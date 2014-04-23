package adfg.provider.custom.propertydescriptors;

import org.eclipse.gmf.runtime.emf.ui.properties.descriptors.EMFCompositeSourcePropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

import adfg.Actor;

public class SCJPropertyDescriptor extends EMFCompositeSourcePropertyDescriptor {

	IItemPropertyDescriptor itemPropertyDescriptor;
	
	public SCJPropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor, String category) {
		super(object, itemPropertyDescriptor, category);
		this.itemPropertyDescriptor = itemPropertyDescriptor;
	}
	
	protected CellEditor doCreateEditor(Composite composite) {
		if (itemPropertyDescriptor instanceof SCJItemPropertyDescriptor) {
			return new SCJEditor(composite, getEditLabelProvider(), getObject());
		}
		return super.doCreateEditor(composite);
	}
	   
}
