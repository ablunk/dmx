/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.MetaSymbol#getPossibleSyntax <em>Possible Syntax</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getMetaSymbol()
 * @model
 * @generated
 */
public interface MetaSymbol extends NamedElement, ComplexSymbol {
	/**
	 * Returns the value of the '<em><b>Possible Syntax</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Syntax</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Syntax</em>' containment reference.
	 * @see #setPossibleSyntax(SyntaxExpression)
	 * @see hub.sam.dbl.DblPackage#getMetaSymbol_PossibleSyntax()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SyntaxExpression getPossibleSyntax();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.MetaSymbol#getPossibleSyntax <em>Possible Syntax</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Possible Syntax</em>' containment reference.
	 * @see #getPossibleSyntax()
	 * @generated
	 */
	void setPossibleSyntax(SyntaxExpression value);

} // MetaSymbol
