package adfg.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import adfg.diagram.providers.AdfgElementTypes;

/**
 * @generated
 */
public class AdfgPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createMissions1Group());
		paletteRoot.add(createNodes2Group());
		paletteRoot.add(createNodeLinks3Group());
	}

	/**
	 * Creates "Missions" palette tool group
	 * @generated
	 */
	private PaletteContainer createMissions1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Missions1Group_title);
		paletteContainer.setId("createMissions1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Missions1Group_desc);
		paletteContainer.add(createMission1CreationTool());
		paletteContainer.add(createTransition2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Nodes2Group_title);
		paletteContainer.setId("createNodes2Group"); //$NON-NLS-1$
		paletteContainer.add(createPeriodicActor1CreationTool());
		paletteContainer.add(createInputPort2CreationTool());
		paletteContainer.add(createOutputPort3CreationTool());
		paletteContainer.add(createAperiodicActor4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "NodeLinks" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodeLinks3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.NodeLinks3Group_title);
		paletteContainer.setId("createNodeLinks3Group"); //$NON-NLS-1$
		paletteContainer.add(createChannel1CreationTool());
		paletteContainer.add(createAffineRelation2CreationTool());
		paletteContainer.add(createLossyChannel3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMission1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Mission1CreationTool_title,
				Messages.Mission1CreationTool_desc,
				Collections.singletonList(AdfgElementTypes.Graph_2001));
		entry.setId("createMission1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/Graph.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/Graph.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Transition2CreationTool_title,
				Messages.Transition2CreationTool_desc,
				Collections
						.singletonList(AdfgElementTypes.GraphConnection_4004));
		entry.setId("createTransition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/GraphConnection.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/GraphConnection.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPeriodicActor1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PeriodicActor1CreationTool_title,
				Messages.PeriodicActor1CreationTool_desc,
				Collections.singletonList(AdfgElementTypes.PeriodicActor_3011));
		entry.setId("createPeriodicActor1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/PeriodicActor.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/PeriodicActor.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputPort2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(AdfgElementTypes.InputPort_3012);
		types.add(AdfgElementTypes.InputPort_3015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputPort2CreationTool_title,
				Messages.InputPort2CreationTool_desc, types);
		entry.setId("createInputPort2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/InputPort.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/InputPort.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOutputPort3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(AdfgElementTypes.OutputPort_3013);
		types.add(AdfgElementTypes.OutputPort_3016);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OutputPort3CreationTool_title,
				Messages.OutputPort3CreationTool_desc, types);
		entry.setId("createOutputPort3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/OutputPort.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/OutputPort.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAperiodicActor4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AperiodicActor4CreationTool_title,
				Messages.AperiodicActor4CreationTool_desc,
				Collections.singletonList(AdfgElementTypes.AperiodicActor_3014));
		entry.setId("createAperiodicActor4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/AperiodicActor.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/AperiodicActor.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChannel1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Channel1CreationTool_title,
				Messages.Channel1CreationTool_desc,
				Collections.singletonList(AdfgElementTypes.Channel_4005));
		entry.setId("createChannel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/Channel.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/Channel.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAffineRelation2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AffineRelation2CreationTool_title,
				Messages.AffineRelation2CreationTool_desc,
				Collections.singletonList(AdfgElementTypes.AffineRelation_4002));
		entry.setId("createAffineRelation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/AffineRelation.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/AffineRelation.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLossyChannel3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.LossyChannel3CreationTool_title,
				Messages.LossyChannel3CreationTool_desc,
				Collections.singletonList(AdfgElementTypes.LossyChannel_4007));
		entry.setId("createLossyChannel3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/LossyChannel.gif")); //$NON-NLS-1$
		entry.setLargeIcon(AdfgDiagramEditorPlugin
				.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/LossyChannel.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private static class NodeToolEntry extends PaletteToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated NOT
		 */
		private NodeToolEntry(
				String title,
				String description,
				List/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/elementTypes) {
			super(null, title, null);
			this.setDescription(description);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
