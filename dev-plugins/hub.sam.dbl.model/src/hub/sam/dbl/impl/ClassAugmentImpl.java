/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ClassAugment;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.DblPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Augment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ClassAugmentImpl#getAugmentedClass <em>Augmented Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassAugmentImpl extends ClassSimilarImpl implements ClassAugment {
	/**
	 * The cached value of the '{@link #getAugmentedClass() <em>Augmented Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAugmentedClass()
	 * @generated
	 * @ordered
	 */
	protected Clazz augmentedClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassAugmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.CLASS_AUGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clazz getAugmentedClass() {
		if (augmentedClass != null && augmentedClass.eIsProxy()) {
			InternalEObject oldAugmentedClass = (InternalEObject)augmentedClass;
			augmentedClass = (Clazz)eResolveProxy(oldAugmentedClass);
			if (augmentedClass != oldAugmentedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS_AUGMENT__AUGMENTED_CLASS, oldAugmentedClass, augmentedClass));
			}
		}
		return augmentedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clazz basicGetAugmentedClass() {
		return augmentedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAugmentedClass(Clazz newAugmentedClass) {
		Clazz oldAugmentedClass = augmentedClass;
		augmentedClass = newAugmentedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_AUGMENT__AUGMENTED_CLASS, oldAugmentedClass, augmentedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DblPackage.CLASS_AUGMENT__AUGMENTED_CLASS:
				if (resolve) return getAugmentedClass();
				return basicGetAugmentedClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DblPackage.CLASS_AUGMENT__AUGMENTED_CLASS:
				setAugmentedClass((Clazz)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DblPackage.CLASS_AUGMENT__AUGMENTED_CLASS:
				setAugmentedClass((Clazz)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DblPackage.CLASS_AUGMENT__AUGMENTED_CLASS:
				return augmentedClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassAugmentImpl
