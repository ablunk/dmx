/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Pattern;
import hub.sam.dbl.ReferencePropertyType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Property Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ReferencePropertyTypeImpl#isRawReference <em>Raw Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferencePropertyTypeImpl extends StructuredPropertyTypeImpl implements ReferencePropertyType {
	/**
	 * The default value of the '{@link #isRawReference() <em>Raw Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRawReference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RAW_REFERENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRawReference() <em>Raw Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRawReference()
	 * @generated
	 * @ordered
	 */
	protected boolean rawReference = RAW_REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferencePropertyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.REFERENCE_PROPERTY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRawReference() {
		return rawReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawReference(boolean newRawReference) {
		boolean oldRawReference = rawReference;
		rawReference = newRawReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.REFERENCE_PROPERTY_TYPE__RAW_REFERENCE, oldRawReference, rawReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DblPackage.REFERENCE_PROPERTY_TYPE__RAW_REFERENCE:
				return isRawReference();
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
			case DblPackage.REFERENCE_PROPERTY_TYPE__RAW_REFERENCE:
				setRawReference((Boolean)newValue);
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
			case DblPackage.REFERENCE_PROPERTY_TYPE__RAW_REFERENCE:
				setRawReference(RAW_REFERENCE_EDEFAULT);
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
			case DblPackage.REFERENCE_PROPERTY_TYPE__RAW_REFERENCE:
				return rawReference != RAW_REFERENCE_EDEFAULT;
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
		result.append(" (rawReference: ");
		result.append(rawReference);
		result.append(')');
		return result.toString();
	}

} //ReferencePropertyTypeImpl
