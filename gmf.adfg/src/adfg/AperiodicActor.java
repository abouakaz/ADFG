/**
 */
package adfg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aperiodic Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.AperiodicActor#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link adfg.AperiodicActor#getReplenishmentPeriod <em>Replenishment Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getAperiodicActor()
 * @model
 * @generated
 */
public interface AperiodicActor extends Actor {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(long)
	 * @see adfg.AdfgPackage#getAperiodicActor_Capacity()
	 * @model default="50" required="true"
	 * @generated
	 */
	long getCapacity();

	/**
	 * Sets the value of the '{@link adfg.AperiodicActor#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(long value);

	/**
	 * Returns the value of the '<em><b>Replenishment Period</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replenishment Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replenishment Period</em>' attribute.
	 * @see #setReplenishmentPeriod(long)
	 * @see adfg.AdfgPackage#getAperiodicActor_ReplenishmentPeriod()
	 * @model default="100" required="true"
	 * @generated
	 */
	long getReplenishmentPeriod();

	/**
	 * Sets the value of the '{@link adfg.AperiodicActor#getReplenishmentPeriod <em>Replenishment Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replenishment Period</em>' attribute.
	 * @see #getReplenishmentPeriod()
	 * @generated
	 */
	void setReplenishmentPeriod(long value);

} // AperiodicActor
