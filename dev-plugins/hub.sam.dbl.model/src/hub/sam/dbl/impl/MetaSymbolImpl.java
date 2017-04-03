/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ComplexSymbol;
import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.MetaSymbol;
import hub.sam.dbl.SyntaxExpression;
import hub.sam.dbl.SyntaxSymbolClassifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Symbol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.MetaSymbolImpl#getExpandExpr <em>Expand Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.MetaSymbolImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.MetaSymbolImpl#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.MetaSymbolImpl#getPossibleSyntax <em>Possible Syntax</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaSymbolImpl extends NamedElementImpl implements MetaSymbol {
	/**
	 * The cached value of the '{@link #getExpandExpr() <em>Expand Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandExpr()
	 * @generated
	 * @ordered
	 */
	protected ExpandExpr expandExpr;

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
	 * The default value of the '{@link #isInstanceOfExtensionDefinition() <em>Instance Of Extension Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstanceOfExtensionDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstanceOfExtensionDefinition() <em>Instance Of Extension Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstanceOfExtensionDefinition()
	 * @generated
	 * @ordered
	 */
	protected boolean instanceOfExtensionDefinition = INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPossibleSyntax() <em>Possible Syntax</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleSyntax()
	 * @generated
	 * @ordered
	 */
	protected SyntaxExpression possibleSyntax;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaSymbolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.META_SYMBOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandExpr getExpandExpr() {
		return expandExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpandExpr(ExpandExpr newExpandExpr, NotificationChain msgs) {
		ExpandExpr oldExpandExpr = expandExpr;
		expandExpr = newExpandExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.META_SYMBOL__EXPAND_EXPR, oldExpandExpr, newExpandExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandExpr(ExpandExpr newExpandExpr) {
		if (newExpandExpr != expandExpr) {
			NotificationChain msgs = null;
			if (expandExpr != null)
				msgs = ((InternalEObject)expandExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.META_SYMBOL__EXPAND_EXPR, null, msgs);
			if (newExpandExpr != null)
				msgs = ((InternalEObject)newExpandExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.META_SYMBOL__EXPAND_EXPR, null, msgs);
			msgs = basicSetExpandExpr(newExpandExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.META_SYMBOL__EXPAND_EXPR, newExpandExpr, newExpandExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.META_SYMBOL__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstanceOfExtensionDefinition() {
		return instanceOfExtensionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceOfExtensionDefinition(boolean newInstanceOfExtensionDefinition) {
		boolean oldInstanceOfExtensionDefinition = instanceOfExtensionDefinition;
		instanceOfExtensionDefinition = newInstanceOfExtensionDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION, oldInstanceOfExtensionDefinition, instanceOfExtensionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxExpression getPossibleSyntax() {
		return possibleSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPossibleSyntax(SyntaxExpression newPossibleSyntax, NotificationChain msgs) {
		SyntaxExpression oldPossibleSyntax = possibleSyntax;
		possibleSyntax = newPossibleSyntax;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.META_SYMBOL__POSSIBLE_SYNTAX, oldPossibleSyntax, newPossibleSyntax);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPossibleSyntax(SyntaxExpression newPossibleSyntax) {
		if (newPossibleSyntax != possibleSyntax) {
			NotificationChain msgs = null;
			if (possibleSyntax != null)
				msgs = ((InternalEObject)possibleSyntax).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.META_SYMBOL__POSSIBLE_SYNTAX, null, msgs);
			if (newPossibleSyntax != null)
				msgs = ((InternalEObject)newPossibleSyntax).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.META_SYMBOL__POSSIBLE_SYNTAX, null, msgs);
			msgs = basicSetPossibleSyntax(newPossibleSyntax, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.META_SYMBOL__POSSIBLE_SYNTAX, newPossibleSyntax, newPossibleSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.META_SYMBOL__EXPAND_EXPR:
				return basicSetExpandExpr(null, msgs);
			case DblPackage.META_SYMBOL__POSSIBLE_SYNTAX:
				return basicSetPossibleSyntax(null, msgs);
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
			case DblPackage.META_SYMBOL__EXPAND_EXPR:
				return getExpandExpr();
			case DblPackage.META_SYMBOL__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION:
				return isInstanceOfExtensionDefinition();
			case DblPackage.META_SYMBOL__POSSIBLE_SYNTAX:
				return getPossibleSyntax();
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
			case DblPackage.META_SYMBOL__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)newValue);
				return;
			case DblPackage.META_SYMBOL__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition((Boolean)newValue);
				return;
			case DblPackage.META_SYMBOL__POSSIBLE_SYNTAX:
				setPossibleSyntax((SyntaxExpression)newValue);
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
			case DblPackage.META_SYMBOL__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)null);
				return;
			case DblPackage.META_SYMBOL__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition(INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT);
				return;
			case DblPackage.META_SYMBOL__POSSIBLE_SYNTAX:
				setPossibleSyntax((SyntaxExpression)null);
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
			case DblPackage.META_SYMBOL__EXPAND_EXPR:
				return expandExpr != null;
			case DblPackage.META_SYMBOL__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION:
				return instanceOfExtensionDefinition != INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT;
			case DblPackage.META_SYMBOL__POSSIBLE_SYNTAX:
				return possibleSyntax != null;
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
		if (baseClass == Construct.class) {
			switch (derivedFeatureID) {
				case DblPackage.META_SYMBOL__EXPAND_EXPR: return DblPackage.CONSTRUCT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.META_SYMBOL__CONCRETE_SYNTAX: return DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
				case DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;
				default: return -1;
			}
		}
		if (baseClass == SyntaxSymbolClassifier.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ComplexSymbol.class) {
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
		if (baseClass == Construct.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCT__EXPAND_EXPR: return DblPackage.META_SYMBOL__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX: return DblPackage.META_SYMBOL__CONCRETE_SYNTAX;
				case DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION;
				default: return -1;
			}
		}
		if (baseClass == SyntaxSymbolClassifier.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ComplexSymbol.class) {
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
		result.append(" (concreteSyntax: ");
		result.append(concreteSyntax);
		result.append(", instanceOfExtensionDefinition: ");
		result.append(instanceOfExtensionDefinition);
		result.append(')');
		return result.toString();
	}

} //MetaSymbolImpl
