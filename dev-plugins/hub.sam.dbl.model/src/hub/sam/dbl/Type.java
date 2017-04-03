/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Type#getArrayDimensions <em>Array Dimensions</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getType()
 * @model abstract="true"
 * @extends DblEObject
 * @generated
 */
public interface Type extends DblEObject {
	/**
	 * Returns the value of the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ArrayDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Dimensions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getType_ArrayDimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArrayDimension> getArrayDimensions();

} // Type
