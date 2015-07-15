/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.PrimitiveType;
import hub.sam.dbl.Statement;
import hub.sam.dbl.TypedElement;

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
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#getTypeArrayDimensions <em>Type Array Dimensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#getClassifierType <em>Classifier Type</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#isClass <em>Class</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.FunctionImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends NamedElementImpl implements Function {
	/**
	 * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveType primitiveType;

	/**
	 * The cached value of the '{@link #getTypeArrayDimensions() <em>Type Array Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArrayDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayDimension> typeArrayDimensions;

	/**
	 * The cached value of the '{@link #getClassifierType() <em>Classifier Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierType()
	 * @generated
	 * @ordered
	 */
	protected IdExpr classifierType;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

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
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getPrimitiveType() {
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimitiveType(PrimitiveType newPrimitiveType, NotificationChain msgs) {
		PrimitiveType oldPrimitiveType = primitiveType;
		primitiveType = newPrimitiveType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveType(PrimitiveType newPrimitiveType) {
		if (newPrimitiveType != primitiveType) {
			NotificationChain msgs = null;
			if (primitiveType != null)
				msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FUNCTION__PRIMITIVE_TYPE, null, msgs);
			if (newPrimitiveType != null)
				msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FUNCTION__PRIMITIVE_TYPE, null, msgs);
			msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getTypeArrayDimensions() {
		if (typeArrayDimensions == null) {
			typeArrayDimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS);
		}
		return typeArrayDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getClassifierType() {
		return classifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassifierType(IdExpr newClassifierType, NotificationChain msgs) {
		IdExpr oldClassifierType = classifierType;
		classifierType = newClassifierType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION__CLASSIFIER_TYPE, oldClassifierType, newClassifierType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifierType(IdExpr newClassifierType) {
		if (newClassifierType != classifierType) {
			NotificationChain msgs = null;
			if (classifierType != null)
				msgs = ((InternalEObject)classifierType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.FUNCTION__CLASSIFIER_TYPE, null, msgs);
			if (newClassifierType != null)
				msgs = ((InternalEObject)newClassifierType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.FUNCTION__CLASSIFIER_TYPE, null, msgs);
			msgs = basicSetClassifierType(newClassifierType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION__CLASSIFIER_TYPE, newClassifierType, newClassifierType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, DblPackage.FUNCTION__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, DblPackage.FUNCTION__PARAMETERS);
		}
		return parameters;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.FUNCTION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.FUNCTION__PRIMITIVE_TYPE:
				return basicSetPrimitiveType(null, msgs);
			case DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS:
				return ((InternalEList<?>)getTypeArrayDimensions()).basicRemove(otherEnd, msgs);
			case DblPackage.FUNCTION__CLASSIFIER_TYPE:
				return basicSetClassifierType(null, msgs);
			case DblPackage.FUNCTION__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case DblPackage.FUNCTION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case DblPackage.FUNCTION__PRIMITIVE_TYPE:
				return getPrimitiveType();
			case DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS:
				return getTypeArrayDimensions();
			case DblPackage.FUNCTION__CLASSIFIER_TYPE:
				return getClassifierType();
			case DblPackage.FUNCTION__STATEMENTS:
				return getStatements();
			case DblPackage.FUNCTION__PARAMETERS:
				return getParameters();
			case DblPackage.FUNCTION__CLASS:
				return isClass();
			case DblPackage.FUNCTION__ABSTRACT:
				return isAbstract();
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
			case DblPackage.FUNCTION__PRIMITIVE_TYPE:
				setPrimitiveType((PrimitiveType)newValue);
				return;
			case DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS:
				getTypeArrayDimensions().clear();
				getTypeArrayDimensions().addAll((Collection<? extends ArrayDimension>)newValue);
				return;
			case DblPackage.FUNCTION__CLASSIFIER_TYPE:
				setClassifierType((IdExpr)newValue);
				return;
			case DblPackage.FUNCTION__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case DblPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case DblPackage.FUNCTION__CLASS:
				setClass((Boolean)newValue);
				return;
			case DblPackage.FUNCTION__ABSTRACT:
				setAbstract((Boolean)newValue);
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
			case DblPackage.FUNCTION__PRIMITIVE_TYPE:
				setPrimitiveType((PrimitiveType)null);
				return;
			case DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS:
				getTypeArrayDimensions().clear();
				return;
			case DblPackage.FUNCTION__CLASSIFIER_TYPE:
				setClassifierType((IdExpr)null);
				return;
			case DblPackage.FUNCTION__STATEMENTS:
				getStatements().clear();
				return;
			case DblPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				return;
			case DblPackage.FUNCTION__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case DblPackage.FUNCTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
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
			case DblPackage.FUNCTION__PRIMITIVE_TYPE:
				return primitiveType != null;
			case DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS:
				return typeArrayDimensions != null && !typeArrayDimensions.isEmpty();
			case DblPackage.FUNCTION__CLASSIFIER_TYPE:
				return classifierType != null;
			case DblPackage.FUNCTION__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case DblPackage.FUNCTION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DblPackage.FUNCTION__CLASS:
				return class_ != CLASS_EDEFAULT;
			case DblPackage.FUNCTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
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
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.FUNCTION__PRIMITIVE_TYPE: return DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE;
				case DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS: return DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS;
				case DblPackage.FUNCTION__CLASSIFIER_TYPE: return DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE;
				default: return -1;
			}
		}
		if (baseClass == LocalScope.class) {
			switch (derivedFeatureID) {
				case DblPackage.FUNCTION__STATEMENTS: return DblPackage.LOCAL_SCOPE__STATEMENTS;
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
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE: return DblPackage.FUNCTION__PRIMITIVE_TYPE;
				case DblPackage.TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS: return DblPackage.FUNCTION__TYPE_ARRAY_DIMENSIONS;
				case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE: return DblPackage.FUNCTION__CLASSIFIER_TYPE;
				default: return -1;
			}
		}
		if (baseClass == LocalScope.class) {
			switch (baseFeatureID) {
				case DblPackage.LOCAL_SCOPE__STATEMENTS: return DblPackage.FUNCTION__STATEMENTS;
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
		result.append(" (class: ");
		result.append(class_);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //FunctionImpl
