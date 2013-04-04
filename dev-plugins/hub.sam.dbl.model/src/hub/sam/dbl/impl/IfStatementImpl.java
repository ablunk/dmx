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
import hub.sam.dbl.IfStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getIfCaseBlock <em>If Case Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getElifCondition <em>Elif Condition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getElifCaseBlock <em>Elif Case Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IfStatementImpl#getElseCaseBlock <em>Else Case Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementImpl extends CompositeStatementImpl implements IfStatement {
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
	 * The cached value of the '{@link #getIfCaseBlock() <em>If Case Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfCaseBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock ifCaseBlock;

	/**
	 * The cached value of the '{@link #getElifCondition() <em>Elif Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElifCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> elifCondition;

	/**
	 * The cached value of the '{@link #getElifCaseBlock() <em>Elif Case Block</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElifCaseBlock()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeBlock> elifCaseBlock;

	/**
	 * The cached value of the '{@link #getElseCaseBlock() <em>Else Case Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseCaseBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock elseCaseBlock;

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
	public CodeBlock getIfCaseBlock() {
		return ifCaseBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfCaseBlock(CodeBlock newIfCaseBlock, NotificationChain msgs) {
		CodeBlock oldIfCaseBlock = ifCaseBlock;
		ifCaseBlock = newIfCaseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__IF_CASE_BLOCK, oldIfCaseBlock, newIfCaseBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfCaseBlock(CodeBlock newIfCaseBlock) {
		if (newIfCaseBlock != ifCaseBlock) {
			NotificationChain msgs = null;
			if (ifCaseBlock != null)
				msgs = ((InternalEObject)ifCaseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__IF_CASE_BLOCK, null, msgs);
			if (newIfCaseBlock != null)
				msgs = ((InternalEObject)newIfCaseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__IF_CASE_BLOCK, null, msgs);
			msgs = basicSetIfCaseBlock(newIfCaseBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__IF_CASE_BLOCK, newIfCaseBlock, newIfCaseBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getElifCondition() {
		if (elifCondition == null) {
			elifCondition = new EObjectContainmentEList<Expression>(Expression.class, this, DblPackage.IF_STATEMENT__ELIF_CONDITION);
		}
		return elifCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeBlock> getElifCaseBlock() {
		if (elifCaseBlock == null) {
			elifCaseBlock = new EObjectContainmentEList<CodeBlock>(CodeBlock.class, this, DblPackage.IF_STATEMENT__ELIF_CASE_BLOCK);
		}
		return elifCaseBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getElseCaseBlock() {
		return elseCaseBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseCaseBlock(CodeBlock newElseCaseBlock, NotificationChain msgs) {
		CodeBlock oldElseCaseBlock = elseCaseBlock;
		elseCaseBlock = newElseCaseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK, oldElseCaseBlock, newElseCaseBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseCaseBlock(CodeBlock newElseCaseBlock) {
		if (newElseCaseBlock != elseCaseBlock) {
			NotificationChain msgs = null;
			if (elseCaseBlock != null)
				msgs = ((InternalEObject)elseCaseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK, null, msgs);
			if (newElseCaseBlock != null)
				msgs = ((InternalEObject)newElseCaseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK, null, msgs);
			msgs = basicSetElseCaseBlock(newElseCaseBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK, newElseCaseBlock, newElseCaseBlock));
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
			case DblPackage.IF_STATEMENT__IF_CASE_BLOCK:
				return basicSetIfCaseBlock(null, msgs);
			case DblPackage.IF_STATEMENT__ELIF_CONDITION:
				return ((InternalEList<?>)getElifCondition()).basicRemove(otherEnd, msgs);
			case DblPackage.IF_STATEMENT__ELIF_CASE_BLOCK:
				return ((InternalEList<?>)getElifCaseBlock()).basicRemove(otherEnd, msgs);
			case DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK:
				return basicSetElseCaseBlock(null, msgs);
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
			case DblPackage.IF_STATEMENT__IF_CASE_BLOCK:
				return getIfCaseBlock();
			case DblPackage.IF_STATEMENT__ELIF_CONDITION:
				return getElifCondition();
			case DblPackage.IF_STATEMENT__ELIF_CASE_BLOCK:
				return getElifCaseBlock();
			case DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK:
				return getElseCaseBlock();
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
			case DblPackage.IF_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case DblPackage.IF_STATEMENT__IF_CASE_BLOCK:
				setIfCaseBlock((CodeBlock)newValue);
				return;
			case DblPackage.IF_STATEMENT__ELIF_CONDITION:
				getElifCondition().clear();
				getElifCondition().addAll((Collection<? extends Expression>)newValue);
				return;
			case DblPackage.IF_STATEMENT__ELIF_CASE_BLOCK:
				getElifCaseBlock().clear();
				getElifCaseBlock().addAll((Collection<? extends CodeBlock>)newValue);
				return;
			case DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK:
				setElseCaseBlock((CodeBlock)newValue);
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
			case DblPackage.IF_STATEMENT__IF_CASE_BLOCK:
				setIfCaseBlock((CodeBlock)null);
				return;
			case DblPackage.IF_STATEMENT__ELIF_CONDITION:
				getElifCondition().clear();
				return;
			case DblPackage.IF_STATEMENT__ELIF_CASE_BLOCK:
				getElifCaseBlock().clear();
				return;
			case DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK:
				setElseCaseBlock((CodeBlock)null);
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
			case DblPackage.IF_STATEMENT__IF_CASE_BLOCK:
				return ifCaseBlock != null;
			case DblPackage.IF_STATEMENT__ELIF_CONDITION:
				return elifCondition != null && !elifCondition.isEmpty();
			case DblPackage.IF_STATEMENT__ELIF_CASE_BLOCK:
				return elifCaseBlock != null && !elifCaseBlock.isEmpty();
			case DblPackage.IF_STATEMENT__ELSE_CASE_BLOCK:
				return elseCaseBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //IfStatementImpl
