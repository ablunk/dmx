/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlDataType;

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
 * This is the item provider adapter for a {@link hub.sam.sdl.SdlDataType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SdlDataTypeItemProvider
	extends EvaluationDataTypeItemProvider
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
	public SdlDataTypeItemProvider(AdapterFactory adapterFactory) {
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

			addMemberPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsNamespacesNamespace_member_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsNamespacesNamespace_member_feature", "_UI_CoreAbstractionsNamespacesNamespace_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_Member(),
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
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlDataType_Literal());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlDataType_Operation());
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
	 * This returns SdlDataType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SdlDataType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SdlDataType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SdlDataType_type") :
			getString("_UI_SdlDataType_type") + " " + label;
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

		switch (notification.getFeatureID(SdlDataType.class)) {
			case EmfSdlPackage.SDL_DATA_TYPE__OWNED_MEMBER:
			case EmfSdlPackage.SDL_DATA_TYPE__LITERAL:
			case EmfSdlPackage.SDL_DATA_TYPE__OPERATION:
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
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlStateList()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsInstancesInstanceSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlAgent()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlAgentType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlChannel()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlChannelPath()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlChoice()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlCompositeState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlElse()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlGate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlImidiate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlInput()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlNowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlOperationCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlPackage()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlVariable()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlPidExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlSignal()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlStateAutomaton()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlStatePartition()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlStateType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlTimer()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlTimerActiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember(),
				 EmfSdlFactory.eINSTANCE.createSdlVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlDataType_Literal(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlDataType_Operation(),
				 EmfSdlFactory.eINSTANCE.createSdlOperation()));
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
			childFeature == EmfSdlPackage.eINSTANCE.getEvaluationDataType_DataType_literal() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlDataType_Literal() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlDataType_Operation();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
