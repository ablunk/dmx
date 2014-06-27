/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Embeddable Extensions Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.EmbeddableExtensionsContainer#getExtensions <em>Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getEmbeddableExtensionsContainer()
 * @model abstract="true"
 * @generated
 */
public interface EmbeddableExtensionsContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExtensibleElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getEmbeddableExtensionsContainer_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensibleElement> getExtensions();

} // EmbeddableExtensionsContainer
