/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link expressions.FunctionCall#getFunction <em>Function</em>}</li>
 *   <li>{@link expressions.FunctionCall#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see expressions.ExpressionsPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends Expression {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(Function)
	 * @see expressions.ExpressionsPackage#getFunctionCall_Function()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link expressions.FunctionCall#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link expressions.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see expressions.ExpressionsPackage#getFunctionCall_Arguments()
	 * @model type="expressions.Expression" containment="true"
	 * @generated
	 */
	EList getArguments();

} // FunctionCall
