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
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Module#getClasses <em>Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getExtensionSemantics <em>Extension Semantics</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getFunctions <em>Functions</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getVariables <em>Variables</em>}</li>
 * </ul>
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
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Extension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Extension> getExtensions();

	/**
	 * Returns the value of the '<em><b>Extension Semantics</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExtensionSemantics}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Semantics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Semantics</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_ExtensionSemantics()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionSemantics> getExtensionSemantics();

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
