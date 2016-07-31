package hub.sam.tef.modelcreating;

import java.util.HashMap;
import java.util.Map;

import hub.sam.tef.PluginFileLocator;
import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.semantics.DefaultSemanticsProvider;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IIdentificationScheme;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.text.Position;
import org.osgi.framework.Bundle;


public abstract class HeadlessEclipseParser {
	
	private final ComposedAdapterFactory fAdapterFactory;
	private final EPackage[] fMetaModelPackages;
	private final ISemanticsProvider fSemanitcsProvider;
	private Syntax fSyntax = null;
	private final IIdentificationScheme fIdentificationScheme;
	
	private PluginFileLocator pluginFileLocator;
	
	protected final IPath inputPath;
	protected final String filename;

	protected ResourceSet resourceSet = new ResourceSetImpl();
	
	private IModelCreatingContext lastModelCreationContext;
	private String currentText;
	
	public HeadlessEclipseParser(IPath inputPath) {
		this(inputPath, "<no-input-file>");	
	}
	
	public HeadlessEclipseParser(IPath inputPath, String filename) {
		this.inputPath = inputPath;
		this.filename = filename;
		fIdentificationScheme = createIdentificationScheme();
		fSemanitcsProvider = createSemanticsProvider();
		fMetaModelPackages = createMetaModelPackages();
		fAdapterFactory = createComposedAdapterFactory();
		pluginFileLocator = createPluginFileLocator();
	}
	
	protected abstract void preProcess(String inputText, IPath inputLocation);

	public IModelCreatingContext parse(String inputText) throws ModelCreatingException {
		System.out.println("pre-processing " + filename + " ...");
		preProcess(inputText, inputPath);
		
		currentText = inputText;
		IModelCreatingContext context = createModelCreatingContext();
		
		final ParserSemantics parserSemantics = new ParserSemantics(getSyntax());
		parserSemantics.DEBUG = true;
		Parser parser = new Parser(getSyntax());
		final boolean parseOk = parser.parse(inputText, parserSemantics);
		
		if (!parseOk) {
			final int lastOffset = parser.getLastOffset();
			if (lastOffset == -1) {
				context.addError(new Error(new Position(0, inputText.length()),
						"Parser error (position unknown)"));
			}
			else {
				final Token lastToken = parser.getLastToken();
				if (lastToken != null) {
					context.addError(new ParserError(lastToken));
				}
				else {
					context.addError(new ParserError(lastOffset));
				}
			}
		}
		else {
			final ParseTreeNode parseResult = parserSemantics.getResult();
			// parseResult.looseParents();
			EObject creationResult = null;

			creationResult = (EObject) parseResult.createModel(context, null);
			context.addCreatedObject(creationResult);

			parseResult.postCreate(context);

			final ResolutionState state = new ResolutionState(creationResult);
			parseResult.resolveModel(context, state);
			context.executeResolutions();

			parseResult.postResolve(context);

			new ModelChecker().checkModel(creationResult, context);
			parseResult.looseParents();
		}

		lastModelCreationContext = context;
		return lastModelCreationContext;
	}
	
	public IModelCreatingContext getLastModelCreationContext() {
		return lastModelCreationContext;
	}
	
	public String getCurrentText() {
		return currentText;
	}
	
	public Syntax getSyntax() {
		if (fSyntax == null) {
			try {
				fSyntax = createSyntax();
			} catch (TslException e) {
				throw new RuntimeException(e);
			}
		}
		return fSyntax;
	}
	
	private static Map<String, Syntax> originalSyntaxDescriptions = new HashMap<String, Syntax>();
	
	/**
	 * @return the newly created/loaded syntax for this editor.
	 */
	protected Syntax createSyntax() throws TslException {
		if (!originalSyntaxDescriptions.containsKey(getSyntaxPath())) {
			System.out.println("loading syntax from " + getSyntaxPath());
			Syntax syntax = Utilities.loadSyntaxDescription(pluginFileLocator, getSyntaxPath(), getMetaModelPackages());
			originalSyntaxDescriptions.put(getSyntaxPath(), syntax);
			return syntax;
		}
		else {
			System.out.println("copying syntax previously loaded from " + getSyntaxPath());
			Syntax syntaxCopy = EcoreUtil.copy(originalSyntaxDescriptions.get(getSyntaxPath()));
			return syntaxCopy;
		}
	}
	
	protected abstract Bundle getPluginBundle();
	
	protected abstract String getSyntaxPath();
	
	protected abstract IModelCreatingContext createModelCreatingContext();
	
	protected abstract EPackage[] createMetaModelPackages();
	
	public final EPackage[] getMetaModelPackages() {
		return fMetaModelPackages;
	}
	
	private ComposedAdapterFactory getComposedAdaptorFactory() {
		return fAdapterFactory;
	}
	
	private PluginFileLocator createPluginFileLocator() {
		Bundle bundle = getPluginBundle();
		if (bundle == null && TEFPlugin.getDefault() != null) {
			bundle = TEFPlugin.getDefault().getBundle();
		}
		return new PluginFileLocator(bundle);

	}
	
	private ComposedAdapterFactory createComposedAdapterFactory() {
		ComposedAdapterFactory result = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		result.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		for (AdapterFactory adapterFactory: createItemProviderAdapterFactories()) {
			result.addAdapterFactory(adapterFactory);
		}			
		result.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		return result;
	}
	
	protected abstract AdapterFactory[] createItemProviderAdapterFactories();
	
	public final ISemanticsProvider getSemanticsProvider() {
		return fSemanitcsProvider;
	}
	
	protected ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanticsProvider(getIdentificationScheme());
	}
	
	private IIdentificationScheme getIdentificationScheme() {
		return fIdentificationScheme;
	}

	protected IIdentificationScheme createIdentificationScheme() {
		return DefaultIdentificationScheme.INSTANCE;
	}
	
	public void setPluginFileLocator(PluginFileLocator pluginFileLocator) {
		this.pluginFileLocator = pluginFileLocator;
	}
	
}
