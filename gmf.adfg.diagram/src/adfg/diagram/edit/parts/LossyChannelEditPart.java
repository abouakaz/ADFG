package adfg.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import adfg.diagram.edit.policies.LossyChannelItemSemanticEditPolicy;

/**
 * @generated
 */
public class LossyChannelEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4007;

	/**
	 * @generated
	 */
	public LossyChannelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LossyChannelItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LossyChannelSizeEditPart) {
			((LossyChannelSizeEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureLossyChannelParameters());
			return true;
		}
		if (childEditPart instanceof WrappingLabelEditPart) {
			((WrappingLabelEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLossyChannelProduceSequence());
			return true;
		}
		if (childEditPart instanceof WrappingLabel2EditPart) {
			((WrappingLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLossyChannelConsumeSequence());
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
		if (childEditPart instanceof LossyChannelSizeEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel2EditPart) {
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
		return new LossyChannelFigure();
	}

	/**
	 * @generated
	 */
	public LossyChannelFigure getPrimaryShape() {
		return (LossyChannelFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class LossyChannelFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLossyChannelParameters;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLossyChannelProduceSequence;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureLossyChannelConsumeSequence;

		/**
		 * @generated
		 */
		public LossyChannelFigure() {
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLossyChannelParameters = new WrappingLabel();

			fFigureLossyChannelParameters.setText("");

			this.add(fFigureLossyChannelParameters);

			fFigureLossyChannelProduceSequence = new WrappingLabel();

			fFigureLossyChannelProduceSequence.setText("");

			this.add(fFigureLossyChannelProduceSequence);

			fFigureLossyChannelConsumeSequence = new WrappingLabel();

			fFigureLossyChannelConsumeSequence.setText("");

			this.add(fFigureLossyChannelConsumeSequence);

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
		public WrappingLabel getFigureLossyChannelParameters() {
			return fFigureLossyChannelParameters;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLossyChannelProduceSequence() {
			return fFigureLossyChannelProduceSequence;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLossyChannelConsumeSequence() {
			return fFigureLossyChannelConsumeSequence;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 130, 180, 70);

}
