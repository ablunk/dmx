/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.FunctionCall;
import hub.sam.dbl.IdExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.FunctionCallImpl#getCallIdExpr <em>Call Id Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionCallImpl extends SimpleStatementImpl implements FunctionCall {
	/**
	 * The cached value of the '{@link #getCallIdExpr() <em>Call Id Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallIdExpr()
	 * @generated
	 * @ordered
	 */
	protected IdExpr callIdExpr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.FUNCTION_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getCallIdExpr() {
		return callIdExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallIdExpr(IdExpr newCallIdExpr, NotificationChain msgs) {
		IdExpr oldCallIdExpr = callIdExpr;
		callIdExpr = newCallIdExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION_CALL__CALL_ID_EXPR, oldCallIdExpr, newCallIdExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallIdExpr(IdExpr newCallIdExpr) {
		if (newCallIdExpr != callIdExpr) {
			NotificationChain msgs = null;
			if (callIdExpr != null)
				msgs = ((InternalEObject)callIdExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FUNCTION_CALL__CALL_ID_EXPR, null, msgs);
			if (newCallIdExpr != null)
				msgs = ((InternalEObject)newCallIdExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FUNCTION_CALL__CALL_ID_EXPR, null, msgs);
			msgs = basicSetCallIdExpr(newCallIdExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION_CALL__CALL_ID_EXPR, newCallIdExpr, newCallIdExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.FUNCTION_CALL__CALL_ID_EXPR:
				return basicSetCallIdExpr(null, msgs);
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
			case DblPackage.FUNCTION_CALL__CALL_ID_EXPR:
				return getCallIdExpr();
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
			case DblPackage.FUNCTION_CALL__CALL_ID_EXPR:
				setCallIdExpr((IdExpr)newValue);
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
			case DblPackage.FUNCTION_CALL__CALL_ID_EXPR:
				setCallIdExpr((IdExpr)null);
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
			case DblPackage.FUNCTION_CALL__CALL_ID_EXPR:
				return callIdExpr != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionCallImpl
