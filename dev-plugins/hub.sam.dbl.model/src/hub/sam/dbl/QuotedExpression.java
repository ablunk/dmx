/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quoted Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.QuotedExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getQuotedExpression()
 * @model
 * @generated
 */
public interface QuotedExpression extends QuotedCode {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see hub.sam.dbl.DblPackage#getQuotedExpression_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.QuotedExpression#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // QuotedExpression
