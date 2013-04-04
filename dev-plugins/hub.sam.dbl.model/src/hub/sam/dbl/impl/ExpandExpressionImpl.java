/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpression;
import hub.sam.dbl.ExpandableElement;
import hub.sam.dbl.Expression;
import hub.sam.dbl.Extension;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NamedExtension;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expand Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExpandExpressionImpl#getExpandExpression <em>Expand Expression</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpandExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpandExpressionImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExpandExpressionImpl#getMetaObject <em>Meta Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpandExpressionImpl extends StatementExpressionImpl implements ExpandExpression {
	/**
	 * The cached value of the '{@link #getExpandExpression() <em>Expand Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpandExpression expandExpression;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getConcreteSyntax() <em>Concrete Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteSyntax()
	 * @generated
	 * @ordered
	 */
	protected static final String CONCRETE_SYNTAX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConcreteSyntax() <em>Concrete Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteSyntax()
	 * @generated
	 * @ordered
	 */
	protected String concreteSyntax = CONCRETE_SYNTAX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetaObject() <em>Meta Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaObject()
	 * @generated
	 * @ordered
	 */
	protected Expression metaObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpandExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXPAND_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandExpression getExpandExpression() {
		return expandExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpandExpression(ExpandExpression newExpandExpression, NotificationChain msgs) {
		ExpandExpression oldExpandExpression = expandExpression;
		expandExpression = newExpandExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION, oldExpandExpression, newExpandExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandExpression(ExpandExpression newExpandExpression) {
		if (newExpandExpression != expandExpression) {
			NotificationChain msgs = null;
			if (expandExpression != null)
				msgs = ((InternalEObject)expandExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION, null, msgs);
			if (newExpandExpression != null)
				msgs = ((InternalEObject)newExpandExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION, null, msgs);
			msgs = basicSetExpandExpression(newExpandExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION, newExpandExpression, newExpandExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPAND_EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConcreteSyntax() {
		return concreteSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcreteSyntax(String newConcreteSyntax) {
		String oldConcreteSyntax = concreteSyntax;
		concreteSyntax = newConcreteSyntax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getMetaObject() {
		return metaObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaObject(Expression newMetaObject, NotificationChain msgs) {
		Expression oldMetaObject = metaObject;
		metaObject = newMetaObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXPAND_EXPRESSION__META_OBJECT, oldMetaObject, newMetaObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaObject(Expression newMetaObject) {
		if (newMetaObject != metaObject) {
			NotificationChain msgs = null;
			if (metaObject != null)
				msgs = ((InternalEObject)metaObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPAND_EXPRESSION__META_OBJECT, null, msgs);
			if (newMetaObject != null)
				msgs = ((InternalEObject)newMetaObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXPAND_EXPRESSION__META_OBJECT, null, msgs);
			msgs = basicSetMetaObject(newMetaObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXPAND_EXPRESSION__META_OBJECT, newMetaObject, newMetaObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION:
				return basicSetExpandExpression(null, msgs);
			case DblPackage.EXPAND_EXPRESSION__META_OBJECT:
				return basicSetMetaObject(null, msgs);
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
			case DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION:
				return getExpandExpression();
			case DblPackage.EXPAND_EXPRESSION__NAME:
				return getName();
			case DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.EXPAND_EXPRESSION__META_OBJECT:
				return getMetaObject();
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
			case DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION:
				setExpandExpression((ExpandExpression)newValue);
				return;
			case DblPackage.EXPAND_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.EXPAND_EXPRESSION__META_OBJECT:
				setMetaObject((Expression)newValue);
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
			case DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION:
				setExpandExpression((ExpandExpression)null);
				return;
			case DblPackage.EXPAND_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.EXPAND_EXPRESSION__META_OBJECT:
				setMetaObject((Expression)null);
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
			case DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION:
				return expandExpression != null;
			case DblPackage.EXPAND_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.EXPAND_EXPRESSION__META_OBJECT:
				return metaObject != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Extension.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ExpandableElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION: return DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.EXPAND_EXPRESSION__NAME: return DblPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == NamedExtension.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (derivedFeatureID) {
				case DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX: return DblPackage.CONSTRUCT__CONCRETE_SYNTAX;
				default: return -1;
			}
		}
		if (baseClass == Expression.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Extension.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ExpandableElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXPANDABLE_ELEMENT__EXPAND_EXPRESSION: return DblPackage.EXPAND_EXPRESSION__EXPAND_EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case DblPackage.NAMED_ELEMENT__NAME: return DblPackage.EXPAND_EXPRESSION__NAME;
				default: return -1;
			}
		}
		if (baseClass == NamedExtension.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCT__CONCRETE_SYNTAX: return DblPackage.EXPAND_EXPRESSION__CONCRETE_SYNTAX;
				default: return -1;
			}
		}
		if (baseClass == Expression.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", concreteSyntax: ");
		result.append(concreteSyntax);
		result.append(')');
		return result.toString();
	}

} //ExpandExpressionImpl
