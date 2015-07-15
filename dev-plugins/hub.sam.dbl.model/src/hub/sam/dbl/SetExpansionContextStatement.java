/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Expansion Context Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.SetExpansionContextStatement#getContext <em>Context</em>}</li>
 *   <li>{@link hub.sam.dbl.SetExpansionContextStatement#isAddAfterContext <em>Add After Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getSetExpansionContextStatement()
 * @model
 * @generated
 */
public interface SetExpansionContextStatement extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(Expression)
	 * @see hub.sam.dbl.DblPackage#getSetExpansionContextStatement_Context()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SetExpansionContextStatement#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Expression value);

	/**
	 * Returns the value of the '<em><b>Add After Context</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add After Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add After Context</em>' attribute.
	 * @see #setAddAfterContext(boolean)
	 * @see hub.sam.dbl.DblPackage#getSetExpansionContextStatement_AddAfterContext()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAddAfterContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SetExpansionContextStatement#isAddAfterContext <em>Add After Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add After Context</em>' attribute.
	 * @see #isAddAfterContext()
	 * @generated
	 */
	void setAddAfterContext(boolean value);

} // SetExpansionContextStatement
