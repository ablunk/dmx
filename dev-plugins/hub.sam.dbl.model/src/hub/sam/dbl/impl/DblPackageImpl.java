/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.impl;

import hub.sam.dbl.AbstractVariable;
import hub.sam.dbl.ActivateObject;
import hub.sam.dbl.ActiveLiteral;
import hub.sam.dbl.AddToSet;
import hub.sam.dbl.Advance;
import hub.sam.dbl.AfterInSet;
import hub.sam.dbl.AlternativeExpr;
import hub.sam.dbl.And;
import hub.sam.dbl.AnnotatableElement;
import hub.sam.dbl.Annotation;
import hub.sam.dbl.AnnotationApplication;
import hub.sam.dbl.ArbitraryExpr;
import hub.sam.dbl.ArgumentExpression;
import hub.sam.dbl.Assignment;
import hub.sam.dbl.AtLeastOneExpr;
import hub.sam.dbl.BeforeInSet;
import hub.sam.dbl.BinaryOperator;
import hub.sam.dbl.BindingExprOpKind;
import hub.sam.dbl.BoolType;
import hub.sam.dbl.BooleanPropertyType;
import hub.sam.dbl.BreakStatement;
import hub.sam.dbl.Cast;
import hub.sam.dbl.ClassAugment;
import hub.sam.dbl.ClassContentExtension;
import hub.sam.dbl.ClassSimilar;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.CodeQuoteExpression;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.CompositeStatement;
import hub.sam.dbl.ConsiderIdElements;
import hub.sam.dbl.Construct;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.Contains;
import hub.sam.dbl.ContinueStatement;
import hub.sam.dbl.CreateObject;
import hub.sam.dbl.DblFactory;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.DepIdentifiableElement;
import hub.sam.dbl.DeprecatedProcedureCallStatement;
import hub.sam.dbl.Div;
import hub.sam.dbl.DoubleLiteral;
import hub.sam.dbl.DoubleType;
import hub.sam.dbl.DynamicMappingPart;
import hub.sam.dbl.ElementAccess;
import hub.sam.dbl.EmbeddableExtensionsContainer;
import hub.sam.dbl.EmptySet;
import hub.sam.dbl.Equal;
import hub.sam.dbl.EvalExpr;
import hub.sam.dbl.ExpandExpression;
import hub.sam.dbl.ExpandSection;
import hub.sam.dbl.ExpandStatement;
import hub.sam.dbl.ExpandableElement;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExpressionStatement;
import hub.sam.dbl.Extension;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.ExtensionRule;
import hub.sam.dbl.FalseLiteral;
import hub.sam.dbl.FindContainer;
import hub.sam.dbl.FirstInSet;
import hub.sam.dbl.FixedMappingPart;
import hub.sam.dbl.ForEachStatement;
import hub.sam.dbl.Greater;
import hub.sam.dbl.GreaterEqual;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.IdPropertyType;
import hub.sam.dbl.IdResolution;
import hub.sam.dbl.IfStatement;
import hub.sam.dbl.Import;
import hub.sam.dbl.IncludePattern;
import hub.sam.dbl.IndexOf;
import hub.sam.dbl.InstanceOf;
import hub.sam.dbl.IntLiteral;
import hub.sam.dbl.IntPropertyType;
import hub.sam.dbl.IntType;
import hub.sam.dbl.Interface;
import hub.sam.dbl.KeyValuePair;
import hub.sam.dbl.L1Expr;
import hub.sam.dbl.LastInSet;
import hub.sam.dbl.Less;
import hub.sam.dbl.LessEqual;
import hub.sam.dbl.Mapping;
import hub.sam.dbl.MappingPart;
import hub.sam.dbl.MappingStatement;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.MetaAccess;
import hub.sam.dbl.MetaExpr;
import hub.sam.dbl.MetaLiteral;
import hub.sam.dbl.Minus;
import hub.sam.dbl.Mod;
import hub.sam.dbl.Model;
import hub.sam.dbl.ModifierExtensionsContainer;
import hub.sam.dbl.Module;
import hub.sam.dbl.ModuleContentExtension;
import hub.sam.dbl.Mul;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NamedExtension;
import hub.sam.dbl.NativeBinding;
import hub.sam.dbl.Neg;
import hub.sam.dbl.Not;
import hub.sam.dbl.NotEqual;
import hub.sam.dbl.NullLiteral;
import hub.sam.dbl.ObjectAt;
import hub.sam.dbl.OptionalExpr;
import hub.sam.dbl.Or;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.Pattern;
import hub.sam.dbl.Plus;
import hub.sam.dbl.PotentiallyHiddenIdElements;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.PrimitiveType;
import hub.sam.dbl.Print;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.ProcedureCall;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.QuotedClassContent;
import hub.sam.dbl.QuotedCode;
import hub.sam.dbl.QuotedExpression;
import hub.sam.dbl.QuotedModuleContent;
import hub.sam.dbl.QuotedStatements;
import hub.sam.dbl.Reactivate;
import hub.sam.dbl.ReferableRhsType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.RemoveFromSet;
import hub.sam.dbl.ResetGenContextStatement;
import hub.sam.dbl.ResumeGenStatement;
import hub.sam.dbl.Return;
import hub.sam.dbl.RhsExpression;
import hub.sam.dbl.RuleExpr;
import hub.sam.dbl.RuntimeExpr;
import hub.sam.dbl.SaveGenStatement;
import hub.sam.dbl.SequenceExpr;
import hub.sam.dbl.SetGenContextStatement;
import hub.sam.dbl.SetOp;
import hub.sam.dbl.SetStatement;
import hub.sam.dbl.SimpleAnnotation;
import hub.sam.dbl.SimpleStatement;
import hub.sam.dbl.SizeOfSet;
import hub.sam.dbl.StartCodeBlock;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StatementExpression;
import hub.sam.dbl.StringLiteral;
import hub.sam.dbl.StringPropertyType;
import hub.sam.dbl.StringType;
import hub.sam.dbl.StructuredPropertyType;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.TargetStatement;
import hub.sam.dbl.TerminalExpr;
import hub.sam.dbl.Terminate;
import hub.sam.dbl.TestStatement;
import hub.sam.dbl.TextualSyntaxDef;
import hub.sam.dbl.TimeLiteral;
import hub.sam.dbl.TrueLiteral;
import hub.sam.dbl.TsRule;
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	private EClass embeddableExtensionsContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierExtensionsContainerEClass = null;

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
	private EClass procedureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleAnnotationEClass = null;

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
	private EClass annotationApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyValuePairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

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
	private EClass classSimilarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startCodeBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clazzEClass = null;

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
	private EClass classAugmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

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
	private EClass codeBlockEClass = null;

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
	private EClass compositeStatementEClass = null;

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
	private EClass expressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementExpressionEClass = null;

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
	private EClass deprecatedProcedureCallStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureCallEClass = null;

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
	private EClass setStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeFromSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addToSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptySetEClass = null;

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
	private EClass whileStatementEClass = null;

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
	private EClass forEachStatementEClass = null;

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
	private EClass andEClass = null;

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
	private EClass instanceOfEClass = null;

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
	private EClass createObjectEClass = null;

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
	private EClass evalExprEClass = null;

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
	private EClass setOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sizeOfSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass firstInSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lastInSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexOfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectAtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beforeInSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass afterInSetEClass = null;

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
	private EClass depIdentifiableElementEClass = null;

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
	private EClass idExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentExpressionEClass = null;

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
	private EClass namedExtensionEClass = null;

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
	private EClass moduleContentExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textualSyntaxDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referableRhsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tsRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rhsExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionalExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atLeastOneExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arbitraryExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternativeExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminalExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyBindingExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idPropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intPropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringPropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanPropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredPropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositePropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencePropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingPartEClass = null;

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
	private EClass mappingStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setGenContextStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetGenContextStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saveGenStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resumeGenStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedMappingPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicMappingPartEClass = null;

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
	private EClass expandSectionEClass = null;

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
	private EClass expandableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idResolutionEClass = null;

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
	private EClass potentiallyHiddenIdElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass findContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass considerIdElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bindingExprOpKindEEnum = null;

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
	public EAttribute getConstruct_ConcreteSyntax() {
		return (EAttribute)constructEClass.getEStructuralFeatures().get(0);
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
	public EReference getModule_Classifiers() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ClassAugments() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ExtensionDefs() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_AnnotationDefs() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Procedures() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Variables() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_IdRes() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmbeddableExtensionsContainer() {
		return embeddableExtensionsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmbeddableExtensionsContainer_Extensions() {
		return (EReference)embeddableExtensionsContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifierExtensionsContainer() {
		return modifierExtensionsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifierExtensionsContainer_ModifierExtensions() {
		return (EReference)modifierExtensionsContainerEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getTypedElement_IsList() {
		return (EAttribute)typedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_ClassifierTypeExpr() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(2);
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
	public EClass getProcedure() {
		return procedureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcedure_Parameters() {
		return (EReference)procedureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcedure_Clazz() {
		return (EAttribute)procedureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleAnnotation() {
		return simpleAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleAnnotation_Value() {
		return (EAttribute)simpleAnnotationEClass.getEStructuralFeatures().get(0);
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
	public EReference getAnnotation_Keys() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationApplication() {
		return annotationApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationApplication_AnnotationDef() {
		return (EReference)annotationApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationApplication_KeyValuePairs() {
		return (EReference)annotationApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyValuePair() {
		return keyValuePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyValuePair_Key() {
		return (EReference)keyValuePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyValuePair_Value() {
		return (EReference)keyValuePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotatableElement() {
		return annotatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotatableElement_AnnotationApplications() {
		return (EReference)annotatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotatableElement_SimpleAnnotations() {
		return (EReference)annotatableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_Bindings() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(0);
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
	public EClass getClassSimilar() {
		return classSimilarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_Attributes() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_Methods() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_SuperClass() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_ImplementedInterfaces() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_InitialBlock() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_FinalBlock() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_ActionsBlock() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_ReportBlock() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSimilar_ClearBlock() {
		return (EReference)classSimilarEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartCodeBlock() {
		return startCodeBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClazz() {
		return clazzEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClazz_Active() {
		return (EAttribute)clazzEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClazz_Constructor() {
		return (EReference)clazzEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClazz_BaseConstructorArguments() {
		return (EReference)clazzEClass.getEStructuralFeatures().get(2);
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
	public EClass getClassAugment() {
		return classAugmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassAugment_AugmentedClass() {
		return (EReference)classAugmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Methods() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_SuperInterfaces() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getVariable_Clazz() {
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
	public EClass getCodeBlock() {
		return codeBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeBlock_Statements() {
		return (EReference)codeBlockEClass.getEStructuralFeatures().get(0);
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
	public EClass getCompositeStatement() {
		return compositeStatementEClass;
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
	public EClass getExpressionStatement() {
		return expressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionStatement_Expression() {
		return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatementExpression() {
		return statementExpressionEClass;
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
	public EClass getDeprecatedProcedureCallStatement() {
		return deprecatedProcedureCallStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeprecatedProcedureCallStatement_ProcedureCall() {
		return (EReference)deprecatedProcedureCallStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcedureCall() {
		return procedureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcedureCall_ProcedureAccess() {
		return (EReference)procedureCallEClass.getEStructuralFeatures().get(0);
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
	public EClass getSetStatement() {
		return setStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetStatement_Object() {
		return (EReference)setStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetStatement_Set() {
		return (EReference)setStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveFromSet() {
		return removeFromSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddToSet() {
		return addToSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddToSet_AtIndex() {
		return (EReference)addToSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptySet() {
		return emptySetEClass;
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
	public EReference getIfStatement_IfCaseBlock() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ElifCondition() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ElifCaseBlock() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ElseCaseBlock() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(4);
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
	public EReference getWhileStatement_WhileBlock() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
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
	public EClass getForEachStatement() {
		return forEachStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_IteratorVariableDefinition() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_IteratorVariableReference() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_IterableExpression() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_ForBlock() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(3);
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
	public EClass getAnd() {
		return andEClass;
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
	public EClass getInstanceOf() {
		return instanceOfEClass;
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
	public EClass getCreateObject() {
		return createObjectEClass;
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
	public EClass getEvalExpr() {
		return evalExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvalExpr_Expr() {
		return (EReference)evalExprEClass.getEStructuralFeatures().get(0);
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
	public EClass getSetOp() {
		return setOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetOp_Set() {
		return (EReference)setOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSizeOfSet() {
		return sizeOfSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFirstInSet() {
		return firstInSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLastInSet() {
		return lastInSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContains() {
		return containsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexOf() {
		return indexOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectAt() {
		return objectAtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeforeInSet() {
		return beforeInSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAfterInSet() {
		return afterInSetEClass;
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
	public EClass getDepIdentifiableElement() {
		return depIdentifiableElementEClass;
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
	public EReference getIdExpr_Arguments() {
		return (EReference)idExprEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgumentExpression() {
		return argumentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgumentExpression_Arguments() {
		return (EReference)argumentExpressionEClass.getEStructuralFeatures().get(0);
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
	public EClass getNamedExtension() {
		return namedExtensionEClass;
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
	public EClass getModuleContentExtension() {
		return moduleContentExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionDefinition() {
		return extensionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_AbstractSyntaxDef() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_TextualSyntaxDef() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_MappingDef() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextualSyntaxDef() {
		return textualSyntaxDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextualSyntaxDef_ExtensionRule() {
		return (EReference)textualSyntaxDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextualSyntaxDef_NewRules() {
		return (EReference)textualSyntaxDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferableRhsType() {
		return referableRhsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTsRule() {
		return tsRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTsRule_MetaClassName() {
		return (EAttribute)tsRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTsRule_Rhs() {
		return (EReference)tsRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionRule() {
		return extensionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionRule_InstantiableMetaClass() {
		return (EReference)extensionRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionRule_FirstNewRule() {
		return (EReference)extensionRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRhsExpression() {
		return rhsExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceExpr() {
		return sequenceExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceExpr_Sequence() {
		return (EReference)sequenceExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionalExpr() {
		return optionalExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptionalExpr_Expression() {
		return (EReference)optionalExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeExpr() {
		return runtimeExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeExpr_Expression() {
		return (EReference)runtimeExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtLeastOneExpr() {
		return atLeastOneExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtLeastOneExpr_Expression() {
		return (EReference)atLeastOneExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArbitraryExpr() {
		return arbitraryExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArbitraryExpr_Expression() {
		return (EReference)arbitraryExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternativeExpr() {
		return alternativeExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternativeExpr_Left() {
		return (EReference)alternativeExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternativeExpr_Right() {
		return (EReference)alternativeExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminalExpr() {
		return terminalExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminalExpr_Terminal() {
		return (EAttribute)terminalExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyBindingExpr() {
		return propertyBindingExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyBindingExpr_PropertyType() {
		return (EReference)propertyBindingExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyBindingExpr_Operator() {
		return (EAttribute)propertyBindingExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleExpr() {
		return ruleExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleExpr_Rule() {
		return (EReference)ruleExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyType() {
		return propertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdPropertyType() {
		return idPropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntPropertyType() {
		return intPropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringPropertyType() {
		return stringPropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanPropertyType() {
		return booleanPropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanPropertyType_Terminal() {
		return (EAttribute)booleanPropertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredPropertyType() {
		return structuredPropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredPropertyType_Type() {
		return (EReference)structuredPropertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositePropertyType() {
		return compositePropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositePropertyType_List() {
		return (EAttribute)compositePropertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferencePropertyType() {
		return referencePropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferencePropertyType_IdResolutionPattern() {
		return (EReference)referencePropertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferencePropertyType_RawReference() {
		return (EAttribute)referencePropertyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Parts() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_MetaObject() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingPart() {
		return mappingPartEClass;
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
	public EReference getTargetStatement_CodeBlock() {
		return (EReference)targetStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingStatement() {
		return mappingStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingStatement_Parts() {
		return (EReference)mappingStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingStatement_Exprs() {
		return (EReference)mappingStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetGenContextStatement() {
		return setGenContextStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetGenContextStatement_Context() {
		return (EReference)setGenContextStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetGenContextStatement_AddAfterContext() {
		return (EAttribute)setGenContextStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResetGenContextStatement() {
		return resetGenContextStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSaveGenStatement() {
		return saveGenStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSaveGenStatement_Variable() {
		return (EReference)saveGenStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResumeGenStatement() {
		return resumeGenStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResumeGenStatement_Variable() {
		return (EReference)resumeGenStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedMappingPart() {
		return fixedMappingPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedMappingPart_Code() {
		return (EAttribute)fixedMappingPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicMappingPart() {
		return dynamicMappingPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicMappingPart_Expr() {
		return (EReference)dynamicMappingPartEClass.getEStructuralFeatures().get(0);
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
	public EClass getExpandSection() {
		return expandSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandSection_CodeBlock() {
		return (EReference)expandSectionEClass.getEStructuralFeatures().get(0);
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
	public EClass getExpandableElement() {
		return expandableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandableElement_ExpandExpression() {
		return (EReference)expandableElementEClass.getEStructuralFeatures().get(0);
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
	public EClass getIdResolution() {
		return idResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdResolution_MetaModelPlatformURI() {
		return (EAttribute)idResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdResolution_Patterns() {
		return (EReference)idResolutionEClass.getEStructuralFeatures().get(1);
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
	public EReference getPattern_CodeBlock() {
		return (EReference)patternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPotentiallyHiddenIdElements() {
		return potentiallyHiddenIdElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPotentiallyHiddenIdElements_CodeBlock() {
		return (EReference)potentiallyHiddenIdElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFindContainer() {
		return findContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFindContainer_VariableBinding() {
		return (EReference)findContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFindContainer_ContainerBlock() {
		return (EReference)findContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFindContainer_ElseBlock() {
		return (EReference)findContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConsiderIdElements() {
		return considerIdElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsiderIdElements_ElementsQuery() {
		return (EReference)considerIdElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncludePattern() {
		return includePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncludePattern_Pattern() {
		return (EReference)includePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncludePattern_Context() {
		return (EReference)includePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBindingExprOpKind() {
		return bindingExprOpKindEEnum;
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
		createEAttribute(constructEClass, CONSTRUCT__CONCRETE_SYNTAX);

		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__IMPORTS);
		createEReference(modelEClass, MODEL__MODULES);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__FILE);
		createEReference(importEClass, IMPORT__MODEL);

		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__CLASSIFIERS);
		createEReference(moduleEClass, MODULE__CLASS_AUGMENTS);
		createEReference(moduleEClass, MODULE__EXTENSION_DEFS);
		createEReference(moduleEClass, MODULE__ANNOTATION_DEFS);
		createEReference(moduleEClass, MODULE__PROCEDURES);
		createEReference(moduleEClass, MODULE__VARIABLES);
		createEReference(moduleEClass, MODULE__ID_RES);

		embeddableExtensionsContainerEClass = createEClass(EMBEDDABLE_EXTENSIONS_CONTAINER);
		createEReference(embeddableExtensionsContainerEClass, EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS);

		modifierExtensionsContainerEClass = createEClass(MODIFIER_EXTENSIONS_CONTAINER);
		createEReference(modifierExtensionsContainerEClass, MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS);

		typeEClass = createEClass(TYPE);

		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__PRIMITIVE_TYPE);
		createEAttribute(typedElementEClass, TYPED_ELEMENT__IS_LIST);
		createEReference(typedElementEClass, TYPED_ELEMENT__CLASSIFIER_TYPE_EXPR);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		voidTypeEClass = createEClass(VOID_TYPE);

		intTypeEClass = createEClass(INT_TYPE);

		boolTypeEClass = createEClass(BOOL_TYPE);

		doubleTypeEClass = createEClass(DOUBLE_TYPE);

		stringTypeEClass = createEClass(STRING_TYPE);

		procedureEClass = createEClass(PROCEDURE);
		createEReference(procedureEClass, PROCEDURE__PARAMETERS);
		createEAttribute(procedureEClass, PROCEDURE__CLAZZ);

		simpleAnnotationEClass = createEClass(SIMPLE_ANNOTATION);
		createEAttribute(simpleAnnotationEClass, SIMPLE_ANNOTATION__VALUE);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__KEYS);

		annotationApplicationEClass = createEClass(ANNOTATION_APPLICATION);
		createEReference(annotationApplicationEClass, ANNOTATION_APPLICATION__ANNOTATION_DEF);
		createEReference(annotationApplicationEClass, ANNOTATION_APPLICATION__KEY_VALUE_PAIRS);

		keyValuePairEClass = createEClass(KEY_VALUE_PAIR);
		createEReference(keyValuePairEClass, KEY_VALUE_PAIR__KEY);
		createEReference(keyValuePairEClass, KEY_VALUE_PAIR__VALUE);

		annotatableElementEClass = createEClass(ANNOTATABLE_ELEMENT);
		createEReference(annotatableElementEClass, ANNOTATABLE_ELEMENT__ANNOTATION_APPLICATIONS);
		createEReference(annotatableElementEClass, ANNOTATABLE_ELEMENT__SIMPLE_ANNOTATIONS);

		classifierEClass = createEClass(CLASSIFIER);
		createEReference(classifierEClass, CLASSIFIER__BINDINGS);

		nativeBindingEClass = createEClass(NATIVE_BINDING);
		createEAttribute(nativeBindingEClass, NATIVE_BINDING__TARGET_LANGUAGE);
		createEAttribute(nativeBindingEClass, NATIVE_BINDING__TARGET_TYPE);

		classSimilarEClass = createEClass(CLASS_SIMILAR);
		createEReference(classSimilarEClass, CLASS_SIMILAR__ATTRIBUTES);
		createEReference(classSimilarEClass, CLASS_SIMILAR__METHODS);
		createEReference(classSimilarEClass, CLASS_SIMILAR__SUPER_CLASS);
		createEReference(classSimilarEClass, CLASS_SIMILAR__IMPLEMENTED_INTERFACES);
		createEReference(classSimilarEClass, CLASS_SIMILAR__INITIAL_BLOCK);
		createEReference(classSimilarEClass, CLASS_SIMILAR__FINAL_BLOCK);
		createEReference(classSimilarEClass, CLASS_SIMILAR__ACTIONS_BLOCK);
		createEReference(classSimilarEClass, CLASS_SIMILAR__REPORT_BLOCK);
		createEReference(classSimilarEClass, CLASS_SIMILAR__CLEAR_BLOCK);

		startCodeBlockEClass = createEClass(START_CODE_BLOCK);

		clazzEClass = createEClass(CLAZZ);
		createEAttribute(clazzEClass, CLAZZ__ACTIVE);
		createEReference(clazzEClass, CLAZZ__CONSTRUCTOR);
		createEReference(clazzEClass, CLAZZ__BASE_CONSTRUCTOR_ARGUMENTS);

		constructorEClass = createEClass(CONSTRUCTOR);
		createEReference(constructorEClass, CONSTRUCTOR__PARAMETERS);

		classAugmentEClass = createEClass(CLASS_AUGMENT);
		createEReference(classAugmentEClass, CLASS_AUGMENT__AUGMENTED_CLASS);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__METHODS);
		createEReference(interfaceEClass, INTERFACE__SUPER_INTERFACES);

		abstractVariableEClass = createEClass(ABSTRACT_VARIABLE);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__CONTROL);
		createEAttribute(variableEClass, VARIABLE__CLAZZ);
		createEReference(variableEClass, VARIABLE__INITIAL_VALUE);

		parameterEClass = createEClass(PARAMETER);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		codeBlockEClass = createEClass(CODE_BLOCK);
		createEReference(codeBlockEClass, CODE_BLOCK__STATEMENTS);

		statementEClass = createEClass(STATEMENT);

		compositeStatementEClass = createEClass(COMPOSITE_STATEMENT);

		simpleStatementEClass = createEClass(SIMPLE_STATEMENT);

		expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
		createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);

		statementExpressionEClass = createEClass(STATEMENT_EXPRESSION);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__VARIABLE);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);

		deprecatedProcedureCallStatementEClass = createEClass(DEPRECATED_PROCEDURE_CALL_STATEMENT);
		createEReference(deprecatedProcedureCallStatementEClass, DEPRECATED_PROCEDURE_CALL_STATEMENT__PROCEDURE_CALL);

		procedureCallEClass = createEClass(PROCEDURE_CALL);
		createEReference(procedureCallEClass, PROCEDURE_CALL__PROCEDURE_ACCESS);

		returnEClass = createEClass(RETURN);
		createEReference(returnEClass, RETURN__VALUE);

		waitUntilEClass = createEClass(WAIT_UNTIL);
		createEReference(waitUntilEClass, WAIT_UNTIL__CONDITION);

		terminateEClass = createEClass(TERMINATE);

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

		setStatementEClass = createEClass(SET_STATEMENT);
		createEReference(setStatementEClass, SET_STATEMENT__OBJECT);
		createEReference(setStatementEClass, SET_STATEMENT__SET);

		removeFromSetEClass = createEClass(REMOVE_FROM_SET);

		addToSetEClass = createEClass(ADD_TO_SET);
		createEReference(addToSetEClass, ADD_TO_SET__AT_INDEX);

		emptySetEClass = createEClass(EMPTY_SET);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__CONDITION);
		createEReference(ifStatementEClass, IF_STATEMENT__IF_CASE_BLOCK);
		createEReference(ifStatementEClass, IF_STATEMENT__ELIF_CONDITION);
		createEReference(ifStatementEClass, IF_STATEMENT__ELIF_CASE_BLOCK);
		createEReference(ifStatementEClass, IF_STATEMENT__ELSE_CASE_BLOCK);

		whileStatementEClass = createEClass(WHILE_STATEMENT);
		createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
		createEReference(whileStatementEClass, WHILE_STATEMENT__WHILE_BLOCK);

		breakStatementEClass = createEClass(BREAK_STATEMENT);

		continueStatementEClass = createEClass(CONTINUE_STATEMENT);

		forEachStatementEClass = createEClass(FOR_EACH_STATEMENT);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ITERATOR_VARIABLE_DEFINITION);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ITERATOR_VARIABLE_REFERENCE);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ITERABLE_EXPRESSION);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__FOR_BLOCK);

		expressionEClass = createEClass(EXPRESSION);

		l1ExprEClass = createEClass(L1_EXPR);

		binaryOperatorEClass = createEClass(BINARY_OPERATOR);
		createEReference(binaryOperatorEClass, BINARY_OPERATOR__OP1);
		createEReference(binaryOperatorEClass, BINARY_OPERATOR__OP2);

		unaryOperatorEClass = createEClass(UNARY_OPERATOR);
		createEReference(unaryOperatorEClass, UNARY_OPERATOR__OP);

		andEClass = createEClass(AND);

		orEClass = createEClass(OR);

		greaterEClass = createEClass(GREATER);

		greaterEqualEClass = createEClass(GREATER_EQUAL);

		lessEClass = createEClass(LESS);

		lessEqualEClass = createEClass(LESS_EQUAL);

		notEqualEClass = createEClass(NOT_EQUAL);

		equalEClass = createEClass(EQUAL);

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

		evalExprEClass = createEClass(EVAL_EXPR);
		createEReference(evalExprEClass, EVAL_EXPR__EXPR);

		meLiteralEClass = createEClass(ME_LITERAL);

		superLiteralEClass = createEClass(SUPER_LITERAL);

		metaLiteralEClass = createEClass(META_LITERAL);

		typeLiteralEClass = createEClass(TYPE_LITERAL);

		setOpEClass = createEClass(SET_OP);
		createEReference(setOpEClass, SET_OP__SET);

		sizeOfSetEClass = createEClass(SIZE_OF_SET);

		firstInSetEClass = createEClass(FIRST_IN_SET);

		lastInSetEClass = createEClass(LAST_IN_SET);

		containsEClass = createEClass(CONTAINS);

		indexOfEClass = createEClass(INDEX_OF);

		objectAtEClass = createEClass(OBJECT_AT);

		beforeInSetEClass = createEClass(BEFORE_IN_SET);

		afterInSetEClass = createEClass(AFTER_IN_SET);

		depIdentifiableElementEClass = createEClass(DEP_IDENTIFIABLE_ELEMENT);

		predefinedIdEClass = createEClass(PREDEFINED_ID);

		idExprEClass = createEClass(ID_EXPR);
		createEReference(idExprEClass, ID_EXPR__PARENT_ID_EXPR);
		createEReference(idExprEClass, ID_EXPR__REFERENCED_ELEMENT);
		createEReference(idExprEClass, ID_EXPR__PREDEFINED_ID);
		createEReference(idExprEClass, ID_EXPR__ARGUMENTS);

		argumentExpressionEClass = createEClass(ARGUMENT_EXPRESSION);
		createEReference(argumentExpressionEClass, ARGUMENT_EXPRESSION__ARGUMENTS);

		elementAccessEClass = createEClass(ELEMENT_ACCESS);
		createEReference(elementAccessEClass, ELEMENT_ACCESS__ID_EXPR);

		variableAccessEClass = createEClass(VARIABLE_ACCESS);

		metaAccessEClass = createEClass(META_ACCESS);

		typeAccessEClass = createEClass(TYPE_ACCESS);

		extensionEClass = createEClass(EXTENSION);

		namedExtensionEClass = createEClass(NAMED_EXTENSION);

		classContentExtensionEClass = createEClass(CLASS_CONTENT_EXTENSION);

		moduleContentExtensionEClass = createEClass(MODULE_CONTENT_EXTENSION);

		extensionDefinitionEClass = createEClass(EXTENSION_DEFINITION);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__MAPPING_DEF);

		textualSyntaxDefEClass = createEClass(TEXTUAL_SYNTAX_DEF);
		createEReference(textualSyntaxDefEClass, TEXTUAL_SYNTAX_DEF__EXTENSION_RULE);
		createEReference(textualSyntaxDefEClass, TEXTUAL_SYNTAX_DEF__NEW_RULES);

		referableRhsTypeEClass = createEClass(REFERABLE_RHS_TYPE);

		tsRuleEClass = createEClass(TS_RULE);
		createEAttribute(tsRuleEClass, TS_RULE__META_CLASS_NAME);
		createEReference(tsRuleEClass, TS_RULE__RHS);

		extensionRuleEClass = createEClass(EXTENSION_RULE);
		createEReference(extensionRuleEClass, EXTENSION_RULE__INSTANTIABLE_META_CLASS);
		createEReference(extensionRuleEClass, EXTENSION_RULE__FIRST_NEW_RULE);

		rhsExpressionEClass = createEClass(RHS_EXPRESSION);

		sequenceExprEClass = createEClass(SEQUENCE_EXPR);
		createEReference(sequenceExprEClass, SEQUENCE_EXPR__SEQUENCE);

		optionalExprEClass = createEClass(OPTIONAL_EXPR);
		createEReference(optionalExprEClass, OPTIONAL_EXPR__EXPRESSION);

		runtimeExprEClass = createEClass(RUNTIME_EXPR);
		createEReference(runtimeExprEClass, RUNTIME_EXPR__EXPRESSION);

		atLeastOneExprEClass = createEClass(AT_LEAST_ONE_EXPR);
		createEReference(atLeastOneExprEClass, AT_LEAST_ONE_EXPR__EXPRESSION);

		arbitraryExprEClass = createEClass(ARBITRARY_EXPR);
		createEReference(arbitraryExprEClass, ARBITRARY_EXPR__EXPRESSION);

		alternativeExprEClass = createEClass(ALTERNATIVE_EXPR);
		createEReference(alternativeExprEClass, ALTERNATIVE_EXPR__LEFT);
		createEReference(alternativeExprEClass, ALTERNATIVE_EXPR__RIGHT);

		terminalExprEClass = createEClass(TERMINAL_EXPR);
		createEAttribute(terminalExprEClass, TERMINAL_EXPR__TERMINAL);

		propertyBindingExprEClass = createEClass(PROPERTY_BINDING_EXPR);
		createEReference(propertyBindingExprEClass, PROPERTY_BINDING_EXPR__PROPERTY_TYPE);
		createEAttribute(propertyBindingExprEClass, PROPERTY_BINDING_EXPR__OPERATOR);

		ruleExprEClass = createEClass(RULE_EXPR);
		createEReference(ruleExprEClass, RULE_EXPR__RULE);

		propertyTypeEClass = createEClass(PROPERTY_TYPE);

		idPropertyTypeEClass = createEClass(ID_PROPERTY_TYPE);

		intPropertyTypeEClass = createEClass(INT_PROPERTY_TYPE);

		stringPropertyTypeEClass = createEClass(STRING_PROPERTY_TYPE);

		booleanPropertyTypeEClass = createEClass(BOOLEAN_PROPERTY_TYPE);
		createEAttribute(booleanPropertyTypeEClass, BOOLEAN_PROPERTY_TYPE__TERMINAL);

		structuredPropertyTypeEClass = createEClass(STRUCTURED_PROPERTY_TYPE);
		createEReference(structuredPropertyTypeEClass, STRUCTURED_PROPERTY_TYPE__TYPE);

		compositePropertyTypeEClass = createEClass(COMPOSITE_PROPERTY_TYPE);
		createEAttribute(compositePropertyTypeEClass, COMPOSITE_PROPERTY_TYPE__LIST);

		referencePropertyTypeEClass = createEClass(REFERENCE_PROPERTY_TYPE);
		createEReference(referencePropertyTypeEClass, REFERENCE_PROPERTY_TYPE__ID_RESOLUTION_PATTERN);
		createEAttribute(referencePropertyTypeEClass, REFERENCE_PROPERTY_TYPE__RAW_REFERENCE);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__PARTS);
		createEReference(mappingEClass, MAPPING__META_OBJECT);

		mappingPartEClass = createEClass(MAPPING_PART);

		metaExprEClass = createEClass(META_EXPR);
		createEReference(metaExprEClass, META_EXPR__EXPR);

		targetStatementEClass = createEClass(TARGET_STATEMENT);
		createEReference(targetStatementEClass, TARGET_STATEMENT__CODE_BLOCK);

		mappingStatementEClass = createEClass(MAPPING_STATEMENT);
		createEReference(mappingStatementEClass, MAPPING_STATEMENT__PARTS);
		createEReference(mappingStatementEClass, MAPPING_STATEMENT__EXPRS);

		setGenContextStatementEClass = createEClass(SET_GEN_CONTEXT_STATEMENT);
		createEReference(setGenContextStatementEClass, SET_GEN_CONTEXT_STATEMENT__CONTEXT);
		createEAttribute(setGenContextStatementEClass, SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT);

		resetGenContextStatementEClass = createEClass(RESET_GEN_CONTEXT_STATEMENT);

		saveGenStatementEClass = createEClass(SAVE_GEN_STATEMENT);
		createEReference(saveGenStatementEClass, SAVE_GEN_STATEMENT__VARIABLE);

		resumeGenStatementEClass = createEClass(RESUME_GEN_STATEMENT);
		createEReference(resumeGenStatementEClass, RESUME_GEN_STATEMENT__VARIABLE);

		fixedMappingPartEClass = createEClass(FIXED_MAPPING_PART);
		createEAttribute(fixedMappingPartEClass, FIXED_MAPPING_PART__CODE);

		dynamicMappingPartEClass = createEClass(DYNAMIC_MAPPING_PART);
		createEReference(dynamicMappingPartEClass, DYNAMIC_MAPPING_PART__EXPR);

		expandExpressionEClass = createEClass(EXPAND_EXPRESSION);
		createEReference(expandExpressionEClass, EXPAND_EXPRESSION__META_OBJECT);

		expandStatementEClass = createEClass(EXPAND_STATEMENT);
		createEReference(expandStatementEClass, EXPAND_STATEMENT__META_OBJECT);
		createEReference(expandStatementEClass, EXPAND_STATEMENT__LOCATION);

		expandSectionEClass = createEClass(EXPAND_SECTION);
		createEReference(expandSectionEClass, EXPAND_SECTION__CODE_BLOCK);

		codeQuoteExpressionEClass = createEClass(CODE_QUOTE_EXPRESSION);
		createEReference(codeQuoteExpressionEClass, CODE_QUOTE_EXPRESSION__QUOTED_CODE);

		quotedCodeEClass = createEClass(QUOTED_CODE);

		quotedExpressionEClass = createEClass(QUOTED_EXPRESSION);
		createEReference(quotedExpressionEClass, QUOTED_EXPRESSION__EXPRESSION);

		quotedStatementsEClass = createEClass(QUOTED_STATEMENTS);
		createEReference(quotedStatementsEClass, QUOTED_STATEMENTS__STATEMENTS);

		quotedClassContentEClass = createEClass(QUOTED_CLASS_CONTENT);

		quotedModuleContentEClass = createEClass(QUOTED_MODULE_CONTENT);

		expandableElementEClass = createEClass(EXPANDABLE_ELEMENT);
		createEReference(expandableElementEClass, EXPANDABLE_ELEMENT__EXPAND_EXPRESSION);

		testStatementEClass = createEClass(TEST_STATEMENT);
		createEAttribute(testStatementEClass, TEST_STATEMENT__VALUE);

		idResolutionEClass = createEClass(ID_RESOLUTION);
		createEAttribute(idResolutionEClass, ID_RESOLUTION__META_MODEL_PLATFORM_URI);
		createEReference(idResolutionEClass, ID_RESOLUTION__PATTERNS);

		patternEClass = createEClass(PATTERN);
		createEAttribute(patternEClass, PATTERN__TOP);
		createEReference(patternEClass, PATTERN__CONTEXT);
		createEReference(patternEClass, PATTERN__CODE_BLOCK);

		potentiallyHiddenIdElementsEClass = createEClass(POTENTIALLY_HIDDEN_ID_ELEMENTS);
		createEReference(potentiallyHiddenIdElementsEClass, POTENTIALLY_HIDDEN_ID_ELEMENTS__CODE_BLOCK);

		findContainerEClass = createEClass(FIND_CONTAINER);
		createEReference(findContainerEClass, FIND_CONTAINER__VARIABLE_BINDING);
		createEReference(findContainerEClass, FIND_CONTAINER__CONTAINER_BLOCK);
		createEReference(findContainerEClass, FIND_CONTAINER__ELSE_BLOCK);

		considerIdElementsEClass = createEClass(CONSIDER_ID_ELEMENTS);
		createEReference(considerIdElementsEClass, CONSIDER_ID_ELEMENTS__ELEMENTS_QUERY);

		includePatternEClass = createEClass(INCLUDE_PATTERN);
		createEReference(includePatternEClass, INCLUDE_PATTERN__PATTERN);
		createEReference(includePatternEClass, INCLUDE_PATTERN__CONTEXT);

		// Create enums
		bindingExprOpKindEEnum = createEEnum(BINDING_EXPR_OP_KIND);
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
		constructEClass.getESuperTypes().add(this.getNamedExtension());
		moduleEClass.getESuperTypes().add(this.getNamedElement());
		moduleEClass.getESuperTypes().add(this.getEmbeddableExtensionsContainer());
		primitiveTypeEClass.getESuperTypes().add(this.getType());
		voidTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		intTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		boolTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		doubleTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		stringTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		procedureEClass.getESuperTypes().add(this.getNamedElement());
		procedureEClass.getESuperTypes().add(this.getTypedElement());
		procedureEClass.getESuperTypes().add(this.getCodeBlock());
		procedureEClass.getESuperTypes().add(this.getAnnotatableElement());
		simpleAnnotationEClass.getESuperTypes().add(this.getNamedElement());
		annotationEClass.getESuperTypes().add(this.getNamedElement());
		classifierEClass.getESuperTypes().add(this.getType());
		classifierEClass.getESuperTypes().add(this.getNamedElement());
		classifierEClass.getESuperTypes().add(this.getReferableRhsType());
		classSimilarEClass.getESuperTypes().add(this.getEmbeddableExtensionsContainer());
		classSimilarEClass.getESuperTypes().add(this.getModifierExtensionsContainer());
		startCodeBlockEClass.getESuperTypes().add(this.getCodeBlock());
		clazzEClass.getESuperTypes().add(this.getClassifier());
		clazzEClass.getESuperTypes().add(this.getClassSimilar());
		classAugmentEClass.getESuperTypes().add(this.getClassSimilar());
		interfaceEClass.getESuperTypes().add(this.getClassifier());
		abstractVariableEClass.getESuperTypes().add(this.getNamedElement());
		abstractVariableEClass.getESuperTypes().add(this.getTypedElement());
		variableEClass.getESuperTypes().add(this.getAbstractVariable());
		variableEClass.getESuperTypes().add(this.getStatement());
		variableEClass.getESuperTypes().add(this.getModifierExtensionsContainer());
		parameterEClass.getESuperTypes().add(this.getAbstractVariable());
		namedElementEClass.getESuperTypes().add(this.getExpandableElement());
		codeBlockEClass.getESuperTypes().add(this.getConstruct());
		statementEClass.getESuperTypes().add(this.getConstruct());
		compositeStatementEClass.getESuperTypes().add(this.getStatement());
		simpleStatementEClass.getESuperTypes().add(this.getStatement());
		expressionStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		assignmentEClass.getESuperTypes().add(this.getSimpleStatement());
		deprecatedProcedureCallStatementEClass.getESuperTypes().add(this.getExpressionStatement());
		procedureCallEClass.getESuperTypes().add(this.getStatementExpression());
		returnEClass.getESuperTypes().add(this.getSimpleStatement());
		waitUntilEClass.getESuperTypes().add(this.getSimpleStatement());
		terminateEClass.getESuperTypes().add(this.getSimpleStatement());
		waitEClass.getESuperTypes().add(this.getSimpleStatement());
		reactivateEClass.getESuperTypes().add(this.getSimpleStatement());
		activateObjectEClass.getESuperTypes().add(this.getSimpleStatement());
		advanceEClass.getESuperTypes().add(this.getSimpleStatement());
		printEClass.getESuperTypes().add(this.getSimpleStatement());
		setStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		removeFromSetEClass.getESuperTypes().add(this.getSetStatement());
		addToSetEClass.getESuperTypes().add(this.getSetStatement());
		emptySetEClass.getESuperTypes().add(this.getSetStatement());
		ifStatementEClass.getESuperTypes().add(this.getCompositeStatement());
		whileStatementEClass.getESuperTypes().add(this.getCompositeStatement());
		breakStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		continueStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		forEachStatementEClass.getESuperTypes().add(this.getCompositeStatement());
		expressionEClass.getESuperTypes().add(this.getConstruct());
		l1ExprEClass.getESuperTypes().add(this.getExpression());
		binaryOperatorEClass.getESuperTypes().add(this.getExpression());
		unaryOperatorEClass.getESuperTypes().add(this.getExpression());
		andEClass.getESuperTypes().add(this.getBinaryOperator());
		orEClass.getESuperTypes().add(this.getBinaryOperator());
		greaterEClass.getESuperTypes().add(this.getBinaryOperator());
		greaterEqualEClass.getESuperTypes().add(this.getBinaryOperator());
		lessEClass.getESuperTypes().add(this.getBinaryOperator());
		lessEqualEClass.getESuperTypes().add(this.getBinaryOperator());
		notEqualEClass.getESuperTypes().add(this.getBinaryOperator());
		equalEClass.getESuperTypes().add(this.getBinaryOperator());
		instanceOfEClass.getESuperTypes().add(this.getBinaryOperator());
		plusEClass.getESuperTypes().add(this.getBinaryOperator());
		minusEClass.getESuperTypes().add(this.getBinaryOperator());
		mulEClass.getESuperTypes().add(this.getBinaryOperator());
		modEClass.getESuperTypes().add(this.getBinaryOperator());
		divEClass.getESuperTypes().add(this.getBinaryOperator());
		negEClass.getESuperTypes().add(this.getUnaryOperator());
		notEClass.getESuperTypes().add(this.getUnaryOperator());
		castEClass.getESuperTypes().add(this.getUnaryOperator());
		castEClass.getESuperTypes().add(this.getTypedElement());
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
		evalExprEClass.getESuperTypes().add(this.getExpression());
		meLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		superLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		metaLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		typeLiteralEClass.getESuperTypes().add(this.getPredefinedId());
		setOpEClass.getESuperTypes().add(this.getPredefinedId());
		sizeOfSetEClass.getESuperTypes().add(this.getSetOp());
		firstInSetEClass.getESuperTypes().add(this.getSetOp());
		lastInSetEClass.getESuperTypes().add(this.getSetOp());
		containsEClass.getESuperTypes().add(this.getSetOp());
		indexOfEClass.getESuperTypes().add(this.getSetOp());
		objectAtEClass.getESuperTypes().add(this.getSetOp());
		beforeInSetEClass.getESuperTypes().add(this.getSetOp());
		afterInSetEClass.getESuperTypes().add(this.getSetOp());
		idExprEClass.getESuperTypes().add(this.getL1Expr());
		elementAccessEClass.getESuperTypes().add(this.getExpression());
		variableAccessEClass.getESuperTypes().add(this.getElementAccess());
		variableAccessEClass.getESuperTypes().add(this.getExpandableElement());
		metaAccessEClass.getESuperTypes().add(this.getVariableAccess());
		typeAccessEClass.getESuperTypes().add(this.getElementAccess());
		typeAccessEClass.getESuperTypes().add(this.getExpandableElement());
		namedExtensionEClass.getESuperTypes().add(this.getExtension());
		namedExtensionEClass.getESuperTypes().add(this.getNamedElement());
		classContentExtensionEClass.getESuperTypes().add(this.getNamedExtension());
		moduleContentExtensionEClass.getESuperTypes().add(this.getNamedExtension());
		extensionDefinitionEClass.getESuperTypes().add(this.getNamedElement());
		referableRhsTypeEClass.getESuperTypes().add(this.getNamedElement());
		tsRuleEClass.getESuperTypes().add(this.getNamedElement());
		tsRuleEClass.getESuperTypes().add(this.getReferableRhsType());
		extensionRuleEClass.getESuperTypes().add(this.getNamedElement());
		sequenceExprEClass.getESuperTypes().add(this.getRhsExpression());
		optionalExprEClass.getESuperTypes().add(this.getRhsExpression());
		runtimeExprEClass.getESuperTypes().add(this.getRhsExpression());
		atLeastOneExprEClass.getESuperTypes().add(this.getRhsExpression());
		arbitraryExprEClass.getESuperTypes().add(this.getRhsExpression());
		alternativeExprEClass.getESuperTypes().add(this.getRhsExpression());
		terminalExprEClass.getESuperTypes().add(this.getRhsExpression());
		propertyBindingExprEClass.getESuperTypes().add(this.getNamedElement());
		propertyBindingExprEClass.getESuperTypes().add(this.getRhsExpression());
		ruleExprEClass.getESuperTypes().add(this.getRhsExpression());
		idPropertyTypeEClass.getESuperTypes().add(this.getPropertyType());
		intPropertyTypeEClass.getESuperTypes().add(this.getPropertyType());
		stringPropertyTypeEClass.getESuperTypes().add(this.getPropertyType());
		booleanPropertyTypeEClass.getESuperTypes().add(this.getPropertyType());
		structuredPropertyTypeEClass.getESuperTypes().add(this.getPropertyType());
		compositePropertyTypeEClass.getESuperTypes().add(this.getStructuredPropertyType());
		referencePropertyTypeEClass.getESuperTypes().add(this.getStructuredPropertyType());
		mappingEClass.getESuperTypes().add(this.getCodeBlock());
		metaExprEClass.getESuperTypes().add(this.getExpression());
		targetStatementEClass.getESuperTypes().add(this.getStatement());
		mappingStatementEClass.getESuperTypes().add(this.getStatement());
		setGenContextStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		resetGenContextStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		saveGenStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		resumeGenStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		fixedMappingPartEClass.getESuperTypes().add(this.getMappingPart());
		dynamicMappingPartEClass.getESuperTypes().add(this.getMappingPart());
		expandExpressionEClass.getESuperTypes().add(this.getStatementExpression());
		expandExpressionEClass.getESuperTypes().add(this.getExpression());
		expandStatementEClass.getESuperTypes().add(this.getStatement());
		expandSectionEClass.getESuperTypes().add(this.getCompositeStatement());
		codeQuoteExpressionEClass.getESuperTypes().add(this.getExpression());
		quotedExpressionEClass.getESuperTypes().add(this.getQuotedCode());
		quotedStatementsEClass.getESuperTypes().add(this.getQuotedCode());
		quotedClassContentEClass.getESuperTypes().add(this.getQuotedCode());
		quotedClassContentEClass.getESuperTypes().add(this.getClassSimilar());
		quotedModuleContentEClass.getESuperTypes().add(this.getQuotedCode());
		quotedModuleContentEClass.getESuperTypes().add(this.getModule());
		testStatementEClass.getESuperTypes().add(this.getStatement());
		patternEClass.getESuperTypes().add(this.getNamedElement());
		potentiallyHiddenIdElementsEClass.getESuperTypes().add(this.getStatement());
		findContainerEClass.getESuperTypes().add(this.getStatement());
		considerIdElementsEClass.getESuperTypes().add(this.getStatement());
		includePatternEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(constructEClass, Construct.class, "Construct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstruct_ConcreteSyntax(), ecorePackage.getEString(), "concreteSyntax", null, 0, 1, Construct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Imports(), this.getImport(), null, "imports", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Modules(), this.getModule(), null, "modules", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_File(), ecorePackage.getEString(), "file", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImport_Model(), this.getModel(), null, "model", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_Classifiers(), this.getClassifier(), null, "classifiers", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_ClassAugments(), this.getClassAugment(), null, "classAugments", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_ExtensionDefs(), this.getExtensionDefinition(), null, "extensionDefs", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_AnnotationDefs(), this.getAnnotation(), null, "annotationDefs", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Procedures(), this.getProcedure(), null, "procedures", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Variables(), this.getVariable(), null, "variables", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_IdRes(), this.getIdResolution(), null, "idRes", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(embeddableExtensionsContainerEClass, EmbeddableExtensionsContainer.class, "EmbeddableExtensionsContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEmbeddableExtensionsContainer_Extensions(), this.getExtension(), null, "extensions", null, 0, -1, EmbeddableExtensionsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifierExtensionsContainerEClass, ModifierExtensionsContainer.class, "ModifierExtensionsContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifierExtensionsContainer_ModifierExtensions(), this.getExtension(), null, "modifierExtensions", null, 0, -1, ModifierExtensionsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_PrimitiveType(), this.getPrimitiveType(), null, "primitiveType", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTypedElement_IsList(), ecorePackage.getEBoolean(), "isList", "false", 1, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTypedElement_ClassifierTypeExpr(), this.getIdExpr(), null, "classifierTypeExpr", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intTypeEClass, IntType.class, "IntType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boolTypeEClass, BoolType.class, "BoolType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doubleTypeEClass, DoubleType.class, "DoubleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(procedureEClass, Procedure.class, "Procedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcedure_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcedure_Clazz(), ecorePackage.getEBoolean(), "clazz", "false", 1, 1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simpleAnnotationEClass, SimpleAnnotation.class, "SimpleAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleAnnotation_Value(), ecorePackage.getEString(), "value", null, 1, 1, SimpleAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Keys(), this.getVariable(), null, "keys", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationApplicationEClass, AnnotationApplication.class, "AnnotationApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationApplication_AnnotationDef(), this.getAnnotation(), null, "annotationDef", null, 1, 1, AnnotationApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAnnotationApplication_KeyValuePairs(), this.getKeyValuePair(), null, "keyValuePairs", null, 0, -1, AnnotationApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyValuePairEClass, KeyValuePair.class, "KeyValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyValuePair_Key(), this.getVariableAccess(), null, "key", null, 1, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getKeyValuePair_Value(), this.getExpression(), null, "value", null, 1, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(annotatableElementEClass, AnnotatableElement.class, "AnnotatableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotatableElement_AnnotationApplications(), this.getAnnotationApplication(), null, "annotationApplications", null, 0, -1, AnnotatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotatableElement_SimpleAnnotations(), this.getSimpleAnnotation(), null, "simpleAnnotations", null, 0, -1, AnnotatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifier_Bindings(), this.getNativeBinding(), null, "bindings", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nativeBindingEClass, NativeBinding.class, "NativeBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNativeBinding_TargetLanguage(), ecorePackage.getEString(), "targetLanguage", null, 1, 1, NativeBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNativeBinding_TargetType(), ecorePackage.getEString(), "targetType", null, 1, 1, NativeBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classSimilarEClass, ClassSimilar.class, "ClassSimilar", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassSimilar_Attributes(), this.getVariable(), null, "attributes", null, 0, -1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassSimilar_Methods(), this.getProcedure(), null, "methods", null, 0, -1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassSimilar_SuperClass(), this.getClazz(), null, "superClass", null, 0, 1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassSimilar_ImplementedInterfaces(), this.getInterface(), null, "implementedInterfaces", null, 0, -1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassSimilar_InitialBlock(), this.getStartCodeBlock(), null, "initialBlock", null, 0, 1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassSimilar_FinalBlock(), this.getStartCodeBlock(), null, "finalBlock", null, 0, 1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassSimilar_ActionsBlock(), this.getStartCodeBlock(), null, "actionsBlock", null, 0, 1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassSimilar_ReportBlock(), this.getStartCodeBlock(), null, "reportBlock", null, 0, 1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassSimilar_ClearBlock(), this.getStartCodeBlock(), null, "clearBlock", null, 0, 1, ClassSimilar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(startCodeBlockEClass, StartCodeBlock.class, "StartCodeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clazzEClass, Clazz.class, "Clazz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClazz_Active(), ecorePackage.getEBoolean(), "active", "false", 1, 1, Clazz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClazz_Constructor(), this.getConstructor(), null, "constructor", null, 0, 1, Clazz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClazz_BaseConstructorArguments(), this.getExpression(), null, "baseConstructorArguments", null, 0, -1, Clazz.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constructorEClass, Constructor.class, "Constructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstructor_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Constructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classAugmentEClass, ClassAugment.class, "ClassAugment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassAugment_AugmentedClass(), this.getClazz(), null, "augmentedClass", null, 1, 1, ClassAugment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_Methods(), this.getProcedure(), null, "methods", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_SuperInterfaces(), this.getInterface(), null, "superInterfaces", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractVariableEClass, AbstractVariable.class, "AbstractVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Control(), ecorePackage.getEBoolean(), "control", "false", 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_Clazz(), ecorePackage.getEBoolean(), "clazz", "false", 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_InitialValue(), this.getExpression(), null, "initialValue", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeBlockEClass, CodeBlock.class, "CodeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1, CodeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeStatementEClass, CompositeStatement.class, "CompositeStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleStatementEClass, SimpleStatement.class, "SimpleStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionStatement_Expression(), this.getStatementExpression(), null, "expression", null, 1, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(statementExpressionEClass, StatementExpression.class, "StatementExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Variable(), this.getVariableAccess(), null, "variable", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssignment_Value(), this.getExpression(), null, "value", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(deprecatedProcedureCallStatementEClass, DeprecatedProcedureCallStatement.class, "DeprecatedProcedureCallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeprecatedProcedureCallStatement_ProcedureCall(), this.getExpression(), null, "procedureCall", null, 1, 1, DeprecatedProcedureCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(procedureCallEClass, ProcedureCall.class, "ProcedureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcedureCall_ProcedureAccess(), this.getExpression(), null, "procedureAccess", null, 1, 1, ProcedureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(returnEClass, Return.class, "Return", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturn_Value(), this.getExpression(), null, "value", null, 1, 1, Return.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitUntilEClass, WaitUntil.class, "WaitUntil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWaitUntil_Condition(), this.getExpression(), null, "condition", null, 1, 1, WaitUntil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(terminateEClass, Terminate.class, "Terminate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(waitEClass, Wait.class, "Wait", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reactivateEClass, Reactivate.class, "Reactivate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReactivate_ObjectAccess(), this.getExpression(), null, "objectAccess", null, 1, 1, Reactivate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(activateObjectEClass, ActivateObject.class, "ActivateObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivateObject_ObjectAccess(), this.getExpression(), null, "objectAccess", null, 1, 1, ActivateObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActivateObject_Priority(), ecorePackage.getEInt(), "priority", "0", 1, 1, ActivateObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(advanceEClass, Advance.class, "Advance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdvance_Time(), this.getExpression(), null, "time", null, 1, 1, Advance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(printEClass, Print.class, "Print", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrint_Outputs(), this.getExpression(), null, "outputs", null, 0, -1, Print.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setStatementEClass, SetStatement.class, "SetStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetStatement_Object(), this.getExpression(), null, "object", null, 1, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSetStatement_Set(), this.getExpression(), null, "set", null, 1, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(removeFromSetEClass, RemoveFromSet.class, "RemoveFromSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addToSetEClass, AddToSet.class, "AddToSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddToSet_AtIndex(), this.getExpression(), null, "atIndex", null, 0, 1, AddToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(emptySetEClass, EmptySet.class, "EmptySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIfStatement_IfCaseBlock(), this.getCodeBlock(), null, "ifCaseBlock", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIfStatement_ElifCondition(), this.getExpression(), null, "elifCondition", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ElifCaseBlock(), this.getCodeBlock(), null, "elifCaseBlock", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ElseCaseBlock(), this.getCodeBlock(), null, "elseCaseBlock", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 1, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWhileStatement_WhileBlock(), this.getCodeBlock(), null, "whileBlock", null, 1, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forEachStatementEClass, ForEachStatement.class, "ForEachStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForEachStatement_IteratorVariableDefinition(), this.getVariable(), null, "iteratorVariableDefinition", null, 0, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForEachStatement_IteratorVariableReference(), this.getVariableAccess(), null, "iteratorVariableReference", null, 0, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForEachStatement_IterableExpression(), this.getExpression(), null, "iterableExpression", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForEachStatement_ForBlock(), this.getCodeBlock(), null, "forBlock", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l1ExprEClass, L1Expr.class, "L1Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryOperatorEClass, BinaryOperator.class, "BinaryOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryOperator_Op1(), this.getExpression(), null, "op1", null, 1, 1, BinaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBinaryOperator_Op2(), this.getExpression(), null, "op2", null, 1, 1, BinaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(unaryOperatorEClass, UnaryOperator.class, "UnaryOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryOperator_Op(), this.getExpression(), null, "op", null, 1, 1, UnaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterEClass, Greater.class, "Greater", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterEqualEClass, GreaterEqual.class, "GreaterEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessEClass, Less.class, "Less", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessEqualEClass, LessEqual.class, "LessEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEqualEClass, NotEqual.class, "NotEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalEClass, Equal.class, "Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intLiteralEClass, IntLiteral.class, "IntLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntLiteral_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(trueLiteralEClass, TrueLiteral.class, "TrueLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseLiteralEClass, FalseLiteral.class, "FalseLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleLiteral_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(evalExprEClass, EvalExpr.class, "EvalExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvalExpr_Expr(), this.getExpression(), null, "expr", null, 1, 1, EvalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(meLiteralEClass, MeLiteral.class, "MeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(superLiteralEClass, SuperLiteral.class, "SuperLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaLiteralEClass, MetaLiteral.class, "MetaLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeLiteralEClass, TypeLiteral.class, "TypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setOpEClass, SetOp.class, "SetOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetOp_Set(), this.getExpression(), null, "set", null, 0, 1, SetOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sizeOfSetEClass, SizeOfSet.class, "SizeOfSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(firstInSetEClass, FirstInSet.class, "FirstInSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lastInSetEClass, LastInSet.class, "LastInSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containsEClass, Contains.class, "Contains", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(indexOfEClass, IndexOf.class, "IndexOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectAtEClass, ObjectAt.class, "ObjectAt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beforeInSetEClass, BeforeInSet.class, "BeforeInSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(afterInSetEClass, AfterInSet.class, "AfterInSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(depIdentifiableElementEClass, DepIdentifiableElement.class, "DepIdentifiableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(predefinedIdEClass, PredefinedId.class, "PredefinedId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(idExprEClass, IdExpr.class, "IdExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdExpr_ParentIdExpr(), this.getIdExpr(), null, "parentIdExpr", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIdExpr_ReferencedElement(), this.getNamedElement(), null, "referencedElement", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIdExpr_PredefinedId(), this.getPredefinedId(), null, "predefinedId", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIdExpr_Arguments(), this.getArgumentExpression(), null, "arguments", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(argumentExpressionEClass, ArgumentExpression.class, "ArgumentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArgumentExpression_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, ArgumentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementAccessEClass, ElementAccess.class, "ElementAccess", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementAccess_IdExpr(), this.getIdExpr(), null, "idExpr", null, 0, 1, ElementAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableAccessEClass, VariableAccess.class, "VariableAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaAccessEClass, MetaAccess.class, "MetaAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeAccessEClass, TypeAccess.class, "TypeAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(extensionEClass, Extension.class, "Extension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedExtensionEClass, NamedExtension.class, "NamedExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classContentExtensionEClass, ClassContentExtension.class, "ClassContentExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleContentExtensionEClass, ModuleContentExtension.class, "ModuleContentExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(extensionDefinitionEClass, ExtensionDefinition.class, "ExtensionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionDefinition_AbstractSyntaxDef(), this.getClassifier(), null, "abstractSyntaxDef", null, 0, -1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionDefinition_TextualSyntaxDef(), this.getTextualSyntaxDef(), null, "textualSyntaxDef", null, 1, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtensionDefinition_MappingDef(), this.getMapping(), null, "mappingDef", null, 0, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textualSyntaxDefEClass, TextualSyntaxDef.class, "TextualSyntaxDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextualSyntaxDef_ExtensionRule(), this.getExtensionRule(), null, "extensionRule", null, 1, 1, TextualSyntaxDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTextualSyntaxDef_NewRules(), this.getTsRule(), null, "newRules", null, 0, -1, TextualSyntaxDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referableRhsTypeEClass, ReferableRhsType.class, "ReferableRhsType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tsRuleEClass, TsRule.class, "TsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTsRule_MetaClassName(), ecorePackage.getEString(), "metaClassName", null, 0, 1, TsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTsRule_Rhs(), this.getRhsExpression(), null, "rhs", null, 1, 1, TsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extensionRuleEClass, ExtensionRule.class, "ExtensionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionRule_InstantiableMetaClass(), this.getClassifier(), null, "instantiableMetaClass", null, 0, 1, ExtensionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionRule_FirstNewRule(), this.getRuleExpr(), null, "firstNewRule", null, 1, 1, ExtensionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rhsExpressionEClass, RhsExpression.class, "RhsExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(rhsExpressionEClass, this.getRhsExpression(), "getSubExpressions", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(sequenceExprEClass, SequenceExpr.class, "SequenceExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceExpr_Sequence(), this.getRhsExpression(), null, "sequence", null, 0, -1, SequenceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionalExprEClass, OptionalExpr.class, "OptionalExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptionalExpr_Expression(), this.getRhsExpression(), null, "expression", null, 1, 1, OptionalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(runtimeExprEClass, RuntimeExpr.class, "RuntimeExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuntimeExpr_Expression(), this.getRhsExpression(), null, "expression", null, 1, 1, RuntimeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(atLeastOneExprEClass, AtLeastOneExpr.class, "AtLeastOneExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAtLeastOneExpr_Expression(), this.getRhsExpression(), null, "expression", null, 1, 1, AtLeastOneExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(arbitraryExprEClass, ArbitraryExpr.class, "ArbitraryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArbitraryExpr_Expression(), this.getRhsExpression(), null, "expression", null, 1, 1, ArbitraryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(alternativeExprEClass, AlternativeExpr.class, "AlternativeExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternativeExpr_Left(), this.getRhsExpression(), null, "left", null, 1, 1, AlternativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAlternativeExpr_Right(), this.getRhsExpression(), null, "right", null, 1, 1, AlternativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(terminalExprEClass, TerminalExpr.class, "TerminalExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminalExpr_Terminal(), ecorePackage.getEString(), "terminal", null, 1, 1, TerminalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyBindingExprEClass, PropertyBindingExpr.class, "PropertyBindingExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyBindingExpr_PropertyType(), this.getPropertyType(), null, "propertyType", null, 1, 1, PropertyBindingExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropertyBindingExpr_Operator(), this.getBindingExprOpKind(), "operator", null, 1, 1, PropertyBindingExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ruleExprEClass, RuleExpr.class, "RuleExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleExpr_Rule(), this.getTsRule(), null, "rule", null, 1, 1, RuleExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyTypeEClass, PropertyType.class, "PropertyType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(idPropertyTypeEClass, IdPropertyType.class, "IdPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intPropertyTypeEClass, IntPropertyType.class, "IntPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringPropertyTypeEClass, StringPropertyType.class, "StringPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanPropertyTypeEClass, BooleanPropertyType.class, "BooleanPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanPropertyType_Terminal(), ecorePackage.getEString(), "terminal", null, 1, 1, BooleanPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(structuredPropertyTypeEClass, StructuredPropertyType.class, "StructuredPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredPropertyType_Type(), this.getReferableRhsType(), null, "type", null, 1, 1, StructuredPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositePropertyTypeEClass, CompositePropertyType.class, "CompositePropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositePropertyType_List(), ecorePackage.getEBoolean(), "list", "false", 1, 1, CompositePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(referencePropertyTypeEClass, ReferencePropertyType.class, "ReferencePropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferencePropertyType_IdResolutionPattern(), this.getPattern(), null, "idResolutionPattern", null, 0, 1, ReferencePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReferencePropertyType_RawReference(), ecorePackage.getEBoolean(), "rawReference", "false", 1, 1, ReferencePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Parts(), this.getMappingPart(), null, "parts", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_MetaObject(), this.getExpression(), null, "metaObject", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mappingPartEClass, MappingPart.class, "MappingPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metaExprEClass, MetaExpr.class, "MetaExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaExpr_Expr(), this.getExpression(), null, "expr", null, 1, 1, MetaExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(targetStatementEClass, TargetStatement.class, "TargetStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetStatement_CodeBlock(), this.getCodeBlock(), null, "codeBlock", null, 1, 1, TargetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mappingStatementEClass, MappingStatement.class, "MappingStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingStatement_Parts(), this.getMappingPart(), null, "parts", null, 0, -1, MappingStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatement_Exprs(), this.getExpression(), null, "exprs", null, 0, -1, MappingStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setGenContextStatementEClass, SetGenContextStatement.class, "SetGenContextStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetGenContextStatement_Context(), this.getExpression(), null, "context", null, 1, 1, SetGenContextStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSetGenContextStatement_AddAfterContext(), ecorePackage.getEBoolean(), "addAfterContext", "false", 1, 1, SetGenContextStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resetGenContextStatementEClass, ResetGenContextStatement.class, "ResetGenContextStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(saveGenStatementEClass, SaveGenStatement.class, "SaveGenStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSaveGenStatement_Variable(), this.getExpression(), null, "variable", null, 1, 1, SaveGenStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resumeGenStatementEClass, ResumeGenStatement.class, "ResumeGenStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResumeGenStatement_Variable(), this.getExpression(), null, "variable", null, 1, 1, ResumeGenStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedMappingPartEClass, FixedMappingPart.class, "FixedMappingPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedMappingPart_Code(), ecorePackage.getEString(), "code", null, 1, 1, FixedMappingPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dynamicMappingPartEClass, DynamicMappingPart.class, "DynamicMappingPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDynamicMappingPart_Expr(), this.getExpression(), null, "expr", null, 1, 1, DynamicMappingPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expandExpressionEClass, ExpandExpression.class, "ExpandExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandExpression_MetaObject(), this.getExpression(), null, "metaObject", null, 1, 1, ExpandExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expandStatementEClass, ExpandStatement.class, "ExpandStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandStatement_MetaObject(), this.getExpression(), null, "metaObject", null, 1, 1, ExpandStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExpandStatement_Location(), this.getExpression(), null, "location", null, 0, 1, ExpandStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expandSectionEClass, ExpandSection.class, "ExpandSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandSection_CodeBlock(), this.getCodeBlock(), null, "codeBlock", null, 0, 1, ExpandSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(codeQuoteExpressionEClass, CodeQuoteExpression.class, "CodeQuoteExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeQuoteExpression_QuotedCode(), this.getQuotedCode(), null, "quotedCode", null, 1, 1, CodeQuoteExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quotedCodeEClass, QuotedCode.class, "QuotedCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedExpressionEClass, QuotedExpression.class, "QuotedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuotedExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, QuotedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quotedStatementsEClass, QuotedStatements.class, "QuotedStatements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuotedStatements_Statements(), this.getStatement(), null, "statements", null, 0, -1, QuotedStatements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quotedClassContentEClass, QuotedClassContent.class, "QuotedClassContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(quotedModuleContentEClass, QuotedModuleContent.class, "QuotedModuleContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expandableElementEClass, ExpandableElement.class, "ExpandableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandableElement_ExpandExpression(), this.getExpandExpression(), null, "expandExpression", null, 0, 1, ExpandableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(testStatementEClass, TestStatement.class, "TestStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestStatement_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, TestStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(idResolutionEClass, IdResolution.class, "IdResolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdResolution_MetaModelPlatformURI(), ecorePackage.getEString(), "metaModelPlatformURI", null, 1, 1, IdResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIdResolution_Patterns(), this.getPattern(), null, "patterns", null, 0, -1, IdResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPattern_Top(), ecorePackage.getEBoolean(), "top", "false", 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPattern_Context(), this.getParameter(), null, "context", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPattern_CodeBlock(), this.getCodeBlock(), null, "codeBlock", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(potentiallyHiddenIdElementsEClass, PotentiallyHiddenIdElements.class, "PotentiallyHiddenIdElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPotentiallyHiddenIdElements_CodeBlock(), this.getCodeBlock(), null, "codeBlock", null, 1, 1, PotentiallyHiddenIdElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(findContainerEClass, FindContainer.class, "FindContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFindContainer_VariableBinding(), this.getParameter(), null, "variableBinding", null, 1, 1, FindContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFindContainer_ContainerBlock(), this.getCodeBlock(), null, "containerBlock", null, 1, 1, FindContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFindContainer_ElseBlock(), this.getCodeBlock(), null, "elseBlock", null, 0, 1, FindContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(considerIdElementsEClass, ConsiderIdElements.class, "ConsiderIdElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsiderIdElements_ElementsQuery(), this.getExpression(), null, "elementsQuery", null, 1, 1, ConsiderIdElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(includePatternEClass, IncludePattern.class, "IncludePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIncludePattern_Pattern(), this.getPattern(), null, "pattern", null, 1, 1, IncludePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIncludePattern_Context(), this.getExpression(), null, "context", null, 1, 1, IncludePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(bindingExprOpKindEEnum, BindingExprOpKind.class, "BindingExprOpKind");
		addEEnumLiteral(bindingExprOpKindEEnum, BindingExprOpKind.ASSIGN);
		addEEnumLiteral(bindingExprOpKindEEnum, BindingExprOpKind.ADD);
		addEEnumLiteral(bindingExprOpKindEEnum, BindingExprOpKind.BOOL);

		// Create resource
		createResource(eNS_URI);
	}

} //DblPackageImpl
