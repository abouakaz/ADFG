package checkers.eclipse.actions;


public class CheckerActions
{
    private CheckerActions()
    {
        throw new AssertionError("not to be instantiated");
    }

    public static class CurrentAction extends RunCheckerAction
    {
        public CurrentAction()
        {
            super();
        }
    }

    public static class SCJAnnotationAction extends RunCheckerAction
    {
        public SCJAnnotationAction()
        { 
            super(CheckerInfo.SCJANNOTATION_CLASS);
            
        }
    }

    public static class CustomAction extends RunCheckerAction
    {
        public CustomAction()
        {
            useCustom = true;
            usePrefs = false;
        }
    }
}
