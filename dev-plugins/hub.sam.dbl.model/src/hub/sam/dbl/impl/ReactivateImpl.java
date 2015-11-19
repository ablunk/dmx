/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.Reactivate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reactivate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ReactivateImpl#getObjectAccess <em>Object Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReactivateImpl extends SimpleStatementImpl implements Reactivate {
	/**
	 * The cached value of the '{@link #getObjectAccess() <em>Object Access</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectAccess()
	 * @generated
	 * @ordered
	 */
	protected Expression objectAccess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReactivateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.REACTIVATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getObjectAccess() {
		return objectAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjectAccess(Expression newObjectAccess, NotificationChain msgs) {
		Expression oldObjectAccess = objectAccess;
		objectAccess = newObjectAccess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.REACTIVATE__OBJECT_ACCESS, oldObjectAccess, newObjectAccess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectAccess(Expression newObjectAccess) {
		if (newObjectAccess != objectAccess) {
			NotificationChain msgs = null;
			if (objectAccess != null)
				msgs = ((InternalEObject)objectAccess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.REACTIVATE__OBJECT_ACCESS, null, msgs);
			if (newObjectAccess != null)
				msgs = ((InternalEObject)newObjectAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.REACTIVATE__OBJECT_ACCESS, null, msgs);
			msgs = basicSetObjectAccess(newObjectAccess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.REACTIVATE__OBJECT_ACCESS, newObjectAccess, newObjectAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.REACTIVATE__OBJECT_ACCESS:
				return basicSetObjectAccess(null, msgs);
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
			case DblPackage.REACTIVATE__OBJECT_ACCESS:
				return getObjectAccess();
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
			case DblPackage.REACTIVATE__OBJECT_ACCESS:
				setObjectAccess((Expression)newValue);
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
			case DblPackage.REACTIVATE__OBJECT_ACCESS:
				setObjectAccess((Expression)null);
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
			case DblPackage.REACTIVATE__OBJECT_ACCESS:
				return objectAccess != null;
		}
		return super.eIsSet(featureID);
	}

} //ReactivateImpl
