/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Assignment;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ForStatement;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.Statement;
import hub.sam.dbl.Variable;

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
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getTermination <em>Termination</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ForStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends LoopStatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

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
	protected Statement body;

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
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, DblPackage.FOR_STATEMENT__STATEMENTS);
		}
		return statements;
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
	public Statement getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Statement newBody, NotificationChain msgs) {
		Statement oldBody = body;
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
	public void setBody(Statement newBody) {
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
			case DblPackage.FOR_STATEMENT__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
			case DblPackage.FOR_STATEMENT__STATEMENTS:
				return getStatements();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DblPackage.FOR_STATEMENT__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case DblPackage.FOR_STATEMENT__TERMINATION:
				setTermination((Expression)newValue);
				return;
			case DblPackage.FOR_STATEMENT__INCREMENT:
				setIncrement((Assignment)newValue);
				return;
			case DblPackage.FOR_STATEMENT__BODY:
				setBody((Statement)newValue);
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
			case DblPackage.FOR_STATEMENT__STATEMENTS:
				getStatements().clear();
				return;
			case DblPackage.FOR_STATEMENT__TERMINATION:
				setTermination((Expression)null);
				return;
			case DblPackage.FOR_STATEMENT__INCREMENT:
				setIncrement((Assignment)null);
				return;
			case DblPackage.FOR_STATEMENT__BODY:
				setBody((Statement)null);
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
			case DblPackage.FOR_STATEMENT__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case DblPackage.FOR_STATEMENT__TERMINATION:
				return termination != null;
			case DblPackage.FOR_STATEMENT__INCREMENT:
				return increment != null;
			case DblPackage.FOR_STATEMENT__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == LocalScope.class) {
			switch (derivedFeatureID) {
				case DblPackage.FOR_STATEMENT__STATEMENTS: return DblPackage.LOCAL_SCOPE__STATEMENTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == LocalScope.class) {
			switch (baseFeatureID) {
				case DblPackage.LOCAL_SCOPE__STATEMENTS: return DblPackage.FOR_STATEMENT__STATEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ForStatementImpl
