/**
 */
package adfg.impl;

import adfg.AdfgPackage;
import adfg.AperiodicActor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aperiodic Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link adfg.impl.AperiodicActorImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link adfg.impl.AperiodicActorImpl#getReplenishmentPeriod <em>Replenishment Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AperiodicActorImpl extends ActorImpl implements AperiodicActor {
	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final long CAPACITY_EDEFAULT = 50L;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected long capacity = CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplenishmentPeriod() <em>Replenishment Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplenishmentPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final long REPLENISHMENT_PERIOD_EDEFAULT = 100L;

	/**
	 * The cached value of the '{@link #getReplenishmentPeriod() <em>Replenishment Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplenishmentPeriod()
	 * @generated
	 * @ordered
	 */
	protected long replenishmentPeriod = REPLENISHMENT_PERIOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AperiodicActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdfgPackage.Literals.APERIODIC_ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(long newCapacity) {
		long oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APERIODIC_ACTOR__CAPACITY, oldCapacity, capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getReplenishmentPeriod() {
		return replenishmentPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplenishmentPeriod(long newReplenishmentPeriod) {
		long oldReplenishmentPeriod = replenishmentPeriod;
		replenishmentPeriod = newReplenishmentPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdfgPackage.APERIODIC_ACTOR__REPLENISHMENT_PERIOD, oldReplenishmentPeriod, replenishmentPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdfgPackage.APERIODIC_ACTOR__CAPACITY:
				return getCapacity();
			case AdfgPackage.APERIODIC_ACTOR__REPLENISHMENT_PERIOD:
				return getReplenishmentPeriod();
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
			case AdfgPackage.APERIODIC_ACTOR__CAPACITY:
				setCapacity((Long)newValue);
				return;
			case AdfgPackage.APERIODIC_ACTOR__REPLENISHMENT_PERIOD:
				setReplenishmentPeriod((Long)newValue);
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
			case AdfgPackage.APERIODIC_ACTOR__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case AdfgPackage.APERIODIC_ACTOR__REPLENISHMENT_PERIOD:
				setReplenishmentPeriod(REPLENISHMENT_PERIOD_EDEFAULT);
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
			case AdfgPackage.APERIODIC_ACTOR__CAPACITY:
				return capacity != CAPACITY_EDEFAULT;
			case AdfgPackage.APERIODIC_ACTOR__REPLENISHMENT_PERIOD:
				return replenishmentPeriod != REPLENISHMENT_PERIOD_EDEFAULT;
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
		result.append(" (capacity: ");
		result.append(capacity);
		result.append(", replenishmentPeriod: ");
		result.append(replenishmentPeriod);
		result.append(')');
		return result.toString();
	}

} //AperiodicActorImpl
