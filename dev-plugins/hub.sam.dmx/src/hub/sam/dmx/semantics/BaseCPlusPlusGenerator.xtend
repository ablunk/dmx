package hub.sam.dmx.semantics
import hub.sam.dbl.And
import hub.sam.dbl.Assignment
import hub.sam.dbl.BinaryOperator
import hub.sam.dbl.BoolType
import hub.sam.dbl.BreakStatement
import hub.sam.dbl.Cast
import hub.sam.dbl.Class
import hub.sam.dbl.Constructor
import hub.sam.dbl.ContinueStatement
import hub.sam.dbl.CreateObject
import hub.sam.dbl.Div
import hub.sam.dbl.DoubleLiteral
import hub.sam.dbl.DoubleType
import hub.sam.dbl.Equal
import hub.sam.dbl.Expression
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
import hub.sam.dmx.semantics.AbstractGenerator
import java.io.Writer
import java.util.List
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import hub.sam.dbl.AbstractVariable
import hub.sam.dbl.Extension
import hub.sam.dbl.ExpansionStatement
import hub.sam.dbl.ExpansionPart
import hub.sam.dbl.ExpandTextPart
import hub.sam.dbl.ExpandVariablePart
import hub.sam.dbl.StructuralSymbolReference
import java.util.Set
import java.util.HashSet
import java.util.Arrays
import hub.sam.dbl.SuperClassSpecification

/* 
 * A base class for generating c++-code for DBL-programs represented by 
 * instances of a meta-model @see resources/dbl.ecore
 * (only general concepts of the language)
 * 
 * @author  Christopher Breszka
 * @version 1.0
 * @date 15.11.2016
 */
class BaseCPlusPlusGenerator extends AbstractGenerator {
	/* folder in which all source files and folders are generated */
	private static val cPackagePrefix = "gen";
	/* boolean flag for indicating that self is used in constructor */
	private var boolean needsWeakPtrInConstructor = false;
	/* container to save included classes and modules */
	protected var Set<EObject> includes = new HashSet<EObject>()
	/* saves all c++-keywords and reserved implementation names to generate correct identifier names */
	private val Set<String> allKeyWords = new HashSet<String>(Arrays.asList(
		"asm","double", "long", "typedef", "auto", "else", "register", "union", "break", "enum", 
		"return", "unsigned", "case", "extern", "short", "void", "char", "float", "signed", "volatile",
		"const", "for", "sizeof", "while", "continue", "goto", "static", "default", "if", "struct", "do", "int", "switch",
		"bool", "inline", "template", "catch", "mutable", "this", "class", "namespace", "throw", "const_cast", "new", "true",
		"delete", "operator", "try", "dynamic_cast", "private", "typeid", "explicit" ,"protected", "typename",
		"export", "public", "using", "false", "reinterpret_cast", "virtual", "friend", "static_cast", "alignas", "alignof",
		"and", "and_eq", "bitand", "bitor", "char16_t", "char32_t", "compl", "constexpr", "decltype", "noexcept", "not",
		"not_eq", "nullptr", "or", "or_eq", "static_assert", "thread_local", "wchar_t", "xor", "xor_eq", "final",
		"override", "std", "make_shared", "process_id", "enable_shared_from_this", "cout", "endl", "string", "shared_ptr",
		"clock_t", "float", "CLOCKS_PER_SEC", "vector", "stringstream", "typeid",
		"to_String", "unordered_map", "static_pointer_cast", "dynamic_pointer_cast", "downcasted_shared_from_this",
		"shared_from_this","myVector","startMainProcedure","MainProcess","make_pair",
		"context","callStack","state","std","cbsLib","NULL"));
	/* contains the path of the project */
	protected static var IPath cPackageFolder;
	/* saves all modules of the DBL program, also the imported ones */
	protected var Set<Module> allModules = new HashSet<Module>();
	/* saves the current generated DBL class */
	protected var Class currentClass;
	/* saves the main Module */
	protected var Module mainModule;
	/* container to save other specific include directives*/
	protected var Set<String> includeStrings = new HashSet<String>()
	/**
	 * calls constructor to generate instance of BaseCPlusPlusGenerator and also generates
	 * project folder path
	 * @param outputFolder specifies path to the project 
	 */
	public new(IPath outputFolder) {
		super(outputFolder);
		cPackageFolder = outputFolder.append(cPackagePrefix);
		makeFolder(cPackageFolder);
	}
	/**
	 * getter-method for getting target language name
	 * @return string representation of target language name
	 */
	public def String getLanguageName() {
		'c++'
	}
	/**
	 * getter-method for getting simLib name
	 * @return string representation of simulation library name
	 */
	public def String getSimLibName() {
		''
	}
	/**
	 * determines all given modules in the DBL-program
	 * @param model the representation of the DBL program ( main model and also imported models)
	 */
	protected def void collectSemanticInformation(Model model){
		val it = model
		// determine all modules in the DBL program
		modules.forEach[allModules.add(it)]
	}
    /**
	 * here starts the code generation process for DBL-models based on abstract syntax represented by
	 * instance of EMF generated class Model. Here starts the code generation for modules and for the 
	 * Main.cpp. There are also function calls for generating a simple makefile and a global variant 
	 * type, which is only generated in simulation programs. 
	 * @param model internal representation of an actual DBL program
	 * @param mainModel flag for indicating that the passed DBL model represents the main model or imported dbl models
	 */
	 override void genModel(Model model, boolean mainModel){
		val it = model
		mainModule = if (mainModel) {
			model.collectSemanticInformation
			model.modules.findFirst[ functions.exists[ name == 'main' ] ] 
		}
		else null
		
		getModules.forEach[genModuleWriter]
		
		if (mainModel && mainModule !== null) {
			createFileWithContent(cPackageFolder, "Main.cpp", genMainCPP(mainModule))
			genVariantTypeReturnInSeparateFile
			genMakeFile
		}
	}
	/**
	 * generates distinct names for c++ identifier/ this is a try of a naming convention, 
	 * but there are still some name conflicts possible
	 * @param t internal representation of a specific NamedElement in DBL
	 * @return distinct name for c++ identifier
	 */
	protected def String genPreciseName(NamedElement t){
		if(t.name.length > 1 && Character.compare(t.name.charAt(1),'_') != 0 && Character.compare(t.name.charAt(0),'_') == 0) '''«t.name.substring(1)»_'''
		else if(t.name.length > 2 && Character.compare(t.name.charAt(2),'_') != 0 && Character.compare(t.name.charAt(1),'_') == 0 && Character.compare(t.name.charAt(0),'_') == 0)'''«t.name.substring(2)»__'''
		else if(t.sameMemberName) '''«t.name»_'''
		else if (allKeyWords.contains(t.name)) '''«Character.toUpperCase(t.name.charAt(0))+t.name.substring(1)»_''' 
		else '''«t.name»'''
	}
	/**
	 * checks if there is an element with same name
	 * @param t internal representation of a specific NamedElement in DBL
	 * @return flag for indicating that elements have same names
	 */
	private def boolean sameMemberName(NamedElement t) {
		// namespace and class should have different name when members are accessed in the program
		// to distinguish between namespace and class
		if((t instanceof Module && (t as Module)?.getClasses.exists
			[name == (t as Module).name])) return true
		// function and variable names should be different in C++
		else if (t instanceof Function){
			val function = t as Function
				if(function.eContainer instanceof Module && (function.eContainer as Module).
					getVariables.exists[name == function.name] 
				)	return true
				else if (function.eContainer instanceof Class && (function.eContainer as Class).
					getAttributes.exists[name == function.name] 
				) return true
				else return false
		}
		else return false
	}
	/**
	 * generates the string representation for the c++-main-method in Main.cpp 
	 * DBL main method statements are generated in function @see startMainProcedure
	 * @param mainModule DBL main module
	 * @return string representation of the c++-main-method
	 */
	protected def String genMainCPP(Module mainModule){
		val it = mainModule
		var Set<EObject> includes = new HashSet<EObject>()
		includes.add(mainModule)
		includes.addAll(getAllContainedMemberTypes(includes))
		'''
			#include "../gen/«genPreciseName»/«genPreciseName».h"
			«FOR c:includes.filter[it instanceof Class && (it as Class).bindings.empty]»
			#include "../gen/«genPreciseName»/«(c as Class).genPreciseName».h"
			«ENDFOR»
			«FOR c:includes.filter[it instanceof Class && !(it as Class).bindings.empty]»
			#include "../../C++-Libraries/«(c as Class).genBoundType(false)».h"
			«ENDFOR»
			#include <ctime>
			#include <iostream>
			
			int main()
			{
				float elapsed;
				clock_t start = clock();
				«IF it !== null»«genPreciseName»::startMainProcedure();«ENDIF»
				elapsed = (float)(clock() - start) / CLOCKS_PER_SEC;
				std::cout << "Execution time: " << elapsed << " sec." << std::endl;
				return 0;
			}
		'''
	}
	/**
	 * generates the Writer for modules and puts the generated module content into the file 
	 * @param module representation of the current DBL module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 */
	protected def void genModuleWriter(Module module) {
		val it = module
		val moduleFolder = cPackageFolder.append(genPreciseName)
		makeFolder(moduleFolder)
		
		createFileWithContent(moduleFolder,genPreciseName+".h",genModule(true))
		createFileWithContent(moduleFolder,genPreciseName+".cpp",genModule(false))
		// DBL classes with bindings are ignored
		module.genClassSet.filter[getBindings.empty].forEach[
			createFileWithContent(moduleFolder,genPreciseName+".h",genClass(true))
			createFileWithContent(moduleFolder,genPreciseName+".cpp",genClass(false))
		]
	}
	/**
	 * generates the Writer and puts the generated content into the file 
	 * @param i path for the file
	 * @param FileName name for the generated file
	 * @param generatedContent the string content that has to be pasted into the file
	 */
	protected def void createFileWithContent(IPath i, String FileName, String generatedContent){
		var Writer writer = beginTargetFile(i, FileName)
		writer.write(generatedContent)
		endTargetFile(writer)
	}
	/**
	 * initializes global data for saving include informations
	 */
	protected def void initialGlobalData(){
		includes = new HashSet<EObject>()
		includeStrings = new HashSet<String>()
	}
	/**
	 * generates string representation for DBL-module 
	 * @param module representation of the current generated DBL module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++ string representation for DBL module
	 */
	protected def String genModule(Module module, boolean isHeader) {
		val it = module
		if(isHeader){
			initialGlobalData
			// its important to generate content in a specific order to guarantee that 
			// required informations are available
			val mainProcessContent = if(it === mainModule) genSimulationProcess(isHeader)
			val moduleContent = genModuleContent(isHeader)
				'''
					#ifndef «genPreciseName.toUpperCase() + "_H"»
					#define «genPreciseName.toUpperCase() + "_H"»
					«genIncludesHeader»
					namespace «genPreciseName» {
						«moduleContent»
						«mainProcessContent»
					}
					#endif
				'''
		}
		else {
			// saves copy of included files to avoid multiple includes
			var includetemp = includeStrings.clone().toSet
			includes.add(it)
			val mainProcessContent = if(it === mainModule) genSimulationProcess(isHeader)
			val moduleContent = genModuleContent(isHeader)
				'''
					«genIncludesCPP(includetemp)»
					«moduleContent»
					«mainProcessContent»
				'''
		}
	}
	/**
	 * generates string representation for DBL main process in simulation programs, otherwise 
	 * just the main function, which contains the mapped statements of the DBL main function
	 * @param module representation of the main module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++ string representation for main process/main function
	 */
	protected def String genSimulationProcess(Module mainModule, boolean isHeader){
		val it = mainModule
			'''
				«genMainProcess(isHeader)»
				«genStaticStartFuncMemberForMainProcess(isHeader)»
			'''
	}
	/**
	 * generates string representation for DBL main function
	 * @param mainModule representation of the main module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++ string representation for DBL main function
	 */
	protected def genStaticStartFuncMemberForMainProcess(Module mainModule, boolean isHeader){
		if(isHeader)'''extern void startMainProcedure();'''
		else 
			'''
				void «mainModule.genPreciseName»::startMainProcedure(){
					«mainModule.getFunctions.findFirst[name == "main"].getStatements.genStatements»
				}
			'''
	}
	/**
	 * mapping from DBL-module content consisting of variables and functions, which can be used from all classes
	 * in the module
	 * @param module representation of the current DBL module
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++string representation of DBL module content
	 */
	protected def String genModuleContent(Module module, boolean isHeader){
		val it = module
		'''
			«getVariables.genVariables(isHeader)»
			«getFunctions.genModuleFunctions(isHeader)»
		'''
	}
	/**
	 * mapping from DBL-module functions on C++-functions
	 * @param functions all functions in a module 
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++string representation of all functions in a module
	 */
	protected def String genModuleFunctions(List<Function> functions, boolean isHeader){
		functions.genFunctions(isHeader)
	}
	/**
	 * generates c++ string representation for class in DBL
	 * @param clazz representation of the current generated DBL class
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++ string representation of DBL class
	 */
	protected def String genClass(Class clazz, boolean isHeader){
		val it = clazz 
		if(isHeader){
			currentClass = clazz
			initialGlobalData
			if(getSuperClasses.empty && !clazz.active) includeStrings.addAll('''#include "../../../C++-Libraries/referenceSemantics/BaseRefCounter.h"''', '''#include "../../../C++-Libraries/referenceSemantics/intrusive_ptr.h"''','''#include "../../../C++-Libraries/referenceSemantics/RefStringType.h"''')
			val contentClassHeader = genContentClassHeader(isHeader)
			'''
				#ifndef «genPreciseName.toUpperCase() + "_H"»
				#define «genPreciseName.toUpperCase() + "_H"»
				«genIncludesHeader»
				«contentClassHeader»
				#endif
			'''		
		}
		else {
			// saves copy of included files to avoid multiple includes
			var includetemp = includeStrings.clone().toSet
			includes.add(it)
			val contentClassCPP = genMemberClass(isHeader)
			'''
				«genIncludesCPP(includetemp)»
				«contentClassCPP»
			'''
		}
	}
	/**
	 * generates string representation for c++ class in the corresponding namespace. All members 
	 * in the class are public elements according to the specification of DBL
	 * @param clazz representation of the current DBL class
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return string representation for c++ class in the corresponding namespace
	 */
	protected def String genContentClassHeader(Class clazz, boolean isHeader){
		val module = clazz.eContainer as Module
	 	'''
			namespace «module.genPreciseName»{	
				class «clazz.genPreciseName» «clazz.genClassInheritance»
				{ 
				public:
					«clazz.genMemberClass(isHeader)»
				};
			}
		''' 
	 }
	 /**
	 * generates string representation for class inheritance
	 * @param clazz representation of the current DBL class
	 * @return C++ string representation for class inheritance relations
	 */
	protected def String genClassInheritance(Class clazz){
		val it = clazz
		'''
			«IF !getSuperClasses.empty»
				«FOR sClass:getSuperClasses BEFORE ':' SEPARATOR ','» 
					public «sClass.getClass_.genType»
				«ENDFOR»
			«ELSE»:«genSpecificBaseClass»
			«ENDIF»
		'''
	}
	/**
	 * classes with no base classes have to inherit from reference counter class, so that 
	 * they could be used with intrusive pointer 
	 * @param clazz representation of the current DBL class
	 * @return C++ string representation for inheritance of intrusive_ref_counter base class
	 */
	protected def String genSpecificBaseClass(Class clazz){
		'''public cbsLib::intrusive_ref_counter<«clazz.genPreciseName»>'''
	}
	/**
	 * generates c++-code for DBL class content, consisting of variables, a toString() method for base 
	 * classes, constructors, defaulted constructors, methods and in case of active classes a lifecycle() method
	 * @param clazz representation of the current DBL class
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++string representation for DBL class members 
	 */
	protected def String genMemberClass(Class clazz, boolean isHeader){
		val it = clazz
		'''
			«getAttributes.genVariables(isHeader)»
			«genToStringMethod(isHeader)»
			«getConstructors.genConstructors(isHeader)»
			«genStandardConstructorAndDestructor(isHeader)»
			«getMethods.genFunctions(isHeader)»
			«IF active»«genLifecycle(isHeader)»«ENDIF»
		'''
	}
	/**
	 * generates string representation for include-directives for header files. There are problems when forward 
	 * declaring intrusive pointer. So current solution works with include and forward declarations. 
	 * @return C++ string representation for includes in header file
	 */
	protected def String genIncludesHeader(){
		'''
			«FOR j:includeStrings»
				«j»
			«ENDFOR»
			«FOR i:includes.filter[it instanceof Class && (it != currentClass)]»
				«IF !(i as Class).bindings.empty»
					class «(i as Class).genBoundType(true)»;
				«ELSEIF (currentClass !== null && currentClass.getSuperClasses.exists[class_ == i])»
					#include "../«(i.eContainer as Module).genPreciseName»/«(i as Class).genPreciseName».h" 
				«ELSE»
					namespace «(i.eContainer as Module).genPreciseName» {class «(i as Class).genPreciseName»;}
				«ENDIF»
			«ENDFOR»
			«IF includeStrings.exists[contains("RefStringType")]»typedef cbsLib::intrusive_ptr<cbsLib::myString> stringPtr;«ENDIF»
		'''
	}
	/**
	 * generates string representation for include-directives for implementation files and try to 
	 * avoid multiple includes (especially includes which are done in header files) 
	 * @param headerIncludes all already included files in header file
	 * @return C++ string representation for includes in implementation files
	 */
	protected def String genIncludesCPP(Set<String> headerIncludes) {
		// include nested member types in CPP files, so that they have a base ref counter
		includes.addAll(getAllContainedMemberTypes(includes))
		'''
			«FOR j:includeStrings.filter[!headerIncludes.contains(it)]»
				«j»
			«ENDFOR»
			«FOR i:includes»
				«IF currentClass === null || (!(currentClass?.getSuperClasses.exists[class_ == i]))»
					«includeForClassAndModule(i)»
				«ENDIF»
			«ENDFOR»
			«IF includeStrings.exists[contains("RefStringType")] && !headerIncludes.exists[contains("RefStringType")]»typedef cbsLib::intrusive_ptr<cbsLib::myString> stringPtr;«ENDIF»
		'''
	}
	/**
	 * generates string representation for include-directives for module and class import
	 * @param i class or module which should be included
	 * @return C++ string representation for include-directives for module and class import
	 */
	private def String includeForClassAndModule(EObject i){
		'''
			«IF i instanceof Class»
				«IF !(i as Class).bindings.empty»
					#include "../../../C++-Libraries/«(i as Class).genBoundType(false)».h"
				«ELSE»
					#include "../«(i.eContainer as Module).genPreciseName»/«(i as Class).genPreciseName».h"
				«ENDIF»
			«ELSE»
				#include "../«(i as Module).genPreciseName»/«(i as Module).genPreciseName».h"
			«ENDIF»
		'''
	}
	/**
	 * determines all classes that should be included and performs a member check to include 
	 * all contained member class types to guarantee that they have a reference count. 
	 * @param includesForVariant difference between variantIncludes and includes
	 */
	protected def Set<Class> getAllContainedMemberTypes(Set<EObject> allFoundTypes){
		var Set<Class> tempIncludeClasses = new HashSet<Class>() 
		for(eObj:allFoundTypes.filter[!(it instanceof Class && !(it as Class).bindings.empty)]) 
			tempIncludeClasses.addAll(genMemberTypesRecursively(eObj,new HashSet<Module>(),new HashSet<Class>()))
		return tempIncludeClasses
	}
	/**
	 * checks all content of classes and modules if they contain nested class types and saves them 
	 * in a set to generate includes in the CPP file. After that the check is performed recursively on
	 * inner members.
	 * @param clazzOrModule class or module that has to be checked for contained class types
	 * @param allVisitedModules saves all visited modules to avoid cycles in search
	 * @param allFoundClassTypes all found class types
	 */
	private def Set<Class> genMemberTypesRecursively(EObject clazzOrModule, Set<Module> allVisitedModules, Set<Class> allFoundClassTypes){
		var allContents = clazzOrModule.eAllContents
		var Set<Class> classTypes = allFoundClassTypes
		
		if(clazzOrModule instanceof Module) allVisitedModules.add(clazzOrModule as Module)
		else classTypes.add(clazzOrModule as Class)
		
		while(allContents.hasNext){
			var nextElement = allContents.next
			// class type is determined and there is a check if the include is necessary
			if(nextElement instanceof TypedElement && (nextElement as TypedElement).classifierType !== null){
				val classType = (nextElement as TypedElement).classifierType.referencedElement as Class
				if(!allFoundClassTypes.exists[getSuperClasses.exists[getClass_.name == classType.name]]){
					if(!classTypes.contains(classType)){
						if(classType.bindings.empty) classTypes.addAll(genMemberTypesRecursively(classType,allVisitedModules,allFoundClassTypes))
						else classTypes.add(classType)
					}
						
				}
			}
			// modules are determined and the module is checked for class types
			else if(nextElement instanceof IdExpr && (nextElement as IdExpr).referencedElement?.eContainer instanceof Module && 
				((nextElement as IdExpr).referencedElement instanceof AbstractVariable || (nextElement as IdExpr).referencedElement instanceof Function)){
				val module = (nextElement as IdExpr).referencedElement?.eContainer as Module
				if(!allVisitedModules.contains(module))
					classTypes.addAll(genMemberTypesRecursively(module,allVisitedModules,allFoundClassTypes))
			}
		}
		return classTypes
	}
	/**
	 * mapping from DBL constructors on c++ constructors. Reset of WeakPtr-Requirement in constructor 
	 * for every new generated constructor.
	 * @param constructors representation of all DBL constructors
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return string representation for generated c++-constructors
	 */
	protected def genConstructors(List<Constructor> constructors, boolean isHeader){
		'''
			«FOR constructor: constructors»
				«setWeakPtrInConstructor(false)»
				«genConstructor(constructor.eContainer as Class, constructor, isHeader)»
			«ENDFOR»
		'''
	}
	/**
	 * includes weak_intrusive_ptr header to implementation file/ this is used in constructors 
	 * when this-pointer is passed over to function or is assigned to variable
	 * @param value switch on or off for weak_pointer concept
	 */
	protected def void setWeakPtrInConstructor(boolean value){
		if(value) includeStrings.add('''#include "../../../C++-Libraries/referenceSemantics/weak_intrusive_ptr.h"''')
		needsWeakPtrInConstructor = value;
	}
	/**
	 * generates additional c++-constructors like standard constructor when inheriting and to 
	 * initialize attributes properly and virtual destructors when base class is used
	 * @param clazz representation of the current DBL class
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return string representation of c++-constructor, destructor
	 */
	protected def genStandardConstructorAndDestructor(Class clazz, boolean isHeader) {
		val it = clazz
		val needsStandardConstructor = !getConstructors.exists[getParameters.empty]
		setWeakPtrInConstructor(false)
		if (isHeader) 
			'''
				«IF needsStandardConstructor»«genConstructor(null,isHeader)»«ENDIF»
				«IF isInheritedBaseClass»virtual ~«genPreciseName»(){}«ENDIF» 
			''' 
		else 
			'''«IF needsStandardConstructor»«genConstructor(null,isHeader)»«ENDIF»'''
	}
	/**
	 * determines if class has child classes by iterating through all classes in all modules
	 * @param clazz representation of the current DBL class
	 * @return determines if class has child classes
	 */
	private def boolean isInheritedBaseClass(Class clazz){
		return allModules.exists[getClasses.exists[getSuperClasses.exists[class_.name == clazz.name && (class_.eContainer as Module).name == (clazz.eContainer as Module).name]]]
	}
	/**
	 * mapping from DBL-constructor on C++-constructor, constructor contains base class constructor calls,
	 * and attribute initializations and a body where mapped statements are inserted
	 * @param clazz representation of the current DBL class
	 * @param constructor representation of the current DBL constructor
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return string representation of c++-constructor
	 */
	protected def String genConstructor (Class clazz, Constructor constructor, boolean isHeader){
		val it = clazz
		if (isHeader) '''«genPreciseName»(«constructor?.getParameters?.genFormalParameters»);'''
		else {
			// generate statements code before inserting into the template because information
			// is needed if weak-intrusive-pointer concept is needed
			val allStatementsCode = '''«constructor?.getStatements?.genStatements»'''
			''' 
				«genType»::«genPreciseName»(«constructor?.getParameters?.genFormalParameters»)
				«genSuperClassCalls(constructor)»
				«IF needsComma»,«ELSEIF needsColon»:«ENDIF»
				«genAttributes»{
					«IF active»this->schedule<«genType»,&«genType»::fActions>(this, new «genType»::MainStruct());«ENDIF»
					«IF needsWeakPtrInConstructor» cbsLib::weak_intrusive_ptr<«currentClass.genType»> self = this;«ENDIF»
					«allStatementsCode»
				}
			'''
		}
	}
	/**
	 * checks if comma is needed in constructor initializer list
	 * @param clazz representation of the DBL class that owns the constructor
	 * @return boolean flag if comma is needed in constructor initializer list
	 */
	protected def boolean needsComma(Class clazz){
		val it = clazz
		return (attributes.exists[!isClass] && (!superClasses.filter[!getConstructorArguments.empty].empty))
	}
	/**
	 * checks if colon is needed in constructor initializer list
	 * @param clazz representation of the DBL class that owns the constructor
	 * @return boolean flag if colon is needed in constructor initializer list
	 */
	protected def boolean needsColon(Class clazz){
		val it = clazz
		return (attributes.exists[!isClass] && (superClasses.filter[!getConstructorArguments.empty].empty))
	}
	/**
	 * mapping from formal parameters in DBL on c++-parameters
	 * @param parameters list of DBL parameters
	 * @return c++ string representation for formal parameters
	 */
	protected def String genFormalParameters(List<Parameter> parameters){
		'''«FOR param: parameters SEPARATOR ','» «genFormalParameter(param)» «ENDFOR»'''
	}
	/**
	 * mapping from formal parameter in DBL on c++-parameter
	 * @param param representation of the current DBL parameter
	 * @return c++ string representation for formal parameter
	 */
	protected def String genFormalParameter(Parameter param){
		val it = param
		'''«genType» «genPreciseName»'''
	}
	/**
	 * mapping from DBL base class constructor calls on c++ superclass constructor calls
	 * @param clazz representation of the DBL class that owns the constructor
	 * @param constructor representation of the current DBL constructor
	 * @return C++ string representation for c++ superclass constructor calls
	 */
	protected def String genSuperClassCalls(Class clazz, Constructor constructor){
		'''
			«FOR sc : clazz.getSuperClasses.filter[!getConstructorArguments.empty] BEFORE ':' SEPARATOR ','»
				«sc.getClass_.genType»
				«IF (sc.getClass_.getBindings.empty)»::«sc.getClass_.genPreciseName»
				«ENDIF»(«sc.getConstructorArguments.genActualParameters»)
			«ENDFOR»
		'''
	}
	/**
	 * mapping from DBL actual parameters on c++ actual parameters. In case of implicit array casts
	 * new arrays have to be created. This is checked by comparing the type of the used expression 
	 * with the expected type.
	 * @param arguments representation of all DBL actual parameters
	 * @return C++ string representation for all actual parameters
	 */
	protected def String genActualParameters(List<Expression> arguments){
		var List<Parameter> params = newArrayList();
		for(v:arguments) params.add(getParam(v,arguments.indexOf(v),arguments));
		'''
			«FOR value: arguments SEPARATOR ','» 
				«value.genInitialValue(params.get(arguments.indexOf(value)))»
			«ENDFOR»
		'''
	}
	/**
	 * mapping from DBL actual parameters on c++ actual parameters. In case of implicit array casts
	 * new arrays have to be created. This is checked by comparing the type of the used expression 
	 * with the expected type. This functions is needed for function or constructor calls.
	 * @param e representation of the expression of an actual parameter
	 * @param pos position of the expression in the function call
	 * @param actualParams contains all parameters of the function call
	 * @return parameter corresponding to the expression e
	 */
	private def Parameter getParam(Expression e, int pos, List<Expression> actualParams){
		if(e?.eContainer?.eContainer instanceof IdExpr){ 
			val idExpr = e.eContainer.eContainer as IdExpr
			// determines the parameter at position @pos of the corresponding function
			if(idExpr.referencedElement instanceof Function){
				val function = idExpr.referencedElement as Function
				return function.getParameters.get(pos);
			}
			// this case is more tricky, because constructors are not referenced in the meta model
			// like function objects. The correct constructor has to be found by comparing expected 
			// and actual type (constructor overloading is not supported, because constructor calls 
			// are not semantically checked and its also not possible to get the type for a complex 
			// expression (these informations should be added to the meta model!!)   
			else if(idExpr.referencedElement instanceof Class && (idExpr.referencedElement as Class).bindings.empty){
				val class = idExpr.referencedElement as Class
				val constructor = class.getConstructors.findFirst[getParameters.size == actualParams.size]
				return constructor.getParameters.get(pos);
			}
		}
		else if(e?.eContainer instanceof SuperClassSpecification){
			val superClass = e.eContainer as SuperClassSpecification
			val constructor = superClass.class_.getConstructors.findFirst[getParameters.size == actualParams.size]
			return constructor.getParameters.get(pos);
		}
		else return null
	}
	/**
	 * generates toString-function which is used to build a string representation for objects. Its only 
	 * generated if the a class has no base classes.
	 * @param clazz representation of the actual DBL class
	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return string representation for toString-function
	 */
	protected def String genToStringMethod(Class clazz, boolean isHeader){
		val it = clazz
		val isStringFunctionDefined = getMethods.exists[
			(name == "toString") && (primitiveType instanceof StringType) && (getParameters.empty) && (typeArrayDimensions.empty)
		]
		// toString function is only needed if the class is passive (active classes have a defaulted toString function) and
		// no toString function is already defined and the class has no base classes
		if ((getSuperClasses.empty) && !isStringFunctionDefined && !active){
			if (isHeader) 
				'''«IF isInheritedBaseClass»virtual«ENDIF» stringPtr toString();'''
			else{
				includeStrings.addAll("#include <sstream>", "#include <typeinfo>", '''#include "../../../C++-Libraries/referenceSemantics/intrusive_ptr.h"''','''#include "../../../C++-Libraries/referenceSemantics/RefStringType.h"''')
				'''
					stringPtr «genType»::toString(){
						std::stringstream ss;
						ss << typeid(*this).name() << "@" << this;
						return new cbsLib::myString(ss.str());
					}
				'''
			}
		}
	}
	/**
	 * strings have to be handled like Java Strings/ problem is that c++ literals cannot be concatenated in a std::string by 
	 * using +-Operator, so constructor std::string() is called for every literal. To get the same string representation like 
	 * in Java a to_String()-function is provided, which maps all data types accordingly
	 * @param e expression for which a toString representation has to be created
	 * @return C++ string for the toString representation of an expression
	 */
	protected def String expressionToString(Expression e){
		if(e instanceof NullLiteral) '''std::string("null")'''
		else if(e instanceof FalseLiteral || e instanceof TrueLiteral)'''std::string("«e.genExpr»")'''
		else if(e instanceof StringLiteral) '''std::string(«e.genExpr»)'''
		else if(e instanceof IdExpr && (e as IdExpr).predefinedId instanceof MeLiteral) 
			genToStringUsage('''*this->toString()''')
		// anonymous object creation
		else if(e instanceof CreateObject && (e as CreateObject).typeArrayDimensions.empty)
			genToStringUsage('''to_String(cbsLib::intrusive_ptr<«(e as CreateObject).genPrimitiveOrClassType(false)»>(«e.genExpr»))''')
		// anonymous array creation
		else if(e instanceof CreateObject){
			genToStringUsage('''to_String(cbsLib::intrusive_ptr<«(e as CreateObject).genVectorType(e.typeArrayDimensions.size)»>(«e.genExpr»))''')
		}
		else if(e instanceof Plus && e.checkComplexExpression)
			'''«(e as BinaryOperator).op1.expressionToString»+«(e as BinaryOperator).op2.expressionToString»'''
		else genToStringUsage('''to_String(«e.genExpr»)''')
	}
	/**
	 * include of to_String functionality to generate toString-representation for datatypes
	 * @param content string value that should be generated
	 * @return content string value
	 */
	protected def String genToStringUsage(String content){
		includeStrings.add('''#include "../../../C++-Libraries/referenceSemantics/stringExtension.h"''')
		'''«content»'''
	}
	/**
	 * All string objects are created on heap. A Special reference counted string type 
	 * is needed and included. 
	 * @param e expression which should be generated
	 * @return C++string representation for with new created String-objects
	 */
	 protected def String createNewStringOnHeap(Expression e){
		includeStrings.add('''#include "../../../C++-Libraries/referenceSemantics/RefStringType.h"''')
		'''new cbsLib::myString(«e.expressionToString»)'''
	}
	/**
	 * checks if an expression has Type string and therefore must be created on heap
	 * @param e expression which should be generated
	 * @return if an expression has Type string
	 */
	protected def boolean stringNeedsCreationOnHeap(Expression e){
		if(e instanceof StringLiteral) return true
		else if(e instanceof Plus && e.checkComplexExpression) return true 
		else return false
	}
	/**
	 * checks complex expression recursively if some of the contained elements is from type string
	 * @param e complex expression for which a toString representation has to be created
	 * @return if complex expression is from type string
	 */
	protected def boolean checkComplexExpression(Expression e){
		if(e.isExpressionStringType) return true
		else if (e instanceof Plus){
			val complexExpression = e as Plus
			return (complexExpression.op1.checkComplexExpression || complexExpression.op2.checkComplexExpression)
		}
		else return false
	}
	/**
	 * checks if non-complex expression is from type string
	 * @param e expression for which a toString representation has to be created
	 * @return if non-complex expression is from type string
	 */
	protected def boolean isExpressionStringType(Expression e){
		// is string literal?
		if(e instanceof StringLiteral) return true
		//is string variable or string array access?
		else if(e instanceof IdExpr && ((e as IdExpr)?.referencedElement as TypedElement)?.primitiveType instanceof StringType)
		{
			val idExpr = e as IdExpr
			val idExprType = idExpr.referencedElement as TypedElement
			return stringArrayAccess(idExprType,idExpr)
		}
		// cast to string?
		else if(e instanceof Cast && (e as Cast)?.classifierType?.primitiveType instanceof StringType) return true 
		else return false
	}
	/**
	 * checks if an expression is a string array access
	 * @param idExprType represents type of the referencedElement
	 * @param idExpr the idExpr that should be generated
	 * @return checks if an expression is a string array access
	 */
	private def boolean stringArrayAccess(TypedElement idExprType, IdExpr idExpr){
		if(!idExprType.typeArrayDimensions.empty && idExpr.arrayIndex.empty)
			return false
		else
			return true
	}
	/**
	 * mapping from DBL class attributes on C++ class attributes
	 * creating and initializing non-static class attributes in initializer list
	 * @param clazz representation of the current DBL class that owns the constructor
	 * @return string representation of c++ attributes in initializer list
	 */
 	protected def String genAttributes(Class clazz){
		'''
			«FOR attribute: clazz.getAttributes.filter[!isClass()] SEPARATOR ','»
				«attribute.genPreciseName»(«attribute.initialValue.genInitialValue(attribute)»)
			«ENDFOR»
		'''
	}
	/**
	 * mapping from DBL functions on c++-Functions except for main-function which is generated at a different location
	 * @param functions representation of DBL functions
 	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++-string representation for DBL functions
	 */
	protected def String genFunctions(List<Function> functions, boolean isHeader) {
		'''
			«FOR f : functions»
				«f.genFunction(isHeader)»
			«ENDFOR»
		'''
	}
	/**
	 * mapping from DBL function on C++-function distinguishing between global functions(module), virtual 
	 * functions and class member functions
	 * @param f representation of DBL function
 	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++ string representation of DBL function
	 */
	protected def String genFunction(Function f, boolean isHeader){
		val it = f
		val inModule = eContainer instanceof Module
		val isVirtual = if(!inModule) isVirtualFunction else false
		val isAbstract = if(!inModule) abstract else false
		if(isHeader)
			'''«IF inModule»extern«ELSEIF isVirtual || isAbstract»virtual«ENDIF» «genType» «genPreciseName»(«getParameters.genFormalParameters»)«IF isAbstract» = 0«ENDIF»;'''	
		else {
			if(!abstract)
				'''
					«genType» «genContentAccess(inModule)» «genPreciseName»(«getParameters.genFormalParameters»)
					{
						«getStatements.genStatements»
					}
				'''
		}
	}
	/**
	 * call of helper function to check if virtual function is needed
	 * @param f representation of current DBL function
	 * @return evaluates virtualFunctionHelper to check if function should be virtual
	 */
	protected def boolean isVirtualFunction(Function f){
		val clazz = f.eContainer as Class
		return isVirtualFunctionHelper(Arrays.asList(clazz),f)
	}
	/**
	 * checks for a function if it should be virtual by checking all class members of class hierarchy
	 * @param classes allClasses which have to be checked, if they have member functions with same prototype
	 * like function f
	 * @param f representation of current DBL function
	 * @return true if DBL function is virtual
	 */
	private def boolean isVirtualFunctionHelper(List<Class> classes, Function f){
		for(clazz:classes){
			var Set<Class> allDerivedClasses = new HashSet<Class>();
			// get all Classes, which derive from base class (clazz)
			for(m:allModules){ 
				val temp = m.getClasses.filter[getSuperClasses.exists[class_.name == clazz.name && 
				(class_.eContainer as Module).name == (clazz.eContainer as Module).name]]
				if (!temp.empty) allDerivedClasses.addAll(temp)
			}
			// checks if there are functions with same prototype recursively 
			if(!allDerivedClasses.empty){
				if(allDerivedClasses.exists[getMethods.exists[sameFunctionPrototype(f)]]) return true
				else return isVirtualFunctionHelper(allDerivedClasses.toList,f)
			}
		}
		return false
	}
	/**
	 * checks if two functions have the same prototype (parameter size and parameter 
	 * types are the same)
	 * @param a representation of function in derived class
	 * @param b representation of current DBL function
	 * @return true if the prototype of two functions is the same
	 */
	private def boolean sameFunctionPrototype(Function a, Function b) {
		val boolean sameNameTypeAndParSize = (a.name == b.name) && (a.genType == b.genType) 
		&& (a.getParameters.size == b.getParameters.size)
		if (sameNameTypeAndParSize){
			for(var int i = 0; i < a.getParameters.size(); i++){
				if(a.getParameters.get(i).genType != b.getParameters.get(i).genType) return false
			}
			return true;
		}
		else return false;
	}
	/**
	 * mapping from DBL variables on c++-variables (non static class attributes have to be generated in 
	 * constructor initializer list and are therefore not generated see condition in IF-clause). 
	 * Here global variables (variables in module) or static variables in class scope are generated. 
	 * @param variables representation of DBL variables in class or module
 	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++-string representation for DBL variables
	 */
	protected def String genVariables(List<Variable> variables, boolean isHeader) {
		'''
			«FOR v : variables»
				«IF (!(v.eContainer instanceof Class && !isHeader && !v.isClass))»
					«v.genVariable(isHeader)»
				«ENDIF» 
			«ENDFOR»
		'''
	}
	/**
	 * mapping from DBL variable on c++-variable distinguishing between declaration and 
	 * definition of variable. 
	 * @param variable representation of current DBL variable
 	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++ string representation for DBL variable
	 */
	protected def String genVariable(Variable variable, boolean isHeader) {
		val it = variable
		'''«genVariableDeclaration(isHeader)»«IF !isHeader» «IF initialValue !== null»=«ENDIF» «initialValue.genInitialValue(variable)»«ENDIF»;'''
	}
	/**
	 * mapping from DBL variable declaration on C++ variable declaration
	 * @param variable representation of current DBL variable
 	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return C++-string representation for DBL variable declaration
	 */
	protected def String genVariableDeclaration(Variable variable, boolean isHeader) {
		val it = variable;
		'''«genVariableDeclarationPrefix(isHeader)» «genPreciseName»'''	
	}
	/**
	 * The prefix of a variable declaration (extern or static and type information) is generated. In modules variables are extern to
	 * avoid multiple definitions of the variables. Its also possible to declare static variables, but only in class
	 * scope. In CPP-Units the variables have to be accessed by their qualified names (e.g. namespace::class::variable).
	 * @param variable representation of DBL variable
 	 * @param isHeader boolean flag for indicating whether a c++-header or -implementation file should be generated
	 * @return string representation for c++ variable declaration prefix
	 */
	protected def String genVariableDeclarationPrefix(Variable variable, boolean isHeader){
		val it = variable;
		val inModule = eContainer instanceof Module
		if(isHeader)
			'''«IF inModule»extern«ENDIF»«IF isClass && !inModule»static«ENDIF» «genType»'''
		else
			'''«genType» «genContentAccess(inModule)»'''
	}
	/**
	 * generates qualified names for variables and functions, which belong to namespace or class scope
	 * and have to be accessed in the style (e.g. namespace::class::variable) in CPP-units.
	 * @param obj representation of DBL variable or function 
 	 * @param inModule boolean flag for indicating whether obj belongs to module or class
	 * @return string representation for qualified variable or functions name
	 */
	private def String genContentAccess(EObject obj, boolean inModule){
		val isVariableStatic = if(obj instanceof Variable && (obj as Variable).isClass) true else false
		val isFunction = if(obj instanceof Function) true else false
		'''«IF inModule»«(obj.eContainer as Module).genPreciseName»::«ELSEIF isFunction || isVariableStatic »«(obj.eContainer as Class).genType»::«ENDIF»'''
	}
	/**
	 * generates string representation for initialValue of an expression. Special Handling for string value needed,
	 * because strings have reference semantics and have therefore be generated on heap. Here is also a check 
	 * performed if the expression is an array if declared array type and defined array type are the same 
	 * otherwise new arrays are created.
	 * @param e representation of DBL expression for initialization
	 * @return C++-string representation for initialValue
	 */
	protected def String genInitialValue(Expression e, TypedElement t){
		val boolean needsCast = if(t !== null && !t?.typeArrayDimensions.empty && t.classifierType !== null && !(e instanceof Cast)) needsArrayCast(e,t) else false
		'''
		«IF e !== null»
			«IF e.stringNeedsCreationOnHeap»
				«e.createNewStringOnHeap»
			«ELSEIF needsCast && e instanceof CreateObject»
				«genVectorDefinition(e as CreateObject,t)»
			«ELSEIF needsCast»
				new «genVectorType(t,t.typeArrayDimensions.size)»(*(«e.genExpr»))
			«ELSE»
				«e.genExpr»
			«ENDIF»
		«ENDIF»
		'''
	}
	/**
	 * this function performs a check to find out if vector types of declared vector type 
	 * and initialization vector type are different and if a cast is needed between types 
	 * @param rValue value of the assigned vector
	 * @param lValueType type of the declared vector type
	 * @return if a vector cast is needed
	 */
	private def boolean needsArrayCast(Expression rValue, TypedElement lValueType){
		if(rValue === null) return false
		else if(rValue instanceof IdExpr){
			val rValueType = (rValue as IdExpr).referencedElement as TypedElement
			return hasDifferentArrayType(rValueType, lValueType)
		}
		else return hasDifferentArrayType(rValue, lValueType)	
	}
	/**
	 * helper function for @see needsArrayCast()
	 * @param rValueType type of the assigned vector
	 * @param lValueType declared vector type
	 * @return if a vector cast is needed
	 */
	private def boolean hasDifferentArrayType(TypedElement rValueType,TypedElement lValueType){
		if(rValueType !== null && lValueType !== null && (!rValueType?.typeArrayDimensions.empty) && (rValueType?.classifierType?.referencedElement != lValueType?.classifierType?.referencedElement)) 
			return true
		else return false
	}
	/**
	 * generates c++-string representation for DBL statements
	 * @param statements list of DBL statements
	 * @return C++-string representation for DBL statements
	 */
	protected def String genStatements(List<Statement> statements){
		'''
			«FOR stm : statements»
				«stm.genStatement»
			«ENDFOR»
		'''
	}
	/**
	 * handles special case, when there was no method to match a DBL component
	 * @param eObj representation of an unmatched DBL EObject
	 * @return Error string representation for unknown EObject
	 */
	protected def String forwardGen(EObject eObj) {
		'<! unknown element ' + eObj.eClass.name ' !>'
	}
	/**
	 * could delegate genStatement()-Calls to super class in case there are statements which are not 
	 * mapped in this class, but in inherited child classes.
	 * @param stm representation of in this class unknown statement
	 * @return string representation for unknown statement
	 */
	protected def dispatch String genStatement(Statement stm) {
		'<! unsupported statement ' + stm.eClass.name + ' !>'
		stm.forwardGen
	}
	/**
	 * generates C++-string representation for DBL Print-statement. Here std::cout is 
	 * used without flushing output with std::endl. That could be done in DBL by using "\n" in the string.
	 * There is also some checking, because some of the expressions have to be mapped in a different way like 
	 * TrueLiteral (in Java: true, C++: 1) or representation of double values, where dangling zeros are removed.
	 * @param print represents DBL print-statement containing expressions to output on console
	 * @return C++-string representation for DBL Print-statement
	 */
	protected def dispatch String genStatement(Print print){
		includeStrings.add("#include <iostream>")
		'''
			std::cout << «FOR expr : print.outputs SEPARATOR '<<'»
				«IF (expr instanceof StringLiteral || expr instanceof IntLiteral || (expr instanceof IdExpr && 
					((expr as IdExpr)?.referencedElement as TypedElement)?.primitiveType instanceof IntType))» 
						«expr.genExpr»
				«ELSEIF expr instanceof TrueLiteral» "true"
				«ELSEIF expr instanceof FalseLiteral» "false"
				«ELSEIF expr instanceof NullLiteral» "null"
				«ELSE» «expr.expressionToString»
				«ENDIF»
			«ENDFOR»; 
		'''
	}
	/**
	 * generates C++-string representation for DBL If-statement. If-Statements in simulation part 
	 * have to be mapped differently in some cases.
	 * @param ifStm represents DBL if-statement
	 * @return C++-string representation for If-statement
	 */
	protected def dispatch String genStatement(IfStatement ifStm) {
		val it = ifStm
		if(isInActionsBlock) return genSpecialIfStatement
		else return '''
			if («condition.genExpr») «trueCase.genStatement»
			«IF falseCase !== null»
				else «falseCase.genStatement»
			«ENDIF»
		'''
	}
	/**
	 * generates c++-string representation for DBL LocalScope-statement (statement block)
	 * @param stm represents DBL LocalScope-statement
	 * @return C++-string representation for DBL-Statement Block
	 */
	protected def dispatch String genStatement(LocalScopeStatement stm) {
		'''{«stm.statements.genStatements»}'''
	}
	/**
	 * calls genAssignment to generate Assignment statement with semicolon (in contrast to
	 * assignment statement in a for-loop without semicolon)
	 * @param stm represents DBL Assignment-statement
	 * @return C++-string representation for DBL Assignment-statement
	 */
	protected def dispatch String genStatement(Assignment stm) {
		'''«stm.genAssignment(true)»'''
	}
	/**
	 * generates C++-string representation for DBL return-statement (special handling for interruptible 
	 * functions necessary)
	 * @param stm represents DBL Return-statement
	 * @return C++-string representation for DBL return-statement
	 */
	protected def dispatch String genStatement(Return stm) {
		if(isInActionsBlock())
			'''«stm.genSpecialReturnStatementForSchedulingFunction»'''	
		else
			'''return «stm.value.genInitialValue(getFunction(stm))»;'''	
	}
	/**
	 * helper function to determine the type of the function that calls the 
	 * return statement
	 * @param obj represents DBL Return-statement
	 * @return the function that belongs to this return-statement
	 */
	protected def Function getFunction(EObject obj){
		var temp = obj.eContainer
		while(!(temp instanceof Function)) temp = temp.eContainer
		return temp as Function 
	}
	/**
	 * generates c++-string representation for DBL Break-statement
	 * @param stm represents DBL Break-statement
	 * @return C++-string representation for DBL Break-statement
	 */
	protected def dispatch String genStatement(BreakStatement stm) {
		if(isInActionsBlock) stm.genSpecialBreakStatement
		else 'break;'
	}
	/**
	 * generates c++-string representation for DBL Continue-statement. If Continue statement is used 
	 * in a loop, where interruptible functions are called in a condition, Continue statements have to be
	 * mapped in a different manner (@see genSpecialContinueStatement()).
	 * @param stm represents DBL Continue-statement
	 * @return C++ string representation for DBL Continue-statement
	 */
	protected def dispatch String genStatement(ContinueStatement stm) {
		if(isInActionsBlock) stm.genSpecialContinueStatement
		else 'continue;'
	}
	/**
	 * generates c++-string representation for DBL Switch-statement distinguishing between 
	 * normal Switch-Statements and special Switch-Statements working with String-Type. This has to be 
	 * emulated in C++.
	 * @param stm represents DBL Switch-statement
	 * @return C++ string representation for DBL Switch-statement
	 */
	protected def dispatch String genStatement(SwitchStatement stm) {
		val it = stm 
		if(isInActionsBlock) stm.genSpecialSwitchStatement
		else{
		if(variable.idExpr.isExpressionStringType){
			switchId++
			'''
				«genMapForSwitch»
				«genSwitchStatement(true)»
			'''
		}
		else
			'''«genSwitchStatement(false)»'''
		}
	}
	/* generates switch name id for building distinct switchCase variables */
	private var switchId = -1;
	/**
	 * generates c++-string representation for DBL Switch-statement distinguishing between 
	 * normal Switch-Statements and special Switch-Statements working with String-Type. There is also a special 
	 * handling for variable declarations. If new variables are introduced in some of the switch cases, 
	 * a statement block {...} is used.
	 * @param stm represents DBL Switch-statement
	 * @param isString indicates if Switch-Expression of Switch-Statement is of Type String
	 * @return C++-string representation for DBL Switch-statement
	 */
	protected def String genSwitchStatement(SwitchStatement stm, boolean isString){
		val it = stm
		var int count = 0
			'''
				switch («IF isString»switchCase«switchId»){
					«FOR c : cases»
					case «count++»:
						«genBlockForStatement(c.body.exists[it instanceof Variable],'''«c.body.genStatements»''')»
					«ENDFOR»
				«ELSE» «variable.genExpr»){
					«FOR c : cases»
					case «c.value.genExpr»:
						«genBlockForStatement(c.body.exists[it instanceof Variable],'''«c.body.genStatements»''')»
					«ENDFOR»
				«ENDIF»
				«IF defaultCase !== null»
					default:
					«genBlockForStatement(defaultCase.body.exists[it instanceof Variable],'''«defaultCase.body.genStatements»''')»
				«ENDIF»
				}
			'''
	}
	/**
	 * generates c++-string representation of statements and checks if a block is needed
	 * @param cond condition if block is needed
	 * @param stm represents string representation of a list of statements
	 * @return C++-string representation of statements/statement block
	 */
	protected def String genBlockForStatement(boolean cond, String stm){
		if(cond) '''«stm»'''
		else '''{«stm»}'''
	}
	/**
	 * special handling for Switch-Statements, where the Switch expression is of data type string. An unordered map 
	 * is used to map string constants on numbers. After that the switch expression is searched
	 * in the map, to get the correct case number for the Switch-statement
	 * @param stm represents DBL Switch-statement
	 * @return C++-string representation for an unordered map that is used for special handling of 
	 * Switch-Statements with Switch Expression of Type String
	 */
	protected def String genMapForSwitch(SwitchStatement stm){
		val it = stm
		var int count = 0
		includeStrings.addAll("#include <string>","#include <unordered_map>")
		'''
			std::unordered_map<std::string, int> switch«switchId» = {
				«FOR c : cases SEPARATOR ','»
					{«c.value.expressionToString»,«count++»}
				«ENDFOR»
			};
			std::unordered_map<std::string,int>::const_iterator it«switchId» = switch«switchId».find(«variable.idExpr.expressionToString»);
			int switchCase«switchId» = -1;
			if(it«switchId» != switch«switchId».end()) switchCase«switchId» = it«switchId»->second;
		'''
	}
	/**
	 * generates C++-string representation for DBL For-Loop. For-Loops that have function calls 
	 * of interruptible functions in their loop conditions have to be mapped in a different manner 
	 * (@see genSpecialForStatement)
	 * @param stm represents DBL For-Loop
	 * @return C++-string representation for DBL-For-Loop
	 */
	protected def dispatch String genStatement(ForStatement stm) {
		val it = stm
		if(isInActionsBlock) return genSpecialForStatement
		else return 
			'''
				for («statements.head.genStatement» «termination.genExpr»; «increment.genAssignment(false)»)
					«body.genStatement»
			'''
	}
	/**
	 * generates c++-string representation for DBL While-Loop. While-Loops that have function calls 
	 * of interruptible functions in their loop conditions have to be mapped in a different manner 
	 * (@see genSpecialWhileStatement)
	 * @param stm represents DBL While-Loop
	 * @return C++-string representation for DBL While-Loop
	 */
	protected def dispatch String genStatement(WhileStatement stm) {
		val it = stm
		if(isInActionsBlock) return genSpecialWhileStatement
		else return '''while («condition.genExpr») «body.genStatement»'''
	}
	/**
	 * generates C++-string representation of DBL assignment-statement
	 * @param stm represents DBL assignment-statement
	 * @param genSemicolon indicates whether a semicolon should be generated or not
	 * @return C++-string representation of DBL assignment-statement
	 */
	protected def String genAssignment(Assignment stm, boolean genSemicolon) {
		'''«stm.variable.genExpr» = «stm.value.genInitialValue(stm.variable.idExpr.referencedElement as TypedElement)»«IF genSemicolon»;«ENDIF»'''
	}
	/**
	 * generates C++-string representation of variable definition (e.g. int x = 15), consisting of
	 * declaration and definition.
	 * @param variable represents DBL variable
	 * @return C++-string representation of c++-variable definition
	 */
	protected def dispatch String genStatement(Variable variable) {
		val it = variable
		if(isInActionsBlock) 
			genActionsBlockVariable
		else 
			'''«genType» «genPreciseName»«IF initialValue !== null» = «ENDIF»«initialValue.genInitialValue(variable)»;'''		
	}
	/**
	 * generates C++-string representation for DBL function call
	 * @param call represents DBL function call
	 * @return C++-string representation for DBL function call
	 */
	protected def dispatch String genStatement(FunctionCall call) {
		'''«call.callIdExpr.genExpr»;'''
	}
	/**
	 * delegates calls of genExpr to super class in case there are no expressions which 
	 * are mapped in this class.
	 * @param expr representation of unknown expression
	 * @return string representation for unknown expression
	 */
	protected def dispatch String genExpr(Expression expr) {
		expr.forwardGen
	}
	/**
	 * generates C++-string representation for DBL Void expression
	 * @param expr represents DBL Void expression
	 * @return C++-string representation for DBL Void expression
	 */
	protected def dispatch String genExpr(Void expr) {''''''}
	/**
	 * generates C++-string representation for logical DBL OR expression (Syntax DBL: x or y)
	 * @param expr represents DBL logical OR expression
	 * @return C++-string representation for DBL logical OR expression
	 */
	protected def dispatch String genExpr(Or expr) {
		'''«expr.genBinaryExpr("||")»'''
	}
	/**
	 * generates C++-string representation for logical DBL AND expression ( Syntax DBL: x and y)
	 * @param expr represents DBL logical AND expression
	 * @return C++-string representation for DBL logical AND expression
	 */
	protected def dispatch String genExpr(And expr) {
		'''«expr.genBinaryExpr("&&")»'''
	}
	/**
	 * generates C++-string representation for EQUAL expression (Syntax DBL: x == y). Special handling 
	 * is needed if strings are compared to each other.
	 * @param expr represents DBL EQUAL expression
	 * @return C++-string representation for DBL EQUAL expression
	 */
	protected def dispatch String genExpr(Equal expr) {
		val compString = genCompareStringExpression(expr, "==")
		if(!("".equals(compString))) '''«compString»'''
		else '''«expr.genBinaryExpr("==")»'''
	}
	/**
	 * generates C++-string representation for NOTEQUAL expression (Syntax DBL: x !=y ). Special handling 
	 * is needed if strings are compared to each other.
	 * @param expr represents DBL NOTEQUAL expression
	 * @return C++-string representation for DBL NOTEQUAL expression
	 */
	protected def dispatch String genExpr(NotEqual expr) {
		val compString = genCompareStringExpression(expr, "!=")
		if(!("".equals(compString))) '''«compString»'''
		else '''«expr.genBinaryExpr("!=")»'''
	}
	/**
	 * generates C++-string representation for string comparisons with "==" or "!="
	 * @param binOp represents DBL NOTEQUAL or EQUAL expression
	 * @param op represents DBL Operator as String
	 * @return C++-string representation for DBL String Comparisons in Expressions
	 */
	private def String genCompareStringExpression(BinaryOperator binOp, String op){
		var result = "";
		val op1NeedsStringCon = binOp.op1.stringNeedsCreationOnHeap 
		val op2NeedsStringCon = binOp.op2.stringNeedsCreationOnHeap 
		if(op1NeedsStringCon || op2NeedsStringCon){
			if(op1NeedsStringCon ) result += '''(«binOp.op1.expressionToString») «op» '''
			else result += '''«binOp.op1.genExpr» «op» '''
			if(op2NeedsStringCon) result += '''(«binOp.op2.expressionToString»)'''
			else result += '''«binOp.op2.genExpr»'''
			return result;
		}
		return result;
	}
	/**
	 * generates C++-string representation of DBL GREATER expression (Syntax DBL: x > y)
	 * @param expr represents DBL GREATER expression
	 * @return C++-string representation of DBL GREATER expression
	 */
	protected def dispatch String genExpr(Greater expr) {
		'''«expr.genBinaryExpr(">")»'''
	}
	/**
	 * generates C++-string representation of DBL GreaterEqual expression (Syntax DBL: x >= y)
	 * @param expr represents DBL GreaterEqual expression
	 * @return C++-string representation of DBL GreaterEqual expression
	 */
	protected def dispatch String genExpr(GreaterEqual expr) {
		'''«expr.genBinaryExpr(">=")»'''
	}
	/**
	 * generates c++-string representation of DBL Less expression (Syntax DBL: x < y)
	 * @param expr represents DBL Less expression
	 * @return C++-string representation of DBL Less expression
	 */
	protected def dispatch String genExpr(Less expr) {
		'''«expr.genBinaryExpr("<")»'''
	}
	/**
	 * generates c++-string representation of DBL LessEqual expression (Syntax DBL: x <= y)
	 * @param expr represents DBL LessEqual expression
	 * @return C++-string representation of DBL LessEqual expression
	 */
	protected def dispatch String genExpr(LessEqual expr) {
		'''«expr.genBinaryExpr("<=")»'''
	}
	/**
	 * generates C++-string representation of DBL Plus expression (DBL Syntax: x + y)
	 * @param expr represents DBL Plus expression
	 * @return C++-string representation for DBL Plus expression
	 */
	protected def dispatch String genExpr(Plus expr) {
		'''«expr.genBinaryExpr("+")»'''
	}
	/**
	 * generates C++-string representation of DBL Minus expression (DBL Syntax: x - y)
	 * @param expr represents DBL Minus expression
	 * @return C++-string representation of DBL Minus expression
	 */
	protected def dispatch String genExpr(Minus expr) {
		'''«expr.genBinaryExpr("-")»'''
	}
	/**
	 * generates C++-string representation of DBL Multiplication expression (DBL Syntax: x * y)
	 * @param expr represents DBL Multiplication expression
	 * @return C++-string representation of DBL Multiplication expression
	 */
	protected def dispatch String genExpr(Mul expr) {
		'''«expr.genBinaryExpr("*")»'''
	}
	/**
	 * generates C++-string representation of DBL Division expression (DBL Syntax: x / y)
	 * @param expr represents DBL Division expression
	 * @return C++-string representation of DBL Division expression
	 */
	protected def dispatch String genExpr(Div expr) {
		'''«expr.genBinaryExpr("/")»'''
	}
	/**
	 * generates C++-string representation of Modulo expression (DBL Syntax: x % y)
	 * @param expr represents DBL Modulo expression
	 * @return C++-string representation of DBL Modulo expression
	 */
	protected def dispatch String genExpr(Mod expr) {
		'''«expr.genBinaryExpr("%")»'''
	}
	/**
	 * generates C++-string representation of DBL Binary operator expressions. All expressions 
	 * are surrounded by parentheses according to the DBL-To-Java-Specification.
	 * @param expr represents DBL Binary Operator
	 * @param op represents Operator as String
	 * @return C++-string representation of DBL Binary operator in parentheses
	 */
	protected def String genBinaryExpr(BinaryOperator expr, String op) {
		'''(«expr.op1.genExpr» «op» «expr.op2.genExpr»)'''
	}
	/**
	 * generates C++-string representation of DBL Negation expression (DBL Syntax: -x)
	 * @param expr represents DBL Negation expression
	 * @return C++-string representation of DBL Negation expression
	 */
	protected def dispatch String genExpr(Neg expr) {
		'''(-«expr.op.genExpr»)'''
	}
	/**
	 * generates C++-string representation of DBL logical not expression (DBL Syntax: !x)
	 * @param expr represents DBL logical not expression
	 * @return C++-string representation of DBL logical not expression
	 */
	protected def dispatch String genExpr(Not expr) {
		'''(!«expr.op.genExpr»)'''
	}
	/**
	 * generates c++-string representation of DBL cast expression (DBL Syntax: x as A). Explicit Casts 
	 * between related class types are done via specific static_pointer_cast for intrusive-pointers and 
	 * explicit casts between primitive types via static_cast. Casts between Array types are done by creating 
	 * new arrays and there is one edge case when casting with new generated arrays.
	 * @param expr represents DBL cast expression
	 * @return C++-string representation of DBL cast expression
	 */
	protected def dispatch String genExpr(Cast expr) {
		val it = expr
		if(expr.classifierType !== null && typeArrayDimensions.empty)
			'''(cbsLib::static_pointer_cast<«genPrimitiveOrClassType(false)»>(«op.genInitialValue(null)»))'''
		else if(!typeArrayDimensions.empty && op instanceof CreateObject)
			'''«genVectorDefinition(op as CreateObject,expr)»'''
		else if(!typeArrayDimensions.empty)
			'''new «genVectorType(typeArrayDimensions.size)»(*(«op.genInitialValue(null)»))'''
		else
			'''(static_cast<«genType»>(«op.genInitialValue(null)»))'''
	}
	/**
	 * generates C++-string representation of DBL Instanceof expression (DBL Syntax: x instanceof A). There 
	 * is no Instanceof operator in C++. So this is done by checking the class hierarchy via dynamic_pointer_
	 * cast. If a cast could be performed the result is unequal nullptr.
	 * @param expr represents DBL Instanceof expression
	 * @return C++-string representation of DBL Instanceof expression
	 */
	protected def dispatch String genExpr(InstanceOf expr) {
		'''(cbsLib::dynamic_pointer_cast<«expr.op2.genExpr»>(«expr.op1.genExpr») != nullptr)'''
	}
	/**
	 * generates C++-string representation of DBL Integer literal (DBL Syntax: e.g. 15)
	 * @param expr represents DBL Integer Literal
	 * @return C++-string representation of DBL Integer Literal
	 */
	protected def dispatch String genExpr(IntLiteral expr) {
		'''«expr.value.toString»'''
	}
	/**
	 * generates C++-string representation of DBL True Literal (DBL Syntax: true)
	 * @param expr represents DBL True Literal
	 * @return C++-string representation of DBL True Literal
	 */
	protected def dispatch String genExpr(TrueLiteral expr) {
		'''true'''
	}
	/**
	 * generates C++-string representation of DBL False Literal (DBL Syntax: false)
	 * @param expr represents DBL False Literal
	 * @return C++-string representation of DBL False Literal
	 */
	protected def dispatch String genExpr(FalseLiteral expr) {
		'''false'''
	}
	/**
	 * generates C++-string representation of DBL Double Literal (DBL Syntax: e.g. 5.546)
	 * @param expr represents DBL Double Literal
	 * @return C++-string representation of DBL Double Literal
	 */
	protected def dispatch String genExpr(DoubleLiteral expr) {
		'''«expr.value.toString»'''
	}
	/**
	 * generates C++-string representation of DBL Null Literal (DBL Syntax: null)
	 * @param expr represents DBL Null Literal
	 * @return C++-string representation of DBL Null Literal
	 */
	protected def dispatch String genExpr(NullLiteral expr) {
		'''nullptr'''
	}
	/**
	 * generates C++-string representation of DBL String Literal (DBL Syntax: e.g. "example")
	 * @param expr represents DBL String Literal
	 * @return C++-string representation of DBL String Literal
	 */
	protected def dispatch String genExpr(StringLiteral expr) {
		'''«quoteCString(expr.value)»'''
	}
	/**
	 * replacement of carriage returns and newline feeds according to the DBL->Java specifications
	 * @param s value of StringLiteral
	 * @return string representation of DBL String Literal after replacements
	 */
	private def String quoteCString(String s){
		if (s.contains('\r\n')) '''"«s.replaceAll('\r\n', '\\\\r\\\\n"+\r\n"')»"'''
		else '''"«s.replaceAll('\n','\\\\r\\\\n"+\r\n"')»"'''
	}
	/**
	 * generates C++-string representation for creating of dynamically allocated objects (DBL Syntax: e.g. new Type(value)). 
	 * Reference Types (array type and class type) are managed by intrusive pointer and are therefore
	 * created on heap. All other types (Integer, Double, Boolean) have value semantics and cannot be created on 
	 * heap! Special Case String as Reference Type cannot be created with new operator, but using string constants.
	 * @param expr represents DBL new expression
	 * @return C++-string representation for new Expression
	 */
	protected def dispatch String genExpr(CreateObject expr) {
		val it = expr
		if (typeArrayDimensions.empty && classifierType !== null)
			'''new «genPrimitiveOrClassType(false)»(«classifierType?.callPart?.callArguments?.genActualParameters»)'''
		else if(!typeArrayDimensions.empty) 
			'''«genVectorDefinition(null)»'''
		else 
			'''<!primitive types cannot not be created on Heap!>'''
	}
	/**
	 * generates C++-string representation of TypeAccess (used for example when generating
	 * Instanceof expressions)
	 * @param expr represents DBL TypeAccess
	 * @return C++-string representation of DBL TypeAccess
	 */
	protected def dispatch String genExpr(TypeAccess expr) {
		'''«expr.idExpr.genExpr»'''
	}
	/**
	 * generates C++-string representation for VariableAccess (used for example when generating
	 * DBL switch statements)
	 * @param expr represents DBL VariableAccess
	 * @return C++-string representation of DBL VariableAccess
	 */
	protected def dispatch String genExpr(VariableAccess expr) {
		'''«expr.idExpr.genExpr»'''
	}
	/**
	 * generates C++-string representation of Identifier expressions (every usage of an identifier e.g.: 
	 * variable, parameter names or function calls)
	 * @param idExpr represents DBL Identifier expression
	 * @return C++-string representation of DBL Identifier expression
	 */
	protected def dispatch String genExpr(IdExpr idExpr) {
		idExpr.genIdExpr
	}
	/**
	 * generates C++-string representation for DBL Identifier expressions. Identifier in coroutines have to be
	 * mapped differently, so if the statement belongs to a coroutine, genSpecialIdExpression() function is 
	 * called for details @see genSpecialIdExpression() in Specific generator. 
	 * if array size expression is used, a cast to Integer is performed to support arithmetic operations 
	 * with the size.
	 * @param idExpr represents DBL Identifier expression
	 * @return C++-string representation of DBL Identifier expressions
	 */
	protected def String genIdExpr(IdExpr idExpr){
		val it = idExpr
		val boolean inActionsBlock = isInActionsBlock()
		if(predefinedId instanceof SizeOfArray)
			'''(static_cast<int>(«genIdExprPassive»))'''
		else
			'''«IF inActionsBlock»«genSpecialIdExpression»«ELSE»«genIdExprPassive»«ENDIF»'''
	}
	/**
	 * generates C++-string representation of regular DBL Identifier expressions. IdExpressions could 
	 * consist of several Identifiers for example: a.b.c. In that case generation starts with generating 
	 * a, then parentIdExpr b and finishes that with IdExpr c to build identifiers correctly with correct
	 * accessing members via "::" or "->". IdExpressions are distinguished between referenced Elements and 
	 * predefined elements which is handled differently.
	 * @param idExpr represents DBL Identifier 
	 * @return C++-string representation of DBL-Identifier expressions
	 */
	protected def String genIdExprPassive(IdExpr idExpr){
		val it = idExpr
		'''
			«IF parentIdExpr !== null»
				«IF (parentIdExpr.predefinedId instanceof SuperLiteral || 
					parentIdExpr.referencedElement instanceof Class)» 
					«parentIdExpr.genIdExpr»::
				«ELSE»
					«parentIdExpr.genIdExpr»->
				«ENDIF»
			«ENDIF»
			«IF referencedElement !== null»
				«genIdExpr_for_ReferencedElement(referencedElement)» 
			«ELSE»
				«genIdExpr_for_PredefinedId(predefinedId)»
			«ENDIF»
		'''
	}
	/**
	 * generates C++-string representation of DBL referenced Elements in IdExpressions
	 * @param idExpr represents DBL Identifier expression
	 * @param referencedElement represents DBL NamedElement (name of the identifier, connected to the actual object)
	 * @return C++-string representation of DBL referenced Elements in IdExpressions
	 */
	protected def String genIdExpr_for_ReferencedElement(IdExpr idExpr, NamedElement referencedElement) {
		val it = idExpr
		'''«referencedElement.genQualifiedName» «genCallArgumentsAndArrayIndex»'''
	}
	/**
	 * generates c++-string representation for IdExpressions with array access or function call
	 * e.g. f(3,5) or a[23]
	 * @param idExpr represents DBL Identifier expression
	 * @return C++-string representation of DBL IdExpressions with array access or function call
	 */
	protected def String genCallArgumentsAndArrayIndex(IdExpr idExpr){
		val it = idExpr
		'''
			«IF callPart !== null»(«callPart.getCallArguments.genActualParameters»)«ENDIF»
			«FOR index:idExpr?.arrayIndex»->operator[](«index.genExpr»)«ENDFOR»
		'''
	}
	/**
	 * generates C++-string representation of undefined DBL identifiers
	 * @param idExpr represents DBL Identifier expression
	 * @param predefinedId represents DBL predefined identifier
	 * @return C++ string representation for unknown predefined identifier
	 */
	protected def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, PredefinedId predefinedId) {
		'<! unsupported PredefinedId !>'
	}
	/**
	 * generates C++-string representation of DBL Me Literal (keyword: self). In general self is mapped on this
	 * in C++, but there is one special case, when using self in constructor. To handle the correct behavior in that 
	 * case a variable self is provided in constructors.
	 * @param idExpr represents DBL Identifier expression
	 * @param predefinedId represents DBL MeLiteral
	 * @return C++-string representation of MeLiteral
	 */
	protected def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, MeLiteral predefinedId) { 
		if(idExpr.inConstructor) {
			setWeakPtrInConstructor(true); 
			'''self'''
		}
		else '''this'''
	}
	/**
	 * this helper function checks if self is used in a constructor. In that case a local variable self 
	 * is defined in that constructor to handle problems with the reference counting.
	 * @param t represents DBL Identifier expression
	 * @return checks if self is used in a constructor
	 */
	private def boolean inConstructor(IdExpr t){
		var eCont = t.eContainer;
		while((!(eCont instanceof Class) || !(eCont instanceof Module)) && eCont !== null){
			if(eCont instanceof Constructor) return true
			else eCont = eCont?.eContainer;
		}
		return false
	}
	/**
	 * generates C++-string representation of DBL Super Literal (keyword: super). Its mapped like 
	 * a direct access on members of the base class.
	 * @param idExpr represents DBL Identifier expression
	 * @param predefinedId represents DBL Super Literal
	 * @return C++-string representation of Super Literal
	 */
	protected def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SuperLiteral predefinedId) {
		'''«currentClass.getSuperClasses.get(0).getClass_.genPreciseName»'''
	}
	/**
	 * generates C++-string representation of DBL SizeOfArray (keyword: length)
	 * @param idExpr represents DBL Identifier expression
	 * @param predefinedId represents DBL SizeOfArray
	 * @return C++-string representation of SizeOfArray
	 */
	protected def dispatch String genIdExpr_for_PredefinedId(IdExpr idExpr, SizeOfArray predefinedId) {
		'''size()'''
	}
	/**
	 * generates C++-String representation of DBL TypedElement (primitive types (Integer, double, boolean) and 
	 * reference types (String, Class type, Array Type)). Vectors and other types are handled separately, because 
	 * vector type is more complex, because it contains more type information.
	 * @param typedElement represents DBL TypedElement
	 * @return C++-String representation of DBL TypedElement
	 */
	protected def dispatch String genType(TypedElement typedElement) {
		val it = typedElement
		if(!typeArrayDimensions.empty) 
			includeStrings.addAll('''#include "../../../C++-Libraries/referenceSemantics/vectorExtension.h"''','''#include "../../../C++-Libraries/referenceSemantics/intrusive_ptr.h"''')
		if(classifierType !== null)	
			includeStrings.add('''#include "../../../C++-Libraries/referenceSemantics/intrusive_ptr.h"''')
		'''
			«IF !typeArrayDimensions.empty»
				«genIntrusiveVectorType»
			«ELSE»
				«genPrimitiveOrClassType(true)»
			«ENDIF»
		'''
	}
	/**
	 * generates C++-String representation of DBL TypedElement (primitive types (Integer, double, boolean) and 
	 * reference types (String, Class type, Array Type)). Here class types and primitive types are handled. 
	 * Mostly reference types have to be wrapped by intrusive pointer. In new expressions the type has to be 
	 * created without intrusive pointer wrapper.
	 * @param typedElement represents DBL TypedElement
	 * @return C++-String representation of DBL TypedElement (class type or primitive type)
	 */
	protected def genPrimitiveOrClassType(TypedElement typedElement, boolean needsIntrusiveWrapper){
		val it = typedElement
		'''
			«IF classifierType !== null && needsIntrusiveWrapper»
				cbsLib::intrusive_ptr<«classifierType.referencedElement.genType»>
			«ELSEIF classifierType !== null»
				«classifierType.referencedElement.genType»
			«ELSEIF primitiveType !== null»
				«primitiveType.genType»
			«ENDIF»
		'''
	}
	/**
	 * generates vector declaration type to simulate DBL Arrays. Multidimensional Arrays are represented 
	 * by vectors in vectors. This declaration wraps the vector in an intrusive pointer object.
	 * @param t represents DBL Array Type
	 * @return C++-string representation of DBL array type
	 */
	protected def String genIntrusiveVectorType(TypedElement t){
		val it = t
		'''cbsLib::intrusive_ptr<«genVectorType(typeArrayDimensions.size)»>'''
	}
	/**
	 * generates vector definition. If the type of the rvalue array expression does not match 
	 * with type of lvalue array expression. The created array has to take over the type of the 
	 * lvalue expression to have similar behavior like in Java. (So inserted objects are statically 
	 * typed with base class type, but virtual functions could be used to see behavior of derived 
	 * class types)
	 * @param expr represents the new expression for generating the DBL Array
	 * @param otherType array type of the lvalue expression 
	 * @return C++-string representation of C++-vector definition
	 */
	protected def String genVectorDefinition(CreateObject expr, TypedElement otherType){
		includeStrings.add('''#include "../../../C++-Libraries/referenceSemantics/vectorExtension.h"''')
		val it = expr
		if(otherType !== null)
			'''new «otherType.genVectorType(typeArrayDimensions.size)» «initializeVectors(typeArrayDimensions.size,it,otherType)»'''
		else
			'''new «genVectorType(typeArrayDimensions.size)» «initializeVectors(typeArrayDimensions.size,it,null)»'''
	}
	/**
	 * this helper function generates vector declaration type dependent on the passed 
	 * array dimensions. 
	 * @param t represents DBL TypedElement of Array type
	 * @param dim count of dimensions
	 * @return C++-string representation of a vector declaration type (representing DBL array)
	 */
	protected def String genVectorType(TypedElement t, int dim){
		'''«FOR d:dim >..1»cbsLib::myVector<cbsLib::intrusive_ptr<«ENDFOR»
				cbsLib::myVector<«t.genPrimitiveOrClassType(true)»>
		   «FOR d:dim >..1»>>«ENDFOR»
		'''
	}
	/**
	 * recursive function to generate multidimensional vectors. A vector is generated in the way that 
	 * it creates nested vectors for simulating multidimensional arrays in DBL. This is done be calling 
	 * the constructors of vectors by decreasing the number of dimensions with every nested vector object.
	 * @param dim count of vector dimensions
	 * @param expr represents the new expression to initialize the DBL array
	 * @param otherType represents the DBL type of the created vector
	 * @return C++-string representation of the creation of vector representing DBL array
	 */
	private def String initializeVectors(int dim, CreateObject expr, TypedElement otherType){
		val it = expr
		val index = typeArrayDimensions.size - dim;
		val String dimSuccSize = if((index < typeArrayDimensions.size-1) && typeArrayDimensions.get(index+1).size !== null) '''«typeArrayDimensions.get(index).size.genExpr»''' else null
		val String dimSize = '''«typeArrayDimensions.get(index).size.genExpr»''' 
		'''
		«IF dim == 1»(«dimSize»)
		«ELSEIF otherType !== null» 
			«handleEdgeCaseWithInnerVectorDimensions(dimSize,dimSuccSize,'''«otherType.genVectorType(dim-1)» «initializeVectors(dim-1,it,otherType)»''')»
		«ELSE»
			«handleEdgeCaseWithInnerVectorDimensions(dimSize,dimSuccSize,'''«genVectorType(dim-1)» «initializeVectors(dim-1,it,null)»''')»
		«ENDIF»
		'''
	}
	/**
	 * inner vectors should not be created when the dimensions are empty, in that case the vector object
	 * is initialized with null pointers instead, otherwise its generated by copying the content of the 
	 * inner vectors.
	 * @param dimSize string representation of the dimension size
	 * @param dimSuccSize string representation of the next dimension (is null if its empty)
	 * @param vectorContent represents the content of the vector
	 * @return C++-string representation for the initialization of outer vectors
	 */
	private def String handleEdgeCaseWithInnerVectorDimensions(String dimSize, String dimSuccSize, String vectorContent){
		'''
			«IF dimSuccSize === null»
				(«dimSize», nullptr) 
			«ELSE»
				(«dimSize», new «vectorContent») 
			«ENDIF»
		'''
	}
	/**
	 * generates C++-string representation of unknown DBL Type
	 * @param type represents unknown DBL Type
	 * @return C++-string representation of unknown DBL type
	 */
	protected def dispatch String genType(Type type) {
		'<! unknown type ' + type.eClass.name + ' !>'
	}
	/**
	 * generates C++-string representation of DBL Class Type
	 * @param type represents DBL Class Type
	 * @return C++-string representation of DBL Class type
	 */
	protected def dispatch String genType(Class type) {
		type.genQualifiedName
	}
	/**
	 * generates C++-string representation of DBL Integer Type
	 * @param type represents DBL Integer Type
	 * @return C++-string representation of DBL Integer Type
	 */
	protected def dispatch String genType(IntType type) {
		'int'
	}
	/**
	 * generates C++-string representation of DBL Void Type (Void Type should only be used to declare procedures)
	 * @param type represents DBL Void Type
	 * @return C++-string representation of DBL Void Type
	 */
	protected def dispatch String genType(VoidType type) {
		'void'
	}
	/**
	 * generates C++-string representation of DBL String Type (String Type is a Reference Type so intrusive 
	 * pointer concept is required and included)
	 * @param type represents DBL String Type
	 * @return C++-string representation of DBL String Type
	 */
	protected def dispatch String genType(StringType type) {
		includeStrings.addAll('''#include "../../../C++-Libraries/referenceSemantics/intrusive_ptr.h"''','''#include "../../../C++-Libraries/referenceSemantics/RefStringType.h"''')
		'stringPtr'
	}
	/**
	 * generates C++-string representation of DBL Boolean Type (DBL Syntax: boolean value = true;)
	 * @param type represents DBL Boolean Type
	 * @return C++-string representation of DBL Boolean Type
	 */
	protected def dispatch String genType(BoolType type) {
		'bool'
	}
	/**
	 * generates C++-string representation of DBL Double Type
	 * @param type represents DBL Double Type
	 * @return C++-string representation of DBL Double Type
	 */
	protected def dispatch String genType(DoubleType type) {
		'double'
	}	
	/**
	 * generates C++-string representation of qualified name access. If the element belongs to a module 
	 * (global data) the module must be included and the element is accessed via the namespace. If there 
	 * are nested element accesses, all accessed types have to be included.
	 * @param element NamedElement that should be accessed e.g. function or variable
	 * @return C++-string representation of qualified name access
	 */
	protected def String genQualifiedName_for_ProcedureVariableAccess(NamedElement element) {
		val it = element
		/*  if there is a transitive access of objects, all respective classes have to be included (for example:
		*	there is an object of class type A and A has member of class type B and B has member of class type C 
		*	then there could be an element access like A a = new A() and a accesses object c like a->b->c. Then in 
		*  	a.cpp implementation file classes b and c have to be included automatically.
		*/
		// type must be generated, so that correct includes can be made
		if(element instanceof TypedElement) genType
		if(eContainer instanceof Module) {
			val module = eContainer as Module
			includes.add(module)
			module.genPreciseName+"::"+genPreciseName
		}
		else genPreciseName
	}
	/**
	 * generates C++-string representation of qualified name access for function calls
	 * @param element Function that should be called
	 * @return C++-string representation of qualified name access for function calls
	 */
	protected def dispatch String genQualifiedName(Function element) {
		element.genQualifiedName_for_ProcedureVariableAccess
	}
	/**
	 * generates C++-string representation of qualified name access for variable usage
	 * @param element AbstractVariable that should be accessed
	 * @return C++-string representation of qualified name access for variable usage
	 */
	protected def dispatch String genQualifiedName(AbstractVariable element) {
		element.genQualifiedName_for_ProcedureVariableAccess
	}
	/**
	 * generates C++-string representation of qualified name for Class Types. Class types belong 
	 * to modules so they are accessed via the corresponding namespace. Bounded classes are handled 
	 * separately.
	 * @param element Class type that is used
	 * @return C++-string representation of qualified name for Class Types
	 */
	protected def dispatch String genQualifiedName(Class element) {
		val it = element
		val module = eContainer as Module
		includes.add(element)
		if (bindings.empty) return module.genPreciseName+"::"+element.genPreciseName
		else genBoundType(true)
	}
	/**
	 * generates C++-string representation of bounded DBL Class Type
	 * @param element bounded Class
	 * @param extractType boolean flag that signals, if the type information has to be extracted from path
	 * @return C++-string representation of bounded DBL Class Type
	 */
	protected def String genBoundType(Class element, boolean extractType){
		val it = element
		var targetType = getBindings.findFirst[targetLanguage == simLibName]?.targetType
		if (targetType !== null) targetType.genMappedClassType(extractType)
		else {
			targetType = bindings.findFirst[targetLanguage == languageName]?.targetType
			if (targetType !== null) targetType.genMappedClassType(extractType)
			else '<!- type binding for library ' + simLibName + ' is missing for type ' + name + ' !>'
		}		
	}
	/**
	 * generates C++-string representation of bounded DBL Class Type. There is a difference between 
	 * including the class (full path is needed) or usage as class type (extracted type from path).
	 * @param targetType bounded Class Type (full path e.g. simulationCore/Process)
	 * @param extractType boolean flag that signals, if the type information has to be extracted from path
	 * @return C++-string representation of bounded DBL Class Type
	 */
	private def String genMappedClassType(String targetType, boolean extractType){
		if(extractType) return targetType.splitMappedClassName
		else return targetType
	}
	/**
	 * splits the string at "\" symbol to extract the class type from path information
	 * @param i bounded Class Type (full path e.g. simulationCore\Process)
	 * @return C++-string representation of extracted bounded DBL Class Type
	 */
	private def String splitMappedClassName(String i){
		return i.substring(i.lastIndexOf('/')+1,i.length)
	}
	/**
	 * generates C++ makefile to ease and manage C++-compiling. Unfortunately the Boost-Library 
	 * has to be included to use variant type. But that could be removed after C++-17 standard 
	 * has be released.
	 */
	protected def void genMakeFile(){
		val Writer makefile = beginTargetFile(cPackageFolder, "makefile");
		var int count = 0;
		
		var List<Module> setModules = newArrayList()
		for (m:allModules) {
			val Module module = allModules.findLast[name == m.name]
			if(!setModules.exists[name == m.name]) setModules.add(module)
		}
		makefile.write(
			'''
			CC = g++
			CFLAGS = -std=c++14 -O2 -Wall -pedantic -Wno-unused-label -I "../../C++-Libraries/boost"  
			«FOR m:setModules»
				SRCS«count++» = ../gen/«m.genPreciseName»/«m.genPreciseName».cpp «m.genClassPaths»
			«ENDFOR»
			«addSimulationCoreToMakeFile(count)»
				
			my_program: «genSRCS(count)»«genSRCSSimulation(count)»
				$(CC) $(CFLAGS) -o my_program «genSRCS(count)» «genSRCSSimulation(count)» Main.cpp 
				
			.PHONY: clean
			clean: 
				$(RM) count *.o *~ my_program
			'''
		);
		endTargetFile(makefile);
	}
	/**
	 * generates class paths and eliminates multiple class entries with same name ( thats a problem 
	 * that should be handled by the DBL editor, that there shouldn't be classes with same names in the 
	 * same module) 
	 * @param m Module which contains the classes
	 * @return C++-string representation of all C++-Class Paths for the makefile
	 */
	private def String genClassPaths(Module m) {
		'''
			«FOR c:m.genClassSet.filter[getBindings.empty]» ../gen/«m.genPreciseName»/«c.genPreciseName».cpp«ENDFOR»
		'''
	}
	/**
	 * returns a valid class set where, if there are some duplicates, they are removed and only the last element is 
	 * saved. This functionality should be given by the DBL Editor to detect multiple definition of classes in 
	 * the same module and throw some errors.
	 * @param m Module which contain the classes
	 * @return set of classes
	 */
	private def List<Class> genClassSet(Module m){
		var List<Class> setClasses = newArrayList()
		for (c:m.getClasses) {
			val Class clazz = m.getClasses.findLast[name == c.name]
			if(!setClasses.exists[name == c.name]) setClasses.add(clazz)
		}
		return setClasses
	}
	/**
	 * helper function for generating makefile macros
	 * @param count counter for SRCS variables in makefile
	 * @return C++-string representation of makefile macros
	 */
	private def String genSRCS(int count) {
		var String result = "";
		for(var int i = 0; i < count; i++) result += '''$(SRCS«i»)'''
		return result;
	}
	
	/////
	// Extension specific code
	/////
	
	/**
	 * This function is used to generate string representation for extension elements, which are used 
	 * in defining language extensions.
	 * @param element used Extension element
	 * @return C++-string representation of extension elements
	 */
	protected def dispatch String genQualifiedName(Extension element) {
		val it = element
		val module = eContainer as Module
		return module.genPreciseName+"::"+element.genPreciseName
	}
	/**
	 * Expansion Statements should only be used in extension semantics
	 * @param stm ExpansionStatement
	 * @return string error when expand is not correctly used
	 */
	protected def dispatch String genStatement(ExpansionStatement stm) {
		'''<!-- expand is not allowed outside extension semantics definitions -->'''
	}
	/**
	 * Unknown expansion parts are forbidden
	 * @param part ExpansionPart
	 * @return string error when expansion part is unknown
	 */
	protected def dispatch String genMappingPart(ExpansionPart part) {
		'< unknown mapping part >'
	}
	/**
	 * creates C++-string representation of ExpandTextPart
	 * @param part ExpandTextPart that has to be replaced
	 * @return C++-string representation of the ExpandTextPart
	 */
	protected def dispatch String genMappingPart(ExpandTextPart part) {
		quoteCString(part.text)
	}
	/**
	 * C++-string representation of the ExpandVariablePart expression
	 * @param part ExpandVariablePart expression that has to be created
	 * @return C++-string representation for the ExpandVariablePart expression
	 */
	protected def dispatch String genMappingPart(ExpandVariablePart part) {
		part.expr.genExpr
	}
	/**
	 * only needed for DBL extensions
	 * @param idExpr represents DBL Identifier expressions
	 * @param referencedElement represents DBL SymbolReference in grammar
	 * @return C++-string representation of DBL Identifier expressions used in extensions
	 */
	protected def String genIdExpr_for_ReferencedElement(IdExpr idExpr, StructuralSymbolReference referencedElement) {
		idExpr.genIdExpr_for_PropertyBindingExpr(referencedElement)
	}
	/**
	 * only needed for DBL extensions
	 * @param idExpr represents DBL Identifier expressions
	 * @param referencedElement represents DBL SymbolReference in grammar
	 * @return C++-string representation of DBL Identifier expressions used in extensions
	 */
	protected def String genIdExpr_for_PropertyBindingExpr(IdExpr idExpr, StructuralSymbolReference referencedElement) {}
	/**
	 * generates C++-string representation for SyntaxSymbolClassifier
	 * @param symbolClassifier represents SyntaxSymbolClassifier
	 * @return C++-string representation for SyntaxSymbolClassifier
	 */
	protected def dispatch String genType(SyntaxSymbolClassifier symbolClassifier) {
		symbolClassifier.genPreciseName
	}
	
	/////
	// Special Functions which are only used in simulation context (definitions only needed in derived class), 
	// because its not possible to call dispatch methods of super class within an overridden dispatch method in 
	// derived class 
	/////
	protected def String genSpecialIdExpression(IdExpr idExpr){}
	protected def String genSpecialReturnStatementForSchedulingFunction(Return stm){}
	protected def String genSpecialIfStatement(IfStatement stm){}
	protected def String genSpecialForStatement(ForStatement stm){}
	protected def String genSpecialContinueStatement(ContinueStatement stm){}
	protected def String genSpecialWhileStatement(WhileStatement stm){}
	protected def String genSpecialSwitchStatement(SwitchStatement stm){}
	protected def String genSpecialBreakStatement(BreakStatement stm){}
	protected def String genMainProcess(Module module, boolean isHeader){}
	protected def boolean isInActionsBlock(){return false}
	protected def String genActionsBlockVariable(Variable variable){}
	protected def String genLifecycle(Class clazz, boolean isHeader) {}
	protected def String addSimulationCoreToMakeFile(int count){}
	protected def String genSRCSSimulation(int count) {}	
	protected def void genVariantTypeReturnInSeparateFile(){}
}