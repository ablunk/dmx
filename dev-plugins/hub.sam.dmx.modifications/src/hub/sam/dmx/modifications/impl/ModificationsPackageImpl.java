/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications.impl;

import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsFactory;
import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.ModificationsRecord;
import hub.sam.dmx.modifications.Substitution;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModificationsPackageImpl extends EPackageImpl implements ModificationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modificationsRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substitutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hub.sam.dmx.modifications.ModificationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModificationsPackageImpl() {
		super(eNS_URI, ModificationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModificationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModificationsPackage init() {
		if (isInited) return (ModificationsPackage)EPackage.Registry.INSTANCE.getEPackage(ModificationsPackage.eNS_URI);

		// Obtain or create and register package
		ModificationsPackageImpl theModificationsPackage = (ModificationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModificationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModificationsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModificationsPackage.createPackageContents();

		// Initialize created meta-data
		theModificationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModificationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModificationsPackage.eNS_URI, theModificationsPackage);
		return theModificationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModificationsRecord() {
		return modificationsRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModificationsRecord_Modifications() {
		return (EReference)modificationsRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModification() {
		return modificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_SourceEObjectUri() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_SourceStart() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_ReplacementText() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstitution() {
		return substitutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubstitution_SourceLength() {
		return (EAttribute)substitutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddition() {
		return additionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddition_AddAfterPosition() {
		return (EAttribute)additionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModificationsFactory getModificationsFactory() {
		return (ModificationsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modificationsRecordEClass = createEClass(MODIFICATIONS_RECORD);
		createEReference(modificationsRecordEClass, MODIFICATIONS_RECORD__MODIFICATIONS);

		modificationEClass = createEClass(MODIFICATION);
		createEAttribute(modificationEClass, MODIFICATION__SOURCE_EOBJECT_URI);
		createEAttribute(modificationEClass, MODIFICATION__SOURCE_START);
		createEAttribute(modificationEClass, MODIFICATION__REPLACEMENT_TEXT);

		substitutionEClass = createEClass(SUBSTITUTION);
		createEAttribute(substitutionEClass, SUBSTITUTION__SOURCE_LENGTH);

		additionEClass = createEClass(ADDITION);
		createEAttribute(additionEClass, ADDITION__ADD_AFTER_POSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		substitutionEClass.getESuperTypes().add(this.getModification());
		additionEClass.getESuperTypes().add(this.getModification());

		// Initialize classes and features; add operations and parameters
		initEClass(modificationsRecordEClass, ModificationsRecord.class, "ModificationsRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModificationsRecord_Modifications(), this.getModification(), null, "modifications", null, 0, -1, ModificationsRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modificationEClass, Modification.class, "Modification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModification_SourceEObjectUri(), ecorePackage.getEString(), "sourceEObjectUri", null, 1, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getModification_SourceStart(), ecorePackage.getEInt(), "sourceStart", "-1", 1, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getModification_ReplacementText(), ecorePackage.getEString(), "replacementText", null, 1, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(substitutionEClass, Substitution.class, "Substitution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubstitution_SourceLength(), ecorePackage.getEInt(), "sourceLength", "-1", 1, 1, Substitution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(additionEClass, Addition.class, "Addition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddition_AddAfterPosition(), ecorePackage.getEBoolean(), "addAfterPosition", "false", 1, 1, Addition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModificationsPackageImpl
