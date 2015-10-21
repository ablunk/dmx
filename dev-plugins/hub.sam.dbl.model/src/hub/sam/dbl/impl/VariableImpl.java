/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.SimpleStatement;
import hub.sam.dbl.Statement;
import hub.sam.dbl.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getExpandExpr <em>Expand Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder1 <em>Place Holder1</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder2 <em>Place Holder2</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder3 <em>Place Holder3</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder4 <em>Place Holder4</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder5 <em>Place Holder5</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder6 <em>Place Holder6</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder8 <em>Place Holder8</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder9 <em>Place Holder9</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getPlaceHolder10 <em>Place Holder10</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#isControl <em>Control</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#isClass <em>Class</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends AbstractVariableImpl implements Variable {
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
	 * The default value of the '{@link #isControl() <em>Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isControl()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTROL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isControl() <em>Control</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isControl()
	 * @generated
	 * @ordered
	 */
	protected boolean control = CONTROL_EDEFAULT;

	/**
	 * The default value of the '{@link #isClass() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClass() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClass()
	 * @generated
	 * @ordered
	 */
	protected boolean class_ = CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected Expression initialValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.VARIABLE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__EXPAND_EXPR, oldExpandExpr, newExpandExpr);
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
				msgs = ((InternalEObject)expandExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.VARIABLE__EXPAND_EXPR, null, msgs);
			if (newExpandExpr != null)
				msgs = ((InternalEObject)newExpandExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.VARIABLE__EXPAND_EXPR, null, msgs);
			msgs = basicSetExpandExpr(newExpandExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__EXPAND_EXPR, newExpandExpr, newExpandExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION, oldInstanceOfExtensionDefinition, instanceOfExtensionDefinition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER1, oldPlaceHolder1, placeHolder1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER1, oldPlaceHolder1, placeHolder1));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER2, oldPlaceHolder2, placeHolder2));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER2, oldPlaceHolder2, placeHolder2));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER3, oldPlaceHolder3, placeHolder3));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER3, oldPlaceHolder3, placeHolder3));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER4, oldPlaceHolder4, placeHolder4));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER4, oldPlaceHolder4, placeHolder4));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER5, oldPlaceHolder5, placeHolder5));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER5, oldPlaceHolder5, placeHolder5));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER6, oldPlaceHolder6, placeHolder6));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER6, oldPlaceHolder6, placeHolder6));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER8, oldPlaceHolder8, placeHolder8));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER8, oldPlaceHolder8, placeHolder8));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER9, oldPlaceHolder9, placeHolder9));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER9, oldPlaceHolder9, placeHolder9));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.VARIABLE__PLACE_HOLDER10, oldPlaceHolder10, placeHolder10));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__PLACE_HOLDER10, oldPlaceHolder10, placeHolder10));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isControl() {
		return control;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControl(boolean newControl) {
		boolean oldControl = control;
		control = newControl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__CONTROL, oldControl, control));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(boolean newClass) {
		boolean oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialValue(Expression newInitialValue, NotificationChain msgs) {
		Expression oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__INITIAL_VALUE, oldInitialValue, newInitialValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(Expression newInitialValue) {
		if (newInitialValue != initialValue) {
			NotificationChain msgs = null;
			if (initialValue != null)
				msgs = ((InternalEObject)initialValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.VARIABLE__INITIAL_VALUE, null, msgs);
			if (newInitialValue != null)
				msgs = ((InternalEObject)newInitialValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.VARIABLE__INITIAL_VALUE, null, msgs);
			msgs = basicSetInitialValue(newInitialValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__INITIAL_VALUE, newInitialValue, newInitialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.VARIABLE__EXPAND_EXPR:
				return basicSetExpandExpr(null, msgs);
			case DblPackage.VARIABLE__INITIAL_VALUE:
				return basicSetInitialValue(null, msgs);
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
			case DblPackage.VARIABLE__EXPAND_EXPR:
				return getExpandExpr();
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION:
				return isInstanceOfExtensionDefinition();
			case DblPackage.VARIABLE__PLACE_HOLDER1:
				if (resolve) return getPlaceHolder1();
				return basicGetPlaceHolder1();
			case DblPackage.VARIABLE__PLACE_HOLDER2:
				if (resolve) return getPlaceHolder2();
				return basicGetPlaceHolder2();
			case DblPackage.VARIABLE__PLACE_HOLDER3:
				if (resolve) return getPlaceHolder3();
				return basicGetPlaceHolder3();
			case DblPackage.VARIABLE__PLACE_HOLDER4:
				if (resolve) return getPlaceHolder4();
				return basicGetPlaceHolder4();
			case DblPackage.VARIABLE__PLACE_HOLDER5:
				if (resolve) return getPlaceHolder5();
				return basicGetPlaceHolder5();
			case DblPackage.VARIABLE__PLACE_HOLDER6:
				if (resolve) return getPlaceHolder6();
				return basicGetPlaceHolder6();
			case DblPackage.VARIABLE__PLACE_HOLDER8:
				if (resolve) return getPlaceHolder8();
				return basicGetPlaceHolder8();
			case DblPackage.VARIABLE__PLACE_HOLDER9:
				if (resolve) return getPlaceHolder9();
				return basicGetPlaceHolder9();
			case DblPackage.VARIABLE__PLACE_HOLDER10:
				if (resolve) return getPlaceHolder10();
				return basicGetPlaceHolder10();
			case DblPackage.VARIABLE__CONTROL:
				return isControl();
			case DblPackage.VARIABLE__CLASS:
				return isClass();
			case DblPackage.VARIABLE__INITIAL_VALUE:
				return getInitialValue();
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
			case DblPackage.VARIABLE__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)newValue);
				return;
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition((Boolean)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER1:
				setPlaceHolder1((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER2:
				setPlaceHolder2((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER3:
				setPlaceHolder3((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER4:
				setPlaceHolder4((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER5:
				setPlaceHolder5((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER6:
				setPlaceHolder6((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER8:
				setPlaceHolder8((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER9:
				setPlaceHolder9((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER10:
				setPlaceHolder10((ExtensibleElement)newValue);
				return;
			case DblPackage.VARIABLE__CONTROL:
				setControl((Boolean)newValue);
				return;
			case DblPackage.VARIABLE__CLASS:
				setClass((Boolean)newValue);
				return;
			case DblPackage.VARIABLE__INITIAL_VALUE:
				setInitialValue((Expression)newValue);
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
			case DblPackage.VARIABLE__EXPAND_EXPR:
				setExpandExpr((ExpandExpr)null);
				return;
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION:
				setInstanceOfExtensionDefinition(INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER1:
				setPlaceHolder1((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER2:
				setPlaceHolder2((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER3:
				setPlaceHolder3((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER4:
				setPlaceHolder4((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER5:
				setPlaceHolder5((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER6:
				setPlaceHolder6((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER8:
				setPlaceHolder8((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER9:
				setPlaceHolder9((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__PLACE_HOLDER10:
				setPlaceHolder10((ExtensibleElement)null);
				return;
			case DblPackage.VARIABLE__CONTROL:
				setControl(CONTROL_EDEFAULT);
				return;
			case DblPackage.VARIABLE__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case DblPackage.VARIABLE__INITIAL_VALUE:
				setInitialValue((Expression)null);
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
			case DblPackage.VARIABLE__EXPAND_EXPR:
				return expandExpr != null;
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION:
				return instanceOfExtensionDefinition != INSTANCE_OF_EXTENSION_DEFINITION_EDEFAULT;
			case DblPackage.VARIABLE__PLACE_HOLDER1:
				return placeHolder1 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER2:
				return placeHolder2 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER3:
				return placeHolder3 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER4:
				return placeHolder4 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER5:
				return placeHolder5 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER6:
				return placeHolder6 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER8:
				return placeHolder8 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER9:
				return placeHolder9 != null;
			case DblPackage.VARIABLE__PLACE_HOLDER10:
				return placeHolder10 != null;
			case DblPackage.VARIABLE__CONTROL:
				return control != CONTROL_EDEFAULT;
			case DblPackage.VARIABLE__CLASS:
				return class_ != CLASS_EDEFAULT;
			case DblPackage.VARIABLE__INITIAL_VALUE:
				return initialValue != null;
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
				case DblPackage.VARIABLE__EXPAND_EXPR: return DblPackage.CONSTRUCT__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.VARIABLE__CONCRETE_SYNTAX: return DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
				case DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;
				case DblPackage.VARIABLE__PLACE_HOLDER1: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER1;
				case DblPackage.VARIABLE__PLACE_HOLDER2: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER2;
				case DblPackage.VARIABLE__PLACE_HOLDER3: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER3;
				case DblPackage.VARIABLE__PLACE_HOLDER4: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER4;
				case DblPackage.VARIABLE__PLACE_HOLDER5: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER5;
				case DblPackage.VARIABLE__PLACE_HOLDER6: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER6;
				case DblPackage.VARIABLE__PLACE_HOLDER8: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER8;
				case DblPackage.VARIABLE__PLACE_HOLDER9: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER9;
				case DblPackage.VARIABLE__PLACE_HOLDER10: return DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER10;
				default: return -1;
			}
		}
		if (baseClass == Statement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SimpleStatement.class) {
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
				case DblPackage.CONSTRUCT__EXPAND_EXPR: return DblPackage.VARIABLE__EXPAND_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX: return DblPackage.VARIABLE__CONCRETE_SYNTAX;
				case DblPackage.EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION: return DblPackage.VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER1: return DblPackage.VARIABLE__PLACE_HOLDER1;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER2: return DblPackage.VARIABLE__PLACE_HOLDER2;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER3: return DblPackage.VARIABLE__PLACE_HOLDER3;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER4: return DblPackage.VARIABLE__PLACE_HOLDER4;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER5: return DblPackage.VARIABLE__PLACE_HOLDER5;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER6: return DblPackage.VARIABLE__PLACE_HOLDER6;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER8: return DblPackage.VARIABLE__PLACE_HOLDER8;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER9: return DblPackage.VARIABLE__PLACE_HOLDER9;
				case DblPackage.EXTENSIBLE_ELEMENT__PLACE_HOLDER10: return DblPackage.VARIABLE__PLACE_HOLDER10;
				default: return -1;
			}
		}
		if (baseClass == Statement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SimpleStatement.class) {
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
		result.append(", control: ");
		result.append(control);
		result.append(", class: ");
		result.append(class_);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
