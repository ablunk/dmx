/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.TypedElement#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link hub.sam.dbl.TypedElement#getTypeArrayDimensions <em>Type Array Dimensions</em>}</li>
 *   <li>{@link hub.sam.dbl.TypedElement#getClassifierType <em>Classifier Type</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getTypedElement()
 * @model abstract="true"
 * @extends DblEObject
 * @generated
 */
public interface TypedElement extends DblEObject {
	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Type</em>' containment reference.
	 * @see #setPrimitiveType(PrimitiveType)
	 * @see hub.sam.dbl.DblPackage#getTypedElement_PrimitiveType()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TypedElement#getPrimitiveType <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Type</em>' containment reference.
	 * @see #getPrimitiveType()
	 * @generated
	 */
	void setPrimitiveType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ArrayDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Array Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Array Dimensions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getTypedElement_TypeArrayDimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArrayDimension> getTypeArrayDimensions();

	/**
	 * Returns the value of the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier Type</em>' containment reference.
	 * @see #setClassifierType(IdExpr)
	 * @see hub.sam.dbl.DblPackage#getTypedElement_ClassifierType()
	 * @model containment="true"
	 * @generated
	 */
	IdExpr getClassifierType();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TypedElement#getClassifierType <em>Classifier Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier Type</em>' containment reference.
	 * @see #getClassifierType()
	 * @generated
	 */
	void setClassifierType(IdExpr value);

} // TypedElement
