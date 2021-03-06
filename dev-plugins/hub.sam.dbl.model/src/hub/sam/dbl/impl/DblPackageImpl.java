/**
 */
package hub.sam.dbl.impl;

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
import hub.sam.dbl.DblFactory;
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
import hub.sam.dbl.YieldTo;
import static hub.sam.dbl.DblPackage.CLASS;
import hub.sam.dbl.*;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DblPackageImpl extends EPackageImpl implements DblPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensibleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotateableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructiveExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructiveExtensionAtContentExtensionPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleContentExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classContentExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voidTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boolTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nativeBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superClassSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitUntilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass yieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass yieldToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reactivateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activateObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass advanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localScopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localScopeStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continueStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l1ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l2ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l3ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l4ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l5ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l6ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l7ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l8ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l9ExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass greaterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass greaterEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceOfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mulEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass negEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass castEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activeLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parseExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predefinedIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sizeOfArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntaxDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntaxSymbolClassifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntaxExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l3SyntaxExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l2SyntaxExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l1SyntaxExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralSymbolReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plainSymbolReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementarySymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keywordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createIdStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expansionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expansionPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandTextPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandVariablePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeQuoteExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedStatementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedClassContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quotedModuleContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testStatementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see hub.sam.dbl.DblPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DblPackageImpl() {
		super(eNS_URI, DblFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DblPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DblPackage init() {
		if (isInited) return (DblPackage)EPackage.Registry.INSTANCE.getEPackage(DblPackage.eNS_URI);

		// Obtain or create and register package
		DblPackageImpl theDblPackage = (DblPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DblPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DblPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDblPackage.createPackageContents();

		// Initialize created meta-data
		theDblPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDblPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DblPackage.eNS_URI, theDblPackage);
		return theDblPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstruct() {
		return constructEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstruct_ExpandExpr() {
		return (EReference)constructEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensibleElement() {
		return extensibleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensibleElement_ConcreteSyntax() {
		return (EAttribute)extensibleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensibleElement_InstanceOfExtensionDefinition() {
		return (EAttribute)extensibleElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Imports() {
		return (EReference)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Modules() {
		return (EReference)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_File() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImport_Model() {
		return (EReference)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Classes() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Extensions() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ExtensionSemantics() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Functions() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Variables() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Items() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationItem() {
		return annotationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationItem_Key() {
		return (EAttribute)annotationItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationItem_Value() {
		return (EAttribute)annotationItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotateableElement() {
		return annotateableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotateableElement_Annotations() {
		return (EReference)annotateableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructiveExtension() {
		return constructiveExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructiveExtensionAtContentExtensionPoint() {
		return constructiveExtensionAtContentExtensionPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructiveExtensionAtContentExtensionPoint_ContentExtensions() {
		return (EReference)constructiveExtensionAtContentExtensionPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleContentExtension() {
		return moduleContentExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassContentExtension() {
		return classContentExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_ArrayDimensions() {
		return (EReference)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_PrimitiveType() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_TypeArrayDimensions() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_ClassifierType() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayDimension() {
		return arrayDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayDimension_Size() {
		return (EReference)arrayDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoidType() {
		return voidTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntType() {
		return intTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoolType() {
		return boolTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleType() {
		return doubleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Parameters() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Class() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Abstract() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Detached() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNativeBinding() {
		return nativeBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNativeBinding_TargetLanguage() {
		return (EAttribute)nativeBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNativeBinding_TargetType() {
		return (EAttribute)nativeBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSuperClassSpecification() {
		return superClassSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSuperClassSpecification_Class() {
		return (EReference)superClassSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSuperClassSpecification_ConstructorArguments() {
		return (EReference)superClassSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Active() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Bindings() {
		return (EReference)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_SuperClasses() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Constructors() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Methods() {
		return (EReference)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ActionsBlock() {
		return (EReference)classEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructor() {
		return constructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructor_Parameters() {
		return (EReference)constructorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructor_OwningClass() {
		return (EReference)constructorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractVariable() {
		return abstractVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Control() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Class() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_InitialValue() {
		return (EReference)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopStatement() {
		return loopStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleStatement() {
		return simpleStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Variable() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Value() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionCall() {
		return functionCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionCall_CallIdExpr() {
		return (EReference)functionCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturn() {
		return returnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturn_Value() {
		return (EReference)returnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWaitUntil() {
		return waitUntilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWaitUntil_Condition() {
		return (EReference)waitUntilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminate() {
		return terminateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getYield() {
		return yieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getYieldTo() {
		return yieldToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getYieldTo_ObjectAccess() {
		return (EReference)yieldToEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWait() {
		return waitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReactivate() {
		return reactivateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReactivate_ObjectAccess() {
		return (EReference)reactivateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivateObject() {
		return activateObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivateObject_ObjectAccess() {
		return (EReference)activateObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivateObject_Priority() {
		return (EAttribute)activateObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdvance() {
		return advanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdvance_Time() {
		return (EReference)advanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrint() {
		return printEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrint_Outputs() {
		return (EReference)printEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_Condition() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_TrueCase() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_FalseCase() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalScope() {
		return localScopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalScope_Statements() {
		return (EReference)localScopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalScopeStatement() {
		return localScopeStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Termination() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Increment() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Body() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileStatement() {
		return whileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileStatement_Condition() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileStatement_Body() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchStatement() {
		return switchStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Variable() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Cases() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_DefaultCase() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchCase() {
		return switchCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCase_Value() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCase_Body() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakStatement() {
		return breakStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinueStatement() {
		return continueStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL1Expr() {
		return l1ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL2Expr() {
		return l2ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL3Expr() {
		return l3ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL4Expr() {
		return l4ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL5Expr() {
		return l5ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL6Expr() {
		return l6ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL7Expr() {
		return l7ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL8Expr() {
		return l8ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL9Expr() {
		return l9ExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryOperator() {
		return binaryOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryOperator_Op1() {
		return (EReference)binaryOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryOperator_Op2() {
		return (EReference)binaryOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryOperator() {
		return unaryOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryOperator_Op() {
		return (EReference)unaryOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotEqual() {
		return notEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqual() {
		return equalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGreater() {
		return greaterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGreaterEqual() {
		return greaterEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLess() {
		return lessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLessEqual() {
		return lessEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceOf() {
		return instanceOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlus() {
		return plusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinus() {
		return minusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMul() {
		return mulEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMod() {
		return modEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiv() {
		return divEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNeg() {
		return negEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCast() {
		return castEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateObject() {
		return createObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullLiteral() {
		return nullLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeLiteral() {
		return timeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActiveLiteral() {
		return activeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntLiteral() {
		return intLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntLiteral_Value() {
		return (EAttribute)intLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueLiteral() {
		return trueLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseLiteral() {
		return falseLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleLiteral() {
		return doubleLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleLiteral_Value() {
		return (EAttribute)doubleLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandExpr() {
		return expandExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandExpr_Expr() {
		return (EReference)expandExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParseExpr() {
		return parseExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParseExpr_AstPart() {
		return (EReference)parseExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredefinedId() {
		return predefinedIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeLiteral() {
		return meLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSuperLiteral() {
		return superLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaLiteral() {
		return metaLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeLiteral() {
		return typeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSizeOfArray() {
		return sizeOfArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationLiteral() {
		return annotationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdExpr() {
		return idExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdExpr_ParentIdExpr() {
		return (EReference)idExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdExpr_ReferencedElement() {
		return (EReference)idExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdExpr_PredefinedId() {
		return (EReference)idExprEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdExpr_ArrayIndex() {
		return (EReference)idExprEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdExpr_CallPart() {
		return (EReference)idExprEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallPart() {
		return callPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallPart_CallArguments() {
		return (EReference)callPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementAccess() {
		return elementAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementAccess_IdExpr() {
		return (EReference)elementAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableAccess() {
		return variableAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaAccess() {
		return metaAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeAccess() {
		return typeAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtension() {
		return extensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_ExtensionPoint() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_SyntaxDefinition() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionSemantics() {
		return extensionSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionSemantics_SyntaxDefinition() {
		return (EReference)extensionSemanticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntaxDefinition() {
		return syntaxDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSyntaxDefinition_StartSymbol() {
		return (EReference)syntaxDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSyntaxDefinition_Symbols() {
		return (EReference)syntaxDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntaxSymbolClassifier() {
		return syntaxSymbolClassifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexSymbol() {
		return complexSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcept() {
		return conceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaSymbol() {
		return metaSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetaSymbol_PossibleSyntax() {
		return (EReference)metaSymbolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntaxExpression() {
		return syntaxExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL3SyntaxExpression() {
		return l3SyntaxExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL2SyntaxExpression() {
		return l2SyntaxExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymbolSequence() {
		return symbolSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSymbolSequence_Sequence() {
		return (EReference)symbolSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL1SyntaxExpression() {
		return l1SyntaxExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralSymbolReference() {
		return structuralSymbolReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralSymbolReference_List() {
		return (EAttribute)structuralSymbolReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralSymbolReference_Composite() {
		return (EAttribute)structuralSymbolReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralSymbolReference_LocalScopedReference() {
		return (EAttribute)structuralSymbolReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralSymbolReference_GlobalScopedReference() {
		return (EAttribute)structuralSymbolReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlainSymbolReference() {
		return plainSymbolReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlainSymbolReference_Classifier() {
		return (EReference)plainSymbolReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlainSymbolReference_OwnedClassifier() {
		return (EReference)plainSymbolReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlainSymbolReference_ReferencedClassifier() {
		return (EReference)plainSymbolReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementarySymbol() {
		return elementarySymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdSymbol() {
		return idSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntSymbol() {
		return intSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringSymbol() {
		return stringSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyword() {
		return keywordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyword_Keyword() {
		return (EAttribute)keywordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaExpr() {
		return metaExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetaExpr_Expr() {
		return (EReference)metaExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetStatement() {
		return targetStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetStatement_Body() {
		return (EReference)targetStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateIdStatement() {
		return createIdStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpansionStatement() {
		return expansionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpansionStatement_ClassContext() {
		return (EAttribute)expansionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpansionStatement_FunctionContext() {
		return (EAttribute)expansionStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpansionStatement_VariableContext() {
		return (EAttribute)expansionStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionStatement_DifferingContext() {
		return (EReference)expansionStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionStatement_Parts() {
		return (EReference)expansionStatementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionStatement_Exprs() {
		return (EReference)expansionStatementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpansionPart() {
		return expansionPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandTextPart() {
		return expandTextPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpandTextPart_Text() {
		return (EAttribute)expandTextPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandVariablePart() {
		return expandVariablePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandVariablePart_Expr() {
		return (EReference)expandVariablePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandExpression() {
		return expandExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandExpression_MetaObject() {
		return (EReference)expandExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandStatement() {
		return expandStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandStatement_MetaObject() {
		return (EReference)expandStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandStatement_Location() {
		return (EReference)expandStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeQuoteExpression() {
		return codeQuoteExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeQuoteExpression_QuotedCode() {
		return (EReference)codeQuoteExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuotedCode() {
		return quotedCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuotedExpression() {
		return quotedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuotedExpression_Expression() {
		return (EReference)quotedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuotedStatements() {
		return quotedStatementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuotedStatements_Statements() {
		return (EReference)quotedStatementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuotedClassContent() {
		return quotedClassContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuotedModuleContent() {
		return quotedModuleContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPattern_Top() {
		return (EAttribute)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Context() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Body() {
		return (EReference)patternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestStatement() {
		return testStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestStatement_Value() {
		return (EAttribute)testStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DblFactory getDblFactory() {
		return (DblFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		constructEClass = createEClass(CONSTRUCT);
		createEReference(constructEClass, CONSTRUCT__EXPAND_EXPR);

		extensibleElementEClass = createEClass(EXTENSIBLE_ELEMENT);
		createEAttribute(extensibleElementEClass, EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX);
		createEAttribute(extensibleElementEClass, EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION);

		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__IMPORTS);
		createEReference(modelEClass, MODEL__MODULES);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__FILE);
		createEReference(importEClass, IMPORT__MODEL);

		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__CLASSES);
		createEReference(moduleEClass, MODULE__EXTENSIONS);
		createEReference(moduleEClass, MODULE__EXTENSION_SEMANTICS);
		createEReference(moduleEClass, MODULE__FUNCTIONS);
		createEReference(moduleEClass, MODULE__VARIABLES);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__ITEMS);

		annotationItemEClass = createEClass(ANNOTATION_ITEM);
		createEAttribute(annotationItemEClass, ANNOTATION_ITEM__KEY);
		createEAttribute(annotationItemEClass, ANNOTATION_ITEM__VALUE);

		annotateableElementEClass = createEClass(ANNOTATEABLE_ELEMENT);
		createEReference(annotateableElementEClass, ANNOTATEABLE_ELEMENT__ANNOTATIONS);

		constructiveExtensionEClass = createEClass(CONSTRUCTIVE_EXTENSION);

		constructiveExtensionAtContentExtensionPointEClass = createEClass(CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT);
		createEReference(constructiveExtensionAtContentExtensionPointEClass, CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS);

		moduleContentExtensionEClass = createEClass(MODULE_CONTENT_EXTENSION);

		classContentExtensionEClass = createEClass(CLASS_CONTENT_EXTENSION);

		typeEClass = createEClass(TYPE);
		createEReference(typeEClass, TYPE__ARRAY_DIMENSIONS);

		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__PRIMITIVE_TYPE);
		createEReference(typedElementEClass, TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS);
		createEReference(typedElementEClass, TYPED_ELEMENT__CLASSIFIER_TYPE);

		arrayDimensionEClass = createEClass(ARRAY_DIMENSION);
		createEReference(arrayDimensionEClass, ARRAY_DIMENSION__SIZE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		voidTypeEClass = createEClass(VOID_TYPE);

		intTypeEClass = createEClass(INT_TYPE);

		boolTypeEClass = createEClass(BOOL_TYPE);

		doubleTypeEClass = createEClass(DOUBLE_TYPE);

		stringTypeEClass = createEClass(STRING_TYPE);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__PARAMETERS);
		createEAttribute(functionEClass, FUNCTION__CLASS);
		createEAttribute(functionEClass, FUNCTION__ABSTRACT);
		createEAttribute(functionEClass, FUNCTION__DETACHED);

		nativeBindingEClass = createEClass(NATIVE_BINDING);
		createEAttribute(nativeBindingEClass, NATIVE_BINDING__TARGET_LANGUAGE);
		createEAttribute(nativeBindingEClass, NATIVE_BINDING__TARGET_TYPE);

		superClassSpecificationEClass = createEClass(SUPER_CLASS_SPECIFICATION);
		createEReference(superClassSpecificationEClass, SUPER_CLASS_SPECIFICATION__CLASS);
		createEReference(superClassSpecificationEClass, SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__ACTIVE);
		createEReference(classEClass, CLASS__BINDINGS);
		createEReference(classEClass, CLASS__SUPER_CLASSES);
		createEReference(classEClass, CLASS__CONSTRUCTORS);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEReference(classEClass, CLASS__METHODS);
		createEReference(classEClass, CLASS__ACTIONS_BLOCK);

		constructorEClass = createEClass(CONSTRUCTOR);
		createEReference(constructorEClass, CONSTRUCTOR__PARAMETERS);
		createEReference(constructorEClass, CONSTRUCTOR__OWNING_CLASS);

		abstractVariableEClass = createEClass(ABSTRACT_VARIABLE);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__CONTROL);
		createEAttribute(variableEClass, VARIABLE__CLASS);
		createEReference(variableEClass, VARIABLE__INITIAL_VALUE);

		parameterEClass = createEClass(PARAMETER);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		statementEClass = createEClass(STATEMENT);

		loopStatementEClass = createEClass(LOOP_STATEMENT);

		simpleStatementEClass = createEClass(SIMPLE_STATEMENT);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__VARIABLE);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);

		functionCallEClass = createEClass(FUNCTION_CALL);
		createEReference(functionCallEClass, FUNCTION_CALL__CALL_ID_EXPR);

		returnEClass = createEClass(RETURN);
		createEReference(returnEClass, RETURN__VALUE);

		waitUntilEClass = createEClass(WAIT_UNTIL);
		createEReference(waitUntilEClass, WAIT_UNTIL__CONDITION);

		terminateEClass = createEClass(TERMINATE);

		yieldEClass = createEClass(YIELD);

		yieldToEClass = createEClass(YIELD_TO);
		createEReference(yieldToEClass, YIELD_TO__OBJECT_ACCESS);

		waitEClass = createEClass(WAIT);

		reactivateEClass = createEClass(REACTIVATE);
		createEReference(reactivateEClass, REACTIVATE__OBJECT_ACCESS);

		activateObjectEClass = createEClass(ACTIVATE_OBJECT);
		createEReference(activateObjectEClass, ACTIVATE_OBJECT__OBJECT_ACCESS);
		createEAttribute(activateObjectEClass, ACTIVATE_OBJECT__PRIORITY);

		advanceEClass = createEClass(ADVANCE);
		createEReference(advanceEClass, ADVANCE__TIME);

		printEClass = createEClass(PRINT);
		createEReference(printEClass, PRINT__OUTPUTS);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__CONDITION);
		createEReference(ifStatementEClass, IF_STATEMENT__TRUE_CASE);
		createEReference(ifStatementEClass, IF_STATEMENT__FALSE_CASE);

		localScopeEClass = createEClass(LOCAL_SCOPE);
		createEReference(localScopeEClass, LOCAL_SCOPE__STATEMENTS);

		localScopeStatementEClass = createEClass(LOCAL_SCOPE_STATEMENT);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__TERMINATION);
		createEReference(forStatementEClass, FOR_STATEMENT__INCREMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__BODY);

		whileStatementEClass = createEClass(WHILE_STATEMENT);
		createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
		createEReference(whileStatementEClass, WHILE_STATEMENT__BODY);

		switchStatementEClass = createEClass(SWITCH_STATEMENT);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__VARIABLE);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__CASES);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__DEFAULT_CASE);

		switchCaseEClass = createEClass(SWITCH_CASE);
		createEReference(switchCaseEClass, SWITCH_CASE__VALUE);
		createEReference(switchCaseEClass, SWITCH_CASE__BODY);

		breakStatementEClass = createEClass(BREAK_STATEMENT);

		continueStatementEClass = createEClass(CONTINUE_STATEMENT);

		expressionEClass = createEClass(EXPRESSION);

		l1ExprEClass = createEClass(L1_EXPR);

		l2ExprEClass = createEClass(L2_EXPR);

		l3ExprEClass = createEClass(L3_EXPR);

		l4ExprEClass = createEClass(L4_EXPR);

		l5ExprEClass = createEClass(L5_EXPR);

		l6ExprEClass = createEClass(L6_EXPR);

		l7ExprEClass = createEClass(L7_EXPR);

		l8ExprEClass = createEClass(L8_EXPR);

		l9ExprEClass = createEClass(L9_EXPR);

		binaryOperatorEClass = createEClass(BINARY_OPERATOR);
		createEReference(binaryOperatorEClass, BINARY_OPERATOR__OP1);
		createEReference(binaryOperatorEClass, BINARY_OPERATOR__OP2);

		unaryOperatorEClass = createEClass(UNARY_OPERATOR);
		createEReference(unaryOperatorEClass, UNARY_OPERATOR__OP);

		orEClass = createEClass(OR);

		andEClass = createEClass(AND);

		notEqualEClass = createEClass(NOT_EQUAL);

		equalEClass = createEClass(EQUAL);

		greaterEClass = createEClass(GREATER);

		greaterEqualEClass = createEClass(GREATER_EQUAL);

		lessEClass = createEClass(LESS);

		lessEqualEClass = createEClass(LESS_EQUAL);

		instanceOfEClass = createEClass(INSTANCE_OF);

		plusEClass = createEClass(PLUS);

		minusEClass = createEClass(MINUS);

		mulEClass = createEClass(MUL);

		modEClass = createEClass(MOD);

		divEClass = createEClass(DIV);

		negEClass = createEClass(NEG);

		notEClass = createEClass(NOT);

		castEClass = createEClass(CAST);

		createObjectEClass = createEClass(CREATE_OBJECT);

		nullLiteralEClass = createEClass(NULL_LITERAL);

		timeLiteralEClass = createEClass(TIME_LITERAL);

		activeLiteralEClass = createEClass(ACTIVE_LITERAL);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		intLiteralEClass = createEClass(INT_LITERAL);
		createEAttribute(intLiteralEClass, INT_LITERAL__VALUE);

		trueLiteralEClass = createEClass(TRUE_LITERAL);

		falseLiteralEClass = createEClass(FALSE_LITERAL);

		doubleLiteralEClass = createEClass(DOUBLE_LITERAL);
		createEAttribute(doubleLiteralEClass, DOUBLE_LITERAL__VALUE);

		expandExprEClass = createEClass(EXPAND_EXPR);
		createEReference(expandExprEClass, EXPAND_EXPR__EXPR);

		parseExprEClass = createEClass(PARSE_EXPR);
		createEReference(parseExprEClass, PARSE_EXPR__AST_PART);

		predefinedIdEClass = createEClass(PREDEFINED_ID);

		meLiteralEClass = createEClass(ME_LITERAL);

		superLiteralEClass = createEClass(SUPER_LITERAL);

		metaLiteralEClass = createEClass(META_LITERAL);

		typeLiteralEClass = createEClass(TYPE_LITERAL);

		sizeOfArrayEClass = createEClass(SIZE_OF_ARRAY);

		annotationLiteralEClass = createEClass(ANNOTATION_LITERAL);

		idExprEClass = createEClass(ID_EXPR);
		createEReference(idExprEClass, ID_EXPR__PARENT_ID_EXPR);
		createEReference(idExprEClass, ID_EXPR__REFERENCED_ELEMENT);
		createEReference(idExprEClass, ID_EXPR__PREDEFINED_ID);
		createEReference(idExprEClass, ID_EXPR__ARRAY_INDEX);
		createEReference(idExprEClass, ID_EXPR__CALL_PART);

		callPartEClass = createEClass(CALL_PART);
		createEReference(callPartEClass, CALL_PART__CALL_ARGUMENTS);

		elementAccessEClass = createEClass(ELEMENT_ACCESS);
		createEReference(elementAccessEClass, ELEMENT_ACCESS__ID_EXPR);

		variableAccessEClass = createEClass(VARIABLE_ACCESS);

		metaAccessEClass = createEClass(META_ACCESS);

		typeAccessEClass = createEClass(TYPE_ACCESS);

		extensionEClass = createEClass(EXTENSION);
		createEReference(extensionEClass, EXTENSION__EXTENSION_POINT);
		createEReference(extensionEClass, EXTENSION__SYNTAX_DEFINITION);

		extensionSemanticsEClass = createEClass(EXTENSION_SEMANTICS);
		createEReference(extensionSemanticsEClass, EXTENSION_SEMANTICS__SYNTAX_DEFINITION);

		syntaxDefinitionEClass = createEClass(SYNTAX_DEFINITION);
		createEReference(syntaxDefinitionEClass, SYNTAX_DEFINITION__START_SYMBOL);
		createEReference(syntaxDefinitionEClass, SYNTAX_DEFINITION__SYMBOLS);

		syntaxSymbolClassifierEClass = createEClass(SYNTAX_SYMBOL_CLASSIFIER);

		complexSymbolEClass = createEClass(COMPLEX_SYMBOL);

		conceptEClass = createEClass(CONCEPT);

		metaSymbolEClass = createEClass(META_SYMBOL);
		createEReference(metaSymbolEClass, META_SYMBOL__POSSIBLE_SYNTAX);

		syntaxExpressionEClass = createEClass(SYNTAX_EXPRESSION);

		l3SyntaxExpressionEClass = createEClass(L3_SYNTAX_EXPRESSION);

		l2SyntaxExpressionEClass = createEClass(L2_SYNTAX_EXPRESSION);

		symbolSequenceEClass = createEClass(SYMBOL_SEQUENCE);
		createEReference(symbolSequenceEClass, SYMBOL_SEQUENCE__SEQUENCE);

		l1SyntaxExpressionEClass = createEClass(L1_SYNTAX_EXPRESSION);

		structuralSymbolReferenceEClass = createEClass(STRUCTURAL_SYMBOL_REFERENCE);
		createEAttribute(structuralSymbolReferenceEClass, STRUCTURAL_SYMBOL_REFERENCE__LIST);
		createEAttribute(structuralSymbolReferenceEClass, STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE);
		createEAttribute(structuralSymbolReferenceEClass, STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE);
		createEAttribute(structuralSymbolReferenceEClass, STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE);

		plainSymbolReferenceEClass = createEClass(PLAIN_SYMBOL_REFERENCE);
		createEReference(plainSymbolReferenceEClass, PLAIN_SYMBOL_REFERENCE__CLASSIFIER);
		createEReference(plainSymbolReferenceEClass, PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER);
		createEReference(plainSymbolReferenceEClass, PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER);

		elementarySymbolEClass = createEClass(ELEMENTARY_SYMBOL);

		idSymbolEClass = createEClass(ID_SYMBOL);

		intSymbolEClass = createEClass(INT_SYMBOL);

		stringSymbolEClass = createEClass(STRING_SYMBOL);

		keywordEClass = createEClass(KEYWORD);
		createEAttribute(keywordEClass, KEYWORD__KEYWORD);

		metaExprEClass = createEClass(META_EXPR);
		createEReference(metaExprEClass, META_EXPR__EXPR);

		targetStatementEClass = createEClass(TARGET_STATEMENT);
		createEReference(targetStatementEClass, TARGET_STATEMENT__BODY);

		createIdStatementEClass = createEClass(CREATE_ID_STATEMENT);

		expansionStatementEClass = createEClass(EXPANSION_STATEMENT);
		createEAttribute(expansionStatementEClass, EXPANSION_STATEMENT__CLASS_CONTEXT);
		createEAttribute(expansionStatementEClass, EXPANSION_STATEMENT__FUNCTION_CONTEXT);
		createEAttribute(expansionStatementEClass, EXPANSION_STATEMENT__VARIABLE_CONTEXT);
		createEReference(expansionStatementEClass, EXPANSION_STATEMENT__DIFFERING_CONTEXT);
		createEReference(expansionStatementEClass, EXPANSION_STATEMENT__PARTS);
		createEReference(expansionStatementEClass, EXPANSION_STATEMENT__EXPRS);

		expansionPartEClass = createEClass(EXPANSION_PART);

		expandTextPartEClass = createEClass(EXPAND_TEXT_PART);
		createEAttribute(expandTextPartEClass, EXPAND_TEXT_PART__TEXT);

		expandVariablePartEClass = createEClass(EXPAND_VARIABLE_PART);
		createEReference(expandVariablePartEClass, EXPAND_VARIABLE_PART__EXPR);

		expandExpressionEClass = createEClass(EXPAND_EXPRESSION);
		createEReference(expandExpressionEClass, EXPAND_EXPRESSION__META_OBJECT);

		expandStatementEClass = createEClass(EXPAND_STATEMENT);
		createEReference(expandStatementEClass, EXPAND_STATEMENT__META_OBJECT);
		createEReference(expandStatementEClass, EXPAND_STATEMENT__LOCATION);

		codeQuoteExpressionEClass = createEClass(CODE_QUOTE_EXPRESSION);
		createEReference(codeQuoteExpressionEClass, CODE_QUOTE_EXPRESSION__QUOTED_CODE);

		quotedCodeEClass = createEClass(QUOTED_CODE);

		quotedExpressionEClass = createEClass(QUOTED_EXPRESSION);
		createEReference(quotedExpressionEClass, QUOTED_EXPRESSION__EXPRESSION);

		quotedStatementsEClass = createEClass(QUOTED_STATEMENTS);
		createEReference(quotedStatementsEClass, QUOTED_STATEMENTS__STATEMENTS);

		quotedClassContentEClass = createEClass(QUOTED_CLASS_CONTENT);

		quotedModuleContentEClass = createEClass(QUOTED_MODULE_CONTENT);

		patternEClass = createEClass(PATTERN);
		createEAttribute(patternEClass, PATTERN__TOP);
		createEReference(patternEClass, PATTERN__CONTEXT);
		createEReference(patternEClass, PATTERN__BODY);

		testStatementEClass = createEClass(TEST_STATEMENT);
		createEAttribute(testStatementEClass, TEST_STATEMENT__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extensibleElementEClass.getESuperTypes().add(this.getNamedElement());
		extensibleElementEClass.getESuperTypes().add(this.getConstruct());
		moduleEClass.getESuperTypes().add(this.getNamedElement());
		moduleEClass.getESuperTypes().add(this.getConstructiveExtensionAtContentExtensionPoint());
		moduleEClass.getESuperTypes().add(this.getConstruct());
		annotationEClass.getESuperTypes().add(this.getNamedElement());
		constructiveExtensionEClass.getESuperTypes().add(this.getExtensibleElement());
		moduleContentExtensionEClass.getESuperTypes().add(this.getConstructiveExtension());
		classContentExtensionEClass.getESuperTypes().add(this.getConstructiveExtension());
		primitiveTypeEClass.getESuperTypes().add(this.getType());
		voidTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		intTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		boolTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		doubleTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		stringTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		functionEClass.getESuperTypes().add(this.getNamedElement());
		functionEClass.getESuperTypes().add(this.getTypedElement());
		functionEClass.getESuperTypes().add(this.getLocalScope());
		classEClass.getESuperTypes().add(this.getNamedElement());
		classEClass.getESuperTypes().add(this.getType());
		classEClass.getESuperTypes().add(this.getConstructiveExtensionAtContentExtensionPoint());
		classEClass.getESuperTypes().add(this.getConcept());
		classEClass.getESuperTypes().add(this.getConstruct());
		classEClass.getESuperTypes().add(this.getAnnotateableElement());
		constructorEClass.getESuperTypes().add(this.getLocalScope());
		abstractVariableEClass.getESuperTypes().add(this.getNamedElement());
		abstractVariableEClass.getESuperTypes().add(this.getTypedElement());
		abstractVariableEClass.getESuperTypes().add(this.getAnnotateableElement());
		variableEClass.getESuperTypes().add(this.getAbstractVariable());
		variableEClass.getESuperTypes().add(this.getSimpleStatement());
		parameterEClass.getESuperTypes().add(this.getAbstractVariable());
		statementEClass.getESuperTypes().add(this.getExtensibleElement());
		statementEClass.getESuperTypes().add(this.getAnnotateableElement());
		loopStatementEClass.getESuperTypes().add(this.getStatement());
		simpleStatementEClass.getESuperTypes().add(this.getStatement());
		assignmentEClass.getESuperTypes().add(this.getSimpleStatement());
		functionCallEClass.getESuperTypes().add(this.getSimpleStatement());
		returnEClass.getESuperTypes().add(this.getSimpleStatement());
		waitUntilEClass.getESuperTypes().add(this.getSimpleStatement());
		terminateEClass.getESuperTypes().add(this.getSimpleStatement());
		yieldEClass.getESuperTypes().add(this.getSimpleStatement());
		yieldToEClass.getESuperTypes().add(this.getSimpleStatement());
		waitEClass.getESuperTypes().add(this.getSimpleStatement());
		reactivateEClass.getESuperTypes().add(this.getSimpleStatement());
		activateObjectEClass.getESuperTypes().add(this.getSimpleStatement());
		advanceEClass.getESuperTypes().add(this.getSimpleStatement());
		printEClass.getESuperTypes().add(this.getSimpleStatement());
		ifStatementEClass.getESuperTypes().add(this.getStatement());
		localScopeStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		localScopeStatementEClass.getESuperTypes().add(this.getLocalScope());
		forStatementEClass.getESuperTypes().add(this.getLoopStatement());
		forStatementEClass.getESuperTypes().add(this.getLocalScope());
		whileStatementEClass.getESuperTypes().add(this.getLoopStatement());
		switchStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		breakStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		continueStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		expressionEClass.getESuperTypes().add(this.getTypedElement());
		expressionEClass.getESuperTypes().add(this.getExtensibleElement());
		l1ExprEClass.getESuperTypes().add(this.getExpression());
		l2ExprEClass.getESuperTypes().add(this.getExpression());
		l3ExprEClass.getESuperTypes().add(this.getExpression());
		l4ExprEClass.getESuperTypes().add(this.getExpression());
		l5ExprEClass.getESuperTypes().add(this.getExpression());
		l6ExprEClass.getESuperTypes().add(this.getExpression());
		l7ExprEClass.getESuperTypes().add(this.getExpression());
		l8ExprEClass.getESuperTypes().add(this.getExpression());
		l9ExprEClass.getESuperTypes().add(this.getExpression());
		binaryOperatorEClass.getESuperTypes().add(this.getExpression());
		unaryOperatorEClass.getESuperTypes().add(this.getExpression());
		orEClass.getESuperTypes().add(this.getBinaryOperator());
		orEClass.getESuperTypes().add(this.getL8Expr());
		andEClass.getESuperTypes().add(this.getBinaryOperator());
		andEClass.getESuperTypes().add(this.getL7Expr());
		notEqualEClass.getESuperTypes().add(this.getBinaryOperator());
		notEqualEClass.getESuperTypes().add(this.getL6Expr());
		equalEClass.getESuperTypes().add(this.getBinaryOperator());
		equalEClass.getESuperTypes().add(this.getL6Expr());
		greaterEClass.getESuperTypes().add(this.getBinaryOperator());
		greaterEClass.getESuperTypes().add(this.getL5Expr());
		greaterEqualEClass.getESuperTypes().add(this.getBinaryOperator());
		greaterEqualEClass.getESuperTypes().add(this.getL5Expr());
		lessEClass.getESuperTypes().add(this.getBinaryOperator());
		lessEClass.getESuperTypes().add(this.getL5Expr());
		lessEqualEClass.getESuperTypes().add(this.getBinaryOperator());
		lessEqualEClass.getESuperTypes().add(this.getL5Expr());
		instanceOfEClass.getESuperTypes().add(this.getBinaryOperator());
		instanceOfEClass.getESuperTypes().add(this.getL5Expr());
		plusEClass.getESuperTypes().add(this.getBinaryOperator());
		plusEClass.getESuperTypes().add(this.getL4Expr());
		minusEClass.getESuperTypes().add(this.getBinaryOperator());
		minusEClass.getESuperTypes().add(this.getL4Expr());
		mulEClass.getESuperTypes().add(this.getBinaryOperator());
		mulEClass.getESuperTypes().add(this.getL3Expr());
		modEClass.getESuperTypes().add(this.getBinaryOperator());
		modEClass.getESuperTypes().add(this.getL3Expr());
		divEClass.getESuperTypes().add(this.getBinaryOperator());
		divEClass.getESuperTypes().add(this.getL3Expr());
		negEClass.getESuperTypes().add(this.getUnaryOperator());
		negEClass.getESuperTypes().add(this.getL2Expr());
		notEClass.getESuperTypes().add(this.getUnaryOperator());
		notEClass.getESuperTypes().add(this.getL2Expr());
		castEClass.getESuperTypes().add(this.getUnaryOperator());
		castEClass.getESuperTypes().add(this.getTypedElement());
		castEClass.getESuperTypes().add(this.getL2Expr());
		createObjectEClass.getESuperTypes().add(this.getL1Expr());
		createObjectEClass.getESuperTypes().add(this.getTypedElement());
		nullLiteralEClass.getESuperTypes().add(this.getL1Expr());
		timeLiteralEClass.getESuperTypes().add(this.getL1Expr());
		activeLiteralEClass.getESuperTypes().add(this.getL1Expr());
		stringLiteralEClass.getESuperTypes().add(this.getL1Expr());
		intLiteralEClass.getESuperTypes().add(this.getL1Expr());
		trueLiteralEClass.getESuperTypes().add(this.getL1Expr());
		falseLiteralEClass.getESuperTypes().add(this.getL1Expr());
		doubleLiteralEClass.getESuperTypes().add(this.getL1Expr());
		expandExprEClass.getESuperTypes().add(this.getExpression());
		parseExprEClass.getESuperTypes().add(this.getExpression());
		meLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		superLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		metaLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		typeLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		sizeOfArrayEClass.getESuperTypes().add(this.getPredefinedId());
		annotationLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		annotationLiteralEClass.getESuperTypes().add(this.getAnnotation());
		idExprEClass.getESuperTypes().add(this.getL1Expr());
		elementAccessEClass.getESuperTypes().add(this.getExpression());
		variableAccessEClass.getESuperTypes().add(this.getElementAccess());
		metaAccessEClass.getESuperTypes().add(this.getVariableAccess());
		typeAccessEClass.getESuperTypes().add(this.getElementAccess());
		extensionEClass.getESuperTypes().add(this.getConcept());
		extensionEClass.getESuperTypes().add(this.getExtensibleElement());
		extensionSemanticsEClass.getESuperTypes().add(this.getExtensibleElement());
		extensionSemanticsEClass.getESuperTypes().add(this.getLocalScope());
		syntaxDefinitionEClass.getESuperTypes().add(this.getExtensibleElement());
		syntaxSymbolClassifierEClass.getESuperTypes().add(this.getNamedElement());
		syntaxSymbolClassifierEClass.getESuperTypes().add(this.getExtensibleElement());
		complexSymbolEClass.getESuperTypes().add(this.getSyntaxSymbolClassifier());
		conceptEClass.getESuperTypes().add(this.getComplexSymbol());
		metaSymbolEClass.getESuperTypes().add(this.getNamedElement());
		metaSymbolEClass.getESuperTypes().add(this.getComplexSymbol());
		l3SyntaxExpressionEClass.getESuperTypes().add(this.getSyntaxExpression());
		l2SyntaxExpressionEClass.getESuperTypes().add(this.getSyntaxExpression());
		symbolSequenceEClass.getESuperTypes().add(this.getL2SyntaxExpression());
		l1SyntaxExpressionEClass.getESuperTypes().add(this.getSyntaxExpression());
		structuralSymbolReferenceEClass.getESuperTypes().add(this.getNamedElement());
		structuralSymbolReferenceEClass.getESuperTypes().add(this.getPlainSymbolReference());
		plainSymbolReferenceEClass.getESuperTypes().add(this.getL1SyntaxExpression());
		elementarySymbolEClass.getESuperTypes().add(this.getSyntaxSymbolClassifier());
		idSymbolEClass.getESuperTypes().add(this.getElementarySymbol());
		intSymbolEClass.getESuperTypes().add(this.getElementarySymbol());
		stringSymbolEClass.getESuperTypes().add(this.getElementarySymbol());
		keywordEClass.getESuperTypes().add(this.getElementarySymbol());
		metaExprEClass.getESuperTypes().add(this.getExpression());
		targetStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		createIdStatementEClass.getESuperTypes().add(this.getVariable());
		expansionStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		expandTextPartEClass.getESuperTypes().add(this.getExpansionPart());
		expandVariablePartEClass.getESuperTypes().add(this.getExpansionPart());
		expandExpressionEClass.getESuperTypes().add(this.getExpression());
		expandStatementEClass.getESuperTypes().add(this.getStatement());
		codeQuoteExpressionEClass.getESuperTypes().add(this.getExpression());
		quotedExpressionEClass.getESuperTypes().add(this.getQuotedCode());
		quotedStatementsEClass.getESuperTypes().add(this.getQuotedCode());
		quotedClassContentEClass.getESuperTypes().add(this.getQuotedCode());
		quotedClassContentEClass.getESuperTypes().add(this.getClass_());
		quotedModuleContentEClass.getESuperTypes().add(this.getQuotedCode());
		quotedModuleContentEClass.getESuperTypes().add(this.getModule());
		patternEClass.getESuperTypes().add(this.getNamedElement());
		testStatementEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(constructEClass, Construct.class, "Construct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstruct_ExpandExpr(), this.getExpandExpr(), null, "expandExpr", null, 1, 1, Construct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensibleElementEClass, ExtensibleElement.class, "ExtensibleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtensibleElement_ConcreteSyntax(), ecorePackage.getEString(), "concreteSyntax", null, 0, 1, ExtensibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtensibleElement_InstanceOfExtensionDefinition(), ecorePackage.getEBoolean(), "instanceOfExtensionDefinition", "false", 1, 1, ExtensibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Imports(), this.getImport(), null, "imports", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Modules(), this.getModule(), null, "modules", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_File(), ecorePackage.getEString(), "file", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImport_Model(), this.getModel(), null, "model", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_Classes(), this.getClass_(), null, "classes", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Extensions(), this.getExtension(), null, "extensions", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_ExtensionSemantics(), this.getExtensionSemantics(), null, "extensionSemantics", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Functions(), this.getFunction(), null, "functions", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Variables(), this.getVariable(), null, "variables", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Items(), this.getAnnotationItem(), null, "items", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationItemEClass, AnnotationItem.class, "AnnotationItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotationItem_Key(), ecorePackage.getEString(), "key", null, 1, 1, AnnotationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationItem_Value(), ecorePackage.getEString(), "value", null, 1, 1, AnnotationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotateableElementEClass, AnnotateableElement.class, "AnnotateableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotateableElement_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, AnnotateableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructiveExtensionEClass, ConstructiveExtension.class, "ConstructiveExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constructiveExtensionAtContentExtensionPointEClass, ConstructiveExtensionAtContentExtensionPoint.class, "ConstructiveExtensionAtContentExtensionPoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstructiveExtensionAtContentExtensionPoint_ContentExtensions(), this.getConstructiveExtension(), null, "contentExtensions", null, 0, -1, ConstructiveExtensionAtContentExtensionPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleContentExtensionEClass, ModuleContentExtension.class, "ModuleContentExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classContentExtensionEClass, ClassContentExtension.class, "ClassContentExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType_ArrayDimensions(), this.getArrayDimension(), null, "arrayDimensions", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_PrimitiveType(), this.getPrimitiveType(), null, "primitiveType", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedElement_TypeArrayDimensions(), this.getArrayDimension(), null, "typeArrayDimensions", null, 0, -1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedElement_ClassifierType(), this.getIdExpr(), null, "classifierType", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayDimensionEClass, ArrayDimension.class, "ArrayDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayDimension_Size(), this.getExpression(), null, "size", null, 0, 1, ArrayDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intTypeEClass, IntType.class, "IntType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boolTypeEClass, BoolType.class, "BoolType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doubleTypeEClass, DoubleType.class, "DoubleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_Class(), ecorePackage.getEBoolean(), "class", "false", 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_Detached(), ecorePackage.getEBoolean(), "detached", "false", 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nativeBindingEClass, NativeBinding.class, "NativeBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNativeBinding_TargetLanguage(), ecorePackage.getEString(), "targetLanguage", null, 1, 1, NativeBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNativeBinding_TargetType(), ecorePackage.getEString(), "targetType", null, 1, 1, NativeBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(superClassSpecificationEClass, SuperClassSpecification.class, "SuperClassSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSuperClassSpecification_Class(), this.getClass_(), null, "class", null, 1, 1, SuperClassSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperClassSpecification_ConstructorArguments(), this.getExpression(), null, "constructorArguments", null, 0, -1, SuperClassSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classEClass, hub.sam.dbl.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_Active(), ecorePackage.getEBoolean(), "active", "false", 1, 1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Bindings(), this.getNativeBinding(), null, "bindings", null, 0, -1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_SuperClasses(), this.getSuperClassSpecification(), null, "superClasses", null, 0, -1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Constructors(), this.getConstructor(), this.getConstructor_OwningClass(), "constructors", null, 0, -1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Attributes(), this.getVariable(), null, "attributes", null, 0, -1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Methods(), this.getFunction(), null, "methods", null, 0, -1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_ActionsBlock(), this.getLocalScope(), null, "actionsBlock", null, 0, 1, hub.sam.dbl.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructorEClass, Constructor.class, "Constructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstructor_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Constructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstructor_OwningClass(), this.getClass_(), this.getClass_Constructors(), "owningClass", null, 1, 1, Constructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractVariableEClass, AbstractVariable.class, "AbstractVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Control(), ecorePackage.getEBoolean(), "control", "false", 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Class(), ecorePackage.getEBoolean(), "class", "false", 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_InitialValue(), this.getExpression(), null, "initialValue", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopStatementEClass, LoopStatement.class, "LoopStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleStatementEClass, SimpleStatement.class, "SimpleStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Variable(), this.getVariableAccess(), null, "variable", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Value(), this.getExpression(), null, "value", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCall_CallIdExpr(), this.getIdExpr(), null, "callIdExpr", null, 1, 1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(returnEClass, Return.class, "Return", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturn_Value(), this.getExpression(), null, "value", null, 1, 1, Return.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitUntilEClass, WaitUntil.class, "WaitUntil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWaitUntil_Condition(), this.getExpression(), null, "condition", null, 1, 1, WaitUntil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminateEClass, Terminate.class, "Terminate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(yieldEClass, Yield.class, "Yield", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(yieldToEClass, YieldTo.class, "YieldTo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getYieldTo_ObjectAccess(), this.getExpression(), null, "objectAccess", null, 1, 1, YieldTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitEClass, Wait.class, "Wait", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reactivateEClass, Reactivate.class, "Reactivate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReactivate_ObjectAccess(), this.getExpression(), null, "objectAccess", null, 1, 1, Reactivate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activateObjectEClass, ActivateObject.class, "ActivateObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivateObject_ObjectAccess(), this.getExpression(), null, "objectAccess", null, 1, 1, ActivateObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivateObject_Priority(), ecorePackage.getEInt(), "priority", "0", 1, 1, ActivateObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(advanceEClass, Advance.class, "Advance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdvance_Time(), this.getExpression(), null, "time", null, 1, 1, Advance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(printEClass, Print.class, "Print", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrint_Outputs(), this.getExpression(), null, "outputs", null, 0, -1, Print.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_TrueCase(), this.getStatement(), null, "trueCase", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_FalseCase(), this.getStatement(), null, "falseCase", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localScopeEClass, LocalScope.class, "LocalScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalScope_Statements(), this.getStatement(), null, "statements", null, 0, -1, LocalScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localScopeStatementEClass, LocalScopeStatement.class, "LocalScopeStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_Termination(), this.getExpression(), null, "termination", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Increment(), this.getAssignment(), null, "increment", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Body(), this.getStatement(), null, "body", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileStatement_Body(), this.getStatement(), null, "body", null, 1, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchStatementEClass, SwitchStatement.class, "SwitchStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchStatement_Variable(), this.getVariableAccess(), null, "variable", null, 1, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchStatement_Cases(), this.getSwitchCase(), null, "cases", null, 0, -1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchStatement_DefaultCase(), this.getSwitchCase(), null, "defaultCase", null, 0, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseEClass, SwitchCase.class, "SwitchCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchCase_Value(), this.getExpression(), null, "value", null, 1, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchCase_Body(), this.getStatement(), null, "body", null, 0, -1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l1ExprEClass, L1Expr.class, "L1Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l2ExprEClass, L2Expr.class, "L2Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l3ExprEClass, L3Expr.class, "L3Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l4ExprEClass, L4Expr.class, "L4Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l5ExprEClass, L5Expr.class, "L5Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l6ExprEClass, L6Expr.class, "L6Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l7ExprEClass, L7Expr.class, "L7Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l8ExprEClass, L8Expr.class, "L8Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l9ExprEClass, L9Expr.class, "L9Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryOperatorEClass, BinaryOperator.class, "BinaryOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryOperator_Op1(), this.getExpression(), null, "op1", null, 1, 1, BinaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryOperator_Op2(), this.getExpression(), null, "op2", null, 1, 1, BinaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryOperatorEClass, UnaryOperator.class, "UnaryOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryOperator_Op(), this.getExpression(), null, "op", null, 1, 1, UnaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEqualEClass, NotEqual.class, "NotEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalEClass, Equal.class, "Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterEClass, Greater.class, "Greater", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterEqualEClass, GreaterEqual.class, "GreaterEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessEClass, Less.class, "Less", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessEqualEClass, LessEqual.class, "LessEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceOfEClass, InstanceOf.class, "InstanceOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(plusEClass, Plus.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(minusEClass, Minus.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mulEClass, Mul.class, "Mul", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modEClass, Mod.class, "Mod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(divEClass, Div.class, "Div", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(negEClass, Neg.class, "Neg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(castEClass, Cast.class, "Cast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createObjectEClass, CreateObject.class, "CreateObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullLiteralEClass, NullLiteral.class, "NullLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeLiteralEClass, TimeLiteral.class, "TimeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activeLiteralEClass, ActiveLiteral.class, "ActiveLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intLiteralEClass, IntLiteral.class, "IntLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntLiteral_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trueLiteralEClass, TrueLiteral.class, "TrueLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseLiteralEClass, FalseLiteral.class, "FalseLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleLiteral_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandExprEClass, ExpandExpr.class, "ExpandExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandExpr_Expr(), this.getExpression(), null, "expr", null, 1, 1, ExpandExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parseExprEClass, ParseExpr.class, "ParseExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParseExpr_AstPart(), this.getConstruct(), null, "astPart", null, 1, 1, ParseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predefinedIdEClass, PredefinedId.class, "PredefinedId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meLiteralEClass, MeLiteral.class, "MeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(superLiteralEClass, SuperLiteral.class, "SuperLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaLiteralEClass, MetaLiteral.class, "MetaLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeLiteralEClass, TypeLiteral.class, "TypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sizeOfArrayEClass, SizeOfArray.class, "SizeOfArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(annotationLiteralEClass, AnnotationLiteral.class, "AnnotationLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(idExprEClass, IdExpr.class, "IdExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdExpr_ParentIdExpr(), this.getIdExpr(), null, "parentIdExpr", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdExpr_ReferencedElement(), this.getNamedElement(), null, "referencedElement", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdExpr_PredefinedId(), this.getPredefinedId(), null, "predefinedId", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdExpr_ArrayIndex(), this.getExpression(), null, "arrayIndex", null, 0, -1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdExpr_CallPart(), this.getCallPart(), null, "callPart", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callPartEClass, CallPart.class, "CallPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallPart_CallArguments(), this.getExpression(), null, "callArguments", null, 0, -1, CallPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementAccessEClass, ElementAccess.class, "ElementAccess", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementAccess_IdExpr(), this.getIdExpr(), null, "idExpr", null, 0, 1, ElementAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableAccessEClass, VariableAccess.class, "VariableAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaAccessEClass, MetaAccess.class, "MetaAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeAccessEClass, TypeAccess.class, "TypeAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(extensionEClass, Extension.class, "Extension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtension_ExtensionPoint(), this.getConcept(), null, "extensionPoint", null, 1, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtension_SyntaxDefinition(), this.getSyntaxDefinition(), null, "syntaxDefinition", null, 1, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionSemanticsEClass, ExtensionSemantics.class, "ExtensionSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionSemantics_SyntaxDefinition(), this.getExtension(), null, "syntaxDefinition", null, 1, 1, ExtensionSemantics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syntaxDefinitionEClass, SyntaxDefinition.class, "SyntaxDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSyntaxDefinition_StartSymbol(), this.getMetaSymbol(), null, "startSymbol", null, 1, 1, SyntaxDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSyntaxDefinition_Symbols(), this.getMetaSymbol(), null, "symbols", null, 0, -1, SyntaxDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syntaxSymbolClassifierEClass, SyntaxSymbolClassifier.class, "SyntaxSymbolClassifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexSymbolEClass, ComplexSymbol.class, "ComplexSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptEClass, Concept.class, "Concept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaSymbolEClass, MetaSymbol.class, "MetaSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaSymbol_PossibleSyntax(), this.getSyntaxExpression(), null, "possibleSyntax", null, 1, 1, MetaSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syntaxExpressionEClass, SyntaxExpression.class, "SyntaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l3SyntaxExpressionEClass, L3SyntaxExpression.class, "L3SyntaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l2SyntaxExpressionEClass, L2SyntaxExpression.class, "L2SyntaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(symbolSequenceEClass, SymbolSequence.class, "SymbolSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolSequence_Sequence(), this.getSyntaxExpression(), null, "sequence", null, 0, -1, SymbolSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(l1SyntaxExpressionEClass, L1SyntaxExpression.class, "L1SyntaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structuralSymbolReferenceEClass, StructuralSymbolReference.class, "StructuralSymbolReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructuralSymbolReference_List(), ecorePackage.getEBoolean(), "list", "false", 1, 1, StructuralSymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuralSymbolReference_Composite(), ecorePackage.getEBoolean(), "composite", null, 1, 1, StructuralSymbolReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuralSymbolReference_LocalScopedReference(), ecorePackage.getEBoolean(), "localScopedReference", "false", 1, 1, StructuralSymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuralSymbolReference_GlobalScopedReference(), ecorePackage.getEBoolean(), "globalScopedReference", "false", 1, 1, StructuralSymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plainSymbolReferenceEClass, PlainSymbolReference.class, "PlainSymbolReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlainSymbolReference_Classifier(), this.getSyntaxSymbolClassifier(), null, "classifier", null, 1, 1, PlainSymbolReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPlainSymbolReference_OwnedClassifier(), this.getSyntaxSymbolClassifier(), null, "ownedClassifier", null, 0, 1, PlainSymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlainSymbolReference_ReferencedClassifier(), this.getSyntaxSymbolClassifier(), null, "referencedClassifier", null, 0, 1, PlainSymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementarySymbolEClass, ElementarySymbol.class, "ElementarySymbol", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(idSymbolEClass, IdSymbol.class, "IdSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intSymbolEClass, IntSymbol.class, "IntSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringSymbolEClass, StringSymbol.class, "StringSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(keywordEClass, Keyword.class, "Keyword", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeyword_Keyword(), ecorePackage.getEString(), "keyword", null, 1, 1, Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaExprEClass, MetaExpr.class, "MetaExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaExpr_Expr(), this.getExpression(), null, "expr", null, 1, 1, MetaExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetStatementEClass, TargetStatement.class, "TargetStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetStatement_Body(), this.getStatement(), null, "body", null, 1, 1, TargetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createIdStatementEClass, CreateIdStatement.class, "CreateIdStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expansionStatementEClass, ExpansionStatement.class, "ExpansionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpansionStatement_ClassContext(), ecorePackage.getEBoolean(), "classContext", "false", 1, 1, ExpansionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpansionStatement_FunctionContext(), ecorePackage.getEBoolean(), "functionContext", "false", 1, 1, ExpansionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpansionStatement_VariableContext(), ecorePackage.getEBoolean(), "variableContext", "false", 1, 1, ExpansionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpansionStatement_DifferingContext(), this.getIdExpr(), null, "differingContext", null, 0, 1, ExpansionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpansionStatement_Parts(), this.getExpansionPart(), null, "parts", null, 0, -1, ExpansionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpansionStatement_Exprs(), this.getExpression(), null, "exprs", null, 0, -1, ExpansionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expansionPartEClass, ExpansionPart.class, "ExpansionPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expandTextPartEClass, ExpandTextPart.class, "ExpandTextPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpandTextPart_Text(), ecorePackage.getEString(), "text", null, 1, 1, ExpandTextPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandVariablePartEClass, ExpandVariablePart.class, "ExpandVariablePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandVariablePart_Expr(), this.getExpression(), null, "expr", null, 1, 1, ExpandVariablePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandExpressionEClass, ExpandExpression.class, "ExpandExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandExpression_MetaObject(), this.getExpression(), null, "metaObject", null, 1, 1, ExpandExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandStatementEClass, ExpandStatement.class, "ExpandStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandStatement_MetaObject(), this.getExpression(), null, "metaObject", null, 1, 1, ExpandStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpandStatement_Location(), this.getExpression(), null, "location", null, 0, 1, ExpandStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeQuoteExpressionEClass, CodeQuoteExpression.class, "CodeQuoteExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeQuoteExpression_QuotedCode(), this.getQuotedCode(), null, "quotedCode", null, 1, 1, CodeQuoteExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quotedCodeEClass, QuotedCode.class, "QuotedCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedExpressionEClass, QuotedExpression.class, "QuotedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuotedExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, QuotedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quotedStatementsEClass, QuotedStatements.class, "QuotedStatements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuotedStatements_Statements(), this.getStatement(), null, "statements", null, 0, -1, QuotedStatements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quotedClassContentEClass, QuotedClassContent.class, "QuotedClassContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedModuleContentEClass, QuotedModuleContent.class, "QuotedModuleContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPattern_Top(), ecorePackage.getEBoolean(), "top", "false", 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Context(), this.getParameter(), null, "context", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Body(), this.getStatement(), null, "body", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testStatementEClass, TestStatement.class, "TestStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestStatement_Value(), ecorePackage.getEInt(), "value", null, 1, 1, TestStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";	
		addAnnotation
		  (getFunction_Class(), 
		   source, 
		   new String[] {
			 "body", "SuperClassSpecification"
		   });	
		addAnnotation
		  (getNativeBinding_TargetLanguage(), 
		   source, 
		   new String[] {
			 "body", "SuperClassSpecification",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getNativeBinding_TargetType(), 
		   source, 
		   new String[] {
			 "body", "SuperClassSpecification"
		   });	
		addAnnotation
		  (getClass_Active(), 
		   source, 
		   new String[] {
			 "body", "Constructor"
		   });	
		addAnnotation
		  (getDoubleLiteral_Value(), 
		   source, 
		   new String[] {
			 "body", "ExpandExpr"
		   });	
		addAnnotation
		  (getStructuralSymbolReference_List(), 
		   source, 
		   new String[] {
			 "body", "PlainSymbolReference",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getStructuralSymbolReference_List(), 
		   source, 
		   new String[] {
			 "body", "PlainSymbolReference",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getStructuralSymbolReference_Composite(), 
		   source, 
		   new String[] {
			 "body", "PlainSymbolReference"
		   });	
		addAnnotation
		  (getStructuralSymbolReference_Composite(), 
		   source, 
		   new String[] {
			 "body", "PlainSymbolReference"
		   });	
		addAnnotation
		  (getStructuralSymbolReference_LocalScopedReference(), 
		   source, 
		   new String[] {
			 "body", "PlainSymbolReference",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getStructuralSymbolReference_LocalScopedReference(), 
		   source, 
		   new String[] {
			 "body", "PlainSymbolReference",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getKeyword_Keyword(), 
		   source, 
		   new String[] {
			 "body", "MetaExpr"
		   });	
		addAnnotation
		  (getKeyword_Keyword(), 
		   source, 
		   new String[] {
			 "body", "MetaExpr"
		   });	
		addAnnotation
		  (getPattern_Top(), 
		   source, 
		   new String[] {
			 "body", "QuotedStatements"
		   });	
		addAnnotation
		  (getPattern_Top(), 
		   source, 
		   new String[] {
			 "body", "QuotedStatements"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";	
		addAnnotation
		  (getStructuralSymbolReference_Composite(), 
		   source, 
		   new String[] {
			 "derivation", "not localScopedReference and not globalScopedReference"
		   });
	}

} //DblPackageImpl
