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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EAttribute;

import adfg.Channel;
import adfg.diagram.edit.policies.ChannelItemSemanticEditPolicy;
import adfg.diagram.part.ValidateAction;
import adfg.impl.ChannelImpl;
import adfg.impl.GraphImpl;

/**
 * @generated
 */
public class ChannelEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4005;

	/**
	 * @generated
	 */
	public ChannelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ChannelItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChannelInitialSizeEditPart) {
			((ChannelInitialSizeEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureChannelParameters());
			return true;
		}
		if (childEditPart instanceof ChannelIdEditPart) {
			((ChannelIdEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureChannelProduceSequence());
			return true;
		}
		if (childEditPart instanceof LabelEditPart) {
			((LabelEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureChannelConsumeSequence());
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
		if (childEditPart instanceof ChannelInitialSizeEditPart) {
			return true;
		}
		if (childEditPart instanceof ChannelIdEditPart) {
			return true;
		}
		if (childEditPart instanceof LabelEditPart) {
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
		return new ChannelFigure();
	}

	/**
	 * @generated
	 */
	public ChannelFigure getPrimaryShape() {
		return (ChannelFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ChannelFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureChannelParameters;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureChannelProduceSequence;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureChannelConsumeSequence;

		/**
		 * @generated
		 */
		public ChannelFigure() {
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureChannelParameters = new WrappingLabel();

			fFigureChannelParameters.setText("");

			this.add(fFigureChannelParameters);

			fFigureChannelProduceSequence = new WrappingLabel();

			fFigureChannelProduceSequence.setText("");

			this.add(fFigureChannelProduceSequence);

			fFigureChannelConsumeSequence = new WrappingLabel();

			fFigureChannelConsumeSequence.setText("");

			this.add(fFigureChannelConsumeSequence);

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
		public WrappingLabel getFigureChannelParameters() {
			return fFigureChannelParameters;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureChannelProduceSequence() {
			return fFigureChannelProduceSequence;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureChannelConsumeSequence() {
			return fFigureChannelConsumeSequence;
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
		channel = (ChannelImpl) resolveSemanticElement();
		graph = (GraphImpl) channel.getOwner();
		//consistency dynamic checking
		if (channel.getOwner().isLoaded()) {
			try {
				channel.getOwner().getDataflow().addModelChannel(channel);
				BasicDiagnostic diagnostic = channel.getOwner().getDataflow()
						.getGraphDiagnostic();
				if (diagnostic != null)
					ValidateAction.runValidation(getDiagramView(), diagnostic);
			} catch (IllegalArgumentException e) {
				this.deactivate();
			}
		}
	}

	/**
	 * @generated NOT
	 */
	ChannelImpl channel;
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
			graph.getDataflow().removeModelChannel(channel);
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
		if (notification.getNotifier() instanceof Channel) {
			if (notification.getFeature() instanceof EAttribute) {
				String refName = ((EAttribute) notification.getFeature())
						.getName();
				Channel channel = (Channel) notification.getNotifier();
				channel.getOwner().getDataflow()
						.updateModelChannel(channel, refName);
				BasicDiagnostic diagnostic = graph.getDataflow()
						.getGraphDiagnostic();
				if (diagnostic != null)
					ValidateAction.runValidation(getDiagramView(), diagnostic);
			}
		}
	}

}
