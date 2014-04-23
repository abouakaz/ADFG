/**
 */
package adfg.provider;


import adfg.AdfgFactory;
import adfg.AdfgPackage;
import adfg.Graph;
import adfg.provider.custom.propertydescriptors.SCJItemPropertyDescriptor;

import java.text.DecimalFormat;
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
 * This is the item provider adapter for a {@link adfg.Graph} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphItemProvider
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
	public GraphItemProvider(AdapterFactory adapterFactory) {
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
			addProcessorUtilizationPropertyDescriptor(object);
			addBufferingRequirementsPropertyDescriptor(object);
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
				 getString("_UI_Graph_name_feature"),
				 getString("_UI_Graph_name_description"),
				 AdfgPackage.Literals.GRAPH__NAME,
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
				 getString("_UI_Graph_sourceCode_feature"),
				 getString("_UI_Graph_sourceCode_description"),
				 AdfgPackage.Literals.GRAPH__SOURCE_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	

	/**
	 * This adds a property descriptor for the Processor Utilization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addProcessorUtilizationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Graph_processorUtilization_feature"),
				 getString("_UI_Graph_processorUtilization_description"),
				 AdfgPackage.Literals.GRAPH__PROCESSOR_UTILIZATION,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 getString("_UI_AutomaticallycomputedPropertyCategory"),
				 null){
				@Override
				protected Object getValue(EObject object, EStructuralFeature feature){
					try {
						Double value=(Double)(object.eGet(feature)); 
						DecimalFormat df = new DecimalFormat("###,##0.0000");
						return (value<=0)?"":df.format(value);
					}
					catch (Throwable exception){ return null;}
				}
			});
	}

	/**
	 * This adds a property descriptor for the Buffering Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addBufferingRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Graph_bufferingRequirements_feature"),
				 getString("_UI_Graph_bufferingRequirements_description"),
				 AdfgPackage.Literals.GRAPH__BUFFERING_REQUIREMENTS,
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
			childrenFeatures.add(AdfgPackage.Literals.GRAPH__NODES);
			childrenFeatures.add(AdfgPackage.Literals.GRAPH__AFFINE_RELATIONS);
			childrenFeatures.add(AdfgPackage.Literals.GRAPH__CONNECTIONS);
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
	 * This returns Graph.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Graph"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Graph)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Graph_type") :
			getString("_UI_Graph_type") + " " + label;
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

		switch (notification.getFeatureID(Graph.class)) {
			case AdfgPackage.GRAPH__NAME:
			case AdfgPackage.GRAPH__NB_ACTORS:
			case AdfgPackage.GRAPH__NB_BUFFERS:
			case AdfgPackage.GRAPH__ID:
			case AdfgPackage.GRAPH__SOURCE_CODE:
			case AdfgPackage.GRAPH__PROCESSOR_UTILIZATION:
			case AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AdfgPackage.GRAPH__NODES:
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
			case AdfgPackage.GRAPH__CONNECTIONS:
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
				(AdfgPackage.Literals.GRAPH__NODES,
				 AdfgFactory.eINSTANCE.createPeriodicActor()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.GRAPH__NODES,
				 AdfgFactory.eINSTANCE.createAperiodicActor()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.GRAPH__AFFINE_RELATIONS,
				 AdfgFactory.eINSTANCE.createAffineRelation()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.GRAPH__CONNECTIONS,
				 AdfgFactory.eINSTANCE.createConnection()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.GRAPH__CONNECTIONS,
				 AdfgFactory.eINSTANCE.createChannel()));

		newChildDescriptors.add
			(createChildParameter
				(AdfgPackage.Literals.GRAPH__CONNECTIONS,
				 AdfgFactory.eINSTANCE.createLossyChannel()));
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
