/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.Construct;
import hub.sam.dbl.ConstructiveExtension;
import hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.Function;
import hub.sam.dbl.LanguageConceptClassifier;
import hub.sam.dbl.LanguageConstructClassifier;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NativeBinding;
import hub.sam.dbl.QuotedClassContent;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.Type;
import hub.sam.dbl.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quoted Class Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getContentExtensions <em>Content Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getExpandExpr <em>Expand Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#isActive <em>Active</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getSuperClasses <em>Super Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getConstructors <em>Constructors</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.QuotedClassContentImpl#getActionsBlock <em>Actions Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuotedClassContentImpl extends QuotedCodeImpl implements QuotedClassContent {
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
	 * The cached value of the '{@link #getArrayDimensions() <em>Array Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayDimension> arrayDimensions;

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
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<NativeBinding> bindings;

	/**
	 * The cached value of the '{@link #getSuperClasses() <em>Super Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<SuperClassSpecification> superClasses;

	/**
	 * The cached value of the '{@link #getConstructors() <em>Constructors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructors()
	 * @generated
	 * @ordered
	 */
	protected EList<Constructor> constructors;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> attributes;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> methods;

	/**
	 * The cached value of the '{@link #getActionsBlock() <em>Actions Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsBlock()
	 * @generated
	 * @ordered
	 */
	protected LocalScope actionsBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuotedClassContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.QUOTED_CLASS_CONTENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getArrayDimensions() {
		if (arrayDimensions == null) {
			arrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS);
		}
		return arrayDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstructiveExtension> getContentExtensions() {
		if (contentExtensions == null) {
			contentExtensions = new EObjectContainmentEList<ConstructiveExtension>(ConstructiveExtension.class, this, DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR, oldExpandExpr, newExpandExpr);
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
				msgs = ((InternalEObject)expandExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR, null, msgs);
			if (newExpandExpr != null)
				msgs = ((InternalEObject)newExpandExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR, null, msgs);
			msgs = basicSetExpandExpr(newExpandExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR, newExpandExpr, newExpandExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION, oldInstanceOfExtensionDefinition, instanceOfExtensionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NativeBinding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<NativeBinding>(NativeBinding.class, this, DblPackage.QUOTED_CLASS_CONTENT__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Variable>(Variable.class, this, DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<Function>(Function.class, this, DblPackage.QUOTED_CLASS_CONTENT__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SuperClassSpecification> getSuperClasses() {
		if (superClasses == null) {
			superClasses = new EObjectContainmentEList<SuperClassSpecification>(SuperClassSpecification.class, this, DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES);
		}
		return superClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constructor> getConstructors() {
		if (constructors == null) {
			constructors = new EObjectContainmentWithInverseEList<Constructor>(Constructor.class, this, DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS, DblPackage.CONSTRUCTOR__OWNING_CLASS);
		}
		return constructors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalScope getActionsBlock() {
		return actionsBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionsBlock(LocalScope newActionsBlock, NotificationChain msgs) {
		LocalScope oldActionsBlock = actionsBlock;
		actionsBlock = newActionsBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK, oldActionsBlock, newActionsBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionsBlock(LocalScope newActionsBlock) {
		if (newActionsBlock != actionsBlock) {
			NotificationChain msgs = null;
			if (actionsBlock != null)
				msgs = ((InternalEObject)actionsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK, null, msgs);
			if (newActionsBlock != null)
				msgs = ((InternalEObject)newActionsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK, null, msgs);
			msgs = basicSetActionsBlock(newActionsBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK, newActionsBlock, newActionsBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstructors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS:
				return ((InternalEList<?>)getArrayDimensions()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS:
				return ((InternalEList<?>)getContentExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR:
				return basicSetExpandExpr(null, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES:
				return ((InternalEList<?>)getSuperClasses()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
				return ((InternalEList<?>)getConstructors()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK:
				return basicSetActionsBlock(null, msgs);
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
			case DblPackage.QUOTED_CLASS_CONTENT__NAME:
				return getName();
			case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS:
				return getArrayDimensions();
			case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS:
				return getContentExtensions();
			case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR:
				return getExpandExpr();
			case DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION:
				return isInstanceOfExtensionDefinition();
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIVE:
				return isActive();
			case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS:
				return getBindings();
			case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES:
				return getSuperClasses();
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
				return getConstructors();
			case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES:
				return getAttributes();
			case DblPackage.QUOTED_CLASS_CONTENT__METHODS:
				return getMethods();
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK:
				return getActionsBlock();
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
			case DblPackage.QUOTED_CLASS_CONTENT__NAME:
				setName((String)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS:
				getArrayDimensions().clear();
				getArrayDimensions().addAll((Collection<? extends ArrayDimension>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS:
				getContentExtensions().clear();
				getContentExtensions().addAll((Collection<? extends ConstructiveExtension>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition((Boolean)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends NativeBinding>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends SuperClassSpecification>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
				getConstructors().clear();
				getConstructors().addAll((Collection<? extends Constructor>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Variable>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Function>)newValue);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK:
				setActionsBlock((LocalScope)newValue);
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
			case DblPackage.QUOTED_CLASS_CONTENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS:
				getArrayDimensions().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS:
				getContentExtensions().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)null);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition(INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS:
				getBindings().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
				getConstructors().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__METHODS:
				getMethods().clear();
				return;
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK:
				setActionsBlock((LocalScope)null);
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
			case DblPackage.QUOTED_CLASS_CONTENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS:
				return arrayDimensions != null && !arrayDimensions.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS:
				return contentExtensions != null && !contentExtensions.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR:
				return expandExpr != null;
			case DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION:
				return instanceOfExtensionDefinition != INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT;
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS:
				return constructors != null && !constructors.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__METHODS:
				return methods != null && !methods.isEmpty();
			case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK:
				return actionsBlock != null;
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
				case DblPackage.QUOTED_CLASS_CONTENT__NAME: return DblPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS: return DblPackage.TYPE__ARRAY_DIMENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ConstructiveExtensionAtContentExtensionPoint.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS: return DblPackage.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR: return DblPackage.CONSTRUCT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX: return DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
				case DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;
				default: return -1;
			}
		}
		if (baseClass == LanguageConstructClassifier.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == LanguageConceptClassifier.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == hub.sam.dbl.Class.class) {
			switch (derivedFeatureID) {
				case DblPackage.QUOTED_CLASS_CONTENT__ACTIVE: return DblPackage.CLASS__ACTIVE;
				case DblPackage.QUOTED_CLASS_CONTENT__BINDINGS: return DblPackage.CLASS__BINDINGS;
				case DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES: return DblPackage.CLASS__SUPER_CLASSES;
				case DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS: return DblPackage.CLASS__CONSTRUCTORS;
				case DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES: return DblPackage.CLASS__ATTRIBUTES;
				case DblPackage.QUOTED_CLASS_CONTENT__METHODS: return DblPackage.CLASS__METHODS;
				case DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK: return DblPackage.CLASS__ACTIONS_BLOCK;
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
				case DblPackage.NAMED_ELEMENT__NAME: return DblPackage.QUOTED_CLASS_CONTENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (baseFeatureID) {
				case DblPackage.TYPE__ARRAY_DIMENSIONS: return DblPackage.QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ConstructiveExtensionAtContentExtensionPoint.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS: return DblPackage.QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCT__EXPAND_EXPR: return DblPackage.QUOTED_CLASS_CONTENT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX: return DblPackage.QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX;
				case DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION;
				default: return -1;
			}
		}
		if (baseClass == LanguageConstructClassifier.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == LanguageConceptClassifier.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == hub.sam.dbl.Class.class) {
			switch (baseFeatureID) {
				case DblPackage.CLASS__ACTIVE: return DblPackage.QUOTED_CLASS_CONTENT__ACTIVE;
				case DblPackage.CLASS__BINDINGS: return DblPackage.QUOTED_CLASS_CONTENT__BINDINGS;
				case DblPackage.CLASS__SUPER_CLASSES: return DblPackage.QUOTED_CLASS_CONTENT__SUPER_CLASSES;
				case DblPackage.CLASS__CONSTRUCTORS: return DblPackage.QUOTED_CLASS_CONTENT__CONSTRUCTORS;
				case DblPackage.CLASS__ATTRIBUTES: return DblPackage.QUOTED_CLASS_CONTENT__ATTRIBUTES;
				case DblPackage.CLASS__METHODS: return DblPackage.QUOTED_CLASS_CONTENT__METHODS;
				case DblPackage.CLASS__ACTIONS_BLOCK: return DblPackage.QUOTED_CLASS_CONTENT__ACTIONS_BLOCK;
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
		result.append(", instanceOfExtensionDefinition: ");
		result.append(instanceOfExtensionDefinition);
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //QuotedClassContentImpl
