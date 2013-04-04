/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.Substitution#getSourceLength <em>Source Length</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dmx.modifications.ModificationsPackage#getSubstitution()
 * @model
 * @generated
 */
public interface Substitution extends Modification {
	/**
	 * Returns the value of the '<em><b>Source Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Length</em>' attribute.
	 * @see #setSourceLength(int)
	 * @see hub.sam.dmx.modifications.ModificationsPackage#getSubstitution_SourceLength()
	 * @model default="-1" required="true" ordered="false"
	 * @generated
	 */
	int getSourceLength();

	/**
	 * Sets the value of the '{@link hub.sam.dmx.modifications.Substitution#getSourceLength <em>Source Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Length</em>' attribute.
	 * @see #getSourceLength()
	 * @generated
	 */
	void setSourceLength(int value);

} // Substitution
