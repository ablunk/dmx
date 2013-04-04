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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.FlowImpl#getSourceBox <em>Source Box</em>}</li>
 *   <li>{@link hub.sam.edu.modsoft.bfmodel.bf.impl.FlowImpl#getTargetBox <em>Target Box</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowImpl extends EObjectImpl implements Flow {
	/**
	 * The cached value of the '{@link #getSourceBox() <em>Source Box</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceBox()
	 * @generated
	 * @ordered
	 */
	protected Box sourceBox;

	/**
	 * The cached value of the '{@link #getTargetBox() <em>Target Box</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetBox()
	 * @generated
	 * @ordered
	 */
	protected Box targetBox;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BfPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box getSourceBox() {
		if (sourceBox != null && sourceBox.eIsProxy()) {
			InternalEObject oldSourceBox = (InternalEObject)sourceBox;
			sourceBox = (Box)eResolveProxy(oldSourceBox);
			if (sourceBox != oldSourceBox) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BfPackage.FLOW__SOURCE_BOX, oldSourceBox, sourceBox));
			}
		}
		return sourceBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box basicGetSourceBox() {
		return sourceBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceBox(Box newSourceBox, NotificationChain msgs) {
		Box oldSourceBox = sourceBox;
		sourceBox = newSourceBox;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BfPackage.FLOW__SOURCE_BOX, oldSourceBox, newSourceBox);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceBox(Box newSourceBox) {
		if (newSourceBox != sourceBox) {
			NotificationChain msgs = null;
			if (sourceBox != null)
				msgs = ((InternalEObject)sourceBox).eInverseRemove(this, BfPackage.BOX__OUTGOING_FLOWS, Box.class, msgs);
			if (newSourceBox != null)
				msgs = ((InternalEObject)newSourceBox).eInverseAdd(this, BfPackage.BOX__OUTGOING_FLOWS, Box.class, msgs);
			msgs = basicSetSourceBox(newSourceBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BfPackage.FLOW__SOURCE_BOX, newSourceBox, newSourceBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box getTargetBox() {
		if (targetBox != null && targetBox.eIsProxy()) {
			InternalEObject oldTargetBox = (InternalEObject)targetBox;
			targetBox = (Box)eResolveProxy(oldTargetBox);
			if (targetBox != oldTargetBox) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BfPackage.FLOW__TARGET_BOX, oldTargetBox, targetBox));
			}
		}
		return targetBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Box basicGetTargetBox() {
		return targetBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetBox(Box newTargetBox, NotificationChain msgs) {
		Box oldTargetBox = targetBox;
		targetBox = newTargetBox;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BfPackage.FLOW__TARGET_BOX, oldTargetBox, newTargetBox);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetBox(Box newTargetBox) {
		if (newTargetBox != targetBox) {
			NotificationChain msgs = null;
			if (targetBox != null)
				msgs = ((InternalEObject)targetBox).eInverseRemove(this, BfPackage.BOX__INCOMING_FLOWS, Box.class, msgs);
			if (newTargetBox != null)
				msgs = ((InternalEObject)newTargetBox).eInverseAdd(this, BfPackage.BOX__INCOMING_FLOWS, Box.class, msgs);
			msgs = basicSetTargetBox(newTargetBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BfPackage.FLOW__TARGET_BOX, newTargetBox, newTargetBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BfPackage.FLOW__SOURCE_BOX:
				if (sourceBox != null)
					msgs = ((InternalEObject)sourceBox).eInverseRemove(this, BfPackage.BOX__OUTGOING_FLOWS, Box.class, msgs);
				return basicSetSourceBox((Box)otherEnd, msgs);
			case BfPackage.FLOW__TARGET_BOX:
				if (targetBox != null)
					msgs = ((InternalEObject)targetBox).eInverseRemove(this, BfPackage.BOX__INCOMING_FLOWS, Box.class, msgs);
				return basicSetTargetBox((Box)otherEnd, msgs);
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
			case BfPackage.FLOW__SOURCE_BOX:
				return basicSetSourceBox(null, msgs);
			case BfPackage.FLOW__TARGET_BOX:
				return basicSetTargetBox(null, msgs);
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
			case BfPackage.FLOW__SOURCE_BOX:
				if (resolve) return getSourceBox();
				return basicGetSourceBox();
			case BfPackage.FLOW__TARGET_BOX:
				if (resolve) return getTargetBox();
				return basicGetTargetBox();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BfPackage.FLOW__SOURCE_BOX:
				setSourceBox((Box)newValue);
				return;
			case BfPackage.FLOW__TARGET_BOX:
				setTargetBox((Box)newValue);
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
			case BfPackage.FLOW__SOURCE_BOX:
				setSourceBox((Box)null);
				return;
			case BfPackage.FLOW__TARGET_BOX:
				setTargetBox((Box)null);
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
			case BfPackage.FLOW__SOURCE_BOX:
				return sourceBox != null;
			case BfPackage.FLOW__TARGET_BOX:
				return targetBox != null;
		}
		return super.eIsSet(featureID);
	}

} //FlowImpl
