package checkers.eclipse.actions;


import checkers.SCJChecker;


/**
 * Stores information that describes a particular checker such as its label, the
 * class to run, or the quals path that is associate with it.
 * 
 * @author asumu
 * 
 */
public class CheckerInfo
{
    private final String label;
    private final Class<?> processor;
    private final String qualsPath;

    // Static information about built-in checkers
    public static final String SCJANNOTATION_LABEL = "SCJ annotation checker"; 
    public static final Class<?> SCJANNOTATION_CLASS = SCJChecker.class;
    public static final String SCJANNOTATION_QUALS = "javax.safetycritical.annotate.*";
    public static final CheckerInfo SCJANNOTATION_INFO = new CheckerInfo(
    		SCJANNOTATION_LABEL, SCJANNOTATION_CLASS, SCJANNOTATION_QUALS);

    /**
     * Sets the name and processor accordingly.
     * 
     * @param label
     * @param processor
     */
    CheckerInfo(String label, Class<?> processor, String qualsPath)
    {
        this.label = label;
        this.processor = processor;
        this.qualsPath = qualsPath;
    }

    /**
     * Gets the canonical class name for running the checker.
     * 
     * @return the class name
     */
    String getClassName()
    {
        return this.processor.getCanonicalName();
    }

    /**
     * Get the label for this checker.
     * 
     * @return the label name
     */
    String getLabel()
    {
        return this.label;
    }

    /**
     * Get the quals path for this checker.
     * 
     * @return the quals path
     */
    String getQualsPath()
    {
        return this.qualsPath;
    }
}
