/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parse Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ParseExpr#getAstPart <em>Ast Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getParseExpr()
 * @model
 * @generated
 */
public interface ParseExpr extends Expression {
	/**
	 * Returns the value of the '<em><b>Ast Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast Part</em>' containment reference.
	 * @see #setAstPart(Construct)
	 * @see hub.sam.dbl.DblPackage#getParseExpr_AstPart()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Construct getAstPart();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ParseExpr#getAstPart <em>Ast Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast Part</em>' containment reference.
	 * @see #getAstPart()
	 * @generated
	 */
	void setAstPart(Construct value);

} // ParseExpr
