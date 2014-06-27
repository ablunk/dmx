/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionRule;
import hub.sam.dbl.TextualSyntaxDef;
import hub.sam.dbl.TsRule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textual Syntax Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.TextualSyntaxDefImpl#getExtensionRule <em>Extension Rule</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.TextualSyntaxDefImpl#getNewRules <em>New Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualSyntaxDefImpl extends EObjectImpl implements TextualSyntaxDef {
	/**
	 * The cached value of the '{@link #getExtensionRule() <em>Extension Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionRule()
	 * @generated
	 * @ordered
	 */
	protected ExtensionRule extensionRule;

	/**
	 * The cached value of the '{@link #getNewRules() <em>New Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewRules()
	 * @generated
	 * @ordered
	 */
	protected EList<TsRule> newRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextualSyntaxDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.TEXTUAL_SYNTAX_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionRule getExtensionRule() {
		return extensionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionRule(ExtensionRule newExtensionRule, NotificationChain msgs) {
		ExtensionRule oldExtensionRule = extensionRule;
		extensionRule = newExtensionRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE, oldExtensionRule, newExtensionRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionRule(ExtensionRule newExtensionRule) {
		if (newExtensionRule != extensionRule) {
			NotificationChain msgs = null;
			if (extensionRule != null)
				msgs = ((InternalEObject)extensionRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE, null, msgs);
			if (newExtensionRule != null)
				msgs = ((InternalEObject)newExtensionRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE, null, msgs);
			msgs = basicSetExtensionRule(newExtensionRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE, newExtensionRule, newExtensionRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TsRule> getNewRules() {
		if (newRules == null) {
			newRules = new EObjectContainmentEList<TsRule>(TsRule.class, this, DblPackage.TEXTUAL_SYNTAX_DEF__NEW_RULES);
		}
		return newRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE:
				return basicSetExtensionRule(null, msgs);
			case DblPackage.TEXTUAL_SYNTAX_DEF__NEW_RULES:
				return ((InternalEList<?>)getNewRules()).basicRemove(otherEnd, msgs);
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE:
				return getExtensionRule();
			case DblPackage.TEXTUAL_SYNTAX_DEF__NEW_RULES:
				return getNewRules();
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE:
				setExtensionRule((ExtensionRule)newValue);
				return;
			case DblPackage.TEXTUAL_SYNTAX_DEF__NEW_RULES:
				getNewRules().clear();
				getNewRules().addAll((Collection<? extends TsRule>)newValue);
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE:
				setExtensionRule((ExtensionRule)null);
				return;
			case DblPackage.TEXTUAL_SYNTAX_DEF__NEW_RULES:
				getNewRules().clear();
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__EXTENSION_RULE:
				return extensionRule != null;
			case DblPackage.TEXTUAL_SYNTAX_DEF__NEW_RULES:
				return newRules != null && !newRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TextualSyntaxDefImpl
