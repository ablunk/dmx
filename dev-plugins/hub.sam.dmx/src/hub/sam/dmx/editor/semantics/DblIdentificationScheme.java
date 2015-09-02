package hub.sam.dmx.editor.semantics;

import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.Class;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.ExtensionSemanticsDefinition;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Import;
import hub.sam.dbl.LanguageConstructClassifier;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.MetaLiteral;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.RhsClassifierExpr;
import hub.sam.dbl.RhsExpression;
import hub.sam.dbl.SequenceExpr;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StructuredPropertyType;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.TextualSyntaxDef;
import hub.sam.dbl.TsRule;
import hub.sam.dbl.TypeLiteral;
import hub.sam.dbl.TypedElement;
import hub.sam.dbl.Variable;
import hub.sam.dmx.editor.IPreProcessedDocument;
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
import org.eclipse.emf.ecore.resource.Resource;

public class DblIdentificationScheme extends DefaultIdentificationScheme {
	
	//private DblTextEditor editor;
	private IPreProcessedDocument preProcessedDocument;
	
	public DblIdentificationScheme(IPreProcessedDocument preProcessedDocument) {
		this.preProcessedDocument = preProcessedDocument;
	}

	// returns all the objects that the given identifier identifies in the given context
	@Override
	public Object[] getGlobalIdentities(Object identifier, EObject context, EClassifier type) {
		try {
			return getGlobalIdentities_save(identifier, context, type);
		}
		catch (RuntimeException e) {
			System.out.println(e);
			return null;
		}
	}
	
	// returns all the objects that the given identifier identifies in the given context
	public Object[] getGlobalIdentities_save(Object identifier, EObject context, EClassifier type) {
		Collection<Object> allIds = new HashSet<Object>();
		
		if (identifier instanceof NamedElement) {
			NamedElement namedElementId = (NamedElement) identifier;
			
			if (context instanceof IdExpr) {
				IdExpr idExpr = (IdExpr) context;		
				Class containerClass = getContainerObjectOfType(context, Class.class);
				Module containerModule = (Module) getContainerObjectOfType(context, DblPackage.Literals.MODULE);
				Model containerModel = (Model) getContainerObjectOfType(context, DblPackage.Literals.MODEL);
				
				if (idExpr.getCallPart() != null) {
					// procedure or type in create object expression ...
					
					if (idExpr.getParentIdExpr() == null) {
						boolean otherIdsHidden = false;
	
						// TODO method overloading is missing
						
						// add methods and augmented methods
						if (containerClass != null) {
							for (Function method: containerClass.getMethods()) {
								if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
									otherIdsHidden = addId(namedElementId, method, allIds);
								}
							}
						}
						
						// add inherited methods
						if (!otherIdsHidden && containerClass != null) {
							otherIdsHidden |= addIdsForInheritedMethods(containerClass, namedElementId, allIds, idExpr);
						}
						
						// add global procedures (also imported ones)
						if (!otherIdsHidden) {
							otherIdsHidden = addIdsForGlobalProcedures(containerModel, namedElementId, allIds, idExpr);
						}
						
						// ---> try to find a Type now ...
						
						if (containerModule != null) {
							otherIdsHidden = addIds(namedElementId, containerModule.getClasses(), allIds);
						}
					}
					else if (hasSelfAsParent(idExpr) && containerClass != null) {
						addIds(namedElementId, containerClass.getMethods(), allIds);
					}
					else if (hasSuperAsParent(idExpr) && containerClass != null) {
						addIdsForInheritedMethods(containerClass, namedElementId, allIds, idExpr);
					}
					else if (hasMetaAsParent(idExpr)) {
						NamedElement metaOfElement = idExpr.getParentIdExpr().getParentIdExpr().getReferencedElement();
						String metaElementName = metaOfElement.eClass().getName();
						System.out.println("meta-object: " + metaElementName + " " + metaOfElement.getName());
						Class eClass = findImportedClass((Model) containerModule.eContainer(), metaElementName);
						if (eClass != null) {
							addIdsForMethods(eClass, namedElementId, allIds, idExpr);
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
							Class eClass = findImportedClass((Model) containerModule.eContainer(), metaTypeName);
							if (eClass != null) {
								addIdsForMethods(eClass, namedElementId, allIds, idExpr);
							}
						}
					}
					else {
						IdExpr parentIdExpr = idExpr.getParentIdExpr();
						
						NamedElement referencedParentElement = parentIdExpr.getReferencedElement();
						if (referencedParentElement != null) {
							if (referencedParentElement instanceof AbstractVariable
									|| referencedParentElement instanceof Function) {
								TypedElement referencedParentTypedElement = (TypedElement) referencedParentElement;
								if (referencedParentTypedElement.getClassifierType() != null) {
									addIdsForMethods(referencedParentTypedElement.getClassifierType(), namedElementId, allIds, idExpr);
								}
							}
							else if (referencedParentElement instanceof Class) {
								Class parentClassifier = (Class) referencedParentElement;
								addIdsForClassMethods(parentClassifier, namedElementId, allIds, idExpr);
							}
							else if (referencedParentElement instanceof PropertyBindingExpr) {
								System.out.println("parent is property binding: " + referencedParentElement.getName());

								PropertyBindingExpr parentPropertyBinding = (PropertyBindingExpr) referencedParentElement;
								PropertyType propertyType = parentPropertyBinding.getPropertyType();
								LanguageConstructClassifier langClassifier = null;
								
								if (propertyType instanceof CompositePropertyType) {
									CompositePropertyType compositePropertyType = (CompositePropertyType) propertyType;
									langClassifier = compositePropertyType.getType();
									
									if (compositePropertyType.isList()) {
										// find type stdlib.List and add its methods
										Class listClassifier = findImportedClass(containerModel, "List");
										if (listClassifier != null) {
											addIdsForMethods(listClassifier, namedElementId, allIds, idExpr);
										}
									}
									else {
										if (langClassifier != null && langClassifier instanceof Class) {
											Class classifierRhsType = (Class) langClassifier;
											addIdsForMethods(classifierRhsType, namedElementId, allIds, idExpr);
										}										
									}
								}
								else if (propertyType instanceof ReferencePropertyType) {
									ReferencePropertyType referencePropertyType = (ReferencePropertyType) propertyType;
									langClassifier = referencePropertyType.getType();

									if (langClassifier != null && langClassifier instanceof Class) {
										Class classifierRhsType = (Class) langClassifier;
										addIdsForMethods(classifierRhsType, namedElementId, allIds, idExpr);
									}
								}
								
							}
						}
						
						// predefinedMember, e.g. xs.first.a
						PredefinedId predefinedId = parentIdExpr.getPredefinedId();
						if (predefinedId != null) {
//							if (predefinedId instanceof BeforeInSet || predefinedId instanceof AfterInSet
//									|| predefinedId instanceof FirstInSet || predefinedId instanceof LastInSet) {
//								// the type of the set operators parent determines what IDs are accessible
//								IdExpr parentOfPredefined = idExpr.getParentIdExpr().getParentIdExpr();
//								if (parentOfPredefined.getReferencedElement() != null) {
//									NamedElement element = parentOfPredefined.getReferencedElement();
//									if (element instanceof TypedElement) {
//										TypedElement typedElement = (TypedElement) element;
//										addIdsForMethods(typedElement.getClassifierType(), namedElementId, allIds);
//									}
//								}
//							}
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
						Function containerFunction = getContainerObjectOfType(context, Function.class);
						if (containerFunction != null) {
							otherIdsHidden |= addIds(namedElementId, containerFunction.getParameters(), allIds);
						}
						
						// add parameters for constructor
						Constructor constructor = getContainerObjectOfType(context, Constructor.class);
						if (constructor != null && containerClass != null) {
							otherIdsHidden |= addIds(namedElementId, constructor.getParameters(), allIds);
						}
						
//						Expression expr = getContainerObjectOfType(context, Expression.class);
						// TODO
//						if (expr != null && containerClass != null && containerClass.getConstructor() != null
//								&& containerClass.getBaseConstructorArguments().contains(expr)) {
//							otherIdsHidden |= addIds(namedElementId, containerClass.getConstructor().getParameters(), allIds);
//						}
						
						// add attributes
						if (!otherIdsHidden && containerClass != null) {
							otherIdsHidden = addIds(namedElementId, containerClass.getAttributes(), allIds);
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
							otherIdsHidden |= addIds(namedElementId, containerModule.getClasses(), allIds);
						}
						
						// idres ...
//						addIdsForIdResolution(idExpr, namedElementId, allIds);
						
						// rules and properties defined in the current extension definition
						ExtensionSemanticsDefinition semanticsDef = getContainerObjectOfType(idExpr, ExtensionSemanticsDefinition.class);
						if (!otherIdsHidden && semanticsDef != null) {
							ExtensionDefinition extDef = semanticsDef.getSyntaxDefinition();
							TsRule firstRule = extDef.getTextualSyntaxDef().getRules().get(0);
							
							// add all properties that are accessible from the first rule
							Stack<TsRule> ruleStack = new Stack<TsRule>();
							ruleStack.push(firstRule);
							addIdsForRhsExpressionsTree(firstRule.getRhs(), ruleStack, namedElementId, allIds);
							ruleStack.pop();
							
							// add types of assigned rules
							addId(namedElementId, extDef.getTextualSyntaxDef().getStartRule(), allIds);
							for (TsRule rule: extDef.getTextualSyntaxDef().getRules()) {
								addIdsForAssignedRules(rule.getRhs(), namedElementId, allIds);
								
								// also add types of indirectly assigned rules, e.g. in "M -> a:A; A -> B; B -> x:X;" the rule B is indirectly an assigned rule
								TsRule directReductionTarget = checkForDirectReductionToOtherRule(rule);
								if (directReductionTarget != null) {
									addId(namedElementId, directReductionTarget, allIds);
								}
							}
						}
						
						// identifiers used in extensions are provided at a global scope by default
//						if (checkIfUsedInsideExtensionInstance(idExpr)) {
//							addPlainNames(namedElementId.getName(), context, allIds);
//						}
						
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
					}
					else if (hasSuperAsParent(idExpr) && containerClass != null) {
						addIdsForInheritedAttributes(containerClass, namedElementId, allIds);
					}
					else if (hasMetaAsParent(idExpr)) {
						Class eClass = findImportedClass((Model) containerModule.eContainer(), "EClass");
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
							else if (referencedParentElement instanceof Function) {
								Function parentFunction = (Function) referencedParentElement;
								addIdsForPropertiesOfTypedElementType(parentFunction, namedElementId, allIds);
							}
							else if (referencedParentElement instanceof Class) {
								Class parentClassifier = (Class) referencedParentElement;
								addIdsForClassAttributes(parentClassifier, namedElementId, allIds);
							}
							else if (referencedParentElement instanceof PropertyBindingExpr) {
								PropertyBindingExpr parentPropertyBinding = (PropertyBindingExpr) referencedParentElement;
								PropertyType parentPropertyType = parentPropertyBinding.getPropertyType();
								if (parentPropertyType instanceof StructuredPropertyType) {
									StructuredPropertyType structuredParentPropertyType = (StructuredPropertyType) parentPropertyType;
									addIdsForPropertiesOfLanguageConstructClassifier(structuredParentPropertyType.getType(), namedElementId, allIds);
								}
							}
							else {
								System.out.println("unknown parent element: " + referencedParentElement.getName());
							}
						}
						
						// parent is a predefinedMember, e.g. xs.first.a
						PredefinedId predefinedMember = parentIdExpr.getPredefinedId();
						if (predefinedMember != null) {
//							if (predefinedMember instanceof FirstInSet || predefinedMember instanceof LastInSet) {
//								// the type of the set operators parent determines what IDs are accessible
//								IdExpr parentOfPredefined = idExpr.getParentIdExpr().getParentIdExpr();
//								if (parentOfPredefined.getReferencedElement() != null) {
//									NamedElement element = parentOfPredefined.getReferencedElement();
//									if (element instanceof TypedElement) {
//										TypedElement typedElement = (TypedElement) element;
//										addIdsForPropertiesOfTypedElementType(typedElement, namedElementId, allIds);
//									}
//								}
//							}
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
					addIds(namedElementId, containerModule.getClasses(), allIds);
				}				
			}
			else if (context instanceof TextualSyntaxDef) {
				addIdsForTsRules(context, namedElementId.getName(), allIds);
			}
			else if (context instanceof ExtensionDefinition) {
				addIdsForLanguageConceptClassifiers(context, namedElementId.getName(), allIds);
			}
			else if (context instanceof RhsExpression) {
				if (context instanceof RhsClassifierExpr) {
					addIdsForLanguageConstructClassifiers(context, namedElementId.getName(), allIds);
				}
			}
			else if (identifier instanceof Class) {
				addIdsForClassifiers(context, namedElementId.getName(), allIds);
			}
			else if (identifier instanceof Variable) {
				// TODO extract and include variable resolution from above here
				LocalScope localScope = getContainerObjectOfType(context, LocalScope.class);
				addIdsForLocalVariables(localScope, namedElementId, allIds);
			}
			else if (context instanceof Statement && identifier instanceof Variable) {
				// TODO just testing here
				LocalScope localScope = (LocalScope) context;
				addIdsForLocalVariables(localScope, namedElementId, allIds);
			}
//			else if (namedElementId.eClass().getName().equals("Vertex")
//					|| namedElementId.eClass().getName().equals("L2")
//					|| namedElementId.eClass().getName().equals("EventDecl")
//					|| namedElementId.eClass().getName().equals("Foo")) {
//				// TODO just for making the SML example work
//				addPlainNames(namedElementId.getName(), context, allIds);
//			}
			else if (context instanceof ExtensibleElement) {
				addPlainNames(namedElementId.getName(), context, allIds);
			}

			// necessary by raw references to global names
			if (allIds.isEmpty()) {
				addPlainNames(namedElementId.getName(), context, allIds);
			}
		}
		else if (identifier instanceof String
				&& (type.getName().equals("Class") || type.getName().equals("Interface") || type.getName().equals("Classifier"))
				|| type instanceof Class) {
			
			addIdsForClassifiers(context, (String) identifier, allIds);
		}
		else if (identifier instanceof String && (type.getName().equals("LanguageConstructClassifier") || type instanceof LanguageConstructClassifier)) {
			addIdsForLanguageConstructClassifiers(context, (String) identifier, allIds);
		}

		// necessary by raw references to global names
		if (identifier instanceof String && allIds.isEmpty()) {
			addPlainNames((String) identifier, context, allIds);
		}
		
		if (allIds.size() > 1) {
			System.out.println("identified more than one object for identifier " + identifier.toString());
		}

		if (!allIds.isEmpty()) {
			return allIds.toArray();
		}
		
//		if (identifier.equals("IdExpr")) {
//			System.out.println("bla");
//		}
		return super.getGlobalIdentities(identifier, context, type);
	}
	
	private boolean _addIdsForGlobalProcedures(Module containerModule, NamedElement namedElementId, Collection<Object> allIds, IdExpr idExpr) {
		boolean added = false;
		if (containerModule != null) {
			for (Function method: containerModule.getFunctions()) {
				if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
					added |= addId(namedElementId, method, allIds);
				}
			}
		}
		return added;
	}
	
	private boolean addIdsForGlobalProcedures(Model containerModel, NamedElement namedElementId, Collection<Object> allIds, IdExpr idExpr) {
		boolean added = false;
		
		for (Module module: containerModel.getModules()) {
			added |= _addIdsForGlobalProcedures(module, namedElementId, allIds, idExpr);
		}
		
		if (!added) {
			for (Import imprt: containerModel.getImports()) {
				Model importedModel = imprt.getModel();
				if (importedModel != null) {
					added |= addIdsForGlobalProcedures(importedModel, namedElementId, allIds, idExpr);
				}
			}
		}

		return added;
	}

	private void addIdsForMethods(IdExpr classifierTypeExpr, NamedElement namedElementId, Collection<Object> allIds, IdExpr idExpr) {
		if (classifierTypeExpr != null) {
			NamedElement type = classifierTypeExpr.getReferencedElement();
			if (type instanceof Class) {
				Class classifier = (Class) type;
				addIdsForMethods(classifier, namedElementId, allIds, idExpr);
			}
		}
	}

	private void addIdsForPropertiesOfTypedElementType(TypedElement typedElement, NamedElement namedElementId, Collection<Object> allIds) {
		if (typedElement.getTypeArrayDimensions().isEmpty()) {
			if (typedElement.getClassifierType() != null) {
				NamedElement type = typedElement.getClassifierType().getReferencedElement();
				if (type instanceof LanguageConstructClassifier) { // includes Classifiers and TsRules
					LanguageConstructClassifier langClassifier = (LanguageConstructClassifier) type;
					addIdsForPropertiesOfLanguageConstructClassifier(langClassifier, namedElementId, allIds);
				}
			}
		}
	}

	private boolean addIdsForPropertiesOfLanguageConstructClassifier(LanguageConstructClassifier langClassifier, NamedElement namedElementId,
			Collection<Object> allIds) {
		if (langClassifier instanceof Class) {
			Class clazz = (Class) langClassifier;
			return addIdsForAttributes(clazz, namedElementId, allIds);
		}
		else if (langClassifier instanceof TsRule) {
			TsRule entryRule = (TsRule) langClassifier;
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
		for (TsRule otherTsRule: ((TextualSyntaxDef) tsRule.eContainer()).getRules()) {
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
		if (expr instanceof RhsClassifierExpr) {
			RhsClassifierExpr rhsClassifierExpr = (RhsClassifierExpr) expr;
			LanguageConstructClassifier langClassifier = rhsClassifierExpr.getClassifier();
			
			if (langClassifier instanceof TsRule) {
				TsRule tsRule = (TsRule) langClassifier;
				collectPropertyBindings(tsRule.getRhs(), definedProperties);
			}
			else {
				// TODO
			}
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
				RhsExpression firstExpr = seqExpr.getSequence().get(0);
				
				if (firstExpr instanceof RhsClassifierExpr) {
					RhsClassifierExpr rhsClassifierExpr = (RhsClassifierExpr) firstExpr;
					LanguageConstructClassifier langClassifier = rhsClassifierExpr.getClassifier();
					
					if (langClassifier instanceof TsRule) {
						TsRule referencedTsRule = (TsRule) langClassifier;
						return referencedTsRule;
					}
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
	
//	private void addIdsForIdResolution(EObject context, NamedElement identifier, Collection<Object> allIds) {
//		IdResolution idRes = getContainerObjectOfType(context, IdResolution.class);
//		if (idRes != null) {
//			Pattern pattern = getContainerObjectOfType(context, Pattern.class);
//			if (pattern != null) {
//				addId(identifier, pattern.getContext(), allIds);
//			}
//			
//			addIdsForParentContainers(context, identifier, allIds);
//			
//			IncludePattern include = getContainerObjectOfType(context, IncludePattern.class);
//			if (include != null) {
//				addIds(identifier, idRes.getPatterns(), allIds);
//			}
//		}		
//	}

	private boolean addIdsForTsRules(EObject context, String identifier, Collection<Object> allIds) {
		ExtensionDefinition extensionDef = getContainerObjectOfType(context, ExtensionDefinition.class);
		if (extensionDef != null) {
			addIds(identifier, extensionDef.getTextualSyntaxDef().getRules(), allIds);
			if (allIds.size() > 1) {
				Object first = allIds.iterator().next();
				allIds.clear();
				allIds.add(first);
				return true;
			}
		}
		return false;
	}
	
	private boolean addIdsForLanguageConceptClassifiers(EObject context, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;
		
		idsAdded |= addIdsForClassifiers(context, identifier, allIds);

		Module containerModule = getContainerObjectOfType(context, Module.class);
		if (containerModule != null) {
			for (ExtensionDefinition otherExtDef : containerModule.getExtensionDefinitions()) {
				idsAdded |= addId(identifier, otherExtDef, allIds);
			}
		}
		
		return idsAdded;
	}

	private boolean addIdsForLanguageConstructClassifiers(EObject context, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;
		
		idsAdded |= addIdsForTsRules(context, identifier, allIds);

		idsAdded |= addIdsForLanguageConceptClassifiers(context, identifier, allIds);
		
		return idsAdded;
	}

	private boolean addIdsForClassifiers(EObject context, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;

		Module containerModule = getContainerObjectOfType(context, Module.class);
		if (containerModule != null) {
			
			idsAdded |= addIds(identifier, containerModule.getClasses(), allIds);
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
					idsAdded |= addIds(identifier, importedModule.getClasses(), allIds);
				}
				if (!idsAdded) {
					idsAdded = addIdsForImports(imprt.getModel(), identifier, allIds);
				}
			}
		}
		return idsAdded;
	}
	
	private Class findImportedClass(Model model, String clazzName) {
		for (Import imprt: model.getImports()) {
			if (imprt.getModel() != null) {
				for (Module importedModule: imprt.getModel().getModules()) {
					for (Class clazz: importedModule.getClasses()) {
						if (clazz.getName().equals(clazzName)) {
							return clazz;
						}
					}
				}
				return findImportedClass(imprt.getModel(), clazzName);
			}
		}
		return null;
	}
	
	private boolean addIdsForRhsExpressionsTree(RhsExpression expr, Stack<TsRule> ruleStack, NamedElement eObjectId, Collection<Object> allIds) {
		if (expr instanceof PropertyBindingExpr) {
			PropertyBindingExpr bindingExpr = (PropertyBindingExpr) expr;
			return addId(eObjectId, bindingExpr, allIds);
		}
		if (expr instanceof RhsClassifierExpr) {
			RhsClassifierExpr rhsClassifierExpr = (RhsClassifierExpr) expr;
			LanguageConstructClassifier langClassifier = rhsClassifierExpr.getClassifier();

			if (langClassifier instanceof TsRule) {
				TsRule entryRule = (TsRule) langClassifier;
				
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
			else if (langClassifier instanceof Class) {
				Class clazz = (Class) langClassifier;
				return addIdsForAttributes(clazz, eObjectId, allIds);
			}
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

		return false;
	}

//	private boolean addIdsForParentContainers(EObject context, NamedElement eObjectId, Collection allIds) {
//		if (context != null) {
//			FindContainer container = getContainerObjectOfType(context.eContainer(), FindContainer.class);
//			if (container != null) {
//				boolean idsAdded = addId(eObjectId, container.getVariableBinding(), allIds);
//				idsAdded |= addIdsForParentContainers(container.eContainer(), eObjectId, allIds);
//				return idsAdded;
//			}
//		}
//		return false;
//	}

	private boolean addIdsForLocalVariables(Expression expr, NamedElement eObjectId, Collection allIds) {
		LocalScope localScope = getContainerObjectOfType(expr, LocalScope.class);
		if (localScope != null)
			return addIdsForLocalVariables(localScope, eObjectId, allIds);
		else
			return false;
	}
	
	private boolean addIdsForLocalVariables(LocalScope contextScope, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		
		if (contextScope != null) {
			for (Statement statement: contextScope.getStatements()) {
				if (statement instanceof Variable) {
					Variable localVariable = (Variable) statement;
					idsAdded |= addId(eObjectId, localVariable, allIds);
				}

				if (statement == contextScope) {
					// the identifier is used in a part of the context statement. therefore, do not look beyond the context.
					break;
				}
			}
	
			LocalScope parentScope = getContainerObjectOfType(contextScope.eContainer(), LocalScope.class);
			if (parentScope != null) {
				idsAdded |= addIdsForLocalVariables(parentScope, eObjectId, allIds);
			}
		}
		
		return idsAdded;
	}
	
	private EList<Variable> getClassAttributes(EList<Variable> allAttributes) {
		EList<Variable> classAttributes = new BasicEList<Variable>();
		for (Variable attr: allAttributes) {
			if (attr.isClass()) {
				classAttributes.add(attr);
			}
		}
		return classAttributes;
	}
	
	private EList<Function> getClassMethods(EList<Function> allMethods) {
		EList<Function> classMethods = new BasicEList<Function>();
		for (Function method: allMethods) {
			if (method.isClass()) {
				classMethods.add(method);
			}
		}
		return classMethods;
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

	private boolean addIdsForInheritedMethods(Class clazz, NamedElement eObjectId, Collection allIds, IdExpr idExpr) {
		boolean idsAdded = false;

		for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				for (Function method: superClass.getMethods()) {
					if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
						idsAdded |= addId(eObjectId, method, allIds);
					}
				}
				idsAdded |= addIdsForInheritedMethods(superClass, eObjectId, allIds, idExpr);
			}
		}

		return idsAdded;
	}
	
	private boolean addIdsForInheritedClassMethods(Class clazz, NamedElement eObjectId, Collection allIds, IdExpr idExpr) {
		boolean idsAdded = false;

		for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				for (Function method: getClassMethods(superClass.getMethods())) {
					if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
						idsAdded |= addId(eObjectId, method, allIds);
					}
				}
				idsAdded |= addIdsForInheritedClassMethods(superClass, eObjectId, allIds, idExpr);
			}
		}
		
		return idsAdded;
	}
	
	private boolean addIdsForInheritedAttributes(Class clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		
		for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				idsAdded |= addIds(eObjectId, superClass.getAttributes(), allIds);
				idsAdded |= addIdsForInheritedAttributes(superClass, eObjectId, allIds);

				//Module containerModule = getContainerObjectOfType(superClass, Module.class);
				//idsAdded |= addIdsForAugmentedAttributes(superClass, containerModule, eObjectId, allIds);
			}
		}

		return idsAdded;
	}

	private boolean addIdsForInheritedClassAttributes(Class clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		
		for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				idsAdded |= addIds(eObjectId, getClassAttributes(superClass.getAttributes()), allIds);
				idsAdded |= addIdsForInheritedClassAttributes(superClass, eObjectId, allIds);

				//Module containerModule = getContainerObjectOfType(superClass, Module.class);
				//idsAdded |= addIdsForAugmentedAttributes(superClass, containerModule, eObjectId, allIds);
			}
		}
		
		return idsAdded;
	}

	private boolean addIdsForAttributes(Class classifier, NamedElement identifier, Collection allIds) {
		boolean idsAdded = false;
		if (classifier instanceof Class) {
			Class clazz = (Class) classifier;
			
			// add attributes
			idsAdded = addIds(identifier, clazz.getAttributes(), allIds);
			
			// add inherited attributes
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedAttributes(clazz, identifier, allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForClassAttributes(Class classifier, NamedElement identifier, Collection allIds) {
		boolean idsAdded = false;
		if (classifier instanceof Class) {
			Class clazz = (Class) classifier;
			
			// add attributes
			for (Variable attr: clazz.getAttributes()) {
				if (attr.isClass()) {
					idsAdded |= addId(identifier, attr, allIds);
				}
			}
			
			// add inherited attributes
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedClassAttributes(clazz, identifier, allIds);
			}
		}
		return idsAdded;
	}

	private boolean addIdsForMethods(Class classifier, NamedElement identifier, Collection allIds, IdExpr idExpr) {
		boolean idsAdded = false;
		if (classifier instanceof Class) {
			Class clazz = (Class) classifier;

			// add methods
			for (Function method: clazz.getMethods()) {
				if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
					idsAdded = addId(identifier, method, allIds);
				}
			}

			// add inherited methods
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedMethods(clazz, identifier, allIds, idExpr);
			}
		}
		return idsAdded;
	}
	
	private boolean addIdsForClassMethods(Class classifier, NamedElement identifier, Collection allIds, IdExpr idExpr) {
		boolean idsAdded = false;
		if (classifier instanceof Class) {
			Class clazz = (Class) classifier;

			// add methods
			for (Function method: getClassMethods(clazz.getMethods())) {
				if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
					idsAdded = addId(identifier, method, allIds);
				}
			}

			// add inherited methods
			if (!idsAdded) {
				idsAdded |= addIdsForInheritedClassMethods(clazz, identifier, allIds, idExpr);
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
		if (object instanceof ExtensibleElement && ((ExtensibleElement) object).isInstanceOfExtensionDefinition()) return true;
		else if (object.eContainer() != null) return checkIfUsedInsideExtensionInstance(object.eContainer());
		else return false;
	}
	
	private <T> T getContainerObjectOfType(EObject object, java.lang.Class<T> type) {
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
		final String objectName = ((NamedElement) object).getName();
		if (objectName != null && objectName.equals(identifier)) {
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
		if (container instanceof Function || container instanceof Class) return container;
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
		
		Resource preModelResource = null;
		if (preProcessedDocument.getModel() != null) {
			preModelResource = preProcessedDocument.getModel().eResource();
		}
		
		if (object.eResource() == null || object.eResource().getURI() == null
				|| object.eResource() == preModelResource) {
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
		else if (object instanceof Module || object instanceof Class || object instanceof Function || object instanceof Parameter
				 || object instanceof Variable) {
			NamedElement namedElement = (NamedElement) object;
			if (object instanceof Variable) {
				return getQualifiedId(object.eContainer()) + "." + object.eClass().getName() + "_"
						+ (((Variable) object).isClass() ? "static_" : "") + namedElement.getName();
			}
			else if (object instanceof Function) {
				return getQualifiedId(object.eContainer()) + "." + object.eClass().getName() + "_"
						+ (((Function) object).isClass() ? "static_" : "") + namedElement.getName();
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
