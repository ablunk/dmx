/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Binding Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.PropertyBindingExpr#getPropertyType <em>Property Type</em>}</li>
 *   <li>{@link hub.sam.dbl.PropertyBindingExpr#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getPropertyBindingExpr()
 * @model
 * @generated
 */
public interface PropertyBindingExpr extends NamedElement, RhsExpression {
	/**
	 * Returns the value of the '<em><b>Property Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Type</em>' containment reference.
	 * @see #setPropertyType(PropertyType)
	 * @see hub.sam.dbl.DblPackage#getPropertyBindingExpr_PropertyType()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PropertyType getPropertyType();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.PropertyBindingExpr#getPropertyType <em>Property Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Type</em>' containment reference.
	 * @see #getPropertyType()
	 * @generated
	 */
	void setPropertyType(PropertyType value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.dbl.BindingExprOpKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see hub.sam.dbl.BindingExprOpKind
	 * @see #setOperator(BindingExprOpKind)
	 * @see hub.sam.dbl.DblPackage#getPropertyBindingExpr_Operator()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BindingExprOpKind getOperator();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.PropertyBindingExpr#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see hub.sam.dbl.BindingExprOpKind
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(BindingExprOpKind value);

} // PropertyBindingExpr
