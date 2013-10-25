/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Procedure;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.Procedure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcedureItemProvider
	extends NamedElementItemProvider
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
	public ProcedureItemProvider(AdapterFactory adapterFactory) {
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

			addIsListPropertyDescriptor(object);
			addConcreteSyntaxPropertyDescriptor(object);
			addClazzPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is List feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsListPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TypedElement_isList_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TypedElement_isList_feature", "_UI_TypedElement_type"),
				 DblPackage.Literals.TYPED_ELEMENT__IS_LIST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_Procedure_clazz_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Procedure_clazz_feature", "_UI_Procedure_type"),
				 DblPackage.Literals.PROCEDURE__CLAZZ,
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
			childrenFeatures.add(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE);
			childrenFeatures.add(DblPackage.Literals.TYPED_ELEMENT__LIST_DIMS);
			childrenFeatures.add(DblPackage.Literals.TYPED_ELEMENT__CLASSIFIER_TYPE_EXPR);
			childrenFeatures.add(DblPackage.Literals.CODE_BLOCK__STATEMENTS);
			childrenFeatures.add(DblPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS);
			childrenFeatures.add(DblPackage.Literals.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS);
			childrenFeatures.add(DblPackage.Literals.PROCEDURE__PARAMETERS);
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
	 * This returns Procedure.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Procedure"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Procedure)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Procedure_type") :
			getString("_UI_Procedure_type") + " " + label;
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

		switch (notification.getFeatureID(Procedure.class)) {
			case DblPackage.PROCEDURE__IS_LIST:
			case DblPackage.PROCEDURE__CONCRETE_SYNTAX:
			case DblPackage.PROCEDURE__CLAZZ:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.PROCEDURE__PRIMITIVE_TYPE:
			case DblPackage.PROCEDURE__LIST_DIMS:
			case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR:
			case DblPackage.PROCEDURE__STATEMENTS:
			case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS:
			case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS:
			case DblPackage.PROCEDURE__PARAMETERS:
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
				(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE,
				 DblFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE,
				 DblFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE,
				 DblFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE,
				 DblFactory.eINSTANCE.createDoubleType()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE,
				 DblFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__LIST_DIMS,
				 DblFactory.eINSTANCE.createListDimension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__CLASSIFIER_TYPE_EXPR,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createCompositeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createDeprecatedProcedureCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createWaitUntil()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createTerminate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createYield()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createWait()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createReactivate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createActivateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createAdvance()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createPrint()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createRemoveFromSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createAddToSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createEmptySet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createContinueStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createTargetStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createMappingStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createSetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createResetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createSaveGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createResumeGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createExpandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createExpandSection()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createTestStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createPotentiallyHiddenIdElements()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createFindContainer()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createConsiderIdElements()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CODE_BLOCK__STATEMENTS,
				 DblFactory.eINSTANCE.createIncludePattern()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS,
				 DblFactory.eINSTANCE.createAnnotationApplication()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS,
				 DblFactory.eINSTANCE.createSimpleAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PROCEDURE__PARAMETERS,
				 DblFactory.eINSTANCE.createParameter()));
	}

}
