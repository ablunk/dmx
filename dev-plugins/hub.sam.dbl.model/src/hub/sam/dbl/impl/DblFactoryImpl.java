/**
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.ActivateObject;
import hub.sam.dbl.ActiveClass;
import hub.sam.dbl.Advance;
import hub.sam.dbl.And;
import hub.sam.dbl.AnnotateableElement;
import hub.sam.dbl.Annotation;
import hub.sam.dbl.AnnotationItem;
import hub.sam.dbl.AnnotationLiteral;
import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.Assignment;
import hub.sam.dbl.BoolType;
import hub.sam.dbl.BreakStatement;
import hub.sam.dbl.CallPart;
import hub.sam.dbl.Cast;
import hub.sam.dbl.ClassContentExtension;
import hub.sam.dbl.CodeQuoteExpression;
import hub.sam.dbl.ComplexSymbol;
import hub.sam.dbl.Concept;
import hub.sam.dbl.Construct;
import hub.sam.dbl.ConstructiveExtension;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.ContinueStatement;
import hub.sam.dbl.CreateIdStatement;
import hub.sam.dbl.CreateObject;
import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Div;
import hub.sam.dbl.DoubleLiteral;
import hub.sam.dbl.DoubleType;
import hub.sam.dbl.Equal;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.ExpandExpression;
import hub.sam.dbl.ExpandStatement;
import hub.sam.dbl.ExpandTextPart;
import hub.sam.dbl.ExpandVariablePart;
import hub.sam.dbl.ExpansionStatement;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionSemantics;
import hub.sam.dbl.FalseLiteral;
import hub.sam.dbl.ForStatement;
import hub.sam.dbl.Function;
import hub.sam.dbl.FunctionCall;
import hub.sam.dbl.Greater;
import hub.sam.dbl.GreaterEqual;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.IdSymbol;
import hub.sam.dbl.IfStatement;
import hub.sam.dbl.Import;
import hub.sam.dbl.InstanceOf;
import hub.sam.dbl.IntLiteral;
import hub.sam.dbl.IntSymbol;
import hub.sam.dbl.IntType;
import hub.sam.dbl.Keyword;
import hub.sam.dbl.L1Expr;
import hub.sam.dbl.L1SyntaxExpression;
import hub.sam.dbl.L2Expr;
import hub.sam.dbl.L2SyntaxExpression;
import hub.sam.dbl.L3Expr;
import hub.sam.dbl.L3SyntaxExpression;
import hub.sam.dbl.L4Expr;
import hub.sam.dbl.L5Expr;
import hub.sam.dbl.L6Expr;
import hub.sam.dbl.L7Expr;
import hub.sam.dbl.L8Expr;
import hub.sam.dbl.L9Expr;
import hub.sam.dbl.Less;
import hub.sam.dbl.LessEqual;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.LocalScopeStatement;
import hub.sam.dbl.LoopStatement;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.MetaAccess;
import hub.sam.dbl.MetaExpr;
import hub.sam.dbl.MetaLiteral;
import hub.sam.dbl.MetaSymbol;
import hub.sam.dbl.Minus;
import hub.sam.dbl.Mod;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.ModuleContentExtension;
import hub.sam.dbl.Mul;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NativeBinding;
import hub.sam.dbl.Neg;
import hub.sam.dbl.Not;
import hub.sam.dbl.NotEqual;
import hub.sam.dbl.NullLiteral;
import hub.sam.dbl.Or;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.ParseExpr;
import hub.sam.dbl.Pattern;
import hub.sam.dbl.PlainSymbolReference;
import hub.sam.dbl.Plus;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.Print;
import hub.sam.dbl.QuotedClassContent;
import hub.sam.dbl.QuotedCode;
import hub.sam.dbl.QuotedExpression;
import hub.sam.dbl.QuotedModuleContent;
import hub.sam.dbl.QuotedStatements;
import hub.sam.dbl.Reactivate;
import hub.sam.dbl.Return;
import hub.sam.dbl.SimpleStatement;
import hub.sam.dbl.SizeOfArray;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StringLiteral;
import hub.sam.dbl.StringSymbol;
import hub.sam.dbl.StringType;
import hub.sam.dbl.StructuralSymbolReference;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.SuperObjectInitializer;
import hub.sam.dbl.SwitchCase;
import hub.sam.dbl.SwitchStatement;
import hub.sam.dbl.SymbolSequence;
import hub.sam.dbl.SyntaxDefinition;
import hub.sam.dbl.SyntaxExpression;
import hub.sam.dbl.SyntaxSymbolClassifier;
import hub.sam.dbl.TargetStatement;
import hub.sam.dbl.TestStatement;
import hub.sam.dbl.TimeLiteral;
import hub.sam.dbl.TrueLiteral;
import hub.sam.dbl.TypeAccess;
import hub.sam.dbl.TypeLiteral;
import hub.sam.dbl.Variable;
import hub.sam.dbl.VariableAccess;
import hub.sam.dbl.VoidType;
import hub.sam.dbl.Wait;
import hub.sam.dbl.WaitUntil;
import hub.sam.dbl.WhileStatement;
import hub.sam.dbl.Yield;
import hub.sam.dbl.YieldTo;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import hub.sam.dbl.*;
import hub.sam.dbl.util.DblUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DblFactoryImpl extends EFactoryImpl implements DblFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DblFactory init() {
		try {
			DblFactory theDblFactory = (DblFactory)EPackage.Registry.INSTANCE.getEFactory(DblPackage.eNS_URI);
			if (theDblFactory != null) {
				return theDblFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DblFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DblFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DblPackage.CONSTRUCT: return (EObject)createConstruct();
			case DblPackage.EXTENSIBLE_ELEMENT: return (EObject)createExtensibleElement();
			case DblPackage.MODEL: return (EObject)createModel();
			case DblPackage.IMPORT: return (EObject)createImport();
			case DblPackage.MODULE: return (EObject)createModule();
			case DblPackage.ANNOTATION: return (EObject)createAnnotation();
			case DblPackage.ANNOTATION_ITEM: return (EObject)createAnnotationItem();
			case DblPackage.ANNOTATEABLE_ELEMENT: return (EObject)createAnnotateableElement();
			case DblPackage.CONSTRUCTIVE_EXTENSION: return (EObject)createConstructiveExtension();
			case DblPackage.MODULE_CONTENT_EXTENSION: return (EObject)createModuleContentExtension();
			case DblPackage.CLASS_CONTENT_EXTENSION: return (EObject)createClassContentExtension();
			case DblPackage.ARRAY_DIMENSION: return (EObject)createArrayDimension();
			case DblPackage.VOID_TYPE: return (EObject)createVoidType();
			case DblPackage.INT_TYPE: return (EObject)createIntType();
			case DblPackage.BOOL_TYPE: return (EObject)createBoolType();
			case DblPackage.DOUBLE_TYPE: return (EObject)createDoubleType();
			case DblPackage.STRING_TYPE: return (EObject)createStringType();
			case DblPackage.FUNCTION: return (EObject)createFunction();
			case DblPackage.NATIVE_BINDING: return (EObject)createNativeBinding();
			case DblPackage.CLASS: return (EObject)createClass();
			case DblPackage.CONSTRUCTOR: return (EObject)createConstructor();
			case DblPackage.VARIABLE: return (EObject)createVariable();
			case DblPackage.PARAMETER: return (EObject)createParameter();
			case DblPackage.NAMED_ELEMENT: return (EObject)createNamedElement();
			case DblPackage.STATEMENT: return (EObject)createStatement();
			case DblPackage.LOOP_STATEMENT: return (EObject)createLoopStatement();
			case DblPackage.SIMPLE_STATEMENT: return (EObject)createSimpleStatement();
			case DblPackage.ASSIGNMENT: return (EObject)createAssignment();
			case DblPackage.FUNCTION_CALL: return (EObject)createFunctionCall();
			case DblPackage.RETURN: return (EObject)createReturn();
			case DblPackage.WAIT_UNTIL: return (EObject)createWaitUntil();
			case DblPackage.YIELD: return (EObject)createYield();
			case DblPackage.YIELD_TO: return (EObject)createYieldTo();
			case DblPackage.WAIT: return (EObject)createWait();
			case DblPackage.REACTIVATE: return (EObject)createReactivate();
			case DblPackage.ACTIVATE_OBJECT: return (EObject)createActivateObject();
			case DblPackage.ADVANCE: return (EObject)createAdvance();
			case DblPackage.PRINT: return (EObject)createPrint();
			case DblPackage.IF_STATEMENT: return (EObject)createIfStatement();
			case DblPackage.LOCAL_SCOPE: return (EObject)createLocalScope();
			case DblPackage.LOCAL_SCOPE_STATEMENT: return (EObject)createLocalScopeStatement();
			case DblPackage.FOR_STATEMENT: return (EObject)createForStatement();
			case DblPackage.WHILE_STATEMENT: return (EObject)createWhileStatement();
			case DblPackage.SWITCH_STATEMENT: return (EObject)createSwitchStatement();
			case DblPackage.SWITCH_CASE: return (EObject)createSwitchCase();
			case DblPackage.BREAK_STATEMENT: return (EObject)createBreakStatement();
			case DblPackage.CONTINUE_STATEMENT: return (EObject)createContinueStatement();
			case DblPackage.EXPRESSION: return (EObject)createExpression();
			case DblPackage.L1_EXPR: return (EObject)createL1Expr();
			case DblPackage.L2_EXPR: return (EObject)createL2Expr();
			case DblPackage.L3_EXPR: return (EObject)createL3Expr();
			case DblPackage.L4_EXPR: return (EObject)createL4Expr();
			case DblPackage.L5_EXPR: return (EObject)createL5Expr();
			case DblPackage.L6_EXPR: return (EObject)createL6Expr();
			case DblPackage.L7_EXPR: return (EObject)createL7Expr();
			case DblPackage.L8_EXPR: return (EObject)createL8Expr();
			case DblPackage.L9_EXPR: return (EObject)createL9Expr();
			case DblPackage.OR: return (EObject)createOr();
			case DblPackage.AND: return (EObject)createAnd();
			case DblPackage.NOT_EQUAL: return (EObject)createNotEqual();
			case DblPackage.EQUAL: return (EObject)createEqual();
			case DblPackage.GREATER: return (EObject)createGreater();
			case DblPackage.GREATER_EQUAL: return (EObject)createGreaterEqual();
			case DblPackage.LESS: return (EObject)createLess();
			case DblPackage.LESS_EQUAL: return (EObject)createLessEqual();
			case DblPackage.INSTANCE_OF: return (EObject)createInstanceOf();
			case DblPackage.PLUS: return (EObject)createPlus();
			case DblPackage.MINUS: return (EObject)createMinus();
			case DblPackage.MUL: return (EObject)createMul();
			case DblPackage.MOD: return (EObject)createMod();
			case DblPackage.DIV: return (EObject)createDiv();
			case DblPackage.NEG: return (EObject)createNeg();
			case DblPackage.NOT: return (EObject)createNot();
			case DblPackage.CAST: return (EObject)createCast();
			case DblPackage.CREATE_OBJECT: return (EObject)createCreateObject();
			case DblPackage.NULL_LITERAL: return (EObject)createNullLiteral();
			case DblPackage.TIME_LITERAL: return (EObject)createTimeLiteral();
			case DblPackage.STRING_LITERAL: return (EObject)createStringLiteral();
			case DblPackage.INT_LITERAL: return (EObject)createIntLiteral();
			case DblPackage.TRUE_LITERAL: return (EObject)createTrueLiteral();
			case DblPackage.FALSE_LITERAL: return (EObject)createFalseLiteral();
			case DblPackage.DOUBLE_LITERAL: return (EObject)createDoubleLiteral();
			case DblPackage.EXPAND_EXPR: return (EObject)createExpandExpr();
			case DblPackage.PARSE_EXPR: return (EObject)createParseExpr();
			case DblPackage.PREDEFINED_ID: return (EObject)createPredefinedId();
			case DblPackage.ME_LITERAL: return (EObject)createMeLiteral();
			case DblPackage.SUPER_LITERAL: return (EObject)createSuperLiteral();
			case DblPackage.META_LITERAL: return (EObject)createMetaLiteral();
			case DblPackage.TYPE_LITERAL: return (EObject)createTypeLiteral();
			case DblPackage.SIZE_OF_ARRAY: return (EObject)createSizeOfArray();
			case DblPackage.ANNOTATION_LITERAL: return (EObject)createAnnotationLiteral();
			case DblPackage.ID_EXPR: return (EObject)createIdExpr();
			case DblPackage.CALL_PART: return (EObject)createCallPart();
			case DblPackage.VARIABLE_ACCESS: return (EObject)createVariableAccess();
			case DblPackage.META_ACCESS: return (EObject)createMetaAccess();
			case DblPackage.TYPE_ACCESS: return (EObject)createTypeAccess();
			case DblPackage.EXTENSION: return (EObject)createExtension();
			case DblPackage.EXTENSION_SEMANTICS: return (EObject)createExtensionSemantics();
			case DblPackage.SYNTAX_DEFINITION: return (EObject)createSyntaxDefinition();
			case DblPackage.SYNTAX_SYMBOL_CLASSIFIER: return (EObject)createSyntaxSymbolClassifier();
			case DblPackage.COMPLEX_SYMBOL: return (EObject)createComplexSymbol();
			case DblPackage.CONCEPT: return (EObject)createConcept();
			case DblPackage.META_SYMBOL: return (EObject)createMetaSymbol();
			case DblPackage.SYNTAX_EXPRESSION: return (EObject)createSyntaxExpression();
			case DblPackage.L3_SYNTAX_EXPRESSION: return (EObject)createL3SyntaxExpression();
			case DblPackage.L2_SYNTAX_EXPRESSION: return (EObject)createL2SyntaxExpression();
			case DblPackage.SYMBOL_SEQUENCE: return (EObject)createSymbolSequence();
			case DblPackage.L1_SYNTAX_EXPRESSION: return (EObject)createL1SyntaxExpression();
			case DblPackage.STRUCTURAL_SYMBOL_REFERENCE: return (EObject)createStructuralSymbolReference();
			case DblPackage.PLAIN_SYMBOL_REFERENCE: return (EObject)createPlainSymbolReference();
			case DblPackage.ID_SYMBOL: return (EObject)createIdSymbol();
			case DblPackage.INT_SYMBOL: return (EObject)createIntSymbol();
			case DblPackage.STRING_SYMBOL: return (EObject)createStringSymbol();
			case DblPackage.KEYWORD: return (EObject)createKeyword();
			case DblPackage.META_EXPR: return (EObject)createMetaExpr();
			case DblPackage.TARGET_STATEMENT: return (EObject)createTargetStatement();
			case DblPackage.CREATE_ID_STATEMENT: return (EObject)createCreateIdStatement();
			case DblPackage.EXPANSION_STATEMENT: return (EObject)createExpansionStatement();
			case DblPackage.EXPAND_TEXT_PART: return (EObject)createExpandTextPart();
			case DblPackage.EXPAND_VARIABLE_PART: return (EObject)createExpandVariablePart();
			case DblPackage.EXPAND_EXPRESSION: return (EObject)createExpandExpression();
			case DblPackage.EXPAND_STATEMENT: return (EObject)createExpandStatement();
			case DblPackage.CODE_QUOTE_EXPRESSION: return (EObject)createCodeQuoteExpression();
			case DblPackage.QUOTED_CODE: return (EObject)createQuotedCode();
			case DblPackage.QUOTED_EXPRESSION: return (EObject)createQuotedExpression();
			case DblPackage.QUOTED_STATEMENTS: return (EObject)createQuotedStatements();
			case DblPackage.QUOTED_CLASS_CONTENT: return (EObject)createQuotedClassContent();
			case DblPackage.QUOTED_MODULE_CONTENT: return (EObject)createQuotedModuleContent();
			case DblPackage.PATTERN: return (EObject)createPattern();
			case DblPackage.TEST_STATEMENT: return (EObject)createTestStatement();
			case DblPackage.SUPER_OBJECT_INITIALIZER: return (EObject)createSuperObjectInitializer();
			case DblPackage.ACTIVE_CLASS: return (EObject)createActiveClass();
			default:
				return DblUtil.createObjectOfParentClass(eClass);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Construct createConstruct() {
		ConstructImpl construct = new ConstructImpl();
		return construct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensibleElement createExtensibleElement() {
		ExtensibleElementImpl extensibleElement = new ExtensibleElementImpl();
		return extensibleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationItem createAnnotationItem() {
		AnnotationItemImpl annotationItem = new AnnotationItemImpl();
		return annotationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotateableElement createAnnotateableElement() {
		AnnotateableElementImpl annotateableElement = new AnnotateableElementImpl();
		return annotateableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructiveExtension createConstructiveExtension() {
		ConstructiveExtensionImpl constructiveExtension = new ConstructiveExtensionImpl();
		return constructiveExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleContentExtension createModuleContentExtension() {
		ModuleContentExtensionImpl moduleContentExtension = new ModuleContentExtensionImpl();
		return moduleContentExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassContentExtension createClassContentExtension() {
		ClassContentExtensionImpl classContentExtension = new ClassContentExtensionImpl();
		return classContentExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayDimension createArrayDimension() {
		ArrayDimensionImpl arrayDimension = new ArrayDimensionImpl();
		return arrayDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoidType createVoidType() {
		VoidTypeImpl voidType = new VoidTypeImpl();
		return voidType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntType createIntType() {
		IntTypeImpl intType = new IntTypeImpl();
		return intType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolType createBoolType() {
		BoolTypeImpl boolType = new BoolTypeImpl();
		return boolType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleType createDoubleType() {
		DoubleTypeImpl doubleType = new DoubleTypeImpl();
		return doubleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeBinding createNativeBinding() {
		NativeBindingImpl nativeBinding = new NativeBindingImpl();
		return nativeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public hub.sam.dbl.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveClass createActiveClass() {
		ActiveClassImpl activeClass = new ActiveClassImpl();
		return activeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constructor createConstructor() {
		ConstructorImpl constructor = new ConstructorImpl();
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperObjectInitializer createSuperObjectInitializer() {
		SuperObjectInitializerImpl superObjectInitializer = new SuperObjectInitializerImpl();
		return superObjectInitializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopStatement createLoopStatement() {
		LoopStatementImpl loopStatement = new LoopStatementImpl();
		return loopStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleStatement createSimpleStatement() {
		SimpleStatementImpl simpleStatement = new SimpleStatementImpl();
		return simpleStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall createFunctionCall() {
		FunctionCallImpl functionCall = new FunctionCallImpl();
		return functionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn() {
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitUntil createWaitUntil() {
		WaitUntilImpl waitUntil = new WaitUntilImpl();
		return waitUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Yield createYield() {
		YieldImpl yield = new YieldImpl();
		return yield;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YieldTo createYieldTo() {
		YieldToImpl yieldTo = new YieldToImpl();
		return yieldTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wait createWait() {
		WaitImpl wait = new WaitImpl();
		return wait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reactivate createReactivate() {
		ReactivateImpl reactivate = new ReactivateImpl();
		return reactivate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivateObject createActivateObject() {
		ActivateObjectImpl activateObject = new ActivateObjectImpl();
		return activateObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Advance createAdvance() {
		AdvanceImpl advance = new AdvanceImpl();
		return advance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Print createPrint() {
		PrintImpl print = new PrintImpl();
		return print;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalScope createLocalScope() {
		LocalScopeImpl localScope = new LocalScopeImpl();
		return localScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalScopeStatement createLocalScopeStatement() {
		LocalScopeStatementImpl localScopeStatement = new LocalScopeStatementImpl();
		return localScopeStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCase createSwitchCase() {
		SwitchCaseImpl switchCase = new SwitchCaseImpl();
		return switchCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinueStatement createContinueStatement() {
		ContinueStatementImpl continueStatement = new ContinueStatementImpl();
		return continueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L1Expr createL1Expr() {
		L1ExprImpl l1Expr = new L1ExprImpl();
		return l1Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2Expr createL2Expr() {
		L2ExprImpl l2Expr = new L2ExprImpl();
		return l2Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L3Expr createL3Expr() {
		L3ExprImpl l3Expr = new L3ExprImpl();
		return l3Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L4Expr createL4Expr() {
		L4ExprImpl l4Expr = new L4ExprImpl();
		return l4Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L5Expr createL5Expr() {
		L5ExprImpl l5Expr = new L5ExprImpl();
		return l5Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L6Expr createL6Expr() {
		L6ExprImpl l6Expr = new L6ExprImpl();
		return l6Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L7Expr createL7Expr() {
		L7ExprImpl l7Expr = new L7ExprImpl();
		return l7Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L8Expr createL8Expr() {
		L8ExprImpl l8Expr = new L8ExprImpl();
		return l8Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L9Expr createL9Expr() {
		L9ExprImpl l9Expr = new L9ExprImpl();
		return l9Expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotEqual createNotEqual() {
		NotEqualImpl notEqual = new NotEqualImpl();
		return notEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equal createEqual() {
		EqualImpl equal = new EqualImpl();
		return equal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Greater createGreater() {
		GreaterImpl greater = new GreaterImpl();
		return greater;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterEqual createGreaterEqual() {
		GreaterEqualImpl greaterEqual = new GreaterEqualImpl();
		return greaterEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Less createLess() {
		LessImpl less = new LessImpl();
		return less;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessEqual createLessEqual() {
		LessEqualImpl lessEqual = new LessEqualImpl();
		return lessEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceOf createInstanceOf() {
		InstanceOfImpl instanceOf = new InstanceOfImpl();
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plus createPlus() {
		PlusImpl plus = new PlusImpl();
		return plus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Minus createMinus() {
		MinusImpl minus = new MinusImpl();
		return minus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mul createMul() {
		MulImpl mul = new MulImpl();
		return mul;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mod createMod() {
		ModImpl mod = new ModImpl();
		return mod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Div createDiv() {
		DivImpl div = new DivImpl();
		return div;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Neg createNeg() {
		NegImpl neg = new NegImpl();
		return neg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cast createCast() {
		CastImpl cast = new CastImpl();
		return cast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateObject createCreateObject() {
		CreateObjectImpl createObject = new CreateObjectImpl();
		return createObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteral createNullLiteral() {
		NullLiteralImpl nullLiteral = new NullLiteralImpl();
		return nullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeLiteral createTimeLiteral() {
		TimeLiteralImpl timeLiteral = new TimeLiteralImpl();
		return timeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntLiteral createIntLiteral() {
		IntLiteralImpl intLiteral = new IntLiteralImpl();
		return intLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueLiteral createTrueLiteral() {
		TrueLiteralImpl trueLiteral = new TrueLiteralImpl();
		return trueLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseLiteral createFalseLiteral() {
		FalseLiteralImpl falseLiteral = new FalseLiteralImpl();
		return falseLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandExpr createExpandExpr() {
		ExpandExprImpl expandExpr = new ExpandExprImpl();
		return expandExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParseExpr createParseExpr() {
		ParseExprImpl parseExpr = new ParseExprImpl();
		return parseExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedId createPredefinedId() {
		PredefinedIdImpl predefinedId = new PredefinedIdImpl();
		return predefinedId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeLiteral createMeLiteral() {
		MeLiteralImpl meLiteral = new MeLiteralImpl();
		return meLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperLiteral createSuperLiteral() {
		SuperLiteralImpl superLiteral = new SuperLiteralImpl();
		return superLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaLiteral createMetaLiteral() {
		MetaLiteralImpl metaLiteral = new MetaLiteralImpl();
		return metaLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeLiteral createTypeLiteral() {
		TypeLiteralImpl typeLiteral = new TypeLiteralImpl();
		return typeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizeOfArray createSizeOfArray() {
		SizeOfArrayImpl sizeOfArray = new SizeOfArrayImpl();
		return sizeOfArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationLiteral createAnnotationLiteral() {
		AnnotationLiteralImpl annotationLiteral = new AnnotationLiteralImpl();
		return annotationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdExpr createIdExpr() {
		IdExprImpl idExpr = new IdExprImpl();
		return idExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallPart createCallPart() {
		CallPartImpl callPart = new CallPartImpl();
		return callPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAccess createVariableAccess() {
		VariableAccessImpl variableAccess = new VariableAccessImpl();
		return variableAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaAccess createMetaAccess() {
		MetaAccessImpl metaAccess = new MetaAccessImpl();
		return metaAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAccess createTypeAccess() {
		TypeAccessImpl typeAccess = new TypeAccessImpl();
		return typeAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionSemantics createExtensionSemantics() {
		ExtensionSemanticsImpl extensionSemantics = new ExtensionSemanticsImpl();
		return extensionSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxDefinition createSyntaxDefinition() {
		SyntaxDefinitionImpl syntaxDefinition = new SyntaxDefinitionImpl();
		return syntaxDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxSymbolClassifier createSyntaxSymbolClassifier() {
		SyntaxSymbolClassifierImpl syntaxSymbolClassifier = new SyntaxSymbolClassifierImpl();
		return syntaxSymbolClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexSymbol createComplexSymbol() {
		ComplexSymbolImpl complexSymbol = new ComplexSymbolImpl();
		return complexSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept createConcept() {
		ConceptImpl concept = new ConceptImpl();
		return concept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaSymbol createMetaSymbol() {
		MetaSymbolImpl metaSymbol = new MetaSymbolImpl();
		return metaSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyntaxExpression createSyntaxExpression() {
		SyntaxExpressionImpl syntaxExpression = new SyntaxExpressionImpl();
		return syntaxExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L3SyntaxExpression createL3SyntaxExpression() {
		L3SyntaxExpressionImpl l3SyntaxExpression = new L3SyntaxExpressionImpl();
		return l3SyntaxExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2SyntaxExpression createL2SyntaxExpression() {
		L2SyntaxExpressionImpl l2SyntaxExpression = new L2SyntaxExpressionImpl();
		return l2SyntaxExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbolSequence createSymbolSequence() {
		SymbolSequenceImpl symbolSequence = new SymbolSequenceImpl();
		return symbolSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L1SyntaxExpression createL1SyntaxExpression() {
		L1SyntaxExpressionImpl l1SyntaxExpression = new L1SyntaxExpressionImpl();
		return l1SyntaxExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralSymbolReference createStructuralSymbolReference() {
		StructuralSymbolReferenceImpl structuralSymbolReference = new StructuralSymbolReferenceImpl();
		return structuralSymbolReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlainSymbolReference createPlainSymbolReference() {
		PlainSymbolReferenceImpl plainSymbolReference = new PlainSymbolReferenceImpl();
		return plainSymbolReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdSymbol createIdSymbol() {
		IdSymbolImpl idSymbol = new IdSymbolImpl();
		return idSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSymbol createIntSymbol() {
		IntSymbolImpl intSymbol = new IntSymbolImpl();
		return intSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSymbol createStringSymbol() {
		StringSymbolImpl stringSymbol = new StringSymbolImpl();
		return stringSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Keyword createKeyword() {
		KeywordImpl keyword = new KeywordImpl();
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaExpr createMetaExpr() {
		MetaExprImpl metaExpr = new MetaExprImpl();
		return metaExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetStatement createTargetStatement() {
		TargetStatementImpl targetStatement = new TargetStatementImpl();
		return targetStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateIdStatement createCreateIdStatement() {
		CreateIdStatementImpl createIdStatement = new CreateIdStatementImpl();
		return createIdStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionStatement createExpansionStatement() {
		ExpansionStatementImpl expansionStatement = new ExpansionStatementImpl();
		return expansionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandTextPart createExpandTextPart() {
		ExpandTextPartImpl expandTextPart = new ExpandTextPartImpl();
		return expandTextPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandVariablePart createExpandVariablePart() {
		ExpandVariablePartImpl expandVariablePart = new ExpandVariablePartImpl();
		return expandVariablePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandExpression createExpandExpression() {
		ExpandExpressionImpl expandExpression = new ExpandExpressionImpl();
		return expandExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandStatement createExpandStatement() {
		ExpandStatementImpl expandStatement = new ExpandStatementImpl();
		return expandStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeQuoteExpression createCodeQuoteExpression() {
		CodeQuoteExpressionImpl codeQuoteExpression = new CodeQuoteExpressionImpl();
		return codeQuoteExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedCode createQuotedCode() {
		QuotedCodeImpl quotedCode = new QuotedCodeImpl();
		return quotedCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedExpression createQuotedExpression() {
		QuotedExpressionImpl quotedExpression = new QuotedExpressionImpl();
		return quotedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedStatements createQuotedStatements() {
		QuotedStatementsImpl quotedStatements = new QuotedStatementsImpl();
		return quotedStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedClassContent createQuotedClassContent() {
		QuotedClassContentImpl quotedClassContent = new QuotedClassContentImpl();
		return quotedClassContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuotedModuleContent createQuotedModuleContent() {
		QuotedModuleContentImpl quotedModuleContent = new QuotedModuleContentImpl();
		return quotedModuleContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStatement createTestStatement() {
		TestStatementImpl testStatement = new TestStatementImpl();
		return testStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DblPackage getDblPackage() {
		return (DblPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DblPackage getPackage() {
		return DblPackage.eINSTANCE;
	}

} //DblFactoryImpl
