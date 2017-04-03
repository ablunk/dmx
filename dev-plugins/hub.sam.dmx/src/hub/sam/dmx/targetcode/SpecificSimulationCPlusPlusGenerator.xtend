package hub.sam.dmx.targetcode
import hub.sam.dbl.ActivateObject
import hub.sam.dbl.Advance
import hub.sam.dbl.Class
import hub.sam.dbl.Constructor
import hub.sam.dbl.Expression
import hub.sam.dbl.Function
import hub.sam.dbl.Reactivate
import hub.sam.dbl.Statement
import hub.sam.dbl.TimeLiteral
import hub.sam.dbl.Wait
import hub.sam.dbl.Yield
import java.util.List
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import hub.sam.dmx.semantics.BaseCPlusPlusGenerator
import hub.sam.dbl.ActiveLiteral
import hub.sam.dbl.Terminate
import hub.sam.dbl.Module
import hub.sam.dbl.Variable
import java.util.Set
import java.util.HashSet
import hub.sam.dbl.FunctionCall
import hub.sam.dbl.Parameter
import hub.sam.dbl.Model
import hub.sam.dbl.IdExpr
import hub.sam.dbl.Return
import hub.sam.dbl.IfStatement
import hub.sam.dbl.ForStatement
import hub.sam.dbl.WhileStatement
import java.util.Queue
import java.util.LinkedList
import org.eclipse.emf.common.util.TreeIterator
import java.util.HashMap
import hub.sam.dbl.VoidType
import hub.sam.dbl.ContinueStatement
import hub.sam.dbl.LocalScopeStatement
import hub.sam.dbl.SwitchStatement
import hub.sam.dbl.TypedElement
import hub.sam.dbl.NamedElement
import hub.sam.dbl.SuperLiteral
import hub.sam.dbl.MeLiteral
import hub.sam.dbl.CreateObject
import hub.sam.dbl.BreakStatement

/* 
 * A specific C++-generator for generating c++-code for DBL-programs represented by 
 * instances of a meta-model @see resources/dbl.ecore
 * (extension for base generator to support simulation specific concepts)
 * 
 * @author  Christopher Breszka
 * @version 1.0
 * @date 15.11.2016
 */
class SpecificSimulationCPlusPlusGenerator extends BaseCPlusPlusGenerator{
	/* saves all interruptible functions that contain a scheduling-statement directly or transitively */
	private var Set<Function> all_Functions_containing_sched = new HashSet<Function>();
	/* generates case number for switch case constants */
	private var int labelCount;
	/* saves all used variables in interruptible functions with a specific ID*/
	private var Set<Pair<Variable, Integer>> allVariables = new HashSet<Pair<Variable,Integer>>();
	/* indicates that there is a special generation state, where coroutines are built up*/
	private var boolean isActionsBlock;
	/* saves the current generated interruptible function */
	private var Function currentFunction;
	/* generates id for building up distinct variable names */
	private var int variableId;
	/* is a string that contains the current tuple type */
	private var String currentTuple;
	/* map from function call on tuple index to build up correct order of function calls */
	private var HashMap<IdExpr,Integer> tupleMap = new HashMap<IdExpr,Integer>();
	/* generates ID for case label in special for or while-loops */
	private var int forLoopIdCount;
	/* associates loop statements with label ids */
	private var HashMap<Statement,Integer> loopContinueLabelIdMap = new HashMap<Statement,Integer>();
	/* is a flag which is important for the compilation. When global variant type is needed. An extra file 
	 * is compiled */
	private var makefileNeedsGlobalVariantType = false;
	/**
	 * calls constructor to generate instance of C++ code-generator and also generates
	 * project folder path
	 * @param outputFolder specifies path to the project 
	 */
	public new(IPath outputFolder) {
		super(outputFolder);
	}
	/**
	 * resets all Parameters before creating a new interruptible function 
	 * implementation (switch-statement block)
	 */
	private def void resetParameters(){
		variableId = 0
		labelCount = 0
		allVariables = new HashSet<Pair<Variable,Integer>>
		loopContinueLabelIdMap = new HashMap<Statement,Integer>();
		forLoopIdCount = 0;
	}
	/**
	 * overrides collectSemanticInformation(see BaseCPlusPlusGenerator). Here all functions are determined 
	 * and then a check is performed to see if functions are interruptible. A function is interruptible if 
	 * it contains a scheduling function call directly or transitively. 
	 * @param model DBL model that has to be checked
	 */
	override void collectSemanticInformation(Model model){
		super.collectSemanticInformation(model);
		val Set<Function> allFunctions = new HashSet<Function>
		// determine all DBL functions in modules and not bounded classes
		allModules.forEach[functions.forEach[allFunctions.add(it)]; 
			classes.filter[getBindings.empty].forEach[methods.forEach[allFunctions.add(it)]]
		]
		// determines all functions containing scheduling function calls
		for(f:allFunctions){
			val isSchedFunction = f.checkSchedFunction(new HashSet<Function>())
			if(isSchedFunction) all_Functions_containing_sched.add(f)	
		}
	}
	/**
	 * checks if function f is an interruptible function containing scheduling function calls directly
	 * or transitively. Interruptible functions have to be mapped differently than usual functions!
	 * @param f the function to check
	 * @param visitedFunctions already visited function objects to avoid cycles
	 * @return if function f contains scheduling function calls directly or transitive (interruptible function)
	 */
	private def boolean checkSchedFunction(Function f, Set<Function> visitedFunctions){
		val allEObjectsInFunction = f.eAllContents
		// if the function was already checked, there is nothing to do
		if (!visitedFunctions.contains(f)) visitedFunctions.add(f)
		else return false
		while(allEObjectsInFunction.hasNext){
			var nextElement = allEObjectsInFunction.next
			// if a Scheduling function call was found the function is interruptible
			if(nextElement instanceof Yield || nextElement instanceof Wait || nextElement instanceof Terminate ||
				nextElement instanceof Advance) return true
			// otherwise function calls have to be checked (if the function called is interruptible, so is the 
			// caller of that function and that has to be checked recursively)
			else if(nextElement instanceof FunctionCall || (nextElement instanceof IdExpr && (nextElement as IdExpr).referencedElement instanceof Function)){
				val function = if(nextElement instanceof IdExpr) (nextElement as IdExpr).referencedElement as Function else ((nextElement as FunctionCall).callIdExpr.referencedElement) as Function
				if(all_Functions_containing_sched.contains(function)) return true
				else {if(checkSchedFunction(function,visitedFunctions)) return true}
			}
		}		
		return false
	}
	/**
	 * generates C++-string representation for function startMainProcedure(), which initializes the simulation 
	 * core by creating a scheduler instance, a main process which is activated and by starting the scheduler 
	 * by calling manageProcessLifeCycles(). The function declaration is the same like in the non-simulation context.
	 * @param mainModule representation for the main DBL module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++-string representation for function startMainProcedure()
	 */
	override genStaticStartFuncMemberForMainProcess(Module mainModule, boolean isHeader){
		if(!isHeader){
			includeStrings.addAll('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''','''#include "../../../C++-Libraries/referenceSemantics/intrusive_ptr.h"''')
			'''
				void «mainModule.genPreciseName»::startMainProcedure(){
					cbsLib::Scheduler* sched = cbsLib::Scheduler::getScheduler();
					cbsLib::intrusive_ptr<MainProcess> mainP = new MainProcess();
					sched->setMainProcess(mainP.get());
					mainP->schedule<MainProcess, &MainProcess::fActions>(mainP.get(), new MainProcess::MainStruct());
					sched->activate(mainP,0);
					sched->manageProcessLifeCycles();
					delete sched;
				}
			'''
		}
		else '''«super.genStaticStartFuncMemberForMainProcess(mainModule,isHeader)»'''
	}
	
	// CHANGES FOR CORRECT INHERITANCE BEHAVIOUR OF ACTIVE CLASSES START 
	/**
	 * generates C++-string representation for creating class inheritance. In case of 
	 * active classes the base class Process is needed, which equips classes with some
	 * base functionalities to support coroutine behavior.
	 * @param clazz representation of the current DBL class
	 * @return C++-string representation for creating class inheritance
	 */
	override String genSpecificBaseClass(Class clazz){
		if(clazz.active) '''public cbsLib::Process'''
		else super.genSpecificBaseClass(clazz)
	}
	/**
	 * checks if comma is needed in constructor initializer list
	 * @param clazz representation of the current DBL class
	 * @return boolean flag if comma is needed in constructor initializer list
	 */
	override boolean needsComma(Class clazz){
		if (clazz.active) return clazz.attributes.exists[!isClass] && clazz.superClasses.empty
		else return super.needsComma(clazz)
	}
	/**
	 * checks if colon is needed in constructor initializer list
	 * @param clazz representation of the current DBL class
	 * @return boolean flag if colon is needed in constructor initializer list
	 */
	override boolean needsColon(Class clazz){
		if (clazz.active) return (clazz.attributes.exists[!isClass] && !clazz.superClasses.empty)
		else return super.needsColon(clazz)
	}
	/**
	 * mapping from DBL superclass calls on C++ superclass calls. Special handling for active classes, 
	 * because active classes have to derive from base class Process. Process constructor is called 
	 * with a process name (class name) and an instance counter (process_id).
	 * @param clazz representation of the current DBL class
	 * @param constructor representation of the current DBL constructor
	 * @return C++-string representation for C++ superclass calls
	 */
	override String genSuperClassCalls(Class clazz,Constructor constructor){
		val it = clazz
		'''
			«IF active && getSuperClasses.empty»: cbsLib::Process("«name»",process_id++)
			«ELSE» «super.genSuperClassCalls(clazz,constructor)»
			«ENDIF»
		'''
	}
	// CHANGES FOR CORRECT INHERITANCE BEHAVIOUR OF ACTIVE CLASSES END 
	
	// MAPPING OF MAIN PROCESS BEGIN
	/**
	 * main process is created as single instance of class MainProcess, which is derived from 
	 * base class Process. The life cycle of main process is build with the help of the first
	 * main function in the DBL program. Main Process Creation is separated on header and CPP file.
	 * @param module representation of the DBL main module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++-string representation of the main Process
	 */
	override String genMainProcess(Module module, boolean isHeader) {
		val it = module
		val mainProcedure = getFunctions.findFirst[name == 'main']
		'''
			«IF isHeader»
				«genMainProcessClassInHeader(mainProcedure)»
			«ELSE»
				«genMainProcessClassInCPP(mainProcedure)»
			«ENDIF»
		'''
	}
	/**
	 * generates the declaration of the MainProcess class, which describes the main process. The main process 
	 * has a life cycle, which is defined in function fActions() and it could also provide some interruptible 
	 * functions, which other processes can call. According to the DBL to Java Specification its not possible 
	 * that the main process could call some interruptible functions itself. 
	 * @param mainProcess representation of the DBL main module
	 * @param mainProcedure representation of the DBL main function
	 * @return C++-string representation of the MainProcess class declaration
	 */
	private def String genMainProcessClassInHeader(Module mainProcess,Function mainProcedure) {
		includeStrings.addAll('''#include "../../../C++-Libraries/simulationCore/Process.h"''','''#include "../../../C++-Libraries/simulationCore/FunctionContext.h"''')
		'''
			class MainProcess: public cbsLib::Process{
				public: 
					MainProcess();
					int fActions(cbsLib::FunctionBaseContext* cont);
					«genStruct(mainProcedure,mainProcedure.getAllVariablesInStatementBlock)»
					«FOR f:mainProcess.getFunctions.filter[all_Functions_containing_sched.contains(it) && (name != "main")]»
						«f.genInterruptibleFunctionH»
					«ENDFOR»
			};
		'''
	}
	/**
	 * generates the definition of the MainProcess class, which describes the main process. The main 
	 * process is derived from base class Process. Its has a specific name and it always has id number 1.
	 * @param mainProcess representation of the DBL main module
	 * @param mainProcedure representation of the DBL main function
	 * @return C++-string representation of the MainProcess class definition
	 */
	private def String genMainProcessClassInCPP(Module module, Function mainProcedure) {
		val it = module
		'''
			«genPreciseName»::MainProcess::MainProcess(): cbsLib::Process("Main procedure in module '«name»'",1){}			
			«genFactionsFunction('''«genPreciseName»::MainProcess''', mainProcedure?.getStatements, true)»
			«FOR f:getFunctions.filter[all_Functions_containing_sched.contains(it) && (name != "main")]»
				«f.genInterruptibleFunctionCPP»
			«ENDFOR»
		'''
	}
	/**
	 * module functions which are not interruptible are generated with this function. Module 
	 * functions which are interruptible are created as member functions of the MainProcess class. 
	 * @param functions representation of all functions in module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++string representation of not interruptible functions in a module
	 */
	override String genModuleFunctions(List<Function> functions, boolean isHeader){
		'''
			«FOR f:functions»
				«IF !all_Functions_containing_sched.contains(f)»
					«f.genFunction(isHeader)»
				«ENDIF»
			«ENDFOR»
		'''
	}
	/**
	 * generates the implementation of the fAction function. All functions with a "memory" get a 
	 * context, which is accessed via the context variable in the fActions-statement block.
	 * @param prefix prefix (content access) before function name
	 * @param actionsBlock all statements that should be created in a switch-Statement
	 * @param isMainProcess boolean flag that indicates, if the main process is generated or not
	 * @return C++-string representation of the fAction function implementation.
	 */
	private def String genFactionsFunction(String prefix, List<Statement> actionsBlock, boolean isMainProcess){
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/FunctionContext.h"''')
		'''
			int «prefix»::fActions(cbsLib::FunctionBaseContext* cont){
				«IF actionsBlock !== null»
				auto context = static_cast<MainStruct*>(cont);
				«actionsBlock.genSwitchCases(isMainProcess)»
				«ENDIF»
				return 1;
			}
		'''
	}
	// MAPPING OF MAIN PROCESS END
	
	// MAPPING OF ACTIVE CLASSES BEGIN
	/**
	 * Only active classes have a life cycle method. Like in the main process its name is fActions and there 
	 * is also a structure which saves the context of that function. A static variable process_id is generated 
	 * for every active class to count instances.
	 * @param clazz current active DBL class 
	 * @param isHeader boolean flag for indicating whether a C++-header or -implementation file should be generated
	 * @return C++-string representation for active class life cycle
	 */
	override genLifecycle(Class clazz, boolean isHeader) {
		includeStrings.addAll('''#include "../../../C++-Libraries/simulationCore/FunctionContext.h"''', '''#include "../../../C++-Libraries/simulationCore/Process.h"''')
		val it = clazz;
		'''
			«IF isHeader»
				static int process_id;
				int fActions(cbsLib::FunctionBaseContext* cont);
				«genStruct(actionsBlock,actionsBlock.getAllVariablesInStatementBlock)»
			«ELSE»
				int «(eContainer as Module).genPreciseName»::«genPreciseName»::process_id = 1;
				«genFactionsFunction('''«(eContainer as Module).genPreciseName»::«genPreciseName»''',actionsBlock?.getStatements,false)»
			«ENDIF»
		'''
	}
	 /**
	 * helper function to create global variant type from all return value types of interruptible function calls
	 * @param allIncludedClasses empty set for storing class types
	 * @return returns variant type for the global variant variable
	 */
	private def String buildTempVariant(Set<EObject> allIncludedClasses){
		var String returnValueTempType = "";
		for(f:all_Functions_containing_sched.filter[!(primitiveType instanceof VoidType)]){
			val returnType = f.genType
			if(!returnValueTempType.contains(returnType)) {
				returnValueTempType += ''',«returnType»'''
				if(f.classifierType !== null) 
					allIncludedClasses.add(f.classifierType.referencedElement as Class)
			}
		}
		return returnValueTempType;
	}
	/**
	 * creates a global variant to save return value types across 
	 * different process context switches. So its possible that every process 
	 * can access return values of arbitrary function calls.
	 * @return C++-string representation for the global variant (declaration and definition)
	 */
	private def String genVariantTypeReturnValue(boolean isHeader){
		var Set<EObject> returnClassTypes = new HashSet<EObject>()
		val String returnValueTempType = buildTempVariant(returnClassTypes)
		returnClassTypes.addAll(getAllContainedMemberTypes(returnClassTypes))
		if(isHeader)
			'''
				#ifndef RETURNVALUETEMP
				#define RETURNVALUETEMP
				#include <tuple>
				#include "boost/variant.hpp"
				#include <type_traits>
				#include <cstddef>
				using boost::variant;
				#include "../../C++-Libraries/referenceSemantics/intrusive_ptr.h"
				#include "../../C++-Libraries/referenceSemantics/RefStringType.h"
				#include "../../C++-Libraries/referenceSemantics/vectorExtension.h"
				typedef cbsLib::intrusive_ptr<cbsLib::myString> stringPtr;
				«FOR i:returnClassTypes.filter[it instanceof Class && (it as Class).bindings.empty]»
				#include "«(i.eContainer as Module).genPreciseName»/«(i as Class).genPreciseName».h"
				«ENDFOR»
				«FOR i:returnClassTypes.filter[it instanceof Class && !(it as Class).bindings.empty]»
				#include "../../C++-Libraries/«(i as Class).genBoundType(false)».h"
				«ENDFOR»
				extern variant<std::nullptr_t «returnValueTempType»> returnValueTemp;
				#endif
			'''	
		else
			'''
				#include "TempReturnVariant.h"
				variant<std::nullptr_t «returnValueTempType»> returnValueTemp;
			'''
	}
	/**
	 * generates new files for global variant (returnValueTemp) declaration and definition 
	 * if they are needed
	 */
	override void genVariantTypeReturnInSeparateFile(){
		if(all_Functions_containing_sched.exists[!(primitiveType instanceof VoidType)]) {
			createFileWithContent(cPackageFolder,"TempReturnVariant.h", genVariantTypeReturnValue(true))
			createFileWithContent(cPackageFolder,"TempReturnVariant.cpp", genVariantTypeReturnValue(false))	
			makefileNeedsGlobalVariantType = true	
		}
	}
	/**
	 * generates C++-code for interruptible functions that contain scheduling function calls directly or transitively. 
	 * This function generates the declarations of these functions 
	 * @param f is an interruptible function
	 * @return C++-string representation of declarations of interruptible functions
	 */
	private def String genInterruptibleFunctionH(Function f) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/FunctionContext.h"''')
		val it = f	
		setcurrentFunction
		val inModule = eContainer instanceof Module
		val isVirtual = if(!inModule) isVirtualFunction else false
		'''
			«IF isVirtual»virtual«ENDIF» int «genDistinctFunctionName»(cbsLib::FunctionBaseContext* cont);
			«genStruct(f.getAllVariablesInStatementBlock)»
			«setcurrentFunction(null)»
		'''
	}
	/**
	 * generates C++-code for interruptible functions that contain scheduling function calls directly or transitively. 
	 * This function generates the implementation of these functions 
	 * @param f is an interruptible function
	 * @return C++-string representation of definition of interruptible functions
	 */
	private def String genInterruptibleFunctionCPP(Function f) {
		val it = f	
		setcurrentFunction
		'''
			int «IF currentClass !== null»«currentClass.genType»«ELSE»«(f.eContainer as Module).genPreciseName»::MainProcess«ENDIF»::«genDistinctFunctionName»(cbsLib::FunctionBaseContext* cont){
				auto context = static_cast<«genDistinctFunctionName»Struct*>(cont);
				«IF getStatements !== null»
					«getStatements.genSwitchCases(false)»
				«ENDIF»
				return 2;
			}
			«setcurrentFunction(null)»
		'''
	}
	/**
	 * helper to set currentFunction in a string template
	 * @param value is the interruptible function which should be generated
	 */
	private def void setcurrentFunction(Function value){
		currentFunction = value;
	}
	// MAPPING OF ACTIVE CLASSES END
	
	// COROUTINE BEHAVIOUR CREATING LABELS AND JUMPING TO SCHEDULER BEGIN ETC.
	/**
	 * generates statements of interruptible functions. They have to be treated differently 
	 * and are marked with boolean flag @see isActionsBlock. Generated statements are put into a Switch-statement. 
	 * The context of the variables and other stuff is saved in a structure which represents the state of the 
	 * interruptible function. At the end of the function definitions the call stack has to be popped and the 
	 * control is given back to the scheduler.
	 * @param actionsBlock represents all statements of an interruptible function
	 * @param isMainProcess boolean flag that indicates, if the main process is generated or not
	 * @return C++-string representation of statements of interruptible functions
	 */
	private def String genSwitchCases(List<Statement> actionsBlock, boolean isMainProcess) {
		// reset of parameter like variable id or switch case label ids
		resetParameters
		isActionsBlock = true
		val actionsBlockCode = actionsBlock.genStatements
		isActionsBlock = false
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''
			switch(context->state){
				case 0:
					«actionsBlockCode»
					«IF isMainProcess» 
						«deleteTopOfCallStack(0)»
					«ELSEIF currentFunction !== null && currentFunction.primitiveType instanceof VoidType» 
						«deleteTopOfCallStack(2)»
					«ELSEIF currentFunction !== null»
					«ELSE» 
						cbsLib::Scheduler::getScheduler()->terminate(this);
						return 1;
					«ENDIF»
			}
		'''
	}
	/**
	 * Before leaving a interruptible function. The call stack of the coroutine is popped so that
	 * the previous function call could be executed by the Scheduler. After that the control is given back 
	 * to the Scheduler via specific return values. 
	 * @param returnValue represents returnValue which the Scheduler needs to call the next function
	 * @return C++-string representation of terminating interruptible functions
	 */
	private def String deleteTopOfCallStack(int returnValue){
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''
			cbsLib::Scheduler::getScheduler()->getCurrentProcess()->callStack.pop();
			return «returnValue»;
		'''
	}
	/**
	 * Before giving control to the Scheduler via return-Statement. The function continue state has to be 
	 * saved in the function context and a new case label for the Switch-Statement is generated. If a 
	 * new interruptible function is called, then there is no context switch, which is signaled with 
	 * different return values.
	 * @param isFunctionCall signals if a new interruptible function or a scheduling function is called
	 * @return C++-string representation for giving back control to the Scheduler
	 */
	private def String genSwitchCase(boolean isFunctionCall){
		labelCount++;
		'''
			context->state = «labelCount»;
			«IF isFunctionCall»	return 2; «ELSE» return 1; «ENDIF»
		case «labelCount»:;
		'''
	}
	/**
	 * generates structure for memorizing function state (contains variables, parameters, 
	 * return values)
	 * @param g represents main procedure, actionsBlock or interruptible function statements
	 * @param allVariables is a set of all found variables in the definition of the interruptible function
	 * @return C++-string representation of structures for interruptible functions
	 */
	private def genStruct(EObject g, Set<Pair<Variable,Integer>> allVariables){
		if(g instanceof Function && !(g as Function === mainModule.getFunctions.findFirst[name == "main"]))
			{
				val f = g as Function
				'''
					struct «f.genDistinctFunctionName»Struct: cbsLib::FunctionBaseContext{
						«IF !f.parameters.empty»
							«f.genDistinctFunctionName»Struct(«f.parameters.genFormalParameters»)«IF !f.parameters.empty»:«FOR p:f.parameters SEPARATOR ','»«p.genPreciseName»(«p.genPreciseName»)«ENDFOR»«ENDIF»{}
						«ENDIF»
						«f.genFunctionCallParametersDeclaration»
						«allVariables.genVariableDeclarationsInStruct»
						«genVariants(f)»
					};
				'''
			}
		else{
			'''
				struct MainStruct: cbsLib::FunctionBaseContext{
					«allVariables.genVariableDeclarationsInStruct»
					«IF (g !== null)»«genVariants(g)»«ENDIF»
				};
			'''	
		}
	}
	/**
	 * generates distinct function names for interruptible functions by using parameter names 
	 * and types
	 * @param f represents interruptible function
	 * @return C++-string representation of distinct function name created by parameter names and types
	 */
	private def genDistinctFunctionName(Function f){
		'''«f.genPreciseName»_«FOR p:f.parameters SEPARATOR '_'»«p.genType.charAt(0)»«p.genPreciseName»«ENDFOR»'''
	}
	/**
	 * creates variant (Boost Feature, but could be replaced by std::variant with C++17) to store 
	 * tuples of return values which are used to save the return values of 
	 * called interruptible functions between giving control to the scheduler and back to processes. 
	 * @param f represents the interruptible function
	 * @return C++-string representation of the variant type declaration
	 */
	private def String genVariants(EObject f){
		val String variant_type = f.genVariantType
		if(!("".equals(variant_type))){
			includeStrings.addAll('''#include "boost/variant.hpp"''','''using boost::variant;''','''using boost::get;''', "#include <tuple>",'''#include <cstddef>''')
			'''variant<std::nullptr_t «variant_type»> rv_variant;'''
		}
	}
	/**
	 * helper function to create Variant Type consisting of tuple types. The tuples contains 
	 * type information of the function call return values according to the DBL to Java specification 
	 * order of function calls.
	 * @param f represents a statement block of an interruptible function
	 * @return C++-string representation for the variant type of an interruptible function
	 */
	private def String genVariantType(EObject f){
		var String allTupleTypes = "";
		// eAllContents gets all contained elements of f
		val allEObjectsInFunction = f.eAllContents
		while(allEObjectsInFunction.hasNext){
			var nextElement = allEObjectsInFunction.next
			// only function calls in statements are important (return value is used)
			if(nextElement instanceof Statement){
				val stm = nextElement as Statement
				if(stm.isNonComplexStatement) allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.getAllFunctionCallsInEObject)
				else {
					if(stm instanceof SwitchStatement) allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.variable.getAllFunctionCallsInEObject)
					else if(stm instanceof ForStatement){
						allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.statements.head.getAllFunctionCallsInEObject)
						allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.termination.getAllFunctionCallsInEObject)
						allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.increment.getAllFunctionCallsInEObject)
					}
					else if(stm instanceof WhileStatement) allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.condition.getAllFunctionCallsInEObject)
					else if(stm instanceof IfStatement) allTupleTypes = genTupleTypeForIdExprQueue(allTupleTypes,stm.condition.getAllFunctionCallsInEObject)
				}
			}
		}
		return allTupleTypes
	}
	/**
	 * helper function to create tuple types from idExpression queues for a different kind of 
	 * statements and variant type is built up
	 * @param allTupleTypes represents the (so far builded) variant type 
	 * @param functionCallQueue represents all function calls of interruptible functions in a statement
	 * @return C++-string representation for the variant type of an interruptible function
	 */
	private def String genTupleTypeForIdExprQueue(String allTupleTypes, Queue<IdExpr> functionCallQueue){
		var String allTupleTypesTemp = allTupleTypes
		if((functionCallQueue !== null) && !functionCallQueue.empty){
			// one specific tuple type is built for function calls in functionCallQueue 
			var String tupleTypes = '''«functionCallQueue.genTupleType»'''
			// only non empty and no multiple tuple types are created
			if(!("".equals(tupleTypes)) && !(allTupleTypes.contains('''std::tuple<«tupleTypes»>''')))
				allTupleTypesTemp += ''', std::tuple<«tupleTypes»>'''
		}
		return allTupleTypesTemp
	}
	/**
	 * helper function to create tuple types for a variant definition from an stack of function calls.
	 * Function calls of type void are ignored and return value types of interruptible function calls are saved 
	 * in a global variant @see returnValueTempType.
	 * @param idExprStack represents all interruptible function calls in a specific statement
	 * @return C++-string representation for a specific tuple type
	 */
	private def String genTupleType(Queue<IdExpr> idExprStack){
		val List<IdExpr> fCallList = newArrayList(idExprStack)
		'''«FOR f:fCallList.filter[!(((referencedElement) as Function).primitiveType instanceof VoidType)] SEPARATOR ','»
				«((f.referencedElement) as Function).genType»
		   «ENDFOR»
		'''
	}
	/**
	 * generates C++-string representation of parameter declarations of an interruptible function
	 * (parameters are saved in a structure for every interruptible function)
	 * @param f represents DBL interruptible function
	 * @return C++-string representation of parameter declarations of an interruptible function
	 */
	private def genFunctionCallParametersDeclaration(Function f){
		'''
			«FOR p:f.parameters»
				«p.genType» «p.genPreciseName»;
			«ENDFOR»
		'''
	}
	/**
	 * generates C++-string representation of variable declarations of an interruptible function
	 * (variables are saved in a structure for every interruptible function)
	 * @param allVariables all variables that are in statement block of the interruptible function
	 * @return C++-string representation of variable declarations of an interruptible function
	 */
	private def genVariableDeclarationsInStruct(Set<Pair<Variable,Integer>> allVariables){
		'''
			«FOR v:allVariables»
				«v.genVariableDeclaration»
			«ENDFOR»
		'''
	}
	/**
	 * determines all variable declarations in a statement block of interruptible functions
	 * @param statementList is an EObject node from which to iterate over the etreeSet to get all variables
	 * @return set of all variables plus ID, that are declared in a statement block of interruptible functions
	 */
	private def Set<Pair<Variable,Integer>> getAllVariablesInStatementBlock(EObject statementList){
		var Set<Pair<Variable,Integer>> allVariables = new HashSet<Pair<Variable,Integer>>
		if(statementList !== null){
			// get all contained EObjects in the statementList and set a variable counter on zero
			val allEObjectsInFunction = statementList.eAllContents
			var int variableId = 0
			while(allEObjectsInFunction.hasNext){
				var nextElement = allEObjectsInFunction.next
				// if variable declaration was found, the variable name and ID will be saved globally
				if(nextElement instanceof Variable) 
					allVariables.add(nextElement as Variable->variableId++)
			}
		}
		return allVariables
	}
	// COROUTINE BEHAVIOUR CREATING LABELS AND JUMPING TO SCHEDULER END
	
	// MAPPING OF FUNCTIONS CONTAINING SCHEDULING FUNCTION CALLS BEGIN
	/**
	 * Functions which are interruptible have to be mapped differently than usual functions. So this function 
	 * delegates the generation of usual functions to the base generator and only generates the code for 
	 * interruptible functions. The main function has to be ignored, because its generated elsewhere.
	 * @param f representing DBL function
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++-String representation of DBL function
	 */
	override String genFunction(Function f, boolean isHeader){
		if(f != mainModule.functions.findFirst[name == 'main']){
			if(all_Functions_containing_sched.contains(f)){
				if(isHeader) f.genInterruptibleFunctionH
				else f.genInterruptibleFunctionCPP
			}
			else super.genFunction(f,isHeader)
		}
	}
	/**
	 * this function creates C++-string representation of all function calls of interruptible functions 
	 * which are used in statements based on informations from a built id expression queue. Statements that 
	 * contain function calls of interruptible functions have to be simulated. Therefore all of these function calls
	 * are determined and scheduled before the statement. The return values are saved in a tuple, which is saved 
	 * in a variant for every function, which calls such interruptible functions.
	 * @param idExprStack contains function calls of interruptible functions in correct order (example: (f()+g()+a(b(c())) -> f,g,c,b,a)
	 * @return C++-string representation of all function calls of interruptible functions which are used in statements
	 */
	private def String genInterruptibleFunctionCalls(Queue<IdExpr> idExprStack){
		var result = ""
		if(!idExprStack.isEmpty){
			val isVoidType = (idExprStack.peek().referencedElement as Function).primitiveType instanceof VoidType
			// function call as statement is ignored
			if (!(isVoidType && (idExprStack.size == 1))) {
	 			var tuple_index = 0;
	 			// creating current tuple type which is used in other function
				currentTuple = '''«idExprStack.genTupleType»'''
				// a new tuple is created to save return values for interruptible function calls
				if(!("".equals(currentTuple))) 
					result += '''context->rv_variant = std::tuple<«currentTuple»>();'''
				while(!idExprStack.isEmpty){
					val idexpr = idExprStack.peek()
					val function = (idexpr.referencedElement) as Function
					result += function.genInterruptibleFunctionCallAndSaveReturnValue(idexpr,tuple_index)
					// saves the position of a function call in the tuple
					tupleMap.put(idexpr,new Integer(tuple_index++))
					idExprStack.remove()
				}
			}
		}
		return result
	}
	/**
	 * This function creates a function call for an interruptible function and gets the return value 
	 * of the called function from the global variant and puts it into the tuple of return values in its 
	 * own function context variant. After that the global temporary variant content could be deleted, which is 
	 * done by setting it to null pointer.
	 * @param function represents interruptible function
	 * @param idexpr represents the corresponding function call of the interruptible function
	 * @param tuple_index represents the position of the function call in the return value tuple.
	 * @return C++-string representation of all function calls of interruptible functions which are used in statements
	 */
	private def String genInterruptibleFunctionCallAndSaveReturnValue(Function function, IdExpr idexpr, int tuple_index){
		includeStrings.add('''#include "../TempReturnVariant.h"''')
		'''
			«function.genInterruptibleFunctionCall(idexpr)»
			std::get<«tuple_index»>(get<std::tuple<«currentTuple»>>(context->rv_variant)) = get<«function.genType»>(returnValueTemp);
			returnValueTemp = nullptr;
		'''
	}
	/**
	 * Function calls of interruptible function are treated differently than usual function calls.
	 * @param call represents DBL function Call
	 * @return C++-string representation for a function call
	 */
	override dispatch String genStatement(FunctionCall call) {
		val function = (call.callIdExpr.referencedElement) as Function
		if(!all_Functions_containing_sched.contains(function)) 
			'''«call.callIdExpr.genIdExprPassive»;''' 
		else 
			'''«function.genInterruptibleFunctionCall(call.callIdExpr)»'''
	}
	/**
	 * creates C++-string representation of an simulated interruptible function call. Therefore schedule() function 
	 * is called on the current active process to fill its coroutine stack with the called function and its 
	 * function context. To understand the schedule()-method call @see base class Process. There is difference 
	 * between calling interruptible functions of the main process or other processes. 
	 * @param function represents DBL interruptible function 
	 * @param call represents DBL interruptible function call
	 * @return C++-string representation of a simulated interruptible function call
	 */
	private def String genInterruptibleFunctionCall(Function function, IdExpr call){
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		val clazz = if (function.eContainer instanceof Class) function.eContainer as Class else null;
		'''
			«IF clazz === null»
				«genScheduleMethodCall(function,call,"MainProcess","cbsLib::Scheduler::getScheduler()->getMainProcess()")»
			«ELSE»
				«genScheduleMethodCall(function,call,'''«clazz.genType»''','''«IF call.parentIdExpr !== null && !(call.parentIdExpr.predefinedId instanceof SuperLiteral) && !(call.parentIdExpr.predefinedId instanceof MeLiteral)»«call.parentIdExpr.genIdExpression».get()«ELSE»cbsLib::Scheduler::getScheduler()->getCurrentProcess().get()«ENDIF»''')»		
			«ENDIF»
			«genSwitchCase(true)»
		'''
	}
	/**
	 * creates C++-string representation for a call to the schedule()-function. For informations about schedule()-
	 * function @see Process class. 
	 * @param function represents DBL interruptible function 
	 * @param call represents DBL interruptible function call
	 * @param type represents the type of the owner of the function (main process or other processes)
	 * @param functionCaller represents the caller of the function
	 * @return C++-string representation for call to schedule()-function
	 */
	private def String genScheduleMethodCall(Function function, IdExpr call, String type, String functionCaller){
		'''cbsLib::Scheduler::getScheduler()->getCurrentProcess()->schedule<«type»,&«type»::«function.genDistinctFunctionName»>
			(«functionCaller», new «type»::«function.genDistinctFunctionName»Struct(«call.callPart.callArguments.genActualParameters»));'''
	}
	/**
	 * generates C++-string representation for a special DBL id expression. This is a edge case, because 
	 * function calls are replaced by their return value, if the function called is interruptible. So 
	 * the whole id expression is not built.
	 * @param idExpr representation of DBL identifier expression
	 * @return C++-string representation for a special DBL id expression
	 */
	override String genSpecialIdExpression(IdExpr idExpr){
		val it = idExpr
		if(referencedElement instanceof Function)
			'''«genFunctionCallInActionsBlock(referencedElement as Function)»'''
		else 
			super.genIdExprPassive(idExpr)
	}
	/**
	 * generates C++-string representation for referenced elements. This is a edge case, because 
	 * variables and parameters in interruptible functions are accessed via their function context.
	 * @param idExpr representation of DBL identifier expression
	 * @param referencedElement representation of the corresponding referenced element
	 * @return C++-string representation for referenced elements
	 */
	override String genIdExpr_for_ReferencedElement(IdExpr idExpr, NamedElement referencedElement) {
		val it = idExpr
		if(isActionsBlock){
			if(parentIdExpr === null && referencedElement instanceof Variable)
				'''«(referencedElement as Variable).genQualifiedNameVariableInActionsBlock(idExpr)» «genCallArgumentsAndArrayIndex»'''
			else if(parentIdExpr === null && referencedElement instanceof Parameter)
				'''«(referencedElement as Parameter).genQualifiedNameParameterInActionsBlock(idExpr)» «genCallArgumentsAndArrayIndex»'''
			else
				super.genIdExpr_for_ReferencedElement(idExpr,referencedElement)
		}
		else super.genIdExpr_for_ReferencedElement(idExpr,referencedElement)
	}
	/**
	 * saves required includes when generating parameter or variable names in interruptible
	 * functions
	 * @param element variable or parameter that should be generated
	 */
	private def genQualifiedNamesAndSaveIncludes(NamedElement element){
		val it = element
		if(element instanceof TypedElement) element.genType
		if(eContainer instanceof Module) {
			val module = eContainer as Module
			includes.add(module)
		}
	}
	/**
	 * generates C++-string representation for a DBL function call of an interruptible function
	 * in a statement/ replaces function calls with return value (return value is taken out of the variant
	 * in the context, which contains tuples)
	 * @param idExpr DBL function call in actionsBlock
	 * @param refElement function that belongs to the idExpr
	 * @return C++ string representation for a DBL function call of an interruptible function in a statement
	 */
	private def String genFunctionCallInActionsBlock(IdExpr idExpr, Function refElement){
		if(all_Functions_containing_sched.contains(refElement)){
			refElement.genQualifiedNamesAndSaveIncludes
			'''std::get<«tupleMap.get(idExpr)»>(get<std::tuple<«currentTuple»>>(context->rv_variant))«FOR index:idExpr?.arrayIndex»->operator[](«index.genExpression»)«ENDFOR»''' 
		} 
		else super.genIdExprPassive(idExpr)
	}
	/**
	 * When returning from interruptible functions some actions has to be done, specifically the 
	 * top of the callStack has to be popped, the returnValue is globally saved in returnValueTemp variant
	 * and the control is transferred to the scheduler. A block surrounds the statements cause normally 
	 * a return statement is a single statement.
	 * @param stm represents the return statement in an interruptible function
	 * @return C++-string representation for a special return statement in an interruptible function
	 */
	override String genSpecialReturnStatementForSchedulingFunction(Return stm){
		// only in interruptible functions with return value needed
		val intrusiveWrapperType = stm.checkAndGetReturnValue
		if(currentFunction !== null){
			includeStrings.add('''#include "../TempReturnVariant.h"''')
			'''
			{
				«IF intrusiveWrapperType !== null»
					returnValueTemp = cbsLib::intrusive_ptr<«intrusiveWrapperType»>(«stm.value.genInitialValue(getFunction(stm))»);
				«ELSE»
					returnValueTemp = «stm.value.genInitialValue(getFunction(stm))»;
				«ENDIF»
				«deleteTopOfCallStack(2)»
			}
			'''
		}
	}
	/**
	 * the return value has to be wrapped in a intrusive_ptr, because raw pointers cannot be handled by
	 * the variant (only string and new expressions have to be wrapped)
	 * @param stm represents the return statement in an interruptible function
	 * @return C++-string representation for the class type needed by intrusive_ptr instantiation
	 */
	private def String checkAndGetReturnValue(Return stm){
		val it = stm
		if (stm.value instanceof CreateObject && (stm.value as CreateObject).typeArrayDimensions.empty) return '''«getFunction(stm).genPrimitiveOrClassType(false)»'''
		else if(stm.value instanceof CreateObject && !(stm.value as CreateObject).typeArrayDimensions.empty) return '''«getFunction(stm).genVectorType(getFunction(stm).typeArrayDimensions.size)»'''
		else if(value.stringNeedsCreationOnHeap) return "cbsLib::myString"
		else return null;
	}
	// MAPPING OF FUNCTIONS CONTAINING SCHEDULING FUNCTION CALLS END
	
	// MAPPING OF PARAMETERS IN COROUTINES BEGIN
	/**
	 * Parameters of interruptible functions are accessed via the function context
	 * @param element represents parameter of a function
	 * @param id represents the whole identifier expression
	 * @return C++-string representation of parameters
	 */
	private def String genQualifiedNameParameterInActionsBlock(Parameter element, IdExpr id){
		val Parameter param = currentFunction.parameters.findFirst[it == element]
		if(param !== null) '''context->«param.genPreciseName»'''
		else element.genQualifiedName_for_ProcedureVariableAccess
	}
	// MAPPING OF PARAMETERS IN COROUTINES END
	
	// MAPPING OF VARIABLES IN COROUTINES BEGIN
	/**
	 * variables in interruptible functions are accessed via function context. They also have a 
	 * variable ID, which is unique and make it possible to save variables with same name. They are 
	 * declared in the specific function context.
	 * @param variable represents a pair of variable and variable ID 
	 * @return C++-string representation for variable declarations in function context
	 */
	private def String genVariableDeclaration(Pair<Variable,Integer> variable) {
		'''«variable.key.genVariableDeclarationPrefix(true)» «variable.genPreciseVariableName»;'''	
	}
	/**
	 * creates unique variable names of the DBL variable name concatenated with a unique ID.
	 * @param variable represents a pair of variable and variable ID 
	 * @return C++-string representation of variable names
	 */
	private def String genPreciseVariableName(Pair<Variable,Integer> variable) {
		'''«variable.key.genPreciseName»«variable.value»'''
	}
	/**
	 * Variables in interruptible functions are accessed via the context. The name of the variable 
	 * is generated via the DBL name and a specific ID.
	 * @param element represents DBL variable in an interruptible function
	 * @param id represents the whole identifier expression
	 * @return C++-string representation for variable usage in interruptible functions
	 */
	private def String genQualifiedNameVariableInActionsBlock(Variable element, IdExpr id) {
		val foundVariable = allVariables.findFirst[key == element]
		if(foundVariable !== null) '''context->«foundVariable.genPreciseVariableName»'''
		else element.genQualifiedName_for_ProcedureVariableAccess
	}
	/**
	 * Variable declarations/definitions are forbidden in interruptible functions. They are instead 
	 * generated in a function context and then are accessed via that context. When there is a definition 
	 * of a variable, only the initializing takes place. 
	 * @param variable a variable which should be declared/defined in an interruptible function
	 * @return C++-string representation of the DBL variable definition by accessing the variable via the 
	 * function context.
	 */
	override String genActionsBlockVariable(Variable variable){
		val foundVariable = variable->new Integer(variableId)
		variableId++
		allVariables.add(foundVariable)
		if(variable.initialValue !== null) 
			'''context->«foundVariable.genPreciseVariableName» = «variable.initialValue.genInitialValue(variable)»;'''
	}
	// MAPPING OF VARIABLES IN COROUTINES END
	
	// STRING GENERATION FOR SIMULATION STATEMENTS AND EXPRESSIONS BEGIN
	/**
	 * generates C++-string representation for EObjects that are not known in the BaseGenerator.
	 * This function is called in baseClass and if there are statements or expressions which are not 
	 * available, the functions of this derived class are called.
	 * @param eObj represents some EObject (simulation expression or simulation statement) 
	 * that couldn't be mapped on type in baseClass
	 * @return C++-string representation for specific simulation EObject
	 */
	override String forwardGen(EObject eObj) {
		if (eObj instanceof Statement) 
			(eObj as Statement).genSimStatement
		else if (eObj instanceof Expression) 
			(eObj as Expression).genSimExpr
		else '<! unknown element ' + eObj.eClass.name + ' !>'
	}
	/**
	 * generates error string for not known DBL statement
	 * @param stm represents an unknown DBL statement type
	 * @return error string if unknown statement was used
	 */
	protected def dispatch String genSimStatement(Statement stm) {
		'''<! Statement is not known !>'''
	}
	/**
	 * generates C++-string representation for DBL yield statement. For yield() implementation
	 * @see yield() function in scheduler class 
	 * @param stm represents DBL yield statement
	 * @return C++-string representation for yield statement
	 */
	protected def dispatch String genSimStatement(Yield stm) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''
			{
				cbsLib::Scheduler::getScheduler()->yield(cbsLib::Scheduler::getScheduler()->getCurrentProcess());
				«genSwitchCase(false)»
			}
		'''
	}
	/**
	 * generates C++-string representation for DBL wait statement. For wait() implementation
	 * @see wait() function in scheduler class 
	 * @param stm represents DBL wait statement
	 * @return C++-string representation for DBL wait statement
	 */
	protected def dispatch String genSimStatement(Wait stm) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''
			{
				cbsLib::Scheduler::getScheduler()->wait(cbsLib::Scheduler::getScheduler()->getCurrentProcess());
				«genSwitchCase(false)»
			}
		'''
	}
	/**
	 * generates C++-string representation for DBL advance statement. For advance() implementation
	 * @see advance() function in scheduler class 
	 * @param stm represents DBL advance statement
	 * @return C++-string representation for DBL advance statement
	 */
	protected def dispatch String genSimStatement(Advance stm) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''
			{
				cbsLib::Scheduler::getScheduler()->advance(cbsLib::Scheduler::getScheduler()->getCurrentProcess(), «stm.time.genExpression»);
				«genSwitchCase(false)»
			}
		'''
	}
	/**
	 * generates C++-string representation for DBL terminate statement. For terminate() implementation
	 * @see terminate() function in scheduler class. Terminate is not defined in the DBL->Java reference 
	 * code generator.
	 * @param stm represents DBL terminate statement
	 * @return C++-string representation for DBL terminate statement
	 */
	protected def dispatch String genSimStatement(Terminate stm){
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''
			{
				cbsLib::Scheduler::getScheduler()->terminate(cbsLib::Scheduler::getScheduler()->getCurrentProcess());
				«genSwitchCase(false)»
			}
		'''
	}
	/**
	 * generates C++-string representation for DBL reactivate statement. For reactivate() implementation
	 * @see reactivate() function in scheduler class. 
	 * @param stm represents DBL reactivate statement
	 * @return C++-string representation for DBL reactivate statement
	 */
	protected def dispatch String genSimStatement(Reactivate stm) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''cbsLib::Scheduler::getScheduler()->reactivate(«stm.objectAccess.genExpression»);'''
	}
	/**
	 * generates C++-string representation for DBL activate statement. For activate implementation
	 * @see activate() function in scheduler class. To fill the call stack for the activated process 
	 * the function schedule() is called. 
	 * @param stm represents DBL activate statement
	 * @return C++-string representation for DBL activate statement
	 */
	protected def dispatch String genSimStatement(ActivateObject stm) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
	    '''cbsLib::Scheduler::getScheduler()->activate(«stm.objectAccess.genExpression»,«stm.priority.toString»);'''
	}
	/**
	 * generates error string for not known DBL expression
	 * @param expr represents an unknown DBL expression type
	 * @return error string if unknown expression was used
	 */
	protected def dispatch String genSimExpr(Expression expr) {
		'''<! Expression is not known !>'''
	}
	/**
	 * generates C++-string representation for DBL time expression. For time implementation
	 * @see modelTime attribute in scheduler class. 
	 * @param expr represents DBL time expression
	 * @return C++-string representation for DBL time expression
	 */
	protected def dispatch String genSimExpr(TimeLiteral expr) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''cbsLib::Scheduler::getScheduler()->getCurrentSimulationTime()'''
	}
	/**
	 * generates C++-string representation for DBL active expression. This returns an intrusive 
	 * pointer to the current active process. 
	 * @param expr represents DBL active expression
	 * @return C++-string representation for DBL active expression
	 */
	protected def dispatch String genSimExpr(ActiveLiteral expr) {
		includeStrings.add('''#include "../../../C++-Libraries/simulationCore/Scheduler.h"''')
		'''cbsLib::Scheduler::getScheduler()->getCurrentProcess()'''
	}
	/**
	 * string have to be handled like Java Strings/ here the function is extended by 
	 * a toString-representation for the simulation specific expressions active and time.
	 * @param e expression for which a toString representation has to be created
	 * @return C++-string representation for an expression
	 */
	override String expressionToString(Expression e){
		if(e instanceof ActiveLiteral || e instanceof TimeLiteral) 
			genToStringUsage('''to_String(«e.genSimExpr»)''')
		else 
			super.expressionToString(e)
	}
	// STRING GENERATION FOR SIMULATION STATEMENTS AND EXPRESSIONS END
	
	// SPECIAL STATEMENT GENERATION BEGIN
	/**
	 * generates C++-string representation for DBL statements and generates function calls of 
	 * interruptible functions before that statement, because they cannot be created in the statement directly.
	 * @param statements list of DBL statements
	 * @return C++-string representation for DBL statements
	 */
	override String genStatements(List<Statement> statements){
		if(inActionsBlock) 
			'''«FOR stm:statements»«stm.genSpecialStatement(false)»«ENDFOR»'''
		else 
			super.genStatements(statements)
	}
	/**
	 * generates C++-string representation for DBL statement and generates function calls of 
	 * interruptible functions before that statement, because they cannot be created in the statement directly. 
	 * @param stm DBL statement which could contain function calls of interruptible functions
	 * @param needsBlock signals if a statement block ({}) is needed
	 * @return C++-string representation for DBL statement
	 */
	private def genSpecialStatement(Statement stm, boolean needsBlock){
		'''«createFunctionCallsAndStatement(stm.genSchedulingFunctionCallsForStatement,stm,needsBlock)»'''
	}
	/**
	 * all function calls of interrupted functions in a statement are determined and generated before the statement
	 * except for complex statements, which are generated with a specialized functions themselves.
	 * @param stm represents a specific DBL statement 
	 * @return C++-string representation for all function calls in the statement
	 */
	private def String genSchedulingFunctionCallsForStatement(Statement stm){
		if(stm.isNonComplexStatement) 
			stm.getAllFunctionCallsInEObject.genInterruptibleFunctionCalls
	}
	/**
	 * checks if a statement is complex (for-,while-loop, switch, if-else and block-statement), 
	 * which means it contains further statements.
	 * @param stm a specific DBL statement 
	 * @return if statement is complex
	 */
	private def boolean isNonComplexStatement(Statement stm){
		return (!(stm instanceof ForStatement) && !(stm instanceof WhileStatement) && !(stm instanceof IfStatement) && 
			!(stm instanceof LocalScopeStatement) && !(stm instanceof SwitchStatement))
	}
	/**
	 * this function checks for all kind of statements or expressions if they contain function calls
	 * of interruptible functions and builds a queue of function calls in the order (order is from 
	 * left to right and inner function calls before outer function calls)
	 * @param s represents a specific DBL EObject 
	 * @return queue of ID-expressions representing the function calls of interruptible functions in a 
	 * EObject
	 */
	private def Queue<IdExpr> getAllFunctionCallsInEObject(EObject s){
		var Queue<IdExpr> idExprQueue = new LinkedList<IdExpr>()
		// checks for inner function calls in a single function call
		if(s.isInterruptibleFunctionCall) 
			genInnerFunctionCalls(idExprQueue, s as IdExpr)
		else if(s !== null) 
			buildFunctionCallQueue(idExprQueue, s.eAllContents())
		return idExprQueue
	}
	/**
	 * this function adds function calls to the queue and calls buildFunctionCallQueue for the call part of 
	 * the function. Attention: Function calls, which contain further function calls have to be put 
	 * after the inner function calls into the queue.
	 * @param queue represents the generated function call queue
	 * @param fCall represents the function call which should be added to the queue
	 */
	private def void genInnerFunctionCalls(Queue<IdExpr> queue, IdExpr fCall){
		val allEObjectsInStatement = fCall?.eAllContents();
		// call part of function fCall is generated first to add inner function calls before fCall
		if(allEObjectsInStatement !== null) 
			buildFunctionCallQueue(queue,allEObjectsInStatement)
		queue.add(fCall);
	}
	/**
	 * this function checks all contained elements of an EObject, if it is a function call 
	 * of an interruptible function and if so, it calls another function to add this function call 
	 * and start checking for the call part of the function.
	 * @param queue represents the generated function call queue
	 * @param treeIt represents all contained objects of an specific EObject
	 */
	private def void buildFunctionCallQueue(Queue<IdExpr> queue, TreeIterator<EObject> treeIt){
		while(treeIt.hasNext){
			var nextElement = treeIt.next
			if(nextElement.isInterruptibleFunctionCall){
				// add function call to id expression queue and start checking the call part of the function
				queue.genInnerFunctionCalls(nextElement as IdExpr)
				// after returning from the previous function call, the call part of the function should 
				// not be checked again, so the EObject tree is cut
				treeIt.prune();
			}
		}
	}
	/**
	 * this function checks if an id-expression is a function call of an interruptible function
	 * @param eObj represents an specific DBL EObject
	 * @return checks if id expression is a function call of an interruptible function
	 */
	private def boolean isInterruptibleFunctionCall(EObject eObj){
		if(eObj instanceof IdExpr && (eObj as IdExpr).referencedElement instanceof Function 
			&& all_Functions_containing_sched.contains((eObj as IdExpr).referencedElement as Function)
		) return true
		else return false
	}
	/**
	 * special switch-statements could have a switch-expression, which contains function calls of  
	 * interruptible functions, that has to be tested and mapped accordingly. The function call is 
	 * executed before the switch-statement in that case. The problem here is that there is a big switch
	 * statement in every interruptible function and to ensure that the correct case labels are found when
	 * re-executing functions. There could also be problems when there are duplicate labels.
	 * Switch-Statements are slightly changed with new case labels. 
	 * @param stm representation of DBL switch-statement 
	 * @return C++-string representation of a special DBL switch-statement in interruptible functions
	 */
	var int caseCounter = 0
	var int caseCounter2 = 0
	override String genSpecialSwitchStatement(SwitchStatement stm){
		val it = stm
		forLoopIdCount++
		loopContinueLabelIdMap.put(stm,forLoopIdCount)
		var String endLabel = '''END«forLoopIdCount»:;'''
		val isStringType = variable.idExpr.isExpressionStringType
		val fCalls = '''«variable.getAllFunctionCallsInEObject.genInterruptibleFunctionCalls»'''
		'''
		{
			«fCalls»
			«FOR c : cases SEPARATOR "else"»
			if(«IF isStringType»*(«variable.genExpression»)«ELSE»«variable.genExpression»«ENDIF» == «IF c.value.checkComplexExpression»«c.value.expressionToString»«ELSE»«c.value.genExpression»«ENDIF») goto SWITCHCASE«caseCounter++»;
			«ENDFOR»
			«IF defaultCase !== null»else goto SWITCHCASE«caseCounter++»;«ENDIF»
			
			«FOR c : cases»
			SWITCHCASE«caseCounter2++»: «genBlockForStatement(c.body.exists[it instanceof Variable],'''«c.body.genStatements»''')»
			«ENDFOR»
			«IF defaultCase !== null»
			SWITCHCASE«caseCounter2++»: «genBlockForStatement(defaultCase.body.exists[it instanceof Variable],'''«defaultCase.body.genStatements»''')»
			«ENDIF»
			«endLabel»
			«IF !("".equals(fCalls))»context->rv_variant = nullptr;«ENDIF»
		}	
		'''
	}
	/**
	 * special break-statements which are used in special switch statements. Switch statements are 
	 * re-builded using goto-jumps and renamed case labels. The break-statement is changed so that 
	 * a jump to the end of the corresponding switch-statement is performed.
	 * @param stm representation of DBL break-statement 
	 * @return C++-string representation for a special DBL break-statement in interruptible function
	 */
	override String genSpecialBreakStatement(BreakStatement stm){
		val breakLabelId = loopContinueLabelIdMap.get(getCorrespondingSwitch(stm))
		if(breakLabelId !== null) 
			'''goto END«breakLabelId»;'''
		else 
			'''break;'''
	}
	/**
	 * helper function to get the corresponding switch-statement, in which the break-statement
	 * is used. 
	 * @param stm representation of DBL break-statement 
	 * @return special DBL switch-statement, which contains the break-statement, otherwise null
	 */
	private def SwitchStatement getCorrespondingSwitch(BreakStatement stm){
		var temp = stm.eContainer
		while(!(temp instanceof SwitchStatement) && !(temp instanceof Module)) 
			temp = temp.eContainer
		if(temp instanceof SwitchStatement) return temp
		else return null
	}
	/**
	 * special if-statements could have a condition, which contains function calls of 
	 * interruptible functions, that has to be tested and mapped accordingly
	 * @param stm representation of DBL if-statement 
	 * @return C++-string representation for a special DBL if-statement
	 */
	override String genSpecialIfStatement(IfStatement stm){
		val it = stm
		'''
			«condition.getAllFunctionCallsInEObject.genInterruptibleFunctionCalls»
			if («condition.genExpression») «IF trueCase instanceof Variable»{«trueCase.genSpecialStatement(true)»}«ELSE»«trueCase.genSpecialStatement(true)»«ENDIF»
			«IF falseCase !== null»
				else «IF falseCase instanceof Variable»{«falseCase.genSpecialStatement(true)»}«ELSE»«falseCase.genSpecialStatement(true)»«ENDIF»
			«ENDIF»
		'''
	}
	/**
	 * special for-loops could contain function calls of interruptible functions in the loop head 
	 * (e.g. initialization part or condition check), that has to be tested and simulated by 
	 * transforming the for-loop into a while-loop. In case of continue-statements in that special loops
	 * a label update is defined which can be jumped to via goto-jump.
	 * @param stm representation of a DBL for-loop 
	 * @return C++-string representation of a special DBL for-loop
	 */
	override String genSpecialForStatement(ForStatement stm){
		val it = stm
		val String init = statements.head.genSchedulingFunctionCallsForStatement
		val String cond = termination.getAllFunctionCallsInEObject.genInterruptibleFunctionCalls
		val String update = increment.genSchedulingFunctionCallsForStatement
		
		//only if there are function calls of interruptible functions in the loop head the following code is needed
		if(!("".equals(init)) || !("".equals(cond)) || !("".equals(update))) {
			// forLoopIdCount is augmented, cause every loop has its own update label
			// which is saved in a loopContinueLabelIdMap map
			forLoopIdCount++
			loopContinueLabelIdMap.put(stm,forLoopIdCount)
			var String updateLabel = '''update«forLoopIdCount»:'''
			return
			'''
				«statements.head.genSpecialStatement(false)»
				while(true){
					«cond»
					if(«termination.genExpression»){
						«body.genSpecialStatement(false)»
						«update»
						«updateLabel»«increment.genAssignment(true)»
					}
					else break;
				}
			'''
		}
		// usual for-loop like in the base class, its not possible to call the super.genStatement 
		// ( Bug: Xtend when calling dispatch methods of base classes lead to infinite loop )
		else return
			'''
				for («statements.head.genStatement» «termination.genExpression»;«increment.genAssignment(false)»)
					«body.genSpecialStatement(true)»
			'''
	}
	/**
	 * for-loop could contain function calls of interruptible functions in the loop head.
	 * Therefore a simulation with while-loop is done. Continue statements in that loops have to be 
	 * mapped via goto-jumps to an update label. At first a check is performed if the continue-statement belongs 
	 * to a simulated loop.
	 * @param stm represents a DBL continue-statement 
	 * @return C++-string representation for a special DBL continue-statement
	 */
	override String genSpecialContinueStatement(ContinueStatement stm){
		val continueLabelId = loopContinueLabelIdMap.get(getCorrespondingLoop(stm))
		if(continueLabelId !== null) 
			'''goto update«continueLabelId»;'''
		else 
			'''continue;'''
	}
	/**
	 * determines the loop which contains the continue-statement
	 * @param stm represents a DBL continue-statement  
	 * @return loop which contains the continue-statement
	 */
	private def Statement getCorrespondingLoop(ContinueStatement stm){
		var temp = stm.eContainer
		while(!(temp instanceof ForStatement) && !(temp instanceof WhileStatement)) 
			temp = temp.eContainer
		return temp as Statement;
	}
	/**
	 * special while-loops could contain function calls of interruptible functions in the loop head 
	 * (condition check), that has to be tested and simulated by 
	 * transforming the while-loop. In case of continue-statements in that special loops
	 * a label update is defined which can be jumped to via goto-jump.
	 * @param stm representation of a DBL while-loop 
	 * @return C++-string representation of a special DBL while-loop
	 */
	override String genSpecialWhileStatement(WhileStatement stm){
		val it  = stm
		val String cond = condition.getAllFunctionCallsInEObject.genInterruptibleFunctionCalls
		if(!("".equals(cond))) {
		forLoopIdCount++
		loopContinueLabelIdMap.put(stm,forLoopIdCount)
		return
			'''
				while(true){
					update«forLoopIdCount»:«cond»
					if(«condition.genExpression»){
						«body.genSpecialStatement(false)»
					}
					else break;
				}
			'''
		}
		else return 
			'''
				while («condition.genExpression») 
					«body.genSpecialStatement(true)»
			'''
	}
	/**
	 * generates function calls of interruptible functions first and then the statement 
	 * and creates a statement block if needed. Also the return value variant is set on null pointer 
	 * which delete the last tuple of return values which are not needed anymore. 
	 * @param fCalls string representation for all function calls of interruptible functions for the statement s
	 * @param s statement that should be generated 
	 * @param checkBlock signals if a statement block ({}) is needed
	 * @return string representation of function calls before statement
	 */
	private def String createFunctionCallsAndStatement(String fCalls, Statement s, boolean checkBlock){
		'''
			«IF fCalls !== null && !"".equals(fCalls)»
				«IF checkBlock»{«ENDIF»«fCalls» «s.genStatement» context->rv_variant = nullptr;«IF checkBlock»}«ENDIF»
			«ELSE»«s.genStatement»
			«ENDIF»
		'''
	}
	// SPECIAL STATEMENT GENERATION END
	
	// MAKEFILE AND OTHER IMPORTANT STUFF ***
	/**
	 * generates C++-string representation for path of simulation core CPP files 
	 * @param count counter for makefile SRCS variables
	 * @return C++-string representation for path of simulation core CPP files 
	 */
	override String addSimulationCoreToMakeFile(int count){
		var result = ""
		var temp = count
		result += '''SRCS«temp++» = ../../C++-Libraries/simulationCore/ProcessCompare.cpp ../../C++-Libraries/simulationCore/EventNote.cpp ../../C++-Libraries/simulationCore/Process.cpp ../../C++-Libraries/simulationCore/Scheduler.cpp «IF(makefileNeedsGlobalVariantType)» TempReturnVariant.cpp«ENDIF»
				  '''
		return result;
	}
	/**
	 * generates C++-string representation for additional SRCS variables in the makefile
	 * @param count counter for makefile SRCS variables
	 * @return C++-string representation for SRCS variables in the makefile
	 */
	override String genSRCSSimulation(int count) {
		var result = ""
		var temp = count
		result += ''' $(SRCS«temp++»)'''
		return result;
	}
	/**
	 * indicates that an interruptible function is being created.
	 * @return isActionsblock signals if an interruptible function is being created.
	 */
	override boolean isInActionsBlock(){
		return isActionsBlock
	}
}