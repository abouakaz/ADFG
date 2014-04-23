/**
 */
package adfg.impl;

import adfg.Actor;
import adfg.AdfgPackage;
import adfg.AffineRelation;
import adfg.Application;
import adfg.Connection;
import adfg.Graph;
import adfg.schedulability.ADFGraph;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.GraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getAffineRelations <em>Affine Relations</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getNbActors <em>Nb Actors</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getNbBuffers <em>Nb Buffers</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getId <em>Id</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getProcessorUtilization <em>Processor Utilization</em>}</li>
 *   <li>{@link adfg.impl.GraphImpl#getBufferingRequirements <em>Buffering Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends EObjectImpl implements Graph {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> nodes;

	/**
	 * The cached value of the '{@link #getAffineRelations() <em>Affine Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffineRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<AffineRelation> affineRelations;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * The default value of the '{@link #getNbActors() <em>Nb Actors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbActors()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_ACTORS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbActors() <em>Nb Actors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbActors()
	 * @generated
	 * @ordered
	 */
	protected int nbActors = NB_ACTORS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbBuffers() <em>Nb Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbBuffers()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_BUFFERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbBuffers() <em>Nb Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbBuffers()
	 * @generated
	 * @ordered
	 */
	protected int nbBuffers = NB_BUFFERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getProcessorUtilization() <em>Processor Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorUtilization()
	 * @generated
	 * @ordered
	 */
	protected static final double PROCESSOR_UTILIZATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProcessorUtilization() <em>Processor Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessorUtilization()
	 * @generated
	 * @ordered
	 */
	protected double processorUtilization = PROCESSOR_UTILIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBufferingRequirements() <em>Buffering Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferingRequirements()
	 * @generated
	 * @ordered
	 */
	protected static final int BUFFERING_REQUIREMENTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBufferingRequirements() <em>Buffering Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferingRequirements()
	 * @generated
	 * @ordered
	 */
	protected int bufferingRequirements = BUFFERING_REQUIREMENTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected GraphImpl() {
		super();
		dataflow=new ADFGraph(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.GRAPH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application getOwner() {
		if (eContainerFeatureID() != AdfgPackage.GRAPH__OWNER) return null;
		return (Application)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Application newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, AdfgPackage.GRAPH__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Application newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != AdfgPackage.GRAPH__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, AdfgPackage.APPLICATION__GRAPHS, Application.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Actor>(Actor.class, this, AdfgPackage.GRAPH__NODES, AdfgPackage.ACTOR__OWNER);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AffineRelation> getAffineRelations() {
		if (affineRelations == null) {
			affineRelations = new EObjectContainmentWithInverseEList<AffineRelation>(AffineRelation.class, this, AdfgPackage.GRAPH__AFFINE_RELATIONS, AdfgPackage.AFFINE_RELATION__OWNER);
		}
		return affineRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentWithInverseEList<Connection>(Connection.class, this, AdfgPackage.GRAPH__CONNECTIONS, AdfgPackage.CONNECTION__OWNER);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbActors() {
		return nbActors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbActors(int newNbActors) {
		int oldNbActors = nbActors;
		nbActors = newNbActors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__NB_ACTORS, oldNbActors, nbActors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbBuffers() {
		return nbBuffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbBuffers(int newNbBuffers) {
		int oldNbBuffers = nbBuffers;
		nbBuffers = newNbBuffers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__NB_BUFFERS, oldNbBuffers, nbBuffers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__SOURCE_CODE, oldSourceCode, sourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProcessorUtilization() {
		return processorUtilization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessorUtilization(double newProcessorUtilization) {
		double oldProcessorUtilization = processorUtilization;
		processorUtilization = newProcessorUtilization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__PROCESSOR_UTILIZATION, oldProcessorUtilization, processorUtilization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBufferingRequirements() {
		return bufferingRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferingRequirements(int newBufferingRequirements) {
		int oldBufferingRequirements = bufferingRequirements;
		bufferingRequirements = newBufferingRequirements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS, oldBufferingRequirements, bufferingRequirements));
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
			case AdfgPackage.GRAPH__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Application)otherEnd, msgs);
			case AdfgPackage.GRAPH__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAffineRelations()).basicAdd(otherEnd, msgs);
			case AdfgPackage.GRAPH__CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnections()).basicAdd(otherEnd, msgs);
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
			case AdfgPackage.GRAPH__OWNER:
				return basicSetOwner(null, msgs);
			case AdfgPackage.GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
				return ((InternalEList<?>)getAffineRelations()).basicRemove(otherEnd, msgs);
			case AdfgPackage.GRAPH__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AdfgPackage.GRAPH__OWNER:
				return eInternalContainer().eInverseRemove(this, AdfgPackage.APPLICATION__GRAPHS, Application.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdfgPackage.GRAPH__NAME:
				return getName();
			case AdfgPackage.GRAPH__OWNER:
				return getOwner();
			case AdfgPackage.GRAPH__NODES:
				return getNodes();
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
				return getAffineRelations();
			case AdfgPackage.GRAPH__CONNECTIONS:
				return getConnections();
			case AdfgPackage.GRAPH__NB_ACTORS:
				return getNbActors();
			case AdfgPackage.GRAPH__NB_BUFFERS:
				return getNbBuffers();
			case AdfgPackage.GRAPH__ID:
				return getId();
			case AdfgPackage.GRAPH__SOURCE_CODE:
				return getSourceCode();
			case AdfgPackage.GRAPH__PROCESSOR_UTILIZATION:
				return getProcessorUtilization();
			case AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS:
				return getBufferingRequirements();
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
			case AdfgPackage.GRAPH__NAME:
				setName((String)newValue);
				return;
			case AdfgPackage.GRAPH__OWNER:
				setOwner((Application)newValue);
				return;
			case AdfgPackage.GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Actor>)newValue);
				return;
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
				getAffineRelations().clear();
				getAffineRelations().addAll((Collection<? extends AffineRelation>)newValue);
				return;
			case AdfgPackage.GRAPH__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case AdfgPackage.GRAPH__NB_ACTORS:
				setNbActors((Integer)newValue);
				return;
			case AdfgPackage.GRAPH__NB_BUFFERS:
				setNbBuffers((Integer)newValue);
				return;
			case AdfgPackage.GRAPH__ID:
				setId((Integer)newValue);
				return;
			case AdfgPackage.GRAPH__SOURCE_CODE:
				setSourceCode((String)newValue);
				return;
			case AdfgPackage.GRAPH__PROCESSOR_UTILIZATION:
				setProcessorUtilization((Double)newValue);
				return;
			case AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS:
				setBufferingRequirements((Integer)newValue);
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
			case AdfgPackage.GRAPH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AdfgPackage.GRAPH__OWNER:
				setOwner((Application)null);
				return;
			case AdfgPackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
				getAffineRelations().clear();
				return;
			case AdfgPackage.GRAPH__CONNECTIONS:
				getConnections().clear();
				return;
			case AdfgPackage.GRAPH__NB_ACTORS:
				setNbActors(NB_ACTORS_EDEFAULT);
				return;
			case AdfgPackage.GRAPH__NB_BUFFERS:
				setNbBuffers(NB_BUFFERS_EDEFAULT);
				return;
			case AdfgPackage.GRAPH__ID:
				setId(ID_EDEFAULT);
				return;
			case AdfgPackage.GRAPH__SOURCE_CODE:
				setSourceCode(SOURCE_CODE_EDEFAULT);
				return;
			case AdfgPackage.GRAPH__PROCESSOR_UTILIZATION:
				setProcessorUtilization(PROCESSOR_UTILIZATION_EDEFAULT);
				return;
			case AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS:
				setBufferingRequirements(BUFFERING_REQUIREMENTS_EDEFAULT);
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
			case AdfgPackage.GRAPH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AdfgPackage.GRAPH__OWNER:
				return getOwner() != null;
			case AdfgPackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case AdfgPackage.GRAPH__AFFINE_RELATIONS:
				return affineRelations != null && !affineRelations.isEmpty();
			case AdfgPackage.GRAPH__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case AdfgPackage.GRAPH__NB_ACTORS:
				return nbActors != NB_ACTORS_EDEFAULT;
			case AdfgPackage.GRAPH__NB_BUFFERS:
				return nbBuffers != NB_BUFFERS_EDEFAULT;
			case AdfgPackage.GRAPH__ID:
				return id != ID_EDEFAULT;
			case AdfgPackage.GRAPH__SOURCE_CODE:
				return SOURCE_CODE_EDEFAULT == null ? sourceCode != null : !SOURCE_CODE_EDEFAULT.equals(sourceCode);
			case AdfgPackage.GRAPH__PROCESSOR_UTILIZATION:
				return processorUtilization != PROCESSOR_UTILIZATION_EDEFAULT;
			case AdfgPackage.GRAPH__BUFFERING_REQUIREMENTS:
				return bufferingRequirements != BUFFERING_REQUIREMENTS_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", nbActors: ");
		result.append(nbActors);
		result.append(", nbBuffers: ");
		result.append(nbBuffers);
		result.append(", id: ");
		result.append(id);
		result.append(", sourceCode: ");
		result.append(sourceCode);
		result.append(", processorUtilization: ");
		result.append(processorUtilization);
		result.append(", bufferingRequirements: ");
		result.append(bufferingRequirements);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Data structure used to perform schedulability analysis.
	 * @generated NOT
	 */
	private ADFGraph dataflow;
	
	/**
	 * @generated NOT
	 */
	public ADFGraph getDataflow(){
		return dataflow;
	}
	
	/**
	 * @generated NOT
	 */
	private boolean loaded=false;
	
	/**
	 * @generated NOT
	 */
	public boolean isLoaded(){
		return loaded;
	}
	
	/**
	 * @generated NOT
	 */
	public void setLoaded(){
		loaded=true;
	}
	
	/**
	 * @generated NOT
	 */
	public void setDeactivated(){
		loaded=false;
	}
	
	/**
	 * @generated NOT
	 */
	public void validationAfterLoading(){
		BasicDiagnostic diagnostic=new BasicDiagnostic(Diagnostic.OK,"Dynamic checking",0,"", new Object[]{this});
		TransactionalEditingDomain domain=TransactionUtil.getEditingDomain(this);
		final class MyCommand extends AbstractTransactionalCommand { 			
			Graph graph;		
			public MyCommand(TransactionalEditingDomain editingDomain, Graph graph, BasicDiagnostic diagnostic){
				super(editingDomain, "a message", null);
				this.graph=graph;
			}	
 		    @Override
 		    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
 			   graph.getDataflow().addModelGraph();
 			   return CommandResult.newOKCommandResult();
 		    } 
        };
    	ICommandProxy comm = new ICommandProxy(new MyCommand(domain,this,diagnostic));;
    	comm.execute();
	}


} //GraphImpl
