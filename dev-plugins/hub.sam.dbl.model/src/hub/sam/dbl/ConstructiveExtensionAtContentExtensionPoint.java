/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructive Extension At Content Extension Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint#getContentExtensions <em>Content Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getConstructiveExtensionAtContentExtensionPoint()
 * @model abstract="true"
 * @generated
 */
public interface ConstructiveExtensionAtContentExtensionPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Content Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ConstructiveExtension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Extensions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getConstructiveExtensionAtContentExtensionPoint_ContentExtensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstructiveExtension> getContentExtensions();

} // ConstructiveExtensionAtContentExtensionPoint
