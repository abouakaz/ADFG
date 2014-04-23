/**
 */
package adfg.provider;


import adfg.Actor;
import adfg.AdfgPackage;
import adfg.PeriodicActor;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link adfg.PeriodicActor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PeriodicActorItemProvider
	extends ActorItemProvider
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
	public PeriodicActorItemProvider(AdapterFactory adapterFactory) {
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

			addPeriodPropertyDescriptor(object);
			addPeriodUpperBoundPropertyDescriptor(object);
			addPhasePropertyDescriptor(object);
			addPeriodLowerBoundPropertyDescriptor(object);
			addDeadlinePropertyDescriptor(object);
			addWcetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Period feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPeriodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PeriodicActor_period_feature"),
				 getString("_UI_PeriodicActor_period_description"),
				 AdfgPackage.Literals.PERIODIC_ACTOR__PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Long value=(Long)(object.eGet(feature));
						return (value<=0)?"":value;
					}
					catch (Throwable exception){ return null;}
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					Long v=(Long)value;
					if(v<=0) v=-1L;
					super.setPropertyValue(object, v);
				}
			});
	}

	/**
	 * This adds a property descriptor for the Period Upper Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPeriodUpperBoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PeriodicActor_periodUpperBound_feature"),
				 getString("_UI_PeriodicActor_periodUpperBound_description"),
				 AdfgPackage.Literals.PERIODIC_ACTOR__PERIOD_UPPER_BOUND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Long value=(Long)(object.eGet(feature));
						return (value<=0)?"":value;
					}
					catch (Throwable exception){ return null;}
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					Long v=(Long)value;
					if(v<=0) v=-1L;
					super.setPropertyValue(object, v);
				}	
				});
	}

	/**
	 * This adds a property descriptor for the Phase feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPhasePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PeriodicActor_phase_feature"),
				 getString("_UI_PeriodicActor_phase_description"),
				 AdfgPackage.Literals.PERIODIC_ACTOR__PHASE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_AutomaticallycomputedPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Long value=(Long)(object.eGet(feature));
						return (value<0)?"":value;
					}
					catch (Throwable exception){ return null;}
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					Long v=(Long)value;
					if(v<0) v=-1L;
					super.setPropertyValue(object, v);
				}		
				});
	}

	/**
	 * This adds a property descriptor for the Period Lower Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPeriodLowerBoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PeriodicActor_periodLowerBound_feature"),
				 getString("_UI_PeriodicActor_periodLowerBound_description"),
				 AdfgPackage.Literals.PERIODIC_ACTOR__PERIOD_LOWER_BOUND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Long value=(Long)(object.eGet(feature));
						return (value<=0)?"":value;
					}
					catch (Throwable exception){ return null;}
				}
				@Override
				public void setPropertyValue(Object object, Object value){
					Long v=(Long)value;
					if(v<=0) v=-2L;
						super.setPropertyValue(object, v);
				}	
				});
	}

	/**
	 * This adds a property descriptor for the Deadline feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDeadlinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PeriodicActor_deadline_feature"),
				 getString("_UI_PeriodicActor_deadline_description"),
				 AdfgPackage.Literals.PERIODIC_ACTOR__DEADLINE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null){
				@Override
				public void setPropertyValue(Object object, Object value){
					String v=(String)value;
					String oldValue=(String)(((EObject)object).eGet(feature));
					
					if(!v.matches("[0-9]+/[0-9]+")) v=oldValue;
					else{
						String[] ab=v.split("/");  int a=Integer.parseInt(ab[0]), b=Integer.parseInt(ab[1]);
						if(b==0 || a>b) v=oldValue;
						else v=a+"/"+b;
					}
					super.setPropertyValue(object, v);
				}	
				});
	}

	/**
	 * This adds a property descriptor for the Wcet feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWcetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PeriodicActor_wcet_feature"),
				 getString("_UI_PeriodicActor_wcet_description"),
				 AdfgPackage.Literals.PERIODIC_ACTOR__WCET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null){
				@Override
				public void setPropertyValue(Object object, Object value){
					Long v=(Long)value;
					Long oldValue=(Long)(((EObject)object).eGet(feature));
					if(v<=0) v=oldValue;
					super.setPropertyValue(object, v);
				}
			});
	}

	/**
	 * This returns PeriodicActor.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PeriodicActor"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PeriodicActor)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_PeriodicActor_type") :
			getString("_UI_PeriodicActor_type") + " " + label;
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

		switch (notification.getFeatureID(PeriodicActor.class)) {
			case AdfgPackage.PERIODIC_ACTOR__PERIOD:
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_UPPER_BOUND:
			case AdfgPackage.PERIODIC_ACTOR__PHASE:
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_LOWER_BOUND:
			case AdfgPackage.PERIODIC_ACTOR__DEADLINE:
			case AdfgPackage.PERIODIC_ACTOR__WCET:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
