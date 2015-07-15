/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.LanguageConceptClassifier;
import hub.sam.dbl.TextualSyntaxDef;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getExtendedConcept <em>Extended Concept</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getAbstractSyntaxDef <em>Abstract Syntax Def</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionDefinitionImpl#getTextualSyntaxDef <em>Textual Syntax Def</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionDefinitionImpl extends LanguageConceptClassifierImpl implements ExtensionDefinition {
	/**
	 * The cached value of the '{@link #getExtendedConcept() <em>Extended Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedConcept()
	 * @generated
	 * @ordered
	 */
	protected LanguageConceptClassifier extendedConcept;

	/**
	 * The cached value of the '{@link #getAbstractSyntaxDef() <em>Abstract Syntax Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSyntaxDef()
	 * @generated
	 * @ordered
	 */
	protected hub.sam.dbl.Class abstractSyntaxDef;

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
	public LanguageConceptClassifier getExtendedConcept() {
		if (extendedConcept != null && extendedConcept.eIsProxy()) {
			InternalEObject oldExtendedConcept = (InternalEObject)extendedConcept;
			extendedConcept = (LanguageConceptClassifier)eResolveProxy(oldExtendedConcept);
			if (extendedConcept != oldExtendedConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT, oldExtendedConcept, extendedConcept));
			}
		}
		return extendedConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageConceptClassifier basicGetExtendedConcept() {
		return extendedConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedConcept(LanguageConceptClassifier newExtendedConcept) {
		LanguageConceptClassifier oldExtendedConcept = extendedConcept;
		extendedConcept = newExtendedConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT, oldExtendedConcept, extendedConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public hub.sam.dbl.Class getAbstractSyntaxDef() {
		return abstractSyntaxDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbstractSyntaxDef(hub.sam.dbl.Class newAbstractSyntaxDef, NotificationChain msgs) {
		hub.sam.dbl.Class oldAbstractSyntaxDef = abstractSyntaxDef;
		abstractSyntaxDef = newAbstractSyntaxDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF, oldAbstractSyntaxDef, newAbstractSyntaxDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractSyntaxDef(hub.sam.dbl.Class newAbstractSyntaxDef) {
		if (newAbstractSyntaxDef != abstractSyntaxDef) {
			NotificationChain msgs = null;
			if (abstractSyntaxDef != null)
				msgs = ((InternalEObject)abstractSyntaxDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF, null, msgs);
			if (newAbstractSyntaxDef != null)
				msgs = ((InternalEObject)newAbstractSyntaxDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF, null, msgs);
			msgs = basicSetAbstractSyntaxDef(newAbstractSyntaxDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF, newAbstractSyntaxDef, newAbstractSyntaxDef));
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return basicSetAbstractSyntaxDef(null, msgs);
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return basicSetTextualSyntaxDef(null, msgs);
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
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				if (resolve) return getExtendedConcept();
				return basicGetExtendedConcept();
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return getAbstractSyntaxDef();
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return getTextualSyntaxDef();
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
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				setExtendedConcept((LanguageConceptClassifier)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				setAbstractSyntaxDef((hub.sam.dbl.Class)newValue);
				return;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				setTextualSyntaxDef((TextualSyntaxDef)newValue);
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
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				setExtendedConcept((LanguageConceptClassifier)null);
				return;
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				setAbstractSyntaxDef((hub.sam.dbl.Class)null);
				return;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				setTextualSyntaxDef((TextualSyntaxDef)null);
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
			case DblPackage.EXTENSION_DEFINITION__EXTENDED_CONCEPT:
				return extendedConcept != null;
			case DblPackage.EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF:
				return abstractSyntaxDef != null;
			case DblPackage.EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF:
				return textualSyntaxDef != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtensionDefinitionImpl
