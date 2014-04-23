
package adfg.provider.custom.propertydescriptors;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;


/**
 * A CellEditor that opens the "Find type" dialog to complete class selection
 */
public class ClassSelectingEditor extends DialogCellEditor {
	
	private static IJavaProject javaProject;
	private static IType baseType;
	
	static {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor =page.getActiveEditor(); 
		IEditorInput input = editor.getEditorInput(); 
		if (input instanceof IFileEditorInput){
			IFile file= ((IFileEditorInput)input).getFile(); 
			javaProject=JavaCore.create(file.getProject());
			try {
				baseType = javaProject.findType("scj.adfg.Capsule");
			} catch (JavaModelException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
     * Pass through constructor
     */
    public ClassSelectingEditor(Composite parent) {
       super(parent);
    }

    // @see org.eclipse.jface.viewers.DialogCellEditor#createButton(org.eclipse.swt.widgets.Composite)
    protected Button createButton(Composite parent) {
       Button button = super.createButton(parent);
       button.setText("Select");
       return button;
    }

    // @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
    protected Object openDialogBox(Control cellEditorWindow) {
    	SelectionDialog dialog;
    	if(baseType!=null){
    		try { 
    			dialog = JavaUI.createTypeDialog(
    					cellEditorWindow.getShell(), 
    					new ProgressMonitorDialog(null),
    					SearchEngine.createStrictHierarchyScope(javaProject, baseType, true, true, null),
    					IJavaElementSearchConstants.CONSIDER_CLASSES, false,"*.class");
    		} catch (JavaModelException e) {
    			return null;
    		}
    		dialog.setTitle("Class selection");
    		dialog.setMessage("Select a class");
    		if (dialog.open() == IDialogConstants.CANCEL_ID)
    			return null;
    		Object[] types= dialog.getResult();
    		if (types == null || types.length == 0)
    			return null; 
    		if(((IType)types[0]).isBinary()){
    			try {
    				URLClassLoader loader=getClassLoader(javaProject);
    				try {
    					Class<?> clazz = loader.loadClass(((IType)types[0]).getFullyQualifiedName());
    					return clazz;
    				} catch (ClassNotFoundException e) { e.printStackTrace(); } 
    			} catch (MalformedURLException e) { e.printStackTrace(); } catch (CoreException e) { e.printStackTrace(); } 
    		}
    	}	
    	return null;
     }
     
     private URLClassLoader getClassLoader(IJavaProject project) throws CoreException, MalformedURLException{
    	 String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(project);
    	 List<URL> urlList = new ArrayList<URL>();
    	 for (int i = 0; i < classPathEntries.length; i++) {
    		 String entry = classPathEntries[i];
    		 IPath path = new Path(entry);
    		 URL url = path.toFile().toURI().toURL();
    		 urlList.add(url);
    	 }
    	 ClassLoader parentClassLoader = project.getClass().getClassLoader();
    	 URL[] urls = (URL[]) urlList.toArray(new URL[urlList.size()]);
    	 URLClassLoader classLoader = new URLClassLoader(urls, parentClassLoader);
    	 return classLoader;
     }
}
