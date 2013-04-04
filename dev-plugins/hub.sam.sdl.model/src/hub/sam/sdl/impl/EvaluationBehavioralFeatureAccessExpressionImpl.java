/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.CoreAbstractionsBehavioralFeaturesBehavioralFeature;
import hub.sam.sdl.CoreAbstractionsClassifiersFeature;
import hub.sam.sdl.CoreAbstractionsCommentsComment;
import hub.sam.sdl.CoreAbstractionsElementsElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.CoreAbstractionsTypedElementsType;
import hub.sam.sdl.CoreAbstractionsTypedElementsTypedElement;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.EvaluationBehavioralFeatureAccessExpression;
import hub.sam.sdl.EvaluationEvaluation;
import hub.sam.sdl.EvaluationExpression;
import hub.sam.sdl.EvaluationFeatureAccessExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation Behavioral Feature Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getLine <em>Line</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getTypedElement_type <em>Typed Element type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getSubExpression <em>Sub Expression</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getType <em>Type</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getFeatureAccessExpression_feature <em>Feature Access Expression feature</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.EvaluationBehavioralFeatureAccessExpressionImpl#getBehavioralFeatureAccessExpression_feature <em>Behavioral Feature Access Expression feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EvaluationBehavioralFeatureAccessExpressionImpl extends EvaluationBehavioralFeatureAccessImpl implements EvaluationBehavioralFeatureAccessExpression {
	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected int line = LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected int column = COLUMN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedElement() <em>Owned Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElement()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsOwnershipsElement> ownedElement;

	/**
	 * The cached value of the '{@link #getOwnedComment() <em>Owned Comment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComment()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsCommentsComment> ownedComment;

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
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected ConcreteSyntaxSdlIdentifier identifier;

	/**
	 * The cached value of the '{@link #getTypedElement_type() <em>Typed Element type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedElement_type()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsTypedElementsType typedElement_type;

	/**
	 * The cached value of the '{@link #getSubExpression() <em>Sub Expression</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationExpression> subExpression;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsTypedElementsType type;

	/**
	 * The cached value of the '{@link #getFeatureAccessExpression_feature() <em>Feature Access Expression feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureAccessExpression_feature()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsClassifiersFeature featureAccessExpression_feature;

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<EvaluationExpression> argument;

	/**
	 * The cached value of the '{@link #getBehavioralFeatureAccessExpression_feature() <em>Behavioral Feature Access Expression feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavioralFeatureAccessExpression_feature()
	 * @generated
	 * @ordered
	 */
	protected CoreAbstractionsBehavioralFeaturesBehavioralFeature behavioralFeatureAccessExpression_feature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EvaluationBehavioralFeatureAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getEvaluationBehavioralFeatureAccessExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(int newLine) {
		int oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE, oldLine, line));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(int newColumn) {
		int oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getOwnedElement() {
		if (ownedElement == null) {
			ownedElement = new EObjectContainmentWithInverseEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER);
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsOwnershipsElement getOwner() {
		if (eContainerFeatureID() != EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER) return null;
		return (CoreAbstractionsOwnershipsElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(CoreAbstractionsOwnershipsElement newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(CoreAbstractionsOwnershipsElement newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsCommentsComment> getOwnedComment() {
		if (ownedComment == null) {
			ownedComment = new EObjectContainmentEList<CoreAbstractionsCommentsComment>(CoreAbstractionsCommentsComment.class, this, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT);
		}
		return ownedComment;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsNamespacesNamespace getNamespace() {
		if (eContainerFeatureID() != EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE) return null;
		return (CoreAbstractionsNamespacesNamespace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(CoreAbstractionsNamespacesNamespace newNamespace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNamespace, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(CoreAbstractionsNamespacesNamespace newNamespace) {
		if (newNamespace != eInternalContainer() || (eContainerFeatureID() != EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE && newNamespace != null)) {
			if (EcoreUtil.isAncestor(this, newNamespace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNamespace != null)
				msgs = ((InternalEObject)newNamespace).eInverseAdd(this, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER, CoreAbstractionsNamespacesNamespace.class, msgs);
			msgs = basicSetNamespace(newNamespace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE, newNamespace, newNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlIdentifier getIdentifier() {
		if (identifier != null && identifier.eIsProxy()) {
			InternalEObject oldIdentifier = (InternalEObject)identifier;
			identifier = (ConcreteSyntaxSdlIdentifier)eResolveProxy(oldIdentifier);
			if (identifier != oldIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER, oldIdentifier, identifier));
			}
		}
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntaxSdlIdentifier basicGetIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(ConcreteSyntaxSdlIdentifier newIdentifier) {
		ConcreteSyntaxSdlIdentifier oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType getTypedElement_type() {
		if (typedElement_type != null && typedElement_type.eIsProxy()) {
			InternalEObject oldTypedElement_type = (InternalEObject)typedElement_type;
			typedElement_type = (CoreAbstractionsTypedElementsType)eResolveProxy(oldTypedElement_type);
			if (typedElement_type != oldTypedElement_type) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE, oldTypedElement_type, typedElement_type));
			}
		}
		return typedElement_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType basicGetTypedElement_type() {
		return typedElement_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedElement_type(CoreAbstractionsTypedElementsType newTypedElement_type) {
		CoreAbstractionsTypedElementsType oldTypedElement_type = typedElement_type;
		typedElement_type = newTypedElement_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE, oldTypedElement_type, typedElement_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationExpression> getSubExpression() {
		if (subExpression == null) {
			subExpression = new EObjectContainmentEList<EvaluationExpression>(EvaluationExpression.class, this, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION);
		}
		return subExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (CoreAbstractionsTypedElementsType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsTypedElementsType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CoreAbstractionsTypedElementsType newType) {
		CoreAbstractionsTypedElementsType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersFeature getFeatureAccessExpression_feature() {
		if (featureAccessExpression_feature != null && featureAccessExpression_feature.eIsProxy()) {
			InternalEObject oldFeatureAccessExpression_feature = (InternalEObject)featureAccessExpression_feature;
			featureAccessExpression_feature = (CoreAbstractionsClassifiersFeature)eResolveProxy(oldFeatureAccessExpression_feature);
			if (featureAccessExpression_feature != oldFeatureAccessExpression_feature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE, oldFeatureAccessExpression_feature, featureAccessExpression_feature));
			}
		}
		return featureAccessExpression_feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsClassifiersFeature basicGetFeatureAccessExpression_feature() {
		return featureAccessExpression_feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureAccessExpression_feature(CoreAbstractionsClassifiersFeature newFeatureAccessExpression_feature) {
		CoreAbstractionsClassifiersFeature oldFeatureAccessExpression_feature = featureAccessExpression_feature;
		featureAccessExpression_feature = newFeatureAccessExpression_feature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE, oldFeatureAccessExpression_feature, featureAccessExpression_feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EvaluationExpression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<EvaluationExpression>(EvaluationExpression.class, this, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsBehavioralFeaturesBehavioralFeature getBehavioralFeatureAccessExpression_feature() {
		if (behavioralFeatureAccessExpression_feature != null && behavioralFeatureAccessExpression_feature.eIsProxy()) {
			InternalEObject oldBehavioralFeatureAccessExpression_feature = (InternalEObject)behavioralFeatureAccessExpression_feature;
			behavioralFeatureAccessExpression_feature = (CoreAbstractionsBehavioralFeaturesBehavioralFeature)eResolveProxy(oldBehavioralFeatureAccessExpression_feature);
			if (behavioralFeatureAccessExpression_feature != oldBehavioralFeatureAccessExpression_feature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE, oldBehavioralFeatureAccessExpression_feature, behavioralFeatureAccessExpression_feature));
			}
		}
		return behavioralFeatureAccessExpression_feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsBehavioralFeaturesBehavioralFeature basicGetBehavioralFeatureAccessExpression_feature() {
		return behavioralFeatureAccessExpression_feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavioralFeatureAccessExpression_feature(CoreAbstractionsBehavioralFeaturesBehavioralFeature newBehavioralFeatureAccessExpression_feature) {
		CoreAbstractionsBehavioralFeaturesBehavioralFeature oldBehavioralFeatureAccessExpression_feature = behavioralFeatureAccessExpression_feature;
		behavioralFeatureAccessExpression_feature = newBehavioralFeatureAccessExpression_feature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE, oldBehavioralFeatureAccessExpression_feature, behavioralFeatureAccessExpression_feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluationEvaluation instantiate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamespace> allNamespaces() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinguishableFrom(CoreAbstractionsNamespacesNamedElement n, CoreAbstractionsNamespacesNamespace ns) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String separator() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String qualifiedName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> allOwnedElements() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean mustBeOwned() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElement()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((CoreAbstractionsOwnershipsElement)otherEnd, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNamespace((CoreAbstractionsNamespacesNamespace)otherEnd, msgs);
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
				return ((InternalEList<?>)getOwnedElement()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				return basicSetOwner(null, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				return basicSetNamespace(null, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION:
				return ((InternalEList<?>)getSubExpression()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER, CoreAbstractionsNamespacesNamespace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE:
				return getLine();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN:
				return getColumn();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
				return getOwnedElement();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				return getOwner();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT:
				return getOwnedComment();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME:
				return getName();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME:
				return getQualifiedName();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				return getNamespace();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE:
				if (resolve) return getTypedElement_type();
				return basicGetTypedElement_type();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION:
				return getSubExpression();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				if (resolve) return getFeatureAccessExpression_feature();
				return basicGetFeatureAccessExpression_feature();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT:
				return getArgument();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE:
				if (resolve) return getBehavioralFeatureAccessExpression_feature();
				return basicGetBehavioralFeatureAccessExpression_feature();
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE:
				setLine((Integer)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN:
				setColumn((Integer)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
				getOwnedElement().clear();
				getOwnedElement().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends CoreAbstractionsCommentsComment>)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME:
				setName((String)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE:
				setTypedElement_type((CoreAbstractionsTypedElementsType)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION:
				getSubExpression().clear();
				getSubExpression().addAll((Collection<? extends EvaluationExpression>)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE:
				setType((CoreAbstractionsTypedElementsType)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				setFeatureAccessExpression_feature((CoreAbstractionsClassifiersFeature)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends EvaluationExpression>)newValue);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE:
				setBehavioralFeatureAccessExpression_feature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)newValue);
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
				getOwnedElement().clear();
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)null);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)null);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)null);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE:
				setTypedElement_type((CoreAbstractionsTypedElementsType)null);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION:
				getSubExpression().clear();
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE:
				setType((CoreAbstractionsTypedElementsType)null);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				setFeatureAccessExpression_feature((CoreAbstractionsClassifiersFeature)null);
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT:
				getArgument().clear();
				return;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE:
				setBehavioralFeatureAccessExpression_feature((CoreAbstractionsBehavioralFeaturesBehavioralFeature)null);
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
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE:
				return line != LINE_EDEFAULT;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN:
				return column != COLUMN_EDEFAULT;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT:
				return ownedElement != null && !ownedElement.isEmpty();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER:
				return getOwner() != null;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE:
				return getNamespace() != null;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER:
				return identifier != null;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE:
				return typedElement_type != null;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION:
				return subExpression != null && !subExpression.isEmpty();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE:
				return type != null;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE:
				return featureAccessExpression_feature != null;
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__BEHAVIORAL_FEATURE_ACCESS_EXPRESSION_FEATURE:
				return behavioralFeatureAccessExpression_feature != null;
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
		if (baseClass == CoreAbstractionsElementsElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE: return EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN: return EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsOwnershipsElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsTypedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE: return EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE;
				default: return -1;
			}
		}
		if (baseClass == EvaluationExpression.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION: return EmfSdlPackage.EVALUATION_EXPRESSION__SUB_EXPRESSION;
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE: return EmfSdlPackage.EVALUATION_EXPRESSION__TYPE;
				default: return -1;
			}
		}
		if (baseClass == EvaluationFeatureAccessExpression.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE: return EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE;
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
		if (baseClass == CoreAbstractionsElementsElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__LINE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__LINE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_ELEMENTS_ELEMENT__COLUMN: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__COLUMN;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsOwnershipsElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_ELEMENT;
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__QUALIFIED_NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__NAMESPACE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__IDENTIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsTypedElementsTypedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_TYPED_ELEMENTS_TYPED_ELEMENT__TYPED_ELEMENT_TYPE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPED_ELEMENT_TYPE;
				default: return -1;
			}
		}
		if (baseClass == EvaluationExpression.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.EVALUATION_EXPRESSION__SUB_EXPRESSION: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__SUB_EXPRESSION;
				case EmfSdlPackage.EVALUATION_EXPRESSION__TYPE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__TYPE;
				default: return -1;
			}
		}
		if (baseClass == EvaluationFeatureAccessExpression.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.EVALUATION_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE: return EmfSdlPackage.EVALUATION_BEHAVIORAL_FEATURE_ACCESS_EXPRESSION__FEATURE_ACCESS_EXPRESSION_FEATURE;
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
		result.append(" (line: ");
		result.append(line);
		result.append(", column: ");
		result.append(column);
		result.append(", name: ");
		result.append(name);
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //EvaluationBehavioralFeatureAccessExpressionImpl
