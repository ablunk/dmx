/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.AddToSet;
import hub.sam.dbl.ArgumentExpression;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add To Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.AddToSetImpl#getAtIndex <em>At Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddToSetImpl extends SetStatementImpl implements AddToSet {
	/**
	 * The cached value of the '{@link #getAtIndex() <em>At Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtIndex()
	 * @generated
	 * @ordered
	 */
	protected ArgumentExpression atIndex;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddToSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.ADD_TO_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgumentExpression getAtIndex() {
		return atIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAtIndex(ArgumentExpression newAtIndex, NotificationChain msgs) {
		ArgumentExpression oldAtIndex = atIndex;
		atIndex = newAtIndex;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.ADD_TO_SET__AT_INDEX, oldAtIndex, newAtIndex);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtIndex(ArgumentExpression newAtIndex) {
		if (newAtIndex != atIndex) {
			NotificationChain msgs = null;
			if (atIndex != null)
				msgs = ((InternalEObject)atIndex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.ADD_TO_SET__AT_INDEX, null, msgs);
			if (newAtIndex != null)
				msgs = ((InternalEObject)newAtIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.ADD_TO_SET__AT_INDEX, null, msgs);
			msgs = basicSetAtIndex(newAtIndex, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ADD_TO_SET__AT_INDEX, newAtIndex, newAtIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.ADD_TO_SET__AT_INDEX:
				return basicSetAtIndex(null, msgs);
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
			case DblPackage.ADD_TO_SET__AT_INDEX:
				return getAtIndex();
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
			case DblPackage.ADD_TO_SET__AT_INDEX:
				setAtIndex((ArgumentExpression)newValue);
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
			case DblPackage.ADD_TO_SET__AT_INDEX:
				setAtIndex((ArgumentExpression)null);
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
			case DblPackage.ADD_TO_SET__AT_INDEX:
				return atIndex != null;
		}
		return super.eIsSet(featureID);
	}

} //AddToSetImpl
