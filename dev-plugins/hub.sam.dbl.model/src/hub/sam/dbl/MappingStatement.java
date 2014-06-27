/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.MappingStatement#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.MappingStatement#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getMappingStatement()
 * @model
 * @generated
 */
public interface MappingStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.MappingPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getMappingStatement_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingPart> getParts();

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
	 * @see hub.sam.dbl.DblPackage#getMappingStatement_Exprs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExprs();

} // MappingStatement
