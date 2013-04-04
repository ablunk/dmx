/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link expressions.Model#getFunctions <em>Functions</em>}</li>
 * </ul>
 * </p>
 *
 * @see expressions.ExpressionsPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link expressions.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see expressions.ExpressionsPackage#getModel_Functions()
	 * @model type="expressions.Function" containment="true" ordered="false"
	 * @generated
	 */
	EList getFunctions();

} // Model
