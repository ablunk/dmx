/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentType;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.sdl.SdlAgentType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SdlAgentTypeItemProvider
	extends SdlBehaviorElementItemProvider
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
	public SdlAgentTypeItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addQualifiedNamePropertyDescriptor(object);
			addIdentifierPropertyDescriptor(object);
			addMemberPropertyDescriptor(object);
			addFeaturePropertyDescriptor(object);
			addGeneralPropertyDescriptor(object);
			addFeaturingClassifierPropertyDescriptor(object);
			addBehavioralFeature_parameterPropertyDescriptor(object);
			addKindPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsNamespacesNamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsNamespacesNamedElement_name_feature", "_UI_CoreAbstractionsNamespacesNamedElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamedElement_Name(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Qualified Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQualifiedNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsNamespacesNamedElement_qualifiedName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsNamespacesNamedElement_qualifiedName_feature", "_UI_CoreAbstractionsNamespacesNamedElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamedElement_QualifiedName(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsNamespacesNamedElement_identifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsNamespacesNamedElement_identifier_feature", "_UI_CoreAbstractionsNamespacesNamedElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamedElement_Identifier(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
	 * This adds a property descriptor for the Behavioral Feature parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBehavioralFeature_parameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsBehavioralFeaturesBehavioralFeature_BehavioralFeature_parameter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsBehavioralFeaturesBehavioralFeature_BehavioralFeature_parameter_feature", "_UI_CoreAbstractionsBehavioralFeaturesBehavioralFeature_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsBehavioralFeaturesBehavioralFeature_BehavioralFeature_parameter(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SdlAgentType_kind_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SdlAgentType_kind_feature", "_UI_SdlAgentType_type"),
				 EmfSdlPackage.eINSTANCE.getSdlAgentType_Kind(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_Generalization());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlClassifier_Procedure());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAgentType_Agent());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAgentType_OwnedAgentType());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAgentType_Channel());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAgentType_Behavior());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAgentType_Parameter());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getSdlAgentType_Gate());
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
	 * This returns SdlAgentType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SdlAgentType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SdlAgentType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SdlAgentType_type") :
			getString("_UI_SdlAgentType_type") + " " + label;
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

		switch (notification.getFeatureID(SdlAgentType.class)) {
			case EmfSdlPackage.SDL_AGENT_TYPE__NAME:
			case EmfSdlPackage.SDL_AGENT_TYPE__QUALIFIED_NAME:
			case EmfSdlPackage.SDL_AGENT_TYPE__KIND:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_ELEMENT:
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_COMMENT:
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_MEMBER:
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_TYPE:
			case EmfSdlPackage.SDL_AGENT_TYPE__GENERALIZATION:
			case EmfSdlPackage.SDL_AGENT_TYPE__VARIABLE:
			case EmfSdlPackage.SDL_AGENT_TYPE__PROCEDURE:
			case EmfSdlPackage.SDL_AGENT_TYPE__AGENT:
			case EmfSdlPackage.SDL_AGENT_TYPE__OWNED_AGENT_TYPE:
			case EmfSdlPackage.SDL_AGENT_TYPE__CHANNEL:
			case EmfSdlPackage.SDL_AGENT_TYPE__BEHAVIOR:
			case EmfSdlPackage.SDL_AGENT_TYPE__PARAMETER:
			case EmfSdlPackage.SDL_AGENT_TYPE__GATE:
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
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlStateList()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createConnector()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsCommentsComment()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsConstraintsConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsExpressionsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsExpressionsOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsGeneralizationsGeneralization()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsInstancesInstanceSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsInstancesInstanceValue()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsInstancesSlot()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralBoolean()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralInteger()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralNull()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralString()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralUnlimitedNatural()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlAgent()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlAgentType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlChannel()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlChannelEnd()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlChannelPath()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlChoice()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlCompositeState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlElse()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlGate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlImidiate()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlInput()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlNowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlOperationCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlPackage()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlVariable()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlPidExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlSignal()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlStateAutomaton()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlStatePartition()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlStateType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlTimer()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlTimerActiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement(),
				 EmfSdlFactory.eINSTANCE.createSdlVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsCommentsComment()));

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
				(EmfSdlPackage.eINSTANCE.getSdlAgentType_Agent(),
				 EmfSdlFactory.eINSTANCE.createSdlAgent()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAgentType_OwnedAgentType(),
				 EmfSdlFactory.eINSTANCE.createSdlAgentType()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAgentType_Channel(),
				 EmfSdlFactory.eINSTANCE.createSdlChannel()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAgentType_Behavior(),
				 EmfSdlFactory.eINSTANCE.createSdlCompositeState()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAgentType_Parameter(),
				 EmfSdlFactory.eINSTANCE.createSdlParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getSdlAgentType_Gate(),
				 EmfSdlFactory.eINSTANCE.createSdlGate()));
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
			childFeature == EmfSdlPackage.eINSTANCE.getSdlBehaviorElement_SdlBehaviorElement_behavior() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamespace_OwnedMember() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAgentType_Behavior() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsGeneralizationsClassifier_Generalization() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAgentType_Agent() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlNamespace_OwnedType() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAgentType_OwnedAgentType() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAgentType_Channel() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAgentType_Gate() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlClassifier_Variable() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlAgentType_Parameter() ||
			childFeature == EmfSdlPackage.eINSTANCE.getSdlClassifier_Procedure();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
