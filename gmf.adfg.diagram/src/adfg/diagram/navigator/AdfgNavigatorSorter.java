package adfg.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import adfg.diagram.part.AdfgVisualIDRegistry;

/**
 * @generated
 */
public class AdfgNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof AdfgNavigatorItem) {
			AdfgNavigatorItem item = (AdfgNavigatorItem) element;
			return AdfgVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
