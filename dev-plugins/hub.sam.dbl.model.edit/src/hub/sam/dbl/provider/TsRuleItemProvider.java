/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.TsRule;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.TsRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TsRuleItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TsRuleItemProvider(AdapterFactory adapterFactory) {
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
			addInstanceOfExtensionDefinitionPropertyDescriptor(object);
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
			childrenFeatures.add(DblPackage.Literals.CONSTRUCT__EXPAND_EXPR);
			childrenFeatures.add(DblPackage.Literals.TS_RULE__RHS);
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
	 * This returns TsRule.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TsRule"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TsRule)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TsRule_type") :
			getString("_UI_TsRule_type") + " " + label;
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

		switch (notification.getFeatureID(TsRule.class)) {
			case DblPackage.TS_RULE__CONCRETE_SYNTAX:
			case DblPackage.TS_RULE__INSTANCE_OF_EXTENSION_DEFINITION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.TS_RULE__EXPAND_EXPR:
			case DblPackage.TS_RULE__RHS:
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
				(DblPackage.Literals.CONSTRUCT__EXPAND_EXPR,
				 DblFactory.eINSTANCE.createExpandExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createRhsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createL3RhsExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createL2RhsExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createSequenceExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createL1RhsExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createTerminalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createPropertyBindingExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TS_RULE__RHS,
				 DblFactory.eINSTANCE.createRhsClassifierExpr()));
	}

}
