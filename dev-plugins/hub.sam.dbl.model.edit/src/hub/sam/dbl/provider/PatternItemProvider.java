/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Pattern;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.Pattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PatternItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternItemProvider(AdapterFactory adapterFactory) {
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

			addTopPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Top feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pattern_top_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pattern_top_feature", "_UI_Pattern_type"),
				 DblPackage.Literals.PATTERN__TOP,
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
			childrenFeatures.add(DblPackage.Literals.PATTERN__CONTEXT);
			childrenFeatures.add(DblPackage.Literals.PATTERN__BODY);
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
	 * This returns Pattern.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Pattern"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Pattern)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Pattern_type") :
			getString("_UI_Pattern_type") + " " + label;
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

		switch (notification.getFeatureID(Pattern.class)) {
			case DblPackage.PATTERN__TOP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.PATTERN__CONTEXT:
			case DblPackage.PATTERN__BODY:
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
				(DblPackage.Literals.PATTERN__CONTEXT,
				 DblFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createLoopStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createFunctionCall()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createWaitUntil()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createTerminate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createYield()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createYieldTo()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createWait()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createReactivate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createActivateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createAdvance()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createPrint()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createLocalScopeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createContinueStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createTargetStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createCreateIdStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createExpansionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createExpandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PATTERN__BODY,
				 DblFactory.eINSTANCE.createTestStatement()));
	}

}
