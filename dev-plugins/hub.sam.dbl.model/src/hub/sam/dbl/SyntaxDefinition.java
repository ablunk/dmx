/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.SyntaxDefinition#getStartSymbol <em>Start Symbol</em>}</li>
 *   <li>{@link hub.sam.dbl.SyntaxDefinition#getSymbols <em>Symbols</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getSyntaxDefinition()
 * @model
 * @generated
 */
public interface SyntaxDefinition extends ExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Start Symbol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Symbol</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Symbol</em>' reference.
	 * @see #setStartSymbol(MetaSymbol)
	 * @see hub.sam.dbl.DblPackage#getSyntaxDefinition_StartSymbol()
	 * @model required="true"
	 * @generated
	 */
	MetaSymbol getStartSymbol();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SyntaxDefinition#getStartSymbol <em>Start Symbol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Symbol</em>' reference.
	 * @see #getStartSymbol()
	 * @generated
	 */
	void setStartSymbol(MetaSymbol value);

	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.MetaSymbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getSyntaxDefinition_Symbols()
	 * @model containment="true"
	 * @generated
	 */
	EList<MetaSymbol> getSymbols();

} // SyntaxDefinition
