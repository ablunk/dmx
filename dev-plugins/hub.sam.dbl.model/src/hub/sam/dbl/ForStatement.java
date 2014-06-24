/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ForStatement#getCountVariableDefinition <em>Count Variable Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.ForStatement#getCountVariableReference <em>Count Variable Reference</em>}</li>
 *   <li>{@link hub.sam.dbl.ForStatement#getTermination <em>Termination</em>}</li>
 *   <li>{@link hub.sam.dbl.ForStatement#getIncrement <em>Increment</em>}</li>
 *   <li>{@link hub.sam.dbl.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends CompositeStatement {
	/**
	 * Returns the value of the '<em><b>Count Variable Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Variable Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Variable Definition</em>' containment reference.
	 * @see #setCountVariableDefinition(Variable)
	 * @see hub.sam.dbl.DblPackage#getForStatement_CountVariableDefinition()
	 * @model containment="true"
	 * @generated
	 */
	Variable getCountVariableDefinition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForStatement#getCountVariableDefinition <em>Count Variable Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Variable Definition</em>' containment reference.
	 * @see #getCountVariableDefinition()
	 * @generated
	 */
	void setCountVariableDefinition(Variable value);

	/**
	 * Returns the value of the '<em><b>Count Variable Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Variable Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Variable Reference</em>' containment reference.
	 * @see #setCountVariableReference(Assignment)
	 * @see hub.sam.dbl.DblPackage#getForStatement_CountVariableReference()
	 * @model containment="true"
	 * @generated
	 */
	Assignment getCountVariableReference();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForStatement#getCountVariableReference <em>Count Variable Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Variable Reference</em>' containment reference.
	 * @see #getCountVariableReference()
	 * @generated
	 */
	void setCountVariableReference(Assignment value);

	/**
	 * Returns the value of the '<em><b>Termination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Termination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Termination</em>' containment reference.
	 * @see #setTermination(Expression)
	 * @see hub.sam.dbl.DblPackage#getForStatement_Termination()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTermination();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForStatement#getTermination <em>Termination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Termination</em>' containment reference.
	 * @see #getTermination()
	 * @generated
	 */
	void setTermination(Expression value);

	/**
	 * Returns the value of the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Increment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Increment</em>' containment reference.
	 * @see #setIncrement(Assignment)
	 * @see hub.sam.dbl.DblPackage#getForStatement_Increment()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Assignment getIncrement();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForStatement#getIncrement <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' containment reference.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(Assignment value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getForStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CodeBlock getBody();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(CodeBlock value);

} // ForStatement
