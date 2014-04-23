/**
 */
package adfg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import adfg.schedulability.ADFGraph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.Graph#getName <em>Name</em>}</li>
 *   <li>{@link adfg.Graph#getOwner <em>Owner</em>}</li>
 *   <li>{@link adfg.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link adfg.Graph#getAffineRelations <em>Affine Relations</em>}</li>
 *   <li>{@link adfg.Graph#getConnections <em>Connections</em>}</li>
 *   <li>{@link adfg.Graph#getNbActors <em>Nb Actors</em>}</li>
 *   <li>{@link adfg.Graph#getNbBuffers <em>Nb Buffers</em>}</li>
 *   <li>{@link adfg.Graph#getId <em>Id</em>}</li>
 *   <li>{@link adfg.Graph#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link adfg.Graph#getProcessorUtilization <em>Processor Utilization</em>}</li>
 *   <li>{@link adfg.Graph#getBufferingRequirements <em>Buffering Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
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
	 * @see adfg.AdfgPackage#getGraph_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link adfg.Graph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link adfg.Application#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see adfg.AdfgPackage#getGraph_Owner()
	 * @see adfg.Application#getGraphs
	 * @model opposite="graphs" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link adfg.Graph#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link adfg.Actor}.
	 * It is bidirectional and its opposite is '{@link adfg.Actor#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see adfg.AdfgPackage#getGraph_Nodes()
	 * @see adfg.Actor#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<Actor> getNodes();

	/**
	 * Returns the value of the '<em><b>Affine Relations</b></em>' containment reference list.
	 * The list contents are of type {@link adfg.AffineRelation}.
	 * It is bidirectional and its opposite is '{@link adfg.AffineRelation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affine Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affine Relations</em>' containment reference list.
	 * @see adfg.AdfgPackage#getGraph_AffineRelations()
	 * @see adfg.AffineRelation#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<AffineRelation> getAffineRelations();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link adfg.Connection}.
	 * It is bidirectional and its opposite is '{@link adfg.Connection#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see adfg.AdfgPackage#getGraph_Connections()
	 * @see adfg.Connection#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Nb Actors</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute is used to automatically generate actors'/communicators' names. It will be incremented each time a new instance of Graph is created.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nb Actors</em>' attribute.
	 * @see #setNbActors(int)
	 * @see adfg.AdfgPackage#getGraph_NbActors()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getNbActors();

	/**
	 * Sets the value of the '{@link adfg.Graph#getNbActors <em>Nb Actors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Actors</em>' attribute.
	 * @see #getNbActors()
	 * @generated
	 */
	void setNbActors(int value);

	/**
	 * Returns the value of the '<em><b>Nb Buffers</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Buffers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Buffers</em>' attribute.
	 * @see #setNbBuffers(int)
	 * @see adfg.AdfgPackage#getGraph_NbBuffers()
	 * @model default="0"
	 * @generated
	 */
	int getNbBuffers();

	/**
	 * Sets the value of the '{@link adfg.Graph#getNbBuffers <em>Nb Buffers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Buffers</em>' attribute.
	 * @see #getNbBuffers()
	 * @generated
	 */
	void setNbBuffers(int value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see adfg.AdfgPackage#getGraph_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link adfg.Graph#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

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
	 * @see adfg.AdfgPackage#getGraph_SourceCode()
	 * @model
	 * @generated
	 */
	String getSourceCode();

	/**
	 * Sets the value of the '{@link adfg.Graph#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);
	
	/**
	 * Returns the value of the '<em><b>Processor Utilization</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor Utilization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor Utilization</em>' attribute.
	 * @see #setProcessorUtilization(double)
	 * @see adfg.AdfgPackage#getGraph_ProcessorUtilization()
	 * @model default="0" required="true" derived="true"
	 * @generated
	 */
	double getProcessorUtilization();

	/**
	 * Sets the value of the '{@link adfg.Graph#getProcessorUtilization <em>Processor Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor Utilization</em>' attribute.
	 * @see #getProcessorUtilization()
	 * @generated
	 */
	void setProcessorUtilization(double value);

	/**
	 * Returns the value of the '<em><b>Buffering Requirements</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffering Requirements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffering Requirements</em>' attribute.
	 * @see #setBufferingRequirements(int)
	 * @see adfg.AdfgPackage#getGraph_BufferingRequirements()
	 * @model default="0" required="true" derived="true"
	 * @generated
	 */
	int getBufferingRequirements();

	/**
	 * Sets the value of the '{@link adfg.Graph#getBufferingRequirements <em>Buffering Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffering Requirements</em>' attribute.
	 * @see #getBufferingRequirements()
	 * @generated
	 */
	void setBufferingRequirements(int value);

	/**
	 ** @generated NOT
	 */
	ADFGraph getDataflow();
	
	/**
	 * @generated NOT
	 */
	public boolean isLoaded();
	
	/**
	 * @generated NOT
	 */
	public void setLoaded();
	
	/**
	 * @generated NOT
	 */
	public void setDeactivated();

} // Graph
