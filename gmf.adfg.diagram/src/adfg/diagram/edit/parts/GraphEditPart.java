package adfg.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;

import adfg.Graph;
import adfg.diagram.edit.policies.GraphItemSemanticEditPolicy;
import adfg.diagram.part.AdfgVisualIDRegistry;
import adfg.diagram.part.ValidateAction;
import adfg.diagram.providers.AdfgElementTypes;
import adfg.impl.GraphImpl;

/**
 * @generated
 */
public class GraphEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public GraphEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new GraphItemSemanticEditPolicy());
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
		return primaryShape = new GraphFigure();
	}

	/**
	 * @generated
	 */
	public GraphFigure getPrimaryShape() {
		return (GraphFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof GraphNameEditPart) {
			((GraphNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureGraphName());
			return true;
		}
		if (childEditPart instanceof GraphGraphCompartmentFigureEditPart) {
			IFigure pane = getPrimaryShape().getFigureGraphCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((GraphGraphCompartmentFigureEditPart) childEditPart)
					.getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof GraphNameEditPart) {
			return true;
		}
		if (childEditPart instanceof GraphGraphCompartmentFigureEditPart) {
			IFigure pane = getPrimaryShape().getFigureGraphCompartmentFigure();
			pane.remove(((GraphGraphCompartmentFigureEditPart) childEditPart)
					.getFigure());
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
		if (editPart instanceof GraphGraphCompartmentFigureEditPart) {
			return getPrimaryShape().getFigureGraphCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	protected NodeFigure createNodeFigure() {
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
				.getType(GraphNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AdfgElementTypes.GraphConnection_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof adfg.diagram.edit.parts.GraphEditPart) {
			types.add(AdfgElementTypes.GraphConnection_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == AdfgElementTypes.GraphConnection_4004) {
			types.add(AdfgElementTypes.Graph_2001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AdfgElementTypes.GraphConnection_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == AdfgElementTypes.GraphConnection_4004) {
			types.add(AdfgElementTypes.Graph_2001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class GraphFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureGraphName;
		/**
		 * @generated
		 */
		private RoundedRectangle fFigureGraphCompartmentFigure;

		/**
		 * @generated
		 */
		public GraphFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(16),
					getMapMode().DPtoLP(16)));
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureGraphName = new WrappingLabel();

			fFigureGraphName.setText("");
			fFigureGraphName.setMaximumSize(new Dimension(getMapMode().DPtoLP(
					5000), getMapMode().DPtoLP(24)));

			this.add(fFigureGraphName, BorderLayout.TOP);

			fFigureGraphCompartmentFigure = new RoundedRectangle();

			fFigureGraphCompartmentFigure.setCornerDimensions(new Dimension(
					getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			fFigureGraphCompartmentFigure.setLineWidth(3);

			this.add(fFigureGraphCompartmentFigure, BorderLayout.CENTER);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureGraphName() {
			return fFigureGraphName;
		}

		/**
		 * @generated
		 */
		public RoundedRectangle getFigureGraphCompartmentFigure() {
			return fFigureGraphCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 34, 139, 34);

	/**
	 * @generated NOT
	 */
	@Override
	public void activate() {
		super.activate();
		graph = (GraphImpl) resolveSemanticElement();
		if (!graph.isLoaded()) {
			if (graph.getDataflow().isEmpty())
				return;
			graph.validationAfterLoading();
			BasicDiagnostic diagnostic = graph.getDataflow()
					.getGraphDiagnostic();
			if (diagnostic != null)
				ValidateAction.runValidation(getDiagramView(), diagnostic);
			graph.setLoaded();
		}
	}

	GraphImpl graph;

	/**
	 * @generated NOT
	 */
	@Override
	public void deactivate() {
		//consistency dynamic checking	
		graph.setDeactivated();
		super.deactivate();
	}

	/**
	 * @generated NOT
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (notification.getNotifier() instanceof Graph) {
			if (notification.getFeature() instanceof EAttribute) {
				String refName = ((EAttribute) notification.getFeature())
						.getName();
				Graph graph = (Graph) notification.getNotifier();
				BasicDiagnostic diagnostic = null;
				if ("name".equals(refName)) {
					//TODO
				}
				if (diagnostic != null)
					ValidateAction.runValidation(getDiagramView(), diagnostic);
			}
		}
	}

}
