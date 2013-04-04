/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.Classifier;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.Mapping;
import hub.sam.dbl.TextualSyntaxDef;

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
 * An implementation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getAbstractSyntaxDef <em>Abstract Syntax Def</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getTextualSyntaxDef <em>Textual Syntax Def</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getMappingDef <em>Mapping Def</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionDefinitionImpl extends NamedElementImpl implements ExtensionDefinition {
	/**
	 * The cached value of the '{@link #getAbstractSyntaxDef() <em>Abstract Syntax Def</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSyntaxDef()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> abstractSyntaxDef;

	/**
	 * The cached value of the '{@link #getTextualSyntaxDef() <em>Textual Syntax Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextualSyntaxDef()
	 * @generated
	 * @ordered
	 */
	protected TextualSyntaxDef textualSyntaxDef;

	/**
	 * The cached value of the '{@link #getMappingDef() <em>Mapping Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingDef()
	 * @generated
	 * @ordered
	 */
	protected Mapping mappingDef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXTENSION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getAbstractSyntaxDef() {
		if (abstractSyntaxDef == null) {
			abstractSyntaxDef = new EObjectContainmentEList<Classifier>(Classifier.class, this, DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF);
		}
		return abstractSyntaxDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextualSyntaxDef getTextualSyntaxDef() {
		return textualSyntaxDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTextualSyntaxDef(TextualSyntaxDef newTextualSyntaxDef, NotificationChain msgs) {
		TextualSyntaxDef oldTextualSyntaxDef = textualSyntaxDef;
		textualSyntaxDef = newTextualSyntaxDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, oldTextualSyntaxDef, newTextualSyntaxDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextualSyntaxDef(TextualSyntaxDef newTextualSyntaxDef) {
		if (newTextualSyntaxDef != textualSyntaxDef) {
			NotificationChain msgs = null;
			if (textualSyntaxDef != null)
				msgs = ((InternalEObject)textualSyntaxDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, null, msgs);
			if (newTextualSyntaxDef != null)
				msgs = ((InternalEObject)newTextualSyntaxDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, null, msgs);
			msgs = basicSetTextualSyntaxDef(newTextualSyntaxDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF, newTextualSyntaxDef, newTextualSyntaxDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMappingDef() {
		return mappingDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingDef(Mapping newMappingDef, NotificationChain msgs) {
		Mapping oldMappingDef = mappingDef;
		mappingDef = newMappingDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, oldMappingDef, newMappingDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingDef(Mapping newMappingDef) {
		if (newMappingDef != mappingDef) {
			NotificationChain msgs = null;
			if (mappingDef != null)
				msgs = ((InternalEObject)mappingDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, null, msgs);
			if (newMappingDef != null)
				msgs = ((InternalEObject)newMappingDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, null, msgs);
			msgs = basicSetMappingDef(newMappingDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__MAPPING_DEF, newMappingDef, newMappingDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return ((InternalEList<?>)getAbstractSyntaxDef()).basicRemove(otherEnd, msgs);
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return basicSetTextualSyntaxDef(null, msgs);
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				return basicSetMappingDef(null, msgs);
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
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return getAbstractSyntaxDef();
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return getTextualSyntaxDef();
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				return getMappingDef();
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
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				getAbstractSyntaxDef().clear();
				getAbstractSyntaxDef().addAll((Collection<? extends Classifier>)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				setTextualSyntaxDef((TextualSyntaxDef)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				setMappingDef((Mapping)newValue);
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
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				getAbstractSyntaxDef().clear();
				return;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				setTextualSyntaxDef((TextualSyntaxDef)null);
				return;
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				setMappingDef((Mapping)null);
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
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return abstractSyntaxDef != null && !abstractSyntaxDef.isEmpty();
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return textualSyntaxDef != null;
			case DblPackage.EXTENSION_DEFINITION__MAPPING_DEF:
				return mappingDef != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtensionDefinitionImpl
