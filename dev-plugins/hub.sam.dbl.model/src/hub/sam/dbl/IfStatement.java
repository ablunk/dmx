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
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.IfStatement#getIfCaseBlock <em>If Case Block</em>}</li>
 *   <li>{@link hub.sam.dbl.IfStatement#getElifCondition <em>Elif Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.IfStatement#getElifCaseBlock <em>Elif Case Block</em>}</li>
 *   <li>{@link hub.sam.dbl.IfStatement#getElseCaseBlock <em>Else Case Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends CompositeStatement {
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
	 * @see hub.sam.dbl.DblPackage#getIfStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IfStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>If Case Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Case Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Case Block</em>' containment reference.
	 * @see #setIfCaseBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getIfStatement_IfCaseBlock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CodeBlock getIfCaseBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IfStatement#getIfCaseBlock <em>If Case Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Case Block</em>' containment reference.
	 * @see #getIfCaseBlock()
	 * @generated
	 */
	void setIfCaseBlock(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Elif Condition</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elif Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elif Condition</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getIfStatement_ElifCondition()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getElifCondition();

	/**
	 * Returns the value of the '<em><b>Elif Case Block</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.CodeBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elif Case Block</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elif Case Block</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getIfStatement_ElifCaseBlock()
	 * @model containment="true"
	 * @generated
	 */
	EList<CodeBlock> getElifCaseBlock();

	/**
	 * Returns the value of the '<em><b>Else Case Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Case Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Case Block</em>' containment reference.
	 * @see #setElseCaseBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getIfStatement_ElseCaseBlock()
	 * @model containment="true"
	 * @generated
	 */
	CodeBlock getElseCaseBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IfStatement#getElseCaseBlock <em>Else Case Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Case Block</em>' containment reference.
	 * @see #getElseCaseBlock()
	 * @generated
	 */
	void setElseCaseBlock(CodeBlock value);

} // IfStatement
