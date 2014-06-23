/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consider Id Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ConsiderIdElements#getElementsQuery <em>Elements Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getConsiderIdElements()
 * @model
 * @generated
 */
public interface ConsiderIdElements extends Statement {
	/**
	 * Returns the value of the '<em><b>Elements Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements Query</em>' containment reference.
	 * @see #setElementsQuery(Expression)
	 * @see hub.sam.dbl.DblPackage#getConsiderIdElements_ElementsQuery()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getElementsQuery();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ConsiderIdElements#getElementsQuery <em>Elements Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elements Query</em>' containment reference.
	 * @see #getElementsQuery()
	 * @generated
	 */
	void setElementsQuery(Expression value);

} // ConsiderIdElements
