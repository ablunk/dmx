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
public interface ForStatement extends LoopStatement, LocalScope {
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
	 * @see #setBody(Statement)
	 * @see hub.sam.dbl.DblPackage#getForStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getBody();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Statement value);

} // ForStatement
