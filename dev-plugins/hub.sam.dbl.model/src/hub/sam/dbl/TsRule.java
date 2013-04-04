/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ts Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.TsRule#getMetaClassName <em>Meta Class Name</em>}</li>
 *   <li>{@link hub.sam.dbl.TsRule#getRhs <em>Rhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getTsRule()
 * @model
 * @generated
 */
public interface TsRule extends NamedElement, ReferableRhsType {
	/**
	 * Returns the value of the '<em><b>Meta Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Class Name</em>' attribute.
	 * @see #setMetaClassName(String)
	 * @see hub.sam.dbl.DblPackage#getTsRule_MetaClassName()
	 * @model ordered="false"
	 * @generated
	 */
	String getMetaClassName();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TsRule#getMetaClassName <em>Meta Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Class Name</em>' attribute.
	 * @see #getMetaClassName()
	 * @generated
	 */
	void setMetaClassName(String value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(RhsExpression)
	 * @see hub.sam.dbl.DblPackage#getTsRule_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RhsExpression getRhs();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TsRule#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(RhsExpression value);

} // TsRule
