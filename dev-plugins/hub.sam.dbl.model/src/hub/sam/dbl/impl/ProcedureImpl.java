/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.AnnotatableElement;
import hub.sam.dbl.AnnotationApplication;
import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.Construct;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.ListDimension;
import hub.sam.dbl.NamedExtensible;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.PrimitiveType;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.SimpleAnnotation;
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
 * An implementation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#isIsList <em>Is List</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getListDims <em>List Dims</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getClassifierTypeExpr <em>Classifier Type Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#isObjectIsExtensionInstance <em>Object Is Extension Instance</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getAnnotationApplications <em>Annotation Applications</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getSimpleAnnotations <em>Simple Annotations</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ProcedureImpl#isClazz <em>Clazz</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcedureImpl extends NamedElementImpl implements Procedure {
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
	 * The default value of the '{@link #isIsList() <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsList() <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsList()
	 * @generated
	 * @ordered
	 */
	protected boolean isList = IS_LIST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getListDims() <em>List Dims</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListDims()
	 * @generated
	 * @ordered
	 */
	protected EList<ListDimension> listDims;

	/**
	 * The cached value of the '{@link #getClassifierTypeExpr() <em>Classifier Type Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierTypeExpr()
	 * @generated
	 * @ordered
	 */
	protected IdExpr classifierTypeExpr;

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
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The cached value of the '{@link #getAnnotationApplications() <em>Annotation Applications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationApplications()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationApplication> annotationApplications;

	/**
	 * The cached value of the '{@link #getSimpleAnnotations() <em>Simple Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleAnnotation> simpleAnnotations;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.PROCEDURE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
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
				msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.PROCEDURE__PRIMITIVE_TYPE, null, msgs);
			if (newPrimitiveType != null)
				msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.PROCEDURE__PRIMITIVE_TYPE, null, msgs);
			msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsList() {
		return isList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsList(boolean newIsList) {
		boolean oldIsList = isList;
		isList = newIsList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__IS_LIST, oldIsList, isList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ListDimension> getListDims() {
		if (listDims == null) {
			listDims = new EObjectContainmentEList<ListDimension>(ListDimension.class, this, DblPackage.PROCEDURE__LIST_DIMS);
		}
		return listDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr getClassifierTypeExpr() {
		return classifierTypeExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassifierTypeExpr(IdExpr newClassifierTypeExpr, NotificationChain msgs) {
		IdExpr oldClassifierTypeExpr = classifierTypeExpr;
		classifierTypeExpr = newClassifierTypeExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR, oldClassifierTypeExpr, newClassifierTypeExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifierTypeExpr(IdExpr newClassifierTypeExpr) {
		if (newClassifierTypeExpr != classifierTypeExpr) {
			NotificationChain msgs = null;
			if (classifierTypeExpr != null)
				msgs = ((InternalEObject)classifierTypeExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR, null, msgs);
			if (newClassifierTypeExpr != null)
				msgs = ((InternalEObject)newClassifierTypeExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR, null, msgs);
			msgs = basicSetClassifierTypeExpr(newClassifierTypeExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR, newClassifierTypeExpr, newClassifierTypeExpr));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE, oldObjectIsExtensionInstance, objectIsExtensionInstance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, DblPackage.PROCEDURE__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationApplication> getAnnotationApplications() {
		if (annotationApplications == null) {
			annotationApplications = new EObjectContainmentEList<AnnotationApplication>(AnnotationApplication.class, this, DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS);
		}
		return annotationApplications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleAnnotation> getSimpleAnnotations() {
		if (simpleAnnotations == null) {
			simpleAnnotations = new EObjectContainmentEList<SimpleAnnotation>(SimpleAnnotation.class, this, DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS);
		}
		return simpleAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, DblPackage.PROCEDURE__PARAMETERS);
		}
		return parameters;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PROCEDURE__CLAZZ, oldClazz, clazz));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.PROCEDURE__PRIMITIVE_TYPE:
				return basicSetPrimitiveType(null, msgs);
			case DblPackage.PROCEDURE__LIST_DIMS:
				return ((InternalEList<?>)getListDims()).basicRemove(otherEnd, msgs);
			case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR:
				return basicSetClassifierTypeExpr(null, msgs);
			case DblPackage.PROCEDURE__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS:
				return ((InternalEList<?>)getAnnotationApplications()).basicRemove(otherEnd, msgs);
			case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS:
				return ((InternalEList<?>)getSimpleAnnotations()).basicRemove(otherEnd, msgs);
			case DblPackage.PROCEDURE__PARAMETERS:
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
			case DblPackage.PROCEDURE__PRIMITIVE_TYPE:
				return getPrimitiveType();
			case DblPackage.PROCEDURE__IS_LIST:
				return isIsList();
			case DblPackage.PROCEDURE__LIST_DIMS:
				return getListDims();
			case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR:
				return getClassifierTypeExpr();
			case DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE:
				return isObjectIsExtensionInstance();
			case DblPackage.PROCEDURE__CONCRETE_SYNTAX:
				return getConcreteSyntax();
			case DblPackage.PROCEDURE__STATEMENTS:
				return getStatements();
			case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS:
				return getAnnotationApplications();
			case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS:
				return getSimpleAnnotations();
			case DblPackage.PROCEDURE__PARAMETERS:
				return getParameters();
			case DblPackage.PROCEDURE__CLAZZ:
				return isClazz();
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
			case DblPackage.PROCEDURE__PRIMITIVE_TYPE:
				setPrimitiveType((PrimitiveType)newValue);
				return;
			case DblPackage.PROCEDURE__IS_LIST:
				setIsList((Boolean)newValue);
				return;
			case DblPackage.PROCEDURE__LIST_DIMS:
				getListDims().clear();
				getListDims().addAll((Collection<? extends ListDimension>)newValue);
				return;
			case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR:
				setClassifierTypeExpr((IdExpr)newValue);
				return;
			case DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE:
				setObjectIsExtensionInstance((Boolean)newValue);
				return;
			case DblPackage.PROCEDURE__CONCRETE_SYNTAX:
				setConcreteSyntax((String)newValue);
				return;
			case DblPackage.PROCEDURE__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS:
				getAnnotationApplications().clear();
				getAnnotationApplications().addAll((Collection<? extends AnnotationApplication>)newValue);
				return;
			case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS:
				getSimpleAnnotations().clear();
				getSimpleAnnotations().addAll((Collection<? extends SimpleAnnotation>)newValue);
				return;
			case DblPackage.PROCEDURE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case DblPackage.PROCEDURE__CLAZZ:
				setClazz((Boolean)newValue);
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
			case DblPackage.PROCEDURE__PRIMITIVE_TYPE:
				setPrimitiveType((PrimitiveType)null);
				return;
			case DblPackage.PROCEDURE__IS_LIST:
				setIsList(IS_LIST_EDEFAULT);
				return;
			case DblPackage.PROCEDURE__LIST_DIMS:
				getListDims().clear();
				return;
			case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR:
				setClassifierTypeExpr((IdExpr)null);
				return;
			case DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE:
				setObjectIsExtensionInstance(OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT);
				return;
			case DblPackage.PROCEDURE__CONCRETE_SYNTAX:
				setConcreteSyntax(CONCRETE_SYNTAX_EDEFAULT);
				return;
			case DblPackage.PROCEDURE__STATEMENTS:
				getStatements().clear();
				return;
			case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS:
				getAnnotationApplications().clear();
				return;
			case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS:
				getSimpleAnnotations().clear();
				return;
			case DblPackage.PROCEDURE__PARAMETERS:
				getParameters().clear();
				return;
			case DblPackage.PROCEDURE__CLAZZ:
				setClazz(CLAZZ_EDEFAULT);
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
			case DblPackage.PROCEDURE__PRIMITIVE_TYPE:
				return primitiveType != null;
			case DblPackage.PROCEDURE__IS_LIST:
				return isList != IS_LIST_EDEFAULT;
			case DblPackage.PROCEDURE__LIST_DIMS:
				return listDims != null && !listDims.isEmpty();
			case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR:
				return classifierTypeExpr != null;
			case DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE:
				return objectIsExtensionInstance != OBJECT_IS_EXTENSION_INSTANCE_EDEFAULT;
			case DblPackage.PROCEDURE__CONCRETE_SYNTAX:
				return CONCRETE_SYNTAX_EDEFAULT == null ? concreteSyntax != null : !CONCRETE_SYNTAX_EDEFAULT.equals(concreteSyntax);
			case DblPackage.PROCEDURE__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS:
				return annotationApplications != null && !annotationApplications.isEmpty();
			case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS:
				return simpleAnnotations != null && !simpleAnnotations.isEmpty();
			case DblPackage.PROCEDURE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DblPackage.PROCEDURE__CLAZZ:
				return clazz != CLAZZ_EDEFAULT;
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
				case DblPackage.PROCEDURE__PRIMITIVE_TYPE: return DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE;
				case DblPackage.PROCEDURE__IS_LIST: return DblPackage.TYPED_ELEMENT__IS_LIST;
				case DblPackage.PROCEDURE__LIST_DIMS: return DblPackage.TYPED_ELEMENT__LIST_DIMS;
				case DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR: return DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE: return DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE;
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
				case DblPackage.PROCEDURE__CONCRETE_SYNTAX: return DblPackage.CONSTRUCT__CONCRETE_SYNTAX;
				default: return -1;
			}
		}
		if (baseClass == CodeBlock.class) {
			switch (derivedFeatureID) {
				case DblPackage.PROCEDURE__STATEMENTS: return DblPackage.CODE_BLOCK__STATEMENTS;
				default: return -1;
			}
		}
		if (baseClass == AnnotatableElement.class) {
			switch (derivedFeatureID) {
				case DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS: return DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS;
				case DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS: return DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS;
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
				case DblPackage.TYPED_ELEMENT__PRIMITIVE_TYPE: return DblPackage.PROCEDURE__PRIMITIVE_TYPE;
				case DblPackage.TYPED_ELEMENT__IS_LIST: return DblPackage.PROCEDURE__IS_LIST;
				case DblPackage.TYPED_ELEMENT__LIST_DIMS: return DblPackage.PROCEDURE__LIST_DIMS;
				case DblPackage.TYPED_ELEMENT__CLASSIFIER_TYPE_EXPR: return DblPackage.PROCEDURE__CLASSIFIER_TYPE_EXPR;
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case DblPackage.EXTENSIBLE_ELEMENT__OBJECT_IS_EXTENSION_INSTANCE: return DblPackage.PROCEDURE__OBJECT_IS_EXTENSION_INSTANCE;
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
				case DblPackage.CONSTRUCT__CONCRETE_SYNTAX: return DblPackage.PROCEDURE__CONCRETE_SYNTAX;
				default: return -1;
			}
		}
		if (baseClass == CodeBlock.class) {
			switch (baseFeatureID) {
				case DblPackage.CODE_BLOCK__STATEMENTS: return DblPackage.PROCEDURE__STATEMENTS;
				default: return -1;
			}
		}
		if (baseClass == AnnotatableElement.class) {
			switch (baseFeatureID) {
				case DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS: return DblPackage.PROCEDURE__ANNOTATION_APPLICATIONS;
				case DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS: return DblPackage.PROCEDURE__SIMPLE_ANNOTATIONS;
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
		result.append(" (isList: ");
		result.append(isList);
		result.append(", objectIsExtensionInstance: ");
		result.append(objectIsExtensionInstance);
		result.append(", concreteSyntax: ");
		result.append(concreteSyntax);
		result.append(", clazz: ");
		result.append(clazz);
		result.append(')');
		return result.toString();
	}

} //ProcedureImpl
