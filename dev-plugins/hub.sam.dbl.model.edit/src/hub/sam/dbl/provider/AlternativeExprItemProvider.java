/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.AlternativeExpr;
import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.AlternativeExpr} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AlternativeExprItemProvider
	extends RhsExpressionItemProvider
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
	public AlternativeExprItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT);
			childrenFeatures.add(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT);
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
	 * This returns AlternativeExpr.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AlternativeExpr"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_AlternativeExpr_type");
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

		switch (notification.getFeatureID(AlternativeExpr.class)) {
			case DblPackage.ALTERNATIVE_EXPR__LEFT:
			case DblPackage.ALTERNATIVE_EXPR__RIGHT:
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
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createSequenceExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createOptionalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createRuntimeExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createAtLeastOneExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createArbitraryExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createAlternativeExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createTerminalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createPropertyBindingExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__LEFT,
				 DblFactory.eINSTANCE.createRuleExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createSequenceExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createOptionalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createRuntimeExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createAtLeastOneExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createArbitraryExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createAlternativeExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createTerminalExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createPropertyBindingExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT,
				 DblFactory.eINSTANCE.createRuleExpr()));
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
			childFeature == DblPackage.Literals.ALTERNATIVE_EXPR__LEFT ||
			childFeature == DblPackage.Literals.ALTERNATIVE_EXPR__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
