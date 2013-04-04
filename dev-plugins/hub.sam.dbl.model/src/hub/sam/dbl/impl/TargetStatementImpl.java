/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.TargetStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.TargetStatementImpl#getCodeBlock <em>Code Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetStatementImpl extends StatementImpl implements TargetStatement {
	/**
	 * The cached value of the '{@link #getCodeBlock() <em>Code Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock codeBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.TARGET_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getCodeBlock() {
		return codeBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodeBlock(CodeBlock newCodeBlock, NotificationChain msgs) {
		CodeBlock oldCodeBlock = codeBlock;
		codeBlock = newCodeBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.TARGET_STATEMENT__CODE_BLOCK, oldCodeBlock, newCodeBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeBlock(CodeBlock newCodeBlock) {
		if (newCodeBlock != codeBlock) {
			NotificationChain msgs = null;
			if (codeBlock != null)
				msgs = ((InternalEObject)codeBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.TARGET_STATEMENT__CODE_BLOCK, null, msgs);
			if (newCodeBlock != null)
				msgs = ((InternalEObject)newCodeBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.TARGET_STATEMENT__CODE_BLOCK, null, msgs);
			msgs = basicSetCodeBlock(newCodeBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.TARGET_STATEMENT__CODE_BLOCK, newCodeBlock, newCodeBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.TARGET_STATEMENT__CODE_BLOCK:
				return basicSetCodeBlock(null, msgs);
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
			case DblPackage.TARGET_STATEMENT__CODE_BLOCK:
				return getCodeBlock();
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
			case DblPackage.TARGET_STATEMENT__CODE_BLOCK:
				setCodeBlock((CodeBlock)newValue);
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
			case DblPackage.TARGET_STATEMENT__CODE_BLOCK:
				setCodeBlock((CodeBlock)null);
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
			case DblPackage.TARGET_STATEMENT__CODE_BLOCK:
				return codeBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //TargetStatementImpl
