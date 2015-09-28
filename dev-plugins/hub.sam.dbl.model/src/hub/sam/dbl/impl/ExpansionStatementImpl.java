/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpansionPart;
import hub.sam.dbl.ExpansionStatement;
import hub.sam.dbl.Expression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expansion Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpansionStatementImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpansionStatementImpl extends StatementImpl implements ExpansionStatement {
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
			case DblPackage.EXPANSION_STATEMENT__PARTS:
				return parts != null && !parts.isEmpty();
			case DblPackage.EXPANSION_STATEMENT__EXPRS:
				return exprs != null && !exprs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExpansionStatementImpl
