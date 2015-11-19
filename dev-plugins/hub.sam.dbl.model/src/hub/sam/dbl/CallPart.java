/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.CallPart#getCallArguments <em>Call Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getCallPart()
 * @model
 * @extends DblEObject
 * @generated
 */
public interface CallPart extends DblEObject {
	/**
	 * Returns the value of the '<em><b>Call Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Arguments</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getCallPart_CallArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getCallArguments();

} // CallPart
