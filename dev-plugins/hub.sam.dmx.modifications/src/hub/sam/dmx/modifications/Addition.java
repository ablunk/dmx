/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.Addition#isAddAfterPosition <em>Add After Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dmx.modifications.ModificationsPackage#getAddition()
 * @model
 * @generated
 */
public interface Addition extends Modification {
	/**
	 * Returns the value of the '<em><b>Add After Position</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add After Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add After Position</em>' attribute.
	 * @see #setAddAfterPosition(boolean)
	 * @see hub.sam.dmx.modifications.ModificationsPackage#getAddition_AddAfterPosition()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isAddAfterPosition();

	/**
	 * Sets the value of the '{@link hub.sam.dmx.modifications.Addition#isAddAfterPosition <em>Add After Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add After Position</em>' attribute.
	 * @see #isAddAfterPosition()
	 * @generated
	 */
	void setAddAfterPosition(boolean value);

} // Addition
