/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.Clazz;
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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.dbl.Clazz} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClazzItemProvider
	extends ClassifierItemProvider
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
	public ClazzItemProvider(AdapterFactory adapterFactory) {
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
			addActivePropertyDescriptor(object);
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
	 * This adds a property descriptor for the Active feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Clazz_active_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Clazz_active_feature", "_UI_Clazz_type"),
				 DblPackage.Literals.CLAZZ__ACTIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__ATTRIBUTES);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__METHODS);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__INITIAL_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__FINAL_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__ACTIONS_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__REPORT_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLASS_SIMILAR__CLEAR_BLOCK);
			childrenFeatures.add(DblPackage.Literals.CLAZZ__CONSTRUCTOR);
			childrenFeatures.add(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS);
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
	 * This returns Clazz.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Clazz"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Clazz)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Clazz_type") :
			getString("_UI_Clazz_type") + " " + label;
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

		switch (notification.getFeatureID(Clazz.class)) {
			case DblPackage.CLAZZ__ACTIVE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.CLAZZ__EXTENSIONS:
			case DblPackage.CLAZZ__MODIFIER_EXTENSIONS:
			case DblPackage.CLAZZ__ATTRIBUTES:
			case DblPackage.CLAZZ__METHODS:
			case DblPackage.CLAZZ__INITIAL_BLOCK:
			case DblPackage.CLAZZ__FINAL_BLOCK:
			case DblPackage.CLAZZ__ACTIONS_BLOCK:
			case DblPackage.CLAZZ__REPORT_BLOCK:
			case DblPackage.CLAZZ__CLEAR_BLOCK:
			case DblPackage.CLAZZ__CONSTRUCTOR:
			case DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS:
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
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createExtensibleElement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createNamedExtensible()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createConstruct()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createProcedure()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createStartCodeBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createCompositeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createDeprecatedProcedureCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createWaitUntil()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createTerminate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createYield()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createWait()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createReactivate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createActivateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createAdvance()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createPrint()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createRemoveFromSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createAddToSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createEmptySet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createContinueStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createEvalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createClassContentExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createModuleContentExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createTargetStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createMappingStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createSetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createResetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createSaveGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createResumeGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createExpandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createExpandSection()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createCodeQuoteExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createTestStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createPotentiallyHiddenIdElements()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createFindContainer()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createConsiderIdElements()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS,
				 DblFactory.eINSTANCE.createIncludePattern()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createExtensibleElement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createNamedExtensible()));

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
				 DblFactory.eINSTANCE.createYield()));

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
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS,
				 DblFactory.eINSTANCE.createCreateObject()));

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
				 DblFactory.eINSTANCE.createEvalExpr()));

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

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__CONSTRUCTOR,
				 DblFactory.eINSTANCE.createConstructor()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createEvalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS,
				 DblFactory.eINSTANCE.createCodeQuoteExpression()));
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
			childFeature == DblPackage.Literals.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION ||
			childFeature == DblPackage.Literals.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS ||
			childFeature == DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS ||
			childFeature == DblPackage.Literals.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS ||
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
