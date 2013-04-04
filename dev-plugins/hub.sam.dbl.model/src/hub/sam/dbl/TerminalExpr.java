/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.TerminalExpr#getTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getTerminalExpr()
 * @model
 * @generated
 */
public interface TerminalExpr extends RhsExpression {
	/**
	 * Returns the value of the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminal</em>' attribute.
	 * @see #setTerminal(String)
	 * @see hub.sam.dbl.DblPackage#getTerminalExpr_Terminal()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTerminal();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TerminalExpr#getTerminal <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #getTerminal()
	 * @generated
	 */
	void setTerminal(String value);

} // TerminalExpr
