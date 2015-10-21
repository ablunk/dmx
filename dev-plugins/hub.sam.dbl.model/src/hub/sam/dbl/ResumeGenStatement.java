/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resume Gen Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.ResumeGenStatement#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getResumeGenStatement()
 * @model
 * @generated
 */
public interface ResumeGenStatement extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Expression)
	 * @see hub.sam.dbl.DblPackage#getResumeGenStatement_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getVariable();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ResumeGenStatement#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Expression value);

} // ResumeGenStatement
