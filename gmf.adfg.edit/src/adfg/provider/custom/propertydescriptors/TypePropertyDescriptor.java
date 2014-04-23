package adfg.provider.custom.propertydescriptors;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.gmf.runtime.emf.ui.properties.descriptors.EMFCompositeSourcePropertyDescriptor;




public class TypePropertyDescriptor extends EMFCompositeSourcePropertyDescriptor {

	   IItemPropertyDescriptor itemPropertyDescriptor;
		
	   public TypePropertyDescriptor(Object object,
			IItemPropertyDescriptor itemPropertyDescriptor, String category) {
		   super(object, itemPropertyDescriptor, category);
		   this.itemPropertyDescriptor = itemPropertyDescriptor;
	   }

	   protected CellEditor doCreateEditor(Composite composite) {
		   if (itemPropertyDescriptor instanceof TypeItemPropertyDescriptor) {
			   return new ClassSelectingEditor(composite);
		   }
		   return super.doCreateEditor(composite);
	   }
}
