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
 *   <li>{@link hub.sam.dbl.IfStatement#getTrueCase <em>True Case</em>}</li>
 *   <li>{@link hub.sam.dbl.IfStatement#getFalseCase <em>False Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement {
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
	 * Returns the value of the '<em><b>True Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Case</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Case</em>' containment reference.
	 * @see #setTrueCase(Statement)
	 * @see hub.sam.dbl.DblPackage#getIfStatement_TrueCase()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getTrueCase();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IfStatement#getTrueCase <em>True Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Case</em>' containment reference.
	 * @see #getTrueCase()
	 * @generated
	 */
	void setTrueCase(Statement value);

	/**
	 * Returns the value of the '<em><b>False Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Case</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Case</em>' containment reference.
	 * @see #setFalseCase(Statement)
	 * @see hub.sam.dbl.DblPackage#getIfStatement_FalseCase()
	 * @model containment="true"
	 * @generated
	 */
	Statement getFalseCase();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IfStatement#getFalseCase <em>False Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Case</em>' containment reference.
	 * @see #getFalseCase()
	 * @generated
	 */
	void setFalseCase(Statement value);

} // IfStatement
