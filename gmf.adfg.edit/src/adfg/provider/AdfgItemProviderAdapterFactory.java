/**
 */
package adfg.provider;

import adfg.util.AdfgAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AdfgItemProviderAdapterFactory extends AdfgAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdfgItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.Application} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationItemProvider applicationItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.Application}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createApplicationAdapter() {
		if (applicationItemProvider == null) {
			applicationItemProvider = new ApplicationItemProvider(this);
		}

		return applicationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.Graph} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphItemProvider graphItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.Graph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphAdapter() {
		if (graphItemProvider == null) {
			graphItemProvider = new GraphItemProvider(this);
		}

		return graphItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.GraphConnection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphConnectionItemProvider graphConnectionItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.GraphConnection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphConnectionAdapter() {
		if (graphConnectionItemProvider == null) {
			graphConnectionItemProvider = new GraphConnectionItemProvider(this);
		}

		return graphConnectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.AffineRelation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AffineRelationItemProvider affineRelationItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.AffineRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAffineRelationAdapter() {
		if (affineRelationItemProvider == null) {
			affineRelationItemProvider = new AffineRelationItemProvider(this);
		}

		return affineRelationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.Connection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionItemProvider connectionItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConnectionAdapter() {
		if (connectionItemProvider == null) {
			connectionItemProvider = new ConnectionItemProvider(this);
		}

		return connectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.InputPort} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputPortItemProvider inputPortItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.InputPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputPortAdapter() {
		if (inputPortItemProvider == null) {
			inputPortItemProvider = new InputPortItemProvider(this);
		}

		return inputPortItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.OutputPort} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPortItemProvider outputPortItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.OutputPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOutputPortAdapter() {
		if (outputPortItemProvider == null) {
			outputPortItemProvider = new OutputPortItemProvider(this);
		}

		return outputPortItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.PeriodicActor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeriodicActorItemProvider periodicActorItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.PeriodicActor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPeriodicActorAdapter() {
		if (periodicActorItemProvider == null) {
			periodicActorItemProvider = new PeriodicActorItemProvider(this);
		}

		return periodicActorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.Channel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelItemProvider channelItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.Channel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChannelAdapter() {
		if (channelItemProvider == null) {
			channelItemProvider = new ChannelItemProvider(this);
		}

		return channelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.AperiodicActor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AperiodicActorItemProvider aperiodicActorItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.AperiodicActor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAperiodicActorAdapter() {
		if (aperiodicActorItemProvider == null) {
			aperiodicActorItemProvider = new AperiodicActorItemProvider(this);
		}

		return aperiodicActorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link adfg.LossyChannel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LossyChannelItemProvider lossyChannelItemProvider;

	/**
	 * This creates an adapter for a {@link adfg.LossyChannel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLossyChannelAdapter() {
		if (lossyChannelItemProvider == null) {
			lossyChannelItemProvider = new LossyChannelItemProvider(this);
		}

		return lossyChannelItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (applicationItemProvider != null) applicationItemProvider.dispose();
		if (graphItemProvider != null) graphItemProvider.dispose();
		if (graphConnectionItemProvider != null) graphConnectionItemProvider.dispose();
		if (affineRelationItemProvider != null) affineRelationItemProvider.dispose();
		if (connectionItemProvider != null) connectionItemProvider.dispose();
		if (inputPortItemProvider != null) inputPortItemProvider.dispose();
		if (outputPortItemProvider != null) outputPortItemProvider.dispose();
		if (periodicActorItemProvider != null) periodicActorItemProvider.dispose();
		if (channelItemProvider != null) channelItemProvider.dispose();
		if (aperiodicActorItemProvider != null) aperiodicActorItemProvider.dispose();
		if (lossyChannelItemProvider != null) lossyChannelItemProvider.dispose();
	}

}
