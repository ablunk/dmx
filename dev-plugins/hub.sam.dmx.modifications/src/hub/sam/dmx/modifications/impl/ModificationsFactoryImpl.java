/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications.impl;

import hub.sam.dmx.modifications.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModificationsFactoryImpl extends EFactoryImpl implements ModificationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModificationsFactory init() {
		try {
			ModificationsFactory theModificationsFactory = (ModificationsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.hu-berlin.de/sam/modifications"); 
			if (theModificationsFactory != null) {
				return theModificationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModificationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModificationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModificationsPackage.MODIFICATIONS_RECORD: return createModificationsRecord();
			case ModificationsPackage.SUBSTITUTION: return createSubstitution();
			case ModificationsPackage.ADDITION: return createAddition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModificationsRecord createModificationsRecord() {
		ModificationsRecordImpl modificationsRecord = new ModificationsRecordImpl();
		return modificationsRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Substitution createSubstitution() {
		SubstitutionImpl substitution = new SubstitutionImpl();
		return substitution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Addition createAddition() {
		AdditionImpl addition = new AdditionImpl();
		return addition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModificationsPackage getModificationsPackage() {
		return (ModificationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModificationsPackage getPackage() {
		return ModificationsPackage.eINSTANCE;
	}

} //ModificationsFactoryImpl
