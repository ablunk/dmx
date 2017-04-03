/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Construct;
import hub.sam.dbl.ConstructiveExtension;
import hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionSemantics;
import hub.sam.dbl.Function;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.QuotedModuleContent;
import hub.sam.dbl.Variable;

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
 * An implementation of the model object '<em><b>Quoted Module Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getContentExtensions <em>Content Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getExpandExpr <em>Expand Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getExtensionSemantics <em>Extension Semantics</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedModuleContentImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuotedModuleContentImpl extends QuotedCodeImpl implements QuotedModuleContent {
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
	 * The cached value of the '{@link #getContentExtensions() <em>Content Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstructiveExtension> contentExtensions;

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
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<hub.sam.dbl.Class> classes;

	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Extension> extensions;

	/**
	 * The cached value of the '{@link #getExtensionSemantics() <em>Extension Semantics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionSemantics()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionSemantics> extensionSemantics;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuotedModuleContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.QUOTED_MODULE_CONTENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_MODULE_CONTENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstructiveExtension> getContentExtensions() {
		if (contentExtensions == null) {
			contentExtensions = new EObjectContainmentEList<ConstructiveExtension>(ConstructiveExtension.class, this, DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS);
		}
		return contentExtensions;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR, oldExpandExpr, newExpandExpr);
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
				msgs = ((InternalEObject)expandExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR, null, msgs);
			if (newExpandExpr != null)
				msgs = ((InternalEObject)newExpandExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR, null, msgs);
			msgs = basicSetExpandExpr(newExpandExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR, newExpandExpr, newExpandExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<hub.sam.dbl.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<hub.sam.dbl.Class>(hub.sam.dbl.Class.class, this, DblPackage.QUOTED_MODULE_CONTENT__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this, DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionSemantics> getExtensionSemantics() {
		if (extensionSemantics == null) {
			extensionSemantics = new EObjectContainmentEList<ExtensionSemantics>(ExtensionSemantics.class, this, DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS);
		}
		return extensionSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this, DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, DblPackage.QUOTED_MODULE_CONTENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS:
				return ((InternalEList<?>)getContentExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR:
				return basicSetExpandExpr(null, msgs);
			case DblPackage.QUOTED_MODULE_CONTENT__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS:
				return ((InternalEList<?>)getExtensionSemantics()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_MODULE_CONTENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case DblPackage.QUOTED_MODULE_CONTENT__NAME:
				return getName();
			case DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS:
				return getContentExtensions();
			case DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR:
				return getExpandExpr();
			case DblPackage.QUOTED_MODULE_CONTENT__CLASSES:
				return getClasses();
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS:
				return getExtensions();
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS:
				return getExtensionSemantics();
			case DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS:
				return getFunctions();
			case DblPackage.QUOTED_MODULE_CONTENT__VARIABLES:
				return getVariables();
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
			case DblPackage.QUOTED_MODULE_CONTENT__NAME:
				setName((String)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS:
				getContentExtensions().clear();
				getContentExtensions().addAll((Collection<? extends ConstructiveExtension>)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends hub.sam.dbl.Class>)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS:
				getExtensionSemantics().clear();
				getExtensionSemantics().addAll((Collection<? extends ExtensionSemantics>)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
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
			case DblPackage.QUOTED_MODULE_CONTENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS:
				getContentExtensions().clear();
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)null);
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__CLASSES:
				getClasses().clear();
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS:
				getExtensions().clear();
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS:
				getExtensionSemantics().clear();
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS:
				getFunctions().clear();
				return;
			case DblPackage.QUOTED_MODULE_CONTENT__VARIABLES:
				getVariables().clear();
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
			case DblPackage.QUOTED_MODULE_CONTENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS:
				return contentExtensions != null && !contentExtensions.isEmpty();
			case DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR:
				return expandExpr != null;
			case DblPackage.QUOTED_MODULE_CONTENT__CLASSES:
				return classes != null && !classes.isEmpty();
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS:
				return extensionSemantics != null && !extensionSemantics.isEmpty();
			case DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case DblPackage.QUOTED_MODULE_CONTENT__VARIABLES:
				return variables != null && !variables.isEmpty();
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
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_MODULE_CONTENT__NAME: return DblPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == ConstructiveExtensionAtContentExtensionPoint.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS: return DblPackage.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR: return DblPackage.CONSTRUCT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == Module.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_MODULE_CONTENT__CLASSES: return DblPackage.MODULE__CLASSES;
				case DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS: return DblPackage.MODULE__EXTENSIONS;
				case DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS: return DblPackage.MODULE__EXTENSION_SEMANTICS;
				case DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS: return DblPackage.MODULE__FUNCTIONS;
				case DblPackage.QUOTED_MODULE_CONTENT__VARIABLES: return DblPackage.MODULE__VARIABLES;
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
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case DblPackage.NAMED_ELEMENT__NAME: return DblPackage.QUOTED_MODULE_CONTENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == ConstructiveExtensionAtContentExtensionPoint.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS: return DblPackage.QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCT__EXPAND_EXPR: return DblPackage.QUOTED_MODULE_CONTENT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == Module.class) {
			switch (baseFeatureID) {
				case DblPackage.MODULE__CLASSES: return DblPackage.QUOTED_MODULE_CONTENT__CLASSES;
				case DblPackage.MODULE__EXTENSIONS: return DblPackage.QUOTED_MODULE_CONTENT__EXTENSIONS;
				case DblPackage.MODULE__EXTENSION_SEMANTICS: return DblPackage.QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS;
				case DblPackage.MODULE__FUNCTIONS: return DblPackage.QUOTED_MODULE_CONTENT__FUNCTIONS;
				case DblPackage.MODULE__VARIABLES: return DblPackage.QUOTED_MODULE_CONTENT__VARIABLES;
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
		result.append(')');
		return result.toString();
	}

} //QuotedModuleContentImpl
