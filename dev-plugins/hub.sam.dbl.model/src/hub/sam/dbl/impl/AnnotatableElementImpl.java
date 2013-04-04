/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.AnnotatableElement;
import hub.sam.dbl.AnnotationApplication;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.SimpleAnnotation;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.AnnotatableElementImpl#getAnnotationApplications <em>Annotation Applications</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.AnnotatableElementImpl#getSimpleAnnotations <em>Simple Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnnotatableElementImpl extends EObjectImpl implements AnnotatableElement {
	/**
	 * The cached value of the '{@link #getAnnotationApplications() <em>Annotation Applications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationApplications()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationApplication> annotationApplications;

	/**
	 * The cached value of the '{@link #getSimpleAnnotations() <em>Simple Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleAnnotation> simpleAnnotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotatableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.ANNOTATABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationApplication> getAnnotationApplications() {
		if (annotationApplications == null) {
			annotationApplications = new EObjectContainmentEList<AnnotationApplication>(AnnotationApplication.class, this, DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS);
		}
		return annotationApplications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleAnnotation> getSimpleAnnotations() {
		if (simpleAnnotations == null) {
			simpleAnnotations = new EObjectContainmentEList<SimpleAnnotation>(SimpleAnnotation.class, this, DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS);
		}
		return simpleAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS:
				return ((InternalEList<?>)getAnnotationApplications()).basicRemove(otherEnd, msgs);
			case DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS:
				return ((InternalEList<?>)getSimpleAnnotations()).basicRemove(otherEnd, msgs);
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
			case DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS:
				return getAnnotationApplications();
			case DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS:
				return getSimpleAnnotations();
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
			case DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS:
				getAnnotationApplications().clear();
				getAnnotationApplications().addAll((Collection<? extends AnnotationApplication>)newValue);
				return;
			case DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS:
				getSimpleAnnotations().clear();
				getSimpleAnnotations().addAll((Collection<? extends SimpleAnnotation>)newValue);
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
			case DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS:
				getAnnotationApplications().clear();
				return;
			case DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS:
				getSimpleAnnotations().clear();
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
			case DblPackage.ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS:
				return annotationApplications != null && !annotationApplications.isEmpty();
			case DblPackage.ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS:
				return simpleAnnotations != null && !simpleAnnotations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotatableElementImpl
