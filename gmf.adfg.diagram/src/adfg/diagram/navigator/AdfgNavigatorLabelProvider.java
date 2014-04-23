package adfg.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import adfg.Application;
import adfg.diagram.edit.parts.AffineRelationEditPart;
import adfg.diagram.edit.parts.AffineRelationNEditPart;
import adfg.diagram.edit.parts.AperiodicActorEditPart;
import adfg.diagram.edit.parts.AperiodicActorNameEditPart;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.ChannelEditPart;
import adfg.diagram.edit.parts.ChannelInitialSizeEditPart;
import adfg.diagram.edit.parts.GraphConnectionEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.edit.parts.GraphNameEditPart;
import adfg.diagram.edit.parts.InputPort2EditPart;
import adfg.diagram.edit.parts.InputPortEditPart;
import adfg.diagram.edit.parts.InputPortName2EditPart;
import adfg.diagram.edit.parts.InputPortNameEditPart;
import adfg.diagram.edit.parts.LossyChannelEditPart;
import adfg.diagram.edit.parts.LossyChannelSizeEditPart;
import adfg.diagram.edit.parts.OutputPort2EditPart;
import adfg.diagram.edit.parts.OutputPortEditPart;
import adfg.diagram.edit.parts.OutputPortName2EditPart;
import adfg.diagram.edit.parts.OutputPortNameEditPart;
import adfg.diagram.edit.parts.PeriodicActorEditPart;
import adfg.diagram.edit.parts.PeriodicActorNameEditPart;
import adfg.diagram.part.AdfgDiagramEditorPlugin;
import adfg.diagram.part.AdfgVisualIDRegistry;
import adfg.diagram.providers.AdfgElementTypes;
import adfg.diagram.providers.AdfgParserProvider;

/**
 * @generated
 */
public class AdfgNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		AdfgDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		AdfgDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof AdfgNavigatorItem
				&& !isOwnView(((AdfgNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof AdfgNavigatorGroup) {
			AdfgNavigatorGroup group = (AdfgNavigatorGroup) element;
			return AdfgDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof AdfgNavigatorItem) {
			AdfgNavigatorItem navigatorItem = (AdfgNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (AdfgVisualIDRegistry.getVisualID(view)) {
		case ApplicationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.example.org/adfg?Application", AdfgElementTypes.Application_1000); //$NON-NLS-1$
		case GraphEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.example.org/adfg?Graph", AdfgElementTypes.Graph_2001); //$NON-NLS-1$
		case PeriodicActorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/adfg?PeriodicActor", AdfgElementTypes.PeriodicActor_3011); //$NON-NLS-1$
		case InputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/adfg?InputPort", AdfgElementTypes.InputPort_3012); //$NON-NLS-1$
		case OutputPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/adfg?OutputPort", AdfgElementTypes.OutputPort_3013); //$NON-NLS-1$
		case AperiodicActorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/adfg?AperiodicActor", AdfgElementTypes.AperiodicActor_3014); //$NON-NLS-1$
		case InputPort2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/adfg?InputPort", AdfgElementTypes.InputPort_3015); //$NON-NLS-1$
		case OutputPort2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/adfg?OutputPort", AdfgElementTypes.OutputPort_3016); //$NON-NLS-1$
		case AffineRelationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/adfg?AffineRelation", AdfgElementTypes.AffineRelation_4002); //$NON-NLS-1$
		case GraphConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/adfg?GraphConnection", AdfgElementTypes.GraphConnection_4004); //$NON-NLS-1$
		case ChannelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/adfg?Channel", AdfgElementTypes.Channel_4005); //$NON-NLS-1$
		case LossyChannelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/adfg?LossyChannel", AdfgElementTypes.LossyChannel_4007); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = AdfgDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& AdfgElementTypes.isKnownElementType(elementType)) {
			image = AdfgElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof AdfgNavigatorGroup) {
			AdfgNavigatorGroup group = (AdfgNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof AdfgNavigatorItem) {
			AdfgNavigatorItem navigatorItem = (AdfgNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (AdfgVisualIDRegistry.getVisualID(view)) {
		case ApplicationEditPart.VISUAL_ID:
			return getApplication_1000Text(view);
		case GraphEditPart.VISUAL_ID:
			return getGraph_2001Text(view);
		case PeriodicActorEditPart.VISUAL_ID:
			return getPeriodicActor_3011Text(view);
		case InputPortEditPart.VISUAL_ID:
			return getInputPort_3012Text(view);
		case OutputPortEditPart.VISUAL_ID:
			return getOutputPort_3013Text(view);
		case AperiodicActorEditPart.VISUAL_ID:
			return getAperiodicActor_3014Text(view);
		case InputPort2EditPart.VISUAL_ID:
			return getInputPort_3015Text(view);
		case OutputPort2EditPart.VISUAL_ID:
			return getOutputPort_3016Text(view);
		case AffineRelationEditPart.VISUAL_ID:
			return getAffineRelation_4002Text(view);
		case GraphConnectionEditPart.VISUAL_ID:
			return getGraphConnection_4004Text(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4005Text(view);
		case LossyChannelEditPart.VISUAL_ID:
			return getLossyChannel_4007Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getGraph_2001Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.Graph_2001,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry.getType(GraphNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getChannel_4005Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.Channel_4005,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry
						.getType(ChannelInitialSizeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLossyChannel_4007Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.LossyChannel_4007,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry
						.getType(LossyChannelSizeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPort_3013Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.OutputPort_3013,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry.getType(OutputPortNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAffineRelation_4002Text(View view) {
		IParser parser = AdfgParserProvider
				.getParser(AdfgElementTypes.AffineRelation_4002, view
						.getElement() != null ? view.getElement() : view,
						AdfgVisualIDRegistry
								.getType(AffineRelationNEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPeriodicActor_3011Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.PeriodicActor_3011,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry
						.getType(PeriodicActorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAperiodicActor_3014Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.AperiodicActor_3014,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry
						.getType(AperiodicActorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getApplication_1000Text(View view) {
		Application domainModelElement = (Application) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPort_3015Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.InputPort_3015,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry.getType(InputPortName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGraphConnection_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutputPort_3016Text(View view) {
		IParser parser = AdfgParserProvider
				.getParser(AdfgElementTypes.OutputPort_3016,
						view.getElement() != null ? view.getElement() : view,
						AdfgVisualIDRegistry
								.getType(OutputPortName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputPort_3012Text(View view) {
		IParser parser = AdfgParserProvider.getParser(
				AdfgElementTypes.InputPort_3012,
				view.getElement() != null ? view.getElement() : view,
				AdfgVisualIDRegistry.getType(InputPortNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ApplicationEditPart.MODEL_ID.equals(AdfgVisualIDRegistry
				.getModelID(view));
	}

}
