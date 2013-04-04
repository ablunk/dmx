/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>At Least One Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.AtLeastOneExpr#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getAtLeastOneExpr()
 * @model
 * @generated
 */
public interface AtLeastOneExpr extends RhsExpression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(RhsExpression)
	 * @see hub.sam.dbl.DblPackage#getAtLeastOneExpr_Expression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	RhsExpression getExpression();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.AtLeastOneExpr#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(RhsExpression value);

} // AtLeastOneExpr
