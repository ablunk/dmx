/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.edu.modsoft.bfmodel.bf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getSourceBox <em>Source Box</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getTargetBox <em>Target Box</em>}</li>
 * </ul>
 *
 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Box</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOutgoingFlows <em>Outgoing Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Box</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Box</em>' reference.
	 * @see #setSourceBox(Box)
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getFlow_SourceBox()
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getOutgoingFlows
	 * @model opposite="outgoingFlows" required="true"
	 * @generated
	 */
	Box getSourceBox();

	/**
	 * Sets the value of the '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getSourceBox <em>Source Box</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Box</em>' reference.
	 * @see #getSourceBox()
	 * @generated
	 */
	void setSourceBox(Box value);

	/**
	 * Returns the value of the '<em><b>Target Box</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getIncomingFlows <em>Incoming Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Box</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Box</em>' reference.
	 * @see #setTargetBox(Box)
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getFlow_TargetBox()
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getIncomingFlows
	 * @model opposite="incomingFlows" required="true"
	 * @generated
	 */
	Box getTargetBox();

	/**
	 * Sets the value of the '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getTargetBox <em>Target Box</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Box</em>' reference.
	 * @see #getTargetBox()
	 * @generated
	 */
	void setTargetBox(Box value);

} // Flow
