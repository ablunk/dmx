/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dmx.modifications.impl;

import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dmx.modifications.impl.ModificationImpl#getSourceEObjectUri <em>Source EObject Uri</em>}</li>
 *   <li>{@link hub.sam.dmx.modifications.impl.ModificationImpl#getSourceStart <em>Source Start</em>}</li>
 *   <li>{@link hub.sam.dmx.modifications.impl.ModificationImpl#getReplacementText <em>Replacement Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModificationImpl extends EObjectImpl implements Modification {
	/**
	 * The default value of the '{@link #getSourceEObjectUri() <em>Source EObject Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEObjectUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EOBJECT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceEObjectUri() <em>Source EObject Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEObjectUri()
	 * @generated
	 * @ordered
	 */
	protected String sourceEObjectUri = SOURCE_EOBJECT_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceStart() <em>Source Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceStart()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_START_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSourceStart() <em>Source Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceStart()
	 * @generated
	 * @ordered
	 */
	protected int sourceStart = SOURCE_START_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplacementText() <em>Replacement Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementText()
	 * @generated
	 * @ordered
	 */
	protected static final String REPLACEMENT_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReplacementText() <em>Replacement Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplacementText()
	 * @generated
	 * @ordered
	 */
	protected String replacementText = REPLACEMENT_TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModificationsPackage.Literals.MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceEObjectUri() {
		return sourceEObjectUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceEObjectUri(String newSourceEObjectUri) {
		String oldSourceEObjectUri = sourceEObjectUri;
		sourceEObjectUri = newSourceEObjectUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModificationsPackage.MODIFICATION__SOURCE_EOBJECT_URI, oldSourceEObjectUri, sourceEObjectUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceStart() {
		return sourceStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceStart(int newSourceStart) {
		int oldSourceStart = sourceStart;
		sourceStart = newSourceStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModificationsPackage.MODIFICATION__SOURCE_START, oldSourceStart, sourceStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReplacementText() {
		return replacementText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacementText(String newReplacementText) {
		String oldReplacementText = replacementText;
		replacementText = newReplacementText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModificationsPackage.MODIFICATION__REPLACEMENT_TEXT, oldReplacementText, replacementText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModificationsPackage.MODIFICATION__SOURCE_EOBJECT_URI:
				return getSourceEObjectUri();
			case ModificationsPackage.MODIFICATION__SOURCE_START:
				return getSourceStart();
			case ModificationsPackage.MODIFICATION__REPLACEMENT_TEXT:
				return getReplacementText();
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
			case ModificationsPackage.MODIFICATION__SOURCE_EOBJECT_URI:
				setSourceEObjectUri((String)newValue);
				return;
			case ModificationsPackage.MODIFICATION__SOURCE_START:
				setSourceStart((Integer)newValue);
				return;
			case ModificationsPackage.MODIFICATION__REPLACEMENT_TEXT:
				setReplacementText((String)newValue);
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
			case ModificationsPackage.MODIFICATION__SOURCE_EOBJECT_URI:
				setSourceEObjectUri(SOURCE_EOBJECT_URI_EDEFAULT);
				return;
			case ModificationsPackage.MODIFICATION__SOURCE_START:
				setSourceStart(SOURCE_START_EDEFAULT);
				return;
			case ModificationsPackage.MODIFICATION__REPLACEMENT_TEXT:
				setReplacementText(REPLACEMENT_TEXT_EDEFAULT);
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
			case ModificationsPackage.MODIFICATION__SOURCE_EOBJECT_URI:
				return SOURCE_EOBJECT_URI_EDEFAULT == null ? sourceEObjectUri != null : !SOURCE_EOBJECT_URI_EDEFAULT.equals(sourceEObjectUri);
			case ModificationsPackage.MODIFICATION__SOURCE_START:
				return sourceStart != SOURCE_START_EDEFAULT;
			case ModificationsPackage.MODIFICATION__REPLACEMENT_TEXT:
				return REPLACEMENT_TEXT_EDEFAULT == null ? replacementText != null : !REPLACEMENT_TEXT_EDEFAULT.equals(replacementText);
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
		result.append(" (sourceEObjectUri: ");
		result.append(sourceEObjectUri);
		result.append(", sourceStart: ");
		result.append(sourceStart);
		result.append(", replacementText: ");
		result.append(replacementText);
		result.append(')');
		return result.toString();
	}

} //ModificationImpl
