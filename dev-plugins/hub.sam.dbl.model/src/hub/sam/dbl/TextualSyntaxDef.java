/**
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
 *   <li>{@link hub.sam.dbl.TextualSyntaxDef#getStartRule <em>Start Rule</em>}</li>
 *   <li>{@link hub.sam.dbl.TextualSyntaxDef#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getTextualSyntaxDef()
 * @model
 * @generated
 */
public interface TextualSyntaxDef extends ExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Start Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Rule</em>' reference.
	 * @see #setStartRule(TsRule)
	 * @see hub.sam.dbl.DblPackage#getTextualSyntaxDef_StartRule()
	 * @model required="true"
	 * @generated
	 */
	TsRule getStartRule();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.TextualSyntaxDef#getStartRule <em>Start Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Rule</em>' reference.
	 * @see #getStartRule()
	 * @generated
	 */
	void setStartRule(TsRule value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.TsRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getTextualSyntaxDef_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<TsRule> getRules();

} // TextualSyntaxDef
