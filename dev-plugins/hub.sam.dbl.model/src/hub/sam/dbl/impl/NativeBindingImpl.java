/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.NativeBinding;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.NativeBindingImpl#getTargetLanguage <em>Target Language</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.NativeBindingImpl#getTargetType <em>Target Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NativeBindingImpl extends EObjectImpl implements NativeBinding {
	/**
	 * The default value of the '{@link #getTargetLanguage() <em>Target Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetLanguage() <em>Target Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLanguage()
	 * @generated
	 * @ordered
	 */
	protected String targetLanguage = TARGET_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected String targetType = TARGET_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NativeBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.NATIVE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetLanguage() {
		return targetLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLanguage(String newTargetLanguage) {
		String oldTargetLanguage = targetLanguage;
		targetLanguage = newTargetLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.NATIVE_BINDING__TARGET_LANGUAGE, oldTargetLanguage, targetLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetType() {
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetType(String newTargetType) {
		String oldTargetType = targetType;
		targetType = newTargetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.NATIVE_BINDING__TARGET_TYPE, oldTargetType, targetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DblPackage.NATIVE_BINDING__TARGET_LANGUAGE:
				return getTargetLanguage();
			case DblPackage.NATIVE_BINDING__TARGET_TYPE:
				return getTargetType();
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
			case DblPackage.NATIVE_BINDING__TARGET_LANGUAGE:
				setTargetLanguage((String)newValue);
				return;
			case DblPackage.NATIVE_BINDING__TARGET_TYPE:
				setTargetType((String)newValue);
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
			case DblPackage.NATIVE_BINDING__TARGET_LANGUAGE:
				setTargetLanguage(TARGET_LANGUAGE_EDEFAULT);
				return;
			case DblPackage.NATIVE_BINDING__TARGET_TYPE:
				setTargetType(TARGET_TYPE_EDEFAULT);
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
			case DblPackage.NATIVE_BINDING__TARGET_LANGUAGE:
				return TARGET_LANGUAGE_EDEFAULT == null ? targetLanguage != null : !TARGET_LANGUAGE_EDEFAULT.equals(targetLanguage);
			case DblPackage.NATIVE_BINDING__TARGET_TYPE:
				return TARGET_TYPE_EDEFAULT == null ? targetType != null : !TARGET_TYPE_EDEFAULT.equals(targetType);
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
		result.append(" (targetLanguage: ");
		result.append(targetLanguage);
		result.append(", targetType: ");
		result.append(targetType);
		result.append(')');
		return result.toString();
	}

} //NativeBindingImpl
