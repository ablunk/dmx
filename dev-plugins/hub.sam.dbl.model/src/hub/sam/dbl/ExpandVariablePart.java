/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expand Variable Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.ExpandVariablePart#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getExpandVariablePart()
 * @model
 * @generated
 */
public interface ExpandVariablePart extends ExpansionPart {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Expression)
	 * @see hub.sam.dbl.DblPackage#getExpandVariablePart_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpandVariablePart#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

} // ExpandVariablePart
