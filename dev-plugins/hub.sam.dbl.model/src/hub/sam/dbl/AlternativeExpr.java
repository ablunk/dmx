/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.AlternativeExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link hub.sam.dbl.AlternativeExpr#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getAlternativeExpr()
 * @model
 * @generated
 */
public interface AlternativeExpr extends RhsExpression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(RhsExpression)
	 * @see hub.sam.dbl.DblPackage#getAlternativeExpr_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RhsExpression getLeft();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.AlternativeExpr#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(RhsExpression value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(RhsExpression)
	 * @see hub.sam.dbl.DblPackage#getAlternativeExpr_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RhsExpression getRight();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.AlternativeExpr#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(RhsExpression value);

} // AlternativeExpr
