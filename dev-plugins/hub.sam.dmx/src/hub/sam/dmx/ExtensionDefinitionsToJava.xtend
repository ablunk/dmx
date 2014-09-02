package hub.sam.dmx

import hub.sam.dbl.ExtensibleElement
import hub.sam.dbl.ExtensionDefinition
import hub.sam.dbl.IdExpr
import hub.sam.dbl.Import
import hub.sam.dbl.IntPropertyType
import hub.sam.dbl.MappingStatement
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

/**
 * Generates executable Java code for all extension definitions, which are
 * used by extensions directly contained in the given model file
 * (extension definitions available by import are not considered).
 */
class ExtensionDefinitionsToJava extends BasicDblToJavaGenerator {
	
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
				val referencedElementClassifierType = typedReferencedElement.classifierType
				if (referencedElementClassifierType != null) {
					val dblType = referencedElementClassifierType.referencedElement.getContainerObjectOfType(Module).name.equals("dbl")
					if (dblType) return true;
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
		return idExpr.getContainerObjectOfType(MappingStatement) != null
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
					extDef = module.extensionDefs.findFirst[ e | (e.name + "_" + e.textualSyntaxDef.startRule.name).equals(name)]
					if (extDef != null) return extDef
				}
				extDef = getImportedExtensionDefinition(imprt.model, name)
				if (extDef != null) return extDef
			}
		}
		return extDef
	}
	
	def void genExtensionDefinition(Model model, String extensionDefinitionName) {
		// look for extension definition in all imported models
		var ExtensionDefinition extensionDefinition = model.getImportedExtensionDefinition(extensionDefinitionName)
		
		if (extensionDefinition != null) {
			model.genExtensionDefinition(extensionDefinition)
		}
	}
	
	def void genExtensionDefinition(Model model, ExtensionDefinition extensionDefinition) {
		print("Generating Java code for extension definition " + extensionDefinition.name + " ... ");

		// generate Java code
		val Module module = extensionDefinition.eContainer as Module;
		val moduleFolder = javaPackageFolder.append(module.name)
		makeFolder(moduleFolder)

		val String result = extensionDefinition.genExtensionDefinition
		if (result != null && result != "") {
			val Writer writer = beginTargetFile(moduleFolder, extensionDefinition.name + "Semantics.java");
			writer.write(result)
			endTargetFile(writer)
			println("ok.");
		}
	}

	def String genExtensionDefinition(ExtensionDefinition extensionDefinition) {
		val it = extensionDefinition
		
		'''
		«(extensionDefinition.eContainer as Module).genPackageStatement»
		
		import hub.sam.dmx.AbstractExtensionSemantics;
		import hub.sam.dbl.*;
		import org.eclipse.emf.ecore.EObject;

		public class «name»Semantics extends AbstractExtensionSemantics {

			public static void main(String[] args) {
				(new «name»Semantics()).doGenerate(args);
			}


			public void doGenerate(EObject _extensionInstance) {
				«mappingDef.genStatement»
			}

		}
		'''
	}
	
}