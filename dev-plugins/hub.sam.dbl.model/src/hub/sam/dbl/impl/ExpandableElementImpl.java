/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpression;
import hub.sam.dbl.ExpandableElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expandable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExpandableElementImpl#getExpandExpression <em>Expand Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpandableElementImpl extends EObjectImpl implements ExpandableElement {
	/**
	 * The cached value of the '{@link #getExpandExpression() <em>Expand Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpandExpression expandExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXPANDABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandExpression getExpandExpression() {
		return expandExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpandExpression(ExpandExpression newExpandExpression, NotificationChain msgs) {
		ExpandExpression oldExpandExpression = expandExpression;
		expandExpression = newExpandExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION, oldExpandExpression, newExpandExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandExpression(ExpandExpression newExpandExpression) {
		if (newExpandExpression != expandExpression) {
			NotificationChain msgs = null;
			if (expandExpression != null)
				msgs = ((InternalEObject)expandExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION, null, msgs);
			if (newExpandExpression != null)
				msgs = ((InternalEObject)newExpandExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION, null, msgs);
			msgs = basicSetExpandExpression(newExpandExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION, newExpandExpression, newExpandExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION:
				return basicSetExpandExpression(null, msgs);
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
			case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION:
				return getExpandExpression();
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
			case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION:
				setExpandExpression((ExpandExpression)newValue);
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
			case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION:
				setExpandExpression((ExpandExpression)null);
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
			case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION:
				return expandExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpandableElementImpl
