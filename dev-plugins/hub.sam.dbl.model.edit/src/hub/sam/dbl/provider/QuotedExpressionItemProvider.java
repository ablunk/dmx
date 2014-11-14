/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.QuotedExpression;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.dbl.QuotedExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QuotedExpressionItemProvider
	extends QuotedCodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedExpressionItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION);
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
	 * This returns QuotedExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/QuotedExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_QuotedExpression_type");
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

		switch (notification.getFeatureID(QuotedExpression.class)) {
			case DblPackage.QUOTED_EXPRESSION__EXPRESSION:
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
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL2Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL3Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL4Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL5Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL6Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL7Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL8Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createL9Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createExpandExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createParseExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.QUOTED_EXPRESSION__EXPRESSION,
				 DblFactory.eINSTANCE.createCodeQuoteExpression()));
	}

}
