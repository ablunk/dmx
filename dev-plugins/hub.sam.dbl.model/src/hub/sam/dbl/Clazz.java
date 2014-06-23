/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clazz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Clazz#isActive <em>Active</em>}</li>
 *   <li>{@link hub.sam.dbl.Clazz#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link hub.sam.dbl.Clazz#getBaseConstructorArguments <em>Base Constructor Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getClazz()
 * @model
 * @generated
 */
public interface Clazz extends Classifier, ClassSimilar {
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
	 * @see hub.sam.dbl.DblPackage#getClazz_Active()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Clazz#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor</em>' containment reference.
	 * @see #setConstructor(Constructor)
	 * @see hub.sam.dbl.DblPackage#getClazz_Constructor()
	 * @model containment="true"
	 * @generated
	 */
	Constructor getConstructor();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Clazz#getConstructor <em>Constructor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' containment reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(Constructor value);

	/**
	 * Returns the value of the '<em><b>Base Constructor Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constructor Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Constructor Arguments</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClazz_BaseConstructorArguments()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getBaseConstructorArguments();

} // Clazz
