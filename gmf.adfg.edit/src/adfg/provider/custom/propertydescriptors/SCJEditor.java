package adfg.provider.custom.propertydescriptors;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;

import acceleo.adfg.generate.GenerateAperiodicActor;
import acceleo.adfg.generate.GenerateApplication;
import acceleo.adfg.generate.GenerateGraph;
import acceleo.adfg.generate.GeneratePeriodicActor;
import adfg.Actor;
import adfg.AperiodicActor;
import adfg.Application;
import adfg.Graph;
import adfg.PeriodicActor;




public class SCJEditor extends ExtendedDialogCellEditor {
	
	Object node;
	
	public SCJEditor(Composite composite, ILabelProvider labelProvider, Object node) {
		super(composite, labelProvider);
		this.node=node;
	}
	
	@Override
    protected Button createButton(Composite parent) {
       Button button = super.createButton(parent);
       button.setText("Change");
       return button;
    }

    /** Remember actual value last set for use in some dialogs */
    private Object lastValue;
    
	
	protected void doSetValue(Object value) {
		super.doSetValue(value);
	    lastValue = value;
	}
	
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		String[] buttonLabels = new String[] {"Regenerate", "Edit","Cancel"};
	    String promptMessage = "You can either regenerate the interface from the model or edit the existing SCJ code";
	    MessageDialog prompt = new MessageDialog(cellEditorWindow.getShell(), "Edit SCJ code", null, promptMessage, MessageDialog.QUESTION, buttonLabels, 0);
	    int choice = prompt.open();
	    if(choice==0 || choice==1){
	    	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	     	IEditorPart editor =page.getActiveEditor();
	     	if(editor instanceof DiagramDocumentEditor)
				((DiagramDocumentEditor)editor).doSave(new NullProgressMonitor());
	     	IEditorInput input = editor.getEditorInput();
	     	if (!(input instanceof IFileEditorInput))
	            return lastValue;
	     	IFile file= ((IFileEditorInput)input).getFile();
	     	String nameFile="";
	     	if(node instanceof Actor){
	     		Actor actor=(Actor)node;
	     		nameFile="/src/"+actor.getOwner().getOwner().getName().toLowerCase()+"/"+actor.getOwner().getName().toLowerCase()+"/"+actor.getName().substring(0,1).toUpperCase()+actor.getName().substring(1)+".java";
	     	}
	     	else if(node instanceof Graph){
	     		Graph graph=(Graph)node;
	     		nameFile="/src/"+graph.getOwner().getName().toLowerCase()+"/"+graph.getName().toLowerCase()+"/"+graph.getName().substring(0,1).toUpperCase()+graph.getName().substring(1)+".java";
	     	}
	     	else if(node instanceof Application){
	     		Application application=(Application)node;
	     		nameFile="/src/"+application.getName().toLowerCase()+"/"+application.getName().substring(0,1).toUpperCase()+application.getName().substring(1)+".java";
	     	}
	     		
	     	File f=new File(file.getProject().getLocation()+nameFile);
	     	boolean refresh=false;
	     	if(!f.exists() || choice==0){
	        	//acceleo generation
	     		try {
	     			if(node instanceof PeriodicActor){
	     				GeneratePeriodicActor generator = new GeneratePeriodicActor((PeriodicActor)node, new File(file.getProject().getLocation().toString()+"/src"), new ArrayList<String>());
		     			generator.doGenerate(BasicMonitor.toMonitor(new NullProgressMonitor()));
	     			}
	     			else if(node instanceof AperiodicActor){
	     				GenerateAperiodicActor generator = new GenerateAperiodicActor((AperiodicActor)node, new File(file.getProject().getLocation().toString()+"/src"), new ArrayList<String>());
		     			generator.doGenerate(BasicMonitor.toMonitor(new NullProgressMonitor()));
	     			}
	     			else if(node instanceof Graph){
	     				GenerateGraph generator = new GenerateGraph((Graph)node, new File(file.getProject().getLocation().toString()+"/src"), new ArrayList<String>());
		     			generator.doGenerate(BasicMonitor.toMonitor(new NullProgressMonitor()));
	     			}
	     			else if(node instanceof Application){
	     				GenerateApplication generator = new GenerateApplication((Application)node, new File(file.getProject().getLocation().toString()+"/src"), new ArrayList<String>());
		     			generator.doGenerate(BasicMonitor.toMonitor(new NullProgressMonitor()));
	     			}
	     			
	     			refresh=true;
	     		} catch (IOException e) { e.printStackTrace(); }
	        }
	     	if(refresh){
	     		try {
	     			file.getProject().refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
	     		} catch (CoreException e1) { e1.printStackTrace();}
	     	}
	     	 Path path = new Path(file.getProject().getName()+nameFile);
    		 IFile fileOpen = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    		 IEditorDescriptor desc = PlatformUI.getWorkbench().
    				 getEditorRegistry().getDefaultEditor(fileOpen.getName());
    		 try {
    			 page.openEditor(new FileEditorInput(fileOpen), desc.getId());
    			 return fileOpen.getProjectRelativePath().toString();
    		 } catch (PartInitException e) { e.printStackTrace();}
	 
	         return lastValue;	  	
	    }
	    else{
	        /* cancel */
	    	return lastValue;
	    }
	}

}
