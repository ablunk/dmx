/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.QuotedClassContent;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.dbl.QuotedClassContent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QuotedClassContentItemProvider extends QuotedCodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedClassContentItemProvider(AdapterFactory adapterFactory) {
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
			addConcreteSyntaxPropertyDescriptor(object);
			addInstanceOfExtensionDefinitionPropertyDescriptor(object);
			addActivePropertyDescriptor(object);
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
				 getString("_UI_NamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
				 DblPackage.Literals.NAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_ExtensibleElement_concreteSyntax_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExtensibleElement_concreteSyntax_feature", "_UI_ExtensibleElement_type"),
				 DblPackage.Literals.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Instance Of Extension Definition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstanceOfExtensionDefinitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExtensibleElement_instanceOfExtensionDefinition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExtensibleElement_instanceOfExtensionDefinition_feature", "_UI_ExtensibleElement_type"),
				 DblPackage.Literals.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Class_active_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Class_active_feature", "_UI_Class_type"),
				 DblPackage.Literals.CLASS__ACTIVE,
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
			childrenFeatures.add(DblPackage.Literals.TYPE__ARRAY_DIMENSIONS);
			childrenFeatures.add(DblPackage.Literals.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.CONSTRUCT__EXPAND_EXPR);
			childrenFeatures.add(DblPackage.Literals.ANNOTATEABLE_ELEMENT__ANNOTATIONS);
			childrenFeatures.add(DblPackage.Literals.CLASS__BINDINGS);
			childrenFeatures.add(DblPackage.Literals.CLASS__SUPER_CLASSES);
			childrenFeatures.add(DblPackage.Literals.CLASS__CONSTRUCTORS);
			childrenFeatures.add(DblPackage.Literals.CLASS__ATTRIBUTES);
			childrenFeatures.add(DblPackage.Literals.CLASS__METHODS);
			childrenFeatures.add(DblPackage.Literals.CLASS__ACTIONS_BLOCK);
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
	 * This returns QuotedClassContent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/QuotedClassContent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((QuotedClassContent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_QuotedClassContent_type") :
			getString("_UI_QuotedClassContent_type") + " " + label;
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

		switch (notification.getFeatureID(QuotedClassContent.class)) {
			case DblPackage.QUOTED_CLASS_CONTENT__NAME:
			case DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX:
			case DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION:
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIVE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS:
			case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS:
			case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR:
			case DblPackage.QUOTED_CLASS_CONTENT__ANNOTATIONS:
			case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS:
			case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES:
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
			case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES:
			case DblPackage.QUOTED_CLASS_CONTENT__METHODS:
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK:
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
				(DblPackage.Literals.TYPE__ARRAY_DIMENSIONS,
				 DblFactory.eINSTANCE.createArrayDimension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS,
				 DblFactory.eINSTANCE.createConstructiveExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS,
				 DblFactory.eINSTANCE.createModuleContentExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS,
				 DblFactory.eINSTANCE.createClassContentExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CONSTRUCT__EXPAND_EXPR,
				 DblFactory.eINSTANCE.createExpandExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ANNOTATEABLE_ELEMENT__ANNOTATIONS,
				 DblFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ANNOTATEABLE_ELEMENT__ANNOTATIONS,
				 DblFactory.eINSTANCE.createAnnotationLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__BINDINGS,
				 DblFactory.eINSTANCE.createNativeBinding()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__SUPER_CLASSES,
				 DblFactory.eINSTANCE.createSuperClassSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__CONSTRUCTORS,
				 DblFactory.eINSTANCE.createConstructor()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ATTRIBUTES,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ATTRIBUTES,
				 DblFactory.eINSTANCE.createCreateIdStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__METHODS,
				 DblFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createLocalScope()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createConstructor()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createLocalScopeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.CLASS__ACTIONS_BLOCK,
				 DblFactory.eINSTANCE.createExtensionSemantics()));
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
			childFeature == DblPackage.Literals.CLASS__CONSTRUCTORS ||
			childFeature == DblPackage.Literals.CLASS__ACTIONS_BLOCK ||
			childFeature == DblPackage.Literals.CLASS__METHODS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
