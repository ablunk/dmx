package hub.sam.dmx.editor.semantics;

import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.Class;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionSemantics;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Import;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.MetaLiteral;
import hub.sam.dbl.MetaSymbol;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.PlainSymbolReference;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StructuralSymbolReference;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.SymbolSequence;
import hub.sam.dbl.SyntaxDefinition;
import hub.sam.dbl.SyntaxExpression;
import hub.sam.dbl.SyntaxSymbolClassifier;
import hub.sam.dbl.TypeLiteral;
import hub.sam.dbl.TypedElement;
import hub.sam.dbl.Variable;
import hub.sam.dmx.editor.IPreProcessedDocument;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.util.MyIterable;

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
			e.printStackTrace();
			return null;
		}
	}
	
	// returns all the objects that the given identifier identifies in the given context
	public Object[] getGlobalIdentities_save(Object identifier, EObject context, EClassifier type) {
		Collection<Object> allIds = new HashSet<Object>();
		
		if (identifier instanceof NamedElement) {
			NamedElement namedElementId = (NamedElement) identifier;
			
			if (namedElementId.getName().equals("Object")) {
				System.out.println("found Object");
			}
			
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
							
							if (!otherIdsHidden) {
								Class importedClass = findImportedClass((Model) containerModule.eContainer(), namedElementId.getName());
								if (importedClass != null) {
									otherIdsHidden = addId(namedElementId, importedClass, allIds);
								}
							}
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
							else if (referencedParentElement instanceof StructuralSymbolReference) {
								System.out.println("parent is structural symbol reference: " + referencedParentElement.getName());

								StructuralSymbolReference structuralSymbolReference = (StructuralSymbolReference) referencedParentElement;
								
								if (structuralSymbolReference.isList()) {
									// find type stdlib.List and add its methods
									Class listClassifier = findImportedClass(containerModel, "List");
									if (listClassifier != null) {
										addIdsForMethods(listClassifier, namedElementId, allIds, idExpr);
									}
								}
								else {
									SyntaxSymbolClassifier symbolClassifier = structuralSymbolReference.getClassifier();
									
									if (symbolClassifier != null && symbolClassifier instanceof Class) {
										Class classifierRhsType = (Class) symbolClassifier;
										addIdsForMethods(classifierRhsType, namedElementId, allIds, idExpr);
									}
									// TODO what about the other Concepts ??
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
						
						// symbols and properties defined in the current extension definition
						ExtensionSemantics semantics = getContainerObjectOfType(idExpr, ExtensionSemantics.class);
						if (!otherIdsHidden && semantics != null) {
							Extension extDef = semantics.getSyntaxDefinition();
							MetaSymbol firstRule = extDef.getSyntaxDefinition().getSymbols().get(0);
							
							// add all properties that are accessible from the first symbol
							Stack<MetaSymbol> symbolStack = new Stack<MetaSymbol>();
							symbolStack.push(firstRule);
							addIdsForSyntaxExpressionsTree(firstRule.getPossibleSyntax(), symbolStack, namedElementId, allIds);
							symbolStack.pop();
							
							// add types of assigned symbols
							addId(namedElementId, extDef.getSyntaxDefinition().getStartSymbol(), allIds);
							for (MetaSymbol symbol: extDef.getSyntaxDefinition().getSymbols()) {
								addIdsForStructuralSymbols(symbol.getPossibleSyntax(), namedElementId, allIds);
								
								// also add types of indirectly assigned symbols, e.g. in "M -> a:A; A -> B; B -> x:X;" the symbol B is indirectly an assigned symbol
								MetaSymbol directReductionTarget = checkForDirectReductionToOtherRule(symbol);
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
								otherIdsHidden = addIdsForImportedConcepts(model, namedElementId.getName(), allIds);
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
							else if (referencedParentElement instanceof StructuralSymbolReference) {
								StructuralSymbolReference parentStructuralSymbolReference = (StructuralSymbolReference) referencedParentElement;
								addIdsForPropertiesOfSyntaxSymbolClassifier(parentStructuralSymbolReference.getClassifier(), namedElementId, allIds);								
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
			else if (context instanceof PlainSymbolReference || context instanceof StructuralSymbolReference) {
				addIdsForSyntaxSymbolClassifiers(context, namedElementId.getName(), allIds);
			}
			else if (context instanceof SyntaxDefinition) {
				addIdsForMetaSymbols(context, namedElementId.getName(), allIds);
			}
			else if (context instanceof Extension || context instanceof ExtensionSemantics) {
				addIdsForConcepts(context, namedElementId.getName(), allIds);
			}
			else if (identifier instanceof Class) {
				addIdsForConcepts(context, namedElementId.getName(), allIds);
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

			// necessary by raw references to global names in extension instances
			if (allIds.isEmpty()) {
				ExtensibleElement extensibleContainer = getContainerObjectOfType(context, ExtensibleElement.class);
				if (extensibleContainer != null && extensibleContainer.isInstanceOfExtensionDefinition()) {
					addPlainNames(namedElementId.getName(), context, allIds);
				}
			}
		}
		else if (identifier instanceof String
				&& (type.getName().equals("Class") || type.getName().equals("Interface") || type.getName().equals("Classifier"))
				|| type instanceof Class) {
			
			addIdsForConcepts(context, (String) identifier, allIds);
		}
		else if (identifier instanceof String && (type.getName().equals("SyntaxSymbolClassifier") || type instanceof SyntaxSymbolClassifier)) {
			addIdsForSyntaxSymbolClassifiers(context, (String) identifier, allIds);
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
		
		added |= _addIdsForGlobalProcedures(containerModel.getModule(), namedElementId, allIds, idExpr);
		
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
				if (type instanceof SyntaxSymbolClassifier) { // includes Classifiers and TsRules
					SyntaxSymbolClassifier symbolClassifier = (SyntaxSymbolClassifier) type;
					addIdsForPropertiesOfSyntaxSymbolClassifier(symbolClassifier, namedElementId, allIds);
				}
			}
		}
	}

	private boolean addIdsForPropertiesOfSyntaxSymbolClassifier(SyntaxSymbolClassifier symbolClassifier, NamedElement namedElementId,
			Collection<Object> allIds) {
		if (symbolClassifier instanceof Class) {
			Class clazz = (Class) symbolClassifier;
			return addIdsForAttributes(clazz, namedElementId, allIds);
		}
		else if (symbolClassifier instanceof MetaSymbol) {
			MetaSymbol entryRule = (MetaSymbol) symbolClassifier;
			boolean idsAdded = false;
			for (MetaSymbol symbol: getAllMetaSymbols(entryRule)) {
				Stack<MetaSymbol> symbolStack = new Stack<MetaSymbol>();
				symbolStack.push(symbol);
				idsAdded |= addIdsForSyntaxExpressionsTree(symbol.getPossibleSyntax(), symbolStack, namedElementId, allIds);
				symbolStack.pop();
			}
			return idsAdded;
		}
		return false;
	}
	
	/**
	 * Collects all TS symbols that have the same name as the given TS symbol.
	 * 
	 * @param metaSymbol
	 * @return
	 */
	private Collection<MetaSymbol> getAllMetaSymbols(MetaSymbol metaSymbol) {
		Collection<MetaSymbol> symbols = new HashSet<MetaSymbol>();
		symbols.add(metaSymbol);
		for (MetaSymbol otherTsRule: ((SyntaxDefinition) metaSymbol.eContainer()).getSymbols()) {
			if (otherTsRule.getName().equals(metaSymbol.getName())) {
				symbols.add(otherTsRule);
			}
		}
		return symbols;
	}

	private EList<StructuralSymbolReference> getStructuralSymbolReferences(MetaSymbol metaSymbol) {
		EList<StructuralSymbolReference> references = new BasicEList<StructuralSymbolReference>();
		collectStructuralSymbolReferences(metaSymbol.getPossibleSyntax(), references);
		return references;
	}

	private void collectStructuralSymbolReferences(SyntaxExpression expr, EList<StructuralSymbolReference> references) {
		if (expr instanceof StructuralSymbolReference) {
			references.add((StructuralSymbolReference) expr);
			return;
		}
		if (expr instanceof PlainSymbolReference) {
			PlainSymbolReference rhsClassifierExpr = (PlainSymbolReference) expr;
			SyntaxSymbolClassifier symbolClassifier = rhsClassifierExpr.getClassifier();
			
			if (symbolClassifier instanceof MetaSymbol) {
				MetaSymbol metaSymbol = (MetaSymbol) symbolClassifier;
				collectStructuralSymbolReferences(metaSymbol.getPossibleSyntax(), references);
			}
			else {
				// TODO
			}
		}
		else {
			for (EObject content: expr.eContents()) {
				if (content instanceof SyntaxExpression) {
					SyntaxExpression subExpr = (SyntaxExpression) content;
					collectStructuralSymbolReferences(subExpr, references);
				}
			}
		}
	}

	private void addIdsForStructuralSymbols(SyntaxExpression expr, NamedElement namedElementId, Collection<Object> allIds) {
		if (expr instanceof StructuralSymbolReference) {
			StructuralSymbolReference symbolRef = (StructuralSymbolReference) expr;
			addId(namedElementId, symbolRef.getClassifier(), allIds);
		}
		else {
			for (EObject content: expr.eContents()) {
				if (content instanceof SyntaxExpression) {
					SyntaxExpression subExpr = (SyntaxExpression) content;
					addIdsForStructuralSymbols(subExpr, namedElementId, allIds);
				}
			}
		}
	}
	
	/**
	 * If the given symbol directly reduces to a single other symbol, the other symbol is returned.
	 * Example: If invoked for the symbol A in "A -> B; B -> x:X;", the symbol B is returned.
	 * @param metaSymbol
	 * @return
	 */
	private MetaSymbol checkForDirectReductionToOtherRule(MetaSymbol metaSymbol) {
		SyntaxExpression expr = metaSymbol.getPossibleSyntax();
		if (expr instanceof SymbolSequence) {
			SymbolSequence seqExpr = (SymbolSequence) expr;
			if (seqExpr.getSequence().size() == 1) {
				SyntaxExpression firstExpr = seqExpr.getSequence().get(0);
				
				if (firstExpr instanceof PlainSymbolReference) {
					PlainSymbolReference plainSymbolRef = (PlainSymbolReference) firstExpr;
					SyntaxSymbolClassifier symbolClassifier = plainSymbolRef.getClassifier();
					
					if (symbolClassifier instanceof MetaSymbol) {
						MetaSymbol referencedTsRule = (MetaSymbol) symbolClassifier;
						return referencedTsRule;
					}
				}
			}
		}
		return null;
	}
	
	private void addPlainNames_new(String identifier, EObject context, Collection<Object> allIds) {
		for (EObject content: context.eResource().getContents()) {
			addContainedObjectNames(identifier, content, allIds);
		}
	}
	
	private void addContainedObjectNames(String identifier, EObject containerObject, Collection<Object> allIds) {
		for (EObject content: containerObject.eContents()) {
			if (content instanceof NamedElement) {
				Object nameValue = content.eGet(DblPackage.Literals.NAMED_ELEMENT__NAME);
				if (nameValue != null && ((String) nameValue).equals(identifier)) {
					allIds.add(getIdentitiy((NamedElement) content));
				}
			}
			else {
				addContainedObjectNames(identifier, content, allIds);
			}
		}
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

	private boolean addIdsForMetaSymbols(EObject context, String identifier, Collection<Object> allIds) {
		Extension extension = getContainerObjectOfType(context, Extension.class);
		if (extension != null) {
			addIds(identifier, extension.getSyntaxDefinition().getSymbols(), allIds);
			if (allIds.size() > 1) {
				Object first = allIds.iterator().next();
				allIds.clear();
				allIds.add(first);
				return true;
			}
		}
		return false;
	}
	
//	private boolean addIdsForConcepts(EObject context, String identifier, Collection<Object> allIds) {
//		boolean idsAdded = false;
//		
//		idsAdded |= addIdsForClassifiers(context, identifier, allIds);
//
//		Module containerModule = getContainerObjectOfType(context, Module.class);
//		if (containerModule != null) {
//			for (Extension otherExtension : containerModule.getExtensions()) {
//				idsAdded |= addId(identifier, otherExtension, allIds);
//			}
//		}
//		
//		return idsAdded;
//	}

	private boolean addIdsForSyntaxSymbolClassifiers(EObject context, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;
		
		idsAdded |= addIdsForMetaSymbols(context, identifier, allIds);
		idsAdded |= addIdsForConcepts(context, identifier, allIds);
		
		return idsAdded;
	}

	private boolean addIdsForConcepts(EObject context, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;

		Module containerModule = getContainerObjectOfType(context, Module.class);
		if (containerModule != null) {
			
			idsAdded |= addIds(identifier, containerModule.getClasses(), allIds);
			idsAdded |= addIds(identifier, containerModule.getExtensions(), allIds);
			
			if (!idsAdded) {
				if (containerModule.eContainer() instanceof Model) {
					Model model = (Model) containerModule.eContainer();
					idsAdded = addIdsForImportedConcepts(model, identifier, allIds);
				}
			}			
		}
		return idsAdded;
	}
	
	private boolean addIdsForImportedConcepts(Model model, String identifier, Collection<Object> allIds) {
		boolean idsAdded = false;
		for (Import imprt: model.getImports()) {
			if (imprt.getModel() != null) {
				idsAdded |= addIds(identifier, imprt.getModel().getModule().getClasses(), allIds);
				idsAdded |= addIds(identifier, imprt.getModel().getModule().getExtensions(), allIds);
				if (!idsAdded) {
					idsAdded = addIdsForImportedConcepts(imprt.getModel(), identifier, allIds);
				}
			}
		}
		return idsAdded;
	}
	
	private Class findImportedClass(Model model, String clazzName) {
		for (Import imprt: model.getImports()) {
			if (imprt.getModel() != null) {
				for (Class clazz: imprt.getModel().getModule().getClasses()) {
					if (clazz.getName().equals(clazzName)) {
						return clazz;
					}
				}
				return findImportedClass(imprt.getModel(), clazzName);
			}
		}
		return null;
	}
	
	private boolean addIdsForSyntaxExpressionsTree(SyntaxExpression expr, Stack<MetaSymbol> symbolStack, NamedElement eObjectId, Collection<Object> allIds) {
		if (expr instanceof StructuralSymbolReference) {
			StructuralSymbolReference bindingExpr = (StructuralSymbolReference) expr;
			return addId(eObjectId, bindingExpr, allIds);
		}
		if (expr instanceof PlainSymbolReference) {
			PlainSymbolReference plainSymbolRef = (PlainSymbolReference) expr;
			SyntaxSymbolClassifier symbolClassifier = plainSymbolRef.getClassifier();

			if (symbolClassifier instanceof MetaSymbol) {
				MetaSymbol entryRule = (MetaSymbol) symbolClassifier;
				
				boolean idsAdded = false;
				for (MetaSymbol symbol: getAllMetaSymbols(entryRule)) {
					if (!symbolStack.contains(symbol)) { // prevents endless recursion
						SyntaxExpression rhsExpr = symbol.getPossibleSyntax();
						symbolStack.push(symbol);
						idsAdded |= addIdsForSyntaxExpressionsTree(rhsExpr, symbolStack, eObjectId, allIds);
						symbolStack.pop();
					}
				}
				return idsAdded;
			}
			else if (symbolClassifier instanceof Class) {
				Class clazz = (Class) symbolClassifier;
				return addIdsForAttributes(clazz, eObjectId, allIds);
			}
		}
		else {
			boolean idsAdded = false;
			for (EObject content: expr.eContents()) {
				if (content instanceof SyntaxExpression) {
					SyntaxExpression subExpr = (SyntaxExpression) content;
					idsAdded |= addIdsForSyntaxExpressionsTree(subExpr, symbolStack, eObjectId, allIds);
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
	
	private boolean addIdsForInheritedMethods(Class clazz, NamedElement eObjectId, Collection allIds, IdExpr idExpr) {
		boolean idsAdded = false;

		/*IdExpr superClassIdExpr = clazz.getSuperClass();
		if (superClassIdExpr != null) {
			NamedElement superClass = superClassIdExpr.getReferencedElement();
		}*/
		/*for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				for (Function method: superClass.getMethods()) {
					if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
						idsAdded |= addId(eObjectId, method, allIds);
					}
				}
				if (!idsAdded) {
					idsAdded |= addIdsForInheritedMethods(superClass, eObjectId, allIds, idExpr);
				}
			}
		}*/

		return idsAdded;
	}
	
	private boolean addIdsForInheritedClassMethods(Class clazz, NamedElement eObjectId, Collection allIds, IdExpr idExpr) {
		boolean idsAdded = false;

		/*for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				for (Function method: getClassMethods(superClass.getMethods())) {
					if (idExpr.getCallPart().getCallArguments().size() == method.getParameters().size()) {
						idsAdded |= addId(eObjectId, method, allIds);
					}
				}
				idsAdded |= addIdsForInheritedClassMethods(superClass, eObjectId, allIds, idExpr);
			}
		}*/
		
		return idsAdded;
	}
	
	private boolean addIdsForInheritedAttributes(Class clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		
		/*for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				idsAdded |= addIds(eObjectId, superClass.getAttributes(), allIds);
				idsAdded |= addIdsForInheritedAttributes(superClass, eObjectId, allIds);

				//Module containerModule = getContainerObjectOfType(superClass, Module.class);
				//idsAdded |= addIdsForAugmentedAttributes(superClass, containerModule, eObjectId, allIds);
			}
		}*/

		return idsAdded;
	}

	private boolean addIdsForInheritedClassAttributes(Class clazz, NamedElement eObjectId, Collection allIds) {
		boolean idsAdded = false;
		
		/*for (SuperClassSpecification superClassSpec: clazz.getSuperClasses()) {
			final Class superClass = superClassSpec.getClass_();
			if (!idsAdded && superClass != null) {
				idsAdded |= addIds(eObjectId, getClassAttributes(superClass.getAttributes()), allIds);
				idsAdded |= addIdsForInheritedClassAttributes(superClass, eObjectId, allIds);

				//Module containerModule = getContainerObjectOfType(superClass, Module.class);
				//idsAdded |= addIdsForAugmentedAttributes(superClass, containerModule, eObjectId, allIds);
			}
		}*/
		
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
					idsAdded |= addId(identifier, method, allIds);
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
					idsAdded |= addId(identifier, method, allIds);
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
		if (object != null) {
			final String objectName = ((NamedElement) object).getName();
			if (objectName != null && objectName.equals(identifier)) {
				allIds.add(getIdentitiy((EObject) object));
				idsAdded = true;
			}
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
