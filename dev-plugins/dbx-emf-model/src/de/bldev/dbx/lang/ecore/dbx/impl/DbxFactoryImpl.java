/**
 */
package de.bldev.dbx.lang.ecore.dbx.impl;

import de.bldev.dbx.lang.ecore.DbxEcoreExtensionsHelper;
import de.bldev.dbx.lang.ecore.dbx.*;

import org.eclipse.emf.ecore.EClass;
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
public class DbxFactoryImpl extends EFactoryImpl implements DbxFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DbxFactory init() {
		try {
			DbxFactory theDbxFactory = (DbxFactory)EPackage.Registry.INSTANCE.getEFactory(DbxPackage.eNS_URI);
			if (theDbxFactory != null) {
				return theDbxFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DbxFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbxFactoryImpl() {
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
			case DbxPackage.NAMED_ELEMENT: return createNamedElement();
			case DbxPackage.EXTENSIBLE_ELEMENT: return createExtensibleElement();
			case DbxPackage.MODEL: return createModel();
			case DbxPackage.IMPORT: return createImport();
			case DbxPackage.VOID_TYPE: return createVoidType();
			case DbxPackage.INT_TYPE: return createIntType();
			case DbxPackage.BOOL_TYPE: return createBoolType();
			case DbxPackage.DOUBLE_TYPE: return createDoubleType();
			case DbxPackage.STRING_TYPE: return createStringType();
			case DbxPackage.NATIVE_TYPE_BINDING: return createNativeTypeBinding();
			case DbxPackage.BASE_CLASS: return createBaseClass();
			case DbxPackage.ACTIVE_CLASS: return createActiveClass();
			case DbxPackage.CONSTRUCTOR: return createConstructor();
			case DbxPackage.METHOD: return createMethod();
			case DbxPackage.INITIALIZABLE_VARIABLE: return createInitializableVariable();
			case DbxPackage.LOCAL_VARIABLE_STATEMENT: return createLocalVariableStatement();
			case DbxPackage.ATTRIBUTE: return createAttribute();
			case DbxPackage.STATEMENT: return createStatement();
			case DbxPackage.LOOP_STATEMENT: return createLoopStatement();
			case DbxPackage.SIMPLE_STATEMENT: return createSimpleStatement();
			case DbxPackage.ASSIGNMENT: return createAssignment();
			case DbxPackage.METHOD_INVOCATION: return createMethodInvocation();
			case DbxPackage.RETURN: return createReturn();
			case DbxPackage.WAIT_UNTIL: return createWaitUntil();
			case DbxPackage.YIELD: return createYield();
			case DbxPackage.YIELD_TO: return createYieldTo();
			case DbxPackage.WAIT: return createWait();
			case DbxPackage.REACTIVATE: return createReactivate();
			case DbxPackage.ACTIVATE: return createActivate();
			case DbxPackage.ADVANCE: return createAdvance();
			case DbxPackage.IF_STATEMENT: return createIfStatement();
			case DbxPackage.LOCAL_SCOPE: return createLocalScope();
			case DbxPackage.FOR_STATEMENT: return createForStatement();
			case DbxPackage.WHILE_STATEMENT: return createWhileStatement();
			case DbxPackage.BREAK_STATEMENT: return createBreakStatement();
			case DbxPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case DbxPackage.EXPRESSION: return createExpression();
			case DbxPackage.L1_EXPR: return createL1Expr();
			case DbxPackage.L2_EXPR: return createL2Expr();
			case DbxPackage.L3_EXPR: return createL3Expr();
			case DbxPackage.L4_EXPR: return createL4Expr();
			case DbxPackage.L5_EXPR: return createL5Expr();
			case DbxPackage.L6_EXPR: return createL6Expr();
			case DbxPackage.L7_EXPR: return createL7Expr();
			case DbxPackage.L8_EXPR: return createL8Expr();
			case DbxPackage.L9_EXPR: return createL9Expr();
			case DbxPackage.OR: return createOr();
			case DbxPackage.AND: return createAnd();
			case DbxPackage.NOT_EQUAL: return createNotEqual();
			case DbxPackage.EQUAL: return createEqual();
			case DbxPackage.GREATER: return createGreater();
			case DbxPackage.GREATER_EQUAL: return createGreaterEqual();
			case DbxPackage.LESS: return createLess();
			case DbxPackage.LESS_EQUAL: return createLessEqual();
			case DbxPackage.INSTANCE_OF: return createInstanceOf();
			case DbxPackage.PLUS: return createPlus();
			case DbxPackage.MINUS: return createMinus();
			case DbxPackage.MUL: return createMul();
			case DbxPackage.MOD: return createMod();
			case DbxPackage.DIV: return createDiv();
			case DbxPackage.NEG: return createNeg();
			case DbxPackage.NOT: return createNot();
			case DbxPackage.CAST: return createCast();
			case DbxPackage.CREATE_OBJECT: return createCreateObject();
			case DbxPackage.NULL_LITERAL: return createNullLiteral();
			case DbxPackage.TIME_LITERAL: return createTimeLiteral();
			case DbxPackage.STRING_LITERAL: return createStringLiteral();
			case DbxPackage.INT_LITERAL: return createIntLiteral();
			case DbxPackage.TRUE_LITERAL: return createTrueLiteral();
			case DbxPackage.FALSE_LITERAL: return createFalseLiteral();
			case DbxPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case DbxPackage.THIS: return createThis();
			case DbxPackage.SUPER: return createSuper();
			case DbxPackage.META: return createMeta();
			case DbxPackage.NAMED_ELEMENT_NAVIGATION_EXPR: return createNamedElementNavigationExpr();
			case DbxPackage.NAMED_ELEMENT_ACCESS: return createNamedElementAccess();
			case DbxPackage.VARIABLE_ACCESS: return createVariableAccess();
			case DbxPackage.INVOCATION_ARGUMENTS: return createInvocationArguments();
			default:
				return DbxEcoreExtensionsHelper.createObjectOfParentClass(eClass);
		}
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
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement createTypedElement() {
		TypedElementImpl typedElement = new TypedElementImpl();
		return typedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
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
	public NativeType createNativeType() {
		NativeTypeImpl nativeType = new NativeTypeImpl();
		return nativeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeTypeBinding createNativeTypeBinding() {
		NativeTypeBindingImpl nativeTypeBinding = new NativeTypeBindingImpl();
		return nativeTypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseClass createBaseClass() {
		BaseClassImpl baseClass = new BaseClassImpl();
		return baseClass;
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
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
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
	public InitializableVariable createInitializableVariable() {
		InitializableVariableImpl initializableVariable = new InitializableVariableImpl();
		return initializableVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableStatement createLocalVariableStatement() {
		LocalVariableStatementImpl localVariableStatement = new LocalVariableStatementImpl();
		return localVariableStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObversableAttribute createObversableAttribute() {
		ObversableAttributeImpl obversableAttribute = new ObversableAttributeImpl();
		return obversableAttribute;
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
	public MethodInvocation createMethodInvocation() {
		MethodInvocationImpl methodInvocation = new MethodInvocationImpl();
		return methodInvocation;
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
	public Activate createActivate() {
		ActivateImpl activate = new ActivateImpl();
		return activate;
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
	public BinaryOperator createBinaryOperator() {
		BinaryOperatorImpl binaryOperator = new BinaryOperatorImpl();
		return binaryOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperator() {
		UnaryOperatorImpl unaryOperator = new UnaryOperatorImpl();
		return unaryOperator;
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
	public Keyword createKeyword() {
		KeywordImpl keyword = new KeywordImpl();
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public This createThis() {
		ThisImpl this_ = new ThisImpl();
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super createSuper() {
		SuperImpl super_ = new SuperImpl();
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta createMeta() {
		MetaImpl meta = new MetaImpl();
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElementNavigationExpr createNamedElementNavigationExpr() {
		NamedElementNavigationExprImpl namedElementNavigationExpr = new NamedElementNavigationExprImpl();
		return namedElementNavigationExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElementAccess createNamedElementAccess() {
		NamedElementAccessImpl namedElementAccess = new NamedElementAccessImpl();
		return namedElementAccess;
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
	public InvocationArguments createInvocationArguments() {
		InvocationArgumentsImpl invocationArguments = new InvocationArgumentsImpl();
		return invocationArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DbxPackage getDbxPackage() {
		return (DbxPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DbxPackage getPackage() {
		return DbxPackage.eINSTANCE;
	}

} //DbxFactoryImpl
