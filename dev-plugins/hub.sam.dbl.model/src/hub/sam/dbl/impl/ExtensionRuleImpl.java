/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Classifier;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionRule;
import hub.sam.dbl.RuleExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensionRuleImpl#getInstantiableMetaClass <em>Instantiable Meta Class</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionRuleImpl#getFirstNewRule <em>First New Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionRuleImpl extends NamedElementImpl implements ExtensionRule {
	/**
	 * The cached value of the '{@link #getInstantiableMetaClass() <em>Instantiable Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiableMetaClass()
	 * @generated
	 * @ordered
	 */
	protected Classifier instantiableMetaClass;

	/**
	 * The cached value of the '{@link #getFirstNewRule() <em>First New Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstNewRule()
	 * @generated
	 * @ordered
	 */
	protected RuleExpr firstNewRule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXTENSION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getInstantiableMetaClass() {
		if (instantiableMetaClass != null && instantiableMetaClass.eIsProxy()) {
			InternalEObject oldInstantiableMetaClass = (InternalEObject)instantiableMetaClass;
			instantiableMetaClass = (Classifier)eResolveProxy(oldInstantiableMetaClass);
			if (instantiableMetaClass != oldInstantiableMetaClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.EXTENSION_RULE__INSTANTIABLE_META_CLASS, oldInstantiableMetaClass, instantiableMetaClass));
			}
		}
		return instantiableMetaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetInstantiableMetaClass() {
		return instantiableMetaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiableMetaClass(Classifier newInstantiableMetaClass) {
		Classifier oldInstantiableMetaClass = instantiableMetaClass;
		instantiableMetaClass = newInstantiableMetaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_RULE__INSTANTIABLE_META_CLASS, oldInstantiableMetaClass, instantiableMetaClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleExpr getFirstNewRule() {
		return firstNewRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstNewRule(RuleExpr newFirstNewRule, NotificationChain msgs) {
		RuleExpr oldFirstNewRule = firstNewRule;
		firstNewRule = newFirstNewRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_RULE__FIRST_NEW_RULE, oldFirstNewRule, newFirstNewRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstNewRule(RuleExpr newFirstNewRule) {
		if (newFirstNewRule != firstNewRule) {
			NotificationChain msgs = null;
			if (firstNewRule != null)
				msgs = ((InternalEObject)firstNewRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_RULE__FIRST_NEW_RULE, null, msgs);
			if (newFirstNewRule != null)
				msgs = ((InternalEObject)newFirstNewRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_RULE__FIRST_NEW_RULE, null, msgs);
			msgs = basicSetFirstNewRule(newFirstNewRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_RULE__FIRST_NEW_RULE, newFirstNewRule, newFirstNewRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXTENSION_RULE__FIRST_NEW_RULE:
				return basicSetFirstNewRule(null, msgs);
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
			case DblPackage.EXTENSION_RULE__INSTANTIABLE_META_CLASS:
				if (resolve) return getInstantiableMetaClass();
				return basicGetInstantiableMetaClass();
			case DblPackage.EXTENSION_RULE__FIRST_NEW_RULE:
				return getFirstNewRule();
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
			case DblPackage.EXTENSION_RULE__INSTANTIABLE_META_CLASS:
				setInstantiableMetaClass((Classifier)newValue);
				return;
			case DblPackage.EXTENSION_RULE__FIRST_NEW_RULE:
				setFirstNewRule((RuleExpr)newValue);
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
			case DblPackage.EXTENSION_RULE__INSTANTIABLE_META_CLASS:
				setInstantiableMetaClass((Classifier)null);
				return;
			case DblPackage.EXTENSION_RULE__FIRST_NEW_RULE:
				setFirstNewRule((RuleExpr)null);
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
			case DblPackage.EXTENSION_RULE__INSTANTIABLE_META_CLASS:
				return instantiableMetaClass != null;
			case DblPackage.EXTENSION_RULE__FIRST_NEW_RULE:
				return firstNewRule != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtensionRuleImpl
