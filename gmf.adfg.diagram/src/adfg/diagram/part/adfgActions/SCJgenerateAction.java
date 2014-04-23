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
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;

import acceleo.adfg.generate.GenerateAll;
import adfg.diagram.part.AdfgDiagramEditor;
import adfg.diagram.part.AdfgDiagramEditorPlugin;
import adfg.impl.ApplicationImpl;

public class SCJgenerateAction extends Action {

	public static final String SCJgenerateActionMessage="Generate SCJ code";
	
	private IWorkbenchPage page;

	public SCJgenerateAction(IWorkbenchPage page) {
		setText(SCJgenerateActionMessage);
		this.page = page;
	}
	
	public void run() {
		IWorkbenchPart workbenchPart = page.getActivePart();
		if (workbenchPart instanceof IDiagramWorkbenchPart) {
			final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;
			if(part instanceof AdfgDiagramEditor)
				((AdfgDiagramEditor)part).doSave(new NullProgressMonitor());
			try {
				new WorkspaceModifyDelegatingOperation(
						new IRunnableWithProgress() {

							public void run(IProgressMonitor monitor)
									throws InterruptedException,
									InvocationTargetException {
								runSCJgenerate(part.getDiagramEditPart(),
										part.getDiagram());
							}
						}).run(new NullProgressMonitor());
			} catch (Exception e) {
				AdfgDiagramEditorPlugin.getInstance().logError(
						"SCJ generate action failed", e); //$NON-NLS-1$
			}
		}
	}
	
	public  void runSCJgenerate(DiagramEditPart diagramEditPart, View view) {
		final ApplicationImpl application=(ApplicationImpl)view.getElement();
		//TODO validation test
	
		//SCJ code generation
		AdfgDiagramEditor editor=(AdfgDiagramEditor)page.getActiveEditor(); 
		IFileEditorInput input = (IFileEditorInput)editor.getEditorInput();
		final IProject project=input.getFile().getProject(); 
		final String pathToProject=project.getLocation().toString(); 
			 
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			 public void run(IProgressMonitor monitor) {
				 try {
					 GenerateAll generator=new GenerateAll(application, new File(pathToProject+"/src"), new ArrayList<String>());
					 generator.doGenerate(BasicMonitor.toMonitor(monitor));
				 } catch (IOException e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
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
		finally {
			 try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	
}
