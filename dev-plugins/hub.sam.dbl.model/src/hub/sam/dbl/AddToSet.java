/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add To Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.AddToSet#getAtIndex <em>At Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getAddToSet()
 * @model
 * @generated
 */
public interface AddToSet extends SetStatement {
	/**
	 * Returns the value of the '<em><b>At Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Index</em>' containment reference.
	 * @see #setAtIndex(ArgumentExpression)
	 * @see hub.sam.dbl.DblPackage#getAddToSet_AtIndex()
	 * @model containment="true"
	 * @generated
	 */
	ArgumentExpression getAtIndex();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.AddToSet#getAtIndex <em>At Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Index</em>' containment reference.
	 * @see #getAtIndex()
	 * @generated
	 */
	void setAtIndex(ArgumentExpression value);

} // AddToSet
