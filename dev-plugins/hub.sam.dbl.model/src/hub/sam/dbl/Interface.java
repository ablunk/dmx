/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Interface#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.Interface#getSuperInterfaces <em>Super Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends Classifier {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Procedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getInterface_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Procedure> getMethods();

	/**
	 * Returns the value of the '<em><b>Super Interfaces</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.dbl.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Interfaces</em>' reference list.
	 * @see hub.sam.dbl.DblPackage#getInterface_SuperInterfaces()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Interface> getSuperInterfaces();

} // Interface
