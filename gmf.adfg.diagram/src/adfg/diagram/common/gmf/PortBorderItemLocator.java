package adfg.diagram.common.gmf;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;



public class PortBorderItemLocator extends BorderItemLocator {

/**
* Use to "middle overlap" the affixed child
*/
private static final int halfSizeOfAfffixedChild = 8;

public PortBorderItemLocator(IFigure parentFigure) {
super(parentFigure);
setBorderItemOffset(new Dimension(halfSizeOfAfffixedChild, halfSizeOfAfffixedChild));
}

public PortBorderItemLocator(IFigure mainFigure, int preferredSide) {
super(mainFigure, preferredSide); 
setBorderItemOffset(new Dimension(halfSizeOfAfffixedChild, halfSizeOfAfffixedChild));
}

/**
* Get an initial location based on the side. ( choose first sixth part of the side for SOUTH or call super)
*
* @param side
* the preferred side of the parent figure on which to place this
* border item as defined in {@link PositionConstants}
* @return point
*/
protected Point getPreferredLocation(int side, IFigure borderItem) {
if (side == PositionConstants.SOUTH) {
Rectangle bounds = getParentBorder();
int parentFigureWidth = bounds.width;
int parentFigureHeight = bounds.height;
int parentFigureX = bounds.x;
int parentFigureY = bounds.y;
int x = parentFigureX;
int y = parentFigureY;
/*Play with this for modify the horizontal position on the activity Figure*/
x += parentFigureWidth / 6;
y = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
return new Point(x, y);
} else {
return super.getPreferredLocation(side, borderItem);
}
}
}
