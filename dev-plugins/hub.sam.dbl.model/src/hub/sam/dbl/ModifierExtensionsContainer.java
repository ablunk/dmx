/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifier Extensions Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ModifierExtensionsContainer#getModifierExtensions <em>Modifier Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getModifierExtensionsContainer()
 * @model abstract="true"
 * @generated
 */
public interface ModifierExtensionsContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExtensibleElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier Extensions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModifierExtensionsContainer_ModifierExtensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensibleElement> getModifierExtensions();

} // ModifierExtensionsContainer
