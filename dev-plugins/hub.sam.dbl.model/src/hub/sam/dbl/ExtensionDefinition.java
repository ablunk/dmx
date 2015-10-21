/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.ExtensionDefinition#getExtendedConcept <em>Extended Concept</em>}</li>
 *   <li>{@link hub.sam.dbl.ExtensionDefinition#getAbstractSyntaxDef <em>Abstract Syntax Def</em>}</li>
 *   <li>{@link hub.sam.dbl.ExtensionDefinition#getTextualSyntaxDef <em>Textual Syntax Def</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getExtensionDefinition()
 * @model
 * @generated
 */
public interface ExtensionDefinition extends LanguageConceptClassifier, ExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Extended Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Concept</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Concept</em>' reference.
	 * @see #setExtendedConcept(LanguageConceptClassifier)
	 * @see hub.sam.dbl.DblPackage#getExtensionDefinition_ExtendedConcept()
	 * @model required="true"
	 * @generated
	 */
	LanguageConceptClassifier getExtendedConcept();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensionDefinition#getExtendedConcept <em>Extended Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Concept</em>' reference.
	 * @see #getExtendedConcept()
	 * @generated
	 */
	void setExtendedConcept(LanguageConceptClassifier value);

	/**
	 * Returns the value of the '<em><b>Abstract Syntax Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Syntax Def</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Syntax Def</em>' containment reference.
	 * @see #setAbstractSyntaxDef(hub.sam.dbl.Class)
	 * @see hub.sam.dbl.DblPackage#getExtensionDefinition_AbstractSyntaxDef()
	 * @model containment="true"
	 * @generated
	 */
	hub.sam.dbl.Class getAbstractSyntaxDef();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensionDefinition#getAbstractSyntaxDef <em>Abstract Syntax Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Syntax Def</em>' containment reference.
	 * @see #getAbstractSyntaxDef()
	 * @generated
	 */
	void setAbstractSyntaxDef(hub.sam.dbl.Class value);

	/**
	 * Returns the value of the '<em><b>Textual Syntax Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textual Syntax Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textual Syntax Def</em>' containment reference.
	 * @see #setTextualSyntaxDef(TextualSyntaxDef)
	 * @see hub.sam.dbl.DblPackage#getExtensionDefinition_TextualSyntaxDef()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TextualSyntaxDef getTextualSyntaxDef();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensionDefinition#getTextualSyntaxDef <em>Textual Syntax Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textual Syntax Def</em>' containment reference.
	 * @see #getTextualSyntaxDef()
	 * @generated
	 */
	void setTextualSyntaxDef(TextualSyntaxDef value);

} // ExtensionDefinition
