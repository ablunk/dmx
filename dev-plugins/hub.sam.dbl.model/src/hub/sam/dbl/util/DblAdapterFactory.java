/**
 */
package hub.sam.dbl.util;

import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.ActivateObject;
import hub.sam.dbl.ActiveLiteral;
import hub.sam.dbl.Advance;
import hub.sam.dbl.And;
import hub.sam.dbl.AnnotateableElement;
import hub.sam.dbl.Annotation;
import hub.sam.dbl.AnnotationItem;
import hub.sam.dbl.AnnotationLiteral;
import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.Assignment;
import hub.sam.dbl.BinaryOperator;
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
import hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.ContinueStatement;
import hub.sam.dbl.CreateIdStatement;
import hub.sam.dbl.CreateObject;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Div;
import hub.sam.dbl.DoubleLiteral;
import hub.sam.dbl.DoubleType;
import hub.sam.dbl.ElementAccess;
import hub.sam.dbl.ElementarySymbol;
import hub.sam.dbl.Equal;
import hub.sam.dbl.ExpandExpr;
import hub.sam.dbl.ExpandExpression;
import hub.sam.dbl.ExpandStatement;
import hub.sam.dbl.ExpandTextPart;
import hub.sam.dbl.ExpandVariablePart;
import hub.sam.dbl.ExpansionPart;
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
import hub.sam.dbl.PrimitiveType;
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
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.SwitchCase;
import hub.sam.dbl.SwitchStatement;
import hub.sam.dbl.SymbolSequence;
import hub.sam.dbl.SyntaxDefinition;
import hub.sam.dbl.SyntaxExpression;
import hub.sam.dbl.SyntaxSymbolClassifier;
import hub.sam.dbl.TargetStatement;
import hub.sam.dbl.Terminate;
import hub.sam.dbl.TestStatement;
import hub.sam.dbl.TimeLiteral;
import hub.sam.dbl.TrueLiteral;
import hub.sam.dbl.Type;
import hub.sam.dbl.TypeAccess;
import hub.sam.dbl.TypeLiteral;
import hub.sam.dbl.TypedElement;
import hub.sam.dbl.UnaryOperator;
import hub.sam.dbl.Variable;
import hub.sam.dbl.VariableAccess;
import hub.sam.dbl.VoidType;
import hub.sam.dbl.Wait;
import hub.sam.dbl.WaitUntil;
import hub.sam.dbl.WhileStatement;
import hub.sam.dbl.Yield;
import hub.sam.dbl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see hub.sam.dbl.DblPackage
 * @generated
 */
public class DblAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DblPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DblAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DblPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DblSwitch<Adapter> modelSwitch =
		new DblSwitch<Adapter>() {
			@Override
			public Adapter caseConstruct(Construct object) {
				return createConstructAdapter();
			}
			@Override
			public Adapter caseExtensibleElement(ExtensibleElement object) {
				return createExtensibleElementAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseImport(Import object) {
				return createImportAdapter();
			}
			@Override
			public Adapter caseModule(Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseAnnotationItem(AnnotationItem object) {
				return createAnnotationItemAdapter();
			}
			@Override
			public Adapter caseAnnotateableElement(AnnotateableElement object) {
				return createAnnotateableElementAdapter();
			}
			@Override
			public Adapter caseConstructiveExtension(ConstructiveExtension object) {
				return createConstructiveExtensionAdapter();
			}
			@Override
			public Adapter caseConstructiveExtensionAtContentExtensionPoint(ConstructiveExtensionAtContentExtensionPoint object) {
				return createConstructiveExtensionAtContentExtensionPointAdapter();
			}
			@Override
			public Adapter caseModuleContentExtension(ModuleContentExtension object) {
				return createModuleContentExtensionAdapter();
			}
			@Override
			public Adapter caseClassContentExtension(ClassContentExtension object) {
				return createClassContentExtensionAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseArrayDimension(ArrayDimension object) {
				return createArrayDimensionAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object) {
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseVoidType(VoidType object) {
				return createVoidTypeAdapter();
			}
			@Override
			public Adapter caseIntType(IntType object) {
				return createIntTypeAdapter();
			}
			@Override
			public Adapter caseBoolType(BoolType object) {
				return createBoolTypeAdapter();
			}
			@Override
			public Adapter caseDoubleType(DoubleType object) {
				return createDoubleTypeAdapter();
			}
			@Override
			public Adapter caseStringType(StringType object) {
				return createStringTypeAdapter();
			}
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseNativeBinding(NativeBinding object) {
				return createNativeBindingAdapter();
			}
			@Override
			public Adapter caseSuperClassSpecification(SuperClassSpecification object) {
				return createSuperClassSpecificationAdapter();
			}
			@Override
			public Adapter caseClass(hub.sam.dbl.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseConstructor(Constructor object) {
				return createConstructorAdapter();
			}
			@Override
			public Adapter caseAbstractVariable(AbstractVariable object) {
				return createAbstractVariableAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseLoopStatement(LoopStatement object) {
				return createLoopStatementAdapter();
			}
			@Override
			public Adapter caseSimpleStatement(SimpleStatement object) {
				return createSimpleStatementAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object) {
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseFunctionCall(FunctionCall object) {
				return createFunctionCallAdapter();
			}
			@Override
			public Adapter caseReturn(Return object) {
				return createReturnAdapter();
			}
			@Override
			public Adapter caseWaitUntil(WaitUntil object) {
				return createWaitUntilAdapter();
			}
			@Override
			public Adapter caseTerminate(Terminate object) {
				return createTerminateAdapter();
			}
			@Override
			public Adapter caseYield(Yield object) {
				return createYieldAdapter();
			}
			@Override
			public Adapter caseWait(Wait object) {
				return createWaitAdapter();
			}
			@Override
			public Adapter caseReactivate(Reactivate object) {
				return createReactivateAdapter();
			}
			@Override
			public Adapter caseActivateObject(ActivateObject object) {
				return createActivateObjectAdapter();
			}
			@Override
			public Adapter caseAdvance(Advance object) {
				return createAdvanceAdapter();
			}
			@Override
			public Adapter casePrint(Print object) {
				return createPrintAdapter();
			}
			@Override
			public Adapter caseIfStatement(IfStatement object) {
				return createIfStatementAdapter();
			}
			@Override
			public Adapter caseLocalScope(LocalScope object) {
				return createLocalScopeAdapter();
			}
			@Override
			public Adapter caseLocalScopeStatement(LocalScopeStatement object) {
				return createLocalScopeStatementAdapter();
			}
			@Override
			public Adapter caseForStatement(ForStatement object) {
				return createForStatementAdapter();
			}
			@Override
			public Adapter caseWhileStatement(WhileStatement object) {
				return createWhileStatementAdapter();
			}
			@Override
			public Adapter caseSwitchStatement(SwitchStatement object) {
				return createSwitchStatementAdapter();
			}
			@Override
			public Adapter caseSwitchCase(SwitchCase object) {
				return createSwitchCaseAdapter();
			}
			@Override
			public Adapter caseBreakStatement(BreakStatement object) {
				return createBreakStatementAdapter();
			}
			@Override
			public Adapter caseContinueStatement(ContinueStatement object) {
				return createContinueStatementAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseL1Expr(L1Expr object) {
				return createL1ExprAdapter();
			}
			@Override
			public Adapter caseL2Expr(L2Expr object) {
				return createL2ExprAdapter();
			}
			@Override
			public Adapter caseL3Expr(L3Expr object) {
				return createL3ExprAdapter();
			}
			@Override
			public Adapter caseL4Expr(L4Expr object) {
				return createL4ExprAdapter();
			}
			@Override
			public Adapter caseL5Expr(L5Expr object) {
				return createL5ExprAdapter();
			}
			@Override
			public Adapter caseL6Expr(L6Expr object) {
				return createL6ExprAdapter();
			}
			@Override
			public Adapter caseL7Expr(L7Expr object) {
				return createL7ExprAdapter();
			}
			@Override
			public Adapter caseL8Expr(L8Expr object) {
				return createL8ExprAdapter();
			}
			@Override
			public Adapter caseL9Expr(L9Expr object) {
				return createL9ExprAdapter();
			}
			@Override
			public Adapter caseBinaryOperator(BinaryOperator object) {
				return createBinaryOperatorAdapter();
			}
			@Override
			public Adapter caseUnaryOperator(UnaryOperator object) {
				return createUnaryOperatorAdapter();
			}
			@Override
			public Adapter caseOr(Or object) {
				return createOrAdapter();
			}
			@Override
			public Adapter caseAnd(And object) {
				return createAndAdapter();
			}
			@Override
			public Adapter caseNotEqual(NotEqual object) {
				return createNotEqualAdapter();
			}
			@Override
			public Adapter caseEqual(Equal object) {
				return createEqualAdapter();
			}
			@Override
			public Adapter caseGreater(Greater object) {
				return createGreaterAdapter();
			}
			@Override
			public Adapter caseGreaterEqual(GreaterEqual object) {
				return createGreaterEqualAdapter();
			}
			@Override
			public Adapter caseLess(Less object) {
				return createLessAdapter();
			}
			@Override
			public Adapter caseLessEqual(LessEqual object) {
				return createLessEqualAdapter();
			}
			@Override
			public Adapter caseInstanceOf(InstanceOf object) {
				return createInstanceOfAdapter();
			}
			@Override
			public Adapter casePlus(Plus object) {
				return createPlusAdapter();
			}
			@Override
			public Adapter caseMinus(Minus object) {
				return createMinusAdapter();
			}
			@Override
			public Adapter caseMul(Mul object) {
				return createMulAdapter();
			}
			@Override
			public Adapter caseMod(Mod object) {
				return createModAdapter();
			}
			@Override
			public Adapter caseDiv(Div object) {
				return createDivAdapter();
			}
			@Override
			public Adapter caseNeg(Neg object) {
				return createNegAdapter();
			}
			@Override
			public Adapter caseNot(Not object) {
				return createNotAdapter();
			}
			@Override
			public Adapter caseCast(Cast object) {
				return createCastAdapter();
			}
			@Override
			public Adapter caseCreateObject(CreateObject object) {
				return createCreateObjectAdapter();
			}
			@Override
			public Adapter caseNullLiteral(NullLiteral object) {
				return createNullLiteralAdapter();
			}
			@Override
			public Adapter caseTimeLiteral(TimeLiteral object) {
				return createTimeLiteralAdapter();
			}
			@Override
			public Adapter caseActiveLiteral(ActiveLiteral object) {
				return createActiveLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseIntLiteral(IntLiteral object) {
				return createIntLiteralAdapter();
			}
			@Override
			public Adapter caseTrueLiteral(TrueLiteral object) {
				return createTrueLiteralAdapter();
			}
			@Override
			public Adapter caseFalseLiteral(FalseLiteral object) {
				return createFalseLiteralAdapter();
			}
			@Override
			public Adapter caseDoubleLiteral(DoubleLiteral object) {
				return createDoubleLiteralAdapter();
			}
			@Override
			public Adapter caseExpandExpr(ExpandExpr object) {
				return createExpandExprAdapter();
			}
			@Override
			public Adapter caseParseExpr(ParseExpr object) {
				return createParseExprAdapter();
			}
			@Override
			public Adapter casePredefinedId(PredefinedId object) {
				return createPredefinedIdAdapter();
			}
			@Override
			public Adapter caseMeLiteral(MeLiteral object) {
				return createMeLiteralAdapter();
			}
			@Override
			public Adapter caseSuperLiteral(SuperLiteral object) {
				return createSuperLiteralAdapter();
			}
			@Override
			public Adapter caseMetaLiteral(MetaLiteral object) {
				return createMetaLiteralAdapter();
			}
			@Override
			public Adapter caseTypeLiteral(TypeLiteral object) {
				return createTypeLiteralAdapter();
			}
			@Override
			public Adapter caseSizeOfArray(SizeOfArray object) {
				return createSizeOfArrayAdapter();
			}
			@Override
			public Adapter caseAnnotationLiteral(AnnotationLiteral object) {
				return createAnnotationLiteralAdapter();
			}
			@Override
			public Adapter caseIdExpr(IdExpr object) {
				return createIdExprAdapter();
			}
			@Override
			public Adapter caseCallPart(CallPart object) {
				return createCallPartAdapter();
			}
			@Override
			public Adapter caseElementAccess(ElementAccess object) {
				return createElementAccessAdapter();
			}
			@Override
			public Adapter caseVariableAccess(VariableAccess object) {
				return createVariableAccessAdapter();
			}
			@Override
			public Adapter caseMetaAccess(MetaAccess object) {
				return createMetaAccessAdapter();
			}
			@Override
			public Adapter caseTypeAccess(TypeAccess object) {
				return createTypeAccessAdapter();
			}
			@Override
			public Adapter caseExtension(Extension object) {
				return createExtensionAdapter();
			}
			@Override
			public Adapter caseExtensionSemantics(ExtensionSemantics object) {
				return createExtensionSemanticsAdapter();
			}
			@Override
			public Adapter caseSyntaxDefinition(SyntaxDefinition object) {
				return createSyntaxDefinitionAdapter();
			}
			@Override
			public Adapter caseSyntaxSymbolClassifier(SyntaxSymbolClassifier object) {
				return createSyntaxSymbolClassifierAdapter();
			}
			@Override
			public Adapter caseComplexSymbol(ComplexSymbol object) {
				return createComplexSymbolAdapter();
			}
			@Override
			public Adapter caseConcept(Concept object) {
				return createConceptAdapter();
			}
			@Override
			public Adapter caseMetaSymbol(MetaSymbol object) {
				return createMetaSymbolAdapter();
			}
			@Override
			public Adapter caseSyntaxExpression(SyntaxExpression object) {
				return createSyntaxExpressionAdapter();
			}
			@Override
			public Adapter caseL3SyntaxExpression(L3SyntaxExpression object) {
				return createL3SyntaxExpressionAdapter();
			}
			@Override
			public Adapter caseL2SyntaxExpression(L2SyntaxExpression object) {
				return createL2SyntaxExpressionAdapter();
			}
			@Override
			public Adapter caseSymbolSequence(SymbolSequence object) {
				return createSymbolSequenceAdapter();
			}
			@Override
			public Adapter caseL1SyntaxExpression(L1SyntaxExpression object) {
				return createL1SyntaxExpressionAdapter();
			}
			@Override
			public Adapter caseStructuralSymbolReference(StructuralSymbolReference object) {
				return createStructuralSymbolReferenceAdapter();
			}
			@Override
			public Adapter casePlainSymbolReference(PlainSymbolReference object) {
				return createPlainSymbolReferenceAdapter();
			}
			@Override
			public Adapter caseElementarySymbol(ElementarySymbol object) {
				return createElementarySymbolAdapter();
			}
			@Override
			public Adapter caseIdSymbol(IdSymbol object) {
				return createIdSymbolAdapter();
			}
			@Override
			public Adapter caseIntSymbol(IntSymbol object) {
				return createIntSymbolAdapter();
			}
			@Override
			public Adapter caseStringSymbol(StringSymbol object) {
				return createStringSymbolAdapter();
			}
			@Override
			public Adapter caseKeyword(Keyword object) {
				return createKeywordAdapter();
			}
			@Override
			public Adapter caseMetaExpr(MetaExpr object) {
				return createMetaExprAdapter();
			}
			@Override
			public Adapter caseTargetStatement(TargetStatement object) {
				return createTargetStatementAdapter();
			}
			@Override
			public Adapter caseCreateIdStatement(CreateIdStatement object) {
				return createCreateIdStatementAdapter();
			}
			@Override
			public Adapter caseExpansionStatement(ExpansionStatement object) {
				return createExpansionStatementAdapter();
			}
			@Override
			public Adapter caseExpansionPart(ExpansionPart object) {
				return createExpansionPartAdapter();
			}
			@Override
			public Adapter caseExpandTextPart(ExpandTextPart object) {
				return createExpandTextPartAdapter();
			}
			@Override
			public Adapter caseExpandVariablePart(ExpandVariablePart object) {
				return createExpandVariablePartAdapter();
			}
			@Override
			public Adapter caseExpandExpression(ExpandExpression object) {
				return createExpandExpressionAdapter();
			}
			@Override
			public Adapter caseExpandStatement(ExpandStatement object) {
				return createExpandStatementAdapter();
			}
			@Override
			public Adapter caseCodeQuoteExpression(CodeQuoteExpression object) {
				return createCodeQuoteExpressionAdapter();
			}
			@Override
			public Adapter caseQuotedCode(QuotedCode object) {
				return createQuotedCodeAdapter();
			}
			@Override
			public Adapter caseQuotedExpression(QuotedExpression object) {
				return createQuotedExpressionAdapter();
			}
			@Override
			public Adapter caseQuotedStatements(QuotedStatements object) {
				return createQuotedStatementsAdapter();
			}
			@Override
			public Adapter caseQuotedClassContent(QuotedClassContent object) {
				return createQuotedClassContentAdapter();
			}
			@Override
			public Adapter caseQuotedModuleContent(QuotedModuleContent object) {
				return createQuotedModuleContentAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter caseTestStatement(TestStatement object) {
				return createTestStatementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Construct <em>Construct</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Construct
	 * @generated
	 */
	public Adapter createConstructAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExtensibleElement
	 * @generated
	 */
	public Adapter createExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.AnnotationItem <em>Annotation Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.AnnotationItem
	 * @generated
	 */
	public Adapter createAnnotationItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.AnnotateableElement <em>Annotateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.AnnotateableElement
	 * @generated
	 */
	public Adapter createAnnotateableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ConstructiveExtension <em>Constructive Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ConstructiveExtension
	 * @generated
	 */
	public Adapter createConstructiveExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint <em>Constructive Extension At Content Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint
	 * @generated
	 */
	public Adapter createConstructiveExtensionAtContentExtensionPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ModuleContentExtension <em>Module Content Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ModuleContentExtension
	 * @generated
	 */
	public Adapter createModuleContentExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ClassContentExtension <em>Class Content Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ClassContentExtension
	 * @generated
	 */
	public Adapter createClassContentExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ArrayDimension <em>Array Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ArrayDimension
	 * @generated
	 */
	public Adapter createArrayDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.VoidType
	 * @generated
	 */
	public Adapter createVoidTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.IntType <em>Int Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.IntType
	 * @generated
	 */
	public Adapter createIntTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.BoolType <em>Bool Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.BoolType
	 * @generated
	 */
	public Adapter createBoolTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.DoubleType
	 * @generated
	 */
	public Adapter createDoubleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.StringType
	 * @generated
	 */
	public Adapter createStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.NativeBinding <em>Native Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.NativeBinding
	 * @generated
	 */
	public Adapter createNativeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SuperClassSpecification <em>Super Class Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SuperClassSpecification
	 * @generated
	 */
	public Adapter createSuperClassSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Constructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Constructor
	 * @generated
	 */
	public Adapter createConstructorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.AbstractVariable
	 * @generated
	 */
	public Adapter createAbstractVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.LoopStatement <em>Loop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.LoopStatement
	 * @generated
	 */
	public Adapter createLoopStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SimpleStatement <em>Simple Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SimpleStatement
	 * @generated
	 */
	public Adapter createSimpleStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.FunctionCall
	 * @generated
	 */
	public Adapter createFunctionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Return
	 * @generated
	 */
	public Adapter createReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.WaitUntil <em>Wait Until</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.WaitUntil
	 * @generated
	 */
	public Adapter createWaitUntilAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Terminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Terminate
	 * @generated
	 */
	public Adapter createTerminateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Yield <em>Yield</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Yield
	 * @generated
	 */
	public Adapter createYieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Wait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Wait
	 * @generated
	 */
	public Adapter createWaitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Reactivate <em>Reactivate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Reactivate
	 * @generated
	 */
	public Adapter createReactivateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ActivateObject <em>Activate Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ActivateObject
	 * @generated
	 */
	public Adapter createActivateObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Advance <em>Advance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Advance
	 * @generated
	 */
	public Adapter createAdvanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Print
	 * @generated
	 */
	public Adapter createPrintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.IfStatement
	 * @generated
	 */
	public Adapter createIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.LocalScope <em>Local Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.LocalScope
	 * @generated
	 */
	public Adapter createLocalScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.LocalScopeStatement <em>Local Scope Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.LocalScopeStatement
	 * @generated
	 */
	public Adapter createLocalScopeStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ForStatement
	 * @generated
	 */
	public Adapter createForStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.WhileStatement
	 * @generated
	 */
	public Adapter createWhileStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SwitchStatement
	 * @generated
	 */
	public Adapter createSwitchStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SwitchCase <em>Switch Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SwitchCase
	 * @generated
	 */
	public Adapter createSwitchCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.BreakStatement
	 * @generated
	 */
	public Adapter createBreakStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ContinueStatement
	 * @generated
	 */
	public Adapter createContinueStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L1Expr <em>L1 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L1Expr
	 * @generated
	 */
	public Adapter createL1ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L2Expr <em>L2 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L2Expr
	 * @generated
	 */
	public Adapter createL2ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L3Expr <em>L3 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L3Expr
	 * @generated
	 */
	public Adapter createL3ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L4Expr <em>L4 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L4Expr
	 * @generated
	 */
	public Adapter createL4ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L5Expr <em>L5 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L5Expr
	 * @generated
	 */
	public Adapter createL5ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L6Expr <em>L6 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L6Expr
	 * @generated
	 */
	public Adapter createL6ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L7Expr <em>L7 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L7Expr
	 * @generated
	 */
	public Adapter createL7ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L8Expr <em>L8 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L8Expr
	 * @generated
	 */
	public Adapter createL8ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L9Expr <em>L9 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L9Expr
	 * @generated
	 */
	public Adapter createL9ExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.BinaryOperator
	 * @generated
	 */
	public Adapter createBinaryOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.UnaryOperator
	 * @generated
	 */
	public Adapter createUnaryOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Or
	 * @generated
	 */
	public Adapter createOrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.And
	 * @generated
	 */
	public Adapter createAndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.NotEqual <em>Not Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.NotEqual
	 * @generated
	 */
	public Adapter createNotEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Equal
	 * @generated
	 */
	public Adapter createEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Greater <em>Greater</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Greater
	 * @generated
	 */
	public Adapter createGreaterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.GreaterEqual <em>Greater Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.GreaterEqual
	 * @generated
	 */
	public Adapter createGreaterEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Less <em>Less</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Less
	 * @generated
	 */
	public Adapter createLessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.LessEqual <em>Less Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.LessEqual
	 * @generated
	 */
	public Adapter createLessEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.InstanceOf <em>Instance Of</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.InstanceOf
	 * @generated
	 */
	public Adapter createInstanceOfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Plus
	 * @generated
	 */
	public Adapter createPlusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Minus
	 * @generated
	 */
	public Adapter createMinusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Mul <em>Mul</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Mul
	 * @generated
	 */
	public Adapter createMulAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Mod <em>Mod</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Mod
	 * @generated
	 */
	public Adapter createModAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Div <em>Div</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Div
	 * @generated
	 */
	public Adapter createDivAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Neg <em>Neg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Neg
	 * @generated
	 */
	public Adapter createNegAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Not
	 * @generated
	 */
	public Adapter createNotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Cast <em>Cast</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Cast
	 * @generated
	 */
	public Adapter createCastAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.CreateObject <em>Create Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.CreateObject
	 * @generated
	 */
	public Adapter createCreateObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.NullLiteral
	 * @generated
	 */
	public Adapter createNullLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TimeLiteral <em>Time Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TimeLiteral
	 * @generated
	 */
	public Adapter createTimeLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ActiveLiteral <em>Active Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ActiveLiteral
	 * @generated
	 */
	public Adapter createActiveLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.IntLiteral
	 * @generated
	 */
	public Adapter createIntLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TrueLiteral <em>True Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TrueLiteral
	 * @generated
	 */
	public Adapter createTrueLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.FalseLiteral <em>False Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.FalseLiteral
	 * @generated
	 */
	public Adapter createFalseLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.DoubleLiteral
	 * @generated
	 */
	public Adapter createDoubleLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpandExpr <em>Expand Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpandExpr
	 * @generated
	 */
	public Adapter createExpandExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ParseExpr <em>Parse Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ParseExpr
	 * @generated
	 */
	public Adapter createParseExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.PredefinedId <em>Predefined Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.PredefinedId
	 * @generated
	 */
	public Adapter createPredefinedIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.MeLiteral <em>Me Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.MeLiteral
	 * @generated
	 */
	public Adapter createMeLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SuperLiteral <em>Super Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SuperLiteral
	 * @generated
	 */
	public Adapter createSuperLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.MetaLiteral <em>Meta Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.MetaLiteral
	 * @generated
	 */
	public Adapter createMetaLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TypeLiteral
	 * @generated
	 */
	public Adapter createTypeLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SizeOfArray <em>Size Of Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SizeOfArray
	 * @generated
	 */
	public Adapter createSizeOfArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.AnnotationLiteral <em>Annotation Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.AnnotationLiteral
	 * @generated
	 */
	public Adapter createAnnotationLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.IdExpr <em>Id Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.IdExpr
	 * @generated
	 */
	public Adapter createIdExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.CallPart <em>Call Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.CallPart
	 * @generated
	 */
	public Adapter createCallPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ElementAccess <em>Element Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ElementAccess
	 * @generated
	 */
	public Adapter createElementAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.VariableAccess
	 * @generated
	 */
	public Adapter createVariableAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.MetaAccess <em>Meta Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.MetaAccess
	 * @generated
	 */
	public Adapter createMetaAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TypeAccess <em>Type Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TypeAccess
	 * @generated
	 */
	public Adapter createTypeAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Extension
	 * @generated
	 */
	public Adapter createExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExtensionSemantics <em>Extension Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExtensionSemantics
	 * @generated
	 */
	public Adapter createExtensionSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SyntaxDefinition <em>Syntax Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SyntaxDefinition
	 * @generated
	 */
	public Adapter createSyntaxDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SyntaxSymbolClassifier <em>Syntax Symbol Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SyntaxSymbolClassifier
	 * @generated
	 */
	public Adapter createSyntaxSymbolClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ComplexSymbol <em>Complex Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ComplexSymbol
	 * @generated
	 */
	public Adapter createComplexSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Concept
	 * @generated
	 */
	public Adapter createConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.MetaSymbol <em>Meta Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.MetaSymbol
	 * @generated
	 */
	public Adapter createMetaSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SyntaxExpression <em>Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SyntaxExpression
	 * @generated
	 */
	public Adapter createSyntaxExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L3SyntaxExpression <em>L3 Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L3SyntaxExpression
	 * @generated
	 */
	public Adapter createL3SyntaxExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L2SyntaxExpression <em>L2 Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L2SyntaxExpression
	 * @generated
	 */
	public Adapter createL2SyntaxExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.SymbolSequence <em>Symbol Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.SymbolSequence
	 * @generated
	 */
	public Adapter createSymbolSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.L1SyntaxExpression <em>L1 Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.L1SyntaxExpression
	 * @generated
	 */
	public Adapter createL1SyntaxExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.StructuralSymbolReference <em>Structural Symbol Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.StructuralSymbolReference
	 * @generated
	 */
	public Adapter createStructuralSymbolReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.PlainSymbolReference <em>Plain Symbol Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.PlainSymbolReference
	 * @generated
	 */
	public Adapter createPlainSymbolReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ElementarySymbol <em>Elementary Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ElementarySymbol
	 * @generated
	 */
	public Adapter createElementarySymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.IdSymbol <em>Id Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.IdSymbol
	 * @generated
	 */
	public Adapter createIdSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.IntSymbol <em>Int Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.IntSymbol
	 * @generated
	 */
	public Adapter createIntSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.StringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.StringSymbol
	 * @generated
	 */
	public Adapter createStringSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Keyword
	 * @generated
	 */
	public Adapter createKeywordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.MetaExpr <em>Meta Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.MetaExpr
	 * @generated
	 */
	public Adapter createMetaExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TargetStatement <em>Target Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TargetStatement
	 * @generated
	 */
	public Adapter createTargetStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.CreateIdStatement <em>Create Id Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.CreateIdStatement
	 * @generated
	 */
	public Adapter createCreateIdStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpansionStatement <em>Expansion Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpansionStatement
	 * @generated
	 */
	public Adapter createExpansionStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpansionPart <em>Expansion Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpansionPart
	 * @generated
	 */
	public Adapter createExpansionPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpandTextPart <em>Expand Text Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpandTextPart
	 * @generated
	 */
	public Adapter createExpandTextPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpandVariablePart <em>Expand Variable Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpandVariablePart
	 * @generated
	 */
	public Adapter createExpandVariablePartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpandExpression <em>Expand Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpandExpression
	 * @generated
	 */
	public Adapter createExpandExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.ExpandStatement <em>Expand Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.ExpandStatement
	 * @generated
	 */
	public Adapter createExpandStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.CodeQuoteExpression <em>Code Quote Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.CodeQuoteExpression
	 * @generated
	 */
	public Adapter createCodeQuoteExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.QuotedCode <em>Quoted Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.QuotedCode
	 * @generated
	 */
	public Adapter createQuotedCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.QuotedExpression <em>Quoted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.QuotedExpression
	 * @generated
	 */
	public Adapter createQuotedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.QuotedStatements <em>Quoted Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.QuotedStatements
	 * @generated
	 */
	public Adapter createQuotedStatementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.QuotedClassContent <em>Quoted Class Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.QuotedClassContent
	 * @generated
	 */
	public Adapter createQuotedClassContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.QuotedModuleContent <em>Quoted Module Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.QuotedModuleContent
	 * @generated
	 */
	public Adapter createQuotedModuleContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link hub.sam.dbl.TestStatement <em>Test Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see hub.sam.dbl.TestStatement
	 * @generated
	 */
	public Adapter createTestStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DblAdapterFactory
