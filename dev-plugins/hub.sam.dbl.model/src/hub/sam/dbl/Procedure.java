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
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Procedure#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hub.sam.dbl.Procedure#isClazz <em>Clazz</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getProcedure()
 * @model
 * @generated
 */
public interface Procedure extends NamedElement, TypedElement, CodeBlock, AnnotatableElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getProcedure_Parameters()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Clazz</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clazz</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clazz</em>' attribute.
	 * @see #setClazz(boolean)
	 * @see hub.sam.dbl.DblPackage#getProcedure_Clazz()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isClazz();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Procedure#isClazz <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clazz</em>' attribute.
	 * @see #isClazz()
	 * @generated
	 */
	void setClazz(boolean value);

} // Procedure
