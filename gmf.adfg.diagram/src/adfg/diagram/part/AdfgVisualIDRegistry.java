package adfg.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import adfg.AdfgPackage;
import adfg.Application;
import adfg.diagram.edit.parts.AffineRelationEditPart;
import adfg.diagram.edit.parts.AffineRelationNEditPart;
import adfg.diagram.edit.parts.AperiodicActorEditPart;
import adfg.diagram.edit.parts.AperiodicActorNameEditPart;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.ChannelEditPart;
import adfg.diagram.edit.parts.ChannelIdEditPart;
import adfg.diagram.edit.parts.ChannelInitialSizeEditPart;
import adfg.diagram.edit.parts.GraphConnectionEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.edit.parts.GraphGraphCompartmentFigureEditPart;
import adfg.diagram.edit.parts.GraphNameEditPart;
import adfg.diagram.edit.parts.InputPort2EditPart;
import adfg.diagram.edit.parts.InputPortEditPart;
import adfg.diagram.edit.parts.InputPortName2EditPart;
import adfg.diagram.edit.parts.InputPortNameEditPart;
import adfg.diagram.edit.parts.LabelEditPart;
import adfg.diagram.edit.parts.LossyChannelEditPart;
import adfg.diagram.edit.parts.LossyChannelSizeEditPart;
import adfg.diagram.edit.parts.OutputPort2EditPart;
import adfg.diagram.edit.parts.OutputPortEditPart;
import adfg.diagram.edit.parts.OutputPortName2EditPart;
import adfg.diagram.edit.parts.OutputPortNameEditPart;
import adfg.diagram.edit.parts.PeriodicActorEditPart;
import adfg.diagram.edit.parts.PeriodicActorNameEditPart;
import adfg.diagram.edit.parts.WrappingLabel2EditPart;
import adfg.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class AdfgVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "gmf.adfg.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ApplicationEditPart.MODEL_ID.equals(view.getType())) {
				return ApplicationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return adfg.diagram.part.AdfgVisualIDRegistry.getVisualID(view
				.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				AdfgDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (AdfgPackage.eINSTANCE.getApplication().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Application) domainElement)) {
			return ApplicationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = adfg.diagram.part.AdfgVisualIDRegistry
				.getModelID(containerView);
		if (!ApplicationEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ApplicationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = adfg.diagram.part.AdfgVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ApplicationEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ApplicationEditPart.VISUAL_ID:
			if (AdfgPackage.eINSTANCE.getGraph().isSuperTypeOf(
					domainElement.eClass())) {
				return GraphEditPart.VISUAL_ID;
			}
			break;
		case PeriodicActorEditPart.VISUAL_ID:
			if (AdfgPackage.eINSTANCE.getInputPort().isSuperTypeOf(
					domainElement.eClass())) {
				return InputPortEditPart.VISUAL_ID;
			}
			if (AdfgPackage.eINSTANCE.getOutputPort().isSuperTypeOf(
					domainElement.eClass())) {
				return OutputPortEditPart.VISUAL_ID;
			}
			break;
		case AperiodicActorEditPart.VISUAL_ID:
			if (AdfgPackage.eINSTANCE.getInputPort().isSuperTypeOf(
					domainElement.eClass())) {
				return InputPort2EditPart.VISUAL_ID;
			}
			if (AdfgPackage.eINSTANCE.getOutputPort().isSuperTypeOf(
					domainElement.eClass())) {
				return OutputPort2EditPart.VISUAL_ID;
			}
			break;
		case GraphGraphCompartmentFigureEditPart.VISUAL_ID:
			if (AdfgPackage.eINSTANCE.getPeriodicActor().isSuperTypeOf(
					domainElement.eClass())) {
				return PeriodicActorEditPart.VISUAL_ID;
			}
			if (AdfgPackage.eINSTANCE.getAperiodicActor().isSuperTypeOf(
					domainElement.eClass())) {
				return AperiodicActorEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = adfg.diagram.part.AdfgVisualIDRegistry
				.getModelID(containerView);
		if (!ApplicationEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ApplicationEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = adfg.diagram.part.AdfgVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ApplicationEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ApplicationEditPart.VISUAL_ID:
			if (GraphEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GraphEditPart.VISUAL_ID:
			if (GraphNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GraphGraphCompartmentFigureEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PeriodicActorEditPart.VISUAL_ID:
			if (PeriodicActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPortEditPart.VISUAL_ID:
			if (InputPortNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPortEditPart.VISUAL_ID:
			if (OutputPortNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AperiodicActorEditPart.VISUAL_ID:
			if (AperiodicActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InputPort2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OutputPort2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InputPort2EditPart.VISUAL_ID:
			if (InputPortName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OutputPort2EditPart.VISUAL_ID:
			if (OutputPortName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GraphGraphCompartmentFigureEditPart.VISUAL_ID:
			if (PeriodicActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AperiodicActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AffineRelationEditPart.VISUAL_ID:
			if (AffineRelationNEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChannelEditPart.VISUAL_ID:
			if (ChannelInitialSizeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ChannelIdEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LossyChannelEditPart.VISUAL_ID:
			if (LossyChannelSizeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (AdfgPackage.eINSTANCE.getAffineRelation().isSuperTypeOf(
				domainElement.eClass())) {
			return AffineRelationEditPart.VISUAL_ID;
		}
		if (AdfgPackage.eINSTANCE.getChannel().isSuperTypeOf(
				domainElement.eClass())) {
			return ChannelEditPart.VISUAL_ID;
		}
		if (AdfgPackage.eINSTANCE.getGraphConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return GraphConnectionEditPart.VISUAL_ID;
		}
		if (AdfgPackage.eINSTANCE.getLossyChannel().isSuperTypeOf(
				domainElement.eClass())) {
			return LossyChannelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Application element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case GraphGraphCompartmentFigureEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case ApplicationEditPart.VISUAL_ID:
			return false;
		case InputPortEditPart.VISUAL_ID:
		case OutputPortEditPart.VISUAL_ID:
		case InputPort2EditPart.VISUAL_ID:
		case OutputPort2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return adfg.diagram.part.AdfgVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return adfg.diagram.part.AdfgVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return adfg.diagram.part.AdfgVisualIDRegistry.getNodeVisualID(
					containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return adfg.diagram.part.AdfgVisualIDRegistry.checkNodeVisualID(
					containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return adfg.diagram.part.AdfgVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return adfg.diagram.part.AdfgVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
