package adfg.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

import adfg.diagram.edit.commands.AperiodicActorCreateCommand;
import adfg.diagram.edit.commands.PeriodicActorCreateCommand;
import adfg.diagram.providers.AdfgElementTypes;

/**
 * @generated
 */
public class GraphGraphCompartmentFigureItemSemanticEditPolicy extends
		AdfgBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public GraphGraphCompartmentFigureItemSemanticEditPolicy() {
		super(AdfgElementTypes.Graph_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (AdfgElementTypes.PeriodicActor_3011 == req.getElementType()) {
			return getGEFWrapper(new PeriodicActorCreateCommand(req));
		}
		if (AdfgElementTypes.AperiodicActor_3014 == req.getElementType()) {
			return getGEFWrapper(new AperiodicActorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated NOT
	 */
	protected Command getMoveCommand(MoveRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated NOT
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

}
