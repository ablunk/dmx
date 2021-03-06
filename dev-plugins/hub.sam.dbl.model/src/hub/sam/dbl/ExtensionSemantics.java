/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Semantics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.ExtensionSemantics#getSyntaxDefinition <em>Syntax Definition</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getExtensionSemantics()
 * @model
 * @generated
 */
public interface ExtensionSemantics extends ExtensibleElement, LocalScope {
	/**
	 * Returns the value of the '<em><b>Syntax Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntax Definition</em>' reference.
	 * @see #setSyntaxDefinition(Extension)
	 * @see hub.sam.dbl.DblPackage#getExtensionSemantics_SyntaxDefinition()
	 * @model required="true"
	 * @generated
	 */
	Extension getSyntaxDefinition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensionSemantics#getSyntaxDefinition <em>Syntax Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syntax Definition</em>' reference.
	 * @see #getSyntaxDefinition()
	 * @generated
	 */
	void setSyntaxDefinition(Extension value);

} // ExtensionSemantics
