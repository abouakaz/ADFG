/**
 */
package adfg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link adfg.Channel#getInitial <em>Initial</em>}</li>
 * </ul>
 * </p>
 *
 * @see adfg.AdfgPackage#getChannel()
 * @model
 * @generated
 */
public interface Channel extends Connection {
	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(int)
	 * @see adfg.AdfgPackage#getChannel_Initial()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getInitial();

	/**
	 * Sets the value of the '{@link adfg.Channel#getInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(int value);

} // Channel
