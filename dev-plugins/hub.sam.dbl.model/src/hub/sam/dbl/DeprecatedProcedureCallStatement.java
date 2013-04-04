/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deprecated Procedure Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.DeprecatedProcedureCallStatement#getProcedureCall <em>Procedure Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getDeprecatedProcedureCallStatement()
 * @model
 * @generated
 */
public interface DeprecatedProcedureCallStatement extends ExpressionStatement {
	/**
	 * Returns the value of the '<em><b>Procedure Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure Call</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure Call</em>' containment reference.
	 * @see #setProcedureCall(Expression)
	 * @see hub.sam.dbl.DblPackage#getDeprecatedProcedureCallStatement_ProcedureCall()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getProcedureCall();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.DeprecatedProcedureCallStatement#getProcedureCall <em>Procedure Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure Call</em>' containment reference.
	 * @see #getProcedureCall()
	 * @generated
	 */
	void setProcedureCall(Expression value);

} // DeprecatedProcedureCallStatement
