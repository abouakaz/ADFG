package checkers.eclipse.marker;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution2;

public class TypeResolution implements IMarkerResolution2
{

    @Override
    public String getLabel()
    {
        return null;
    }

    @Override
    public void run(IMarker marker)
    {

    }

    @Override
    public String getDescription()
    {
        return "Foobar";
    }

    @Override
    public Image getImage()
    {
        return null;
    }

}
