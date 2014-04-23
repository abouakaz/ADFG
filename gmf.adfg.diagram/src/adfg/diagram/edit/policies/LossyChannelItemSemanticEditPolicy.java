package adfg.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import adfg.diagram.providers.AdfgElementTypes;

/**
 * @generated
 */
public class LossyChannelItemSemanticEditPolicy extends
		AdfgBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LossyChannelItemSemanticEditPolicy() {
		super(AdfgElementTypes.LossyChannel_4007);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
