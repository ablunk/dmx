package hub.sam.dmx

import java.util.Collection
import hub.sam.tef.tsl.Rule
import java.util.HashSet
import org.eclipse.emf.ecore.EClass
import hub.sam.dbl.ExtensionDefinition
import hub.sam.tef.tsl.Syntax
import hub.sam.dbl.DblPackage
import java.util.Stack
import hub.sam.dbl.TsRule
import java.util.Map
import java.util.HashMap
import hub.sam.tef.tsl.NonTerminal
import hub.sam.tef.tsl.TslFactory
import org.eclipse.emf.ecore.EObject
import hub.sam.tef.tsl.SimpleRule
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EcoreFactory
import hub.sam.dbl.SequenceExpr
import hub.sam.dbl.RhsClassifierExpr
import java.util.logging.Logger
import hub.sam.dbl.Clazz
import hub.sam.dbl.LanguageConstructClassifier
import hub.sam.dbl.TerminalExpr
import hub.sam.dbl.PropertyBindingExpr
import hub.sam.dbl.RhsExpression
import hub.sam.dbl.IntPropertyType
import org.eclipse.emf.ecore.EcorePackage
import hub.sam.dbl.StringPropertyType
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EStructuralFeature
import hub.sam.dbl.IdPropertyType
import hub.sam.dbl.ReferencePropertyType
import hub.sam.dbl.CompositePropertyType
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil

class DuplicatedRulesContainer {
	public var Collection<TsRule> rules = new HashSet<TsRule>();
	public var EClass metaClass;
}

class ExtensionSyntaxDefinitionProcessor {
	
	private val Collection<Rule> addedRules = new HashSet<Rule>();
	private val Collection<EClass> addedMetaClasses = new HashSet<EClass>();
	
	// former metaClasses, cache for all meta-classes used
	private val Map<String, EClass> allMetaClasses = new HashMap<String, EClass>();

	private val Collection<TsRule> processedRules = new HashSet<TsRule>();	
	private val Map<String, DuplicatedRulesContainer> duplicatedRules = new HashMap<String, DuplicatedRulesContainer>();
	private val Collection<TsRule> completelyProcessedRules = new HashSet<TsRule>();
	
	private var ExtensionDefinition extensionDefinition;
	private var Syntax _syntax;
	private var DblPackage _dblMetaModel;
	private var EClass _extendedConceptMetaClass;
	private var EClass _instantiableDblEClass;
	
	private val Logger logger = Logger.getLogger(ExtensionSyntaxDefinitionProcessor.name)
	
	new(ExtensionDefinition extensionDefinition, Syntax syntax, DblPackage dblMetaModel) {
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
	
	def boolean addToDbl() {
		if (extensionDefinition.getTextualSyntaxDef().getStartRule() != null) {
			// the first rule must refer to an existent rule in the syntax.
			// the right side must consist of one new rule.
			// `existent-rule` -> `new-rule`;
			
			// start rule
			val startRule = extensionDefinition.getTextualSyntaxDef().getStartRule();		
			val startTslRule = TslFactory.eINSTANCE.createSimpleRule();
		
			val startNonTerminal = extensionDefinition.extendedConcept.createNonTerminal			
			startTslRule.setLhs(startNonTerminal);
			startTslRule.getRhs().add(startRule.createNonTerminal);
			
			getSyntax().getRules().add(startTslRule);
			addedRules.add(startTslRule);	
			
			// other rules ...
			val Stack<TsRule> ruleStack = new Stack<TsRule>();			
			processAllRulesWithSameName(extensionDefinition.getTextualSyntaxDef().getRules().get(0), null, ruleStack);
			
			// process duplicated rules ...
			do {
				val Map<String, DuplicatedRulesContainer> processingDuplicatedRules = new HashMap<String, DuplicatedRulesContainer>(duplicatedRules);
				duplicatedRules.clear();
				for (String ruleName: processingDuplicatedRules.keySet()) {
					extensionDefinition.getTextualSyntaxDef().getRules().addAll(processingDuplicatedRules.get(ruleName).rules);
					processAllRulesWithSameName(ruleName, processingDuplicatedRules.get(ruleName).metaClass, ruleStack);
				}
			} while (duplicatedRules.size() > 0);
			
			//printCurrentSyntax();

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
	
	private def dispatch NonTerminal createNonTerminal(TsRule rule) {
		val nonTerminal = TslFactory.eINSTANCE.createNonTerminal()
		nonTerminal.setName(rule.syntaxRuleName)
		return nonTerminal
	}
	
	private def dispatch NonTerminal createNonTerminal(ExtensionDefinition extDef) {
		val nonTerminal = TslFactory.eINSTANCE.createNonTerminal()
		nonTerminal.setName(extDef.syntaxRuleName)
		return nonTerminal
	}
	
	private def dispatch NonTerminal createNonTerminal(Clazz clazz) {
		val nonTerminal = TslFactory.eINSTANCE.createNonTerminal()
		nonTerminal.setName(clazz.syntaxRuleName)
		return nonTerminal
	}
	
	private def dispatch String getSyntaxRuleName(EObject object) {
		throw new RuntimeException
	}

	private def dispatch String getSyntaxRuleName(TsRule rule) {
		return extensionDefinition.name + "_" + rule.name + "_extension"
	}
	
	private def dispatch String getSyntaxRuleName(ExtensionDefinition referencedExtDef) {
		return getExtensionDefinitionSyntaxRuleName(referencedExtDef)
	}
	
	public static def String getExtensionDefinitionSyntaxRuleName(ExtensionDefinition extDef) {
		return extDef.name + "_" + extDef.textualSyntaxDef.startRule.name + "_extension"
	}

	private def dispatch String getSyntaxRuleName(Clazz clazz) {
		return clazz.name
	}

	private def void processAllRulesWithSameName(TsRule newRule, EClass metaClass, Stack<TsRule> ruleStack) {
		processAllRulesWithSameName(newRule.getName(), metaClass, ruleStack);
	}
	
	
	private def void processAllRulesWithSameName(String ruleName, EClass metaClass, Stack<TsRule> ruleStack) {
		for (TsRule otherRule: extensionDefinition.getTextualSyntaxDef().getRules()) {
			if (otherRule.getName().equals(ruleName) && !completelyProcessedRules.contains(otherRule)) {
				processSingleRule(otherRule, metaClass, ruleStack);
				completelyProcessedRules.add(otherRule);
			}
		}
	}
	
	private def SimpleRule createTslRule(TsRule rule) {
		val nonTerminal = rule.createNonTerminal
		
		val tslRule = TslFactory.eINSTANCE.createSimpleRule();
		tslRule.setLhs(nonTerminal);
		
		//if (!processedRules.contains(rule)) {
			getSyntax().getRules().add(tslRule);
			addedRules.add(tslRule);
			processedRules.add(rule);
		//}
		
		return tslRule;
	}
	
	private def EClass getExtendedConceptMetaClass() {
		if (_extendedConceptMetaClass == null) {
			_extendedConceptMetaClass = extensionDefinition.extendedConcept.metaClass;
		}
		return _extendedConceptMetaClass;
	}
	
	private def EClass getInstantiableDblEClass() {
		if (_instantiableDblEClass == null) {
			var conceptClassifier = extensionDefinition.extendedConcept
			while (conceptClassifier instanceof ExtensionDefinition) {
				conceptClassifier = (conceptClassifier as ExtensionDefinition).extendedConcept
			}
			_instantiableDblEClass = (conceptClassifier as Clazz).metaClass
		}
		return _instantiableDblEClass;
	}
	
	private def dispatch EClass getMetaClass(Clazz conceptClassifier) {
		return _getMetaClass_general(conceptClassifier.syntaxRuleName, conceptClassifier)
	}
	
	private def dispatch EClass getMetaClass(ExtensionDefinition conceptClassifier) {
		return _getMetaClass_general(conceptClassifier.syntaxRuleName, conceptClassifier)
	}

	private def dispatch EClass getMetaClass(TsRule rule) {
		return _getMetaClass_general(rule.syntaxRuleName, rule)
	}
	
	private def EClass _getMetaClass_general(String name, LanguageConstructClassifier langConstructClassifier) {
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

				if (langConstructClassifier instanceof ExtensionDefinition) {
					var conceptClassifier = (langConstructClassifier as ExtensionDefinition).extendedConcept
					while (conceptClassifier instanceof ExtensionDefinition) {
						conceptClassifier = (conceptClassifier as ExtensionDefinition).extendedConcept
					}
					metaClass.getESuperTypes().add((conceptClassifier as Clazz).metaClass);
				}
				else {
					metaClass.getESuperTypes().add(instantiableDblEClass);
				}

				metaClass.getESuperTypes().add(extendedConceptMetaClass);
				
				// in case, the langConstructClassifier is used in a direct reduction rule, e.g. "directReductionRule" -> "langConstructClassifier":
				// the meta-class of "directReductionRule" is added as a super-class of the meta-class of "langConstructClassifier".
				val fMetaClass = metaClass
				extensionDefinition.getTextualSyntaxDef().rules.
					filter[
						rhs instanceof SequenceExpr && (rhs as SequenceExpr).sequence.size == 1
							&& (rhs as SequenceExpr).sequence.get(0) instanceof RhsClassifierExpr
					].forEach[ directReductionRule | 
						val directReductionConstructClassifier = ((directReductionRule.rhs as SequenceExpr).sequence.get(0) as RhsClassifierExpr).classifier
						if (directReductionConstructClassifier.name.equals(name)) {
							val superMetaClass = directReductionRule.metaClass
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
	
	private def dispatch void processRhsExpr(TerminalExpr rhsExpr, SimpleRule tslRule, EClass metaClass, Stack<TsRule> ruleStack) {
		val fixTerminal = TslFactory.eINSTANCE.createFixTerminal();
		fixTerminal.setTerminal(rhsExpr.getTerminal());
		tslRule.getRhs().add(fixTerminal);
	}
	
	private def dispatch void processRhsExpr(RhsClassifierExpr rhsExpr, SimpleRule tslRule, EClass _metaClass, Stack<TsRule> ruleStack) {
		val type = rhsExpr.getClassifier();
		var metaClass = _metaClass
		
		switch (type) {
			TsRule: {
				var rule = type
				
				val rhsContainer = rhsExpr.eContainer
				if (rhsContainer instanceof SequenceExpr) {
					val sequenceExpr = rhsContainer as SequenceExpr
					
					if (sequenceExpr.sequence.size > 1) {
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
							 * to be saved in the structural feature RBaz.otherBaz which does not exist for IBaz.
							 * 
							 * therefore, if a RuleExpr is reached, that has already been processed and is not currently
							 * on the rule stack, then this rule is duplicated for the currently active rule.
							 */

							val dupRuleName = type.syntaxRuleName + "_" + metaClass.getName();
		
							val dupRule = processedRules.findFirst[name.equals(dupRuleName)]
							if (dupRule != null) {
								// duplicated rule was processed before
								tslRule.getRhs().add(createNonTerminal(dupRule));
							}
							else {
								// all definitions (lhs) of the rule have to be duplicated
								
								val duplicatedRules = new DuplicatedRulesContainer();
								duplicatedRules.metaClass = metaClass;
								
								val fRule = rule
								val sameNameRules = extensionDefinition.textualSyntaxDef.rules.filter[name.equals(fRule.name)]
								
								var TsRule ruleDefDuplicate = null;
								for (ruleDef : sameNameRules) {
									ruleDefDuplicate = EcoreUtil.copy(ruleDef)
									ruleDefDuplicate.setName(dupRuleName)
									duplicatedRules.rules.add(ruleDefDuplicate)
									processedRules.add(ruleDefDuplicate)
									logger.info("created duplicate rule: " + ruleDefDuplicate.getName())
								}
								
								// does not matter which duplicated rule as they are identified only by their name (which is the same)
								this.duplicatedRules.put(dupRuleName, duplicatedRules);
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
				
					processAllRulesWithSameName(rule, metaClass, ruleStack);
				}
			}
			ExtensionDefinition: {
				tslRule.getRhs().add(createNonTerminal(type));
			}
		}
	}
	
	private def dispatch void processRhsExpr(PropertyBindingExpr rhsExpr, SimpleRule tslRule, EClass metaClass, Stack<TsRule> ruleStack) {
		rhsExpr.propertyType.processPropertyType(tslRule, rhsExpr, metaClass, ruleStack)
	}
	
	private def dispatch void processPropertyType(IntPropertyType propertyType, SimpleRule tslRule, PropertyBindingExpr bindingExpr, EClass metaClass, Stack<TsRule> ruleStack) {
		val nonTerminal = createNonTerminal_for_PrimitivePropertyBinding(bindingExpr, EcorePackage.Literals.EINT, "INTEGER", metaClass);
		tslRule.getRhs().add(nonTerminal);
	}

	private def dispatch void processPropertyType(StringPropertyType propertyType, SimpleRule tslRule, PropertyBindingExpr bindingExpr, EClass metaClass, Stack<TsRule> ruleStack) {
		val nonTerminal = createNonTerminal_for_PrimitivePropertyBinding(bindingExpr, EcorePackage.Literals.ESTRING, "STRINGDEF", metaClass);
		tslRule.getRhs().add(nonTerminal);
	}

	private def dispatch void processPropertyType(IdPropertyType propertyType, SimpleRule tslRule, PropertyBindingExpr bindingExpr, EClass metaClass, Stack<TsRule> ruleStack) {
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
	
	private def dispatch void processPropertyType(ReferencePropertyType propertyType, SimpleRule tslRule, PropertyBindingExpr bindingExpr, EClass metaClass, Stack<TsRule> ruleStack) {
		if (propertyType.isRawReference()) {
			tslRule.getRhs().add(createNonTerminal_for_RawReferencePropertyBinding(bindingExpr, propertyType.getType(), metaClass));
		}
		else {
			tslRule.getRhs().add(createNonTerminal_for_ReferencePropertyBinding(bindingExpr, propertyType, metaClass));
		}
	}

	private def dispatch void processPropertyType(CompositePropertyType propertyType, SimpleRule tslRule, PropertyBindingExpr bindingExpr, EClass metaClass, Stack<TsRule> ruleStack) {
		tslRule.getRhs().add(createNonTerminal_for_CompositePropertyBinding(bindingExpr, propertyType, metaClass));
		
		if (propertyType.type instanceof TsRule) {
			processAllRulesWithSameName(propertyType.type as TsRule, null, ruleStack);
		}
	}
	
	private def NonTerminal createNonTerminal_for_RawReferencePropertyBinding(PropertyBindingExpr bindingExpr, LanguageConstructClassifier type, EClass metaClass) {
		val reference = createReference(bindingExpr.getName(), metaClass);
		reference.setContainment(false);
		
		val bindingMetaClass = type.metaClass;
		reference.setEType(bindingMetaClass);
		
		val propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();

		val propertyBinding = TslFactory.eINSTANCE.createReferenceBinding();
		propertyBinding.setProperty(reference);
		propertyNonTerminal.setPropertyBinding(propertyBinding);

		val refNonTerminalName = type.syntaxRuleName + "Ref";
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
	
	private def NonTerminal createNonTerminal_for_ReferencePropertyBinding(PropertyBindingExpr bindingExpr, ReferencePropertyType type, EClass metaClass) {
		val reference = createReference(bindingExpr.getName(), metaClass);
		reference.setLowerBound(0);
		reference.setUpperBound(1);

		reference.setContainment(true); // because the IdExpr is contained	
		
		val propertyType = DblPackage.Literals.ID_EXPR;

		val propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
		propertyNonTerminal.setName("IdExpr");
		
		if (reference.getEType() == null) {
			reference.setEType(propertyType);
		}
		// else: the property is inherited -> use its defined type
		
		val propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
		propertyBinding.setProperty(reference);
		propertyNonTerminal.setPropertyBinding(propertyBinding);			
		
		return propertyNonTerminal;
	}
	
	private def NonTerminal createNonTerminal_for_CompositePropertyBinding(PropertyBindingExpr bindingExpr, CompositePropertyType propertyType, EClass metaClass) {

		val property = createReference(bindingExpr.getName(), metaClass);
		property.setLowerBound(0);
		property.setUpperBound(1);

		property.setContainment(true);	
		
		val propertyNonTerminal = createNonTerminal(propertyType.type);
		if (propertyType.list) {
			property.setUpperBound(-1);
		}
		
		val bindingMetaClass = getMetaClass(propertyType.type);

		if (property.getEType() == null) {
			property.setEType(bindingMetaClass);
		}
		// else: the property is inherited -> use its defined type
		
		val propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
		propertyBinding.setProperty(property);
		propertyNonTerminal.setPropertyBinding(propertyBinding);			
		
		return propertyNonTerminal;
	}
	
	private def NonTerminal createNonTerminal_for_PrimitivePropertyBinding(PropertyBindingExpr bindingExpr, EDataType propertyType,
		String tslValueTypeName, EClass metaClass
	) {
		val metaClassAttribute = createAttribute(bindingExpr.getName(), metaClass);
		metaClassAttribute.setEType(propertyType);
		
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
	
	private def EReference createReference(String name, EClass metaClass) {
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

	private def void processSingleRule(TsRule newRule, EClass passedDownMetaClass, Stack<TsRule> ruleStack) {			
		if (!ruleStack.contains(newRule)) {
			processedRules.add(newRule);
			
			ruleStack.push(newRule);
			logger.info("processing rule " + newRule.getName());
			
			val tslRule = newRule.createTslRule;
			
			var EClass bindingMetaClass = passedDownMetaClass;
			if (bindingMetaClass == null) {
				bindingMetaClass = getMetaClass(newRule);

				val metaClassBinding = TslFactory.eINSTANCE.createElementBinding();
				metaClassBinding.setMetaclass(bindingMetaClass);
				tslRule.setValueBinding(metaClassBinding);
			}
			
			val rhs = newRule.getRhs();
			
			if (rhs instanceof SequenceExpr) {
				val sequence = rhs as SequenceExpr;
				
				//sequencePartsLoop:
				for (RhsExpression sequencePart: sequence.getSequence()) {
					sequencePart.processRhsExpr(tslRule, bindingMetaClass, ruleStack)
					
					if (sequencePart instanceof PropertyBindingExpr) {
						val propertyBindingExpr = sequencePart as PropertyBindingExpr
						
						if (propertyBindingExpr.propertyType instanceof CompositePropertyType) {
							val compositePropertyType = propertyBindingExpr.propertyType as CompositePropertyType
							
							if (compositePropertyType.type instanceof TsRule) {
								processAllRulesWithSameName(compositePropertyType.type as TsRule, null, ruleStack);
							}
						}
					}
					
					if (sequencePart instanceof RhsClassifierExpr) {

					}
				}
			}
			ruleStack.pop();
		}
			
	}
	
}