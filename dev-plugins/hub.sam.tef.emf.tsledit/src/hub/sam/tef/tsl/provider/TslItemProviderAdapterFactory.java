/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.tef.tsl.provider;

import hub.sam.tef.tsl.util.TslAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TslItemProviderAdapterFactory extends TslAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TslItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.Syntax} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SyntaxItemProvider syntaxItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.Syntax}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSyntaxAdapter() {
		if (syntaxItemProvider == null) {
			syntaxItemProvider = new SyntaxItemProvider(this);
		}

		return syntaxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.SimpleRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleRuleItemProvider simpleRuleItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.SimpleRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSimpleRuleAdapter() {
		if (simpleRuleItemProvider == null) {
			simpleRuleItemProvider = new SimpleRuleItemProvider(this);
		}

		return simpleRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.NonTerminal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonTerminalItemProvider nonTerminalItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.NonTerminal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNonTerminalAdapter() {
		if (nonTerminalItemProvider == null) {
			nonTerminalItemProvider = new NonTerminalItemProvider(this);
		}

		return nonTerminalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.FixTerminal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixTerminalItemProvider fixTerminalItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.FixTerminal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFixTerminalAdapter() {
		if (fixTerminalItemProvider == null) {
			fixTerminalItemProvider = new FixTerminalItemProvider(this);
		}

		return fixTerminalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.PatternTerminal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternTerminalItemProvider patternTerminalItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.PatternTerminal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternTerminalAdapter() {
		if (patternTerminalItemProvider == null) {
			patternTerminalItemProvider = new PatternTerminalItemProvider(this);
		}

		return patternTerminalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.WhiteSpace} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhiteSpaceItemProvider whiteSpaceItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.WhiteSpace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWhiteSpaceAdapter() {
		if (whiteSpaceItemProvider == null) {
			whiteSpaceItemProvider = new WhiteSpaceItemProvider(this);
		}

		return whiteSpaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.Pattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternItemProvider patternItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.Pattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternAdapter() {
		if (patternItemProvider == null) {
			patternItemProvider = new PatternItemProvider(this);
		}

		return patternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.Binding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingItemProvider bindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.Binding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBindingAdapter() {
		if (bindingItemProvider == null) {
			bindingItemProvider = new BindingItemProvider(this);
		}

		return bindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.ElementBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementBindingItemProvider elementBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.ElementBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createElementBindingAdapter() {
		if (elementBindingItemProvider == null) {
			elementBindingItemProvider = new ElementBindingItemProvider(this);
		}

		return elementBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.ElementReferenceBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementReferenceBindingItemProvider elementReferenceBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.ElementReferenceBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createElementReferenceBindingAdapter() {
		if (elementReferenceBindingItemProvider == null) {
			elementReferenceBindingItemProvider = new ElementReferenceBindingItemProvider(this);
		}

		return elementReferenceBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.PrimitiveBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveBindingItemProvider primitiveBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.PrimitiveBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPrimitiveBindingAdapter() {
		if (primitiveBindingItemProvider == null) {
			primitiveBindingItemProvider = new PrimitiveBindingItemProvider(this);
		}

		return primitiveBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.CompositeBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBindingItemProvider compositeBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.CompositeBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeBindingAdapter() {
		if (compositeBindingItemProvider == null) {
			compositeBindingItemProvider = new CompositeBindingItemProvider(this);
		}

		return compositeBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.ReferenceBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceBindingItemProvider referenceBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.ReferenceBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReferenceBindingAdapter() {
		if (referenceBindingItemProvider == null) {
			referenceBindingItemProvider = new ReferenceBindingItemProvider(this);
		}

		return referenceBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.ActionBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionBindingItemProvider actionBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.ActionBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActionBindingAdapter() {
		if (actionBindingItemProvider == null) {
			actionBindingItemProvider = new ActionBindingItemProvider(this);
		}

		return actionBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.Statement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatementItemProvider statementItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStatementAdapter() {
		if (statementItemProvider == null) {
			statementItemProvider = new StatementItemProvider(this);
		}

		return statementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link hub.sam.tef.tsl.ConstantBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantBindingItemProvider constantBindingItemProvider;

	/**
	 * This creates an adapter for a {@link hub.sam.tef.tsl.ConstantBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstantBindingAdapter() {
		if (constantBindingItemProvider == null) {
			constantBindingItemProvider = new ConstantBindingItemProvider(this);
		}

		return constantBindingItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (syntaxItemProvider != null) syntaxItemProvider.dispose();
		if (simpleRuleItemProvider != null) simpleRuleItemProvider.dispose();
		if (nonTerminalItemProvider != null) nonTerminalItemProvider.dispose();
		if (fixTerminalItemProvider != null) fixTerminalItemProvider.dispose();
		if (patternTerminalItemProvider != null) patternTerminalItemProvider.dispose();
		if (whiteSpaceItemProvider != null) whiteSpaceItemProvider.dispose();
		if (patternItemProvider != null) patternItemProvider.dispose();
		if (bindingItemProvider != null) bindingItemProvider.dispose();
		if (elementBindingItemProvider != null) elementBindingItemProvider.dispose();
		if (elementReferenceBindingItemProvider != null) elementReferenceBindingItemProvider.dispose();
		if (primitiveBindingItemProvider != null) primitiveBindingItemProvider.dispose();
		if (constantBindingItemProvider != null) constantBindingItemProvider.dispose();
		if (compositeBindingItemProvider != null) compositeBindingItemProvider.dispose();
		if (referenceBindingItemProvider != null) referenceBindingItemProvider.dispose();
		if (actionBindingItemProvider != null) actionBindingItemProvider.dispose();
		if (statementItemProvider != null) statementItemProvider.dispose();
	}

}