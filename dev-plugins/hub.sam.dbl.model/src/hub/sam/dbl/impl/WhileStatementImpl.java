/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.WhileStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.WhileStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.WhileStatementImpl#getWhileBlock <em>While Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileStatementImpl extends CompositeStatementImpl implements WhileStatement {
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
	 * The cached value of the '{@link #getWhileBlock() <em>While Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhileBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock whileBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.WHILE_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.WHILE_STATEMENT__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.WHILE_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.WHILE_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.WHILE_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getWhileBlock() {
		return whileBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhileBlock(CodeBlock newWhileBlock, NotificationChain msgs) {
		CodeBlock oldWhileBlock = whileBlock;
		whileBlock = newWhileBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.WHILE_STATEMENT__WHILE_BLOCK, oldWhileBlock, newWhileBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhileBlock(CodeBlock newWhileBlock) {
		if (newWhileBlock != whileBlock) {
			NotificationChain msgs = null;
			if (whileBlock != null)
				msgs = ((InternalEObject)whileBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.WHILE_STATEMENT__WHILE_BLOCK, null, msgs);
			if (newWhileBlock != null)
				msgs = ((InternalEObject)newWhileBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.WHILE_STATEMENT__WHILE_BLOCK, null, msgs);
			msgs = basicSetWhileBlock(newWhileBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.WHILE_STATEMENT__WHILE_BLOCK, newWhileBlock, newWhileBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.WHILE_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case DblPackage.WHILE_STATEMENT__WHILE_BLOCK:
				return basicSetWhileBlock(null, msgs);
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
			case DblPackage.WHILE_STATEMENT__CONDITION:
				return getCondition();
			case DblPackage.WHILE_STATEMENT__WHILE_BLOCK:
				return getWhileBlock();
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
			case DblPackage.WHILE_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case DblPackage.WHILE_STATEMENT__WHILE_BLOCK:
				setWhileBlock((CodeBlock)newValue);
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
			case DblPackage.WHILE_STATEMENT__CONDITION:
				setCondition((Expression)null);
				return;
			case DblPackage.WHILE_STATEMENT__WHILE_BLOCK:
				setWhileBlock((CodeBlock)null);
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
			case DblPackage.WHILE_STATEMENT__CONDITION:
				return condition != null;
			case DblPackage.WHILE_STATEMENT__WHILE_BLOCK:
				return whileBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //WhileStatementImpl
