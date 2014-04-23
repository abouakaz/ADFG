/**
 */
package adfg.impl;

import adfg.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EDataType;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdfgFactoryImpl extends EFactoryImpl implements AdfgFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdfgFactory init() {
		try {
			AdfgFactory theAdfgFactory = (AdfgFactory)EPackage.Registry.INSTANCE.getEFactory(AdfgPackage.eNS_URI);
			if (theAdfgFactory != null) {
				return theAdfgFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AdfgFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdfgFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AdfgPackage.APPLICATION: return createApplication();
			case AdfgPackage.GRAPH: return createGraph();
			case AdfgPackage.GRAPH_CONNECTION: return createGraphConnection();
			case AdfgPackage.AFFINE_RELATION: return createAffineRelation();
			case AdfgPackage.CONNECTION: return createConnection();
			case AdfgPackage.INPUT_PORT: return createInputPort();
			case AdfgPackage.OUTPUT_PORT: return createOutputPort();
			case AdfgPackage.PERIODIC_ACTOR: return createPeriodicActor();
			case AdfgPackage.CHANNEL: return createChannel();
			case AdfgPackage.APERIODIC_ACTOR: return createAperiodicActor();
			case AdfgPackage.LOSSY_CHANNEL: return createLossyChannel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application createApplication() {
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphConnection createGraphConnection() {
		GraphConnectionImpl graphConnection = new GraphConnectionImpl();
		return graphConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineRelation createAffineRelation() {
		AffineRelationImpl affineRelation = new AffineRelationImpl();
		return affineRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicActor createPeriodicActor() {
		PeriodicActorImpl periodicActor = new PeriodicActorImpl();
		return periodicActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Channel createChannel() {
		ChannelImpl channel = new ChannelImpl();
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AperiodicActor createAperiodicActor() {
		AperiodicActorImpl aperiodicActor = new AperiodicActorImpl();
		return aperiodicActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LossyChannel createLossyChannel() {
		LossyChannelImpl lossyChannel = new LossyChannelImpl();
		return lossyChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdfgPackage getAdfgPackage() {
		return (AdfgPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AdfgPackage getPackage() {
		return AdfgPackage.eINSTANCE;
	}
	

} //AdfgFactoryImpl
