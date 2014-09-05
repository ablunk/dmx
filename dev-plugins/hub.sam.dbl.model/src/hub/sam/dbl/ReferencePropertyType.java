/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Property Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ReferencePropertyType#isRawReference <em>Raw Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getReferencePropertyType()
 * @model
 * @generated
 */
public interface ReferencePropertyType extends StructuredPropertyType {
	/**
	 * Returns the value of the '<em><b>Raw Reference</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Reference</em>' attribute.
	 * @see #setRawReference(boolean)
	 * @see hub.sam.dbl.DblPackage#getReferencePropertyType_RawReference()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRawReference();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ReferencePropertyType#isRawReference <em>Raw Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Reference</em>' attribute.
	 * @see #isRawReference()
	 * @generated
	 */
	void setRawReference(boolean value);

} // ReferencePropertyType
