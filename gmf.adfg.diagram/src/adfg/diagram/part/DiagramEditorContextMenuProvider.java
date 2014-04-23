package adfg.diagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.gef.ui.actions.ActionRegistry;

import adfg.diagram.part.adfgActions.AnalysisAction;
import adfg.diagram.part.adfgActions.ResetAction;
import adfg.diagram.part.adfgActions.SCJCodeGenerationAction;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends
		DiagramContextMenuProvider {

	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	private DeleteElementAction deleteAction;

	/**
	 * @generated
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part,
			EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new DeleteElementAction(part);
		deleteAction.init();
	}

	/**
	 * @generated
	 */
	public void dispose() {
		if (deleteAction != null) {
			deleteAction.dispose();
			deleteAction = null;
		}
		super.dispose();
	}

	/**
	 * @generated NOT
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		final ActionRegistry actionRegistry = this.getActionRegistry();
		try {
			TransactionUtil.getEditingDomain(
					(EObject) getViewer().getContents().getModel())
					.runExclusive(new Runnable() {

						public void run() {
							ContributionItemService
									.getInstance()
									.contributeToPopupMenu(
											DiagramEditorContextMenuProvider.this,
											part);
							menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
							menu.appendToGroup("editGroup", deleteAction);
							//Added
							MenuManager subMenu = new MenuManager(
									"ADFG Actions",
									AdfgDiagramEditorPlugin
											.findImageDescriptor("/gmf.adfg.edit/icons/full/obj16/PeriodicActor.gif"),
									null);

							IAction action1 = actionRegistry
									.getAction(AnalysisAction.ANALYSIS);
							subMenu.add(action1);

							IAction action2 = actionRegistry
									.getAction(SCJCodeGenerationAction.SCJ_Code_Generation);
							subMenu.add(action2);
							
							IAction action3 = actionRegistry
							.getAction(ResetAction.Reset_Action);
							subMenu.add(action3);
							
							menu.add(subMenu);

						}
					});
		} catch (Exception e) {
			AdfgDiagramEditorPlugin.getInstance().logError(
					"Error building context menu", e);
		}
	}
}
