/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.StructuralSymbolReference;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.StructuralSymbolReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralSymbolReferenceItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralSymbolReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addClassifierPropertyDescriptor(object);
			addReferencedClassifierPropertyDescriptor(object);
			addListPropertyDescriptor(object);
			addCompositePropertyDescriptor(object);
			addLocalScopedReferencePropertyDescriptor(object);
			addGlobalScopedReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PlainSymbolReference_classifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PlainSymbolReference_classifier_feature", "_UI_PlainSymbolReference_type"),
				 DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__CLASSIFIER,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Referenced Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencedClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PlainSymbolReference_referencedClassifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PlainSymbolReference_referencedClassifier_feature", "_UI_PlainSymbolReference_type"),
				 DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the List feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addListPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuralSymbolReference_list_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuralSymbolReference_list_feature", "_UI_StructuralSymbolReference_type"),
				 DblPackage.Literals.STRUCTURAL_SYMBOL_REFERENCE__LIST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Composite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompositePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuralSymbolReference_composite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuralSymbolReference_composite_feature", "_UI_StructuralSymbolReference_type"),
				 DblPackage.Literals.STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Local Scoped Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocalScopedReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuralSymbolReference_localScopedReference_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuralSymbolReference_localScopedReference_feature", "_UI_StructuralSymbolReference_type"),
				 DblPackage.Literals.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Global Scoped Reference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGlobalScopedReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructuralSymbolReference_globalScopedReference_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructuralSymbolReference_globalScopedReference_feature", "_UI_StructuralSymbolReference_type"),
				 DblPackage.Literals.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE,
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
			childrenFeatures.add(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER);
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
	 * This returns StructuralSymbolReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StructuralSymbolReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StructuralSymbolReference)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_StructuralSymbolReference_type") :
			getString("_UI_StructuralSymbolReference_type") + " " + label;
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

		switch (notification.getFeatureID(StructuralSymbolReference.class)) {
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LIST:
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE:
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE:
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
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
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createClass()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createSyntaxSymbolClassifier()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createComplexSymbol()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createExtension()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createMetaSymbol()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createIdSymbol()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createIntSymbol()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createStringSymbol()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createKeyword()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER,
				 DblFactory.eINSTANCE.createQuotedClassContent()));
	}

}
