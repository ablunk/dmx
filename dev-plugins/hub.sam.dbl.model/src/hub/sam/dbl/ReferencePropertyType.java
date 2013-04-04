/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 *   <li>{@link hub.sam.dbl.ReferencePropertyType#getIdResolutionPattern <em>Id Resolution Pattern</em>}</li>
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
	 * Returns the value of the '<em><b>Id Resolution Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Resolution Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Resolution Pattern</em>' reference.
	 * @see #setIdResolutionPattern(Pattern)
	 * @see hub.sam.dbl.DblPackage#getReferencePropertyType_IdResolutionPattern()
	 * @model ordered="false"
	 * @generated
	 */
	Pattern getIdResolutionPattern();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ReferencePropertyType#getIdResolutionPattern <em>Id Resolution Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Resolution Pattern</em>' reference.
	 * @see #getIdResolutionPattern()
	 * @generated
	 */
	void setIdResolutionPattern(Pattern value);

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
	 * @model default="false" required="true" ordered="false"
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
