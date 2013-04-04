/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.sdl.impl;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.CoreAbstractionsCommentsComment;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.CoreAbstractionsNamespacesNamespace;
import hub.sam.sdl.CoreAbstractionsOwnershipsElement;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAbstractState;
import hub.sam.sdl.SdlNamedState;
import hub.sam.sdl.SdlStateAutomaton;
import hub.sam.sdl.SdlTransition;
import hub.sam.sdl.Start;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sdl State Automaton</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getMember <em>Member</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getState <em>State</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getTransition <em>Transition</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getNamedState <em>Named State</em>}</li>
 *   <li>{@link hub.sam.sdl.impl.SdlStateAutomatonImpl#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SdlStateAutomatonImpl extends SdlBehaviorImpl implements SdlStateAutomaton {
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
	 * The cached value of the '{@link #getOwnedMember() <em>Owned Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> ownedMember;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<CoreAbstractionsNamespacesNamedElement> member;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlAbstractState> state;

	/**
	 * The cached value of the '{@link #getTransition() <em>Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlTransition> transition;

	/**
	 * The cached value of the '{@link #getNamedState() <em>Named State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedState()
	 * @generated
	 * @ordered
	 */
	protected EList<SdlNamedState> namedState;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Start start;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SdlStateAutomatonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfSdlPackage.eINSTANCE.getSdlStateAutomaton();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsOwnershipsElement> getOwnedElement() {
		if (ownedElement == null) {
			ownedElement = new EObjectContainmentWithInverseEList<CoreAbstractionsOwnershipsElement>(CoreAbstractionsOwnershipsElement.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER);
		}
		return ownedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsOwnershipsElement getOwner() {
		if (eContainerFeatureID() != EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER) return null;
		return (CoreAbstractionsOwnershipsElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(CoreAbstractionsOwnershipsElement newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(CoreAbstractionsOwnershipsElement newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER && newOwner != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsCommentsComment> getOwnedComment() {
		if (ownedComment == null) {
			ownedComment = new EObjectContainmentEList<CoreAbstractionsCommentsComment>(CoreAbstractionsCommentsComment.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT);
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAbstractionsNamespacesNamespace getNamespace() {
		if (eContainerFeatureID() != EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE) return null;
		return (CoreAbstractionsNamespacesNamespace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(CoreAbstractionsNamespacesNamespace newNamespace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNamespace, EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(CoreAbstractionsNamespacesNamespace newNamespace) {
		if (newNamespace != eInternalContainer() || (eContainerFeatureID() != EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE && newNamespace != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE, newNamespace, newNamespace));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER, oldIdentifier, identifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getOwnedMember() {
		if (ownedMember == null) {
			ownedMember = new EObjectContainmentWithInverseEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER, EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE);
		}
		return ownedMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CoreAbstractionsNamespacesNamedElement> getMember() {
		if (member == null) {
			member = new EObjectResolvingEList<CoreAbstractionsNamespacesNamedElement>(CoreAbstractionsNamespacesNamedElement.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlAbstractState> getState() {
		if (state == null) {
			state = new EObjectContainmentEList<SdlAbstractState>(SdlAbstractState.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__STATE);
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlTransition> getTransition() {
		if (transition == null) {
			transition = new EObjectContainmentEList<SdlTransition>(SdlTransition.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__TRANSITION);
		}
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SdlNamedState> getNamedState() {
		if (namedState == null) {
			namedState = new EObjectContainmentEList<SdlNamedState>(SdlNamedState.class, this, EmfSdlPackage.SDL_STATE_AUTOMATON__NAMED_STATE);
		}
		return namedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Start getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStart(Start newStart, NotificationChain msgs) {
		Start oldStart = start;
		start = newStart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__START, oldStart, newStart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Start newStart) {
		if (newStart != start) {
			NotificationChain msgs = null;
			if (start != null)
				msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_STATE_AUTOMATON__START, null, msgs);
			if (newStart != null)
				msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfSdlPackage.SDL_STATE_AUTOMATON__START, null, msgs);
			msgs = basicSetStart(newStart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfSdlPackage.SDL_STATE_AUTOMATON__START, newStart, newStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNamesOfMember(CoreAbstractionsNamespacesNamedElement element) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean membersAreDistinguishable() {
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElement()).basicAdd(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((CoreAbstractionsOwnershipsElement)otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNamespace((CoreAbstractionsNamespacesNamespace)otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMember()).basicAdd(otherEnd, msgs);
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT:
				return ((InternalEList<?>)getOwnedElement()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				return basicSetOwner(null, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
				return basicSetNamespace(null, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER:
				return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__TRANSITION:
				return ((InternalEList<?>)getTransition()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMED_STATE:
				return ((InternalEList<?>)getNamedState()).basicRemove(otherEnd, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__START:
				return basicSetStart(null, msgs);
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				return eInternalContainer().eInverseRemove(this, EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT, CoreAbstractionsOwnershipsElement.class, msgs);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT:
				return getOwnedElement();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				return getOwner();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT:
				return getOwnedComment();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAME:
				return getName();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME:
				return getQualifiedName();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
				return getNamespace();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER:
				return getOwnedMember();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER:
				return getMember();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__STATE:
				return getState();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__TRANSITION:
				return getTransition();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMED_STATE:
				return getNamedState();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__START:
				return getStart();
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT:
				getOwnedElement().clear();
				getOwnedElement().addAll((Collection<? extends CoreAbstractionsOwnershipsElement>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends CoreAbstractionsCommentsComment>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAME:
				setName((String)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER:
				getOwnedMember().clear();
				getOwnedMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends CoreAbstractionsNamespacesNamedElement>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__STATE:
				getState().clear();
				getState().addAll((Collection<? extends SdlAbstractState>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__TRANSITION:
				getTransition().clear();
				getTransition().addAll((Collection<? extends SdlTransition>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMED_STATE:
				getNamedState().clear();
				getNamedState().addAll((Collection<? extends SdlNamedState>)newValue);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__START:
				setStart((Start)newValue);
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT:
				getOwnedElement().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				setOwner((CoreAbstractionsOwnershipsElement)null);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
				setNamespace((CoreAbstractionsNamespacesNamespace)null);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER:
				setIdentifier((ConcreteSyntaxSdlIdentifier)null);
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER:
				getOwnedMember().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER:
				getMember().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__STATE:
				getState().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__TRANSITION:
				getTransition().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMED_STATE:
				getNamedState().clear();
				return;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__START:
				setStart((Start)null);
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
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT:
				return ownedElement != null && !ownedElement.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER:
				return getOwner() != null;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE:
				return getNamespace() != null;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER:
				return identifier != null;
			case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER:
				return ownedMember != null && !ownedMember.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER:
				return member != null && !member.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__STATE:
				return state != null && !state.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__TRANSITION:
				return transition != null && !transition.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMED_STATE:
				return namedState != null && !namedState.isEmpty();
			case EmfSdlPackage.SDL_STATE_AUTOMATON__START:
				return start != null;
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
		if (baseClass == CoreAbstractionsOwnershipsElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT;
				case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER;
				case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT: return EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_STATE_AUTOMATON__NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME;
				case EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME;
				case EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE;
				case EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamespace.class) {
			switch (derivedFeatureID) {
				case EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER;
				case EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER: return EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER;
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
		if (baseClass == CoreAbstractionsOwnershipsElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_ELEMENT: return EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_ELEMENT;
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNER: return EmfSdlPackage.SDL_STATE_AUTOMATON__OWNER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_OWNERSHIPS_ELEMENT__OWNED_COMMENT: return EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamedElement.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAME: return EmfSdlPackage.SDL_STATE_AUTOMATON__NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__QUALIFIED_NAME: return EmfSdlPackage.SDL_STATE_AUTOMATON__QUALIFIED_NAME;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__NAMESPACE: return EmfSdlPackage.SDL_STATE_AUTOMATON__NAMESPACE;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMED_ELEMENT__IDENTIFIER: return EmfSdlPackage.SDL_STATE_AUTOMATON__IDENTIFIER;
				default: return -1;
			}
		}
		if (baseClass == CoreAbstractionsNamespacesNamespace.class) {
			switch (baseFeatureID) {
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__OWNED_MEMBER: return EmfSdlPackage.SDL_STATE_AUTOMATON__OWNED_MEMBER;
				case EmfSdlPackage.CORE_ABSTRACTIONS_NAMESPACES_NAMESPACE__MEMBER: return EmfSdlPackage.SDL_STATE_AUTOMATON__MEMBER;
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
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //SdlStateAutomatonImpl
