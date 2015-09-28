package hub.sam.dmx.targetcode

import hub.sam.dbl.Class
import hub.sam.dbl.Model
import hub.sam.dbl.Module
import java.io.Writer
import java.util.logging.Logger
import org.eclipse.core.runtime.IPath
import hub.sam.dbl.LanguageConstructClassifier
import hub.sam.dbl.TypedElement
import hub.sam.dbl.Type
import hub.sam.dbl.IntType
import hub.sam.dbl.VoidType
import hub.sam.dbl.StringType
import hub.sam.dbl.BoolType
import hub.sam.dbl.DoubleType
import hub.sam.dbl.IdExpr
import java.util.List
import hub.sam.dbl.Variable
import hub.sam.dbl.Statement
import hub.sam.dbl.Print
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.Expression
import hub.sam.dbl.IfStatement
import hub.sam.dbl.LocalScopeStatement
import hub.sam.dbl.Assignment
import hub.sam.dbl.Return
import hub.sam.dbl.BreakStatement
import hub.sam.dbl.ContinueStatement
import hub.sam.dbl.SwitchStatement
import hub.sam.dbl.ForStatement
import hub.sam.dbl.WhileStatement
import hub.sam.dbl.Or
import hub.sam.dbl.And
import hub.sam.dbl.Equal
import hub.sam.dbl.NotEqual
import hub.sam.dbl.Greater
import hub.sam.dbl.GreaterEqual
import hub.sam.dbl.Less
import hub.sam.dbl.LessEqual
import hub.sam.dbl.Plus
import hub.sam.dbl.Minus
import hub.sam.dbl.Mul
import hub.sam.dbl.Div
import hub.sam.dbl.Mod
import hub.sam.dbl.BinaryOperator
import hub.sam.dbl.IntLiteral
import hub.sam.dbl.TrueLiteral
import hub.sam.dbl.FalseLiteral
import hub.sam.dbl.DoubleLiteral
import hub.sam.dbl.NullLiteral
import hub.sam.dbl.TypeAccess
import hub.sam.dbl.VariableAccess
import hub.sam.dbl.StringLiteral
import hub.sam.dbl.Cast
import hub.sam.dbl.Not
import hub.sam.dbl.Neg
import hub.sam.dbl.CreateObject
import hub.sam.dbl.PredefinedId
import hub.sam.dbl.MeLiteral
import hub.sam.dbl.SuperLiteral
import hub.sam.dbl.SizeOfArray
import hub.sam.dbl.NamedElement
import hub.sam.dbl.InstanceOf
import hub.sam.dbl.Yield
import hub.sam.dbl.Wait
import hub.sam.dbl.ActivateObject
import hub.sam.dbl.Reactivate
import hub.sam.dbl.Advance
import hub.sam.dbl.TimeLiteral
import hub.sam.dbl.ActiveLiteral
import hub.sam.dbl.Parameter
import hub.sam.dbl.Function
import hub.sam.dbl.FunctionCall
import hub.sam.dbl.SetExpansionContextStatement
import hub.sam.dbl.ExpansionStatement
import hub.sam.dbl.ExpansionPart
import hub.sam.dbl.ExpandTextPart
import hub.sam.dbl.ExpandVariablePart
import hub.sam.dbl.Constructor
import hub.sam.dmx.semantics.AbstractGenerator
import hub.sam.dbl.SuperClassSpecification
import org.eclipse.emf.common.util.EList

class ExtendedDblToCGenerator extends BasicDblToCGenerator{
	
	new(IPath outputFolder) {
		super(outputFolder);
	}
	
	override String getSimLibName() {
		'labelsAsValues'
	}
	
	override String genHeaderActiveClass(Class clazz, boolean header) {
		val it = clazz
		'''
		#ifndef «name.toUpperCase() + "_H"»
		#define «name.toUpperCase() + "_H"»
		#include "GotoExecution.h"	
			
		«genPlaceholder»
		
		class «name» 
		«IF superClasses.size >= 1»:
			«FOR SuperClassSpecification: superClasses SEPARATOR ','» public «SuperClassSpecification.class_.genType»
			«ENDFOR»
		«ELSE»: 
			«IF objectCreated»public Object,
			«ENDIF» 
			public GotoExecution
		«ENDIF»
		{
			public:
			«IF superClasses.size >= 1»typedef «(superClasses.findFirst[clazz.name != ""]).class_.name» super; 
			«ENDIF»
			«genContentClass(header)»
		};
		#endif
		'''
	}
	
	override String genActiveClass(Class clazz, boolean header) {
		val it = clazz	
		'''	
		«genPlaceholder»
		#include "GotoExecution.h"
		#include "Scheduler.h"
		«genContentClass(header)»
		'''
	}
	
	override String genMainFunctionActive(Function p, List<Module> modules){
		val it = p
		var String beginningMain = genSchedulerAndActionsMain
		isActive = true;
		'''	
			«beginningMain»
			«modules.genActionsPartActiveClasses»
			«genProceduresContainingSched»
			program_end:;
			}
			
			int main()
			{
			float elapsed;
			clock_t start = clock();
			simulate();	
			elapsed = (float)(clock() - start) / CLOCKS_PER_SEC;
			std::cout << "Overall execution time: " << elapsed << " sec." << std::endl;
			
			return 0;
			}
		'''
	}
	
	private def String genSchedulerAndActionsMain(Function p){
		val it = p;
		return 
		'''
		void simulate(){
			Scheduler* sched = Scheduler::getSingleInstance();
			cx = new GotoExecution(0, &&main_actions);
			cx->setScheduledTime(0);
			main_actions:;
			«statements.genStatements»
			goto program_end;
		'''
	}
	
	private def String genActionsPartActiveClasses(List <Module> modules) {
		return '''
		«FOR m:modules»
			«FOR c: m.classes»
				«IF (c as Class) != null && (c as Class).active»
					«c.name»:;
					«IF (c as Class).actionsBlock != null»
						// create some mem for variables on stack
						«IF (c as Class).actionsBlock.statements.exists[statement| statement instanceof Variable]»
							cx->push(nullptr, «(c as Class).name.toUpperCase()»_variables_size);
						«ENDIF»
						«(c as Class).actionsBlock.statements.genStatements()»
						TERMINATE;
					«ELSE»;
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		'''
	}
	
	private def String genProceduresContainingSched(){
		return '''
		«FOR procedure:all_Functions_containing_sched»
				«procedure.name.toUpperCase»:;
				«procedure.statements.genStatements»
				RETURN(«(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size);
		«ENDFOR»
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
		genYieldWaitAdvance(stm)
	}
	
	def dispatch String genSimStatement(Wait stm) {
		genYieldWaitAdvance(stm)
	}
	
	def dispatch String genSimStatement(ActivateObject stm) {
		'''sched->activate(«stm.objectAccess.genExpr»);'''
	}
	
	def dispatch String genSimStatement(Reactivate stm) {
		'''sched->reactivate(«stm.objectAccess.genExpr»);'''
	}
	
	def dispatch String genSimStatement(Advance stm) {
		genYieldWaitAdvance(stm)
	}

	def dispatch String genSimExpr(Expression expr) {
	
	}

	def dispatch String genSimExpr(TimeLiteral stm) {
		'''	sched->modelTime'''
	}
	
	def dispatch String genSimExpr(ActiveLiteral stm) {
		var boolean isActiveClass = false;
		var Class activeClass = getActiveClass(stm.eContainer)
		
		if (activeClass != null) isActiveClass = true
		
		'''«IF isActiveClass»static_cast<«activeClass.name»*> (cx)«ELSE»cx«ENDIF»'''
	}
	
	private def String genYieldWaitAdvance(Statement stm) {
		var boolean isActiveClass = false;
		var Class activeClass = getActiveClass(stm.eContainer)
		
		if (activeClass != null) isActiveClass = true
		checkAndAddFunctionIfContainingSchedOperation(stm.eContainer, isActiveClass)
		
		id++
		'''
		cx->cont = &&«IF !isActiveClass»Main«ELSE»«activeClass.name»«ENDIF»_l«id»;
		«IF stm instanceof Yield» YIELD 
		«ELSEIF stm instanceof Wait» WAIT 
		«ELSE» ADVANCE(«(stm as Advance).time.genExpr»)
		«ENDIF»;
		«IF !isActiveClass»Main«ELSE»«activeClass.name»«ENDIF»_l«id»:;
		'''
	}
	
	private def void checkAndAddFunctionIfContainingSchedOperation(EObject obj, boolean isActiveClass) {
		var EObject object = obj
		while (!(object instanceof Module || object instanceof Class || object instanceof Function)){
			object = object.eContainer;
		}
		if (obj instanceof Function && isActiveClass){
			if(!all_Functions_containing_sched.contains((object as Function))) all_Functions_containing_sched.add((object as Function));
		}
	}
}
// base c++ generator, imports are not considered (just for the specified the model)
class BasicDblToCGenerator extends AbstractGenerator {
	protected static final Logger logger = Logger.getLogger(BasicDblToCGenerator.getName());
	// for creating folder structure
	protected val cPackagePrefix = "hub.sam.dmx.csim.gen"
	protected val cPackageFolderPrefix = cPackagePrefix.replaceAll("\\.", "/")
	protected var IPath cPackageFolder;
	/* to separate between header and implementation files */ 
	protected val boolean header = true;
	/* isActive is used for special handling for simulation ( for example using macros instead of used variable names) */ 
	protected var isActive = false;
	/* listWrapper and objectCreated are boolean flags for listWrapper and object class integration*/ 
	protected var boolean listWrapperCreated = false;
	protected var boolean objectCreated = false;
	/*id for label generation */
	protected static var id = 0;
	// help ArrayLists for determining properties of the metamodell 
	protected val List<String> allClassesInWorkspace = newArrayList();
	protected val List<String> allModulesInWorkspace = newArrayList();
	protected val List<String> otherCLibs = newArrayList("cout", "instanceof", "string");
	protected var List<String> allPlaceholders; 
	protected var List<String> allImportedClassesNames = newArrayList(); 
	protected var List<Class> allImportedClasses = newArrayList(); 
	protected var List<String> allPointerToObjects = newArrayList();
	protected var List<String> allActiveClasses = newArrayList();
	protected var List<Variable> all_Var_main_actions = newArrayList();
	protected var List<Variable> all_Var_f = newArrayList();
	/* all_Functions_containing_sched contains all function EObjects that contain transitive sched-operations */
	protected var List<Function> all_Functions_containing_sched = newArrayList();
	/* all_Macros contains names of variables and parameter that are saved in call stack for processes*/   
	protected var List<String> all_Macros = newArrayList();
	/* allCppFiles list of class names that is returned and used by the compiler*/ 
	public var List<String> allCppFiles = newArrayList();
	/* if scheduler_var = false, scheduler will iterate over one map which is sorted by priority
	*  and time, otherwise scheduler will own two maps, one is sorted by priority(moving map) and the
	* other one is sorted by time (future map)
	*/
	protected var boolean scheduler_var = false; 
	/* debug flag to display scheduler logs */ 
	protected var boolean debug = false;
	
	new(IPath outputFolder) {
		super(outputFolder);
		// creates a new folder
		cPackageFolder = outputFolder.append(cPackageFolderPrefix);
		makeFolder(cPackageFolder);
	}	
	
	def String getSimLibName() {
		// not needed yet
	}
	
	def String getLanguageName() {
		'c++'
	}

	def void genModel(Model model, boolean mainModel){
		// if there are active classes, additional c++ classes needed
		val moduleWithActiveClasses = model.modules.filter[classes != null].filter[classes.findFirstActiveClass()].empty
			if (!moduleWithActiveClasses) {
				model.modules.forEach[ module | module.classes.forEach[ class_ |
				if(class_.active) allActiveClasses.add(class_.name)
				]]
				createAdditionalClasses()
				allCppFiles.add("Execution.cpp") 
				allCppFiles.add("GotoExecution.cpp")
				allCppFiles.add("Scheduler.cpp") 
				allCppFiles.add("TimeRedBlackTree.cpp") 
				allCppFiles.add("EventNode.cpp")  
				allCppFiles.add("EventNodeCompareTimeAndPriority.cpp") 
				if(scheduler_var){
					allCppFiles.add("EventNodeComparePriority.cpp") 	
				}	
			}
		
		if(mainModel){
			model.modules.forEach[ module | module.classes.forEach[ class_ |
				allClassesInWorkspace.add(class_.name)
			]]
			model.modules.forEach[module | allModulesInWorkspace.add(module.name)]
		}
		model.imports.forEach[import | if(import.model != null) import.model.modules.forEach[module | module.classes.forEach
		[class_ | if (class_.bindings != null && (class_.bindings.findFirst[binding | binding.targetLanguage == "c++"] != null)){
				class_.bindings.forEach[binding | 
					// import handling plus include of wrapper classes and add Files for compiler
					if (binding.targetType == "ListWrapper"){
						createListWrapper();
						createObjectClass();
					}
					else if (binding.targetType == "Object"){
						createObjectClass();
					}
				]
				allImportedClassesNames.add(class_.name);
				allImportedClasses.add(class_);
			}
		]]]
				
		val ModulsWithMains = model.modules.filter[functions.exists[name == 'main']]
		if (ModulsWithMains.size > 1) logger.info("more than one main-procedure, aborting translation")
		else{ 
		allPlaceholders = newArrayList(allClassesInWorkspace+allModulesInWorkspace+otherCLibs+allImportedClassesNames);
		val Module moduleWithMainFunction = if (mainModel) model.modules.findFirst[ functions.exists[ name == 'main' ] ] else null
		// fuer jedes Modul wird Datei angelegt
		model.modules.forEach[ module | 
		
			if(!(module.variables.size == 0 && module.functions.size == 1 && module.functions.exists[name == 'main'])){
				// generate header files for modules
				if (module.variables.size > 0 || module.functions.size > 0)
				{ 
					val Writer moduleHeaderWriter = beginTargetFile(cPackageFolder, module.name + ".h");
					moduleHeaderWriter.write(
						dynamicInclude(module.gen(header), header,null,model.modules)
					)
					endTargetFile(moduleHeaderWriter)
				
					val Writer moduleCPPWriter = beginTargetFile(cPackageFolder, module.name + ".cpp");
					allCppFiles.add(module.name+".cpp")
					moduleCPPWriter.write(
						dynamicInclude(module.gen(!header), !header,null,model.modules)
					)
					endTargetFile(moduleCPPWriter)				
				}
			}
			
			// generate header files for classes
			module.classes.forEach[ class_ |
				if(class_.gen(header) != null && class_.gen(header) != ""){
					val Writer classifierHeaderWriter = beginTargetFile(cPackageFolder, class_.name + ".h");
					classifierHeaderWriter.write(
						dynamicInclude(class_.gen(header), header,class_ , model.modules)
					)
					endTargetFile(classifierHeaderWriter)
				}
				if(class_.gen(!header) != null && class_.gen(!header) != ""){	
					allCppFiles.add(class_.name+".cpp")
					val Writer classifierCppWriter = beginTargetFile(cPackageFolder, class_.name + ".cpp");
					classifierCppWriter.write(
						dynamicInclude(class_.gen(!header), !header, class_, model.modules)
					)
					endTargetFile(classifierCppWriter)
				}
			]
		]
		// generates main.cpp
		if (mainModel && moduleWithMainFunction != null) {
			// main Java class with main function
			val Writer cMain = beginTargetFile(cPackageFolder, "Main.cpp");
			val prodecureMain = (model.modules.findFirst[functions.exists[name == 'main']]).functions.findFirst[name == 'main'];

			cMain.write(
				'''
				«IF (!moduleWithActiveClasses)»
				#define STACK_SIZE 32*1024
				#include "Log.h"
				#include "GotoExecution.h"
				GotoExecution* cx;
				#include "Scheduler.h"
				#include "Frame.h"
				
				#define YIELD   log("YIELD"); \
				cx = (GotoExecution*) sched->yield(); \
				goto *(cx->cont);

				#define WAIT    log("WAIT"); \
				cx = (GotoExecution*) sched->wait(); \
				goto *(cx->cont);

				#define ADVANCE(t)	log("ADVANCE " << t); \
				cx = (GotoExecution*) sched->advance(t); \
				goto *(cx->cont);

				#define TERMINATE   log("TERMINATE"); \
				cx = (GotoExecution*) sched->terminate(); \
				goto *(cx->cont);

				#define RETURN(vsize)   cx->pop(vsize); \
				goto *( ((class Frame*)(cx->top))->returnPoint );

				// access to a return value if the last function call returned an int value
				#define LRV_INT  (cx->lrv.iv)
				
				// access to a return value if the last function call returned an double value
				#define LRV_DOUBLE  (cx->lrv.dv)
				
				// access to a return value if the last function call returned an bool value
				#define LRV_BOOL  (cx->lrv.bv)
				
				// access to a return value if the last function call returned any other value
				#define LRV_POINTER  (cx->lrv.pv)	
				
				#include <string>
				«macros_for_main_actionsParts(model)»
				«macros_for_functions()»
				
				«ENDIF»
				«FOR Module: model.modules»
					 «IF(!(Module.variables.size == 0 && Module.functions.size == 1 && Module.functions.exists[name == 'main']))» 
					 «IF (Module.variables.size > 0 || Module.functions.size > 0)»
					 	«Module.genIncludeStatement»
					 «ENDIF»	
					«ENDIF»
					«FOR Class: Module.classes»
						«Class.genIncludeStatement»
					«ENDFOR»
				«ENDFOR»
				// import header files standard library
				#include <iostream>
				#include <ctime>
				«IF listWrapperCreated» 
				#include "ListWrapper.h"
				#include "Object.h"
				«ELSEIF objectCreated»
				#include "Object.h"
				«ENDIF»		
				«IF (moduleWithActiveClasses)»«prodecureMain.genMainFunction»«ELSE»«prodecureMain.genMainFunctionActive(model.modules)»«ENDIF»
				'''			
			);
			endTargetFile(cMain);
		}
		} 
	}
	
	def boolean findFirstActiveClass(Iterable<Class> classes) {
		for (c : classes) {
			if (c.active == true) return true	
		}
		return false;
	}
		//currently only for main procedure
	def dispatch String genIncludeStatement(Module module) {
		'''
		#include «module.cNameQualified»
		'''
	}
	//currently only for main procedure
	def dispatch String genIncludeStatement(Class clazz) {
		val it = clazz
		if (bindings.empty) {
			'''
			#include «clazz.cNameQualified»
			'''
		}
	}
	
	def dispatch String cNameQualified(Module module){
		"\"" +module.name+ ".h\""
	}
	
	def dispatch String cNameQualified(Class clazz){
		val it = clazz
	
		if (bindings.empty) {
	 		"\"" +clazz.name+ ".h\"" 	
	 	}
	}
	
	def dispatch String cNameQualified(NamedElement element) {
		element.name
	}
	
	def String macros_for_functions() {
		// precalculation to mark every variable declaration
		isActive = true;
		for(p:all_Functions_containing_sched){
			p.genFunction(!header);
		}
		isActive = false;
		
		for(procedure:all_Functions_containing_sched){
			for(p:procedure.parameters){
				if (!(all_Macros.contains(p.name))) all_Macros.add(p.name)
			}
			for(v:all_Var_f){
				if (!(all_Macros.contains(v.name))) all_Macros.add(v.name)
			}
		}
					
		'''
		//variable size for all variables and parameters in all methods in all active classes 
		«FOR procedure:all_Functions_containing_sched»
			«FOR p:procedure.parameters»
				#define PARAMETER_«(p.eContainer.eContainer as Class).name.toUpperCase()»_«(p.eContainer as Function).name.toUpperCase()»_«p.name.toUpperCase()»_size sizeof(«p.genType»«IF p.primitiveType == null»«ENDIF»)
			«ENDFOR»
			«FOR s: all_Var_f»
				«IF s.getFunctionName == procedure.name»
					#define VARIABLE_«getClassName(s).toUpperCase()»_«getFunctionName(s).toUpperCase()»_«(s as Variable).name.toUpperCase()»_size sizeof(«(s as Variable).genType»«IF (s as Variable).primitiveType == null»«ENDIF»)
				«ENDIF»
			«ENDFOR»
			
		«ENDFOR»
		//sum of variable size for all variables in methods of all active classes
		«FOR procedure:all_Functions_containing_sched»
			«IF procedure.parameters.size != 0»
				#define «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size («calculateSizeFunction(procedure)»
			«ELSE»
				#define «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size 0
			«ENDIF»
		«ENDFOR»
		//macro for the access to the variables in all methods of all active classes
		«FOR procedure:all_Functions_containing_sched»
			«FOR p:procedure.parameters»
				#define «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_«p.name.toUpperCase()» (* reinterpret_cast<«p.genType»*>(cx->top - «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size «calculatePlaceFunction(procedure,p,true)»))	
				#define «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_«p.name.toUpperCase()»_PASSOVER «IF calculatePlaceFunction(procedure,p,false) != ""» «calculatePlaceFunction(procedure,p,false)»«ELSE» 0 «ENDIF»				
			«ENDFOR»
			
			«FOR s: all_Var_f»
				«IF s.getFunctionName == procedure.name»
					#define «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_«(s as Variable).name.toUpperCase()» (* reinterpret_cast<«(s as Variable).genType»*>(cx->top - «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size «calculatePlaceFunction(procedure,s,true)»))
					#define «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_«(s as Variable).name.toUpperCase()»_PASSOVER «IF calculatePlaceFunction(procedure,s,false) != ""» «calculatePlaceFunction(procedure,s,false)» «ELSE» 0 «ENDIF»
				«ENDIF»
				
			«ENDFOR»
			
		«ENDFOR»
		'''
	}
	// TODO: there are already existing helper functions
	def String getFunctionName(EObject variable) {
		var object = variable.eContainer;
		
		while (!(object instanceof Module || object instanceof Class || object instanceof Function)){
			object = object.eContainer;
		}
		if(object instanceof Function) return ((object as Function).name)
	}
	// TODO: there are already existing helper functions
	def String getClassName(EObject s) {
		var object = s.eContainer;
		
		while (!(object instanceof Module || object instanceof Class)){
			object = object.eContainer;
		}
		if(object instanceof Class) return ((object as Class).name)
	}
	
	def String calculatePlaceFunction(Function procedure, EObject variableOrParameter, boolean state2) {
		var String result = ""
		var boolean state = false;
		var boolean initial = true;
		
		if(variableOrParameter instanceof Parameter){
			for (p:procedure.parameters){
				if(!state){
					if(p == variableOrParameter as Parameter){
						state = true;
					}	
					else{
						result = result + ''' «IF state2 || !initial»+«ENDIF» PARAMETER_«(p.eContainer.eContainer as Class).name.toUpperCase()»_«(p.eContainer as Function).name.toUpperCase()»_«p.name.toUpperCase()»_size'''
						initial = false; 
					}
				}
			}
		}
		else{
			for (p:procedure.parameters){
				result = result + '''«IF state2 || !initial»+«ENDIF» PARAMETER_«p.getClassName.toUpperCase()»_«p.getFunctionName.toUpperCase()»_«p.name.toUpperCase()»_size'''
				initial = false;
			}
			for (s: all_Var_f){
				if (s.getFunctionName == procedure.name && !state){
						if(variableOrParameter as Variable == s){
							state = true;
						}
						else{
							result = result + ''' + VARIABLE_«s.getClassName.toUpperCase()»_«s.getFunctionName.toUpperCase()»_«(s as Variable).name.toUpperCase()»_size'''
						}
				} 
			}
		}
		return result;
	}
	
	def String macros_for_main_actionsParts(Model modell) {
		//to find all declarations in the mainPart of active classes
		isActive = true
		for (m: modell.modules){
			for(c:m.classes){
				if((c as Class).active){
					if((c as Class).actionsBlock!=null)
						((c as Class).actionsBlock).statements.genStatements
				}
			}
		}
		isActive = false;		
					
		for(v: all_Var_main_actions){
			if (!(all_Macros.contains(v.name))) all_Macros.add(v.name)
		}	
		'''		
		//variable size for all variables in action parts of all active classes 		
		«FOR m: modell.modules»
			«FOR c:m.classes»
				«IF (c as Class).active»
					«FOR v: all_Var_main_actions»
						«IF	v.getClassName == (c as Class).name»
							#define «(c as Class).name.toUpperCase()»_«v.name.toUpperCase()»_size sizeof(«v.genType»«IF v.primitiveType == null»«ENDIF»)
						«ENDIF»
					«ENDFOR»
					
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		//sum of variable size for all variables in action parts of all active classes 
		«FOR m: modell.modules»
			«FOR c:m.classes»
				«IF (c as Class).active»
					«IF (c as Class).actionsBlock!= null»
						«IF (c as Class).actionsBlock.statements.exists[statement| statement instanceof Variable]»
							#define «(c as Class).name.toUpperCase()»_variables_size («calculateSize(c as Class)»
						«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		//macro for the access to the variables in actions parts of all active classes
		«FOR m: modell.modules»
			«FOR c:m.classes»
				«IF (c as Class).active»
					«FOR v: all_Var_main_actions»
						«IF	v.getClassName == (c as Class).name»
							#define «(c as Class).name.toUpperCase()»_«v.name.toUpperCase()» (* reinterpret_cast<«IF v.genType == "string"»string*>«ELSE»«v.genType»*>«ENDIF»(cx->top - «(c as Class).name.toUpperCase()»_variables_size «calculatePlace(v,(c as Class),true)»))
							#define «(c as Class).name.toUpperCase()»_«v.name.toUpperCase()»_PASSOVER «IF calculatePlace(v,(c as Class),false) != ""» «calculatePlace(v,(c as Class),false)» «ELSE» 0 «ENDIF»
						«ENDIF»
					«ENDFOR»
					
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
		'''
	}
	
	def String calculateSizeFunction(Function p) {
		val it = p
		var int temp = -1;
		
		for (s: all_Var_f)
			if (s.getFunctionName == p.name)
				temp = all_Var_f.indexOf(s);
		'''
			«IF parameters != null»
				«FOR param:parameters SEPARATOR "+"»
					PARAMETER_«param.getClassName.toUpperCase()»_«param.getFunctionName.toUpperCase()»_«param.name.toUpperCase()»_size«ENDFOR»«ENDIF»«IF parameters != null && temp!=-1»+«FOR s:all_Var_f»«IF s.getFunctionName == p.name»VARIABLE_«s.getClassName.toUpperCase()»_«s.getFunctionName.toUpperCase()»_«(s as Variable).name.toUpperCase()»_size«IF all_Var_f.indexOf(s) < temp»+«ELSE»«ENDIF»«ENDIF»«ENDFOR»«ENDIF»)
		'''
	}
	
	def String calculateSize(Class actionsClass) {
		var int temp = 0;
		for (s: all_Var_main_actions)
			if (s.getClassName == actionsClass.name)
				temp = all_Var_main_actions.indexOf(s);
		'''
			«FOR action:all_Var_main_actions»«IF action.getClassName == actionsClass.name» «actionsClass.name.toUpperCase()»_«action.name.toUpperCase()»_size «IF all_Var_main_actions.indexOf(action) < temp»+«ELSE»«ENDIF»«ENDIF»«ENDFOR»)
		'''
	}
	
	def String calculatePlace(Variable s, Class actionsClass, boolean state2) {
		var String result = ""
		var boolean state = false;
		var boolean initial = true;
		
		for (t: all_Var_main_actions){
			if (t.getClassName == actionsClass.name && !state){
				if(t == s){
					state = true;
				}
				else{
					result = result + ''' «IF state2 || !initial»+«ENDIF» «actionsClass.name.toUpperCase()»_«t.name.toUpperCase()»_size'''
					initial = false;
				}
			} 
		}
		return result;
	}

	def String dynamicInclude(String result, boolean header, Class clazz, List<Module> modules){
		var replacedString = result
		if(clazz == null && header || ((clazz != null) && !header) ){			
			for(name:allClassesInWorkspace){
				replacedString = replacePlaceholder(replacedString,name,name,false);
			}
		}
		
		if(header){
			replacedString = replacePlaceholder(result,"string","string",true);
			replacedString = genIncludeImportClasses(replacedString)
			if(clazz != null) replacedString = genForwardDecl(replacedString,clazz)
		}
		else{
			replacedString = replacePlaceholder(replacedString,"typeid","typeinfo",true);
			replacedString = replacePlaceholder(replacedString,"cout","iostream",true);		
			if(clazz != null) replacedString = genIncludeModuleClasses(replacedString, modules);
		}
		replacedString = replacePlaceholder(replacedString,"placeholder","",false);
		return replacedString
	}
	
	def genForwardDecl(String clazzContentString, Class clazz) {
		var temp = clazzContentString
		for(name:allClassesInWorkspace){
			if(name != clazz.name){
				if (temp.contains(name)) {
					temp = temp.replaceFirst("placeholder", "class "+name+";")
				}
			}
		}	
		return temp;
	}
	
	def genIncludeModuleClasses(String clazzContentString, List<Module> modules) {
		var temp = clazzContentString
		for(module:modules){
			val List<String> procedureAndVariablesNamesOfModule = newArrayList()
				module.functions.forEach[procedureAndVariablesNamesOfModule.add(name)]
				module.variables.forEach[procedureAndVariablesNamesOfModule.add(name)]
				if(procedureAndVariablesNamesOfModule.exists [s | clazzContentString.contains(s)])
					 temp = temp.replaceFirst("placeholder", "#include \""+module.name+".h\"")
		}
		return temp;
	}
	
	def genIncludeImportClasses(String clazzContentString) {
		var temp = clazzContentString
		for(c:allImportedClasses){
			for(b:c.bindings){
				if(b.targetLanguage == "c++"){
					temp = replacePlaceholder(temp,c.name,b.targetType,false);
				}
			}
		}
		return temp;	
	}
	
	def String replacePlaceholder(String clazzContentString, String searchString, String replaceString, boolean isStandard) {
		var temp = clazzContentString
		if(searchString == "placeholder") temp = temp.replaceAll("placeholder", "")
		else{
			if(clazzContentString.contains(searchString)){
				if(isStandard) temp = temp.replaceFirst("placeholder", '''#include <«replaceString»>''')
				else temp = temp.replaceFirst("placeholder", '''#include "«replaceString».h"''')
			}
		}
		return temp;
	}
	
	def String genPlaceholder(){
		return '''
		«IF allPlaceholders != null»
			«FOR p : allPlaceholders»
				placeholder
			«ENDFOR»
		«ENDIF»
		'''
	}
	
	def String gen(Class clazz, boolean header) {
		val it = clazz
		if (header){
			if (clazz.bindings.empty) {
				if (clazz.active) {
					/* precalculation to mark functions containing sched-operations*/
					methods.genFunctions(!header,false)
					genHeaderActiveClass(header)
				}
				else genHeaderPassiveClass(header)
			}
		}
		else{
			if (clazz.bindings.empty) {
				if (clazz.active) genActiveClass(header)
				else genPassiveClass(header)
			}
		}
	}
	
	def String genHeaderActiveClass(Class clazz, boolean header) {
		// no active classes in basegenerator
	}
	
	def String genActiveClass(Class clazz, boolean header) {
		// no active classes in basic generator
	}
	
	def String genHeaderPassiveClass(Class clazz, boolean header) {
		val it = clazz
		'''
		#ifndef «name.toUpperCase() + "_H"»
		#define «name.toUpperCase() + "_H"»
		
		«genPlaceholder»
		
		class «name» 
		«IF superClasses.size >= 1»:
			«FOR SuperClassSpecification: superClasses SEPARATOR ','» public «SuperClassSpecification.class_.genType»
			«ENDFOR»
		«ELSE»
			«IF objectCreated»: public Object
			«ENDIF»
		«ENDIF»
		{
		public:
			«IF superClasses.size >= 1»typedef «(superClasses.findFirst[clazz.name != ""]).class_.name» super; «ENDIF»
			«genContentClass(header)»
		};

		#endif
		'''
	}
	
	def String genPassiveClass(Class clazz, boolean header) {
		val it = clazz	
		'''
		«genPlaceholder»
		«genContentClass(header)»
		'''
	}
	
	def String genContentClass(Class clazz, boolean header){
		// Konstruktoren der Klasse
		val it = clazz
		'''
		// Konstruktoren der Klasse
		«IF constructors.size>0»
			«FOR constructor: constructors»
				«genConstructor(constructor, clazz, header)»
			«ENDFOR»
		«ELSE» 
			«genConstructor(null, clazz, header)»
		«ENDIF»
		«genAdditionalConstructors(clazz, header)»

		«IF methods.size != 0»
			// Funktionen der Klasse	
			«methods.genFunctions(header,false)»
		«ENDIF»	
		«IF attributes.size != 0»
			// Attribute der Klasse	
			«attributes.genVariables(header,false)»
		«ENDIF»	
		'''
	}
	
	def String gen(Module module, boolean header){
		val it = module
		'''
		«IF header»
		#ifndef «name.toUpperCase() + "_H"»
		#define «name.toUpperCase() + "_H"»
		«ELSE»
		#include "«name + ".h\""»
			«IF module.classes.exists[class_| class_.active]»
				#include "Scheduler.h"
				#include "GotoExecution.h"
				Scheduler* sched = Scheduler::getSingleInstance();
				extern GotoExecution* cx;
			«ENDIF»
		«ENDIF»
		«genPlaceholder»
		
		«IF variables.size != 0»
			// global variables
			«variables.genVariables(header,true)»
		«ENDIF»
		«IF functions.size != 0»
			// global functions
			«functions.genFunctions(header,true)»
		«ENDIF»
		«IF header»#endif«ENDIF»
		'''
	}
	
	def String genStatements(List <Statement> statements){
		'''
		«FOR stm : statements»«stm.genStatement»«ENDFOR»
		'''
	}
	// forward generation of other elements to more specific generators
	def String forwardGen(EObject eObj) {
		'<! unknown element ' + eObj.eClass.name ' !>'
	}
	
	def dispatch String genStatement(Statement stm) {
		//'<! unsupported statement ' + stm.eClass.name + ' !>'
		stm.forwardGen
	}
	
	def dispatch String genStatement(FunctionCall call) {
		var boolean activeClassContainsProcedure = false;
		var boolean procedureCallContainsSched = false;
		var boolean functionCallInMain = (checkLocationOfVariable(call.eContainer) == 0);
		var Class activeClass = getActiveClass(call.eContainer);
		var Function procedureCaller = getFunction(call.eContainer);
		var Function procedureCall;
		var Class procedureCallerClass;
		

		
		if (activeClass != null){
			procedureCall = activeClass.methods.findFirst[name == call.callIdExpr.referencedElement.cNameQualified]		
			if(procedureCall != null){
				activeClassContainsProcedure = true;
				if (procedureCaller != null){
					// functionblock is generated, if scheduling-operation exists in function, it will be added to all_Functions_containing_sched
					// see generation of scheduling operations above
					genFunction(procedureCall, !header)
					// if procedureCall contains scheduling-operation, the procedure that contains the procedure call has to be flattened too
					if(all_Functions_containing_sched.contains(procedureCall)){
						procedureCallContainsSched = true;
						procedureCallerClass = procedureCaller.eContainer as Class
						if(!all_Functions_containing_sched.contains(procedureCaller)) all_Functions_containing_sched.add(procedureCaller);
					}
				}
			}
		}
			
		if(procedureCallContainsSched || activeClassContainsProcedure){
			id++;
			'''	
			cx->push(&&RETURN_«genMacroVariable(procedureCall)»_«id», «genMacroVariable(activeClass, procedureCall)»_variables_size);
			«FOR param:procedureCall.parameters»
				«IF functionCallInMain»«genMacroVariable(activeClass, procedureCall, param)»«ELSE»«genMacroVariable(procedureCallerClass, procedureCaller, param)»«ENDIF»=
				«IF ((call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)) instanceof IdExpr) && 
					(call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)) as IdExpr).referencedElement != null)»
					«IF all_Macros.contains((call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)) as IdExpr).referencedElement.name)»
						«IF functionCallInMain»
							(* reinterpret_cast<«param.genType»*>(cx->top - sizeof(class Frame) - «genMacroVariable(activeClass, procedureCall)»_variables_size - «genMacroVariable(procedureCall)»_variables_size + 
							(«genMacroVariable(procedureCall)»_«(call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)) as IdExpr).referencedElement.name.toUpperCase()»_PASSOVER)));
						«ELSE»
							(* reinterpret_cast<«param.genType»*>(cx->top - sizeof(class Frame) - «genMacroVariable(procedureCallerClass, procedureCall)»_variables_size - 
							«genMacroVariable(procedureCallerClass, procedureCaller)»_variables_size + 
							(«genMacroVariable(procedureCallerClass, procedureCaller)»_«(call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)) as IdExpr).referencedElement.name.toUpperCase()»_PASSOVER)));
						«ENDIF»
					«ELSE»
						«call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)).genExpr»;
					«ENDIF»
				«ELSE»
					«call.callIdExpr.callPart.callArguments.get(procedureCall.parameters.indexOf(param)).genExpr»;
				«ENDIF»
			«ENDFOR»
			goto «genMacroVariable(procedureCall)»;
			RETURN_«genMacroVariable(procedureCall)»_«id»:;
        	'''
		}
		else{
			'''«IF activeClassContainsProcedure && isActive»static_cast<«activeClass.name»*> (cx)->«ENDIF»«call.callIdExpr.genExpr»;'''
		}
	}
	// this method is necessary, cause IdExpr cannot be converted to FunctionCall object
	// if a procedure call is used as rvalue for example as initial value for a variable definition this method is used
	// optimizing of this method can be done, see method genStatement(FunctionCall) 
	def String genFunctionCallStatements(IdExpr initialValue) {
		var boolean contain = false;
		var boolean contain2 = false;
		var Class activeClass;
		var Function procedure;
		var Function procedureCaller;
		var object = initialValue.eContainer;
		var Module module;
		
		while (!(object instanceof Module)){
			object = object.eContainer;
		}
		module = object as Module;
		
		activeClass = module.classes.findFirst[class_ | class_.active && class_.methods.exists[name == initialValue.referencedElement.cNameQualified]] as Class
		if (activeClass != null) contain = true
		
		procedureCaller = activeClass.methods.findFirst[method | method.name == initialValue.referencedElement.cNameQualified] 
		
	 	object = initialValue.eContainer;
		while (!(object instanceof Module || object instanceof Class || object instanceof Function)){
			object = object.eContainer;
		}
		if (object instanceof Function && contain){
			// to mark functions that contain scheduling operations
			genFunction(procedureCaller, !header)
			if(all_Functions_containing_sched.contains(procedureCaller))
				if(!all_Functions_containing_sched.contains(object as Function)) all_Functions_containing_sched.add(object as Function);
		}
		
		for(p:all_Functions_containing_sched){
			if(p.name == initialValue.referencedElement.cNameQualified){
				contain2 = true;
				procedure = p;
			}
		}
 
		var boolean Mainf = false;
		var Function prev = null;
		object = initialValue.eContainer;
		while (!(object instanceof Module || object instanceof Class || object instanceof Function)){
			object = object.eContainer;
		}
		if(object instanceof Class) Mainf = true	
		if(object instanceof Function) prev = object as Function	
		id++;
			
		if(contain2){
			'''	
			cx->push(&&RETURN_«procedure.name.toUpperCase»_«id», «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size);
			«FOR param:procedure.parameters»
				«(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_«param.name.toUpperCase()» =
				«IF ((initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)) instanceof IdExpr) && (initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)) as IdExpr).referencedElement != null)»
					«IF all_Macros.contains((initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)) as IdExpr).referencedElement.name)»
						«IF Mainf»
							(* reinterpret_cast<«param.genType»*>(cx->top - sizeof(class Frame) - «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size - «(procedure.eContainer as Class).name.toUpperCase()»_variables_size + («(procedure.eContainer as Class).name.toUpperCase()»_«(initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)) as IdExpr).referencedElement.name.toUpperCase()»_PASSOVER)));
						«ELSE»
							(* reinterpret_cast<«param.genType»*>(cx->top - sizeof(class Frame) - «(procedure.eContainer as Class).name.toUpperCase()»_«procedure.name.toUpperCase()»_variables_size - «(procedure.eContainer as Class).name.toUpperCase()»_«prev.name.toUpperCase()»_variables_size + («(procedure.eContainer as Class).name.toUpperCase()»_«prev.name.toUpperCase()»_«(initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)) as IdExpr).referencedElement.name.toUpperCase()»_PASSOVER)));
						«ENDIF»
					«ELSE»
						«initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)).genExpr»;
					«ENDIF»
				«ELSE»
					«initialValue.callPart.callArguments.get(procedure.parameters.indexOf(param)).genExpr»;
				«ENDIF»
			«ENDFOR»
			goto «procedure.name.toUpperCase»;
			RETURN_«procedure.name.toUpperCase»_«id»:;
        	'''
		}
		else{
			'''«IF contain && isActive»static_cast<«activeClass.name»*> (cx)->«ENDIF»«initialValue.genExpr»;'''
		}
	}
	
	def dispatch String genStatement(Print print){
		'''std::cout <<«FOR expr : print.outputs SEPARATOR '<<'»«expr.genExpr»«ENDFOR»<< std::endl;'''
	}
	
	def dispatch String genStatement(IfStatement ifStm) {
		val it = ifStm
		'''
		if («condition.genExpr») «trueCase.genStatement»
		«IF falseCase != null»
		else «falseCase.genStatement»
		«ENDIF»
		'''
	}
	
	def dispatch String genStatement(LocalScopeStatement stm) {
		'''{«stm.statements.genStatements»«stm.statements.genDeleteStatements»}'''
	}
	
	def dispatch String genStatement(Assignment stm) {
		stm.genAssignment(true)
	}
	
	def String genAssignment(Assignment stm, boolean genSemicolon) {
		'''«stm.variable.genExpr» = «stm.value.genExpr»«IF genSemicolon»;«ENDIF»'''
	}
	
	def dispatch String genStatement(Return stm) {
		var Function procedureCaller = getFunction(stm.eContainer);
		
		if (procedureCaller != null){		
			if(all_Functions_containing_sched.contains(procedureCaller)) '''«genReturnType(procedureCaller.genType)» = «stm.value.genExpr»;'''
			else '''return «stm.value.genExpr»;'''
		}		
	}
	
	def String genReturnType(String t){
		'''
		«IF (t == "int")»
				LRV_INT 
			«ELSEIF (t == "bool")»
				LRV_BOOL 
			«ELSEIF (t == "double")»
				LRV_DOUBLE 
			«ELSE»
				LRV_POINTER 
		«ENDIF»	
		'''
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
				«c.body.genStatements»
			«ENDFOR»
			«IF defaultCase != null»
			default:
				«defaultCase.body.genStatements»
			«ENDIF»
		}
		'''
	}
	
	def dispatch String genStatement(ForStatement stm) {
		val it = stm
		'''
		for («statements.head.genStatement» «termination.genExpr»;«increment.genAssignment(false)»)
		«body.genStatement»
		'''
	}

	def dispatch String genStatement(WhileStatement stm) {
		val it = stm
		'''while («condition.genExpr»)
			«body.genStatement»
		'''
	}
	
	def dispatch String genStatement(SetExpansionContextStatement stm) {
		val it = stm
		'''setExpand(«context.genExpr», «addAfterContext»);'''
	}

	def dispatch String genStatement(ExpansionStatement stm) {
		val it = stm
		'''expand(
		«FOR part : parts SEPARATOR '+'»
			«part.genMappingPart»
		«ENDFOR»
		);'''
	}
	
	def dispatch String genMappingPart(ExpansionPart part) {
		'< unknown mapping part >'
	}

	def dispatch String genMappingPart(ExpandTextPart part) {
		quoteCString(part.text)
	}

	def dispatch String genMappingPart(ExpandVariablePart part) {
		part.expr.genExpr
	}

	def dispatch String genStatement(Variable variable) {
		val it = variable
		if(!isActive){
			'''	«genType»
				«IF classifierType != null»*«ENDIF» «name»
					«IF initialValue != null»{«initialValue.genExpr»}
					«ELSE» {«autoInitial»}
					«ENDIF»;
			'''
		}
		else{
			var Class activeClass = getActiveClass(variable.eContainer);
			var Function procedureCaller = getFunction(variable.eContainer);
			var Class clazz = (procedureCaller?.eContainer as Class)
			var boolean sameNamelikeParameter = false;
			if (getFunction(eContainer) != null) {
				if(variable.initialValue instanceof IdExpr)
						if ((getFunction(eContainer).parameters.findFirst[name == (variable.initialValue as IdExpr).referencedElement?.name]) != null)
							sameNamelikeParameter = true;
			}
			var boolean variableInClass = (checkLocationOfVariable(eContainer) == 0);
			var boolean variableIsClassType = (initialValue instanceof CreateObject || variable.primitiveType == null)
			var boolean isFunctionCall = (initialValue instanceof IdExpr && (initialValue as IdExpr).callPart != null)
		
			if (variableInClass){
				if(!all_Var_main_actions.contains(variable)) all_Var_main_actions.add(variable);
					if(isFunctionCall){
						'''
							«genFunctionCallStatements(initialValue as IdExpr)»
							«genMacroVariable(activeClass,variable)» = «genReturnType(getCalledFunction((initialValue as IdExpr)).genType)»;
						'''
					}
					else{
						'''«genMacroVariable(activeClass,variable)» «genMacroVariableAssignment(variableIsClassType)»'''
					}
			}	
			else{
				if(!all_Var_f.contains(variable)) all_Var_f.add(variable);
					if(all_Functions_containing_sched.contains(procedureCaller)){
						if(isFunctionCall){
						'''
							«genFunctionCallStatements(initialValue as IdExpr)»
							«genMacroVariable(clazz, procedureCaller, variable)» = «genReturnType(getCalledFunction((initialValue as IdExpr)).genType)»;
						'''
						}
						else if (!sameNamelikeParameter) {
							'''«genMacroVariable(clazz, procedureCaller, variable)» «genMacroVariableAssignment(variableIsClassType)»'''
						}
				}
			}
		}
	}
	
	def String genMacroVariableAssignment(Variable v, boolean isClass){
		val it = v
		'''
		«IF initialValue != null»
			= «IF isClass»*(«ENDIF» «initialValue.genExpr»
		«ELSE» = «autoInitial»
		«ENDIF»
		«IF isClass»)«ENDIF»;
		'''
	}
	
	def String genMacroVariable(Function f){
		return '''«f.name.toUpperCase()»'''
	}
	
	def String genMacroVariable(Class c, Variable v){
		return '''«c.name.toUpperCase()»_«v.name.toUpperCase()»'''
	}
	
	def String genMacroVariable(Class c, Function f){
		return '''«c.name.toUpperCase()»_«f.name.toUpperCase()»'''
	}
	
	def String genMacroVariable(Class c, Function f, Parameter p){
		return '''«c.name.toUpperCase()»_«p.name.toUpperCase()»'''
	}
	
	def String genMacroVariable(Class c, Function f, Variable v){
		return '''«c.name.toUpperCase()»_«f.name.toUpperCase()»_«v.name.toUpperCase()»'''
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
	
	def dispatch String genExpr(IntLiteral expr) {
		expr.value.toString
	}

	def dispatch String genExpr(InstanceOf expr) {
		'''typeid(«IF expr.op1 instanceof IdExpr»*«ENDIF»«expr.op1.genExpr») == typeid(«IF expr.op2 instanceof IdExpr»*«ENDIF»«expr.op2.genExpr»)'''
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
		'nullptr'
	}
	
	def String genBinaryExpr(BinaryOperator expr, String op) {
		"("+expr.op1.genExpr + op + expr.op2.genExpr+")"
	}
	
	def dispatch String genExpr(TypeAccess expr) {
		expr.idExpr.genClassifierTypeExpr
	}
	
	def dispatch String genExpr(VariableAccess expr) {
		expr.idExpr.genExpr
	}

	def dispatch String genExpr(StringLiteral expr) {
		quoteCString(expr.value)
	}
	
	def String quoteCString(String s){
		if (s.contains('\r\n')) '''"«s.replaceAll('\r\n', '\\\\r\\\\n"+\r\n"')»"'''
		else '''"«s.replaceAll('\n','\\\\r\\\\n"+\r\n"')»"'''
	}
	
	def dispatch String genExpr(Neg expr) {
		'''(-«expr.op.genExpr»)'''
	}
	
	def dispatch String genExpr(Not expr) {
		'''(!«expr.op.genExpr»)'''
	}
	
	def dispatch String genExpr(Cast expr) {
		'''static_cast<«expr.genType»*> («expr.op.genExpr»)'''
	}
	
	def dispatch String genExpr(CreateObject expr) {
		val it = expr
		var mappedString = genImportType(genType);
		if (mappedString == "") mappedString = genType
		val boolean isActive = allActiveClasses.contains(genType)
		'''
		new «mappedString»
			«IF classifierType != null && classifierType.arrayIndex.empty && typeArrayDimensions.empty»
			(
				«IF classifierType.callPart != null»
					«FOR arg : classifierType.callPart.callArguments SEPARATOR ','»
						«IF classifierType.callPart.callArguments.size >= 2 && arg == classifierType.callPart.callArguments.get(1) && isActive»&&«genType»«ELSE»«arg.genExpr»«ENDIF» 
					«ENDFOR»
				«ENDIF»
			)
			«ENDIF»
		'''
	}
	
	def dispatch String genExpr(IdExpr idExpr) {
		idExpr.genIdExpr
	}

	def String genIdExpr(IdExpr idExpr) {
		val it = idExpr
		var boolean isActiveClass = false;
		var boolean isVariableMain = false;
		var boolean isVariableFunction = false;
		var boolean isParameterFunction = false
		var Variable varMain
		var Variable varFunction
		var Function procedure;
		var Parameter parameter;
		var IdExpr refElement;
		var Class clazz;
		
		if(parentIdExpr != null) refElement = parentIdExpr
		else refElement = idExpr
		
		var Class activeClass = getActiveClass(refElement.eContainer)
		if (activeClass != null) isActiveClass = true
		
		if(checkLocationOfVariable(refElement.eContainer) == 0 && isActiveClass) {
			val IdExpr temp = refElement
			varMain = all_Var_main_actions.findFirst[variable| variable.name == temp.referencedElement.cNameQualified]
			if (varMain != null) isVariableMain = true
		}
		else if (checkLocationOfVariable(refElement.eContainer) == 1 && isActiveClass) {
			val IdExpr temp = refElement
			procedure = getFunction(idExpr.eContainer)
			clazz = (procedure.eContainer as Class)
			parameter = procedure.parameters.findFirst[param| param.name == temp.referencedElement.cNameQualified]
			if (parameter != null) isParameterFunction = true
			else{ 
				varFunction = all_Var_f.findFirst[variable| variable.name == temp.referencedElement.cNameQualified]
				if (varFunction != null) isVariableFunction = true
			}
		}
		'''
		«IF isActive»
			«IF (parentIdExpr != null)»
				«IF (parentIdExpr.predefinedId instanceof SuperLiteral)» 
					«parentIdExpr.genIdExpr»::
				«ELSEIF isParameterFunction || isVariableFunction || isVariableMain»
					«parentIdExpr.genIdExpr».
				«ELSE»
					«parentIdExpr.genIdExpr»->
				«ENDIF»
			«ENDIF»
			«IF (referencedElement != null)»
				«IF idExpr.parentIdExpr == null»
				 	«IF isParameterFunction» («genMacroVariable(clazz,procedure,parameter)»)
						«ELSEIF isVariableFunction» («genMacroVariable(clazz,procedure,varFunction)»)
						«ELSEIF isVariableMain» («genMacroVariable(activeClass,varMain)»)
						«ELSEIF idExpr.callPart != null» «idExpr.genIdExprPassive»
						«ELSEIF activeClass.attributes.findFirst[name == idExpr.referencedElement.cNameQualified] == null» «genIdExpr_for_ReferencedElement(referencedElement)»
					«ELSE» static_cast<«activeClass.name»*> (cx)->«idExpr.genIdExprPassive»
					«ENDIF»
				«ELSE»
					«genIdExpr_for_ReferencedElement(referencedElement)»
				«ENDIF»
			«ELSE»
				 «genIdExpr_for_PredefinedId(predefinedId)»
			«ENDIF»
		«ELSE» 
			«idExpr.genIdExprPassive»
		«ENDIF»
		'''
	}
	
	def String genIdExprPassive(IdExpr idExpr){
		val it = idExpr
		'''
		«IF parentIdExpr != null»
			«IF (parentIdExpr.predefinedId instanceof SuperLiteral)» 
				«parentIdExpr.genIdExpr»::
			«ELSE»
				«parentIdExpr.genIdExpr»->
			«ENDIF»
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
		'this'
	}
	
	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SuperLiteral predefinedId) {
		'super'
	}

	def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SizeOfArray predefinedId) {
		if (idExpr.callPart == null) 'length'
		else 'size()'
	}
	
	def String genIdExpr_for_ReferencedElement(IdExpr idExpr, NamedElement referencedElement) {
		'''
			«referencedElement.cNameQualified»
			«IF idExpr.callPart != null»(
				«FOR arg : idExpr.callPart.callArguments SEPARATOR ','»
					«arg.genExpr»
				«ENDFOR»)
			«ENDIF»
			«FOR index : idExpr.arrayIndex»
				[«index.genExpr»]
			«ENDFOR»
		'''
	}
	
	def genAdditionalConstructors(Class clazz, boolean isHeader) {
		val it = clazz
		if (isHeader)
		'''
			«name»(const «name»& a);
			«IF isInheritedBaseClass»virtual«ENDIF» ~«name»();
		'''
		else{
		'''
			«name»::«name»(const «name»& a) = default;
			«name»::~«name»() = default;
		'''}
	}	
	
	def String genConstructor (Constructor constructor, Class clazz, boolean isHeader){
		val it = clazz
		var boolean containsConstructorClassVariableAssignment;
		if(constructor != null) {
			containsConstructorClassVariableAssignment = constructor.statements.exists
		[ s | s instanceof Assignment && clazz.attributes.exists
			[name.trim() == (s as Assignment).variable.genExpr.trim() && constructor.parameters.exists
				[name.trim() == (s as Assignment).value.genExpr.trim()]
			]
		]}
		val boolean needsColon = (superClasses.size > 0 || containsConstructorClassVariableAssignment || active);
		val boolean needsComma = (containsConstructorClassVariableAssignment && ((superClasses.size > 0) || active) )
		 
		if (isHeader) {
			''' «name»(«genConstructorParameters(constructor, clazz)»);'''
		}
		else {
			''' «name»::«name»(«genConstructorParameters(constructor, clazz)»)
				«IF needsColon»:«ENDIF» «genBaseClassCalls(superClasses, clazz, constructor)»
				«IF needsComma»,«ENDIF»
				«IF containsConstructorClassVariableAssignment» «genInitializerList(constructor)»«ENDIF»
				«IF constructor != null»{
					«FOR s:constructor.statements»
						«IF !(s instanceof Assignment && clazz.attributes.exists
							[name.trim() == (s as Assignment).variable.genExpr.trim() && constructor.parameters.exists
							[name.trim() == (s as Assignment).value.genExpr.trim()]])»
							«s.genStatement»
						«ENDIF»
					«ENDFOR»
				}«ELSE» = default;
				«ENDIF»
			'''
		}
	}
	
	def String genBaseClassCalls(EList <SuperClassSpecification> superClasses, Class clazz, Constructor constructor){
		val it = clazz
		'''
			«FOR sc : superClasses SEPARATOR ','»
				«sc.class_.name»::«sc.class_.name»(
					«IF sc.constructorArguments != null»
						«FOR expr : sc.constructorArguments SEPARATOR ','»
							«expr.genExpr»
						«ENDFOR»
					«ENDIF»
				)
			«ENDFOR»
			«IF active && superClasses.size == 0» GotoExecution::GotoExecution(
				«IF constructor != null»«constructor.parameters.get(0).name»
				«ELSE» 1
				«ENDIF», label)
			«ENDIF»
		'''
	}
	
	def String genConstructorParameters(Constructor constructor, Class clazz){
		val it = clazz
		'''
		«IF constructor != null»
			«FOR cparam: constructor.parameters SEPARATOR ','»
				«IF constructor.parameters.size >= 2 && cparam == constructor.parameters.get(1) && active» void* label
				«ELSE» «cparam.genType»
					«IF((cparam as TypedElement).classifierType instanceof IdExpr)»*«ENDIF» 
				«cparam.name»
				«ENDIF»
			«ENDFOR»
		«ELSE»
			«IF active»int priority, void* label«ENDIF»
		«ENDIF»
		'''
	}
	
 	 def String genInitializerList(Class clazz, Constructor constructor){
		val it = clazz
		var int temp = 0;
		// get largest index for commata
		for(attribute: attributes){
			if(!attribute.isClass()){
				if (constructor.statements.exists[ s| s instanceof Assignment && (s as Assignment).variable.genExpr.trim() == attribute.name])
					temp = attributes.indexOf(attribute)
			}
		}
		
		'''
			«FOR attribute: attributes»
				«IF !attribute.isClass()»
					«IF constructor.statements.exists[ s| s instanceof Assignment && (s as Assignment).variable.genExpr.trim() == attribute.name]»
						«attribute.name»(
						«((constructor.statements.findFirst
							[ s| s instanceof Assignment && (s as Assignment).variable.genExpr.trim() == attribute.name]
						) as Assignment).value.genExpr»)
						«IF attributes.indexOf(attribute) < temp»,«ELSE»«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
	}
	
	def boolean isInheritedBaseClass(Class clazz) {
		var object = clazz.eContainer;
		var Model model;
		while (!(object instanceof Model)){
			object = object.eContainer;
		}
		model = (object) as Model;

		for(module:model.modules){
			for(class:module.classes){
				if (class.superClasses.findFirst[class_.name == clazz.name] != null) return true;	
			}
		}
		return false;
	}
	
	def String genVariables(List<Variable> variables, boolean isHeader, boolean isModule) {
		'''
		«FOR v : variables»
			«IF isHeader && isModule»extern «ENDIF»«v.genVariable(isHeader)»
		«ENDFOR»
		'''
	}
	
	def String genVariable(Variable variable, boolean isHeader) {
		val it = variable
		val ArrayOrVariable = '''
		«IF typeArrayDimensions.size != 0» «genArray(isHeader)»
		«ELSE» «genVariableDeclaration(isHeader)»	
		«ENDIF»
		'''
		if(isHeader){
			'''«ArrayOrVariable»'''
		}
		else{
			'''
				«ArrayOrVariable» { 
				«IF initialValue != null»
					«initialValue.genExpr»
				«ELSE»
					«autoInitial»
				«ENDIF»};
			'''
		}
	}
	
	def String genVariableDeclaration(Variable variable, boolean isHeader) {
		val it = variable;
		'''
			«IF isClass() && isHeader»static«ENDIF»
			«genType»
			«IF classifierType instanceof IdExpr»*«ENDIF»
			«IF isClass() && !isHeader»«(eContainer as Class).name»::«ENDIF»
			«name»
			«IF isHeader»;«ENDIF»
		'''	
	}
	
	def String autoInitial(Variable v){
		val it = v
		'''
		«IF (primitiveType != null)»
			«IF (primitiveType instanceof IntType)»0
			«ENDIF»
			«IF (primitiveType instanceof StringType)»""
			«ENDIF»
			«IF (primitiveType instanceof BoolType)»false
			«ENDIF»
			«IF (primitiveType instanceof DoubleType)»0.0
			«ENDIF»
		«ELSE»nullptr
		«ENDIF»
		'''
	}
	
	def String genArray(Variable variable, boolean isHeader) {
		val it = variable
		'''
			«genType»
			«IF classifierType instanceof IdExpr»* «ENDIF» 
			«name»
			«IF initialValue instanceof CreateObject»
				«FOR dim:typeArrayDimensions»[«dim.size.genExpr»]
				«ENDFOR»
				«IF isHeader»;«ENDIF»
			«ENDIF»
		'''
	}
	
	def String genFunctions(List<Function> functions, boolean isHeader, boolean isModule) {
		'''
		«FOR p : functions»
			«IF p.name != "main" && !all_Functions_containing_sched.contains(p)»
				«IF isHeader && isModule»extern«ENDIF» «p.genFunction(isHeader)»
			«ENDIF»
		«ENDFOR»
		'''
	}
	
	def String genFunction(Function p, boolean isHeader){
		val it = p
		'''
		«IF (abstract) && isHeader»virtual«ENDIF» 
		«IF (!abstract || isHeader)»«genType»
			«IF((p as TypedElement).classifierType instanceof IdExpr)»*«ENDIF» 
			«IF p.eContainer instanceof Class && !isHeader»«(p.eContainer as Class).name»::
			«ENDIF»«name»
			(
			«FOR parameter: p.parameters SEPARATOR ','»«parameter.genType»
				«IF((parameter as TypedElement).classifierType instanceof IdExpr)»*
				«ENDIF» «parameter.name»
			«ENDFOR»
			)
			«IF (abstract) && isHeader» = 0
			«ENDIF»
			«IF isHeader»;
			«ELSE»{«statements.genStatements»}
			«ENDIF»
		«ENDIF»
		'''	
	}
	
	def String genMainFunctionActive(Function p, List<Module> variables){
		// no active classes in basegenerator
	}
	
	def String genMainFunction(Function p){
		val it = p;
		'''
			int main()
			{
			float elapsed;
			clock_t start = clock();
			«statements.genStatements»
			«statements.genDeleteStatements»
			elapsed = (float)(clock() - start) / CLOCKS_PER_SEC;
			std::cout << "Overall execution time: " << elapsed << " sec." << std::endl;
			
			return 0;
			}
		'''
	}
	
	def String genDeleteStatements(List<Statement> s) {
		'''
			«FOR statement:s»
				«IF statement instanceof Variable»
					«IF (statement as Variable).initialValue instanceof CreateObject»
						delete «(statement as Variable).name»;
					«ELSEIF ((statement as Variable).initialValue instanceof IdExpr && ((statement as Variable).initialValue as IdExpr).callPart != null && all_Functions_containing_sched.contains(getCalledFunction((statement as Variable).initialValue as IdExpr)) && getCalledFunction(((statement as Variable).initialValue as IdExpr)).primitiveType == null) »
						delete «(statement as Variable).name»;
					«ENDIF»
				«ENDIF»
			«ENDFOR»
		'''
	}

	def dispatch String genType(LanguageConstructClassifier langClassifier) {
		var mappedString = genImportType(langClassifier.name);
		if (mappedString == "") langClassifier.name
		else mappedString
	}
	
	def String genImportType(String s){
		if (allImportedClassesNames.contains(s)){
				val mappedClass = allImportedClasses.findFirst[clazz|clazz.name == s]
				val binding = mappedClass.bindings.findFirst[targetLanguage == "c++"]
				if (binding != null) return binding.targetType
		}
		else return "";
	}
	
	def dispatch String genType(TypedElement typedElement) {
		val it = typedElement
		if (primitiveType != null) primitiveType.genType
		else classifierType.genClassifierTypeExpr
	}
	
	def String genClassifierTypeExpr(IdExpr typeExpr) {
		typeExpr.referencedElement.genType
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
		'std::string'
	}
	
	def dispatch String genType(BoolType type) {
		'bool'
	}
	
	def dispatch String genType(DoubleType type) {
		'double'
	}	
	// helper functions to get the corresponding object of active class
	private def Function getFunction(EObject anything){
		var object = anything
		while (!(object instanceof Module || object instanceof Class || object instanceof Function)){
			object = object.eContainer;
		}
		if(object instanceof Function) return (object as Function)
		else return null
	}
	
	def Class getActiveClass(EObject obj) {
		var EObject object = obj
		var Class activeClass;
		
		while (!(object instanceof Module || object instanceof Class)){
			object = object.eContainer;
		}
		if (object instanceof Class){
			    activeClass = (object) as Class;
				if(activeClass.active){
					return activeClass
				}
		}
		return null;
	}	
	
	private def int checkLocationOfVariable(EObject obj) {
		var EObject object = obj

		while (!(object instanceof Module || object instanceof Class || object instanceof Function)){
			object = object.eContainer;
		}
		if (object instanceof Class){
			return 0;
		}
		if (object instanceof Function){
			return 1;
		}
		else return 2;
	}	
	
	private def Function getCalledFunction(IdExpr nameOfFunction) {
		var Class activeClass;
		var Function procedure;
		var object = nameOfFunction.eContainer;
		var Module module;
		while (!(object instanceof Module)){
			object = object.eContainer;
		}
		module = object as Module;
		
		activeClass = module.classes.findFirst[class_ | class_.active && class_.methods.exists[name == nameOfFunction.referencedElement.cNameQualified]] as Class
		if (activeClass != null) {
			procedure = activeClass.methods.findFirst[method | method.name == nameOfFunction.referencedElement.cNameQualified] 
			return procedure;
		}	
		return null
	}
	// following strings are hardcoded
	def createListWrapper() {
		if(!listWrapperCreated){
		val Writer ListWrapper_H = beginTargetFile(cPackageFolder, "ListWrapper.h");
			ListWrapper_H.write(
				'''
				#ifndef LISTWRAPPER_H
				#define LISTWRAPPER_H
				
				#include <list>
				#include "Object.h"
				
				using namespace std;

				class ListWrapper {
				public:
				ListWrapper();
				ListWrapper(const ListWrapper& a);
				~ListWrapper();
				
				private:
				list<Object*> objectList; 
				list<Object*>::iterator it;
				
				// Methoden zur Listenmanipulation
				public:
				bool add(Object* e);
				bool add(int index, Object* e);
				void clear();
				bool contains(Object* e);
				int size();
				Object* get(int index);
				int indexOf(Object* e);
				bool isEmpty();
				bool remove(Object* e);
				Object* toArray();
				};

				#endif
				'''
			);
			endTargetFile(ListWrapper_H);
			
			val Writer ListWrapper_CPP = beginTargetFile(cPackageFolder, "ListWrapper.cpp");
			ListWrapper_CPP.write(
				'''
				#include "ListWrapper.h" 
				#include "Object.h"
				#include <iostream>
				using namespace std;

				// Konstruktoren der Klasse
				ListWrapper::ListWrapper() : objectList(),it(){}
				ListWrapper::ListWrapper(const ListWrapper& a) = default;
				ListWrapper::~ListWrapper() = default;
				
				bool ListWrapper::add(Object* e)
				{
					if(e != nullptr){
						try{
							objectList.push_back(e);
							return true;
						}
						catch (int e){
							cout << "An exception occurred. Exception Nr. " << e << '\n';
							return false;
						}
					}
					else return false;
				}
				
				bool ListWrapper::add(int index, Object* e)
				{
					if(e != nullptr){
						try{
							it = objectList.begin();
							advance(it,index);
							objectList.insert(it,e);
							return true;
						}
						catch (int e){
							cout << "An exception occurred. Exception Nr. " << e << '\n';
							return false;
						}
					}
					else return false;
				}
				
				void ListWrapper::clear(){
					objectList.clear();
				}
				
				bool ListWrapper::contains(Object* e)
				{
					if(e != nullptr){
						for(it = objectList.begin(); it != objectList.end(); it++)
						{
							if (*it == e) return true;	
						}
						return false;
					}
					else return false;
				}
				
				int ListWrapper::size()
				{
					return objectList.size();
				}
				
				Object* ListWrapper::get(int index)
				{
					if(index <= objectList.size()-1){
						it = objectList.begin();
						advance(it,index);
						return *it;
					}
					else 
					{
						return *objectList.end();
					}
				}
				
				int ListWrapper::indexOf(Object* e)
				{
					if(e != nullptr){
						for(it = objectList.begin(); it != objectList.end(); it++)
						{
							if (*it == e) 
							{
								return distance(objectList.begin(),it);
							}	
						}
						return -1;
					}
					else return -1;
				}
				
				bool ListWrapper::isEmpty()
				{
					return objectList.empty();
				}
				
				bool ListWrapper::remove(Object* e)
				{
					if(e != nullptr){
						for(it = objectList.begin(); it != objectList.end(); it++)
						{
							if (*it == e) 
							{
								objectList.erase (it);
								return true;
							}	
						}
						return false;
					}
					else return false;
				}
				
				Object* ListWrapper::toArray(){
					// arraySize must be defined before here 100 objects could be set
					Object* array [101];
					if (objectList.size() > 0 && objectList.size() <= 100){
						int temp = 0;
						for(it = objectList.begin(); it != objectList.end(); it++)
						{
							array[temp] = *it;
							temp++;
						}
						return array[0];
					}
					else return nullptr;
				}
				'''
			);
			endTargetFile(ListWrapper_CPP);
			allCppFiles.add("ListWrapper.cpp") 
			}
			listWrapperCreated=true;
	}
	
	def createObjectClass() {
		if(!objectCreated){
		val Writer OBJECT_H = beginTargetFile(cPackageFolder, "Object.h");
			OBJECT_H.write(
				'''
				#ifndef OBJECT_H
				#define OBJECT_H

				class Object {
				public:
				Object();
				Object(const Object& a);
				virtual ~Object();
				};
				#endif
				'''
			);
			endTargetFile(OBJECT_H);
			
			val Writer Object_CPP = beginTargetFile(cPackageFolder, "Object.cpp");
			Object_CPP.write(
				'''
				#include "Object.h"

				Object::Object() = default;
				Object::Object(const Object& a) = default;
				Object::~Object() = default;				
				'''
			);
			endTargetFile(Object_CPP);
			allCppFiles.add("Object.cpp") 
		}
		objectCreated = true;
	}
	
	def createAdditionalClasses() {
		val Writer goto_H = beginTargetFile(cPackageFolder, "GotoExecution.h");
			goto_H.write(
				'''
				#ifndef __Goto_H
				#define __Goto_H
				#ifndef STACK_SIZE
				#define STACK_SIZE 32*1024
				#endif
				#include "Execution.h"

				class GotoExecution : public Execution {
				public:
				void* cont; // continuation instruction

				char mem[STACK_SIZE];
				char* top;
				
				union lrv_union {
				int iv;
				double dv;
				bool bv;
				void* pv;
				} lrv;

				void push(void* returnPoint, int vsize);

				void pop(int vsize);

				GotoExecution(int priority, void* cont);

				virtual ~GotoExecution();
				};
				#endif
				'''
			)
			endTargetFile(goto_H);
			
			val Writer goto_CPP = beginTargetFile(cPackageFolder, "GotoExecution.cpp");
			goto_CPP.write(
				'''
				#include "log.h"
				#include "Execution.h"
				#include "GotoExecution.h"
				#include "Frame.h"

				void GotoExecution::push(void* returnPoint, int vsize) {
				log2("current top @ " << ((void*) top));
				((class Frame*)(top))->returnPoint = returnPoint;
				top = top + sizeof(class Frame) + vsize;
				log2("new top @ " << ((void*)top));
				log2("pushed stack frame");
				}

				void GotoExecution::pop(int vsize) {
				top = top - sizeof(class Frame) - vsize;
				log2("popped stack frame");
				}

				GotoExecution::GotoExecution(int priority, void* cont) : Execution(priority), cont(cont) {
				top = mem;
				log2("mem @ " << ((void*)mem) << " to " << ((void*)(mem + STACK_SIZE)) );
				log2("top @ " << ((void*)top));
				}

				GotoExecution::~GotoExecution() {
				cont = nullptr;
				// TODO release memory of stack in mem variable
				log2("pid-" << pid << ": freed resources.");
				}
				''');
			endTargetFile(goto_CPP);
			
			val Writer frame_H = beginTargetFile(cPackageFolder, "Frame.h");
			frame_H.write(
				'''
				#ifndef __frame_H
				#define __frame_H
				class Frame {
				public:
				void* returnPoint; // pointer to return label
				};
				#endif
				''');
			endTargetFile(frame_H);
					
		val Writer execution_H = beginTargetFile(cPackageFolder, "Execution.h");
			execution_H.write(
				'''
				#ifndef EXECUTION_H
				#define EXECUTION_H
				class Execution {
				private:
				static int nextPid;
				int priority;
				double scheduledTime;

				public:
				int pid;
				bool isWaiting;
				bool isInterrupted;
				Execution* prev; // previous execution if this execution is linked with other executions
				Execution* next; // next execution if this execution is linked with other executions
				Execution* last;

				Execution(int priority);
				virtual ~Execution();

				void setPriority(int newPriority);
				int getPriority() const;

				void setScheduledTime(double time);
				double getScheduledTime() const;

				void printDetails();
				};
				#endif
				''');
			endTargetFile(execution_H);

			val Writer execution_CPP = beginTargetFile(cPackageFolder, "Execution.cpp");
			execution_CPP.write(
				'''
				#include "Scheduler.h"
				#include "Execution.h"
				#include "Log.h"
				#include <iostream>
				class GotoExecution;
				extern GotoExecution* cx;
				
				int Execution::nextPid = 0;
				
				void Execution::printDetails() {
				std::cout << getScheduledTime() << "," << getPriority() << " (pid:" << pid << ")   ";
				}

				int Execution::getPriority() const {
				return priority;
				}

				void Execution::setScheduledTime(double time) {
				scheduledTime = time;
				}

				double Execution::getScheduledTime() const {
				return scheduledTime;
				}

				void Execution::setPriority(int newPriority) {
				priority = newPriority;

				// changing priority of another execution, requires removing it from the event list
				// (if it is in) and then adding it again.
				if (this != (Execution*)cx) {
					if (!isWaiting) {
						Scheduler::getSingleInstance()->eventSet.remove(this);
						Scheduler::getSingleInstance()->eventSet.insert(this);
					}
				}
				}

				Execution::Execution(int priority) : pid(nextPid++), priority(priority), scheduledTime(-1),
				isWaiting(false), isInterrupted(false), prev(nullptr),
				next(nullptr), last(this)
				{
				log2("created execution: pid = " << pid << ", priority = " << priority);
				if (Scheduler::isDebugOn()) {
				Scheduler::getSingleInstance()->debug_add(this);
				}
				}

				Execution::~Execution() {
				setScheduledTime(-1);
				}
				''');
			endTargetFile(execution_CPP);
			
			val Writer timeRedBlackTree_H = beginTargetFile(cPackageFolder, "TimeRedBlackTree.h");
			timeRedBlackTree_H.write(
				'''
				#ifndef TIME_RED_BLACK_TREE_H
				#define TIME_RED_BLACK_TREE_H
				
				#include "EventSet.h"
				#include "EventNode.h"
		
				// Variante1:
				#include "EventNodeCompareTimeAndPriority.h"
				«IF scheduler_var»
				// Variante2:
				//#include "EventNodeCompareTime.h"
				#include "EventNodeComparePriority.h"
				«ENDIF»
				#include <map>
				
				class TimeRedBlackTree : public EventSet {
				private:
				
				// Variante1: only one map, events sorted by priority and time
				std::map<EventNode, Execution*, EventNodeCompareTimeAndPriority> map;
				typedef std::map<EventNode, Execution*, EventNodeCompareTimeAndPriority>::iterator MapIteratorTimeAndPriority;
				«IF scheduler_var»
				//Variante2: moving map sorted by priority and future map sorted by time
				std::map<EventNode, Execution*, EventNodeComparePriority> movingMap;
				typedef std::map<EventNode, Execution*, EventNodeComparePriority>::iterator MapIteratorPriority;
				
				std::map<EventNode, Execution*, EventNodeCompareTimeAndPriority> futureMap;
				//typedef std::map<EventNode, Execution*, EventNodeCompareTime>::iterator MapIteratorTime;
				«ENDIF»
				
				typedef std::pair<EventNode, Execution*> MapPairType;
				
				public:
				TimeRedBlackTree() {}
				void insert(Execution* e);
				Execution* pick();
				void remove(Execution* e);
				bool empty();
				void printState();
				«IF scheduler_var»
				void insertFuture(Execution* e);
				void insertMoving(Execution* e);
				Execution* pickMovingMap();
				«ENDIF»
				};
				#endif
				''');
			endTargetFile(timeRedBlackTree_H);
			
			val Writer timeRedBlackTree_CPP = beginTargetFile(cPackageFolder, "TimeRedBlackTree.cpp");
			timeRedBlackTree_CPP.write(
				'''
				#include "TimeRedBlackTree.h"
				#include "Execution.h"
				#include "Log.h"
				#include <iostream>
				
				extern Execution* cx;
				
				«IF scheduler_var»
				//Variante2: insert in moving map
				void TimeRedBlackTree::insertMoving(Execution* e) {
					if(!empty()){
						e->next = nullptr;
						e->last = e;
					}
					EventNode eventNode(e->getScheduledTime(), e->getPriority(), e);

					std::pair<MapIteratorPriority, bool> result = movingMap.insert( MapPairType(eventNode, e) );

					if (!result.second) {
						// execution with priority already present
						Execution* firstEquivalentExecution = result.first->second;

						// put new execution at the end (FIFO order)
						Execution* last = firstEquivalentExecution->last;
						last->next = e;
						e->prev = last;
						firstEquivalentExecution->last = e;
					}
				}
				//Variante2: insert in futuremap
				void TimeRedBlackTree::insertFuture(Execution* e) {
					e->next = nullptr;
					e->last = e;
					EventNode eventNode(e->getScheduledTime(), e->getPriority(), e);

					std::pair<MapIteratorTimeAndPriority, bool> result = futureMap.insert( MapPairType(eventNode, e) );

					if (!result.second) {
						// execution with time already present
						Execution* firstEquivalentExecution = result.first->second;

						// put new execution at the end (FIFO order)
						Execution* last = firstEquivalentExecution->last;
						last->next = e;
						e->prev = last;
						firstEquivalentExecution->last = e;
					}
				}
				
				Execution* TimeRedBlackTree::pick() {
					Execution* v;
				«IF debug»	std::cout << "before pick" << std::endl; 
					printState(); «ENDIF»
					if(empty()){
						if(!futureMap.empty()){
							EventNode k = futureMap.begin()->first;
							v = futureMap.begin()->second;
							
							/* Variante 1:
							Execution* lastEquivalent = v->last;
							Execution* temp;
							while(lastEquivalent != v){
								temp = lastEquivalent->prev;
								insertMoving(lastEquivalent);
								lastEquivalent = temp;	
							}
							*/
							futureMap.erase(k);
							insertMoving(v); 	
						}
					}
				«IF debug»	std::cout << "in the middle of pick" << std::endl;
					printState(); «ENDIF»
					return pickMovingMap();
				}
				
				Execution* TimeRedBlackTree::pickMovingMap() {
					EventNode k = movingMap.begin()->first;
					Execution* v = movingMap.begin()->second;
						
					Execution* nextEquivalent = v->next;
					
					if (nextEquivalent != nullptr) {
						// executions with same priority are still present
						movingMap[k] = nextEquivalent;
						nextEquivalent->prev = nullptr;
						nextEquivalent->last = v->last;
						v->prev = nullptr;
					}	
					else {
						movingMap.erase(k);
					}
					«IF debug» std::cout << "after pick" << std::endl;
					printState(); «ENDIF»
					return v;
				}
				
				void TimeRedBlackTree::printState() {
					std::cout << "---------------MOVINGMAP" << std::endl;
					for (MapIteratorPriority it = movingMap.begin(); it != movingMap.end(); ++it) {
						EventNode k = it->first;
						Execution* v = it->second;

						k.printMe();
						std::cout << " => ";

						v->printDetails();

						Execution* next = v->next;
						while (next != nullptr) {
							next->printDetails();
							std::cout << " ";
							next = next->next;
						}
						std::cout << std::endl;
					}
					std::cout << "---------------" << std::endl;
					std::cout << "---------------FUTUREMAP" << std::endl;
					for (MapIteratorTimeAndPriority it = futureMap.begin(); it != futureMap.end(); ++it) {
						EventNode k = it->first;
						Execution* v = it->second;

						k.printMe();
						std::cout << " => ";

						v->printDetails();

						Execution* next = v->next;
						while (next != nullptr) {
							next->printDetails();
							std::cout << " ";
							next = next->next;
						}
						std::cout << std::endl;
					}
					std::cout << "---------------" << std::endl;
				}
				«ELSE»
				Execution* TimeRedBlackTree::pick() {
					EventNode k = map.begin()->first;
					Execution* v = map.begin()->second;
					
					Execution* nextEquivalent = v->next;
					
					if (nextEquivalent != nullptr) {
						// executions with same time and priority are still present
						map[k] = nextEquivalent;
						nextEquivalent->prev = nullptr;
						nextEquivalent->last = v->last;

						//v->next = nullptr;
						v->prev = nullptr;
					}
					else {
						map.erase(k);
					}

					return v;
				}

				void TimeRedBlackTree::printState() {
					std::cout << "---------------" << std::endl;
					for (MapIteratorTimeAndPriority it = map.begin(); it != map.end(); ++it) {
						EventNode k = it->first;
						Execution* v = it->second;

						k.printMe();
						std::cout << " => ";

						v->printDetails();

						Execution* next = v->next;
						while (next != nullptr) {
							next->printDetails();
							std::cout << " ";
							next = next->next;
						}
						std::cout << std::endl;
					}
					std::cout << "---------------" << std::endl;
				}
				«ENDIF»
				
				//Variante1:
				void TimeRedBlackTree::insert(Execution* e) {
					e->next = nullptr;
					e->last = e;
					EventNode eventNode(e->getScheduledTime(), e->getPriority(), e);

					std::pair<MapIteratorTimeAndPriority, bool> result = map.insert(MapPairType(eventNode, e) );

					if (!result.second) {
						// execution with equivalent time and priority already present
						Execution* firstEquivalentExecution = result.first->second;

						// put new execution at the end (FIFO order)
						Execution* last = firstEquivalentExecution->last;
						last->next = e;
						e->prev = last;
						firstEquivalentExecution->last = e;
					}
				}
				
				void TimeRedBlackTree::remove(Execution* e) {
					// efficient remove requires double-linked list of executions
					if (e->prev == nullptr) {
						EventNode eventNode(e->getScheduledTime(), e->getPriority(), e);

						// execution is at front in map
						Execution* nextEquivalent = e->next;
						if (nextEquivalent == nullptr) {
							// there are NO equivalent executions
							map.erase(eventNode);
						}
						else {
							// there are equivalent executions
							map[eventNode] = nextEquivalent;
							nextEquivalent->last = e->last;
							nextEquivalent->prev = nullptr;
							e->prev = nullptr;
						}
					}
					else {
						// execution is in between equivalent other executions
						e->prev->next = e->next;
						e->prev = nullptr;
						e->next = nullptr;
					}
				}
				
				bool TimeRedBlackTree::empty() {
					«IF !scheduler_var»
					//Variante1:
					return map.empty();
					«ELSE»
					//Variante2:
					return movingMap.empty();
					«ENDIF»
				}
				''');
			endTargetFile(timeRedBlackTree_CPP);
			
			val Writer eventset_H = beginTargetFile(cPackageFolder, "EventSet.h");
			eventset_H.write(
				'''
				#ifndef EVENTSET_H
				#define EVENTSET_H
				class Execution; 
				
				class EventSet {
					public:
					void insertFuture(Execution* e);
					void insertMoving(Execution* e);
					Execution* pick();
					void remove(Execution* e);
					bool empty();
				};
				#endif
				''');
			endTargetFile(eventset_H);
			
			val Writer eventnode_H = beginTargetFile(cPackageFolder, "EventNode.h");
			eventnode_H.write(
				'''
				#ifndef EVENTNODE_H
				#define EVENTNODE_H
				class Execution; 
				
				class EventNode {
					public:
					double time;
					int priority;
					Execution* execution;
					
					EventNode(double t, int p, Execution* e);
					void printMe();
				};
				#endif
				''');
			endTargetFile(eventnode_H);
			
			val Writer eventnode_CPP = beginTargetFile(cPackageFolder, "EventNode.cpp");
			eventnode_CPP.write(
				'''
				#include "EventNode.h"
				#include "Execution.h"
				#include <iostream>
				
				EventNode::EventNode(double t, int p, Execution* e) : time(t), priority(p), execution(e) {}
				
				void EventNode::printMe() {
					std::cout << "(t:" << time << ",p:" << priority << ")";
				}
				''');
			endTargetFile(eventnode_CPP);
			
			//Variante1: compares elements by priority and time
			val Writer eventnodecomparetimeandpriority_H = beginTargetFile(cPackageFolder, "EventNodeCompareTimeAndPriority.h");
			eventnodecomparetimeandpriority_H.write(
				'''
				#ifndef EVENTNODECOMPARETIMEANDPRIORITY_H
				#define EVENTNODECOMPARETIMEANDPRIORITY_H
				class EventNode;
				
				class EventNodeCompareTimeAndPriority {
					public:
					bool operator() (const EventNode& node1, const EventNode& node2) const;
				};
				#endif
				''');
			endTargetFile(eventnodecomparetimeandpriority_H);
			
			val Writer eventnodecomparetimeandpriority_CPP = beginTargetFile(cPackageFolder, "EventNodeCompareTimeAndPriority.cpp");
			eventnodecomparetimeandpriority_CPP.write(
				'''
				#include "EventNodeCompareTimeAndPriority.h"
				#include "EventNode.h"
				
				bool EventNodeCompareTimeAndPriority::operator() (const EventNode& node1, const EventNode& node2) const {
					return node1.time < node2.time || (node1.time == node2.time && node1.priority > node2.priority);
				}
				''');
			endTargetFile(eventnodecomparetimeandpriority_CPP);
			
		if(scheduler_var){
			val Writer eventnodecomparepriority_H = beginTargetFile(cPackageFolder, "EventNodeComparePriority.h");
			eventnodecomparepriority_H.write(
				'''
				#ifndef EVENTNODECOMPAREPRIORITY_H
				#define EVENTNODECOMPAREPRIORITY_H
				class EventNode;
				
				class EventNodeComparePriority {
					public:
					bool operator() (const EventNode& node1, const EventNode& node2) const;
				};
				#endif
				''');
			endTargetFile(eventnodecomparepriority_H);
			
			val Writer eventnodecomparepriority_CPP = beginTargetFile(cPackageFolder, "EventNodeComparePriority.cpp");
			eventnodecomparepriority_CPP.write(
				'''
				#include "EventNodeComparePriority.h"
				#include "EventNode.h"
				
				bool EventNodeComparePriority::operator() (const EventNode& node1, const EventNode& node2) const {
					return (node1.priority > node2.priority);
				}
				''');
			endTargetFile(eventnodecomparepriority_CPP);
		}
			
 			val Writer scheduler_H = beginTargetFile(cPackageFolder, "Scheduler.h");
			scheduler_H.write(
				'''
				#ifndef SCHEDULER_H
				#define SCHEDULER_H
				
				#include "TimeRedBlackTree.h"
				#include "Execution.h"
				#include <forward_list>
				
				class Scheduler {
				public:

				TimeRedBlackTree eventSet;
				double modelTime;

				// must be called before getSingleInstance. cannot be changed afterwards.
				static void setInitialCreationWithDebug();
				static bool isDebugOn();
				static Scheduler* getSingleInstance();

				Execution* pickNextEvent(); // removes the next event and returns it

				Execution* yield();
				Execution* yieldTo(Execution* e);
				Execution* advance(double time); // advance current and return next
				Execution* terminate(); // terminate current and return next from moving list
				Execution* wait();

				void activate(Execution* e);
				void reactivate(Execution* e);
				void interrupt(Execution* e); // interrupt scheduled execution
				void resume(Execution* e); // resume interrupted execution
				void reschedule(Execution* e, double time); // reschedule scheduled execution

				void debug_add(Execution* e); // adds the execution to a list of all executions for debug (not needed for regular executions).

				private:
				static Scheduler* instance;
				static bool debugOn;

				// in debug mode, all executions are accessible from this list.
				// when the debugger suspends execution, it inspects the executions
				// in this list in order to display waiting and interrupted executions
				// separately in the GUI.
				std::forward_list<Execution*> executionList;
				std::forward_list<Execution*> waitingList;
				std::forward_list<Execution*> interruptedList;

				Scheduler() : modelTime(0) {}
				};
				#endif
				'''
			);
			endTargetFile(scheduler_H);
			
				val Writer scheduler_CPP = beginTargetFile(cPackageFolder, "Scheduler.cpp");
			scheduler_CPP.write(
				'''
				#include "Scheduler.h"
				#include "GotoExecution.h"
				#include "Log.h"
				
				extern GotoExecution* cx;
				
				Scheduler* Scheduler::instance = nullptr;
				bool Scheduler::debugOn = false;

				Execution* Scheduler::pickNextEvent() {
					return eventSet.pick();
				}

				Execution* Scheduler::advance(double time) {
					«IF debug» std::cout << "before advance"<< std::endl;
					eventSet.printState(); «ENDIF»
					«IF scheduler_var»
					//Variante2:
					if(time > 0) {
						cx->setScheduledTime(modelTime + time);
						eventSet.insertFuture(cx);
					}
					else eventSet.insertMoving(cx);
					«ELSE»
					//Variante1:
					if(time < 0) time = 0.0;
					cx->setScheduledTime(modelTime + time);
					eventSet.insert(cx);	
					«ENDIF»		

				Execution* nextEvent = pickNextEvent();

				if (nextEvent->getScheduledTime() != modelTime) {
					modelTime = nextEvent->getScheduledTime();
					log2("model time changes to: " << modelTime);
				}
				«IF debug»std::cout << "after advance"<< std::endl;
				eventSet.printState(); «ENDIF»
				return nextEvent;
				}

				Execution* Scheduler::yield() {
				«IF debug»	std::cout << "before yield"<< std::endl;
					eventSet.printState(); «ENDIF»
					«IF !scheduler_var»
					//Variante1:
					eventSet.insert(cx);
					«ELSE»
					//Variante2:
					eventSet.insertMoving(cx);
					«ENDIF»
					«IF debug»std::cout << "after yield"<< std::endl;
					eventSet.printState(); «ENDIF»
				return pickNextEvent();
				}
				// cannot be used in DBL
				Execution* Scheduler::yieldTo(Execution* e) {
					eventSet.remove(e);
					«IF !scheduler_var»
					//Variante1:
					eventSet.insert(cx);
					«ELSE»
					//Variante2:
					eventSet.insertMoving(cx);
					«ENDIF»
				return e;
				}

				Execution* Scheduler::terminate() {
				// execution objects are deleted here.
				// if you do not want an execution to be deleted, just don't call terminate!
				
				Execution* nextEvent = pickNextEvent();
				
				if (nextEvent->getScheduledTime() != modelTime) {
					modelTime = nextEvent->getScheduledTime();
					log2("model time changes to: " << modelTime);
				}

				delete cx;

				return nextEvent;
				}

				Execution* Scheduler::wait() {
					«IF debug»std::cout << "before wait"<< std::endl;
					eventSet.printState(); «ENDIF»
					cx->isWaiting = true;
					waitingList.push_front(cx);
				
					if (eventSet.empty()) {
						std::cerr << "ERROR: Cannot continue with next event because the because the event list is empty." << std::endl;
						std::terminate();
					}
					
					Execution* nextEvent = pickNextEvent();

					if (nextEvent->getScheduledTime() != modelTime) {
						modelTime = nextEvent->getScheduledTime();
						log2("model time changes to: " << modelTime);
					}
					«IF debug» std::cout << "after wait"<< std::endl;
					eventSet.printState(); «ENDIF»

				return nextEvent;
				}

				Scheduler* Scheduler::getSingleInstance() {
					if (instance == nullptr) {
						instance = new Scheduler();
					}
					return instance;
				}

				bool Scheduler::isDebugOn() {
					return debugOn;
				}

				void Scheduler::setInitialCreationWithDebug() {
					if (instance != nullptr) {
						std::cerr << "ERROR: Cannot activate debug for an already created scheduler." << std::endl;
						std::terminate();
					}
					if (debugOn) {
						std::cerr << "ERROR: Cannot deactivate debug for an already created debug-scheduler." << std::endl;
						std::terminate();
					}
					debugOn = true;
				}

				void Scheduler::debug_add(Execution* e) {
					executionList.push_front(e);
				}

				void Scheduler::activate(Execution* e) {
				«IF debug»	std::cout << "before activate"<< std::endl;
					eventSet.printState(); «ENDIF»
					e->setScheduledTime(modelTime);
					«IF !scheduler_var»
					// Variante1:
					eventSet.insert(e);	
					«ELSE»
					// Variante2:
					eventSet.insertMoving(e);
					«ENDIF»
				«IF debug»	std::cout << "after activate"<< std::endl;
					eventSet.printState(); «ENDIF»
				}

				void Scheduler::reactivate(Execution* e) {
				«IF debug»	std::cout << "before reactivate"<< std::endl;
					eventSet.printState(); «ENDIF»
					e->setScheduledTime(modelTime);
					e->isWaiting = false;
					waitingList.remove(e);
					«IF !scheduler_var»
					// Variante1:
					 eventSet.insert(e);	
					 «ELSE»
					// Variante2:
					eventSet.insertMoving(e);
					«ENDIF»
				«IF debug»	std::cout << "after reactivate"<< std::endl;
					eventSet.printState(); «ENDIF»
				}
				// cannot be used in DBL
				void Scheduler::interrupt(Execution* e) {
					// interrupt scheduled execution
					eventSet.remove(e);
					e->isInterrupted = true;
					interruptedList.push_front(e);
				}
				// cannot be used in DBL
				void Scheduler::resume(Execution* e) {
					// resume interrupted execution
					if (e->isInterrupted) {
						e->setScheduledTime(modelTime);
						e->isInterrupted = false;
						interruptedList.remove(e);
						«IF !scheduler_var»
						// Variante1:
						 eventSet.insert(e);	
						 «ELSE»
						// Variante2:
						eventSet.insertMoving(e);
						«ENDIF»
					}
					else {
						std::cerr << "ERROR: Cannot resume an execution which was not interrupted before." << std::endl;
						std::terminate();
					}
				}
				// cannot be used in DBL
				void Scheduler::reschedule(Execution* e, double time) {
					// reschedule scheduled execution
					eventSet.remove(e);
					e->setScheduledTime(modelTime + time);
					«IF scheduler_var»
					eventSet.insertFuture(e);
					«ENDIF»
				}
				'''
			);
			endTargetFile(scheduler_CPP); 
			
			val Writer log_H = beginTargetFile(cPackageFolder, "Log.h");
			log_H.write(
				'''
				#ifndef __LOG_H
				#define __LOG_H

				#include <iostream>
				#include <stdlib.h>

				#ifdef PRINT_LOG
				#define log(MSG) std::cout << "(pid-" << cx->pid << ") " << MSG << std::endl;
				#define log2(MSG) std::cout << MSG << std::endl;
				#else
				#define log(MSG) 
				#define log2(MSG) 
				#endif

				#define print(MSG) std::cout << MSG << std::endl;
				#define pprint(MSG) std::cout << "pid-" << cx->pid << ": " << MSG << std::endl;

				#endif
				'''
			);
			endTargetFile(log_H);
	}
}