/**
 */
package adfg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.Actor#getOwner <em>Owner</em>}</li>
 *   <li>{@link adfg.Actor#getPorts <em>Ports</em>}</li>
 *   <li>{@link adfg.Actor#getNbPorts <em>Nb Ports</em>}</li>
 *   <li>{@link adfg.Actor#getName <em>Name</em>}</li>
 *   <li>{@link adfg.Actor#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link adfg.Actor#getPriority <em>Priority</em>}</li>
 *   <li>{@link adfg.Actor#getProcNumber <em>Proc Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getActor()
 * @model abstract="true"
 * @generated
 */
public interface Actor extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link adfg.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Graph)
	 * @see adfg.AdfgPackage#getActor_Owner()
	 * @see adfg.Graph#getNodes
	 * @model opposite="nodes" required="true" transient="false"
	 * @generated
	 */
	Graph getOwner();

	/**
	 * Sets the value of the '{@link adfg.Actor#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Graph value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link adfg.Port}.
	 * It is bidirectional and its opposite is '{@link adfg.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see adfg.AdfgPackage#getActor_Ports()
	 * @see adfg.Port#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Port> getPorts();

	/**
	 * Returns the value of the '<em><b>Nb Ports</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Ports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Ports</em>' attribute.
	 * @see #setNbPorts(int)
	 * @see adfg.AdfgPackage#getActor_NbPorts()
	 * @model default="0"
	 * @generated
	 */
	int getNbPorts();

	/**
	 * Sets the value of the '{@link adfg.Actor#getNbPorts <em>Nb Ports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Ports</em>' attribute.
	 * @see #getNbPorts()
	 * @generated
	 */
	void setNbPorts(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see adfg.AdfgPackage#getActor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link adfg.Actor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Code</em>' attribute.
	 * @see #setSourceCode(String)
	 * @see adfg.AdfgPackage#getActor_SourceCode()
	 * @model
	 * @generated
	 */
	String getSourceCode();

	/**
	 * Sets the value of the '{@link adfg.Actor#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see adfg.AdfgPackage#getActor_Priority()
	 * @model required="true"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link adfg.Actor#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Proc Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proc Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proc Number</em>' attribute.
	 * @see #setProcNumber(int)
	 * @see adfg.AdfgPackage#getActor_ProcNumber()
	 * @model required="true"
	 * @generated
	 */
	int getProcNumber();

	/**
	 * Sets the value of the '{@link adfg.Actor#getProcNumber <em>Proc Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proc Number</em>' attribute.
	 * @see #getProcNumber()
	 * @generated
	 */
	void setProcNumber(int value);

} // Actor
