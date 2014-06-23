/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Each Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ForEachStatement#getIteratorVariableDefinition <em>Iterator Variable Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.ForEachStatement#getIteratorVariableReference <em>Iterator Variable Reference</em>}</li>
 *   <li>{@link hub.sam.dbl.ForEachStatement#getIterableExpression <em>Iterable Expression</em>}</li>
 *   <li>{@link hub.sam.dbl.ForEachStatement#getForBlock <em>For Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getForEachStatement()
 * @model
 * @generated
 */
public interface ForEachStatement extends CompositeStatement {
	/**
	 * Returns the value of the '<em><b>Iterator Variable Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator Variable Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator Variable Definition</em>' containment reference.
	 * @see #setIteratorVariableDefinition(Variable)
	 * @see hub.sam.dbl.DblPackage#getForEachStatement_IteratorVariableDefinition()
	 * @model containment="true"
	 * @generated
	 */
	Variable getIteratorVariableDefinition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForEachStatement#getIteratorVariableDefinition <em>Iterator Variable Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator Variable Definition</em>' containment reference.
	 * @see #getIteratorVariableDefinition()
	 * @generated
	 */
	void setIteratorVariableDefinition(Variable value);

	/**
	 * Returns the value of the '<em><b>Iterator Variable Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator Variable Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator Variable Reference</em>' containment reference.
	 * @see #setIteratorVariableReference(VariableAccess)
	 * @see hub.sam.dbl.DblPackage#getForEachStatement_IteratorVariableReference()
	 * @model containment="true"
	 * @generated
	 */
	VariableAccess getIteratorVariableReference();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForEachStatement#getIteratorVariableReference <em>Iterator Variable Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator Variable Reference</em>' containment reference.
	 * @see #getIteratorVariableReference()
	 * @generated
	 */
	void setIteratorVariableReference(VariableAccess value);

	/**
	 * Returns the value of the '<em><b>Iterable Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterable Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterable Expression</em>' containment reference.
	 * @see #setIterableExpression(Expression)
	 * @see hub.sam.dbl.DblPackage#getForEachStatement_IterableExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getIterableExpression();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForEachStatement#getIterableExpression <em>Iterable Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterable Expression</em>' containment reference.
	 * @see #getIterableExpression()
	 * @generated
	 */
	void setIterableExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>For Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Block</em>' containment reference.
	 * @see #setForBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getForEachStatement_ForBlock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CodeBlock getForBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForEachStatement#getForBlock <em>For Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Block</em>' containment reference.
	 * @see #getForBlock()
	 * @generated
	 */
	void setForBlock(CodeBlock value);

} // ForEachStatement
