package hub.sam.dmx.semantics

import hub.sam.dbl.Cast
import hub.sam.dbl.ComplexSymbol
import hub.sam.dbl.CreateIdStatement
import hub.sam.dbl.DblEObject
import hub.sam.dbl.ExpansionStatement
import hub.sam.dbl.ExtensibleElement
import hub.sam.dbl.Extension
import hub.sam.dbl.ExtensionSemantics
import hub.sam.dbl.IdExpr
import hub.sam.dbl.IdSymbol
import hub.sam.dbl.Import
import hub.sam.dbl.IntSymbol
import hub.sam.dbl.Keyword
import hub.sam.dbl.MetaSymbol
import hub.sam.dbl.Model
import hub.sam.dbl.Module
import hub.sam.dbl.PlainSymbolReference
import hub.sam.dbl.StringSymbol
import hub.sam.dbl.StructuralSymbolReference
import hub.sam.dbl.SyntaxSymbolClassifier
import hub.sam.dbl.TypedElement
import hub.sam.dbl.Variable
import hub.sam.dmx.editor.semantics.ExtensionSyntaxDefinitionProcessor
import java.io.Writer
import java.util.logging.Logger
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject

/**
 * Generates executable Java code for all extension definitions, which are
 * used by extensions directly contained in the given model file
 * (extension definitions available by import are not considered).
 */
class ExtensionDefinitionsToJava extends BasicDblToJavaGenerator {
	
	private static final Logger logger = Logger.getLogger(ExtensionDefinitionsToJava.getName());
	
	def boolean oneParentRefersToSyntaxPartOrDblMetamodel(IdExpr idExpr) {
		val it = idExpr
		if (referencedElement instanceof StructuralSymbolReference) {
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
		return referencedElement instanceof StructuralSymbolReference
	}
	
	def boolean refersToDblMetamodel(IdExpr idExpr) {
		val it = idExpr
		if (referencedElement != null) {
			val containerModule = referencedElement.getContainerObjectOfType(Module)
			return containerModule.name.equals("dbl")
		}
		return false
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
		if (referencedElement instanceof StructuralSymbolReference) {
			return (referencedElement as StructuralSymbolReference).classifier instanceof ComplexSymbol
		}
		else false
	}
	
	def boolean refersToVariable_ofType_StructuredPropertyType(IdExpr idExpr) {
		val it = idExpr
		if (referencedElement instanceof Variable) {
			val variable = referencedElement as Variable;
			if (variable.classifierType != null) {
				val type = variable.classifierType.referencedElement
				return type instanceof SyntaxSymbolClassifier
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
			else if (referencedElement instanceof StructuralSymbolReference) {
				val structuralSymbolRef = referencedElement as StructuralSymbolReference
				return structuralSymbolRef.list
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
			else if (referencedElement instanceof PlainSymbolReference) {
				val symbolRef = referencedElement as PlainSymbolReference
				val classifier = symbolRef.classifier
				return classifier instanceof IdSymbol || classifier instanceof StringSymbol || classifier instanceof IntSymbol
					|| classifier instanceof Keyword
			}
		}
		return false
	}
	
	override String genType(DblEObject type) {
		if (type instanceof MetaSymbol || type.getContainerObjectOfType(Module).name.equals("dbl")) return "EObject"
		else super.genType(type)
	}
	
	override def String genClassifierTypeExpr(IdExpr typeExpr) {
		if (typeExpr.refersToDblMetamodel) {
			"EObject"
		}
		else {
			typeExpr.referencedElement.genType
		}
	}
	
	override def dispatch String genExpr(Cast expr) {
		// TODO metaclass must be checked for EObjects !!
		'''
		«IF expr.classifierType != null && expr.classifierType.refersToDblMetamodel»
			((EObject) «expr.op.genExpr»)
		«ELSE»
			((«expr.genType») «expr.op.genExpr»)
		«ENDIF»
		'''
	}
	
	def dispatch String genStatement(CreateIdStatement createIdStatement) {
		val it = createIdStatement		
		'''
		String «name» = getUniqueID("«name»");
		'''
	}
	
	override def dispatch String genStatement(ExpansionStatement stm) {
		val it = stm
		
		if (differingContext == null) {
			'''expandAtExtensionPosition(
			«FOR part : parts SEPARATOR '+'»
				«part.genMappingPart»
			«ENDFOR»
			);'''
		}
		else {
			'''expandAtDifferentPosition(
			«FOR part : parts SEPARATOR '+'»
				«part.genMappingPart»
			«ENDFOR»
			, «differingContext.genExpr»
			);'''
			// TODO Needs to be tested!
		}
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
		«ELSEIF refersToCreateIdStatement»
			getUniqueID("«idExpr.referencedElement.name»")
		«ELSE»
			«super.genIdExpr(idExpr)»
		«ENDIF»
		'''
	}
	
	def boolean refersToCreateIdStatement(IdExpr idExpr) {
		idExpr.referencedElement instanceof CreateIdStatement
	}
	
	override String genIdExpr_for_PredefinedId_meLiteral() {
		'_extensionInstance'
	}
	
//	def dispatch String genPropertyType(PropertyType type) {
//		'<unkown property type>'
//	}
//	
//	def dispatch String genPropertyType(IntSymbol type) {
//		'Integer'
//	}
//	
//	def dispatch String genPropertyType(StringSymbol type) {
//		'String'
//	}
//	
//	def dispatch String genPropertyType(StructuredPropertyType type) {
//		//type.type.genReferableRhsType
//		'EObject'
//	}
	
//	def dispatch String genReferableRhsType(ReferableRhsType type) {
//		type.name
//	}
//	
//	def dispatch String genReferableRhsType(Classifier type) {
//		type.genType
//	}
	
	override String genIdExpr_for_PropertyBindingExpr(IdExpr idExpr, StructuralSymbolReference referencedElement) {
		'''
		getPropertyValue(_extensionInstance ,"«referencedElement.name»")
		'''
	}
	
	def Extension getImportedExtensionDefinition(Model model, String name) {
		var Extension extDef;
		for (Import imprt: model.imports) {
			if (imprt.model != null) {
				for (Module module: imprt.model.modules) {
					extDef = module.extensions.findFirst[
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

	def ExtensionSemantics getImportedExtensionSemanticsDefinition(Model model, String name) {
		var ExtensionSemantics semanticsDef;
		for (Import imprt: model.imports) {
			if (imprt.model != null) {
				for (Module module: imprt.model.modules) {
					semanticsDef = module.extensionSemantics.findFirst[
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
		//var hub.sam.dbl.Extension extensionDefinition = model.getImportedExtensionDefinition(extensionDefinitionName)
		val ExtensionSemantics semanticsDef = model.getImportedExtensionSemanticsDefinition(extensionDefinitionName)
		
		if (semanticsDef != null) {
			model.genExtensionSemanticsDefinition(semanticsDef)
		}
	}
	
	def void genExtensionSemanticsDefinition(Model model, ExtensionSemantics semanticsDef) {
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

	def String genExtensionSemanticsDefinition(ExtensionSemantics semanticsDef) {
		val it = semanticsDef
		
		if (statements.empty) {
			logger.severe("extension instance will not be replaced because semantics part of " + semanticsDef.syntaxDefinition.name + " is empty.")
		}
		
		'''
		«(semanticsDef.eContainer as Module).genPackageStatement»
		
		import hub.sam.dmx.semantics.AbstractExtensionSemantics;
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