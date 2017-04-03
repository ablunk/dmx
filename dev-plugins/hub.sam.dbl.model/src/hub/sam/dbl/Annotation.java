/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Annotation#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.AnnotationItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getAnnotation_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationItem> getItems();

} // Annotation
