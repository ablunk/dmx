/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.edu.modsoft.bfmodel.bf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwnedBoxes <em>Owned Boxes</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getFlows <em>Flows</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getIncomingFlows <em>Incoming Flows</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOutgoingFlows <em>Outgoing Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox()
 * @model
 * @generated
 */
public interface Box extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Boxes</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.edu.modsoft.bfmodel.bf.Box}.
	 * It is bidirectional and its opposite is '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Boxes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Boxes</em>' containment reference list.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox_OwnedBoxes()
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Box> getOwnedBoxes();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwnedBoxes <em>Owned Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Box)
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox_Owner()
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getOwnedBoxes
	 * @model opposite="ownedBoxes" transient="false"
	 * @generated
	 */
	Box getOwner();

	/**
	 * Sets the value of the '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Box value);

	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.edu.modsoft.bfmodel.bf.Flow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox_Flows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Flow> getFlows();

	/**
	 * Returns the value of the '<em><b>Incoming Flows</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.edu.modsoft.bfmodel.bf.Flow}.
	 * It is bidirectional and its opposite is '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getTargetBox <em>Target Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Flows</em>' reference list.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox_IncomingFlows()
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Flow#getTargetBox
	 * @model opposite="targetBox"
	 * @generated
	 */
	EList<Flow> getIncomingFlows();

	/**
	 * Returns the value of the '<em><b>Outgoing Flows</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.edu.modsoft.bfmodel.bf.Flow}.
	 * It is bidirectional and its opposite is '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getSourceBox <em>Source Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Flows</em>' reference list.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.BfPackage#getBox_OutgoingFlows()
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Flow#getSourceBox
	 * @model opposite="sourceBox"
	 * @generated
	 */
	EList<Flow> getOutgoingFlows();

} // Box
