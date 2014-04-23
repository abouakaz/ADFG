/**
 */
package adfg.provider;


import adfg.Actor;
import adfg.AdfgFactory;
import adfg.AdfgPackage;
import adfg.provider.custom.propertydescriptors.SCJItemPropertyDescriptor;

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
 * This is the item provider adapter for a {@link adfg.Actor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActorItemProvider
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
	public ActorItemProvider(AdapterFactory adapterFactory) {
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
			addSourceCodePropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addProcNumberPropertyDescriptor(object);
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
				 getString("_UI_Actor_name_feature"),
				 getString("_UI_Actor_name_description"),
				 AdfgPackage.Literals.ACTOR__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
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
				 getString("_UI_Actor_sourceCode_feature"),
				 getString("_UI_Actor_sourceCode_description"),
				 AdfgPackage.Literals.ACTOR__SOURCE_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Actor_priority_feature"),
				 getString("_UI_Actor_priority_description"),
				 AdfgPackage.Literals.ACTOR__PRIORITY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AutomaticallycomputedPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Integer value=(Integer)(object.eGet(feature));
						return (value<=0)?"":value;
					}
					catch (Throwable exception){ return null;}
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					Integer v=(Integer)value;
					if(v<=0) v=0;
					super.setPropertyValue(object, v);
				}
				
				@Override
				public String getCategory(Object object){
					String scheduling=((Actor)object).getOwner().getOwner().getSchedulingAlgorithm();
					if(scheduling.equals("User") || scheduling.equals("User, User"))
					        return getString("_UI_BasicPropertyCategory");
					else return getString("_UI_AutomaticallycomputedPropertyCategory");
				}
				
				@Override
				public boolean canSetProperty(Object object){
					String scheduling=((Actor)object).getOwner().getOwner().getSchedulingAlgorithm();
					if(scheduling.equals("User") || scheduling.equals("User, User"))
					        return true;
					else return false;
				}
			});
	}

	/**
	 * This adds a property descriptor for the Proc Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addProcNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Actor_procNumber_feature"),
				 getString("_UI_Actor_procNumber_description"),
				 AdfgPackage.Literals.ACTOR__PROC_NUMBER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AutomaticallycomputedPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Integer value=(Integer)(object.eGet(feature));
						if(((Actor)object).getOwner().getOwner().getNbProcessors()<2) value=1;
						return (value<=0)?"":value;
					}
					catch (Throwable exception){ return null;}
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					Integer v=(Integer)value;
					if(v<=0 || v>((Actor)object).getOwner().getOwner().getNbProcessors()) v=0;
					super.setPropertyValue(object, v);
				}
				
				@Override
				public String getCategory(Object object){
					String scheduling=((Actor)object).getOwner().getOwner().getSchedulingAlgorithm();
					if(scheduling.equals("User, User"))
					        return getString("_UI_BasicPropertyCategory");
					else return getString("_UI_AutomaticallycomputedPropertyCategory");
				}
				
				@Override
				public String getDisplayName(Object object){
					return "Processor number";
				}
				
				@Override
				public boolean canSetProperty(Object object){
					String scheduling=((Actor)object).getOwner().getOwner().getSchedulingAlgorithm();
					if(scheduling.equals("User, User"))
					        return true;
					else return false;
				}
			});
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
			childrenFeatures.add(AdfgPackage.Literals.ACTOR__PORTS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Actor)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Actor_type") :
			getString("_UI_Actor_type") + " " + label;
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

		switch (notification.getFeatureID(Actor.class)) {
			case AdfgPackage.ACTOR__NB_PORTS:
			case AdfgPackage.ACTOR__NAME:
			case AdfgPackage.ACTOR__SOURCE_CODE:
			case AdfgPackage.ACTOR__PRIORITY:
			case AdfgPackage.ACTOR__PROC_NUMBER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AdfgPackage.ACTOR__PORTS:
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
				(AdfgPackage.Literals.ACTOR__PORTS,
				 AdfgFactory.eINSTANCE.createInputPort()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.ACTOR__PORTS,
				 AdfgFactory.eINSTANCE.createOutputPort()));
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
