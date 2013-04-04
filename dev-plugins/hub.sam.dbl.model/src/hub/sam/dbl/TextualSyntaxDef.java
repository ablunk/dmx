/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textual Syntax Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.TextualSyntaxDef#getExtensionRule <em>Extension Rule</em>}</li>
 *   <li>{@link hub.sam.dbl.TextualSyntaxDef#getNewRules <em>New Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getTextualSyntaxDef()
 * @model
 * @generated
 */
public interface TextualSyntaxDef extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Rule</em>' containment reference.
	 * @see #setExtensionRule(ExtensionRule)
	 * @see hub.sam.dbl.DblPackage#getTextualSyntaxDef_ExtensionRule()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ExtensionRule getExtensionRule();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TextualSyntaxDef#getExtensionRule <em>Extension Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Rule</em>' containment reference.
	 * @see #getExtensionRule()
	 * @generated
	 */
	void setExtensionRule(ExtensionRule value);

	/**
	 * Returns the value of the '<em><b>New Rules</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.TsRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Rules</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getTextualSyntaxDef_NewRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<TsRule> getNewRules();

} // TextualSyntaxDef
