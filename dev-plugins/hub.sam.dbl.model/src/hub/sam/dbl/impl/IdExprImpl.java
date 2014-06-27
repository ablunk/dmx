/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.CallPart;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.PredefinedId;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Id Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.IdExprImpl#getParentIdExpr <em>Parent Id Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IdExprImpl#getReferencedElement <em>Referenced Element</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IdExprImpl#getPredefinedId <em>Predefined Id</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IdExprImpl#getArrayIndex <em>Array Index</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IdExprImpl#getCallPart <em>Call Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdExprImpl extends L1ExprImpl implements IdExpr {
	/**
	 * The cached value of the '{@link #getParentIdExpr() <em>Parent Id Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentIdExpr()
	 * @generated
	 * @ordered
	 */
	protected IdExpr parentIdExpr;

	/**
	 * The cached value of the '{@link #getReferencedElement() <em>Referenced Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement referencedElement;

	/**
	 * The cached value of the '{@link #getPredefinedId() <em>Predefined Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedId()
	 * @generated
	 * @ordered
	 */
	protected PredefinedId predefinedId;

	/**
	 * The cached value of the '{@link #getArrayIndex() <em>Array Index</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayIndex()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> arrayIndex;

	/**
	 * The cached value of the '{@link #getCallPart() <em>Call Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallPart()
	 * @generated
	 * @ordered
	 */
	protected CallPart callPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.ID_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getParentIdExpr() {
		return parentIdExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentIdExpr(IdExpr newParentIdExpr, NotificationChain msgs) {
		IdExpr oldParentIdExpr = parentIdExpr;
		parentIdExpr = newParentIdExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__PARENT_ID_EXPR, oldParentIdExpr, newParentIdExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentIdExpr(IdExpr newParentIdExpr) {
		if (newParentIdExpr != parentIdExpr) {
			NotificationChain msgs = null;
			if (parentIdExpr != null)
				msgs = ((InternalEObject)parentIdExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.ID_EXPR__PARENT_ID_EXPR, null, msgs);
			if (newParentIdExpr != null)
				msgs = ((InternalEObject)newParentIdExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.ID_EXPR__PARENT_ID_EXPR, null, msgs);
			msgs = basicSetParentIdExpr(newParentIdExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__PARENT_ID_EXPR, newParentIdExpr, newParentIdExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getReferencedElement() {
		if (referencedElement != null && referencedElement.eIsProxy()) {
			InternalEObject oldReferencedElement = (InternalEObject)referencedElement;
			referencedElement = (NamedElement)eResolveProxy(oldReferencedElement);
			if (referencedElement != oldReferencedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.ID_EXPR__REFERENCED_ELEMENT, oldReferencedElement, referencedElement));
			}
		}
		return referencedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetReferencedElement() {
		return referencedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedElement(NamedElement newReferencedElement) {
		NamedElement oldReferencedElement = referencedElement;
		referencedElement = newReferencedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__REFERENCED_ELEMENT, oldReferencedElement, referencedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedId getPredefinedId() {
		return predefinedId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredefinedId(PredefinedId newPredefinedId, NotificationChain msgs) {
		PredefinedId oldPredefinedId = predefinedId;
		predefinedId = newPredefinedId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__PREDEFINED_ID, oldPredefinedId, newPredefinedId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedId(PredefinedId newPredefinedId) {
		if (newPredefinedId != predefinedId) {
			NotificationChain msgs = null;
			if (predefinedId != null)
				msgs = ((InternalEObject)predefinedId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.ID_EXPR__PREDEFINED_ID, null, msgs);
			if (newPredefinedId != null)
				msgs = ((InternalEObject)newPredefinedId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.ID_EXPR__PREDEFINED_ID, null, msgs);
			msgs = basicSetPredefinedId(newPredefinedId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__PREDEFINED_ID, newPredefinedId, newPredefinedId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getArrayIndex() {
		if (arrayIndex == null) {
			arrayIndex = new EObjectContainmentEList<Expression>(Expression.class, this, DblPackage.ID_EXPR__ARRAY_INDEX);
		}
		return arrayIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallPart getCallPart() {
		return callPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallPart(CallPart newCallPart, NotificationChain msgs) {
		CallPart oldCallPart = callPart;
		callPart = newCallPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__CALL_PART, oldCallPart, newCallPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallPart(CallPart newCallPart) {
		if (newCallPart != callPart) {
			NotificationChain msgs = null;
			if (callPart != null)
				msgs = ((InternalEObject)callPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.ID_EXPR__CALL_PART, null, msgs);
			if (newCallPart != null)
				msgs = ((InternalEObject)newCallPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.ID_EXPR__CALL_PART, null, msgs);
			msgs = basicSetCallPart(newCallPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ID_EXPR__CALL_PART, newCallPart, newCallPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.ID_EXPR__PARENT_ID_EXPR:
				return basicSetParentIdExpr(null, msgs);
			case DblPackage.ID_EXPR__PREDEFINED_ID:
				return basicSetPredefinedId(null, msgs);
			case DblPackage.ID_EXPR__ARRAY_INDEX:
				return ((InternalEList<?>)getArrayIndex()).basicRemove(otherEnd, msgs);
			case DblPackage.ID_EXPR__CALL_PART:
				return basicSetCallPart(null, msgs);
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
			case DblPackage.ID_EXPR__PARENT_ID_EXPR:
				return getParentIdExpr();
			case DblPackage.ID_EXPR__REFERENCED_ELEMENT:
				if (resolve) return getReferencedElement();
				return basicGetReferencedElement();
			case DblPackage.ID_EXPR__PREDEFINED_ID:
				return getPredefinedId();
			case DblPackage.ID_EXPR__ARRAY_INDEX:
				return getArrayIndex();
			case DblPackage.ID_EXPR__CALL_PART:
				return getCallPart();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DblPackage.ID_EXPR__PARENT_ID_EXPR:
				setParentIdExpr((IdExpr)newValue);
				return;
			case DblPackage.ID_EXPR__REFERENCED_ELEMENT:
				setReferencedElement((NamedElement)newValue);
				return;
			case DblPackage.ID_EXPR__PREDEFINED_ID:
				setPredefinedId((PredefinedId)newValue);
				return;
			case DblPackage.ID_EXPR__ARRAY_INDEX:
				getArrayIndex().clear();
				getArrayIndex().addAll((Collection<? extends Expression>)newValue);
				return;
			case DblPackage.ID_EXPR__CALL_PART:
				setCallPart((CallPart)newValue);
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
			case DblPackage.ID_EXPR__PARENT_ID_EXPR:
				setParentIdExpr((IdExpr)null);
				return;
			case DblPackage.ID_EXPR__REFERENCED_ELEMENT:
				setReferencedElement((NamedElement)null);
				return;
			case DblPackage.ID_EXPR__PREDEFINED_ID:
				setPredefinedId((PredefinedId)null);
				return;
			case DblPackage.ID_EXPR__ARRAY_INDEX:
				getArrayIndex().clear();
				return;
			case DblPackage.ID_EXPR__CALL_PART:
				setCallPart((CallPart)null);
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
			case DblPackage.ID_EXPR__PARENT_ID_EXPR:
				return parentIdExpr != null;
			case DblPackage.ID_EXPR__REFERENCED_ELEMENT:
				return referencedElement != null;
			case DblPackage.ID_EXPR__PREDEFINED_ID:
				return predefinedId != null;
			case DblPackage.ID_EXPR__ARRAY_INDEX:
				return arrayIndex != null && !arrayIndex.isEmpty();
			case DblPackage.ID_EXPR__CALL_PART:
				return callPart != null;
		}
		return super.eIsSet(featureID);
	}

} //IdExprImpl
