package adfg.diagram.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import adfg.Actor;
import adfg.AperiodicActor;
import adfg.Channel;
import adfg.Connection;
import adfg.InputPort;
import adfg.OutputPort;
import adfg.PeriodicActor;
import adfg.Port;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.part.AdfgDiagramEditorPlugin;
import adfg.diagram.part.AdfgVisualIDRegistry;

/**
 * @generated
 */
public class AdfgValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
	 */
	public static void runWithConstraints(
			TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if (editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				AdfgDiagramEditorPlugin.getInstance().logError(
						"Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive
					&& ApplicationEditPart.MODEL_ID.equals(AdfgVisualIDRegistry
							.getModelID((View) object));
		}
		return true;
	}

	/**
	 * @generated
	 */
	public static class DefaultCtx implements IClientSelector {

		/**
		 * @generated
		 */
		public boolean selects(Object object) {
			return isInDefaultEditorContext(object);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter3 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			PeriodicActor context = (PeriodicActor) ctx.getTarget();
			// periodicActorValidParameters
			boolean ok = true;
			if (context.getPeriodUpperBound() > 0 && context.getPeriod() > 0
					&& context.getPeriod() > context.getPeriodUpperBound())
				ok = false;
			if (context.getPeriodUpperBound() > 0
					&& context.getPeriodUpperBound() < context.getWcet())
				ok = false;
			if (context.getPeriod() > 0
					&& context.getPeriod() < context.getWcet())
				ok = false;
			if (context.getPeriodLowerBound() > 0 && context.getPeriod() > 0
					&& context.getPeriod() < context.getPeriodLowerBound())
				ok = false;

			if (context.getPeriodLowerBound() > 0
					&& context.getPeriodUpperBound() > 0
					&& context.getPeriodLowerBound() > context
							.getPeriodUpperBound())
				ok = false;

			return ok ? ctx.createSuccessStatus() : ctx.createFailureStatus();
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter5 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Connection context = (Connection) ctx.getTarget();
			// TypeSystem
			Class typeSource = context.getSource().getType(), typeTarget = context
					.getTarget().getType();
			boolean ok = true;
			if (typeSource != null && typeTarget != null) {
				if (!typeSource.getClass().isAssignableFrom(
						typeTarget.getClass()))
					ok = false;
			}
			return ok ? ctx.createSuccessStatus() : ctx.createFailureStatus();
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter6 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Channel context = (Channel) ctx.getTarget();
			boolean ok = true;
			if (context.getSize() > 0 && context.getInitial() >= 0
					&& context.getSize() < context.getInitial())
				ok = false;
			return ok ? ctx.createSuccessStatus() : ctx.createFailureStatus();
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter7 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Port context = (Port) ctx.getTarget();
			// portValidType
			boolean ok = true;

			if (context.getType() != null) {

				Class cls = null;
				try {
					cls = Class.forName("scj.adfg.Capsule", true, context
							.getType().getClassLoader());
				} catch (ClassNotFoundException e) {
				}
				if (cls != null && !cls.isAssignableFrom(context.getType()))
					ok = false;
				else {
					Connection channel = null;
					if (context instanceof InputPort) {
						InputPort port = (InputPort) context;
						if (port.getConnection() != null)
							channel = port.getConnection();
					} else {
						OutputPort port = (OutputPort) context;
						if (port.getConnection() != null)
							channel = port.getConnection();
					}
					if (channel != null) {
						Class typeSource = channel.getSource().getType(), typeTarget = channel
								.getTarget().getType();
						if (typeSource != null && typeTarget != null) {
							try {
								Class classSource = Class.forName(
										typeSource.getCanonicalName(), true,
										typeTarget.getClassLoader());
								if (!classSource.isAssignableFrom(typeTarget))
									ok = false;
							} catch (ClassNotFoundException e) {
							}
						}
					}
				}
			}
			return ok ? ctx.createSuccessStatus() : ctx.createFailureStatus();
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter8 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			AperiodicActor context = (AperiodicActor) ctx.getTarget();
			// aperiodicActorValidParameters
			boolean ok = true;
			if (context.getCapacity() > 0
					&& context.getReplenishmentPeriod() > 0
					&& context.getCapacity() > context.getReplenishmentPeriod())
				ok = false;
			return ok ? ctx.createSuccessStatus() : ctx.createFailureStatus();
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter9 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Actor context = (Actor) ctx.getTarget();
			//ActorValidPriority
			boolean ok = true;

			if (context.getOwner().getDataflow().isPropertyUpdating())
				return ctx.createSuccessStatus();

			if (context.getPriority() > 0
					&& (context.getOwner().getOwner().getNbProcessors() == 1 || context
							.getProcNumber() > 0)) {
				for (Actor actor : context.getOwner().getNodes()) {
					if (actor != context
							&& (context.getOwner().getOwner().getNbProcessors() == 1 || actor
									.getProcNumber() == context.getProcNumber())) {
						if (actor.getPriority() == context.getPriority()) {
							ok = false;
							break;
						} else {
							if (context instanceof PeriodicActor
									&& actor instanceof AperiodicActor
									&& actor.getPriority() > 0
									&& context.getPriority() < actor
											.getPriority()) {
								ok = false;
								break;
							} else if (context instanceof AperiodicActor
									&& actor instanceof PeriodicActor
									&& actor.getPriority() > 0
									&& context.getPriority() > actor
											.getPriority()) {
								ok = false;
								break;
							}
						}
					}
				}
			}
			return ok ? ctx.createSuccessStatus() : ctx.createFailureStatus();
		}
	}

	/**
	 * @generated
	 */
	static String formatElement(EObject object) {
		return EMFCoreUtil.getQualifiedName(object, true);
	}

}
