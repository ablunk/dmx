/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Function#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hub.sam.dbl.Function#isClass <em>Class</em>}</li>
 *   <li>{@link hub.sam.dbl.Function#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends NamedElement, TypedElement, LocalScope {
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
	 * @see hub.sam.dbl.DblPackage#getFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(boolean)
	 * @see hub.sam.dbl.DblPackage#getFunction_Class()
	 * @model default="false" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SuperClassSpecification'"
	 * @generated
	 */
	boolean isClass();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Function#isClass <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #isClass()
	 * @generated
	 */
	void setClass(boolean value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see hub.sam.dbl.DblPackage#getFunction_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Function#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

} // Function
