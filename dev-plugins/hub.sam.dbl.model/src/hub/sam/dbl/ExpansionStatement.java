/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expansion Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getExpansionStatement()
 * @model
 * @generated
 */
public interface ExpansionStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExpansionPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpansionPart> getParts();

	/**
	 * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exprs</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_Exprs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExprs();

} // ExpansionStatement
