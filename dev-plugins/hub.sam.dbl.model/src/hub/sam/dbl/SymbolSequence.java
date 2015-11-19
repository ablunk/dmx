/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.SymbolSequence#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getSymbolSequence()
 * @model
 * @generated
 */
public interface SymbolSequence extends L2SyntaxExpression {
	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.SyntaxExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getSymbolSequence_Sequence()
	 * @model containment="true"
	 * @generated
	 */
	EList<SyntaxExpression> getSequence();

} // SymbolSequence
