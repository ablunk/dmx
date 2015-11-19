/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.L1SyntaxExpression;
import hub.sam.dbl.PlainSymbolReference;
import hub.sam.dbl.StructuralSymbolReference;
import hub.sam.dbl.SyntaxExpression;
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
 * An implementation of the model object '<em><b>Structural Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#getOwnedClassifier <em>Owned Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#getReferencedClassifier <em>Referenced Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#isList <em>List</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#isComposite <em>Composite</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#isLocalScopedReference <em>Local Scoped Reference</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl#isGlobalScopedReference <em>Global Scoped Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructuralSymbolReferenceImpl extends NamedElementImpl implements StructuralSymbolReference {
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
	 * The default value of the '{@link #isList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isList()
	 * @generated
	 * @ordered
	 */
	protected boolean list = LIST_EDEFAULT;

	/**
	 * The cached setting delegate for the '{@link #isComposite() <em>Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate COMPOSITE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)DblPackage.Literals.STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE).getSettingDelegate();

	/**
	 * The default value of the '{@link #isLocalScopedReference() <em>Local Scoped Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalScopedReference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_SCOPED_REFERENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocalScopedReference() <em>Local Scoped Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalScopedReference()
	 * @generated
	 * @ordered
	 */
	protected boolean localScopedReference = LOCAL_SCOPED_REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGlobalScopedReference() <em>Global Scoped Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGlobalScopedReference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GLOBAL_SCOPED_REFERENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGlobalScopedReference() <em>Global Scoped Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGlobalScopedReference()
	 * @generated
	 * @ordered
	 */
	protected boolean globalScopedReference = GLOBAL_SCOPED_REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuralSymbolReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.STRUCTURAL_SYMBOL_REFERENCE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER, oldOwnedClassifier, newOwnedClassifier);
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
				msgs = ((InternalEObject)ownedClassifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER, null, msgs);
			if (newOwnedClassifier != null)
				msgs = ((InternalEObject)newOwnedClassifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER, null, msgs);
			msgs = basicSetOwnedClassifier(newOwnedClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER, newOwnedClassifier, newOwnedClassifier));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER, oldReferencedClassifier, referencedClassifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER, oldReferencedClassifier, referencedClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isList() {
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(boolean newList) {
		boolean oldList = list;
		list = newList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LIST, oldList, list));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposite() {
		return (Boolean)COMPOSITE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalScopedReference() {
		return localScopedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalScopedReference(boolean newLocalScopedReference) {
		boolean oldLocalScopedReference = localScopedReference;
		localScopedReference = newLocalScopedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE, oldLocalScopedReference, localScopedReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGlobalScopedReference() {
		return globalScopedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalScopedReference(boolean newGlobalScopedReference) {
		boolean oldGlobalScopedReference = globalScopedReference;
		globalScopedReference = newGlobalScopedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE, oldGlobalScopedReference, globalScopedReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
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
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__CLASSIFIER:
				if (resolve) return getClassifier();
				return basicGetClassifier();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				return getOwnedClassifier();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				if (resolve) return getReferencedClassifier();
				return basicGetReferencedClassifier();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LIST:
				return isList();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE:
				return isComposite();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE:
				return isLocalScopedReference();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE:
				return isGlobalScopedReference();
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
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				setOwnedClassifier((SyntaxSymbolClassifier)newValue);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				setReferencedClassifier((SyntaxSymbolClassifier)newValue);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LIST:
				setList((Boolean)newValue);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE:
				setLocalScopedReference((Boolean)newValue);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE:
				setGlobalScopedReference((Boolean)newValue);
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
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				setOwnedClassifier((SyntaxSymbolClassifier)null);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				setReferencedClassifier((SyntaxSymbolClassifier)null);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LIST:
				setList(LIST_EDEFAULT);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE:
				setLocalScopedReference(LOCAL_SCOPED_REFERENCE_EDEFAULT);
				return;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE:
				setGlobalScopedReference(GLOBAL_SCOPED_REFERENCE_EDEFAULT);
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
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__CLASSIFIER:
				return basicGetClassifier() != null;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER:
				return ownedClassifier != null;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER:
				return referencedClassifier != null;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LIST:
				return list != LIST_EDEFAULT;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE:
				return COMPOSITE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE:
				return localScopedReference != LOCAL_SCOPED_REFERENCE_EDEFAULT;
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE:
				return globalScopedReference != GLOBAL_SCOPED_REFERENCE_EDEFAULT;
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
		if (baseClass == SyntaxExpression.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == L1SyntaxExpression.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PlainSymbolReference.class) {
			switch (derivedFeatureID) {
				case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__CLASSIFIER: return DblPackage.PLAIN_SYMBOL_REFERENCE__CLASSIFIER;
				case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER: return DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER;
				case DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER: return DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER;
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
		if (baseClass == SyntaxExpression.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == L1SyntaxExpression.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PlainSymbolReference.class) {
			switch (baseFeatureID) {
				case DblPackage.PLAIN_SYMBOL_REFERENCE__CLASSIFIER: return DblPackage.STRUCTURAL_SYMBOL_REFERENCE__CLASSIFIER;
				case DblPackage.PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER: return DblPackage.STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER;
				case DblPackage.PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER: return DblPackage.STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER;
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
		result.append(" (list: ");
		result.append(list);
		result.append(", localScopedReference: ");
		result.append(localScopedReference);
		result.append(", globalScopedReference: ");
		result.append(globalScopedReference);
		result.append(')');
		return result.toString();
	}

} //StructuralSymbolReferenceImpl
