/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.FunctionCall#getCallIdExpr <em>Call Id Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Call Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Id Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Id Expr</em>' containment reference.
	 * @see #setCallIdExpr(IdExpr)
	 * @see hub.sam.dbl.DblPackage#getFunctionCall_CallIdExpr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IdExpr getCallIdExpr();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.FunctionCall#getCallIdExpr <em>Call Id Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Id Expr</em>' containment reference.
	 * @see #getCallIdExpr()
	 * @generated
	 */
	void setCallIdExpr(IdExpr value);

} // FunctionCall
