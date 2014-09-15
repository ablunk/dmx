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
 *   <li>{@link hub.sam.dbl.Module#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getClassAugments <em>Class Augments</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getExtensionDefs <em>Extension Defs</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link hub.sam.dbl.Module#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends NamedElement, EmbeddableExtensionsContainer, Construct {
	/**
	 * Returns the value of the '<em><b>Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifiers</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_Classifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Classifier> getClassifiers();

	/**
	 * Returns the value of the '<em><b>Class Augments</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ClassAugment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Augments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Augments</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_ClassAugments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassAugment> getClassAugments();

	/**
	 * Returns the value of the '<em><b>Extension Defs</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExtensionDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Defs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Defs</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_ExtensionDefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtensionDefinition> getExtensionDefs();

	/**
	 * Returns the value of the '<em><b>Procedures</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Procedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedures</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getModule_Procedures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Procedure> getProcedures();

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
