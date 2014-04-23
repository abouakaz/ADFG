package project.adfg.builder;

import org.eclipse.core.runtime.IStatus;

import project.adfg.Activator;


public class AdfgErrorStatus implements IStatus {
	
    private String message;

    public AdfgErrorStatus(String message) {
        this.message = message;
    }

    @Override
    public IStatus[] getChildren() {
        return new IStatus[] {};
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public Throwable getException() {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getPlugin() {
        return Activator.PLUGIN_ID;
    }

    @Override
    public int getSeverity() {
        return IStatus.ERROR;
    }

    @Override
    public boolean isMultiStatus() {
        return false;
    }

    @Override
    public boolean isOK() {
        return false;
    }

    @Override
    public boolean matches(int severityMask) {
        return (severityMask & IStatus.ERROR) != 0;
    }
}