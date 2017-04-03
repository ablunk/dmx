/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Yield To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.YieldTo#getObjectAccess <em>Object Access</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getYieldTo()
 * @model
 * @generated
 */
public interface YieldTo extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Object Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Access</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Access</em>' containment reference.
	 * @see #setObjectAccess(Expression)
	 * @see hub.sam.dbl.DblPackage#getYieldTo_ObjectAccess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getObjectAccess();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.YieldTo#getObjectAccess <em>Object Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Access</em>' containment reference.
	 * @see #getObjectAccess()
	 * @generated
	 */
	void setObjectAccess(Expression value);

} // YieldTo
