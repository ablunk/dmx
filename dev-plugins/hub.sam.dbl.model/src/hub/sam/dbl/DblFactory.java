/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	 * Returns a new object of class '<em>Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedure</em>'.
	 * @generated
	 */
	Procedure createProcedure();

	/**
	 * Returns a new object of class '<em>Simple Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Annotation</em>'.
	 * @generated
	 */
	SimpleAnnotation createSimpleAnnotation();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Annotation Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Application</em>'.
	 * @generated
	 */
	AnnotationApplication createAnnotationApplication();

	/**
	 * Returns a new object of class '<em>Key Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Value Pair</em>'.
	 * @generated
	 */
	KeyValuePair createKeyValuePair();

	/**
	 * Returns a new object of class '<em>Native Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Native Binding</em>'.
	 * @generated
	 */
	NativeBinding createNativeBinding();

	/**
	 * Returns a new object of class '<em>Start Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Code Block</em>'.
	 * @generated
	 */
	StartCodeBlock createStartCodeBlock();

	/**
	 * Returns a new object of class '<em>Clazz</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clazz</em>'.
	 * @generated
	 */
	Clazz createClazz();

	/**
	 * Returns a new object of class '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constructor</em>'.
	 * @generated
	 */
	Constructor createConstructor();

	/**
	 * Returns a new object of class '<em>Class Augment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Augment</em>'.
	 * @generated
	 */
	ClassAugment createClassAugment();

	/**
	 * Returns a new object of class '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface</em>'.
	 * @generated
	 */
	Interface createInterface();

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
	 * Returns a new object of class '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Block</em>'.
	 * @generated
	 */
	CodeBlock createCodeBlock();

	/**
	 * Returns a new object of class '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement</em>'.
	 * @generated
	 */
	Statement createStatement();

	/**
	 * Returns a new object of class '<em>Composite Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Statement</em>'.
	 * @generated
	 */
	CompositeStatement createCompositeStatement();

	/**
	 * Returns a new object of class '<em>Simple Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Statement</em>'.
	 * @generated
	 */
	SimpleStatement createSimpleStatement();

	/**
	 * Returns a new object of class '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Statement</em>'.
	 * @generated
	 */
	ExpressionStatement createExpressionStatement();

	/**
	 * Returns a new object of class '<em>Statement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statement Expression</em>'.
	 * @generated
	 */
	StatementExpression createStatementExpression();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Deprecated Procedure Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deprecated Procedure Call Statement</em>'.
	 * @generated
	 */
	DeprecatedProcedureCallStatement createDeprecatedProcedureCallStatement();

	/**
	 * Returns a new object of class '<em>Procedure Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedure Call</em>'.
	 * @generated
	 */
	ProcedureCall createProcedureCall();

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
	 * Returns a new object of class '<em>Remove From Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove From Set</em>'.
	 * @generated
	 */
	RemoveFromSet createRemoveFromSet();

	/**
	 * Returns a new object of class '<em>Add To Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add To Set</em>'.
	 * @generated
	 */
	AddToSet createAddToSet();

	/**
	 * Returns a new object of class '<em>Empty Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty Set</em>'.
	 * @generated
	 */
	EmptySet createEmptySet();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
	WhileStatement createWhileStatement();

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
	 * Returns a new object of class '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Statement</em>'.
	 * @generated
	 */
	ForEachStatement createForEachStatement();

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
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>Create Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Object</em>'.
	 * @generated
	 */
	CreateObject createCreateObject();

	/**
	 * Returns a new object of class '<em>Cast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cast</em>'.
	 * @generated
	 */
	Cast createCast();

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
	 * Returns a new object of class '<em>Eval Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval Expr</em>'.
	 * @generated
	 */
	EvalExpr createEvalExpr();

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
	 * Returns a new object of class '<em>Size Of Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Size Of Set</em>'.
	 * @generated
	 */
	SizeOfSet createSizeOfSet();

	/**
	 * Returns a new object of class '<em>First In Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>First In Set</em>'.
	 * @generated
	 */
	FirstInSet createFirstInSet();

	/**
	 * Returns a new object of class '<em>Last In Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Last In Set</em>'.
	 * @generated
	 */
	LastInSet createLastInSet();

	/**
	 * Returns a new object of class '<em>Contains</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains</em>'.
	 * @generated
	 */
	Contains createContains();

	/**
	 * Returns a new object of class '<em>Index Of</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Of</em>'.
	 * @generated
	 */
	IndexOf createIndexOf();

	/**
	 * Returns a new object of class '<em>Object At</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object At</em>'.
	 * @generated
	 */
	ObjectAt createObjectAt();

	/**
	 * Returns a new object of class '<em>Before In Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Before In Set</em>'.
	 * @generated
	 */
	BeforeInSet createBeforeInSet();

	/**
	 * Returns a new object of class '<em>After In Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>After In Set</em>'.
	 * @generated
	 */
	AfterInSet createAfterInSet();

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
	 * Returns a new object of class '<em>Predefined Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predefined Id</em>'.
	 * @generated
	 */
	PredefinedId createPredefinedId();

	/**
	 * Returns a new object of class '<em>Id Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Expr</em>'.
	 * @generated
	 */
	IdExpr createIdExpr();

	/**
	 * Returns a new object of class '<em>Argument Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Argument Expression</em>'.
	 * @generated
	 */
	ArgumentExpression createArgumentExpression();

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
	 * Returns a new object of class '<em>Named Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Extension</em>'.
	 * @generated
	 */
	NamedExtension createNamedExtension();

	/**
	 * Returns a new object of class '<em>Class Content Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Content Extension</em>'.
	 * @generated
	 */
	ClassContentExtension createClassContentExtension();

	/**
	 * Returns a new object of class '<em>Module Content Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Content Extension</em>'.
	 * @generated
	 */
	ModuleContentExtension createModuleContentExtension();

	/**
	 * Returns a new object of class '<em>Extension Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Definition</em>'.
	 * @generated
	 */
	ExtensionDefinition createExtensionDefinition();

	/**
	 * Returns a new object of class '<em>Textual Syntax Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Textual Syntax Def</em>'.
	 * @generated
	 */
	TextualSyntaxDef createTextualSyntaxDef();

	/**
	 * Returns a new object of class '<em>Ts Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ts Rule</em>'.
	 * @generated
	 */
	TsRule createTsRule();

	/**
	 * Returns a new object of class '<em>Extension Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Rule</em>'.
	 * @generated
	 */
	ExtensionRule createExtensionRule();

	/**
	 * Returns a new object of class '<em>Sequence Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Expr</em>'.
	 * @generated
	 */
	SequenceExpr createSequenceExpr();

	/**
	 * Returns a new object of class '<em>Optional Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Optional Expr</em>'.
	 * @generated
	 */
	OptionalExpr createOptionalExpr();

	/**
	 * Returns a new object of class '<em>Runtime Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Runtime Expr</em>'.
	 * @generated
	 */
	RuntimeExpr createRuntimeExpr();

	/**
	 * Returns a new object of class '<em>At Least One Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>At Least One Expr</em>'.
	 * @generated
	 */
	AtLeastOneExpr createAtLeastOneExpr();

	/**
	 * Returns a new object of class '<em>Arbitrary Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arbitrary Expr</em>'.
	 * @generated
	 */
	ArbitraryExpr createArbitraryExpr();

	/**
	 * Returns a new object of class '<em>Alternative Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternative Expr</em>'.
	 * @generated
	 */
	AlternativeExpr createAlternativeExpr();

	/**
	 * Returns a new object of class '<em>Terminal Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminal Expr</em>'.
	 * @generated
	 */
	TerminalExpr createTerminalExpr();

	/**
	 * Returns a new object of class '<em>Property Binding Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Binding Expr</em>'.
	 * @generated
	 */
	PropertyBindingExpr createPropertyBindingExpr();

	/**
	 * Returns a new object of class '<em>Rule Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Expr</em>'.
	 * @generated
	 */
	RuleExpr createRuleExpr();

	/**
	 * Returns a new object of class '<em>Id Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Property Type</em>'.
	 * @generated
	 */
	IdPropertyType createIdPropertyType();

	/**
	 * Returns a new object of class '<em>Int Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Property Type</em>'.
	 * @generated
	 */
	IntPropertyType createIntPropertyType();

	/**
	 * Returns a new object of class '<em>String Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Property Type</em>'.
	 * @generated
	 */
	StringPropertyType createStringPropertyType();

	/**
	 * Returns a new object of class '<em>Boolean Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Property Type</em>'.
	 * @generated
	 */
	BooleanPropertyType createBooleanPropertyType();

	/**
	 * Returns a new object of class '<em>Structured Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Property Type</em>'.
	 * @generated
	 */
	StructuredPropertyType createStructuredPropertyType();

	/**
	 * Returns a new object of class '<em>Composite Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Property Type</em>'.
	 * @generated
	 */
	CompositePropertyType createCompositePropertyType();

	/**
	 * Returns a new object of class '<em>Reference Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Property Type</em>'.
	 * @generated
	 */
	ReferencePropertyType createReferencePropertyType();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

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
	 * Returns a new object of class '<em>Mapping Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Statement</em>'.
	 * @generated
	 */
	MappingStatement createMappingStatement();

	/**
	 * Returns a new object of class '<em>Set Gen Context Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Gen Context Statement</em>'.
	 * @generated
	 */
	SetGenContextStatement createSetGenContextStatement();

	/**
	 * Returns a new object of class '<em>Reset Gen Context Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reset Gen Context Statement</em>'.
	 * @generated
	 */
	ResetGenContextStatement createResetGenContextStatement();

	/**
	 * Returns a new object of class '<em>Save Gen Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Save Gen Statement</em>'.
	 * @generated
	 */
	SaveGenStatement createSaveGenStatement();

	/**
	 * Returns a new object of class '<em>Resume Gen Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resume Gen Statement</em>'.
	 * @generated
	 */
	ResumeGenStatement createResumeGenStatement();

	/**
	 * Returns a new object of class '<em>Fixed Mapping Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Mapping Part</em>'.
	 * @generated
	 */
	FixedMappingPart createFixedMappingPart();

	/**
	 * Returns a new object of class '<em>Dynamic Mapping Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Mapping Part</em>'.
	 * @generated
	 */
	DynamicMappingPart createDynamicMappingPart();

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
	 * Returns a new object of class '<em>Expand Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Section</em>'.
	 * @generated
	 */
	ExpandSection createExpandSection();

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
	 * Returns a new object of class '<em>Expandable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expandable Element</em>'.
	 * @generated
	 */
	ExpandableElement createExpandableElement();

	/**
	 * Returns a new object of class '<em>Test Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Statement</em>'.
	 * @generated
	 */
	TestStatement createTestStatement();

	/**
	 * Returns a new object of class '<em>Id Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Resolution</em>'.
	 * @generated
	 */
	IdResolution createIdResolution();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Potentially Hidden Id Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Potentially Hidden Id Elements</em>'.
	 * @generated
	 */
	PotentiallyHiddenIdElements createPotentiallyHiddenIdElements();

	/**
	 * Returns a new object of class '<em>Find Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Find Container</em>'.
	 * @generated
	 */
	FindContainer createFindContainer();

	/**
	 * Returns a new object of class '<em>Consider Id Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consider Id Elements</em>'.
	 * @generated
	 */
	ConsiderIdElements createConsiderIdElements();

	/**
	 * Returns a new object of class '<em>Include Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Include Pattern</em>'.
	 * @generated
	 */
	IncludePattern createIncludePattern();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DblPackage getDblPackage();

} //DblFactory