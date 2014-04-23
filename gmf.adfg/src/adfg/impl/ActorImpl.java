/**
 */
package adfg.impl;

import adfg.Actor;
import adfg.AdfgPackage;
import adfg.Graph;
import adfg.Port;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.ActorImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link adfg.impl.ActorImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link adfg.impl.ActorImpl#getNbPorts <em>Nb Ports</em>}</li>
 *   <li>{@link adfg.impl.ActorImpl#getName <em>Name</em>}</li>
 *   <li>{@link adfg.impl.ActorImpl#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link adfg.impl.ActorImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link adfg.impl.ActorImpl#getProcNumber <em>Proc Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActorImpl extends EObjectImpl implements Actor {
	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> ports;

	/**
	 * The default value of the '{@link #getNbPorts() <em>Nb Ports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbPorts()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_PORTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbPorts() <em>Nb Ports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbPorts()
	 * @generated
	 * @ordered
	 */
	protected int nbPorts = NB_PORTS_EDEFAULT;

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
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcNumber() <em>Proc Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int PROC_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProcNumber() <em>Proc Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcNumber()
	 * @generated
	 * @ordered
	 */
	protected int procNumber = PROC_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getOwner() {
		if (eContainerFeatureID() != AdfgPackage.ACTOR__OWNER) return null;
		return (Graph)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Graph newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, AdfgPackage.ACTOR__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Graph newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != AdfgPackage.ACTOR__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, AdfgPackage.GRAPH__NODES, Graph.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.ACTOR__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<Port>(Port.class, this, AdfgPackage.ACTOR__PORTS, AdfgPackage.PORT__OWNER);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbPorts() {
		return nbPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbPorts(int newNbPorts) {
		int oldNbPorts = nbPorts;
		nbPorts = newNbPorts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.ACTOR__NB_PORTS, oldNbPorts, nbPorts));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.ACTOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.ACTOR__SOURCE_CODE, oldSourceCode, sourceCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.ACTOR__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProcNumber() {
		return procNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcNumber(int newProcNumber) {
		int oldProcNumber = procNumber;
		procNumber = newProcNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.ACTOR__PROC_NUMBER, oldProcNumber, procNumber));
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
			case AdfgPackage.ACTOR__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Graph)otherEnd, msgs);
			case AdfgPackage.ACTOR__PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPorts()).basicAdd(otherEnd, msgs);
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
			case AdfgPackage.ACTOR__OWNER:
				return basicSetOwner(null, msgs);
			case AdfgPackage.ACTOR__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
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
			case AdfgPackage.ACTOR__OWNER:
				return eInternalContainer().eInverseRemove(this, AdfgPackage.GRAPH__NODES, Graph.class, msgs);
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
			case AdfgPackage.ACTOR__OWNER:
				return getOwner();
			case AdfgPackage.ACTOR__PORTS:
				return getPorts();
			case AdfgPackage.ACTOR__NB_PORTS:
				return getNbPorts();
			case AdfgPackage.ACTOR__NAME:
				return getName();
			case AdfgPackage.ACTOR__SOURCE_CODE:
				return getSourceCode();
			case AdfgPackage.ACTOR__PRIORITY:
				return getPriority();
			case AdfgPackage.ACTOR__PROC_NUMBER:
				return getProcNumber();
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
			case AdfgPackage.ACTOR__OWNER:
				setOwner((Graph)newValue);
				return;
			case AdfgPackage.ACTOR__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case AdfgPackage.ACTOR__NB_PORTS:
				setNbPorts((Integer)newValue);
				return;
			case AdfgPackage.ACTOR__NAME:
				setName((String)newValue);
				return;
			case AdfgPackage.ACTOR__SOURCE_CODE:
				setSourceCode((String)newValue);
				return;
			case AdfgPackage.ACTOR__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case AdfgPackage.ACTOR__PROC_NUMBER:
				setProcNumber((Integer)newValue);
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
			case AdfgPackage.ACTOR__OWNER:
				setOwner((Graph)null);
				return;
			case AdfgPackage.ACTOR__PORTS:
				getPorts().clear();
				return;
			case AdfgPackage.ACTOR__NB_PORTS:
				setNbPorts(NB_PORTS_EDEFAULT);
				return;
			case AdfgPackage.ACTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AdfgPackage.ACTOR__SOURCE_CODE:
				setSourceCode(SOURCE_CODE_EDEFAULT);
				return;
			case AdfgPackage.ACTOR__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case AdfgPackage.ACTOR__PROC_NUMBER:
				setProcNumber(PROC_NUMBER_EDEFAULT);
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
			case AdfgPackage.ACTOR__OWNER:
				return getOwner() != null;
			case AdfgPackage.ACTOR__PORTS:
				return ports != null && !ports.isEmpty();
			case AdfgPackage.ACTOR__NB_PORTS:
				return nbPorts != NB_PORTS_EDEFAULT;
			case AdfgPackage.ACTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AdfgPackage.ACTOR__SOURCE_CODE:
				return SOURCE_CODE_EDEFAULT == null ? sourceCode != null : !SOURCE_CODE_EDEFAULT.equals(sourceCode);
			case AdfgPackage.ACTOR__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case AdfgPackage.ACTOR__PROC_NUMBER:
				return procNumber != PROC_NUMBER_EDEFAULT;
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
		result.append(" (nbPorts: ");
		result.append(nbPorts);
		result.append(", name: ");
		result.append(name);
		result.append(", sourceCode: ");
		result.append(sourceCode);
		result.append(", priority: ");
		result.append(priority);
		result.append(", procNumber: ");
		result.append(procNumber);
		result.append(')');
		return result.toString();
	}

} //ActorImpl
