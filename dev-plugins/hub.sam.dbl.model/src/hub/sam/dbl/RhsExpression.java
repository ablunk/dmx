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
 * A representation of the model object '<em><b>Rhs Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see hub.sam.dbl.DblPackage#getRhsExpression()
 * @model abstract="true"
 * @generated
 */
public interface RhsExpression extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<RhsExpression> getSubExpressions();

} // RhsExpression
