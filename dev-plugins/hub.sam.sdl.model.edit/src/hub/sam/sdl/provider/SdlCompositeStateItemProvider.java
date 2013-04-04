/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlCompositeState;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.sdl.SdlCompositeState} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SdlCompositeStateItemProvider
	extends CoreAbstractionsTypedElementsTypedElementItemProvider
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
	public SdlCompositeStateItemProvider(AdapterFactory adapterFactory) {
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

			addFeaturingClassifierPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Featuring Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturingClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsClassifiersFeature_featuringClassifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsClassifiersFeature_featuringClassifier_feature", "_UI_CoreAbstractionsClassifiersFeature_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsClassifiersFeature_FeaturingClassifier(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SdlCompositeState_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SdlCompositeState_type_feature", "_UI_SdlCompositeState_type"),
				 EmfSdlPackage.eINSTANCE.getSdlCompositeState_Type(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlState_Entry());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlState_Exit());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SdlCompositeState.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SdlCompositeState"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SdlCompositeState)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SdlCompositeState_type") :
			getString("_UI_SdlCompositeState_type") + " " + label;
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

		switch (notification.getFeatureID(SdlCompositeState.class)) {
			case EmfSdlPackage.SDL_COMPOSITE_STATE__TRIGGER:
			case EmfSdlPackage.SDL_COMPOSITE_STATE__ENTRY:
			case EmfSdlPackage.SDL_COMPOSITE_STATE__EXIT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger(),
				 EmfSdlFactory.eINSTANCE.createSdlTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger(),
				 EmfSdlFactory.eINSTANCE.createSdlChoice()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger(),
				 EmfSdlFactory.eINSTANCE.createSdlElse()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger(),
				 EmfSdlFactory.eINSTANCE.createSdlImidiate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger(),
				 EmfSdlFactory.eINSTANCE.createSdlInput()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Entry(),
				 EmfSdlFactory.eINSTANCE.createSdlAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Entry(),
				 EmfSdlFactory.eINSTANCE.createSdlCreate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Entry(),
				 EmfSdlFactory.eINSTANCE.createSdlOutput()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Entry(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Entry(),
				 EmfSdlFactory.eINSTANCE.createSdlSet()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Entry(),
				 EmfSdlFactory.eINSTANCE.createSdlReset()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Exit(),
				 EmfSdlFactory.eINSTANCE.createSdlAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Exit(),
				 EmfSdlFactory.eINSTANCE.createSdlCreate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Exit(),
				 EmfSdlFactory.eINSTANCE.createSdlOutput()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Exit(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Exit(),
				 EmfSdlFactory.eINSTANCE.createSdlSet()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlState_Exit(),
				 EmfSdlFactory.eINSTANCE.createSdlReset()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAbstractState_Trigger() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlState_Entry() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlState_Exit();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
