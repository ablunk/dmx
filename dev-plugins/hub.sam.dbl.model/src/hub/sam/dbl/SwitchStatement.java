/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.SwitchStatement#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.dbl.SwitchStatement#getCases <em>Cases</em>}</li>
 *   <li>{@link hub.sam.dbl.SwitchStatement#getDefaultCase <em>Default Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(VariableAccess)
	 * @see hub.sam.dbl.DblPackage#getSwitchStatement_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableAccess getVariable();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SwitchStatement#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableAccess value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.SwitchCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getSwitchStatement_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<SwitchCase> getCases();

	/**
	 * Returns the value of the '<em><b>Default Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Case</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Case</em>' containment reference.
	 * @see #setDefaultCase(SwitchCase)
	 * @see hub.sam.dbl.DblPackage#getSwitchStatement_DefaultCase()
	 * @model containment="true"
	 * @generated
	 */
	SwitchCase getDefaultCase();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SwitchStatement#getDefaultCase <em>Default Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Case</em>' containment reference.
	 * @see #getDefaultCase()
	 * @generated
	 */
	void setDefaultCase(SwitchCase value);

} // SwitchStatement
