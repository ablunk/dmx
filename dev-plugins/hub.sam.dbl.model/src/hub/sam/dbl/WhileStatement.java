/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.WhileStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.WhileStatement#getWhileBlock <em>While Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getWhileStatement()
 * @model
 * @generated
 */
public interface WhileStatement extends CompositeStatement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see hub.sam.dbl.DblPackage#getWhileStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.WhileStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>While Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>While Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>While Block</em>' containment reference.
	 * @see #setWhileBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getWhileStatement_WhileBlock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CodeBlock getWhileBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.WhileStatement#getWhileBlock <em>While Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>While Block</em>' containment reference.
	 * @see #getWhileBlock()
	 * @generated
	 */
	void setWhileBlock(CodeBlock value);

} // WhileStatement
