/**
 */
package hub.sam.dbl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extensible Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ExtensibleElement#isObjectIsExtensionInstance <em>Object Is Extension Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getExtensibleElement()
 * @model
 * @generated
 */
public interface ExtensibleElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Object Is Extension Instance</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Is Extension Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Is Extension Instance</em>' attribute.
	 * @see #setObjectIsExtensionInstance(boolean)
	 * @see hub.sam.dbl.DblPackage#getExtensibleElement_ObjectIsExtensionInstance()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isObjectIsExtensionInstance();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensibleElement#isObjectIsExtensionInstance <em>Object Is Extension Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Is Extension Instance</em>' attribute.
	 * @see #isObjectIsExtensionInstance()
	 * @generated
	 */
	void setObjectIsExtensionInstance(boolean value);

} // ExtensibleElement
