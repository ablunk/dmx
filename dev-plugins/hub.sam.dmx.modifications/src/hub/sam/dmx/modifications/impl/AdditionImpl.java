/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications.impl;

import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.ModificationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.impl.AdditionImpl#isAddAfterPosition <em>Add After Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdditionImpl extends ModificationImpl implements Addition {
	/**
	 * The default value of the '{@link #isAddAfterPosition() <em>Add After Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddAfterPosition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADD_AFTER_POSITION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddAfterPosition() <em>Add After Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddAfterPosition()
	 * @generated
	 * @ordered
	 */
	protected boolean addAfterPosition = ADD_AFTER_POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModificationsPackage.Literals.ADDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddAfterPosition() {
		return addAfterPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddAfterPosition(boolean newAddAfterPosition) {
		boolean oldAddAfterPosition = addAfterPosition;
		addAfterPosition = newAddAfterPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModificationsPackage.ADDITION__ADD_AFTER_POSITION, oldAddAfterPosition, addAfterPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModificationsPackage.ADDITION__ADD_AFTER_POSITION:
				return isAddAfterPosition();
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
			case ModificationsPackage.ADDITION__ADD_AFTER_POSITION:
				setAddAfterPosition((Boolean)newValue);
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
			case ModificationsPackage.ADDITION__ADD_AFTER_POSITION:
				setAddAfterPosition(ADD_AFTER_POSITION_EDEFAULT);
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
			case ModificationsPackage.ADDITION__ADD_AFTER_POSITION:
				return addAfterPosition != ADD_AFTER_POSITION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (addAfterPosition: ");
		result.append(addAfterPosition);
		result.append(')');
		return result.toString();
	}

} //AdditionImpl
