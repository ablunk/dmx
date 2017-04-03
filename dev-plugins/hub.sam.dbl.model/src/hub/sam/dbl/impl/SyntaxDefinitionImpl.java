/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.MetaSymbol;
import hub.sam.dbl.SyntaxDefinition;

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
 * An implementation of the model object '<em><b>Syntax Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.impl.SyntaxDefinitionImpl#getStartSymbol <em>Start Symbol</em>}</li>
 *   <li>{@link hub.sam.dbl.impl.SyntaxDefinitionImpl#getSymbols <em>Symbols</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SyntaxDefinitionImpl extends ExtensibleElementImpl implements SyntaxDefinition {
	/**
	 * The cached value of the '{@link #getStartSymbol() <em>Start Symbol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartSymbol()
	 * @generated
	 * @ordered
	 */
	protected MetaSymbol startSymbol;

	/**
	 * The cached value of the '{@link #getSymbols() <em>Symbols</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbols()
	 * @generated
	 * @ordered
	 */
	protected EList<MetaSymbol> symbols;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SyntaxDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DblPackage.Literals.SYNTAX_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaSymbol getStartSymbol() {
		if (startSymbol != null && ((EObject)startSymbol).eIsProxy()) {
			InternalEObject oldStartSymbol = (InternalEObject)startSymbol;
			startSymbol = (MetaSymbol)eResolveProxy(oldStartSymbol);
			if (startSymbol != oldStartSymbol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DblPackage.SYNTAX_DEFINITION__START_SYMBOL, oldStartSymbol, startSymbol));
			}
		}
		return startSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaSymbol basicGetStartSymbol() {
		return startSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartSymbol(MetaSymbol newStartSymbol) {
		MetaSymbol oldStartSymbol = startSymbol;
		startSymbol = newStartSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DblPackage.SYNTAX_DEFINITION__START_SYMBOL, oldStartSymbol, startSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetaSymbol> getSymbols() {
		if (symbols == null) {
			symbols = new EObjectContainmentEList<MetaSymbol>(MetaSymbol.class, this, DblPackage.SYNTAX_DEFINITION__SYMBOLS);
		}
		return symbols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DblPackage.SYNTAX_DEFINITION__SYMBOLS:
				return ((InternalEList<?>)getSymbols()).basicRemove(otherEnd, msgs);
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
			case DblPackage.SYNTAX_DEFINITION__START_SYMBOL:
				if (resolve) return getStartSymbol();
				return basicGetStartSymbol();
			case DblPackage.SYNTAX_DEFINITION__SYMBOLS:
				return getSymbols();
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
			case DblPackage.SYNTAX_DEFINITION__START_SYMBOL:
				setStartSymbol((MetaSymbol)newValue);
				return;
			case DblPackage.SYNTAX_DEFINITION__SYMBOLS:
				getSymbols().clear();
				getSymbols().addAll((Collection<? extends MetaSymbol>)newValue);
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
			case DblPackage.SYNTAX_DEFINITION__START_SYMBOL:
				setStartSymbol((MetaSymbol)null);
				return;
			case DblPackage.SYNTAX_DEFINITION__SYMBOLS:
				getSymbols().clear();
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
			case DblPackage.SYNTAX_DEFINITION__START_SYMBOL:
				return startSymbol != null;
			case DblPackage.SYNTAX_DEFINITION__SYMBOLS:
				return symbols != null && !symbols.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SyntaxDefinitionImpl
