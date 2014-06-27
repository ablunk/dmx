/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extensible Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ExtensibleElement#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.ExtensibleElement#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getExtensibleElement()
 * @model
 * @generated
 */
public interface ExtensibleElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Syntax</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Syntax</em>' attribute.
	 * @see #setConcreteSyntax(String)
	 * @see hub.sam.dbl.DblPackage#getExtensibleElement_ConcreteSyntax()
	 * @model
	 * @generated
	 */
	String getConcreteSyntax();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensibleElement#getConcreteSyntax <em>Concrete Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concrete Syntax</em>' attribute.
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	void setConcreteSyntax(String value);

	/**
	 * Returns the value of the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Of Extension Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Of Extension Definition</em>' attribute.
	 * @see #setInstanceOfExtensionDefinition(boolean)
	 * @see hub.sam.dbl.DblPackage#getExtensibleElement_InstanceOfExtensionDefinition()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isInstanceOfExtensionDefinition();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensibleElement#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Of Extension Definition</em>' attribute.
	 * @see #isInstanceOfExtensionDefinition()
	 * @generated
	 */
	void setInstanceOfExtensionDefinition(boolean value);

} // ExtensibleElement
