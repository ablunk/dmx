/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl.util;

import hub.sam.dbl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see hub.sam.dbl.DblPackage
 * @generated
 */
public class DblSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DblPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DblSwitch() {
		if (modelPackage == null) {
			modelPackage = DblPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DblPackage.EXTENSIBLE_ELEMENT: {
				ExtensibleElement extensibleElement = (ExtensibleElement)theEObject;
				T result = caseExtensibleElement(extensibleElement);
				if (result == null) result = caseNamedElement(extensibleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MODULE: {
				Module module = (Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = caseNamedElement(module);
				if (result == null) result = caseEmbeddableExtensionsContainer(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EMBEDDABLE_EXTENSIONS_CONTAINER: {
				EmbeddableExtensionsContainer embeddableExtensionsContainer = (EmbeddableExtensionsContainer)theEObject;
				T result = caseEmbeddableExtensionsContainer(embeddableExtensionsContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MODIFIER_EXTENSIONS_CONTAINER: {
				ModifierExtensionsContainer modifierExtensionsContainer = (ModifierExtensionsContainer)theEObject;
				T result = caseModifierExtensionsContainer(modifierExtensionsContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TYPED_ELEMENT: {
				TypedElement typedElement = (TypedElement)theEObject;
				T result = caseTypedElement(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ARRAY_DIMENSION: {
				ArrayDimension arrayDimension = (ArrayDimension)theEObject;
				T result = caseArrayDimension(arrayDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.VOID_TYPE: {
				VoidType voidType = (VoidType)theEObject;
				T result = caseVoidType(voidType);
				if (result == null) result = casePrimitiveType(voidType);
				if (result == null) result = caseType(voidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INT_TYPE: {
				IntType intType = (IntType)theEObject;
				T result = caseIntType(intType);
				if (result == null) result = casePrimitiveType(intType);
				if (result == null) result = caseType(intType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BOOL_TYPE: {
				BoolType boolType = (BoolType)theEObject;
				T result = caseBoolType(boolType);
				if (result == null) result = casePrimitiveType(boolType);
				if (result == null) result = caseType(boolType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DOUBLE_TYPE: {
				DoubleType doubleType = (DoubleType)theEObject;
				T result = caseDoubleType(doubleType);
				if (result == null) result = casePrimitiveType(doubleType);
				if (result == null) result = caseType(doubleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = casePrimitiveType(stringType);
				if (result == null) result = caseType(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PROCEDURE: {
				Procedure procedure = (Procedure)theEObject;
				T result = caseProcedure(procedure);
				if (result == null) result = caseNamedElement(procedure);
				if (result == null) result = caseTypedElement(procedure);
				if (result == null) result = caseLocalScope(procedure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASSIFIER: {
				Classifier classifier = (Classifier)theEObject;
				T result = caseClassifier(classifier);
				if (result == null) result = caseType(classifier);
				if (result == null) result = caseReferableRhsType(classifier);
				if (result == null) result = caseNamedElement(classifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NATIVE_BINDING: {
				NativeBinding nativeBinding = (NativeBinding)theEObject;
				T result = caseNativeBinding(nativeBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASS_SIMILAR: {
				ClassSimilar classSimilar = (ClassSimilar)theEObject;
				T result = caseClassSimilar(classSimilar);
				if (result == null) result = caseEmbeddableExtensionsContainer(classSimilar);
				if (result == null) result = caseModifierExtensionsContainer(classSimilar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASS_PART: {
				ClassPart classPart = (ClassPart)theEObject;
				T result = caseClassPart(classPart);
				if (result == null) result = caseLocalScope(classPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SUPER_CLASS_SPECIFICATION: {
				SuperClassSpecification superClassSpecification = (SuperClassSpecification)theEObject;
				T result = caseSuperClassSpecification(superClassSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLAZZ: {
				Clazz clazz = (Clazz)theEObject;
				T result = caseClazz(clazz);
				if (result == null) result = caseClassifier(clazz);
				if (result == null) result = caseClassSimilar(clazz);
				if (result == null) result = caseType(clazz);
				if (result == null) result = caseReferableRhsType(clazz);
				if (result == null) result = caseEmbeddableExtensionsContainer(clazz);
				if (result == null) result = caseModifierExtensionsContainer(clazz);
				if (result == null) result = caseNamedElement(clazz);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CONSTRUCTOR: {
				Constructor constructor = (Constructor)theEObject;
				T result = caseConstructor(constructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASS_AUGMENT: {
				ClassAugment classAugment = (ClassAugment)theEObject;
				T result = caseClassAugment(classAugment);
				if (result == null) result = caseClassSimilar(classAugment);
				if (result == null) result = caseEmbeddableExtensionsContainer(classAugment);
				if (result == null) result = caseModifierExtensionsContainer(classAugment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ABSTRACT_VARIABLE: {
				AbstractVariable abstractVariable = (AbstractVariable)theEObject;
				T result = caseAbstractVariable(abstractVariable);
				if (result == null) result = caseNamedElement(abstractVariable);
				if (result == null) result = caseTypedElement(abstractVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseAbstractVariable(variable);
				if (result == null) result = caseStatement(variable);
				if (result == null) result = caseModifierExtensionsContainer(variable);
				if (result == null) result = caseTypedElement(variable);
				if (result == null) result = caseExtensibleElement(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseAbstractVariable(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DEPRECATED_CODE_BLOCK: {
				deprecated_CodeBlock deprecated_CodeBlock = (deprecated_CodeBlock)theEObject;
				T result = casedeprecated_CodeBlock(deprecated_CodeBlock);
				if (result == null) result = caseExtensibleElement(deprecated_CodeBlock);
				if (result == null) result = caseNamedElement(deprecated_CodeBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseExtensibleElement(statement);
				if (result == null) result = caseNamedElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LOOP_STATEMENT: {
				LoopStatement loopStatement = (LoopStatement)theEObject;
				T result = caseLoopStatement(loopStatement);
				if (result == null) result = caseStatement(loopStatement);
				if (result == null) result = caseExtensibleElement(loopStatement);
				if (result == null) result = caseNamedElement(loopStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SIMPLE_STATEMENT: {
				SimpleStatement simpleStatement = (SimpleStatement)theEObject;
				T result = caseSimpleStatement(simpleStatement);
				if (result == null) result = caseStatement(simpleStatement);
				if (result == null) result = caseExtensibleElement(simpleStatement);
				if (result == null) result = caseNamedElement(simpleStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseSimpleStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = caseExtensibleElement(expressionStatement);
				if (result == null) result = caseNamedElement(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STATEMENT_EXPRESSION: {
				StatementExpression statementExpression = (StatementExpression)theEObject;
				T result = caseStatementExpression(statementExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseSimpleStatement(assignment);
				if (result == null) result = caseStatement(assignment);
				if (result == null) result = caseExtensibleElement(assignment);
				if (result == null) result = caseNamedElement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PROCEDURE_CALL: {
				ProcedureCall procedureCall = (ProcedureCall)theEObject;
				T result = caseProcedureCall(procedureCall);
				if (result == null) result = caseStatementExpression(procedureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RETURN: {
				Return return_ = (Return)theEObject;
				T result = caseReturn(return_);
				if (result == null) result = caseSimpleStatement(return_);
				if (result == null) result = caseStatement(return_);
				if (result == null) result = caseExtensibleElement(return_);
				if (result == null) result = caseNamedElement(return_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.WAIT_UNTIL: {
				WaitUntil waitUntil = (WaitUntil)theEObject;
				T result = caseWaitUntil(waitUntil);
				if (result == null) result = caseSimpleStatement(waitUntil);
				if (result == null) result = caseStatement(waitUntil);
				if (result == null) result = caseExtensibleElement(waitUntil);
				if (result == null) result = caseNamedElement(waitUntil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TERMINATE: {
				Terminate terminate = (Terminate)theEObject;
				T result = caseTerminate(terminate);
				if (result == null) result = caseSimpleStatement(terminate);
				if (result == null) result = caseStatement(terminate);
				if (result == null) result = caseExtensibleElement(terminate);
				if (result == null) result = caseNamedElement(terminate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.YIELD: {
				Yield yield = (Yield)theEObject;
				T result = caseYield(yield);
				if (result == null) result = caseSimpleStatement(yield);
				if (result == null) result = caseStatement(yield);
				if (result == null) result = caseExtensibleElement(yield);
				if (result == null) result = caseNamedElement(yield);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.WAIT: {
				Wait wait = (Wait)theEObject;
				T result = caseWait(wait);
				if (result == null) result = caseSimpleStatement(wait);
				if (result == null) result = caseStatement(wait);
				if (result == null) result = caseExtensibleElement(wait);
				if (result == null) result = caseNamedElement(wait);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.REACTIVATE: {
				Reactivate reactivate = (Reactivate)theEObject;
				T result = caseReactivate(reactivate);
				if (result == null) result = caseSimpleStatement(reactivate);
				if (result == null) result = caseStatement(reactivate);
				if (result == null) result = caseExtensibleElement(reactivate);
				if (result == null) result = caseNamedElement(reactivate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ACTIVATE_OBJECT: {
				ActivateObject activateObject = (ActivateObject)theEObject;
				T result = caseActivateObject(activateObject);
				if (result == null) result = caseSimpleStatement(activateObject);
				if (result == null) result = caseStatement(activateObject);
				if (result == null) result = caseExtensibleElement(activateObject);
				if (result == null) result = caseNamedElement(activateObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ADVANCE: {
				Advance advance = (Advance)theEObject;
				T result = caseAdvance(advance);
				if (result == null) result = caseSimpleStatement(advance);
				if (result == null) result = caseStatement(advance);
				if (result == null) result = caseExtensibleElement(advance);
				if (result == null) result = caseNamedElement(advance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PRINT: {
				Print print = (Print)theEObject;
				T result = casePrint(print);
				if (result == null) result = caseSimpleStatement(print);
				if (result == null) result = caseStatement(print);
				if (result == null) result = caseExtensibleElement(print);
				if (result == null) result = caseNamedElement(print);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = caseExtensibleElement(ifStatement);
				if (result == null) result = caseNamedElement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LOCAL_SCOPE: {
				LocalScope localScope = (LocalScope)theEObject;
				T result = caseLocalScope(localScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LOCAL_SCOPE_STATEMENT: {
				LocalScopeStatement localScopeStatement = (LocalScopeStatement)theEObject;
				T result = caseLocalScopeStatement(localScopeStatement);
				if (result == null) result = caseSimpleStatement(localScopeStatement);
				if (result == null) result = caseLocalScope(localScopeStatement);
				if (result == null) result = caseStatement(localScopeStatement);
				if (result == null) result = caseExtensibleElement(localScopeStatement);
				if (result == null) result = caseNamedElement(localScopeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseLoopStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = caseExtensibleElement(forStatement);
				if (result == null) result = caseNamedElement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseLoopStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = caseExtensibleElement(whileStatement);
				if (result == null) result = caseNamedElement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseSimpleStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = caseExtensibleElement(switchStatement);
				if (result == null) result = caseNamedElement(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SWITCH_CASE: {
				SwitchCase switchCase = (SwitchCase)theEObject;
				T result = caseSwitchCase(switchCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseSimpleStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = caseExtensibleElement(breakStatement);
				if (result == null) result = caseNamedElement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CONTINUE_STATEMENT: {
				ContinueStatement continueStatement = (ContinueStatement)theEObject;
				T result = caseContinueStatement(continueStatement);
				if (result == null) result = caseSimpleStatement(continueStatement);
				if (result == null) result = caseStatement(continueStatement);
				if (result == null) result = caseExtensibleElement(continueStatement);
				if (result == null) result = caseNamedElement(continueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseTypedElement(expression);
				if (result == null) result = caseExtensibleElement(expression);
				if (result == null) result = caseNamedElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.L1_EXPR: {
				L1Expr l1Expr = (L1Expr)theEObject;
				T result = caseL1Expr(l1Expr);
				if (result == null) result = caseExpression(l1Expr);
				if (result == null) result = caseTypedElement(l1Expr);
				if (result == null) result = caseExtensibleElement(l1Expr);
				if (result == null) result = caseNamedElement(l1Expr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BINARY_OPERATOR: {
				BinaryOperator binaryOperator = (BinaryOperator)theEObject;
				T result = caseBinaryOperator(binaryOperator);
				if (result == null) result = caseExpression(binaryOperator);
				if (result == null) result = caseTypedElement(binaryOperator);
				if (result == null) result = caseExtensibleElement(binaryOperator);
				if (result == null) result = caseNamedElement(binaryOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.UNARY_OPERATOR: {
				UnaryOperator unaryOperator = (UnaryOperator)theEObject;
				T result = caseUnaryOperator(unaryOperator);
				if (result == null) result = caseExpression(unaryOperator);
				if (result == null) result = caseTypedElement(unaryOperator);
				if (result == null) result = caseExtensibleElement(unaryOperator);
				if (result == null) result = caseNamedElement(unaryOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseBinaryOperator(and);
				if (result == null) result = caseExpression(and);
				if (result == null) result = caseTypedElement(and);
				if (result == null) result = caseExtensibleElement(and);
				if (result == null) result = caseNamedElement(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseBinaryOperator(or);
				if (result == null) result = caseExpression(or);
				if (result == null) result = caseTypedElement(or);
				if (result == null) result = caseExtensibleElement(or);
				if (result == null) result = caseNamedElement(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.GREATER: {
				Greater greater = (Greater)theEObject;
				T result = caseGreater(greater);
				if (result == null) result = caseBinaryOperator(greater);
				if (result == null) result = caseExpression(greater);
				if (result == null) result = caseTypedElement(greater);
				if (result == null) result = caseExtensibleElement(greater);
				if (result == null) result = caseNamedElement(greater);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.GREATER_EQUAL: {
				GreaterEqual greaterEqual = (GreaterEqual)theEObject;
				T result = caseGreaterEqual(greaterEqual);
				if (result == null) result = caseBinaryOperator(greaterEqual);
				if (result == null) result = caseExpression(greaterEqual);
				if (result == null) result = caseTypedElement(greaterEqual);
				if (result == null) result = caseExtensibleElement(greaterEqual);
				if (result == null) result = caseNamedElement(greaterEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LESS: {
				Less less = (Less)theEObject;
				T result = caseLess(less);
				if (result == null) result = caseBinaryOperator(less);
				if (result == null) result = caseExpression(less);
				if (result == null) result = caseTypedElement(less);
				if (result == null) result = caseExtensibleElement(less);
				if (result == null) result = caseNamedElement(less);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LESS_EQUAL: {
				LessEqual lessEqual = (LessEqual)theEObject;
				T result = caseLessEqual(lessEqual);
				if (result == null) result = caseBinaryOperator(lessEqual);
				if (result == null) result = caseExpression(lessEqual);
				if (result == null) result = caseTypedElement(lessEqual);
				if (result == null) result = caseExtensibleElement(lessEqual);
				if (result == null) result = caseNamedElement(lessEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NOT_EQUAL: {
				NotEqual notEqual = (NotEqual)theEObject;
				T result = caseNotEqual(notEqual);
				if (result == null) result = caseBinaryOperator(notEqual);
				if (result == null) result = caseExpression(notEqual);
				if (result == null) result = caseTypedElement(notEqual);
				if (result == null) result = caseExtensibleElement(notEqual);
				if (result == null) result = caseNamedElement(notEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EQUAL: {
				Equal equal = (Equal)theEObject;
				T result = caseEqual(equal);
				if (result == null) result = caseBinaryOperator(equal);
				if (result == null) result = caseExpression(equal);
				if (result == null) result = caseTypedElement(equal);
				if (result == null) result = caseExtensibleElement(equal);
				if (result == null) result = caseNamedElement(equal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INSTANCE_OF: {
				InstanceOf instanceOf = (InstanceOf)theEObject;
				T result = caseInstanceOf(instanceOf);
				if (result == null) result = caseBinaryOperator(instanceOf);
				if (result == null) result = caseExpression(instanceOf);
				if (result == null) result = caseTypedElement(instanceOf);
				if (result == null) result = caseExtensibleElement(instanceOf);
				if (result == null) result = caseNamedElement(instanceOf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PLUS: {
				Plus plus = (Plus)theEObject;
				T result = casePlus(plus);
				if (result == null) result = caseBinaryOperator(plus);
				if (result == null) result = caseExpression(plus);
				if (result == null) result = caseTypedElement(plus);
				if (result == null) result = caseExtensibleElement(plus);
				if (result == null) result = caseNamedElement(plus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MINUS: {
				Minus minus = (Minus)theEObject;
				T result = caseMinus(minus);
				if (result == null) result = caseBinaryOperator(minus);
				if (result == null) result = caseExpression(minus);
				if (result == null) result = caseTypedElement(minus);
				if (result == null) result = caseExtensibleElement(minus);
				if (result == null) result = caseNamedElement(minus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MUL: {
				Mul mul = (Mul)theEObject;
				T result = caseMul(mul);
				if (result == null) result = caseBinaryOperator(mul);
				if (result == null) result = caseExpression(mul);
				if (result == null) result = caseTypedElement(mul);
				if (result == null) result = caseExtensibleElement(mul);
				if (result == null) result = caseNamedElement(mul);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MOD: {
				Mod mod = (Mod)theEObject;
				T result = caseMod(mod);
				if (result == null) result = caseBinaryOperator(mod);
				if (result == null) result = caseExpression(mod);
				if (result == null) result = caseTypedElement(mod);
				if (result == null) result = caseExtensibleElement(mod);
				if (result == null) result = caseNamedElement(mod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DIV: {
				Div div = (Div)theEObject;
				T result = caseDiv(div);
				if (result == null) result = caseBinaryOperator(div);
				if (result == null) result = caseExpression(div);
				if (result == null) result = caseTypedElement(div);
				if (result == null) result = caseExtensibleElement(div);
				if (result == null) result = caseNamedElement(div);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NEG: {
				Neg neg = (Neg)theEObject;
				T result = caseNeg(neg);
				if (result == null) result = caseUnaryOperator(neg);
				if (result == null) result = caseExpression(neg);
				if (result == null) result = caseTypedElement(neg);
				if (result == null) result = caseExtensibleElement(neg);
				if (result == null) result = caseNamedElement(neg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseUnaryOperator(not);
				if (result == null) result = caseExpression(not);
				if (result == null) result = caseTypedElement(not);
				if (result == null) result = caseExtensibleElement(not);
				if (result == null) result = caseNamedElement(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CAST: {
				Cast cast = (Cast)theEObject;
				T result = caseCast(cast);
				if (result == null) result = caseUnaryOperator(cast);
				if (result == null) result = caseExpression(cast);
				if (result == null) result = caseTypedElement(cast);
				if (result == null) result = caseExtensibleElement(cast);
				if (result == null) result = caseNamedElement(cast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CREATE_OBJECT: {
				CreateObject createObject = (CreateObject)theEObject;
				T result = caseCreateObject(createObject);
				if (result == null) result = caseL1Expr(createObject);
				if (result == null) result = caseExpression(createObject);
				if (result == null) result = caseTypedElement(createObject);
				if (result == null) result = caseExtensibleElement(createObject);
				if (result == null) result = caseNamedElement(createObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NULL_LITERAL: {
				NullLiteral nullLiteral = (NullLiteral)theEObject;
				T result = caseNullLiteral(nullLiteral);
				if (result == null) result = caseL1Expr(nullLiteral);
				if (result == null) result = caseExpression(nullLiteral);
				if (result == null) result = caseTypedElement(nullLiteral);
				if (result == null) result = caseExtensibleElement(nullLiteral);
				if (result == null) result = caseNamedElement(nullLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TIME_LITERAL: {
				TimeLiteral timeLiteral = (TimeLiteral)theEObject;
				T result = caseTimeLiteral(timeLiteral);
				if (result == null) result = caseL1Expr(timeLiteral);
				if (result == null) result = caseExpression(timeLiteral);
				if (result == null) result = caseTypedElement(timeLiteral);
				if (result == null) result = caseExtensibleElement(timeLiteral);
				if (result == null) result = caseNamedElement(timeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ACTIVE_LITERAL: {
				ActiveLiteral activeLiteral = (ActiveLiteral)theEObject;
				T result = caseActiveLiteral(activeLiteral);
				if (result == null) result = caseL1Expr(activeLiteral);
				if (result == null) result = caseExpression(activeLiteral);
				if (result == null) result = caseTypedElement(activeLiteral);
				if (result == null) result = caseExtensibleElement(activeLiteral);
				if (result == null) result = caseNamedElement(activeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseL1Expr(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = caseTypedElement(stringLiteral);
				if (result == null) result = caseExtensibleElement(stringLiteral);
				if (result == null) result = caseNamedElement(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INT_LITERAL: {
				IntLiteral intLiteral = (IntLiteral)theEObject;
				T result = caseIntLiteral(intLiteral);
				if (result == null) result = caseL1Expr(intLiteral);
				if (result == null) result = caseExpression(intLiteral);
				if (result == null) result = caseTypedElement(intLiteral);
				if (result == null) result = caseExtensibleElement(intLiteral);
				if (result == null) result = caseNamedElement(intLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TRUE_LITERAL: {
				TrueLiteral trueLiteral = (TrueLiteral)theEObject;
				T result = caseTrueLiteral(trueLiteral);
				if (result == null) result = caseL1Expr(trueLiteral);
				if (result == null) result = caseExpression(trueLiteral);
				if (result == null) result = caseTypedElement(trueLiteral);
				if (result == null) result = caseExtensibleElement(trueLiteral);
				if (result == null) result = caseNamedElement(trueLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FALSE_LITERAL: {
				FalseLiteral falseLiteral = (FalseLiteral)theEObject;
				T result = caseFalseLiteral(falseLiteral);
				if (result == null) result = caseL1Expr(falseLiteral);
				if (result == null) result = caseExpression(falseLiteral);
				if (result == null) result = caseTypedElement(falseLiteral);
				if (result == null) result = caseExtensibleElement(falseLiteral);
				if (result == null) result = caseNamedElement(falseLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DOUBLE_LITERAL: {
				DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
				T result = caseDoubleLiteral(doubleLiteral);
				if (result == null) result = caseL1Expr(doubleLiteral);
				if (result == null) result = caseExpression(doubleLiteral);
				if (result == null) result = caseTypedElement(doubleLiteral);
				if (result == null) result = caseExtensibleElement(doubleLiteral);
				if (result == null) result = caseNamedElement(doubleLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EVAL_EXPR: {
				EvalExpr evalExpr = (EvalExpr)theEObject;
				T result = caseEvalExpr(evalExpr);
				if (result == null) result = caseExpression(evalExpr);
				if (result == null) result = caseTypedElement(evalExpr);
				if (result == null) result = caseExtensibleElement(evalExpr);
				if (result == null) result = caseNamedElement(evalExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PREDEFINED_ID: {
				PredefinedId predefinedId = (PredefinedId)theEObject;
				T result = casePredefinedId(predefinedId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ME_LITERAL: {
				MeLiteral meLiteral = (MeLiteral)theEObject;
				T result = caseMeLiteral(meLiteral);
				if (result == null) result = casePredefinedId(meLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SUPER_LITERAL: {
				SuperLiteral superLiteral = (SuperLiteral)theEObject;
				T result = caseSuperLiteral(superLiteral);
				if (result == null) result = casePredefinedId(superLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.META_LITERAL: {
				MetaLiteral metaLiteral = (MetaLiteral)theEObject;
				T result = caseMetaLiteral(metaLiteral);
				if (result == null) result = casePredefinedId(metaLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TYPE_LITERAL: {
				TypeLiteral typeLiteral = (TypeLiteral)theEObject;
				T result = caseTypeLiteral(typeLiteral);
				if (result == null) result = casePredefinedId(typeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SIZE_OF_ARRAY: {
				SizeOfArray sizeOfArray = (SizeOfArray)theEObject;
				T result = caseSizeOfArray(sizeOfArray);
				if (result == null) result = casePredefinedId(sizeOfArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ID_EXPR: {
				IdExpr idExpr = (IdExpr)theEObject;
				T result = caseIdExpr(idExpr);
				if (result == null) result = caseL1Expr(idExpr);
				if (result == null) result = caseExpression(idExpr);
				if (result == null) result = caseTypedElement(idExpr);
				if (result == null) result = caseExtensibleElement(idExpr);
				if (result == null) result = caseNamedElement(idExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ELEMENT_ACCESS: {
				ElementAccess elementAccess = (ElementAccess)theEObject;
				T result = caseElementAccess(elementAccess);
				if (result == null) result = caseExpression(elementAccess);
				if (result == null) result = caseTypedElement(elementAccess);
				if (result == null) result = caseExtensibleElement(elementAccess);
				if (result == null) result = caseNamedElement(elementAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.VARIABLE_ACCESS: {
				VariableAccess variableAccess = (VariableAccess)theEObject;
				T result = caseVariableAccess(variableAccess);
				if (result == null) result = caseElementAccess(variableAccess);
				if (result == null) result = caseExpression(variableAccess);
				if (result == null) result = caseTypedElement(variableAccess);
				if (result == null) result = caseExtensibleElement(variableAccess);
				if (result == null) result = caseNamedElement(variableAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.META_ACCESS: {
				MetaAccess metaAccess = (MetaAccess)theEObject;
				T result = caseMetaAccess(metaAccess);
				if (result == null) result = caseVariableAccess(metaAccess);
				if (result == null) result = caseElementAccess(metaAccess);
				if (result == null) result = caseExpression(metaAccess);
				if (result == null) result = caseTypedElement(metaAccess);
				if (result == null) result = caseExtensibleElement(metaAccess);
				if (result == null) result = caseNamedElement(metaAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TYPE_ACCESS: {
				TypeAccess typeAccess = (TypeAccess)theEObject;
				T result = caseTypeAccess(typeAccess);
				if (result == null) result = caseElementAccess(typeAccess);
				if (result == null) result = caseExpression(typeAccess);
				if (result == null) result = caseTypedElement(typeAccess);
				if (result == null) result = caseExtensibleElement(typeAccess);
				if (result == null) result = caseNamedElement(typeAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASS_CONTENT_EXTENSION: {
				ClassContentExtension classContentExtension = (ClassContentExtension)theEObject;
				T result = caseClassContentExtension(classContentExtension);
				if (result == null) result = caseExtensibleElement(classContentExtension);
				if (result == null) result = caseNamedElement(classContentExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MODULE_CONTENT_EXTENSION: {
				ModuleContentExtension moduleContentExtension = (ModuleContentExtension)theEObject;
				T result = caseModuleContentExtension(moduleContentExtension);
				if (result == null) result = caseExtensibleElement(moduleContentExtension);
				if (result == null) result = caseNamedElement(moduleContentExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXTENSION_DEFINITION: {
				ExtensionDefinition extensionDefinition = (ExtensionDefinition)theEObject;
				T result = caseExtensionDefinition(extensionDefinition);
				if (result == null) result = caseNamedElement(extensionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TEXTUAL_SYNTAX_DEF: {
				TextualSyntaxDef textualSyntaxDef = (TextualSyntaxDef)theEObject;
				T result = caseTextualSyntaxDef(textualSyntaxDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.REFERABLE_RHS_TYPE: {
				ReferableRhsType referableRhsType = (ReferableRhsType)theEObject;
				T result = caseReferableRhsType(referableRhsType);
				if (result == null) result = caseNamedElement(referableRhsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TS_RULE: {
				TsRule tsRule = (TsRule)theEObject;
				T result = caseTsRule(tsRule);
				if (result == null) result = caseReferableRhsType(tsRule);
				if (result == null) result = caseNamedElement(tsRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXTENSION_RULE: {
				ExtensionRule extensionRule = (ExtensionRule)theEObject;
				T result = caseExtensionRule(extensionRule);
				if (result == null) result = caseNamedElement(extensionRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RHS_EXPRESSION: {
				RhsExpression rhsExpression = (RhsExpression)theEObject;
				T result = caseRhsExpression(rhsExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SEQUENCE_EXPR: {
				SequenceExpr sequenceExpr = (SequenceExpr)theEObject;
				T result = caseSequenceExpr(sequenceExpr);
				if (result == null) result = caseRhsExpression(sequenceExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.OPTIONAL_EXPR: {
				OptionalExpr optionalExpr = (OptionalExpr)theEObject;
				T result = caseOptionalExpr(optionalExpr);
				if (result == null) result = caseRhsExpression(optionalExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RUNTIME_EXPR: {
				RuntimeExpr runtimeExpr = (RuntimeExpr)theEObject;
				T result = caseRuntimeExpr(runtimeExpr);
				if (result == null) result = caseRhsExpression(runtimeExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.AT_LEAST_ONE_EXPR: {
				AtLeastOneExpr atLeastOneExpr = (AtLeastOneExpr)theEObject;
				T result = caseAtLeastOneExpr(atLeastOneExpr);
				if (result == null) result = caseRhsExpression(atLeastOneExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ARBITRARY_EXPR: {
				ArbitraryExpr arbitraryExpr = (ArbitraryExpr)theEObject;
				T result = caseArbitraryExpr(arbitraryExpr);
				if (result == null) result = caseRhsExpression(arbitraryExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ALTERNATIVE_EXPR: {
				AlternativeExpr alternativeExpr = (AlternativeExpr)theEObject;
				T result = caseAlternativeExpr(alternativeExpr);
				if (result == null) result = caseRhsExpression(alternativeExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TERMINAL_EXPR: {
				TerminalExpr terminalExpr = (TerminalExpr)theEObject;
				T result = caseTerminalExpr(terminalExpr);
				if (result == null) result = caseRhsExpression(terminalExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PROPERTY_BINDING_EXPR: {
				PropertyBindingExpr propertyBindingExpr = (PropertyBindingExpr)theEObject;
				T result = casePropertyBindingExpr(propertyBindingExpr);
				if (result == null) result = caseNamedElement(propertyBindingExpr);
				if (result == null) result = caseRhsExpression(propertyBindingExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RULE_EXPR: {
				RuleExpr ruleExpr = (RuleExpr)theEObject;
				T result = caseRuleExpr(ruleExpr);
				if (result == null) result = caseRhsExpression(ruleExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PROPERTY_TYPE: {
				PropertyType propertyType = (PropertyType)theEObject;
				T result = casePropertyType(propertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ID_PROPERTY_TYPE: {
				IdPropertyType idPropertyType = (IdPropertyType)theEObject;
				T result = caseIdPropertyType(idPropertyType);
				if (result == null) result = casePropertyType(idPropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INT_PROPERTY_TYPE: {
				IntPropertyType intPropertyType = (IntPropertyType)theEObject;
				T result = caseIntPropertyType(intPropertyType);
				if (result == null) result = casePropertyType(intPropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STRING_PROPERTY_TYPE: {
				StringPropertyType stringPropertyType = (StringPropertyType)theEObject;
				T result = caseStringPropertyType(stringPropertyType);
				if (result == null) result = casePropertyType(stringPropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BOOLEAN_PROPERTY_TYPE: {
				BooleanPropertyType booleanPropertyType = (BooleanPropertyType)theEObject;
				T result = caseBooleanPropertyType(booleanPropertyType);
				if (result == null) result = casePropertyType(booleanPropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STRUCTURED_PROPERTY_TYPE: {
				StructuredPropertyType structuredPropertyType = (StructuredPropertyType)theEObject;
				T result = caseStructuredPropertyType(structuredPropertyType);
				if (result == null) result = casePropertyType(structuredPropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.COMPOSITE_PROPERTY_TYPE: {
				CompositePropertyType compositePropertyType = (CompositePropertyType)theEObject;
				T result = caseCompositePropertyType(compositePropertyType);
				if (result == null) result = caseStructuredPropertyType(compositePropertyType);
				if (result == null) result = casePropertyType(compositePropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.REFERENCE_PROPERTY_TYPE: {
				ReferencePropertyType referencePropertyType = (ReferencePropertyType)theEObject;
				T result = caseReferencePropertyType(referencePropertyType);
				if (result == null) result = caseStructuredPropertyType(referencePropertyType);
				if (result == null) result = casePropertyType(referencePropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseLocalScopeStatement(mapping);
				if (result == null) result = caseSimpleStatement(mapping);
				if (result == null) result = caseLocalScope(mapping);
				if (result == null) result = caseStatement(mapping);
				if (result == null) result = caseExtensibleElement(mapping);
				if (result == null) result = caseNamedElement(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MAPPING_PART: {
				MappingPart mappingPart = (MappingPart)theEObject;
				T result = caseMappingPart(mappingPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.META_EXPR: {
				MetaExpr metaExpr = (MetaExpr)theEObject;
				T result = caseMetaExpr(metaExpr);
				if (result == null) result = caseExpression(metaExpr);
				if (result == null) result = caseTypedElement(metaExpr);
				if (result == null) result = caseExtensibleElement(metaExpr);
				if (result == null) result = caseNamedElement(metaExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TARGET_STATEMENT: {
				TargetStatement targetStatement = (TargetStatement)theEObject;
				T result = caseTargetStatement(targetStatement);
				if (result == null) result = caseStatement(targetStatement);
				if (result == null) result = caseExtensibleElement(targetStatement);
				if (result == null) result = caseNamedElement(targetStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MAPPING_STATEMENT: {
				MappingStatement mappingStatement = (MappingStatement)theEObject;
				T result = caseMappingStatement(mappingStatement);
				if (result == null) result = caseStatement(mappingStatement);
				if (result == null) result = caseExtensibleElement(mappingStatement);
				if (result == null) result = caseNamedElement(mappingStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SET_GEN_CONTEXT_STATEMENT: {
				SetGenContextStatement setGenContextStatement = (SetGenContextStatement)theEObject;
				T result = caseSetGenContextStatement(setGenContextStatement);
				if (result == null) result = caseSimpleStatement(setGenContextStatement);
				if (result == null) result = caseStatement(setGenContextStatement);
				if (result == null) result = caseExtensibleElement(setGenContextStatement);
				if (result == null) result = caseNamedElement(setGenContextStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RESET_GEN_CONTEXT_STATEMENT: {
				ResetGenContextStatement resetGenContextStatement = (ResetGenContextStatement)theEObject;
				T result = caseResetGenContextStatement(resetGenContextStatement);
				if (result == null) result = caseSimpleStatement(resetGenContextStatement);
				if (result == null) result = caseStatement(resetGenContextStatement);
				if (result == null) result = caseExtensibleElement(resetGenContextStatement);
				if (result == null) result = caseNamedElement(resetGenContextStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SAVE_GEN_STATEMENT: {
				SaveGenStatement saveGenStatement = (SaveGenStatement)theEObject;
				T result = caseSaveGenStatement(saveGenStatement);
				if (result == null) result = caseSimpleStatement(saveGenStatement);
				if (result == null) result = caseStatement(saveGenStatement);
				if (result == null) result = caseExtensibleElement(saveGenStatement);
				if (result == null) result = caseNamedElement(saveGenStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RESUME_GEN_STATEMENT: {
				ResumeGenStatement resumeGenStatement = (ResumeGenStatement)theEObject;
				T result = caseResumeGenStatement(resumeGenStatement);
				if (result == null) result = caseSimpleStatement(resumeGenStatement);
				if (result == null) result = caseStatement(resumeGenStatement);
				if (result == null) result = caseExtensibleElement(resumeGenStatement);
				if (result == null) result = caseNamedElement(resumeGenStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FIXED_MAPPING_PART: {
				FixedMappingPart fixedMappingPart = (FixedMappingPart)theEObject;
				T result = caseFixedMappingPart(fixedMappingPart);
				if (result == null) result = caseMappingPart(fixedMappingPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DYNAMIC_MAPPING_PART: {
				DynamicMappingPart dynamicMappingPart = (DynamicMappingPart)theEObject;
				T result = caseDynamicMappingPart(dynamicMappingPart);
				if (result == null) result = caseMappingPart(dynamicMappingPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPAND_EXPRESSION: {
				ExpandExpression expandExpression = (ExpandExpression)theEObject;
				T result = caseExpandExpression(expandExpression);
				if (result == null) result = caseStatementExpression(expandExpression);
				if (result == null) result = caseExpression(expandExpression);
				if (result == null) result = caseTypedElement(expandExpression);
				if (result == null) result = caseExtensibleElement(expandExpression);
				if (result == null) result = caseNamedElement(expandExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPAND_STATEMENT: {
				ExpandStatement expandStatement = (ExpandStatement)theEObject;
				T result = caseExpandStatement(expandStatement);
				if (result == null) result = caseStatement(expandStatement);
				if (result == null) result = caseExtensibleElement(expandStatement);
				if (result == null) result = caseNamedElement(expandStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CODE_QUOTE_EXPRESSION: {
				CodeQuoteExpression codeQuoteExpression = (CodeQuoteExpression)theEObject;
				T result = caseCodeQuoteExpression(codeQuoteExpression);
				if (result == null) result = caseExpression(codeQuoteExpression);
				if (result == null) result = caseTypedElement(codeQuoteExpression);
				if (result == null) result = caseExtensibleElement(codeQuoteExpression);
				if (result == null) result = caseNamedElement(codeQuoteExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.QUOTED_CODE: {
				QuotedCode quotedCode = (QuotedCode)theEObject;
				T result = caseQuotedCode(quotedCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.QUOTED_EXPRESSION: {
				QuotedExpression quotedExpression = (QuotedExpression)theEObject;
				T result = caseQuotedExpression(quotedExpression);
				if (result == null) result = caseQuotedCode(quotedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.QUOTED_STATEMENTS: {
				QuotedStatements quotedStatements = (QuotedStatements)theEObject;
				T result = caseQuotedStatements(quotedStatements);
				if (result == null) result = caseQuotedCode(quotedStatements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.QUOTED_CLASS_CONTENT: {
				QuotedClassContent quotedClassContent = (QuotedClassContent)theEObject;
				T result = caseQuotedClassContent(quotedClassContent);
				if (result == null) result = caseQuotedCode(quotedClassContent);
				if (result == null) result = caseClassSimilar(quotedClassContent);
				if (result == null) result = caseEmbeddableExtensionsContainer(quotedClassContent);
				if (result == null) result = caseModifierExtensionsContainer(quotedClassContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.QUOTED_MODULE_CONTENT: {
				QuotedModuleContent quotedModuleContent = (QuotedModuleContent)theEObject;
				T result = caseQuotedModuleContent(quotedModuleContent);
				if (result == null) result = caseQuotedCode(quotedModuleContent);
				if (result == null) result = caseModule(quotedModuleContent);
				if (result == null) result = caseNamedElement(quotedModuleContent);
				if (result == null) result = caseEmbeddableExtensionsContainer(quotedModuleContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = caseNamedElement(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TEST_STATEMENT: {
				TestStatement testStatement = (TestStatement)theEObject;
				T result = caseTestStatement(testStatement);
				if (result == null) result = caseStatement(testStatement);
				if (result == null) result = caseExtensibleElement(testStatement);
				if (result == null) result = caseNamedElement(testStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Embeddable Extensions Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Embeddable Extensions Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmbeddableExtensionsContainer(EmbeddableExtensionsContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier Extensions Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier Extensions Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifierExtensionsContainer(ModifierExtensionsContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayDimension(ArrayDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntType(IntType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolType(BoolType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleType(DoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedure(Procedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Native Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Native Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNativeBinding(NativeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Similar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Similar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassSimilar(ClassSimilar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassPart(ClassPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Class Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Class Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperClassSpecification(SuperClassSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clazz</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clazz</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClazz(Clazz object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructor(Constructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Augment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Augment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassAugment(ClassAugment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractVariable(AbstractVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>deprecated Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>deprecated Code Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedeprecated_CodeBlock(deprecated_CodeBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopStatement(LoopStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleStatement(SimpleStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementExpression(StatementExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedure Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedure Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedureCall(ProcedureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturn(Return object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait Until</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait Until</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitUntil(WaitUntil object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminate(Terminate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Yield</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Yield</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseYield(Yield object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWait(Wait object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reactivate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reactivate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReactivate(Reactivate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activate Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activate Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivateObject(ActivateObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdvance(Advance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Print</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrint(Print object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalScope(LocalScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Scope Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Scope Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalScopeStatement(LocalScopeStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCase(SwitchCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueStatement(ContinueStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L1 Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L1 Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL1Expr(L1Expr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOperator(BinaryOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryOperator(UnaryOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlus(Plus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinus(Minus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mul</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mul</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMul(Mul object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mod</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mod</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMod(Mod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Div</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Div</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiv(Div object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Neg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Neg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNeg(Neg object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreater(Greater object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterEqual(GreaterEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLess(Less object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessEqual(LessEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotEqual(NotEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqual(Equal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Of</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Of</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceOf(InstanceOf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateObject(CreateObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCast(Cast object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteral(NullLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeLiteral(TimeLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Active Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Active Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActiveLiteral(ActiveLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eval Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eval Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvalExpr(EvalExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Me Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Me Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeLiteral(MeLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperLiteral(SuperLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaLiteral(MetaLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLiteral(TypeLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Size Of Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Size Of Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSizeOfArray(SizeOfArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntLiteral(IntLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueLiteral(TrueLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalseLiteral(FalseLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleLiteral(DoubleLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredefinedId(PredefinedId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdExpr(IdExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementAccess(ElementAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableAccess(VariableAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaAccess(MetaAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeAccess(TypeAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Content Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Content Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassContentExtension(ClassContentExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Content Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Content Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleContentExtension(ModuleContentExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionDefinition(ExtensionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Textual Syntax Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Textual Syntax Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextualSyntaxDef(TextualSyntaxDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referable Rhs Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referable Rhs Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferableRhsType(ReferableRhsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ts Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ts Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTsRule(TsRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionRule(ExtensionRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rhs Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rhs Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRhsExpression(RhsExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceExpr(SequenceExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optional Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optional Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptionalExpr(OptionalExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Runtime Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Runtime Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuntimeExpr(RuntimeExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>At Least One Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>At Least One Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtLeastOneExpr(AtLeastOneExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arbitrary Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arbitrary Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArbitraryExpr(ArbitraryExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternative Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternative Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternativeExpr(AlternativeExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminal Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminal Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminalExpr(TerminalExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Binding Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Binding Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyBindingExpr(PropertyBindingExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleExpr(RuleExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyType(PropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdPropertyType(IdPropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntPropertyType(IntPropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringPropertyType(StringPropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanPropertyType(BooleanPropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredPropertyType(StructuredPropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositePropertyType(CompositePropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencePropertyType(ReferencePropertyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingPart(MappingPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaExpr(MetaExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetStatement(TargetStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingStatement(MappingStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Gen Context Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Gen Context Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetGenContextStatement(SetGenContextStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reset Gen Context Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reset Gen Context Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResetGenContextStatement(ResetGenContextStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Save Gen Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Save Gen Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSaveGenStatement(SaveGenStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resume Gen Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resume Gen Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResumeGenStatement(ResumeGenStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Mapping Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Mapping Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedMappingPart(FixedMappingPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Mapping Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Mapping Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicMappingPart(DynamicMappingPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expand Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expand Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandExpression(ExpandExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expand Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expand Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandStatement(ExpandStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Quote Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Quote Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeQuoteExpression(CodeQuoteExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedCode(QuotedCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedExpression(QuotedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Statements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Statements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedStatements(QuotedStatements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Class Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Class Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedClassContent(QuotedClassContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quoted Module Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quoted Module Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuotedModuleContent(QuotedModuleContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestStatement(TestStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePattern(Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DblSwitch
