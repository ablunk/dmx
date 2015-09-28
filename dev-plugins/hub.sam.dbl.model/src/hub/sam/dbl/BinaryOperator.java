/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.BinaryOperator#getOp1 <em>Op1</em>}</li>
 *   <li>{@link hub.sam.dbl.BinaryOperator#getOp2 <em>Op2</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getBinaryOperator()
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
	 * @see hub.sam.dbl.DblPackage#getBinaryOperator_Op1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOp1();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.BinaryOperator#getOp1 <em>Op1</em>}' containment reference.
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
	 * @see hub.sam.dbl.DblPackage#getBinaryOperator_Op2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getOp2();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.BinaryOperator#getOp2 <em>Op2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op2</em>' containment reference.
	 * @see #getOp2()
	 * @generated
	 */
	void setOp2(Expression value);

} // BinaryOperator
