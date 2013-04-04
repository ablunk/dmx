/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.TargetStatement#getCodeBlock <em>Code Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getTargetStatement()
 * @model
 * @generated
 */
public interface TargetStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Code Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Block</em>' containment reference.
	 * @see #setCodeBlock(CodeBlock)
	 * @see hub.sam.dbl.DblPackage#getTargetStatement_CodeBlock()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CodeBlock getCodeBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TargetStatement#getCodeBlock <em>Code Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Block</em>' containment reference.
	 * @see #getCodeBlock()
	 * @generated
	 */
	void setCodeBlock(CodeBlock value);

} // TargetStatement
