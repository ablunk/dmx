/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ParseExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parse Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ParseExprImpl#getAstPart <em>Ast Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParseExprImpl extends ExpressionImpl implements ParseExpr {
	/**
	 * The cached value of the '{@link #getAstPart() <em>Ast Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAstPart()
	 * @generated
	 * @ordered
	 */
	protected Construct astPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParseExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.PARSE_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Construct getAstPart() {
		return astPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAstPart(Construct newAstPart, NotificationChain msgs) {
		Construct oldAstPart = astPart;
		astPart = newAstPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.PARSE_EXPR__AST_PART, oldAstPart, newAstPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAstPart(Construct newAstPart) {
		if (newAstPart != astPart) {
			NotificationChain msgs = null;
			if (astPart != null)
				msgs = ((InternalEObject)astPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.PARSE_EXPR__AST_PART, null, msgs);
			if (newAstPart != null)
				msgs = ((InternalEObject)newAstPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.PARSE_EXPR__AST_PART, null, msgs);
			msgs = basicSetAstPart(newAstPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PARSE_EXPR__AST_PART, newAstPart, newAstPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.PARSE_EXPR__AST_PART:
				return basicSetAstPart(null, msgs);
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
			case DblPackage.PARSE_EXPR__AST_PART:
				return getAstPart();
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
			case DblPackage.PARSE_EXPR__AST_PART:
				setAstPart((Construct)newValue);
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
			case DblPackage.PARSE_EXPR__AST_PART:
				setAstPart((Construct)null);
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
			case DblPackage.PARSE_EXPR__AST_PART:
				return astPart != null;
		}
		return super.eIsSet(featureID);
	}

} //ParseExprImpl
