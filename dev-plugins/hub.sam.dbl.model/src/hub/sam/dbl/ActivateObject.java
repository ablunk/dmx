/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activate Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.ActivateObject#getObjectAccess <em>Object Access</em>}</li>
 *   <li>{@link hub.sam.dbl.ActivateObject#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getActivateObject()
 * @model
 * @generated
 */
public interface ActivateObject extends SimpleStatement {
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
	 * @see hub.sam.dbl.DblPackage#getActivateObject_ObjectAccess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getObjectAccess();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ActivateObject#getObjectAccess <em>Object Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Access</em>' containment reference.
	 * @see #getObjectAccess()
	 * @generated
	 */
	void setObjectAccess(Expression value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see hub.sam.dbl.DblPackage#getActivateObject_Priority()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ActivateObject#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

} // ActivateObject
