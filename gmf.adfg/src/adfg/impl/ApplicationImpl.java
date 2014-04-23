/**
 */
package adfg.impl;

import adfg.AdfgPackage;
import adfg.Application;
import adfg.Graph;
import adfg.GraphConnection;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.ApplicationImpl#getGraphs <em>Graphs</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#getNbGraphs <em>Nb Graphs</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#getName <em>Name</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#getNbProcessors <em>Nb Processors</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#getGraphConnections <em>Graph Connections</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#isDynamicChecking <em>Dynamic Checking</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#getSchedulingAlgorithm <em>Scheduling Algorithm</em>}</li>
 *   <li>{@link adfg.impl.ApplicationImpl#getSourceCode <em>Source Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationImpl extends EObjectImpl implements Application {
	/**
	 * The cached value of the '{@link #getGraphs() <em>Graphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<Graph> graphs;

	/**
	 * The default value of the '{@link #getNbGraphs() <em>Nb Graphs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbGraphs()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_GRAPHS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbGraphs() <em>Nb Graphs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbGraphs()
	 * @generated
	 * @ordered
	 */
	protected int nbGraphs = NB_GRAPHS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "Application";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbProcessors() <em>Nb Processors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbProcessors()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_PROCESSORS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getNbProcessors() <em>Nb Processors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbProcessors()
	 * @generated
	 * @ordered
	 */
	protected int nbProcessors = NB_PROCESSORS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGraphConnections() <em>Graph Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphConnection> graphConnections;

	/**
	 * The default value of the '{@link #isDynamicChecking() <em>Dynamic Checking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamicChecking()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_CHECKING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamicChecking() <em>Dynamic Checking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamicChecking()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamicChecking = DYNAMIC_CHECKING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulingAlgorithm() <em>Scheduling Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEDULING_ALGORITHM_EDEFAULT = "User";

	/**
	 * The cached value of the '{@link #getSchedulingAlgorithm() <em>Scheduling Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String schedulingAlgorithm = SCHEDULING_ALGORITHM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceCode() <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceCode() <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCode()
	 * @generated
	 * @ordered
	 */
	protected String sourceCode = SOURCE_CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Graph> getGraphs() {
		if (graphs == null) {
			graphs = new EObjectContainmentWithInverseEList<Graph>(Graph.class, this, AdfgPackage.APPLICATION__GRAPHS, AdfgPackage.GRAPH__OWNER);
		}
		return graphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbGraphs() {
		return nbGraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbGraphs(int newNbGraphs) {
		int oldNbGraphs = nbGraphs;
		nbGraphs = newNbGraphs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APPLICATION__NB_GRAPHS, oldNbGraphs, nbGraphs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APPLICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbProcessors() {
		return nbProcessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbProcessors(int newNbProcessors) {
		int oldNbProcessors = nbProcessors;
		nbProcessors = newNbProcessors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APPLICATION__NB_PROCESSORS, oldNbProcessors, nbProcessors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphConnection> getGraphConnections() {
		if (graphConnections == null) {
			graphConnections = new EObjectContainmentWithInverseEList<GraphConnection>(GraphConnection.class, this, AdfgPackage.APPLICATION__GRAPH_CONNECTIONS, AdfgPackage.GRAPH_CONNECTION__OWNER);
		}
		return graphConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamicChecking() {
		return dynamicChecking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicChecking(boolean newDynamicChecking) {
		boolean oldDynamicChecking = dynamicChecking;
		dynamicChecking = newDynamicChecking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APPLICATION__DYNAMIC_CHECKING, oldDynamicChecking, dynamicChecking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedulingAlgorithm() {
		return schedulingAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulingAlgorithm(String newSchedulingAlgorithm) {
		String oldSchedulingAlgorithm = schedulingAlgorithm;
		schedulingAlgorithm = newSchedulingAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM, oldSchedulingAlgorithm, schedulingAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceCode() {
		return sourceCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceCode(String newSourceCode) {
		String oldSourceCode = sourceCode;
		sourceCode = newSourceCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APPLICATION__SOURCE_CODE, oldSourceCode, sourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdfgPackage.APPLICATION__GRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGraphs()).basicAdd(otherEnd, msgs);
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGraphConnections()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdfgPackage.APPLICATION__GRAPHS:
				return ((InternalEList<?>)getGraphs()).basicRemove(otherEnd, msgs);
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				return ((InternalEList<?>)getGraphConnections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdfgPackage.APPLICATION__GRAPHS:
				return getGraphs();
			case AdfgPackage.APPLICATION__NB_GRAPHS:
				return getNbGraphs();
			case AdfgPackage.APPLICATION__NAME:
				return getName();
			case AdfgPackage.APPLICATION__NB_PROCESSORS:
				return getNbProcessors();
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				return getGraphConnections();
			case AdfgPackage.APPLICATION__DYNAMIC_CHECKING:
				return isDynamicChecking();
			case AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM:
				return getSchedulingAlgorithm();
			case AdfgPackage.APPLICATION__SOURCE_CODE:
				return getSourceCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AdfgPackage.APPLICATION__GRAPHS:
				getGraphs().clear();
				getGraphs().addAll((Collection<? extends Graph>)newValue);
				return;
			case AdfgPackage.APPLICATION__NB_GRAPHS:
				setNbGraphs((Integer)newValue);
				return;
			case AdfgPackage.APPLICATION__NAME:
				setName((String)newValue);
				return;
			case AdfgPackage.APPLICATION__NB_PROCESSORS:
				setNbProcessors((Integer)newValue);
				return;
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				getGraphConnections().clear();
				getGraphConnections().addAll((Collection<? extends GraphConnection>)newValue);
				return;
			case AdfgPackage.APPLICATION__DYNAMIC_CHECKING:
				setDynamicChecking((Boolean)newValue);
				return;
			case AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM:
				setSchedulingAlgorithm((String)newValue);
				return;
			case AdfgPackage.APPLICATION__SOURCE_CODE:
				setSourceCode((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AdfgPackage.APPLICATION__GRAPHS:
				getGraphs().clear();
				return;
			case AdfgPackage.APPLICATION__NB_GRAPHS:
				setNbGraphs(NB_GRAPHS_EDEFAULT);
				return;
			case AdfgPackage.APPLICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AdfgPackage.APPLICATION__NB_PROCESSORS:
				setNbProcessors(NB_PROCESSORS_EDEFAULT);
				return;
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				getGraphConnections().clear();
				return;
			case AdfgPackage.APPLICATION__DYNAMIC_CHECKING:
				setDynamicChecking(DYNAMIC_CHECKING_EDEFAULT);
				return;
			case AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM:
				setSchedulingAlgorithm(SCHEDULING_ALGORITHM_EDEFAULT);
				return;
			case AdfgPackage.APPLICATION__SOURCE_CODE:
				setSourceCode(SOURCE_CODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AdfgPackage.APPLICATION__GRAPHS:
				return graphs != null && !graphs.isEmpty();
			case AdfgPackage.APPLICATION__NB_GRAPHS:
				return nbGraphs != NB_GRAPHS_EDEFAULT;
			case AdfgPackage.APPLICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AdfgPackage.APPLICATION__NB_PROCESSORS:
				return nbProcessors != NB_PROCESSORS_EDEFAULT;
			case AdfgPackage.APPLICATION__GRAPH_CONNECTIONS:
				return graphConnections != null && !graphConnections.isEmpty();
			case AdfgPackage.APPLICATION__DYNAMIC_CHECKING:
				return dynamicChecking != DYNAMIC_CHECKING_EDEFAULT;
			case AdfgPackage.APPLICATION__SCHEDULING_ALGORITHM:
				return SCHEDULING_ALGORITHM_EDEFAULT == null ? schedulingAlgorithm != null : !SCHEDULING_ALGORITHM_EDEFAULT.equals(schedulingAlgorithm);
			case AdfgPackage.APPLICATION__SOURCE_CODE:
				return SOURCE_CODE_EDEFAULT == null ? sourceCode != null : !SOURCE_CODE_EDEFAULT.equals(sourceCode);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nbGraphs: ");
		result.append(nbGraphs);
		result.append(", name: ");
		result.append(name);
		result.append(", nbProcessors: ");
		result.append(nbProcessors);
		result.append(", dynamicChecking: ");
		result.append(dynamicChecking);
		result.append(", schedulingAlgorithm: ");
		result.append(schedulingAlgorithm);
		result.append(", sourceCode: ");
		result.append(sourceCode);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @generated NOT
	 */
	public BasicDiagnostic updateDataflowGraphs(String str){
		BasicDiagnostic diagnostic=new BasicDiagnostic(Diagnostic.OK,"Construct Connectivity graphs",0,"", new Object[]{this});
		Iterator<Graph> it=graphs.iterator();
		if("dynamicChecking".equals(str)){
			if(!dynamicChecking) return diagnostic;
			while(it.hasNext()){
				Graph graph=it.next();
				graph.getDataflow().constructAffineGraph();
				if(graph.getDataflow().getGraphDiagnostic()!=null) diagnostic.addAll(graph.getDataflow().getGraphDiagnostic());
			}
		}
		else if("schedulingAlgorithm".equals(str)){
			while(it.hasNext()){
				Graph graph=it.next();
				graph.getDataflow().setScheduleType(getSchedulingAlgorithm());
			}
		}
		else if("nbProcessors".equals(str)){
			while(it.hasNext()){
				Graph graph=it.next();
				graph.getDataflow().setNbProcessors(getNbProcessors());
			}
		}
		return diagnostic;
	}
	

} //ApplicationImpl
