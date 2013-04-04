/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.IdResolution;
import hub.sam.dbl.Pattern;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Id Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.IdResolutionImpl#getMetaModelPlatformURI <em>Meta Model Platform URI</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.IdResolutionImpl#getPatterns <em>Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdResolutionImpl extends EObjectImpl implements IdResolution {
	/**
	 * The default value of the '{@link #getMetaModelPlatformURI() <em>Meta Model Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelPlatformURI()
	 * @generated
	 * @ordered
	 */
	protected static final String META_MODEL_PLATFORM_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaModelPlatformURI() <em>Meta Model Platform URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModelPlatformURI()
	 * @generated
	 * @ordered
	 */
	protected String metaModelPlatformURI = META_MODEL_PLATFORM_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<Pattern> patterns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.ID_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaModelPlatformURI() {
		return metaModelPlatformURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModelPlatformURI(String newMetaModelPlatformURI) {
		String oldMetaModelPlatformURI = metaModelPlatformURI;
		metaModelPlatformURI = newMetaModelPlatformURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ID_RESOLUTION__META_MODEL_PLATFORM_URI, oldMetaModelPlatformURI, metaModelPlatformURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pattern> getPatterns() {
		if (patterns == null) {
			patterns = new EObjectContainmentEList<Pattern>(Pattern.class, this, DblPackage.ID_RESOLUTION__PATTERNS);
		}
		return patterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.ID_RESOLUTION__PATTERNS:
				return ((InternalEList<?>)getPatterns()).basicRemove(otherEnd, msgs);
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
			case DblPackage.ID_RESOLUTION__META_MODEL_PLATFORM_URI:
				return getMetaModelPlatformURI();
			case DblPackage.ID_RESOLUTION__PATTERNS:
				return getPatterns();
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
			case DblPackage.ID_RESOLUTION__META_MODEL_PLATFORM_URI:
				setMetaModelPlatformURI((String)newValue);
				return;
			case DblPackage.ID_RESOLUTION__PATTERNS:
				getPatterns().clear();
				getPatterns().addAll((Collection<? extends Pattern>)newValue);
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
			case DblPackage.ID_RESOLUTION__META_MODEL_PLATFORM_URI:
				setMetaModelPlatformURI(META_MODEL_PLATFORM_URI_EDEFAULT);
				return;
			case DblPackage.ID_RESOLUTION__PATTERNS:
				getPatterns().clear();
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
			case DblPackage.ID_RESOLUTION__META_MODEL_PLATFORM_URI:
				return META_MODEL_PLATFORM_URI_EDEFAULT == null ? metaModelPlatformURI != null : !META_MODEL_PLATFORM_URI_EDEFAULT.equals(metaModelPlatformURI);
			case DblPackage.ID_RESOLUTION__PATTERNS:
				return patterns != null && !patterns.isEmpty();
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
		result.append(" (metaModelPlatformURI: ");
		result.append(metaModelPlatformURI);
		result.append(')');
		return result.toString();
	}

} //IdResolutionImpl
