/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications;

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
 * @see hub.sam.dmx.modifications.ModificationsFactory
 * @model kind="package"
 * @generated
 */
public interface ModificationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifications";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.hu-berlin.de/sam/modifications";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modifications";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModificationsPackage eINSTANCE = hub.sam.dmx.modifications.impl.ModificationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link hub.sam.dmx.modifications.impl.ModificationsRecordImpl <em>Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dmx.modifications.impl.ModificationsRecordImpl
	 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getModificationsRecord()
	 * @generated
	 */
	int MODIFICATIONS_RECORD = 0;

	/**
	 * The feature id for the '<em><b>Modifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS_RECORD__MODIFICATIONS = 0;

	/**
	 * The number of structural features of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS_RECORD_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dmx.modifications.impl.ModificationImpl <em>Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dmx.modifications.impl.ModificationImpl
	 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getModification()
	 * @generated
	 */
	int MODIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Source EObject Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__SOURCE_EOBJECT_URI = 0;

	/**
	 * The feature id for the '<em><b>Source Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__SOURCE_START = 1;

	/**
	 * The feature id for the '<em><b>Replacement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__REPLACEMENT_TEXT = 2;

	/**
	 * The number of structural features of the '<em>Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hub.sam.dmx.modifications.impl.SubstitutionImpl <em>Substitution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dmx.modifications.impl.SubstitutionImpl
	 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getSubstitution()
	 * @generated
	 */
	int SUBSTITUTION = 2;

	/**
	 * The feature id for the '<em><b>Source EObject Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__SOURCE_EOBJECT_URI = MODIFICATION__SOURCE_EOBJECT_URI;

	/**
	 * The feature id for the '<em><b>Source Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__SOURCE_START = MODIFICATION__SOURCE_START;

	/**
	 * The feature id for the '<em><b>Replacement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__REPLACEMENT_TEXT = MODIFICATION__REPLACEMENT_TEXT;

	/**
	 * The feature id for the '<em><b>Source Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION__SOURCE_LENGTH = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Substitution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSTITUTION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dmx.modifications.impl.AdditionImpl <em>Addition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dmx.modifications.impl.AdditionImpl
	 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getAddition()
	 * @generated
	 */
	int ADDITION = 3;

	/**
	 * The feature id for the '<em><b>Source EObject Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__SOURCE_EOBJECT_URI = MODIFICATION__SOURCE_EOBJECT_URI;

	/**
	 * The feature id for the '<em><b>Source Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__SOURCE_START = MODIFICATION__SOURCE_START;

	/**
	 * The feature id for the '<em><b>Replacement Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__REPLACEMENT_TEXT = MODIFICATION__REPLACEMENT_TEXT;

	/**
	 * The feature id for the '<em><b>Add After Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__ADD_AFTER_POSITION = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Addition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link hub.sam.dmx.modifications.ModificationsRecord <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record</em>'.
	 * @see hub.sam.dmx.modifications.ModificationsRecord
	 * @generated
	 */
	EClass getModificationsRecord();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dmx.modifications.ModificationsRecord#getModifications <em>Modifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifications</em>'.
	 * @see hub.sam.dmx.modifications.ModificationsRecord#getModifications()
	 * @see #getModificationsRecord()
	 * @generated
	 */
	EReference getModificationsRecord_Modifications();

	/**
	 * Returns the meta object for class '{@link hub.sam.dmx.modifications.Modification <em>Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modification</em>'.
	 * @see hub.sam.dmx.modifications.Modification
	 * @generated
	 */
	EClass getModification();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dmx.modifications.Modification#getSourceEObjectUri <em>Source EObject Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source EObject Uri</em>'.
	 * @see hub.sam.dmx.modifications.Modification#getSourceEObjectUri()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_SourceEObjectUri();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dmx.modifications.Modification#getSourceStart <em>Source Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Start</em>'.
	 * @see hub.sam.dmx.modifications.Modification#getSourceStart()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_SourceStart();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dmx.modifications.Modification#getReplacementText <em>Replacement Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replacement Text</em>'.
	 * @see hub.sam.dmx.modifications.Modification#getReplacementText()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_ReplacementText();

	/**
	 * Returns the meta object for class '{@link hub.sam.dmx.modifications.Substitution <em>Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Substitution</em>'.
	 * @see hub.sam.dmx.modifications.Substitution
	 * @generated
	 */
	EClass getSubstitution();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dmx.modifications.Substitution#getSourceLength <em>Source Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Length</em>'.
	 * @see hub.sam.dmx.modifications.Substitution#getSourceLength()
	 * @see #getSubstitution()
	 * @generated
	 */
	EAttribute getSubstitution_SourceLength();

	/**
	 * Returns the meta object for class '{@link hub.sam.dmx.modifications.Addition <em>Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addition</em>'.
	 * @see hub.sam.dmx.modifications.Addition
	 * @generated
	 */
	EClass getAddition();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dmx.modifications.Addition#isAddAfterPosition <em>Add After Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add After Position</em>'.
	 * @see hub.sam.dmx.modifications.Addition#isAddAfterPosition()
	 * @see #getAddition()
	 * @generated
	 */
	EAttribute getAddition_AddAfterPosition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModificationsFactory getModificationsFactory();

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
		 * The meta object literal for the '{@link hub.sam.dmx.modifications.impl.ModificationsRecordImpl <em>Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dmx.modifications.impl.ModificationsRecordImpl
		 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getModificationsRecord()
		 * @generated
		 */
		EClass MODIFICATIONS_RECORD = eINSTANCE.getModificationsRecord();

		/**
		 * The meta object literal for the '<em><b>Modifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFICATIONS_RECORD__MODIFICATIONS = eINSTANCE.getModificationsRecord_Modifications();

		/**
		 * The meta object literal for the '{@link hub.sam.dmx.modifications.impl.ModificationImpl <em>Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dmx.modifications.impl.ModificationImpl
		 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getModification()
		 * @generated
		 */
		EClass MODIFICATION = eINSTANCE.getModification();

		/**
		 * The meta object literal for the '<em><b>Source EObject Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__SOURCE_EOBJECT_URI = eINSTANCE.getModification_SourceEObjectUri();

		/**
		 * The meta object literal for the '<em><b>Source Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__SOURCE_START = eINSTANCE.getModification_SourceStart();

		/**
		 * The meta object literal for the '<em><b>Replacement Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__REPLACEMENT_TEXT = eINSTANCE.getModification_ReplacementText();

		/**
		 * The meta object literal for the '{@link hub.sam.dmx.modifications.impl.SubstitutionImpl <em>Substitution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dmx.modifications.impl.SubstitutionImpl
		 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getSubstitution()
		 * @generated
		 */
		EClass SUBSTITUTION = eINSTANCE.getSubstitution();

		/**
		 * The meta object literal for the '<em><b>Source Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSTITUTION__SOURCE_LENGTH = eINSTANCE.getSubstitution_SourceLength();

		/**
		 * The meta object literal for the '{@link hub.sam.dmx.modifications.impl.AdditionImpl <em>Addition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dmx.modifications.impl.AdditionImpl
		 * @see hub.sam.dmx.modifications.impl.ModificationsPackageImpl#getAddition()
		 * @generated
		 */
		EClass ADDITION = eINSTANCE.getAddition();

		/**
		 * The meta object literal for the '<em><b>Add After Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITION__ADD_AFTER_POSITION = eINSTANCE.getAddition_AddAfterPosition();

	}

} //ModificationsPackage
