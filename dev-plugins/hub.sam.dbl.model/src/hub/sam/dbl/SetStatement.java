/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.SetStatement#getObject <em>Object</em>}</li>
 *   <li>{@link hub.sam.dbl.SetStatement#getSet <em>Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getSetStatement()
 * @model abstract="true"
 * @generated
 */
public interface SetStatement extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(Expression)
	 * @see hub.sam.dbl.DblPackage#getSetStatement_Object()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getObject();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SetStatement#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(Expression value);

	/**
	 * Returns the value of the '<em><b>Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set</em>' containment reference.
	 * @see #setSet(Expression)
	 * @see hub.sam.dbl.DblPackage#getSetStatement_Set()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getSet();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SetStatement#getSet <em>Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set</em>' containment reference.
	 * @see #getSet()
	 * @generated
	 */
	void setSet(Expression value);

} // SetStatement
