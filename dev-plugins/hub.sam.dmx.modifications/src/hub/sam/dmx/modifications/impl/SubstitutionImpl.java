/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications.impl;

import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.Substitution;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Substitution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.impl.SubstitutionImpl#getSourceLength <em>Source Length</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubstitutionImpl extends ModificationImpl implements Substitution {
	/**
	 * The default value of the '{@link #getSourceLength() <em>Source Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLength()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_LENGTH_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSourceLength() <em>Source Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLength()
	 * @generated
	 * @ordered
	 */
	protected int sourceLength = SOURCE_LENGTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstitutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModificationsPackage.Literals.SUBSTITUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceLength() {
		return sourceLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLength(int newSourceLength) {
		int oldSourceLength = sourceLength;
		sourceLength = newSourceLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModificationsPackage.SUBSTITUTION__SOURCE_LENGTH, oldSourceLength, sourceLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModificationsPackage.SUBSTITUTION__SOURCE_LENGTH:
				return getSourceLength();
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
			case ModificationsPackage.SUBSTITUTION__SOURCE_LENGTH:
				setSourceLength((Integer)newValue);
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
			case ModificationsPackage.SUBSTITUTION__SOURCE_LENGTH:
				setSourceLength(SOURCE_LENGTH_EDEFAULT);
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
			case ModificationsPackage.SUBSTITUTION__SOURCE_LENGTH:
				return sourceLength != SOURCE_LENGTH_EDEFAULT;
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
		result.append(" (sourceLength: ");
		result.append(sourceLength);
		result.append(')');
		return result.toString();
	}

} //SubstitutionImpl
