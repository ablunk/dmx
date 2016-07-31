/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.edu.modsoft.bfmodel.bf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hub.sam.edu.modsoft.bfmodel.bf.BfFactory
 * @model kind="package"
 * @generated
 */
public interface BfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.hu-berlin.de/sam/lang/bf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BfPackage eINSTANCE = hub.sam.edu.modsoft.bfmodel.bf.impl.BfPackageImpl.init();

	/**
	 * The meta object id for the '{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl <em>Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl
	 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.BfPackageImpl#getBox()
	 * @generated
	 */
	int BOX = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__NAME = 0;

	/**
	 * The feature id for the '<em><b>Owned Boxes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__OWNED_BOXES = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__OWNER = 2;

	/**
	 * The feature id for the '<em><b>Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__FLOWS = 3;

	/**
	 * The feature id for the '<em><b>Incoming Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__INCOMING_FLOWS = 4;

	/**
	 * The feature id for the '<em><b>Outgoing Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__OUTGOING_FLOWS = 5;

	/**
	 * The feature id for the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX__META_CLASS = 6;

	/**
	 * The number of structural features of the '<em>Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOX_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link hub.sam.edu.modsoft.bfmodel.bf.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.FlowImpl
	 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.BfPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 1;

	/**
	 * The feature id for the '<em><b>Source Box</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__SOURCE_BOX = 0;

	/**
	 * The feature id for the '<em><b>Target Box</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TARGET_BOX = 1;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link hub.sam.edu.modsoft.bfmodel.bf.Box <em>Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Box</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box
	 * @generated
	 */
	EClass getBox();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getName()
	 * @see #getBox()
	 * @generated
	 */
	EAttribute getBox_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwnedBoxes <em>Owned Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Boxes</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getOwnedBoxes()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_OwnedBoxes();

	/**
	 * Returns the meta object for the container reference '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getOwner()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getFlows <em>Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flows</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getFlows()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_Flows();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getIncomingFlows <em>Incoming Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Flows</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getIncomingFlows()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_IncomingFlows();

	/**
	 * Returns the meta object for the reference list '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getOutgoingFlows <em>Outgoing Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Flows</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getOutgoingFlows()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_OutgoingFlows();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.edu.modsoft.bfmodel.bf.Box#getMetaClass <em>Meta Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Meta Class</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Box#getMetaClass()
	 * @see #getBox()
	 * @generated
	 */
	EReference getBox_MetaClass();

	/**
	 * Returns the meta object for class '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getSourceBox <em>Source Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Box</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Flow#getSourceBox()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_SourceBox();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.edu.modsoft.bfmodel.bf.Flow#getTargetBox <em>Target Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Box</em>'.
	 * @see hub.sam.edu.modsoft.bfmodel.bf.Flow#getTargetBox()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_TargetBox();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BfFactory getBfFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl <em>Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl
		 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.BfPackageImpl#getBox()
		 * @generated
		 */
		EClass BOX = eINSTANCE.getBox();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOX__NAME = eINSTANCE.getBox_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Boxes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__OWNED_BOXES = eINSTANCE.getBox_OwnedBoxes();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__OWNER = eINSTANCE.getBox_Owner();

		/**
		 * The meta object literal for the '<em><b>Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__FLOWS = eINSTANCE.getBox_Flows();

		/**
		 * The meta object literal for the '<em><b>Incoming Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__INCOMING_FLOWS = eINSTANCE.getBox_IncomingFlows();

		/**
		 * The meta object literal for the '<em><b>Outgoing Flows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__OUTGOING_FLOWS = eINSTANCE.getBox_OutgoingFlows();

		/**
		 * The meta object literal for the '<em><b>Meta Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOX__META_CLASS = eINSTANCE.getBox_MetaClass();

		/**
		 * The meta object literal for the '{@link hub.sam.edu.modsoft.bfmodel.bf.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.FlowImpl
		 * @see hub.sam.edu.modsoft.bfmodel.bf.impl.BfPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>Source Box</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__SOURCE_BOX = eINSTANCE.getFlow_SourceBox();

		/**
		 * The meta object literal for the '<em><b>Target Box</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__TARGET_BOX = eINSTANCE.getFlow_TargetBox();

	}

} //BfPackage
