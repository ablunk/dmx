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
import hub.sam.dbl.ForEachStatement;
import hub.sam.dbl.Variable;
import hub.sam.dbl.VariableAccess;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Each Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ForEachStatementImpl#getIteratorVariableDefinition <em>Iterator Variable Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForEachStatementImpl#getIteratorVariableReference <em>Iterator Variable Reference</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForEachStatementImpl#getIterableExpression <em>Iterable Expression</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForEachStatementImpl#getForBlock <em>For Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForEachStatementImpl extends CompositeStatementImpl implements ForEachStatement {
	/**
	 * The cached value of the '{@link #getIteratorVariableDefinition() <em>Iterator Variable Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteratorVariableDefinition()
	 * @generated
	 * @ordered
	 */
	protected Variable iteratorVariableDefinition;

	/**
	 * The cached value of the '{@link #getIteratorVariableReference() <em>Iterator Variable Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteratorVariableReference()
	 * @generated
	 * @ordered
	 */
	protected VariableAccess iteratorVariableReference;

	/**
	 * The cached value of the '{@link #getIterableExpression() <em>Iterable Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterableExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression iterableExpression;

	/**
	 * The cached value of the '{@link #getForBlock() <em>For Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForBlock()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock forBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForEachStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.FOR_EACH_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getIteratorVariableDefinition() {
		return iteratorVariableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIteratorVariableDefinition(Variable newIteratorVariableDefinition, NotificationChain msgs) {
		Variable oldIteratorVariableDefinition = iteratorVariableDefinition;
		iteratorVariableDefinition = newIteratorVariableDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION, oldIteratorVariableDefinition, newIteratorVariableDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteratorVariableDefinition(Variable newIteratorVariableDefinition) {
		if (newIteratorVariableDefinition != iteratorVariableDefinition) {
			NotificationChain msgs = null;
			if (iteratorVariableDefinition != null)
				msgs = ((InternalEObject)iteratorVariableDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION, null, msgs);
			if (newIteratorVariableDefinition != null)
				msgs = ((InternalEObject)newIteratorVariableDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION, null, msgs);
			msgs = basicSetIteratorVariableDefinition(newIteratorVariableDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION, newIteratorVariableDefinition, newIteratorVariableDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAccess getIteratorVariableReference() {
		return iteratorVariableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIteratorVariableReference(VariableAccess newIteratorVariableReference, NotificationChain msgs) {
		VariableAccess oldIteratorVariableReference = iteratorVariableReference;
		iteratorVariableReference = newIteratorVariableReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE, oldIteratorVariableReference, newIteratorVariableReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteratorVariableReference(VariableAccess newIteratorVariableReference) {
		if (newIteratorVariableReference != iteratorVariableReference) {
			NotificationChain msgs = null;
			if (iteratorVariableReference != null)
				msgs = ((InternalEObject)iteratorVariableReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE, null, msgs);
			if (newIteratorVariableReference != null)
				msgs = ((InternalEObject)newIteratorVariableReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE, null, msgs);
			msgs = basicSetIteratorVariableReference(newIteratorVariableReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE, newIteratorVariableReference, newIteratorVariableReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIterableExpression() {
		return iterableExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterableExpression(Expression newIterableExpression, NotificationChain msgs) {
		Expression oldIterableExpression = iterableExpression;
		iterableExpression = newIterableExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION, oldIterableExpression, newIterableExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterableExpression(Expression newIterableExpression) {
		if (newIterableExpression != iterableExpression) {
			NotificationChain msgs = null;
			if (iterableExpression != null)
				msgs = ((InternalEObject)iterableExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION, null, msgs);
			if (newIterableExpression != null)
				msgs = ((InternalEObject)newIterableExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION, null, msgs);
			msgs = basicSetIterableExpression(newIterableExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION, newIterableExpression, newIterableExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getForBlock() {
		return forBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForBlock(CodeBlock newForBlock, NotificationChain msgs) {
		CodeBlock oldForBlock = forBlock;
		forBlock = newForBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK, oldForBlock, newForBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForBlock(CodeBlock newForBlock) {
		if (newForBlock != forBlock) {
			NotificationChain msgs = null;
			if (forBlock != null)
				msgs = ((InternalEObject)forBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK, null, msgs);
			if (newForBlock != null)
				msgs = ((InternalEObject)newForBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK, null, msgs);
			msgs = basicSetForBlock(newForBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK, newForBlock, newForBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION:
				return basicSetIteratorVariableDefinition(null, msgs);
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE:
				return basicSetIteratorVariableReference(null, msgs);
			case DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION:
				return basicSetIterableExpression(null, msgs);
			case DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK:
				return basicSetForBlock(null, msgs);
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
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION:
				return getIteratorVariableDefinition();
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE:
				return getIteratorVariableReference();
			case DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION:
				return getIterableExpression();
			case DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK:
				return getForBlock();
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
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION:
				setIteratorVariableDefinition((Variable)newValue);
				return;
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE:
				setIteratorVariableReference((VariableAccess)newValue);
				return;
			case DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION:
				setIterableExpression((Expression)newValue);
				return;
			case DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK:
				setForBlock((CodeBlock)newValue);
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
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION:
				setIteratorVariableDefinition((Variable)null);
				return;
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE:
				setIteratorVariableReference((VariableAccess)null);
				return;
			case DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION:
				setIterableExpression((Expression)null);
				return;
			case DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK:
				setForBlock((CodeBlock)null);
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
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION:
				return iteratorVariableDefinition != null;
			case DblPackage.FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE:
				return iteratorVariableReference != null;
			case DblPackage.FOR_EACH_STATEMENT__ITERABLE_EXPRESSION:
				return iterableExpression != null;
			case DblPackage.FOR_EACH_STATEMENT__FOR_BLOCK:
				return forBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //ForEachStatementImpl
