/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Assignment;
import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ForStatement;
import hub.sam.dbl.Statement;
import hub.sam.dbl.Variable;
import hub.sam.dbl.VariableAccess;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getCountVariableDefinition <em>Count Variable Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getCountVariableReference <em>Count Variable Reference</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getTermination <em>Termination</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends CompositeStatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getCountVariableDefinition() <em>Count Variable Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountVariableDefinition()
	 * @generated
	 * @ordered
	 */
	protected Variable countVariableDefinition;

	/**
	 * The cached value of the '{@link #getCountVariableReference() <em>Count Variable Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountVariableReference()
	 * @generated
	 * @ordered
	 */
	protected Assignment countVariableReference;

	/**
	 * The cached value of the '{@link #getTermination() <em>Termination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTermination()
	 * @generated
	 * @ordered
	 */
	protected Expression termination;

	/**
	 * The cached value of the '{@link #getIncrement() <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected Assignment increment;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getCountVariableDefinition() {
		return countVariableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCountVariableDefinition(Variable newCountVariableDefinition, NotificationChain msgs) {
		Variable oldCountVariableDefinition = countVariableDefinition;
		countVariableDefinition = newCountVariableDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION, oldCountVariableDefinition, newCountVariableDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountVariableDefinition(Variable newCountVariableDefinition) {
		if (newCountVariableDefinition != countVariableDefinition) {
			NotificationChain msgs = null;
			if (countVariableDefinition != null)
				msgs = ((InternalEObject)countVariableDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION, null, msgs);
			if (newCountVariableDefinition != null)
				msgs = ((InternalEObject)newCountVariableDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION, null, msgs);
			msgs = basicSetCountVariableDefinition(newCountVariableDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION, newCountVariableDefinition, newCountVariableDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment getCountVariableReference() {
		return countVariableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCountVariableReference(Assignment newCountVariableReference, NotificationChain msgs) {
		Assignment oldCountVariableReference = countVariableReference;
		countVariableReference = newCountVariableReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE, oldCountVariableReference, newCountVariableReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountVariableReference(Assignment newCountVariableReference) {
		if (newCountVariableReference != countVariableReference) {
			NotificationChain msgs = null;
			if (countVariableReference != null)
				msgs = ((InternalEObject)countVariableReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE, null, msgs);
			if (newCountVariableReference != null)
				msgs = ((InternalEObject)newCountVariableReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE, null, msgs);
			msgs = basicSetCountVariableReference(newCountVariableReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE, newCountVariableReference, newCountVariableReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTermination() {
		return termination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTermination(Expression newTermination, NotificationChain msgs) {
		Expression oldTermination = termination;
		termination = newTermination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__TERMINATION, oldTermination, newTermination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTermination(Expression newTermination) {
		if (newTermination != termination) {
			NotificationChain msgs = null;
			if (termination != null)
				msgs = ((InternalEObject)termination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__TERMINATION, null, msgs);
			if (newTermination != null)
				msgs = ((InternalEObject)newTermination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__TERMINATION, null, msgs);
			msgs = basicSetTermination(newTermination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__TERMINATION, newTermination, newTermination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment getIncrement() {
		return increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncrement(Assignment newIncrement, NotificationChain msgs) {
		Assignment oldIncrement = increment;
		increment = newIncrement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__INCREMENT, oldIncrement, newIncrement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(Assignment newIncrement) {
		if (newIncrement != increment) {
			NotificationChain msgs = null;
			if (increment != null)
				msgs = ((InternalEObject)increment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__INCREMENT, null, msgs);
			if (newIncrement != null)
				msgs = ((InternalEObject)newIncrement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__INCREMENT, null, msgs);
			msgs = basicSetIncrement(newIncrement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__INCREMENT, newIncrement, newIncrement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(CodeBlock newBody, NotificationChain msgs) {
		CodeBlock oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(CodeBlock newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FOR_STATEMENT__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FOR_STATEMENT__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION:
				return basicSetCountVariableDefinition(null, msgs);
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE:
				return basicSetCountVariableReference(null, msgs);
			case DblPackage.FOR_STATEMENT__TERMINATION:
				return basicSetTermination(null, msgs);
			case DblPackage.FOR_STATEMENT__INCREMENT:
				return basicSetIncrement(null, msgs);
			case DblPackage.FOR_STATEMENT__BODY:
				return basicSetBody(null, msgs);
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
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION:
				return getCountVariableDefinition();
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE:
				return getCountVariableReference();
			case DblPackage.FOR_STATEMENT__TERMINATION:
				return getTermination();
			case DblPackage.FOR_STATEMENT__INCREMENT:
				return getIncrement();
			case DblPackage.FOR_STATEMENT__BODY:
				return getBody();
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
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION:
				setCountVariableDefinition((Variable)newValue);
				return;
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE:
				setCountVariableReference((Assignment)newValue);
				return;
			case DblPackage.FOR_STATEMENT__TERMINATION:
				setTermination((Expression)newValue);
				return;
			case DblPackage.FOR_STATEMENT__INCREMENT:
				setIncrement((Assignment)newValue);
				return;
			case DblPackage.FOR_STATEMENT__BODY:
				setBody((CodeBlock)newValue);
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
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION:
				setCountVariableDefinition((Variable)null);
				return;
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE:
				setCountVariableReference((Assignment)null);
				return;
			case DblPackage.FOR_STATEMENT__TERMINATION:
				setTermination((Expression)null);
				return;
			case DblPackage.FOR_STATEMENT__INCREMENT:
				setIncrement((Assignment)null);
				return;
			case DblPackage.FOR_STATEMENT__BODY:
				setBody((CodeBlock)null);
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
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_DEFINITION:
				return countVariableDefinition != null;
			case DblPackage.FOR_STATEMENT__COUNT_VARIABLE_REFERENCE:
				return countVariableReference != null;
			case DblPackage.FOR_STATEMENT__TERMINATION:
				return termination != null;
			case DblPackage.FOR_STATEMENT__INCREMENT:
				return increment != null;
			case DblPackage.FOR_STATEMENT__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
