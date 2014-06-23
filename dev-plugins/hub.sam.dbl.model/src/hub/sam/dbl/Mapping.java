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
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Mapping#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.Mapping#getMetaObject <em>Meta Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends CodeBlock {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.MappingPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getMapping_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingPart> getParts();

	/**
	 * Returns the value of the '<em><b>Meta Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Object</em>' containment reference.
	 * @see #setMetaObject(Expression)
	 * @see hub.sam.dbl.DblPackage#getMapping_MetaObject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getMetaObject();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Mapping#getMetaObject <em>Meta Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Object</em>' containment reference.
	 * @see #getMetaObject()
	 * @generated
	 */
	void setMetaObject(Expression value);

} // Mapping
