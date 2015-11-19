/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Constructor#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hub.sam.dbl.Constructor#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getConstructor()
 * @model
 * @generated
 */
public interface Constructor extends LocalScope {
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
	 * @see hub.sam.dbl.DblPackage#getConstructor_Parameters()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.dbl.Class#getConstructors <em>Constructors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(hub.sam.dbl.Class)
	 * @see hub.sam.dbl.DblPackage#getConstructor_OwningClass()
	 * @see hub.sam.dbl.Class#getConstructors
	 * @model opposite="constructors" required="true" transient="false"
	 * @generated
	 */
	hub.sam.dbl.Class getOwningClass();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Constructor#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(hub.sam.dbl.Class value);

} // Constructor
