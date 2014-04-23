package adfg.diagram.sheet;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.sheet.DefaultPropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.gmf.runtime.emf.ui.properties.descriptors.EMFCompositePropertySource;

import adfg.Port;
import adfg.provider.custom.propertydescriptors.SCJPropertyDescriptor;
import adfg.provider.custom.propertydescriptors.TypePropertyDescriptor;

/**
 * @generated
 */
public class AdfgPropertySection extends DefaultPropertySection implements
		IPropertySourceProvider {

	/**
	 * @generated NOT
	 */
	public IPropertySource getPropertySource(Object object) {
		if (object instanceof IPropertySource) {
			return (IPropertySource) object;
		}
		AdapterFactory af = getAdapterFactory(object);
		if (af != null) {
			IItemPropertySource ips = (IItemPropertySource) af.adapt(object,
					IItemPropertySource.class);
			if (ips != null) {
				return new EMFCompositePropertySource(object, ips, null) {
					protected IPropertyDescriptor newPropertyDescriptor(
							IItemPropertyDescriptor itemPropertyDescriptor) {
						if (object instanceof Port) {
							return new TypePropertyDescriptor(object,
									itemPropertyDescriptor, getCategory());
						} else {
							return new SCJPropertyDescriptor(object,
									itemPropertyDescriptor, getCategory());
						}
					}
				};
			}
		}
		if (object instanceof IAdaptable) {
			return (IPropertySource) ((IAdaptable) object)
					.getAdapter(IPropertySource.class);
		}
		return null;
	}

	/**
	 * Modify/unwrap selection.
	 * @generated
	 */
	@Override
	protected Object transformSelection(Object selected) {
		selected = /*super.*/transformSelectionToDomain(selected);
		return selected;
	}

}
