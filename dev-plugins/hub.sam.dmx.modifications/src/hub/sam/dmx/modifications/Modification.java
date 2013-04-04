/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.Modification#getSourceEObjectUri <em>Source EObject Uri</em>}</li>
 *   <li>{@link hub.sam.dmx.modifications.Modification#getSourceStart <em>Source Start</em>}</li>
 *   <li>{@link hub.sam.dmx.modifications.Modification#getReplacementText <em>Replacement Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dmx.modifications.ModificationsPackage#getModification()
 * @model abstract="true"
 * @generated
 */
public interface Modification extends EObject {
	/**
	 * Returns the value of the '<em><b>Source EObject Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source EObject Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source EObject Uri</em>' attribute.
	 * @see #setSourceEObjectUri(String)
	 * @see hub.sam.dmx.modifications.ModificationsPackage#getModification_SourceEObjectUri()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSourceEObjectUri();

	/**
	 * Sets the value of the '{@link hub.sam.dmx.modifications.Modification#getSourceEObjectUri <em>Source EObject Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source EObject Uri</em>' attribute.
	 * @see #getSourceEObjectUri()
	 * @generated
	 */
	void setSourceEObjectUri(String value);

	/**
	 * Returns the value of the '<em><b>Source Start</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Start</em>' attribute.
	 * @see #setSourceStart(int)
	 * @see hub.sam.dmx.modifications.ModificationsPackage#getModification_SourceStart()
	 * @model default="-1" required="true" ordered="false"
	 * @generated
	 */
	int getSourceStart();

	/**
	 * Sets the value of the '{@link hub.sam.dmx.modifications.Modification#getSourceStart <em>Source Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Start</em>' attribute.
	 * @see #getSourceStart()
	 * @generated
	 */
	void setSourceStart(int value);

	/**
	 * Returns the value of the '<em><b>Replacement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement Text</em>' attribute.
	 * @see #setReplacementText(String)
	 * @see hub.sam.dmx.modifications.ModificationsPackage#getModification_ReplacementText()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getReplacementText();

	/**
	 * Sets the value of the '{@link hub.sam.dmx.modifications.Modification#getReplacementText <em>Replacement Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement Text</em>' attribute.
	 * @see #getReplacementText()
	 * @generated
	 */
	void setReplacementText(String value);

} // Modification
