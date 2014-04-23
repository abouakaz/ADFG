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

import adfg.Actor;
import adfg.AdfgPackage;
import adfg.AperiodicActor;
import adfg.PeriodicActor;
import adfg.impl.AperiodicActorImpl;
import adfg.impl.PeriodicActorImpl;


public class PriorityAssignmentPolicies {
	
	private WeaklyConnectedComponent component;
	private ADFGraph adfgraph;
	
	public PriorityAssignmentPolicies(WeaklyConnectedComponent C){
		component=C;
		adfgraph=component.getADFGraph();
	}
	
	
	public boolean perform(){
		switch(component.getScheduleType()){
		//uniprocessor
		case 0: priorityAssignmentDM(adfgraph.getNbAperiodicActors()+1); break;
		case 1: if(!priorityAssignmentLOP(adfgraph.getNbAperiodicActors(), false)){
					adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(),"LOP priority assignment failed.","Priority assignment");
					return false;
		        } break;
		case 2: { 
			 	Map<_Actor,Long> oldPeriods=savePeriods(); priorityAssignmentDM(1); 
			 	long T=component.SRTA(component.getAffineGraph().vertexSet(), component.getADFGraph().getAperiodicActors());
			 	resetPeriods(oldPeriods);
				if(T<0){
					adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(),"UDH priority assignment failed.","Priority assignment");
					return false;
				}
				priorityAssignmentUtilizationDistanceHeuristic(T, 0.15, 7, adfgraph.getNbAperiodicActors());
				} break;
		case 3: {
				String str=checkUserPriorities();
				if(!str.equals("")){
					adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(),str,"Priority assignment");
					return false;
				}
				} break;
		case 4: if(!priorityAssignmentLOP(adfgraph.getNbAperiodicActors(), true)){
					adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(),"CLOP priority assignment failed.","Priority assignment");
					return false;
				} break;
			
		//multiprocessor
		case 10: case 11: priorityAssignmentDM(adfgraph.getNbAperiodicActors()+1); break;
		case 12: {
				String str=checkUserPriorities();
				if(!str.equals("")){
					adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(),str,"Priority assignment");
					return false;
				}
				} break;
		}
		
		//update the graphical model
		if(component.getNbProcessor()>1) return true; /* the update will be done after the processor allocation process. */
		
		adfgraph.setPropertyUpdating(true);
		for(_Actor A:component.getActors()){
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
		}
		adfgraph.setPropertyUpdating(false);
		
		return true;
	}

//===============================================================================================================================================================
//												(DM) Deadline monotonic ==> processor utilization maximization
//===============================================================================================================================================================
	
	public void priorityAssignmentDM(int min){
		ArrayList<DeadlineInfo> priorityOrder=new ArrayList<DeadlineInfo>();
		for(_Actor actor:component.getActors()){
			Fraction coef=component.getCoefficients().get(actor);
			Fraction deadline=actor.getSymbolicDeadline().MUL(coef);
			DeadlineInfo D=new DeadlineInfo(actor,deadline);
			insertOrderedSet(priorityOrder,D);
		}
		int i=min;
		for(DeadlineInfo element:priorityOrder){
			element.actor.setPriority(i);
			System.out.println(element.actor.getName()+"  "+i);
			i++;
		}
	}
	
	private class DeadlineInfo{
		public _Actor actor;
		public Fraction deadline;
		
		public DeadlineInfo(_Actor A, Fraction f){
			actor=A;
			deadline=f;
		}
	}
	
	private void insertOrderedSet(ArrayList<DeadlineInfo> list, DeadlineInfo D){
		int i=0;
		for(DeadlineInfo element:list){
			if(D.deadline.less(element.deadline)) break;
			else if(D.deadline.equals(element.deadline)){
				double x=D.actor.getWcet()/component.getCoefficients().get(D.actor).getValue();
				double y=element.actor.getWcet()/component.getCoefficients().get(element.actor).getValue();
				if(x>y)  break; 
				else if(x==y){
					if(D.actor.getID()<element.actor.getID()) break;
					else i++;
				}
				else i++;
			}
			else i++;
		}
		list.add(i, D);
	}
	
//===============================================================================================================================================================
//										(LOP) Linear Ordering Problem  ==> buffer minimization
//===============================================================================================================================================================
	
	public boolean priorityAssignmentLOP(int min, boolean compromise){
		ArrayList<_Actor> setOfActors=new ArrayList<_Actor>();
		for(_Actor A: component.getActors()) setOfActors.add(A);
		int N=setOfActors.size();
		/* weight matrix */
		int[][] sizes=new int[N][N];
		int i=0, j=0;
		for(_Actor A:setOfActors){
			j=0;
			for(_Actor B:setOfActors){
				A.setPriority(1); B.setPriority(2); _AffineRelation r=component.getAffineGraph().getEdge(A,B); 
				if(r!=null){
				   if(A.getID()>B.getID()) r=r.getReverse(); else r=r.clone();
				   sizes[i][j]=approximateSize(A,B,r);
				}
				else sizes[i][j]=0;
				j++;
			}
			i++;
		}
		//for(i=0;i<N;i++){ for(j=0; j<N;j++){ System.out.print(sizes[i][j]+"  "); } System.out.println(); }
			
		/* generate ILP program */
		StringBuilder constraints=new StringBuilder("\nSubject To \n"), binary=new StringBuilder("\nBinary \n"), objective=new StringBuilder("\nMINIMIZE \n obj:"), bounds=new StringBuilder("\n Bounds \n");
		
		for(i=0; i<setOfActors.size(); i++)
			for(j=0;j<setOfActors.size(); j++){
				if(i!=j){
					binary.append("x_"+i+"_"+j+"\n");
					if(sizes[i][j]!=0) objective.append(sizes[i][j]+" x_"+i+"_"+j+" + ");
					if(i<j){
						constraints.append("x_"+i+"_"+j+" + x_"+j+"_"+i+" = 1\n");
						for(int k=i+1; k<component.getActors().size();k++){
							if(k!=j) constraints.append("x_"+i+"_"+j+" + "+"x_"+j+"_"+k+" + "+"x_"+k+"_"+i+" <= 2\n");
						}
					}
				}
			}
		/* distance between DM priorities and the new ones */
		if(compromise){
			priorityAssignmentDM(1);
			int[][] DMprecedences=new int[N][N];
			i=0;
			for(_Actor A:setOfActors){
				j=0;
				for(_Actor B:setOfActors){
					if(A.getPriority()<B.getPriority()) DMprecedences[i][j]=1; else DMprecedences[i][j]=0;
					j++;
				}
				i++;
			}
			String str="";
			for(i=0;i<N;i++)
				for(j=0;j<N;j++){
					if(DMprecedences[i][j]==1) str+="x_"+i+"_"+j+" +";
				}
			str=str.substring(0, str.length()-1);
			int d=N*(N-1); d/=2; d-=d/5;
			constraints.append(str+" >= "+d+"\n");
		}
		objective.deleteCharAt(objective.length()-2).append(" \n"); binary.append("\nEnd");
		
		//System.out.println(objective.toString()+constraints.toString()+binary.toString()+"\n\n");
		/* solve the ILP problem */
		try{
			FileWriter lpProblem=new FileWriter("ILProblemPriority.lp"); 
			lpProblem.write(objective.toString()); lpProblem.write(constraints.toString()); 
			lpProblem.write(binary.toString());
			lpProblem.close();
		}
		catch(Exception e){System.err.println("Error: " + e.getMessage());}
		try {
			  // Read the generated linear problem from a file
			  IloCplex cplex = new IloCplex();
			  cplex.importModel("ILProblemPriority.lp"); cplex.setOut(null); cplex.setParam(IloCplex.DoubleParam.TiLim, 300); // 5 minutes maximum
			  // solve the problem
			  if(!cplex.solve()) return false; /* infeasible ILP problem. */
			  /* save the solution */
			  IloLPMatrix lp = (IloLPMatrix)cplex.LPMatrixIterator().next();
		      IloNumVar[] vars = lp.getNumVars();
		      Map<Integer,Integer> priorities=new HashMap<Integer,Integer>();
		      for(i=0; i<setOfActors.size(); i++) priorities.put(i, 0);
		      double[]    vals = cplex.getValues(vars);
		      HashMap<String,Integer> varsPhi=new HashMap<String,Integer>();
			  for (i = 0; i < vals.length; i++) {
				  String varName=vars[i].getName(); int varValue=(int)Math.round(vals[i]);
				  //System.out.println(varName+" "+varValue);
				  if(varValue==1){
					  String temp1=varName.replaceAll("\\D"," ");  temp1=temp1.trim(); String[] temp2=temp1.split(" +");
					  int[] ids= new int[2]; ids[0]=Integer.decode(temp2[0]); ids[1]=Integer.decode(temp2[1]);
					  priorities.put(ids[0], priorities.get(ids[0])+1);
				  } 
				    
			  }
			  cplex.end();
			  int n=setOfActors.size();
			  for(i=0;i<setOfActors.size();i++){
				  _Actor actor=setOfActors.get(i);
				  actor.setPriority(n-priorities.get(i)+min);
				  //System.out.println("p_"+actor.getID()+" "+actor.getPriority());
			  }
		 }
		 catch (IloException e) {
		       e.printStackTrace();
		 }
		return true;
	}
		
	protected int approximateSize(_Actor src, _Actor dest, _AffineRelation r){	
		Set<_Channel> edges=adfgraph.getDataflowGraph().getAllEdges(src, dest);
		edges.addAll(adfgraph.getDataflowGraph().getAllEdges(dest, src)); 
		if(edges.isEmpty()) return 0;
		r.setPhi(1);		
		int result=0;
		for(_Channel e:edges){
			int oldSize=e.getSize(), oldInitial=e.getInitial();
			boolean b=(adfgraph.getDataflowGraph().getEdgeSource(e)==src);
			if(b) ADFGraph.bufferSize(e, src, dest, r); else ADFGraph.bufferSize(e,dest,src,r.getReverse()); 
			result+=e.getSize()*e.getDataSize(); e.setInitial(oldInitial); e.setSize(oldSize);
		}
		return result;
	}
	
//===============================================================================================================================================================
//									(UDH) Utilization distance heuristic ==> buffer minimization with throughput constraint
//===============================================================================================================================================================
	
	/**
	 * 2 <= L <= 9
	 */
	protected void priorityAssignmentUtilizationDistanceHeuristic(long T, double threshold, int L, int min){
		/*compute DM priority without setting priorities */
		ArrayList<DeadlineInfo> priorityOrder=new ArrayList<DeadlineInfo>();
		for(_Actor actor:component.getActors()){
			Fraction coef=component.getCoefficients().get(actor);
			Fraction deadline=actor.getSymbolicDeadline().MUL(coef);
			DeadlineInfo D=new DeadlineInfo(actor,deadline);
			insertOrderedSet(priorityOrder,D);
		}
		int i=0; int N=component.getAffineGraph().vertexSet().size();
		_Actor[] DMOrderedActors=new _Actor[N];
		for(DeadlineInfo element:priorityOrder){
			DMOrderedActors[i]=element.actor;
			i++;
		}
		PriorityAssignment DMPermutation=new PriorityAssignment(DMOrderedActors); 
		/* Approximate buffer sizes*/
		int[][] sizes=new int[N][N];
		_Actor[] vertexSet=new _Actor[N]; int k=0;
		for(_Actor A:component.getActors()){
			vertexSet[k]=A;
			k++;
		}
		int ii=0, jj=0;
		for(_Actor A:vertexSet){
			jj=0;
			for(_Actor B:vertexSet){
				A.setPriority(1); B.setPriority(2);
				_AffineRelation r=component.getAffineGraph().getEdge(A,B); 
				if(r!=null){
					if(A.getID()>B.getID()) r=r.getReverse(); else r=r.clone();
					sizes[ii][jj]=approximateSize(A,B,r);
				}
				else sizes[ii][jj]=0;
				jj++;
			}
			ii++;
		}
		//----
		if(L>N) L=N;
		PriorityAssignment curPerm=DMPermutation.clone(), prevPerm;
		int curSize=curPerm.getApproximateBuffering(sizes,vertexSet); 
		double curDistance=0;
		do{
			prevPerm=curPerm.clone(); 
			for(i=0;i<=(N-L);i++){
				ArrayList<PriorityAssignment> arrangments=prevPerm.arranging(i,L); 
				for(PriorityAssignment O:arrangments){
					//System.out.println("O "+O);
					double dis=O.getUtilizationDistance(T); 
					if(dis<=threshold){
						int size=O.getApproximateBuffering(sizes,vertexSet); 
						if(size<curSize ||(size==curSize && dis<curDistance)){ 
							curSize=size;
							curDistance=dis;
							curPerm=O.clone();
						}
					}
				}
			}
			//System.out.println(curPerm);
		}while(!curPerm.equals(prevPerm));
		
		/* setting priorities */
		for(int j=0; j<N; j++){
			curPerm.order[j].setPriority(j+1+min);
		}
	}
	
	private class PriorityAssignment{
		_Actor[] order;
		
		public PriorityAssignment(_Actor[] actors){
			order=actors;
		}
		
		public boolean equals(PriorityAssignment O){
			boolean res=true;
			for(int i=0;i<order.length;i++){
				if(order[i].getID()!=O.order[i].getID()){ res=false; break;}
			}
			return res;
		}
		
		public PriorityAssignment clone(){
			_Actor[] actors=new _Actor[order.length];
			for(int i=0;i<order.length;i++) actors[i]=order[i];
			return new PriorityAssignment(actors);
		}
		
		public ArrayList<PriorityAssignment> arranging(int index, int L){
			ArrayList<PriorityAssignment> result=new ArrayList<PriorityAssignment>();
			String str=""; for(int i=0;i<L;i++) str+=i; 
			ArrayList<String> localPerm=new ArrayList<String>();
			if(L==3){
				localPerm.add("012"); localPerm.add("021"); localPerm.add("102"); localPerm.add("120"); localPerm.add("201"); localPerm.add("210");
			}
			else permutations(localPerm,"",str); 
			
			for(int i=0;i<localPerm.size();i++){
				_Actor[] actors=new _Actor[order.length];
				for(int j=0;j<index;j++) actors[j]=order[j];
				for(int j=index+L;j<order.length;j++) actors[j]=order[j];
				String localStr=localPerm.get(i); 
				for(int j=0;j<L;j++){
					int k=Integer.parseInt(""+localStr.charAt(j));
					actors[j+index]=order[k+index];
				}
				PriorityAssignment O=new PriorityAssignment(actors);
				result.add(O);
			}
			return result;
		}
		
		private void permutations(ArrayList<String> result, String prefix, String str){
			int n = str.length();
		    if (n == 0)  result.add(prefix);
		    else {
		        for (int i = 0; i < n; i++)
		            permutations(result, prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		    }
		}
		
		public double getUtilizationDistance(long T){
			double U=component.getPsi()/T;
			long maxT=T;
			for(int i=0;i<order.length;i++){
				_Actor A=order[i];
				/*compute response time of A */
				long R,R_next=A.getWcet();
				do{
					R=R_next;
					R_next=A.getWcet(); 
					for(int j=0;j<i;j++){
						_Actor B=order[j];
						Fraction f=component.getCoefficients().get(B);
						R_next+=B.getWcet()*(long)Math.ceil(R/(f.getValue()*T)); 
					}
					
				}while(R!=R_next);
				/* compute maxT */
				Fraction deadline=A.getSymbolicDeadline().MUL(component.getCoefficients().get(A));
				long temp=component.getDivFactor()*(long)Math.ceil(R/(deadline.getValue()*component.getDivFactor())); 
				if(temp>maxT) maxT=temp;
			}
			return 1-(component.getPsi()/(U*maxT));
		}
		
		public int getApproximateBuffering(int[][] sizes, _Actor[] vertexSet){
			int sum=0;
			for(int i=0;i<order.length;i++){
				_Actor A=order[i]; 
				int ii=0; for(ii=0; ii<vertexSet.length; ii++){ if(vertexSet[ii].getID()==A.getID()) break; }
				for(int j=i+1;j<order.length;j++){
					_Actor B=order[j];
					int jj=0; for(jj=0; jj<vertexSet.length; jj++){ if(vertexSet[jj].getID()==B.getID()) break; }
					sum+=sizes[ii][jj];
				}
			}
			return sum;
		}
		
		public String toString(){
			String str="";
			for(int i=0;i<order.length;i++) str+=order[i].getName()+"   ";
			return str;
		}
		
	}
	
	private Map<_Actor,Long> savePeriods(){
		Map<_Actor,Long> oldPeriods=new HashMap<_Actor,Long>();
		for(_Actor A: component.getActors()){
			oldPeriods.put(A, A.getPeriod());
		}
		return oldPeriods;
	}
	
	private void resetPeriods(Map<_Actor,Long> oldPeriods){
		Iterator<_Actor> it=oldPeriods.keySet().iterator();
		while(it.hasNext()){
			_Actor A=it.next(); 
			A.setPeriod(oldPeriods.get(A));
		}
	}
	
//===============================================================================================================================================================
//														(User) User-provided priorities
//===============================================================================================================================================================
	
	public String checkUserPriorities(){
		String str="";
		for(Actor A:adfgraph.getApplicationGraph().getNodes()){
			  if(A.getPriority()<=0 || (component.getScheduleType()>=10 && A.getProcNumber()<=0) ) str+=A.getName()+"; ";
		}
		if(!str.equals("")){
			str="No user-provided priorities/processor allocation for actors: "+str;
			return str;
		}
		//check that two actors on the same processor have distinguished priorities and aperiodic actors have higher priorities than periodic actor
		for(Actor A:adfgraph.getApplicationGraph().getNodes()){
			for(Actor B:adfgraph.getApplicationGraph().getNodes()){
				if(A!=B && A.getProcNumber()==B.getProcNumber()){
					if( A.getPriority()==B.getPriority()){
						str="Actors allocated to the same processor must have distinguished priorities: "+A.getName()+" and "+ B.getName();
						return str;
					}
					else if((A instanceof PeriodicActor && B instanceof AperiodicActor && A.getPriority()<B.getPriority()) ||(A instanceof AperiodicActor && B instanceof PeriodicActor && A.getPriority()>B.getPriority())){
						str="Aperiodic actors must have higher priorities than periodic actors allocated to the same processor: "+A.getName()+" and "+ B.getName();
						return str;
					}
				}
				
			}
		}
		return str;
	}
	
//===============================================================================================================================================================
//													Aperiodic actors: priority assignment (RM) and processor allocation (Best-Fit)
//===============================================================================================================================================================
	
	public List<List<AperiodicActor>> aperiodicActorsPriorityAndAllocation(List<AperiodicActor> actors){
		/* load ordering */
		List<AperiodicActor> orderedSet=loadOrdering(actors);
		/* best-fit partitionning */
		List<List<AperiodicActor>> partitions=loadBestFitPartitioning(orderedSet);
		/* RM priority ordering of actors in each partition */
		for(int i=0; i<component.getNbProcessor();i++){
			List<AperiodicActor> RMorder=RMOrdering(partitions.get(i));
			/* update the graphical model */
			for(int j=0; j<RMorder.size();j++){
				AperiodicActor modelActor=RMorder.get(j); 
				
				component.getADFGraph().setPropertyUpdating(true);
				TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(modelActor);
				SetRequest setRequest = new SetRequest(domain, modelActor, AdfgPackage.eINSTANCE.getActor_Priority(),j+1);
				setRequest.setParameter("oldValue", modelActor.getPriority());
				SetValueCommand operation = new SetValueCommand(setRequest){     		    
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						((AperiodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PRIORITY,((SetRequest)this.getRequest()).getValue());
						return CommandResult.newOKCommandResult();
					} 
				};
				ICommandProxy comm = new ICommandProxy(operation);
				comm.execute();
				
				
				setRequest = new SetRequest(domain, modelActor, AdfgPackage.eINSTANCE.getActor_ProcNumber(),i+1);
				setRequest.setParameter("oldValue", modelActor.getProcNumber());
				operation = new SetValueCommand(setRequest){     		    
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						((AperiodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PROC_NUMBER,((SetRequest)this.getRequest()).getValue());
						return CommandResult.newOKCommandResult();
					} 
				};
				comm = new ICommandProxy(operation);
				comm.execute();	
				component.getADFGraph().setPropertyUpdating(false);
			}
		}
		/* Check whether the load of each partition is less than 1 */
		String str="";
		for(int i=0; i<component.getNbProcessor(); i++){
			if(WeaklyConnectedComponent.getUS1(partitions.get(i)) >1){ 
				str+=" processor "+(i+1)+"; ";
			}
		}
		if(!str.equals("")){
			str="Utilization of aperiodic actors exceeds 1: "+str;
			adfgraph.updateGraphDiagnostic(adfgraph.getApplicationGraph(),str,"Priority assignment");
			return null;
		}
		return partitions;
	}
	
	private List<AperiodicActor> loadOrdering(List<AperiodicActor> actors){
		List<AperiodicActor> orderedSet=new ArrayList<AperiodicActor>();
		for(AperiodicActor actor:actors){
			boolean inserted=false;
			int i=0;
			while(i<orderedSet.size() && !inserted){
				AperiodicActor A=orderedSet.get(i); double loadA= (double)A.getCapacity()/A.getReplenishmentPeriod(), loadActor=(double)actor.getCapacity()/actor.getReplenishmentPeriod();
				if(loadA<loadActor){
					inserted=true; orderedSet.add(i, actor);
				}
				i++;
			}
			if(!inserted) orderedSet.add(i,actor);
		}
		return orderedSet;
	}
	
	private List<List<AperiodicActor>> loadBestFitPartitioning(List<AperiodicActor> actors){
		ArrayList<List<AperiodicActor>> partitions=new ArrayList<List<AperiodicActor>>();
		for(int i=0; i<component.getNbProcessor(); i++) partitions.add(new ArrayList<AperiodicActor>());
		double[] loads=new double[component.getNbProcessor()]; for(int i=0; i<component.getNbProcessor(); i++) loads[i]=0;
		for(AperiodicActor actor:actors){
			int bestPartition=-1; double bestLoad=Double.MAX_VALUE, loadActor=(double)actor.getCapacity()/actor.getReplenishmentPeriod();
			for(int i=0;i<component.getNbProcessor();i++){
				if(loads[i]+loadActor < bestLoad){
					bestLoad=loads[i]+loadActor;
					bestPartition=i;
				}
			}
			partitions.get(bestPartition).add(actor); loads[bestPartition]+=loadActor;
		}
		return partitions;
	}
	
	private List<AperiodicActor> RMOrdering(List<AperiodicActor> actors){
		List<AperiodicActor> orderedSet=new ArrayList<AperiodicActor>();
		for(AperiodicActor actor:actors){
			boolean inserted=false;
			int i=0;
			while(i<orderedSet.size() && !inserted){
				AperiodicActor A=orderedSet.get(i); double loadA= (double)A.getCapacity()/A.getReplenishmentPeriod(), loadActor=(double)actor.getCapacity()/actor.getReplenishmentPeriod();
				if(actor.getReplenishmentPeriod()<A.getReplenishmentPeriod() ||(actor.getReplenishmentPeriod()==A.getReplenishmentPeriod() && loadActor>loadA)){
					inserted=true; orderedSet.add(i, actor);
				}
				i++;
			}
			if(!inserted) orderedSet.add(i,actor);
		}
		return orderedSet;
	}
}
