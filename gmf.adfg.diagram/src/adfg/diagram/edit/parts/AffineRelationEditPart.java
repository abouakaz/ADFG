package adfg.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;

import adfg.AffineRelation;
import adfg.PeriodicActor;
import adfg.diagram.edit.policies.AffineRelationItemSemanticEditPolicy;
import adfg.diagram.part.ValidateAction;
import adfg.impl.AffineRelationImpl;
import adfg.impl.GraphImpl;

/**
 * @generated
 */
public class AffineRelationEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	public AffineRelationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AffineRelationItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AffineRelationNEditPart) {
			((AffineRelationNEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAffineRelationParameters());
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
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AffineRelationNEditPart) {
			return true;
		}
		return false;
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new AffineRelationFigure();
	}

	/**
	 * @generated
	 */
	public AffineRelationFigure getPrimaryShape() {
		return (AffineRelationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class AffineRelationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAffineRelationParameters;

		/**
		 * @generated
		 */
		public AffineRelationFigure() {
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureAffineRelationParameters = new WrappingLabel();

			fFigureAffineRelationParameters.setText("");

			this.add(fFigureAffineRelationParameters);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAffineRelationParameters() {
			return fFigureAffineRelationParameters;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 142, 35, 35);

	/**
	 * @generated NOT
	 */
	@Override
	public void activate() {
		super.activate();
		affineRelation = (AffineRelationImpl) resolveSemanticElement();
		graph = (GraphImpl) affineRelation.getOwner();
		source = affineRelation.getSource();
		target = affineRelation.getTarget();
		//consistency dynamic checking
		if (affineRelation.getOwner().isLoaded()) {
			graph.getDataflow().addModelAffineRelation(affineRelation);
			BasicDiagnostic diagnostic = graph.getDataflow()
					.getGraphDiagnostic();
			if (diagnostic != null)
				ValidateAction.runValidation(getDiagramView(), diagnostic);
		}
	}

	/**
	 * @generated NOT
	 */
	AffineRelationImpl affineRelation;

	/**
	 * @generated NOT
	 */
	GraphImpl graph;

	/**
	 * @generated NOT
	 */
	PeriodicActor source, target;

	/**
	 * @generated NOT
	 */
	@Override
	public void deactivate() {
		//consistency dynamic checking	
		if (graph.isLoaded()) {
			graph.getDataflow().removeModelAffineRelation(affineRelation,
					source, target);
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
		if (notification.getNotifier() instanceof AffineRelation) {
			if (notification.getFeature() instanceof EAttribute) {
				AffineRelation affineRelation = (AffineRelation) notification
						.getNotifier();
				affineRelation.getOwner().getDataflow()
						.updateModelAffineRelation(affineRelation);
				BasicDiagnostic diagnostic = graph.getDataflow()
						.getGraphDiagnostic();
				if (diagnostic != null)
					ValidateAction.runValidation(getDiagramView(), diagnostic);
			}
		}
	}

}
