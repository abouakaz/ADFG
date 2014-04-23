/**
 */
package adfg;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Periodic Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.PeriodicActor#getPeriod <em>Period</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getPeriodUpperBound <em>Period Upper Bound</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getPhase <em>Phase</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getAffineRelationSource <em>Affine Relation Source</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getAffineRelationTarget <em>Affine Relation Target</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getPeriodLowerBound <em>Period Lower Bound</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link adfg.PeriodicActor#getWcet <em>Wcet</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getPeriodicActor()
 * @model
 * @generated
 */
public interface PeriodicActor extends Actor {
	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(long)
	 * @see adfg.AdfgPackage#getPeriodicActor_Period()
	 * @model default="-1" required="true"
	 * @generated
	 */
	long getPeriod();

	/**
	 * Sets the value of the '{@link adfg.PeriodicActor#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(long value);

	/**
	 * Returns the value of the '<em><b>Period Upper Bound</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period Upper Bound</em>' attribute.
	 * @see #setPeriodUpperBound(long)
	 * @see adfg.AdfgPackage#getPeriodicActor_PeriodUpperBound()
	 * @model default="-1" required="true"
	 * @generated
	 */
	long getPeriodUpperBound();

	/**
	 * Sets the value of the '{@link adfg.PeriodicActor#getPeriodUpperBound <em>Period Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Upper Bound</em>' attribute.
	 * @see #getPeriodUpperBound()
	 * @generated
	 */
	void setPeriodUpperBound(long value);

	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see #setPhase(long)
	 * @see adfg.AdfgPackage#getPeriodicActor_Phase()
	 * @model default="-1" required="true"
	 * @generated
	 */
	long getPhase();

	/**
	 * Sets the value of the '{@link adfg.PeriodicActor#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(long value);

	/**
	 * Returns the value of the '<em><b>Affine Relation Source</b></em>' reference list.
	 * The list contents are of type {@link adfg.AffineRelation}.
	 * It is bidirectional and its opposite is '{@link adfg.AffineRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affine Relation Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affine Relation Source</em>' reference list.
	 * @see adfg.AdfgPackage#getPeriodicActor_AffineRelationSource()
	 * @see adfg.AffineRelation#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<AffineRelation> getAffineRelationSource();

	/**
	 * Returns the value of the '<em><b>Affine Relation Target</b></em>' reference list.
	 * The list contents are of type {@link adfg.AffineRelation}.
	 * It is bidirectional and its opposite is '{@link adfg.AffineRelation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affine Relation Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affine Relation Target</em>' reference list.
	 * @see adfg.AdfgPackage#getPeriodicActor_AffineRelationTarget()
	 * @see adfg.AffineRelation#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<AffineRelation> getAffineRelationTarget();

	/**
	 * Returns the value of the '<em><b>Period Lower Bound</b></em>' attribute.
	 * The default value is <code>"-2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period Lower Bound</em>' attribute.
	 * @see #setPeriodLowerBound(long)
	 * @see adfg.AdfgPackage#getPeriodicActor_PeriodLowerBound()
	 * @model default="-2" required="true"
	 * @generated
	 */
	long getPeriodLowerBound();

	/**
	 * Sets the value of the '{@link adfg.PeriodicActor#getPeriodLowerBound <em>Period Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Lower Bound</em>' attribute.
	 * @see #getPeriodLowerBound()
	 * @generated
	 */
	void setPeriodLowerBound(long value);

	/**
	 * Returns the value of the '<em><b>Deadline</b></em>' attribute.
	 * The default value is <code>"1/1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline</em>' attribute.
	 * @see #setDeadline(String)
	 * @see adfg.AdfgPackage#getPeriodicActor_Deadline()
	 * @model default="1/1" required="true"
	 * @generated
	 */
	String getDeadline();

	/**
	 * Sets the value of the '{@link adfg.PeriodicActor#getDeadline <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline</em>' attribute.
	 * @see #getDeadline()
	 * @generated
	 */
	void setDeadline(String value);

	/**
	 * Returns the value of the '<em><b>Wcet</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wcet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wcet</em>' attribute.
	 * @see #setWcet(long)
	 * @see adfg.AdfgPackage#getPeriodicActor_Wcet()
	 * @model default="50" required="true"
	 * @generated
	 */
	long getWcet();

	/**
	 * Sets the value of the '{@link adfg.PeriodicActor#getWcet <em>Wcet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wcet</em>' attribute.
	 * @see #getWcet()
	 * @generated
	 */
	void setWcet(long value);

} // PeriodicActor
