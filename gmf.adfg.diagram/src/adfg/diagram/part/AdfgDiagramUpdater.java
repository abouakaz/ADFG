package adfg.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import adfg.Actor;
import adfg.AdfgPackage;
import adfg.AffineRelation;
import adfg.AperiodicActor;
import adfg.Application;
import adfg.Channel;
import adfg.Graph;
import adfg.GraphConnection;
import adfg.InputPort;
import adfg.LossyChannel;
import adfg.OutputPort;
import adfg.PeriodicActor;
import adfg.Port;
import adfg.diagram.edit.parts.AffineRelationEditPart;
import adfg.diagram.edit.parts.AperiodicActorEditPart;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.edit.parts.ChannelEditPart;
import adfg.diagram.edit.parts.GraphConnectionEditPart;
import adfg.diagram.edit.parts.GraphEditPart;
import adfg.diagram.edit.parts.GraphGraphCompartmentFigureEditPart;
import adfg.diagram.edit.parts.InputPort2EditPart;
import adfg.diagram.edit.parts.InputPortEditPart;
import adfg.diagram.edit.parts.LossyChannelEditPart;
import adfg.diagram.edit.parts.OutputPort2EditPart;
import adfg.diagram.edit.parts.OutputPortEditPart;
import adfg.diagram.edit.parts.PeriodicActorEditPart;
import adfg.diagram.providers.AdfgElementTypes;

/**
 * @generated
 */
public class AdfgDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<AdfgNodeDescriptor> getSemanticChildren(View view) {
		switch (AdfgVisualIDRegistry.getVisualID(view)) {
		case ApplicationEditPart.VISUAL_ID:
			return getApplication_1000SemanticChildren(view);
		case PeriodicActorEditPart.VISUAL_ID:
			return getPeriodicActor_3011SemanticChildren(view);
		case AperiodicActorEditPart.VISUAL_ID:
			return getAperiodicActor_3014SemanticChildren(view);
		case GraphGraphCompartmentFigureEditPart.VISUAL_ID:
			return getGraphGraphCompartmentFigure_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgNodeDescriptor> getApplication_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Application modelElement = (Application) view.getElement();
		LinkedList<AdfgNodeDescriptor> result = new LinkedList<AdfgNodeDescriptor>();
		for (Iterator<?> it = modelElement.getGraphs().iterator(); it.hasNext();) {
			Graph childElement = (Graph) it.next();
			int visualID = AdfgVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == GraphEditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgNodeDescriptor> getPeriodicActor_3011SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		PeriodicActor modelElement = (PeriodicActor) view.getElement();
		LinkedList<AdfgNodeDescriptor> result = new LinkedList<AdfgNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPorts().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = AdfgVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InputPortEditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OutputPortEditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgNodeDescriptor> getAperiodicActor_3014SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		AperiodicActor modelElement = (AperiodicActor) view.getElement();
		LinkedList<AdfgNodeDescriptor> result = new LinkedList<AdfgNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPorts().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = AdfgVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InputPort2EditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OutputPort2EditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgNodeDescriptor> getGraphGraphCompartmentFigure_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Graph modelElement = (Graph) containerView.getElement();
		LinkedList<AdfgNodeDescriptor> result = new LinkedList<AdfgNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			Actor childElement = (Actor) it.next();
			int visualID = AdfgVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PeriodicActorEditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AperiodicActorEditPart.VISUAL_ID) {
				result.add(new AdfgNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getContainedLinks(View view) {
		switch (AdfgVisualIDRegistry.getVisualID(view)) {
		case ApplicationEditPart.VISUAL_ID:
			return getApplication_1000ContainedLinks(view);
		case GraphEditPart.VISUAL_ID:
			return getGraph_2001ContainedLinks(view);
		case PeriodicActorEditPart.VISUAL_ID:
			return getPeriodicActor_3011ContainedLinks(view);
		case InputPortEditPart.VISUAL_ID:
			return getInputPort_3012ContainedLinks(view);
		case OutputPortEditPart.VISUAL_ID:
			return getOutputPort_3013ContainedLinks(view);
		case AperiodicActorEditPart.VISUAL_ID:
			return getAperiodicActor_3014ContainedLinks(view);
		case InputPort2EditPart.VISUAL_ID:
			return getInputPort_3015ContainedLinks(view);
		case OutputPort2EditPart.VISUAL_ID:
			return getOutputPort_3016ContainedLinks(view);
		case AffineRelationEditPart.VISUAL_ID:
			return getAffineRelation_4002ContainedLinks(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4005ContainedLinks(view);
		case GraphConnectionEditPart.VISUAL_ID:
			return getGraphConnection_4004ContainedLinks(view);
		case LossyChannelEditPart.VISUAL_ID:
			return getLossyChannel_4007ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getIncomingLinks(View view) {
		switch (AdfgVisualIDRegistry.getVisualID(view)) {
		case GraphEditPart.VISUAL_ID:
			return getGraph_2001IncomingLinks(view);
		case PeriodicActorEditPart.VISUAL_ID:
			return getPeriodicActor_3011IncomingLinks(view);
		case InputPortEditPart.VISUAL_ID:
			return getInputPort_3012IncomingLinks(view);
		case OutputPortEditPart.VISUAL_ID:
			return getOutputPort_3013IncomingLinks(view);
		case AperiodicActorEditPart.VISUAL_ID:
			return getAperiodicActor_3014IncomingLinks(view);
		case InputPort2EditPart.VISUAL_ID:
			return getInputPort_3015IncomingLinks(view);
		case OutputPort2EditPart.VISUAL_ID:
			return getOutputPort_3016IncomingLinks(view);
		case AffineRelationEditPart.VISUAL_ID:
			return getAffineRelation_4002IncomingLinks(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4005IncomingLinks(view);
		case GraphConnectionEditPart.VISUAL_ID:
			return getGraphConnection_4004IncomingLinks(view);
		case LossyChannelEditPart.VISUAL_ID:
			return getLossyChannel_4007IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutgoingLinks(View view) {
		switch (AdfgVisualIDRegistry.getVisualID(view)) {
		case GraphEditPart.VISUAL_ID:
			return getGraph_2001OutgoingLinks(view);
		case PeriodicActorEditPart.VISUAL_ID:
			return getPeriodicActor_3011OutgoingLinks(view);
		case InputPortEditPart.VISUAL_ID:
			return getInputPort_3012OutgoingLinks(view);
		case OutputPortEditPart.VISUAL_ID:
			return getOutputPort_3013OutgoingLinks(view);
		case AperiodicActorEditPart.VISUAL_ID:
			return getAperiodicActor_3014OutgoingLinks(view);
		case InputPort2EditPart.VISUAL_ID:
			return getInputPort_3015OutgoingLinks(view);
		case OutputPort2EditPart.VISUAL_ID:
			return getOutputPort_3016OutgoingLinks(view);
		case AffineRelationEditPart.VISUAL_ID:
			return getAffineRelation_4002OutgoingLinks(view);
		case ChannelEditPart.VISUAL_ID:
			return getChannel_4005OutgoingLinks(view);
		case GraphConnectionEditPart.VISUAL_ID:
			return getGraphConnection_4004OutgoingLinks(view);
		case LossyChannelEditPart.VISUAL_ID:
			return getLossyChannel_4007OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getApplication_1000ContainedLinks(
			View view) {
		Application modelElement = (Application) view.getElement();
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_GraphConnection_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getGraph_2001ContainedLinks(View view) {
		Graph modelElement = (Graph) view.getElement();
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_AffineRelation_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Channel_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_LossyChannel_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getPeriodicActor_3011ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getInputPort_3012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutputPort_3013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getAperiodicActor_3014ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getInputPort_3015ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutputPort_3016ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getAffineRelation_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getChannel_4005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getGraphConnection_4004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getLossyChannel_4007ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getGraph_2001IncomingLinks(View view) {
		Graph modelElement = (Graph) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_GraphConnection_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getPeriodicActor_3011IncomingLinks(
			View view) {
		PeriodicActor modelElement = (PeriodicActor) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_AffineRelation_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getInputPort_3012IncomingLinks(
			View view) {
		InputPort modelElement = (InputPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Channel_4005(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LossyChannel_4007(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutputPort_3013IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getAperiodicActor_3014IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getInputPort_3015IncomingLinks(
			View view) {
		InputPort modelElement = (InputPort) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Channel_4005(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_LossyChannel_4007(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutputPort_3016IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getAffineRelation_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getChannel_4005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getGraphConnection_4004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getLossyChannel_4007IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getGraph_2001OutgoingLinks(View view) {
		Graph modelElement = (Graph) view.getElement();
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_GraphConnection_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getPeriodicActor_3011OutgoingLinks(
			View view) {
		PeriodicActor modelElement = (PeriodicActor) view.getElement();
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_AffineRelation_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getInputPort_3012OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutputPort_3013OutgoingLinks(
			View view) {
		OutputPort modelElement = (OutputPort) view.getElement();
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Channel_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LossyChannel_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getAperiodicActor_3014OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getInputPort_3015OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getOutputPort_3016OutgoingLinks(
			View view) {
		OutputPort modelElement = (OutputPort) view.getElement();
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Channel_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_LossyChannel_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getAffineRelation_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getChannel_4005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getGraphConnection_4004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AdfgLinkDescriptor> getLossyChannel_4007OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getContainedTypeModelFacetLinks_AffineRelation_4002(
			Graph container) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getAffineRelations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AffineRelation) {
				continue;
			}
			AffineRelation link = (AffineRelation) linkObject;
			if (AffineRelationEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			PeriodicActor dst = link.getTarget();
			PeriodicActor src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.AffineRelation_4002,
					AffineRelationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getContainedTypeModelFacetLinks_Channel_4005(
			Graph container) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Channel) {
				continue;
			}
			Channel link = (Channel) linkObject;
			if (ChannelEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InputPort dst = link.getTarget();
			OutputPort src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.Channel_4005, ChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getContainedTypeModelFacetLinks_GraphConnection_4004(
			Application container) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getGraphConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GraphConnection) {
				continue;
			}
			GraphConnection link = (GraphConnection) linkObject;
			if (GraphConnectionEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Graph dst = link.getTarget();
			Graph src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.GraphConnection_4004,
					GraphConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getContainedTypeModelFacetLinks_LossyChannel_4007(
			Graph container) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof LossyChannel) {
				continue;
			}
			LossyChannel link = (LossyChannel) linkObject;
			if (LossyChannelEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InputPort dst = link.getTarget();
			OutputPort src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.LossyChannel_4007,
					LossyChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getIncomingTypeModelFacetLinks_AffineRelation_4002(
			PeriodicActor target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AdfgPackage.eINSTANCE
					.getAffineRelation_Target()
					|| false == setting.getEObject() instanceof AffineRelation) {
				continue;
			}
			AffineRelation link = (AffineRelation) setting.getEObject();
			if (AffineRelationEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			PeriodicActor src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, target, link,
					AdfgElementTypes.AffineRelation_4002,
					AffineRelationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getIncomingTypeModelFacetLinks_Channel_4005(
			InputPort target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AdfgPackage.eINSTANCE
					.getConnection_Target()
					|| false == setting.getEObject() instanceof Channel) {
				continue;
			}
			Channel link = (Channel) setting.getEObject();
			if (ChannelEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OutputPort src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, target, link,
					AdfgElementTypes.Channel_4005, ChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getIncomingTypeModelFacetLinks_GraphConnection_4004(
			Graph target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AdfgPackage.eINSTANCE
					.getGraphConnection_Target()
					|| false == setting.getEObject() instanceof GraphConnection) {
				continue;
			}
			GraphConnection link = (GraphConnection) setting.getEObject();
			if (GraphConnectionEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Graph src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, target, link,
					AdfgElementTypes.GraphConnection_4004,
					GraphConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getIncomingTypeModelFacetLinks_LossyChannel_4007(
			InputPort target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AdfgPackage.eINSTANCE
					.getConnection_Target()
					|| false == setting.getEObject() instanceof LossyChannel) {
				continue;
			}
			LossyChannel link = (LossyChannel) setting.getEObject();
			if (LossyChannelEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OutputPort src = link.getSource();
			result.add(new AdfgLinkDescriptor(src, target, link,
					AdfgElementTypes.LossyChannel_4007,
					LossyChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getOutgoingTypeModelFacetLinks_AffineRelation_4002(
			PeriodicActor source) {
		Graph container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Graph) {
				container = (Graph) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getAffineRelations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof AffineRelation) {
				continue;
			}
			AffineRelation link = (AffineRelation) linkObject;
			if (AffineRelationEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			PeriodicActor dst = link.getTarget();
			PeriodicActor src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.AffineRelation_4002,
					AffineRelationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getOutgoingTypeModelFacetLinks_Channel_4005(
			OutputPort source) {
		Graph container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Graph) {
				container = (Graph) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Channel) {
				continue;
			}
			Channel link = (Channel) linkObject;
			if (ChannelEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InputPort dst = link.getTarget();
			OutputPort src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.Channel_4005, ChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getOutgoingTypeModelFacetLinks_GraphConnection_4004(
			Graph source) {
		Application container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Application) {
				container = (Application) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getGraphConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof GraphConnection) {
				continue;
			}
			GraphConnection link = (GraphConnection) linkObject;
			if (GraphConnectionEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Graph dst = link.getTarget();
			Graph src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.GraphConnection_4004,
					GraphConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AdfgLinkDescriptor> getOutgoingTypeModelFacetLinks_LossyChannel_4007(
			OutputPort source) {
		Graph container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Graph) {
				container = (Graph) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<AdfgLinkDescriptor> result = new LinkedList<AdfgLinkDescriptor>();
		for (Iterator<?> links = container.getConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof LossyChannel) {
				continue;
			}
			LossyChannel link = (LossyChannel) linkObject;
			if (LossyChannelEditPart.VISUAL_ID != AdfgVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InputPort dst = link.getTarget();
			OutputPort src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new AdfgLinkDescriptor(src, dst, link,
					AdfgElementTypes.LossyChannel_4007,
					LossyChannelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<AdfgNodeDescriptor> getSemanticChildren(View view) {
			return AdfgDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<AdfgLinkDescriptor> getContainedLinks(View view) {
			return AdfgDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<AdfgLinkDescriptor> getIncomingLinks(View view) {
			return AdfgDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<AdfgLinkDescriptor> getOutgoingLinks(View view) {
			return AdfgDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
