/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Classifier;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.LanguageConceptClassifier;
import hub.sam.dbl.Mapping;
import hub.sam.dbl.TextualSyntaxDef;

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
 * An implementation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getExpandExpr <em>Expand Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getExtendedConcept <em>Extended Concept</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getAbstractSyntaxDef <em>Abstract Syntax Def</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getTextualSyntaxDef <em>Textual Syntax Def</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getMappingDef <em>Mapping Def</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionDefinitionImpl extends LanguageConceptClassifierImpl implements ExtensionDefinition {
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
	 * The cached value of the '{@link #getExtendedConcept() <em>Extended Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedConcept()
	 * @generated
	 * @ordered
	 */
	protected LanguageConceptClassifier extendedConcept;

	/**
	 * The cached value of the '{@link #getAbstractSyntaxDef() <em>Abstract Syntax Def</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSyntaxDef()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> abstractSyntaxDef;

	/**
	 * The cached value of the '{@link #getTextualSyntaxDef() <em>Textual Syntax Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextualSyntaxDef()
	 * @generated
	 * @ordered
	 */
	protected TextualSyntaxDef textualSyntaxDef;

	/**
	 * The cached value of the '{@link #getMappingDef() <em>Mapping Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingDef()
	 * @generated
	 * @ordered
	 */
	protected Mapping mappingDef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXTENSION_DEFINITION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR, oldExpandExpr, newExpandExpr);
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
				msgs = ((InternalEObject)expandExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR, null, msgs);
			if (newExpandExpr != null)
				msgs = ((InternalEObject)newExpandExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR, null, msgs);
			msgs = basicSetExpandExpr(newExpandExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR, newExpandExpr, newExpandExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION, oldInstanceOfExtensionDefinition, instanceOfExtensionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageConceptClassifier getExtendedConcept() {
		if (extendedConcept != null && extendedConcept.eIsProxy()) {
			InternalEObject oldExtendedConcept = (InternalEObject)extendedConcept;
			extendedConcept = (LanguageConceptClassifier)eResolveProxy(oldExtendedConcept);
			if (extendedConcept != oldExtendedConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT, oldExtendedConcept, extendedConcept));
			}
		}
		return extendedConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageConceptClassifier basicGetExtendedConcept() {
		return extendedConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedConcept(LanguageConceptClassifier newExtendedConcept) {
		LanguageConceptClassifier oldExtendedConcept = extendedConcept;
		extendedConcept = newExtendedConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT, oldExtendedConcept, extendedConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getAbstractSyntaxDef() {
		if (abstractSyntaxDef == null) {
			abstractSyntaxDef = new EObjectContainmentEList<Classifier>(Classifier.class, this, DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF);
		}
		return abstractSyntaxDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextualSyntaxDef getTextualSyntaxDef() {
		return textualSyntaxDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTextualSyntaxDef(TextualSyntaxDef newTextualSyntaxDef, NotificationChain msgs) {
		TextualSyntaxDef oldTextualSyntaxDef = textualSyntaxDef;
		textualSyntaxDef = newTextualSyntaxDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, oldTextualSyntaxDef, newTextualSyntaxDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextualSyntaxDef(TextualSyntaxDef newTextualSyntaxDef) {
		if (newTextualSyntaxDef != textualSyntaxDef) {
			NotificationChain msgs = null;
			if (textualSyntaxDef != null)
				msgs = ((InternalEObject)textualSyntaxDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, null, msgs);
			if (newTextualSyntaxDef != null)
				msgs = ((InternalEObject)newTextualSyntaxDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, null, msgs);
			msgs = basicSetTextualSyntaxDef(newTextualSyntaxDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, newTextualSyntaxDef, newTextualSyntaxDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMappingDef() {
		return mappingDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingDef(Mapping newMappingDef, NotificationChain msgs) {
		Mapping oldMappingDef = mappingDef;
		mappingDef = newMappingDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, oldMappingDef, newMappingDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingDef(Mapping newMappingDef) {
		if (newMappingDef != mappingDef) {
			NotificationChain msgs = null;
			if (mappingDef != null)
				msgs = ((InternalEObject)mappingDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, null, msgs);
			if (newMappingDef != null)
				msgs = ((InternalEObject)newMappingDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, null, msgs);
			msgs = basicSetMappingDef(newMappingDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, newMappingDef, newMappingDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR:
				return basicSetExpandExpr(null, msgs);
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return ((InternalEList<?>)getAbstractSyntaxDef()).basicRemove(otherEnd, msgs);
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return basicSetTextualSyntaxDef(null, msgs);
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				return basicSetMappingDef(null, msgs);
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
			case DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR:
				return getExpandExpr();
			case DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION:
				return isInstanceOfExtensionDefinition();
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				if (resolve) return getExtendedConcept();
				return basicGetExtendedConcept();
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return getAbstractSyntaxDef();
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return getTextualSyntaxDef();
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				return getMappingDef();
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
			case DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition((Boolean)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				setExtendedConcept((LanguageConceptClassifier)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				getAbstractSyntaxDef().clear();
				getAbstractSyntaxDef().addAll((Collection<? extends Classifier>)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				setTextualSyntaxDef((TextualSyntaxDef)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				setMappingDef((Mapping)newValue);
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
			case DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)null);
				return;
			case DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition(INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT);
				return;
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				setExtendedConcept((LanguageConceptClassifier)null);
				return;
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				getAbstractSyntaxDef().clear();
				return;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				setTextualSyntaxDef((TextualSyntaxDef)null);
				return;
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				setMappingDef((Mapping)null);
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
			case DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR:
				return expandExpr != null;
			case DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION:
				return instanceOfExtensionDefinition != INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT;
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				return extendedConcept != null;
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return abstractSyntaxDef != null && !abstractSyntaxDef.isEmpty();
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return textualSyntaxDef != null;
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				return mappingDef != null;
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
				case DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR: return DblPackage.CONSTRUCT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX: return DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
				case DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;
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
				case DblPackage.CONSTRUCT__EXPAND_EXPR: return DblPackage.EXTENSION_DEFINITION__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX: return DblPackage.EXTENSION_DEFINITION__CONCRETE_SYNTAX;
				case DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION;
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

} //ExtensionDefinitionImpl
