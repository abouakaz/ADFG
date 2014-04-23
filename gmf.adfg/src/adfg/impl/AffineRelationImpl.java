/**
 */
package adfg.impl;

import adfg.AdfgPackage;
import adfg.AffineRelation;
import adfg.Graph;
import adfg.PeriodicActor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Affine Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.AffineRelationImpl#getN <em>N</em>}</li>
 *   <li>{@link adfg.impl.AffineRelationImpl#getPhi <em>Phi</em>}</li>
 *   <li>{@link adfg.impl.AffineRelationImpl#getD <em>D</em>}</li>
 *   <li>{@link adfg.impl.AffineRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link adfg.impl.AffineRelationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link adfg.impl.AffineRelationImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AffineRelationImpl extends EObjectImpl implements AffineRelation {
	/**
	 * The default value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected static final int N_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected int n = N_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhi() <em>Phi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhi()
	 * @generated
	 * @ordered
	 */
	protected static final int PHI_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPhi() <em>Phi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhi()
	 * @generated
	 * @ordered
	 */
	protected int phi = PHI_EDEFAULT;

	/**
	 * The default value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected static final int D_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getD() <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected int d = D_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected PeriodicActor source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected PeriodicActor target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AffineRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.AFFINE_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getN() {
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN(int newN) {
		int oldN = n;
		n = newN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__N, oldN, n));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPhi() {
		return phi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhi(int newPhi) {
		int oldPhi = phi;
		phi = newPhi;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__PHI, oldPhi, phi));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getD() {
		return d;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setD(int newD) {
		int oldD = d;
		d = newD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__D, oldD, d));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicActor getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (PeriodicActor)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdfgPackage.AFFINE_RELATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicActor basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(PeriodicActor newSource, NotificationChain msgs) {
		PeriodicActor oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(PeriodicActor newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE, PeriodicActor.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE, PeriodicActor.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicActor getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (PeriodicActor)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdfgPackage.AFFINE_RELATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicActor basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(PeriodicActor newTarget, NotificationChain msgs) {
		PeriodicActor oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(PeriodicActor newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET, PeriodicActor.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET, PeriodicActor.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getOwner() {
		if (eContainerFeatureID() != AdfgPackage.AFFINE_RELATION__OWNER) return null;
		return (Graph)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Graph newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, AdfgPackage.AFFINE_RELATION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Graph newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != AdfgPackage.AFFINE_RELATION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, AdfgPackage.GRAPH__AFFINE_RELATIONS, Graph.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.AFFINE_RELATION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdfgPackage.AFFINE_RELATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE, PeriodicActor.class, msgs);
				return basicSetSource((PeriodicActor)otherEnd, msgs);
			case AdfgPackage.AFFINE_RELATION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET, PeriodicActor.class, msgs);
				return basicSetTarget((PeriodicActor)otherEnd, msgs);
			case AdfgPackage.AFFINE_RELATION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Graph)otherEnd, msgs);
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
			case AdfgPackage.AFFINE_RELATION__SOURCE:
				return basicSetSource(null, msgs);
			case AdfgPackage.AFFINE_RELATION__TARGET:
				return basicSetTarget(null, msgs);
			case AdfgPackage.AFFINE_RELATION__OWNER:
				return basicSetOwner(null, msgs);
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
			case AdfgPackage.AFFINE_RELATION__OWNER:
				return eInternalContainer().eInverseRemove(this, AdfgPackage.GRAPH__AFFINE_RELATIONS, Graph.class, msgs);
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
			case AdfgPackage.AFFINE_RELATION__N:
				return getN();
			case AdfgPackage.AFFINE_RELATION__PHI:
				return getPhi();
			case AdfgPackage.AFFINE_RELATION__D:
				return getD();
			case AdfgPackage.AFFINE_RELATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case AdfgPackage.AFFINE_RELATION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case AdfgPackage.AFFINE_RELATION__OWNER:
				return getOwner();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AdfgPackage.AFFINE_RELATION__N:
				setN((Integer)newValue);
				return;
			case AdfgPackage.AFFINE_RELATION__PHI:
				setPhi((Integer)newValue);
				return;
			case AdfgPackage.AFFINE_RELATION__D:
				setD((Integer)newValue);
				return;
			case AdfgPackage.AFFINE_RELATION__SOURCE:
				setSource((PeriodicActor)newValue);
				return;
			case AdfgPackage.AFFINE_RELATION__TARGET:
				setTarget((PeriodicActor)newValue);
				return;
			case AdfgPackage.AFFINE_RELATION__OWNER:
				setOwner((Graph)newValue);
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
			case AdfgPackage.AFFINE_RELATION__N:
				setN(N_EDEFAULT);
				return;
			case AdfgPackage.AFFINE_RELATION__PHI:
				setPhi(PHI_EDEFAULT);
				return;
			case AdfgPackage.AFFINE_RELATION__D:
				setD(D_EDEFAULT);
				return;
			case AdfgPackage.AFFINE_RELATION__SOURCE:
				setSource((PeriodicActor)null);
				return;
			case AdfgPackage.AFFINE_RELATION__TARGET:
				setTarget((PeriodicActor)null);
				return;
			case AdfgPackage.AFFINE_RELATION__OWNER:
				setOwner((Graph)null);
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
			case AdfgPackage.AFFINE_RELATION__N:
				return n != N_EDEFAULT;
			case AdfgPackage.AFFINE_RELATION__PHI:
				return phi != PHI_EDEFAULT;
			case AdfgPackage.AFFINE_RELATION__D:
				return d != D_EDEFAULT;
			case AdfgPackage.AFFINE_RELATION__SOURCE:
				return source != null;
			case AdfgPackage.AFFINE_RELATION__TARGET:
				return target != null;
			case AdfgPackage.AFFINE_RELATION__OWNER:
				return getOwner() != null;
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
		result.append(" (n: ");
		result.append(n);
		result.append(", phi: ");
		result.append(phi);
		result.append(", d: ");
		result.append(d);
		result.append(')');
		return result.toString();
	}

} //AffineRelationImpl
