package adfg.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;

import adfg.PeriodicActor;
import adfg.diagram.common.gmf.PortBorderItemLocator;
import adfg.diagram.edit.policies.PeriodicActorCanonicalEditPolicy;
import adfg.diagram.edit.policies.PeriodicActorItemSemanticEditPolicy;
import adfg.diagram.part.AdfgVisualIDRegistry;
import adfg.diagram.part.ValidateAction;
import adfg.diagram.providers.AdfgElementTypes;
import adfg.impl.GraphImpl;
import adfg.impl.PeriodicActorImpl;

/**
 * @generated
 */
public class PeriodicActorEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3011;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public PeriodicActorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						AdfgVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PeriodicActorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new PeriodicActorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (AdfgVisualIDRegistry.getVisualID(childView)) {
				case InputPortEditPart.VISUAL_ID:
				case OutputPortEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new PeriodicActorFigure();
	}

	/**
	 * @generated
	 */
	public PeriodicActorFigure getPrimaryShape() {
		return (PeriodicActorFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PeriodicActorNameEditPart) {
			((PeriodicActorNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigurePeriodicActorName());
			return true;
		}

		if (childEditPart instanceof InputPortEditPart) {
			BorderItemLocator locator = new PortBorderItemLocator(
					getMainFigure(), PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((InputPortEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof OutputPortEditPart) {
			BorderItemLocator locator = new PortBorderItemLocator(
					getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((OutputPortEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PeriodicActorNameEditPart) {
			return true;
		}
		if (childEditPart instanceof InputPortEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((InputPortEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof OutputPortEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((OutputPortEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(70, 50);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(AdfgVisualIDRegistry
				.getType(PeriodicActorNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AdfgElementTypes.AffineRelation_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof adfg.diagram.edit.parts.PeriodicActorEditPart) {
			types.add(AdfgElementTypes.AffineRelation_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == AdfgElementTypes.AffineRelation_4002) {
			types.add(AdfgElementTypes.PeriodicActor_3011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AdfgElementTypes.AffineRelation_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == AdfgElementTypes.AffineRelation_4002) {
			types.add(AdfgElementTypes.PeriodicActor_3011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class PeriodicActorFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePeriodicActorName;

		/**
		 * @generated
		 */
		public PeriodicActorFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(16)));
			this.setLineWidth(2);
			this.setForegroundColor(THIS_FORE);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(70),
					getMapMode().DPtoLP(50)));
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigurePeriodicActorName = new WrappingLabel();
			fFigurePeriodicActorName.setText("");
			fFigurePeriodicActorName.setAlignment(PositionConstants.CENTER);
			this.add(fFigurePeriodicActorName, BorderLayout.CENTER);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePeriodicActorName() {
			return fFigurePeriodicActorName;
		}

		/**
		 * @generated NOT
		 */
		protected void fillShape(Graphics graphics) {
			// Backup the graphics colors
			Color bgColor = graphics.getBackgroundColor();
			Color fgColor = graphics.getForegroundColor();
			// Set the graphics color
			graphics.setForegroundColor(new Color(null, 70, 130, 180));

			double zoom = graphics.getAbsoluteScale();

			float arcSize = (float) (zoom * getCornerDimensions().height);
			PrecisionRectangle rBounds = new PrecisionRectangle(getBounds());
			rBounds.shrink(getLineWidth() / 2, getLineWidth() / 2);

			float x = rBounds.x;
			float y = rBounds.y;
			float width = rBounds.width;
			float height = rBounds.height;

			// start from top left "corner" and move clockwise
			Path path = new Path(null);
			path.addArc(x, y, arcSize, arcSize, 90, 90);
			path.lineTo(x, y + height - arcSize / 2);
			path.addArc(x, y + height - arcSize, arcSize, arcSize, 180, 90);
			path.lineTo(x + width - arcSize / 2, y + height);
			path.addArc(x + width - arcSize, y + height - arcSize, arcSize,
					arcSize, 0, -90);
			path.lineTo(x + width, y + height - arcSize / 2);
			path.addArc(x + width - arcSize, y, arcSize, arcSize, 0, 90);
			path.close();

			Pattern pattern = new Pattern(Display.getCurrent(),
					(float) (x * zoom), (float) (y * zoom),
					(float) (x * zoom + width * zoom), (float) (y * zoom + zoom
							* height), ColorConstants.white, new Color(null,
							176, 226, 255));
			graphics.setBackgroundPattern(pattern);

			graphics.fillPath(path);
			// Restore the original colors
			graphics.setBackgroundColor(bgColor);
			graphics.setForegroundColor(fgColor);
			path.dispose();
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 70, 130, 180);

	/**
	 * @generated NOT
	 */
	@Override
	public void activate() {
		super.activate();
		pactor = (PeriodicActorImpl) resolveSemanticElement();
		graph = (GraphImpl) pactor.getOwner();
		//consistency dynamic checking	
		if (pactor.getOwner().isLoaded()) {
			pactor.getOwner().getDataflow().addModelPeriodicActor(pactor);
			BasicDiagnostic diagnostic = graph.getDataflow()
					.getGraphDiagnostic();
			if (diagnostic != null)
				ValidateAction.runValidation(getDiagramView(), diagnostic);
		}
	}

	/**
	 * @generated NOT
	 */
	PeriodicActorImpl pactor;
	/**
	 * @generated NOT
	 */
	GraphImpl graph;

	/**
	 * @generated NOT
	 */
	@Override
	public void deactivate() {
		//consistency dynamic checking	
		if (graph.isLoaded()) {
			graph.getDataflow().removeModelPeriodicActor(pactor);
			BasicDiagnostic diagnostic = graph.getDataflow()
					.getGraphDiagnostic();
			if (diagnostic != null)
				ValidateAction.runValidation(getDiagramView(), diagnostic);
		}
		super.deactivate();
	}

	/**
	 * @generated NOT
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (notification.getNotifier() instanceof PeriodicActor) {
			if (notification.getFeature() instanceof EAttribute) {
				String refName = ((EAttribute) notification.getFeature())
						.getName();
				PeriodicActor actor = (PeriodicActor) notification
						.getNotifier();
				actor.getOwner().getDataflow().updateModelActor(actor, refName);
				BasicDiagnostic diagnostic = graph.getDataflow()
						.getGraphDiagnostic();
				if (diagnostic != null)
					ValidateAction.runValidation(getDiagramView(), diagnostic);
			}
		}
	}

}
