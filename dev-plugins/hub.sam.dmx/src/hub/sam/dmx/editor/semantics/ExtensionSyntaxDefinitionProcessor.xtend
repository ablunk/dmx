package hub.sam.dmx.editor.semantics

import hub.sam.dbl.Class
import hub.sam.dbl.ComplexSymbol
import hub.sam.dbl.Concept
import hub.sam.dbl.DblPackage
import hub.sam.dbl.ElementarySymbol
import hub.sam.dbl.Extension
import hub.sam.dbl.IdSymbol
import hub.sam.dbl.IntSymbol
import hub.sam.dbl.Keyword
import hub.sam.dbl.MetaSymbol
import hub.sam.dbl.PlainSymbolReference
import hub.sam.dbl.StringSymbol
import hub.sam.dbl.StructuralSymbolReference
import hub.sam.dbl.SymbolSequence
import hub.sam.dbl.SyntaxDefinition
import hub.sam.dbl.SyntaxExpression
import hub.sam.dbl.SyntaxSymbolClassifier
import hub.sam.tef.tsl.NonTerminal
import hub.sam.tef.tsl.Rule
import hub.sam.tef.tsl.SimpleRule
import hub.sam.tef.tsl.Syntax
import hub.sam.tef.tsl.TslFactory
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Stack
import java.util.logging.Logger
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil
import hub.sam.dbl.Classifier
import hub.sam.dbl.Interface

class DuplicatedMetaSymbolsContainer {
	public var Collection<MetaSymbol> symbols = new HashSet<MetaSymbol>();
	public var EClass metaClass;
}

class ExtensionSyntaxDefinitionProcessor {
	
	private val Collection<Rule> addedRules = new HashSet<Rule>();
	private val Collection<EClass> addedMetaClasses = new HashSet<EClass>();
	
	// former metaClasses, cache for all meta-classes used
	private val Map<String, EClass> allMetaClasses = new HashMap<String, EClass>();

	private val Collection<MetaSymbol> processedMetaSymbols = new HashSet<MetaSymbol>();	
	private val Map<String, DuplicatedMetaSymbolsContainer> duplicatedMetaSymbols = new HashMap<String, DuplicatedMetaSymbolsContainer>();
	private val Collection<MetaSymbol> completelyProcessedMetaSymbols = new HashSet<MetaSymbol>();
	
	private var Extension extensionDefinition;
	private var Syntax _syntax;
	private var DblPackage _dblMetaModel;
	private var EClass _extendedConceptMetaClass;
	private var EClass _instantiableDblEClass;
	
	private val Logger logger = Logger.getLogger(ExtensionSyntaxDefinitionProcessor.name)
	
	new(Extension extensionDefinition, Syntax syntax, DblPackage dblMetaModel) {
		this.extensionDefinition = extensionDefinition;
		_syntax = syntax;
		_dblMetaModel = dblMetaModel;
	}
	
	private def Syntax getSyntax() {
		return _syntax;
	}
	
	private def DblPackage getDblMetaModel() {
		return _dblMetaModel;
	}
	
	private Collection<StructuralSymbolReference> structuralSymbolRefs_with_derivedListProperty = new HashSet<StructuralSymbolReference>()
	
	// adds the list attribute to all structural symbol references which are of type list
	private def rewriteListParts(SyntaxDefinition syntaxDef) {
		syntaxDef.symbols.forEach[rule | 
			if (rule.possibleSyntax instanceof SymbolSequence) {
				val rhsSequenceExpr = rule.possibleSyntax as SymbolSequence
				if (rhsSequenceExpr.sequence.size > 0) {
					// case a)
					if (rhsSequenceExpr.sequence.filter(PlainSymbolReference).filter[classifier != null && classifier.name != null].exists[classifier.name.equals(rule.name)]) {
						// rewrite all composite parts
						rhsSequenceExpr.sequence.filter(StructuralSymbolReference).forEach[structuralSymbolRef | 
							if (structuralSymbolRef.composite) {
								structuralSymbolRefs_with_derivedListProperty.add(structuralSymbolRef)
								logger.info("found list part " + structuralSymbolRef.name + " in rule " + rule.name)
							}
						]
					}
					
					// TODO case b)
				}
			}
		]
	}
	
	// zieht Attribute, die in mehreren Spezialisierungen definiert sind, zur Basis hoch
	private def pullAttributesToBase(SyntaxDefinition syntaxDef) {
		val helper = new PullUpAttributesToBaseHelper(extensionDefinition.syntaxDefinition);
		helper.pullAttributesToBase();
	}
	
	def boolean addToDbl() {
		if (extensionDefinition.syntaxDefinition.startSymbol != null) {
			// the first rule must refer to an existent rule in the syntax.
			// the right side must consist of one new rule.
			// `existent-rule` -> `new-rule`;
			
			rewriteListParts(extensionDefinition.syntaxDefinition)
			//pullAttributesToBase(extensionDefinition.syntaxDefinition)
			
			// start rule
			val startSymbol = extensionDefinition.getSyntaxDefinition().startSymbol;		
			val startTslRule = TslFactory.eINSTANCE.createSimpleRule();
		
			val startNonTerminal = extensionDefinition.extensionPoint.createNonTerminal			
			startTslRule.setLhs(startNonTerminal);
			startTslRule.getRhs().add(startSymbol.createNonTerminal);
			
			getSyntax().getRules().add(startTslRule);
			addedRules.add(startTslRule);	
			
			// other rules ...
			val Stack<MetaSymbol> symbolStack = new Stack<MetaSymbol>();			
			processAllMetaSymbolsWithEqualNames(extensionDefinition.getSyntaxDefinition().symbols.get(0), null, symbolStack);
			
			// process duplicated meta symbols ...
			do {
				val Map<String, DuplicatedMetaSymbolsContainer> processingDuplicatedMetaSymbols = new HashMap<String, DuplicatedMetaSymbolsContainer>(duplicatedMetaSymbols);
				duplicatedMetaSymbols.clear();
				for (String ruleName: processingDuplicatedMetaSymbols.keySet()) {
					extensionDefinition.getSyntaxDefinition().symbols.addAll(processingDuplicatedMetaSymbols.get(ruleName).symbols);
					processAllMetaSymbolsWithEqualNames(ruleName, processingDuplicatedMetaSymbols.get(ruleName).metaClass, symbolStack);
				}
			} while (duplicatedMetaSymbols.size() > 0);
			
			//syntax.rules.forEach[ rule | System.out.println(rule); ]

			return true;
		}
		return false;
	}
	
	public def void revert() {
		for (Rule rule: addedRules) {
			(rule.eContainer as Syntax).rules.remove(rule)
		}
		
		for (EClass metaClass: addedMetaClasses) {
			metaClass.getEPackage().getEClassifiers().remove(metaClass);
		}
	}
	
	private def dispatch NonTerminal createNonTerminal(EObject object) {
		throw new RuntimeException
	}
	
	private def dispatch NonTerminal createNonTerminal(MetaSymbol rule) {
		val nonTerminal = TslFactory.eINSTANCE.createNonTerminal()
		nonTerminal.setName(rule.syntaxSymbolName)
		return nonTerminal
	}
	
	private def dispatch NonTerminal createNonTerminal(Extension extDef) {
		val nonTerminal = TslFactory.eINSTANCE.createNonTerminal()
		nonTerminal.setName(extDef.syntaxSymbolName)
		return nonTerminal
	}
	
	private def dispatch NonTerminal createNonTerminal(Classifier classifier) {
		val nonTerminal = TslFactory.eINSTANCE.createNonTerminal()
		nonTerminal.setName(classifier.syntaxSymbolName)
		return nonTerminal
	}
	
	private def dispatch String getSyntaxSymbolName(EObject object) {
		throw new RuntimeException
	}

	private def dispatch String getSyntaxSymbolName(MetaSymbol symbol) {
		val extDef = (symbol.eContainer as SyntaxDefinition)?.eContainer as Extension
		return (if (extDef != null) extDef.name else extensionDefinition.name) + "_" + symbol.name + "_extension"
	}
	
	private def dispatch String getSyntaxSymbolName(Extension referencedExtDef) {
		return getExtensionDefinitionSyntaxRuleName(referencedExtDef)
	}
	
	public static def String getExtensionDefinitionSyntaxRuleName(Extension extDef) {
		return extDef.name + "_" + extDef.syntaxDefinition.startSymbol.name + "_extension"
	}

	private def dispatch String getSyntaxSymbolName(Classifier classifier) {
		return classifier.name
	}

	private def void processAllMetaSymbolsWithEqualNames(MetaSymbol newSymbol, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		processAllMetaSymbolsWithEqualNames(newSymbol.getName(), metaClass, symbolStack);
	}
	
	
	private def void processAllMetaSymbolsWithEqualNames(String symbolName, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		for (MetaSymbol otherSymbol: extensionDefinition.syntaxDefinition.symbols) {
			if (otherSymbol.getName().equals(symbolName) && !completelyProcessedMetaSymbols.contains(otherSymbol)) {
				processSingleMetaSymbol(otherSymbol, metaClass, symbolStack);
				completelyProcessedMetaSymbols.add(otherSymbol);
			}
		}
	}
	
	private def SimpleRule createTslRule(MetaSymbol symbol) {
		val nonTerminal = symbol.createNonTerminal
		
		val tslRule = TslFactory.eINSTANCE.createSimpleRule();
		tslRule.setLhs(nonTerminal);
		
		//if (!processedRules.contains(rule)) {
			getSyntax().getRules().add(tslRule);
			addedRules.add(tslRule);
			processedMetaSymbols.add(symbol);
		//}
		
		return tslRule;
	}
	
	private def EClass getExtendedConceptMetaClass() {
		if (_extendedConceptMetaClass == null) {
			_extendedConceptMetaClass = extensionDefinition.extensionPoint.metaClass;
		}
		return _extendedConceptMetaClass;
	}
	
	private def EClass getInstantiableDblEClass() {
		if (_instantiableDblEClass == null) {
			var conceptClassifier = extensionDefinition.extensionPoint
			while (conceptClassifier instanceof Extension) {
				conceptClassifier = (conceptClassifier as Extension).extensionPoint
			}
			_instantiableDblEClass = (conceptClassifier as Classifier).metaClass
		}
		return _instantiableDblEClass;
	}
	
	private def dispatch EClass getMetaClass(Classifier concept) {
		return _getMetaClass_general(concept.syntaxSymbolName, concept)
	}
	
	private def dispatch EClass getMetaClass(Extension concept) {
		return _getMetaClass_general(concept.syntaxSymbolName, concept)
	}

	private def dispatch EClass getMetaClass(MetaSymbol concept) {
		return _getMetaClass_general(concept.syntaxSymbolName, concept)
	}
	
	private def EClass _getMetaClass_general(String name, SyntaxSymbolClassifier symbolClassifier) {
		if (allMetaClasses.containsKey(name)) {
			return allMetaClasses.get(name);
		}
		else {
			var EClass metaClass = null;
			val EClassifier metaClassifier = getDblMetaModel().getEClassifier(name);
			
			if (metaClassifier != null && metaClassifier instanceof EClass) {
				metaClass = metaClassifier as EClass;
				logger.info("using existing meta-class with classifier-ID " + metaClass.getClassifierID())
			}
			else {
				logger.info("creating new meta-class " + name)
				
				metaClass = EcoreFactory.eINSTANCE.createEClass();
				metaClass.setName(name);

				if (symbolClassifier instanceof Extension) {
					var concept = (symbolClassifier as Extension).extensionPoint
					while (concept instanceof Extension) {
						concept = (concept as Extension).extensionPoint
					}
					metaClass.getESuperTypes().add((concept as Interface).metaClass);
				}
				else if (symbolClassifier instanceof MetaSymbol) {
					val metaSymbol = symbolClassifier as MetaSymbol
					if (metaSymbol.syntaxSymbolName.equals(extensionDefinition.syntaxDefinition.startSymbol.syntaxSymbolName)) {
						metaClass.getESuperTypes().add(instantiableDblEClass)
					}
					else {
						metaClass.getESuperTypes().add(DblPackage.Literals.EXTENSIBLE_ELEMENT);
						//metaClass.getESuperTypes().add(instantiableDblEClass)
					}
				}
				else if (symbolClassifier instanceof Interface) {
					// it cannot be a DBL metaclass from the dbl module because getDblMetaModel().getEClassifier(name)
					// would have return the metaclass.
					
					// it could be a regular DBL class
					metaClass.getESuperTypes().add(DblPackage.Literals.CONSTRUCT);
					// then it has be at least a Construct so that instances can be created
				}

				//metaClass.getESuperTypes().add(extendedConceptMetaClass);
				
				// in case, the langConstructClassifier is used in a direct reduction rule, e.g. "directReductionRule" -> "langConstructClassifier":
				// the meta-class of "directReductionRule" is added as a super-class of the meta-class of "langConstructClassifier".
				val fMetaClass = metaClass

				directDerivatives.forEach[ directDerivative | 
					val reductionTarget = ((directDerivative.possibleSyntax as SymbolSequence).sequence.get(0) as PlainSymbolReference).classifier
					if (reductionTarget instanceof ComplexSymbol && reductionTarget.syntaxSymbolName.equals(name)) {
						val superMetaClass = directDerivative.metaClass
						fMetaClass.getESuperTypes().add(superMetaClass)
						logger.info("added super-class " + superMetaClass + " to meta-class "+ name)
					}
				]
				
				getDblMetaModel().getEClassifiers().add(metaClass);
				addedMetaClasses.add(metaClass);
			}
			
			allMetaClasses.put(name, metaClass);
			return metaClass;
		}
	}
	
	private var List<MetaSymbol> _directDerivatives;
	
	private def List<MetaSymbol> getDirectDerivatives() {
		if (_directDerivatives == null) {
			_directDerivatives = extensionDefinition.getSyntaxDefinition().symbols.
				filter[
					possibleSyntax instanceof SymbolSequence && (possibleSyntax as SymbolSequence).sequence.size == 1
						&& (possibleSyntax as SymbolSequence).sequence.get(0) instanceof PlainSymbolReference
						&& !((possibleSyntax as SymbolSequence).sequence.get(0) instanceof StructuralSymbolReference)
						&& ((possibleSyntax as SymbolSequence).sequence.get(0) as PlainSymbolReference).classifier instanceof MetaSymbol
				].toList
		}
		return _directDerivatives
	}

	private def dispatch void processRhsExpr(SyntaxExpression plainSymbolRef, SimpleRule tslRule, EClass _metaClass, Stack<MetaSymbol> symbolStack) {
		// not implemented
	}
	
	private def dispatch void processRhsExpr(PlainSymbolReference plainSymbolRef, SimpleRule tslRule, EClass _metaClass, Stack<MetaSymbol> symbolStack) {
		val symbolClassifier = plainSymbolRef.getClassifier();
		var metaClass = _metaClass
		
		switch (symbolClassifier) {
			Extension: {
				tslRule.getRhs().add(createNonTerminal(symbolClassifier));
			}
			ElementarySymbol: {
				// ... -> ... ID ...
				// ... -> ... "keyword" ...
				processSymbol(symbolClassifier, plainSymbolRef, tslRule, metaClass, symbolStack)
			}
			Interface: {
				// ... -> ... Statement ... ;

				// copy rhs of the rule identified by the name of type to this rule's rhs
				val firstRuleWithClassName = syntax.rules.findFirst[lhs.name.equals(symbolClassifier.name)]
				// TODO: if multiple rules exist...
				
				if (firstRuleWithClassName instanceof SimpleRule) {
					var actualRule = firstRuleWithClassName as SimpleRule
					if (actualRule.rhs.size == 1 && actualRule.rhs.head instanceof NonTerminal &&
						actualRule.rhs.head.propertyBinding == null
					) {
						// another indirection: `simpleRule` -> `actualRule`; `actualRule`:element(...) -> ...;
						val fActualRule = actualRule;
						actualRule = syntax.rules.findFirst[lhs.name.equals((fActualRule.rhs.head as NonTerminal).name)] as SimpleRule
					}
					
					val copier = new EcoreUtil.Copier()
					val rhsCopy = copier.copyAll(actualRule.rhs)
					copier.copyReferences
					tslRule.rhs.addAll(rhsCopy)
				}
				
				//tslRule.getRhs().add(createNonTerminal(type));
				//tslRule.valueBinding = null
			}
			MetaSymbol: {
				var rule = symbolClassifier
				
				val rhsContainer = plainSymbolRef.eContainer
				if (rhsContainer instanceof SymbolSequence) {
					val sequenceExpr = rhsContainer as SymbolSequence
					
					if (sequenceExpr.sequence.size > 1) {
						if (processedMetaSymbols.contains(rule) && !symbolStack.contains(rule)) {
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
							 * to be saved in the structural feature RBaz.otherBaz which does not exist for IBaz.
							 * 
							 * therefore, if a RuleExpr is reached, that has already been processed and is not currently
							 * on the rule stack, then this rule is duplicated for the currently active rule.
							 */

							val dupRuleName = symbolClassifier.syntaxSymbolName + "_" + metaClass.getName();
		
							val dupRule = processedMetaSymbols.findFirst[name.equals(dupRuleName)]
							if (dupRule != null) {
								// duplicated rule was processed before
								tslRule.getRhs().add(createNonTerminal(dupRule));
							}
							else {
								// all definitions (lhs) of the rule have to be duplicated
								
								val duplicatedRules = new DuplicatedMetaSymbolsContainer();
								duplicatedRules.metaClass = metaClass;
								
								val fRule = rule
								val sameNameRules = extensionDefinition.syntaxDefinition.symbols.filter[name.equals(fRule.name)]
								
								var MetaSymbol ruleDefDuplicate = null;
								for (ruleDef : sameNameRules) {
									ruleDefDuplicate = EcoreUtil.copy(ruleDef)
									ruleDefDuplicate.setName(dupRuleName)
									duplicatedRules.symbols.add(ruleDefDuplicate)
									processedMetaSymbols.add(ruleDefDuplicate)
									logger.info("created duplicate rule: " + ruleDefDuplicate.getName())
								}
								
								// does not matter which duplicated rule as they are identified only by their name (which is the same)
								this.duplicatedMetaSymbols.put(dupRuleName, duplicatedRules);
								rule = ruleDefDuplicate;
							}
						}
					}
					else if (sequenceExpr.sequence.size == 1) {
						// remove the meta-class binding for the current TSL rule, if it only reduces to another rule,
						// i.e. "current_TSL_rule -> B" and B being the rule referenced in ruleExpr.
						// in this case, the rule B should be bound to the more concrete meta-class B.
						// therefore we remove the metaClass here.
						
						tslRule.setValueBinding(null);
						metaClass = null;					
					}
	
					tslRule.getRhs().add(createNonTerminal(rule));
				
					processAllMetaSymbolsWithEqualNames(rule, metaClass, symbolStack);
				}
			}
		}
	}
	
	private def dispatch void processRhsExpr(StructuralSymbolReference symbolRef, SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		processSymbol(symbolRef.classifier, symbolRef, tslRule, metaClass, symbolStack)
	}
	
	private def dispatch void processSymbol(Keyword symbol, PlainSymbolReference symbolRef, SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		val fixTerminal = TslFactory.eINSTANCE.createFixTerminal();
		fixTerminal.setTerminal(symbol.keyword);
		tslRule.getRhs().add(fixTerminal);
	}
	
	private def dispatch void processSymbol(Keyword keywordSymbol, StructuralSymbolReference structuralSymbolRef, SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		val metaClassAttribute = createAttribute(structuralSymbolRef.getName(), metaClass);
		metaClassAttribute.setEType(EcorePackage.Literals.EBOOLEAN);
		
		// new rule: `constantRuleName` : constant("true" : EBoolean) -> "`propertyType.terminal`" ;
		val constantRuleName = extensionDefinition.name + "_" + tslRule.lhs.name + "_" + structuralSymbolRef.name;
		
		val constantBinding = TslFactory.eINSTANCE.createConstantBinding();
		constantBinding.setType("EBoolean");
		constantBinding.setValue("true");

		val lhsNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		lhsNonTerminal.setName(constantRuleName);

		val constantRule = TslFactory.eINSTANCE.createSimpleRule();
		constantRule.setLhs(lhsNonTerminal)
		constantRule.setValueBinding(constantBinding)
		
		getSyntax().getRules().add(constantRule);
		addedRules.add(constantRule);		
		
		val rhsNonTerminal = TslFactory.eINSTANCE.createFixTerminal();
		rhsNonTerminal.setTerminal(keywordSymbol.keyword);
		constantRule.rhs.add(rhsNonTerminal)
		
		// source position
		val tslCompositeBinding = TslFactory.eINSTANCE.createCompositeBinding();
		tslCompositeBinding.setProperty(metaClassAttribute);
		
		val sourceNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		sourceNonTerminal.setPropertyBinding(tslCompositeBinding);
		sourceNonTerminal.setName(constantRuleName);
		
		tslRule.rhs.add(sourceNonTerminal)
	}
	
	private def dispatch void processSymbol(IntSymbol propertyType, StructuralSymbolReference structuralSymbolRef, SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		val nonTerminal = createNonTerminal_for_ElementarySymbol(structuralSymbolRef, EcorePackage.Literals.EINT, "INTEGER", metaClass);
		tslRule.getRhs().add(nonTerminal);
	}

	private def dispatch void processSymbol(StringSymbol propertyType, StructuralSymbolReference structuralSymbolRef, SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		val nonTerminal = createNonTerminal_for_ElementarySymbol(structuralSymbolRef, EcorePackage.Literals.ESTRING, "STRINGDEF", metaClass);
		tslRule.getRhs().add(nonTerminal);
	}

	private def dispatch void processSymbol(IdSymbol propertyType, StructuralSymbolReference bindingExpr, SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack) {
		var EStructuralFeature metaClassFeature = null;
		
//		if(bindingExpr.getName().equals("name")) {
//			for (EAttribute attribute: metaClass.getEAllAttributes()) {
//				if (attribute.getName().equals("name")) {
//					property = attribute;
//					break;
//				}
//			}
//			if (property == null) {
//				property = createAttribute(bindingExpr.getName(), metaClass);
//				property.setEType(EcorePackage.Literals.ESTRING);
//			}
//		}
//		else {
			if (!metaClass.getEAllStructuralFeatures().contains(DblPackage.Literals.NAMED_ELEMENT__NAME)) {
				metaClass.getESuperTypes().add(DblPackage.Literals.NAMED_ELEMENT);
			}
			metaClassFeature = DblPackage.Literals.NAMED_ELEMENT__NAME;
//		}

		val tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
		tslPropertyBinding.setProperty(metaClassFeature);
		
		val propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
		propertyNonTerminal.setName("IDENTIFIER");
		
		tslRule.getRhs().add(propertyNonTerminal);
	}
	
	private def dispatch void processSymbol(MetaSymbol symbol, StructuralSymbolReference bindingExpr, 
		SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack
	) {
		tslRule.getRhs().add(createNonTerminal(symbol as ComplexSymbol, bindingExpr, metaClass));

		processAllMetaSymbolsWithEqualNames(symbol, null, symbolStack);
	}
	
	private def dispatch void processSymbol(Concept symbol, StructuralSymbolReference bindingExpr, 
		SimpleRule tslRule, EClass metaClass, Stack<MetaSymbol> symbolStack
	) {
		tslRule.getRhs().add(createNonTerminal(symbol as ComplexSymbol, bindingExpr, metaClass));
	}

	private def NonTerminal createNonTerminal_for_GlobalReference(ComplexSymbol type, StructuralSymbolReference bindingExpr, EClass metaClass) {
		val reference = createEReference(bindingExpr.getName(), metaClass);
		reference.setContainment(false);
		
		val bindingMetaClass = type.metaClass;
		reference.setEType(bindingMetaClass);
		
		val propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();

		val propertyBinding = TslFactory.eINSTANCE.createReferenceBinding();
		propertyBinding.setProperty(reference);
		propertyNonTerminal.setPropertyBinding(propertyBinding);

		val refNonTerminalName = type.syntaxSymbolName + "Ref";
		propertyNonTerminal.setName(refNonTerminalName);

		if (getSyntax().getRules().filter[lhs.name.equals(refNonTerminalName)].empty) {
			// `property-type`Ref -> ...
			
			val refNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			refNonTerminal.setName(refNonTerminalName);
		
			val refNonTerminalRule = TslFactory.eINSTANCE.createSimpleRule();
			refNonTerminalRule.setLhs(refNonTerminal);
		
			getSyntax().getRules().add(refNonTerminalRule);
			addedRules.add(refNonTerminalRule);
			
			// ... -> IDENTIFIER:composite(name)
			
			val idNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			idNonTerminal.setName("IDENTIFIER");
			
			val nameBinding = TslFactory.eINSTANCE.createCompositeBinding();
			
			val nameAttribute = bindingMetaClass.EAllAttributes.filter[name.equals("name")].head;
			if (nameAttribute != null) {
				nameBinding.setProperty(nameAttribute);
			}
			else {
				nameBinding.setProperty(DblPackage.Literals.NAMED_ELEMENT__NAME); // TODO
			}
			idNonTerminal.setPropertyBinding(nameBinding);
			
			refNonTerminalRule.getRhs().add(idNonTerminal);
			
			// `property-type`Ref:element(`property-type`) -> ...
			val propertyTypeBinding = TslFactory.eINSTANCE.createElementBinding();
			propertyTypeBinding.setMetaclass(bindingMetaClass);
			refNonTerminalRule.setValueBinding(propertyTypeBinding);
		}
				
		return propertyNonTerminal;
	}
	
	private def NonTerminal createNonTerminal(ComplexSymbol complexSymbol, StructuralSymbolReference structuralSymbolRef, EClass metaClass) {

		val eReference = createEReference(structuralSymbolRef.getName(), metaClass);
		eReference.setLowerBound(0);
		eReference.setUpperBound(1);
		
		eReference.setContainment(true);
		
		if (structuralSymbolRef.composite) {
			val nonTerminal = createNonTerminal(complexSymbol);
			
			if (structuralSymbolRef.list || structuralSymbolRefs_with_derivedListProperty.contains(structuralSymbolRef)) {
				eReference.setUpperBound(-1);
			}
			
			val bindingMetaClass = getMetaClass(complexSymbol);
	
			if (eReference.getEType() == null) {
				eReference.setEType(bindingMetaClass);
			}
			// else: the property is inherited -> use its defined type
			
			val compositeBinding = TslFactory.eINSTANCE.createCompositeBinding();
			compositeBinding.setProperty(eReference);
			nonTerminal.setPropertyBinding(compositeBinding);			
			
			return nonTerminal;
		}
		else if (structuralSymbolRef.localScopedReference) {
			// i.e. reference
			val propertyType = DblPackage.Literals.ID_EXPR;

			val propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
			propertyNonTerminal.setName("IdExpr");
			
			if (eReference.getEType() == null) {
				eReference.setEType(propertyType);
			}
			// else: the property is inherited -> use its defined type
			
			val propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
			propertyBinding.setProperty(eReference);
			propertyNonTerminal.setPropertyBinding(propertyBinding);			
			
			return propertyNonTerminal;
		}
		else {
			// i.e. globalScopedReference
			createNonTerminal_for_GlobalReference(complexSymbol, structuralSymbolRef, metaClass)
		}
	}
	
	private def NonTerminal createNonTerminal_for_ElementarySymbol(StructuralSymbolReference structuralSymbolRef, EDataType eReferenceType,
		String tslValueTypeName, EClass metaClass
	) {
		val metaClassAttribute = createAttribute(structuralSymbolRef.getName(), metaClass);
		metaClassAttribute.setEType(eReferenceType);
		
		val tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
		tslPropertyBinding.setProperty(metaClassAttribute);
		
		val propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
		propertyNonTerminal.setName(tslValueTypeName);
		
		return propertyNonTerminal;
	}
	
	private def EAttribute createAttribute(String name, EClass metaClass) {
		val structuralFeature = findStructuralFeature(name, metaClass);
		if (structuralFeature != null) {
			if (structuralFeature instanceof EAttribute) return structuralFeature as EAttribute
			else throw new RuntimeException()
		}
		val attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName(name);
		metaClass.getEStructuralFeatures().add(attribute);
		logger.info("adding attribute '" + name + "' to meta-class '" + metaClass.getName() + "'");
		return attribute;
	}
	
	private def EReference createEReference(String name, EClass metaClass) {
		val structuralFeature = findStructuralFeature(name, metaClass);
		if (structuralFeature != null) {
			if (structuralFeature instanceof EReference) return structuralFeature as EReference
			else throw new RuntimeException()
		}
		val reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName(name);
		metaClass.getEStructuralFeatures().add(reference);
		logger.info("adding reference '" + name + "' to meta-class '" + metaClass.getName() + "'");
		return reference;
	}
	
	private def EStructuralFeature findStructuralFeature(String name, EClass metaClass) {
		for (EStructuralFeature feature: metaClass.getEAllStructuralFeatures()) {
			if (feature.getName().equals(name)) {
				return feature;
			}
		}
		return null;
	}

	private def void processSingleMetaSymbol(MetaSymbol newRule, EClass passedDownMetaClass, Stack<MetaSymbol> symbolStack) {			
		if (!symbolStack.contains(newRule)) {
			processedMetaSymbols.add(newRule);
			
			symbolStack.push(newRule);
			logger.info("processing rule " + newRule.getName());
			
			val tslRule = newRule.createTslRule;
			
			var EClass bindingMetaClass = passedDownMetaClass;
			if (bindingMetaClass == null) {
				bindingMetaClass = getMetaClass(newRule);

				val metaClassBinding = TslFactory.eINSTANCE.createElementBinding();
				metaClassBinding.setMetaclass(bindingMetaClass);
				tslRule.setValueBinding(metaClassBinding);
			}
			
			val rhs = newRule.possibleSyntax;
			
			if (rhs instanceof SymbolSequence) {
				val sequenceExpr = rhs as SymbolSequence;
				
				for (SyntaxExpression sequencePart: sequenceExpr.sequence) {
					sequencePart.processRhsExpr(tslRule, bindingMetaClass, symbolStack)
					
					if (sequencePart instanceof StructuralSymbolReference) {
						val structuralSymbolRef = sequencePart as StructuralSymbolReference
						
						if (structuralSymbolRef.composite) {
							if (structuralSymbolRef.classifier instanceof MetaSymbol) {
								processAllMetaSymbolsWithEqualNames(structuralSymbolRef.classifier as MetaSymbol, null, symbolStack);
							}
						}
					}
				}
			}
			symbolStack.pop();
			
			logger.info(tslRule.toString)
		}
			
	}
	
}