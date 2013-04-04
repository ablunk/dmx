/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression;

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
 * This is the item provider adapter for a {@link hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EvaluationBehavioralFeatureAccessExpressionItemProvider
	extends EvaluationBehavioralFeatureAccessItemProvider
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
	public EvaluationBehavioralFeatureAccessExpressionItemProvider(AdapterFactory adapterFactory) {
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

			addLinePropertyDescriptor(object);
			addColumnPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addQualifiedNamePropertyDescriptor(object);
			addIdentifierPropertyDescriptor(object);
			addTypedElement_typePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addFeatureAccessExpression_featurePropertyDescriptor(object);
			addBehavioralFeatureAccessExpression_featurePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Line feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsElementsElement_line_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsElementsElement_line_feature", "_UI_CoreAbstractionsElementsElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsElementsElement_Line(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsElementsElement_column_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsElementsElement_column_feature", "_UI_CoreAbstractionsElementsElement_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsElementsElement_Column(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_EvaluationExpression_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EvaluationExpression_type_feature", "_UI_EvaluationExpression_type"),
				 EmfSdlPackage.eINSTANCE.getEvaluationExpression_Type(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature Access Expression feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureAccessExpression_featurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EvaluationFeatureAccessExpression_FeatureAccessExpression_feature_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EvaluationFeatureAccessExpression_FeatureAccessExpression_feature_feature", "_UI_EvaluationFeatureAccessExpression_type"),
				 EmfSdlPackage.eINSTANCE.getEvaluationFeatureAccessExpression_FeatureAccessExpression_feature(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Behavioral Feature Access Expression feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBehavioralFeatureAccessExpression_featurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EvaluationBehavioralFeatureAccessExpression_BehavioralFeatureAccessExpression_feature_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EvaluationBehavioralFeatureAccessExpression_BehavioralFeatureAccessExpression_feature_feature", "_UI_EvaluationBehavioralFeatureAccessExpression_type"),
				 EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_BehavioralFeatureAccessExpression_feature(),
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
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression());
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument());
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EvaluationBehavioralFeatureAccessExpression)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EvaluationBehavioralFeatureAccessExpression_type") :
			getString("_UI_EvaluationBehavioralFeatureAccessExpression_type") + " " + label;
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

		switch (notification.getFeatureID(EvaluationBehavioralFeatureAccessExpression.class)) {
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE:
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN:
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME:
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT:
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION:
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT:
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
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlNowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlOperationCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlPidExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlTimerActiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression(),
				 EmfSdlFactory.eINSTANCE.createSdlVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlLiteralExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlNowExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlOperationCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlPidExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlTimerActiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument(),
				 EmfSdlFactory.eINSTANCE.createSdlVariableAccess()));
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
			childFeature == EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccess_BehavioralFeatureAccess_argument() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement() ||
			childFeature == EmfSdlPackage.eINSTANCE.getEvaluationExpression_SubExpression() ||
			childFeature == EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression_Argument() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
