/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.ModificationsRecord#getModifications <em>Modifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dmx.modifications.ModificationsPackage#getModificationsRecord()
 * @model
 * @generated
 */
public interface ModificationsRecord extends EObject {
	/**
	 * Returns the value of the '<em><b>Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dmx.modifications.Modification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifications</em>' containment reference list.
	 * @see hub.sam.dmx.modifications.ModificationsPackage#getModificationsRecord_Modifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Modification> getModifications();

} // ModificationsRecord
