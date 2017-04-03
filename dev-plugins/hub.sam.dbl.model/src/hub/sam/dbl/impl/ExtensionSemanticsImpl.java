/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionSemantics;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.Statement;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.ExtensionSemanticsImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.ExtensionSemanticsImpl#getSyntaxDefinition <em>Syntax Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtensionSemanticsImpl extends ExtensibleElementImpl implements ExtensionSemantics {
	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The cached value of the '{@link #getSyntaxDefinition() <em>Syntax Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntaxDefinition()
	 * @generated
	 * @ordered
	 */
	protected Extension syntaxDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.EXTENSION_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<Statement>(Statement.class, this, DblPackage.EXTENSION_SEMANTICS__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension getSyntaxDefinition() {
		if (syntaxDefinition != null && ((EObject)syntaxDefinition).eIsProxy()) {
			InternalEObject oldSyntaxDefinition = (InternalEObject)syntaxDefinition;
			syntaxDefinition = (Extension)eResolveProxy(oldSyntaxDefinition);
			if (syntaxDefinition != oldSyntaxDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.EXTENSION_SEMANTICS__SYNTAX_DEFINITION, oldSyntaxDefinition, syntaxDefinition));
			}
		}
		return syntaxDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension basicGetSyntaxDefinition() {
		return syntaxDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyntaxDefinition(Extension newSyntaxDefinition) {
		Extension oldSyntaxDefinition = syntaxDefinition;
		syntaxDefinition = newSyntaxDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.EXTENSION_SEMANTICS__SYNTAX_DEFINITION, oldSyntaxDefinition, syntaxDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.EXTENSION_SEMANTICS__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
			case DblPackage.EXTENSION_SEMANTICS__STATEMENTS:
				return getStatements();
			case DblPackage.EXTENSION_SEMANTICS__SYNTAX_DEFINITION:
				if (resolve) return getSyntaxDefinition();
				return basicGetSyntaxDefinition();
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
			case DblPackage.EXTENSION_SEMANTICS__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case DblPackage.EXTENSION_SEMANTICS__SYNTAX_DEFINITION:
				setSyntaxDefinition((Extension)newValue);
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
			case DblPackage.EXTENSION_SEMANTICS__STATEMENTS:
				getStatements().clear();
				return;
			case DblPackage.EXTENSION_SEMANTICS__SYNTAX_DEFINITION:
				setSyntaxDefinition((Extension)null);
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
			case DblPackage.EXTENSION_SEMANTICS__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case DblPackage.EXTENSION_SEMANTICS__SYNTAX_DEFINITION:
				return syntaxDefinition != null;
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
		if (baseClass == LocalScope.class) {
			switch (derivedFeatureID) {
				case DblPackage.EXTENSION_SEMANTICS__STATEMENTS: return DblPackage.LOCAL_SCOPE__STATEMENTS;
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
		if (baseClass == LocalScope.class) {
			switch (baseFeatureID) {
				case DblPackage.LOCAL_SCOPE__STATEMENTS: return DblPackage.EXTENSION_SEMANTICS__STATEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ExtensionSemanticsImpl
