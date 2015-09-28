/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.PrimitiveType;
import hub.sam.dbl.TypedElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.TypedElementImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.TypedElementImpl#getTypeArrayDimensions <em>Type Array Dimensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.TypedElementImpl#getClassifierType <em>Classifier Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TypedElementImpl extends EObjectImpl implements TypedElement {
	/**
	 * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveType primitiveType;

	/**
	 * The cached value of the '{@link #getTypeArrayDimensions() <em>Type Array Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArrayDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayDimension> typeArrayDimensions;

	/**
	 * The cached value of the '{@link #getClassifierType() <em>Classifier Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierType()
	 * @generated
	 * @ordered
	 */
	protected IdExpr classifierType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.TYPED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getPrimitiveType() {
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimitiveType(PrimitiveType newPrimitiveType, NotificationChain msgs) {
		PrimitiveType oldPrimitiveType = primitiveType;
		primitiveType = newPrimitiveType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveType(PrimitiveType newPrimitiveType) {
		if (newPrimitiveType != primitiveType) {
			NotificationChain msgs = null;
			if (primitiveType != null)
				msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE, null, msgs);
			if (newPrimitiveType != null)
				msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE, null, msgs);
			msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getTypeArrayDimensions() {
		if (typeArrayDimensions == null) {
			typeArrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS);
		}
		return typeArrayDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getClassifierType() {
		return classifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassifierType(IdExpr newClassifierType, NotificationChain msgs) {
		IdExpr oldClassifierType = classifierType;
		classifierType = newClassifierType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE, oldClassifierType, newClassifierType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifierType(IdExpr newClassifierType) {
		if (newClassifierType != classifierType) {
			NotificationChain msgs = null;
			if (classifierType != null)
				msgs = ((InternalEObject)classifierType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE, null, msgs);
			if (newClassifierType != null)
				msgs = ((InternalEObject)newClassifierType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE, null, msgs);
			msgs = basicSetClassifierType(newClassifierType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE, newClassifierType, newClassifierType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE:
				return basicSetPrimitiveType(null, msgs);
			case DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS:
				return ((InternalEList<?>)getTypeArrayDimensions()).basicRemove(otherEnd, msgs);
			case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE:
				return basicSetClassifierType(null, msgs);
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
			case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE:
				return getPrimitiveType();
			case DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS:
				return getTypeArrayDimensions();
			case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE:
				return getClassifierType();
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
			case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE:
				setPrimitiveType((PrimitiveType)newValue);
				return;
			case DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS:
				getTypeArrayDimensions().clear();
				getTypeArrayDimensions().addAll((Collection<? extends ArrayDimension>)newValue);
				return;
			case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE:
				setClassifierType((IdExpr)newValue);
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
			case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE:
				setPrimitiveType((PrimitiveType)null);
				return;
			case DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS:
				getTypeArrayDimensions().clear();
				return;
			case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE:
				setClassifierType((IdExpr)null);
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
			case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE:
				return primitiveType != null;
			case DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS:
				return typeArrayDimensions != null && !typeArrayDimensions.isEmpty();
			case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE:
				return classifierType != null;
		}
		return super.eIsSet(featureID);
	}

} //TypedElementImpl
