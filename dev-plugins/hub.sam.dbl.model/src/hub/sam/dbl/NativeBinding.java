/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Native Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.NativeBinding#getTargetLanguage <em>Target Language</em>}</li>
 *   <li>{@link hub.sam.dbl.NativeBinding#getTargetType <em>Target Type</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getNativeBinding()
 * @model
 * @extends DblEObject
 * @generated
 */
public interface NativeBinding extends DblEObject {
	/**
	 * Returns the value of the '<em><b>Target Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Language</em>' attribute.
	 * @see #setTargetLanguage(String)
	 * @see hub.sam.dbl.DblPackage#getNativeBinding_TargetLanguage()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SuperClassSpecification' unique='false' upper='*'"
	 * @generated
	 */
	String getTargetLanguage();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.NativeBinding#getTargetLanguage <em>Target Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Language</em>' attribute.
	 * @see #getTargetLanguage()
	 * @generated
	 */
	void setTargetLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' attribute.
	 * @see #setTargetType(String)
	 * @see hub.sam.dbl.DblPackage#getNativeBinding_TargetType()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SuperClassSpecification'"
	 * @generated
	 */
	String getTargetType();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.NativeBinding#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' attribute.
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(String value);

} // NativeBinding
