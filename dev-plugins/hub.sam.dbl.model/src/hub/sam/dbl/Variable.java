/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Variable#isControl <em>Control</em>}</li>
 *   <li>{@link hub.sam.dbl.Variable#isClazz <em>Clazz</em>}</li>
 *   <li>{@link hub.sam.dbl.Variable#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends AbstractVariable, Statement, ModifierExtensionsContainer {
	/**
	 * Returns the value of the '<em><b>Control</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control</em>' attribute.
	 * @see #setControl(boolean)
	 * @see hub.sam.dbl.DblPackage#getVariable_Control()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isControl();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Variable#isControl <em>Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' attribute.
	 * @see #isControl()
	 * @generated
	 */
	void setControl(boolean value);

	/**
	 * Returns the value of the '<em><b>Clazz</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clazz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clazz</em>' attribute.
	 * @see #setClazz(boolean)
	 * @see hub.sam.dbl.DblPackage#getVariable_Clazz()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isClazz();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Variable#isClazz <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clazz</em>' attribute.
	 * @see #isClazz()
	 * @generated
	 */
	void setClazz(boolean value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(Expression)
	 * @see hub.sam.dbl.DblPackage#getVariable_InitialValue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitialValue();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Variable#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(Expression value);

} // Variable
