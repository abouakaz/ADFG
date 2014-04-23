package adfg.schedulability;

import ilog.concert.IloException;
import ilog.concert.IloLPMatrix;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.KruskalMinimumSpanningTree;
import org.jgrapht.graph.UndirectedSubgraph;
import org.jgrapht.traverse.DepthFirstIterator;


import adfg.Actor;
import adfg.AdfgPackage;
import adfg.AffineRelation;
import adfg.AperiodicActor;
import adfg.Channel;
import adfg.PeriodicActor;
import adfg.impl.AffineRelationImpl;
import adfg.impl.ChannelImpl;
import adfg.impl.GraphImpl;
import adfg.impl.PeriodicActorImpl;

public class Analysis {
	
	private ADFGraph graph;
	private SimpleGraph<_Actor, _AffineRelation> affineGraph=new SimpleGraph<_Actor, _AffineRelation>(_AffineRelation.class);
    private int scheduleType;
    	/* scheduleType:
    	  * uni-processor fixed-priority scheduling
    	  0 : DM priority assignment
	      1 : LOP priority assignment 
	      2 : utilization distance heuristic priority assignment 
	      3 : user-provided priorities
	      4 : constrained LOP priority assignment
	      * multiprocessor scheduling
	      10: Best fit FBB-FFD partitioning, DM priority assignment
	      11: Best fit SRTA partitioning, DM priority assignment
	      12: user-provided priorities and partitioning  
	    */
	private int nbProcessor;

	public Analysis(ADFGraph G){
		graph=G;
		scheduleType=G.getScheduleType();
		nbProcessor=G.getNbProcessors();
	}
	
	private boolean isMultiprocessor(){
		return (scheduleType>=10);
	}
	
	public void perform(){
		if(affineRelationSynthesis())
		symbolicSchedulabilityAnalysis();
	}
	
//==================================================================================================
//                                 Affine Relation Synthesis
//==================================================================================================
	
	private List<Set<_Actor>> weaklyConnectedComponents;
	private Set<List<_AffineRelation>> CycleBasis;
	private List<AperiodicActor> aperiodicActors;
	/* used only in the case of partitioned scheduling */
	private List<Set<_Actor>> partitions;
	private List<List<AperiodicActor>> aperiodicPartitions;
	
	public boolean affineRelationSynthesis(){
		
		/* check if there are already some errors in the affine graph */
		for(_Actor A:graph.getAffineGraph().vertexSet()) affineGraph.addVertex(A);
		
		Collection<_AffineRelation> edges=graph.getAffineGraph().edgeSet(); 
		for(_AffineRelation ar:edges){		
			_Actor A1=graph.getAffineGraph().getEdgeSource(ar), A2=graph.getAffineGraph().getEdgeTarget(ar);
			if(ar.isIncorrect()){
				String str="Not solved reported errors on channels/affine relation (e.g. between actors "+A1.getName()+" and "+A2.getName()+").";
				graph.updateGraphDiagnostic(graph.getApplicationGraph(), str, "Affine relation synthesis");
				return false;
			}
			else{ //clone graphAffineRelations into affineGraph.
				affineGraph.addEdge(A1, A2, ar.clone());
			}
		}
		
		/*STEP3: Decomposition of affineGraph: search of weak components and fundamental cycles. Connectivity is induced by affine relations*/
		decomposition();
		
		if(weaklyConnectedComponents.size()>1){
			String str="The dataflow subgraph (periodic actors + FIFO channels) must be a connected graph.";
			graph.updateGraphDiagnostic(graph.getApplicationGraph(), str,"Affine relation synthesis");
			return false;
		}
		
		/* STEP4: Affine relations consistency: Part 1. Verifying whether parameters n,d are coherent. All the fundamental cycles are obtained in STEP3*/
		if(!consistencyAnalysisPart1()) return false;
		 
		/*
		 * TODO: Phi's computation (if some varibales can be uniquely computed)
		 */
		
		/*STEP5: Priority assignment  and Processor allocation */

		WeaklyConnectedComponent component=new WeaklyConnectedComponent(graph, affineGraph, graph.getDataflowGraph().vertexSet(), false, nbProcessor, scheduleType);
		PriorityAssignmentPolicies priorityAssignment=new PriorityAssignmentPolicies(component);
		
		/* Priority assignment and processor allocation: aperiodic actors*/
		aperiodicActors=graph.getAperiodicActors();
		aperiodicPartitions=priorityAssignment.aperiodicActorsPriorityAndAllocation(aperiodicActors);
		if(aperiodicPartitions==null) return false;
		
		/* Priority assignment: periodic actors*/	
		if(!priorityAssignment.perform()) return false;
		
		/* Processor allocation: periodic actors */
		if(isMultiprocessor()){
			partitions=component.performPartitioning(aperiodicPartitions);
			if(partitions==null) return false;
		}
		
		/*STEP6: Affine relations synthesis (ILP program or enumerative solution); */
		if(CycleBasis.isEmpty()){
			// enumerative solution 
			//System.out.println("\n================================================\nAffine relation Synthesis --Enumerative solution\n================================================");
			for(_AffineRelation r: affineGraph.edgeSet()){
				_Actor src=affineGraph.getEdgeSource(r), dest=affineGraph.getEdgeTarget(r);
				_AffineRelation rtemp=(src.getID()>dest.getID())?r.getReverse():r.clone();
				int best=bestPhi(rtemp,src,dest);
				if(src.getID()<dest.getID()) r.setPhi(best); else r.setPhi(-best);
				//System.out.println("[p_"+src.getID()+"--> p_"+dest.getID()+"] "+r);
				String key=(src.getID()<dest.getID())?src.getID()+":"+dest.getID():src.getID()+":"+dest.getID();
				AffineRelation modelAffineRelation=graph.getAffineRelationGM().getValue(key);
				//modelAffineRelation.setPhi(r.getPhi());
				TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(modelAffineRelation);
				SetRequest setRequest = new SetRequest(domain, modelAffineRelation, AdfgPackage.eINSTANCE.getAffineRelation_Phi(), r.getPhi());
				setRequest.setParameter("oldValue", modelAffineRelation.getPhi());
				SetValueCommand operation = new SetValueCommand(setRequest){     		    
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						((AffineRelationImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.AFFINE_RELATION__PHI,((SetRequest)this.getRequest()).getValue());
						return CommandResult.newOKCommandResult();
					} 
				};
				ICommandProxy comm = new ICommandProxy(operation);
				comm.execute();
				//System.out.println("[p_"+src.getID()+"--> p_"+dest.getID()+"] "+r);
			}
		}
		else
		if(!ILPAffineRelation()) {
			graph.updateGraphDiagnostic(graph.getApplicationGraph(), "Affine relation synthesis fails: the ILP program has no solution.","Affine relation synthesis");
			return false;
		}
		
		/*STEP7:  Refine the size and the number of initial tokens in channels.*/
		bufferSizes(); 
		
		/* Affine relation synthesis succeeded */
		graph.updateGraphDiagnostic(graph.getApplicationGraph(),"","Affine relation synthesis");
		return true;
	}
	
	/**
	 * STEP3
	 * ======
	 */
	private void decomposition(){
		ConnectivityInspector<_Actor,_AffineRelation> inspector=new ConnectivityInspector<_Actor,_AffineRelation>(affineGraph);
		weaklyConnectedComponents=inspector.connectedSets();
		
		CycleBasis=new HashSet<List<_AffineRelation>>();
		
		KruskalMinimumSpanningTree<_Actor,_AffineRelation> tree=new KruskalMinimumSpanningTree<_Actor,_AffineRelation>(affineGraph);
		UndirectedSubgraph<_Actor,_AffineRelation> tempGraph=new UndirectedSubgraph<_Actor,_AffineRelation>(affineGraph,null,tree.getEdgeSet());
		
		Set<_AffineRelation> remainingedges = new HashSet<_AffineRelation>(affineGraph.edgeSet()); remainingedges.removeAll(tree.getEdgeSet());
		for (_AffineRelation edge: remainingedges) {
			_Actor src=affineGraph.getEdgeSource(edge), dest=affineGraph.getEdgeTarget(edge);
			DijkstraShortestPath<_Actor,_AffineRelation> shortestPathFinder= new DijkstraShortestPath<_Actor,_AffineRelation>(tempGraph, src, dest);
		    List<_AffineRelation> path=shortestPathFinder.getPathEdgeList();
		    tempGraph.addEdge(src, dest, edge);
		    if(path!=null){
		    	path.add(edge);
		  		CycleBasis.add(path);
		    }
		}
	} 
	
	/**
	 * STEP4
	 * =====
	 * Affine relations consistency: Part 1. Verifying whether parameters n,d are coherent. All the fundamental cycles are obtained in STEP3
	 */
	private boolean consistencyAnalysisPart1(){
		String str="";
		for(List<_AffineRelation> cycle:CycleBasis){
			UndirectedSubgraph<_Actor,_AffineRelation> tempGraph=new UndirectedSubgraph<_Actor,_AffineRelation>(affineGraph,null,new HashSet<_AffineRelation>(cycle));
			int nbPhi=0;
			long mulN=1, mulD=1;
			
			_Actor start=tempGraph.getEdgeSource(cycle.get(0));
			DepthFirstIterator<_Actor, _AffineRelation> dfs = new DepthFirstIterator<_Actor, _AffineRelation>(tempGraph,start);
			_Actor src=dfs.next(), dest=null;
	        while (nbPhi<cycle.size()) { 
	        	dest=(dfs.hasNext())?dfs.next():start; 
	            _AffineRelation r=affineGraph.getEdge(src, dest); 
	            if(src.getID()>dest.getID())  r=r.getReverse();
	            mulN*=r.getN();
	            mulD*=r.getD();
	            long g=MathFunction.GCD(mulN, mulD); mulN/=g; mulD/=g;
	            nbPhi++;
	            src=dest;
	        }
	        if(mulN!=mulD) {
	        	/* consistency Part1 is not satisfied */
	        	for(_AffineRelation edge:cycle){
					_Actor A1=affineGraph.getEdgeSource(edge), A2=affineGraph.getEdgeTarget(edge); str+="p_"+A1.getID()+" --> p_"+A2.getID()+"; ";
				}
	        	str+="\n";
	        }
		}
		if(!str.equals("")){
			str="Inconsistent cycles :\n"+str;
			graph.updateGraphDiagnostic(graph.getApplicationGraph(), str,"Affine relation synthesis");
			return false;
		}
		else graph.updateGraphDiagnostic(graph.getApplicationGraph(), "","Affine relation synthesis");
		return true;
	}
	
	private boolean ILPAffineRelation(){
		/* variables to contain the generated constraints (LP FORMAT) */
		StringBuilder SubjectTo=new StringBuilder("\nSubject To \n"), Minimize=new StringBuilder("\nMINIMIZE \n obj:");
		StringBuilder Bounds=new StringBuilder("\nBounds \n"), General=new StringBuilder("\nGeneral \n");
		
		/* Consistency constraints */
		for(List<_AffineRelation> cycle: CycleBasis){
			if(!cycleConstraintGeneration(cycle,SubjectTo)) return false;
		}
		
		/* Overflow and underflow constraints */
		Set<_Channel> edges=graph.getDataflowGraph().edgeSet();
		for(_Channel edge:edges){
			_Actor src=graph.getDataflowGraph().getEdgeSource(edge), dest=graph.getDataflowGraph().getEdgeTarget(edge); 
			_AffineRelation r=affineGraph.getEdge(src, dest).clone(); 
			if(r.getPhi()!=_AffineRelation.UNDEFINED) continue; 
			if(src.getID()>dest.getID()) r=r.getReverse();
			channelConstraintGeneration(edge,src,dest,r,Minimize,SubjectTo,Bounds,General);
		}
		
		/* Add phi variables */
		for(_AffineRelation r:affineGraph.edgeSet()){
			_Actor src=affineGraph.getEdgeSource(r), dest=affineGraph.getEdgeTarget(r);
			String varphi=(src.getID()<dest.getID())?"phi_"+src.getID()+"_"+dest.getID() : "phi_"+dest.getID()+"_"+src.getID();
			General.append(varphi+"\n");
			Bounds.append(varphi+" free \n");
			if(r.getPhi()!=_AffineRelation.UNDEFINED){
				SubjectTo.append(varphi+" = "+r.getPhi()+" ;\n");
			}
		}
		
		Minimize.deleteCharAt(Minimize.length()-1).append(" \n"); General.append("\nEnd");
		System.out.println("\n================================\nAffine relation Synthesis -- ILP\n================================");
		//System.out.println(Minimize.toString()+SubjectTo.toString()+Bounds.toString()+General.toString());
		
		/* solve the ILP problem */
		try{System.out.println(Minimize.toString()+SubjectTo.toString()+Bounds.toString()+General.toString());
			FileWriter lpProblem=new FileWriter("ILProblem.lp"); 
			lpProblem.write(Minimize.toString()); lpProblem.write(SubjectTo.toString());
			lpProblem.write(Bounds.toString()); 
			lpProblem.write(General.toString());
			lpProblem.close();
		}
		catch(Exception e){System.err.println("Error: " + e.getMessage());}
		try {
			  // Read the generated linear problem from a file
			  IloCplex cplex = new IloCplex();
			  cplex.importModel("ILProblem.lp"); cplex.setOut(null); cplex.setParam(IloCplex.DoubleParam.TiLim, 180); // 3 minutes
			  // solve the problem
			  if(!cplex.solve()) return false; /* infeasible ILP problem. */
			  System.out.println("Approximate value of the sum of buffer sizes :"+cplex.getObjValue());
			  /* save the solution */
			  IloLPMatrix lp = (IloLPMatrix)cplex.LPMatrixIterator().next();
		      IloNumVar[] vars = lp.getNumVars();
		      double[]    vals = cplex.getValues(vars);
		      HashMap<String,Integer> varsPhi=new HashMap<String,Integer>();
			  for (int i = 0; i < vals.length; i++) {
				  String varName=vars[i].getName(); int varValue=(int)Math.round(vals[i]); //System.out.println(varName+" "+varValue);
				  if(varName.charAt(0)=='p') varsPhi.put(varName,varValue); 
			  }
			  cplex.end();
			  /* save phis in affineGraph */
			  for(_AffineRelation r:affineGraph.edgeSet()){
				  _Actor src=affineGraph.getEdgeSource(r), dest=affineGraph.getEdgeTarget(r);
				  String varphi=(src.getID()<dest.getID())?"phi_"+src.getID()+"_"+dest.getID() : "phi_"+dest.getID()+"_"+src.getID();
				  int phi=varsPhi.get(varphi);
				  r.setPhi(phi);
				  //System.out.println("[p_"+src.getID()+"--> p_"+dest.getID()+"] "+r);
				  String key=(src.getID()<dest.getID())?src.getID()+":"+dest.getID():src.getID()+":"+dest.getID();
				  AffineRelation modelAffineRelation=graph.getAffineRelationGM().getValue(key);
				  if(modelAffineRelation!=null){
					  TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(modelAffineRelation);
					  SetRequest setRequest = new SetRequest(domain, modelAffineRelation, AdfgPackage.eINSTANCE.getAffineRelation_Phi(), r.getPhi());
					  setRequest.setParameter("oldValue", modelAffineRelation.getPhi());
					  SetValueCommand operation = new SetValueCommand(setRequest){     		    
						  @Override
						  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							  ((AffineRelationImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.AFFINE_RELATION__PHI,((SetRequest)this.getRequest()).getValue());
							  return CommandResult.newOKCommandResult();
						  } 
					  };
					  ICommandProxy comm = new ICommandProxy(operation);
					  comm.execute();
				  }
			  }
		 }
		 catch (IloException e) {
		       e.printStackTrace();
		 }
		return true;
	}
	
	private void channelConstraintGeneration(_Channel edge, _Actor src, _Actor dest, _AffineRelation r, StringBuilder objectiveFunction, StringBuilder constraints, StringBuilder bounds, StringBuilder general){
		
		UPIS prate=edge.getProduce(), crate=edge.getConsume();
		/* initial tokens */
		general.append("C_"+edge.getID()+" \n"); 
		if(edge.getInitial()!=_Channel.UNDEFINED) constraints.append(" C_"+edge.getID()+" = "+edge.getInitial()+"\n ");
		bounds.append("C_"+edge.getID()+" >= 0\n");
		
		/* size */
		general.append("h_"+edge.getID()+" \n");
		if(edge.getSize()!=_Channel.UNDEFINED) constraints.append(" h_"+edge.getID()+" = "+edge.getSize()+"\n");
		bounds.append("h_"+edge.getID()+" >= "+prate.constantBounds().getSecond()+ "\n");
		
		constraints.append("C_"+edge.getID()+" - h_"+edge.getID()+" <= 0\n");
		objectiveFunction.append(" "+edge.getDataSize()+" h_"+edge.getID()+" +");
		
		/* affine relation */
		String varphi=(src.getID()<dest.getID())?"phi_"+src.getID()+"_"+dest.getID() : "phi_"+dest.getID()+"_"+src.getID();
		String sign=(src.getID()<dest.getID())?"":"- "; //because in the second case the affine relation is reversed; i.e. (-phi) is used instead of phi.
	
		/* overflow and underflow constraints */
		Pair<Fraction> pLB=prate.linearBounds(), cLB=crate.linearBounds();
		if(src.getNbPartition()!=dest.getNbPartition()){
			//actors allocated to different processors
			Fraction tempf=cLB.getFirst().DIF(pLB.getSecond()).DIF(new Fraction(prate.getSumPeriod(),prate.getPeriodLength()).MUL(new Fraction(r.getD()-1+r.getN(),r.getN())));
			int common=(int)MathFunction.LCM(r.getN()*prate.getPeriodLength(), tempf.getB());
			constraints.append(sign+(common*prate.getSumPeriod())/(prate.getPeriodLength()*r.getN())+" "+varphi+" + "+ common+ " C_"+edge.getID()+" - "+ common+ " h_"+edge.getID()+" <= "+(common*tempf.getA()/tempf.getB())+"\n");
			
			tempf=cLB.getSecond().DIF(pLB.getFirst()).ADD(new Fraction(crate.getSumPeriod(), crate.getPeriodLength()).MUL(new Fraction(r.getD()-1+r.getN(),r.getD())));
			common=(int)MathFunction.LCM(r.getN()*prate.getPeriodLength(), tempf.getB());
			constraints.append(sign+(common*prate.getSumPeriod())/(prate.getPeriodLength()*r.getN())+" "+varphi+" + "+common+" C_"+edge.getID()+" >= "+(common*tempf.getA()/tempf.getB())+"\n");
		}
		else{
			if(src.getPriority()<dest.getPriority()){
				Fraction tempf=cLB.getFirst().DIF(pLB.getSecond()).DIF(new Fraction(prate.getSumPeriod(),prate.getPeriodLength()).MUL(new Fraction(r.getD()-1+r.getN(),r.getN())));
				int common=(int)MathFunction.LCM(r.getN()*prate.getPeriodLength(), tempf.getB());
				constraints.append(sign+(common*prate.getSumPeriod())/(prate.getPeriodLength()*r.getN())+" "+varphi+" + "+ common+ " C_"+edge.getID()+" - "+ common+ " h_"+edge.getID()+" <= "+(common*tempf.getA()/tempf.getB())+"\n");
			
				tempf=cLB.getSecond().DIF(pLB.getFirst()).ADD(new Fraction(prate.getSumPeriod(),prate.getPeriodLength()).MUL(new Fraction(r.getD()-1,r.getN())));
				common=(int)MathFunction.LCM(r.getN()*prate.getPeriodLength(), tempf.getB());
				constraints.append(sign+(common*prate.getSumPeriod())/(prate.getPeriodLength()*r.getN())+" "+varphi+" + "+common+" C_"+edge.getID()+" >= "+(common*tempf.getA()/tempf.getB())+"\n");
			}
			else{
				Fraction tempf=cLB.getFirst().DIF(pLB.getSecond()).DIF(new Fraction(prate.getSumPeriod(),prate.getPeriodLength()).MUL(new Fraction(-1+r.getN(),r.getN())));
				int common=(int)MathFunction.LCM(r.getN()*prate.getPeriodLength(), tempf.getB());
				constraints.append(sign+(common*prate.getSumPeriod())/(prate.getPeriodLength()*r.getN())+" "+varphi+" + "+ common+ " C_"+edge.getID()+" - "+ common+ " h_"+edge.getID()+" <= "+(common*tempf.getA()/tempf.getB())+"\n");
			
				tempf=cLB.getSecond().DIF(pLB.getFirst()).ADD(new Fraction(prate.getSumPeriod(),prate.getPeriodLength()).MUL(new Fraction(r.getD()-1+r.getN(),r.getN())));
				common=(int)MathFunction.LCM(r.getN()*prate.getPeriodLength(), tempf.getB());
				constraints.append(sign+(common*prate.getSumPeriod())/(prate.getPeriodLength()*r.getN())+" "+varphi+" + "+common+" C_"+edge.getID()+" >= "+(common*tempf.getA()/tempf.getB())+"\n");
			}
		}
	}
	
	private boolean cycleConstraintGeneration(List<_AffineRelation> cycle, StringBuilder constraints){
		UndirectedSubgraph<_Actor,_AffineRelation> tempGraph=new UndirectedSubgraph<_Actor,_AffineRelation>(affineGraph,null,new HashSet<_AffineRelation>(cycle));
		String[] varsPhi=new String[cycle.size()]; long[] coefsPhi=new long[cycle.size()]; for(int i=0; i<coefsPhi.length; i++) coefsPhi[i]=1;
		int nbPhi=0;
		long mulN=1, mulD=1;
		
		_Actor start=tempGraph.getEdgeSource(cycle.get(0));
		DepthFirstIterator<_Actor, _AffineRelation> dfs = new DepthFirstIterator<_Actor, _AffineRelation>(tempGraph,start);
		_Actor src=dfs.next(), dest=null;
        while (nbPhi<varsPhi.length) { 
        	dest=(dfs.hasNext())?dfs.next():start; 
            _AffineRelation r=affineGraph.getEdge(src, dest); 
            String varphi=(src.getID()<dest.getID())?"phi_"+src.getID()+"_"+dest.getID() : "phi_"+dest.getID()+"_"+src.getID();
            varsPhi[nbPhi]=varphi;
            if(src.getID()>dest.getID()) { coefsPhi[nbPhi]*=-1; r=r.getReverse();}
            for(int i=0; i<nbPhi; i++) coefsPhi[i]*=r.getN();
            for(int i=nbPhi+1; i<coefsPhi.length; i++) coefsPhi[i]*=r.getD();
            mulN*=r.getN();
            mulD*=r.getD();
            long g=MathFunction.GCD(mulN, mulD); mulN/=g; mulD/=g;
            g=coefsPhi[0]; for(int i=0; i<coefsPhi.length; i++) g=MathFunction.GCD(g, coefsPhi[i]);
            for(int i=0; i<coefsPhi.length; i++) coefsPhi[i]=coefsPhi[i]/g;
            nbPhi++;
            src=dest;
        }
        if(mulN!=mulD) return false; /* consistency Part1 is not satisfied */
        String constraint=coefsPhi[0]+" "+varsPhi[0]+" ";
        for(int i=1; i<varsPhi.length; i++){ 
			 if (coefsPhi[i]>0) constraint+="+ "+coefsPhi[i]+" "+varsPhi[i]+" ";
			 else constraint+=coefsPhi[i]+" "+varsPhi[i]+" ";
        }
        constraint+=" = 0 \n"; 
        constraints.append(constraint);
        
		return true;
	}
	
	private void bufferSizes(){
		//System.out.println("\n============\nBuffer sizes\n============");
		int sumBufferSize=0;
		for(_Channel edge: graph.getDataflowGraph().edgeSet()){
			_Actor src=graph.getDataflowGraph().getEdgeSource(edge), dest=graph.getDataflowGraph().getEdgeTarget(edge);
			_AffineRelation r=affineGraph.getEdge(src, dest); if(src.getID()>dest.getID()) r=r.getReverse();
			ADFGraph.bufferSize(edge,src,dest,r);
			
			Channel modelChannel=graph.getChannelGM().getValue(edge);
			//modelChannel.setInitial(edge.getInitial()); 
			TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(modelChannel);
	    	SetRequest setRequest = new SetRequest(domain, modelChannel, AdfgPackage.eINSTANCE.getChannel_Initial(), edge.getInitial());
	    	setRequest.setParameter("oldValue", modelChannel.getInitial());
	    	SetValueCommand operation = new SetValueCommand(setRequest){     		    
	 		   @Override
	 		   protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	 			  ((ChannelImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.CHANNEL__INITIAL,((SetRequest)this.getRequest()).getValue());
	 			  return CommandResult.newOKCommandResult();
	 		   } 
	        };
	    	ICommandProxy comm = new ICommandProxy(operation);
	    	comm.execute();
	    	
			//modelChannel.setSize(edge.getSize());
            setRequest = new SetRequest(domain, modelChannel, AdfgPackage.eINSTANCE.getConnection_Size(), edge.getSize());
	    	setRequest.setParameter("oldValue", modelChannel.getSize());
	    	operation = new SetValueCommand(setRequest){     		    
	 		   @Override
	 		   protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	 			   ((ChannelImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.CHANNEL__SIZE,((SetRequest)this.getRequest()).getValue());
	 			  return CommandResult.newOKCommandResult();
	 		   } 
	        };
	    	comm = new ICommandProxy(operation);
	    	comm.execute();
	    	
			sumBufferSize+=edge.getSize()*edge.getDataSize();
		}
		/* update the graphical model: buffering requirements */
		
		TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(graph.getApplicationGraph());
	    SetRequest setRequest = new SetRequest(domain, graph.getApplicationGraph(), AdfgPackage.eINSTANCE.getGraph_BufferingRequirements(), sumBufferSize);
	    setRequest.setParameter("oldValue", graph.getApplicationGraph().getBufferingRequirements());
	    SetValueCommand operation = new SetValueCommand(setRequest){     		    
	    	@Override
	    	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	    		((GraphImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS,((SetRequest)this.getRequest()).getValue());
	    		return CommandResult.newOKCommandResult();
	    	} 
	    };
	    ICommandProxy comm = new ICommandProxy(operation);
	    comm.execute();
		
	}
	
	private int bestPhi(_AffineRelation r, _Actor src, _Actor dest){
		int best=0, size=Integer.MAX_VALUE;
		Set<_Channel> edges=graph.getDataflowGraph().getAllEdges(src, dest);
		int max=0, min=0;
		for(_Channel edge: edges){
			max=Math.max(max, edge.getProduce().getLength()); min=Math.max(min, edge.getConsume().getLength());
		}
		edges.addAll(graph.getDataflowGraph().getAllEdges(dest, src));
		for(_Channel edge: graph.getDataflowGraph().getAllEdges(dest, src)){
			max=Math.max(max, edge.getConsume().getLength()); min=Math.max(min, edge.getProduce().getLength());
		}
		
		for(int i=-min*r.getD(); i< max*r.getN(); i++){
			int sum=0;
			_AffineRelation rtemp=r.clone(); rtemp.setPhi(i);
			for(_Channel edge:edges){
				if(graph.getDataflowGraph().getEdgeSource(edge)==src)
				       ADFGraph.bufferSize(edge, src, dest, rtemp);
				else ADFGraph.bufferSize(edge,src,dest,rtemp.getReverse());
				sum+=edge.getSize()*edge.getDataSize(); 
			}	
		    if(sum<size) {size=sum; best=i; }
		}
		return best;
	}
	
//==================================================================================================
//								 Symbolic schedulability analysis
//==================================================================================================
	
	public boolean symbolicSchedulabilityAnalysis(){ 
		double U=-1;
		
		WeaklyConnectedComponent component=new WeaklyConnectedComponent(graph,affineGraph,graph.getDataflowGraph().vertexSet(), true, nbProcessor,scheduleType);
		if(!isMultiprocessor()){ partitions=new ArrayList<Set<_Actor>>(); partitions.add(new HashSet<_Actor>(affineGraph.vertexSet()));}
		
		/* perfrom standard RTA */
		long T=component.standardSchedulability(partitions, aperiodicPartitions);
		if(T<0) return false;
		else if(T==0){
			/* perfrom symbolic RTA */
			if(!isMultiprocessor()) T=component.SRTA(graph.getDataflowGraph().vertexSet(),aperiodicActors);
			else T=component.PSRTA(partitions,aperiodicPartitions);
			if(T<0){
				graph.updateGraphDiagnostic(graph.getApplicationGraph(), "Symbolic schedulability analysis failed.", "Symbolic schedulability analysis");
				return false;
			}
		}
		
		if(T>0){
			if(!component.solve(0)){
				graph.updateGraphDiagnostic(graph.getApplicationGraph(), "Computation of phases failed.", "Symbolic schedulability analysis");
				return false;
			}
		}
		
		U=component.getProcessorUtilizationFactor(aperiodicActors); 
		
		/* update the graphical model : processor utilization*/
	    TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(graph.getApplicationGraph());
	    SetRequest setRequest = new SetRequest(domain, graph.getApplicationGraph(), AdfgPackage.eINSTANCE.getGraph_ProcessorUtilization(), U);
	    setRequest.setParameter("oldValue", graph.getApplicationGraph().getProcessorUtilization());
	    SetValueCommand operation = new SetValueCommand(setRequest){     		    
	    	@Override
	    	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	    		((GraphImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.GRAPH__PROCESSOR_UTILIZATION,((SetRequest)this.getRequest()).getValue());
	    		return CommandResult.newOKCommandResult();
	    	} 
	    };
	    ICommandProxy comm = new ICommandProxy(operation);
	    comm.execute();
	    
		return true;
	}

}
