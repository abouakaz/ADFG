/**
 */
package adfg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.GraphConnection#getSource <em>Source</em>}</li>
 *   <li>{@link adfg.GraphConnection#getTarget <em>Target</em>}</li>
 *   <li>{@link adfg.GraphConnection#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getGraphConnection()
 * @model
 * @generated
 */
public interface GraphConnection extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Graph)
	 * @see adfg.AdfgPackage#getGraphConnection_Source()
	 * @model required="true"
	 * @generated
	 */
	Graph getSource();

	/**
	 * Sets the value of the '{@link adfg.GraphConnection#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Graph value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Graph)
	 * @see adfg.AdfgPackage#getGraphConnection_Target()
	 * @model required="true"
	 * @generated
	 */
	Graph getTarget();

	/**
	 * Sets the value of the '{@link adfg.GraphConnection#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Graph value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link adfg.Application#getGraphConnections <em>Graph Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see adfg.AdfgPackage#getGraphConnection_Owner()
	 * @see adfg.Application#getGraphConnections
	 * @model opposite="GraphConnections" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link adfg.GraphConnection#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

} // GraphConnection
