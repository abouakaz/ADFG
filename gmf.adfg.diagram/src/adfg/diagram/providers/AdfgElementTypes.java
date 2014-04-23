package adfg.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import adfg.AdfgPackage;
import adfg.diagram.edit.parts.AffineRelationEditPart;
import adfg.diagram.edit.parts.AperiodicActorEditPart;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.ChannelEditPart;
import adfg.diagram.edit.parts.GraphConnectionEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.edit.parts.InputPort2EditPart;
import adfg.diagram.edit.parts.InputPortEditPart;
import adfg.diagram.edit.parts.LossyChannelEditPart;
import adfg.diagram.edit.parts.OutputPort2EditPart;
import adfg.diagram.edit.parts.OutputPortEditPart;
import adfg.diagram.edit.parts.PeriodicActorEditPart;
import adfg.diagram.part.AdfgDiagramEditorPlugin;

/**
 * @generated
 */
public class AdfgElementTypes {

	/**
	 * @generated
	 */
	private AdfgElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			AdfgDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Application_1000 = getElementType("gmf.adfg.diagram.Application_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Graph_2001 = getElementType("gmf.adfg.diagram.Graph_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PeriodicActor_3011 = getElementType("gmf.adfg.diagram.PeriodicActor_3011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InputPort_3012 = getElementType("gmf.adfg.diagram.InputPort_3012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OutputPort_3013 = getElementType("gmf.adfg.diagram.OutputPort_3013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AperiodicActor_3014 = getElementType("gmf.adfg.diagram.AperiodicActor_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InputPort_3015 = getElementType("gmf.adfg.diagram.InputPort_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutputPort_3016 = getElementType("gmf.adfg.diagram.OutputPort_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AffineRelation_4002 = getElementType("gmf.adfg.diagram.AffineRelation_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Channel_4005 = getElementType("gmf.adfg.diagram.Channel_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GraphConnection_4004 = getElementType("gmf.adfg.diagram.GraphConnection_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LossyChannel_4007 = getElementType("gmf.adfg.diagram.LossyChannel_4007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Application_1000,
					AdfgPackage.eINSTANCE.getApplication());

			elements.put(Graph_2001, AdfgPackage.eINSTANCE.getGraph());

			elements.put(PeriodicActor_3011,
					AdfgPackage.eINSTANCE.getPeriodicActor());

			elements.put(InputPort_3012, AdfgPackage.eINSTANCE.getInputPort());

			elements.put(OutputPort_3013, AdfgPackage.eINSTANCE.getOutputPort());

			elements.put(AperiodicActor_3014,
					AdfgPackage.eINSTANCE.getAperiodicActor());

			elements.put(InputPort_3015, AdfgPackage.eINSTANCE.getInputPort());

			elements.put(OutputPort_3016, AdfgPackage.eINSTANCE.getOutputPort());

			elements.put(AffineRelation_4002,
					AdfgPackage.eINSTANCE.getAffineRelation());

			elements.put(Channel_4005, AdfgPackage.eINSTANCE.getChannel());

			elements.put(GraphConnection_4004,
					AdfgPackage.eINSTANCE.getGraphConnection());

			elements.put(LossyChannel_4007,
					AdfgPackage.eINSTANCE.getLossyChannel());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Application_1000);
			KNOWN_ELEMENT_TYPES.add(Graph_2001);
			KNOWN_ELEMENT_TYPES.add(PeriodicActor_3011);
			KNOWN_ELEMENT_TYPES.add(InputPort_3012);
			KNOWN_ELEMENT_TYPES.add(OutputPort_3013);
			KNOWN_ELEMENT_TYPES.add(AperiodicActor_3014);
			KNOWN_ELEMENT_TYPES.add(InputPort_3015);
			KNOWN_ELEMENT_TYPES.add(OutputPort_3016);
			KNOWN_ELEMENT_TYPES.add(AffineRelation_4002);
			KNOWN_ELEMENT_TYPES.add(Channel_4005);
			KNOWN_ELEMENT_TYPES.add(GraphConnection_4004);
			KNOWN_ELEMENT_TYPES.add(LossyChannel_4007);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ApplicationEditPart.VISUAL_ID:
			return Application_1000;
		case GraphEditPart.VISUAL_ID:
			return Graph_2001;
		case PeriodicActorEditPart.VISUAL_ID:
			return PeriodicActor_3011;
		case InputPortEditPart.VISUAL_ID:
			return InputPort_3012;
		case OutputPortEditPart.VISUAL_ID:
			return OutputPort_3013;
		case AperiodicActorEditPart.VISUAL_ID:
			return AperiodicActor_3014;
		case InputPort2EditPart.VISUAL_ID:
			return InputPort_3015;
		case OutputPort2EditPart.VISUAL_ID:
			return OutputPort_3016;
		case AffineRelationEditPart.VISUAL_ID:
			return AffineRelation_4002;
		case ChannelEditPart.VISUAL_ID:
			return Channel_4005;
		case GraphConnectionEditPart.VISUAL_ID:
			return GraphConnection_4004;
		case LossyChannelEditPart.VISUAL_ID:
			return LossyChannel_4007;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return adfg.diagram.providers.AdfgElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return adfg.diagram.providers.AdfgElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return adfg.diagram.providers.AdfgElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
