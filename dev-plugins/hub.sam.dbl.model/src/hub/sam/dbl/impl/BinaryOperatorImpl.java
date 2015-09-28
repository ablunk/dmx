/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.BinaryOperator;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.BinaryOperatorImpl#getOp1 <em>Op1</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.BinaryOperatorImpl#getOp2 <em>Op2</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BinaryOperatorImpl extends ExpressionImpl implements BinaryOperator {
	/**
	 * The cached value of the '{@link #getOp1() <em>Op1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp1()
	 * @generated
	 * @ordered
	 */
	protected Expression op1;

	/**
	 * The cached value of the '{@link #getOp2() <em>Op2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp2()
	 * @generated
	 * @ordered
	 */
	protected Expression op2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.BINARY_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOp1() {
		return op1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOp1(Expression newOp1, NotificationChain msgs) {
		Expression oldOp1 = op1;
		op1 = newOp1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.BINARY_OPERATOR__OP1, oldOp1, newOp1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp1(Expression newOp1) {
		if (newOp1 != op1) {
			NotificationChain msgs = null;
			if (op1 != null)
				msgs = ((InternalEObject)op1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.BINARY_OPERATOR__OP1, null, msgs);
			if (newOp1 != null)
				msgs = ((InternalEObject)newOp1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.BINARY_OPERATOR__OP1, null, msgs);
			msgs = basicSetOp1(newOp1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.BINARY_OPERATOR__OP1, newOp1, newOp1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOp2() {
		return op2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOp2(Expression newOp2, NotificationChain msgs) {
		Expression oldOp2 = op2;
		op2 = newOp2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.BINARY_OPERATOR__OP2, oldOp2, newOp2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp2(Expression newOp2) {
		if (newOp2 != op2) {
			NotificationChain msgs = null;
			if (op2 != null)
				msgs = ((InternalEObject)op2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.BINARY_OPERATOR__OP2, null, msgs);
			if (newOp2 != null)
				msgs = ((InternalEObject)newOp2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.BINARY_OPERATOR__OP2, null, msgs);
			msgs = basicSetOp2(newOp2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.BINARY_OPERATOR__OP2, newOp2, newOp2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.BINARY_OPERATOR__OP1:
				return basicSetOp1(null, msgs);
			case DblPackage.BINARY_OPERATOR__OP2:
				return basicSetOp2(null, msgs);
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
			case DblPackage.BINARY_OPERATOR__OP1:
				return getOp1();
			case DblPackage.BINARY_OPERATOR__OP2:
				return getOp2();
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
			case DblPackage.BINARY_OPERATOR__OP1:
				setOp1((Expression)newValue);
				return;
			case DblPackage.BINARY_OPERATOR__OP2:
				setOp2((Expression)newValue);
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
			case DblPackage.BINARY_OPERATOR__OP1:
				setOp1((Expression)null);
				return;
			case DblPackage.BINARY_OPERATOR__OP2:
				setOp2((Expression)null);
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
			case DblPackage.BINARY_OPERATOR__OP1:
				return op1 != null;
			case DblPackage.BINARY_OPERATOR__OP2:
				return op2 != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryOperatorImpl
