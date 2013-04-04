/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.AnnotatableElement#getAnnotationApplications <em>Annotation Applications</em>}</li>
 *   <li>{@link hub.sam.dbl.AnnotatableElement#getSimpleAnnotations <em>Simple Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getAnnotatableElement()
 * @model abstract="true"
 * @generated
 */
public interface AnnotatableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotation Applications</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.AnnotationApplication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Applications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Applications</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getAnnotatableElement_AnnotationApplications()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationApplication> getAnnotationApplications();

	/**
	 * Returns the value of the '<em><b>Simple Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.SimpleAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Annotations</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getAnnotatableElement_SimpleAnnotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleAnnotation> getSimpleAnnotations();

} // AnnotatableElement
