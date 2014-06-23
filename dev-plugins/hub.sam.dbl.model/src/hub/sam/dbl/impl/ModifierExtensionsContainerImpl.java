/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ModifierExtensionsContainer;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifier Extensions Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ModifierExtensionsContainerImpl#getModifierExtensions <em>Modifier Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModifierExtensionsContainerImpl extends EObjectImpl implements ModifierExtensionsContainer {
	/**
	 * The cached value of the '{@link #getModifierExtensions() <em>Modifier Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifierExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensibleElement> modifierExtensions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifierExtensionsContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensibleElement> getModifierExtensions() {
		if (modifierExtensions == null) {
			modifierExtensions = new EObjectContainmentEList<ExtensibleElement>(ExtensibleElement.class, this, DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS);
		}
		return modifierExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS:
				return ((InternalEList<?>)getModifierExtensions()).basicRemove(otherEnd, msgs);
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
			case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS:
				return getModifierExtensions();
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
			case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				getModifierExtensions().addAll((Collection<? extends ExtensibleElement>)newValue);
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
			case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
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
			case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS:
				return modifierExtensions != null && !modifierExtensions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModifierExtensionsContainerImpl
