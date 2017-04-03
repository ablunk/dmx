/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.CodeQuoteExpression;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.QuotedCode;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Quote Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.CodeQuoteExpressionImpl#getQuotedCode <em>Quoted Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeQuoteExpressionImpl extends ExpressionImpl implements CodeQuoteExpression {
	/**
	 * The cached value of the '{@link #getQuotedCode() <em>Quoted Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuotedCode()
	 * @generated
	 * @ordered
	 */
	protected QuotedCode quotedCode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeQuoteExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.CODE_QUOTE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedCode getQuotedCode() {
		return quotedCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuotedCode(QuotedCode newQuotedCode, NotificationChain msgs) {
		QuotedCode oldQuotedCode = quotedCode;
		quotedCode = newQuotedCode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE, oldQuotedCode, newQuotedCode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuotedCode(QuotedCode newQuotedCode) {
		if (newQuotedCode != quotedCode) {
			NotificationChain msgs = null;
			if (quotedCode != null)
				msgs = ((InternalEObject)quotedCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE, null, msgs);
			if (newQuotedCode != null)
				msgs = ((InternalEObject)newQuotedCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE, null, msgs);
			msgs = basicSetQuotedCode(newQuotedCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE, newQuotedCode, newQuotedCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE:
				return basicSetQuotedCode(null, msgs);
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
			case DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE:
				return getQuotedCode();
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
			case DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE:
				setQuotedCode((QuotedCode)newValue);
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
			case DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE:
				setQuotedCode((QuotedCode)null);
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
			case DblPackage.CODE_QUOTE_EXPRESSION__QUOTED_CODE:
				return quotedCode != null;
		}
		return super.eIsSet(featureID);
	}

} //CodeQuoteExpressionImpl
