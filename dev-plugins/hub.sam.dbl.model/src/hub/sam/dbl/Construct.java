/**
 */
package hub.sam.dbl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Construct</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Construct#getExpandExpr <em>Expand Expr</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getConstruct()
 * @model
 * @generated
 */
public interface Construct extends EObject {
	/**
	 * Returns the value of the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expand Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expand Expr</em>' containment reference.
	 * @see #setExpandExpr(ExpandExpr)
	 * @see hub.sam.dbl.DblPackage#getConstruct_ExpandExpr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpandExpr getExpandExpr();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Construct#getExpandExpr <em>Expand Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expand Expr</em>' containment reference.
	 * @see #getExpandExpr()
	 * @generated
	 */
	void setExpandExpr(ExpandExpr value);

} // Construct
