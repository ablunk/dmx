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
			case DblPackage.CONSTRUCT: {
				Construct construct = (Construct)theEObject;
				T result = caseConstruct(construct);
				if (result == null) result = caseNamedExtension(construct);
				if (result == null) result = caseExtension(construct);
				if (result == null) result = caseNamedElement(construct);
				if (result == null) result = caseExpandableElement(construct);
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
				if (result == null) result = caseExpandableElement(module);
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
				if (result == null) result = caseTypedElement(procedure);
				if (result == null) result = caseCodeBlock(procedure);
				if (result == null) result = caseAnnotatableElement(procedure);
				if (result == null) result = caseExpandableElement(procedure);
				if (result == null) result = caseConstruct(procedure);
				if (result == null) result = caseNamedExtension(procedure);
				if (result == null) result = caseNamedElement(procedure);
				if (result == null) result = caseExtension(procedure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SIMPLE_ANNOTATION: {
				SimpleAnnotation simpleAnnotation = (SimpleAnnotation)theEObject;
				T result = caseSimpleAnnotation(simpleAnnotation);
				if (result == null) result = caseNamedElement(simpleAnnotation);
				if (result == null) result = caseExpandableElement(simpleAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseNamedElement(annotation);
				if (result == null) result = caseExpandableElement(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ANNOTATION_APPLICATION: {
				AnnotationApplication annotationApplication = (AnnotationApplication)theEObject;
				T result = caseAnnotationApplication(annotationApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.KEY_VALUE_PAIR: {
				KeyValuePair keyValuePair = (KeyValuePair)theEObject;
				T result = caseKeyValuePair(keyValuePair);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ANNOTATABLE_ELEMENT: {
				AnnotatableElement annotatableElement = (AnnotatableElement)theEObject;
				T result = caseAnnotatableElement(annotatableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASSIFIER: {
				Classifier classifier = (Classifier)theEObject;
				T result = caseClassifier(classifier);
				if (result == null) result = caseType(classifier);
				if (result == null) result = caseReferableRhsType(classifier);
				if (result == null) result = caseNamedElement(classifier);
				if (result == null) result = caseExpandableElement(classifier);
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
			case DblPackage.START_CODE_BLOCK: {
				StartCodeBlock startCodeBlock = (StartCodeBlock)theEObject;
				T result = caseStartCodeBlock(startCodeBlock);
				if (result == null) result = caseCodeBlock(startCodeBlock);
				if (result == null) result = caseConstruct(startCodeBlock);
				if (result == null) result = caseNamedExtension(startCodeBlock);
				if (result == null) result = caseExtension(startCodeBlock);
				if (result == null) result = caseNamedElement(startCodeBlock);
				if (result == null) result = caseExpandableElement(startCodeBlock);
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
				if (result == null) result = caseExpandableElement(clazz);
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
			case DblPackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				T result = caseInterface(interface_);
				if (result == null) result = caseClassifier(interface_);
				if (result == null) result = caseType(interface_);
				if (result == null) result = caseReferableRhsType(interface_);
				if (result == null) result = caseNamedElement(interface_);
				if (result == null) result = caseExpandableElement(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ABSTRACT_VARIABLE: {
				AbstractVariable abstractVariable = (AbstractVariable)theEObject;
				T result = caseAbstractVariable(abstractVariable);
				if (result == null) result = caseNamedElement(abstractVariable);
				if (result == null) result = caseTypedElement(abstractVariable);
				if (result == null) result = caseExpandableElement(abstractVariable);
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
				if (result == null) result = caseConstruct(variable);
				if (result == null) result = caseExpandableElement(variable);
				if (result == null) result = caseNamedExtension(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseExtension(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseAbstractVariable(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = caseExpandableElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseExpandableElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CODE_BLOCK: {
				CodeBlock codeBlock = (CodeBlock)theEObject;
				T result = caseCodeBlock(codeBlock);
				if (result == null) result = caseConstruct(codeBlock);
				if (result == null) result = caseNamedExtension(codeBlock);
				if (result == null) result = caseExtension(codeBlock);
				if (result == null) result = caseNamedElement(codeBlock);
				if (result == null) result = caseExpandableElement(codeBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseConstruct(statement);
				if (result == null) result = caseNamedExtension(statement);
				if (result == null) result = caseExtension(statement);
				if (result == null) result = caseNamedElement(statement);
				if (result == null) result = caseExpandableElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.COMPOSITE_STATEMENT: {
				CompositeStatement compositeStatement = (CompositeStatement)theEObject;
				T result = caseCompositeStatement(compositeStatement);
				if (result == null) result = caseStatement(compositeStatement);
				if (result == null) result = caseConstruct(compositeStatement);
				if (result == null) result = caseNamedExtension(compositeStatement);
				if (result == null) result = caseExtension(compositeStatement);
				if (result == null) result = caseNamedElement(compositeStatement);
				if (result == null) result = caseExpandableElement(compositeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SIMPLE_STATEMENT: {
				SimpleStatement simpleStatement = (SimpleStatement)theEObject;
				T result = caseSimpleStatement(simpleStatement);
				if (result == null) result = caseStatement(simpleStatement);
				if (result == null) result = caseConstruct(simpleStatement);
				if (result == null) result = caseNamedExtension(simpleStatement);
				if (result == null) result = caseExtension(simpleStatement);
				if (result == null) result = caseNamedElement(simpleStatement);
				if (result == null) result = caseExpandableElement(simpleStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseSimpleStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = caseConstruct(expressionStatement);
				if (result == null) result = caseNamedExtension(expressionStatement);
				if (result == null) result = caseExtension(expressionStatement);
				if (result == null) result = caseNamedElement(expressionStatement);
				if (result == null) result = caseExpandableElement(expressionStatement);
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
				if (result == null) result = caseConstruct(assignment);
				if (result == null) result = caseNamedExtension(assignment);
				if (result == null) result = caseExtension(assignment);
				if (result == null) result = caseNamedElement(assignment);
				if (result == null) result = caseExpandableElement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DEPRECATED_PROCEDURE_CALL_STATEMENT: {
				DeprecatedProcedureCallStatement deprecatedProcedureCallStatement = (DeprecatedProcedureCallStatement)theEObject;
				T result = caseDeprecatedProcedureCallStatement(deprecatedProcedureCallStatement);
				if (result == null) result = caseExpressionStatement(deprecatedProcedureCallStatement);
				if (result == null) result = caseSimpleStatement(deprecatedProcedureCallStatement);
				if (result == null) result = caseStatement(deprecatedProcedureCallStatement);
				if (result == null) result = caseConstruct(deprecatedProcedureCallStatement);
				if (result == null) result = caseNamedExtension(deprecatedProcedureCallStatement);
				if (result == null) result = caseExtension(deprecatedProcedureCallStatement);
				if (result == null) result = caseNamedElement(deprecatedProcedureCallStatement);
				if (result == null) result = caseExpandableElement(deprecatedProcedureCallStatement);
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
				if (result == null) result = caseConstruct(return_);
				if (result == null) result = caseNamedExtension(return_);
				if (result == null) result = caseExtension(return_);
				if (result == null) result = caseNamedElement(return_);
				if (result == null) result = caseExpandableElement(return_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.WAIT_UNTIL: {
				WaitUntil waitUntil = (WaitUntil)theEObject;
				T result = caseWaitUntil(waitUntil);
				if (result == null) result = caseSimpleStatement(waitUntil);
				if (result == null) result = caseStatement(waitUntil);
				if (result == null) result = caseConstruct(waitUntil);
				if (result == null) result = caseNamedExtension(waitUntil);
				if (result == null) result = caseExtension(waitUntil);
				if (result == null) result = caseNamedElement(waitUntil);
				if (result == null) result = caseExpandableElement(waitUntil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TERMINATE: {
				Terminate terminate = (Terminate)theEObject;
				T result = caseTerminate(terminate);
				if (result == null) result = caseSimpleStatement(terminate);
				if (result == null) result = caseStatement(terminate);
				if (result == null) result = caseConstruct(terminate);
				if (result == null) result = caseNamedExtension(terminate);
				if (result == null) result = caseExtension(terminate);
				if (result == null) result = caseNamedElement(terminate);
				if (result == null) result = caseExpandableElement(terminate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.WAIT: {
				Wait wait = (Wait)theEObject;
				T result = caseWait(wait);
				if (result == null) result = caseSimpleStatement(wait);
				if (result == null) result = caseStatement(wait);
				if (result == null) result = caseConstruct(wait);
				if (result == null) result = caseNamedExtension(wait);
				if (result == null) result = caseExtension(wait);
				if (result == null) result = caseNamedElement(wait);
				if (result == null) result = caseExpandableElement(wait);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.REACTIVATE: {
				Reactivate reactivate = (Reactivate)theEObject;
				T result = caseReactivate(reactivate);
				if (result == null) result = caseSimpleStatement(reactivate);
				if (result == null) result = caseStatement(reactivate);
				if (result == null) result = caseConstruct(reactivate);
				if (result == null) result = caseNamedExtension(reactivate);
				if (result == null) result = caseExtension(reactivate);
				if (result == null) result = caseNamedElement(reactivate);
				if (result == null) result = caseExpandableElement(reactivate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ACTIVATE_OBJECT: {
				ActivateObject activateObject = (ActivateObject)theEObject;
				T result = caseActivateObject(activateObject);
				if (result == null) result = caseSimpleStatement(activateObject);
				if (result == null) result = caseStatement(activateObject);
				if (result == null) result = caseConstruct(activateObject);
				if (result == null) result = caseNamedExtension(activateObject);
				if (result == null) result = caseExtension(activateObject);
				if (result == null) result = caseNamedElement(activateObject);
				if (result == null) result = caseExpandableElement(activateObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ADVANCE: {
				Advance advance = (Advance)theEObject;
				T result = caseAdvance(advance);
				if (result == null) result = caseSimpleStatement(advance);
				if (result == null) result = caseStatement(advance);
				if (result == null) result = caseConstruct(advance);
				if (result == null) result = caseNamedExtension(advance);
				if (result == null) result = caseExtension(advance);
				if (result == null) result = caseNamedElement(advance);
				if (result == null) result = caseExpandableElement(advance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PRINT: {
				Print print = (Print)theEObject;
				T result = casePrint(print);
				if (result == null) result = caseSimpleStatement(print);
				if (result == null) result = caseStatement(print);
				if (result == null) result = caseConstruct(print);
				if (result == null) result = caseNamedExtension(print);
				if (result == null) result = caseExtension(print);
				if (result == null) result = caseNamedElement(print);
				if (result == null) result = caseExpandableElement(print);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SET_STATEMENT: {
				SetStatement setStatement = (SetStatement)theEObject;
				T result = caseSetStatement(setStatement);
				if (result == null) result = caseSimpleStatement(setStatement);
				if (result == null) result = caseStatement(setStatement);
				if (result == null) result = caseConstruct(setStatement);
				if (result == null) result = caseNamedExtension(setStatement);
				if (result == null) result = caseExtension(setStatement);
				if (result == null) result = caseNamedElement(setStatement);
				if (result == null) result = caseExpandableElement(setStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.REMOVE_FROM_SET: {
				RemoveFromSet removeFromSet = (RemoveFromSet)theEObject;
				T result = caseRemoveFromSet(removeFromSet);
				if (result == null) result = caseSetStatement(removeFromSet);
				if (result == null) result = caseSimpleStatement(removeFromSet);
				if (result == null) result = caseStatement(removeFromSet);
				if (result == null) result = caseConstruct(removeFromSet);
				if (result == null) result = caseNamedExtension(removeFromSet);
				if (result == null) result = caseExtension(removeFromSet);
				if (result == null) result = caseNamedElement(removeFromSet);
				if (result == null) result = caseExpandableElement(removeFromSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ADD_TO_SET: {
				AddToSet addToSet = (AddToSet)theEObject;
				T result = caseAddToSet(addToSet);
				if (result == null) result = caseSetStatement(addToSet);
				if (result == null) result = caseSimpleStatement(addToSet);
				if (result == null) result = caseStatement(addToSet);
				if (result == null) result = caseConstruct(addToSet);
				if (result == null) result = caseNamedExtension(addToSet);
				if (result == null) result = caseExtension(addToSet);
				if (result == null) result = caseNamedElement(addToSet);
				if (result == null) result = caseExpandableElement(addToSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EMPTY_SET: {
				EmptySet emptySet = (EmptySet)theEObject;
				T result = caseEmptySet(emptySet);
				if (result == null) result = caseSetStatement(emptySet);
				if (result == null) result = caseSimpleStatement(emptySet);
				if (result == null) result = caseStatement(emptySet);
				if (result == null) result = caseConstruct(emptySet);
				if (result == null) result = caseNamedExtension(emptySet);
				if (result == null) result = caseExtension(emptySet);
				if (result == null) result = caseNamedElement(emptySet);
				if (result == null) result = caseExpandableElement(emptySet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseCompositeStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = caseConstruct(ifStatement);
				if (result == null) result = caseNamedExtension(ifStatement);
				if (result == null) result = caseExtension(ifStatement);
				if (result == null) result = caseNamedElement(ifStatement);
				if (result == null) result = caseExpandableElement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseCompositeStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = caseConstruct(whileStatement);
				if (result == null) result = caseNamedExtension(whileStatement);
				if (result == null) result = caseExtension(whileStatement);
				if (result == null) result = caseNamedElement(whileStatement);
				if (result == null) result = caseExpandableElement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseSimpleStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = caseConstruct(breakStatement);
				if (result == null) result = caseNamedExtension(breakStatement);
				if (result == null) result = caseExtension(breakStatement);
				if (result == null) result = caseNamedElement(breakStatement);
				if (result == null) result = caseExpandableElement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CONTINUE_STATEMENT: {
				ContinueStatement continueStatement = (ContinueStatement)theEObject;
				T result = caseContinueStatement(continueStatement);
				if (result == null) result = caseSimpleStatement(continueStatement);
				if (result == null) result = caseStatement(continueStatement);
				if (result == null) result = caseConstruct(continueStatement);
				if (result == null) result = caseNamedExtension(continueStatement);
				if (result == null) result = caseExtension(continueStatement);
				if (result == null) result = caseNamedElement(continueStatement);
				if (result == null) result = caseExpandableElement(continueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FOR_EACH_STATEMENT: {
				ForEachStatement forEachStatement = (ForEachStatement)theEObject;
				T result = caseForEachStatement(forEachStatement);
				if (result == null) result = caseCompositeStatement(forEachStatement);
				if (result == null) result = caseStatement(forEachStatement);
				if (result == null) result = caseConstruct(forEachStatement);
				if (result == null) result = caseNamedExtension(forEachStatement);
				if (result == null) result = caseExtension(forEachStatement);
				if (result == null) result = caseNamedElement(forEachStatement);
				if (result == null) result = caseExpandableElement(forEachStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseConstruct(expression);
				if (result == null) result = caseNamedExtension(expression);
				if (result == null) result = caseExtension(expression);
				if (result == null) result = caseNamedElement(expression);
				if (result == null) result = caseExpandableElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.L1_EXPR: {
				L1Expr l1Expr = (L1Expr)theEObject;
				T result = caseL1Expr(l1Expr);
				if (result == null) result = caseExpression(l1Expr);
				if (result == null) result = caseConstruct(l1Expr);
				if (result == null) result = caseNamedExtension(l1Expr);
				if (result == null) result = caseExtension(l1Expr);
				if (result == null) result = caseNamedElement(l1Expr);
				if (result == null) result = caseExpandableElement(l1Expr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BINARY_OPERATOR: {
				BinaryOperator binaryOperator = (BinaryOperator)theEObject;
				T result = caseBinaryOperator(binaryOperator);
				if (result == null) result = caseExpression(binaryOperator);
				if (result == null) result = caseConstruct(binaryOperator);
				if (result == null) result = caseNamedExtension(binaryOperator);
				if (result == null) result = caseExtension(binaryOperator);
				if (result == null) result = caseNamedElement(binaryOperator);
				if (result == null) result = caseExpandableElement(binaryOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.UNARY_OPERATOR: {
				UnaryOperator unaryOperator = (UnaryOperator)theEObject;
				T result = caseUnaryOperator(unaryOperator);
				if (result == null) result = caseExpression(unaryOperator);
				if (result == null) result = caseConstruct(unaryOperator);
				if (result == null) result = caseNamedExtension(unaryOperator);
				if (result == null) result = caseExtension(unaryOperator);
				if (result == null) result = caseNamedElement(unaryOperator);
				if (result == null) result = caseExpandableElement(unaryOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PLUS: {
				Plus plus = (Plus)theEObject;
				T result = casePlus(plus);
				if (result == null) result = caseBinaryOperator(plus);
				if (result == null) result = caseExpression(plus);
				if (result == null) result = caseConstruct(plus);
				if (result == null) result = caseNamedExtension(plus);
				if (result == null) result = caseExtension(plus);
				if (result == null) result = caseNamedElement(plus);
				if (result == null) result = caseExpandableElement(plus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MINUS: {
				Minus minus = (Minus)theEObject;
				T result = caseMinus(minus);
				if (result == null) result = caseBinaryOperator(minus);
				if (result == null) result = caseExpression(minus);
				if (result == null) result = caseConstruct(minus);
				if (result == null) result = caseNamedExtension(minus);
				if (result == null) result = caseExtension(minus);
				if (result == null) result = caseNamedElement(minus);
				if (result == null) result = caseExpandableElement(minus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MUL: {
				Mul mul = (Mul)theEObject;
				T result = caseMul(mul);
				if (result == null) result = caseBinaryOperator(mul);
				if (result == null) result = caseExpression(mul);
				if (result == null) result = caseConstruct(mul);
				if (result == null) result = caseNamedExtension(mul);
				if (result == null) result = caseExtension(mul);
				if (result == null) result = caseNamedElement(mul);
				if (result == null) result = caseExpandableElement(mul);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MOD: {
				Mod mod = (Mod)theEObject;
				T result = caseMod(mod);
				if (result == null) result = caseBinaryOperator(mod);
				if (result == null) result = caseExpression(mod);
				if (result == null) result = caseConstruct(mod);
				if (result == null) result = caseNamedExtension(mod);
				if (result == null) result = caseExtension(mod);
				if (result == null) result = caseNamedElement(mod);
				if (result == null) result = caseExpandableElement(mod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DIV: {
				Div div = (Div)theEObject;
				T result = caseDiv(div);
				if (result == null) result = caseBinaryOperator(div);
				if (result == null) result = caseExpression(div);
				if (result == null) result = caseConstruct(div);
				if (result == null) result = caseNamedExtension(div);
				if (result == null) result = caseExtension(div);
				if (result == null) result = caseNamedElement(div);
				if (result == null) result = caseExpandableElement(div);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NEG: {
				Neg neg = (Neg)theEObject;
				T result = caseNeg(neg);
				if (result == null) result = caseUnaryOperator(neg);
				if (result == null) result = caseExpression(neg);
				if (result == null) result = caseConstruct(neg);
				if (result == null) result = caseNamedExtension(neg);
				if (result == null) result = caseExtension(neg);
				if (result == null) result = caseNamedElement(neg);
				if (result == null) result = caseExpandableElement(neg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseBinaryOperator(and);
				if (result == null) result = caseExpression(and);
				if (result == null) result = caseConstruct(and);
				if (result == null) result = caseNamedExtension(and);
				if (result == null) result = caseExtension(and);
				if (result == null) result = caseNamedElement(and);
				if (result == null) result = caseExpandableElement(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseBinaryOperator(or);
				if (result == null) result = caseExpression(or);
				if (result == null) result = caseConstruct(or);
				if (result == null) result = caseNamedExtension(or);
				if (result == null) result = caseExtension(or);
				if (result == null) result = caseNamedElement(or);
				if (result == null) result = caseExpandableElement(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.GREATER: {
				Greater greater = (Greater)theEObject;
				T result = caseGreater(greater);
				if (result == null) result = caseBinaryOperator(greater);
				if (result == null) result = caseExpression(greater);
				if (result == null) result = caseConstruct(greater);
				if (result == null) result = caseNamedExtension(greater);
				if (result == null) result = caseExtension(greater);
				if (result == null) result = caseNamedElement(greater);
				if (result == null) result = caseExpandableElement(greater);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.GREATER_EQUAL: {
				GreaterEqual greaterEqual = (GreaterEqual)theEObject;
				T result = caseGreaterEqual(greaterEqual);
				if (result == null) result = caseBinaryOperator(greaterEqual);
				if (result == null) result = caseExpression(greaterEqual);
				if (result == null) result = caseConstruct(greaterEqual);
				if (result == null) result = caseNamedExtension(greaterEqual);
				if (result == null) result = caseExtension(greaterEqual);
				if (result == null) result = caseNamedElement(greaterEqual);
				if (result == null) result = caseExpandableElement(greaterEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LESS: {
				Less less = (Less)theEObject;
				T result = caseLess(less);
				if (result == null) result = caseBinaryOperator(less);
				if (result == null) result = caseExpression(less);
				if (result == null) result = caseConstruct(less);
				if (result == null) result = caseNamedExtension(less);
				if (result == null) result = caseExtension(less);
				if (result == null) result = caseNamedElement(less);
				if (result == null) result = caseExpandableElement(less);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LESS_EQUAL: {
				LessEqual lessEqual = (LessEqual)theEObject;
				T result = caseLessEqual(lessEqual);
				if (result == null) result = caseBinaryOperator(lessEqual);
				if (result == null) result = caseExpression(lessEqual);
				if (result == null) result = caseConstruct(lessEqual);
				if (result == null) result = caseNamedExtension(lessEqual);
				if (result == null) result = caseExtension(lessEqual);
				if (result == null) result = caseNamedElement(lessEqual);
				if (result == null) result = caseExpandableElement(lessEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NOT_EQUAL: {
				NotEqual notEqual = (NotEqual)theEObject;
				T result = caseNotEqual(notEqual);
				if (result == null) result = caseBinaryOperator(notEqual);
				if (result == null) result = caseExpression(notEqual);
				if (result == null) result = caseConstruct(notEqual);
				if (result == null) result = caseNamedExtension(notEqual);
				if (result == null) result = caseExtension(notEqual);
				if (result == null) result = caseNamedElement(notEqual);
				if (result == null) result = caseExpandableElement(notEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EQUAL: {
				Equal equal = (Equal)theEObject;
				T result = caseEqual(equal);
				if (result == null) result = caseBinaryOperator(equal);
				if (result == null) result = caseExpression(equal);
				if (result == null) result = caseConstruct(equal);
				if (result == null) result = caseNamedExtension(equal);
				if (result == null) result = caseExtension(equal);
				if (result == null) result = caseNamedElement(equal);
				if (result == null) result = caseExpandableElement(equal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INSTANCE_OF: {
				InstanceOf instanceOf = (InstanceOf)theEObject;
				T result = caseInstanceOf(instanceOf);
				if (result == null) result = caseBinaryOperator(instanceOf);
				if (result == null) result = caseExpression(instanceOf);
				if (result == null) result = caseConstruct(instanceOf);
				if (result == null) result = caseNamedExtension(instanceOf);
				if (result == null) result = caseExtension(instanceOf);
				if (result == null) result = caseNamedElement(instanceOf);
				if (result == null) result = caseExpandableElement(instanceOf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseUnaryOperator(not);
				if (result == null) result = caseExpression(not);
				if (result == null) result = caseConstruct(not);
				if (result == null) result = caseNamedExtension(not);
				if (result == null) result = caseExtension(not);
				if (result == null) result = caseNamedElement(not);
				if (result == null) result = caseExpandableElement(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CREATE_OBJECT: {
				CreateObject createObject = (CreateObject)theEObject;
				T result = caseCreateObject(createObject);
				if (result == null) result = caseExpression(createObject);
				if (result == null) result = caseTypedElement(createObject);
				if (result == null) result = caseConstruct(createObject);
				if (result == null) result = caseNamedExtension(createObject);
				if (result == null) result = caseExtension(createObject);
				if (result == null) result = caseNamedElement(createObject);
				if (result == null) result = caseExpandableElement(createObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CAST: {
				Cast cast = (Cast)theEObject;
				T result = caseCast(cast);
				if (result == null) result = caseUnaryOperator(cast);
				if (result == null) result = caseTypedElement(cast);
				if (result == null) result = caseExpression(cast);
				if (result == null) result = caseConstruct(cast);
				if (result == null) result = caseNamedExtension(cast);
				if (result == null) result = caseExtension(cast);
				if (result == null) result = caseNamedElement(cast);
				if (result == null) result = caseExpandableElement(cast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NULL_LITERAL: {
				NullLiteral nullLiteral = (NullLiteral)theEObject;
				T result = caseNullLiteral(nullLiteral);
				if (result == null) result = caseExpression(nullLiteral);
				if (result == null) result = caseConstruct(nullLiteral);
				if (result == null) result = caseNamedExtension(nullLiteral);
				if (result == null) result = caseExtension(nullLiteral);
				if (result == null) result = caseNamedElement(nullLiteral);
				if (result == null) result = caseExpandableElement(nullLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TIME_LITERAL: {
				TimeLiteral timeLiteral = (TimeLiteral)theEObject;
				T result = caseTimeLiteral(timeLiteral);
				if (result == null) result = caseExpression(timeLiteral);
				if (result == null) result = caseConstruct(timeLiteral);
				if (result == null) result = caseNamedExtension(timeLiteral);
				if (result == null) result = caseExtension(timeLiteral);
				if (result == null) result = caseNamedElement(timeLiteral);
				if (result == null) result = caseExpandableElement(timeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ACTIVE_LITERAL: {
				ActiveLiteral activeLiteral = (ActiveLiteral)theEObject;
				T result = caseActiveLiteral(activeLiteral);
				if (result == null) result = caseExpression(activeLiteral);
				if (result == null) result = caseConstruct(activeLiteral);
				if (result == null) result = caseNamedExtension(activeLiteral);
				if (result == null) result = caseExtension(activeLiteral);
				if (result == null) result = caseNamedElement(activeLiteral);
				if (result == null) result = caseExpandableElement(activeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EVAL_EXPR: {
				EvalExpr evalExpr = (EvalExpr)theEObject;
				T result = caseEvalExpr(evalExpr);
				if (result == null) result = caseExpression(evalExpr);
				if (result == null) result = caseConstruct(evalExpr);
				if (result == null) result = caseNamedExtension(evalExpr);
				if (result == null) result = caseExtension(evalExpr);
				if (result == null) result = caseNamedElement(evalExpr);
				if (result == null) result = caseExpandableElement(evalExpr);
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
			case DblPackage.SET_OP: {
				SetOp setOp = (SetOp)theEObject;
				T result = caseSetOp(setOp);
				if (result == null) result = casePredefinedId(setOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SIZE_OF_SET: {
				SizeOfSet sizeOfSet = (SizeOfSet)theEObject;
				T result = caseSizeOfSet(sizeOfSet);
				if (result == null) result = caseSetOp(sizeOfSet);
				if (result == null) result = casePredefinedId(sizeOfSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FIRST_IN_SET: {
				FirstInSet firstInSet = (FirstInSet)theEObject;
				T result = caseFirstInSet(firstInSet);
				if (result == null) result = caseSetOp(firstInSet);
				if (result == null) result = casePredefinedId(firstInSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.LAST_IN_SET: {
				LastInSet lastInSet = (LastInSet)theEObject;
				T result = caseLastInSet(lastInSet);
				if (result == null) result = caseSetOp(lastInSet);
				if (result == null) result = casePredefinedId(lastInSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CONTAINS: {
				Contains contains = (Contains)theEObject;
				T result = caseContains(contains);
				if (result == null) result = caseSetOp(contains);
				if (result == null) result = casePredefinedId(contains);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INDEX_OF: {
				IndexOf indexOf = (IndexOf)theEObject;
				T result = caseIndexOf(indexOf);
				if (result == null) result = caseSetOp(indexOf);
				if (result == null) result = casePredefinedId(indexOf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.OBJECT_AT: {
				ObjectAt objectAt = (ObjectAt)theEObject;
				T result = caseObjectAt(objectAt);
				if (result == null) result = caseSetOp(objectAt);
				if (result == null) result = casePredefinedId(objectAt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.BEFORE_IN_SET: {
				BeforeInSet beforeInSet = (BeforeInSet)theEObject;
				T result = caseBeforeInSet(beforeInSet);
				if (result == null) result = caseSetOp(beforeInSet);
				if (result == null) result = casePredefinedId(beforeInSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.AFTER_IN_SET: {
				AfterInSet afterInSet = (AfterInSet)theEObject;
				T result = caseAfterInSet(afterInSet);
				if (result == null) result = caseSetOp(afterInSet);
				if (result == null) result = casePredefinedId(afterInSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = caseConstruct(stringLiteral);
				if (result == null) result = caseNamedExtension(stringLiteral);
				if (result == null) result = caseExtension(stringLiteral);
				if (result == null) result = caseNamedElement(stringLiteral);
				if (result == null) result = caseExpandableElement(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INT_LITERAL: {
				IntLiteral intLiteral = (IntLiteral)theEObject;
				T result = caseIntLiteral(intLiteral);
				if (result == null) result = caseExpression(intLiteral);
				if (result == null) result = caseConstruct(intLiteral);
				if (result == null) result = caseNamedExtension(intLiteral);
				if (result == null) result = caseExtension(intLiteral);
				if (result == null) result = caseNamedElement(intLiteral);
				if (result == null) result = caseExpandableElement(intLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TRUE_LITERAL: {
				TrueLiteral trueLiteral = (TrueLiteral)theEObject;
				T result = caseTrueLiteral(trueLiteral);
				if (result == null) result = caseExpression(trueLiteral);
				if (result == null) result = caseConstruct(trueLiteral);
				if (result == null) result = caseNamedExtension(trueLiteral);
				if (result == null) result = caseExtension(trueLiteral);
				if (result == null) result = caseNamedElement(trueLiteral);
				if (result == null) result = caseExpandableElement(trueLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FALSE_LITERAL: {
				FalseLiteral falseLiteral = (FalseLiteral)theEObject;
				T result = caseFalseLiteral(falseLiteral);
				if (result == null) result = caseExpression(falseLiteral);
				if (result == null) result = caseConstruct(falseLiteral);
				if (result == null) result = caseNamedExtension(falseLiteral);
				if (result == null) result = caseExtension(falseLiteral);
				if (result == null) result = caseNamedElement(falseLiteral);
				if (result == null) result = caseExpandableElement(falseLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DOUBLE_LITERAL: {
				DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
				T result = caseDoubleLiteral(doubleLiteral);
				if (result == null) result = caseExpression(doubleLiteral);
				if (result == null) result = caseConstruct(doubleLiteral);
				if (result == null) result = caseNamedExtension(doubleLiteral);
				if (result == null) result = caseExtension(doubleLiteral);
				if (result == null) result = caseNamedElement(doubleLiteral);
				if (result == null) result = caseExpandableElement(doubleLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.DEP_IDENTIFIABLE_ELEMENT: {
				DepIdentifiableElement depIdentifiableElement = (DepIdentifiableElement)theEObject;
				T result = caseDepIdentifiableElement(depIdentifiableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PREDEFINED_ID: {
				PredefinedId predefinedId = (PredefinedId)theEObject;
				T result = casePredefinedId(predefinedId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ID_EXPR: {
				IdExpr idExpr = (IdExpr)theEObject;
				T result = caseIdExpr(idExpr);
				if (result == null) result = caseExpression(idExpr);
				if (result == null) result = caseConstruct(idExpr);
				if (result == null) result = caseNamedExtension(idExpr);
				if (result == null) result = caseExtension(idExpr);
				if (result == null) result = caseNamedElement(idExpr);
				if (result == null) result = caseExpandableElement(idExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ARGUMENT_EXPRESSION: {
				ArgumentExpression argumentExpression = (ArgumentExpression)theEObject;
				T result = caseArgumentExpression(argumentExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ELEMENT_ACCESS: {
				ElementAccess elementAccess = (ElementAccess)theEObject;
				T result = caseElementAccess(elementAccess);
				if (result == null) result = caseExpression(elementAccess);
				if (result == null) result = caseConstruct(elementAccess);
				if (result == null) result = caseNamedExtension(elementAccess);
				if (result == null) result = caseExtension(elementAccess);
				if (result == null) result = caseNamedElement(elementAccess);
				if (result == null) result = caseExpandableElement(elementAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.VARIABLE_ACCESS: {
				VariableAccess variableAccess = (VariableAccess)theEObject;
				T result = caseVariableAccess(variableAccess);
				if (result == null) result = caseElementAccess(variableAccess);
				if (result == null) result = caseExpression(variableAccess);
				if (result == null) result = caseConstruct(variableAccess);
				if (result == null) result = caseNamedExtension(variableAccess);
				if (result == null) result = caseExtension(variableAccess);
				if (result == null) result = caseNamedElement(variableAccess);
				if (result == null) result = caseExpandableElement(variableAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.META_ACCESS: {
				MetaAccess metaAccess = (MetaAccess)theEObject;
				T result = caseMetaAccess(metaAccess);
				if (result == null) result = caseVariableAccess(metaAccess);
				if (result == null) result = caseElementAccess(metaAccess);
				if (result == null) result = caseExpression(metaAccess);
				if (result == null) result = caseConstruct(metaAccess);
				if (result == null) result = caseNamedExtension(metaAccess);
				if (result == null) result = caseExtension(metaAccess);
				if (result == null) result = caseNamedElement(metaAccess);
				if (result == null) result = caseExpandableElement(metaAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TYPE_ACCESS: {
				TypeAccess typeAccess = (TypeAccess)theEObject;
				T result = caseTypeAccess(typeAccess);
				if (result == null) result = caseElementAccess(typeAccess);
				if (result == null) result = caseExpression(typeAccess);
				if (result == null) result = caseConstruct(typeAccess);
				if (result == null) result = caseNamedExtension(typeAccess);
				if (result == null) result = caseExtension(typeAccess);
				if (result == null) result = caseNamedElement(typeAccess);
				if (result == null) result = caseExpandableElement(typeAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXTENSION: {
				Extension extension = (Extension)theEObject;
				T result = caseExtension(extension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.NAMED_EXTENSION: {
				NamedExtension namedExtension = (NamedExtension)theEObject;
				T result = caseNamedExtension(namedExtension);
				if (result == null) result = caseExtension(namedExtension);
				if (result == null) result = caseNamedElement(namedExtension);
				if (result == null) result = caseExpandableElement(namedExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CLASS_CONTENT_EXTENSION: {
				ClassContentExtension classContentExtension = (ClassContentExtension)theEObject;
				T result = caseClassContentExtension(classContentExtension);
				if (result == null) result = caseNamedExtension(classContentExtension);
				if (result == null) result = caseExtension(classContentExtension);
				if (result == null) result = caseNamedElement(classContentExtension);
				if (result == null) result = caseExpandableElement(classContentExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MODULE_CONTENT_EXTENSION: {
				ModuleContentExtension moduleContentExtension = (ModuleContentExtension)theEObject;
				T result = caseModuleContentExtension(moduleContentExtension);
				if (result == null) result = caseNamedExtension(moduleContentExtension);
				if (result == null) result = caseExtension(moduleContentExtension);
				if (result == null) result = caseNamedElement(moduleContentExtension);
				if (result == null) result = caseExpandableElement(moduleContentExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXTENSION_DEFINITION: {
				ExtensionDefinition extensionDefinition = (ExtensionDefinition)theEObject;
				T result = caseExtensionDefinition(extensionDefinition);
				if (result == null) result = caseNamedElement(extensionDefinition);
				if (result == null) result = caseExpandableElement(extensionDefinition);
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
				if (result == null) result = caseExpandableElement(referableRhsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TS_RULE: {
				TsRule tsRule = (TsRule)theEObject;
				T result = caseTsRule(tsRule);
				if (result == null) result = caseReferableRhsType(tsRule);
				if (result == null) result = caseNamedElement(tsRule);
				if (result == null) result = caseExpandableElement(tsRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXTENSION_RULE: {
				ExtensionRule extensionRule = (ExtensionRule)theEObject;
				T result = caseExtensionRule(extensionRule);
				if (result == null) result = caseNamedElement(extensionRule);
				if (result == null) result = caseExpandableElement(extensionRule);
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
				if (result == null) result = caseExpandableElement(propertyBindingExpr);
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
				if (result == null) result = caseCodeBlock(mapping);
				if (result == null) result = caseConstruct(mapping);
				if (result == null) result = caseNamedExtension(mapping);
				if (result == null) result = caseExtension(mapping);
				if (result == null) result = caseNamedElement(mapping);
				if (result == null) result = caseExpandableElement(mapping);
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
				if (result == null) result = caseConstruct(metaExpr);
				if (result == null) result = caseNamedExtension(metaExpr);
				if (result == null) result = caseExtension(metaExpr);
				if (result == null) result = caseNamedElement(metaExpr);
				if (result == null) result = caseExpandableElement(metaExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TARGET_STATEMENT: {
				TargetStatement targetStatement = (TargetStatement)theEObject;
				T result = caseTargetStatement(targetStatement);
				if (result == null) result = caseStatement(targetStatement);
				if (result == null) result = caseConstruct(targetStatement);
				if (result == null) result = caseNamedExtension(targetStatement);
				if (result == null) result = caseExtension(targetStatement);
				if (result == null) result = caseNamedElement(targetStatement);
				if (result == null) result = caseExpandableElement(targetStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.MAPPING_STATEMENT: {
				MappingStatement mappingStatement = (MappingStatement)theEObject;
				T result = caseMappingStatement(mappingStatement);
				if (result == null) result = caseStatement(mappingStatement);
				if (result == null) result = caseConstruct(mappingStatement);
				if (result == null) result = caseNamedExtension(mappingStatement);
				if (result == null) result = caseExtension(mappingStatement);
				if (result == null) result = caseNamedElement(mappingStatement);
				if (result == null) result = caseExpandableElement(mappingStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SET_GEN_CONTEXT_STATEMENT: {
				SetGenContextStatement setGenContextStatement = (SetGenContextStatement)theEObject;
				T result = caseSetGenContextStatement(setGenContextStatement);
				if (result == null) result = caseSimpleStatement(setGenContextStatement);
				if (result == null) result = caseStatement(setGenContextStatement);
				if (result == null) result = caseConstruct(setGenContextStatement);
				if (result == null) result = caseNamedExtension(setGenContextStatement);
				if (result == null) result = caseExtension(setGenContextStatement);
				if (result == null) result = caseNamedElement(setGenContextStatement);
				if (result == null) result = caseExpandableElement(setGenContextStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RESET_GEN_CONTEXT_STATEMENT: {
				ResetGenContextStatement resetGenContextStatement = (ResetGenContextStatement)theEObject;
				T result = caseResetGenContextStatement(resetGenContextStatement);
				if (result == null) result = caseSimpleStatement(resetGenContextStatement);
				if (result == null) result = caseStatement(resetGenContextStatement);
				if (result == null) result = caseConstruct(resetGenContextStatement);
				if (result == null) result = caseNamedExtension(resetGenContextStatement);
				if (result == null) result = caseExtension(resetGenContextStatement);
				if (result == null) result = caseNamedElement(resetGenContextStatement);
				if (result == null) result = caseExpandableElement(resetGenContextStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.SAVE_GEN_STATEMENT: {
				SaveGenStatement saveGenStatement = (SaveGenStatement)theEObject;
				T result = caseSaveGenStatement(saveGenStatement);
				if (result == null) result = caseSimpleStatement(saveGenStatement);
				if (result == null) result = caseStatement(saveGenStatement);
				if (result == null) result = caseConstruct(saveGenStatement);
				if (result == null) result = caseNamedExtension(saveGenStatement);
				if (result == null) result = caseExtension(saveGenStatement);
				if (result == null) result = caseNamedElement(saveGenStatement);
				if (result == null) result = caseExpandableElement(saveGenStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.RESUME_GEN_STATEMENT: {
				ResumeGenStatement resumeGenStatement = (ResumeGenStatement)theEObject;
				T result = caseResumeGenStatement(resumeGenStatement);
				if (result == null) result = caseSimpleStatement(resumeGenStatement);
				if (result == null) result = caseStatement(resumeGenStatement);
				if (result == null) result = caseConstruct(resumeGenStatement);
				if (result == null) result = caseNamedExtension(resumeGenStatement);
				if (result == null) result = caseExtension(resumeGenStatement);
				if (result == null) result = caseNamedElement(resumeGenStatement);
				if (result == null) result = caseExpandableElement(resumeGenStatement);
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
				if (result == null) result = caseConstruct(expandExpression);
				if (result == null) result = caseNamedExtension(expandExpression);
				if (result == null) result = caseExtension(expandExpression);
				if (result == null) result = caseNamedElement(expandExpression);
				if (result == null) result = caseExpandableElement(expandExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPAND_STATEMENT: {
				ExpandStatement expandStatement = (ExpandStatement)theEObject;
				T result = caseExpandStatement(expandStatement);
				if (result == null) result = caseStatement(expandStatement);
				if (result == null) result = caseConstruct(expandStatement);
				if (result == null) result = caseNamedExtension(expandStatement);
				if (result == null) result = caseExtension(expandStatement);
				if (result == null) result = caseNamedElement(expandStatement);
				if (result == null) result = caseExpandableElement(expandStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPAND_SECTION: {
				ExpandSection expandSection = (ExpandSection)theEObject;
				T result = caseExpandSection(expandSection);
				if (result == null) result = caseCompositeStatement(expandSection);
				if (result == null) result = caseStatement(expandSection);
				if (result == null) result = caseConstruct(expandSection);
				if (result == null) result = caseNamedExtension(expandSection);
				if (result == null) result = caseExtension(expandSection);
				if (result == null) result = caseNamedElement(expandSection);
				if (result == null) result = caseExpandableElement(expandSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CODE_QUOTE_EXPRESSION: {
				CodeQuoteExpression codeQuoteExpression = (CodeQuoteExpression)theEObject;
				T result = caseCodeQuoteExpression(codeQuoteExpression);
				if (result == null) result = caseExpression(codeQuoteExpression);
				if (result == null) result = caseConstruct(codeQuoteExpression);
				if (result == null) result = caseNamedExtension(codeQuoteExpression);
				if (result == null) result = caseExtension(codeQuoteExpression);
				if (result == null) result = caseNamedElement(codeQuoteExpression);
				if (result == null) result = caseExpandableElement(codeQuoteExpression);
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
				if (result == null) result = caseExpandableElement(quotedModuleContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.EXPANDABLE_ELEMENT: {
				ExpandableElement expandableElement = (ExpandableElement)theEObject;
				T result = caseExpandableElement(expandableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.TEST_STATEMENT: {
				TestStatement testStatement = (TestStatement)theEObject;
				T result = caseTestStatement(testStatement);
				if (result == null) result = caseStatement(testStatement);
				if (result == null) result = caseConstruct(testStatement);
				if (result == null) result = caseNamedExtension(testStatement);
				if (result == null) result = caseExtension(testStatement);
				if (result == null) result = caseNamedElement(testStatement);
				if (result == null) result = caseExpandableElement(testStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.ID_RESOLUTION: {
				IdResolution idResolution = (IdResolution)theEObject;
				T result = caseIdResolution(idResolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = caseNamedElement(pattern);
				if (result == null) result = caseExpandableElement(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.POTENTIALLY_HIDDEN_ID_ELEMENTS: {
				PotentiallyHiddenIdElements potentiallyHiddenIdElements = (PotentiallyHiddenIdElements)theEObject;
				T result = casePotentiallyHiddenIdElements(potentiallyHiddenIdElements);
				if (result == null) result = caseStatement(potentiallyHiddenIdElements);
				if (result == null) result = caseConstruct(potentiallyHiddenIdElements);
				if (result == null) result = caseNamedExtension(potentiallyHiddenIdElements);
				if (result == null) result = caseExtension(potentiallyHiddenIdElements);
				if (result == null) result = caseNamedElement(potentiallyHiddenIdElements);
				if (result == null) result = caseExpandableElement(potentiallyHiddenIdElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.FIND_CONTAINER: {
				FindContainer findContainer = (FindContainer)theEObject;
				T result = caseFindContainer(findContainer);
				if (result == null) result = caseStatement(findContainer);
				if (result == null) result = caseConstruct(findContainer);
				if (result == null) result = caseNamedExtension(findContainer);
				if (result == null) result = caseExtension(findContainer);
				if (result == null) result = caseNamedElement(findContainer);
				if (result == null) result = caseExpandableElement(findContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.CONSIDER_ID_ELEMENTS: {
				ConsiderIdElements considerIdElements = (ConsiderIdElements)theEObject;
				T result = caseConsiderIdElements(considerIdElements);
				if (result == null) result = caseStatement(considerIdElements);
				if (result == null) result = caseConstruct(considerIdElements);
				if (result == null) result = caseNamedExtension(considerIdElements);
				if (result == null) result = caseExtension(considerIdElements);
				if (result == null) result = caseNamedElement(considerIdElements);
				if (result == null) result = caseExpandableElement(considerIdElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DblPackage.INCLUDE_PATTERN: {
				IncludePattern includePattern = (IncludePattern)theEObject;
				T result = caseIncludePattern(includePattern);
				if (result == null) result = caseStatement(includePattern);
				if (result == null) result = caseConstruct(includePattern);
				if (result == null) result = caseNamedExtension(includePattern);
				if (result == null) result = caseExtension(includePattern);
				if (result == null) result = caseNamedElement(includePattern);
				if (result == null) result = caseExpandableElement(includePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Construct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Construct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstruct(Construct object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Simple Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleAnnotation(SimpleAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationApplication(AnnotationApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Value Pair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyValuePair(KeyValuePair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotatableElement(AnnotatableElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Start Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Code Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartCodeBlock(StartCodeBlock object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterface(Interface object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeBlock(CodeBlock object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Composite Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeStatement(CompositeStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Deprecated Procedure Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deprecated Procedure Call Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeprecatedProcedureCallStatement(DeprecatedProcedureCallStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetStatement(SetStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove From Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove From Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveFromSet(RemoveFromSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add To Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add To Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddToSet(AddToSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptySet(EmptySet object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachStatement(ForEachStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Set Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetOp(SetOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Size Of Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Size Of Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSizeOfSet(SizeOfSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>First In Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>First In Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFirstInSet(FirstInSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Last In Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Last In Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLastInSet(LastInSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContains(Contains object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Of</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Of</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexOf(IndexOf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object At</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object At</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectAt(ObjectAt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Before In Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Before In Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeforeInSet(BeforeInSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>After In Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>After In Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAfterInSet(AfterInSet object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Dep Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dep Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDepIdentifiableElement(DepIdentifiableElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Argument Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgumentExpression(ArgumentExpression object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtension(Extension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedExtension(NamedExtension object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Expand Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expand Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandSection(ExpandSection object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Expandable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expandable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandableElement(ExpandableElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Id Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdResolution(IdResolution object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Potentially Hidden Id Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Potentially Hidden Id Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePotentiallyHiddenIdElements(PotentiallyHiddenIdElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Find Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Find Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFindContainer(FindContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consider Id Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consider Id Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsiderIdElements(ConsiderIdElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Include Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Include Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncludePattern(IncludePattern object) {
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
