package project.adfg.wizards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.wizards.JavaCapabilityConfigurationPage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.osgi.framework.Bundle;

import project.adfg.Activator;
import project.adfg.builder.AdfgErrorStatus;
import project.adfg.builder.AdfgNature;

public class NewADFGProjectWizard extends Wizard implements INewWizard {
	
	private static final String SCJ_LIB_LOCATION = "lib/scj.jar";
	
	private static final String SCJ_ADFG_LIB_LOCATION = "lib/scj-adfg.jar";
	
	private WizardNewProjectCreationPage mainPage;
	
	private JavaCapabilityConfigurationPage jccPage;
	
	private IWorkbench adfgWorkbench;
	
	private IConfigurationElement adfgConfigElement;
	
	
	public NewADFGProjectWizard() {
    	super();
        // set icon
        ImageDescriptor image = AbstractUIPlugin.imageDescriptorFromPlugin("project.adfg", "icons/projectIcon.png");
        setDefaultPageImageDescriptor(image);
        setNeedsProgressMonitor(true);
        setWindowTitle("New ADFG Project");
    }
	
	@Override
	public void addPages(){
		mainPage = new WizardNewProjectCreationPage("project");
        mainPage.setTitle("Create an ADFG Project");
        mainPage.setDescription("Create an ADFG Project in the Workspace or external location");
        addPage(mainPage);
        jccPage = new JavaCapabilityConfigurationPage() {
            public void setVisible(boolean visible) {
                updatePage();
                super.setVisible(visible);
            }
       };
       addPage(jccPage);
	}
	
	private void updatePage() {
    	IJavaProject jproject = JavaCore.create(mainPage.getProjectHandle());
        if (!jproject.equals(jccPage.getJavaProject())) {
        	IClasspathEntry[] buildPath = {
        			JavaCore.newSourceEntry(jproject.getPath().append("src")),
                    JavaRuntime.getDefaultJREContainerEntry() };
            IPath outputLocation = jproject.getPath().append("bin");
            jccPage.init(jproject, outputLocation, buildPath, false);
        }
    }

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		adfgWorkbench = workbench;
	}

	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
    		protected void execute(IProgressMonitor monitor) throws CoreException,InvocationTargetException, InterruptedException {
                 doFinish(monitor);
            }
        };
        try {
        	getContainer().run(false, true, op);
        } catch (InvocationTargetException e) {
            return false; // TODO: should open error dialog and log
        } catch (InterruptedException e) {
            return false; // canceled
        }
        return true;
	}
	
	private void doFinish(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
    	if (monitor == null) {
    		monitor = new NullProgressMonitor();
        }
    	IProject project = null;
    	try {
    		monitor.beginTask("Creating ADFG Project...", 3); // 3 steps
            project = mainPage.getProjectHandle();
            IPath locationPath = mainPage.getLocationPath();
            
            // create the project
            IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
            if (!mainPage.useDefaults()) {
            	desc.setLocation(locationPath);
            }
            project.create(desc, new SubProgressMonitor(monitor, 1));
            project.open(new SubProgressMonitor(monitor, 1));
        
            updatePage();
            
            jccPage.configureJavaProject(new SubProgressMonitor(monitor, 1));
                  
            /* Add scj-(adfg) libraries */
            addLibraries(JavaCore.create(mainPage.getProjectHandle()), new SubProgressMonitor(monitor, 1));
            
            /* Add the java and adfg nature */
            addNature(project, AdfgNature.NATURE_ID, new SubProgressMonitor(monitor, 1));
            
            // change to the perspective
            BasicNewProjectResourceWizard.updatePerspective(adfgConfigElement);
            BasicNewResourceWizard.selectAndReveal(project, adfgWorkbench.getActiveWorkbenchWindow());
            
            // create the directory for created diagrams
            project.getFolder("model").create(true, true, monitor);

        } catch (CoreException e) { e.printStackTrace();
        	StatusManager manager = StatusManager.getManager();
    		AdfgErrorStatus status = new AdfgErrorStatus("Error while creating ADFG project.");
    		manager.handle(status, StatusManager.SHOW);
            throw new InvocationTargetException(e);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new InvocationTargetException(t);
        } finally {
            monitor.done();
        }
    }
	
	/**
     * Add necessary plugins to the classpath
     */
    public static void addLibraries(IJavaProject javaProj, IProgressMonitor monitor) throws CoreException {
    	monitor.beginTask("Adding ADFG Libraries", 1);
    	try{
    		IProject project = javaProj.getProject(); 
        	IFile scjJarFile=project.getFile("scj.jar"), scj_adfgJarFile=project.getFile("scj-adfg.jar");
        	FileInputStream input;
        	try{
        		input = new FileInputStream(locatePluginFile(SCJ_LIB_LOCATION));
        		scjJarFile.create(input, false, null);
        	}catch (FileNotFoundException e) {
        		StatusManager manager = StatusManager.getManager();
        		AdfgErrorStatus status = new AdfgErrorStatus("Could not find scj.jar file.");
        		manager.handle(status, StatusManager.SHOW);
        	}catch (CoreException e) {
        		StatusManager manager = StatusManager.getManager();
        		AdfgErrorStatus status = new AdfgErrorStatus("Could not create scj.jar file in project.");
        		manager.handle(status, StatusManager.SHOW);
        	}
        	
        	try{
        		input = new FileInputStream(locatePluginFile(SCJ_ADFG_LIB_LOCATION));
        		scj_adfgJarFile.create(input, false, null);
        	}catch (FileNotFoundException e) {
        		StatusManager manager = StatusManager.getManager();
        		AdfgErrorStatus status = new AdfgErrorStatus("Could not find scj-adfg.jar file.");
        		manager.handle(status, StatusManager.SHOW);
        	}catch (CoreException e) {
        		StatusManager manager = StatusManager.getManager();
        		AdfgErrorStatus status = new AdfgErrorStatus("Could not create scj-adfg.jar file in project.");
        		manager.handle(status, StatusManager.SHOW);
        	}
        	
       
        		
        	try {
        		IClasspathEntry[] entries = javaProj.getRawClasspath();
        		IClasspathEntry[] newEntries = new IClasspathEntry[entries.length + 2];

        		System.arraycopy(entries, 0, newEntries, 0, entries.length);
        		IClasspathEntry javaEntry1 = JavaCore.newLibraryEntry(scjJarFile.getLocation(), null, null);
        		IClasspathEntry javaEntry2 = JavaCore.newLibraryEntry(scj_adfgJarFile.getLocation(), null, null);
        		newEntries[entries.length] = javaEntry1;
        		newEntries[entries.length+1] = javaEntry2;

        		javaProj.setRawClasspath(newEntries, null);
        	}catch (JavaModelException e) {
        		StatusManager manager = StatusManager.getManager();
        		AdfgErrorStatus status = new AdfgErrorStatus("Could not add scj(-adfg) library to project classpath.");
        		manager.handle(status, StatusManager.SHOW);
        	}
        	
        	String property = System.getProperty("java.library.path");
    		System.setProperty( "java.library.path", property+":"+project.getLocation()+"/lib/" );
    		try {
				Field  fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
				fieldSysPath.setAccessible( true );
	    		try { fieldSysPath.set(null,null); } catch (IllegalArgumentException e) { e.printStackTrace();} catch (IllegalAccessException e) { e.printStackTrace();}
			
    		} catch (SecurityException e1) { e1.printStackTrace(); } catch (NoSuchFieldException e1) { e1.printStackTrace(); }
    		property = System.getProperty("java.library.path");
    		StringTokenizer parser = new StringTokenizer(property, ";");
    		while (parser.hasMoreTokens()) {
    		    System.err.println(parser.nextToken());
    		}
    	} 
        finally {
            monitor.done();
        }
    }
    
    public static String locatePluginFile(String path) {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);

        Path fileJAR = new Path(path);
        URL fileJarURL;
        try {
            fileJarURL = FileLocator.toFileURL(FileLocator.find(bundle, fileJAR, null));
        }catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return fileJarURL.getPath();
    }
    
    /**
     * Adds the provided nature to the provided project
     * @param monitor
     * @throws CoreException
     */
	public static void addNature(IProject project, String nature, SubProgressMonitor monitor) throws CoreException {
      monitor.beginTask("Adding Nature", 1);
      
      IProjectDescription desc = project.getDescription();
      String[] natures = desc.getNatureIds();
      String[] newNatures = new String[natures.length + 1];
      System.arraycopy(natures, 0, newNatures, 0, natures.length);
      newNatures[newNatures.length - 1] = AdfgNature.NATURE_ID;
      desc.setNatureIds(newNatures);
      project.setDescription(desc, monitor);
      project.getNature(nature).configure();
      
      monitor.done();
    }

}
