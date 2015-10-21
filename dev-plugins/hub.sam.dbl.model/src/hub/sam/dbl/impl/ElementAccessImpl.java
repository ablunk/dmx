/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ElementAccess;
import hub.sam.dbl.IdExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ElementAccessImpl#getIdExpr <em>Id Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementAccessImpl extends ExpressionImpl implements ElementAccess {
	/**
	 * The cached value of the '{@link #getIdExpr() <em>Id Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdExpr()
	 * @generated
	 * @ordered
	 */
	protected IdExpr idExpr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.ELEMENT_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getIdExpr() {
		return idExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdExpr(IdExpr newIdExpr, NotificationChain msgs) {
		IdExpr oldIdExpr = idExpr;
		idExpr = newIdExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.ELEMENT_ACCESS__ID_EXPR, oldIdExpr, newIdExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdExpr(IdExpr newIdExpr) {
		if (newIdExpr != idExpr) {
			NotificationChain msgs = null;
			if (idExpr != null)
				msgs = ((InternalEObject)idExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.ELEMENT_ACCESS__ID_EXPR, null, msgs);
			if (newIdExpr != null)
				msgs = ((InternalEObject)newIdExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.ELEMENT_ACCESS__ID_EXPR, null, msgs);
			msgs = basicSetIdExpr(newIdExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ELEMENT_ACCESS__ID_EXPR, newIdExpr, newIdExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.ELEMENT_ACCESS__ID_EXPR:
				return basicSetIdExpr(null, msgs);
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
			case DblPackage.ELEMENT_ACCESS__ID_EXPR:
				return getIdExpr();
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
			case DblPackage.ELEMENT_ACCESS__ID_EXPR:
				setIdExpr((IdExpr)newValue);
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
			case DblPackage.ELEMENT_ACCESS__ID_EXPR:
				setIdExpr((IdExpr)null);
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
			case DblPackage.ELEMENT_ACCESS__ID_EXPR:
				return idExpr != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementAccessImpl
