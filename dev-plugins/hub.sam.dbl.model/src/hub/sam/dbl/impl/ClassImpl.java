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
import hub.sam.dbl.NativeBinding;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.Type;
import hub.sam.dbl.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getContentExtensions <em>Content Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getExpandExpr <em>Expand Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder1 <em>Place Holder1</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder2 <em>Place Holder2</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder3 <em>Place Holder3</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder4 <em>Place Holder4</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder5 <em>Place Holder5</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder6 <em>Place Holder6</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder8 <em>Place Holder8</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder9 <em>Place Holder9</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getPlaceHolder10 <em>Place Holder10</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#isActive <em>Active</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getSuperClasses <em>Super Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getConstructors <em>Constructors</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassImpl#getActionsBlock <em>Actions Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements hub.sam.dbl.Class {
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
	 * The cached value of the '{@link #getPlaceHolder1() <em>Place Holder1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder1()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder1;

	/**
	 * The cached value of the '{@link #getPlaceHolder2() <em>Place Holder2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder2()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder2;

	/**
	 * The cached value of the '{@link #getPlaceHolder3() <em>Place Holder3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder3()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder3;

	/**
	 * The cached value of the '{@link #getPlaceHolder4() <em>Place Holder4</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder4()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder4;

	/**
	 * The cached value of the '{@link #getPlaceHolder5() <em>Place Holder5</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder5()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder5;

	/**
	 * The cached value of the '{@link #getPlaceHolder6() <em>Place Holder6</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder6()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder6;

	/**
	 * The cached value of the '{@link #getPlaceHolder8() <em>Place Holder8</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder8()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder8;

	/**
	 * The cached value of the '{@link #getPlaceHolder9() <em>Place Holder9</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder9()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder9;

	/**
	 * The cached value of the '{@link #getPlaceHolder10() <em>Place Holder10</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlaceHolder10()
	 * @generated
	 * @ordered
	 */
	protected ExtensibleElement placeHolder10;

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
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getArrayDimensions() {
		if (arrayDimensions == null) {
			arrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, DblPackage.CLASS__ARRAY_DIMENSIONS);
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
			contentExtensions = new EObjectContainmentEList<ConstructiveExtension>(ConstructiveExtension.class, this, DblPackage.CLASS__CONTENT_EXTENSIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__EXPAND_EXPR, oldExpandExpr, newExpandExpr);
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
				msgs = ((InternalEObject)expandExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS__EXPAND_EXPR, null, msgs);
			if (newExpandExpr != null)
				msgs = ((InternalEObject)newExpandExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS__EXPAND_EXPR, null, msgs);
			msgs = basicSetExpandExpr(newExpandExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__EXPAND_EXPR, newExpandExpr, newExpandExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION, oldInstanceOfExtensionDefinition, instanceOfExtensionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder1() {
		if (placeHolder1 != null && ((EObject)placeHolder1).eIsProxy()) {
			InternalEObject oldPlaceHolder1 = (InternalEObject)placeHolder1;
			placeHolder1 = (ExtensibleElement)eResolveProxy(oldPlaceHolder1);
			if (placeHolder1 != oldPlaceHolder1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER1, oldPlaceHolder1, placeHolder1));
			}
		}
		return placeHolder1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder1() {
		return placeHolder1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder1(ExtensibleElement newPlaceHolder1) {
		ExtensibleElement oldPlaceHolder1 = placeHolder1;
		placeHolder1 = newPlaceHolder1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER1, oldPlaceHolder1, placeHolder1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder2() {
		if (placeHolder2 != null && ((EObject)placeHolder2).eIsProxy()) {
			InternalEObject oldPlaceHolder2 = (InternalEObject)placeHolder2;
			placeHolder2 = (ExtensibleElement)eResolveProxy(oldPlaceHolder2);
			if (placeHolder2 != oldPlaceHolder2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER2, oldPlaceHolder2, placeHolder2));
			}
		}
		return placeHolder2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder2() {
		return placeHolder2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder2(ExtensibleElement newPlaceHolder2) {
		ExtensibleElement oldPlaceHolder2 = placeHolder2;
		placeHolder2 = newPlaceHolder2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER2, oldPlaceHolder2, placeHolder2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder3() {
		if (placeHolder3 != null && ((EObject)placeHolder3).eIsProxy()) {
			InternalEObject oldPlaceHolder3 = (InternalEObject)placeHolder3;
			placeHolder3 = (ExtensibleElement)eResolveProxy(oldPlaceHolder3);
			if (placeHolder3 != oldPlaceHolder3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER3, oldPlaceHolder3, placeHolder3));
			}
		}
		return placeHolder3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder3() {
		return placeHolder3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder3(ExtensibleElement newPlaceHolder3) {
		ExtensibleElement oldPlaceHolder3 = placeHolder3;
		placeHolder3 = newPlaceHolder3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER3, oldPlaceHolder3, placeHolder3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder4() {
		if (placeHolder4 != null && ((EObject)placeHolder4).eIsProxy()) {
			InternalEObject oldPlaceHolder4 = (InternalEObject)placeHolder4;
			placeHolder4 = (ExtensibleElement)eResolveProxy(oldPlaceHolder4);
			if (placeHolder4 != oldPlaceHolder4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER4, oldPlaceHolder4, placeHolder4));
			}
		}
		return placeHolder4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder4() {
		return placeHolder4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder4(ExtensibleElement newPlaceHolder4) {
		ExtensibleElement oldPlaceHolder4 = placeHolder4;
		placeHolder4 = newPlaceHolder4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER4, oldPlaceHolder4, placeHolder4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder5() {
		if (placeHolder5 != null && ((EObject)placeHolder5).eIsProxy()) {
			InternalEObject oldPlaceHolder5 = (InternalEObject)placeHolder5;
			placeHolder5 = (ExtensibleElement)eResolveProxy(oldPlaceHolder5);
			if (placeHolder5 != oldPlaceHolder5) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER5, oldPlaceHolder5, placeHolder5));
			}
		}
		return placeHolder5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder5() {
		return placeHolder5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder5(ExtensibleElement newPlaceHolder5) {
		ExtensibleElement oldPlaceHolder5 = placeHolder5;
		placeHolder5 = newPlaceHolder5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER5, oldPlaceHolder5, placeHolder5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder6() {
		if (placeHolder6 != null && ((EObject)placeHolder6).eIsProxy()) {
			InternalEObject oldPlaceHolder6 = (InternalEObject)placeHolder6;
			placeHolder6 = (ExtensibleElement)eResolveProxy(oldPlaceHolder6);
			if (placeHolder6 != oldPlaceHolder6) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER6, oldPlaceHolder6, placeHolder6));
			}
		}
		return placeHolder6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder6() {
		return placeHolder6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder6(ExtensibleElement newPlaceHolder6) {
		ExtensibleElement oldPlaceHolder6 = placeHolder6;
		placeHolder6 = newPlaceHolder6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER6, oldPlaceHolder6, placeHolder6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder8() {
		if (placeHolder8 != null && ((EObject)placeHolder8).eIsProxy()) {
			InternalEObject oldPlaceHolder8 = (InternalEObject)placeHolder8;
			placeHolder8 = (ExtensibleElement)eResolveProxy(oldPlaceHolder8);
			if (placeHolder8 != oldPlaceHolder8) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER8, oldPlaceHolder8, placeHolder8));
			}
		}
		return placeHolder8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder8() {
		return placeHolder8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder8(ExtensibleElement newPlaceHolder8) {
		ExtensibleElement oldPlaceHolder8 = placeHolder8;
		placeHolder8 = newPlaceHolder8;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER8, oldPlaceHolder8, placeHolder8));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder9() {
		if (placeHolder9 != null && ((EObject)placeHolder9).eIsProxy()) {
			InternalEObject oldPlaceHolder9 = (InternalEObject)placeHolder9;
			placeHolder9 = (ExtensibleElement)eResolveProxy(oldPlaceHolder9);
			if (placeHolder9 != oldPlaceHolder9) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER9, oldPlaceHolder9, placeHolder9));
			}
		}
		return placeHolder9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder9() {
		return placeHolder9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder9(ExtensibleElement newPlaceHolder9) {
		ExtensibleElement oldPlaceHolder9 = placeHolder9;
		placeHolder9 = newPlaceHolder9;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER9, oldPlaceHolder9, placeHolder9));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement getPlaceHolder10() {
		if (placeHolder10 != null && ((EObject)placeHolder10).eIsProxy()) {
			InternalEObject oldPlaceHolder10 = (InternalEObject)placeHolder10;
			placeHolder10 = (ExtensibleElement)eResolveProxy(oldPlaceHolder10);
			if (placeHolder10 != oldPlaceHolder10) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLASS__PLACE_HOLDER10, oldPlaceHolder10, placeHolder10));
			}
		}
		return placeHolder10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement basicGetPlaceHolder10() {
		return placeHolder10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlaceHolder10(ExtensibleElement newPlaceHolder10) {
		ExtensibleElement oldPlaceHolder10 = placeHolder10;
		placeHolder10 = newPlaceHolder10;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__PLACE_HOLDER10, oldPlaceHolder10, placeHolder10));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NativeBinding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<NativeBinding>(NativeBinding.class, this, DblPackage.CLASS__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SuperClassSpecification> getSuperClasses() {
		if (superClasses == null) {
			superClasses = new EObjectContainmentEList<SuperClassSpecification>(SuperClassSpecification.class, this, DblPackage.CLASS__SUPER_CLASSES);
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
			constructors = new EObjectContainmentWithInverseEList<Constructor>(Constructor.class, this, DblPackage.CLASS__CONSTRUCTORS, DblPackage.CONSTRUCTOR__OWNING_CLASS);
		}
		return constructors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Variable>(Variable.class, this, DblPackage.CLASS__ATTRIBUTES);
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
			methods = new EObjectContainmentEList<Function>(Function.class, this, DblPackage.CLASS__METHODS);
		}
		return methods;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__ACTIONS_BLOCK, oldActionsBlock, newActionsBlock);
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
				msgs = ((InternalEObject)actionsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS__ACTIONS_BLOCK, null, msgs);
			if (newActionsBlock != null)
				msgs = ((InternalEObject)newActionsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS__ACTIONS_BLOCK, null, msgs);
			msgs = basicSetActionsBlock(newActionsBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS__ACTIONS_BLOCK, newActionsBlock, newActionsBlock));
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
			case DblPackage.CLASS__CONSTRUCTORS:
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
			case DblPackage.CLASS__ARRAY_DIMENSIONS:
				return ((InternalEList<?>)getArrayDimensions()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__CONTENT_EXTENSIONS:
				return ((InternalEList<?>)getContentExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__EXPAND_EXPR:
				return basicSetExpandExpr(null, msgs);
			case DblPackage.CLASS__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__SUPER_CLASSES:
				return ((InternalEList<?>)getSuperClasses()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__CONSTRUCTORS:
				return ((InternalEList<?>)getConstructors()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS__ACTIONS_BLOCK:
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
			case DblPackage.CLASS__ARRAY_DIMENSIONS:
				return getArrayDimensions();
			case DblPackage.CLASS__CONTENT_EXTENSIONS:
				return getContentExtensions();
			case DblPackage.CLASS__EXPAND_EXPR:
				return getExpandExpr();
			case DblPackage.CLASS__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION:
				return isInstanceOfExtensionDefinition();
			case DblPackage.CLASS__PLACE_HOLDER1:
				if (resolve) return getPlaceHolder1();
				return basicGetPlaceHolder1();
			case DblPackage.CLASS__PLACE_HOLDER2:
				if (resolve) return getPlaceHolder2();
				return basicGetPlaceHolder2();
			case DblPackage.CLASS__PLACE_HOLDER3:
				if (resolve) return getPlaceHolder3();
				return basicGetPlaceHolder3();
			case DblPackage.CLASS__PLACE_HOLDER4:
				if (resolve) return getPlaceHolder4();
				return basicGetPlaceHolder4();
			case DblPackage.CLASS__PLACE_HOLDER5:
				if (resolve) return getPlaceHolder5();
				return basicGetPlaceHolder5();
			case DblPackage.CLASS__PLACE_HOLDER6:
				if (resolve) return getPlaceHolder6();
				return basicGetPlaceHolder6();
			case DblPackage.CLASS__PLACE_HOLDER8:
				if (resolve) return getPlaceHolder8();
				return basicGetPlaceHolder8();
			case DblPackage.CLASS__PLACE_HOLDER9:
				if (resolve) return getPlaceHolder9();
				return basicGetPlaceHolder9();
			case DblPackage.CLASS__PLACE_HOLDER10:
				if (resolve) return getPlaceHolder10();
				return basicGetPlaceHolder10();
			case DblPackage.CLASS__ACTIVE:
				return isActive();
			case DblPackage.CLASS__BINDINGS:
				return getBindings();
			case DblPackage.CLASS__SUPER_CLASSES:
				return getSuperClasses();
			case DblPackage.CLASS__CONSTRUCTORS:
				return getConstructors();
			case DblPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case DblPackage.CLASS__METHODS:
				return getMethods();
			case DblPackage.CLASS__ACTIONS_BLOCK:
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
			case DblPackage.CLASS__ARRAY_DIMENSIONS:
				getArrayDimensions().clear();
				getArrayDimensions().addAll((Collection<? extends ArrayDimension>)newValue);
				return;
			case DblPackage.CLASS__CONTENT_EXTENSIONS:
				getContentExtensions().clear();
				getContentExtensions().addAll((Collection<? extends ConstructiveExtension>)newValue);
				return;
			case DblPackage.CLASS__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)newValue);
				return;
			case DblPackage.CLASS__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition((Boolean)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER1:
				setPlaceHolder1((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER2:
				setPlaceHolder2((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER3:
				setPlaceHolder3((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER4:
				setPlaceHolder4((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER5:
				setPlaceHolder5((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER6:
				setPlaceHolder6((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER8:
				setPlaceHolder8((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER9:
				setPlaceHolder9((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__PLACE_HOLDER10:
				setPlaceHolder10((ExtensibleElement)newValue);
				return;
			case DblPackage.CLASS__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case DblPackage.CLASS__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends NativeBinding>)newValue);
				return;
			case DblPackage.CLASS__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends SuperClassSpecification>)newValue);
				return;
			case DblPackage.CLASS__CONSTRUCTORS:
				getConstructors().clear();
				getConstructors().addAll((Collection<? extends Constructor>)newValue);
				return;
			case DblPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Variable>)newValue);
				return;
			case DblPackage.CLASS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Function>)newValue);
				return;
			case DblPackage.CLASS__ACTIONS_BLOCK:
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
			case DblPackage.CLASS__ARRAY_DIMENSIONS:
				getArrayDimensions().clear();
				return;
			case DblPackage.CLASS__CONTENT_EXTENSIONS:
				getContentExtensions().clear();
				return;
			case DblPackage.CLASS__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)null);
				return;
			case DblPackage.CLASS__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition(INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT);
				return;
			case DblPackage.CLASS__PLACE_HOLDER1:
				setPlaceHolder1((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER2:
				setPlaceHolder2((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER3:
				setPlaceHolder3((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER4:
				setPlaceHolder4((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER5:
				setPlaceHolder5((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER6:
				setPlaceHolder6((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER8:
				setPlaceHolder8((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER9:
				setPlaceHolder9((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__PLACE_HOLDER10:
				setPlaceHolder10((ExtensibleElement)null);
				return;
			case DblPackage.CLASS__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case DblPackage.CLASS__BINDINGS:
				getBindings().clear();
				return;
			case DblPackage.CLASS__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case DblPackage.CLASS__CONSTRUCTORS:
				getConstructors().clear();
				return;
			case DblPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DblPackage.CLASS__METHODS:
				getMethods().clear();
				return;
			case DblPackage.CLASS__ACTIONS_BLOCK:
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
			case DblPackage.CLASS__ARRAY_DIMENSIONS:
				return arrayDimensions != null && !arrayDimensions.isEmpty();
			case DblPackage.CLASS__CONTENT_EXTENSIONS:
				return contentExtensions != null && !contentExtensions.isEmpty();
			case DblPackage.CLASS__EXPAND_EXPR:
				return expandExpr != null;
			case DblPackage.CLASS__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION:
				return instanceOfExtensionDefinition != INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT;
			case DblPackage.CLASS__PLACE_HOLDER1:
				return placeHolder1 != null;
			case DblPackage.CLASS__PLACE_HOLDER2:
				return placeHolder2 != null;
			case DblPackage.CLASS__PLACE_HOLDER3:
				return placeHolder3 != null;
			case DblPackage.CLASS__PLACE_HOLDER4:
				return placeHolder4 != null;
			case DblPackage.CLASS__PLACE_HOLDER5:
				return placeHolder5 != null;
			case DblPackage.CLASS__PLACE_HOLDER6:
				return placeHolder6 != null;
			case DblPackage.CLASS__PLACE_HOLDER8:
				return placeHolder8 != null;
			case DblPackage.CLASS__PLACE_HOLDER9:
				return placeHolder9 != null;
			case DblPackage.CLASS__PLACE_HOLDER10:
				return placeHolder10 != null;
			case DblPackage.CLASS__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case DblPackage.CLASS__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case DblPackage.CLASS__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case DblPackage.CLASS__CONSTRUCTORS:
				return constructors != null && !constructors.isEmpty();
			case DblPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DblPackage.CLASS__METHODS:
				return methods != null && !methods.isEmpty();
			case DblPackage.CLASS__ACTIONS_BLOCK:
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
		if (baseClass == Type.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLASS__ARRAY_DIMENSIONS: return DblPackage.TYPE__ARRAY_DIMENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ConstructiveExtensionAtContentExtensionPoint.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLASS__CONTENT_EXTENSIONS: return DblPackage.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLASS__EXPAND_EXPR: return DblPackage.CONSTRUCT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLASS__CONCRETE_SYNTAX: return DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
				case DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;
				case DblPackage.CLASS__PLACE_HOLDER1: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER1;
				case DblPackage.CLASS__PLACE_HOLDER2: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER2;
				case DblPackage.CLASS__PLACE_HOLDER3: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER3;
				case DblPackage.CLASS__PLACE_HOLDER4: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER4;
				case DblPackage.CLASS__PLACE_HOLDER5: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER5;
				case DblPackage.CLASS__PLACE_HOLDER6: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER6;
				case DblPackage.CLASS__PLACE_HOLDER8: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER8;
				case DblPackage.CLASS__PLACE_HOLDER9: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER9;
				case DblPackage.CLASS__PLACE_HOLDER10: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER10;
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
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Type.class) {
			switch (baseFeatureID) {
				case DblPackage.TYPE__ARRAY_DIMENSIONS: return DblPackage.CLASS__ARRAY_DIMENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ConstructiveExtensionAtContentExtensionPoint.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS: return DblPackage.CLASS__CONTENT_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCT__EXPAND_EXPR: return DblPackage.CLASS__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX: return DblPackage.CLASS__CONCRETE_SYNTAX;
				case DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.CLASS__INSTANCE_OF_EXTENSION_DEFINITION;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER1: return DblPackage.CLASS__PLACE_HOLDER1;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER2: return DblPackage.CLASS__PLACE_HOLDER2;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER3: return DblPackage.CLASS__PLACE_HOLDER3;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER4: return DblPackage.CLASS__PLACE_HOLDER4;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER5: return DblPackage.CLASS__PLACE_HOLDER5;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER6: return DblPackage.CLASS__PLACE_HOLDER6;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER8: return DblPackage.CLASS__PLACE_HOLDER8;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER9: return DblPackage.CLASS__PLACE_HOLDER9;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER10: return DblPackage.CLASS__PLACE_HOLDER10;
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
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
