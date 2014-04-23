package adfg.schedulability;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.UndirectedSubgraph;
import org.jgrapht.traverse.DepthFirstIterator;


import adfg.Actor;
import adfg.AdfgPackage;
import adfg.AffineRelation;
import adfg.AperiodicActor;
import adfg.Channel;
import adfg.Connection;
import adfg.Graph;
import adfg.PeriodicActor;
import adfg.impl.ApplicationImpl;


public class ADFGraph {

	private DirectedMultigraph<_Actor,_Channel> dataflowGraph= new DirectedMultigraph<_Actor,_Channel>(_Channel.class);
	private SimpleGraph<_Actor, _AffineRelation> affineGraph=new SimpleGraph<_Actor, _AffineRelation>(_AffineRelation.class);
	
	private int scheduleType=3;
	
	private int nbProcessor=1;
	
	private Graph applicationGraph;
	
	public ADFGraph(Graph g){
		applicationGraph=g;
		scheduleType=3;
		nbProcessor=1;
	}
	
	public SimpleGraph<_Actor, _AffineRelation> getAffineGraph(){
		return affineGraph;
	}
	
	public Graph getApplicationGraph(){
		return applicationGraph;
	}
	
	public DirectedMultigraph<_Actor,_Channel> getDataflowGraph(){
		return dataflowGraph;
	}
	
	public int getScheduleType(){return scheduleType;} 
	
	public void setScheduleType(String str){
		//uniprocessor
		if(str.equals("DM")) scheduleType=0;
		else if(str.equals("LOP")) scheduleType=1;
		else if(str.equals("UDH")) scheduleType=2;
		else if(str.equals("User")) scheduleType=3;
		else if(str.equals("CLOP")) scheduleType=4;
		
		//multiprocessor
		else if(str.equals("DM, BF(SRTA)")) scheduleType=10;
		else if(str.equals("DM, BF(FBB-FFD)")) scheduleType=11;
		else if(str.equals("User, User")) scheduleType=12;
	}
	
	public int getNbProcessors(){return nbProcessor;} 
	
	public void setNbProcessors(int nb){
		if(nbProcessor!=nb){
			int oldNb=nbProcessor;
			nbProcessor=nb;
			boolean change=false; String newSched=applicationGraph.getOwner().getSchedulingAlgorithm();
			if(oldNb==1){
				//change from uniprocessor to multiprocessor
				change=true; newSched="User, User";
			} 
			else if(nb==1){
				//change from multiprocessor to uniprocessor
				change=true; newSched="User";
			}
			if(change){
				TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(applicationGraph.getOwner());
				SetRequest setRequest = new SetRequest(domain, applicationGraph.getOwner(), AdfgPackage.eINSTANCE.getApplication_SchedulingAlgorithm(), newSched);
				setRequest.setParameter("oldValue", applicationGraph.getOwner().getSchedulingAlgorithm());
				SetValueCommand operation = new SetValueCommand(setRequest){     		    
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						((ApplicationImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM,((SetRequest)this.getRequest()).getValue());
						return CommandResult.newOKCommandResult();
					} 
				};
				ICommandProxy comm = new ICommandProxy(operation);
				comm.execute();
			}
		}
	}
	
	private static boolean onSameProcessor(_Actor src,_Actor dest){
		return src.getNbPartition()==dest.getNbPartition();
	}
	
	
    private boolean analyzed=true;
	
	public boolean toReanalyze(){ return !analyzed; }
	
	public void setToReanalyze(){ analyzed=false; }
	
	public String toString(){
		String str="Actors\n=============\n";
		for(PeriodicActor actor:actorGM.ValueSet()){
			str+=actor.getName()+"["+actor.getPeriod()+", "+actor.getPhase()+", "+actor.getWcet()+", "+actor.getPriority()+", "+
		          actor.getProcNumber()+", "+actor.getDeadline()+", "+actor.getPeriodLowerBound()+", "+actor.getPeriodUpperBound()+"];  ";
		}
		str+="\nChannels\n=============\n";
		for(Channel C:channelGM.ValueSet()){
			str+=C.getSource().getOwner().getName()+" --> "+C.getTarget().getOwner().getName()+"["+C.getInitial()+", "+C.getSize()+", "+C.getSource().getSequence()+", "+C.getTarget().getSequence()+ "];  ";
		}
		str+="\nAffine relations\n=================\n";
		for(AffineRelation R:affineRelationGM.ValueSet()){
			str+=R.getSource().getName()+" --> "+R.getTarget().getName()+"["+R.getN()+", "+R.getPhi()+", "+R.getD()+"];  ";
		}
		return str;
	}
	
	public int getNbAperiodicActors(){
		int i=0;
		for(Actor A:applicationGraph.getNodes()){
			if(A instanceof AperiodicActor) i++;
		}
		return i;
	}
	
	
	private boolean propertyUpdating=false;
	
	public boolean isPropertyUpdating() {return propertyUpdating; }
	
	public void setPropertyUpdating(boolean b){ propertyUpdating=b; }
	
	
	public List<AperiodicActor> getAperiodicActors(){
		List<AperiodicActor> aperiodicActors=new ArrayList<AperiodicActor>();
		for(Actor actor:applicationGraph.getNodes()){
			if(actor instanceof AperiodicActor)  aperiodicActors.add((AperiodicActor)actor);
		}
		return aperiodicActors;
	}
	
//=========================================================================================================================================
//                                                 Dynamic construction of the dataflow graph
//=========================================================================================================================================
	
	/**
 	 * a map between actor objects in the graph and actor objects in the model.
 	 */
 	private BidiMap<_Actor, PeriodicActor> actorGM = new BidiMap<_Actor, PeriodicActor>();
 	
 	public BidiMap<_Actor, PeriodicActor> getActorGM(){ return actorGM; }
 	 
 	/**
 	 * a map between simple channels in the graph and those in the model.
 	 */
 	private BidiMap<_Channel, Channel> channelGM = new BidiMap<_Channel, Channel>();
 	
 	public BidiMap<_Channel, Channel> getChannelGM(){ return channelGM; }
 	 
 	/**
 	 * a map between affine relations in the graph and those in the model.
 	 */
 	private BidiMap<String, AffineRelation> affineRelationGM= new BidiMap<String, AffineRelation>();
 	
 	public BidiMap<String, AffineRelation> getAffineRelationGM(){ return affineRelationGM; }
 	
 	//------------------------
 	//Add a periodic actor
 	//------------------------
 	/**
 	 * Add a new adfg.PeriodicActor to this graph.
 	 * @param actor a non null instance of PeriodicActor.
 	 * @return true if the actor is added (no duplicate addition), false otherwise.
 	 * 
 	 */
 	public void addModelPeriodicActor(PeriodicActor actor){
 		if(!actorGM.containsValue(actor)){
  			_Actor A=create_Actor(actor);
  	 		if(dataflowGraph.addVertex(A)){
 	 			actorGM.put(A, actor);
 	 			setToReanalyze();
 	            if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_AddActor(A); //Dynamic checking
 	 		}
 		}
 	 }
 	
 	private _Actor create_Actor(PeriodicActor actor){
 		_Actor A=new _Actor(actor.getName(),actor.getWcet());
 		if(actor.getPeriod()>0) A.setPeriod(actor.getPeriod());
 		if(actor.getPhase()>=0) A.setPhase(actor.getPhase());
 		if(actor.getPeriodUpperBound()>0) A.setPeriodUpperBound(actor.getPeriodUpperBound());
 		if(actor.getPeriodLowerBound()>0) A.setPeriodLowerBound(actor.getPeriodLowerBound());
 		A.setSymbolicDeadline(stringtoFraction(actor.getDeadline()));
 		A.setNbPartition(actor.getProcNumber());
 		return A;
 	}
 	
 	private Fraction stringtoFraction(String str){
 		int a,b;
 		String[] ab=str.split("/");  a=Integer.parseInt(ab[0]); b=Integer.parseInt(ab[1]);
 		return new Fraction(a,b);
 	}
 	
 	//------------------------
 	//Add a channel
 	//------------------------
 	/**
	  * Add a new adfg.simpleChannel to this network.
	  * @param channel the SimpleChannel to be added.
	  * @return true if the channel is added successfully.
	  */
	 public void addModelChannel(Channel channel) throws IllegalArgumentException {
		 if(!channelGM.containsValue(channel)){
			 _Channel C=create_Channel(channel);
			 /* Search for actors */
			 _Actor A1=actorGM.getKey((PeriodicActor)channel.getSource().getOwner());
			 _Actor A2=actorGM.getKey((PeriodicActor)channel.getTarget().getOwner());
			 if(addChannel(C, A1, A2)){
				 channelGM.put(C, channel);
				 setToReanalyze();
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_AddChannel(C); //Dynamic checking
			 }
		 }
	 }
	 
	 private _Channel create_Channel(Channel channel){
		 String SW1=channel.getSource().getSequence(), SW2=channel.getTarget().getSequence();     
		 UPIS w1= new UPIS(SW1);
		 UPIS w2= new UPIS(SW2);
	 	 
		 _Channel C=new _Channel(w1,w2,channel.getSize(), channel.getInitial());
		 C.setDataSize(1);	//TODO: extract the information from the source port IType
		 return C;
	 	}
	 
	 /**
	 * Add a simple channel between two actors. The two actors must be added first.
	 * @return true if channel is added successfully.
	 */
	 private boolean addChannel(_Channel C,_Actor A1, _Actor A2) {
		if(A1==null || A2==null) throw new IllegalArgumentException("End points must be inserted before the channel.");
		if(A1.getID()==A2.getID()) throw new IllegalArgumentException("Self loops are not allowed");
		return dataflowGraph.addEdge(A1, A2, C);
	 }
	 
	 //------------------------
	 //Add affine relation
	 //------------------------
	 /**
	  * Add a new adfg.AffineRelation to this graph.
	  * @param affineRelation the affine relation to be added.
	  * @return true if relation is added, false otherwise. 
	  */
	 public void addModelAffineRelation(AffineRelation affineRelation){
		 if(!affineRelationGM.containsValue(affineRelation)){ 
			 _Actor A1=actorGM.getKey(affineRelation.getSource());
			 _Actor A2=actorGM.getKey(affineRelation.getTarget());
			 //_AffineRelation r= create_AffineRelation(affineRelation);
			 if(addAffineRelation(A1, A2)){
				 String key=(A1.getID()<A2.getID())?A1.getID()+":"+A2.getID():A2.getID()+":"+A1.getID();
				 affineRelationGM.put(key, affineRelation);
				 setToReanalyze();
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_AddAffineRelation(A1,A2); //Dynamic checking
			 }
		 }
	 }
	
	 private _AffineRelation create_AffineRelation(AffineRelation r){
		 return new _AffineRelation(r.getN(),r.getPhi(),r.getD());
	 }
	 /**
	  * @return false if a relation already exists in the model.
	  */
	 private boolean addAffineRelation(_Actor A1,_Actor A2){
		 if(A1==null || A2==null) throw new IllegalArgumentException("Arguments of addAffineRelation must not be null");
		 String key;
		 if(A1.getID()<A2.getID()) key=A1.getID()+":"+A2.getID();
		 else if(A1.getID()>A2.getID()) { key=A2.getID()+":"+A1.getID();}
		 else throw new IllegalArgumentException("An affine relation can be added only between two distinguised actors");
		 if(affineRelationGM.containsKey(key)) throw new IllegalArgumentException("An affine relation already exists between the two actors"); //The key already exists
		 return true;
	 }
	 
	 //-----------------------------------------------------------------
	 // Remove model elements: periodic actor, channel, affine relation
	 //-----------------------------------------------------------------
	 
	 /**
	  * Remove an adfg.PeriodicActor from this graph. All connections of the actor must be deleted first.
	  */
	 public void removeModelPeriodicActor(PeriodicActor actor){
		 if(actorGM.containsValue(actor)){ 
			 _Actor A=actorGM.getKey(actor);
			 dataflowGraph.removeVertex(A);
			 actorGM.removeKey(A);
			 setToReanalyze();
			 if(applicationGraph.getOwner().isDynamicChecking())  dynamicCheking_RemoveActor(A); //Dynamic checking
		 }
	 }
	 
	 /**
	  * Remove an adfg.Channel from this graph.
	  */
	 public void removeModelChannel(Channel channel){
		 if(channelGM.containsValue(channel)){
			 _Channel C=channelGM.getKey(channel);
			 if(dataflowGraph.containsEdge(C)){
				 _Actor A1=dataflowGraph.getEdgeSource(C), A2=dataflowGraph.getEdgeTarget(C);
				 dataflowGraph.removeEdge(C);
				 setToReanalyze();
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_RemoveChannel(A1,A2);
			 }
			 channelGM.removeKey(C);
		 }
	 }
	 
	 
	 /**
	  * Remove an adfg.AffineRelation from this network.
	  */
	 public void removeModelAffineRelation(AffineRelation affineRelation, PeriodicActor source, PeriodicActor target){
		 if(affineRelationGM.containsValue(affineRelation)){
			 _Actor A1=actorGM.getKey(source); 
			 _Actor A2=actorGM.getKey(target);
			 affineRelationGM.removeValue(affineRelation);
			 if(A1!=null && A2!=null){
				 setToReanalyze();
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_RemoveAffineRelation(A1,A2); //Dynamic checking
			 }
		 }
	 }
	 
	 //-----------------------------------------------------------------
	 // Update model elements: periodic actor, channel, affine relation
	 //-----------------------------------------------------------------
	
	 /**
	  * Update informations in an adfg.PeriodicActor
	  * @param str the attribute to update. 
	  */
	 public void updateModelActor(PeriodicActor actor, String str){
		 if(actorGM.containsValue(actor)){
			 _Actor A=actorGM.getKey(actor);
			 if(str.equals("name")) A.setName(actor.getName()); 
			 else{ 
				 setToReanalyze();
				 if(str.equals("wcet")) A.setWcet(actor.getWcet());
				 else  if(str.equals("periodUpperBound"))  A.setPeriodUpperBound(actor.getPeriodUpperBound()); 
				 else  if(str.equals("periodLowerBound")) A.setPeriodLowerBound(actor.getPeriodLowerBound()); 
				 else  if(str.equals("deadline")) A.setSymbolicDeadline(stringtoFraction(actor.getDeadline()));
				 else  if(str.equals("period")){
					 A.setPeriod(actor.getPeriod());
					 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_UpdateActorPeriod(A); //Dynamic checking
				 }
			 }
			 System.out.println(this);
		 }
	 }
	 
	 /**
	  * Update informations in an adfg.Channel.
	  * @param str the attribute to update
	  */
	 public void updateModelChannel(Channel channel, String str){
		 if(channelGM.containsValue(channel)){
			 _Channel C=channelGM.getKey(channel);
			 setToReanalyze();
			 if(str.equals("size")){
				 C.setSize(channel.getSize()); 
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_UpdateChannelSizeInitial(C);  //Dynamic checking
			 }
			 else if(str.equals("initial")){
				 C.setInitial(channel.getInitial());
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_UpdateChannelSizeInitial(C);  //Dynamic checking
			 }
			 else if(str.equals("type")){
				//TODO
				 C.setDataSize(1);
			 }
			 else if(str.equals("produce")){
				 String SW1=channel.getSource().getSequence(); UPIS w1= new UPIS(SW1);
				 C.setProduce(w1);
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_UpdateChannelSequence(C); //Dynamic Checking
			 }
			 else if(str.equals("consume")){
				 String SW2=channel.getTarget().getSequence(); UPIS w2= new UPIS(SW2);				 
				 C.setConsume(w2);
				 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_UpdateChannelSequence(C); //Dynamic checking
			 }
			 System.out.println(this);
		 }
	 }
	 
	 
	 /**
	  * Update informations in an adfg.AffineRelation.
	  */
	 public void updateModelAffineRelation(AffineRelation affineRelation){
		 if(affineRelationGM.containsValue(affineRelation)){
			 _Actor A1=actorGM.getKey(affineRelation.getSource());
			 _Actor A2=actorGM.getKey(affineRelation.getTarget());
			 setToReanalyze();
			 if(applicationGraph.getOwner().isDynamicChecking()) dynamicChecking_UpdateAffineRelation(A1,A2); //Dynamic checking
		 }
	 }
	 
 //=========================================================================================================================================
 //                                               Static construction of the dataflow graph
 //=========================================================================================================================================
	
	 /**
	  * This function is called when the graph is entirely loaded from the xml file: construct the graph
	  */
	 public void addModelGraph(){		
		 for(Iterator<Actor> it=applicationGraph.getNodes().iterator();it.hasNext();){
			 Actor actor=it.next();
			 if(actor instanceof PeriodicActor){
				 addModelPeriodicActor((PeriodicActor)actor);
			 }
		 }
		 for(Iterator<Connection> it=applicationGraph.getConnections().iterator(); it.hasNext();){
			 Connection connection=it.next();
			 if(connection instanceof Channel){
				 addModelChannel((Channel)connection);
			 }
		 }
		 for(Iterator<AffineRelation> it=applicationGraph.getAffineRelations().iterator(); it.hasNext();){
			 AffineRelation affineRelation=it.next();
			 addModelAffineRelation(affineRelation);		
		 }
		 
		 if(applicationGraph.getOwner().isDynamicChecking()) checkConsistency_Cycles();
	 }
		
	 public boolean isEmpty(){
		 return (applicationGraph.getNodes().isEmpty() && applicationGraph.getConnections().isEmpty() && applicationGraph.getAffineRelations().isEmpty());
	 }	 
	 
 //=========================================================================================================================================
 //                                               Dynamic construction of the graph of affine relations
 //=========================================================================================================================================
	 /**
	  * This function is called upon adding an actor.
	  */
	 public void dynamicChecking_AddActor(_Actor actor){
		 affineGraph.addVertex(actor);  
		 if(actor.getPeriod()!=_Actor.UNDEFINED){
			 dynamicChecking_UpdateActorPeriod(actor);
		 }
	 }	
	 
	 /**
	  * This function is called upon removing an actor.
	  */
	 public void dynamicCheking_RemoveActor(_Actor actor){
		 affineGraph.removeVertex(actor); 
		 checkConsistency_Cycles();
	 }
	
	 /**
	  * This function is called when the period of an actor is set. At this moment, we have to perform a time abstraction validation.
	  */
	 public void dynamicChecking_UpdateActorPeriod(_Actor actor){
		 Iterator<_Actor> it=dataflowGraph.vertexSet().iterator();
		 while(it.hasNext()){
			 _Actor A=it.next();
			 if(A.getID()==actor.getID()) continue; 
			 long A_period=A.getPeriod();
			 if(A_period==_Actor.UNDEFINED) continue;
			 recheckConsistency(actor,A);
		 }
	 }
	 
	 /**
	  * This function is called upon adding a channel.
	  */
	 public void dynamicChecking_AddChannel(_Channel channel){
		 recheckConsistency(dataflowGraph.getEdgeSource(channel), dataflowGraph.getEdgeTarget(channel));
	 }
	 
	 /**
	  * This function is called upon deleting a channel.
	  */
	 public void dynamicChecking_RemoveChannel(_Actor A1, _Actor A2){
		 recheckConsistency(A1, A2); 
	 }
	 
	 /**
	  * This function is called when a sequence of a channel is changed.
	  */
	 public void dynamicChecking_UpdateChannelSequence(_Channel channel){
		 recheckConsistency(dataflowGraph.getEdgeSource(channel), dataflowGraph.getEdgeTarget(channel));
	 }
	 
	 /**
	  * This function is called when the size or the number of initial tokens in a channel change.
	  */
	 public void dynamicChecking_UpdateChannelSizeInitial(_Channel channel){
		 _Actor A1=dataflowGraph.getEdgeSource(channel), A2=dataflowGraph.getEdgeTarget(channel);
		 _AffineRelation ar=affineGraph.getEdge(A1, A2);
		 if(ar.getPhi()!=_AffineRelation.UNDEFINED){
			 /* verification of only one channel, do not re-check all connections */
			 recheckConsistency_OneChannel(channel, ar);
		 }
	 }
	 
	 /**
	  * This function is called upon adding an affine relation between actors A1 and A2.
	  */
	 public void dynamicChecking_AddAffineRelation(_Actor A1, _Actor A2){
		 recheckConsistency(A1,A2);
	 }
	 
	 /**
	  * This function is called upon removing an affine relation between actors A1 and A2.
	  */
	 public void dynamicChecking_RemoveAffineRelation(_Actor A1, _Actor A2){
		 recheckConsistency(A1,A2);
	 }
		 
	 /**
	  * This function is called upon modifying one parameter of the affine relation.
	  */
	 public void dynamicChecking_UpdateAffineRelation(_Actor A1, _Actor A2){
		 recheckConsistency(A1,A2);
	 }
	 
	 /**
	  * re-check consistency of connections between A1 and A2. Priorities of checking are as follows: 
	  * (1) time abstraction of the periods if they are specified ==> affine relation r1.
	  * (2) if there is an affine relation specified between A1 and A2 (r2), if r2 is not consistent with r1 ==> indicates problem in r2.
	  * (3) if there is an edge and r2 has no problem, check boundedness criterion w.r.t. r2. if r2 is complete ==> compute size and initial verification.
	  * (4) if there is an edge and r2 has problem, check boundedness criterion w.r.t. r1.
	  * (5) if there is edges and no r1, no r2, then the first edge will create r1. goto (4).
	  * @return put the new Affine relation between A1 and A2 in the affine graph.
	  */
	 private void recheckConsistency(_Actor A1, _Actor A2){
		 analysis=null; //The affine relation synthesis must be re-performed before performing the symbolic schedulability analysis. 
			
		 _AffineRelation ar=affineGraph.getEdge(A1, A2);
		 if(ar!=null) affineGraph.removeEdge(ar);
			
		 _AffineRelation r1=null; //from A1 ---> A2 (if A1.id < A2.id), form A2 ---> A1 otherwise.
		 Collection<_Channel> channels=new ArrayList<_Channel>(); 
		 channels.addAll(dataflowGraph.getAllEdges(A1, A2));
		 channels.addAll(dataflowGraph.getAllEdges(A2, A1)); 
		 Iterator<_Channel> it;
		 String key=(A1.getID()<A2.getID())?A1.getID()+":"+A2.getID():A2.getID()+":"+A1.getID();
			 
		 if(A1.getPeriod()==_Actor.UNDEFINED || A2.getPeriod()==_Actor.UNDEFINED){
			 if(affineRelationGM.containsKey(key)){ 
				 AffineRelation R2=affineRelationGM.getValue(key);
				 r1=create_AffineRelation(R2); if(A1.getID()>A2.getID()) r1=r1.getReverse();
			 }
			 else{ 
				 /*search for an edge between A1 and A2*/
				 it=channels.iterator();
				 if(it.hasNext()){
					 _Channel channel=it.next();
					 UPIS w1=channel.getProduce(), w2=channel.getConsume(); 
					 int l2=w1.getPeriodLength(), h2=w2.getPeriodLength();		 
					 int sum_w1=w1.getSumPeriod(), sum_w2=w2.getSumPeriod();	 
					 _AffineRelation rtemp=(dataflowGraph.getEdgeSource(channel)==A1)?new _AffineRelation(sum_w1*h2,_AffineRelation.UNDEFINED,sum_w2*l2):
						                                                              new _AffineRelation(sum_w2*l2,_AffineRelation.UNDEFINED,sum_w1*h2);
					 if(A1.getID()>A2.getID()) rtemp=rtemp.getReverse();
					 r1=rtemp; //r1 is computed using the boundedness criterion
				 }
			 }
		 }
		 else{
			 _AffineRelation rtemp=new _AffineRelation((int)A1.getPeriod(),_AffineRelation.UNDEFINED,(int)A2.getPeriod()); 
			 if(A1.getID()>A2.getID()) rtemp=rtemp.getReverse();
			 if(affineRelationGM.containsKey(key)){
				 AffineRelation R2=affineRelationGM.getValue(key);
				 _AffineRelation r2=create_AffineRelation(R2); if(A1.getID()>A2.getID()) r2=r2.getReverse();
				 if(!r2.isConsistentWith(rtemp)){
					 r1=rtemp; 
					 //Display ERROR on the affine relation
					 String errorStr="The provided affine relation is inconsistent with the provided periods of actors "+A1.getName()+" and "+ A2.getName();
					 updateGraphDiagnostic(R2, errorStr,"Dynamic checking");
				 }
				 else{ 
					 r1=r2;
					 //Display OK on the affine relation
					 updateGraphDiagnostic(R2, "","Dynamic checking");
				 }
			 }
			 else{ r1=rtemp; }
		 }
		 /* check all edges between A1 and A2 */
		 it=channels.iterator();
		 while(it.hasNext()){
			 _Channel channel=it.next();
			 recheckConsistency_OneChannel(channel, r1);
		 }
			 
		 if(r1!=null){
			 affineGraph.addEdge(A1, A2,r1);
			 if(applicationGraph.isLoaded() && (ar==null || !r1.isConsistentWith(ar))){
				 checkConsistency_Cycles();
			 }
		 }
		 else if(ar!=null && applicationGraph.isLoaded()){
			 checkConsistency_Cycles();
		 }
	 }
	 
	 /**
	  * check boundedness of one channel
	  */
	 private void recheckConsistency_OneChannel(_Channel channel, _AffineRelation r1){
		
		 Channel modelChannel=channelGM.getValue(channel);
		 UPIS w1=channel.getProduce(), w2=channel.getConsume(); 
		 int l2=w1.getPeriodLength(), h2=w2.getPeriodLength();
		 int sum_w1=w1.getSumPeriod(), sum_w2=w2.getSumPeriod();
			 
		 _Actor A1=dataflowGraph.getEdgeSource(channel), A2=dataflowGraph.getEdgeTarget(channel);
		 int n=(A1.getID()<A2.getID())?r1.getN():r1.getD(), d=(A1.getID()<A2.getID())?r1.getD():r1.getN();
			 
		 String key=(A1.getID()<A2.getID())?A1.getID()+":"+A2.getID():A2.getID()+":"+A1.getID();
			 
		 //Boundedness test 
		 if((((double)sum_w1*h2)/(sum_w2*l2))!=((double)n/d)){ 
			 /* boundedness not satisfied. report this problem graphically. */
			 String errorStr="";
			 if(A1.getPeriod()!=_Actor.UNDEFINED && A2.getPeriod()!=_Actor.UNDEFINED){
				 errorStr+=" due to the provided periods of actors "+A1.getName()+" and "+ A2.getName()+".";
			 }
			 else if(affineRelationGM.containsKey(key)){ 
				 AffineRelation R2=affineRelationGM.getValue(key);
				 errorStr+=" due to the provided ("+R2.getN()+",*,"+R2.getD()+")-affine relation between actors "+A1.getName()+" and "+ A2.getName()+".";
			 } 
			 else  errorStr+=" due to other channels betwen actors "+A1.getName()+" and "+ A2.getName()+".";
			 r1.setIncorrect();
			 errorStr="Unbounded channel: "+errorStr;
			 //Display ERROR
			 updateGraphDiagnostic(modelChannel, errorStr,"Dynamic checking");		 
		 }
		 else if(r1.getPhi()!=_AffineRelation.UNDEFINED){ 
			 /*do size and initial verification */
			 int ok=bufferSize(channel, A1, A2,new _AffineRelation(r1.getN(), r1.getPhi(), r1.getD()));
			 if(ok==0){
				 /*if all it's OK*/
				 modelChannel.setInitial(channel.getInitial()); 
				 modelChannel.setSize(channel.getSize()); 
				 //Display OK
				 updateGraphDiagnostic(modelChannel, "","Dynamic checking");	
			 }
			 else if(ok==1){
				 r1.setIncorrect();
				 String errorStr="The provided number of initial tokens ("+channel.getInitial()+") cannot prevent underflow exceptions."; /* problem in the specified number of initial tokens*/
				 //Display ERROR
				 updateGraphDiagnostic(modelChannel, errorStr,"Dynamic checking");	
			 }
			 else{
				 r1.setIncorrect();
				 String errorStr="The provided size ("+channel.getSize()+") cannot prevent overflows exceptions.";
				 //Display ERROR
				 updateGraphDiagnostic(modelChannel, errorStr,"Dynamic checking");	
			 }
		 }
		 else{ 
			 //Display OK
			 updateGraphDiagnostic(modelChannel, "","Dynamic checking");
		 }
	 }
	 
	 /**
	  * Dyanamic checking of cycles
	  */
	 private Set<List<_AffineRelation>> CycleBasis;
	 
	 private void constructCycleBasis(){
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
	 
	 private boolean cycleBoundedness(List<_AffineRelation> cycle){
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
		 if(mulN!=mulD) return false;
		 else return true;
	 }
	 
	 private void checkConsistency_Cycles(){
		 String errorStr="";
		 constructCycleBasis();
		 int i=1;
		 for(List<_AffineRelation> cycle:CycleBasis){
			 if(!cycleBoundedness(cycle)){
				 errorStr="["+i+"]  ";
				 for(_AffineRelation edge:cycle){
					 _Actor A1=affineGraph.getEdgeSource(edge), A2=affineGraph.getEdgeTarget(edge); 
					 errorStr+=A1.getName()+" --> "+A2.getName()+"; ";
				 }
				 errorStr+="\n";
				 i++;
			 }
		 }
		 if(!errorStr.equals("")) errorStr="Inconsistent cycles:\n"+errorStr;
		 updateGraphDiagnostic(applicationGraph, errorStr,"Dynamic checking");	
	 }
//==========================================================================================================================================
//														Diagnostic management
//==========================================================================================================================================
	 
	 private BasicDiagnostic graphDiagnostic=null;
	 
	 public BasicDiagnostic getGraphDiagnostic(){
		 return graphDiagnostic;
	 }
	 
	 public void updateGraphDiagnostic(Object element, String message, String phase){
		 List<Diagnostic> children=(graphDiagnostic==null)?new ArrayList<Diagnostic>() :graphDiagnostic.getChildren();
		 graphDiagnostic=new BasicDiagnostic(Diagnostic.OK,phase,0,"", new Object[]{applicationGraph});
		 for(Diagnostic child:children){
			 if(child.getData().get(0)!=element) graphDiagnostic.add(child);
		 }
		 if(!message.equals("")){
			 BasicDiagnostic newChild=new BasicDiagnostic(Diagnostic.ERROR,phase,0,message, new Object[]{element});
			graphDiagnostic.add(newChild);
		 }
	 }
//==========================================================================================================================================
//                                               Static construction of the graph of affine relations
//==========================================================================================================================================
	 /**
	  * construct the hole affine graph (not step by step). 
	  */
	 public void constructAffineGraph(){
		 affineGraph=new SimpleGraph<_Actor, _AffineRelation>(_AffineRelation.class);
		 Iterator<_Actor> it1=dataflowGraph.vertexSet().iterator();
		 while(it1.hasNext()){
			 affineGraph.addVertex(it1.next());
		 }
		 it1=dataflowGraph.vertexSet().iterator();
		 while(it1.hasNext()){
			 _Actor A1=it1.next();
			 Iterator<_Actor> it2=dataflowGraph.vertexSet().iterator();
			 while (it2.hasNext()){
				 _Actor A2=it2.next();
				 if(A1.getID()>=A2.getID()) continue;
				 recheckConsistency(A1,A2);
			 }
		 }
	 }
	 
//=========================================================================================================================================
//                                             Computation of Buffer size and number of initial tokens 
//=========================================================================================================================================	 

	 public static int bufferSize(_Channel edge, _Actor src, _Actor dest, _AffineRelation r){
			UPIS prate= edge.getProduce(), crate=edge.getConsume();
			Pair<UPIS> encoding=r.binaryEncoding();
			Pair<UPIS> hyperEncoding=UPIS.hyperPeriod(encoding.getFirst(), encoding.getSecond(), prate, crate);
			UPIS produce=hyperEncoding.getFirst().distributOver(prate), consume=hyperEncoding.getSecond().distributOver(crate);
			UPIS pClock=hyperEncoding.getFirst(), cClock=hyperEncoding.getSecond();
			if(onSameProcessor(src,dest)){
				/* underflow analysis */
				int minSize=0, c=1;
				while(c<=cClock.getLength()){
					if(cClock.elementAt(c)==1){
						int p=0;
						if(pClock.elementAt(c)==1){
							if(src.getPriority()<dest.getPriority()) p=c; else p=c-1;
						}
						else{
							if(src.getPriority()<dest.getPriority()) p=c-1;
							else{
								p=c-1; 
								while(p>1) if(pClock.elementAt(p)==1) {p--; break;} else p--;
							}
						}
						int inBuffer=produce.getCumulative(p)-consume.getCumulative(c);
						if(minSize>inBuffer) minSize=inBuffer;
					}
					c++;
				}
				int initial=Math.abs(minSize);
				if(edge.getInitial()==_Channel.UNDEFINED) edge.setInitial(initial); 
				else 
					if(initial>edge.getInitial()) return 1; //the number of initial tokens is not enough: a risk of an underflow.
					//else edge.setInitial(initial); 
				
				/* overflow analysis */
				int maxSize=initial; int p=1;
				while(p<=pClock.getLength()){
					if(pClock.elementAt(p)==1){
						c=0;
						if(cClock.elementAt(p)==1){
							if(src.getPriority()<dest.getPriority()) c=p-1; else c=p;
						}
						else{
							if(src.getPriority()<dest.getPriority()){
								c=p-1; 
								while(c>1) if(cClock.elementAt(c)==1) {c--; break;} else c--;
							}
							else c=p-1;
						}
						int inBuffer=initial+produce.getCumulative(p)-consume.getCumulative(c);
						if(maxSize<inBuffer) maxSize=inBuffer;
					}
					p++;
				}
				if(edge.getSize()==_Channel.UNDEFINED) edge.setSize(maxSize); 
				else 
					if(maxSize>edge.getSize()) return 2; //there size given by the programmer is not enough: there is a risk of overflow.
					//else edge.setSize(maxSize); 
			}
			else{
				/* edge crossing processors */
				int minSize=0, c=1;
				while(c<=cClock.getLength()){
					if(cClock.elementAt(c)==1){
						int p=0;
						if(pClock.elementAt(c)==1){ p=c-1; }
						else{
							p=c-1; 
							while(p>1) if(pClock.elementAt(p)==1) {p--; break;} else p--;
						}
						int inBuffer=produce.getCumulative(p)-consume.getCumulative(c);
						if(minSize>inBuffer) minSize=inBuffer;
					}
					c++;
				}
				int initial=Math.abs(minSize);
				if(edge.getInitial()==_Channel.UNDEFINED) edge.setInitial(initial); 
				else 
					if(initial>edge.getInitial()) return 1; //the number of initial tokens is not enough: a risk of an underflow.
					//else edge.setInitial(initial);
				
				int maxSize=initial; int p=1;
				while(p<=pClock.getLength()){
					if(pClock.elementAt(p)==1){
						c=0;
						if(cClock.elementAt(p)==1){ c=p-1; }
						else{
							c=p-1; 
							while(c>1) if(cClock.elementAt(c)==1) {c--; break;} else c--;
						}
						int inBuffer=initial+produce.getCumulative(p)-consume.getCumulative(c);
						if(maxSize<inBuffer) maxSize=inBuffer;
					}
					p++;
				}
				if(edge.getSize()==_Channel.UNDEFINED) edge.setSize(maxSize); 
				else 
					if(maxSize>edge.getSize()) return 2; //there size given by the programmer is not enough: there is a risk of overflow.
					//else edge.setSize(maxSize); 
			}
			return 0;
		}

//=========================================================================================================================================
//   					Affine Relation Synthesis and symbolic schedulability analysis
//=========================================================================================================================================	 

	Analysis analysis=null;
	
	public Analysis getAnalysis(){ return analysis;}

	public void analyze(){
		setScheduleType(applicationGraph.getOwner().getSchedulingAlgorithm()); 
		nbProcessor=applicationGraph.getOwner().getNbProcessors();
		if(!applicationGraph.getOwner().isDynamicChecking()) constructAffineGraph();
		analysis =new Analysis(this);
		analysis.perform();
   }
	

}
