/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ProcedureCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Procedure Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ProcedureCallImpl#getProcedureAccess <em>Procedure Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcedureCallImpl extends StatementExpressionImpl implements ProcedureCall {
	/**
	 * The cached value of the '{@link #getProcedureAccess() <em>Procedure Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedureAccess()
	 * @generated
	 * @ordered
	 */
	protected Expression procedureAccess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcedureCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.PROCEDURE_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getProcedureAccess() {
		return procedureAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcedureAccess(Expression newProcedureAccess, NotificationChain msgs) {
		Expression oldProcedureAccess = procedureAccess;
		procedureAccess = newProcedureAccess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS, oldProcedureAccess, newProcedureAccess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureAccess(Expression newProcedureAccess) {
		if (newProcedureAccess != procedureAccess) {
			NotificationChain msgs = null;
			if (procedureAccess != null)
				msgs = ((InternalEObject)procedureAccess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS, null, msgs);
			if (newProcedureAccess != null)
				msgs = ((InternalEObject)newProcedureAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS, null, msgs);
			msgs = basicSetProcedureAccess(newProcedureAccess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS, newProcedureAccess, newProcedureAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS:
				return basicSetProcedureAccess(null, msgs);
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
			case DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS:
				return getProcedureAccess();
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
			case DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS:
				setProcedureAccess((Expression)newValue);
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
			case DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS:
				setProcedureAccess((Expression)null);
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
			case DblPackage.PROCEDURE_CALL__PROCEDURE_ACCESS:
				return procedureAccess != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcedureCallImpl
