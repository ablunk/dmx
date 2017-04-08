package hub.sam.dmx.semantics

import hub.sam.dbl.AbstractVariable
import hub.sam.dbl.And
import hub.sam.dbl.Assignment
import hub.sam.dbl.BinaryOperator
import hub.sam.dbl.BoolType
import hub.sam.dbl.BreakStatement
import hub.sam.dbl.Cast
import hub.sam.dbl.Class
import hub.sam.dbl.ContinueStatement
import hub.sam.dbl.CreateObject
import hub.sam.dbl.Div
import hub.sam.dbl.DoubleLiteral
import hub.sam.dbl.DoubleType
import hub.sam.dbl.Equal
import hub.sam.dbl.ExpandTextPart
import hub.sam.dbl.ExpandVariablePart
import hub.sam.dbl.ExpansionPart
import hub.sam.dbl.ExpansionStatement
import hub.sam.dbl.Expression
import hub.sam.dbl.Extension
import hub.sam.dbl.FalseLiteral
import hub.sam.dbl.ForStatement
import hub.sam.dbl.Function
import hub.sam.dbl.FunctionCall
import hub.sam.dbl.Greater
import hub.sam.dbl.GreaterEqual
import hub.sam.dbl.IdExpr
import hub.sam.dbl.IfStatement
import hub.sam.dbl.InstanceOf
import hub.sam.dbl.IntLiteral
import hub.sam.dbl.IntType
import hub.sam.dbl.Less
import hub.sam.dbl.LessEqual
import hub.sam.dbl.LocalScopeStatement
import hub.sam.dbl.MeLiteral
import hub.sam.dbl.Minus
import hub.sam.dbl.Mod
import hub.sam.dbl.Model
import hub.sam.dbl.Module
import hub.sam.dbl.Mul
import hub.sam.dbl.NamedElement
import hub.sam.dbl.Neg
import hub.sam.dbl.Not
import hub.sam.dbl.NotEqual
import hub.sam.dbl.NullLiteral
import hub.sam.dbl.Or
import hub.sam.dbl.Parameter
import hub.sam.dbl.Plus
import hub.sam.dbl.PredefinedId
import hub.sam.dbl.Print
import hub.sam.dbl.Return
import hub.sam.dbl.SizeOfArray
import hub.sam.dbl.Statement
import hub.sam.dbl.StringLiteral
import hub.sam.dbl.StringType
import hub.sam.dbl.StructuralSymbolReference
import hub.sam.dbl.SuperLiteral
import hub.sam.dbl.SwitchStatement
import hub.sam.dbl.SyntaxSymbolClassifier
import hub.sam.dbl.TrueLiteral
import hub.sam.dbl.Type
import hub.sam.dbl.TypeAccess
import hub.sam.dbl.TypedElement
import hub.sam.dbl.Variable
import hub.sam.dbl.VariableAccess
import hub.sam.dbl.VoidType
import hub.sam.dbl.WhileStatement
import java.io.Writer
import java.util.List
import java.util.regex.Matcher
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject

/**
 * Generates Java code for the specified model only (i.e. imported models are not considered).
 */
class BasicDblToJavaGenerator extends AbstractGenerator {
	
	public val javaPackagePrefix = "hub.sam.dmx.javasim.gen"
	public val javaPackageFolderPrefix = javaPackagePrefix.replaceAll("\\.", "/")
	public var IPath javaPackageFolder;
	
	protected val javaClass_for_ModuleLevelElements = "Module_"
	
	new(IPath outputFolder) {
		super(outputFolder)

		javaPackageFolder = outputFolder.append(javaPackageFolderPrefix)
		makeFolder(javaPackageFolder);
	}
	
	def String genActiveClass(Class clazz) {
		'<! active classes are not support in basic DBL models !>'
	}

	def String genModuleWithMainProcedure(Module module) {
		val it = module
		'''
		«genPackageStatement»

		public class «javaClass_for_ModuleLevelElements» {
			
			public static void startMainProcedure() {
				main();
			}
		
			«variables.genVariables(true)»
			
			«functions.genFunctions(true)»
		}
		'''
	}
	
	def String getSimLibName() {
		''
	}
	
	def String getLanguageName() {
		'java'
	}

	// forward generation of other elements to more specific generators
	def String forwardGen(EObject eObj) {
		'<! unknown element ' + eObj.eClass.name ' !>'
	}
	
	def String javaNameQualified_for_Module(Module element, boolean forContentAccess) {
		val it = element
		if (forContentAccess) javaPackagePrefix + "." + name + "." + javaClass_for_ModuleLevelElements
		else javaPackagePrefix + "." + name
	}

	def dispatch String javaNameQualified(Extension element) {
		val it = element
		val owner = element.eContainer as Module;
		owner.javaNameQualified_for_Module(false) + "." + name
	}

	def dispatch String javaNameQualified(Class element) {
		val it = element
		if (bindings.empty) {
			val owner = element.eContainer as Module;
			owner.javaNameQualified_for_Module(false) + "." + name
		}
		else javaNameBound
	}
	
	def String javaNameBound(Class clazz) {
		val it = clazz
		var targetType = bindings.findFirst[targetLanguage == simLibName]?.targetType
		if (targetType != null) targetType
		else {
			targetType = bindings.findFirst[targetLanguage == languageName]?.targetType
			if (targetType != null) targetType
			else '<!- type binding for library ' + simLibName + ' is missing for type ' + clazz.name + ' !>'
		}		
	}

	def dispatch String javaNameQualified(Function element) {
		element.javaNameQualified_for_ProcedureVariable
	}
	
	def dispatch String javaNameQualified(AbstractVariable element) {
		element.javaNameQualified_for_ProcedureVariable
	}
	
	def String javaNameQualified_for_ProcedureVariable(NamedElement element) {
		val it = element
		if (element.eContainer instanceof Module) {
			val owner = element.eContainer as Module;
			owner.javaNameQualified_for_Module(true) + "." + name
		}
		else name
	}

	override void genModel(Model model, boolean mainModel) {
		val Module moduleWithMainProcedure = if (mainModel) model.modules.findFirst[ functions.exists[ name == 'main' ] ] else null
		
		model.modules.forEach[ module | 
			val moduleFolder = javaPackageFolder.append(module.name)
			makeFolder(moduleFolder)

			val Writer moduleWriter = beginTargetFile(moduleFolder, javaClass_for_ModuleLevelElements + ".java");
			moduleWriter.write(
				if (moduleWithMainProcedure == null || module != moduleWithMainProcedure) module.gen
				else module.genModuleWithMainProcedure
			)
			endTargetFile(moduleWriter)
			
			module.classes.forEach[ class_ |
				val String result = class_.gen
				if (result != null && result != "") {
					val Writer classifierWriter = beginTargetFile(moduleFolder, class_.name + ".java");
					classifierWriter.write(result)
					endTargetFile(classifierWriter)
				}
			]
		]
		
		if (mainModel && moduleWithMainProcedure != null) {
			// main Java class with main function
			val Writer javaMain = beginTargetFile(javaPackageFolder, "JavaMain.java");
			javaMain.write(
				'''
				package «javaPackagePrefix»;
				
				public class JavaMain {
					public static void main(String[] args) {
						long startTime = System.nanoTime();
				
						«moduleWithMainProcedure.javaNameQualified_for_Module(true)».startMainProcedure();
				
						long estimatedTime = System.nanoTime() - startTime;
						long ms = estimatedTime / (1000 * 1000);
						System.out.println("Execution time: " + ms / 1000.0 + " seconds");

						Runtime runtime = Runtime.getRuntime();
						long memory = runtime.totalMemory() - runtime.freeMemory();
						System.out.println("Memory Usage: " +  memory/1024.0/1024 + " MB");

						System.exit(0);
					}
				}
				'''			
			);
			endTargetFile(javaMain);
		}
	}
	
	def dispatch String gen(Void e) {
		''
	}
	
	def boolean isMainModule(Module module) {
		module.functions.exists[name == 'main']
	}
	
	def dispatch String gen(Module module) {
		val it = module;		
		// TODO import types used in this module
		'''
		«genPackageStatement»
		
		public class «javaClass_for_ModuleLevelElements» {
			«variables.genVariables(true)»
			
			«functions.genFunctions(true)»
		}
		'''
	}
	
	def String genVariables(List<Variable> variables, boolean setStatic) {
		'''
		«FOR variable : variables»
			public «IF setStatic»static«ENDIF» «variable.gen»
		«ENDFOR»
		'''
	}
	
	def String genFunctions(List<Function> functions, boolean setStatic) {
		'''
		«FOR p : functions»
			public «IF setStatic»static«ENDIF» «p.gen»
		«ENDFOR»
		'''
	}

	def dispatch String gen(Statement stm) {
		stm.genStatement
	}
	
	def dispatch String genStatement(Statement stm) {
		//'<! unsupported statement ' + stm.eClass.name + ' !>'
		stm.forwardGen
	}
	
	def dispatch String genStatement(FunctionCall call) {
		call.callIdExpr.genExpr + ';'
	}
	
	def dispatch String genStatement(Print print) {
		'''
		System.out.print(
		«FOR expr : print.outputs SEPARATOR '+'»
			«expr.genExpr»
		«ENDFOR»
		);
		'''
	}
	
	def dispatch String genStatement(IfStatement ifStm) {
		val it = ifStm
		'''
		if («condition.genExpr»)
			«trueCase.gen»
		«IF falseCase != null»
		else
			«falseCase.gen»
		«ENDIF»
		'''
	}
	
	def dispatch String genStatement(LocalScopeStatement stm) {
		'''{«stm.statements.gen»}'''
	}

	def dispatch String genStatement(Assignment stm) {
		stm.genAssignment(true)
	}
	
	def String genAssignment(Assignment stm, boolean genSemicolon) {
		val it = stm
		'''
		«variable.genExpr» = «value.genExpr»
		«IF genSemicolon»;«ENDIF»
		'''
	}
	
	def dispatch String genStatement(Return stm) {
		'''return «stm.value.genExpr»;'''
	}

	def dispatch String genStatement(BreakStatement stm) {
		'break;'
	}

	def dispatch String genStatement(ContinueStatement stm) {
		'continue;'
	}

	def dispatch String genStatement(SwitchStatement stm) {
		val it = stm
		'''
		switch («variable.genExpr») {
			«FOR c : cases»
			case «c.value.genExpr»:
				«c.body.gen»
			«ENDFOR»
			«IF defaultCase != null»
			default:
				«defaultCase.body.gen»
			«ENDIF»
		}
		'''
	}
	
	def dispatch String genStatement(ForStatement stm) {
		// it is better to provide for as a basic statement as GPL compilers
		// provide optimizations for it.
		val it = stm
		'''
		for (
			«statements.head.gen»

			«termination.genExpr»
			;
			«increment.genAssignment(false)»
		)
		«body.gen»
		'''
	}

	def dispatch String genStatement(WhileStatement stm) {
		val it = stm
		'''while («condition.genExpr»)
			«body.gen»
		'''
	}

	def dispatch String genStatement(ExpansionStatement stm) {
		'''<!-- expand is not allowed outside extension semantics definitions -->'''
	}
	
	def dispatch String genMappingPart(ExpansionPart part) {
		'< unknown mapping part >'
	}

	def dispatch String genMappingPart(ExpandTextPart part) {
		quoteJavaString(part.text)
	}

	def dispatch String genMappingPart(ExpandVariablePart part) {
		part.expr.genExpr
	}

	def dispatch String genStatement(Variable variable) {
		val it = variable
		//val ListDimension ldim1 = if (isList && listDims.size() == 1) listDims.get(1) else null;
		
		'''
		«genType» «name»
		«IF initialValue != null»
			= «initialValue.genExpr»
		«ELSEIF classifierType != null»
			= null
		«ENDIF»
		;
		'''
	}
	
	def dispatch String genExpr(Expression expr) {
		//'<! unknown expression ' + expr.eClass.name + ' !>'
		expr.forwardGen
	}
	
	def dispatch String genExpr(Void expr) {
		''
	}
	
	def dispatch String genExpr(Or expr) {
		expr.genBinaryExpr("||")
	}
	
	def dispatch String genExpr(And expr) {
		expr.genBinaryExpr("&&")
	}
	
	def dispatch String genExpr(Equal expr) {
		expr.genBinaryExpr("==")
	}
	
	def dispatch String genExpr(NotEqual expr) {
		expr.genBinaryExpr("!=")
	}
	
	def dispatch String genExpr(Greater expr) {
		expr.genBinaryExpr(">")
	}
	
	def dispatch String genExpr(GreaterEqual expr) {
		expr.genBinaryExpr(">=")
	}
	
	def dispatch String genExpr(Less expr) {
		expr.genBinaryExpr("<")
	}
	
	def dispatch String genExpr(LessEqual expr) {
		expr.genBinaryExpr("<=")
	}
	
	def dispatch String genExpr(Plus expr) {
		expr.genBinaryExpr("+")
	}
	
	def dispatch String genExpr(Minus expr) {
		expr.genBinaryExpr("-")
	}

	def dispatch String genExpr(Mul expr) {
		expr.genBinaryExpr("*")
	}
	
	def dispatch String genExpr(Div expr) {
		expr.genBinaryExpr("/")
	}
	
	def dispatch String genExpr(Mod expr) {
		expr.genBinaryExpr("%")
	}
	
	def dispatch String genExpr(Neg expr) {
		'''(-«expr.op.genExpr»)'''
	}
	
	def dispatch String genExpr(Not expr) {
		'''(!«expr.op.genExpr»)'''
	}
	
	def dispatch String genExpr(Cast expr) {
		'''((«expr.genType») «expr.op.genExpr»)'''
	}
	
	def dispatch String genExpr(TypeAccess expr) {
		expr.idExpr.genClassifierTypeExpr
	}
	
	def dispatch String genExpr(VariableAccess expr) {
		expr.idExpr.genExpr
	}

	def dispatch String genExpr(StringLiteral expr) {
		quoteJavaString(expr.value)
	}
	
	def String quoteJavaString(String s) {
		if (s.contains('\r\n')) '''"«s.replaceAll('\r\n', '\\\\r\\\\n"+\r\n"')»"'''
		else '''"«s.replaceAll('\n','\\\\r\\\\n"+\r\n"')»"'''
	}
	
	def dispatch String genExpr(IntLiteral expr) {
		expr.value.toString
	}
	
	def dispatch String genExpr(InstanceOf expr) {
		"(" + expr.op1.genExpr + " instanceof " + expr.op2.genExpr + ")"
	}
	
	def dispatch String genExpr(TrueLiteral expr) {
		'true'
	}
	
	def dispatch String genExpr(FalseLiteral expr) {
		'false'
	}
	
	def dispatch String genExpr(DoubleLiteral expr) {
		expr.value.toString
	}
	
	def dispatch String genExpr(NullLiteral expr) {
		'null'
	}
	
	def String genBinaryExpr(BinaryOperator expr, String op) {
		val it = expr
		'''(«op1.genExpr» «op» «op2.genExpr»)'''
	}

	def dispatch String genExpr(CreateObject expr) {
		val it = expr
		'''
		(
			new «genType(true)»
			«IF classifierType != null»
				«IF typeArrayDimensions.empty»
				(
					«IF classifierType.callPart != null»
						«FOR arg : classifierType.callPart.callArguments SEPARATOR ','»
							«arg.genExpr»
						«ENDFOR»
					«ENDIF»
				)
				«ELSEIF classifierType.callPart != null»
					<! arrays of a class type cannot be initialized by a general constructor call !>
				«ENDIF»
			«ENDIF»
		)
		'''
	}
	
	def dispatch String genExpr(IdExpr idExpr) {
		idExpr.genIdExpr
	}

	def String genIdExpr(IdExpr idExpr) {
		val it = idExpr

		'''
		«IF parentIdExpr != null»
			«parentIdExpr.genIdExpr».
		«ENDIF»
		
		«IF referencedElement != null»
			«genIdExpr_for_ReferencedElement(referencedElement)»
		«ELSE»
			«genIdExpr_for_PredefinedId(predefinedId)»
		«ENDIF»
		'''
	}
	
	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, PredefinedId predefinedId) {
		'<! unsupported PredefinedId !>'
	}
	
	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, MeLiteral predefinedId) {
		genIdExpr_for_PredefinedId_meLiteral
	}

	def String genIdExpr_for_PredefinedId_meLiteral() {
		'this'
	}
	
	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SuperLiteral predefinedId) {
		'super'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SizeOfArray predefinedId) {
		if (idExpr.callPart == null) 'length'
		else 'length()'
	}

	def dispatch String genIdExpr_for_ReferencedElement(IdExpr idExpr, NamedElement referencedElement) {
		'''
		«referencedElement.javaNameQualified»
		«IF idExpr.callPart != null»
			(
			«FOR arg : idExpr.callPart.callArguments SEPARATOR ','»
				«arg.genExpr»
			«ENDFOR»
			)
		«ENDIF»
		«FOR index : idExpr.arrayIndex»
			[«index.genExpr»]
		«ENDFOR»
		'''
	}	
	
	def dispatch String genIdExpr_for_ReferencedElement(IdExpr idExpr, StructuralSymbolReference referencedElement) {
		idExpr.genIdExpr_for_PropertyBindingExpr(referencedElement)
	}
	
	def String genIdExpr_for_PropertyBindingExpr(IdExpr idExpr, StructuralSymbolReference referencedElement) {
		// empty for DBL models
	}
	
	def dispatch String genType(TypedElement typedElement) {
		typedElement.genType(false)
	}

	def String genType(TypedElement typedElement, boolean genArraySizeDimensions) {
		val it = typedElement
		'''
		«IF primitiveType != null»
			«primitiveType.genType»
		«ELSE»
			«classifierType.genClassifierTypeExpr»
		«ENDIF»
		«IF !typeArrayDimensions.empty»
			«FOR dim : typeArrayDimensions»
				[«IF genArraySizeDimensions»«dim.size.genExpr»«ENDIF»]
			«ENDFOR»
		«ENDIF»
		'''
	}
	
//	def String genTypeWrapListPrimitives(TypedElement typedElement) {
//		val it = typedElement
//		primitiveType?.genWrappedType
//		classifierType?.genClassifierTypeExpr
//	}
//	
//	def String genTypeNoWrapOfListPrimitives(TypedElement typedElement) {
//		val it = typedElement
//		if (primitiveType != null) return primitiveType.genType
//		else return classifierType.genClassifierTypeExpr
//	}
	
	def String genClassifierTypeExpr(IdExpr typeExpr) {
		typeExpr.referencedElement.genType
	}

	def dispatch String genType(SyntaxSymbolClassifier symbolClassifier) {
		symbolClassifier.name
	}
	
	def String genModulePrefix(EObject element) {
		val it = element
		'''
		«IF eContainer instanceof Module»
			«javaPackagePrefix».
			«(eContainer as Module).name».
		«ENDIF»
		'''		
	}
	
	def dispatch String genType(Class type) {
		type.javaNameQualified
	}

	def dispatch String genType(Type type) {
		'<! unknown type ' + type.eClass.name + ' !>'
	}
	
	def dispatch String genType(IntType type) {
		'int'
	}
	
	def dispatch String genType(VoidType type) {
		'void'
	}
	
	def dispatch String genType(StringType type) {
		'String'
	}
	
	def dispatch String genType(BoolType type) {
		'boolean'
	}
	
	def dispatch String genType(DoubleType type) {
		'double'
	}
	
	def dispatch String genWrappedType(Type type) {
		'<! unknown type ' + type.eClass.name + ' !>'
	}
	
	def dispatch String genWrappedType(IntType type) {
		'Long'
	}
	
	def dispatch String genWrappedType(VoidType type) {
		'void'
	}
	
	def dispatch String genWrappedType(StringType type) {
		'String'
	}
	
	def dispatch String genWrappedType(BoolType type) {
		'Boolean'
	}
	
	def dispatch String genWrappedType(DoubleType type) {
		'Double'
	}
	
	def dispatch String gen(List<Statement> statements) {
		'''
		«FOR stm : statements»
			«stm.genStatement»
		«ENDFOR»
		'''
	}
	
	def String removeAllNewLinesAndTrim(String str) {
		str.replaceAll(Matcher.quoteReplacement("\n"),"")
	}
	
	def dispatch String gen(Function function) {
		val it = function
		'''
		«genType» «name»(
		«FOR param : parameters SEPARATOR ','»
			«param.genType» «param.name»
		«ENDFOR»
		) {
			«statements.gen»
		}
		'''
	}
	
	def dispatch String gen(Class clazz) {
		val it = clazz
		if (clazz.bindings.empty) {
			if (clazz.active) genActiveClass
			else genPassiveClass
		}
	}
	
	def dispatch String gen(Parameter param) {
		val it = param
		'''«genType» «name»'''
	}
	
	def String genPackageStatement(Module module) {
		'''
		package «module.javaNameQualified_for_Module(false)»;
		'''
	}

	def String genPackageStatement(Class clazz) {
		'''
		package «(clazz.eContainer as Module).javaNameQualified_for_Module(false)»;
		'''
	}
	
	def String genPassiveClass(Class clazz) {
		val it = clazz
		val superClassExpr = clazz.superClass
		'''
		«genPackageStatement»
		
		public class «name»
		«IF superClassExpr != null»
			extends «superClassExpr.genClassifierTypeExpr»
		«ENDIF»
		{

			«FOR constructor: constructors»
				public «name»(
				«FOR cparam: constructor.parameters SEPARATOR ','»
					«cparam.gen»
				«ENDFOR»
				) {
					«constructor.statements.gen»
				}
			«ENDFOR»

			«attributes.genVariables(false)»

			«methods.genFunctions(false)»
		}
		'''
	}
		
}