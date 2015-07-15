package hub.sam.dmx

import hub.sam.dbl.ExtensibleElement
import hub.sam.dbl.ExtensionDefinition
import hub.sam.dbl.IdExpr
import hub.sam.dbl.Import
import hub.sam.dbl.IntPropertyType
import hub.sam.dbl.Model
import hub.sam.dbl.Module
import hub.sam.dbl.PropertyBindingExpr
import hub.sam.dbl.PropertyType
import hub.sam.dbl.StringPropertyType
import hub.sam.dbl.StructuredPropertyType
import hub.sam.dbl.Variable
import java.io.Writer
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.TypedElement
import hub.sam.dbl.TsRule
import hub.sam.dbl.CompositePropertyType
import hub.sam.dbl.LanguageConstructClassifier
import hub.sam.dbl.IdPropertyType
import java.util.logging.Logger
import hub.sam.dbl.ExpansionStatement
import hub.sam.dbl.ExtensionSemanticsDefinition

/**
 * Generates executable Java code for all extension definitions, which are
 * used by extensions directly contained in the given model file
 * (extension definitions available by import are not considered).
 */
class ExtensionDefinitionsToJava extends BasicDblToJavaGenerator {
	
	private static final Logger logger = Logger.getLogger(ExtensionDefinitionsToJava.getName());
	
	new(IPath outputFolder) {
		super(outputFolder)
	}
	
	def boolean oneParentRefersToSyntaxPartOrDblMetamodel(IdExpr idExpr) {
		val it = idExpr
		if (referencedElement instanceof PropertyBindingExpr) {
			true
		}
		else {
			if (referencedElement != null && referencedElement instanceof TypedElement) {
				val typedReferencedElement = referencedElement as TypedElement
				if (referencedElement.getContainerObjectOfType(Module).name.equals("dbl")) {
					return true;
				}
				else if (typedReferencedElement.classifierType != null) {
					// local variable of DBL metaclass type?	
					return typedReferencedElement.classifierType.referencedElement.getContainerObjectOfType(Module).name.equals("dbl")
				}
			}
			
			if (parentIdExpr != null) {
				parentIdExpr.oneParentRefersToSyntaxPartOrDblMetamodel
			}
			else {
				false
			}
		}
	}
	
	def boolean directlyRefersToSyntaxPart(IdExpr idExpr) {
		val it = idExpr
		return referencedElement instanceof PropertyBindingExpr
	}
	
	def boolean refersToDblMetamodel(IdExpr idExpr) {
		val it = idExpr
		referencedElement != null && referencedElement.getContainerObjectOfType(Module).name.equals("dbl")
	}

	def boolean hasSyntaxType(IdExpr idExpr) {
		val it = idExpr
		if (parentIdExpr == null) {
			return referencedElement instanceof ExtensibleElement
		}
		else
			return parentIdExpr.hasSyntaxType
	}

	def <T> T getContainerObjectOfType(EObject object, Class<T> type) {
		if (type.isAssignableFrom(object.getClass())) return object as T
		else if (object.eContainer() == null) return null
		else return getContainerObjectOfType(object.eContainer(), type)
	}
	
	def boolean isPartOfGenStatement(IdExpr idExpr) {
		return idExpr.getContainerObjectOfType(ExpansionStatement) != null
	}
	
	def boolean refersToSyntaxPart_ofType_StructuredPropertyType(IdExpr idExpr) {
		val it = idExpr
		if (referencedElement instanceof PropertyBindingExpr) {
			return (referencedElement as PropertyBindingExpr).propertyType instanceof StructuredPropertyType
		}
		else false
	}
	
	def boolean refersToVariable_ofType_StructuredPropertyType(IdExpr idExpr) {
		val it = idExpr
		if (referencedElement instanceof Variable) {
			val variable = referencedElement as Variable;
			if (variable.classifierType != null) {
				val type = variable.classifierType.referencedElement
				return type instanceof LanguageConstructClassifier
			}
		}
		false
	}
	
//	def String genSyntaxPartIdExpr(IdExpr idExpr) {
//		val it = idExpr
//
//		'''
//		getPropertyValue(
//		
//		(EObject)
//		«IF parentIdExpr != null»
//			«parentIdExpr.genSyntaxPartIdExpr»,
//		«ELSE»
//			_extensionInstance,
//		«ENDIF»
//		
//		«IF referencedElement != null»
//			"«
//			if (referencedElement.name.startsWith("_"))
//				referencedElement.name.substring(1)
//			else
//				referencedElement.name
//			»"
//		«ELSE»
//			«genIdExpr_for_PredefinedId(predefinedId)»
//		«ENDIF»
//		)
//		'''
//	}

	def boolean referencedElementIsOfTypeList(IdExpr idExpr) {
		val referencedElement = idExpr.referencedElement
		if (referencedElement != null) {
			if (referencedElement instanceof TypedElement) {
				val typedElement = referencedElement as TypedElement
				if (typedElement.classifierType != null) {
					val referencedClassifierType = typedElement.classifierType.referencedElement
					return referencedClassifierType.name.equals("List")
				}
			}
			else if (referencedElement instanceof PropertyBindingExpr) {
				val propertyBinding = referencedElement as PropertyBindingExpr
				val propertyType = propertyBinding.propertyType
				if (propertyType instanceof CompositePropertyType) {
					val compositePropertyType = propertyType as CompositePropertyType
					return compositePropertyType.list
				}
			}
		}
		return false
	}
	
	def boolean referencedElementIsOfTypePrimitive(IdExpr idExpr) {
		val referencedElement = idExpr.referencedElement
		if (referencedElement != null) {
			if (referencedElement instanceof TypedElement) {
				val typedElement = referencedElement as TypedElement
				return typedElement.primitiveType != null;
			}
			else if (referencedElement instanceof PropertyBindingExpr) {
				val propertyBinding = referencedElement as PropertyBindingExpr
				val propertyType = propertyBinding.propertyType
				if (propertyType instanceof IdPropertyType || propertyType instanceof StringPropertyType) {
					return true
				}
			}
		}
		return false
	}
	
	override String genType(EObject type) {
		if (type instanceof TsRule || type.getContainerObjectOfType(Module).name.equals("dbl")) return "EObject"
		else super.genType(type)
	}
	
	def String genIdExprWithSyntaxPartReferences(IdExpr idExpr) {
		val it = idExpr

		if (directlyRefersToSyntaxPart || refersToDblMetamodel) {
			'''
			(
			«IF referencedElement != null»
				«IF referencedElementIsOfTypeList»
					(java.util.List)
				«ELSEIF referencedElementIsOfTypePrimitive»
				
				«ELSE»
					(EObject)
				«ENDIF»
			«ENDIF»
			getPropertyValue(
			«IF parentIdExpr != null»
				«parentIdExpr.genIdExprWithSyntaxPartReferences»
			«ELSE»
				(EObject) _extensionInstance
			«ENDIF»
			,
			«IF referencedElement != null»
				"«
				if (referencedElement.name.startsWith("_"))
					referencedElement.name.substring(1)
				else
					referencedElement.name
				»"
			«ELSE»
				«genIdExpr_for_PredefinedId(predefinedId)»
			«ENDIF»
			)
			)
			'''
		}
		else {
			if (parentIdExpr != null) {
				parentIdExpr.genIdExprWithSyntaxPartReferences + "." + genIdExpr_for_ReferencedElement(referencedElement)
			}
			else {
				genIdExpr_for_ReferencedElement(referencedElement)
			}
		}
	}

//	def String genIdExprWithSyntaxPartReferences(IdExpr idExpr) {
//		val it = idExpr
//
//		if (directlyRefersToSyntaxPart || refersToDblMetamodel) {
//			'''
//			«IF parentIdExpr != null»
//				«parentIdExpr.genIdExprWithSyntaxPartReferences».
//			«ELSE»
//				_extensionInstance.
//			«ENDIF»
//			
//			«IF referencedElement != null»
//				get«
//				if (referencedElement.name.startsWith("_"))
//					referencedElement.name.substring(1).toFirstUpper
//				else
//					referencedElement.name.toFirstUpper
//				»()
//			«ELSE»
//				«genIdExpr_for_PredefinedId(predefinedId)»
//			«ENDIF»
//			'''
//		}
//		else {
//			if (parentIdExpr != null) {
//				parentIdExpr.genIdExprWithSyntaxPartReferences + "." + genIdExpr_for_ReferencedElement(referencedElement)
//			}
//			else {
//				genIdExpr_for_ReferencedElement(referencedElement)
//			}
//		}
//	}
	
	override String genIdExpr(IdExpr idExpr) {
		val it = idExpr
		'''
		«IF oneParentRefersToSyntaxPartOrDblMetamodel»
			«IF partOfGenStatement»
				getConcreteSyntax(«genIdExprWithSyntaxPartReferences»)
			«ELSE»
				«genIdExprWithSyntaxPartReferences»
			«ENDIF»
		«ELSE»
			«super.genIdExpr(idExpr)»
		«ENDIF»
		'''
	}
	
	override String genIdExpr_for_PredefinedId_meLiteral() {
		'_extensionInstance'
	}
	
	def dispatch String genPropertyType(PropertyType type) {
		'<unkown property type>'
	}
	
	def dispatch String genPropertyType(IntPropertyType type) {
		'Integer'
	}
	
	def dispatch String genPropertyType(StringPropertyType type) {
		'String'
	}
	
	def dispatch String genPropertyType(StructuredPropertyType type) {
		//type.type.genReferableRhsType
		'EObject'
	}
	
//	def dispatch String genReferableRhsType(ReferableRhsType type) {
//		type.name
//	}
//	
//	def dispatch String genReferableRhsType(Classifier type) {
//		type.genType
//	}
	
	override String genIdExpr_for_PropertyBindingExpr(IdExpr idExpr, PropertyBindingExpr referencedElement) {
		'''
		getPropertyValue(_extensionInstance ,"«referencedElement.name»")
		'''
	}
	
	def ExtensionDefinition getImportedExtensionDefinition(Model model, String name) {
		var ExtensionDefinition extDef;
		for (Import imprt: model.imports) {
			if (imprt.model != null) {
				for (Module module: imprt.model.modules) {
					extDef = module.extensionDefinitions.findFirst[
						e | ExtensionSyntaxDefinitionProcessor.getExtensionDefinitionSyntaxRuleName(e).equals(name)
					]
					if (extDef != null) return extDef
				}
				extDef = getImportedExtensionDefinition(imprt.model, name)
				if (extDef != null) return extDef
			}
		}
		return extDef
	}

	def ExtensionSemanticsDefinition getImportedExtensionSemanticsDefinition(Model model, String name) {
		var ExtensionSemanticsDefinition semanticsDef;
		for (Import imprt: model.imports) {
			if (imprt.model != null) {
				for (Module module: imprt.model.modules) {
					semanticsDef = module.extensionSemanticsDefinitions.findFirst[
						sd | ExtensionSyntaxDefinitionProcessor.getExtensionDefinitionSyntaxRuleName(sd.syntaxDefinition).equals(name)
					]
					if (semanticsDef != null) return semanticsDef
				}
				semanticsDef = getImportedExtensionSemanticsDefinition(imprt.model, name)
				if (semanticsDef != null) return semanticsDef
			}
		}
		return semanticsDef
	}
	
	def void genExtensionDefinition(Model model, String extensionDefinitionName) {
		// look for extension definition in all imported models
		//var ExtensionDefinition extensionDefinition = model.getImportedExtensionDefinition(extensionDefinitionName)
		val ExtensionSemanticsDefinition semanticsDef = model.getImportedExtensionSemanticsDefinition(extensionDefinitionName)
		
		if (semanticsDef != null) {
			model.genExtensionSemanticsDefinition(semanticsDef)
		}
	}
	
	def void genExtensionSemanticsDefinition(Model model, ExtensionSemanticsDefinition semanticsDef) {
		print("Generating Java code for extension definition " + semanticsDef.syntaxDefinition.name + " ... ");

		// generate Java code
		val Module module = semanticsDef.eContainer as Module;
		val moduleFolder = javaPackageFolder.append(module.name)
		makeFolder(moduleFolder)

		val String result = semanticsDef.genExtensionSemanticsDefinition
		if (result != null && result != "") {
			val Writer writer = beginTargetFile(moduleFolder, semanticsDef.syntaxDefinition.name + "Semantics.java");
			writer.write(result)
			endTargetFile(writer)
			println("ok.");
		}
	}

	def String genExtensionSemanticsDefinition(ExtensionSemanticsDefinition semanticsDef) {
		val it = semanticsDef
		
		if (statements.empty) {
			logger.severe("extension instance will not be replaced because semantics part of " + semanticsDef.syntaxDefinition.name + " is empty.")
		}
		
		'''
		«(semanticsDef.eContainer as Module).genPackageStatement»
		
		import hub.sam.dmx.AbstractExtensionSemantics;
		import hub.sam.dbl.*;
		import org.eclipse.emf.ecore.EObject;

		public class «syntaxDefinition.name»Semantics extends AbstractExtensionSemantics {

			public static void main(String[] args) {
				(new «syntaxDefinition.name»Semantics()).doGenerate(args);
			}


			public void doGenerate(EObject _extensionInstance) {
				«statements.gen»
			}

		}
		'''
	}
	
}