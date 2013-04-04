/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Annotation;
import hub.sam.dbl.AnnotationApplication;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.KeyValuePair;

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
 * An implementation of the model object '<em><b>Annotation Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.AnnotationApplicationImpl#getAnnotationDef <em>Annotation Def</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.AnnotationApplicationImpl#getKeyValuePairs <em>Key Value Pairs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationApplicationImpl extends EObjectImpl implements AnnotationApplication {
	/**
	 * The cached value of the '{@link #getAnnotationDef() <em>Annotation Def</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationDef()
	 * @generated
	 * @ordered
	 */
	protected Annotation annotationDef;

	/**
	 * The cached value of the '{@link #getKeyValuePairs() <em>Key Value Pairs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyValuePairs()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValuePair> keyValuePairs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.ANNOTATION_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation getAnnotationDef() {
		if (annotationDef != null && annotationDef.eIsProxy()) {
			InternalEObject oldAnnotationDef = (InternalEObject)annotationDef;
			annotationDef = (Annotation)eResolveProxy(oldAnnotationDef);
			if (annotationDef != oldAnnotationDef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.ANNOTATION_APPLICATION__ANNOTATION_DEF, oldAnnotationDef, annotationDef));
			}
		}
		return annotationDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation basicGetAnnotationDef() {
		return annotationDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotationDef(Annotation newAnnotationDef) {
		Annotation oldAnnotationDef = annotationDef;
		annotationDef = newAnnotationDef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.ANNOTATION_APPLICATION__ANNOTATION_DEF, oldAnnotationDef, annotationDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValuePair> getKeyValuePairs() {
		if (keyValuePairs == null) {
			keyValuePairs = new EObjectContainmentEList<KeyValuePair>(KeyValuePair.class, this, DblPackage.ANNOTATION_APPLICATION__KEY_VALUE_PAIRS);
		}
		return keyValuePairs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.ANNOTATION_APPLICATION__KEY_VALUE_PAIRS:
				return ((InternalEList<?>)getKeyValuePairs()).basicRemove(otherEnd, msgs);
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
			case DblPackage.ANNOTATION_APPLICATION__ANNOTATION_DEF:
				if (resolve) return getAnnotationDef();
				return basicGetAnnotationDef();
			case DblPackage.ANNOTATION_APPLICATION__KEY_VALUE_PAIRS:
				return getKeyValuePairs();
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
			case DblPackage.ANNOTATION_APPLICATION__ANNOTATION_DEF:
				setAnnotationDef((Annotation)newValue);
				return;
			case DblPackage.ANNOTATION_APPLICATION__KEY_VALUE_PAIRS:
				getKeyValuePairs().clear();
				getKeyValuePairs().addAll((Collection<? extends KeyValuePair>)newValue);
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
			case DblPackage.ANNOTATION_APPLICATION__ANNOTATION_DEF:
				setAnnotationDef((Annotation)null);
				return;
			case DblPackage.ANNOTATION_APPLICATION__KEY_VALUE_PAIRS:
				getKeyValuePairs().clear();
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
			case DblPackage.ANNOTATION_APPLICATION__ANNOTATION_DEF:
				return annotationDef != null;
			case DblPackage.ANNOTATION_APPLICATION__KEY_VALUE_PAIRS:
				return keyValuePairs != null && !keyValuePairs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationApplicationImpl
