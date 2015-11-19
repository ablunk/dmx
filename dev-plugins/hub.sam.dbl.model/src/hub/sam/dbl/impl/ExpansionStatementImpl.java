/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpansionPart;
import hub.sam.dbl.ExpansionStatement;
import hub.sam.dbl.Expression;

import hub.sam.dbl.IdExpr;
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
 * An implementation of the model object '<em><b>Expansion Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#isClassContext <em>Class Context</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#isFunctionContext <em>Function Context</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#isVariableContext <em>Variable Context</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#getDifferingContext <em>Differing Context</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpansionStatementImpl extends SimpleStatementImpl implements ExpansionStatement {
	/**
	 * The default value of the '{@link #isClassContext() <em>Class Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClassContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLASS_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClassContext() <em>Class Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClassContext()
	 * @generated
	 * @ordered
	 */
	protected boolean classContext = CLASS_CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isFunctionContext() <em>Function Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctionContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUNCTION_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFunctionContext() <em>Function Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFunctionContext()
	 * @generated
	 * @ordered
	 */
	protected boolean functionContext = FUNCTION_CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isVariableContext() <em>Variable Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariableContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VARIABLE_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVariableContext() <em>Variable Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariableContext()
	 * @generated
	 * @ordered
	 */
	protected boolean variableContext = VARIABLE_CONTEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDifferingContext() <em>Differing Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDifferingContext()
	 * @generated
	 * @ordered
	 */
	protected IdExpr differingContext;

	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpansionPart> parts;

	/**
	 * The cached value of the '{@link #getExprs() <em>Exprs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> exprs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpansionStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXPANSION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClassContext() {
		return classContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassContext(boolean newClassContext) {
		boolean oldClassContext = classContext;
		classContext = newClassContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPANSION_STATEMENT__CLASS_CONTEXT, oldClassContext, classContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFunctionContext() {
		return functionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionContext(boolean newFunctionContext) {
		boolean oldFunctionContext = functionContext;
		functionContext = newFunctionContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPANSION_STATEMENT__FUNCTION_CONTEXT, oldFunctionContext, functionContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVariableContext() {
		return variableContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableContext(boolean newVariableContext) {
		boolean oldVariableContext = variableContext;
		variableContext = newVariableContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPANSION_STATEMENT__VARIABLE_CONTEXT, oldVariableContext, variableContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getDifferingContext() {
		return differingContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDifferingContext(IdExpr newDifferingContext, NotificationChain msgs) {
		IdExpr oldDifferingContext = differingContext;
		differingContext = newDifferingContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT, oldDifferingContext, newDifferingContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDifferingContext(IdExpr newDifferingContext) {
		if (newDifferingContext != differingContext) {
			NotificationChain msgs = null;
			if (differingContext != null)
				msgs = ((InternalEObject)differingContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT, null, msgs);
			if (newDifferingContext != null)
				msgs = ((InternalEObject)newDifferingContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT, null, msgs);
			msgs = basicSetDifferingContext(newDifferingContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT, newDifferingContext, newDifferingContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpansionPart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<ExpansionPart>(ExpansionPart.class, this, DblPackage.EXPANSION_STATEMENT__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getExprs() {
		if (exprs == null) {
			exprs = new EObjectContainmentEList<Expression>(Expression.class, this, DblPackage.EXPANSION_STATEMENT__EXPRS);
		}
		return exprs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT:
				return basicSetDifferingContext(null, msgs);
			case DblPackage.EXPANSION_STATEMENT__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case DblPackage.EXPANSION_STATEMENT__EXPRS:
				return ((InternalEList<?>)getExprs()).basicRemove(otherEnd, msgs);
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
			case DblPackage.EXPANSION_STATEMENT__CLASS_CONTEXT:
				return isClassContext();
			case DblPackage.EXPANSION_STATEMENT__FUNCTION_CONTEXT:
				return isFunctionContext();
			case DblPackage.EXPANSION_STATEMENT__VARIABLE_CONTEXT:
				return isVariableContext();
			case DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT:
				return getDifferingContext();
			case DblPackage.EXPANSION_STATEMENT__PARTS:
				return getParts();
			case DblPackage.EXPANSION_STATEMENT__EXPRS:
				return getExprs();
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
			case DblPackage.EXPANSION_STATEMENT__CLASS_CONTEXT:
				setClassContext((Boolean)newValue);
				return;
			case DblPackage.EXPANSION_STATEMENT__FUNCTION_CONTEXT:
				setFunctionContext((Boolean)newValue);
				return;
			case DblPackage.EXPANSION_STATEMENT__VARIABLE_CONTEXT:
				setVariableContext((Boolean)newValue);
				return;
			case DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT:
				setDifferingContext((IdExpr)newValue);
				return;
			case DblPackage.EXPANSION_STATEMENT__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends ExpansionPart>)newValue);
				return;
			case DblPackage.EXPANSION_STATEMENT__EXPRS:
				getExprs().clear();
				getExprs().addAll((Collection<? extends Expression>)newValue);
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
			case DblPackage.EXPANSION_STATEMENT__CLASS_CONTEXT:
				setClassContext(CLASS_CONTEXT_EDEFAULT);
				return;
			case DblPackage.EXPANSION_STATEMENT__FUNCTION_CONTEXT:
				setFunctionContext(FUNCTION_CONTEXT_EDEFAULT);
				return;
			case DblPackage.EXPANSION_STATEMENT__VARIABLE_CONTEXT:
				setVariableContext(VARIABLE_CONTEXT_EDEFAULT);
				return;
			case DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT:
				setDifferingContext((IdExpr)null);
				return;
			case DblPackage.EXPANSION_STATEMENT__PARTS:
				getParts().clear();
				return;
			case DblPackage.EXPANSION_STATEMENT__EXPRS:
				getExprs().clear();
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
			case DblPackage.EXPANSION_STATEMENT__CLASS_CONTEXT:
				return classContext != CLASS_CONTEXT_EDEFAULT;
			case DblPackage.EXPANSION_STATEMENT__FUNCTION_CONTEXT:
				return functionContext != FUNCTION_CONTEXT_EDEFAULT;
			case DblPackage.EXPANSION_STATEMENT__VARIABLE_CONTEXT:
				return variableContext != VARIABLE_CONTEXT_EDEFAULT;
			case DblPackage.EXPANSION_STATEMENT__DIFFERING_CONTEXT:
				return differingContext != null;
			case DblPackage.EXPANSION_STATEMENT__PARTS:
				return parts != null && !parts.isEmpty();
			case DblPackage.EXPANSION_STATEMENT__EXPRS:
				return exprs != null && !exprs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (classContext: ");
		result.append(classContext);
		result.append(", functionContext: ");
		result.append(functionContext);
		result.append(", variableContext: ");
		result.append(variableContext);
		result.append(')');
		return result.toString();
	}

} //ExpansionStatementImpl
