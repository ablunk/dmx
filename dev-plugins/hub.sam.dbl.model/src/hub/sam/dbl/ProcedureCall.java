/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ProcedureCall#getProcedureAccess <em>Procedure Access</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getProcedureCall()
 * @model
 * @generated
 */
public interface ProcedureCall extends StatementExpression {
	/**
	 * Returns the value of the '<em><b>Procedure Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure Access</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure Access</em>' containment reference.
	 * @see #setProcedureAccess(Expression)
	 * @see hub.sam.dbl.DblPackage#getProcedureCall_ProcedureAccess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getProcedureAccess();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ProcedureCall#getProcedureAccess <em>Procedure Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure Access</em>' containment reference.
	 * @see #getProcedureAccess()
	 * @generated
	 */
	void setProcedureAccess(Expression value);

} // ProcedureCall
