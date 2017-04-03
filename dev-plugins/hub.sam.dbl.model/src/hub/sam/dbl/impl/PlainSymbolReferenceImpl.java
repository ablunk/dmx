/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.PlainSymbolReference;
import hub.sam.dbl.SyntaxSymbolClassifier;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plain Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.PlainSymbolReferenceImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.PlainSymbolReferenceImpl#getOwnedClassifier <em>Owned Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.PlainSymbolReferenceImpl#getReferencedClassifier <em>Referenced Classifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlainSymbolReferenceImpl extends L1SyntaxExpressionImpl implements PlainSymbolReference {
	/**
	 * The cached value of the '{@link #getOwnedClassifier() <em>Owned Classifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClassifier()
	 * @generated
	 * @ordered
	 */
	protected SyntaxSymbolClassifier ownedClassifier;
	/**
	 * The cached value of the '{@link #getReferencedClassifier() <em>Referenced Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedClassifier()
	 * @generated
	 * @ordered
	 */
	protected SyntaxSymbolClassifier referencedClassifier;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlainSymbolReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.PLAIN_SYMBOL_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxSymbolClassifier getClassifier() {
		SyntaxSymbolClassifier classifier = basicGetClassifier();
		return classifier != null && ((EObject)classifier).eIsProxy() ? (SyntaxSymbolClassifier)eResolveProxy((InternalEObject)classifier) : classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SyntaxSymbolClassifier basicGetClassifier() {
		SyntaxSymbolClassifier classifier = getOwnedClassifier();
		if (classifier == null) {
			classifier = getReferencedClassifier();
		}
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxSymbolClassifier getOwnedClassifier() {
		return ownedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedClassifier(SyntaxSymbolClassifier newOwnedClassifier, NotificationChain msgs) {
		SyntaxSymbolClassifier oldOwnedClassifier = ownedClassifier;
		ownedClassifier = newOwnedClassifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER, oldOwnedClassifier, newOwnedClassifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedClassifier(SyntaxSymbolClassifier newOwnedClassifier) {
		if (newOwnedClassifier != ownedClassifier) {
			NotificationChain msgs = null;
			if (ownedClassifier != null)
				msgs = ((InternalEObject)ownedClassifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER, null, msgs);
			if (newOwnedClassifier != null)
				msgs = ((InternalEObject)newOwnedClassifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER, null, msgs);
			msgs = basicSetOwnedClassifier(newOwnedClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER, newOwnedClassifier, newOwnedClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxSymbolClassifier getReferencedClassifier() {
		if (referencedClassifier != null && ((EObject)referencedClassifier).eIsProxy()) {
			InternalEObject oldReferencedClassifier = (InternalEObject)referencedClassifier;
			referencedClassifier = (SyntaxSymbolClassifier)eResolveProxy(oldReferencedClassifier);
			if (referencedClassifier != oldReferencedClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER, oldReferencedClassifier, referencedClassifier));
			}
		}
		return referencedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxSymbolClassifier basicGetReferencedClassifier() {
		return referencedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedClassifier(SyntaxSymbolClassifier newReferencedClassifier) {
		SyntaxSymbolClassifier oldReferencedClassifier = referencedClassifier;
		referencedClassifier = newReferencedClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER, oldReferencedClassifier, referencedClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				return basicSetOwnedClassifier(null, msgs);
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
			case DblPackage.PLAIN_SYMBOL_REFERENCE__CLASSIFIER:
				if (resolve) return getClassifier();
				return basicGetClassifier();
			case DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				return getOwnedClassifier();
			case DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				if (resolve) return getReferencedClassifier();
				return basicGetReferencedClassifier();
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
			case DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				setOwnedClassifier((SyntaxSymbolClassifier)newValue);
				return;
			case DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				setReferencedClassifier((SyntaxSymbolClassifier)newValue);
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
			case DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				setOwnedClassifier((SyntaxSymbolClassifier)null);
				return;
			case DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				setReferencedClassifier((SyntaxSymbolClassifier)null);
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
			case DblPackage.PLAIN_SYMBOL_REFERENCE__CLASSIFIER:
				return basicGetClassifier() != null;
			case DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				return ownedClassifier != null;
			case DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				return referencedClassifier != null;
		}
		return super.eIsSet(featureID);
	}

} //PlainSymbolReferenceImpl
