/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Concept;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Extension;
import hub.sam.dbl.SyntaxDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensionImpl#getExtensionPoint <em>Extension Point</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionImpl#getSyntaxDefinition <em>Syntax Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtensionImpl extends ConceptImpl implements Extension {
	/**
	 * The cached value of the '{@link #getExtensionPoint() <em>Extension Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPoint()
	 * @generated
	 * @ordered
	 */
	protected Concept extensionPoint;

	/**
	 * The cached value of the '{@link #getSyntaxDefinition() <em>Syntax Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntaxDefinition()
	 * @generated
	 * @ordered
	 */
	protected SyntaxDefinition syntaxDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept getExtensionPoint() {
		if (extensionPoint != null && ((EObject)extensionPoint).eIsProxy()) {
			InternalEObject oldExtensionPoint = (InternalEObject)extensionPoint;
			extensionPoint = (Concept)eResolveProxy(oldExtensionPoint);
			if (extensionPoint != oldExtensionPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.EXTENSION__EXTENSION_POINT, oldExtensionPoint, extensionPoint));
			}
		}
		return extensionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetExtensionPoint() {
		return extensionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionPoint(Concept newExtensionPoint) {
		Concept oldExtensionPoint = extensionPoint;
		extensionPoint = newExtensionPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION__EXTENSION_POINT, oldExtensionPoint, extensionPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxDefinition getSyntaxDefinition() {
		return syntaxDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSyntaxDefinition(SyntaxDefinition newSyntaxDefinition, NotificationChain msgs) {
		SyntaxDefinition oldSyntaxDefinition = syntaxDefinition;
		syntaxDefinition = newSyntaxDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION__SYNTAX_DEFINITION, oldSyntaxDefinition, newSyntaxDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntaxDefinition(SyntaxDefinition newSyntaxDefinition) {
		if (newSyntaxDefinition != syntaxDefinition) {
			NotificationChain msgs = null;
			if (syntaxDefinition != null)
				msgs = ((InternalEObject)syntaxDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION__SYNTAX_DEFINITION, null, msgs);
			if (newSyntaxDefinition != null)
				msgs = ((InternalEObject)newSyntaxDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION__SYNTAX_DEFINITION, null, msgs);
			msgs = basicSetSyntaxDefinition(newSyntaxDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION__SYNTAX_DEFINITION, newSyntaxDefinition, newSyntaxDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXTENSION__SYNTAX_DEFINITION:
				return basicSetSyntaxDefinition(null, msgs);
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
			case DblPackage.EXTENSION__EXTENSION_POINT:
				if (resolve) return getExtensionPoint();
				return basicGetExtensionPoint();
			case DblPackage.EXTENSION__SYNTAX_DEFINITION:
				return getSyntaxDefinition();
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
			case DblPackage.EXTENSION__EXTENSION_POINT:
				setExtensionPoint((Concept)newValue);
				return;
			case DblPackage.EXTENSION__SYNTAX_DEFINITION:
				setSyntaxDefinition((SyntaxDefinition)newValue);
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
			case DblPackage.EXTENSION__EXTENSION_POINT:
				setExtensionPoint((Concept)null);
				return;
			case DblPackage.EXTENSION__SYNTAX_DEFINITION:
				setSyntaxDefinition((SyntaxDefinition)null);
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
			case DblPackage.EXTENSION__EXTENSION_POINT:
				return extensionPoint != null;
			case DblPackage.EXTENSION__SYNTAX_DEFINITION:
				return syntaxDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtensionImpl
