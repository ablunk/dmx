package hub.sam.dmx.targetcode

import hub.sam.dbl.ActivateObject
import hub.sam.dbl.Advance
import hub.sam.dbl.Class
import hub.sam.dbl.Expression
import hub.sam.dbl.Module
import hub.sam.dbl.Reactivate
import hub.sam.dbl.Statement
import hub.sam.dbl.TimeLiteral
import hub.sam.dbl.Wait
import hub.sam.dbl.Yield
import hub.sam.dmx.semantics.BasicDblToJavaGenerator
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.ActiveClass
import hub.sam.dbl.Assignment
import hub.sam.dbl.VariableAccess
import hub.sam.dbl.NamedElement
import hub.sam.dbl.ControlVariable
import hub.sam.dbl.IdExpr
import hub.sam.dbl.Variable
import hub.sam.dbl.WaitUntil
import java.util.List
import java.util.ArrayList

class DblToDesmojJavaGenerator extends BasicDblToJavaGenerator {
	
	override def String genModuleWithMainProcedure(Module module) {
		val it = module
		
		val mainProcedure = functions.findFirst[name == 'main']
		
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
			
			«functions.filter[ p | p != mainProcedure ].toList.genFunctions(true)»
			
			public «mainProcedure.gen»
		}
		'''
	}
	
	override getSimLibName() {
		'desmoj'
	}
	
	def dispatch String gen(ActiveClass activeClass) {
		val it = activeClass
		'''
		«genPackageStatement»
		
		import hub.sam.dmx.javasim.desmoj.SimulationProcess;
		import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
			
		public class «name» extends SimulationProcess
		{

			«FOR constructor: constructors»
				public «name»(
				«FOR cparam: constructor.parameters SEPARATOR ','»
					«cparam.gen»
				«ENDFOR»
				) {
					super("«name»");
					«constructor.statements.gen»
				}
			«ENDFOR»
			
			«IF constructors.empty»
				public «name»() {
					super("«name»");
				}
			«ENDIF»
			
			public void base_actions() {
				«IF actionsBlock !== null»
					«actionsBlock.statements.gen»
				«ENDIF»
			}
		
			«attributes.genVariables(false)»

			«methods.genFunctions(false)»
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
		genWait
	}
	
	def String genWait() {
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

	def dispatch String genSimStatement(WaitUntil stm) {
		var codeForAddingCurrentProcessToAllControlVariableWaitLists = ""
		var codeForRemovingCurrentProcessFromAllControlVariableWaitLists = ""
		
		val List<IdExpr> controlVariableIdExprs = new ArrayList();
		getIdExprsReferingToControlVariables(stm.condition, controlVariableIdExprs)
		
		for (IdExpr controlVariableIdExpr: controlVariableIdExprs) {
			val controlVariable = controlVariableIdExpr.referencedElement as ControlVariable
			
			val codeForAccessingControlVariableWaitList = '''
				«IF controlVariableIdExpr.parentIdExpr !== null»
					«controlVariableIdExpr.parentIdExpr.genIdExpr».
				«ENDIF»
				«controlVariable.nameForWaitListOfControlVariable»
			'''
			
			codeForAddingCurrentProcessToAllControlVariableWaitLists += '''
			«codeForAccessingControlVariableWaitList».add(hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess());
			'''

			codeForRemovingCurrentProcessFromAllControlVariableWaitLists += '''
			«codeForAccessingControlVariableWaitList».remove(hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess());
			'''
		}
		
		'''
		«codeForAddingCurrentProcessToAllControlVariableWaitLists»
		while (!(«stm.condition.genExpr»)) {
			«genWait»
		}
		«codeForRemovingCurrentProcessFromAllControlVariableWaitLists»
		'''
	}
	
	def void getIdExprsReferingToControlVariables(EObject eObject, List<IdExpr> result) {
		if (eObject instanceof IdExpr) {
			val idExpr = eObject as IdExpr;
			if (idExpr.referencedElement instanceof ControlVariable) {
				result.add(idExpr);
			}
		} else {
			for (EObject content: eObject.eContents) {
				getIdExprsReferingToControlVariables(content, result)
			}
		}
	}

	override def String genVariable(Variable variable) {
		val variableCode = super.genVariable(variable)
		
		if (variable instanceof ControlVariable) {
			val controlVariable = variable as ControlVariable
			'''
			«variableCode»
			java.util.List<hub.sam.dmx.javasim.desmoj.SimulationProcess> «controlVariable.nameForWaitListOfControlVariable» = new java.util.ArrayList<hub.sam.dmx.javasim.desmoj.SimulationProcess>();
			'''
		} else {
			variableCode
		}
	}

	def dispatch String genSimExpr(Expression expr) {
		
	}

	def dispatch String genSimExpr(TimeLiteral stm) {
		'hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getPresentTime()'
	}
	
	override def String genAssignment(Assignment stm, boolean genSemicolon) {
		val it = stm
		val controlVariable = variable.findControlVariable
		'''
		«variable.genExpr» = «value.genExpr»
		«IF genSemicolon»;«ENDIF»
		
		«IF controlVariable !== null»
			for (hub.sam.dmx.javasim.desmoj.SimulationProcess simProcess:
			«IF variable.idExpr.parentIdExpr !== null»
				«variable.idExpr.parentIdExpr.genIdExpr».
			«ENDIF»
			«controlVariable.nameForWaitListOfControlVariable») {
				simProcess.base_reactivate();
			}
		«ENDIF»
		«IF genSemicolon»;«ENDIF»
		'''
	}
	
	def String getNameForWaitListOfControlVariable(NamedElement controlVariable) {
		controlVariable.name + '_waitList'
	}
	
	def ControlVariable findControlVariable(VariableAccess variableAccess) {
		val referencedElement = variableAccess.idExpr.referencedElement
		if (referencedElement !== null && referencedElement instanceof ControlVariable) {
			return referencedElement as ControlVariable
		} else {
			return null
		}
	}
	
}