/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.*;
import hub.sam.dbl.util.DblUtil;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
			DblFactory theDblFactory = (DblFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.hu-berlin.de/sam/dbl"); 
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
			case DblPackage.CONSTRUCT: return createConstruct();
			case DblPackage.MODEL: return createModel();
			case DblPackage.IMPORT: return createImport();
			case DblPackage.MODULE: return createModule();
			case DblPackage.VOID_TYPE: return createVoidType();
			case DblPackage.INT_TYPE: return createIntType();
			case DblPackage.BOOL_TYPE: return createBoolType();
			case DblPackage.DOUBLE_TYPE: return createDoubleType();
			case DblPackage.STRING_TYPE: return createStringType();
			case DblPackage.PROCEDURE: return createProcedure();
			case DblPackage.SIMPLE_ANNOTATION: return createSimpleAnnotation();
			case DblPackage.ANNOTATION: return createAnnotation();
			case DblPackage.ANNOTATION_APPLICATION: return createAnnotationApplication();
			case DblPackage.KEY_VALUE_PAIR: return createKeyValuePair();
			case DblPackage.NATIVE_BINDING: return createNativeBinding();
			case DblPackage.START_CODE_BLOCK: return createStartCodeBlock();
			case DblPackage.CLAZZ: return createClazz();
			case DblPackage.CONSTRUCTOR: return createConstructor();
			case DblPackage.CLASS_AUGMENT: return createClassAugment();
			case DblPackage.INTERFACE: return createInterface();
			case DblPackage.VARIABLE: return createVariable();
			case DblPackage.PARAMETER: return createParameter();
			case DblPackage.NAMED_ELEMENT: return createNamedElement();
			case DblPackage.CODE_BLOCK: return createCodeBlock();
			case DblPackage.STATEMENT: return createStatement();
			case DblPackage.COMPOSITE_STATEMENT: return createCompositeStatement();
			case DblPackage.SIMPLE_STATEMENT: return createSimpleStatement();
			case DblPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case DblPackage.STATEMENT_EXPRESSION: return createStatementExpression();
			case DblPackage.ASSIGNMENT: return createAssignment();
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT: return createDeprecatedProcedureCallStatement();
			case DblPackage.PROCEDURE_CALL: return createProcedureCall();
			case DblPackage.RETURN: return createReturn();
			case DblPackage.WAIT_UNTIL: return createWaitUntil();
			case DblPackage.TERMINATE: return createTerminate();
			case DblPackage.WAIT: return createWait();
			case DblPackage.REACTIVATE: return createReactivate();
			case DblPackage.ACTIVATE_OBJECT: return createActivateObject();
			case DblPackage.ADVANCE: return createAdvance();
			case DblPackage.PRINT: return createPrint();
			case DblPackage.REMOVE_FROM_SET: return createRemoveFromSet();
			case DblPackage.ADD_TO_SET: return createAddToSet();
			case DblPackage.EMPTY_SET: return createEmptySet();
			case DblPackage.IF_STATEMENT: return createIfStatement();
			case DblPackage.WHILE_STATEMENT: return createWhileStatement();
			case DblPackage.BREAK_STATEMENT: return createBreakStatement();
			case DblPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case DblPackage.FOR_EACH_STATEMENT: return createForEachStatement();
			case DblPackage.EXPRESSION: return createExpression();
			case DblPackage.L1_EXPR: return createL1Expr();
			case DblPackage.PLUS: return createPlus();
			case DblPackage.MINUS: return createMinus();
			case DblPackage.MUL: return createMul();
			case DblPackage.MOD: return createMod();
			case DblPackage.DIV: return createDiv();
			case DblPackage.NEG: return createNeg();
			case DblPackage.AND: return createAnd();
			case DblPackage.OR: return createOr();
			case DblPackage.GREATER: return createGreater();
			case DblPackage.GREATER_EQUAL: return createGreaterEqual();
			case DblPackage.LESS: return createLess();
			case DblPackage.LESS_EQUAL: return createLessEqual();
			case DblPackage.NOT_EQUAL: return createNotEqual();
			case DblPackage.EQUAL: return createEqual();
			case DblPackage.INSTANCE_OF: return createInstanceOf();
			case DblPackage.NOT: return createNot();
			case DblPackage.CREATE_OBJECT: return createCreateObject();
			case DblPackage.CAST: return createCast();
			case DblPackage.NULL_LITERAL: return createNullLiteral();
			case DblPackage.TIME_LITERAL: return createTimeLiteral();
			case DblPackage.ACTIVE_LITERAL: return createActiveLiteral();
			case DblPackage.EVAL_EXPR: return createEvalExpr();
			case DblPackage.ME_LITERAL: return createMeLiteral();
			case DblPackage.SUPER_LITERAL: return createSuperLiteral();
			case DblPackage.META_LITERAL: return createMetaLiteral();
			case DblPackage.TYPE_LITERAL: return createTypeLiteral();
			case DblPackage.SIZE_OF_SET: return createSizeOfSet();
			case DblPackage.FIRST_IN_SET: return createFirstInSet();
			case DblPackage.LAST_IN_SET: return createLastInSet();
			case DblPackage.CONTAINS: return createContains();
			case DblPackage.INDEX_OF: return createIndexOf();
			case DblPackage.OBJECT_AT: return createObjectAt();
			case DblPackage.BEFORE_IN_SET: return createBeforeInSet();
			case DblPackage.AFTER_IN_SET: return createAfterInSet();
			case DblPackage.STRING_LITERAL: return createStringLiteral();
			case DblPackage.INT_LITERAL: return createIntLiteral();
			case DblPackage.TRUE_LITERAL: return createTrueLiteral();
			case DblPackage.FALSE_LITERAL: return createFalseLiteral();
			case DblPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case DblPackage.PREDEFINED_ID: return createPredefinedId();
			case DblPackage.ID_EXPR: return createIdExpr();
			case DblPackage.ARGUMENT_EXPRESSION: return createArgumentExpression();
			case DblPackage.VARIABLE_ACCESS: return createVariableAccess();
			case DblPackage.META_ACCESS: return createMetaAccess();
			case DblPackage.TYPE_ACCESS: return createTypeAccess();
			case DblPackage.EXTENSION: return createExtension();
			case DblPackage.NAMED_EXTENSION: return createNamedExtension();
			case DblPackage.CLASS_CONTENT_EXTENSION: return createClassContentExtension();
			case DblPackage.MODULE_CONTENT_EXTENSION: return createModuleContentExtension();
			case DblPackage.EXTENSION_DEFINITION: return createExtensionDefinition();
			case DblPackage.TEXTUAL_SYNTAX_DEF: return createTextualSyntaxDef();
			case DblPackage.TS_RULE: return createTsRule();
			case DblPackage.EXTENSION_RULE: return createExtensionRule();
			case DblPackage.SEQUENCE_EXPR: return createSequenceExpr();
			case DblPackage.OPTIONAL_EXPR: return createOptionalExpr();
			case DblPackage.RUNTIME_EXPR: return createRuntimeExpr();
			case DblPackage.AT_LEAST_ONE_EXPR: return createAtLeastOneExpr();
			case DblPackage.ARBITRARY_EXPR: return createArbitraryExpr();
			case DblPackage.ALTERNATIVE_EXPR: return createAlternativeExpr();
			case DblPackage.TERMINAL_EXPR: return createTerminalExpr();
			case DblPackage.PROPERTY_BINDING_EXPR: return createPropertyBindingExpr();
			case DblPackage.RULE_EXPR: return createRuleExpr();
			case DblPackage.ID_PROPERTY_TYPE: return createIdPropertyType();
			case DblPackage.INT_PROPERTY_TYPE: return createIntPropertyType();
			case DblPackage.STRING_PROPERTY_TYPE: return createStringPropertyType();
			case DblPackage.BOOLEAN_PROPERTY_TYPE: return createBooleanPropertyType();
			case DblPackage.STRUCTURED_PROPERTY_TYPE: return createStructuredPropertyType();
			case DblPackage.COMPOSITE_PROPERTY_TYPE: return createCompositePropertyType();
			case DblPackage.REFERENCE_PROPERTY_TYPE: return createReferencePropertyType();
			case DblPackage.MAPPING: return createMapping();
			case DblPackage.META_EXPR: return createMetaExpr();
			case DblPackage.TARGET_STATEMENT: return createTargetStatement();
			case DblPackage.MAPPING_STATEMENT: return createMappingStatement();
			case DblPackage.SET_GEN_CONTEXT_STATEMENT: return createSetGenContextStatement();
			case DblPackage.RESET_GEN_CONTEXT_STATEMENT: return createResetGenContextStatement();
			case DblPackage.SAVE_GEN_STATEMENT: return createSaveGenStatement();
			case DblPackage.RESUME_GEN_STATEMENT: return createResumeGenStatement();
			case DblPackage.FIXED_MAPPING_PART: return createFixedMappingPart();
			case DblPackage.DYNAMIC_MAPPING_PART: return createDynamicMappingPart();
			case DblPackage.EXPAND_EXPRESSION: return createExpandExpression();
			case DblPackage.EXPAND_STATEMENT: return createExpandStatement();
			case DblPackage.EXPAND_SECTION: return createExpandSection();
			case DblPackage.CODE_QUOTE_EXPRESSION: return createCodeQuoteExpression();
			case DblPackage.QUOTED_CODE: return createQuotedCode();
			case DblPackage.QUOTED_EXPRESSION: return createQuotedExpression();
			case DblPackage.QUOTED_STATEMENTS: return createQuotedStatements();
			case DblPackage.QUOTED_CLASS_CONTENT: return createQuotedClassContent();
			case DblPackage.QUOTED_MODULE_CONTENT: return createQuotedModuleContent();
			case DblPackage.EXPANDABLE_ELEMENT: return createExpandableElement();
			case DblPackage.TEST_STATEMENT: return createTestStatement();
			case DblPackage.ID_RESOLUTION: return createIdResolution();
			case DblPackage.PATTERN: return createPattern();
			case DblPackage.POTENTIALLY_HIDDEN_ID_ELEMENTS: return createPotentiallyHiddenIdElements();
			case DblPackage.FIND_CONTAINER: return createFindContainer();
			case DblPackage.CONSIDER_ID_ELEMENTS: return createConsiderIdElements();
			case DblPackage.INCLUDE_PATTERN: return createIncludePattern();
			case DblPackage.YIELD: return createYield();
			case DblPackage.LIST_DIMENSION: return createListDimension();
			default:
				//throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
				return DblUtil.createObjectOfParentClass(eClass);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DblPackage.BINDING_EXPR_OP_KIND:
				return createBindingExprOpKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DblPackage.BINDING_EXPR_OP_KIND:
				return convertBindingExprOpKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public ListDimension createListDimension() {
		ListDimensionImpl listDimension = new ListDimensionImpl();
		return listDimension;
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
	public Procedure createProcedure() {
		ProcedureImpl procedure = new ProcedureImpl();
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleAnnotation createSimpleAnnotation() {
		SimpleAnnotationImpl simpleAnnotation = new SimpleAnnotationImpl();
		return simpleAnnotation;
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
	public AnnotationApplication createAnnotationApplication() {
		AnnotationApplicationImpl annotationApplication = new AnnotationApplicationImpl();
		return annotationApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValuePair createKeyValuePair() {
		KeyValuePairImpl keyValuePair = new KeyValuePairImpl();
		return keyValuePair;
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
	public StartCodeBlock createStartCodeBlock() {
		StartCodeBlockImpl startCodeBlock = new StartCodeBlockImpl();
		return startCodeBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clazz createClazz() {
		ClazzImpl clazz = new ClazzImpl();
		return clazz;
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
	public ClassAugment createClassAugment() {
		ClassAugmentImpl classAugment = new ClassAugmentImpl();
		return classAugment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface createInterface() {
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
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
	public CodeBlock createCodeBlock() {
		CodeBlockImpl codeBlock = new CodeBlockImpl();
		return codeBlock;
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
	public CompositeStatement createCompositeStatement() {
		CompositeStatementImpl compositeStatement = new CompositeStatementImpl();
		return compositeStatement;
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
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementExpression createStatementExpression() {
		StatementExpressionImpl statementExpression = new StatementExpressionImpl();
		return statementExpression;
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
	public DeprecatedProcedureCallStatement createDeprecatedProcedureCallStatement() {
		DeprecatedProcedureCallStatementImpl deprecatedProcedureCallStatement = new DeprecatedProcedureCallStatementImpl();
		return deprecatedProcedureCallStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcedureCall createProcedureCall() {
		ProcedureCallImpl procedureCall = new ProcedureCallImpl();
		return procedureCall;
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
	public Terminate createTerminate() {
		TerminateImpl terminate = new TerminateImpl();
		return terminate;
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
	public RemoveFromSet createRemoveFromSet() {
		RemoveFromSetImpl removeFromSet = new RemoveFromSetImpl();
		return removeFromSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddToSet createAddToSet() {
		AddToSetImpl addToSet = new AddToSetImpl();
		return addToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptySet createEmptySet() {
		EmptySetImpl emptySet = new EmptySetImpl();
		return emptySet;
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
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
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
	public ForEachStatement createForEachStatement() {
		ForEachStatementImpl forEachStatement = new ForEachStatementImpl();
		return forEachStatement;
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
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
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
	public InstanceOf createInstanceOf() {
		InstanceOfImpl instanceOf = new InstanceOfImpl();
		return instanceOf;
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
	public CreateObject createCreateObject() {
		CreateObjectImpl createObject = new CreateObjectImpl();
		return createObject;
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
	public ActiveLiteral createActiveLiteral() {
		ActiveLiteralImpl activeLiteral = new ActiveLiteralImpl();
		return activeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvalExpr createEvalExpr() {
		EvalExprImpl evalExpr = new EvalExprImpl();
		return evalExpr;
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
	public SizeOfSet createSizeOfSet() {
		SizeOfSetImpl sizeOfSet = new SizeOfSetImpl();
		return sizeOfSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FirstInSet createFirstInSet() {
		FirstInSetImpl firstInSet = new FirstInSetImpl();
		return firstInSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LastInSet createLastInSet() {
		LastInSetImpl lastInSet = new LastInSetImpl();
		return lastInSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contains createContains() {
		ContainsImpl contains = new ContainsImpl();
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexOf createIndexOf() {
		IndexOfImpl indexOf = new IndexOfImpl();
		return indexOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectAt createObjectAt() {
		ObjectAtImpl objectAt = new ObjectAtImpl();
		return objectAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeforeInSet createBeforeInSet() {
		BeforeInSetImpl beforeInSet = new BeforeInSetImpl();
		return beforeInSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AfterInSet createAfterInSet() {
		AfterInSetImpl afterInSet = new AfterInSetImpl();
		return afterInSet;
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
	public PredefinedId createPredefinedId() {
		PredefinedIdImpl predefinedId = new PredefinedIdImpl();
		return predefinedId;
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
	public ArgumentExpression createArgumentExpression() {
		ArgumentExpressionImpl argumentExpression = new ArgumentExpressionImpl();
		return argumentExpression;
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
	public NamedExtension createNamedExtension() {
		NamedExtensionImpl namedExtension = new NamedExtensionImpl();
		return namedExtension;
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
	public ModuleContentExtension createModuleContentExtension() {
		ModuleContentExtensionImpl moduleContentExtension = new ModuleContentExtensionImpl();
		return moduleContentExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionDefinition createExtensionDefinition() {
		ExtensionDefinitionImpl extensionDefinition = new ExtensionDefinitionImpl();
		return extensionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextualSyntaxDef createTextualSyntaxDef() {
		TextualSyntaxDefImpl textualSyntaxDef = new TextualSyntaxDefImpl();
		return textualSyntaxDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TsRule createTsRule() {
		TsRuleImpl tsRule = new TsRuleImpl();
		return tsRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionRule createExtensionRule() {
		ExtensionRuleImpl extensionRule = new ExtensionRuleImpl();
		return extensionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceExpr createSequenceExpr() {
		SequenceExprImpl sequenceExpr = new SequenceExprImpl();
		return sequenceExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionalExpr createOptionalExpr() {
		OptionalExprImpl optionalExpr = new OptionalExprImpl();
		return optionalExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeExpr createRuntimeExpr() {
		RuntimeExprImpl runtimeExpr = new RuntimeExprImpl();
		return runtimeExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtLeastOneExpr createAtLeastOneExpr() {
		AtLeastOneExprImpl atLeastOneExpr = new AtLeastOneExprImpl();
		return atLeastOneExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArbitraryExpr createArbitraryExpr() {
		ArbitraryExprImpl arbitraryExpr = new ArbitraryExprImpl();
		return arbitraryExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeExpr createAlternativeExpr() {
		AlternativeExprImpl alternativeExpr = new AlternativeExprImpl();
		return alternativeExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalExpr createTerminalExpr() {
		TerminalExprImpl terminalExpr = new TerminalExprImpl();
		return terminalExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyBindingExpr createPropertyBindingExpr() {
		PropertyBindingExprImpl propertyBindingExpr = new PropertyBindingExprImpl();
		return propertyBindingExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleExpr createRuleExpr() {
		RuleExprImpl ruleExpr = new RuleExprImpl();
		return ruleExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdPropertyType createIdPropertyType() {
		IdPropertyTypeImpl idPropertyType = new IdPropertyTypeImpl();
		return idPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntPropertyType createIntPropertyType() {
		IntPropertyTypeImpl intPropertyType = new IntPropertyTypeImpl();
		return intPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPropertyType createStringPropertyType() {
		StringPropertyTypeImpl stringPropertyType = new StringPropertyTypeImpl();
		return stringPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanPropertyType createBooleanPropertyType() {
		BooleanPropertyTypeImpl booleanPropertyType = new BooleanPropertyTypeImpl();
		return booleanPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredPropertyType createStructuredPropertyType() {
		StructuredPropertyTypeImpl structuredPropertyType = new StructuredPropertyTypeImpl();
		return structuredPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositePropertyType createCompositePropertyType() {
		CompositePropertyTypeImpl compositePropertyType = new CompositePropertyTypeImpl();
		return compositePropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencePropertyType createReferencePropertyType() {
		ReferencePropertyTypeImpl referencePropertyType = new ReferencePropertyTypeImpl();
		return referencePropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
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
	public MappingStatement createMappingStatement() {
		MappingStatementImpl mappingStatement = new MappingStatementImpl();
		return mappingStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetGenContextStatement createSetGenContextStatement() {
		SetGenContextStatementImpl setGenContextStatement = new SetGenContextStatementImpl();
		return setGenContextStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetGenContextStatement createResetGenContextStatement() {
		ResetGenContextStatementImpl resetGenContextStatement = new ResetGenContextStatementImpl();
		return resetGenContextStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaveGenStatement createSaveGenStatement() {
		SaveGenStatementImpl saveGenStatement = new SaveGenStatementImpl();
		return saveGenStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResumeGenStatement createResumeGenStatement() {
		ResumeGenStatementImpl resumeGenStatement = new ResumeGenStatementImpl();
		return resumeGenStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedMappingPart createFixedMappingPart() {
		FixedMappingPartImpl fixedMappingPart = new FixedMappingPartImpl();
		return fixedMappingPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicMappingPart createDynamicMappingPart() {
		DynamicMappingPartImpl dynamicMappingPart = new DynamicMappingPartImpl();
		return dynamicMappingPart;
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
	public ExpandSection createExpandSection() {
		ExpandSectionImpl expandSection = new ExpandSectionImpl();
		return expandSection;
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
	public ExpandableElement createExpandableElement() {
		ExpandableElementImpl expandableElement = new ExpandableElementImpl();
		return expandableElement;
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
	public IdResolution createIdResolution() {
		IdResolutionImpl idResolution = new IdResolutionImpl();
		return idResolution;
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
	public PotentiallyHiddenIdElements createPotentiallyHiddenIdElements() {
		PotentiallyHiddenIdElementsImpl potentiallyHiddenIdElements = new PotentiallyHiddenIdElementsImpl();
		return potentiallyHiddenIdElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FindContainer createFindContainer() {
		FindContainerImpl findContainer = new FindContainerImpl();
		return findContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsiderIdElements createConsiderIdElements() {
		ConsiderIdElementsImpl considerIdElements = new ConsiderIdElementsImpl();
		return considerIdElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludePattern createIncludePattern() {
		IncludePatternImpl includePattern = new IncludePatternImpl();
		return includePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingExprOpKind createBindingExprOpKindFromString(EDataType eDataType, String initialValue) {
		BindingExprOpKind result = BindingExprOpKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingExprOpKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
