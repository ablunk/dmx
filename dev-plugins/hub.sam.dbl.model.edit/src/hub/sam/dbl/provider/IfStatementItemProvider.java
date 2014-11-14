/**
 */
package hub.sam.dbl.provider;


import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IfStatement;

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
 * This is the item provider adapter for a {@link hub.sam.dbl.IfStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IfStatementItemProvider
	extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(DblPackage.Literals.IF_STATEMENT__CONDITION);
			childrenFeatures.add(DblPackage.Literals.IF_STATEMENT__TRUE_CASE);
			childrenFeatures.add(DblPackage.Literals.IF_STATEMENT__FALSE_CASE);
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
	 * This returns IfStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IfStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IfStatement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IfStatement_type") :
			getString("_UI_IfStatement_type") + " " + label;
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

		switch (notification.getFeatureID(IfStatement.class)) {
			case DblPackage.IF_STATEMENT__CONDITION:
			case DblPackage.IF_STATEMENT__TRUE_CASE:
			case DblPackage.IF_STATEMENT__FALSE_CASE:
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
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL1Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL2Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL3Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL4Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL5Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL6Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL7Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL8Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createL9Expr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createNotEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createGreater()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createGreaterEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createLess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createLessEqual()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createInstanceOf()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createMul()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createMod()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createDiv()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createNeg()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createCast()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createCreateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createNullLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createTimeLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createActiveLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createStringLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createIntLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createTrueLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createFalseLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createDoubleLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createExpandExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createParseExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createIdExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createVariableAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createMetaAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createTypeAccess()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createMetaExpr()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createExpandExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__CONDITION,
				 DblFactory.eINSTANCE.createCodeQuoteExpression()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createLoopStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createWaitUntil()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createTerminate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createYield()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createWait()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createReactivate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createActivateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createAdvance()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createPrint()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createLocalScopeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createContinueStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createTargetStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createMappingStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createSetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createResetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createSaveGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createResumeGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createExpandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__TRUE_CASE,
				 DblFactory.eINSTANCE.createTestStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createLoopStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createProcedureCall()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createReturn()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createWaitUntil()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createTerminate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createYield()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createWait()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createReactivate()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createActivateObject()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createAdvance()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createPrint()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createLocalScopeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createSwitchStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createBreakStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createContinueStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createTargetStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createMappingStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createSetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createResetGenContextStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createSaveGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createResumeGenStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createExpandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(DblPackage.Literals.IF_STATEMENT__FALSE_CASE,
				 DblFactory.eINSTANCE.createTestStatement()));
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
			childFeature == DblPackage.Literals.IF_STATEMENT__CONDITION ||
			childFeature == DblPackage.Literals.IF_STATEMENT__TRUE_CASE ||
			childFeature == DblPackage.Literals.IF_STATEMENT__FALSE_CASE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
