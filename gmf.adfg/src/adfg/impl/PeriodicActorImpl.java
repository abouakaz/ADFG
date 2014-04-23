/**
 */
package adfg.impl;

import adfg.AdfgPackage;
import adfg.AffineRelation;
import adfg.PeriodicActor;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Periodic Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getPeriodUpperBound <em>Period Upper Bound</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getPhase <em>Phase</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getAffineRelationSource <em>Affine Relation Source</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getAffineRelationTarget <em>Affine Relation Target</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getPeriodLowerBound <em>Period Lower Bound</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link adfg.impl.PeriodicActorImpl#getWcet <em>Wcet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeriodicActorImpl extends ActorImpl implements PeriodicActor {
	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final long PERIOD_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected long period = PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriodUpperBound() <em>Period Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final long PERIOD_UPPER_BOUND_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getPeriodUpperBound() <em>Period Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodUpperBound()
	 * @generated
	 * @ordered
	 */
	protected long periodUpperBound = PERIOD_UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected static final long PHASE_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected long phase = PHASE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAffineRelationSource() <em>Affine Relation Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffineRelationSource()
	 * @generated
	 * @ordered
	 */
	protected EList<AffineRelation> affineRelationSource;

	/**
	 * The cached value of the '{@link #getAffineRelationTarget() <em>Affine Relation Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffineRelationTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<AffineRelation> affineRelationTarget;

	/**
	 * The default value of the '{@link #getPeriodLowerBound() <em>Period Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final long PERIOD_LOWER_BOUND_EDEFAULT = -2L;

	/**
	 * The cached value of the '{@link #getPeriodLowerBound() <em>Period Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodLowerBound()
	 * @generated
	 * @ordered
	 */
	protected long periodLowerBound = PERIOD_LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected static final String DEADLINE_EDEFAULT = "1/1";

	/**
	 * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected String deadline = DEADLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWcet() <em>Wcet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWcet()
	 * @generated
	 * @ordered
	 */
	protected static final long WCET_EDEFAULT = 50L;

	/**
	 * The cached value of the '{@link #getWcet() <em>Wcet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWcet()
	 * @generated
	 * @ordered
	 */
	protected long wcet = WCET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeriodicActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.PERIODIC_ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(long newPeriod) {
		long oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PERIODIC_ACTOR__PERIOD, oldPeriod, period));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPeriodUpperBound() {
		return periodUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodUpperBound(long newPeriodUpperBound) {
		long oldPeriodUpperBound = periodUpperBound;
		periodUpperBound = newPeriodUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PERIODIC_ACTOR__PERIOD_UPPER_BOUND, oldPeriodUpperBound, periodUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPhase() {
		return phase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhase(long newPhase) {
		long oldPhase = phase;
		phase = newPhase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PERIODIC_ACTOR__PHASE, oldPhase, phase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AffineRelation> getAffineRelationSource() {
		if (affineRelationSource == null) {
			affineRelationSource = new EObjectWithInverseResolvingEList<AffineRelation>(AffineRelation.class, this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE, AdfgPackage.AFFINE_RELATION__SOURCE);
		}
		return affineRelationSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AffineRelation> getAffineRelationTarget() {
		if (affineRelationTarget == null) {
			affineRelationTarget = new EObjectWithInverseResolvingEList<AffineRelation>(AffineRelation.class, this, AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET, AdfgPackage.AFFINE_RELATION__TARGET);
		}
		return affineRelationTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPeriodLowerBound() {
		return periodLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodLowerBound(long newPeriodLowerBound) {
		long oldPeriodLowerBound = periodLowerBound;
		periodLowerBound = newPeriodLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PERIODIC_ACTOR__PERIOD_LOWER_BOUND, oldPeriodLowerBound, periodLowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeadline() {
		return deadline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadline(String newDeadline) {
		String oldDeadline = deadline;
		deadline = newDeadline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PERIODIC_ACTOR__DEADLINE, oldDeadline, deadline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWcet() {
		return wcet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWcet(long newWcet) {
		long oldWcet = wcet;
		wcet = newWcet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.PERIODIC_ACTOR__WCET, oldWcet, wcet));
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
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAffineRelationSource()).basicAdd(otherEnd, msgs);
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAffineRelationTarget()).basicAdd(otherEnd, msgs);
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
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE:
				return ((InternalEList<?>)getAffineRelationSource()).basicRemove(otherEnd, msgs);
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET:
				return ((InternalEList<?>)getAffineRelationTarget()).basicRemove(otherEnd, msgs);
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
			case AdfgPackage.PERIODIC_ACTOR__PERIOD:
				return getPeriod();
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_UPPER_BOUND:
				return getPeriodUpperBound();
			case AdfgPackage.PERIODIC_ACTOR__PHASE:
				return getPhase();
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE:
				return getAffineRelationSource();
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET:
				return getAffineRelationTarget();
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_LOWER_BOUND:
				return getPeriodLowerBound();
			case AdfgPackage.PERIODIC_ACTOR__DEADLINE:
				return getDeadline();
			case AdfgPackage.PERIODIC_ACTOR__WCET:
				return getWcet();
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
			case AdfgPackage.PERIODIC_ACTOR__PERIOD:
				setPeriod((Long)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_UPPER_BOUND:
				setPeriodUpperBound((Long)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__PHASE:
				setPhase((Long)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE:
				getAffineRelationSource().clear();
				getAffineRelationSource().addAll((Collection<? extends AffineRelation>)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET:
				getAffineRelationTarget().clear();
				getAffineRelationTarget().addAll((Collection<? extends AffineRelation>)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_LOWER_BOUND:
				setPeriodLowerBound((Long)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__DEADLINE:
				setDeadline((String)newValue);
				return;
			case AdfgPackage.PERIODIC_ACTOR__WCET:
				setWcet((Long)newValue);
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
			case AdfgPackage.PERIODIC_ACTOR__PERIOD:
				setPeriod(PERIOD_EDEFAULT);
				return;
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_UPPER_BOUND:
				setPeriodUpperBound(PERIOD_UPPER_BOUND_EDEFAULT);
				return;
			case AdfgPackage.PERIODIC_ACTOR__PHASE:
				setPhase(PHASE_EDEFAULT);
				return;
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE:
				getAffineRelationSource().clear();
				return;
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET:
				getAffineRelationTarget().clear();
				return;
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_LOWER_BOUND:
				setPeriodLowerBound(PERIOD_LOWER_BOUND_EDEFAULT);
				return;
			case AdfgPackage.PERIODIC_ACTOR__DEADLINE:
				setDeadline(DEADLINE_EDEFAULT);
				return;
			case AdfgPackage.PERIODIC_ACTOR__WCET:
				setWcet(WCET_EDEFAULT);
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
			case AdfgPackage.PERIODIC_ACTOR__PERIOD:
				return period != PERIOD_EDEFAULT;
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_UPPER_BOUND:
				return periodUpperBound != PERIOD_UPPER_BOUND_EDEFAULT;
			case AdfgPackage.PERIODIC_ACTOR__PHASE:
				return phase != PHASE_EDEFAULT;
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_SOURCE:
				return affineRelationSource != null && !affineRelationSource.isEmpty();
			case AdfgPackage.PERIODIC_ACTOR__AFFINE_RELATION_TARGET:
				return affineRelationTarget != null && !affineRelationTarget.isEmpty();
			case AdfgPackage.PERIODIC_ACTOR__PERIOD_LOWER_BOUND:
				return periodLowerBound != PERIOD_LOWER_BOUND_EDEFAULT;
			case AdfgPackage.PERIODIC_ACTOR__DEADLINE:
				return DEADLINE_EDEFAULT == null ? deadline != null : !DEADLINE_EDEFAULT.equals(deadline);
			case AdfgPackage.PERIODIC_ACTOR__WCET:
				return wcet != WCET_EDEFAULT;
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
		result.append(" (period: ");
		result.append(period);
		result.append(", periodUpperBound: ");
		result.append(periodUpperBound);
		result.append(", phase: ");
		result.append(phase);
		result.append(", periodLowerBound: ");
		result.append(periodLowerBound);
		result.append(", deadline: ");
		result.append(deadline);
		result.append(", wcet: ");
		result.append(wcet);
		result.append(')');
		return result.toString();
	}

} //PeriodicActorImpl
