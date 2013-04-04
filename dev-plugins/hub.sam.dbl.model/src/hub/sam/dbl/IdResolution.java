/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.IdResolution#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}</li>
 *   <li>{@link hub.sam.dbl.IdResolution#getPatterns <em>Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getIdResolution()
 * @model
 * @generated
 */
public interface IdResolution extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta Model Platform URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Platform URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Platform URI</em>' attribute.
	 * @see #setMetaModelPlatformURI(String)
	 * @see hub.sam.dbl.DblPackage#getIdResolution_MetaModelPlatformURI()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMetaModelPlatformURI();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IdResolution#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Platform URI</em>' attribute.
	 * @see #getMetaModelPlatformURI()
	 * @generated
	 */
	void setMetaModelPlatformURI(String value);

	/**
	 * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Pattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getIdResolution_Patterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pattern> getPatterns();

} // IdResolution
