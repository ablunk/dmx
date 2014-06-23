/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensibleElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extensible Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensibleElementImpl#isObjectIsExtensionInstance <em>Object Is Extension Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensibleElementImpl extends EObjectImpl implements ExtensibleElement {
	/**
	 * The default value of the '{@link #isObjectIsExtensionInstance() <em>Object Is Extension Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isObjectIsExtensionInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isObjectIsExtensionInstance() <em>Object Is Extension Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isObjectIsExtensionInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean objectIsExtensionInstance = OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensibleElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXTENSIBLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isObjectIsExtensionInstance() {
		return objectIsExtensionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectIsExtensionInstance(boolean newObjectIsExtensionInstance) {
		boolean oldObjectIsExtensionInstance = objectIsExtensionInstance;
		objectIsExtensionInstance = newObjectIsExtensionInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE, oldObjectIsExtensionInstance, objectIsExtensionInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE:
				return isObjectIsExtensionInstance();
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
			case DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE:
				setObjectIsExtensionInstance((Boolean)newValue);
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
			case DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE:
				setObjectIsExtensionInstance(OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT);
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
			case DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE:
				return objectIsExtensionInstance != OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT;
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
		result.append(" (objectIsExtensionInstance: ");
		result.append(objectIsExtensionInstance);
		result.append(')');
		return result.toString();
	}

} //ExtensibleElementImpl
