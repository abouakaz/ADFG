package adfg.diagram.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import adfg.diagram.edit.policies.GraphGraphCompartmentFigureCanonicalEditPolicy;
import adfg.diagram.edit.policies.GraphGraphCompartmentFigureItemSemanticEditPolicy;
import adfg.diagram.part.AdfgVisualIDRegistry;
import adfg.diagram.part.Messages;

/**
 * @generated
 */
public class GraphGraphCompartmentFigureEditPart extends
		ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public GraphGraphCompartmentFigureEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.GraphGraphCompartmentFigureEditPart_title;
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new ResizableCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new GraphGraphCompartmentFigureItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new GraphGraphCompartmentFigureCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			/**
			 * Overrides <code>getAddCommand()</code> to generate the proper constraint for each child
			 * being added. Once the constraint is calculated, {@link
			 * #createAddCommand(EditPart,Object)} is called. Subclasses must implement this method.
			 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getAddCommand(Request)
			 */
			protected Command getAddCommand(Request generic) {
				ChangeBoundsRequest request = (ChangeBoundsRequest) generic;
				List editParts = request.getEditParts();
				CompoundCommand command = new CompoundCommand();
				command.setDebugLabel("Add in ConstrainedLayoutEditPolicy");//$NON-NLS-1$
				GraphicalEditPart childPart;
				Rectangle r;
				Object constraint;

				for (int i = 0; i < editParts.size(); i++) {
					childPart = (GraphicalEditPart) editParts.get(i);
					if (childPart instanceof InputPortEditPart
							|| childPart instanceof InputPortNameEditPart
							|| childPart instanceof OutputPortEditPart
							|| childPart instanceof OutputPortNameEditPart)
						continue;
					r = childPart.getFigure().getBounds().getCopy();
					//convert r to absolute from childpart figure
					childPart.getFigure().translateToAbsolute(r);
					r = request.getTransformedRectangle(r);
					//convert this figure to relative 
					getLayoutContainer().translateToRelative(r);
					getLayoutContainer().translateFromParent(r);
					r.translate(getLayoutOrigin().getNegated());
					constraint = getConstraintFor(r);
					/*
					 * @TODO:Pratik Should create a new createAddCommand(...) which is given the
					 * request so that attaching to/detaching from guides can be taken care of.  
					 */
					command.add(createAddCommand(childPart,
							translateToModelConstraint(constraint)));
				}
				return command.unwrap();
			}
		});
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}
