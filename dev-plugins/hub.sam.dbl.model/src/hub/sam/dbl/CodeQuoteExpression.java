/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Quote Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.CodeQuoteExpression#getQuotedCode <em>Quoted Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getCodeQuoteExpression()
 * @model
 * @generated
 */
public interface CodeQuoteExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Quoted Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quoted Code</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quoted Code</em>' containment reference.
	 * @see #setQuotedCode(QuotedCode)
	 * @see hub.sam.dbl.DblPackage#getCodeQuoteExpression_QuotedCode()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QuotedCode getQuotedCode();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.CodeQuoteExpression#getQuotedCode <em>Quoted Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quoted Code</em>' containment reference.
	 * @see #getQuotedCode()
	 * @generated
	 */
	void setQuotedCode(QuotedCode value);

} // CodeQuoteExpression
