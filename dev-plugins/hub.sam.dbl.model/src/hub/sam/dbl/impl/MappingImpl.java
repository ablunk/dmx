/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.Mapping;
import hub.sam.dbl.MappingPart;

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
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.MappingImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.MappingImpl#getMetaObject <em>Meta Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends CodeBlockImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingPart> parts;

	/**
	 * The cached value of the '{@link #getMetaObject() <em>Meta Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaObject()
	 * @generated
	 * @ordered
	 */
	protected Expression metaObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingPart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<MappingPart>(MappingPart.class, this, DblPackage.MAPPING__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getMetaObject() {
		return metaObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaObject(Expression newMetaObject, NotificationChain msgs) {
		Expression oldMetaObject = metaObject;
		metaObject = newMetaObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.MAPPING__META_OBJECT, oldMetaObject, newMetaObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaObject(Expression newMetaObject) {
		if (newMetaObject != metaObject) {
			NotificationChain msgs = null;
			if (metaObject != null)
				msgs = ((InternalEObject)metaObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.MAPPING__META_OBJECT, null, msgs);
			if (newMetaObject != null)
				msgs = ((InternalEObject)newMetaObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.MAPPING__META_OBJECT, null, msgs);
			msgs = basicSetMetaObject(newMetaObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.MAPPING__META_OBJECT, newMetaObject, newMetaObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.MAPPING__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case DblPackage.MAPPING__META_OBJECT:
				return basicSetMetaObject(null, msgs);
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
			case DblPackage.MAPPING__PARTS:
				return getParts();
			case DblPackage.MAPPING__META_OBJECT:
				return getMetaObject();
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
			case DblPackage.MAPPING__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends MappingPart>)newValue);
				return;
			case DblPackage.MAPPING__META_OBJECT:
				setMetaObject((Expression)newValue);
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
			case DblPackage.MAPPING__PARTS:
				getParts().clear();
				return;
			case DblPackage.MAPPING__META_OBJECT:
				setMetaObject((Expression)null);
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
			case DblPackage.MAPPING__PARTS:
				return parts != null && !parts.isEmpty();
			case DblPackage.MAPPING__META_OBJECT:
				return metaObject != null;
		}
		return super.eIsSet(featureID);
	}

} //MappingImpl
