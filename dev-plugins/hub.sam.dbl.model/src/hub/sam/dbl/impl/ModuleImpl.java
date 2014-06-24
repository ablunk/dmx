/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ClassAugment;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.EmbeddableExtensionsContainer;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.Module;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ModuleImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ModuleImpl#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ModuleImpl#getClassAugments <em>Class Augments</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ModuleImpl#getExtensionDefs <em>Extension Defs</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ModuleImpl#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ModuleImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends NamedElementImpl implements Module {
	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensibleElement> extensions;

	/**
	 * The cached value of the '{@link #getClassifiers() <em>Classifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> classifiers;

	/**
	 * The cached value of the '{@link #getClassAugments() <em>Class Augments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassAugments()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassAugment> classAugments;

	/**
	 * The cached value of the '{@link #getExtensionDefs() <em>Extension Defs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionDefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionDefinition> extensionDefs;

	/**
	 * The cached value of the '{@link #getProcedures() <em>Procedures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedures()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> procedures;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensibleElement> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<ExtensibleElement>(ExtensibleElement.class, this, DblPackage.MODULE__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getClassifiers() {
		if (classifiers == null) {
			classifiers = new EObjectContainmentEList<Classifier>(Classifier.class, this, DblPackage.MODULE__CLASSIFIERS);
		}
		return classifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassAugment> getClassAugments() {
		if (classAugments == null) {
			classAugments = new EObjectContainmentEList<ClassAugment>(ClassAugment.class, this, DblPackage.MODULE__CLASS_AUGMENTS);
		}
		return classAugments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionDefinition> getExtensionDefs() {
		if (extensionDefs == null) {
			extensionDefs = new EObjectContainmentEList<ExtensionDefinition>(ExtensionDefinition.class, this, DblPackage.MODULE__EXTENSION_DEFS);
		}
		return extensionDefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Procedure> getProcedures() {
		if (procedures == null) {
			procedures = new EObjectContainmentEList<Procedure>(Procedure.class, this, DblPackage.MODULE__PROCEDURES);
		}
		return procedures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, DblPackage.MODULE__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.MODULE__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.MODULE__CLASSIFIERS:
				return ((InternalEList<?>)getClassifiers()).basicRemove(otherEnd, msgs);
			case DblPackage.MODULE__CLASS_AUGMENTS:
				return ((InternalEList<?>)getClassAugments()).basicRemove(otherEnd, msgs);
			case DblPackage.MODULE__EXTENSION_DEFS:
				return ((InternalEList<?>)getExtensionDefs()).basicRemove(otherEnd, msgs);
			case DblPackage.MODULE__PROCEDURES:
				return ((InternalEList<?>)getProcedures()).basicRemove(otherEnd, msgs);
			case DblPackage.MODULE__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case DblPackage.MODULE__EXTENSIONS:
				return getExtensions();
			case DblPackage.MODULE__CLASSIFIERS:
				return getClassifiers();
			case DblPackage.MODULE__CLASS_AUGMENTS:
				return getClassAugments();
			case DblPackage.MODULE__EXTENSION_DEFS:
				return getExtensionDefs();
			case DblPackage.MODULE__PROCEDURES:
				return getProcedures();
			case DblPackage.MODULE__VARIABLES:
				return getVariables();
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
			case DblPackage.MODULE__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends ExtensibleElement>)newValue);
				return;
			case DblPackage.MODULE__CLASSIFIERS:
				getClassifiers().clear();
				getClassifiers().addAll((Collection<? extends Classifier>)newValue);
				return;
			case DblPackage.MODULE__CLASS_AUGMENTS:
				getClassAugments().clear();
				getClassAugments().addAll((Collection<? extends ClassAugment>)newValue);
				return;
			case DblPackage.MODULE__EXTENSION_DEFS:
				getExtensionDefs().clear();
				getExtensionDefs().addAll((Collection<? extends ExtensionDefinition>)newValue);
				return;
			case DblPackage.MODULE__PROCEDURES:
				getProcedures().clear();
				getProcedures().addAll((Collection<? extends Procedure>)newValue);
				return;
			case DblPackage.MODULE__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
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
			case DblPackage.MODULE__EXTENSIONS:
				getExtensions().clear();
				return;
			case DblPackage.MODULE__CLASSIFIERS:
				getClassifiers().clear();
				return;
			case DblPackage.MODULE__CLASS_AUGMENTS:
				getClassAugments().clear();
				return;
			case DblPackage.MODULE__EXTENSION_DEFS:
				getExtensionDefs().clear();
				return;
			case DblPackage.MODULE__PROCEDURES:
				getProcedures().clear();
				return;
			case DblPackage.MODULE__VARIABLES:
				getVariables().clear();
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
			case DblPackage.MODULE__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case DblPackage.MODULE__CLASSIFIERS:
				return classifiers != null && !classifiers.isEmpty();
			case DblPackage.MODULE__CLASS_AUGMENTS:
				return classAugments != null && !classAugments.isEmpty();
			case DblPackage.MODULE__EXTENSION_DEFS:
				return extensionDefs != null && !extensionDefs.isEmpty();
			case DblPackage.MODULE__PROCEDURES:
				return procedures != null && !procedures.isEmpty();
			case DblPackage.MODULE__VARIABLES:
				return variables != null && !variables.isEmpty();
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
		if (baseClass == EmbeddableExtensionsContainer.class) {
			switch (derivedFeatureID) {
				case DblPackage.MODULE__EXTENSIONS: return DblPackage.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS;
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
		if (baseClass == EmbeddableExtensionsContainer.class) {
			switch (baseFeatureID) {
				case DblPackage.EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS: return DblPackage.MODULE__EXTENSIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ModuleImpl
