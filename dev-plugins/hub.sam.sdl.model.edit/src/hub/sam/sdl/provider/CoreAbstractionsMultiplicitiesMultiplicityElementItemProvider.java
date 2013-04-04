/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement;
import hub.sam.sdl.EmfSdlPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.sdl.CoreAbstractionsMultiplicitiesMultiplicityElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreAbstractionsMultiplicitiesMultiplicityElementItemProvider
	extends CoreAbstractionsElementsElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsMultiplicitiesMultiplicityElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIsOrderedPropertyDescriptor(object);
			addIsUniquePropertyDescriptor(object);
			addLowerPropertyDescriptor(object);
			addUpperPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Ordered feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsOrderedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_isOrdered_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_isOrdered_feature", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsMultiplicitiesMultiplicityElement_IsOrdered(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Unique feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsUniquePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_isUnique_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_isUnique_feature", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsMultiplicitiesMultiplicityElement_IsUnique(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lower feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLowerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_lower_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_lower_feature", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsMultiplicitiesMultiplicityElement_Lower(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Upper feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpperPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_upper_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_upper_feature", "_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsMultiplicitiesMultiplicityElement_Upper(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		CoreAbstractionsMultiplicitiesMultiplicityElement coreAbstractionsMultiplicitiesMultiplicityElement = (CoreAbstractionsMultiplicitiesMultiplicityElement)object;
		return getString("_UI_CoreAbstractionsMultiplicitiesMultiplicityElement_type") + " " + coreAbstractionsMultiplicitiesMultiplicityElement.getLine();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CoreAbstractionsMultiplicitiesMultiplicityElement.class)) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_ORDERED:
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__IS_UNIQUE:
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__LOWER:
			case EmfSdlPackage.CORE_ABSTRACTIONS_MULTIPLICITIES_MULTIPLICITY_ELEMENT__UPPER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
