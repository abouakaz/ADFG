/**
 */
package adfg;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see adfg.AdfgFactory
 * @model kind="package"
 * @generated
 */
public interface AdfgPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "adfg";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/adfg";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "adfg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdfgPackage eINSTANCE = adfg.impl.AdfgPackageImpl.init();

	/**
	 * The meta object id for the '{@link adfg.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.ApplicationImpl
	 * @see adfg.impl.AdfgPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__GRAPHS = 0;

	/**
	 * The feature id for the '<em><b>Nb Graphs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NB_GRAPHS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Nb Processors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NB_PROCESSORS = 3;

	/**
	 * The feature id for the '<em><b>Graph Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__GRAPH_CONNECTIONS = 4;

	/**
	 * The feature id for the '<em><b>Dynamic Checking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__DYNAMIC_CHECKING = 5;

	/**
	 * The feature id for the '<em><b>Scheduling Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__SCHEDULING_ALGORITHM = 6;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__SOURCE_CODE = 7;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link adfg.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.GraphImpl
	 * @see adfg.impl.AdfgPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__OWNER = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = 2;

	/**
	 * The feature id for the '<em><b>Affine Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__AFFINE_RELATIONS = 3;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__CONNECTIONS = 4;

	/**
	 * The feature id for the '<em><b>Nb Actors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NB_ACTORS = 5;

	/**
	 * The feature id for the '<em><b>Nb Buffers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NB_BUFFERS = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__ID = 7;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__SOURCE_CODE = 8;

	/**
	 * The feature id for the '<em><b>Processor Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__PROCESSOR_UTILIZATION = 9;

	/**
	 * The feature id for the '<em><b>Buffering Requirements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__BUFFERING_REQUIREMENTS = 10;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link adfg.impl.GraphConnectionImpl <em>Graph Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.GraphConnectionImpl
	 * @see adfg.impl.AdfgPackageImpl#getGraphConnection()
	 * @generated
	 */
	int GRAPH_CONNECTION = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTION__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTION__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTION__OWNER = 2;

	/**
	 * The number of structural features of the '<em>Graph Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link adfg.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.ActorImpl
	 * @see adfg.impl.AdfgPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PORTS = 1;

	/**
	 * The feature id for the '<em><b>Nb Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NB_PORTS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = 3;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__SOURCE_CODE = 4;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PRIORITY = 5;

	/**
	 * The feature id for the '<em><b>Proc Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PROC_NUMBER = 6;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link adfg.impl.AffineRelationImpl <em>Affine Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.AffineRelationImpl
	 * @see adfg.impl.AdfgPackageImpl#getAffineRelation()
	 * @generated
	 */
	int AFFINE_RELATION = 4;

	/**
	 * The feature id for the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION__N = 0;

	/**
	 * The feature id for the '<em><b>Phi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION__PHI = 1;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION__D = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION__SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION__TARGET = 4;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION__OWNER = 5;

	/**
	 * The number of structural features of the '<em>Affine Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_RELATION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link adfg.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.ConnectionImpl
	 * @see adfg.impl.AdfgPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__OWNER = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SIZE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ID = 4;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link adfg.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.PortImpl
	 * @see adfg.impl.AdfgPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 6;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SEQUENCE = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OWNER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link adfg.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.InputPortImpl
	 * @see adfg.impl.AdfgPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 7;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__SEQUENCE = PORT__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__OWNER = PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__CONNECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link adfg.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.OutputPortImpl
	 * @see adfg.impl.AdfgPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 8;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__SEQUENCE = PORT__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OWNER = PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__TYPE = PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__CONNECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link adfg.impl.PeriodicActorImpl <em>Periodic Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.PeriodicActorImpl
	 * @see adfg.impl.AdfgPackageImpl#getPeriodicActor()
	 * @generated
	 */
	int PERIODIC_ACTOR = 9;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__OWNER = ACTOR__OWNER;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PORTS = ACTOR__PORTS;

	/**
	 * The feature id for the '<em><b>Nb Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__NB_PORTS = ACTOR__NB_PORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__NAME = ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__SOURCE_CODE = ACTOR__SOURCE_CODE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PRIORITY = ACTOR__PRIORITY;

	/**
	 * The feature id for the '<em><b>Proc Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PROC_NUMBER = ACTOR__PROC_NUMBER;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PERIOD = ACTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Period Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PERIOD_UPPER_BOUND = ACTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PHASE = ACTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Affine Relation Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__AFFINE_RELATION_SOURCE = ACTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Affine Relation Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__AFFINE_RELATION_TARGET = ACTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Period Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__PERIOD_LOWER_BOUND = ACTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__DEADLINE = ACTOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wcet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR__WCET = ACTOR_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Periodic Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_ACTOR_FEATURE_COUNT = ACTOR_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link adfg.impl.ChannelImpl <em>Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.ChannelImpl
	 * @see adfg.impl.AdfgPackageImpl#getChannel()
	 * @generated
	 */
	int CHANNEL = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__TARGET = CONNECTION__TARGET;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__OWNER = CONNECTION__OWNER;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__SIZE = CONNECTION__SIZE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__ID = CONNECTION__ID;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__INITIAL = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link adfg.impl.AperiodicActorImpl <em>Aperiodic Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.AperiodicActorImpl
	 * @see adfg.impl.AdfgPackageImpl#getAperiodicActor()
	 * @generated
	 */
	int APERIODIC_ACTOR = 11;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__OWNER = ACTOR__OWNER;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__PORTS = ACTOR__PORTS;

	/**
	 * The feature id for the '<em><b>Nb Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__NB_PORTS = ACTOR__NB_PORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__NAME = ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__SOURCE_CODE = ACTOR__SOURCE_CODE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__PRIORITY = ACTOR__PRIORITY;

	/**
	 * The feature id for the '<em><b>Proc Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__PROC_NUMBER = ACTOR__PROC_NUMBER;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__CAPACITY = ACTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replenishment Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR__REPLENISHMENT_PERIOD = ACTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aperiodic Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APERIODIC_ACTOR_FEATURE_COUNT = ACTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link adfg.impl.LossyChannelImpl <em>Lossy Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adfg.impl.LossyChannelImpl
	 * @see adfg.impl.AdfgPackageImpl#getLossyChannel()
	 * @generated
	 */
	int LOSSY_CHANNEL = 12;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOSSY_CHANNEL__SOURCE = CONNECTION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOSSY_CHANNEL__TARGET = CONNECTION__TARGET;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOSSY_CHANNEL__OWNER = CONNECTION__OWNER;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOSSY_CHANNEL__SIZE = CONNECTION__SIZE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOSSY_CHANNEL__ID = CONNECTION__ID;

	/**
	 * The number of structural features of the '<em>Lossy Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOSSY_CHANNEL_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link adfg.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see adfg.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference list '{@link adfg.Application#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Graphs</em>'.
	 * @see adfg.Application#getGraphs()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Graphs();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Application#getNbGraphs <em>Nb Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Graphs</em>'.
	 * @see adfg.Application#getNbGraphs()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_NbGraphs();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Application#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see adfg.Application#getName()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_Name();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Application#getNbProcessors <em>Nb Processors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Processors</em>'.
	 * @see adfg.Application#getNbProcessors()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_NbProcessors();

	/**
	 * Returns the meta object for the containment reference list '{@link adfg.Application#getGraphConnections <em>Graph Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Graph Connections</em>'.
	 * @see adfg.Application#getGraphConnections()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_GraphConnections();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Application#isDynamicChecking <em>Dynamic Checking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic Checking</em>'.
	 * @see adfg.Application#isDynamicChecking()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_DynamicChecking();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Application#getSchedulingAlgorithm <em>Scheduling Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduling Algorithm</em>'.
	 * @see adfg.Application#getSchedulingAlgorithm()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_SchedulingAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Application#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see adfg.Application#getSourceCode()
	 * @see #getApplication()
	 * @generated
	 */
	EAttribute getApplication_SourceCode();

	/**
	 * Returns the meta object for class '{@link adfg.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see adfg.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see adfg.Graph#getName()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Name();

	/**
	 * Returns the meta object for the container reference '{@link adfg.Graph#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see adfg.Graph#getOwner()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link adfg.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see adfg.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link adfg.Graph#getAffineRelations <em>Affine Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Affine Relations</em>'.
	 * @see adfg.Graph#getAffineRelations()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_AffineRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link adfg.Graph#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see adfg.Graph#getConnections()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Connections();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getNbActors <em>Nb Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Actors</em>'.
	 * @see adfg.Graph#getNbActors()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NbActors();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getNbBuffers <em>Nb Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Buffers</em>'.
	 * @see adfg.Graph#getNbBuffers()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NbBuffers();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see adfg.Graph#getId()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Id();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see adfg.Graph#getSourceCode()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_SourceCode();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getProcessorUtilization <em>Processor Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processor Utilization</em>'.
	 * @see adfg.Graph#getProcessorUtilization()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_ProcessorUtilization();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Graph#getBufferingRequirements <em>Buffering Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Buffering Requirements</em>'.
	 * @see adfg.Graph#getBufferingRequirements()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_BufferingRequirements();

	/**
	 * Returns the meta object for class '{@link adfg.GraphConnection <em>Graph Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Connection</em>'.
	 * @see adfg.GraphConnection
	 * @generated
	 */
	EClass getGraphConnection();

	/**
	 * Returns the meta object for the reference '{@link adfg.GraphConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see adfg.GraphConnection#getSource()
	 * @see #getGraphConnection()
	 * @generated
	 */
	EReference getGraphConnection_Source();

	/**
	 * Returns the meta object for the reference '{@link adfg.GraphConnection#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see adfg.GraphConnection#getTarget()
	 * @see #getGraphConnection()
	 * @generated
	 */
	EReference getGraphConnection_Target();

	/**
	 * Returns the meta object for the container reference '{@link adfg.GraphConnection#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see adfg.GraphConnection#getOwner()
	 * @see #getGraphConnection()
	 * @generated
	 */
	EReference getGraphConnection_Owner();

	/**
	 * Returns the meta object for class '{@link adfg.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see adfg.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the container reference '{@link adfg.Actor#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see adfg.Actor#getOwner()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link adfg.Actor#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see adfg.Actor#getPorts()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Ports();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Actor#getNbPorts <em>Nb Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Ports</em>'.
	 * @see adfg.Actor#getNbPorts()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_NbPorts();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Actor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see adfg.Actor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Actor#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see adfg.Actor#getSourceCode()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_SourceCode();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Actor#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see adfg.Actor#getPriority()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Priority();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Actor#getProcNumber <em>Proc Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proc Number</em>'.
	 * @see adfg.Actor#getProcNumber()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_ProcNumber();

	/**
	 * Returns the meta object for class '{@link adfg.AffineRelation <em>Affine Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Affine Relation</em>'.
	 * @see adfg.AffineRelation
	 * @generated
	 */
	EClass getAffineRelation();

	/**
	 * Returns the meta object for the attribute '{@link adfg.AffineRelation#getN <em>N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>N</em>'.
	 * @see adfg.AffineRelation#getN()
	 * @see #getAffineRelation()
	 * @generated
	 */
	EAttribute getAffineRelation_N();

	/**
	 * Returns the meta object for the attribute '{@link adfg.AffineRelation#getPhi <em>Phi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phi</em>'.
	 * @see adfg.AffineRelation#getPhi()
	 * @see #getAffineRelation()
	 * @generated
	 */
	EAttribute getAffineRelation_Phi();

	/**
	 * Returns the meta object for the attribute '{@link adfg.AffineRelation#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see adfg.AffineRelation#getD()
	 * @see #getAffineRelation()
	 * @generated
	 */
	EAttribute getAffineRelation_D();

	/**
	 * Returns the meta object for the reference '{@link adfg.AffineRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see adfg.AffineRelation#getSource()
	 * @see #getAffineRelation()
	 * @generated
	 */
	EReference getAffineRelation_Source();

	/**
	 * Returns the meta object for the reference '{@link adfg.AffineRelation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see adfg.AffineRelation#getTarget()
	 * @see #getAffineRelation()
	 * @generated
	 */
	EReference getAffineRelation_Target();

	/**
	 * Returns the meta object for the container reference '{@link adfg.AffineRelation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see adfg.AffineRelation#getOwner()
	 * @see #getAffineRelation()
	 * @generated
	 */
	EReference getAffineRelation_Owner();

	/**
	 * Returns the meta object for class '{@link adfg.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see adfg.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link adfg.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see adfg.Connection#getSource()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Source();

	/**
	 * Returns the meta object for the reference '{@link adfg.Connection#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see adfg.Connection#getTarget()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Target();

	/**
	 * Returns the meta object for the container reference '{@link adfg.Connection#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see adfg.Connection#getOwner()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Owner();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Connection#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see adfg.Connection#getSize()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Size();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Connection#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see adfg.Connection#getId()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Id();

	/**
	 * Returns the meta object for class '{@link adfg.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see adfg.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Port#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence</em>'.
	 * @see adfg.Port#getSequence()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Sequence();

	/**
	 * Returns the meta object for the container reference '{@link adfg.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see adfg.Port#getOwner()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Owner();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see adfg.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Port#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see adfg.Port#getType()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Type();

	/**
	 * Returns the meta object for class '{@link adfg.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see adfg.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the reference '{@link adfg.InputPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see adfg.InputPort#getConnection()
	 * @see #getInputPort()
	 * @generated
	 */
	EReference getInputPort_Connection();

	/**
	 * Returns the meta object for class '{@link adfg.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see adfg.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the reference '{@link adfg.OutputPort#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see adfg.OutputPort#getConnection()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_Connection();

	/**
	 * Returns the meta object for class '{@link adfg.PeriodicActor <em>Periodic Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Periodic Actor</em>'.
	 * @see adfg.PeriodicActor
	 * @generated
	 */
	EClass getPeriodicActor();

	/**
	 * Returns the meta object for the attribute '{@link adfg.PeriodicActor#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see adfg.PeriodicActor#getPeriod()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EAttribute getPeriodicActor_Period();

	/**
	 * Returns the meta object for the attribute '{@link adfg.PeriodicActor#getPeriodUpperBound <em>Period Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period Upper Bound</em>'.
	 * @see adfg.PeriodicActor#getPeriodUpperBound()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EAttribute getPeriodicActor_PeriodUpperBound();

	/**
	 * Returns the meta object for the attribute '{@link adfg.PeriodicActor#getPhase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase</em>'.
	 * @see adfg.PeriodicActor#getPhase()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EAttribute getPeriodicActor_Phase();

	/**
	 * Returns the meta object for the reference list '{@link adfg.PeriodicActor#getAffineRelationSource <em>Affine Relation Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affine Relation Source</em>'.
	 * @see adfg.PeriodicActor#getAffineRelationSource()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EReference getPeriodicActor_AffineRelationSource();

	/**
	 * Returns the meta object for the reference list '{@link adfg.PeriodicActor#getAffineRelationTarget <em>Affine Relation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affine Relation Target</em>'.
	 * @see adfg.PeriodicActor#getAffineRelationTarget()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EReference getPeriodicActor_AffineRelationTarget();

	/**
	 * Returns the meta object for the attribute '{@link adfg.PeriodicActor#getPeriodLowerBound <em>Period Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period Lower Bound</em>'.
	 * @see adfg.PeriodicActor#getPeriodLowerBound()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EAttribute getPeriodicActor_PeriodLowerBound();

	/**
	 * Returns the meta object for the attribute '{@link adfg.PeriodicActor#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see adfg.PeriodicActor#getDeadline()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EAttribute getPeriodicActor_Deadline();

	/**
	 * Returns the meta object for the attribute '{@link adfg.PeriodicActor#getWcet <em>Wcet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wcet</em>'.
	 * @see adfg.PeriodicActor#getWcet()
	 * @see #getPeriodicActor()
	 * @generated
	 */
	EAttribute getPeriodicActor_Wcet();

	/**
	 * Returns the meta object for class '{@link adfg.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel</em>'.
	 * @see adfg.Channel
	 * @generated
	 */
	EClass getChannel();

	/**
	 * Returns the meta object for the attribute '{@link adfg.Channel#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see adfg.Channel#getInitial()
	 * @see #getChannel()
	 * @generated
	 */
	EAttribute getChannel_Initial();

	/**
	 * Returns the meta object for class '{@link adfg.AperiodicActor <em>Aperiodic Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aperiodic Actor</em>'.
	 * @see adfg.AperiodicActor
	 * @generated
	 */
	EClass getAperiodicActor();

	/**
	 * Returns the meta object for the attribute '{@link adfg.AperiodicActor#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see adfg.AperiodicActor#getCapacity()
	 * @see #getAperiodicActor()
	 * @generated
	 */
	EAttribute getAperiodicActor_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link adfg.AperiodicActor#getReplenishmentPeriod <em>Replenishment Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replenishment Period</em>'.
	 * @see adfg.AperiodicActor#getReplenishmentPeriod()
	 * @see #getAperiodicActor()
	 * @generated
	 */
	EAttribute getAperiodicActor_ReplenishmentPeriod();

	/**
	 * Returns the meta object for class '{@link adfg.LossyChannel <em>Lossy Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lossy Channel</em>'.
	 * @see adfg.LossyChannel
	 * @generated
	 */
	EClass getLossyChannel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AdfgFactory getAdfgFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link adfg.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.ApplicationImpl
		 * @see adfg.impl.AdfgPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__GRAPHS = eINSTANCE.getApplication_Graphs();

		/**
		 * The meta object literal for the '<em><b>Nb Graphs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__NB_GRAPHS = eINSTANCE.getApplication_NbGraphs();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__NAME = eINSTANCE.getApplication_Name();

		/**
		 * The meta object literal for the '<em><b>Nb Processors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__NB_PROCESSORS = eINSTANCE.getApplication_NbProcessors();

		/**
		 * The meta object literal for the '<em><b>Graph Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__GRAPH_CONNECTIONS = eINSTANCE.getApplication_GraphConnections();

		/**
		 * The meta object literal for the '<em><b>Dynamic Checking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__DYNAMIC_CHECKING = eINSTANCE.getApplication_DynamicChecking();

		/**
		 * The meta object literal for the '<em><b>Scheduling Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__SCHEDULING_ALGORITHM = eINSTANCE.getApplication_SchedulingAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION__SOURCE_CODE = eINSTANCE.getApplication_SourceCode();

		/**
		 * The meta object literal for the '{@link adfg.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.GraphImpl
		 * @see adfg.impl.AdfgPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NAME = eINSTANCE.getGraph_Name();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__OWNER = eINSTANCE.getGraph_Owner();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Affine Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__AFFINE_RELATIONS = eINSTANCE.getGraph_AffineRelations();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__CONNECTIONS = eINSTANCE.getGraph_Connections();

		/**
		 * The meta object literal for the '<em><b>Nb Actors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NB_ACTORS = eINSTANCE.getGraph_NbActors();

		/**
		 * The meta object literal for the '<em><b>Nb Buffers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NB_BUFFERS = eINSTANCE.getGraph_NbBuffers();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__ID = eINSTANCE.getGraph_Id();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__SOURCE_CODE = eINSTANCE.getGraph_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Processor Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__PROCESSOR_UTILIZATION = eINSTANCE.getGraph_ProcessorUtilization();

		/**
		 * The meta object literal for the '<em><b>Buffering Requirements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__BUFFERING_REQUIREMENTS = eINSTANCE.getGraph_BufferingRequirements();

		/**
		 * The meta object literal for the '{@link adfg.impl.GraphConnectionImpl <em>Graph Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.GraphConnectionImpl
		 * @see adfg.impl.AdfgPackageImpl#getGraphConnection()
		 * @generated
		 */
		EClass GRAPH_CONNECTION = eINSTANCE.getGraphConnection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_CONNECTION__SOURCE = eINSTANCE.getGraphConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_CONNECTION__TARGET = eINSTANCE.getGraphConnection_Target();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_CONNECTION__OWNER = eINSTANCE.getGraphConnection_Owner();

		/**
		 * The meta object literal for the '{@link adfg.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.ActorImpl
		 * @see adfg.impl.AdfgPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__OWNER = eINSTANCE.getActor_Owner();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PORTS = eINSTANCE.getActor_Ports();

		/**
		 * The meta object literal for the '<em><b>Nb Ports</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NB_PORTS = eINSTANCE.getActor_NbPorts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NAME = eINSTANCE.getActor_Name();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__SOURCE_CODE = eINSTANCE.getActor_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__PRIORITY = eINSTANCE.getActor_Priority();

		/**
		 * The meta object literal for the '<em><b>Proc Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__PROC_NUMBER = eINSTANCE.getActor_ProcNumber();

		/**
		 * The meta object literal for the '{@link adfg.impl.AffineRelationImpl <em>Affine Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.AffineRelationImpl
		 * @see adfg.impl.AdfgPackageImpl#getAffineRelation()
		 * @generated
		 */
		EClass AFFINE_RELATION = eINSTANCE.getAffineRelation();

		/**
		 * The meta object literal for the '<em><b>N</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AFFINE_RELATION__N = eINSTANCE.getAffineRelation_N();

		/**
		 * The meta object literal for the '<em><b>Phi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AFFINE_RELATION__PHI = eINSTANCE.getAffineRelation_Phi();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AFFINE_RELATION__D = eINSTANCE.getAffineRelation_D();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFFINE_RELATION__SOURCE = eINSTANCE.getAffineRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFFINE_RELATION__TARGET = eINSTANCE.getAffineRelation_Target();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFFINE_RELATION__OWNER = eINSTANCE.getAffineRelation_Owner();

		/**
		 * The meta object literal for the '{@link adfg.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.ConnectionImpl
		 * @see adfg.impl.AdfgPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__TARGET = eINSTANCE.getConnection_Target();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__OWNER = eINSTANCE.getConnection_Owner();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__SIZE = eINSTANCE.getConnection_Size();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ID = eINSTANCE.getConnection_Id();

		/**
		 * The meta object literal for the '{@link adfg.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.PortImpl
		 * @see adfg.impl.AdfgPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__SEQUENCE = eINSTANCE.getPort_Sequence();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OWNER = eINSTANCE.getPort_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TYPE = eINSTANCE.getPort_Type();

		/**
		 * The meta object literal for the '{@link adfg.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.InputPortImpl
		 * @see adfg.impl.AdfgPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORT__CONNECTION = eINSTANCE.getInputPort_Connection();

		/**
		 * The meta object literal for the '{@link adfg.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.OutputPortImpl
		 * @see adfg.impl.AdfgPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORT__CONNECTION = eINSTANCE.getOutputPort_Connection();

		/**
		 * The meta object literal for the '{@link adfg.impl.PeriodicActorImpl <em>Periodic Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.PeriodicActorImpl
		 * @see adfg.impl.AdfgPackageImpl#getPeriodicActor()
		 * @generated
		 */
		EClass PERIODIC_ACTOR = eINSTANCE.getPeriodicActor();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_ACTOR__PERIOD = eINSTANCE.getPeriodicActor_Period();

		/**
		 * The meta object literal for the '<em><b>Period Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_ACTOR__PERIOD_UPPER_BOUND = eINSTANCE.getPeriodicActor_PeriodUpperBound();

		/**
		 * The meta object literal for the '<em><b>Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_ACTOR__PHASE = eINSTANCE.getPeriodicActor_Phase();

		/**
		 * The meta object literal for the '<em><b>Affine Relation Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERIODIC_ACTOR__AFFINE_RELATION_SOURCE = eINSTANCE.getPeriodicActor_AffineRelationSource();

		/**
		 * The meta object literal for the '<em><b>Affine Relation Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERIODIC_ACTOR__AFFINE_RELATION_TARGET = eINSTANCE.getPeriodicActor_AffineRelationTarget();

		/**
		 * The meta object literal for the '<em><b>Period Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_ACTOR__PERIOD_LOWER_BOUND = eINSTANCE.getPeriodicActor_PeriodLowerBound();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_ACTOR__DEADLINE = eINSTANCE.getPeriodicActor_Deadline();

		/**
		 * The meta object literal for the '<em><b>Wcet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_ACTOR__WCET = eINSTANCE.getPeriodicActor_Wcet();

		/**
		 * The meta object literal for the '{@link adfg.impl.ChannelImpl <em>Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.ChannelImpl
		 * @see adfg.impl.AdfgPackageImpl#getChannel()
		 * @generated
		 */
		EClass CHANNEL = eINSTANCE.getChannel();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANNEL__INITIAL = eINSTANCE.getChannel_Initial();

		/**
		 * The meta object literal for the '{@link adfg.impl.AperiodicActorImpl <em>Aperiodic Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.AperiodicActorImpl
		 * @see adfg.impl.AdfgPackageImpl#getAperiodicActor()
		 * @generated
		 */
		EClass APERIODIC_ACTOR = eINSTANCE.getAperiodicActor();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APERIODIC_ACTOR__CAPACITY = eINSTANCE.getAperiodicActor_Capacity();

		/**
		 * The meta object literal for the '<em><b>Replenishment Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APERIODIC_ACTOR__REPLENISHMENT_PERIOD = eINSTANCE.getAperiodicActor_ReplenishmentPeriod();

		/**
		 * The meta object literal for the '{@link adfg.impl.LossyChannelImpl <em>Lossy Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adfg.impl.LossyChannelImpl
		 * @see adfg.impl.AdfgPackageImpl#getLossyChannel()
		 * @generated
		 */
		EClass LOSSY_CHANNEL = eINSTANCE.getLossyChannel();

	}

} //AdfgPackage
