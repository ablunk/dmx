/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
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
 *   <li>{@link hub.sam.dbl.impl.TextualSyntaxDefImpl#getStartRule <em>Start Rule</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.TextualSyntaxDefImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualSyntaxDefImpl extends ExtensibleElementImpl implements TextualSyntaxDef {
	/**
	 * The cached value of the '{@link #getStartRule() <em>Start Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartRule()
	 * @generated
	 * @ordered
	 */
	protected TsRule startRule;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<TsRule> rules;

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
	public TsRule getStartRule() {
		if (startRule != null && startRule.eIsProxy()) {
			InternalEObject oldStartRule = (InternalEObject)startRule;
			startRule = (TsRule)eResolveProxy(oldStartRule);
			if (startRule != oldStartRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.TEXTUAL_SYNTAX_DEF__START_RULE, oldStartRule, startRule));
			}
		}
		return startRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TsRule basicGetStartRule() {
		return startRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartRule(TsRule newStartRule) {
		TsRule oldStartRule = startRule;
		startRule = newStartRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.TEXTUAL_SYNTAX_DEF__START_RULE, oldStartRule, startRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TsRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<TsRule>(TsRule.class, this, DblPackage.TEXTUAL_SYNTAX_DEF__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.TEXTUAL_SYNTAX_DEF__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__START_RULE:
				if (resolve) return getStartRule();
				return basicGetStartRule();
			case DblPackage.TEXTUAL_SYNTAX_DEF__RULES:
				return getRules();
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__START_RULE:
				setStartRule((TsRule)newValue);
				return;
			case DblPackage.TEXTUAL_SYNTAX_DEF__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends TsRule>)newValue);
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__START_RULE:
				setStartRule((TsRule)null);
				return;
			case DblPackage.TEXTUAL_SYNTAX_DEF__RULES:
				getRules().clear();
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
			case DblPackage.TEXTUAL_SYNTAX_DEF__START_RULE:
				return startRule != null;
			case DblPackage.TEXTUAL_SYNTAX_DEF__RULES:
				return rules != null && !rules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TextualSyntaxDefImpl
