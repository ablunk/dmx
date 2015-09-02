/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Class#isActive <em>Active</em>}</li>
 *   <li>{@link hub.sam.dbl.Class#getBindings <em>Bindings</em>}</li>
 *   <li>{@link hub.sam.dbl.Class#getSuperClasses <em>Super Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.Class#getConstructors <em>Constructors</em>}</li>
 *   <li>{@link hub.sam.dbl.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hub.sam.dbl.Class#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.Class#getActionsBlock <em>Actions Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement, Type, ConstructiveExtensionAtContentExtensionPoint, LanguageConceptClassifier, Construct {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see hub.sam.dbl.DblPackage#getClass_Active()
	 * @model default="false" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='Constructor'"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Class#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.NativeBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClass_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<NativeBinding> getBindings();

	/**
	 * Returns the value of the '<em><b>Super Classes</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.SuperClassSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Classes</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClass_SuperClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<SuperClassSpecification> getSuperClasses();

	/**
	 * Returns the value of the '<em><b>Constructors</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Constructor}.
	 * It is bidirectional and its opposite is '{@link hub.sam.dbl.Constructor#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructors</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClass_Constructors()
	 * @see hub.sam.dbl.Constructor#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<Constructor> getConstructors();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClass_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getAttributes();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClass_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getMethods();

	/**
	 * Returns the value of the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Block</em>' containment reference.
	 * @see #setActionsBlock(LocalScope)
	 * @see hub.sam.dbl.DblPackage#getClass_ActionsBlock()
	 * @model containment="true"
	 * @generated
	 */
	LocalScope getActionsBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Class#getActionsBlock <em>Actions Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actions Block</em>' containment reference.
	 * @see #getActionsBlock()
	 * @generated
	 */
	void setActionsBlock(LocalScope value);

} // Class
