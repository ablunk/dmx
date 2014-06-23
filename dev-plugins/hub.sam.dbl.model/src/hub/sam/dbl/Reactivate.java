/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reactivate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Reactivate#getObjectAccess <em>Object Access</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getReactivate()
 * @model
 * @generated
 */
public interface Reactivate extends SimpleStatement {
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
	 * @see hub.sam.dbl.DblPackage#getReactivate_ObjectAccess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getObjectAccess();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Reactivate#getObjectAccess <em>Object Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Access</em>' containment reference.
	 * @see #getObjectAccess()
	 * @generated
	 */
	void setObjectAccess(Expression value);

} // Reactivate
