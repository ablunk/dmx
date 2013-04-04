/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdExpr;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.IdExpr} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IdExprItemProvider
	extends ExpressionItemProvider
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
	public IdExprItemProvider(AdapterFactory adapterFactory) {
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

			addReferencedElementPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Referenced Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencedElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IdExpr_referencedElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IdExpr_referencedElement_feature", "_UI_IdExpr_type"),
				 DblPackage.Literals.ID_EXPR__REFERENCED_ELEMENT,
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
			childrenFeatures.add(DblPackage.Literals.ID_EXPR__PARENT_ID_EXPR);
			childrenFeatures.add(DblPackage.Literals.ID_EXPR__PREDEFINED_ID);
			childrenFeatures.add(DblPackage.Literals.ID_EXPR__ARGUMENTS);
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
	 * This returns IdExpr.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IdExpr"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IdExpr)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IdExpr_type") :
			getString("_UI_IdExpr_type") + " " + label;
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

		switch (notification.getFeatureID(IdExpr.class)) {
			case DblPackage.ID_EXPR__PARENT_ID_EXPR:
			case DblPackage.ID_EXPR__PREDEFINED_ID:
			case DblPackage.ID_EXPR__ARGUMENTS:
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
				(DblPackage.Literals.ID_EXPR__PARENT_ID_EXPR,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createPredefinedId()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createMeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createSuperLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createMetaLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createTypeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createSizeOfSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createFirstInSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createLastInSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createContains()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createIndexOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createObjectAt()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createBeforeInSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__PREDEFINED_ID,
				 DblFactory.eINSTANCE.createAfterInSet()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ID_EXPR__ARGUMENTS,
				 DblFactory.eINSTANCE.createArgumentExpression()));
	}

}
