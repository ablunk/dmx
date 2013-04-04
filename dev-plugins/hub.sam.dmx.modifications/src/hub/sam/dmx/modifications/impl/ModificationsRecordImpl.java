/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications.impl;

import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.ModificationsRecord;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.impl.ModificationsRecordImpl#getModifications <em>Modifications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModificationsRecordImpl extends EObjectImpl implements ModificationsRecord {
	/**
	 * The cached value of the '{@link #getModifications() <em>Modifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifications()
	 * @generated
	 * @ordered
	 */
	protected EList<Modification> modifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModificationsRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModificationsPackage.Literals.MODIFICATIONS_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Modification> getModifications() {
		if (modifications == null) {
			modifications = new EObjectContainmentEList<Modification>(Modification.class, this, ModificationsPackage.MODIFICATIONS_RECORD__MODIFICATIONS);
		}
		return modifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModificationsPackage.MODIFICATIONS_RECORD__MODIFICATIONS:
				return ((InternalEList<?>)getModifications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModificationsPackage.MODIFICATIONS_RECORD__MODIFICATIONS:
				return getModifications();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModificationsPackage.MODIFICATIONS_RECORD__MODIFICATIONS:
				getModifications().clear();
				getModifications().addAll((Collection<? extends Modification>)newValue);
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
			case ModificationsPackage.MODIFICATIONS_RECORD__MODIFICATIONS:
				getModifications().clear();
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
			case ModificationsPackage.MODIFICATIONS_RECORD__MODIFICATIONS:
				return modifications != null && !modifications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModificationsRecordImpl
