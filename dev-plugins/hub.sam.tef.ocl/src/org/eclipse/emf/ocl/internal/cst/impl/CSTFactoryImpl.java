/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ocl.internal.cst.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CSTFactoryImpl extends EFactoryImpl implements CSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CSTFactory init() {
		try {
			CSTFactory theCSTFactory = (CSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/OCL2/1.0.0/ocl/cst"); //$NON-NLS-1$ 
			if (theCSTFactory != null) {
				return theCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CSTPackage.PACKAGE_DECLARATION_CS: return createPackageDeclarationCS();
			case CSTPackage.PROPERTY_CONTEXT_CS: return createPropertyContextCS();
			case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS: return createClassifierContextDeclCS();
			case CSTPackage.OPERATION_CONTEXT_DECL_CS: return createOperationContextDeclCS();
			case CSTPackage.PRE_POST_OR_BODY_DECL_CS: return createPrePostOrBodyDeclCS();
			case CSTPackage.OPERATION_CS: return createOperationCS();
			case CSTPackage.DER_VALUE_CS: return createDerValueCS();
			case CSTPackage.INIT_VALUE_CS: return createInitValueCS();
			case CSTPackage.INV_CS: return createInvCS();
			case CSTPackage.DEF_CS: return createDefCS();
			case CSTPackage.DEF_EXPRESSION_CS: return createDefExpressionCS();
			case CSTPackage.PATH_NAME_CS: return createPathNameCS();
			case CSTPackage.VARIABLE_EXP_CS: return createVariableExpCS();
			case CSTPackage.SIMPLE_NAME_CS: return createSimpleNameCS();
			case CSTPackage.PRIMITIVE_TYPE_CS: return createPrimitiveTypeCS();
			case CSTPackage.TUPLE_TYPE_CS: return createTupleTypeCS();
			case CSTPackage.COLLECTION_TYPE_CS: return createCollectionTypeCS();
			case CSTPackage.LET_EXP_CS: return createLetExpCS();
			case CSTPackage.IF_EXP_CS: return createIfExpCS();
			case CSTPackage.MESSAGE_EXP_CS: return createMessageExpCS();
			case CSTPackage.OCL_MESSAGE_ARG_CS: return createOCLMessageArgCS();
			case CSTPackage.VARIABLE_CS: return createVariableCS();
			case CSTPackage.ENUM_LITERAL_EXP_CS: return createEnumLiteralExpCS();
			case CSTPackage.COLLECTION_LITERAL_EXP_CS: return createCollectionLiteralExpCS();
			case CSTPackage.TUPLE_LITERAL_EXP_CS: return createTupleLiteralExpCS();
			case CSTPackage.PRIMITIVE_LITERAL_EXP_CS: return createPrimitiveLiteralExpCS();
			case CSTPackage.INTEGER_LITERAL_EXP_CS: return createIntegerLiteralExpCS();
			case CSTPackage.REAL_LITERAL_EXP_CS: return createRealLiteralExpCS();
			case CSTPackage.STRING_LITERAL_EXP_CS: return createStringLiteralExpCS();
			case CSTPackage.BOOLEAN_LITERAL_EXP_CS: return createBooleanLiteralExpCS();
			case CSTPackage.NULL_LITERAL_EXP_CS: return createNullLiteralExpCS();
			case CSTPackage.INVALID_LITERAL_EXP_CS: return createInvalidLiteralExpCS();
			case CSTPackage.COLLECTION_LITERAL_PART_CS: return createCollectionLiteralPartCS();
			case CSTPackage.COLLECTION_RANGE_CS: return createCollectionRangeCS();
			case CSTPackage.CALL_EXP_CS: return createCallExpCS();
			case CSTPackage.LOOP_EXP_CS: return createLoopExpCS();
			case CSTPackage.ITERATOR_EXP_CS: return createIteratorExpCS();
			case CSTPackage.ITERATE_EXP_CS: return createIterateExpCS();
			case CSTPackage.FEATURE_CALL_EXP_CS: return createFeatureCallExpCS();
			case CSTPackage.OPERATION_CALL_EXP_CS: return createOperationCallExpCS();
			case CSTPackage.IS_MARKED_PRE_CS: return createIsMarkedPreCS();
			case CSTPackage.STATE_EXP_CS: return createStateExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CSTPackage.PRE_POST_OR_BODY_ENUM:
				return createPrePostOrBodyEnumFromString(eDataType, initialValue);
			case CSTPackage.SIMPLE_TYPE_ENUM:
				return createSimpleTypeEnumFromString(eDataType, initialValue);
			case CSTPackage.COLLECTION_TYPE_IDENTIFIER_ENUM:
				return createCollectionTypeIdentifierEnumFromString(eDataType, initialValue);
			case CSTPackage.DOT_OR_ARROW_ENUM:
				return createDotOrArrowEnumFromString(eDataType, initialValue);
			case CSTPackage.MESSAGE_EXP_KIND:
				return createMessageExpKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CSTPackage.PRE_POST_OR_BODY_ENUM:
				return convertPrePostOrBodyEnumToString(eDataType, instanceValue);
			case CSTPackage.SIMPLE_TYPE_ENUM:
				return convertSimpleTypeEnumToString(eDataType, instanceValue);
			case CSTPackage.COLLECTION_TYPE_IDENTIFIER_ENUM:
				return convertCollectionTypeIdentifierEnumToString(eDataType, instanceValue);
			case CSTPackage.DOT_OR_ARROW_ENUM:
				return convertDotOrArrowEnumToString(eDataType, instanceValue);
			case CSTPackage.MESSAGE_EXP_KIND:
				return convertMessageExpKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageDeclarationCS createPackageDeclarationCS() {
		PackageDeclarationCSImpl packageDeclarationCS = new PackageDeclarationCSImpl();
		return packageDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyContextCS createPropertyContextCS() {
		PropertyContextCSImpl propertyContextCS = new PropertyContextCSImpl();
		return propertyContextCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierContextDeclCS createClassifierContextDeclCS() {
		ClassifierContextDeclCSImpl classifierContextDeclCS = new ClassifierContextDeclCSImpl();
		return classifierContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContextDeclCS createOperationContextDeclCS() {
		OperationContextDeclCSImpl operationContextDeclCS = new OperationContextDeclCSImpl();
		return operationContextDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrePostOrBodyDeclCS createPrePostOrBodyDeclCS() {
		PrePostOrBodyDeclCSImpl prePostOrBodyDeclCS = new PrePostOrBodyDeclCSImpl();
		return prePostOrBodyDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS createOperationCS() {
		OperationCSImpl operationCS = new OperationCSImpl();
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerValueCS createDerValueCS() {
		DerValueCSImpl derValueCS = new DerValueCSImpl();
		return derValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitValueCS createInitValueCS() {
		InitValueCSImpl initValueCS = new InitValueCSImpl();
		return initValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvCS createInvCS() {
		InvCSImpl invCS = new InvCSImpl();
		return invCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefCS createDefCS() {
		DefCSImpl defCS = new DefCSImpl();
		return defCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefExpressionCS createDefExpressionCS() {
		DefExpressionCSImpl defExpressionCS = new DefExpressionCSImpl();
		return defExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS createPathNameCS() {
		PathNameCSImpl pathNameCS = new PathNameCSImpl();
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExpCS createVariableExpCS() {
		VariableExpCSImpl variableExpCS = new VariableExpCSImpl();
		return variableExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS createSimpleNameCS() {
		SimpleNameCSImpl simpleNameCS = new SimpleNameCSImpl();
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeCS createPrimitiveTypeCS() {
		PrimitiveTypeCSImpl primitiveTypeCS = new PrimitiveTypeCSImpl();
		return primitiveTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleTypeCS createTupleTypeCS() {
		TupleTypeCSImpl tupleTypeCS = new TupleTypeCSImpl();
		return tupleTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeCS createCollectionTypeCS() {
		CollectionTypeCSImpl collectionTypeCS = new CollectionTypeCSImpl();
		return collectionTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpCS createLetExpCS() {
		LetExpCSImpl letExpCS = new LetExpCSImpl();
		return letExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpCS createIfExpCS() {
		IfExpCSImpl ifExpCS = new IfExpCSImpl();
		return ifExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExpCS createMessageExpCS() {
		MessageExpCSImpl messageExpCS = new MessageExpCSImpl();
		return messageExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLMessageArgCS createOCLMessageArgCS() {
		OCLMessageArgCSImpl oclMessageArgCS = new OCLMessageArgCSImpl();
		return oclMessageArgCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS createVariableCS() {
		VariableCSImpl variableCS = new VariableCSImpl();
		return variableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralExpCS createEnumLiteralExpCS() {
		EnumLiteralExpCSImpl enumLiteralExpCS = new EnumLiteralExpCSImpl();
		return enumLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralExpCS createCollectionLiteralExpCS() {
		CollectionLiteralExpCSImpl collectionLiteralExpCS = new CollectionLiteralExpCSImpl();
		return collectionLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExpCS createTupleLiteralExpCS() {
		TupleLiteralExpCSImpl tupleLiteralExpCS = new TupleLiteralExpCSImpl();
		return tupleLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS createPrimitiveLiteralExpCS() {
		PrimitiveLiteralExpCSImpl primitiveLiteralExpCS = new PrimitiveLiteralExpCSImpl();
		return primitiveLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteralExpCS createIntegerLiteralExpCS() {
		IntegerLiteralExpCSImpl integerLiteralExpCS = new IntegerLiteralExpCSImpl();
		return integerLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealLiteralExpCS createRealLiteralExpCS() {
		RealLiteralExpCSImpl realLiteralExpCS = new RealLiteralExpCSImpl();
		return realLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS createStringLiteralExpCS() {
		StringLiteralExpCSImpl stringLiteralExpCS = new StringLiteralExpCSImpl();
		return stringLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpCS createBooleanLiteralExpCS() {
		BooleanLiteralExpCSImpl booleanLiteralExpCS = new BooleanLiteralExpCSImpl();
		return booleanLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteralExpCS createNullLiteralExpCS() {
		NullLiteralExpCSImpl nullLiteralExpCS = new NullLiteralExpCSImpl();
		return nullLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidLiteralExpCS createInvalidLiteralExpCS() {
		InvalidLiteralExpCSImpl invalidLiteralExpCS = new InvalidLiteralExpCSImpl();
		return invalidLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralPartCS createCollectionLiteralPartCS() {
		CollectionLiteralPartCSImpl collectionLiteralPartCS = new CollectionLiteralPartCSImpl();
		return collectionLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionRangeCS createCollectionRangeCS() {
		CollectionRangeCSImpl collectionRangeCS = new CollectionRangeCSImpl();
		return collectionRangeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallExpCS createCallExpCS() {
		CallExpCSImpl callExpCS = new CallExpCSImpl();
		return callExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopExpCS createLoopExpCS() {
		LoopExpCSImpl loopExpCS = new LoopExpCSImpl();
		return loopExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorExpCS createIteratorExpCS() {
		IteratorExpCSImpl iteratorExpCS = new IteratorExpCSImpl();
		return iteratorExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateExpCS createIterateExpCS() {
		IterateExpCSImpl iterateExpCS = new IterateExpCSImpl();
		return iterateExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureCallExpCS createFeatureCallExpCS() {
		FeatureCallExpCSImpl featureCallExpCS = new FeatureCallExpCSImpl();
		return featureCallExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExpCS createOperationCallExpCS() {
		OperationCallExpCSImpl operationCallExpCS = new OperationCallExpCSImpl();
		return operationCallExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsMarkedPreCS createIsMarkedPreCS() {
		IsMarkedPreCSImpl isMarkedPreCS = new IsMarkedPreCSImpl();
		return isMarkedPreCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateExpCS createStateExpCS() {
		StateExpCSImpl stateExpCS = new StateExpCSImpl();
		return stateExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrePostOrBodyEnum createPrePostOrBodyEnumFromString(EDataType eDataType, String initialValue) {
		PrePostOrBodyEnum result = PrePostOrBodyEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrePostOrBodyEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleTypeEnum createSimpleTypeEnumFromString(EDataType eDataType, String initialValue) {
		SimpleTypeEnum result = SimpleTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSimpleTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeIdentifierEnum createCollectionTypeIdentifierEnumFromString(EDataType eDataType, String initialValue) {
		CollectionTypeIdentifierEnum result = CollectionTypeIdentifierEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionTypeIdentifierEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DotOrArrowEnum createDotOrArrowEnumFromString(EDataType eDataType, String initialValue) {
		DotOrArrowEnum result = DotOrArrowEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDotOrArrowEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExpKind createMessageExpKindFromString(EDataType eDataType, String initialValue) {
		MessageExpKind result = MessageExpKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageExpKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTPackage getCSTPackage() {
		return (CSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static CSTPackage getPackage() {
		return CSTPackage.eINSTANCE;
	}

} //CSTFactoryImpl
