package hub.sam.dmx;

import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.AfterInSet;
import hub.sam.dbl.BeforeInSet;
import hub.sam.dbl.ClassAugment;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.FindContainer;
import hub.sam.dbl.FirstInSet;
import hub.sam.dbl.ForEachStatement;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.IdResolution;
import hub.sam.dbl.Import;
import hub.sam.dbl.IncludePattern;
import hub.sam.dbl.Interface;
import hub.sam.dbl.LastInSet;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.MetaLiteral;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NamedExtensible;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.Pattern;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferableRhsType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.RhsExpression;
import hub.sam.dbl.RuleExpr;
import hub.sam.dbl.SequenceExpr;
import hub.sam.dbl.StartCodeBlock;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StructuredPropertyType;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.TextualSyntaxDef;
import hub.sam.dbl.TsRule;
import hub.sam.dbl.TypeLiteral;
import hub.sam.dbl.TypedElement;
import hub.sam.dbl.Variable;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.util.MyIterable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public class DblIdentificationScheme extends DefaultIdentificationScheme {
	
	//private DblTextEditor editor;
	private IPreProcessedDocument preProcessedDocument;
	
	public DblIdentificationScheme(IPreProcessedDocument preProcessedDocument) {
		this.preProcessedDocument = preProcessedDocument;
	}

	// returns all the objects that the given identifier identifies in the given context
	@Override
	public Object[] getGlobalIdentities(Object identifier, EObject context, EClassifier type) {
		Collection<Object> allIds = new HashSet<Object>();
		
		if (identifier instanceof NamedElement) {
			NamedElement namedElementId = (NamedElement) identifier;
			
			if (context instanceof IdExpr) {
				IdExpr idExpr = (IdExpr) context;		

				Clazz containerClass = getContainerObjectOfType(context, Clazz.class);
				Module containerModule = (Module) getContainerObjectOfType(context, DblPackage.Literals.MODULE);
				
				if (idExpr.getArguments() != null) {
					// procedure or type in create object expression ...
					
					if (idExpr.getParentIdExpr() == null) {
						boolean otherIdsHidden = false;
	
						// TODO method overloading is missing
						
						// add methods and augmented methods
						if (containerClass != null) {
							otherIdsHidden = addIds(namedElementId, containerClass.getMethods(), allIds);
							if (containerModule != null) {
								otherIdsHidden |= addIdsForAugmentedMethods(containerClass, containerModule, namedElementId, allIds);
							}
						}
						
						// add inherited methods
						if (!otherIdsHidden && containerClass != null) {
							otherIdsHidden |= addIdsForInheritedMethods(containerClass, namedElementId, allIds);
						}
						
						// add global procedures
						if (!otherIdsHidden && containerModule != null) {
							otherIdsHidden = addIds(namedElementId, containerModule.getProcedures(), allIds);
						}
						
						// ---> try to find a Type now ...
						
						if (containerModule != null) {
							otherIdsHidden = addIds(namedElementId, containerModule.getClassifiers(), allIds);
						}
					}
					else if (hasSelfAsParent(idExpr) && containerClass != null) {
						addIds(namedElementId, containerClass.getMethods(), allIds);
						if (containerModule != null) {
							addIdsForAugmentedMethods(containerClass, containerModule, namedElementId, allIds);
						}
					}
					else if (hasSuperAsParent(idExpr) && containerClass != null) {
						addIdsForInheritedMethods(containerClass, namedElementId, allIds);
					}
					else if (hasMetaAsParent(idExpr)) {
						NamedElement metaOfElement = idExpr.getParentIdExpr().getParentIdExpr().getReferencedElement();
						String metaElementName = metaOfElement.eClass().getName();
						System.out.println("meta-object: " + metaElementName + " " + metaOfElement.getName());
						Classifier eClass = findImportedClassifier((Model) containerModule.eContainer(), metaElementName);
						if (eClass != null) {
							addIdsForMethods(eClass, namedElementId, allIds);
						}
					}
					else if (hasTypeAsParent(idExpr)) {
						NamedElement typeOfElement = idExpr.getParentIdExpr().getParentIdExpr().getReferencedElement();
						if (typeOfElement instanceof TypedElement) {
							TypedElement typeOfTypedElement = (TypedElement) typeOfElement;
							String metaTypeName = null;
							String typeName = "";
							// FIXME
//							if (typeOfTypedElement.getClassifierType() != null) {
//								metaTypeName = typeOfTypedElement.getClassifierType().eClass().getName();
//								typeName = typeOfTypedElement.getClassifierType().getName();
//							}
//							else if (typeOfTypedElement.getPrimitiveType() != null) {
//								metaTypeName = typeOfTypedElement.getPrimitiveType().eClass().getName();
//								typeName = metaTypeName;
//							}
//							else if (typeOfTypedElement.isIsList()) {
//								metaTypeName = typeOfTypedElement.getClassifierType().eClass().getName();
//								typeName = metaTypeName;
//							}
							System.out.println("type-object: " + metaTypeName + " " + typeName);
							Classifier eClass = findImportedClassifier((Model) containerModule.eContainer(), metaTypeName);
							if (eClass != null) {
								addIdsForMethods(eClass, namedElementId, allIds);
							}
						}
					}
					else {
						IdExpr parentIdExpr = idExpr.getParentIdExpr();
						
						NamedElement referencedParentElement = parentIdExpr.getReferencedElement();
						if (referencedParentElement != null) {
							if (referencedParentElement instanceof AbstractVariable
									|| referencedParentElement instanceof Procedure) {
								TypedElement referencedParentTypedElement = (TypedElement) referencedParentElement;
								if (!referencedParentTypedElement.isIsList()) {
									addIdsForMethods(referencedParentTypedElement.getClassifierTypeExpr(), namedElementId, allIds);
								}
							}
							else if (referencedParentElement instanceof Classifier) {
								Classifier parentClassifier = (Classifier) referencedParentElement;
								addIdsForClassMethods(parentClassifier, namedElementId, allIds);
							}
							else if (referencedParentElement instanceof PropertyBindingExpr) {
								System.out.println("parent is property binding: " + referencedParentElement.getName());
								// TODO
								PropertyBindingExpr parentPropertyBinding = (PropertyBindingExpr) referencedParentElement;
								PropertyType propertyType = parentPropertyBinding.getPropertyType();
								ReferableRhsType rhsType = null;
								
								if (propertyType instanceof CompositePropertyType) {
									CompositePropertyType compositePropertyType = (CompositePropertyType) propertyType;
									rhsType = compositePropertyType.getType();
								}
								else if (propertyType instanceof ReferencePropertyType) {
									ReferencePropertyType referencePropertyType = (ReferencePropertyType) propertyType;
									rhsType = referencePropertyType.getType();
								}
								
								if (rhsType != null && rhsType instanceof Classifier) {
									Classifier classifierRhsType = (Classifier) rhsType;
									addIdsForMethods(classifierRhsType, namedElementId, allIds);
								}
							}
						}
						
						// predefinedMember, e.g. xs.first.a
						PredefinedId predefinedId = parentIdExpr.getPredefinedId();
						if (predefinedId != null) {
							if (predefinedId instanceof BeforeInSet || predefinedId instanceof AfterInSet
									|| predefinedId instanceof FirstInSet || predefinedId instanceof LastInSet) {
								// the type of the set operators parent determines what IDs are accessible
								IdExpr parentOfPredefined = idExpr.getParentIdExpr().getParentIdExpr();
								if (parentOfPredefined.getReferencedElement() != null) {
									NamedElement element = parentOfPredefined.getReferencedElement();
									if (element instanceof TypedElement) {
										TypedElement typedElement = (TypedElement) element;
										addIdsForMethods(typedElement.getClassifierTypeExpr(), namedElementId, allIds);
									}
								}
							}
						}
					}
				}
				else {
					// id could identify a Variable or a Type
					
					if (idExpr.getParentIdExpr() == null) {
						boolean otherIdsHidden = false;
						
						// ---> try to find a Variable first ...
						
						// add local variables
						otherIdsHidden = addIdsForLocalVariables(idExpr, namedElementId, allIds);
						
						// add parameters
						Procedure containerProcedure = getContainerObjectOfType(context, Procedure.class);
						if (containerProcedure != null) {
							otherIdsHidden |= addIds(namedElementId, containerProcedure.getParameters(), allIds);
						}
						
						// add constructor parameters for initial parts
						StartCodeBlock startCodeBlock = getContainerObjectOfType(context, StartCodeBlock.class);
						if (startCodeBlock != null && containerClass != null && containerClass.getInitialBlock() != null
								&& containerClass.getInitialBlock().equals(startCodeBlock)
								&& containerClass.getConstructor() != null) {
							otherIdsHidden |= addIds(namedElementId, containerClass.getConstructor().getParameters(), allIds);
						}
						
						Expression expr = getContainerObjectOfType(context, Expression.class);
						if (expr != null && containerClass != null && containerClass.getConstructor() != null
								&& containerClass.getBaseConstructorArguments().contains(expr)) {
							otherIdsHidden |= addIds(namedElementId, containerClass.getConstructor().getParameters(), allIds);
						}
						
						// add attributes and augmented attributes
						if (!otherIdsHidden && containerClass != null) {
							otherIdsHidden = addIds(namedElementId, containerClass.getAttributes(), allIds);
							if (containerModule != null) {
								otherIdsHidden |= addIdsForAugmentedAttributes(containerClass, containerModule, namedElementId, allIds);
							}
						}
						
						// add inherited attributes
						if (!otherIdsHidden && containerClass != null) {
							otherIdsHidden |= addIdsForInheritedAttributes(containerClass, namedElementId, allIds);
						}
						
						// add global variables
						if (!otherIdsHidden && containerModule != null) {
							otherIdsHidden = addIds(namedElementId, containerModule.getVariables(), allIds);
						}
						
						// ---> try to find a Type now ...
						
						if (!otherIdsHidden && containerModule != null) {
							otherIdsHidden |= addIds(namedElementId, containerModule.getClassifiers(), allIds);
						}
						
						// idres ...
						addIdsForIdResolution(idExpr, namedElementId, allIds);
						
						// extension definitions
						ExtensionDefinition extDef = getContainerObjectOfType(idExpr, ExtensionDefinition.class);
						if (!otherIdsHidden && extDef != null) {
							TsRule firstRule = extDef.getTextualSyntaxDef().getNewRules().get(0);
							
							// add all properties that are accessible from the first rule
							Stack<TsRule> ruleStack = new Stack<TsRule>();
							ruleStack.push(firstRule);
							addIdsForRhsExpressionsTree(firstRule.getRhs(), ruleStack, namedElementId, allIds);
							ruleStack.pop();
							
							// add types of assigned rules
							addId(namedElementId, extDef.getTextualSyntaxDef().getExtensionRule().getFirstNewRule().getRule(), allIds);
							for (TsRule rule: extDef.getTextualSyntaxDef().getNewRules()) {
								addIdsForAssignedRules(rule.getRhs(), namedElementId, allIds);
								
								// also add types of indirectly assigned rules, e.g. in "M -> a:A; A -> B; B -> x:X;" the rule B is indirectly an assigned rule
								TsRule directReductionTarget = checkForDirectReductionToOtherRule(rule);
								if (directReductionTarget != null) {
									addId(namedElementId, directReductionTarget, allIds);
								}
							}
						}
						
						// identifiers used in extensions are provided at a global scope by default
						if (checkIfUsedInsideExtensionInstance(idExpr)) {
							addPlainNames(namedElementId.getName(), context, allIds);
						}
						
						// imported types
						if (containerModule.eContainer() instanceof Model) {
							Model model = (Model) containerModule.eContainer();
							if (!otherIdsHidden) {
								otherIdsHidden = addIdsForImports(model, namedElementId.getName(), allIds);
							}
						}
					}
					else if (hasSelfAsParent(idExpr) && containerClass != null) {
						addIds(namedElementId, containerClass.getAttributes(), allIds);
						if (containerModule != null) {
							addIdsForAugmentedAttributes(containerClass, containerModule, namedElementId, allIds);
						}
					}
					else if (hasSuperAsParent(idExpr) && containerClass != null) {
						addIdsForInheritedAttributes(containerClass, namedElementId, allIds);
					}
					else if (hasMetaAsParent(idExpr)) {
						Classifier eClass = findImportedClassifier((Model) containerModule.eContainer(), "EClass");
						if (eClass != null) {
							addIdsForAttributes(eClass, namedElementId, allIds);
						}
					}
					else {
						IdExpr parentIdExpr = idExpr.getParentIdExpr();
						
						NamedElement referencedParentElement = parentIdExpr.getReferencedElement();
						if (referencedParentElement != null) {
							if (referencedParentElement instanceof AbstractVariable) {
								AbstractVariable parentVariable = (AbstractVariable) referencedParentElement;
								addIdsForPropertiesOfTypedElementType(parentVariable, namedElementId, allIds);
							}
							else if (referencedParentElement instanceof Procedure) {
								Procedure parentProcedure = (Procedure) referencedParentElement;
								addIdsForPropertiesOfTypedElementType(parentProcedure, namedElementId, allIds);
							}
							else if (referencedParentElement instanceof Classifier) {
								Classifier parentClassifier = (Classifier) referencedParentElement;
								addIdsForClassAttributes(parentClassifier, namedElementId, allIds);
							}
							else if (referencedParentElement instanceof PropertyBindingExpr) {
								PropertyBindingExpr parentPropertyBinding = (PropertyBindingExpr) referencedParentElement;
								PropertyType parentPropertyType = parentPropertyBinding.getPropertyType();
								if (parentPropertyType instanceof StructuredPropertyType) {
									StructuredPropertyType structuredParentPropertyType = (StructuredPropertyType) parentPropertyType;
									addIdsForPropertiesOfReferableRhsType(structuredParentPropertyType.getType(), namedElementId, allIds);
								}
							}
							else {
								System.out.println("unknown parent element: " + referencedParentElement.getName());
							}
						}
						
						// parent is a predefinedMember, e.g. xs.first.a
						PredefinedId predefinedMember = parentIdExpr.getPredefinedId();
						if (predefinedMember != null) {
							if (predefinedMember instanceof FirstInSet || predefinedMember instanceof LastInSet) {
								// the type of the set operators parent determines what IDs are accessible
								IdExpr parentOfPredefined = idExpr.getParentIdExpr().getParentIdExpr();
								if (parentOfPredefined.getReferencedElement() != null) {
									NamedElement element = parentOfPredefined.getReferencedElement();
									if (element instanceof TypedElement) {
										TypedElement typedElement = (TypedElement) element;
										addIdsForPropertiesOfTypedElementType(typedElement, namedElementId, allIds);
									}
								}
							}
						}
					}
							
				}
				
				//if (allIds.isEmpty()) {
				//	return super.getGlobalIdentities(identifier, context, type);
				//}
				
			}
			else if (context instanceof ReferencePropertyType || context instanceof CompositePropertyType) {
				Module containerModule = getContainerObjectOfType(context, Module.class);
				if (containerModule != null) {
					addIds(namedElementId, containerModule.getClassifiers(), allIds);
					if (containerModule.getIdRes() != null) {
						addIds(namedElementId, containerModule.getIdRes().getPatterns(), allIds);
					}
				}				
			}
			else if (context instanceof RuleExpr) {
				addIdsForTsRules(context, namedElementId.getName(), allIds);
			}
			else if (identifier instanceof Pattern) {
				addIdsForIdResolution(context, namedElementId, allIds);
			}
			else if (identifier instanceof Classifier) {
				addIdsForClassifiers(context, namedElementId.getName(), allIds);
			}
			else if (identifier instanceof Variable) {
				// TODO extract and include variable resolution from above here
				Statement stm = getContainerObjectOfType(context, Statement.class);
				addIdsForLocalVariables(stm, namedElementId, allIds);
			}
			else if (context instanceof Statement && identifier instanceof Variable) {
				// TODO just testing here
				Statement stm = (Statement) context;
				addIdsForLocalVariables(stm, namedElementId, allIds);
			}
			else if (namedElementId.eClass().getName().equals("Vertex")
					|| namedElementId.eClass().getName().equals("L2")
					|| namedElementId.eClass().getName().equals("EventDecl")
					|| namedElementId.eClass().getName().equals("Foo")) {
				// TODO just for making the SML example work
				addPlainNames(namedElementId.getName(), context, allIds);
			}
			else if (context instanceof NamedExtensible) {
				addPlainNames(namedElementId.getName(), context, allIds);
			}

			//if (allIds.isEmpty()) {
			//	addPlainNames(namedElementId.getName(), context, allIds);
			//}
		}
		else if (identifier instanceof String
				&& (type.getName().equals("Clazz") || type.getName().equals("Interface") || type.getName().equals("Classifier"))
				|| type instanceof Classifier) {
			
			addIdsForClassifiers(context, (String) identifier, allIds);
		}
		else if (identifier instanceof String && (type.getName().equals("ReferableRhsType") || type instanceof ReferableRhsType)) {
			addIdsForTsRules(context, (String) identifier, allIds);
			addIdsForClassifiers(context, (String) identifier, allIds);
		}

		// TODO adding plain names must be specified explicitly in language extensions
		if (identifier instanceof String && allIds.isEmpty()) {
			addPlainNames((String) identifier, context, allIds);
		}
		
		if (allIds.size() > 1) {
			System.out.println("identified more than one object");
		}

		if (!allIds.isEmpty()) {
			return allIds.toArray();
		}
		
//		if (identifier.equals("IdExpr")) {
//			System.out.println("bla");
//		}
		return super.getGlobalIdentities(identifier, context, type);
	}
	
	private void addIdsForMethods(IdExpr classifierTypeExpr, NamedElement namedElementId, Collection<Object> allIds) {
		if (classifierTypeExpr != null) {
			NamedElement type = classifierTypeExpr.getReferencedElement();
			if (type instanceof Classifier) {
				Classifier classifier = (Classifier) type;
				addIdsForMethods(classifier, namedElementId, allIds);
			}
		}
	}

	private void addIdsForPropertiesOfTypedElementType(TypedElement typedElement, NamedElement namedElementId, Collection<Object> allIds) {
		if (!typedElement.isIsList()) {
			if (typedElement.getClassifierTypeExpr() != null) {
				NamedElement type = typedElement.getClassifierTypeExpr().getReferencedElement();
				if (type instanceof ReferableRhsType) { // includes Classifiers and TsRules
					ReferableRhsType parentElementReferableRhsType = (ReferableRhsType) type;
					addIdsForPropertiesOfReferableRhsType(parentElementReferableRhsType, namedElementId, allIds);
				}
			}
		}
	}

	private boolean addIdsForPropertiesOfReferableRhsType(ReferableRhsType type, NamedElement namedElementId,
			Collection<Object> allIds) {
		if (type instanceof Clazz) {
			Clazz clazz = (Clazz) type;
			return addIdsForAttributes(clazz, namedElementId, allIds);
		}
		else if (type instanceof TsRule) {
			TsRule entryRule = (TsRule) type;
			boolean idsAdded = false;
			for (TsRule rule: getAllTsRules(entryRule)) {
				Stack<TsRule> ruleStack = new Stack<TsRule>();
				ruleStack.push(rule);
				idsAdded |= addIdsForRhsExpressionsTree(rule.getRhs(), ruleStack, namedElementId, allIds);
				ruleStack.pop();
			}
			return idsAdded;
		}
		return false;
	}
	
	/**
	 * Collects all TS rules that have the same name as the given TS rule.
	 * 
	 * @param tsRule
	 * @return
	 */
	private Collection<TsRule> getAllTsRules(TsRule tsRule) {
		Collection<TsRule> rules = new HashSet<TsRule>();
		rules.add(tsRule);
		for (TsRule otherTsRule: ((TextualSyntaxDef) tsRule.eContainer()).getNewRules()) {
			if (otherTsRule.getName().equals(tsRule.getName())) {
				rules.add(otherTsRule);
			}
		}
		return rules;
	}

	private EList<PropertyBindingExpr> getPropertyBindings(TsRule tsRule) {
		EList<PropertyBindingExpr> definedProperties = new BasicEList<PropertyBindingExpr>();
		collectPropertyBindings(tsRule.getRhs(), definedProperties);
		return definedProperties;
	}

	private void collectPropertyBindings(RhsExpression expr, EList<PropertyBindingExpr> definedProperties) {
		if (expr instanceof PropertyBindingExpr) {
			PropertyBindingExpr bindingExpr = (PropertyBindingExpr) expr;
			definedProperties.add(bindingExpr);
			return;
		}
		if (expr instanceof RuleExpr) {
			RuleExpr ruleExpr = (RuleExpr) expr;
			collectPropertyBindings(ruleExpr, definedProperties);
		}
		else {
			for (EObject content: expr.eContents()) {
				if (content instanceof RhsExpression) {
					RhsExpression subExpr = (RhsExpression) content;
					collectPropertyBindings(subExpr, definedProperties);
				}
			}
		}
	}

	private void addIdsForAssignedRules(RhsExpression expr, NamedElement namedElementId, Collection<Object> allIds) {
		if (expr instanceof PropertyBindingExpr) {
			PropertyBindingExpr bindingExpr = (PropertyBindingExpr) expr;
			PropertyType bindingType = bindingExpr.getPropertyType();
			if (bindingType instanceof StructuredPropertyType) {
				StructuredPropertyType structuredBindingType = (StructuredPropertyType) bindingType;
				addId(namedElementId, structuredBindingType.getType(), allIds);
			}
		}
		else {
			for (EObject content: expr.eContents()) {
				if (content instanceof RhsExpression) {
					RhsExpression subExpr = (RhsExpression) content;
					addIdsForAssignedRules(subExpr, namedElementId, allIds);
				}
			}
		}
	}
	
	/**
	 * If the given rule directly reduces to a single other rule, the other rule is returned.
	 * Example: If invoked for the rule A in "A -> B; B -> x:X;", the rule B is returned.
	 * @param tsRule
	 * @return
	 */
	private TsRule checkForDirectReductionToOtherRule(TsRule tsRule) {
		RhsExpression expr = tsRule.getRhs();
		if (expr instanceof SequenceExpr) {
			SequenceExpr seqExpr = (SequenceExpr) expr;
			if (seqExpr.getSequence().size() == 1) {
				RhsExpression firstExpr =seqExpr.getSequence().get(0);
				if (firstExpr instanceof RuleExpr) {
					RuleExpr ruleExpr = (RuleExpr) firstExpr;
					return ruleExpr.getRule();
				}
			}
		}
		return null;
	}

	private void addPlainNames(String identifier, EObject context, Collection<Object> allIds) {
		MyIterable<EObject> allObjects = new MyIterable<EObject>(context.eResource().getAllContents());
		for (EObject obj: allObjects) {
			if (obj instanceof NamedElement) {
				Object nameValue = obj.eGet(DblPackage.Literals.NAMED_ELEMENT__NAME);
				if (nameValue != null && ((String) nameValue).equals(identifier)) {
					allIds.add(getIdentitiy((NamedElement) obj));
				}
			}
		}
	}
	
	private void addIdsForIdResolution(EObject context, NamedElement identifier, Collection<Object> allIds) {
		IdResolution idRes = getContainerObjectOfType(context, IdResolution.class);
		if (idRes != null) {
			Pattern pattern = getContainerObjectOfType(context, Pattern.class);
			if (pattern != null) {
				addId(identifier, pattern.getContext(), allIds);
			}
			
			addIdsForParentContainers(context, identifier, allIds);
			
			IncludePattern include = getContainerObjectOfType(context, IncludePattern.class);
			if (include != null) {
				addIds(identifier, idRes.getPatterns(), allIds);
			}
		}		
	}

	private void addIdsForTsRules(EObject context, String identifier, Collection<Object> allIds) {
		ExtensionDefinition extensionDef = getContainerObjectOfType(context, ExtensionDefinition.class);
		if (extensionDef != null) {
			addIds(identifier, extensionDef.getTextualSyntaxDef().getNewRules(), allIds);
			if (allIds.size() > 1) {
				Object first = allIds.iterator().next();
				allIds.clear();
				allIds.add(first);
			}
		}
	}
	
	private boolean addIdsForClassifiers(EObject context, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;

		Module containerModule = getContainerObjectOfType(context, Module.class);
		if (containerModule != null) {
			
			idsAdded |= addIds(identifier, containerModule.getClassifiers(), allIds);
			if (!idsAdded) {
				if (containerModule.eContainer() instanceof Model) {
					Model model = (Model) containerModule.eContainer();
					idsAdded = addIdsForImports(model, identifier, allIds);
				}
			}			
		}
		return idsAdded;
	}
	
	private boolean addIdsForImports(Model model, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;
		for (Import imprt: model.getImports()) {
			if (imprt.getModel() != null) {
				for (Module importedModule: imprt.getModel().getModules()) {
					idsAdded |= addIds(identifier, importedModule.getClassifiers(), allIds);
				}
				if (!idsAdded) {
					idsAdded = addIdsForImports(imprt.getModel(), identifier, allIds);
				}
			}
		}
		return idsAdded;
	}
	
	private Classifier findImportedClassifier(Model model, String classifierName) {
		for (Import imprt: model.getImports()) {
			if (imprt.getModel() != null) {
				for (Module importedModule: imprt.getModel().getModules()) {
					for (Classifier classifier: importedModule.getClassifiers()) {
						if (classifier.getName().equals(classifierName)) {
							return classifier;
						}
					}
				}
				return findImportedClassifier(imprt.getModel(), classifierName);
			}
		}
		return null;
	}
	
	private boolean addIdsForRhsExpressionsTree(RhsExpression expr, Stack<TsRule> ruleStack, NamedElement eObjectId, Collection<Object> allIds) {
		if (expr instanceof PropertyBindingExpr) {
			PropertyBindingExpr bindingExpr = (PropertyBindingExpr) expr;
			return addId(eObjectId, bindingExpr, allIds);
		}
		else if (expr instanceof RuleExpr) {
			RuleExpr ruleExpr = (RuleExpr) expr;
			TsRule entryRule = ruleExpr.getRule();
			boolean idsAdded = false;
			for (TsRule rule: getAllTsRules(entryRule)) {
				if (!ruleStack.contains(rule)) { // prevents endless recursion
					RhsExpression rhsExpr = rule.getRhs();
					ruleStack.push(rule);
					idsAdded |= addIdsForRhsExpressionsTree(rhsExpr, ruleStack, eObjectId, allIds);
					ruleStack.pop();
				}
			}
			return idsAdded;
		}
		else {
			boolean idsAdded = false;
			for (EObject content: expr.eContents()) {
				if (content instanceof RhsExpression) {
					RhsExpression subExpr = (RhsExpression) content;
					idsAdded |= addIdsForRhsExpressionsTree(subExpr, ruleStack, eObjectId, allIds);
				}
			}
			return idsAdded;
		}
	}

	private boolean addIdsForParentContainers(EObject context, NamedElement eObjectId, Collection allIds) {
		if (context != null) {
			FindContainer container = getContainerObjectOfType(context.eContainer(), FindContainer.class);
			if (container != null) {
				boolean idsAdded = addId(eObjectId, container.getVariableBinding(), allIds);
				idsAdded |= addIdsForParentContainers(container.eContainer(), eObjectId, allIds);
				return idsAdded;
			}
		}
		return false;
	}

	private boolean addIdsForLocalVariables(Expression expr, NamedElement eObjectId, Collection allIds) {
		Statement stm = getContainerObjectOfType(expr, Statement.class);
		if (stm != null)
			return addIdsForLocalVariables(stm, eObjectId, allIds);
		else
			return false;
	}
	
	private boolean addIdsForLocalVariables(Statement contextStatement, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		
		CodeBlock codeBlock = getContainerObjectOfType(contextStatement, CodeBlock.class);		
		if (codeBlock != null) {
			for (Statement statement: codeBlock.getStatements()) {
				if (statement == contextStatement) {
					break;
				}
				if (statement instanceof Variable) {
					Variable localVariable = (Variable) statement;
					idsAdded |= addId(eObjectId, localVariable, allIds);
				}
			}
	
			EObject codeBlockContainer = codeBlock.eContainer();
			if (codeBlockContainer instanceof ForEachStatement) {
				ForEachStatement forEachStm = (ForEachStatement) codeBlockContainer;
				if (forEachStm.getIteratorVariableDefinition() != null) {
					idsAdded |= addId(eObjectId, forEachStm.getIteratorVariableDefinition(), allIds);
				}
				else if (forEachStm.getIteratorVariableReference() != null) {
					idsAdded |= addIdsForLocalVariables(forEachStm.getIteratorVariableReference(), eObjectId, allIds);
				}
				idsAdded |= addIdsForLocalVariables(forEachStm, eObjectId, allIds);
			}
			else {
				Statement parentStatement = getContainerObjectOfType(codeBlock, Statement.class);
				if (parentStatement != null) {
					idsAdded |= addIdsForLocalVariables(parentStatement, eObjectId, allIds);
				}
			}
		}
		
		return idsAdded;
	}
	
	private EList<Variable> getClassAttributes(EList<Variable> allAttributes) {
		EList<Variable> classAttributes = new BasicEList<Variable>();
		for (Variable attr: allAttributes) {
			if (attr.isClazz()) {
				classAttributes.add(attr);
			}
		}
		return classAttributes;
	}
	
	private EList<Procedure> getClassMethods(EList<Procedure> allMethods) {
		EList<Procedure> classMethods = new BasicEList<Procedure>();
		for (Procedure method: allMethods) {
			if (method.isClazz()) {
				classMethods.add(method);
			}
		}
		return classMethods;
	}
	
	// only in same module
	private boolean addIdsForAugmentedAttributes(Clazz clazz, Module module, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		for (ClassAugment augment: module.getClassAugments()) {
			if (augment.getAugmentedClass().equals(clazz)) {
				idsAdded |= addIds(eObjectId, augment.getAttributes(), allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForAugmentedClassAttributes(Clazz clazz, Module module, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		for (ClassAugment augment: module.getClassAugments()) {
			if (augment.getAugmentedClass().equals(clazz)) {
				idsAdded |= addIds(eObjectId, getClassAttributes(augment.getAttributes()), allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForAugmentedMethods(Clazz clazz, Module module, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		for (ClassAugment augment: module.getClassAugments()) {
			if (augment.getAugmentedClass().equals(clazz)) {
				idsAdded |= addIds(eObjectId, augment.getMethods(), allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForAugmentedClassMethods(Clazz clazz, Module module, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		for (ClassAugment augment: module.getClassAugments()) {
			if (augment.getAugmentedClass().equals(clazz)) {
				idsAdded |= addIds(eObjectId, getClassMethods(augment.getMethods()), allIds);
			}
		}
		return idsAdded;
	}
	
	static interface A {
		void m();
	}
	static interface B {
		void m();
	}
	
	static class C implements A,B {
		public void m() {}
	}

	private boolean addIdsForInheritedMethods(Clazz clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		Clazz superClass = clazz.getSuperClass();
		while (superClass != null && !idsAdded) {
			idsAdded |= addIds(eObjectId, superClass.getMethods(), allIds);
			superClass = superClass.getSuperClass();
		}
		return idsAdded;
	}
	
	private boolean addIdsForInheritedMethods(Interface iface, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		for (Interface superIface: iface.getSuperInterfaces()) {
			if (!idsAdded) {
				idsAdded |= addIds(eObjectId, superIface.getMethods(), allIds);
				addIdsForInheritedMethods(superIface, eObjectId, allIds);
			}
		}
		return idsAdded;
	}
	
	private boolean addIdsForInheritedClassMethods(Clazz clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		Clazz superClass = clazz.getSuperClass();
		while (superClass != null && !idsAdded) {
			idsAdded |= addIds(eObjectId, getClassMethods(superClass.getMethods()), allIds);
			superClass = superClass.getSuperClass();
		}
		return idsAdded;
	}
	
	private boolean addIdsForInheritedAttributes(Clazz clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		Clazz superClass = clazz.getSuperClass();
		while (superClass != null && !idsAdded) {
			idsAdded |= addIds(eObjectId, superClass.getAttributes(), allIds);

			//Module containerModule = getContainerObjectOfType(superClass, Module.class);
			//idsAdded |= addIdsForAugmentedAttributes(superClass, containerModule, eObjectId, allIds);
			
			superClass = superClass.getSuperClass();
		}
		return idsAdded;
	}

	private boolean addIdsForInheritedClassAttributes(Clazz clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		Clazz superClass = clazz.getSuperClass();
		while (superClass != null && !idsAdded) {
			idsAdded |= addIds(eObjectId, getClassAttributes(superClass.getAttributes()), allIds);

			//Module containerModule = getContainerObjectOfType(superClass, Module.class);
			//idsAdded |= addIdsForAugmentedAttributes(superClass, containerModule, eObjectId, allIds);
			
			superClass = superClass.getSuperClass();
		}
		return idsAdded;
	}

	private boolean addIdsForAttributes(Classifier classifier, NamedElement identifier, Collection allIds) {
		boolean idsAdded = false;
		if (classifier instanceof Clazz) {
			Clazz clazz = (Clazz) classifier;
			
			// add attributes
			idsAdded = addIds(identifier, clazz.getAttributes(), allIds);
			
			// add augmented attributes
			Module containerModule = getContainerObjectOfType(clazz, Module.class);
			idsAdded |= addIdsForAugmentedAttributes(clazz, containerModule, identifier, allIds);

			// add inherited attributes
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedAttributes(clazz, identifier, allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForClassAttributes(Classifier classifier, NamedElement identifier, Collection allIds) {
		boolean idsAdded = false;
		if (classifier instanceof Clazz) {
			Clazz clazz = (Clazz) classifier;
			
			// add attributes
			for (Variable attr: clazz.getAttributes()) {
				if (attr.isClazz()) {
					idsAdded |= addId(identifier, attr, allIds);
				}
			}
			
			// add augmented attributes
			Module containerModule = getContainerObjectOfType(clazz, Module.class);
			idsAdded |= addIdsForAugmentedClassAttributes(clazz, containerModule, identifier, allIds);

			// add inherited attributes
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedClassAttributes(clazz, identifier, allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForMethods(Classifier classifier, NamedElement identifier, Collection allIds) {
		boolean idsAdded = false;
		if (classifier instanceof Clazz) {
			Clazz clazz = (Clazz) classifier;

			// add methods
			idsAdded = addIds(identifier, clazz.getMethods(), allIds);
			
			// add augmented methods
			Module containerModule = getContainerObjectOfType(clazz, Module.class);
			idsAdded |= addIdsForAugmentedMethods(clazz, containerModule, identifier, allIds);

			// add inherited methods
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedMethods(clazz, identifier, allIds);
			}
		}
		else if (classifier instanceof Interface) {
			Interface iface = (Interface) classifier;
			
			idsAdded = addIds(identifier, iface.getMethods(), allIds);

			if (!idsAdded) {
				idsAdded |= addIdsForInheritedMethods(iface, identifier, allIds);
			}
		}
		return idsAdded;
	}
	
	private boolean addIdsForClassMethods(Classifier classifier, NamedElement identifier, Collection allIds) {
		boolean idsAdded = false;
		if (classifier instanceof Clazz) {
			Clazz clazz = (Clazz) classifier;

			// add methods
			idsAdded = addIds(identifier, getClassMethods(clazz.getMethods()), allIds);
			
			// add augmented methods
			Module containerModule = getContainerObjectOfType(clazz, Module.class);
			idsAdded |= addIdsForAugmentedClassMethods(clazz, containerModule, identifier, allIds);

			// add inherited methods
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedClassMethods(clazz, identifier, allIds);
			}
		}
		return idsAdded;
	}
	
	private EObject getContainerObjectOfType(EObject obj, EClass type) {
		if (obj.eClass().equals(type) || obj.eClass().getEAllSuperTypes().contains(type)) return obj;
		else if (obj.eContainer() == null) return null;
		else return getContainerObjectOfType(obj.eContainer(), type);
	}
	
	private boolean checkIfUsedInsideExtensionInstance(EObject object) {
		if (object instanceof ExtensibleElement && ((ExtensibleElement) object).isObjectIsExtensionInstance()) return true;
		else if (object.eContainer() != null) return checkIfUsedInsideExtensionInstance(object.eContainer());
		else return false;
	}
	
	private <T> T getContainerObjectOfType(EObject object, Class<T> type) {
		if (type.isAssignableFrom(object.getClass())) return (T) object;
		else if (object.eContainer() == null) return null;
		else return getContainerObjectOfType(object.eContainer(), type);
		
		//if (object.eContainer() == null) return null;
		//else if (type.isAssignableFrom(object.eContainer().getClass())) return (T) object.eContainer();
		//else return getContainerObjectOfType(object.eContainer(), type);
	}
	
	private <E extends NamedElement> boolean addIds(String identifier, EList<E> objects, Collection allIds) {
		boolean idsAdded = false;
		for (Object obj: objects) {
			NamedElement namedElement = (NamedElement) obj;
			if (namedElement.getName() != null && namedElement.getName().equals(identifier)) {
				allIds.add(getIdentitiy((EObject) obj));
				idsAdded = true;
			}
		}
		return idsAdded;
	}

	private <E extends NamedElement> boolean addIds(NamedElement identifier, EList<E> objects, Collection allIds) {
		return addIds(identifier.getName(), objects, allIds);
	}
	
	private <E extends NamedElement> boolean addId(NamedElement identifier, E object, Collection allIds) {
		return addId(identifier.getName(), object, allIds);
	}
	
	private <E extends NamedElement> boolean addId(String identifier, E object, Collection allIds) {
		boolean idsAdded = false;
		if (((NamedElement) object).getName().equals(identifier)) {
			allIds.add(getIdentitiy((EObject) object));
			idsAdded = true;
		}
		return idsAdded;
	}
	
	private boolean hasSelfAsParent(IdExpr idExpr) {
		if (idExpr.getParentIdExpr() != null) {
			if (idExpr.getParentIdExpr().getPredefinedId() instanceof MeLiteral) return true;
		}
		return false;
	}
	
	private boolean hasSuperAsParent(IdExpr idExpr) {
		if (idExpr.getParentIdExpr() != null) {
			if (idExpr.getParentIdExpr().getPredefinedId() instanceof SuperLiteral) return true;
		}
		return false;
	}
	
	private boolean hasMetaAsParent(IdExpr idExpr) {
		if (idExpr.getParentIdExpr() != null) {
			if (idExpr.getParentIdExpr().getPredefinedId() instanceof MetaLiteral) return true;
		}
		return false;
	}
	
	private boolean hasTypeAsParent(IdExpr idExpr) {
		if (idExpr.getParentIdExpr() != null) {
			if (idExpr.getParentIdExpr().getPredefinedId() instanceof TypeLiteral) return true;
		}
		return false;
	}
	
	private EObject getNamespace(EObject object) {
		EObject container = object.eContainer();
		if (container instanceof Procedure || container instanceof Clazz) return container;
		else return getNamespace(container);
	}

	// computes the global ID of an object
	// e.g. Module_Test.Class_X.Procedure_m.LocalVariable_n
	// e.g. Module_Test.Class_X.Procedure_m.Parameter_n
	@Override
	public Object getIdentitiy(EObject object) {
//		if (object instanceof Procedure || object instanceof Parameter || object instanceof Variable
//				) {
			return getQualifiedId(object);
//		}
//		return super.getIdentitiy(object);
	}
	
	private String getQualifiedId(EObject object) {
		String result;
		if (object.eResource() == null || object.eResource().getURI() == null
				|| object.eResource() == preProcessedDocument.getCurrentModel()) {
			result = object.eResource().getURIFragment(object);
		}
		else {
			result = object.eResource().getURI() + object.eResource().getURIFragment(object);
		}
		//System.out.println(result);
		return result;
	}
	
	private String getQualifiedIdOld(EObject object) {
		if (object instanceof Model) {
			return "";
		}
		else if (object instanceof Module || object instanceof Clazz || object instanceof Procedure || object instanceof Parameter
				 || object instanceof Variable || object instanceof Interface) {
			NamedElement namedElement = (NamedElement) object;
			if (object instanceof Variable) {
				return getQualifiedId(object.eContainer()) + "." + object.eClass().getName() + "_"
						+ (((Variable) object).isClazz() ? "static_" : "") + namedElement.getName();
			}
			else if (object instanceof Procedure) {
				return getQualifiedId(object.eContainer()) + "." + object.eClass().getName() + "_"
						+ (((Procedure) object).isClazz() ? "static_" : "") + namedElement.getName();
			}
			else {
				return getQualifiedId(object.eContainer()) + "." + object.eClass().getName() + "_" + namedElement.getName();
			}
		}
		else {
			String id = "";
			if (object instanceof NamedElement) {
				NamedElement namedElement = (NamedElement) object;
				id = "." + object.eClass().getName() + "_" + namedElement.getName();
			}
			if (object.eContainer() != null) {
				return getQualifiedId(object.eContainer()) + id;
			}
			else {
				throw new RuntimeException();
			}
		}
	}

	@Override
	public String getLocalIdentity(EObject object, EObject context) {
		// TODO Auto-generated method stub
		return super.getLocalIdentity(object, context);
	}

}
