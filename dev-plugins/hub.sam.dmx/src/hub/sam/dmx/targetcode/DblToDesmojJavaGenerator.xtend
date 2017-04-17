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
	
	override def String genActiveClass(Class clazz) {
		val it = clazz
		'''
		«genPackageStatement»
		
		import hub.sam.dmx.javasim.desmoj.SimulationProcess;
		import hub.sam.dmx.javasim.desmoj.DefaultSimulation;
			
		public class «name»
		«IF !superClasses.empty»
			extends «superClasses.get(0).genType»
		«ELSEIF active»
			extends SimulationProcess
		«ENDIF»
		{

			«FOR constructor: constructors»
				public «name»(
				«FOR cparam: constructor.parameters SEPARATOR ','»
					«cparam.gen»
				«ENDFOR»
				) {
					«IF active && superClasses.empty»
						super("«name»");
					«ENDIF»
				
					«constructor.statements.gen»
				}
			«ENDFOR»
			
			«IF constructors.empty»
				public «name»() {
					super("«name»");
				}
			«ENDIF»
			
			«IF active»
			public void base_actions() {
				«IF actionsBlock !== null»
					«actionsBlock.statements.gen»
				«ENDIF»
			}
			«ENDIF»
		
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
	
}