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
 * A representation of the model object '<em><b>Annotation Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.AnnotationApplication#getAnnotationDef <em>Annotation Def</em>}</li>
 *   <li>{@link hub.sam.dbl.AnnotationApplication#getKeyValuePairs <em>Key Value Pairs</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getAnnotationApplication()
 * @model
 * @generated
 */
public interface AnnotationApplication extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotation Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Def</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Def</em>' reference.
	 * @see #setAnnotationDef(Annotation)
	 * @see hub.sam.dbl.DblPackage#getAnnotationApplication_AnnotationDef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Annotation getAnnotationDef();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.AnnotationApplication#getAnnotationDef <em>Annotation Def</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Def</em>' reference.
	 * @see #getAnnotationDef()
	 * @generated
	 */
	void setAnnotationDef(Annotation value);

	/**
	 * Returns the value of the '<em><b>Key Value Pairs</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.KeyValuePair}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Value Pairs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Value Pairs</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getAnnotationApplication_KeyValuePairs()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValuePair> getKeyValuePairs();

} // AnnotationApplication
