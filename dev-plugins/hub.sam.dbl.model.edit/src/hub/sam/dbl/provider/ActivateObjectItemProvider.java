/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.ActivateObject;
import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.ActivateObject} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivateObjectItemProvider extends SimpleStatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivateObjectItemProvider(AdapterFactory adapterFactory) {
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

			addPriorityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ActivateObject_priority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ActivateObject_priority_feature", "_UI_ActivateObject_type"),
				 DblPackage.Literals.ACTIVATE_OBJECT__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS);
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
	 * This returns ActivateObject.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ActivateObject"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ActivateObject)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ActivateObject_type") :
			getString("_UI_ActivateObject_type") + " " + label;
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

		switch (notification.getFeatureID(ActivateObject.class)) {
			case DblPackage.ACTIVATE_OBJECT__PRIORITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.ACTIVATE_OBJECT__OBJECT_ACCESS:
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
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL2Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL3Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL4Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL5Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL6Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL7Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL8Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createL9Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createExpandExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createParseExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS,
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
			childFeature == DblPackage.Literals.CONSTRUCT__EXPAND_EXPR ||
			childFeature == DblPackage.Literals.ACTIVATE_OBJECT__OBJECT_ACCESS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
