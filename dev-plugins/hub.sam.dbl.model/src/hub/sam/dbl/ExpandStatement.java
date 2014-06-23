/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expand Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ExpandStatement#getMetaObject <em>Meta Object</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpandStatement#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getExpandStatement()
 * @model
 * @generated
 */
public interface ExpandStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Meta Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Object</em>' containment reference.
	 * @see #setMetaObject(Expression)
	 * @see hub.sam.dbl.DblPackage#getExpandStatement_MetaObject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getMetaObject();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpandStatement#getMetaObject <em>Meta Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Object</em>' containment reference.
	 * @see #getMetaObject()
	 * @generated
	 */
	void setMetaObject(Expression value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Expression)
	 * @see hub.sam.dbl.DblPackage#getExpandStatement_Location()
	 * @model containment="true"
	 * @generated
	 */
	Expression getLocation();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpandStatement#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Expression value);

} // ExpandStatement
