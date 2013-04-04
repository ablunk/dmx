/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.FindContainer;
import hub.sam.dbl.Parameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Find Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.FindContainerImpl#getVariableBinding <em>Variable Binding</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FindContainerImpl#getContainerBlock <em>Container Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FindContainerImpl#getElseBlock <em>Else Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FindContainerImpl extends StatementImpl implements FindContainer {
	/**
	 * The cached value of the '{@link #getVariableBinding() <em>Variable Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableBinding()
	 * @generated
	 * @ordered
	 */
	protected Parameter variableBinding;

	/**
	 * The cached value of the '{@link #getContainerBlock() <em>Container Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock containerBlock;

	/**
	 * The cached value of the '{@link #getElseBlock() <em>Else Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock elseBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FindContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.FIND_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getVariableBinding() {
		return variableBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableBinding(Parameter newVariableBinding, NotificationChain msgs) {
		Parameter oldVariableBinding = variableBinding;
		variableBinding = newVariableBinding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FIND_CONTAINER__VARIABLE_BINDING, oldVariableBinding, newVariableBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableBinding(Parameter newVariableBinding) {
		if (newVariableBinding != variableBinding) {
			NotificationChain msgs = null;
			if (variableBinding != null)
				msgs = ((InternalEObject)variableBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FIND_CONTAINER__VARIABLE_BINDING, null, msgs);
			if (newVariableBinding != null)
				msgs = ((InternalEObject)newVariableBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FIND_CONTAINER__VARIABLE_BINDING, null, msgs);
			msgs = basicSetVariableBinding(newVariableBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FIND_CONTAINER__VARIABLE_BINDING, newVariableBinding, newVariableBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getContainerBlock() {
		return containerBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerBlock(CodeBlock newContainerBlock, NotificationChain msgs) {
		CodeBlock oldContainerBlock = containerBlock;
		containerBlock = newContainerBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FIND_CONTAINER__CONTAINER_BLOCK, oldContainerBlock, newContainerBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerBlock(CodeBlock newContainerBlock) {
		if (newContainerBlock != containerBlock) {
			NotificationChain msgs = null;
			if (containerBlock != null)
				msgs = ((InternalEObject)containerBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FIND_CONTAINER__CONTAINER_BLOCK, null, msgs);
			if (newContainerBlock != null)
				msgs = ((InternalEObject)newContainerBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FIND_CONTAINER__CONTAINER_BLOCK, null, msgs);
			msgs = basicSetContainerBlock(newContainerBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FIND_CONTAINER__CONTAINER_BLOCK, newContainerBlock, newContainerBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getElseBlock() {
		return elseBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseBlock(CodeBlock newElseBlock, NotificationChain msgs) {
		CodeBlock oldElseBlock = elseBlock;
		elseBlock = newElseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FIND_CONTAINER__ELSE_BLOCK, oldElseBlock, newElseBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseBlock(CodeBlock newElseBlock) {
		if (newElseBlock != elseBlock) {
			NotificationChain msgs = null;
			if (elseBlock != null)
				msgs = ((InternalEObject)elseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FIND_CONTAINER__ELSE_BLOCK, null, msgs);
			if (newElseBlock != null)
				msgs = ((InternalEObject)newElseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FIND_CONTAINER__ELSE_BLOCK, null, msgs);
			msgs = basicSetElseBlock(newElseBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FIND_CONTAINER__ELSE_BLOCK, newElseBlock, newElseBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.FIND_CONTAINER__VARIABLE_BINDING:
				return basicSetVariableBinding(null, msgs);
			case DblPackage.FIND_CONTAINER__CONTAINER_BLOCK:
				return basicSetContainerBlock(null, msgs);
			case DblPackage.FIND_CONTAINER__ELSE_BLOCK:
				return basicSetElseBlock(null, msgs);
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
			case DblPackage.FIND_CONTAINER__VARIABLE_BINDING:
				return getVariableBinding();
			case DblPackage.FIND_CONTAINER__CONTAINER_BLOCK:
				return getContainerBlock();
			case DblPackage.FIND_CONTAINER__ELSE_BLOCK:
				return getElseBlock();
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
			case DblPackage.FIND_CONTAINER__VARIABLE_BINDING:
				setVariableBinding((Parameter)newValue);
				return;
			case DblPackage.FIND_CONTAINER__CONTAINER_BLOCK:
				setContainerBlock((CodeBlock)newValue);
				return;
			case DblPackage.FIND_CONTAINER__ELSE_BLOCK:
				setElseBlock((CodeBlock)newValue);
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
			case DblPackage.FIND_CONTAINER__VARIABLE_BINDING:
				setVariableBinding((Parameter)null);
				return;
			case DblPackage.FIND_CONTAINER__CONTAINER_BLOCK:
				setContainerBlock((CodeBlock)null);
				return;
			case DblPackage.FIND_CONTAINER__ELSE_BLOCK:
				setElseBlock((CodeBlock)null);
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
			case DblPackage.FIND_CONTAINER__VARIABLE_BINDING:
				return variableBinding != null;
			case DblPackage.FIND_CONTAINER__CONTAINER_BLOCK:
				return containerBlock != null;
			case DblPackage.FIND_CONTAINER__ELSE_BLOCK:
				return elseBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //FindContainerImpl
