/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ClassPart;
import hub.sam.dbl.ClassSimilar;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ModifierExtensionsContainer;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Similar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getModifierExtensions <em>Modifier Extensions</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getSuperClasses <em>Super Classes</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getInitialBlock <em>Initial Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getFinalBlock <em>Final Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getActionsBlock <em>Actions Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getReportBlock <em>Report Block</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ClassSimilarImpl#getClearBlock <em>Clear Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassSimilarImpl extends EmbeddableExtensionsContainerImpl implements ClassSimilar {
	/**
	 * The cached value of the '{@link #getModifierExtensions() <em>Modifier Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifierExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensibleElement> modifierExtensions;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> attributes;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> methods;

	/**
	 * The cached value of the '{@link #getSuperClasses() <em>Super Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<SuperClassSpecification> superClasses;

	/**
	 * The cached value of the '{@link #getInitialBlock() <em>Initial Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialBlock()
	 * @generated
	 * @ordered
	 */
	protected ClassPart initialBlock;

	/**
	 * The cached value of the '{@link #getFinalBlock() <em>Final Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalBlock()
	 * @generated
	 * @ordered
	 */
	protected ClassPart finalBlock;

	/**
	 * The cached value of the '{@link #getActionsBlock() <em>Actions Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionsBlock()
	 * @generated
	 * @ordered
	 */
	protected ClassPart actionsBlock;

	/**
	 * The cached value of the '{@link #getReportBlock() <em>Report Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReportBlock()
	 * @generated
	 * @ordered
	 */
	protected ClassPart reportBlock;

	/**
	 * The cached value of the '{@link #getClearBlock() <em>Clear Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearBlock()
	 * @generated
	 * @ordered
	 */
	protected ClassPart clearBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassSimilarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.CLASS_SIMILAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensibleElement> getModifierExtensions() {
		if (modifierExtensions == null) {
			modifierExtensions = new EObjectContainmentEList<ExtensibleElement>(ExtensibleElement.class, this, DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS);
		}
		return modifierExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Variable>(Variable.class, this, DblPackage.CLASS_SIMILAR__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Procedure> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<Procedure>(Procedure.class, this, DblPackage.CLASS_SIMILAR__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SuperClassSpecification> getSuperClasses() {
		if (superClasses == null) {
			superClasses = new EObjectContainmentEList<SuperClassSpecification>(SuperClassSpecification.class, this, DblPackage.CLASS_SIMILAR__SUPER_CLASSES);
		}
		return superClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPart getInitialBlock() {
		return initialBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialBlock(ClassPart newInitialBlock, NotificationChain msgs) {
		ClassPart oldInitialBlock = initialBlock;
		initialBlock = newInitialBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__INITIAL_BLOCK, oldInitialBlock, newInitialBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialBlock(ClassPart newInitialBlock) {
		if (newInitialBlock != initialBlock) {
			NotificationChain msgs = null;
			if (initialBlock != null)
				msgs = ((InternalEObject)initialBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__INITIAL_BLOCK, null, msgs);
			if (newInitialBlock != null)
				msgs = ((InternalEObject)newInitialBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__INITIAL_BLOCK, null, msgs);
			msgs = basicSetInitialBlock(newInitialBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__INITIAL_BLOCK, newInitialBlock, newInitialBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPart getFinalBlock() {
		return finalBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinalBlock(ClassPart newFinalBlock, NotificationChain msgs) {
		ClassPart oldFinalBlock = finalBlock;
		finalBlock = newFinalBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__FINAL_BLOCK, oldFinalBlock, newFinalBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalBlock(ClassPart newFinalBlock) {
		if (newFinalBlock != finalBlock) {
			NotificationChain msgs = null;
			if (finalBlock != null)
				msgs = ((InternalEObject)finalBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__FINAL_BLOCK, null, msgs);
			if (newFinalBlock != null)
				msgs = ((InternalEObject)newFinalBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__FINAL_BLOCK, null, msgs);
			msgs = basicSetFinalBlock(newFinalBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__FINAL_BLOCK, newFinalBlock, newFinalBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPart getActionsBlock() {
		return actionsBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionsBlock(ClassPart newActionsBlock, NotificationChain msgs) {
		ClassPart oldActionsBlock = actionsBlock;
		actionsBlock = newActionsBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK, oldActionsBlock, newActionsBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionsBlock(ClassPart newActionsBlock) {
		if (newActionsBlock != actionsBlock) {
			NotificationChain msgs = null;
			if (actionsBlock != null)
				msgs = ((InternalEObject)actionsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK, null, msgs);
			if (newActionsBlock != null)
				msgs = ((InternalEObject)newActionsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK, null, msgs);
			msgs = basicSetActionsBlock(newActionsBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK, newActionsBlock, newActionsBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPart getReportBlock() {
		return reportBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReportBlock(ClassPart newReportBlock, NotificationChain msgs) {
		ClassPart oldReportBlock = reportBlock;
		reportBlock = newReportBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__REPORT_BLOCK, oldReportBlock, newReportBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReportBlock(ClassPart newReportBlock) {
		if (newReportBlock != reportBlock) {
			NotificationChain msgs = null;
			if (reportBlock != null)
				msgs = ((InternalEObject)reportBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__REPORT_BLOCK, null, msgs);
			if (newReportBlock != null)
				msgs = ((InternalEObject)newReportBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__REPORT_BLOCK, null, msgs);
			msgs = basicSetReportBlock(newReportBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__REPORT_BLOCK, newReportBlock, newReportBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPart getClearBlock() {
		return clearBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClearBlock(ClassPart newClearBlock, NotificationChain msgs) {
		ClassPart oldClearBlock = clearBlock;
		clearBlock = newClearBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__CLEAR_BLOCK, oldClearBlock, newClearBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClearBlock(ClassPart newClearBlock) {
		if (newClearBlock != clearBlock) {
			NotificationChain msgs = null;
			if (clearBlock != null)
				msgs = ((InternalEObject)clearBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__CLEAR_BLOCK, null, msgs);
			if (newClearBlock != null)
				msgs = ((InternalEObject)newClearBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.CLASS_SIMILAR__CLEAR_BLOCK, null, msgs);
			msgs = basicSetClearBlock(newClearBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.CLASS_SIMILAR__CLEAR_BLOCK, newClearBlock, newClearBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS:
				return ((InternalEList<?>)getModifierExtensions()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS_SIMILAR__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS_SIMILAR__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS_SIMILAR__SUPER_CLASSES:
				return ((InternalEList<?>)getSuperClasses()).basicRemove(otherEnd, msgs);
			case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK:
				return basicSetInitialBlock(null, msgs);
			case DblPackage.CLASS_SIMILAR__FINAL_BLOCK:
				return basicSetFinalBlock(null, msgs);
			case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK:
				return basicSetActionsBlock(null, msgs);
			case DblPackage.CLASS_SIMILAR__REPORT_BLOCK:
				return basicSetReportBlock(null, msgs);
			case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK:
				return basicSetClearBlock(null, msgs);
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
			case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS:
				return getModifierExtensions();
			case DblPackage.CLASS_SIMILAR__ATTRIBUTES:
				return getAttributes();
			case DblPackage.CLASS_SIMILAR__METHODS:
				return getMethods();
			case DblPackage.CLASS_SIMILAR__SUPER_CLASSES:
				return getSuperClasses();
			case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK:
				return getInitialBlock();
			case DblPackage.CLASS_SIMILAR__FINAL_BLOCK:
				return getFinalBlock();
			case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK:
				return getActionsBlock();
			case DblPackage.CLASS_SIMILAR__REPORT_BLOCK:
				return getReportBlock();
			case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK:
				return getClearBlock();
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
			case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				getModifierExtensions().addAll((Collection<? extends ExtensibleElement>)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Variable>)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Procedure>)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__SUPER_CLASSES:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends SuperClassSpecification>)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK:
				setInitialBlock((ClassPart)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__FINAL_BLOCK:
				setFinalBlock((ClassPart)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK:
				setActionsBlock((ClassPart)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__REPORT_BLOCK:
				setReportBlock((ClassPart)newValue);
				return;
			case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK:
				setClearBlock((ClassPart)newValue);
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
			case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS:
				getModifierExtensions().clear();
				return;
			case DblPackage.CLASS_SIMILAR__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DblPackage.CLASS_SIMILAR__METHODS:
				getMethods().clear();
				return;
			case DblPackage.CLASS_SIMILAR__SUPER_CLASSES:
				getSuperClasses().clear();
				return;
			case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK:
				setInitialBlock((ClassPart)null);
				return;
			case DblPackage.CLASS_SIMILAR__FINAL_BLOCK:
				setFinalBlock((ClassPart)null);
				return;
			case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK:
				setActionsBlock((ClassPart)null);
				return;
			case DblPackage.CLASS_SIMILAR__REPORT_BLOCK:
				setReportBlock((ClassPart)null);
				return;
			case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK:
				setClearBlock((ClassPart)null);
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
			case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS:
				return modifierExtensions != null && !modifierExtensions.isEmpty();
			case DblPackage.CLASS_SIMILAR__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DblPackage.CLASS_SIMILAR__METHODS:
				return methods != null && !methods.isEmpty();
			case DblPackage.CLASS_SIMILAR__SUPER_CLASSES:
				return superClasses != null && !superClasses.isEmpty();
			case DblPackage.CLASS_SIMILAR__INITIAL_BLOCK:
				return initialBlock != null;
			case DblPackage.CLASS_SIMILAR__FINAL_BLOCK:
				return finalBlock != null;
			case DblPackage.CLASS_SIMILAR__ACTIONS_BLOCK:
				return actionsBlock != null;
			case DblPackage.CLASS_SIMILAR__REPORT_BLOCK:
				return reportBlock != null;
			case DblPackage.CLASS_SIMILAR__CLEAR_BLOCK:
				return clearBlock != null;
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
		if (baseClass == ModifierExtensionsContainer.class) {
			switch (derivedFeatureID) {
				case DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS: return DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS;
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
		if (baseClass == ModifierExtensionsContainer.class) {
			switch (baseFeatureID) {
				case DblPackage.MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS: return DblPackage.CLASS_SIMILAR__MODIFIER_EXTENSIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ClassSimilarImpl
