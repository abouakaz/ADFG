package adfg.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import adfg.diagram.part.AdfgVisualIDRegistry;

/**
 * @generated
 */
public class AdfgEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (AdfgVisualIDRegistry.getVisualID(view)) {

			case ApplicationEditPart.VISUAL_ID:
				return new ApplicationEditPart(view);

			case GraphEditPart.VISUAL_ID:
				return new GraphEditPart(view);

			case GraphNameEditPart.VISUAL_ID:
				return new GraphNameEditPart(view);

			case PeriodicActorEditPart.VISUAL_ID:
				return new PeriodicActorEditPart(view);

			case PeriodicActorNameEditPart.VISUAL_ID:
				return new PeriodicActorNameEditPart(view);

			case InputPortEditPart.VISUAL_ID:
				return new InputPortEditPart(view);

			case InputPortNameEditPart.VISUAL_ID:
				return new InputPortNameEditPart(view);

			case OutputPortEditPart.VISUAL_ID:
				return new OutputPortEditPart(view);

			case OutputPortNameEditPart.VISUAL_ID:
				return new OutputPortNameEditPart(view);

			case AperiodicActorEditPart.VISUAL_ID:
				return new AperiodicActorEditPart(view);

			case AperiodicActorNameEditPart.VISUAL_ID:
				return new AperiodicActorNameEditPart(view);

			case InputPort2EditPart.VISUAL_ID:
				return new InputPort2EditPart(view);

			case InputPortName2EditPart.VISUAL_ID:
				return new InputPortName2EditPart(view);

			case OutputPort2EditPart.VISUAL_ID:
				return new OutputPort2EditPart(view);

			case OutputPortName2EditPart.VISUAL_ID:
				return new OutputPortName2EditPart(view);

			case GraphGraphCompartmentFigureEditPart.VISUAL_ID:
				return new GraphGraphCompartmentFigureEditPart(view);

			case AffineRelationEditPart.VISUAL_ID:
				return new AffineRelationEditPart(view);

			case AffineRelationNEditPart.VISUAL_ID:
				return new AffineRelationNEditPart(view);

			case ChannelEditPart.VISUAL_ID:
				return new ChannelEditPart(view);

			case ChannelInitialSizeEditPart.VISUAL_ID:
				return new ChannelInitialSizeEditPart(view);

			case ChannelIdEditPart.VISUAL_ID:
				return new ChannelIdEditPart(view);

			case LabelEditPart.VISUAL_ID:
				return new LabelEditPart(view);

			case GraphConnectionEditPart.VISUAL_ID:
				return new GraphConnectionEditPart(view);

			case LossyChannelEditPart.VISUAL_ID:
				return new LossyChannelEditPart(view);

			case LossyChannelSizeEditPart.VISUAL_ID:
				return new LossyChannelSizeEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
