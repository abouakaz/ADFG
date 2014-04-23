/**
 */
package adfg.provider;


import adfg.AdfgFactory;
import adfg.AdfgPackage;
import adfg.Application;
import adfg.impl.ApplicationImpl;
import adfg.provider.custom.propertydescriptors.SCJItemPropertyDescriptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link adfg.Application} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplicationItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addNbProcessorsPropertyDescriptor(object);
			addDynamicCheckingPropertyDescriptor(object);
			addSchedulingAlgorithmPropertyDescriptor(object);
			addSourceCodePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Application_name_feature"),
				 getString("_UI_Application_name_description"),
				 AdfgPackage.Literals.APPLICATION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Nb Processors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNbProcessorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Application_nbProcessors_feature"),
				 getString("_UI_Application_nbProcessors_description"),
				 AdfgPackage.Literals.APPLICATION__NB_PROCESSORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null){
				@Override
				public void setPropertyValue(Object object, Object value){
					Integer v=(Integer)value;
					Integer oldValue=(Integer)(((EObject)object).eGet(feature));
					if(v<=0) v=oldValue;
					super.setPropertyValue(object, v);
				}
				});
	}

	/**
	 * This adds a property descriptor for the Dynamic Checking feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDynamicCheckingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Application_dynamicChecking_feature"),
				 getString("_UI_Application_dynamicChecking_description"),
				 AdfgPackage.Literals.APPLICATION__DYNAMIC_CHECKING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ToolPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Scheduling Algorithm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSchedulingAlgorithmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Application_schedulingAlgorithm_feature"),
				 getString("_UI_Application_schedulingAlgorithm_description"),
				 AdfgPackage.Literals.APPLICATION__SCHEDULING_ALGORITHM,
				 true,
				 false,
				 true,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_ToolPropertyCategory"),
				 null){
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					Collection<String> res = new ArrayList<String>();
					if(((ApplicationImpl)object).getNbProcessors()==1){
						res.add("User"); res.add("DM"); res.add("LOP"); res.add("UDH"); res.add("CLOP");
					}
					else{
						res.add("User, User"); res.add("DM, BF(SRTA)"); res.add("DM, BF(FBB-FFD)");
					}
					return res;
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					String v=(String)value;
					String oldValue=(String)(((EObject)object).eGet(feature));
					if(v==null || v.length()<2) v=oldValue;
					super.setPropertyValue(object, v);
				}
				
				@Override
				public String getDisplayName(Object object){
					int nb=((Application)object).getNbProcessors();
					if(nb==1) return "Priority assignment";
					else return "Priority assignment, Processor allocation";
				}
			});
	}

	/**
	 * This adds a property descriptor for the Source Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSourceCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new SCJItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Application_sourceCode_feature"),
				 getString("_UI_Application_sourceCode_description"),
				 AdfgPackage.Literals.APPLICATION__SOURCE_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AdfgPackage.Literals.APPLICATION__GRAPHS);
			childrenFeatures.add(AdfgPackage.Literals.APPLICATION__GRAPH_CONNECTIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Application.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Application"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Application)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Application_type") :
			getString("_UI_Application_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Application.class)) {
			case AdfgPackage.APPLICATION__NB_GRAPHS:
			case AdfgPackage.APPLICATION__NAME:
			case AdfgPackage.APPLICATION__NB_PROCESSORS:
			case AdfgPackage.APPLICATION__DYNAMIC_CHECKING:
			case AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM:
			case AdfgPackage.APPLICATION__SOURCE_CODE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AdfgPackage.APPLICATION__GRAPHS:
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.APPLICATION__GRAPHS,
				 AdfgFactory.eINSTANCE.createGraph()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.APPLICATION__GRAPH_CONNECTIONS,
				 AdfgFactory.eINSTANCE.createGraphConnection()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AdfgEditPlugin.INSTANCE;
	}

}
