/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ModifierExtensionsContainer;
import hub.sam.dbl.NamedExtensible;
import hub.sam.dbl.Statement;
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
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#isObjectIsExtensionInstance <em>Object Is Extension Instance</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getModifierExtensions <em>Modifier Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#isControl <em>Control</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#isClazz <em>Clazz</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.VariableImpl#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends AbstractVariableImpl implements Variable {
	/**
	 * The default value of the '{@link #isObjectIsExtensionInstance() <em>Object Is Extension Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isObjectIsExtensionInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isObjectIsExtensionInstance() <em>Object Is Extension Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isObjectIsExtensionInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean objectIsExtensionInstance = OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT;

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
	 * The cached value of the '{@link #getModifierExtensions() <em>Modifier Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifierExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensibleElement> modifierExtensions;

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
	 * The default value of the '{@link #isClazz() <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClazz()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLAZZ_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClazz() <em>Clazz</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClazz()
	 * @generated
	 * @ordered
	 */
	protected boolean clazz = CLAZZ_EDEFAULT;

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
	public boolean isObjectIsExtensionInstance() {
		return objectIsExtensionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectIsExtensionInstance(boolean newObjectIsExtensionInstance) {
		boolean oldObjectIsExtensionInstance = objectIsExtensionInstance;
		objectIsExtensionInstance = newObjectIsExtensionInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE, oldObjectIsExtensionInstance, objectIsExtensionInstance));
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
	public EList<ExtensibleElement> getModifierExtensions() {
		if (modifierExtensions == null) {
			modifierExtensions = new EObjectContainmentEList<ExtensibleElement>(ExtensibleElement.class, this, DblPackage.VARIABLE__MODIFIER_EXTENSIONS);
		}
		return modifierExtensions;
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
	public boolean isClazz() {
		return clazz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClazz(boolean newClazz) {
		boolean oldClazz = clazz;
		clazz = newClazz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.VARIABLE__CLAZZ, oldClazz, clazz));
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
			case DblPackage.VARIABLE__MODIFIER_EXTENSIONS:
				return ((InternalEList<?>)getModifierExtensions()).basicRemove(otherEnd, msgs);
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
			case DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE:
				return isObjectIsExtensionInstance();
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.VARIABLE__MODIFIER_EXTENSIONS:
				return getModifierExtensions();
			case DblPackage.VARIABLE__CONTROL:
				return isControl();
			case DblPackage.VARIABLE__CLAZZ:
				return isClazz();
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
			case DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE:
				setObjectIsExtensionInstance((Boolean)newValue);
				return;
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.VARIABLE__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				getModifierExtensions().addAll((Collection<? extends ExtensibleElement>)newValue);
				return;
			case DblPackage.VARIABLE__CONTROL:
				setControl((Boolean)newValue);
				return;
			case DblPackage.VARIABLE__CLAZZ:
				setClazz((Boolean)newValue);
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
			case DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE:
				setObjectIsExtensionInstance(OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT);
				return;
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.VARIABLE__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				return;
			case DblPackage.VARIABLE__CONTROL:
				setControl(CONTROL_EDEFAULT);
				return;
			case DblPackage.VARIABLE__CLAZZ:
				setClazz(CLAZZ_EDEFAULT);
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
			case DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE:
				return objectIsExtensionInstance != OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT;
			case DblPackage.VARIABLE__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.VARIABLE__MODIFIER_EXTENSIONS:
				return modifierExtensions != null && !modifierExtensions.isEmpty();
			case DblPackage.VARIABLE__CONTROL:
				return control != CONTROL_EDEFAULT;
			case DblPackage.VARIABLE__CLAZZ:
				return clazz != CLAZZ_EDEFAULT;
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
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE: return DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE;
				default: return -1;
			}
		}
		if (baseClass == NamedExtensible.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (derivedFeatureID) {
				case DblPackage.VARIABLE__CONCRETE_SYNTAX: return DblPackage.CONSTRUCT__CONCRETE_SYNTAX;
				default: return -1;
			}
		}
		if (baseClass == Statement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ModifierExtensionsContainer.class) {
			switch (derivedFeatureID) {
				case DblPackage.VARIABLE__MODIFIER_EXTENSIONS: return DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS;
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
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE: return DblPackage.VARIABLE__OBJECT_IS_EXTENSION_INSTANCE;
				default: return -1;
			}
		}
		if (baseClass == NamedExtensible.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Construct.class) {
			switch (baseFeatureID) {
				case DblPackage.CONSTRUCT__CONCRETE_SYNTAX: return DblPackage.VARIABLE__CONCRETE_SYNTAX;
				default: return -1;
			}
		}
		if (baseClass == Statement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ModifierExtensionsContainer.class) {
			switch (baseFeatureID) {
				case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS: return DblPackage.VARIABLE__MODIFIER_EXTENSIONS;
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
		result.append(" (objectIsExtensionInstance: ");
		result.append(objectIsExtensionInstance);
		result.append(", concreteSyntax: ");
		result.append(concreteSyntax);
		result.append(", control: ");
		result.append(control);
		result.append(", clazz: ");
		result.append(clazz);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
