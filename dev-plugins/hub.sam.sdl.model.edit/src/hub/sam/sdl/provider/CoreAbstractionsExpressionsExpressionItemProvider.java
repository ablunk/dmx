/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.provider;


import hub.sam.sdl.CoreAbstractionsExpressionsExpression;
import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;

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
 * This is the item provider adapter for a {@link hub.sam.sdl.CoreAbstractionsExpressionsExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreAbstractionsExpressionsExpressionItemProvider
	extends CoreAbstractionsExpressionsValueSpecificationItemProvider
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
	public CoreAbstractionsExpressionsExpressionItemProvider(AdapterFactory adapterFactory) {
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

			addSymbolPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Symbol feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSymbolPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CoreAbstractionsExpressionsExpression_symbol_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CoreAbstractionsExpressionsExpression_symbol_feature", "_UI_CoreAbstractionsExpressionsExpression_type"),
				 EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Symbol(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand());
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
	 * This returns CoreAbstractionsExpressionsExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CoreAbstractionsExpressionsExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		CoreAbstractionsExpressionsExpression coreAbstractionsExpressionsExpression = (CoreAbstractionsExpressionsExpression)object;
		return getString("_UI_CoreAbstractionsExpressionsExpression_type") + " " + coreAbstractionsExpressionsExpression.getLine();
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

		switch (notification.getFeatureID(CoreAbstractionsExpressionsExpression.class)) {
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__SYMBOL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EmfSdlPackage.CORE_ABSTRACTIONS_EXPRESSIONS_EXPRESSION__OPERAND:
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
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsExpressionsExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsExpressionsOpaqueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsInstancesInstanceValue()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralBoolean()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralInteger()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralNull()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralString()));

		newChildDescriptors.add
			(createChildParameter
				(EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand(),
				 EmfSdlFactory.eINSTANCE.createCoreAbstractionsLiteralsLiteralUnlimitedNatural()));
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
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedElement() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsOwnershipsElement_OwnedComment() ||
			childFeature == EmfSdlPackage.eINSTANCE.getCoreAbstractionsExpressionsExpression_Operand();

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
