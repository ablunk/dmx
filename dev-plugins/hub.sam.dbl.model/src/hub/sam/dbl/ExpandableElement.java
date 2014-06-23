/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expandable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ExpandableElement#getExpandExpression <em>Expand Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getExpandableElement()
 * @model
 * @generated
 */
public interface ExpandableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Expand Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expand Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expand Expression</em>' containment reference.
	 * @see #setExpandExpression(ExpandExpression)
	 * @see hub.sam.dbl.DblPackage#getExpandableElement_ExpandExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpandExpression getExpandExpression();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpandableElement#getExpandExpression <em>Expand Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expand Expression</em>' containment reference.
	 * @see #getExpandExpression()
	 * @generated
	 */
	void setExpandExpression(ExpandExpression value);

} // ExpandableElement
