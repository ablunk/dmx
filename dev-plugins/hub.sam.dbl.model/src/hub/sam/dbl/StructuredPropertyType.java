/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structured Property Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.StructuredPropertyType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getStructuredPropertyType()
 * @model
 * @generated
 */
public interface StructuredPropertyType extends PropertyType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(LanguageConstructClassifier)
	 * @see hub.sam.dbl.DblPackage#getStructuredPropertyType_Type()
	 * @model required="true"
	 * @generated
	 */
	LanguageConstructClassifier getType();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.StructuredPropertyType#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(LanguageConstructClassifier value);

} // StructuredPropertyType
