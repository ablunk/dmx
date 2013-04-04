/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ClassSimilar;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.EmbeddableExtensionsContainer;
import hub.sam.dbl.Expression;
import hub.sam.dbl.Extension;
import hub.sam.dbl.Interface;
import hub.sam.dbl.ModifierExtensionsContainer;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.StartCodeBlock;
import hub.sam.dbl.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clazz</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getModifierExtensions <em>Modifier Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getImplementedInterfaces <em>Implemented Interfaces</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getInitialBlock <em>Initial Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getFinalBlock <em>Final Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getActionsBlock <em>Actions Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getReportBlock <em>Report Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getClearBlock <em>Clear Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#isActive <em>Active</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClazzImpl#getBaseConstructorArguments <em>Base Constructor Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClazzImpl extends ClassifierImpl implements Clazz {
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
	 * The cached value of the '{@link #getModifierExtensions() <em>Modifier Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifierExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Extension> modifierExtensions;

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
	protected EList<Procedure> methods;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected Clazz superClass;

	/**
	 * The cached value of the '{@link #getImplementedInterfaces() <em>Implemented Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> implementedInterfaces;

	/**
	 * The cached value of the '{@link #getInitialBlock() <em>Initial Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialBlock()
	 * @generated
	 * @ordered
	 */
	protected StartCodeBlock initialBlock;

	/**
	 * The cached value of the '{@link #getFinalBlock() <em>Final Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalBlock()
	 * @generated
	 * @ordered
	 */
	protected StartCodeBlock finalBlock;

	/**
	 * The cached value of the '{@link #getActionsBlock() <em>Actions Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsBlock()
	 * @generated
	 * @ordered
	 */
	protected StartCodeBlock actionsBlock;

	/**
	 * The cached value of the '{@link #getReportBlock() <em>Report Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReportBlock()
	 * @generated
	 * @ordered
	 */
	protected StartCodeBlock reportBlock;

	/**
	 * The cached value of the '{@link #getClearBlock() <em>Clear Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearBlock()
	 * @generated
	 * @ordered
	 */
	protected StartCodeBlock clearBlock;

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
	 * The cached value of the '{@link #getConstructor() <em>Constructor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructor()
	 * @generated
	 * @ordered
	 */
	protected Constructor constructor;

	/**
	 * The cached value of the '{@link #getBaseConstructorArguments() <em>Base Constructor Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseConstructorArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> baseConstructorArguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClazzImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.CLAZZ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this, DblPackage.CLAZZ__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Extension> getModifierExtensions() {
		if (modifierExtensions == null) {
			modifierExtensions = new EObjectContainmentEList<Extension>(Extension.class, this, DblPackage.CLAZZ__MODIFIER_EXTENSIONS);
		}
		return modifierExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Variable>(Variable.class, this, DblPackage.CLAZZ__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Procedure> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<Procedure>(Procedure.class, this, DblPackage.CLAZZ__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clazz getSuperClass() {
		if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject)superClass;
			superClass = (Clazz)eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.CLAZZ__SUPER_CLASS, oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clazz basicGetSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(Clazz newSuperClass) {
		Clazz oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__SUPER_CLASS, oldSuperClass, superClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getImplementedInterfaces() {
		if (implementedInterfaces == null) {
			implementedInterfaces = new EObjectResolvingEList<Interface>(Interface.class, this, DblPackage.CLAZZ__IMPLEMENTED_INTERFACES);
		}
		return implementedInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartCodeBlock getInitialBlock() {
		return initialBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialBlock(StartCodeBlock newInitialBlock, NotificationChain msgs) {
		StartCodeBlock oldInitialBlock = initialBlock;
		initialBlock = newInitialBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__INITIAL_BLOCK, oldInitialBlock, newInitialBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialBlock(StartCodeBlock newInitialBlock) {
		if (newInitialBlock != initialBlock) {
			NotificationChain msgs = null;
			if (initialBlock != null)
				msgs = ((InternalEObject)initialBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__INITIAL_BLOCK, null, msgs);
			if (newInitialBlock != null)
				msgs = ((InternalEObject)newInitialBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__INITIAL_BLOCK, null, msgs);
			msgs = basicSetInitialBlock(newInitialBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__INITIAL_BLOCK, newInitialBlock, newInitialBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartCodeBlock getFinalBlock() {
		return finalBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinalBlock(StartCodeBlock newFinalBlock, NotificationChain msgs) {
		StartCodeBlock oldFinalBlock = finalBlock;
		finalBlock = newFinalBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__FINAL_BLOCK, oldFinalBlock, newFinalBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalBlock(StartCodeBlock newFinalBlock) {
		if (newFinalBlock != finalBlock) {
			NotificationChain msgs = null;
			if (finalBlock != null)
				msgs = ((InternalEObject)finalBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__FINAL_BLOCK, null, msgs);
			if (newFinalBlock != null)
				msgs = ((InternalEObject)newFinalBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__FINAL_BLOCK, null, msgs);
			msgs = basicSetFinalBlock(newFinalBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__FINAL_BLOCK, newFinalBlock, newFinalBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartCodeBlock getActionsBlock() {
		return actionsBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionsBlock(StartCodeBlock newActionsBlock, NotificationChain msgs) {
		StartCodeBlock oldActionsBlock = actionsBlock;
		actionsBlock = newActionsBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__ACTIONS_BLOCK, oldActionsBlock, newActionsBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionsBlock(StartCodeBlock newActionsBlock) {
		if (newActionsBlock != actionsBlock) {
			NotificationChain msgs = null;
			if (actionsBlock != null)
				msgs = ((InternalEObject)actionsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__ACTIONS_BLOCK, null, msgs);
			if (newActionsBlock != null)
				msgs = ((InternalEObject)newActionsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__ACTIONS_BLOCK, null, msgs);
			msgs = basicSetActionsBlock(newActionsBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__ACTIONS_BLOCK, newActionsBlock, newActionsBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartCodeBlock getReportBlock() {
		return reportBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReportBlock(StartCodeBlock newReportBlock, NotificationChain msgs) {
		StartCodeBlock oldReportBlock = reportBlock;
		reportBlock = newReportBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__REPORT_BLOCK, oldReportBlock, newReportBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReportBlock(StartCodeBlock newReportBlock) {
		if (newReportBlock != reportBlock) {
			NotificationChain msgs = null;
			if (reportBlock != null)
				msgs = ((InternalEObject)reportBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__REPORT_BLOCK, null, msgs);
			if (newReportBlock != null)
				msgs = ((InternalEObject)newReportBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__REPORT_BLOCK, null, msgs);
			msgs = basicSetReportBlock(newReportBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__REPORT_BLOCK, newReportBlock, newReportBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartCodeBlock getClearBlock() {
		return clearBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClearBlock(StartCodeBlock newClearBlock, NotificationChain msgs) {
		StartCodeBlock oldClearBlock = clearBlock;
		clearBlock = newClearBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__CLEAR_BLOCK, oldClearBlock, newClearBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClearBlock(StartCodeBlock newClearBlock) {
		if (newClearBlock != clearBlock) {
			NotificationChain msgs = null;
			if (clearBlock != null)
				msgs = ((InternalEObject)clearBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__CLEAR_BLOCK, null, msgs);
			if (newClearBlock != null)
				msgs = ((InternalEObject)newClearBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__CLEAR_BLOCK, null, msgs);
			msgs = basicSetClearBlock(newClearBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__CLEAR_BLOCK, newClearBlock, newClearBlock));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constructor getConstructor() {
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstructor(Constructor newConstructor, NotificationChain msgs) {
		Constructor oldConstructor = constructor;
		constructor = newConstructor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__CONSTRUCTOR, oldConstructor, newConstructor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructor(Constructor newConstructor) {
		if (newConstructor != constructor) {
			NotificationChain msgs = null;
			if (constructor != null)
				msgs = ((InternalEObject)constructor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__CONSTRUCTOR, null, msgs);
			if (newConstructor != null)
				msgs = ((InternalEObject)newConstructor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLAZZ__CONSTRUCTOR, null, msgs);
			msgs = basicSetConstructor(newConstructor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLAZZ__CONSTRUCTOR, newConstructor, newConstructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getBaseConstructorArguments() {
		if (baseConstructorArguments == null) {
			baseConstructorArguments = new EObjectContainmentEList<Expression>(Expression.class, this, DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS);
		}
		return baseConstructorArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.CLAZZ__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.CLAZZ__MODIFIER_EXTENSIONS:
				return ((InternalEList<?>)getModifierExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.CLAZZ__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case DblPackage.CLAZZ__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case DblPackage.CLAZZ__INITIAL_BLOCK:
				return basicSetInitialBlock(null, msgs);
			case DblPackage.CLAZZ__FINAL_BLOCK:
				return basicSetFinalBlock(null, msgs);
			case DblPackage.CLAZZ__ACTIONS_BLOCK:
				return basicSetActionsBlock(null, msgs);
			case DblPackage.CLAZZ__REPORT_BLOCK:
				return basicSetReportBlock(null, msgs);
			case DblPackage.CLAZZ__CLEAR_BLOCK:
				return basicSetClearBlock(null, msgs);
			case DblPackage.CLAZZ__CONSTRUCTOR:
				return basicSetConstructor(null, msgs);
			case DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS:
				return ((InternalEList<?>)getBaseConstructorArguments()).basicRemove(otherEnd, msgs);
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
			case DblPackage.CLAZZ__EXTENSIONS:
				return getExtensions();
			case DblPackage.CLAZZ__MODIFIER_EXTENSIONS:
				return getModifierExtensions();
			case DblPackage.CLAZZ__ATTRIBUTES:
				return getAttributes();
			case DblPackage.CLAZZ__METHODS:
				return getMethods();
			case DblPackage.CLAZZ__SUPER_CLASS:
				if (resolve) return getSuperClass();
				return basicGetSuperClass();
			case DblPackage.CLAZZ__IMPLEMENTED_INTERFACES:
				return getImplementedInterfaces();
			case DblPackage.CLAZZ__INITIAL_BLOCK:
				return getInitialBlock();
			case DblPackage.CLAZZ__FINAL_BLOCK:
				return getFinalBlock();
			case DblPackage.CLAZZ__ACTIONS_BLOCK:
				return getActionsBlock();
			case DblPackage.CLAZZ__REPORT_BLOCK:
				return getReportBlock();
			case DblPackage.CLAZZ__CLEAR_BLOCK:
				return getClearBlock();
			case DblPackage.CLAZZ__ACTIVE:
				return isActive();
			case DblPackage.CLAZZ__CONSTRUCTOR:
				return getConstructor();
			case DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS:
				return getBaseConstructorArguments();
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
			case DblPackage.CLAZZ__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case DblPackage.CLAZZ__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				getModifierExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case DblPackage.CLAZZ__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Variable>)newValue);
				return;
			case DblPackage.CLAZZ__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Procedure>)newValue);
				return;
			case DblPackage.CLAZZ__SUPER_CLASS:
				setSuperClass((Clazz)newValue);
				return;
			case DblPackage.CLAZZ__IMPLEMENTED_INTERFACES:
				getImplementedInterfaces().clear();
				getImplementedInterfaces().addAll((Collection<? extends Interface>)newValue);
				return;
			case DblPackage.CLAZZ__INITIAL_BLOCK:
				setInitialBlock((StartCodeBlock)newValue);
				return;
			case DblPackage.CLAZZ__FINAL_BLOCK:
				setFinalBlock((StartCodeBlock)newValue);
				return;
			case DblPackage.CLAZZ__ACTIONS_BLOCK:
				setActionsBlock((StartCodeBlock)newValue);
				return;
			case DblPackage.CLAZZ__REPORT_BLOCK:
				setReportBlock((StartCodeBlock)newValue);
				return;
			case DblPackage.CLAZZ__CLEAR_BLOCK:
				setClearBlock((StartCodeBlock)newValue);
				return;
			case DblPackage.CLAZZ__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case DblPackage.CLAZZ__CONSTRUCTOR:
				setConstructor((Constructor)newValue);
				return;
			case DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS:
				getBaseConstructorArguments().clear();
				getBaseConstructorArguments().addAll((Collection<? extends Expression>)newValue);
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
			case DblPackage.CLAZZ__EXTENSIONS:
				getExtensions().clear();
				return;
			case DblPackage.CLAZZ__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				return;
			case DblPackage.CLAZZ__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DblPackage.CLAZZ__METHODS:
				getMethods().clear();
				return;
			case DblPackage.CLAZZ__SUPER_CLASS:
				setSuperClass((Clazz)null);
				return;
			case DblPackage.CLAZZ__IMPLEMENTED_INTERFACES:
				getImplementedInterfaces().clear();
				return;
			case DblPackage.CLAZZ__INITIAL_BLOCK:
				setInitialBlock((StartCodeBlock)null);
				return;
			case DblPackage.CLAZZ__FINAL_BLOCK:
				setFinalBlock((StartCodeBlock)null);
				return;
			case DblPackage.CLAZZ__ACTIONS_BLOCK:
				setActionsBlock((StartCodeBlock)null);
				return;
			case DblPackage.CLAZZ__REPORT_BLOCK:
				setReportBlock((StartCodeBlock)null);
				return;
			case DblPackage.CLAZZ__CLEAR_BLOCK:
				setClearBlock((StartCodeBlock)null);
				return;
			case DblPackage.CLAZZ__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case DblPackage.CLAZZ__CONSTRUCTOR:
				setConstructor((Constructor)null);
				return;
			case DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS:
				getBaseConstructorArguments().clear();
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
			case DblPackage.CLAZZ__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case DblPackage.CLAZZ__MODIFIER_EXTENSIONS:
				return modifierExtensions != null && !modifierExtensions.isEmpty();
			case DblPackage.CLAZZ__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DblPackage.CLAZZ__METHODS:
				return methods != null && !methods.isEmpty();
			case DblPackage.CLAZZ__SUPER_CLASS:
				return superClass != null;
			case DblPackage.CLAZZ__IMPLEMENTED_INTERFACES:
				return implementedInterfaces != null && !implementedInterfaces.isEmpty();
			case DblPackage.CLAZZ__INITIAL_BLOCK:
				return initialBlock != null;
			case DblPackage.CLAZZ__FINAL_BLOCK:
				return finalBlock != null;
			case DblPackage.CLAZZ__ACTIONS_BLOCK:
				return actionsBlock != null;
			case DblPackage.CLAZZ__REPORT_BLOCK:
				return reportBlock != null;
			case DblPackage.CLAZZ__CLEAR_BLOCK:
				return clearBlock != null;
			case DblPackage.CLAZZ__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case DblPackage.CLAZZ__CONSTRUCTOR:
				return constructor != null;
			case DblPackage.CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS:
				return baseConstructorArguments != null && !baseConstructorArguments.isEmpty();
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
		if (baseClass == EmbeddableExtensionsContainer.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLAZZ__EXTENSIONS: return DblPackage.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ModifierExtensionsContainer.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLAZZ__MODIFIER_EXTENSIONS: return DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ClassSimilar.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLAZZ__ATTRIBUTES: return DblPackage.CLASS_SIMILAR__ATTRIBUTES;
				case DblPackage.CLAZZ__METHODS: return DblPackage.CLASS_SIMILAR__METHODS;
				case DblPackage.CLAZZ__SUPER_CLASS: return DblPackage.CLASS_SIMILAR__SUPER_CLASS;
				case DblPackage.CLAZZ__IMPLEMENTED_INTERFACES: return DblPackage.CLASS_SIMILAR__IMPLEMENTED_INTERFACES;
				case DblPackage.CLAZZ__INITIAL_BLOCK: return DblPackage.CLASS_SIMILAR__INITIAL_BLOCK;
				case DblPackage.CLAZZ__FINAL_BLOCK: return DblPackage.CLASS_SIMILAR__FINAL_BLOCK;
				case DblPackage.CLAZZ__ACTIONS_BLOCK: return DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK;
				case DblPackage.CLAZZ__REPORT_BLOCK: return DblPackage.CLASS_SIMILAR__REPORT_BLOCK;
				case DblPackage.CLAZZ__CLEAR_BLOCK: return DblPackage.CLASS_SIMILAR__CLEAR_BLOCK;
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
		if (baseClass == EmbeddableExtensionsContainer.class) {
			switch (baseFeatureID) {
				case DblPackage.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS: return DblPackage.CLAZZ__EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ModifierExtensionsContainer.class) {
			switch (baseFeatureID) {
				case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS: return DblPackage.CLAZZ__MODIFIER_EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == ClassSimilar.class) {
			switch (baseFeatureID) {
				case DblPackage.CLASS_SIMILAR__ATTRIBUTES: return DblPackage.CLAZZ__ATTRIBUTES;
				case DblPackage.CLASS_SIMILAR__METHODS: return DblPackage.CLAZZ__METHODS;
				case DblPackage.CLASS_SIMILAR__SUPER_CLASS: return DblPackage.CLAZZ__SUPER_CLASS;
				case DblPackage.CLASS_SIMILAR__IMPLEMENTED_INTERFACES: return DblPackage.CLAZZ__IMPLEMENTED_INTERFACES;
				case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK: return DblPackage.CLAZZ__INITIAL_BLOCK;
				case DblPackage.CLASS_SIMILAR__FINAL_BLOCK: return DblPackage.CLAZZ__FINAL_BLOCK;
				case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK: return DblPackage.CLAZZ__ACTIONS_BLOCK;
				case DblPackage.CLASS_SIMILAR__REPORT_BLOCK: return DblPackage.CLAZZ__REPORT_BLOCK;
				case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK: return DblPackage.CLAZZ__CLEAR_BLOCK;
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
		result.append(" (active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //ClazzImpl
