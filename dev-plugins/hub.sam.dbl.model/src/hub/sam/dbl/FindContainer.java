/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Find Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.FindContainer#getVariableBinding <em>Variable Binding</em>}</li>
 *   <li>{@link hub.sam.dbl.FindContainer#getContainerBlock <em>Container Block</em>}</li>
 *   <li>{@link hub.sam.dbl.FindContainer#getElseBlock <em>Else Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getFindContainer()
 * @model
 * @generated
 */
public interface FindContainer extends Statement {
	/**
	 * Returns the value of the '<em><b>Variable Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Binding</em>' containment reference.
	 * @see #setVariableBinding(Parameter)
	 * @see hub.sam.dbl.DblPackage#getFindContainer_VariableBinding()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Parameter getVariableBinding();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.FindContainer#getVariableBinding <em>Variable Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Binding</em>' containment reference.
	 * @see #getVariableBinding()
	 * @generated
	 */
	void setVariableBinding(Parameter value);

	/**
	 * Returns the value of the '<em><b>Container Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Block</em>' containment reference.
	 * @see #setContainerBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getFindContainer_ContainerBlock()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CodeBlock getContainerBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.FindContainer#getContainerBlock <em>Container Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Block</em>' containment reference.
	 * @see #getContainerBlock()
	 * @generated
	 */
	void setContainerBlock(CodeBlock value);

	/**
	 * Returns the value of the '<em><b>Else Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Block</em>' containment reference.
	 * @see #setElseBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getFindContainer_ElseBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	CodeBlock getElseBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.FindContainer#getElseBlock <em>Else Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Block</em>' containment reference.
	 * @see #getElseBlock()
	 * @generated
	 */
	void setElseBlock(CodeBlock value);

} // FindContainer
