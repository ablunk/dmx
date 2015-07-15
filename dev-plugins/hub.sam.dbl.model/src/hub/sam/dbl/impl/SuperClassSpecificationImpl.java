/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.SuperClassSpecification;

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
 * An implementation of the model object '<em><b>Super Class Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.SuperClassSpecificationImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.SuperClassSpecificationImpl#getConstructorArguments <em>Constructor Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperClassSpecificationImpl extends EObjectImpl implements SuperClassSpecification {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected hub.sam.dbl.Class class_;

	/**
	 * The cached value of the '{@link #getConstructorArguments() <em>Constructor Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructorArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> constructorArguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperClassSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.SUPER_CLASS_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public hub.sam.dbl.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (hub.sam.dbl.Class)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.SUPER_CLASS_SPECIFICATION__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public hub.sam.dbl.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(hub.sam.dbl.Class newClass) {
		hub.sam.dbl.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SUPER_CLASS_SPECIFICATION__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getConstructorArguments() {
		if (constructorArguments == null) {
			constructorArguments = new EObjectContainmentEList<Expression>(Expression.class, this, DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS);
		}
		return constructorArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS:
				return ((InternalEList<?>)getConstructorArguments()).basicRemove(otherEnd, msgs);
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS:
				return getConstructorArguments();
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLASS:
				setClass((hub.sam.dbl.Class)newValue);
				return;
			case DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS:
				getConstructorArguments().clear();
				getConstructorArguments().addAll((Collection<? extends Expression>)newValue);
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLASS:
				setClass((hub.sam.dbl.Class)null);
				return;
			case DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS:
				getConstructorArguments().clear();
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLASS:
				return class_ != null;
			case DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS:
				return constructorArguments != null && !constructorArguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SuperClassSpecificationImpl
