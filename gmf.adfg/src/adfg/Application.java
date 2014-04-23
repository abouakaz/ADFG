/**
 */
package adfg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.Application#getGraphs <em>Graphs</em>}</li>
 *   <li>{@link adfg.Application#getNbGraphs <em>Nb Graphs</em>}</li>
 *   <li>{@link adfg.Application#getName <em>Name</em>}</li>
 *   <li>{@link adfg.Application#getNbProcessors <em>Nb Processors</em>}</li>
 *   <li>{@link adfg.Application#getGraphConnections <em>Graph Connections</em>}</li>
 *   <li>{@link adfg.Application#isDynamicChecking <em>Dynamic Checking</em>}</li>
 *   <li>{@link adfg.Application#getSchedulingAlgorithm <em>Scheduling Algorithm</em>}</li>
 *   <li>{@link adfg.Application#getSourceCode <em>Source Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends EObject {
	/**
	 * Returns the value of the '<em><b>Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link adfg.Graph}.
	 * It is bidirectional and its opposite is '{@link adfg.Graph#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphs</em>' containment reference list.
	 * @see adfg.AdfgPackage#getApplication_Graphs()
	 * @see adfg.Graph#getOwner
	 * @model opposite="owner" containment="true" keys="name"
	 * @generated
	 */
	EList<Graph> getGraphs();

	/**
	 * Returns the value of the '<em><b>Nb Graphs</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute is used to automatically generate graphs' names. It will be incremented each time a new instance of Graph is created.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nb Graphs</em>' attribute.
	 * @see #setNbGraphs(int)
	 * @see adfg.AdfgPackage#getApplication_NbGraphs()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getNbGraphs();

	/**
	 * Sets the value of the '{@link adfg.Application#getNbGraphs <em>Nb Graphs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Graphs</em>' attribute.
	 * @see #getNbGraphs()
	 * @generated
	 */
	void setNbGraphs(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Application"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see adfg.AdfgPackage#getApplication_Name()
	 * @model default="Application" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link adfg.Application#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Nb Processors</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Processors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Processors</em>' attribute.
	 * @see #setNbProcessors(int)
	 * @see adfg.AdfgPackage#getApplication_NbProcessors()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getNbProcessors();

	/**
	 * Sets the value of the '{@link adfg.Application#getNbProcessors <em>Nb Processors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Processors</em>' attribute.
	 * @see #getNbProcessors()
	 * @generated
	 */
	void setNbProcessors(int value);

	/**
	 * Returns the value of the '<em><b>Graph Connections</b></em>' containment reference list.
	 * The list contents are of type {@link adfg.GraphConnection}.
	 * It is bidirectional and its opposite is '{@link adfg.GraphConnection#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph Connections</em>' containment reference list.
	 * @see adfg.AdfgPackage#getApplication_GraphConnections()
	 * @see adfg.GraphConnection#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<GraphConnection> getGraphConnections();

	/**
	 * Returns the value of the '<em><b>Dynamic Checking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Checking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Checking</em>' attribute.
	 * @see #setDynamicChecking(boolean)
	 * @see adfg.AdfgPackage#getApplication_DynamicChecking()
	 * @model required="true"
	 * @generated
	 */
	boolean isDynamicChecking();

	/**
	 * Sets the value of the '{@link adfg.Application#isDynamicChecking <em>Dynamic Checking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Checking</em>' attribute.
	 * @see #isDynamicChecking()
	 * @generated
	 */
	void setDynamicChecking(boolean value);

	/**
	 * Returns the value of the '<em><b>Scheduling Algorithm</b></em>' attribute.
	 * The default value is <code>"User"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling Algorithm</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling Algorithm</em>' attribute.
	 * @see #setSchedulingAlgorithm(String)
	 * @see adfg.AdfgPackage#getApplication_SchedulingAlgorithm()
	 * @model default="User" required="true"
	 * @generated
	 */
	String getSchedulingAlgorithm();

	/**
	 * Sets the value of the '{@link adfg.Application#getSchedulingAlgorithm <em>Scheduling Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling Algorithm</em>' attribute.
	 * @see #getSchedulingAlgorithm()
	 * @generated
	 */
	void setSchedulingAlgorithm(String value);

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
	 * @see adfg.AdfgPackage#getApplication_SourceCode()
	 * @model
	 * @generated
	 */
	String getSourceCode();

	/**
	 * Sets the value of the '{@link adfg.Application#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);

} // Application
