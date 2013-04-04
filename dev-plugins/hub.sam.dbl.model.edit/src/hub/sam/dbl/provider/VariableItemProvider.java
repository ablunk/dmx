/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Variable;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.Variable} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableItemProvider
	extends AbstractVariableItemProvider
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
	public VariableItemProvider(AdapterFactory adapterFactory) {
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

			addConcreteSyntaxPropertyDescriptor(object);
			addControlPropertyDescriptor(object);
			addClazzPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Concrete Syntax feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConcreteSyntaxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Construct_concreteSyntax_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Construct_concreteSyntax_feature", "_UI_Construct_type"),
				 DblPackage.Literals.CONSTRUCT__CONCRETE_SYNTAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Control feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addControlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Variable_control_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Variable_control_feature", "_UI_Variable_type"),
				 DblPackage.Literals.VARIABLE__CONTROL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Clazz feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClazzPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Variable_clazz_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Variable_clazz_feature", "_UI_Variable_type"),
				 DblPackage.Literals.VARIABLE__CLAZZ,
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
			childrenFeatures.add(DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.VARIABLE__INITIAL_VALUE);
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
	 * This returns Variable.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Variable"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Variable)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Variable_type") :
			getString("_UI_Variable_type") + " " + label;
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

		switch (notification.getFeatureID(Variable.class)) {
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
			case DblPackage.VARIABLE__CONTROL:
			case DblPackage.VARIABLE__CLAZZ:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.VARIABLE__MODIFIER_EXTENSIONS:
			case DblPackage.VARIABLE__INITIAL_VALUE:
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
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createEvalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.VARIABLE__INITIAL_VALUE,
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
			childFeature == DblPackage.Literals.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS ||
			childFeature == DblPackage.Literals.VARIABLE__INITIAL_VALUE ||
			childFeature == DblPackage.Literals.TYPED_ELEMENT__CLASSIFIER_TYPE_EXPR;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
