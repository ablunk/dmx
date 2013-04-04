/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link expressions.BinaryOperator#getOp1 <em>Op1</em>}</li>
 *   <li>{@link expressions.BinaryOperator#getOp2 <em>Op2</em>}</li>
 * </ul>
 * </p>
 *
 * @see expressions.ExpressionsPackage#getBinaryOperator()
 * @model abstract="true"
 * @generated
 */
public interface BinaryOperator extends Expression {
	/**
	 * Returns the value of the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op1</em>' containment reference.
	 * @see #setOp1(Expression)
	 * @see expressions.ExpressionsPackage#getBinaryOperator_Op1()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getOp1();

	/**
	 * Sets the value of the '{@link expressions.BinaryOperator#getOp1 <em>Op1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op1</em>' containment reference.
	 * @see #getOp1()
	 * @generated
	 */
	void setOp1(Expression value);

	/**
	 * Returns the value of the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op2</em>' containment reference.
	 * @see #setOp2(Expression)
	 * @see expressions.ExpressionsPackage#getBinaryOperator_Op2()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getOp2();

	/**
	 * Sets the value of the '{@link expressions.BinaryOperator#getOp2 <em>Op2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op2</em>' containment reference.
	 * @see #getOp2()
	 * @generated
	 */
	void setOp2(Expression value);

} // BinaryOperator
