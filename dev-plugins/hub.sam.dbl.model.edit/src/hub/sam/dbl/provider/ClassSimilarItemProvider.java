/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.ClassSimilar;
import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.ClassSimilar} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassSimilarItemProvider
	extends EmbeddableExtensionsContainerItemProvider
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
	public ClassSimilarItemProvider(AdapterFactory adapterFactory) {
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

			addSuperClassPropertyDescriptor(object);
			addImplementedInterfacesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Super Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ClassSimilar_superClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ClassSimilar_superClass_feature", "_UI_ClassSimilar_type"),
				 DblPackage.Literals.CLASS_SIMILAR__SUPER_CLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Implemented Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementedInterfacesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ClassSimilar_implementedInterfaces_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ClassSimilar_implementedInterfaces_feature", "_UI_ClassSimilar_type"),
				 DblPackage.Literals.CLASS_SIMILAR__IMPLEMENTED_INTERFACES,
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
			childrenFeatures.add(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__ATTRIBUTES);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__METHODS);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__INITIAL_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__FINAL_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__ACTIONS_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__REPORT_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__CLEAR_BLOCK);
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
		return getString("_UI_ClassSimilar_type");
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

		switch (notification.getFeatureID(ClassSimilar.class)) {
			case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS:
			case DblPackage.CLASS_SIMILAR__ATTRIBUTES:
			case DblPackage.CLASS_SIMILAR__METHODS:
			case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK:
			case DblPackage.CLASS_SIMILAR__FINAL_BLOCK:
			case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK:
			case DblPackage.CLASS_SIMILAR__REPORT_BLOCK:
			case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK:
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
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createNamedExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createConstruct()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createStartCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCompositeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createDeprecatedProcedureCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createWaitUntil()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createTerminate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createWait()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createReactivate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createActivateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createAdvance()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createPrint()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createRemoveFromSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createAddToSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createEmptySet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createContinueStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createEvalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createClassContentExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createModuleContentExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createTargetStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createMappingStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createSetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createResetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createSaveGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createResumeGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExpandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExpandSection()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCodeQuoteExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createTestStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createPotentiallyHiddenIdElements()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createFindContainer()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createConsiderIdElements()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createIncludePattern()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__ATTRIBUTES,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__METHODS,
				 DblFactory.eINSTANCE.createProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__INITIAL_BLOCK,
				 DblFactory.eINSTANCE.createStartCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__FINAL_BLOCK,
				 DblFactory.eINSTANCE.createStartCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createStartCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__REPORT_BLOCK,
				 DblFactory.eINSTANCE.createStartCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS_SIMILAR__CLEAR_BLOCK,
				 DblFactory.eINSTANCE.createStartCodeBlock()));
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
			childFeature == DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS ||
			childFeature == DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__METHODS ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__INITIAL_BLOCK ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__FINAL_BLOCK ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__ACTIONS_BLOCK ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__REPORT_BLOCK ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__CLEAR_BLOCK ||
			childFeature == DblPackage.Literals.CLASS_SIMILAR__ATTRIBUTES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
