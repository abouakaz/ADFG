package adfg.diagram.sheet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.gmf.runtime.emf.ui.properties.sections.UndoableModelPropertySheetEntry;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

public class AdfgPropertySheetEntry extends UndoableModelPropertySheetEntry {

	public AdfgPropertySheetEntry(IOperationHistory operationHistory) {
	      super(operationHistory);
	}
	
	 /**
	  * Overrides the super method to avoid ordering attributes, and so keep the order defined in the ecore model. 
	  * @return sorted <code>List</code> of all the <code>IPropertyDescriptor</code>s for the objects 
	  */
	 protected List computeMergedPropertyDescriptors() {
	      if (values.length == 0) return new ArrayList(0);
          // get all descriptors from each object
	      Map[] propertyDescriptorMaps = new Map[values.length];
	      for (int i = 0; i < values.length; i++) {
	    	  Object object = values[i];
	          IPropertySource source = getPropertySource(object);
	          if (source == null){
	        	  // if one of the selected items is not a property source then we show no properties
	              return new ArrayList(0);
	          }
	          // get the property descriptors keyed by id
	          propertyDescriptorMaps[i] = computePropertyDescriptorsFor(source);
	      }
          // intersect
	      Map intersection = propertyDescriptorMaps[0];
	      for (int i = 1; i < propertyDescriptorMaps.length; i++){
	    	  // get the current ids
	          Object[] ids = intersection.keySet().toArray();
	          for (int j = 0; j < ids.length; j++) {
	        	  Object object = propertyDescriptorMaps[i].get(ids[j]);
	              if (object == null ||
	            	   // see if the descriptors (which have the same id) are compatible
	                  !((IPropertyDescriptor) intersection.get(ids[j])).isCompatibleWith((IPropertyDescriptor) object))
	               intersection.remove(ids[j]);
	          }
	       }
           // Sort the descriptors
	       List descriptors = new ArrayList(intersection.values());
           return descriptors;
	   }
	 
	 /**
	  * Overrides the super method to avoid ordering attributes, and so keep the
	  * order defined in the ecore model.
	  * The difference with the super method is that a LinkedHashMap is used instead of a HashMap,
	  * in order to keep the properties order.
	  * 
	  * @param source a property source for which to obtain descriptors
	  * @return a table of descriptors keyed on their id
	  */
	 protected Map computePropertyDescriptorsFor(IPropertySource source) {
		 IPropertyDescriptor[] descriptors = source.getPropertyDescriptors();
	     // Use LinkedHashMap instead of HashMap to preserve order
	     Map result = new LinkedHashMap();
	     for (int i = 0; i < descriptors.length; i++) {
	         result.put(descriptors[i].getId(), descriptors[i]);
	     }
	     return result;
	 }

}

