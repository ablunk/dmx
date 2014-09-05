/**
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
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getPropertyBindingExpr()
 * @model
 * @generated
 */
public interface PropertyBindingExpr extends NamedElement, L1RhsExpr {
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
	 * @model containment="true" required="true"
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

} // PropertyBindingExpr
