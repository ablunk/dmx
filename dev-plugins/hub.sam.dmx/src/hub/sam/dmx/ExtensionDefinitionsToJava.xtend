package hub.sam.dmx

import hub.sam.dbl.ExtensibleElement
import hub.sam.dbl.ExtensionDefinition
import hub.sam.dbl.IdExpr
import hub.sam.dbl.Import
import hub.sam.dbl.MappingStatement
import hub.sam.dbl.Model
import hub.sam.dbl.Module
import hub.sam.dbl.PropertyBindingExpr
import hub.sam.dbl.ReferableRhsType
import hub.sam.dbl.StructuredPropertyType
import hub.sam.dbl.Variable
import java.io.Writer
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.PropertyType
import hub.sam.dbl.Classifier
import hub.sam.dbl.IntPropertyType
import hub.sam.dbl.StringPropertyType
import hub.sam.dbl.Procedure

/**
 * Generates executable Java code for all extension definitions, which are
 * used by extensions directly contained in the given model file
 * (extension definitions available by import are not considered).
 */
class ExtensionDefinitionsToJava extends BasicDblToJavaGenerator {
	
	new(IPath outputFolder) {
		super(outputFolder)
	}
	
	def boolean refersToSyntaxPart(IdExpr idExpr) {
		val it = idExpr
		if (parentIdExpr == null) {
			return referencedElement instanceof PropertyBindingExpr
		}
		else
			return parentIdExpr.refersToSyntaxPart
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
				return type instanceof ReferableRhsType
			}
		}
		false
	}
	
	def String genSyntaxPartIdExpr(IdExpr idExpr) {
		val it = idExpr

		'''
		getPropertyValue(
		
		(EObject)
		«IF parentIdExpr != null»
			«parentIdExpr.genSyntaxPartIdExpr»,
		«ELSE»
			_extensionInstance,
		«ENDIF»
		
		«IF referencedElement != null»
			"«
			if (referencedElement.name.startsWith("get"))
				referencedElement.name.substring(3).toFirstLower
			else if (referencedElement.name.startsWith("is"))
				referencedElement.name.substring(2).toFirstLower
			else
				referencedElement.name
			»"
		«ELSE»
			«genIdExpr_for_PredefinedId(predefinedId)»
		«ENDIF»
		)
		'''
	}
	
	
	override String genIdExpr(IdExpr idExpr) {
		val it = idExpr
		//«IF refersToSyntaxPart && partOfGenStatement && (refersToSyntaxPart_ofType_StructuredPropertyType || refersToVariable_ofType_StructuredPropertyType)»
		'''
		«IF refersToSyntaxPart && partOfGenStatement»
			getConcreteSyntax(«genSyntaxPartIdExpr(idExpr)»)
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
					extDef = module.extensionDefs.findFirst[ e | e.name == name]
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