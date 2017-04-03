/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Extension#getExtensionPoint <em>Extension Point</em>}</li>
 *   <li>{@link hub.sam.dbl.Extension#getSyntaxDefinition <em>Syntax Definition</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getExtension()
 * @model
 * @generated
 */
public interface Extension extends Concept, ExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Extension Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Point</em>' reference.
	 * @see #setExtensionPoint(Concept)
	 * @see hub.sam.dbl.DblPackage#getExtension_ExtensionPoint()
	 * @model required="true"
	 * @generated
	 */
	Concept getExtensionPoint();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Extension#getExtensionPoint <em>Extension Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Point</em>' reference.
	 * @see #getExtensionPoint()
	 * @generated
	 */
	void setExtensionPoint(Concept value);

	/**
	 * Returns the value of the '<em><b>Syntax Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntax Definition</em>' containment reference.
	 * @see #setSyntaxDefinition(SyntaxDefinition)
	 * @see hub.sam.dbl.DblPackage#getExtension_SyntaxDefinition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SyntaxDefinition getSyntaxDefinition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Extension#getSyntaxDefinition <em>Syntax Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syntax Definition</em>' containment reference.
	 * @see #getSyntaxDefinition()
	 * @generated
	 */
	void setSyntaxDefinition(SyntaxDefinition value);

} // Extension
