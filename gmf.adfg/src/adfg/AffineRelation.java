/**
 */
package adfg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Affine Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.AffineRelation#getN <em>N</em>}</li>
 *   <li>{@link adfg.AffineRelation#getPhi <em>Phi</em>}</li>
 *   <li>{@link adfg.AffineRelation#getD <em>D</em>}</li>
 *   <li>{@link adfg.AffineRelation#getSource <em>Source</em>}</li>
 *   <li>{@link adfg.AffineRelation#getTarget <em>Target</em>}</li>
 *   <li>{@link adfg.AffineRelation#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getAffineRelation()
 * @model
 * @generated
 */
public interface AffineRelation extends EObject {
	/**
	 * Returns the value of the '<em><b>N</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N</em>' attribute.
	 * @see #setN(int)
	 * @see adfg.AdfgPackage#getAffineRelation_N()
	 * @model default="2" required="true"
	 * @generated
	 */
	int getN();

	/**
	 * Sets the value of the '{@link adfg.AffineRelation#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N</em>' attribute.
	 * @see #getN()
	 * @generated
	 */
	void setN(int value);

	/**
	 * Returns the value of the '<em><b>Phi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phi</em>' attribute.
	 * @see #setPhi(int)
	 * @see adfg.AdfgPackage#getAffineRelation_Phi()
	 * @model required="true"
	 * @generated
	 */
	int getPhi();

	/**
	 * Sets the value of the '{@link adfg.AffineRelation#getPhi <em>Phi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phi</em>' attribute.
	 * @see #getPhi()
	 * @generated
	 */
	void setPhi(int value);

	/**
	 * Returns the value of the '<em><b>D</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D</em>' attribute.
	 * @see #setD(int)
	 * @see adfg.AdfgPackage#getAffineRelation_D()
	 * @model default="2" required="true"
	 * @generated
	 */
	int getD();

	/**
	 * Sets the value of the '{@link adfg.AffineRelation#getD <em>D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D</em>' attribute.
	 * @see #getD()
	 * @generated
	 */
	void setD(int value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link adfg.PeriodicActor#getAffineRelationSource <em>Affine Relation Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PeriodicActor)
	 * @see adfg.AdfgPackage#getAffineRelation_Source()
	 * @see adfg.PeriodicActor#getAffineRelationSource
	 * @model opposite="affineRelationSource" required="true"
	 * @generated
	 */
	PeriodicActor getSource();

	/**
	 * Sets the value of the '{@link adfg.AffineRelation#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PeriodicActor value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link adfg.PeriodicActor#getAffineRelationTarget <em>Affine Relation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(PeriodicActor)
	 * @see adfg.AdfgPackage#getAffineRelation_Target()
	 * @see adfg.PeriodicActor#getAffineRelationTarget
	 * @model opposite="affineRelationTarget" required="true"
	 * @generated
	 */
	PeriodicActor getTarget();

	/**
	 * Sets the value of the '{@link adfg.AffineRelation#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PeriodicActor value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link adfg.Graph#getAffineRelations <em>Affine Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Graph)
	 * @see adfg.AdfgPackage#getAffineRelation_Owner()
	 * @see adfg.Graph#getAffineRelations
	 * @model opposite="affineRelations" required="true" transient="false"
	 * @generated
	 */
	Graph getOwner();

	/**
	 * Sets the value of the '{@link adfg.AffineRelation#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Graph value);

} // AffineRelation
