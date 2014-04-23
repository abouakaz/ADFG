package adfg.schedulability;


import ilog.concert.IloException;
import ilog.concert.IloLPMatrix;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import adfg.AdfgPackage;
import adfg.AperiodicActor;
import adfg.PeriodicActor;
import adfg.impl.PeriodicActorImpl;

public class WeaklyConnectedComponent {
	
	private ADFGraph adfgraph;
	
	private SimpleGraph<_Actor, _AffineRelation> graph;
	
	private Set<_Actor> actors;
	
	private int scheduleType;

	private _Actor basis; /* a fixed actor: periods of other actors are expressed in term of the period of the basis */
	
	private HashMap<_Actor, Fraction> coefficients=new HashMap<_Actor, Fraction>();
	
	private long periodUpperBound=Integer.MAX_VALUE, periodLowerBound=0;
	
	private int divFactor=1; /* the basis period must be a multiple of divFactor */
	
	private double psi;
	
	private int nbProcessor=1;
	
	StringBuilder constraints=new StringBuilder(), general=new StringBuilder();
	
	
	public WeaklyConnectedComponent(ADFGraph G, SimpleGraph<_Actor, _AffineRelation> g, Set<_Actor> actorSet, boolean ILP, int nb, int sch){
		adfgraph=G;
		graph=g;
		actors=actorSet;
		nbProcessor=nb;
		scheduleType=sch;
		/* construction */
		Iterator<_Actor> it=actors.iterator();
		/* the first element is the basis */
		basis = it.next(); coefficients.put(basis, new Fraction(1,1)); 
		if(basis.getPeriodLowerBound()!=_Actor.UNDEFINED) periodLowerBound=basis.getPeriodLowerBound();
		if(basis.getPeriodUpperBound()!=_Actor.UNDEFINED) periodUpperBound=basis.getPeriodUpperBound();
		psi=basis.getWcet();
		if(ILP){
			general.append("p_"+basis.getID()+"\n"+" r_"+basis.getID()+"\n");
			if(basis.getPeriod()!=_Actor.UNDEFINED) general.append("p_"+basis.getID()+" = "+basis.getPeriod()+" ;\n");
			if(basis.getPhase()!=_Actor.UNDEFINED) general.append("r_"+basis.getID()+" = "+basis.getPhase()+" ;\n");
		}
		
		Set<_AffineRelation> edgesDone=new HashSet<_AffineRelation>();
		DepthFirstIterator<_Actor, _AffineRelation> dfs = new DepthFirstIterator<_Actor, _AffineRelation>(graph,basis); dfs.next();
		while(dfs.hasNext()){
			_Actor actor=dfs.next(), neighbor=null;
			_AffineRelation edge=null;
			/* compute coefficient of actor*/
			for(_Actor A:coefficients.keySet()) if((edge=graph.getEdge(A, actor))!=null) {neighbor=A; break;}
			edgesDone.add(edge);
			if(actor.getID()>neighbor.getID()) edge=edge.getReverse();
			
			Fraction coef=new Fraction(edge.getN(), edge.getD()), coef2=coefficients.get(neighbor); 
			coef=coef.MUL(coef2);
			coefficients.put(actor, coef);
			/* divFactor and psi*/
			divFactor=(int)MathFunction.LCM(divFactor, coef.getB());
			psi+=(double) actor.getWcet()/coef.getValue();
			/* check bounds */
			if(actor.getPeriodUpperBound()!=_Actor.UNDEFINED){
				long pub=(long)Math.floor(actor.getPeriodUpperBound()/coef.getValue());
				if(pub<periodUpperBound) periodUpperBound=pub;
			}
			long plb=(long)Math.ceil(actor.getPeriodLowerBound()/coef.getValue());
			if(plb>periodLowerBound) periodLowerBound=plb;
			/* consider deadline */ 
			Fraction temp=actor.getSymbolicDeadline().MUL(coef);
			divFactor=(int)MathFunction.LCM(divFactor, temp.getB());
			plb=(long)Math.ceil(actor.getWcet()/temp.getValue()); 
			if(plb>periodLowerBound) periodLowerBound=plb;
			
			if(periodLowerBound>periodUpperBound) throw new Error("bounds on periods are non-consistent");
			/* ILP generation */
			if(ILP){ 
				general.append("p_"+actor.getID()+"\n"+"r_"+actor.getID()+"\n");
				if(basis.getPeriod()!=_Actor.UNDEFINED) general.append("p_"+basis.getID()+" = "+basis.getPeriod()+" ;\n");
				if(basis.getPhase()!=_Actor.UNDEFINED) general.append("r_"+basis.getID()+" = "+basis.getPhase()+" ;\n");
				constraints.append(coef.getB()+" p_"+actor.getID()+" - "+coef.getA()+" p_"+basis.getID()+" = 0\n");
			}
			String x="r_"+actor.getID(), y="r_"+neighbor.getID();
			if(edge.getPhi()>=0){
				Fraction frac=new Fraction(edge.getPhi(), edge.getN()).MUL(coef);
				if(ILP) constraints.append(frac.getB()+" "+y+" - "+frac.getB()+" "+x+" - "+frac.getA()+" p_"+basis.getID()+" =0\n");
				divFactor=(int)MathFunction.LCM(divFactor,frac.getB());
			}
			else{
				Fraction frac=new Fraction(-edge.getPhi(), edge.getD()).MUL(coef2);
				if(ILP) constraints.append(frac.getB()+" "+x+" - "+frac.getB()+" "+y+" - "+frac.getA()+" p_"+basis.getID()+" =0\n");
				divFactor=(int)MathFunction.LCM(divFactor,frac.getB());
			}
		}
		
		for(_AffineRelation r:graph.edgeSet()){
			if(!edgesDone.contains(r)){
				_Actor src=graph.getEdgeSource(r), dest=graph.getEdgeTarget(r);
				if(src.getID()> dest.getID()) r=r.getReverse();
				Fraction f=new Fraction(r.getPhi(), r.getN()).MUL(coefficients.get(src));
				divFactor=(int)MathFunction.LCM(divFactor, Math.abs(f.getB()));
				if(ILP){
					String x="r_"+src.getID(), y="r_"+dest.getID();
					if(r.getPhi()>=0){
						Fraction frac=new Fraction(r.getPhi(), r.getN()).MUL(coefficients.get(src));
						constraints.append(frac.getB()+" "+y+" - "+frac.getB()+" "+x+" - "+frac.getA()+" p_"+basis.getID()+" =0\n");
					}
					else{
						Fraction frac=new Fraction(-r.getPhi(), r.getD()).MUL(coefficients.get(dest));
						constraints.append(frac.getB()+" "+x+" - "+frac.getB()+" "+y+" - "+frac.getA()+" p_"+basis.getID()+" =0\n");
					}
				}
			}
		}
        /* U <= m */
		long plb=(long)Math.ceil(psi/nbProcessor); 
		if(plb>periodLowerBound) periodLowerBound=plb;
		if(periodLowerBound>periodUpperBound) throw new Error("bounds on periods are non-consistent");
	}
	
	
	/** 
	 * @param periodMin if  periodMin==0: maximize the the throughput; else compute the other parameters
	 */
	public boolean solve(long periodMin){
		try{
			FileWriter lpProblem=new FileWriter("lpProblem.lp");
			if(periodMin==0){
				lpProblem.write("\nMINIMIZE \n obj: p_"+basis.getID()+"\n");
				constraints.append("p_"+basis.getID()+" = "+basis.getPeriod()+" \n"); /* solved by the SQPA algorithm */
				//System.out.println(constraints.toString());
			}
			else if(periodMin==-1){
				lpProblem.write("\nMAXIMIZE \n obj: p_"+basis.getID()+"\n");
			}
			else{ 
				lpProblem.write("\nMINIMIZE \n obj:  p_"+basis.getID()+"\n");
				constraints.append("p_"+basis.getID()+" >= "+periodMin+" \n");
			}
			
			lpProblem.write("Subject To\n"+constraints.toString());
			lpProblem.write("Bounds \n"+"p_"+basis.getID()+" >= "+periodLowerBound+"\n"+"p_"+basis.getID()+" <= "+periodUpperBound+"\n");
			
			lpProblem.write("General \n"+general.toString()+"\nEnd");
			lpProblem.close();
		}
		catch(Exception e){System.err.println("Error: " + e.getMessage());}
		try {
			/* Read the generated linear problem from a file */
			IloCplex cplex = new IloCplex();
			cplex.importModel("lpProblem.lp"); cplex.setOut(null); System.out.println("psi ="+psi+"\n"+" divFactor "+divFactor+"\n");
			/* solve the problem */
			if(!cplex.solve()) return false; //infeasible ILP problem.
				  		      
			/* save the solution to the network */
			HashMap<String,Long> periods=new HashMap<String,Long>(), phases=new HashMap<String,Long>();
			IloLPMatrix lp = (IloLPMatrix)cplex.LPMatrixIterator().next();
			IloNumVar[] vars = lp.getNumVars();
			double[]    vals = cplex.getValues(vars); 
			for (int i = 0; i < vals.length; i++) {
				String var=vars[i].getName();
				long value=(long)Math.round(vals[i]);
				if(var.charAt(0)=='p') periods.put(var, value);
				else if(var.charAt(0)=='r') phases.put(var, value);
				//System.out.println(var+" "+value);
			}
			cplex.end();
			for(_Actor A:actors){
				  A.setPeriod(periods.get("p_"+A.getID()));
				  /* update the graphical model*/
				  adfgraph.setPropertyUpdating(true);
				  PeriodicActor modelActor=adfgraph.getActorGM().getValue(A);
				  TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(modelActor);
				  SetRequest setRequest = new SetRequest(domain, modelActor, AdfgPackage.eINSTANCE.getPeriodicActor_Period(), A.getPeriod());
				  setRequest.setParameter("oldValue", modelActor.getPeriod());
				  SetValueCommand operation = new SetValueCommand(setRequest){     		    
			 		   @Override
			 		   protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			 			  ((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.PERIODIC_ACTOR__PERIOD,((SetRequest)this.getRequest()).getValue());
			 			  return CommandResult.newOKCommandResult();
			 		   } 
				  };
				  ICommandProxy comm = new ICommandProxy(operation);
				  comm.execute();
				  
				  A.setPhase(phases.get("r_"+A.getID()));
				  //TODO display
				  SetRequest setRequest2 = new SetRequest(domain, modelActor, AdfgPackage.eINSTANCE.getPeriodicActor_Phase(), A.getPhase());
				  setRequest2.setParameter("oldValue", modelActor.getPhase());
				  SetValueCommand operation2 = new SetValueCommand(setRequest2){     		    
				  @Override
				  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					  ((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.PERIODIC_ACTOR__PHASE,((SetRequest)this.getRequest()).getValue());
					  return CommandResult.newOKCommandResult();
				  } 
				  };
				  ICommandProxy comm2 = new ICommandProxy(operation2);
				  comm2.execute();
				  adfgraph.setPropertyUpdating(false);
			}
		}
		catch (IloException e) {
			e.printStackTrace();
		}
		return true;
	}


	public _Actor getBasis() { return basis; }

	public HashMap<_Actor, Fraction> getCoefficients() { return coefficients; }
	
	public Set<_Actor> getActors(){ return actors; }
	
	public SimpleGraph<_Actor, _AffineRelation> getAffineGraph(){ return graph; }
	
	public ADFGraph getADFGraph(){ return adfgraph; }
	
	public int getDivFactor(){ return divFactor; }
	
	public double getPsi(){ return psi; }
	
	public long getPeriodUpperBound(){ return periodUpperBound; }
	
	public long getPeriodLowerBound(){ return periodLowerBound; }
	
	public void setNBProcessor(int nb){ nbProcessor=nb; }
	
	public int getNbProcessor(){return nbProcessor; }
	
	public int getScheduleType(){ return scheduleType; }
	
	public String ILPString(){
		String str="===============================================\n";
		str+="\nMINIMIZE \n obj: p_"+basis.getID()+"\n";
		str+="Subject To\n"+constraints.toString();
		str+="Bounds \n"+"p_"+basis.getID()+" >= "+periodLowerBound+"\n"+"p_"+basis.getID()+" <= "+periodUpperBound+"\n";
		str+="General \n"+general.toString()+"\nEnd";
		str+="\n===============================================\n"; 
		return str;
	}
	
	public String toString(){
		 String str="===============================================\n";
		 str+=periodLowerBound+" <= (p_"+basis.getID()+"=k*"+divFactor+") <= "+periodUpperBound+"\n U= "+psi+"/p_"+basis.getID()+" \n"; 
		 for(_Actor A:coefficients.keySet()){ str+=" p_"+A.getID()+" = "+coefficients.get(A)+" p_"+basis.getID()+" "; }
		 str+="\n===============================================\n"; 
		 return str;
	}
	
//=====================================================================================================================================
//										     Partitioning
//=====================================================================================================================================
	
	public List<Set<_Actor>> performPartitioning(List<List<AperiodicActor>> aperiodicPartitions){
		List<Set<_Actor>> partitions=null;
		switch(scheduleType){
		case 10: partitions=partitioning_bestFit_FP(nbProcessor, true, aperiodicPartitions);   break;
		case 11: partitions=partitioning_bestFit_FP(nbProcessor, false, aperiodicPartitions);  break;
		case 12: partitions=partitioning_user(); break;
		}
		if(scheduleType!=12 && partitions!=null){
			//update the grpahical model
			for(_Actor A:actors){
				adfgraph.setPropertyUpdating(true);
				PeriodicActor modelActor=adfgraph.getActorGM().getValue(A);
	
				TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(modelActor);
				SetRequest setRequest = new SetRequest(domain, modelActor, AdfgPackage.eINSTANCE.getActor_Priority(), A.getPriority());
				setRequest.setParameter("oldValue", modelActor.getPriority());
				SetValueCommand operation = new SetValueCommand(setRequest){     		    
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PRIORITY,((SetRequest)this.getRequest()).getValue());
						return CommandResult.newOKCommandResult();
					} 
				};
				ICommandProxy comm = new ICommandProxy(operation);
				comm.execute();		
				
				domain=TransactionUtil.getEditingDomain(modelActor);
				setRequest = new SetRequest(domain, modelActor, AdfgPackage.eINSTANCE.getActor_ProcNumber(), A.getNbPartition());
				setRequest.setParameter("oldValue", modelActor.getProcNumber());
				operation = new SetValueCommand(setRequest){     		    
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PROC_NUMBER,((SetRequest)this.getRequest()).getValue());
						return CommandResult.newOKCommandResult();
					} 
				};
				comm = new ICommandProxy(operation);
				comm.execute();
				
				adfgraph.setPropertyUpdating(false);
			}
		}
		return null; //partitions;
	}
	
	private List<Set<_Actor>> partitioning_user(){
		 ArrayList<Set<_Actor>> partitions=new ArrayList<Set<_Actor>>();
		 for(int i=0; i<nbProcessor; i++) partitions.add(new HashSet<_Actor>());
		 for(_Actor A: actors){
			int nb=A.getNbPartition();
			partitions.get(nb-1).add(A);
		 }
		 return partitions;
	}
	
	protected List<Set<_Actor>> partitioning_bestFit_FP(int nbParts, boolean SRTA, List<List<AperiodicActor>> aperiodicPartitions){
		priorityOrdering();
		ArrayList<Set<_Actor>> partitions=new ArrayList<Set<_Actor>>();
		for(int i=0; i<nbParts; i++) partitions.add(new HashSet<_Actor>());
		for(_Actor actor: priorityOrderedActors){
			long bestT=Integer.MAX_VALUE;
			int bestPartition=-1;
			Fraction coef=coefficients.get(actor);
			double deadline=actor.getSymbolicDeadline().MUL(coef).getValue();
			int i=0;
			for(Set<_Actor> partition:partitions){
				long tempT=Integer.MAX_VALUE;
				if(SRTA){
					HashSet<_Actor> tempSet=new HashSet<_Actor>(partition); tempSet.add(actor);
					tempT=this.SRTA(tempSet, aperiodicPartitions.get(i)); //System.out.println("tempT "+i+" "+tempT);
				}
				else{
					/* FBB_FFD */
					double sum=actor.getWcet(); for(_Actor A:partition) sum+=A.getWcet()*(1+(deadline/coefficients.get(A).getValue()));
					//a T >= b
					double a=sum; for(AperiodicActor apA:aperiodicPartitions.get(i)) sum+=apA.getCapacity();
					double b=deadline*(1-getUS1(aperiodicPartitions.get(i)));
					tempT=(long)Math.ceil(sum/deadline); //System.out.println("tempT "+i+" "+tempT);
				}
				if(tempT<bestT) { bestPartition=i; bestT=tempT; }
				else if(tempT==bestT){
					/* min load */
					if(getLoad(partitions.get(bestPartition))>getLoad(partitions.get(i))) { bestPartition=i; bestT=tempT; }
				}
				i++;
			}
			partitions.get(bestPartition).add(actor); actor.setNbPartition(bestPartition); //System.out.println("part "+bestPartition+" p_"+actor.getID()); 
		}
		/* update priorities in each partition */
		int[] nbActors=new int[nbParts]; for(int i=0;i<nbParts;i++) nbActors[i]=aperiodicPartitions.get(i).size();
		for(_Actor A:priorityOrderedActors){
			A.setPriority(++nbActors[A.getNbPartition()]); A.setNbPartition(A.getNbPartition()+1);
		}
		
		/* count edges between parts */
		/*UndirectedSubgraph<_Actor,_AffineRelation> subgraph= new UndirectedSubgraph<_Actor,_AffineRelation>(graph, actors, null);
	    int nbEdgeCrossing=0;
	    for(_AffineRelation r:subgraph.edgeSet()){
	    	_Actor src=subgraph.getEdgeSource(r); int partSrc=0;
	    	_Actor dest=subgraph.getEdgeTarget(r); int partDest=0;
	    	Iterator<Set<_Actor>> partit=partitions.iterator(); 
	    	while(partit.hasNext()){
	    		if(partit.next().contains(src)) break; 
	    		partSrc++;
	    	}
	    	partit=partitions.iterator(); 
	    	while(partit.hasNext()){
	    		if(partit.next().contains(dest)) break;
	    		partDest++;
	    	}
	    	if(partSrc!=partDest){
	    		nbEdgeCrossing++;
	    	}
	    }
	    System.out.println("\n============\nPartitioning\n============");
	    System.out.println("number of edges crossing partitions "+nbEdgeCrossing);
	    int i=1;
	    for(Set<_Actor> partition:partitions){
	    	String str="";
	    	double load=0;
	    	for(_Actor A:partition){ load+=A.getWcet()/coefficients.get(A).getValue(); str+="p_"+A.getID()+" ";}
	    	System.out.println("partition "+i+": Load= "+load+"; Actors= "+str);
	    	i++;
	    }
	    System.out.println();*/
		return partitions;
	}
		
	private double getLoad(Set<_Actor> vertexSet){
		double psi2=0; for(_Actor A:vertexSet) { psi2+=A.getWcet()/coefficients.get(A).getValue(); }
		return psi2;
	}
	
	
//===============================================================================================================================================
//														Symbolic static-priority scheduling 
//===============================================================================================================================================

	private ArrayList<_Actor> priorityOrderedActors;
	Map<_Actor,Long> InfSchedulable=new HashMap<_Actor,Long>();
	
	private void priorityOrdering(){
		priorityOrderedActors=new ArrayList<_Actor>();
		for(_Actor actor:actors){
			boolean inserted=false; int i=0;
			while(i<priorityOrderedActors.size() && !inserted){
				if(actor.getPriority()< priorityOrderedActors.get(i).getPriority()){
					inserted=true; priorityOrderedActors.add(i, actor);
				}
				i++;
			}
			if(!inserted) priorityOrderedActors.add(i, actor);
		}
	}
	
	/**
	 * @param T is the period of the basis actor.
	 */
	public void setAllPeriods(long T, Set<_Actor> vertexSet){
		for(_Actor A:vertexSet){
			Fraction coef=coefficients.get(A);
			A.setPeriod(T*coef.getA()/coef.getB()); /* the setPeriod() method will also set the deadline */
			//System.out.println("p_"+A.getID()+" "+A.getPeriod()+" d_"+A.getID()+" "+A.getDeadline());
		}
	}
	
	private Pair<Long> reduceSearchSpace(Set<_Actor> vertexSet, double US1, double US2){
		InfSchedulable.clear();
		long inf=-1, sup=-1;
		for(int i=0; i< priorityOrderedActors.size(); i++){
			_Actor actor=priorityOrderedActors.get(i);
			if(!vertexSet.contains(actor)) continue;
			Pair<Long> pair=reduceSearchSpace_Actor(i,vertexSet, US1, US2);
			InfSchedulable.put(actor, (pair.getSecond()==-2)?0:pair.getSecond());
			//System.out.println("now "+actor.getName()+" inf= "+pair.getFirst()+" sup= "+pair.getSecond());
			if(inf<pair.getFirst())  inf=pair.getFirst();
			if(sup<pair.getSecond()) sup=pair.getSecond();
		}
		if(sup==-1) sup=0;
		if(inf==-1) inf=0;
		Pair<Long> res=new Pair<Long>(inf,sup);
		//System.out.println("Inf= "+res.getFirst()+" Sup= "+res.getSecond());
		return res;
	}
	
	/**
	 * @param i priority of the actor
	 */
	private Pair<Long> reduceSearchSpace_Actor(int i,Set<_Actor> vertexSet, double US1, double US2){
		_Actor actor=priorityOrderedActors.get(i);
		double deadline=actor.getSymbolicDeadline().MUL(coefficients.get(actor)).getValue();  
		double a1=deadline, a2=deadline;
		double c1=0, b1=-actor.getWcet(), c2=0, b2=-actor.getWcet(); 
		for(int j=0; j<i; j++){
			_Actor A=priorityOrderedActors.get(j);
			if(!vertexSet.contains(A)) continue;
			long wcet= A.getWcet();
			double coef=coefficients.get(A).getValue();
			c1-=(double)wcet*wcet/coef;
			b1+=wcet*(1-(deadline/coef));
			c2+=(double)wcet*wcet/coef;
			b2-=(double)wcet*(1+(deadline/coef));
		}
		/* Lower Bound: solve second degree equation a1 T^2 +b1 T + c1 < 0 */
		b1+=US2;
		a1*=(1-US1);
		double delta1=b1*b1-(4*a1*c1);
		double tl=(-b1+Math.sqrt(delta1))/(2*a1); 
		long Inf=(long)Math.floor(tl);
		
		/* Upper bound: solve second degree equation a2 T^2 + b2 T + c2 >= 0*/
		a2*=(1-US1);
		b2-=US2;
		double delta2=b2*b2-(4*a2*c2); 
		long Sup=0;
		if(delta2 <= 0) Sup=-2;
		else{
			double tu=(-b2+Math.sqrt(delta2))/(2*a2);
			Sup=(long)Math.ceil(tu);
		}
		return new Pair<Long>(Inf,Sup);
	}
	
	protected long SRTA(Set<_Actor> vertexSet, List<AperiodicActor> apactors){ 
		double US1=getUS1(apactors), US2=getUS2(apactors);
		if(US1>1 || (US1==1 && !vertexSet.isEmpty())) return -1;
		
		if(vertexSet.isEmpty()){
			return 0;
		}
		priorityOrdering();
		Pair<Long> p=reduceSearchSpace(vertexSet, US1, US2);
		long lower=p.getFirst(), upper=p.getSecond(); 
		double psi2=getLoad(vertexSet); 
		long Inf=Math.max(periodLowerBound, (long)Math.ceil(psi2/(1-US1))), Sup=periodUpperBound;  
		Inf=Math.max(Inf, lower); 
		long oneSolution=(long) Math.ceil((double)upper/divFactor)*divFactor; 
		if(oneSolution>Sup) return -1;
		if(Inf>upper) { 
			setAllPeriods((long) Math.ceil((double)Inf/divFactor)*divFactor,vertexSet);
			return (long) Math.ceil((double)Inf/divFactor)*divFactor; 
		}
		/* dichotomic search */
		long res=-1; 
		int start=(int) Math.ceil((double)Inf/divFactor), end= (int)Math.floor((double)upper/divFactor);  
		if(start<=end) 
			do{
				int middle=(start+end)/2;
				long T=middle*divFactor;
				if(RTA(T,vertexSet,apactors)){
					res=T; //System.out.println("hit "+T+"   "+middle);
					end=middle-1;
				}
				else{ start=middle+1; /*System.out.println("miss "+T+"  "+middle);*/ }
			}
			while(start<=end);
		res=(res==-1)?oneSolution:res;
		if(res==oneSolution) setAllPeriods(oneSolution,vertexSet); 
		return res;
	}
	
	private boolean RTA(long T,Set<_Actor> vertexSet, List<AperiodicActor> apactors){
		setAllPeriods(T, vertexSet);
		for(int j=0;j<priorityOrderedActors.size(); j++){
			_Actor actor=priorityOrderedActors.get(j); 
			if(!vertexSet.contains(actor)) continue;
			long infSched=InfSchedulable.get(actor);
			if(T>=infSched) continue;
			long R=responseTime(j,vertexSet,apactors); 
			if(R>actor.getDeadline()) return false;
			else InfSchedulable.put(actor, T);
		}
		return true;
	}
	
	private long responseTime(int i,Set<_Actor> vertexSet, List<AperiodicActor> apactors){
		_Actor actor=priorityOrderedActors.get(i);
		long res=actor.getWcet(); long prev_res=0;
		do{
			prev_res=res;
			res=actor.getWcet();
			for(int j=0; j<i; j++){
				_Actor A=priorityOrderedActors.get(j);
				if(!vertexSet.contains(A)) continue;
				res+=(long)Math.ceil((double)prev_res/A.getPeriod())*A.getWcet();
			}
			for(AperiodicActor apactor:apactors) res+=(long)Math.ceil((double)prev_res/apactor.getReplenishmentPeriod())*apactor.getCapacity();			
		}while(res!=prev_res);
		return res;
	}
	
	protected long PSRTA(List<Set<_Actor>> partitions, List<List<AperiodicActor>> aperiodicPartitions){
		long maxT=0; int i=0;
		for(Set<_Actor> vertexSet: partitions){
			long T=SRTA(vertexSet, aperiodicPartitions.get(i));
			if(T==-1) return T;
			if(T>maxT) maxT=T;
			i++;
		}
		setAllPeriods(maxT,graph.vertexSet());
		return maxT;
	}
	
	public static double getUS1(List<AperiodicActor> apactors){
		double res=0;
		for(AperiodicActor actor:apactors) res+=(double)actor.getCapacity()/actor.getReplenishmentPeriod();
		return res;
	}
	
	private double getUS2(List<AperiodicActor> apactors){
		double res=0;
		for(AperiodicActor actor:apactors) res+=actor.getCapacity()*(1-(double)actor.getCapacity()/actor.getReplenishmentPeriod());
		return res;
	}
	
//===============================================================================================================================================================
//													standard schedulability analysis
//===============================================================================================================================================================
	/**
	 * In case the user provides some periods, a standard RTA will be used to check the schedulability of the task set
	 * @return T=0: if no period is provided,
	 * 		   Y=-1: system unschedulable w.r.t. provided periods, 
	 *         T=-2: provided period not a multiple of divFactor,
	 *         T=-3: provided periods are not compatible 
	 *         T=-4: provided periods are not compatible with provided bounds,
	 *         T=-5: Utilization of aperiodic actors exceeds 1,
	 *         T>0: otherwise
	 */
	
	public long standardSchedulability(List<Set<_Actor>> partitions, List<List<AperiodicActor>> aperiodicPartitions){
		long T=0;
		T=getT(partitions); 
		if(T<=0) return T;
		/* check schedulability */
		priorityOrdering();
		int i=0;
		for(Set<_Actor> partition:partitions){
			List<AperiodicActor> apartition=aperiodicPartitions.get(i);
			double US=getUS1(apartition), UP=this.getLoad(partition)/T;
			if(US+UP>1){
				adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(), "Utilization exceeds 1: processor"+(i+1)+".", "Standard schedulability analysis");
				return -5;
			}
			if(!this.standardRTA(T, partition, apartition)){
				adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(), "Unschedulable system w.r.t. provided periods: processor"+(i+1)+".", "Standard schedulability analysis");
				return -1;
			}	
			i++;
		}
		return T;
	}
	
	private long getT(List<Set<_Actor>> partitions){
		long T=0; _Actor first=null;
		for(Set<_Actor> partition:partitions){
			for(_Actor A:partition){
				long period=A.getPeriod();
				if(period!=_Actor.UNDEFINED){
					if(period%divFactor!=0){
						adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(), "Period of actor "+A.getName()+" must be a multiple of"+divFactor+".", "Standard schedulability analysis");
						return -2; 
					}
					Fraction coef=coefficients.get(A);
					long temp=period*coef.getB()/coef.getA();
					if(T==0) {T=temp; first=A;}
					else if(T!=temp){
						adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(), "Periods of actors "+A.getName()+" and "+first.getName()+" are not compatible.", "Standard schedulability analysis");
						return -3;
					}
				}
			}
		}
		if(T>0 && (T<periodLowerBound || T>periodUpperBound)){
			adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(), "Provided periods (actor "+first.getName()+") should be in ["+periodLowerBound+", "+periodUpperBound+"].", "Standard schedulability analysis");
			return -4;
		}
		return T;
	}
	
	private boolean standardRTA(long T,Set<_Actor> vertexSet, List<AperiodicActor> apactors){
		setAllPeriods(T, vertexSet);
		for(int j=0;j<priorityOrderedActors.size(); j++){
			_Actor actor=priorityOrderedActors.get(j); 
			if(!vertexSet.contains(actor)) continue;
			long R=responseTime(j,vertexSet,apactors); 
			if(R>actor.getDeadline()) return false;
		}
		return true;
	}
	
	public double getProcessorUtilizationFactor(List<AperiodicActor> apactors){ 
		if(basis.getPeriod()==_Actor.UNDEFINED) return -1;
		double UP=psi/basis.getPeriod(), US=getUS1(apactors);
		return UP+US; 
	}
}
