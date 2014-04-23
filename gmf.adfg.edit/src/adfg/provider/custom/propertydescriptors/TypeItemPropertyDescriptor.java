package adfg.provider.custom.propertydescriptors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;


public class TypeItemPropertyDescriptor extends ItemPropertyDescriptor {
	
          EStructuralFeature feature;
	
	public TypeItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			boolean multiLine, boolean sortChoices, Object staticImage,
			String category, String[] filterFlags) {
		super(adapterFactory, resourceLocator, displayName, description, feature,
				isSettable, multiLine, sortChoices, staticImage, category, filterFlags);
		this.feature = feature;
	}
	
	@Override
	protected Object getValue(EObject object, EStructuralFeature feature) {
		Object propertyObject = object.eGet(feature);
		if (propertyObject == null) return null;
		if (propertyObject instanceof Class){   
				return ((Class)propertyObject).getCanonicalName();
		}
		return super.getValue(object, feature);
	}

	@Override
	public void setPropertyValue(Object object, Object value) {
		if (object instanceof EObject) {
			EObject eobject = (EObject) object;
			eobject.eSet(feature, (Class)value);
			return;
		}
		super.setPropertyValue(object, value);
	}
	
}
