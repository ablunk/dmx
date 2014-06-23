/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ElementAccess#getIdExpr <em>Id Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getElementAccess()
 * @model abstract="true"
 * @generated
 */
public interface ElementAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Expr</em>' containment reference.
	 * @see #setIdExpr(IdExpr)
	 * @see hub.sam.dbl.DblPackage#getElementAccess_IdExpr()
	 * @model containment="true"
	 * @generated
	 */
	IdExpr getIdExpr();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ElementAccess#getIdExpr <em>Id Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Expr</em>' containment reference.
	 * @see #getIdExpr()
	 * @generated
	 */
	void setIdExpr(IdExpr value);

} // ElementAccess
