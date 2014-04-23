package adfg.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

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
import adfg.diagram.part.AdfgVisualIDRegistry;
import adfg.diagram.part.Messages;

/**
 * @generated
 */
public class AdfgNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public AdfgNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
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
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<AdfgNavigatorItem> result = new ArrayList<AdfgNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews, ApplicationEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof AdfgNavigatorGroup) {
			AdfgNavigatorGroup group = (AdfgNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof AdfgNavigatorItem) {
			AdfgNavigatorItem navigatorItem = (AdfgNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (AdfgVisualIDRegistry.getVisualID(view)) {

		case ApplicationEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			AdfgNavigatorGroup links = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_Application_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(GraphEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(AffineRelationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(ChannelEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(GraphConnectionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(LossyChannelEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case GraphEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			AdfgNavigatorGroup incominglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_Graph_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AdfgNavigatorGroup outgoinglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_Graph_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(GraphGraphCompartmentFigureEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					AdfgVisualIDRegistry
							.getType(PeriodicActorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(GraphGraphCompartmentFigureEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					AdfgVisualIDRegistry
							.getType(AperiodicActorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(GraphConnectionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(GraphConnectionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PeriodicActorEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			AdfgNavigatorGroup incominglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_PeriodicActor_3011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AdfgNavigatorGroup outgoinglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_PeriodicActor_3011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(InputPortEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(OutputPortEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(AffineRelationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(AffineRelationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InputPortEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			AdfgNavigatorGroup incominglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_InputPort_3012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(ChannelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(LossyChannelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OutputPortEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			AdfgNavigatorGroup outgoinglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_OutputPort_3013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(ChannelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(LossyChannelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AperiodicActorEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(InputPort2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(OutputPort2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case InputPort2EditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			AdfgNavigatorGroup incominglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_InputPort_3015_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(ChannelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(LossyChannelEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OutputPort2EditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Node sv = (Node) view;
			AdfgNavigatorGroup outgoinglinks = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_OutputPort_3016_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(ChannelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(LossyChannelEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AffineRelationEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AdfgNavigatorGroup target = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_AffineRelation_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AdfgNavigatorGroup source = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_AffineRelation_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(PeriodicActorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AdfgVisualIDRegistry
							.getType(PeriodicActorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case GraphConnectionEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AdfgNavigatorGroup target = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_GraphConnection_4004_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AdfgNavigatorGroup source = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_GraphConnection_4004_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(GraphEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(GraphEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ChannelEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AdfgNavigatorGroup target = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_Channel_4005_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AdfgNavigatorGroup source = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_Channel_4005_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(InputPortEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(InputPort2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(OutputPortEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(OutputPort2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case LossyChannelEditPart.VISUAL_ID: {
			LinkedList<AdfgAbstractNavigatorItem> result = new LinkedList<AdfgAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AdfgNavigatorGroup target = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_LossyChannel_4007_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AdfgNavigatorGroup source = new AdfgNavigatorGroup(
					Messages.NavigatorGroupName_LossyChannel_4007_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(InputPortEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(InputPort2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(OutputPortEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AdfgVisualIDRegistry.getType(OutputPort2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ApplicationEditPart.MODEL_ID.equals(AdfgVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<AdfgNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<AdfgNavigatorItem> result = new ArrayList<AdfgNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new AdfgNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof AdfgAbstractNavigatorItem) {
			AdfgAbstractNavigatorItem abstractNavigatorItem = (AdfgAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
