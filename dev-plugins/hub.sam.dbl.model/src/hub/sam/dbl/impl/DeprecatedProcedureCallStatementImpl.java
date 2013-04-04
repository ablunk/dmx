/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.DeprecatedProcedureCallStatement;
import hub.sam.dbl.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deprecated Procedure Call Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.DeprecatedProcedureCallStatementImpl#getProcedureCall <em>Procedure Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeprecatedProcedureCallStatementImpl extends ExpressionStatementImpl implements DeprecatedProcedureCallStatement {
	/**
	 * The cached value of the '{@link #getProcedureCall() <em>Procedure Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedureCall()
	 * @generated
	 * @ordered
	 */
	protected Expression procedureCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeprecatedProcedureCallStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.DEPRECATED_PROCEDURE_CALL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getProcedureCall() {
		return procedureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcedureCall(Expression newProcedureCall, NotificationChain msgs) {
		Expression oldProcedureCall = procedureCall;
		procedureCall = newProcedureCall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL, oldProcedureCall, newProcedureCall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureCall(Expression newProcedureCall) {
		if (newProcedureCall != procedureCall) {
			NotificationChain msgs = null;
			if (procedureCall != null)
				msgs = ((InternalEObject)procedureCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL, null, msgs);
			if (newProcedureCall != null)
				msgs = ((InternalEObject)newProcedureCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL, null, msgs);
			msgs = basicSetProcedureCall(newProcedureCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL, newProcedureCall, newProcedureCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL:
				return basicSetProcedureCall(null, msgs);
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
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL:
				return getProcedureCall();
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
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL:
				setProcedureCall((Expression)newValue);
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
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL:
				setProcedureCall((Expression)null);
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
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL:
				return procedureCall != null;
		}
		return super.eIsSet(featureID);
	}

} //DeprecatedProcedureCallStatementImpl
