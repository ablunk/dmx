/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Class Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.SuperClassSpecification#getClass_ <em>Class</em>}</li>
 *   <li>{@link hub.sam.dbl.SuperClassSpecification#getConstructorArguments <em>Constructor Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getSuperClassSpecification()
 * @model
 * @extends DblEObject
 * @generated
 */
public interface SuperClassSpecification extends DblEObject {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(hub.sam.dbl.Class)
	 * @see hub.sam.dbl.DblPackage#getSuperClassSpecification_Class()
	 * @model required="true"
	 * @generated
	 */
	hub.sam.dbl.Class getClass_();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SuperClassSpecification#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(hub.sam.dbl.Class value);

	/**
	 * Returns the value of the '<em><b>Constructor Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor Arguments</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getSuperClassSpecification_ConstructorArguments()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getConstructorArguments();

} // SuperClassSpecification
