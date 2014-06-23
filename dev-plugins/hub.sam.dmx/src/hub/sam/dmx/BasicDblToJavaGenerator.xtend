package hub.sam.dmx

import hub.sam.dbl.AddToSet
import hub.sam.dbl.And
import hub.sam.dbl.ArgumentExpression
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
import hub.sam.dbl.DoubleType
import hub.sam.dbl.EmptySet
import hub.sam.dbl.Equal
import hub.sam.dbl.Expression
import hub.sam.dbl.ForEachStatement
import hub.sam.dbl.Greater
import hub.sam.dbl.GreaterEqual
import hub.sam.dbl.IdExpr
import hub.sam.dbl.IfStatement
import hub.sam.dbl.IntType
import hub.sam.dbl.Less
import hub.sam.dbl.LessEqual
import hub.sam.dbl.ListDimension
import hub.sam.dbl.MappingStatement
import hub.sam.dbl.Minus
import hub.sam.dbl.Mod
import hub.sam.dbl.Model
import hub.sam.dbl.Module
import hub.sam.dbl.Mul
import hub.sam.dbl.Neg
import hub.sam.dbl.Not
import hub.sam.dbl.NotEqual
import hub.sam.dbl.Or
import hub.sam.dbl.Plus
import hub.sam.dbl.Print
import hub.sam.dbl.Procedure
import hub.sam.dbl.ProcedureCall
import hub.sam.dbl.ReferableRhsType
import hub.sam.dbl.RemoveFromSet
import hub.sam.dbl.ResetGenContextStatement
import hub.sam.dbl.Return
import hub.sam.dbl.SetGenContextStatement
import hub.sam.dbl.Statement
import hub.sam.dbl.StringType
import hub.sam.dbl.Type
import hub.sam.dbl.TypeAccess
import hub.sam.dbl.TypedElement
import hub.sam.dbl.Variable
import hub.sam.dbl.VariableAccess
import hub.sam.dbl.VoidType
import hub.sam.dbl.WhileStatement
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.Writer
import java.util.List
import java.util.regex.Matcher
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.resource.Resource
import hub.sam.dbl.StringLiteral
import hub.sam.dbl.IntLiteral
import hub.sam.dbl.TrueLiteral
import hub.sam.dbl.FalseLiteral
import hub.sam.dbl.DoubleLiteral
import hub.sam.dbl.NullLiteral
import hub.sam.dbl.Yield
import hub.sam.dbl.Wait
import hub.sam.dbl.ActivateObject
import hub.sam.dbl.Reactivate
import hub.sam.dbl.Advance
import hub.sam.dbl.TimeLiteral
import hub.sam.dbl.ActiveLiteral
import hub.sam.dbl.PropertyBindingExpr
import hub.sam.dbl.Interface
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.IndexOf
import hub.sam.dbl.NamedElement
import hub.sam.dbl.PredefinedId
import hub.sam.dbl.MeLiteral
import hub.sam.dbl.SuperLiteral
import hub.sam.dbl.SizeOfSet
import hub.sam.dbl.FirstInSet
import hub.sam.dbl.LastInSet
import hub.sam.dbl.Contains
import hub.sam.dbl.ObjectAt
import hub.sam.dbl.AfterInSet
import hub.sam.dbl.BeforeInSet

class DblToDesmojJavaGenerator extends BasicDblToJavaGenerator {
	
	new(Resource modelResource, IPath outputFolder) {
		super(modelResource, outputFolder)
	}
	
	override def String genModuleWithMainProcedure(Module module) {
		val it = module
		
		val mainProcedure = procedures.findFirst[name == 'main']
		
		'''
		package «javaPackagePrefix»;
		
		import hub.sam.dmx.javasim.desmoj.SimulationProcess;
		import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
		
		public class «name» extends SimulationProcess {
			
			public «name»() {
				super("«name»");
			}
			
			public void base_actions() {
				main();
				
				// simulations are stopped when main terminates
				getModel().getExperiment().stop();
			}

			public static void startMainProcedure() {
				«name» mainProcess = new «name»();
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
		package «javaPackagePrefix»;
		
		import hub.sam.dmx.javasim.desmoj.SimulationProcess;
		import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
			
		public class «name»
		«IF superClass != null»
			extends «superClass.genType»
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
				«IF active && superClass == null»
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
		'DefaultSimulation.DEFAULT.getCurrentProcess().base_yield();'
	}
	
	def dispatch String genSimStatement(Wait stm) {
		'DefaultSimulation.DEFAULT.getCurrentProcess().passivate();'
	}
	
	def dispatch String genSimStatement(ActivateObject stm) {
		'''((SimulationProcess) «stm.objectAccess.genExpr»).base_activate();'''
	}
	
	def dispatch String genSimStatement(Reactivate stm) {
		'''((SimulationProcess) «stm.objectAccess.genExpr»).base_reactivate();'''
	}
	
	def dispatch String genSimStatement(Advance stm) {
		'''base_advance(«stm.time.genExpr»);'''
	}

	def dispatch String genSimExpr(Expression expr) {
		
	}

	def dispatch String genSimExpr(TimeLiteral stm) {
		'DefaultSimulation.DEFAULT.getPresentTime()'
	}
	
	def dispatch String genSimExpr(ActiveLiteral stm) {
		'DefaultSimulation.DEFAULT.getCurrentProcess()'
	}
	
}

class ExtensionsToJavaGenerator extends BasicDblToJavaGenerator {
	
	new(Resource modelResource, IPath outputFolder) {
		super(modelResource, outputFolder)
	}
	
	override String genIdExpr_for_PredefinedId_meLiteral() {
		'self'
	}
	
}
	
class BasicDblToJavaGenerator {
	
	private val Resource modelResource
	private val IPath outputFolder
	
	public val javaPackagePrefix = "hub.sam.dmx.javasim.gen"
	public val javaPackageFolderPrefix = javaPackagePrefix.replaceAll("\\.", "/")
	var IPath javaPackageFolder;
	
	new(Resource modelResource, IPath outputFolder) {
		this.modelResource = modelResource;
		this.outputFolder = outputFolder;
	}
	
	def String genActiveClass(Clazz clazz) {
		'<! active classes are not support in basic DBL models !>'
	}

	def String genModuleWithMainProcedure(Module module) {
		val it = module
		'''
		package «javaPackagePrefix»;

		public class «name» {
			
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
	
	// forward generation of other elements to more specific generators
	def String forwardGen(EObject eObj) {
		'<! unknown element ' + eObj.eClass.name ' !>'
	}

	def Module getModuleWithMainProcedure(Model model) {
		model.modules.findFirst[ procedures.exists[ name == 'main' ] ]
	}
	
	def void startGenerator() {
		val model = modelResource.contents.head as Model;
		val moduleWithMainProcedure = model.moduleWithMainProcedure
		
		javaPackageFolder = outputFolder.append(javaPackageFolderPrefix)
		val javaPackageFolder_fileObject = new File(javaPackageFolder.toString);
		if (!javaPackageFolder_fileObject.exists && !javaPackageFolder_fileObject.mkdirs) {
			throw new RuntimeException("could not create java package folder structure.");
		}
			
		model.modules.forEach[ module | 
			val Writer moduleWriter = beginTargetFile(javaPackageFolder, module.name + ".java");
			moduleWriter.write(
				if (module != moduleWithMainProcedure) module.gen
				else module.genModuleWithMainProcedure
			)
			endTargetFile(moduleWriter)
			
			module.classifiers.forEach[ classifier |
				val String result = classifier.gen
				if (result != null && result != "") {
					val Writer classifierWriter = beginTargetFile(javaPackageFolder, classifier.name + ".java");
					classifierWriter.write(result)
					endTargetFile(classifierWriter)
				}
			]
		]
		
		// main Java class with main function
		val Writer javaMain = beginTargetFile(javaPackageFolder, "JavaMain.java");
		javaMain.write(
			'''
			package «javaPackagePrefix»;
			
			public class JavaMain {
				public static void main(String[] args) {
					long startTime = System.nanoTime();
					
					«moduleWithMainProcedure.name».startMainProcedure();
					
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
		package «javaPackagePrefix»;
		
		public class «name» {
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
		call.procedureAccess.genExpr
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
		if («condition.genExpr») {
			«ifCaseBlock.statements.gen»
		}
		«FOR elseIfBlock : elifCaseBlock»
		else if («elifCondition.get(elifCaseBlock.indexOf(elseIfBlock))») {
			«elseIfBlock.statements.gen»
		}
		«ENDFOR»
		else {
		«IF elseCaseBlock != null»
			«elseCaseBlock.statements.gen»
		«ENDIF»
		}
		'''
	}
	
	def dispatch String genStatement(Assignment stm) {
		val it = stm
		'''«variable.genExpr» = «value.genExpr»;'''
	}
	
	def dispatch String genStatement(Return stm) {
		'''return «stm.value.genExpr»;'''
	}

	def dispatch String genStatement(AddToSet stm) {
		val it = stm
		'''
		«set.genExpr».add(
			«IF atIndex != null»(int) «atIndex.genExpr», «ENDIF»
			«object.genExpr»
		);
		'''
	}

	def dispatch String genStatement(RemoveFromSet stm) {
		val it = stm
		'''«set.genExpr».remove(«object.genExpr»);'''
	}

	def dispatch String genStatement(EmptySet stm) {
		val it = stm
		'''«set.genExpr».clear();'''
	}

	def dispatch String genStatement(BreakStatement stm) {
		'break;'
	}

	def dispatch String genStatement(ContinueStatement stm) {
		'continue;'
	}

	def dispatch String genStatement(ForEachStatement stm) {
		val it = stm
		''''''
		// remove foreach and add for as a basic statement.
		// define foreach as an extension by using for.
		// it is better to provide for as a basic statement as GPL compilers
		// provide optimizations for it.
	}

	def dispatch String genStatement(WhileStatement stm) {
		val it = stm
		'''while («condition.genExpr») {
			«whileBlock.statements.gen»
		}'''
	}

	def dispatch String genStatement(ResetGenContextStatement stm) {
		'resetGenContext();'
	}

	def dispatch String genStatement(SetGenContextStatement stm) {
		val it = stm
		'''setGenContext(«context.genExpr», «addAfterContext»);'''
	}

	def dispatch String genStatement(MappingStatement stm) {
		val it = stm
		'''gen(«FOR part : parts SEPARATOR '+'»
			// TODO
		«ENDFOR»);'''
	}

	def dispatch String genStatement(Variable variable) {
		val it = variable
		val ListDimension ldim1 = if (isList && listDims.size() == 1) listDims.get(1) else null;
		
		'''
		«genType» «name»
		«IF initialValue != null»
			= «initialValue.genExpr»
		«ELSEIF isList»
			«IF ldim1 != null»
				«IF ldim1.size > 0»
					= new «ldim1.genTypeNoWrapOfListPrimitives»[«ldim1.size»]
				«ELSE»
					= new java.util.ArrayList<«ldim1.genTypeWrapListPrimitives»>()
				«ENDIF»
			«ENDIF»
		«ELSEIF classifierTypeExpr != null»
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
		expr.value.toString + 'L'
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

	def dispatch String genExpr(ArgumentExpression expr) {
		'''«FOR e : expr.arguments SEPARATOR ','»
			«e.genExpr»
		«ENDFOR»'''
	}
	
	def dispatch String genExpr(CreateObject expr) {
		'(new ' + expr.genType + '(' + expr?.classifierTypeExpr?.arguments.genExpr + '))'
	}
	
	def boolean refersToSyntaxPart(IdExpr idExpr) {
		val it = idExpr
		if (parentIdExpr == null) {
			return referencedElement != null && referencedElement instanceof PropertyBindingExpr
		}
		else
			return parentIdExpr.refersToSyntaxPart
	}
	
	def boolean refersToSyntaxPart_ofType_StructuredType(IdExpr idExpr) {
		false
	}
	
	def dispatch String genExpr(IdExpr idExpr) {
		idExpr.genIdExpr
	}

	def String genIdExpr(IdExpr idExpr) {
		val it = idExpr

		// TODO different code generation if used in extension semantics needed
		// SEE template public genExpression(idExpr : IdExpr, extensionSemantics : Boolean)

		'''
		«IF parentIdExpr != null»
			«IF predefinedId != null && predefinedId instanceof IndexOf»
				(
			«ENDIF»
			
			«parentIdExpr.genIdExpr»
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

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SizeOfSet predefinedId) {
		'size()'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, FirstInSet predefinedId) {
		'get(0)'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, LastInSet predefinedId) {
		'get(' + idExpr.parentIdExpr.genIdExpr + '.size() - 1)'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, Contains predefinedId) {
		'contains(' + idExpr.arguments.genExpr + ')'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, IndexOf predefinedId) {
		'indexOf(' + idExpr.arguments.genExpr + ')'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, ObjectAt predefinedId) {
		'get((int) ' + idExpr.arguments.genExpr + ')'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, AfterInSet predefinedId) {
		'''
		get( «idExpr.parentIdExpr.genIdExpr».indexOf(«idExpr.arguments.genExpr») + 1)
		'''
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, BeforeInSet predefinedId) {
		'''
		get( «idExpr.parentIdExpr.genIdExpr».indexOf(«idExpr.arguments.genExpr») - 1)
		'''
	}

	def dispatch String genIdExpr_for_ReferencedElement(IdExpr idExpr, NamedElement referencedElement) {
		'''
		«IF referencedElement.eContainer instanceof Module»
			«(referencedElement.eContainer as Module).name».
		«ENDIF»
		«referencedElement.name»
		'''
	}
	
	def dispatch String genIdExpr_for_ReferencedElement(IdExpr idExpr, Procedure referencedElement) {
		'''
		«IF referencedElement.eContainer instanceof Module»
			«(referencedElement.eContainer as Module).name».
		«ENDIF»
		«referencedElement.name»(
		«FOR arg : idExpr.arguments.arguments SEPARATOR ','»
			«arg.genExpr»
		«ENDFOR»
		)
		'''
	}
	
	def dispatch String genIdExpr_for_ReferencedElement(IdExpr idExpr, PropertyBindingExpr referencedElement) {
		'''
		get«referencedElement.name.toFirstUpper»
		'''
	}
	
	def dispatch String genType(TypedElement typedElement) {
		val it = typedElement
		if (!isList) {
			genTypeNoWrapOfListPrimitives
		}
		else {
			if (listDims.size == 1) {
				val ldim1 = listDims.get(0)
				if (ldim1.size > 0) {
					ldim1.genTypeNoWrapOfListPrimitives + '[]'
				}
				else {
					'java.util.List<' + ldim1.genTypeWrapListPrimitives + '>'
				}
			}
		}
	}
	
	def String genTypeWrapListPrimitives(TypedElement typedElement) {
		val it = typedElement
		primitiveType?.genWrappedType
		classifierTypeExpr?.genClassifierTypeExpr
	}
	
	def String genTypeNoWrapOfListPrimitives(TypedElement typedElement) {
		val it = typedElement
		if (primitiveType != null) return primitiveType.genType
		else return classifierTypeExpr.genClassifierTypeExpr
	}
	
	def String genClassifierTypeExpr(IdExpr typeExpr) {
		typeExpr.referencedElement.genType
	}

	def dispatch String genType(ReferableRhsType rhsType) {
		rhsType.name
	}
	
	def dispatch String genType(Classifier type) {
		val it = type
		if (bindings.empty) {
			name
		}
		else {
			val targetType = bindings.findFirst[targetLanguage == simLibName].targetType
			if (targetType != null) targetType
			else '<!- type binding for library ' + simLibName + ' is missing for type ' + type.name + ' !>'
		}
	}

	def dispatch String genType(Type type) {
		'<! unknown type ' + type.eClass.name + ' !>'
	}
	
	def dispatch String genType(IntType type) {
		'long'
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
	
	def String genPassiveClass(Clazz clazz) {
		val it = clazz
		'''
		package «javaPackagePrefix»;
		
		public class «name»
		«IF superClass != null»
			extends «superClass.genType»
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
			
			public «attributes.genVariables(false)»

			public «methods.genProcedures(false)»
		}
		'''
	}
	
	def dispatch String gen(Interface iface) {
		// empty at the moment
	}
	
	private def Writer beginTargetFile(IPath folder, String fileName) {
		val File file = new File(folder.append(fileName).toString);
		if (!file.exists()) {
			file.createNewFile();
		}
 
		val FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
		val BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		return bufferedWriter;
	}
	
	private def void endTargetFile(Writer targerWriter) {
		targerWriter.close;
	}
		
}