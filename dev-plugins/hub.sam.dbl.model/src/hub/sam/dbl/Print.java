/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.Print#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getPrint()
 * @model
 * @generated
 */
public interface Print extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getPrint_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getOutputs();

} // Print
