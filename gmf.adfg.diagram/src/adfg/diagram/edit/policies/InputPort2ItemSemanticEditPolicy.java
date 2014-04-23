package adfg.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import adfg.diagram.edit.commands.ChannelCreateCommand;
import adfg.diagram.edit.commands.ChannelReorientCommand;
import adfg.diagram.edit.commands.LossyChannelCreateCommand;
import adfg.diagram.edit.commands.LossyChannelReorientCommand;
import adfg.diagram.edit.parts.ChannelEditPart;
import adfg.diagram.edit.parts.LossyChannelEditPart;
import adfg.diagram.part.AdfgVisualIDRegistry;
import adfg.diagram.providers.AdfgElementTypes;

/**
 * @generated
 */
public class InputPort2ItemSemanticEditPolicy extends
		AdfgBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InputPort2ItemSemanticEditPolicy() {
		super(AdfgElementTypes.InputPort_3015);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (AdfgVisualIDRegistry.getVisualID(incomingLink) == ChannelEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (AdfgVisualIDRegistry.getVisualID(incomingLink) == LossyChannelEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (AdfgElementTypes.Channel_4005 == req.getElementType()) {
			return null;
		}
		if (AdfgElementTypes.LossyChannel_4007 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (AdfgElementTypes.Channel_4005 == req.getElementType()) {
			return getGEFWrapper(new ChannelCreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (AdfgElementTypes.LossyChannel_4007 == req.getElementType()) {
			return getGEFWrapper(new LossyChannelCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ChannelEditPart.VISUAL_ID:
			return getGEFWrapper(new ChannelReorientCommand(req));
		case LossyChannelEditPart.VISUAL_ID:
			return getGEFWrapper(new LossyChannelReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
