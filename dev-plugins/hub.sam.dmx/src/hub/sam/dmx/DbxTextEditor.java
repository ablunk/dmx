package hub.sam.dmx;

import hub.sam.dbl.Classifier;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.IntPropertyType;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.RhsExpression;
import hub.sam.dbl.RuleExpr;
import hub.sam.dbl.SequenceExpr;
import hub.sam.dbl.StringPropertyType;
import hub.sam.dbl.TerminalExpr;
import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.editor.SourceViewerConfiguration;
import hub.sam.tef.etsl.Rhs;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.TslFactory;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

public class DbxTextEditor extends DblTextEditor implements IExtensionDefinitionApplier {

	@Override
	protected String getMetaModelPath() {
		return "/resources/dbl.ecore";
	}
	
	private Map<String, ExtensionDefinitionProcessor> extensionDefsProcessed = new HashMap<String, ExtensionDefinitionProcessor>();

	@Override
	protected void initPreProcessor() {
		_preProcessor = new DbxPreProcessor(this, getEditorInput().getName(), this);
	}
	
	private ExtensionDefinitionManager _extensionDefinitionManager;
	
	private ExtensionDefinitionManager getExtensionDefinitionManager() {
		if (_extensionDefinitionManager == null) {
			_extensionDefinitionManager = new ExtensionDefinitionManager(getSyntax(), getDblMetaModel());
		}
		return _extensionDefinitionManager;
	}

	@Override
	public void preProcessDocument() {
		super.preProcessDocument();

		// extension definitions have to be added for each import beginning at the leaves of the import tree.
		// what is needed, is a pre-processed model of the full import tree. this pre-model is used for adding extension definitions
		// from outside to inside (i.e. beginning at the leaves of the import tree back to the model itself)

		if (extensionDefinitionsAdded) {
			extensionDefinitionsAdded = false;
			fireRccSyntaxChanged();
		}
	}
	
	private boolean extensionDefinitionsAdded = false;
	
	public void syntaxChanged() {
		getExtensionDefinitionManager().syntaxChanged();
		fireRccSyntaxChanged();
	}

	public boolean addExtensionDefinitions(Model model) {		
		boolean added = getExtensionDefinitionManager().addExtensionDefinitions(model);
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).uninstall();
				((SourceViewerConfiguration) getSourceViewerConfiguration()).clearPresentationReconciler();
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).install(getSourceViewer());
			}
		});
		
		return added;
	}
	
	public void unwindExtensionDefinitionEffects(Model model) {
		getExtensionDefinitionManager().unwindExtensionDefinitionEffects(model);
	}
	
	private void addExtensionDefinition(ExtensionDefinition extensionDef) {
		System.out.println("adding extension definition '" + extensionDef.getName() + "' ...");
		
		ExtensionDefinitionProcessor processor = new ExtensionDefinitionProcessor(extensionDef, getSyntax(), getDblMetaModel());
		boolean added = processor.addToSyntax();
		if (added) {
			extensionDefsProcessed.put(extensionDef.getName(), processor);
		}
	}
	
	private void addExtensionDefOld(ExtensionDefinition extensionDef) {
		System.out.println("adding extension definition '" + extensionDef.getName() + "' ...");
		
		ExtensionDefinitionProcessor processor = new ExtensionDefinitionProcessor(extensionDef, getSyntax(), getDblMetaModel());
		extensionDefsProcessed.put(extensionDef.getName(), processor);

		// *** extend DBL TSL grammar ***
		
		NonTerminal statementExtensionNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		statementExtensionNonTerminal.setName("StatementExtension");
		
		// StatementExtension -> `new-extension`_extension;
		SimpleRule statementExtensionToNewExtensionRule = TslFactory.eINSTANCE.createSimpleRule();
		statementExtensionToNewExtensionRule.setLhs(statementExtensionNonTerminal);
		getSyntax().getRules().add(statementExtensionToNewExtensionRule);
		
		//effects.getAddedRules().add(statementExtensionToNewExtensionRule);
		
		String extensionNonTerminalName = extensionDef.getName() + "_extension";
		
		{
		NonTerminal extensionNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		extensionNonTerminal.setName(extensionNonTerminalName);
		statementExtensionToNewExtensionRule.getRhs().add(extensionNonTerminal);
		}
		
		// `new-extension`_extension:element(`new-meta-class`) -> ... ;
		SimpleRule extensionRule = TslFactory.eINSTANCE.createSimpleRule();
		getSyntax().getRules().add(extensionRule);
		//effects.getAddedRules().add(extensionRule);
		{
			NonTerminal extensionNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			extensionNonTerminal.setName(extensionNonTerminalName);
			extensionRule.setLhs(extensionNonTerminal);
		}
	
		// *** create meta classes for rules ***
		EClass firstMetaClass = EcoreFactory.eINSTANCE.createEClass();
		String className = extensionDef.getName().substring(0,1).toUpperCase() + extensionDef.getName().substring(1);
		firstMetaClass.setName(className);
		//metamodelPkg.getEClassifiers().add(firstMetaClass);
		
		//effects.getAddedMetaClasses().add(firstMetaClass);

		//RhsExpression firstRhs = extensionDef.getTextualSyntaxDef().get(0).getRhs();
		//processRhs(firstRhs, extensionRule.getRhs(), firstMetaClass);

		ElementBinding metaClassBinding = TslFactory.eINSTANCE.createElementBinding();
		metaClassBinding.setMetaclass(firstMetaClass);
		extensionRule.setValueBinding(metaClassBinding);
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).uninstall();
				((SourceViewerConfiguration) getSourceViewerConfiguration()).clearPresentationReconciler();
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).install(getSourceViewer());
			}
		});
	}
	
	private void addToRhsList(Symbol symbol, EList rhsList) {
		rhsList.add(symbol);
	}
	
	private void addToRhsList(Rhs rhs, EList rhsList) {
		rhsList.add(rhs);
	}
	
	private void processRhs(RhsExpression rhs, EList addList, EClass metaClass) {
		if (rhs instanceof SequenceExpr) {
			SequenceExpr sequence = (SequenceExpr) rhs;
			for (RhsExpression sequencePart: sequence.getSequence()) {
				if (sequencePart instanceof TerminalExpr) {
					TerminalExpr terminalExpr = (TerminalExpr) sequencePart;

					FixTerminal fixTerminal = TslFactory.eINSTANCE.createFixTerminal();
					fixTerminal.setTerminal(terminalExpr.getTerminal());
					
					addToRhsList(fixTerminal, addList);
				}
				else if (sequencePart instanceof PropertyBindingExpr) {
					PropertyBindingExpr bindingExpr = (PropertyBindingExpr) sequencePart;
					System.out.println("PropertyBindingExpr: " + bindingExpr.getName());
					
					PropertyType propertyType = bindingExpr.getPropertyType();
					if (propertyType instanceof IntPropertyType) {
						//processPrimitiveTypeBinding(bindingExpr, EcorePackage.Literals.EINT, "INTEGER", metaClass, addList);
					}
					else if (propertyType instanceof StringPropertyType) {
						//processPrimitiveTypeBinding(bindingExpr, EcorePackage.Literals.ESTRING, "STRINGDEF", metaClass, addList);
					}
					else if (propertyType instanceof ReferencePropertyType) {
						ReferencePropertyType referencePropertyType = (ReferencePropertyType) propertyType;
						processMetaClassBinding(false, bindingExpr, (Classifier) referencePropertyType.getType(), metaClass, addList);
					}
					else if (propertyType instanceof CompositePropertyType) {
						CompositePropertyType referencePropertyType = (CompositePropertyType) propertyType;
						processMetaClassBinding(true, bindingExpr, (Classifier) referencePropertyType.getType(), metaClass, addList);
					}
					else if (propertyType instanceof RuleExpr) {
						RuleExpr ruleExpr = (RuleExpr) propertyType;
						processUnboundRule(ruleExpr, addList, metaClass);
					}
				}
//				else if (sequencePart instanceof OptionalExpr) {
//					OptionalExpr optionalpart = (OptionalExpr) sequencePart;
//					Optional etslOptional = EtslFactory.eINSTANCE.createOptional();
//					RhsExpression subExpr = optionalpart.getExpression();
//					
//					if (subExpr instanceof SequenceExpr) {
//						SequenceExpr sequenceSubExpr = (SequenceExpr) subExpr;
//						RhsSequence etslSequence = EtslFactory.eINSTANCE.createRhsSequence();
//						
//						processRhs(sequenceSubExpr, etslSequence.getParts(), metaClass);
//					}
//				}
			}
		}
	}
	
	private void processUnboundRule(RuleExpr ruleExpr, EList addList, EClass metaClass) {
		SimpleRule tslRule = TslFactory.eINSTANCE.createSimpleRule();
		getSyntax().getRules().add(tslRule);
		
		NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		nonTerminal.setName(ruleExpr.getRule().getName());
		
		tslRule.setLhs(nonTerminal);
		
		processRhs(ruleExpr.getRule().getRhs(), addList, metaClass);
	}

	private void processMetaClassBinding(boolean isComposite, PropertyBindingExpr bindingExpr, Classifier propertyType, EClass extensionMetaClass, EList addList) {
		EReference property = EcoreFactory.eINSTANCE.createEReference();
		property.setContainment(isComposite);
		property.setName(bindingExpr.getName());
		
		String propertyTypeName = propertyType.getName();
		if (!isComposite) {
			propertyTypeName = "IdExpr";
			property.setContainment(true);
		}
		
		// ODEMc classifier is an interface that is only a place-holder for the real meta-class
		for (EClassifier otherMetaClass: extensionMetaClass.getEPackage().getEClassifiers()) {
			if (otherMetaClass.getName().equals(propertyTypeName)) {
				property.setEType(otherMetaClass);
			}
		}
		
		extensionMetaClass.getEStructuralFeatures().add(property);
		
		NonTerminal propertyNonTerminal;
		PropertyBinding propertyBinding;
		
		if (isComposite) {
			propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			
			propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(propertyBinding);
			propertyNonTerminal.setName(property.getEType().getName());
		}
		else {
			propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			
			propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(propertyBinding);
			propertyNonTerminal.setName(propertyTypeName);

//			propertyBinding = TslFactory.eINSTANCE.createReferenceBinding();
//
//			Syntax syntax = (Syntax) extensionRule.eContainer();
//			String refNonTerminalName = property.getEType().getName() + "Ref";
//			NonTerminal refNonTerminal = null;
//
//			for (Rule rule: syntax.getRules()) {
//				if (rule.getLhs().getName().equals(refNonTerminalName)) {
//					refNonTerminal = rule.getLhs();
//					break;
//				}
//			}
//			
//
//			if (refNonTerminal == null) {
//				SimpleRule refNonTerminalRule = TslFactory.eINSTANCE.createSimpleRule();
//				syntax.getRules().add(refNonTerminalRule);
//				
//				// `property-type`Ref -> ...
//				
//				refNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
//				refNonTerminal.setName(refNonTerminalName);
//				
//				refNonTerminalRule.setLhs(refNonTerminal);
//				
//				// ... -> IDENTIFIER:composite(name)
//				
//				NonTerminal idNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
//				idNonTerminal.setName("IDENTIFIER");
//				
//				CompositeBinding nameBinding = TslFactory.eINSTANCE.createCompositeBinding();
//				nameBinding.setProperty(DblPackage.Literals.NAMED_ELEMENT__NAME);
//				idNonTerminal.setPropertyBinding(nameBinding);
//				
//				refNonTerminalRule.getRhs().add(idNonTerminal);
//				
//				ElementBinding propertyTypeBinding = TslFactory.eINSTANCE.createElementBinding();
//				propertyTypeBinding.setMetaclass((EClass) property.getEType());
//				refNonTerminalRule.setValueBinding(propertyTypeBinding);
//			}
//
//			propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
//			propertyNonTerminal.setPropertyBinding(propertyBinding);
//			propertyNonTerminal.setName(refNonTerminalName);			
		}
		
		propertyBinding.setProperty(property);
				
		addToRhsList(propertyNonTerminal, addList);
	}
	
	private void collectAllBindingExpressions(RhsExpression rootExpr, Collection<PropertyBindingExpr> collectedBindingExpressions) {
		if (rootExpr.getSubExpressions() != null) {
			for (RhsExpression expr: rootExpr.getSubExpressions()) {
				if (expr instanceof PropertyBindingExpr) {
					PropertyBindingExpr bindingExpr = (PropertyBindingExpr) expr;
					collectedBindingExpressions.add(bindingExpr);
				}
				else {
					collectAllBindingExpressions(expr, collectedBindingExpressions);
				}
			}
		}
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
		URL url = FileLocator.find(getPluginBundle(), new Path(getMetaModelPath()), null);
		//FileLocator.toFileURL(url)
//		try {
//			System.out.println(FileLocator.toFileURL(url).toString());
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//ResourceSet resourceSet = new ResourceSetImpl();
        //Resource resource = resourceSet.getResource(url.toURI(), true);
		return new DbxModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}
	
	
	private Syntax syntax;
	
	@Override
	public Syntax getSyntax() {
		if (syntax == null) {
			try {
				syntax = createSyntax();
			}
			catch (TslException e) {
				throw new RuntimeException(e);
			}
		}
		//System.out.println("getSyntax()");
		return syntax;
	}

	@Override
	protected Syntax createSyntax() throws TslException {
		Bundle bundle = getPluginBundle();
		if (bundle == null) {
			bundle = TEFPlugin.getDefault().getBundle();
		}
		
		return Utilities.loadSyntaxDescription(bundle, getSyntaxPath(), getMetaModelPackages());
	
		/*InputDialog dialog = new InputDialog(getEditorSite().getShell(), "Syntax File", "Enter syntax file name:", "/resources/dbl-ext.etslt", null);
		if (dialog.open() == IDialogConstants.OK_ID) {
			String syntaxFile = dialog.getValue();
			return Utilities.loadSyntaxDescription(bundle, syntaxFile, getMetaModelPackages());
		}
		else {
			throw new TslException("no textual syntax file specified.");
		}*/
	}

}
