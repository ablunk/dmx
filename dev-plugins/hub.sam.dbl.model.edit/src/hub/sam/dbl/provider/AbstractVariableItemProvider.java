/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hub.sam.dbl.AbstractVariable} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractVariableItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractVariableItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(DblPackage.Literals.TYPED_ELEMENT__PRIMITIVE_TYPE);
			childrenFeatures.add(DblPackage.Literals.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS);
			childrenFeatures.add(DblPackage.Literals.TYPED_ELEMENT__CLASSIFIER_TYPE);
			childrenFeatures.add(DblPackage.Literals.ANNOTATEABLE_ELEMENT__ANNOTATIONS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AbstractVariable)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractVariable_type") :
			getString("_UI_AbstractVariable_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractVariable.class)) {
			case DblPackage.ABSTRACT_VARIABLE__PRIMITIVE_TYPE:
			case DblPackage.ABSTRACT_VARIABLE__TYPE_ARRAY_DIMENSIONS:
			case DblPackage.ABSTRACT_VARIABLE__CLASSIFIER_TYPE:
			case DblPackage.ABSTRACT_VARIABLE__ANNOTATIONS:
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
				(DblPackage.Literals.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS,
				 DblFactory.eINSTANCE.createArrayDimension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.TYPED_ELEMENT__CLASSIFIER_TYPE,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ANNOTATEABLE_ELEMENT__ANNOTATIONS,
				 DblFactory.eINSTANCE.createAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.ANNOTATEABLE_ELEMENT__ANNOTATIONS,
				 DblFactory.eINSTANCE.createAnnotationLiteral()));
	}

}
