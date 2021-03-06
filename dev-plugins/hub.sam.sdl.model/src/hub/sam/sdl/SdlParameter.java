/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sdl Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.sdl.SdlParameter#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.sdl.EmfSdlPackage#getSdlParameter()
 * @model
 * @generated
 */
public interface SdlParameter extends SdlVariable, CoreAbstractionsBehavioralFeaturesParameter, CoreAbstractionsTypedElementsTypedElement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link hub.sam.sdl.SdlParameterKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.SdlParameterKind
	 * @see #setKind(SdlParameterKind)
	 * @see hub.sam.sdl.EmfSdlPackage#getSdlParameter_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SdlParameterKind getKind();

	/**
	 * Sets the value of the '{@link hub.sam.sdl.SdlParameter#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see hub.sam.sdl.SdlParameterKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SdlParameterKind value);

} // SdlParameter
