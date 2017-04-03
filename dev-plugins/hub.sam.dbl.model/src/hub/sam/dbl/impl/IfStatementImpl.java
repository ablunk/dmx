/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.IfStatement;
import hub.sam.dbl.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getTrueCase <em>True Case</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getFalseCase <em>False Case</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getTrueCase() <em>True Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueCase()
	 * @generated
	 * @ordered
	 */
	protected Statement trueCase;

	/**
	 * The cached value of the '{@link #getFalseCase() <em>False Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseCase()
	 * @generated
	 * @ordered
	 */
	protected Statement falseCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.IF_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getTrueCase() {
		return trueCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueCase(Statement newTrueCase, NotificationChain msgs) {
		Statement oldTrueCase = trueCase;
		trueCase = newTrueCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__TRUE_CASE, oldTrueCase, newTrueCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueCase(Statement newTrueCase) {
		if (newTrueCase != trueCase) {
			NotificationChain msgs = null;
			if (trueCase != null)
				msgs = ((InternalEObject)trueCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__TRUE_CASE, null, msgs);
			if (newTrueCase != null)
				msgs = ((InternalEObject)newTrueCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__TRUE_CASE, null, msgs);
			msgs = basicSetTrueCase(newTrueCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__TRUE_CASE, newTrueCase, newTrueCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getFalseCase() {
		return falseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseCase(Statement newFalseCase, NotificationChain msgs) {
		Statement oldFalseCase = falseCase;
		falseCase = newFalseCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__FALSE_CASE, oldFalseCase, newFalseCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseCase(Statement newFalseCase) {
		if (newFalseCase != falseCase) {
			NotificationChain msgs = null;
			if (falseCase != null)
				msgs = ((InternalEObject)falseCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__FALSE_CASE, null, msgs);
			if (newFalseCase != null)
				msgs = ((InternalEObject)newFalseCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__FALSE_CASE, null, msgs);
			msgs = basicSetFalseCase(newFalseCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__FALSE_CASE, newFalseCase, newFalseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.IF_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case DblPackage.IF_STATEMENT__TRUE_CASE:
				return basicSetTrueCase(null, msgs);
			case DblPackage.IF_STATEMENT__FALSE_CASE:
				return basicSetFalseCase(null, msgs);
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
			case DblPackage.IF_STATEMENT__CONDITION:
				return getCondition();
			case DblPackage.IF_STATEMENT__TRUE_CASE:
				return getTrueCase();
			case DblPackage.IF_STATEMENT__FALSE_CASE:
				return getFalseCase();
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
			case DblPackage.IF_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case DblPackage.IF_STATEMENT__TRUE_CASE:
				setTrueCase((Statement)newValue);
				return;
			case DblPackage.IF_STATEMENT__FALSE_CASE:
				setFalseCase((Statement)newValue);
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
			case DblPackage.IF_STATEMENT__CONDITION:
				setCondition((Expression)null);
				return;
			case DblPackage.IF_STATEMENT__TRUE_CASE:
				setTrueCase((Statement)null);
				return;
			case DblPackage.IF_STATEMENT__FALSE_CASE:
				setFalseCase((Statement)null);
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
			case DblPackage.IF_STATEMENT__CONDITION:
				return condition != null;
			case DblPackage.IF_STATEMENT__TRUE_CASE:
				return trueCase != null;
			case DblPackage.IF_STATEMENT__FALSE_CASE:
				return falseCase != null;
		}
		return super.eIsSet(featureID);
	}

} //IfStatementImpl
