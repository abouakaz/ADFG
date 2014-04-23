package adfg.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import adfg.Application;
import adfg.Graph;
import adfg.GraphConnection;
import adfg.diagram.edit.policies.AdfgBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class GraphConnectionReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public GraphConnectionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof GraphConnection) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Graph && newEnd instanceof Graph)) {
			return false;
		}
		Graph target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof Application)) {
			return false;
		}
		Application container = (Application) getLink().eContainer();
		return AdfgBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistGraphConnection_4004(container, getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Graph && newEnd instanceof Graph)) {
			return false;
		}
		Graph source = getLink().getSource();
		if (!(getLink().eContainer() instanceof Application)) {
			return false;
		}
		Application container = (Application) getLink().eContainer();
		return AdfgBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistGraphConnection_4004(container, getLink(), source,
						getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected GraphConnection getLink() {
		return (GraphConnection) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Graph getOldSource() {
		return (Graph) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Graph getNewSource() {
		return (Graph) newEnd;
	}

	/**
	 * @generated
	 */
	protected Graph getOldTarget() {
		return (Graph) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Graph getNewTarget() {
		return (Graph) newEnd;
	}
}
