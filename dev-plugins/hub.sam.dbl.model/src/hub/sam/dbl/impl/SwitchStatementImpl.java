/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.SwitchCase;
import hub.sam.dbl.SwitchStatement;
import hub.sam.dbl.VariableAccess;

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
 * An implementation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.SwitchStatementImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.SwitchStatementImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.SwitchStatementImpl#getDefaultCase <em>Default Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchStatementImpl extends SimpleStatementImpl implements SwitchStatement {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableAccess variable;

	/**
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<SwitchCase> cases;

	/**
	 * The cached value of the '{@link #getDefaultCase() <em>Default Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCase()
	 * @generated
	 * @ordered
	 */
	protected SwitchCase defaultCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.SWITCH_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAccess getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable(VariableAccess newVariable, NotificationChain msgs) {
		VariableAccess oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.SWITCH_STATEMENT__VARIABLE, oldVariable, newVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(VariableAccess newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.SWITCH_STATEMENT__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.SWITCH_STATEMENT__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SWITCH_STATEMENT__VARIABLE, newVariable, newVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SwitchCase> getCases() {
		if (cases == null) {
			cases = new EObjectContainmentEList<SwitchCase>(SwitchCase.class, this, DblPackage.SWITCH_STATEMENT__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCase getDefaultCase() {
		return defaultCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultCase(SwitchCase newDefaultCase, NotificationChain msgs) {
		SwitchCase oldDefaultCase = defaultCase;
		defaultCase = newDefaultCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.SWITCH_STATEMENT__DEFAULT_CASE, oldDefaultCase, newDefaultCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultCase(SwitchCase newDefaultCase) {
		if (newDefaultCase != defaultCase) {
			NotificationChain msgs = null;
			if (defaultCase != null)
				msgs = ((InternalEObject)defaultCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.SWITCH_STATEMENT__DEFAULT_CASE, null, msgs);
			if (newDefaultCase != null)
				msgs = ((InternalEObject)newDefaultCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.SWITCH_STATEMENT__DEFAULT_CASE, null, msgs);
			msgs = basicSetDefaultCase(newDefaultCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SWITCH_STATEMENT__DEFAULT_CASE, newDefaultCase, newDefaultCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.SWITCH_STATEMENT__VARIABLE:
				return basicSetVariable(null, msgs);
			case DblPackage.SWITCH_STATEMENT__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
			case DblPackage.SWITCH_STATEMENT__DEFAULT_CASE:
				return basicSetDefaultCase(null, msgs);
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
			case DblPackage.SWITCH_STATEMENT__VARIABLE:
				return getVariable();
			case DblPackage.SWITCH_STATEMENT__CASES:
				return getCases();
			case DblPackage.SWITCH_STATEMENT__DEFAULT_CASE:
				return getDefaultCase();
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
			case DblPackage.SWITCH_STATEMENT__VARIABLE:
				setVariable((VariableAccess)newValue);
				return;
			case DblPackage.SWITCH_STATEMENT__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends SwitchCase>)newValue);
				return;
			case DblPackage.SWITCH_STATEMENT__DEFAULT_CASE:
				setDefaultCase((SwitchCase)newValue);
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
			case DblPackage.SWITCH_STATEMENT__VARIABLE:
				setVariable((VariableAccess)null);
				return;
			case DblPackage.SWITCH_STATEMENT__CASES:
				getCases().clear();
				return;
			case DblPackage.SWITCH_STATEMENT__DEFAULT_CASE:
				setDefaultCase((SwitchCase)null);
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
			case DblPackage.SWITCH_STATEMENT__VARIABLE:
				return variable != null;
			case DblPackage.SWITCH_STATEMENT__CASES:
				return cases != null && !cases.isEmpty();
			case DblPackage.SWITCH_STATEMENT__DEFAULT_CASE:
				return defaultCase != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchStatementImpl
