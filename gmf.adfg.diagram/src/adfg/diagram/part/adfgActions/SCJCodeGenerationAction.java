package adfg.diagram.part.adfgActions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import acceleo.adfg.generate.GenerateAperiodicActor;
import acceleo.adfg.generate.GenerateApplication;
import acceleo.adfg.generate.GenerateGraph;
import acceleo.adfg.generate.GeneratePeriodicActor;
import adfg.diagram.edit.parts.AperiodicActorEditPart;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.edit.parts.PeriodicActorEditPart;
import adfg.diagram.part.AdfgDiagramEditor;
import adfg.impl.AperiodicActorImpl;
import adfg.impl.ApplicationImpl;
import adfg.impl.GraphImpl;
import adfg.impl.PeriodicActorImpl;

import org.eclipse.ui.IFileEditorInput;;

public class SCJCodeGenerationAction extends SelectionAction{
	
	public static final String SCJ_Code_Generation = "SCJCodeGeneration";

	public SCJCodeGenerationAction(IWorkbenchPart part) {
		super(part);
		setId(SCJ_Code_Generation);
		setText("Generate SCJ code");
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty()) {
            return false;
        }
        for(Object selectedObject : getSelectedObjects()) {
            if(!(selectedObject instanceof ApplicationEditPart || selectedObject instanceof GraphEditPart || selectedObject instanceof PeriodicActorEditPart || selectedObject instanceof AperiodicActorEditPart)) {
                return false;
            }
        }
        return true;
	}
	
	@Override
	public void run() {
		 AdfgDiagramEditor editor=(AdfgDiagramEditor)getWorkbenchPart();
		 editor.doSave(new NullProgressMonitor());
		 IFileEditorInput input = (IFileEditorInput)editor.getEditorInput();
		 final IProject project=input.getFile().getProject();
		 final String pathToProject=project.getLocation().toString();
		 
		 IRunnableWithProgress operation = new IRunnableWithProgress() {
			 public void run(IProgressMonitor monitor) {
				 try {
					 for(Object selectedObject : getSelectedObjects()) {
						 if(selectedObject instanceof ApplicationEditPart){
							 ApplicationImpl application = (ApplicationImpl) ((ApplicationEditPart)selectedObject).resolveSemanticElement();
				             GenerateApplication generator = new GenerateApplication(application, new File(pathToProject+"/src"), new ArrayList<String>());
							 generator.doGenerate(BasicMonitor.toMonitor(monitor));
						 }
						 else if(selectedObject instanceof GraphEditPart) {
							 GraphImpl graph = (GraphImpl) ((GraphEditPart)selectedObject).resolveSemanticElement();
				             GenerateGraph generator = new GenerateGraph(graph, new File(pathToProject+"/src"), new ArrayList<String>());
							 generator.doGenerate(BasicMonitor.toMonitor(monitor));
				         }
						 else if(selectedObject instanceof PeriodicActorEditPart){
							 PeriodicActorImpl actor=(PeriodicActorImpl) ((PeriodicActorEditPart)selectedObject).resolveSemanticElement();
							 GeneratePeriodicActor generator= new GeneratePeriodicActor(actor, new File(pathToProject+"/src"), new ArrayList<String>());
							 generator.doGenerate(BasicMonitor.toMonitor(monitor));
						 }
						 else if(selectedObject instanceof AperiodicActorEditPart){
							 AperiodicActorImpl actor=(AperiodicActorImpl) ((AperiodicActorEditPart)selectedObject).resolveSemanticElement();
							 GenerateAperiodicActor generator= new GenerateAperiodicActor(actor, new File(pathToProject+"/src"), new ArrayList<String>());
							 generator.doGenerate(BasicMonitor.toMonitor(monitor));
						 }
				     }
				 
				 } catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
				 } finally {
					 try {
						project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
			 }		 	 
		 };
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
