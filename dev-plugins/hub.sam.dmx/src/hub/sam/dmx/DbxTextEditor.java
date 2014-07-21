package hub.sam.dmx;

import hub.sam.dbl.BooleanPropertyType;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.ExtensionRule;
import hub.sam.dbl.IdPropertyType;
import hub.sam.dbl.IntPropertyType;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferableRhsType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.RhsExpression;
import hub.sam.dbl.RuleExpr;
import hub.sam.dbl.SequenceExpr;
import hub.sam.dbl.StringPropertyType;
import hub.sam.dbl.TerminalExpr;
import hub.sam.dbl.TsRule;
import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.editor.SourceViewerConfiguration;
import hub.sam.tef.etsl.Rhs;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.TslFactory;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

public class DbxTextEditor extends DblTextEditor {

	@Override
	protected String getMetaModelPath() {
		return "/resources/dbl.ecore";
	}
	
	private Map<String, ExtensionDefinitionProcessor> extensionDefsProcessed = new HashMap<String, ExtensionDefinitionProcessor>();

//	private IResourceChangeListener workspaceResourceChangeListener;
//	private IResourceDeltaVisitor resourceDeltaVisitor;
	
	@Override
	protected void initPreProcessor() {
		_preProcessor = new DbxPreProcessor(this);
	}

	@Override
	public void preProcessDocument() {
		super.preProcessDocument();

		// TODO extension definitions have to be added for each import beginning at the leaves of the import tree.
		// what is needed, is a pre-processed model of the full import tree. this pre-model is used for adding extension definitions
		// from outside to inside (i.e. beginning at the leaves of the import tree back to the model itself)
		
//		boolean additions = updateExtensionDefs();
		
//		for (IModelContainer modelContainer: getImportedModels()) {
//			final Resource importedResource = modelContainer.getResource();
//			// TODO start at leaves of import tree and move to the root
//			if (importedResource.getContents().size() > 0) {
//				additions |= updateExtensionDefs((Model) importedResource.getContents().get(0));
//			}
//		}

		if (extensionDefinitionsAdded) {
			extensionDefinitionsAdded = false;
			fireRccSyntaxChanged();
		}
		
//		// TODO change code below so that extension definition updates occur when the pre-processor is notified of a change
		
//		if (workspaceResourceChangeListener == null) {
//			resourceDeltaVisitor = new IResourceDeltaVisitor() {
//				@Override
//				public boolean visit(IResourceDelta delta) throws CoreException {
//					IPath path = delta.getFullPath();
//					String fileName = path.removeFileExtension().lastSegment();
//					
//					if (path != null && path.getFileExtension() != null && path.getFileExtension().equals("xmi")) {
//						//Resource importedResourceWithChanges = preProcessor.getImportedModel(fileName).getResource();
//						IModelContainer importWithChanges = getPreProcessor().getImportedModel(fileName);
//
//						if (importWithChanges != null) {
//							unwindExtensionDefinitionEffects(importWithChanges.getModel());
//							
//							// INFO:
//							// xmi resources do not need to be reloaded because active editors (which potentially change) are referenced directly.
//							// however, if an xmi file changes externally (outside eclipse), this change is not known anymore.
//							
////							importedResourceWithChanges.unload();
////							//synchronized (this) {
////							getImportedResources().remove(importedResourceWithChanges);
////							//}
////							preProcessor.loseImportedResource(fileName);
//							
//							fireRccSyntaxChanged();
//						}
//					}
//					return true;
//				}
//			};
//			
//			workspaceResourceChangeListener = new IResourceChangeListener() {
//				@Override
//				public void resourceChanged(IResourceChangeEvent event) {
//					try {
//						event.getDelta().accept(resourceDeltaVisitor);
//					}
//					catch (CoreException e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceResourceChangeListener, IResourceChangeEvent.POST_CHANGE);
//		}
	}
	
	private boolean extensionDefinitionsAdded = false;

	void addExtensionDefinitions(Model model) {		
		for (Module module: model.getModules()) {
			for (ExtensionDefinition extensionDef: module.getExtensionDefs()) {
				if (!extensionDefsProcessed.containsKey(extensionDef.getName())) {
					addExtensionDefinition(extensionDef);
					extensionDefinitionsAdded = true;
				}
			}
		}
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).uninstall();
				((SourceViewerConfiguration) getSourceViewerConfiguration()).clearPresentationReconciler();
				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).install(getSourceViewer());
			}
		});
	}

//	private boolean updateExtensionDefs(Model model) {
//		boolean additions = false;
//		for (Module module: model.getModules()) {
//			for (ExtensionDefinition extensionDef: module.getExtensionDefs()) {
//				if (!extensionDefsProcessed.containsKey(extensionDef.getName())) {
//					addExtensionDef(extensionDef);
//					additions = true;
//				}
//			}
//		}
//		
//		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
//			public void run() {
//				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).uninstall();
//				((SourceViewerConfiguration) getSourceViewerConfiguration()).clearPresentationReconciler();
//				getSourceViewerConfiguration().getPresentationReconciler(getSourceViewer()).install(getSourceViewer());
//			}
//		});
//		
//		return additions;
//	}
	
	void unwindExtensionDefinitionEffects(Model model) {
		for (Module module: model.getModules()) {
			for (ExtensionDefinition extensionDef: module.getExtensionDefs()) {
				if (extensionDefsProcessed.containsKey(extensionDef.getName())) {
					System.out.println("unwinding extension definition '" + extensionDef.getName() + "' ...");
					extensionDefsProcessed.get(extensionDef.getName()).revert();
					extensionDefsProcessed.remove(extensionDef.getName());
				}
			}
		}
	}
	
	private class ExtensionDefinitionProcessor {
		
		private final Collection<Rule> addedRules = new HashSet<Rule>();
		private final Collection<EClass> addedMetaClasses = new HashSet<EClass>();
		
		private final ExtensionDefinition extensionDefinition;
		
		public ExtensionDefinitionProcessor(ExtensionDefinition extensionDefinition) {
			this.extensionDefinition = extensionDefinition;
		}
		
		// StatementExtension -> Foo ;
		// Foo -> "foo" ";" ;
		public boolean addToSyntax() {

			// the first rule must refer to an existent rule in the syntax.
			// the right side must consist of one new rule.
			// `existent-rule` -> `new-rule`;
			processExtensionRule(extensionDefinition.getTextualSyntaxDef().getExtensionRule());
			
			Stack<TsRule> ruleStack = new Stack<TsRule>();
			
			// other rules ...
			processAllRulesWithSameName(extensionDefinition.getTextualSyntaxDef().getNewRules().get(0), null, ruleStack);
			
			// process duplicated rules ...
			do {
				Map<String, DuplicatedRules> processingDuplicatedRules = new HashMap<String, DbxTextEditor.ExtensionDefinitionProcessor.DuplicatedRules>(duplicatedRules);
				duplicatedRules.clear();
				for (String ruleName: processingDuplicatedRules.keySet()) {
					extensionDefinition.getTextualSyntaxDef().getNewRules().addAll(processingDuplicatedRules.get(ruleName).rules);
					processAllRulesWithSameName(ruleName, processingDuplicatedRules.get(ruleName).metaClass, ruleStack);
				}
			} while (duplicatedRules.size() > 0);
			
			//printCurrentSyntax();

			return true;
		}
		
		private void printCurrentSyntax() {
			for (Rule rule: syntax.getRules()) {
				System.out.println(rule);
			}
		}
		
		private void processExtensionRule(ExtensionRule extensionRule) {
			NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			nonTerminal.setName(extensionRule.getName());
			
			SimpleRule tslRule = TslFactory.eINSTANCE.createSimpleRule();
			tslRule.setLhs(nonTerminal);
			
			getSyntax().getRules().add(tslRule);
			addedRules.add(tslRule);

			TsRule firstNewRule = extensionRule.getFirstNewRule().getRule();
			tslRule.getRhs().add(createNonTerminal(firstNewRule));
		}
		
		private String getTslRuleName(TsRule rule) {
			return rule.getName() + "_extension";
		}
		
		private String getTslRuleName(String ruleName) {
			return ruleName + "_extension";
		}
		
		private void processAllRulesWithSameName(TsRule newRule, EClass metaClass, Stack<TsRule> ruleStack) {
			processAllRulesWithSameName(newRule.getName(), metaClass, ruleStack);
		}
		
		private Collection<TsRule> completelyProcessedRules = new HashSet<TsRule>();
		
		private void processAllRulesWithSameName(String ruleName, EClass metaClass, Stack<TsRule> ruleStack) {
			for (TsRule otherRule: extensionDefinition.getTextualSyntaxDef().getNewRules()) {
				if (otherRule.getName().equals(ruleName) && !completelyProcessedRules.contains(otherRule)) {
					processSingleRule(otherRule, metaClass, ruleStack);
					completelyProcessedRules.add(otherRule);
				}
			}
		}

		private Collection<TsRule> processedRules = new HashSet<TsRule>();
		
		private Map<String, DuplicatedRules> duplicatedRules = new HashMap<String, DuplicatedRules>();
		
		private class DuplicatedRules {
			public Collection<TsRule> rules = new HashSet<TsRule>();
			public EClass metaClass;
		}
			
		private void processSingleRule(TsRule newRule, EClass metaClass, Stack<TsRule> ruleStack) {			
			if (!ruleStack.contains(newRule)) {
				processedRules.add(newRule);
				
				ruleStack.push(newRule);
				System.out.println("processing rule " + newRule.getName());
				
				SimpleRule tslRule = createTslRule(newRule);
				
				if (metaClass == null) {
					metaClass = getMetaClass(newRule.getName());
	
					ElementBinding metaClassBinding = TslFactory.eINSTANCE.createElementBinding();
					metaClassBinding.setMetaclass(metaClass);
					tslRule.setValueBinding(metaClassBinding);
				}
				
				RhsExpression rhs = newRule.getRhs();
				
				if (rhs instanceof SequenceExpr) {
					SequenceExpr sequence = (SequenceExpr) rhs;
					
					sequencePartsLoop: for (RhsExpression sequencePart: sequence.getSequence()) {
						if (sequencePart instanceof TerminalExpr) {
							TerminalExpr terminalExpr = (TerminalExpr) sequencePart;
	
							FixTerminal fixTerminal = TslFactory.eINSTANCE.createFixTerminal();
							fixTerminal.setTerminal(terminalExpr.getTerminal());
							
							tslRule.getRhs().add(fixTerminal);
						}
						else if (sequencePart instanceof PropertyBindingExpr) {
							PropertyBindingExpr bindingExpr = (PropertyBindingExpr) sequencePart;
							PropertyType propertyType = bindingExpr.getPropertyType();
							
							if (propertyType instanceof IntPropertyType) {
								NonTerminal nonTerminal = createNonTerminalForPrimitivePropertyBinding(
										bindingExpr, EcorePackage.Literals.EINT, "INTEGER", metaClass);
								tslRule.getRhs().add(nonTerminal);
							}
							else if (propertyType instanceof StringPropertyType) {
								NonTerminal nonTerminal = createNonTerminalForPrimitivePropertyBinding(
										bindingExpr, EcorePackage.Literals.ESTRING, "STRINGDEF", metaClass);
								tslRule.getRhs().add(nonTerminal);
							}
							else if (propertyType instanceof IdPropertyType) {
								NonTerminal nonTerminal = createNonTerminalForIdentifierBinding(bindingExpr, metaClass);
								tslRule.getRhs().add(nonTerminal);
							}
							else if (propertyType instanceof BooleanPropertyType) {
								// TODO
								//NonTerminal nonTerminal = createNonTerminalForBooleanPropertyBinding(bindingExpr, (BooleanPropertyType) propertyType, metaClass);
								//tslRule.getRhs().add(nonTerminal);
							}
							else if (propertyType instanceof ReferencePropertyType) {
								ReferencePropertyType referencePropertyType = (ReferencePropertyType) propertyType;
								if (referencePropertyType.isRawReference()) {
									NonTerminal nonTerminal = createNonTerminalForRawReferencePropertyBinding(bindingExpr,
											referencePropertyType.getType(), metaClass);
									tslRule.getRhs().add(nonTerminal);
								}
								else {
									NonTerminal nonTerminal = createNonTerminalForPropertyBinding(
											bindingExpr, referencePropertyType.getType(), metaClass);
									tslRule.getRhs().add(nonTerminal);
								}
							}
							else if (propertyType instanceof CompositePropertyType) {
								CompositePropertyType referencePropertyType = (CompositePropertyType) propertyType;
								NonTerminal nonTerminal = createNonTerminalForPropertyBinding(
										bindingExpr, referencePropertyType.getType(), metaClass);
								tslRule.getRhs().add(nonTerminal);
								if (referencePropertyType.getType() instanceof TsRule) {
									processAllRulesWithSameName((TsRule) referencePropertyType.getType(), null, ruleStack);
								}
							}
						}
						else if (sequencePart instanceof RuleExpr) {
							RuleExpr ruleExpr = (RuleExpr) sequencePart;
							TsRule rule = ruleExpr.getRule();
							String ruleName = rule.getName();
							
							if (sequence.getSequence().size() > 1) {
								String dupRuleName = metaClass.getName() + "_" + ruleName;
								if (processedRules.contains(rule) && !ruleStack.contains(rule)) {
									/* in case we have a situation like this:
									 * 		Baz -> RBaz;
									 *		Baz -> IBaz;
									 *		IBaz -> "ibaz" name:ID OptionalToBaz;
									 *		RBaz -> "rbaz" name:ID OptionalToBaz;
									 *		OptionalToBaz -> ;
									 *		OptionalToBaz -> "to" otherBaz:$$Baz OptionalToBaz;
									 * 
									 * here the rule OptionalToBaz is duplicated when it is reached for the second time.
									 * this is needed because the part otherBaz in the rule OptionalToBaz is directly bound
									 * to the concrete structural feature otherBaz of the meta-class that was active when
									 * the rule was processed. this means that if the rule OptionalToBaz is not duplicated,
									 * then otherBaz is bound to the structural feature otherBaz in meta-class RBaz. this
									 * will be a problem when an IBaz is recognized because the reference to a Baz will tried
									 * to be saved in the structural featuer RBaz.otherBaz which does not exist for IBaz.
									 * 
									 * therefore, if a RuleExpr is reached, that has already been processed and is not currently
									 * on the rule stack, then this rule is duplicated for the currently active rule.
									 */

									// duplicate all referenced rule
									boolean alreadyDuplicated = false;
									for (TsRule pRule: processedRules) {
										if (pRule.getName().equals(dupRuleName)) {
											alreadyDuplicated = true;
											tslRule.getRhs().add(createNonTerminal(pRule));
											continue sequencePartsLoop;
										}
									}
									
									if (!alreadyDuplicated) {
										DuplicatedRules duplicatedRules = new DuplicatedRules();
										duplicatedRules.metaClass = metaClass;
										TsRule dupOfOtherRule = null;
										for (TsRule otherRule: extensionDefinition.getTextualSyntaxDef().getNewRules()) {
											if (otherRule.getName().equals(ruleName)) {
												dupOfOtherRule = EcoreUtil.copy(otherRule);
												dupOfOtherRule.setName(metaClass.getName() + "_" + ruleName);
												duplicatedRules.rules.add(dupOfOtherRule);
												processedRules.add(dupOfOtherRule);
												System.out.println("created duplicate rule: " + dupOfOtherRule.getName());
											}
										}
										// does not matter which duplicated rule as they are identified only by their name (which is the same)
										this.duplicatedRules.put(dupOfOtherRule.getName(), duplicatedRules);
										rule = dupOfOtherRule;
									}
								}
							}
							else if (sequence.getSequence().size() == 1) {
								// remove the meta-class binding for the current TSL rule, if it only reduces to another rule,
								// i.e. "current_TSL_rule -> B" and B being the rule referenced in ruleExpr.
								// in this case, the rule B should be bound to the more concrete meta-class B.
								// therefore we remove the metaClass here.
								tslRule.setValueBinding(null);
								metaClass = null;
							}

							tslRule.getRhs().add(createNonTerminal(rule));
							
							processAllRulesWithSameName(rule, metaClass, ruleStack);
						}
					}
				}
				ruleStack.pop();
			}
				
		}
		
		private NonTerminal createNonTerminalForBooleanPropertyBinding(PropertyBindingExpr bindingExpr, BooleanPropertyType propertyType,
				EClass metaClass) {
			
			EAttribute property = EcoreFactory.eINSTANCE.createEAttribute();
			property.setName(bindingExpr.getName());
			property.setEType(EcorePackage.Literals.EBOOLEAN);
			metaClass.getEStructuralFeatures().add(property);

			// IsQualifiedReference:constant("true":EBoolean) -> "qualified";

			String booleanRuleName = metaClass.getName() + "_" + bindingExpr.getName() + "_booleanRule";
			SimpleRule booleanRule = createTslRule(booleanRuleName);
			
			ConstantBinding booleanBinding = TslFactory.eINSTANCE.createConstantBinding();
			booleanBinding.setValue("true");
			booleanBinding.setType("EBoolean");
			
			FixTerminal keywordTerminal = TslFactory.eINSTANCE.createFixTerminal();
			keywordTerminal.setTerminal(propertyType.getTerminal());

			// ... -> ... ( IsQualifiedReference:composite(qualified) )? ... ;

			CompositeBinding tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			tslPropertyBinding.setProperty(property);
			
			NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
			propertyNonTerminal.setName(booleanRuleName);
			
			return propertyNonTerminal;
		}
		
		private NonTerminal createNonTerminalForPrimitivePropertyBinding(PropertyBindingExpr bindingExpr, EDataType propertyType, String tslValueTypeName, EClass metaClass) {
			EAttribute property = createAttribute(bindingExpr.getName(), metaClass);
			property.setEType(propertyType);
			
			CompositeBinding tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			tslPropertyBinding.setProperty(property);
			
			NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
			propertyNonTerminal.setName(tslValueTypeName);
			
			return propertyNonTerminal;
		}

		private NonTerminal createNonTerminalForIdentifierBinding(PropertyBindingExpr bindingExpr, EClass metaClass) {
			EStructuralFeature property = null;
			
//			if(bindingExpr.getName().equals("name")) {
//				for (EAttribute attribute: metaClass.getEAllAttributes()) {
//					if (attribute.getName().equals("name")) {
//						property = attribute;
//						break;
//					}
//				}
//				if (property == null) {
//					property = createAttribute(bindingExpr.getName(), metaClass);
//					property.setEType(EcorePackage.Literals.ESTRING);
//				}
//			}
//			else {
				if (!metaClass.getEAllStructuralFeatures().contains(DblPackage.Literals.NAMED_ELEMENT__NAME)) {
					metaClass.getESuperTypes().add(DblPackage.Literals.NAMED_ELEMENT);
				}
				property = DblPackage.Literals.NAMED_ELEMENT__NAME;
//			}

			CompositeBinding tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			tslPropertyBinding.setProperty(property);
			
			NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
			propertyNonTerminal.setName("IDENTIFIER");
			
			return propertyNonTerminal;
		}

		//private NonTerminal createNonTerminalForPropertyBinding(PropertyBindingExpr bindingExpr,
		//		ReferableRhsType type, EClass metaClass) {
		
		private NonTerminal createNonTerminalForRawReferencePropertyBinding(PropertyBindingExpr bindingExpr, ReferableRhsType type, EClass metaClass) {
			String typeName = type.getName();

			EReference property = createReference(bindingExpr.getName(), metaClass);
			property.setContainment(false);
			
			EClass bindingMetaClass = findMetaClass(typeName);
			if (bindingMetaClass == null) {
				bindingMetaClass = getMetaClass(typeName);				
			}
			property.setEType(bindingMetaClass);
			String refNonTerminalName = property.getEType().getName() + "Ref";
			
			PropertyBinding propertyBinding = TslFactory.eINSTANCE.createReferenceBinding();
				
			NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(propertyBinding);
			propertyNonTerminal.setName(refNonTerminalName);

			NonTerminal refNonTerminal = null;

			for (Rule rule: getSyntax().getRules()) {
				if (rule.getLhs().getName().equals(refNonTerminalName)) {
					refNonTerminal = rule.getLhs();
					break;
				}
			}

			if (refNonTerminal == null) {
				// `property-type`Ref -> ...
				SimpleRule refNonTerminalRule = createTslRule(refNonTerminalName); //TslFactory.eINSTANCE.createSimpleRule();					
				
				// ... -> IDENTIFIER:composite(name)
				
				NonTerminal idNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
				idNonTerminal.setName("IDENTIFIER");
				
				CompositeBinding nameBinding = TslFactory.eINSTANCE.createCompositeBinding();
				
				EAttribute nameAttribute = null;
				for (EAttribute attribute: bindingMetaClass.getEAllAttributes()) {
					if (attribute.getName().equals("name")) {
						nameAttribute = attribute;
					}
				}
				if (nameAttribute != null) {
					nameBinding.setProperty(nameAttribute);
				}
				else {
					nameBinding.setProperty(DblPackage.Literals.NAMED_ELEMENT__NAME); // TODO
				}
				idNonTerminal.setPropertyBinding(nameBinding);
				
				refNonTerminalRule.getRhs().add(idNonTerminal);
				
				// `property-type`Ref:element(`property-type`) -> ...
				ElementBinding propertyTypeBinding = TslFactory.eINSTANCE.createElementBinding();
				propertyTypeBinding.setMetaclass((EClass) property.getEType());
				refNonTerminalRule.setValueBinding(propertyTypeBinding);
			}

			propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setPropertyBinding(propertyBinding);
			propertyNonTerminal.setName(refNonTerminalName);			
			
			propertyBinding.setProperty(property);
					
			return propertyNonTerminal;
		}
		
		private NonTerminal createNonTerminalForPropertyBinding(PropertyBindingExpr bindingExpr,
				ReferableRhsType type, EClass metaClass) {

			EReference property = createReference(bindingExpr.getName(), metaClass);
			property.setContainment(true);
			
			property.setLowerBound(0);
			property.setUpperBound(1);
			
			String propertyTypeName = null;
			NonTerminal propertyNonTerminal = null;
			
			if (bindingExpr.getPropertyType() instanceof ReferencePropertyType) {
				propertyTypeName = "IdExpr";
				propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
				propertyNonTerminal.setName(propertyTypeName);
			}
			else if (bindingExpr.getPropertyType() instanceof CompositePropertyType) {
				CompositePropertyType compositePropertyType = (CompositePropertyType) bindingExpr.getPropertyType();
				propertyTypeName = type.getName();
				propertyNonTerminal = createNonTerminal(type);
				if (compositePropertyType.isList()) {
					property.setUpperBound(-1);
				}
			}
			
			// try to find a meta-class ...
			// ODEMc classifier is an interface that is only a place-holder for the real meta-class
			EClass bindingMetaClass = findMetaClass(propertyTypeName);
			if (bindingMetaClass == null) {
				bindingMetaClass = getMetaClass(propertyTypeName);				
			}
			property.setEType(bindingMetaClass);
			
			PropertyBinding propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			propertyBinding.setProperty(property);
			propertyNonTerminal.setPropertyBinding(propertyBinding);			
			
			return propertyNonTerminal;
		}
		
		private EClass findMetaClass(String name) {
			for (EClassifier metaClass: getDblMetaModel().getEClassifiers()) {
				if (metaClass instanceof EClass && metaClass.getName().equals(name)) {
					return (EClass) metaClass;
				}
			}
			return null;
		}

		private EClass extensionRuleMetaClass;
		
		private EClass getExtensionRuleMetaClass() {
			if (extensionRuleMetaClass == null) {
				ExtensionRule extensionRule = extensionDefinition.getTextualSyntaxDef().getExtensionRule();
				
				String extensionRuleName = null;
				if (extensionRule.getInstantiableMetaClass() != null) {
					extensionRuleName = extensionRule.getInstantiableMetaClass().getName();
				}
				else {
					extensionRuleName = extensionRule.getName();
				}
				
				for (EClassifier metaClass: getDblMetaModel().getEClassifiers()) {
					if (metaClass instanceof EClass && metaClass.getName().equals(extensionRuleName)) {
						extensionRuleMetaClass = (EClass) metaClass;
						return extensionRuleMetaClass;
					}
				}
				
				// try to find meta-class via syntax -> Factor
			}
			return extensionRuleMetaClass;
		}

		private Map<String, EClass> metaClasses = new HashMap<String, EClass>();
		
		private EStructuralFeature findStructuralFeature(String name, EClass metaClass) {
			for (EStructuralFeature feature: metaClass.getEAllStructuralFeatures()) {
				if (feature.getName().equals(name)) {
					return feature;
				}
			}
			return null;
		}
		
		private EReference createReference(String name, EClass metaClass) {
			EStructuralFeature feature = findStructuralFeature(name, metaClass);
			if (feature != null) {
				if (feature instanceof EReference) return (EReference) feature;
				else throw new RuntimeException();
			}
			EReference ref = EcoreFactory.eINSTANCE.createEReference();
			ref.setName(name);
			metaClass.getEStructuralFeatures().add(ref);
			System.out.println("adding reference '" + name + "' to meta-class '" + metaClass.getName() + "'");
			return ref;
		}
		
		private EAttribute createAttribute(String name, EClass metaClass) {
			EStructuralFeature feature = findStructuralFeature(name, metaClass);
			if (feature != null) {
				if (feature instanceof EAttribute) return (EAttribute) feature;
				else throw new RuntimeException();
			}
			EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
			attr.setName(name);
			metaClass.getEStructuralFeatures().add(attr);
			System.out.println("adding attribute '" + name + "' to meta-class '" + metaClass.getName() + "'");
			return attr;
		}
		
		private EClass getMetaClass(String name) {
			if (metaClasses.containsKey(name)) {
				return metaClasses.get(name);
			}
			else {
				EClass metaClass = null;
				EClassifier classifier = getDblMetaModel().getEClassifier(name);
				if (classifier != null && classifier instanceof EClass) {
					metaClass = (EClass) classifier;
					System.out.println("using existing meta-class");
					System.out.println("meta-id: " + metaClass.getClassifierID());
				}
				else {
					System.out.println("creating new meta-class");
					
					metaClass = EcoreFactory.eINSTANCE.createEClass();

					String className = name.substring(0,1).toUpperCase() + name.substring(1);
					metaClass.setName(className);
					
					metaClass.getESuperTypes().add(getExtensionRuleMetaClass());
					
					// other rules that just reduce to the current rule are added as meta-classes of the current one
					// e.g. rule A -> Current results in the meta-class Current extending meta-class A.
					for (TsRule rule: extensionDefinition.getTextualSyntaxDef().getNewRules()) {
						RhsExpression rhsExpr = rule.getRhs();
						if (rhsExpr instanceof SequenceExpr) {
							SequenceExpr sequenceExpr = (SequenceExpr) rhsExpr;
							if (sequenceExpr.getSequence().size() == 1) {
								RhsExpression firstExpr = sequenceExpr.getSequence().get(0);
								if (firstExpr instanceof RuleExpr) {
									RuleExpr ruleExpr = (RuleExpr) firstExpr;
									if (ruleExpr.getRule().getName().equals(name)) {
										EClass parentMetaClass = getMetaClass(rule.getName());
										metaClass.getESuperTypes().add(parentMetaClass);
									}
								}
							}
						}
					}
					
					getDblMetaModel().getEClassifiers().add(metaClass);
					addedMetaClasses.add(metaClass);
				}
				metaClasses.put(name, metaClass);
				return metaClass;
			}
		}
		
		
		
		private NonTerminal createNonTerminal(TsRule rule) {
			NonTerminal extensionNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			extensionNonTerminal.setName(getTslRuleName(rule));
			return extensionNonTerminal;
		}
		
		private NonTerminal createNonTerminal(ReferableRhsType referableRhsType) {
			NonTerminal extensionNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			
			if (referableRhsType instanceof TsRule) {
				extensionNonTerminal.setName(getTslRuleName(referableRhsType.getName()));
			}
			else {
				extensionNonTerminal.setName(referableRhsType.getName());
			}
			
			return extensionNonTerminal;
		}
		
		private SimpleRule createTslRule(TsRule rule) {
			NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			nonTerminal.setName(getTslRuleName(rule));
			
			SimpleRule tslRule = TslFactory.eINSTANCE.createSimpleRule();
			tslRule.setLhs(nonTerminal);
			
			//if (!processedRules.contains(rule)) {
				getSyntax().getRules().add(tslRule);
				addedRules.add(tslRule);
				processedRules.add(rule);
			//}
			
			return tslRule;
		}

		private SimpleRule createTslRule(String name) {
			NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			nonTerminal.setName(name);
			
			SimpleRule tslRule = TslFactory.eINSTANCE.createSimpleRule();
			tslRule.setLhs(nonTerminal);
			
			getSyntax().getRules().add(tslRule);
			addedRules.add(tslRule);
			
			return tslRule;
		}

		public void revert() {
			for (Rule rule: addedRules) {
				((Syntax) rule.eContainer()).getRules().remove(rule);
			}
			
			for (EClass metaClass: addedMetaClasses) {
				metaClass.getEPackage().getEClassifiers().remove(metaClass);
			}
		}
		
	}
	
	private void addExtensionDefinition(ExtensionDefinition extensionDef) {
		System.out.println("adding extension definition '" + extensionDef.getName() + "' ...");
		
		ExtensionDefinitionProcessor processor = new ExtensionDefinitionProcessor(extensionDef);
		boolean added = processor.addToSyntax();
		if (added) {
			extensionDefsProcessed.put(extensionDef.getName(), processor);
		}
	}
	
	private void addExtensionDefOld(ExtensionDefinition extensionDef) {
		System.out.println("adding extension definition '" + extensionDef.getName() + "' ...");
		
		ExtensionDefinitionProcessor processor = new ExtensionDefinitionProcessor(extensionDef);
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
