package adfg.diagram.part.adfgActions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import acceleo.adfg.generate.GenerateAperiodicActor;
import acceleo.adfg.generate.GenerateApplication;
import acceleo.adfg.generate.GenerateGraph;
import acceleo.adfg.generate.GeneratePeriodicActor;
import adfg.Actor;
import adfg.AdfgPackage;
import adfg.Connection;
import adfg.Graph;
import adfg.diagram.edit.parts.AperiodicActorEditPart;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.ChannelEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.edit.parts.PeriodicActorEditPart;
import adfg.diagram.part.AdfgDiagramEditor;
import adfg.impl.AperiodicActorImpl;
import adfg.impl.ApplicationImpl;
import adfg.impl.ChannelImpl;
import adfg.impl.GraphImpl;
import adfg.impl.PeriodicActorImpl;

public class ResetAction extends SelectionAction {
	public static final String Reset_Action = "ResetAction";

	public ResetAction(IWorkbenchPart part) {
		super(part);
		setId(Reset_Action);
		setText("Reset properties");
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty()) {
            return false;
        }
        for(Object selectedObject : getSelectedObjects()) {
            if(!(selectedObject instanceof ApplicationEditPart || selectedObject instanceof GraphEditPart || 
            	selectedObject instanceof PeriodicActorEditPart || selectedObject instanceof AperiodicActorEditPart ||
            	selectedObject instanceof ChannelEditPart)) {
                return false;
            }
        }
        return true;
	}
	
	@Override
	public void run() {
		 AdfgDiagramEditor editor=(AdfgDiagramEditor)getWorkbenchPart();
		 editor.doSave(new NullProgressMonitor());		 
		 IRunnableWithProgress operation = new IRunnableWithProgress() {
			 public void run(IProgressMonitor monitor) {
				 for(Object selectedObject : getSelectedObjects()) {
						resetProperties(selectedObject);
				 }
			 }		 	 
		 };
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
		} catch (InvocationTargetException e) { e.printStackTrace(); } catch (InterruptedException e) { e.printStackTrace();}
	}
	
	private void resetProperties(Object object){
		if(object instanceof ChannelEditPart){
			ChannelImpl channel = (ChannelImpl) ((ChannelEditPart)object).resolveSemanticElement();
			restPropertiesChannel(channel);
		}
		else if(object instanceof PeriodicActorEditPart){
			PeriodicActorImpl actor=(PeriodicActorImpl) ((PeriodicActorEditPart)object).resolveSemanticElement();
			resetPropertiesPeriodicActor(actor);
		}
		else if(object instanceof AperiodicActorEditPart){
			AperiodicActorImpl actor=(AperiodicActorImpl) ((AperiodicActorEditPart)object).resolveSemanticElement();
			resetPropertiesAperiodicActor(actor);
		}
		else if(object instanceof GraphEditPart){
			GraphImpl graph = (GraphImpl) ((GraphEditPart)object).resolveSemanticElement();
			resetPropertiesGraph(graph);
		}
		else if(object instanceof ApplicationEditPart){
			ApplicationImpl application = (ApplicationImpl) ((ApplicationEditPart)object).resolveSemanticElement();
			for(Graph graph:application.getGraphs()) resetPropertiesGraph((GraphImpl)graph);
		}
		
	}
	
	private void restPropertiesChannel(ChannelImpl channel){
		//initial
		TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(channel);
    	SetRequest setRequest = new SetRequest(domain, channel, AdfgPackage.eINSTANCE.getChannel_Initial(), -1);
    	setRequest.setParameter("oldValue", channel.getInitial());
    	SetValueCommand operation = new SetValueCommand(setRequest){     		    
 		   @Override
 		   protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
 			  ((ChannelImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.CHANNEL__INITIAL,((SetRequest)this.getRequest()).getValue());
 			  return CommandResult.newOKCommandResult();
 		   } 
        };
    	ICommandProxy comm = new ICommandProxy(operation);
    	comm.execute();
    	//size
    	setRequest = new SetRequest(domain, channel, AdfgPackage.eINSTANCE.getConnection_Size(), -1);
    	setRequest.setParameter("oldValue", channel.getSize());
    	operation = new SetValueCommand(setRequest){     		    
 		   @Override
 		   protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
 			   ((ChannelImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.CHANNEL__SIZE,((SetRequest)this.getRequest()).getValue());
 			  return CommandResult.newOKCommandResult();
 		   } 
        };
    	comm = new ICommandProxy(operation);
    	comm.execute();
	}
	
	private void resetPropertiesPeriodicActor(PeriodicActorImpl pactor){
		//period
		TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(pactor);
		SetRequest setRequest = new SetRequest(domain, pactor, AdfgPackage.eINSTANCE.getPeriodicActor_Period(), -1L);
		setRequest.setParameter("oldValue", pactor.getPeriod());
		SetValueCommand operation = new SetValueCommand(setRequest){     		    
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.PERIODIC_ACTOR__PERIOD,((SetRequest)this.getRequest()).getValue());
				return CommandResult.newOKCommandResult();
			} 
		};
		ICommandProxy comm = new ICommandProxy(operation);
		comm.execute();
		
		//phase	
		setRequest = new SetRequest(domain, pactor, AdfgPackage.eINSTANCE.getPeriodicActor_Phase(), -1L);
		setRequest.setParameter("oldValue", pactor.getPhase());
		operation = new SetValueCommand(setRequest){     		    
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.PERIODIC_ACTOR__PHASE,((SetRequest)this.getRequest()).getValue());
				return CommandResult.newOKCommandResult();
			} 
		};
		comm = new ICommandProxy(operation);
		comm.execute();
		
		//priority
		setRequest = new SetRequest(domain, pactor, AdfgPackage.eINSTANCE.getActor_Priority(), 0);
		setRequest.setParameter("oldValue", pactor.getPriority());
		operation = new SetValueCommand(setRequest){     		    
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PRIORITY,((SetRequest)this.getRequest()).getValue());
				return CommandResult.newOKCommandResult();
			} 
		};
		comm = new ICommandProxy(operation);
		comm.execute();
		
		//processor allocaction
		setRequest = new SetRequest(domain, pactor, AdfgPackage.eINSTANCE.getActor_ProcNumber(),0);
		setRequest.setParameter("oldValue", pactor.getProcNumber());
		operation = new SetValueCommand(setRequest){     		    
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((PeriodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PROC_NUMBER,((SetRequest)this.getRequest()).getValue());
				return CommandResult.newOKCommandResult();
			} 
		};
		comm = new ICommandProxy(operation);
		comm.execute();
	}

	private void resetPropertiesAperiodicActor(AperiodicActorImpl apactor){
		//priority
		TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(apactor);
		SetRequest setRequest = new SetRequest(domain, apactor, AdfgPackage.eINSTANCE.getActor_Priority(),0);
		setRequest.setParameter("oldValue", apactor.getPriority());
		SetValueCommand operation = new SetValueCommand(setRequest){     		    
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((AperiodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PRIORITY,((SetRequest)this.getRequest()).getValue());
				return CommandResult.newOKCommandResult();
			} 
		};
		ICommandProxy comm = new ICommandProxy(operation);
		comm.execute();
		
		//processor allocation
		setRequest = new SetRequest(domain, apactor, AdfgPackage.eINSTANCE.getActor_ProcNumber(),0);
		setRequest.setParameter("oldValue", apactor.getProcNumber());
		operation = new SetValueCommand(setRequest){     		    
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((AperiodicActorImpl)((SetRequest)this.getRequest()).getElementToEdit()).eSet(AdfgPackage.ACTOR__PROC_NUMBER,((SetRequest)this.getRequest()).getValue());
				return CommandResult.newOKCommandResult();
			} 
		};
		comm = new ICommandProxy(operation);
		comm.execute();	
	}
	
	private void resetPropertiesGraph(GraphImpl graph){
		for(Connection connection: graph.getConnections()){
			if(connection instanceof ChannelImpl) restPropertiesChannel((ChannelImpl)connection);
		}
		for(Actor actor:graph.getNodes()){
			if(actor instanceof PeriodicActorImpl) resetPropertiesPeriodicActor((PeriodicActorImpl)actor);
			else resetPropertiesAperiodicActor((AperiodicActorImpl)actor);
		}
	}
}