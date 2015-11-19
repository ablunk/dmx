/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Return#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getReturn()
 * @model
 * @generated
 */
public interface Return extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see hub.sam.dbl.DblPackage#getReturn_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Return#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // Return
