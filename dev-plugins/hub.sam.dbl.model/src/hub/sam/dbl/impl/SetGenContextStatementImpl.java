/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.SetGenContextStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Gen Context Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.SetGenContextStatementImpl#getContext <em>Context</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.SetGenContextStatementImpl#isAddAfterContext <em>Add After Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetGenContextStatementImpl extends SimpleStatementImpl implements SetGenContextStatement {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected Expression context;

	/**
	 * The default value of the '{@link #isAddAfterContext() <em>Add After Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddAfterContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADD_AFTER_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddAfterContext() <em>Add After Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddAfterContext()
	 * @generated
	 * @ordered
	 */
	protected boolean addAfterContext = ADD_AFTER_CONTEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetGenContextStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.SET_GEN_CONTEXT_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Expression newContext, NotificationChain msgs) {
		Expression oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT, oldContext, newContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Expression newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT, null, msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT, null, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddAfterContext() {
		return addAfterContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddAfterContext(boolean newAddAfterContext) {
		boolean oldAddAfterContext = addAfterContext;
		addAfterContext = newAddAfterContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT, oldAddAfterContext, addAfterContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT:
				return basicSetContext(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT:
				return getContext();
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT:
				return isAddAfterContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT:
				setContext((Expression)newValue);
				return;
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT:
				setAddAfterContext((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT:
				setContext((Expression)null);
				return;
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT:
				setAddAfterContext(ADD_AFTER_CONTEXT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__CONTEXT:
				return context != null;
			case DblPackage.SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT:
				return addAfterContext != ADD_AFTER_CONTEXT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (addAfterContext: ");
		result.append(addAfterContext);
		result.append(')');
		return result.toString();
	}

} //SetGenContextStatementImpl
