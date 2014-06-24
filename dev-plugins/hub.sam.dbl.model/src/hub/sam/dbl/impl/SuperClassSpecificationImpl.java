/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Clazz;
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
 *   <li>{@link hub.sam.dbl.impl.SuperClassSpecificationImpl#getClazz <em>Clazz</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.SuperClassSpecificationImpl#getConstructorArguments <em>Constructor Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperClassSpecificationImpl extends EObjectImpl implements SuperClassSpecification {
	/**
	 * The cached value of the '{@link #getClazz() <em>Clazz</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClazz()
	 * @generated
	 * @ordered
	 */
	protected Clazz clazz;

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
	public Clazz getClazz() {
		if (clazz != null && clazz.eIsProxy()) {
			InternalEObject oldClazz = (InternalEObject)clazz;
			clazz = (Clazz)eResolveProxy(oldClazz);
			if (clazz != oldClazz) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.SUPER_CLASS_SPECIFICATION__CLAZZ, oldClazz, clazz));
			}
		}
		return clazz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clazz basicGetClazz() {
		return clazz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClazz(Clazz newClazz) {
		Clazz oldClazz = clazz;
		clazz = newClazz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SUPER_CLASS_SPECIFICATION__CLAZZ, oldClazz, clazz));
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLAZZ:
				if (resolve) return getClazz();
				return basicGetClazz();
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLAZZ:
				setClazz((Clazz)newValue);
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLAZZ:
				setClazz((Clazz)null);
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
			case DblPackage.SUPER_CLASS_SPECIFICATION__CLAZZ:
				return clazz != null;
			case DblPackage.SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS:
				return constructorArguments != null && !constructorArguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SuperClassSpecificationImpl
