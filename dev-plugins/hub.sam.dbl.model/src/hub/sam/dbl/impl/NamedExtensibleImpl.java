/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpression;
import hub.sam.dbl.ExpandableElement;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NamedExtensible;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Extensible</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.NamedExtensibleImpl#getExpandExpression <em>Expand Expression</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.NamedExtensibleImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedExtensibleImpl extends ExtensibleElementImpl implements NamedExtensible {
	/**
	 * The cached value of the '{@link #getExpandExpression() <em>Expand Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpandExpression expandExpression;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedExtensibleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.NAMED_EXTENSIBLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandExpression getExpandExpression() {
		return expandExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpandExpression(ExpandExpression newExpandExpression, NotificationChain msgs) {
		ExpandExpression oldExpandExpression = expandExpression;
		expandExpression = newExpandExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION, oldExpandExpression, newExpandExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandExpression(ExpandExpression newExpandExpression) {
		if (newExpandExpression != expandExpression) {
			NotificationChain msgs = null;
			if (expandExpression != null)
				msgs = ((InternalEObject)expandExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION, null, msgs);
			if (newExpandExpression != null)
				msgs = ((InternalEObject)newExpandExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION, null, msgs);
			msgs = basicSetExpandExpression(newExpandExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION, newExpandExpression, newExpandExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.NAMED_EXTENSIBLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION:
				return basicSetExpandExpression(null, msgs);
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
			case DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION:
				return getExpandExpression();
			case DblPackage.NAMED_EXTENSIBLE__NAME:
				return getName();
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
			case DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION:
				setExpandExpression((ExpandExpression)newValue);
				return;
			case DblPackage.NAMED_EXTENSIBLE__NAME:
				setName((String)newValue);
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
			case DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION:
				setExpandExpression((ExpandExpression)null);
				return;
			case DblPackage.NAMED_EXTENSIBLE__NAME:
				setName(NAME_EDEFAULT);
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
			case DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION:
				return expandExpression != null;
			case DblPackage.NAMED_EXTENSIBLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpandableElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION: return DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.NAMED_EXTENSIBLE__NAME: return DblPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ExpandableElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION: return DblPackage.NAMED_EXTENSIBLE__EXPAND_EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case DblPackage.NAMED_ELEMENT__NAME: return DblPackage.NAMED_EXTENSIBLE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NamedExtensibleImpl
