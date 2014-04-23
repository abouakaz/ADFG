package adfg.diagram.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import adfg.diagram.edit.parts.AdfgEditPartFactory;
import adfg.diagram.edit.parts.ApplicationEditPart;
import adfg.diagram.part.AdfgVisualIDRegistry;

/**
 * @generated
 */
public class AdfgEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public AdfgEditPartProvider() {
		super(new AdfgEditPartFactory(), AdfgVisualIDRegistry.TYPED_INSTANCE,
				ApplicationEditPart.MODEL_ID);
	}
}
