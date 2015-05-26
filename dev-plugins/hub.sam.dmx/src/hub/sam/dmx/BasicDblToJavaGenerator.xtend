package hub.sam.dmx

import hub.sam.dbl.ActivateObject
import hub.sam.dbl.ActiveLiteral
import hub.sam.dbl.Advance
import hub.sam.dbl.And
import hub.sam.dbl.Assignment
import hub.sam.dbl.BinaryOperator
import hub.sam.dbl.BoolType
import hub.sam.dbl.BreakStatement
import hub.sam.dbl.Cast
import hub.sam.dbl.Classifier
import hub.sam.dbl.Clazz
import hub.sam.dbl.ContinueStatement
import hub.sam.dbl.CreateObject
import hub.sam.dbl.Div
import hub.sam.dbl.DoubleLiteral
import hub.sam.dbl.DoubleType
import hub.sam.dbl.Equal
import hub.sam.dbl.Expression
import hub.sam.dbl.FalseLiteral
import hub.sam.dbl.ForStatement
import hub.sam.dbl.Greater
import hub.sam.dbl.GreaterEqual
import hub.sam.dbl.IdExpr
import hub.sam.dbl.IfStatement
import hub.sam.dbl.IntLiteral
import hub.sam.dbl.IntType
import hub.sam.dbl.Less
import hub.sam.dbl.LessEqual
import hub.sam.dbl.LocalScopeStatement
import hub.sam.dbl.MappingStatement
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
import hub.sam.dbl.Plus
import hub.sam.dbl.PredefinedId
import hub.sam.dbl.Print
import hub.sam.dbl.Procedure
import hub.sam.dbl.ProcedureCall
import hub.sam.dbl.PropertyBindingExpr
import hub.sam.dbl.Reactivate
import hub.sam.dbl.ResetGenContextStatement
import hub.sam.dbl.Return
import hub.sam.dbl.SetGenContextStatement
import hub.sam.dbl.SizeOfArray
import hub.sam.dbl.Statement
import hub.sam.dbl.StringLiteral
import hub.sam.dbl.StringType
import hub.sam.dbl.SuperLiteral
import hub.sam.dbl.SwitchStatement
import hub.sam.dbl.TimeLiteral
import hub.sam.dbl.TrueLiteral
import hub.sam.dbl.Type
import hub.sam.dbl.TypeAccess
import hub.sam.dbl.TypedElement
import hub.sam.dbl.Variable
import hub.sam.dbl.VariableAccess
import hub.sam.dbl.VoidType
import hub.sam.dbl.Wait
import hub.sam.dbl.WhileStatement
import hub.sam.dbl.Yield
import java.io.Writer
import java.util.List
import java.util.regex.Matcher
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.MappingPart
import hub.sam.dbl.FixedMappingPart
import hub.sam.dbl.DynamicMappingPart
import hub.sam.dbl.ExtensionDefinition
import hub.sam.dbl.LanguageConstructClassifier
import hub.sam.dbl.AbstractVariable
import hub.sam.dbl.InstanceOf

class DblToDesmojJavaGenerator extends BasicDblToJavaGenerator {
	
	new(IPath outputFolder) {
		super(outputFolder)
	}
	
	override def String genModuleWithMainProcedure(Module module) {
		val it = module
		
		val mainProcedure = procedures.findFirst[name == 'main']
		
		'''
		«genPackageStatement»
		
		import hub.sam.dmx.javasim.desmoj.SimulationProcess;
		import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
		
		public class «javaClass_for_ModuleLevelElements» extends SimulationProcess {
			
			public «javaClass_for_ModuleLevelElements»() {
				super("Main procedure in module '«name»'");
			}
			
			public void base_actions() {
				main();
				
				// simulations are stopped when main terminates
				getModel().getExperiment().stop();
			}

			public static void startMainProcedure() {
				«javaClass_for_ModuleLevelElements» mainProcess = new «javaClass_for_ModuleLevelElements»();
				DefaultSimulation.DEFAULT.addInitialProcess(mainProcess);
				DefaultSimulation.DEFAULT.start(0);
			}
		
			«variables.genVariables(true)»
			
			«procedures.filter[ p | p != mainProcedure ].toList.genProcedures(true)»
			
			public «mainProcedure.gen»
		}
		'''
	}
	
	override getSimLibName() {
		'desmoj'
	}
	
	override def String genActiveClass(Clazz clazz) {
		val it = clazz
		'''
		«genPackageStatement»
		
		import hub.sam.dmx.javasim.desmoj.SimulationProcess;
		import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
			
		public class «name»
		«IF superClasses.size > 1»
			<! multiple inheritance is not supported for Java as a target language at the moment !>
		«ELSEIF superClasses.size == 1»
			extends «superClasses.head.clazz.genType»
		«ELSEIF active»
			extends SimulationProcess
		«ENDIF»
		{

			public «name»(
			«IF constructor != null»
				«FOR cparam: constructor.parameters SEPARATOR ','»
					«cparam.gen»
				«ENDFOR»
			«ENDIF»
			) {
				«IF active && superClasses.empty»
					super("«name»");
				«ENDIF»
			
				«initialBlock?.statements.gen»
			}
			
			«IF active»
			public void base_actions() {
				«IF actionsBlock != null»
					«actionsBlock.statements.gen»
				«ENDIF»
			}
			«ENDIF»
		
			«attributes.genVariables(false)»

			«methods.genProcedures(false)»
		}
		'''
	}
	
	override String forwardGen(EObject eObj) {
		if (eObj instanceof Statement) (eObj as Statement).genSimStatement
		else if (eObj instanceof Expression) (eObj as Expression).genSimExpr
		else '<! unknown element ' + eObj.eClass.name + ' !>'
	}
	
	def dispatch String genSimStatement(Statement stm) {
			
	}
	
	def dispatch String genSimStatement(Yield stm) {
		'hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess().base_yield();'
	}
	
	def dispatch String genSimStatement(Wait stm) {
		'hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess().passivate();'
	}
	
	def dispatch String genSimStatement(ActivateObject stm) {
		'''((hub.sam.dmx.javasim.desmoj.SimulationProcess) «stm.objectAccess.genExpr»).base_activate();'''
	}
	
	def dispatch String genSimStatement(Reactivate stm) {
		'''((hub.sam.dmx.javasim.desmoj.SimulationProcess) «stm.objectAccess.genExpr»).base_reactivate();'''
	}
	
	def dispatch String genSimStatement(Advance stm) {
		'''base_advance(«stm.time.genExpr»);'''
	}

	def dispatch String genSimExpr(Expression expr) {
		
	}

	def dispatch String genSimExpr(TimeLiteral stm) {
		'hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getPresentTime()'
	}
	
	def dispatch String genSimExpr(ActiveLiteral stm) {
		'hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess()'
	}
	
}

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
	
	def String genActiveClass(Clazz clazz) {
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
			
			«procedures.genProcedures(true)»
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

	def dispatch String javaNameQualified(ExtensionDefinition element) {
		val it = element
		val owner = element.eContainer as Module;
		owner.javaNameQualified_for_Module(false) + "." + name
	}

	def dispatch String javaNameQualified(Clazz element) {
		val it = element
		if (bindings.empty) {
			val owner = element.eContainer as Module;
			owner.javaNameQualified_for_Module(false) + "." + name
		}
		else javaNameBound
	}
	
	def String javaNameBound(Clazz clazz) {
		val it = clazz
		var targetType = bindings.findFirst[targetLanguage == simLibName]?.targetType
		if (targetType != null) targetType
		else {
			targetType = bindings.findFirst[targetLanguage == languageName]?.targetType
			if (targetType != null) targetType
			else '<!- type binding for library ' + simLibName + ' is missing for type ' + clazz.name + ' !>'
		}		
	}

	def dispatch String javaNameQualified(Procedure element) {
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

	def void genModel(Model model, boolean mainModel) {
		val Module moduleWithMainProcedure = if (mainModel) model.modules.findFirst[ procedures.exists[ name == 'main' ] ] else null
		
		model.modules.forEach[ module | 
			val moduleFolder = javaPackageFolder.append(module.name)
			makeFolder(moduleFolder)

			val Writer moduleWriter = beginTargetFile(moduleFolder, javaClass_for_ModuleLevelElements + ".java");
			moduleWriter.write(
				if (moduleWithMainProcedure == null || module != moduleWithMainProcedure) module.gen
				else module.genModuleWithMainProcedure
			)
			endTargetFile(moduleWriter)
			
			module.classifiers.forEach[ classifier |
				val String result = classifier.gen
				if (result != null && result != "") {
					val Writer classifierWriter = beginTargetFile(moduleFolder, classifier.name + ".java");
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
	
	def dispatch String gen(Classifier c) {
		'<! unknown classifier ' + c.eClass.name + ' !>'
	}
	
	def dispatch String gen(Void e) {
		''
	}
	
	def boolean isMainModule(Module module) {
		module.procedures.exists[name == 'main']
	}
	
	def dispatch String gen(Module module) {
		val it = module;		
		// TODO import types used in this module
		'''
		«genPackageStatement»
		
		public class «javaClass_for_ModuleLevelElements» {
			«variables.genVariables(true)»
			
			«procedures.genProcedures(true)»
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
	
	def String genProcedures(List<Procedure> procedures, boolean setStatic) {
		'''
		«FOR p : procedures»
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
	
	def dispatch String genStatement(ProcedureCall call) {
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

	def dispatch String genStatement(ResetGenContextStatement stm) {
		'resetGenContext();'
	}

	def dispatch String genStatement(SetGenContextStatement stm) {
		val it = stm
		'''setExpand(«context.genExpr», «addAfterContext»);'''
	}

	def dispatch String genStatement(MappingStatement stm) {
		val it = stm
		'''expand(
		«FOR part : parts SEPARATOR '+'»
			«part.genMappingPart»
		«ENDFOR»
		);'''
	}
	
	def dispatch String genMappingPart(MappingPart part) {
		'< unknown mapping part >'
	}

	def dispatch String genMappingPart(FixedMappingPart part) {
		quoteJavaString(part.code)
	}

	def dispatch String genMappingPart(DynamicMappingPart part) {
		part.expr.genExpr
	}

	def dispatch String genStatement(Variable variable) {
		val it = variable
		//val ListDimension ldim1 = if (isList && listDims.size() == 1) listDims.get(1) else null;
		
		'''
		«genType» «name»
		«IF initialValue != null»
			= «initialValue.genExpr»
		«ELSEIF !typeArrayDimensions.empty»
«««			«IF ldim1 != null»
«««				«IF ldim1.size > 0»
«««					= new «ldim1.genTypeNoWrapOfListPrimitives»[«ldim1.size»]
«««				«ELSE»
«««					= new java.util.ArrayList<«ldim1.genTypeWrapListPrimitives»>()
«««				«ENDIF»
«««			«ENDIF»
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
			new «genType»		
		«IF classifierType != null && classifierType.arrayIndex.empty && typeArrayDimensions.empty»
			(
			«IF classifierType.callPart != null»
				«FOR arg : classifierType.callPart.callArguments SEPARATOR ','»
					«arg.genExpr»
				«ENDFOR»
			«ENDIF»
			)
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
		else 'size()'
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
	
	def dispatch String genIdExpr_for_ReferencedElement(IdExpr idExpr, PropertyBindingExpr referencedElement) {
		idExpr.genIdExpr_for_PropertyBindingExpr(referencedElement)
	}
	
	def String genIdExpr_for_PropertyBindingExpr(IdExpr idExpr, PropertyBindingExpr referencedElement) {
		// empty for DBL models
	}
	
	def dispatch String genType(TypedElement typedElement) {
		val it = typedElement
		'''
		«IF primitiveType != null»
			«primitiveType.genType»
		«ELSE»
			«classifierType.genClassifierTypeExpr»
		«ENDIF»
		«IF !typeArrayDimensions.empty»
			«FOR dim : typeArrayDimensions»
				[«dim.size.genExpr»]
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

	def dispatch String genType(LanguageConstructClassifier langClassifier) {
		langClassifier.name
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
	
	def dispatch String genType(Clazz type) {
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
	
	def dispatch String gen(Procedure procedure) {
		val it = procedure
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
	
	def dispatch String gen(Clazz clazz) {
		val it = clazz
		if (clazz.bindings.empty) {
			if (clazz.active) genActiveClass
			else genPassiveClass
		}
	}
	
	def String genPackageStatement(Module module) {
		'''
		package «module.javaNameQualified_for_Module(false)»;
		'''
	}

	def String genPackageStatement(Clazz clazz) {
		'''
		package «(clazz.eContainer as Module).javaNameQualified_for_Module(false)»;
		'''
	}
	
	def String genPassiveClass(Clazz clazz) {
		val it = clazz
		'''
		«genPackageStatement»
		
		public class «name»
		«IF superClasses.size > 1»
			<! multiple inheritance is not supported for Java as a target language at the moment !>
		«ELSEIF superClasses.size == 1»
			extends «superClasses.head.clazz.genType»
		«ENDIF»
		{

			public «name»(
			«IF constructor != null»
				«FOR cparam: constructor.parameters SEPARATOR ','»
					«cparam.gen»
				«ENDFOR»
			«ENDIF»
			) {
				«initialBlock?.statements.gen»
			}
			
			«attributes.genVariables(false)»

			«methods.genProcedures(false)»
		}
		'''
	}
		
}