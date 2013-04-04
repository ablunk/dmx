/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlProcedure;

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
 * This is the item provider adapter for a {@link hub.sam.sdl.SdlProcedure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SdlProcedureItemProvider
	extends CoreAbstractionsBehavioralFeaturesBehavioralFeatureItemProvider
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
	public SdlProcedureItemProvider(AdapterFactory adapterFactory) {
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

			addTypedElement_typePropertyDescriptor(object);
			addFeaturePropertyDescriptor(object);
			addGeneralPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Typed Element type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypedElement_typePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsTypedElementsTypedElement_TypedElement_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsTypedElementsTypedElement_TypedElement_type_feature", "_UI_CoreAbstractionsTypedElementsTypedElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsTypedElementsTypedElement_TypedElement_type(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsClassifiersClassifier_feature_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsClassifiersClassifier_feature_feature", "_UI_CoreAbstractionsClassifiersClassifier_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsClassifiersClassifier_Feature(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the General feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsGeneralizationsClassifier_general_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsGeneralizationsClassifier_general_feature", "_UI_CoreAbstractionsGeneralizationsClassifier_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_General(),
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
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_Generalization());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlClassifier_Procedure());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlProcedure_Parameter());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlProcedure_ProcedureStateAutomaton());
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
	 * This returns SdlProcedure.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SdlProcedure"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SdlProcedure)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SdlProcedure_type") :
			getString("_UI_SdlProcedure_type") + " " + label;
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

		switch (notification.getFeatureID(SdlProcedure.class)) {
			case EmfSdlPackage.SDL_PROCEDURE__SDL_BEHAVIOR_ELEMENT_BEHAVIOR:
			case EmfSdlPackage.SDL_PROCEDURE__OWNED_TYPE:
			case EmfSdlPackage.SDL_PROCEDURE__GENERALIZATION:
			case EmfSdlPackage.SDL_PROCEDURE__VARIABLE:
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE:
			case EmfSdlPackage.SDL_PROCEDURE__PARAMETER:
			case EmfSdlPackage.SDL_PROCEDURE__PROCEDURE_STATE_AUTOMATON:
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
				(EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior(),
				 EmfSdlFactory.eINSTANCE.createSdlBehavior()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior(),
				 EmfSdlFactory.eINSTANCE.createSdlCompositeState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior(),
				 EmfSdlFactory.eINSTANCE.createSdlStateAutomaton()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior(),
				 EmfSdlFactory.eINSTANCE.createSdlStatePartition()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType(),
				 EmfSdlFactory.eINSTANCE.createSdlAgentType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType(),
				 EmfSdlFactory.eINSTANCE.createSdlDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType(),
				 EmfSdlFactory.eINSTANCE.createSdlSignal()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType(),
				 EmfSdlFactory.eINSTANCE.createSdlStateType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType(),
				 EmfSdlFactory.eINSTANCE.createSdlTimer()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_Generalization(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsGeneralizationsGeneralization()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable(),
				 EmfSdlFactory.eINSTANCE.createSdlVariable()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable(),
				 EmfSdlFactory.eINSTANCE.createSdlParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlClassifier_Procedure(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlProcedure_Parameter(),
				 EmfSdlFactory.eINSTANCE.createSdlParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlProcedure_ProcedureStateAutomaton(),
				 EmfSdlFactory.eINSTANCE.createSdlStateAutomaton()));
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
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_Generalization() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlProcedure_Parameter() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlClassifier_Procedure() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlProcedure_ProcedureStateAutomaton();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
