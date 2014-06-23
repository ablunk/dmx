/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ExtensionRule#getInstantiableMetaClass <em>Instantiable Meta Class</em>}</li>
 *   <li>{@link hub.sam.dbl.ExtensionRule#getFirstNewRule <em>First New Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getExtensionRule()
 * @model
 * @generated
 */
public interface ExtensionRule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Instantiable Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiable Meta Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiable Meta Class</em>' reference.
	 * @see #setInstantiableMetaClass(Classifier)
	 * @see hub.sam.dbl.DblPackage#getExtensionRule_InstantiableMetaClass()
	 * @model
	 * @generated
	 */
	Classifier getInstantiableMetaClass();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensionRule#getInstantiableMetaClass <em>Instantiable Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiable Meta Class</em>' reference.
	 * @see #getInstantiableMetaClass()
	 * @generated
	 */
	void setInstantiableMetaClass(Classifier value);

	/**
	 * Returns the value of the '<em><b>First New Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First New Rule</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First New Rule</em>' containment reference.
	 * @see #setFirstNewRule(RuleExpr)
	 * @see hub.sam.dbl.DblPackage#getExtensionRule_FirstNewRule()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RuleExpr getFirstNewRule();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExtensionRule#getFirstNewRule <em>First New Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First New Rule</em>' containment reference.
	 * @see #getFirstNewRule()
	 * @generated
	 */
	void setFirstNewRule(RuleExpr value);

} // ExtensionRule
