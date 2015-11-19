/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Module;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.dbl.Module} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModuleItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(DblPackage.Literals.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.CONSTRUCT__EXPAND_EXPR);
			childrenFeatures.add(DblPackage.Literals.MODULE__CLASSES);
			childrenFeatures.add(DblPackage.Literals.MODULE__EXTENSIONS);
			childrenFeatures.add(DblPackage.Literals.MODULE__EXTENSION_SEMANTICS);
			childrenFeatures.add(DblPackage.Literals.MODULE__FUNCTIONS);
			childrenFeatures.add(DblPackage.Literals.MODULE__VARIABLES);
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
	 * This returns Module.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Module"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Module)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Module_type") :
			getString("_UI_Module_type") + " " + label;
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

		switch (notification.getFeatureID(Module.class)) {
			case DblPackage.MODULE__CONTENT_EXTENSIONS:
			case DblPackage.MODULE__EXPAND_EXPR:
			case DblPackage.MODULE__CLASSES:
			case DblPackage.MODULE__EXTENSIONS:
			case DblPackage.MODULE__EXTENSION_SEMANTICS:
			case DblPackage.MODULE__FUNCTIONS:
			case DblPackage.MODULE__VARIABLES:
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
				(DblPackage.Literals.MODULE__CLASSES,
				 DblFactory.eINSTANCE.createClass()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODULE__CLASSES,
				 DblFactory.eINSTANCE.createQuotedClassContent()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODULE__EXTENSIONS,
				 DblFactory.eINSTANCE.createExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODULE__EXTENSION_SEMANTICS,
				 DblFactory.eINSTANCE.createExtensionSemantics()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODULE__FUNCTIONS,
				 DblFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODULE__VARIABLES,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.MODULE__VARIABLES,
				 DblFactory.eINSTANCE.createCreateIdStatement()));
	}

}
