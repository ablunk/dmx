/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Class Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.SuperClassSpecification#getClazz <em>Clazz</em>}</li>
 *   <li>{@link hub.sam.dbl.SuperClassSpecification#getConstructorArguments <em>Constructor Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getSuperClassSpecification()
 * @model
 * @generated
 */
public interface SuperClassSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Clazz</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clazz</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clazz</em>' reference.
	 * @see #setClazz(Clazz)
	 * @see hub.sam.dbl.DblPackage#getSuperClassSpecification_Clazz()
	 * @model required="true"
	 * @generated
	 */
	Clazz getClazz();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.SuperClassSpecification#getClazz <em>Clazz</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clazz</em>' reference.
	 * @see #getClazz()
	 * @generated
	 */
	void setClazz(Clazz value);

	/**
	 * Returns the value of the '<em><b>Constructor Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor Arguments</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getSuperClassSpecification_ConstructorArguments()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getConstructorArguments();

} // SuperClassSpecification
