package hub.sam.dmx.editor.semantics;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.Class;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.DblEObject;
import hub.sam.dbl.DblElementVisitor;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Import;
import hub.sam.dbl.LanguageConstructClassifier;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.MetaLiteral;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.TypeLiteral;
import hub.sam.dbl.TypedElement;
import hub.sam.tef.semantics.IIdentificationScheme;

public class CollectIdentitiesVisitor implements DblElementVisitor {
	
	private final String identifier;
	
	private final IIdentificationScheme creator;
	
	// includes all the identities matching the identifier which were found by this visitor
	private final Collection<Object> allIds = new HashSet<Object>();

	private Class containerClass;
	private Module containerModule;
	private Model containerModel;
	
	public CollectIdentitiesVisitor(IIdentificationScheme creator, String identifier) {
		this.identifier = identifier;
		this.creator = creator;
	}
	
	public Object[] getIdentities() {
		return allIds.toArray();
	}
	
	public boolean hasContainerClass() {
		return containerClass != null;
	}

	public Class getContainerClass() {
		return containerClass;
	}

	public boolean hasContainerModule() {
		return containerModule != null;
	}

	public Module getContainerModule() {
		return containerModule;
	}

	public Model getContainerModel() {
		return containerModel;
	}

	private void initContainerReferences(EObject object) {
		containerClass = getContainerObjectOfType(object, Class.class);
		if (containerClass != null) {
			containerModule = getContainerObjectOfType(containerClass, Module.class);
		}
		if (containerModule != null) {
			containerModel = getContainerObjectOfType(containerModule, Model.class);
		}
	}

	@Override
	public void visit(DblEObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitIdExpr(IdExpr idExpr) {
		System.out.println("visiting IdExpr");

		initContainerReferences(idExpr);
		
		if (idExpr.getParentIdExpr() == null) {
			// function or constructor call
			if (idExpr.getCallPart() != null) {
				// TODO method overloading is not considered at the moment
				Predicate<Function> functionFilter = function -> function.getParameters().size() == idExpr.getCallPart().getCallArguments().size();

				// functions of containing class
				if (hasContainerClass()) {
					addIdentitiesOfSuitableMethods(getContainerClass(), functionFilter);				
				}
				
				// global functions (also imported ones)
				if (identitiesEmpty()) {
					addIdentitiesOfSuitableGlobalFunctionsFollowImports(functionFilter);
				}

				// constructor calls, i.e. new Class(...)
				if (hasContainerModule()) {
					getContainerModule().getClasses().forEach(class_ -> addIdentityIfSuitable(class_));
				}
			}
			else {
				// some kind of variable or a Class
				
				// local variables
				
				// parameters if contained in a function
				
				// parameters if contained in a constructor
				
				// attributes including inherited ones if contained in a class
				
				// global variables
				
				// classes of containing module
				
				// rules and properties if contained in an extension definition
				
				// imported classes
			}
		}
		else if (hasSelfAsParent(idExpr) && hasContainerClass()) {
			addIds(namedElementId, containerClass.getAttributes(), allIds);
		}
		else if (hasSuperAsParent(idExpr) && getContainerClass() != null) {
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
			// ...
		}
	}
	
	protected void visitIdExpr(IdExpr parentIdExpr, IdExpr contextIdExpr) {
		
	}
	
	private void addFunctions(IdExpr idExpr) {

		
		if (idExpr.getParentIdExpr() == null) {
			if (hasContainerClass()) {
				addIdentitiesOfSuitableMethods(getContainerClass(), functionFilter);				
			}
			
			// add global procedures (also imported ones)
			if (identitiesEmpty()) {
				addIdentitiesOfSuitableGlobalFunctionsFollowImports(functionFilter);
			}
		}
		else if (hasContainerClass() && hasSelfAsParent(idExpr)) {
			getContainerClass().getMethods().stream()
				.filter(functionFilter)
				.forEach(method -> addIdentityIfSuitable(method));
		}
		else if (hasContainerClass() && hasSuperAsParent(idExpr)) {
			addIdentitiesOfSuitableInheritedMethods(getContainerClass(), functionFilter);
		}
		else if (hasMetaAsParent(idExpr)) {
			NamedElement metaOfElement = idExpr.getParentIdExpr().getParentIdExpr().getReferencedElement();
			String metaElementName = metaOfElement.eClass().getName();
			System.out.println("meta-object: " + metaElementName + " " + metaOfElement.getName());
			Class metaClass = findImportedClass((Model) containerModule.eContainer(), metaElementName);
			if (metaClass != null) {
				addIdentitiesOfSuitableMethods(metaClass, functionFilter);
			}
		}
		else if (hasTypeAsParent(idExpr)) {
			NamedElement typeOfElement = idExpr.getParentIdExpr().getParentIdExpr().getReferencedElement();
			if (typeOfElement instanceof TypedElement) {
				TypedElement typeOfTypedElement = (TypedElement) typeOfElement;
				String metaTypeName = null;
				String typeName = "";
				// FIXME
//				if (typeOfTypedElement.getClassifierType() != null) {
//					metaTypeName = typeOfTypedElement.getClassifierType().eClass().getName();
//					typeName = typeOfTypedElement.getClassifierType().getName();
//				}
//				else if (typeOfTypedElement.getPrimitiveType() != null) {
//					metaTypeName = typeOfTypedElement.getPrimitiveType().eClass().getName();
//					typeName = metaTypeName;
//				}
//				else if (typeOfTypedElement.isIsList()) {
//					metaTypeName = typeOfTypedElement.getClassifierType().eClass().getName();
//					typeName = metaTypeName;
//				}
				System.out.println("type-object: " + metaTypeName + " " + typeName);
				Class metaClass = findImportedClass((Model) containerModule.eContainer(), metaTypeName);
				if (metaClass != null) {
					addIdentitiesOfSuitableMethods(metaClass, functionFilter);
				}
			}
		}
		else {
			IdExpr parentIdExpr = idExpr.getParentIdExpr();
			
			NamedElement referencedParentElement = parentIdExpr.getReferencedElement();
			if (referencedParentElement != null) {
				// TODO replace instanceof checks by element.accept(this)
				// in order to forward the visitor to the next element
				
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
//				if (predefinedId instanceof BeforeInSet || predefinedId instanceof AfterInSet
//						|| predefinedId instanceof FirstInSet || predefinedId instanceof LastInSet) {
//					// the type of the set operators parent determines what IDs are accessible
//					IdExpr parentOfPredefined = idExpr.getParentIdExpr().getParentIdExpr();
//					if (parentOfPredefined.getReferencedElement() != null) {
//						NamedElement element = parentOfPredefined.getReferencedElement();
//						if (element instanceof TypedElement) {
//							TypedElement typedElement = (TypedElement) element;
//							addIdsForMethods(typedElement.getClassifierType(), namedElementId, allIds);
//						}
//					}
//				}
			}
		}
	}
	
	// former addIdsForMethods
	private void addIdentitiesOfSuitableMethods(Class class_, Predicate<? super Function> functionFilter) {
		class_.getMethods().stream()
			.filter(functionFilter)
			.forEach(method -> addIdentityIfSuitable(method));

		// add inherited methods
		if (identitiesEmpty()) {
			// look for suitable methods in super class of current class
			addIdentitiesOfSuitableInheritedMethods(class_, functionFilter);
		}
	}
	
	// former addIdsForInheritedMethods()
	private void addIdentitiesOfSuitableInheritedMethods(Class class_, Predicate<? super Function> functionFilter) {
		class_.getSuperClasses().stream()
			.map(superClassSpec -> superClassSpec.getClass_())
			.forEach(superClass -> {
				superClass.getMethods().stream()
					.filter(functionFilter)
					.forEach(method -> addIdentityIfSuitable(method));
				
				if (identitiesEmpty()) {
					// look for suitable methods in super class of current class
					addIdentitiesOfSuitableInheritedMethods(superClass, functionFilter);
				}
			});
	}
	
	// former addIdsForGlobalProcedures
	private void addIdentitiesOfSuitableGlobalFunctionsFollowImports(Predicate<? super Function> functionFilter) {
		getContainerModel().getModules().stream()
			.forEach(module -> addIdentitiesOfSuitableModuleFunctions(module, functionFilter));

		if (identitiesEmpty()) {
			getContainerModel().getImports().stream()
				.map(imprt -> imprt.getModel())
				.filter(importedModel -> importedModel != null)
				.forEach(importedModel -> addIdentitiesOfSuitableGlobalFunctionsFollowImports(functionFilter));
		}
	}
	
	private void addIdentitiesOfSuitableModuleFunctions(Module module, Predicate<? super Function> functionFilter) {
		if (module != null) {
			module.getFunctions().stream()
				.filter(functionFilter)
				.forEach(function -> addIdentityIfSuitable(function));
		}
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
	
	private Class findImportedClass(Model model, String className) {
		for (Import imprt: model.getImports()) {
			if (imprt.getModel() != null) {
				for (Module importedModule: imprt.getModel().getModules()) {
					for (Class class_: importedModule.getClasses()) {
						if (class_.getName().equals(className)) {
							return class_;
						}
					}
				}
				return findImportedClass(imprt.getModel(), className);
			}
		}
		return null;
	}
	
	private boolean identitiesEmpty() {
		return allIds.isEmpty();
	}
	
	private boolean identitiesFound() {
		return !allIds.isEmpty();
	}
	
	// former addId(...)
	private <E extends NamedElement> void addIdentityIfSuitable(NamedElement namedElement) {
		final String name = namedElement.getName();
		if (name != null && name.equals(identifier)) {
			allIds.add(creator.getIdentitiy(namedElement));
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getContainerObjectOfType(EObject object, java.lang.Class<T> type) {
		if (type.isAssignableFrom(object.getClass())) return (T) object;
		else if (object.eContainer() == null) return null;
		else return getContainerObjectOfType(object.eContainer(), type);
	}
	
}
