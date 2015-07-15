/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Module#getClasses <em>Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getExtensionDefinitions <em>Extension Definitions</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getExtensionSemanticsDefinitions <em>Extension Semantics Definitions</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getFunctions <em>Functions</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends NamedElement, ConstructiveExtensionAtContentExtensionPoint, Construct {
	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<hub.sam.dbl.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Extension Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExtensionDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Definitions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_ExtensionDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionDefinition> getExtensionDefinitions();

	/**
	 * Returns the value of the '<em><b>Extension Semantics Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExtensionSemanticsDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Semantics Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Semantics Definitions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_ExtensionSemanticsDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionSemanticsDefinition> getExtensionSemanticsDefinitions();

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

} // Module
