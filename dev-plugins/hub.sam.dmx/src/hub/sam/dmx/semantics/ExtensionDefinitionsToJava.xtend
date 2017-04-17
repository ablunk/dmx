package hub.sam.dmx.semantics

import hub.sam.dbl.Cast
import hub.sam.dbl.CreateIdStatement
import hub.sam.dbl.DblEObject
import hub.sam.dbl.ElementarySymbol
import hub.sam.dbl.ExpansionPart
import hub.sam.dbl.ExpansionStatement
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
import hub.sam.dbl.StringSymbol
import hub.sam.dbl.StructuralSymbolReference
import hub.sam.dbl.TypedElement
import hub.sam.dmx.editor.semantics.ExtensionSyntaxDefinitionProcessor
import java.io.Writer
import java.util.logging.Logger
import org.eclipse.emf.ecore.EObject

/**
 * Generates executable Java code for all extension definitions, which are
 * used by extensions directly contained in the given model file
 * (extension definitions available by import are not considered).
 */
class ExtensionDefinitionsToJava extends BasicDblToJavaGenerator {
	
	private static final Logger logger = Logger.getLogger(ExtensionDefinitionsToJava.getName());
	
	
	def void genExtensionDefinition(Model model, String extensionDefinitionName) {
		// look for extension definition in all imported models
		//var hub.sam.dbl.Extension extensionDefinition = model.getImportedExtensionDefinition(extensionDefinitionName)
		val ExtensionSemantics semanticsDef = model.getImportedExtensionSemanticsDefinition(extensionDefinitionName)
		
		if (semanticsDef !== null) {
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
		if (result !== null && result != "") {
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

	override String genType(DblEObject type) {
		if (type instanceof MetaSymbol || type.getContainerObjectOfType(Module).name.equals("dbl")) return "EObject"
		else super.genType(type)
	}
	
	private def <T> T getContainerObjectOfType(EObject object, Class<T> type) {
		if (type.isAssignableFrom(object.getClass())) return object as T
		else if (object.eContainer() === null) return null
		else return getContainerObjectOfType(object.eContainer(), type)
	}
	
	override def String genClassifierTypeExpr(IdExpr typeExpr) {
		if (typeExpr.refersToDblMetamodel) {
			"EObject"
		} else {
			typeExpr.referencedElement.genType
		}
	}
	
	private def boolean refersToDblMetamodel(IdExpr idExpr) {
		return idExpr.referencedElement?.getContainerObjectOfType(Module)?.name.equals("dbl")
	}
	
	override def dispatch String genExpr(Cast expr) {
		'''
		«IF expr.classifierType !== null && expr.classifierType.refersToDblMetamodel»
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
		
		if (differingContext === null) {
			'''expandAtExtensionPosition(
			«FOR part : parts SEPARATOR '+'»
				«part.genMappingPart»
			«ENDFOR»
			);'''
		} else {
			'''expandAfterPosition(
			«FOR part : parts SEPARATOR '+'»
				«part.genMappingPart»
			«ENDFOR»
			, «differingContext.genExpr»
			);'''
		}
	}
	
	def String genIdExprWithSyntaxPartReferences(IdExpr idExpr) {
		val it = idExpr

		if (directlyRefersToSyntaxPart || refersToDblMetamodel) {
			val referencedElementType = getTypeOfReferencedElement
			'''
			(
			«IF referencedElementType !== null»
				(«referencedElementType»)
			«ELSE»
				(EObject)
			«ENDIF»
			
				getPropertyValue(
				«IF parentIdExpr !== null»
					«parentIdExpr.genIdExprWithSyntaxPartReferences»
				«ELSE»
					(EObject) _extensionInstance
				«ENDIF»
				,
				«IF referencedElement !== null»
					"«referencedElement.name.withoutLeadingUnderscore»"
				«ELSE»
					«genIdExpr_for_PredefinedId(predefinedId)»
				«ENDIF»
				)
			)
			'''
		} else {
			if (parentIdExpr !== null) {
				parentIdExpr.genIdExprWithSyntaxPartReferences + "." + genIdExpr_for_ReferencedElement(referencedElement)
			} else {
				genIdExpr_for_ReferencedElement(referencedElement)
			}
		}
	}
	
	private def String withoutLeadingUnderscore(String value) {
		if (value.startsWith("_")) value.substring(1)
		else value
	}
	
	private def boolean directlyRefersToSyntaxPart(IdExpr idExpr) {
		return idExpr.referencedElement instanceof StructuralSymbolReference
	}
	
	override String genIdExpr(IdExpr idExpr) {
		val it = idExpr
		'''
		«IF oneParentRefersToSyntaxPartOrDblMetamodel»
			«IF implicitlyRefersToConcreteSyntax»
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
	
	private def boolean oneParentRefersToSyntaxPartOrDblMetamodel(IdExpr idExpr) {
		val it = idExpr

		if (idExpr.directlyRefersToSyntaxPart) {
			return true
		} else {
			if (referencedElement !== null && referencedElement instanceof TypedElement) {
				val typedReferencedElement = referencedElement as TypedElement
				if (referencedElement.getContainerObjectOfType(Module).name.equals("dbl")) {
					return true
				}
				else if (typedReferencedElement.classifierType !== null) {
					// local variable of DBL metaclass type
					return typedReferencedElement.classifierType.referencedElement.getContainerObjectOfType(Module).name.equals("dbl")
				}
			}
			
			if (parentIdExpr !== null) {
				return parentIdExpr.oneParentRefersToSyntaxPartOrDblMetamodel
			} else {
				return false
			}
		}
	}
	
	private def boolean implicitlyRefersToConcreteSyntax(IdExpr idExpr) {
		return idExpr.getContainerObjectOfType(ExpansionPart) !== null
	}
	
	private def String getTypeOfReferencedElement(IdExpr idExpr) {
		val referencedElement = idExpr.referencedElement
		
		if (referencedElement !== null) {
			if (referencedElement instanceof TypedElement) {
				val typedElement = referencedElement as TypedElement
				
				if (typedElement.classifierType !== null) {
					val referencedClassifierType = typedElement.classifierType.referencedElement
					
					// TODO this is really ugly
					if (referencedClassifierType.name.equals("List") || referencedClassifierType.name.equals("EList")
					) {
						return 'java.util.List'
					}
				} else if (typedElement.primitiveType !== null) {
					return typedElement.primitiveType.genWrappedType;
				}
			} else if (referencedElement instanceof StructuralSymbolReference) {
				val structuralSymbolRef = referencedElement as StructuralSymbolReference
				
				if (structuralSymbolRef.list) {
					return 'java.util.List'
				}

				val classifier = structuralSymbolRef.classifier
				
				if (classifier instanceof ElementarySymbol) {
					return classifier.genElementarySymbolType
				}
			}
		}
		return null
	}
	
	def dispatch String genElementarySymbolType(ElementarySymbol elementarySymbol) {
		null
	}
	
	def dispatch String genElementarySymbolType(Keyword elementarySymbol) {
		'Boolean'
	}

	def dispatch String genElementarySymbolType(StringSymbol elementarySymbol) {
		'String'
	}

	def dispatch String genElementarySymbolType(IntSymbol elementarySymbol) {
		'Integer'
	}

	def dispatch String genElementarySymbolType(IdSymbol elementarySymbol) {
		'String'
	}
	
	private def boolean refersToCreateIdStatement(IdExpr idExpr) {
		return idExpr.referencedElement instanceof CreateIdStatement
	}
	
	override String genIdExpr_for_PredefinedId_meLiteral() {
		'_extensionInstance'
	}
	
	override String genIdExpr_for_PropertyBindingExpr(IdExpr idExpr, StructuralSymbolReference referencedElement) {
		'''
		getPropertyValue(_extensionInstance ,"«referencedElement.name»")
		'''
	}
	
	def Extension getImportedExtensionDefinition(Model model, String name) {
		var Extension extDef;
		for (Import imprt: model.imports) {
			if (imprt.model !== null) {
				extDef = imprt.model.module.extensions.findFirst[
					e | ExtensionSyntaxDefinitionProcessor.getExtensionDefinitionSyntaxRuleName(e).equals(name)
				]
				if (extDef !== null) return extDef
				
				extDef = getImportedExtensionDefinition(imprt.model, name)
				if (extDef !== null) return extDef
			}
		}
		return extDef
	}

	def ExtensionSemantics getImportedExtensionSemanticsDefinition(Model model, String name) {
		var ExtensionSemantics semanticsDef;
		for (Import imprt: model.imports) {
			if (imprt.model !== null) {
				semanticsDef = imprt.model.module.extensionSemantics.findFirst[
					sd | ExtensionSyntaxDefinitionProcessor.getExtensionDefinitionSyntaxRuleName(sd.syntaxDefinition).equals(name)
				]
				if (semanticsDef !== null) return semanticsDef
				
				semanticsDef = getImportedExtensionSemanticsDefinition(imprt.model, name)
				if (semanticsDef !== null) return semanticsDef
			}
		}
		return semanticsDef
	}
	
}