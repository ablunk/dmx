/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.edu.modsoft.bfmodel.bf.impl;

import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;
import hub.sam.edu.modsoft.bfmodel.bf.Flow;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getName <em>Name</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getOwnedBoxes <em>Owned Boxes</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getIncomingFlows <em>Incoming Flows</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getOutgoingFlows <em>Outgoing Flows</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.BoxImpl#getMetaClass <em>Meta Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoxImpl extends EObjectImpl implements Box {
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
	 * The cached value of the '{@link #getOwnedBoxes() <em>Owned Boxes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBoxes()
	 * @generated
	 * @ordered
	 */
	protected EList<Box> ownedBoxes;

	/**
	 * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> flows;

	/**
	 * The cached value of the '{@link #getIncomingFlows() <em>Incoming Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> incomingFlows;

	/**
	 * The cached value of the '{@link #getOutgoingFlows() <em>Outgoing Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<Flow> outgoingFlows;

	/**
	 * The cached value of the '{@link #getMetaClass() <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaClass()
	 * @generated
	 * @ordered
	 */
	protected EClass metaClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BfPackage.Literals.BOX;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BfPackage.BOX__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Box> getOwnedBoxes() {
		if (ownedBoxes == null) {
			ownedBoxes = new EObjectContainmentWithInverseEList<Box>(Box.class, this, BfPackage.BOX__OWNED_BOXES, BfPackage.BOX__OWNER);
		}
		return ownedBoxes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box getOwner() {
		if (eContainerFeatureID() != BfPackage.BOX__OWNER) return null;
		return (Box)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Box newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, BfPackage.BOX__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Box newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != BfPackage.BOX__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, BfPackage.BOX__OWNED_BOXES, Box.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BfPackage.BOX__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Flow> getFlows() {
		if (flows == null) {
			flows = new EObjectContainmentEList<Flow>(Flow.class, this, BfPackage.BOX__FLOWS);
		}
		return flows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Flow> getIncomingFlows() {
		if (incomingFlows == null) {
			incomingFlows = new EObjectWithInverseResolvingEList<Flow>(Flow.class, this, BfPackage.BOX__INCOMING_FLOWS, BfPackage.FLOW__TARGET_BOX);
		}
		return incomingFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Flow> getOutgoingFlows() {
		if (outgoingFlows == null) {
			outgoingFlows = new EObjectWithInverseResolvingEList<Flow>(Flow.class, this, BfPackage.BOX__OUTGOING_FLOWS, BfPackage.FLOW__SOURCE_BOX);
		}
		return outgoingFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaClass() {
		if (metaClass != null && metaClass.eIsProxy()) {
			InternalEObject oldMetaClass = (InternalEObject)metaClass;
			metaClass = (EClass)eResolveProxy(oldMetaClass);
			if (metaClass != oldMetaClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BfPackage.BOX__META_CLASS, oldMetaClass, metaClass));
			}
		}
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetMetaClass() {
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaClass(EClass newMetaClass) {
		EClass oldMetaClass = metaClass;
		metaClass = newMetaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BfPackage.BOX__META_CLASS, oldMetaClass, metaClass));
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
			case BfPackage.BOX__OWNED_BOXES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedBoxes()).basicAdd(otherEnd, msgs);
			case BfPackage.BOX__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Box)otherEnd, msgs);
			case BfPackage.BOX__INCOMING_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingFlows()).basicAdd(otherEnd, msgs);
			case BfPackage.BOX__OUTGOING_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingFlows()).basicAdd(otherEnd, msgs);
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
			case BfPackage.BOX__OWNED_BOXES:
				return ((InternalEList<?>)getOwnedBoxes()).basicRemove(otherEnd, msgs);
			case BfPackage.BOX__OWNER:
				return basicSetOwner(null, msgs);
			case BfPackage.BOX__FLOWS:
				return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
			case BfPackage.BOX__INCOMING_FLOWS:
				return ((InternalEList<?>)getIncomingFlows()).basicRemove(otherEnd, msgs);
			case BfPackage.BOX__OUTGOING_FLOWS:
				return ((InternalEList<?>)getOutgoingFlows()).basicRemove(otherEnd, msgs);
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
			case BfPackage.BOX__OWNER:
				return eInternalContainer().eInverseRemove(this, BfPackage.BOX__OWNED_BOXES, Box.class, msgs);
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
			case BfPackage.BOX__NAME:
				return getName();
			case BfPackage.BOX__OWNED_BOXES:
				return getOwnedBoxes();
			case BfPackage.BOX__OWNER:
				return getOwner();
			case BfPackage.BOX__FLOWS:
				return getFlows();
			case BfPackage.BOX__INCOMING_FLOWS:
				return getIncomingFlows();
			case BfPackage.BOX__OUTGOING_FLOWS:
				return getOutgoingFlows();
			case BfPackage.BOX__META_CLASS:
				if (resolve) return getMetaClass();
				return basicGetMetaClass();
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
			case BfPackage.BOX__NAME:
				setName((String)newValue);
				return;
			case BfPackage.BOX__OWNED_BOXES:
				getOwnedBoxes().clear();
				getOwnedBoxes().addAll((Collection<? extends Box>)newValue);
				return;
			case BfPackage.BOX__OWNER:
				setOwner((Box)newValue);
				return;
			case BfPackage.BOX__FLOWS:
				getFlows().clear();
				getFlows().addAll((Collection<? extends Flow>)newValue);
				return;
			case BfPackage.BOX__INCOMING_FLOWS:
				getIncomingFlows().clear();
				getIncomingFlows().addAll((Collection<? extends Flow>)newValue);
				return;
			case BfPackage.BOX__OUTGOING_FLOWS:
				getOutgoingFlows().clear();
				getOutgoingFlows().addAll((Collection<? extends Flow>)newValue);
				return;
			case BfPackage.BOX__META_CLASS:
				setMetaClass((EClass)newValue);
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
			case BfPackage.BOX__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BfPackage.BOX__OWNED_BOXES:
				getOwnedBoxes().clear();
				return;
			case BfPackage.BOX__OWNER:
				setOwner((Box)null);
				return;
			case BfPackage.BOX__FLOWS:
				getFlows().clear();
				return;
			case BfPackage.BOX__INCOMING_FLOWS:
				getIncomingFlows().clear();
				return;
			case BfPackage.BOX__OUTGOING_FLOWS:
				getOutgoingFlows().clear();
				return;
			case BfPackage.BOX__META_CLASS:
				setMetaClass((EClass)null);
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
			case BfPackage.BOX__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BfPackage.BOX__OWNED_BOXES:
				return ownedBoxes != null && !ownedBoxes.isEmpty();
			case BfPackage.BOX__OWNER:
				return getOwner() != null;
			case BfPackage.BOX__FLOWS:
				return flows != null && !flows.isEmpty();
			case BfPackage.BOX__INCOMING_FLOWS:
				return incomingFlows != null && !incomingFlows.isEmpty();
			case BfPackage.BOX__OUTGOING_FLOWS:
				return outgoingFlows != null && !outgoingFlows.isEmpty();
			case BfPackage.BOX__META_CLASS:
				return metaClass != null;
		}
		return super.eIsSet(featureID);
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

} //BoxImpl
