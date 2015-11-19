/**
 */
package hub.sam.dbl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.dbl.DblPackage
 * @generated
 */
public interface DblFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DblFactory eINSTANCE = hub.sam.dbl.impl.DblFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Construct</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Construct</em>'.
	 * @generated
	 */
	Construct createConstruct();

	/**
	 * Returns a new object of class '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extensible Element</em>'.
	 * @generated
	 */
	ExtensibleElement createExtensibleElement();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Annotation Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Item</em>'.
	 * @generated
	 */
	AnnotationItem createAnnotationItem();

	/**
	 * Returns a new object of class '<em>Annotateable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotateable Element</em>'.
	 * @generated
	 */
	AnnotateableElement createAnnotateableElement();

	/**
	 * Returns a new object of class '<em>Constructive Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructive Extension</em>'.
	 * @generated
	 */
	ConstructiveExtension createConstructiveExtension();

	/**
	 * Returns a new object of class '<em>Module Content Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Content Extension</em>'.
	 * @generated
	 */
	ModuleContentExtension createModuleContentExtension();

	/**
	 * Returns a new object of class '<em>Class Content Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Content Extension</em>'.
	 * @generated
	 */
	ClassContentExtension createClassContentExtension();

	/**
	 * Returns a new object of class '<em>Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Dimension</em>'.
	 * @generated
	 */
	ArrayDimension createArrayDimension();

	/**
	 * Returns a new object of class '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Void Type</em>'.
	 * @generated
	 */
	VoidType createVoidType();

	/**
	 * Returns a new object of class '<em>Int Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Type</em>'.
	 * @generated
	 */
	IntType createIntType();

	/**
	 * Returns a new object of class '<em>Bool Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bool Type</em>'.
	 * @generated
	 */
	BoolType createBoolType();

	/**
	 * Returns a new object of class '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Type</em>'.
	 * @generated
	 */
	DoubleType createDoubleType();

	/**
	 * Returns a new object of class '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Native Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Native Binding</em>'.
	 * @generated
	 */
	NativeBinding createNativeBinding();

	/**
	 * Returns a new object of class '<em>Super Class Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Class Specification</em>'.
	 * @generated
	 */
	SuperClassSpecification createSuperClassSpecification();

	/**
	 * Returns a new object of class '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class</em>'.
	 * @generated
	 */
	Class createClass();

	/**
	 * Returns a new object of class '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructor</em>'.
	 * @generated
	 */
	Constructor createConstructor();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement</em>'.
	 * @generated
	 */
	Statement createStatement();

	/**
	 * Returns a new object of class '<em>Loop Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Statement</em>'.
	 * @generated
	 */
	LoopStatement createLoopStatement();

	/**
	 * Returns a new object of class '<em>Simple Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Statement</em>'.
	 * @generated
	 */
	SimpleStatement createSimpleStatement();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call</em>'.
	 * @generated
	 */
	FunctionCall createFunctionCall();

	/**
	 * Returns a new object of class '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return</em>'.
	 * @generated
	 */
	Return createReturn();

	/**
	 * Returns a new object of class '<em>Wait Until</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Until</em>'.
	 * @generated
	 */
	WaitUntil createWaitUntil();

	/**
	 * Returns a new object of class '<em>Terminate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminate</em>'.
	 * @generated
	 */
	Terminate createTerminate();

	/**
	 * Returns a new object of class '<em>Yield</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Yield</em>'.
	 * @generated
	 */
	Yield createYield();

	/**
	 * Returns a new object of class '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait</em>'.
	 * @generated
	 */
	Wait createWait();

	/**
	 * Returns a new object of class '<em>Reactivate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reactivate</em>'.
	 * @generated
	 */
	Reactivate createReactivate();

	/**
	 * Returns a new object of class '<em>Activate Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activate Object</em>'.
	 * @generated
	 */
	ActivateObject createActivateObject();

	/**
	 * Returns a new object of class '<em>Advance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advance</em>'.
	 * @generated
	 */
	Advance createAdvance();

	/**
	 * Returns a new object of class '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Print</em>'.
	 * @generated
	 */
	Print createPrint();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>Local Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Scope</em>'.
	 * @generated
	 */
	LocalScope createLocalScope();

	/**
	 * Returns a new object of class '<em>Local Scope Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Scope Statement</em>'.
	 * @generated
	 */
	LocalScopeStatement createLocalScopeStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
	WhileStatement createWhileStatement();

	/**
	 * Returns a new object of class '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Statement</em>'.
	 * @generated
	 */
	SwitchStatement createSwitchStatement();

	/**
	 * Returns a new object of class '<em>Switch Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case</em>'.
	 * @generated
	 */
	SwitchCase createSwitchCase();

	/**
	 * Returns a new object of class '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Break Statement</em>'.
	 * @generated
	 */
	BreakStatement createBreakStatement();

	/**
	 * Returns a new object of class '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continue Statement</em>'.
	 * @generated
	 */
	ContinueStatement createContinueStatement();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>L1 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L1 Expr</em>'.
	 * @generated
	 */
	L1Expr createL1Expr();

	/**
	 * Returns a new object of class '<em>L2 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L2 Expr</em>'.
	 * @generated
	 */
	L2Expr createL2Expr();

	/**
	 * Returns a new object of class '<em>L3 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L3 Expr</em>'.
	 * @generated
	 */
	L3Expr createL3Expr();

	/**
	 * Returns a new object of class '<em>L4 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L4 Expr</em>'.
	 * @generated
	 */
	L4Expr createL4Expr();

	/**
	 * Returns a new object of class '<em>L5 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L5 Expr</em>'.
	 * @generated
	 */
	L5Expr createL5Expr();

	/**
	 * Returns a new object of class '<em>L6 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L6 Expr</em>'.
	 * @generated
	 */
	L6Expr createL6Expr();

	/**
	 * Returns a new object of class '<em>L7 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L7 Expr</em>'.
	 * @generated
	 */
	L7Expr createL7Expr();

	/**
	 * Returns a new object of class '<em>L8 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L8 Expr</em>'.
	 * @generated
	 */
	L8Expr createL8Expr();

	/**
	 * Returns a new object of class '<em>L9 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L9 Expr</em>'.
	 * @generated
	 */
	L9Expr createL9Expr();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Greater</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater</em>'.
	 * @generated
	 */
	Greater createGreater();

	/**
	 * Returns a new object of class '<em>Greater Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater Equal</em>'.
	 * @generated
	 */
	GreaterEqual createGreaterEqual();

	/**
	 * Returns a new object of class '<em>Less</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less</em>'.
	 * @generated
	 */
	Less createLess();

	/**
	 * Returns a new object of class '<em>Less Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less Equal</em>'.
	 * @generated
	 */
	LessEqual createLessEqual();

	/**
	 * Returns a new object of class '<em>Not Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Equal</em>'.
	 * @generated
	 */
	NotEqual createNotEqual();

	/**
	 * Returns a new object of class '<em>Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equal</em>'.
	 * @generated
	 */
	Equal createEqual();

	/**
	 * Returns a new object of class '<em>Instance Of</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Of</em>'.
	 * @generated
	 */
	InstanceOf createInstanceOf();

	/**
	 * Returns a new object of class '<em>Plus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plus</em>'.
	 * @generated
	 */
	Plus createPlus();

	/**
	 * Returns a new object of class '<em>Minus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minus</em>'.
	 * @generated
	 */
	Minus createMinus();

	/**
	 * Returns a new object of class '<em>Mul</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mul</em>'.
	 * @generated
	 */
	Mul createMul();

	/**
	 * Returns a new object of class '<em>Mod</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mod</em>'.
	 * @generated
	 */
	Mod createMod();

	/**
	 * Returns a new object of class '<em>Div</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Div</em>'.
	 * @generated
	 */
	Div createDiv();

	/**
	 * Returns a new object of class '<em>Neg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Neg</em>'.
	 * @generated
	 */
	Neg createNeg();

	/**
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>Cast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cast</em>'.
	 * @generated
	 */
	Cast createCast();

	/**
	 * Returns a new object of class '<em>Create Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Object</em>'.
	 * @generated
	 */
	CreateObject createCreateObject();

	/**
	 * Returns a new object of class '<em>Null Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Literal</em>'.
	 * @generated
	 */
	NullLiteral createNullLiteral();

	/**
	 * Returns a new object of class '<em>Time Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Literal</em>'.
	 * @generated
	 */
	TimeLiteral createTimeLiteral();

	/**
	 * Returns a new object of class '<em>Active Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active Literal</em>'.
	 * @generated
	 */
	ActiveLiteral createActiveLiteral();

	/**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
	StringLiteral createStringLiteral();

	/**
	 * Returns a new object of class '<em>Int Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Literal</em>'.
	 * @generated
	 */
	IntLiteral createIntLiteral();

	/**
	 * Returns a new object of class '<em>True Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Literal</em>'.
	 * @generated
	 */
	TrueLiteral createTrueLiteral();

	/**
	 * Returns a new object of class '<em>False Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Literal</em>'.
	 * @generated
	 */
	FalseLiteral createFalseLiteral();

	/**
	 * Returns a new object of class '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Literal</em>'.
	 * @generated
	 */
	DoubleLiteral createDoubleLiteral();

	/**
	 * Returns a new object of class '<em>Expand Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Expr</em>'.
	 * @generated
	 */
	ExpandExpr createExpandExpr();

	/**
	 * Returns a new object of class '<em>Parse Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parse Expr</em>'.
	 * @generated
	 */
	ParseExpr createParseExpr();

	/**
	 * Returns a new object of class '<em>Predefined Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predefined Id</em>'.
	 * @generated
	 */
	PredefinedId createPredefinedId();

	/**
	 * Returns a new object of class '<em>Me Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Me Literal</em>'.
	 * @generated
	 */
	MeLiteral createMeLiteral();

	/**
	 * Returns a new object of class '<em>Super Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Literal</em>'.
	 * @generated
	 */
	SuperLiteral createSuperLiteral();

	/**
	 * Returns a new object of class '<em>Meta Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Literal</em>'.
	 * @generated
	 */
	MetaLiteral createMetaLiteral();

	/**
	 * Returns a new object of class '<em>Type Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Literal</em>'.
	 * @generated
	 */
	TypeLiteral createTypeLiteral();

	/**
	 * Returns a new object of class '<em>Size Of Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Size Of Array</em>'.
	 * @generated
	 */
	SizeOfArray createSizeOfArray();

	/**
	 * Returns a new object of class '<em>Annotation Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Literal</em>'.
	 * @generated
	 */
	AnnotationLiteral createAnnotationLiteral();

	/**
	 * Returns a new object of class '<em>Id Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Expr</em>'.
	 * @generated
	 */
	IdExpr createIdExpr();

	/**
	 * Returns a new object of class '<em>Call Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Part</em>'.
	 * @generated
	 */
	CallPart createCallPart();

	/**
	 * Returns a new object of class '<em>Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Access</em>'.
	 * @generated
	 */
	VariableAccess createVariableAccess();

	/**
	 * Returns a new object of class '<em>Meta Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Access</em>'.
	 * @generated
	 */
	MetaAccess createMetaAccess();

	/**
	 * Returns a new object of class '<em>Type Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Access</em>'.
	 * @generated
	 */
	TypeAccess createTypeAccess();

	/**
	 * Returns a new object of class '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension</em>'.
	 * @generated
	 */
	Extension createExtension();

	/**
	 * Returns a new object of class '<em>Extension Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Semantics</em>'.
	 * @generated
	 */
	ExtensionSemantics createExtensionSemantics();

	/**
	 * Returns a new object of class '<em>Syntax Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Syntax Definition</em>'.
	 * @generated
	 */
	SyntaxDefinition createSyntaxDefinition();

	/**
	 * Returns a new object of class '<em>Syntax Symbol Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Syntax Symbol Classifier</em>'.
	 * @generated
	 */
	SyntaxSymbolClassifier createSyntaxSymbolClassifier();

	/**
	 * Returns a new object of class '<em>Complex Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Symbol</em>'.
	 * @generated
	 */
	ComplexSymbol createComplexSymbol();

	/**
	 * Returns a new object of class '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept</em>'.
	 * @generated
	 */
	Concept createConcept();

	/**
	 * Returns a new object of class '<em>Meta Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Symbol</em>'.
	 * @generated
	 */
	MetaSymbol createMetaSymbol();

	/**
	 * Returns a new object of class '<em>Syntax Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Syntax Expression</em>'.
	 * @generated
	 */
	SyntaxExpression createSyntaxExpression();

	/**
	 * Returns a new object of class '<em>L3 Syntax Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L3 Syntax Expression</em>'.
	 * @generated
	 */
	L3SyntaxExpression createL3SyntaxExpression();

	/**
	 * Returns a new object of class '<em>L2 Syntax Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L2 Syntax Expression</em>'.
	 * @generated
	 */
	L2SyntaxExpression createL2SyntaxExpression();

	/**
	 * Returns a new object of class '<em>Symbol Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbol Sequence</em>'.
	 * @generated
	 */
	SymbolSequence createSymbolSequence();

	/**
	 * Returns a new object of class '<em>L1 Syntax Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L1 Syntax Expression</em>'.
	 * @generated
	 */
	L1SyntaxExpression createL1SyntaxExpression();

	/**
	 * Returns a new object of class '<em>Structural Symbol Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Symbol Reference</em>'.
	 * @generated
	 */
	StructuralSymbolReference createStructuralSymbolReference();

	/**
	 * Returns a new object of class '<em>Plain Symbol Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plain Symbol Reference</em>'.
	 * @generated
	 */
	PlainSymbolReference createPlainSymbolReference();

	/**
	 * Returns a new object of class '<em>Id Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Symbol</em>'.
	 * @generated
	 */
	IdSymbol createIdSymbol();

	/**
	 * Returns a new object of class '<em>Int Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Symbol</em>'.
	 * @generated
	 */
	IntSymbol createIntSymbol();

	/**
	 * Returns a new object of class '<em>String Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Symbol</em>'.
	 * @generated
	 */
	StringSymbol createStringSymbol();

	/**
	 * Returns a new object of class '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Keyword</em>'.
	 * @generated
	 */
	Keyword createKeyword();

	/**
	 * Returns a new object of class '<em>Meta Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Expr</em>'.
	 * @generated
	 */
	MetaExpr createMetaExpr();

	/**
	 * Returns a new object of class '<em>Target Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Statement</em>'.
	 * @generated
	 */
	TargetStatement createTargetStatement();

	/**
	 * Returns a new object of class '<em>Create Id Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Id Statement</em>'.
	 * @generated
	 */
	CreateIdStatement createCreateIdStatement();

	/**
	 * Returns a new object of class '<em>Expansion Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expansion Statement</em>'.
	 * @generated
	 */
	ExpansionStatement createExpansionStatement();

	/**
	 * Returns a new object of class '<em>Expand Text Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Text Part</em>'.
	 * @generated
	 */
	ExpandTextPart createExpandTextPart();

	/**
	 * Returns a new object of class '<em>Expand Variable Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Variable Part</em>'.
	 * @generated
	 */
	ExpandVariablePart createExpandVariablePart();

	/**
	 * Returns a new object of class '<em>Expand Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Expression</em>'.
	 * @generated
	 */
	ExpandExpression createExpandExpression();

	/**
	 * Returns a new object of class '<em>Expand Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Statement</em>'.
	 * @generated
	 */
	ExpandStatement createExpandStatement();

	/**
	 * Returns a new object of class '<em>Code Quote Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Quote Expression</em>'.
	 * @generated
	 */
	CodeQuoteExpression createCodeQuoteExpression();

	/**
	 * Returns a new object of class '<em>Quoted Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Code</em>'.
	 * @generated
	 */
	QuotedCode createQuotedCode();

	/**
	 * Returns a new object of class '<em>Quoted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Expression</em>'.
	 * @generated
	 */
	QuotedExpression createQuotedExpression();

	/**
	 * Returns a new object of class '<em>Quoted Statements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Statements</em>'.
	 * @generated
	 */
	QuotedStatements createQuotedStatements();

	/**
	 * Returns a new object of class '<em>Quoted Class Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Class Content</em>'.
	 * @generated
	 */
	QuotedClassContent createQuotedClassContent();

	/**
	 * Returns a new object of class '<em>Quoted Module Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Module Content</em>'.
	 * @generated
	 */
	QuotedModuleContent createQuotedModuleContent();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Test Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Statement</em>'.
	 * @generated
	 */
	TestStatement createTestStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DblPackage getDblPackage();

} //DblFactory
