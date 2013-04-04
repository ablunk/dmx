/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ConsiderIdElements;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consider Id Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ConsiderIdElementsImpl#getElementsQuery <em>Elements Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConsiderIdElementsImpl extends StatementImpl implements ConsiderIdElements {
	/**
	 * The cached value of the '{@link #getElementsQuery() <em>Elements Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementsQuery()
	 * @generated
	 * @ordered
	 */
	protected Expression elementsQuery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsiderIdElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.CONSIDER_ID_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getElementsQuery() {
		return elementsQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementsQuery(Expression newElementsQuery, NotificationChain msgs) {
		Expression oldElementsQuery = elementsQuery;
		elementsQuery = newElementsQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY, oldElementsQuery, newElementsQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementsQuery(Expression newElementsQuery) {
		if (newElementsQuery != elementsQuery) {
			NotificationChain msgs = null;
			if (elementsQuery != null)
				msgs = ((InternalEObject)elementsQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY, null, msgs);
			if (newElementsQuery != null)
				msgs = ((InternalEObject)newElementsQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY, null, msgs);
			msgs = basicSetElementsQuery(newElementsQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY, newElementsQuery, newElementsQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY:
				return basicSetElementsQuery(null, msgs);
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
			case DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY:
				return getElementsQuery();
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
			case DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY:
				setElementsQuery((Expression)newValue);
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
			case DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY:
				setElementsQuery((Expression)null);
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
			case DblPackage.CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY:
				return elementsQuery != null;
		}
		return super.eIsSet(featureID);
	}

} //ConsiderIdElementsImpl
