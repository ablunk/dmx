/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Property Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.BooleanPropertyType#getTerminal <em>Terminal</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getBooleanPropertyType()
 * @model
 * @generated
 */
public interface BooleanPropertyType extends PropertyType {
	/**
	 * Returns the value of the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal</em>' attribute.
	 * @see #setTerminal(String)
	 * @see hub.sam.dbl.DblPackage#getBooleanPropertyType_Terminal()
	 * @model required="true"
	 * @generated
	 */
	String getTerminal();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.BooleanPropertyType#getTerminal <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #getTerminal()
	 * @generated
	 */
	void setTerminal(String value);

} // BooleanPropertyType
