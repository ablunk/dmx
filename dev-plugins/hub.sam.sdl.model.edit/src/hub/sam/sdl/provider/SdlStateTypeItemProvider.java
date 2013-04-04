/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlStateType;

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
 * This is the item provider adapter for a {@link hub.sam.sdl.SdlStateType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SdlStateTypeItemProvider
	extends SdlClassifierItemProvider
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
	public SdlStateTypeItemProvider(AdapterFactory adapterFactory) {
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

			addMediumPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Medium feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMediumPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CommunicationCommunicator_medium_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CommunicationCommunicator_medium_feature", "_UI_CommunicationCommunicator_type"),
				 EmfSdlPackage.eINSTANCE.getCommunicationCommunicator_Medium(),
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
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlStateType_StateAutomaton());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlStateType_State());
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
	 * This returns SdlStateType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SdlStateType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SdlStateType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SdlStateType_type") :
			getString("_UI_SdlStateType_type") + " " + label;
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

		switch (notification.getFeatureID(SdlStateType.class)) {
			case EmfSdlPackage.SDL_STATE_TYPE__STATE_AUTOMATON:
			case EmfSdlPackage.SDL_STATE_TYPE__STATE:
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
				(EmfSdlPackage.eINSTANCE.getSdlStateType_StateAutomaton(),
				 EmfSdlFactory.eINSTANCE.createSdlStateAutomaton()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlStateType_State(),
				 EmfSdlFactory.eINSTANCE.createSdlState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlStateType_State(),
				 EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlStateList()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlStateType_State(),
				 EmfSdlFactory.eINSTANCE.createSdlCompositeState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlStateType_State(),
				 EmfSdlFactory.eINSTANCE.createSdlStatePartition()));
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
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlStateType_State() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_Generalization() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlClassifier_Procedure() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlStateType_StateAutomaton();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
