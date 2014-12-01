/**
 */
package hub.sam.dbl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hub.sam.dbl.DblFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface DblPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dbl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.informatik.hu-berlin.de/sam/dbl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dbl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DblPackage eINSTANCE = hub.sam.dbl.impl.DblPackageImpl.init();

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ConstructImpl <em>Construct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ConstructImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getConstruct()
	 * @generated
	 */
	int CONSTRUCT = 0;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCT__EXPAND_EXPR = 0;

	/**
	 * The number of structural features of the '<em>Construct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NamedElementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExtensibleElementImpl <em>Extensible Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExtensibleElementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExtensibleElement()
	 * @generated
	 */
	int EXTENSIBLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Extensible Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSIBLE_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ModelImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 2;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__MODULES = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ImportImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 3;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__FILE = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__MODEL = 1;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ModuleImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXTENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CLASSIFIERS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class Augments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CLASS_AUGMENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extension Defs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXTENSION_DEFS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Procedures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__PROCEDURES = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__VARIABLES = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.EmbeddableExtensionsContainerImpl <em>Embeddable Extensions Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.EmbeddableExtensionsContainerImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getEmbeddableExtensionsContainer()
	 * @generated
	 */
	int EMBEDDABLE_EXTENSIONS_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Embeddable Extensions Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ModifierExtensionsContainerImpl <em>Modifier Extensions Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ModifierExtensionsContainerImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getModifierExtensionsContainer()
	 * @generated
	 */
	int MODIFIER_EXTENSIONS_CONTAINER = 6;

	/**
	 * The feature id for the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Modifier Extensions Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIER_EXTENSIONS_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 7;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ARRAY_DIMENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TypedElementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__PRIMITIVE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS = 1;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__CLASSIFIER_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ArrayDimensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getArrayDimension()
	 * @generated
	 */
	int ARRAY_DIMENSION = 9;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION__SIZE = 0;

	/**
	 * The number of structural features of the '<em>Array Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PrimitiveTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ARRAY_DIMENSIONS = TYPE__ARRAY_DIMENSIONS;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.VoidTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__ARRAY_DIMENSIONS = PRIMITIVE_TYPE__ARRAY_DIMENSIONS;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IntTypeImpl <em>Int Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IntTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIntType()
	 * @generated
	 */
	int INT_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE__ARRAY_DIMENSIONS = PRIMITIVE_TYPE__ARRAY_DIMENSIONS;

	/**
	 * The number of structural features of the '<em>Int Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.BoolTypeImpl <em>Bool Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.BoolTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getBoolType()
	 * @generated
	 */
	int BOOL_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_TYPE__ARRAY_DIMENSIONS = PRIMITIVE_TYPE__ARRAY_DIMENSIONS;

	/**
	 * The number of structural features of the '<em>Bool Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.DoubleTypeImpl <em>Double Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.DoubleTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getDoubleType()
	 * @generated
	 */
	int DOUBLE_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__ARRAY_DIMENSIONS = PRIMITIVE_TYPE__ARRAY_DIMENSIONS;

	/**
	 * The number of structural features of the '<em>Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StringTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__ARRAY_DIMENSIONS = PRIMITIVE_TYPE__ARRAY_DIMENSIONS;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ProcedureImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PRIMITIVE_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__TYPE_ARRAY_DIMENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__CLASSIFIER_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__STATEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Clazz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__CLAZZ = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__ABSTRACT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassifierImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__ARRAY_DIMENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NativeBindingImpl <em>Native Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NativeBindingImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNativeBinding()
	 * @generated
	 */
	int NATIVE_BINDING = 18;

	/**
	 * The feature id for the '<em><b>Target Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_BINDING__TARGET_LANGUAGE = 0;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_BINDING__TARGET_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Native Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassSimilarImpl <em>Class Similar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassSimilarImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClassSimilar()
	 * @generated
	 */
	int CLASS_SIMILAR = 19;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__EXTENSIONS = EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__MODIFIER_EXTENSIONS = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__ATTRIBUTES = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__METHODS = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__SUPER_CLASSES = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__INITIAL_BLOCK = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Final Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__FINAL_BLOCK = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__ACTIONS_BLOCK = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Report Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__REPORT_BLOCK = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Clear Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR__CLEAR_BLOCK = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Class Similar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SIMILAR_FEATURE_COUNT = EMBEDDABLE_EXTENSIONS_CONTAINER_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LocalScopeImpl <em>Local Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LocalScopeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLocalScope()
	 * @generated
	 */
	int LOCAL_SCOPE = 44;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE__STATEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Local Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassPartImpl <em>Class Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClassPart()
	 * @generated
	 */
	int CLASS_PART = 20;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PART__STATEMENTS = LOCAL_SCOPE__STATEMENTS;

	/**
	 * The number of structural features of the '<em>Class Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PART_FEATURE_COUNT = LOCAL_SCOPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SuperClassSpecificationImpl <em>Super Class Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SuperClassSpecificationImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSuperClassSpecification()
	 * @generated
	 */
	int SUPER_CLASS_SPECIFICATION = 21;

	/**
	 * The feature id for the '<em><b>Clazz</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS_SPECIFICATION__CLAZZ = 0;

	/**
	 * The feature id for the '<em><b>Constructor Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS = 1;

	/**
	 * The number of structural features of the '<em>Super Class Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS_SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClazzImpl <em>Clazz</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClazzImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClazz()
	 * @generated
	 */
	int CLAZZ = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__ARRAY_DIMENSIONS = CLASSIFIER__ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__EXTENSIONS = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__MODIFIER_EXTENSIONS = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__ATTRIBUTES = CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__METHODS = CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__SUPER_CLASSES = CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__INITIAL_BLOCK = CLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Final Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__FINAL_BLOCK = CLASSIFIER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__ACTIONS_BLOCK = CLASSIFIER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Report Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__REPORT_BLOCK = CLASSIFIER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Clear Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__CLEAR_BLOCK = CLASSIFIER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__EXPAND_EXPR = CLASSIFIER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__CONCRETE_SYNTAX = CLASSIFIER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__INSTANCE_OF_EXTENSION_DEFINITION = CLASSIFIER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__ACTIVE = CLASSIFIER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__CONSTRUCTOR = CLASSIFIER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ__BINDINGS = CLASSIFIER_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Clazz</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAZZ_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ConstructorImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructor()
	 * @generated
	 */
	int CONSTRUCTOR = 23;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassAugmentImpl <em>Class Augment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassAugmentImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClassAugment()
	 * @generated
	 */
	int CLASS_AUGMENT = 24;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__EXTENSIONS = CLASS_SIMILAR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__MODIFIER_EXTENSIONS = CLASS_SIMILAR__MODIFIER_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__ATTRIBUTES = CLASS_SIMILAR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__METHODS = CLASS_SIMILAR__METHODS;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__SUPER_CLASSES = CLASS_SIMILAR__SUPER_CLASSES;

	/**
	 * The feature id for the '<em><b>Initial Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__INITIAL_BLOCK = CLASS_SIMILAR__INITIAL_BLOCK;

	/**
	 * The feature id for the '<em><b>Final Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__FINAL_BLOCK = CLASS_SIMILAR__FINAL_BLOCK;

	/**
	 * The feature id for the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__ACTIONS_BLOCK = CLASS_SIMILAR__ACTIONS_BLOCK;

	/**
	 * The feature id for the '<em><b>Report Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__REPORT_BLOCK = CLASS_SIMILAR__REPORT_BLOCK;

	/**
	 * The feature id for the '<em><b>Clear Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__CLEAR_BLOCK = CLASS_SIMILAR__CLEAR_BLOCK;

	/**
	 * The feature id for the '<em><b>Augmented Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT__AUGMENTED_CLASS = CLASS_SIMILAR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Augment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_AUGMENT_FEATURE_COUNT = CLASS_SIMILAR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AbstractVariableImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__PRIMITIVE_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__TYPE_ARRAY_DIMENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__CLASSIFIER_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.VariableImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__PRIMITIVE_TYPE = ABSTRACT_VARIABLE__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE_ARRAY_DIMENSIONS = ABSTRACT_VARIABLE__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CLASSIFIER_TYPE = ABSTRACT_VARIABLE__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__EXPAND_EXPR = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CONCRETE_SYNTAX = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION = ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__MODIFIER_EXTENSIONS = ABSTRACT_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CONTROL = ABSTRACT_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Clazz</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CLAZZ = ABSTRACT_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INITIAL_VALUE = ABSTRACT_VARIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ParameterImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PRIMITIVE_TYPE = ABSTRACT_VARIABLE__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE_ARRAY_DIMENSIONS = ABSTRACT_VARIABLE__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__CLASSIFIER_TYPE = ABSTRACT_VARIABLE__CLASSIFIER_TYPE;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LoopStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLoopStatement()
	 * @generated
	 */
	int LOOP_STATEMENT = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Loop Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SimpleStatementImpl <em>Simple Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SimpleStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSimpleStatement()
	 * @generated
	 */
	int SIMPLE_STATEMENT = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Simple Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AssignmentImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VARIABLE = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ProcedureCallImpl <em>Procedure Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ProcedureCallImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getProcedureCall()
	 * @generated
	 */
	int PROCEDURE_CALL = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_CALL__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_CALL__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_CALL__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_CALL__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Call Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_CALL__CALL_ID_EXPR = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Procedure Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_CALL_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ReturnImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__VALUE = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.WaitUntilImpl <em>Wait Until</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.WaitUntilImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getWaitUntil()
	 * @generated
	 */
	int WAIT_UNTIL = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL__CONDITION = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TerminateImpl <em>Terminate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TerminateImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTerminate()
	 * @generated
	 */
	int TERMINATE = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Terminate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.YieldImpl <em>Yield</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.YieldImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getYield()
	 * @generated
	 */
	int YIELD = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YIELD__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YIELD__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YIELD__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YIELD__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Yield</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YIELD_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.WaitImpl <em>Wait</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.WaitImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getWait()
	 * @generated
	 */
	int WAIT = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Wait</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ReactivateImpl <em>Reactivate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ReactivateImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getReactivate()
	 * @generated
	 */
	int REACTIVATE = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Object Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE__OBJECT_ACCESS = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reactivate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ActivateObjectImpl <em>Activate Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ActivateObjectImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getActivateObject()
	 * @generated
	 */
	int ACTIVATE_OBJECT = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Object Access</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__OBJECT_ACCESS = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__PRIORITY = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Activate Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AdvanceImpl <em>Advance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AdvanceImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAdvance()
	 * @generated
	 */
	int ADVANCE = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE__TIME = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Advance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PrintImpl <em>Print</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PrintImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPrint()
	 * @generated
	 */
	int PRINT = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__OUTPUTS = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IfStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__TRUE_CASE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__FALSE_CASE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LocalScopeStatementImpl <em>Local Scope Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LocalScopeStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLocalScopeStatement()
	 * @generated
	 */
	int LOCAL_SCOPE_STATEMENT = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT__STATEMENTS = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Scope Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ForStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__NAME = LOOP_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__EXPAND_EXPR = LOOP_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__CONCRETE_SYNTAX = LOOP_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = LOOP_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__STATEMENTS = LOOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Termination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__TERMINATION = LOOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__INCREMENT = LOOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY = LOOP_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = LOOP_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.WhileStatementImpl <em>While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.WhileStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getWhileStatement()
	 * @generated
	 */
	int WHILE_STATEMENT = 47;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__NAME = LOOP_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__EXPAND_EXPR = LOOP_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONCRETE_SYNTAX = LOOP_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = LOOP_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONDITION = LOOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__BODY = LOOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT_FEATURE_COUNT = LOOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SwitchStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSwitchStatement()
	 * @generated
	 */
	int SWITCH_STATEMENT = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__VARIABLE = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CASES = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__DEFAULT_CASE = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SwitchCaseImpl <em>Switch Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SwitchCaseImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSwitchCase()
	 * @generated
	 */
	int SWITCH_CASE = 49;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE__BODY = 1;

	/**
	 * The number of structural features of the '<em>Switch Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.BreakStatementImpl <em>Break Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.BreakStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getBreakStatement()
	 * @generated
	 */
	int BREAK_STATEMENT = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Break Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ContinueStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getContinueStatement()
	 * @generated
	 */
	int CONTINUE_STATEMENT = 51;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Continue Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 52;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__PRIMITIVE_TYPE = TYPED_ELEMENT__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__TYPE_ARRAY_DIMENSIONS = TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__CLASSIFIER_TYPE = TYPED_ELEMENT__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NAME = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPAND_EXPR = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__CONCRETE_SYNTAX = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L1ExprImpl <em>L1 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L1ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL1Expr()
	 * @generated
	 */
	int L1_EXPR = 53;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L1 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L2ExprImpl <em>L2 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L2ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL2Expr()
	 * @generated
	 */
	int L2_EXPR = 54;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L2 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L3ExprImpl <em>L3 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L3ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL3Expr()
	 * @generated
	 */
	int L3_EXPR = 55;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L3 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L4ExprImpl <em>L4 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L4ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL4Expr()
	 * @generated
	 */
	int L4_EXPR = 56;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L4 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L4_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L5ExprImpl <em>L5 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L5ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL5Expr()
	 * @generated
	 */
	int L5_EXPR = 57;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L5 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L5_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L6ExprImpl <em>L6 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L6ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL6Expr()
	 * @generated
	 */
	int L6_EXPR = 58;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L6 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L6_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L7ExprImpl <em>L7 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L7ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL7Expr()
	 * @generated
	 */
	int L7_EXPR = 59;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L7 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L7_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L8ExprImpl <em>L8 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L8ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL8Expr()
	 * @generated
	 */
	int L8_EXPR = 60;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L8 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L8_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L9ExprImpl <em>L9 Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L9ExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL9Expr()
	 * @generated
	 */
	int L9_EXPR = 61;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>L9 Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L9_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.BinaryOperatorImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getBinaryOperator()
	 * @generated
	 */
	int BINARY_OPERATOR = 62;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__OP1 = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__OP2 = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.UnaryOperatorImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 63;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__OP = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AndImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 65;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.OrImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getOr()
	 * @generated
	 */
	int OR = 64;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.GreaterImpl <em>Greater</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.GreaterImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getGreater()
	 * @generated
	 */
	int GREATER = 68;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.GreaterEqualImpl <em>Greater Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.GreaterEqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getGreaterEqual()
	 * @generated
	 */
	int GREATER_EQUAL = 69;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LessImpl <em>Less</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LessImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLess()
	 * @generated
	 */
	int LESS = 70;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LessEqualImpl <em>Less Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LessEqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLessEqual()
	 * @generated
	 */
	int LESS_EQUAL = 71;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NotEqualImpl <em>Not Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NotEqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNotEqual()
	 * @generated
	 */
	int NOT_EQUAL = 66;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Not Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.EqualImpl <em>Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.EqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getEqual()
	 * @generated
	 */
	int EQUAL = 67;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Greater</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Greater Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Less</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Less Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.InstanceOfImpl <em>Instance Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.InstanceOfImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getInstanceOf()
	 * @generated
	 */
	int INSTANCE_OF = 72;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Instance Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OF_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PlusImpl <em>Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PlusImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPlus()
	 * @generated
	 */
	int PLUS = 73;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MinusImpl <em>Minus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MinusImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMinus()
	 * @generated
	 */
	int MINUS = 74;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MulImpl <em>Mul</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MulImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMul()
	 * @generated
	 */
	int MUL = 75;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Mul</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUL_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ModImpl <em>Mod</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ModImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMod()
	 * @generated
	 */
	int MOD = 76;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Mod</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.DivImpl <em>Div</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.DivImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getDiv()
	 * @generated
	 */
	int DIV = 77;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__PRIMITIVE_TYPE = BINARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__TYPE_ARRAY_DIMENSIONS = BINARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__CLASSIFIER_TYPE = BINARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__NAME = BINARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__EXPAND_EXPR = BINARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__CONCRETE_SYNTAX = BINARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__INSTANCE_OF_EXTENSION_DEFINITION = BINARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__OP1 = BINARY_OPERATOR__OP1;

	/**
	 * The feature id for the '<em><b>Op2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV__OP2 = BINARY_OPERATOR__OP2;

	/**
	 * The number of structural features of the '<em>Div</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NegImpl <em>Neg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NegImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNeg()
	 * @generated
	 */
	int NEG = 78;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__PRIMITIVE_TYPE = UNARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__TYPE_ARRAY_DIMENSIONS = UNARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__CLASSIFIER_TYPE = UNARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__NAME = UNARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__EXPAND_EXPR = UNARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__CONCRETE_SYNTAX = UNARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__INSTANCE_OF_EXTENSION_DEFINITION = UNARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG__OP = UNARY_OPERATOR__OP;

	/**
	 * The number of structural features of the '<em>Neg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEG_FEATURE_COUNT = UNARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NotImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 79;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__PRIMITIVE_TYPE = UNARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__TYPE_ARRAY_DIMENSIONS = UNARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__CLASSIFIER_TYPE = UNARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__NAME = UNARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__EXPAND_EXPR = UNARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__CONCRETE_SYNTAX = UNARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__INSTANCE_OF_EXTENSION_DEFINITION = UNARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__OP = UNARY_OPERATOR__OP;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.CastImpl <em>Cast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.CastImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getCast()
	 * @generated
	 */
	int CAST = 80;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__PRIMITIVE_TYPE = UNARY_OPERATOR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__TYPE_ARRAY_DIMENSIONS = UNARY_OPERATOR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__CLASSIFIER_TYPE = UNARY_OPERATOR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__NAME = UNARY_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__EXPAND_EXPR = UNARY_OPERATOR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__CONCRETE_SYNTAX = UNARY_OPERATOR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__INSTANCE_OF_EXTENSION_DEFINITION = UNARY_OPERATOR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST__OP = UNARY_OPERATOR__OP;

	/**
	 * The number of structural features of the '<em>Cast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_FEATURE_COUNT = UNARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.CreateObjectImpl <em>Create Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.CreateObjectImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getCreateObject()
	 * @generated
	 */
	int CREATE_OBJECT = 81;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Create Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NullLiteralImpl <em>Null Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NullLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNullLiteral()
	 * @generated
	 */
	int NULL_LITERAL = 82;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Null Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TimeLiteralImpl <em>Time Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TimeLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTimeLiteral()
	 * @generated
	 */
	int TIME_LITERAL = 83;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Time Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ActiveLiteralImpl <em>Active Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ActiveLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getActiveLiteral()
	 * @generated
	 */
	int ACTIVE_LITERAL = 84;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Active Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StringLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 85;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IntLiteralImpl <em>Int Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IntLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIntLiteral()
	 * @generated
	 */
	int INT_LITERAL = 86;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__VALUE = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TrueLiteralImpl <em>True Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TrueLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTrueLiteral()
	 * @generated
	 */
	int TRUE_LITERAL = 87;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>True Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.FalseLiteralImpl <em>False Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.FalseLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getFalseLiteral()
	 * @generated
	 */
	int FALSE_LITERAL = 88;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>False Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.DoubleLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 89;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__VALUE = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpandExprImpl <em>Expand Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpandExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandExpr()
	 * @generated
	 */
	int EXPAND_EXPR = 90;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR__EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expand Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ParseExprImpl <em>Parse Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ParseExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getParseExpr()
	 * @generated
	 */
	int PARSE_EXPR = 91;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Ast Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR__AST_PART = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parse Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARSE_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PredefinedIdImpl <em>Predefined Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PredefinedIdImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPredefinedId()
	 * @generated
	 */
	int PREDEFINED_ID = 92;

	/**
	 * The number of structural features of the '<em>Predefined Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_ID_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MeLiteralImpl <em>Me Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MeLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMeLiteral()
	 * @generated
	 */
	int ME_LITERAL = 93;

	/**
	 * The number of structural features of the '<em>Me Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_LITERAL_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SuperLiteralImpl <em>Super Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SuperLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSuperLiteral()
	 * @generated
	 */
	int SUPER_LITERAL = 94;

	/**
	 * The number of structural features of the '<em>Super Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_LITERAL_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MetaLiteralImpl <em>Meta Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MetaLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaLiteral()
	 * @generated
	 */
	int META_LITERAL = 95;

	/**
	 * The number of structural features of the '<em>Meta Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_LITERAL_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TypeLiteralImpl <em>Type Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TypeLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTypeLiteral()
	 * @generated
	 */
	int TYPE_LITERAL = 96;

	/**
	 * The number of structural features of the '<em>Type Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SizeOfArrayImpl <em>Size Of Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SizeOfArrayImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSizeOfArray()
	 * @generated
	 */
	int SIZE_OF_ARRAY = 97;

	/**
	 * The number of structural features of the '<em>Size Of Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_OF_ARRAY_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IdExprImpl <em>Id Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IdExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIdExpr()
	 * @generated
	 */
	int ID_EXPR = 98;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__PRIMITIVE_TYPE = L1_EXPR__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__TYPE_ARRAY_DIMENSIONS = L1_EXPR__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__CLASSIFIER_TYPE = L1_EXPR__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__NAME = L1_EXPR__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__EXPAND_EXPR = L1_EXPR__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__CONCRETE_SYNTAX = L1_EXPR__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = L1_EXPR__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parent Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__PARENT_ID_EXPR = L1_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__REFERENCED_ELEMENT = L1_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predefined Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__PREDEFINED_ID = L1_EXPR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array Index</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__ARRAY_INDEX = L1_EXPR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Call Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR__CALL_PART = L1_EXPR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Id Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_EXPR_FEATURE_COUNT = L1_EXPR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.CallPartImpl <em>Call Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.CallPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getCallPart()
	 * @generated
	 */
	int CALL_PART = 99;

	/**
	 * The feature id for the '<em><b>Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_PART__CALL_ARGUMENTS = 0;

	/**
	 * The number of structural features of the '<em>Call Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ElementAccessImpl <em>Element Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ElementAccessImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getElementAccess()
	 * @generated
	 */
	int ELEMENT_ACCESS = 100;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS__ID_EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ACCESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.VariableAccessImpl <em>Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.VariableAccessImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getVariableAccess()
	 * @generated
	 */
	int VARIABLE_ACCESS = 101;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__PRIMITIVE_TYPE = ELEMENT_ACCESS__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__TYPE_ARRAY_DIMENSIONS = ELEMENT_ACCESS__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__CLASSIFIER_TYPE = ELEMENT_ACCESS__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__NAME = ELEMENT_ACCESS__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__EXPAND_EXPR = ELEMENT_ACCESS__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__CONCRETE_SYNTAX = ELEMENT_ACCESS__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION = ELEMENT_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__ID_EXPR = ELEMENT_ACCESS__ID_EXPR;

	/**
	 * The number of structural features of the '<em>Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS_FEATURE_COUNT = ELEMENT_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MetaAccessImpl <em>Meta Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MetaAccessImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaAccess()
	 * @generated
	 */
	int META_ACCESS = 102;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__PRIMITIVE_TYPE = VARIABLE_ACCESS__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__TYPE_ARRAY_DIMENSIONS = VARIABLE_ACCESS__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__CLASSIFIER_TYPE = VARIABLE_ACCESS__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__NAME = VARIABLE_ACCESS__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__EXPAND_EXPR = VARIABLE_ACCESS__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__CONCRETE_SYNTAX = VARIABLE_ACCESS__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION = VARIABLE_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS__ID_EXPR = VARIABLE_ACCESS__ID_EXPR;

	/**
	 * The number of structural features of the '<em>Meta Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_ACCESS_FEATURE_COUNT = VARIABLE_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TypeAccessImpl <em>Type Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TypeAccessImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTypeAccess()
	 * @generated
	 */
	int TYPE_ACCESS = 103;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__PRIMITIVE_TYPE = ELEMENT_ACCESS__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__TYPE_ARRAY_DIMENSIONS = ELEMENT_ACCESS__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__CLASSIFIER_TYPE = ELEMENT_ACCESS__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__NAME = ELEMENT_ACCESS__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__EXPAND_EXPR = ELEMENT_ACCESS__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__CONCRETE_SYNTAX = ELEMENT_ACCESS__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION = ELEMENT_ACCESS__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS__ID_EXPR = ELEMENT_ACCESS__ID_EXPR;

	/**
	 * The number of structural features of the '<em>Type Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACCESS_FEATURE_COUNT = ELEMENT_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassContentExtensionImpl <em>Class Content Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassContentExtensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClassContentExtension()
	 * @generated
	 */
	int CLASS_CONTENT_EXTENSION = 104;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Class Content Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ModuleContentExtensionImpl <em>Module Content Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ModuleContentExtensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getModuleContentExtension()
	 * @generated
	 */
	int MODULE_CONTENT_EXTENSION = 105;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Module Content Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LanguageConstructClassifierImpl <em>Language Construct Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LanguageConstructClassifierImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLanguageConstructClassifier()
	 * @generated
	 */
	int LANGUAGE_CONSTRUCT_CLASSIFIER = 108;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONSTRUCT_CLASSIFIER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONSTRUCT_CLASSIFIER__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONSTRUCT_CLASSIFIER__CONCRETE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONSTRUCT_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Language Construct Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONSTRUCT_CLASSIFIER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LanguageConceptClassifierImpl <em>Language Concept Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LanguageConceptClassifierImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLanguageConceptClassifier()
	 * @generated
	 */
	int LANGUAGE_CONCEPT_CLASSIFIER = 109;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONCEPT_CLASSIFIER__NAME = LANGUAGE_CONSTRUCT_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONCEPT_CLASSIFIER__EXPAND_EXPR = LANGUAGE_CONSTRUCT_CLASSIFIER__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONCEPT_CLASSIFIER__CONCRETE_SYNTAX = LANGUAGE_CONSTRUCT_CLASSIFIER__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONCEPT_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION = LANGUAGE_CONSTRUCT_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Language Concept Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_CONCEPT_CLASSIFIER_FEATURE_COUNT = LANGUAGE_CONSTRUCT_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExtensionDefinitionImpl <em>Extension Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExtensionDefinitionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExtensionDefinition()
	 * @generated
	 */
	int EXTENSION_DEFINITION = 106;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__NAME = LANGUAGE_CONCEPT_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__EXPAND_EXPR = LANGUAGE_CONCEPT_CLASSIFIER__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__CONCRETE_SYNTAX = LANGUAGE_CONCEPT_CLASSIFIER__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION = LANGUAGE_CONCEPT_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Extended Concept</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__EXTENDED_CONCEPT = LANGUAGE_CONCEPT_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract Syntax Def</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF = LANGUAGE_CONCEPT_CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Textual Syntax Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF = LANGUAGE_CONCEPT_CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__MAPPING_DEF = LANGUAGE_CONCEPT_CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Extension Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION_FEATURE_COUNT = LANGUAGE_CONCEPT_CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TextualSyntaxDefImpl <em>Textual Syntax Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TextualSyntaxDefImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTextualSyntaxDef()
	 * @generated
	 */
	int TEXTUAL_SYNTAX_DEF = 107;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Start Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF__START_RULE = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF__RULES = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Textual Syntax Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_SYNTAX_DEF_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TsRuleImpl <em>Ts Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TsRuleImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTsRule()
	 * @generated
	 */
	int TS_RULE = 110;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_RULE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_RULE__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_RULE__CONCRETE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_RULE__INSTANCE_OF_EXTENSION_DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_RULE__RHS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ts Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TS_RULE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.RhsExpressionImpl <em>Rhs Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.RhsExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getRhsExpression()
	 * @generated
	 */
	int RHS_EXPRESSION = 111;

	/**
	 * The number of structural features of the '<em>Rhs Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L3RhsExprImpl <em>L3 Rhs Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L3RhsExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL3RhsExpr()
	 * @generated
	 */
	int L3_RHS_EXPR = 112;

	/**
	 * The number of structural features of the '<em>L3 Rhs Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_RHS_EXPR_FEATURE_COUNT = RHS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L2RhsExprImpl <em>L2 Rhs Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L2RhsExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL2RhsExpr()
	 * @generated
	 */
	int L2_RHS_EXPR = 113;

	/**
	 * The number of structural features of the '<em>L2 Rhs Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_RHS_EXPR_FEATURE_COUNT = RHS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SequenceExprImpl <em>Sequence Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SequenceExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSequenceExpr()
	 * @generated
	 */
	int SEQUENCE_EXPR = 114;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPR__SEQUENCE = L2_RHS_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPR_FEATURE_COUNT = L2_RHS_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L1RhsExprImpl <em>L1 Rhs Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L1RhsExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL1RhsExpr()
	 * @generated
	 */
	int L1_RHS_EXPR = 115;

	/**
	 * The number of structural features of the '<em>L1 Rhs Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_RHS_EXPR_FEATURE_COUNT = RHS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TerminalExprImpl <em>Terminal Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TerminalExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTerminalExpr()
	 * @generated
	 */
	int TERMINAL_EXPR = 116;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_EXPR__TERMINAL = L1_RHS_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminal Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_EXPR_FEATURE_COUNT = L1_RHS_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PropertyBindingExprImpl <em>Property Binding Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PropertyBindingExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPropertyBindingExpr()
	 * @generated
	 */
	int PROPERTY_BINDING_EXPR = 117;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING_EXPR__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Property Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING_EXPR__PROPERTY_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Binding Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_BINDING_EXPR_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.RhsClassifierExprImpl <em>Rhs Classifier Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.RhsClassifierExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getRhsClassifierExpr()
	 * @generated
	 */
	int RHS_CLASSIFIER_EXPR = 118;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_CLASSIFIER_EXPR__CLASSIFIER = L1_RHS_EXPR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rhs Classifier Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RHS_CLASSIFIER_EXPR_FEATURE_COUNT = L1_RHS_EXPR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PropertyTypeImpl <em>Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 119;

	/**
	 * The number of structural features of the '<em>Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IdPropertyTypeImpl <em>Id Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IdPropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIdPropertyType()
	 * @generated
	 */
	int ID_PROPERTY_TYPE = 120;

	/**
	 * The number of structural features of the '<em>Id Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_PROPERTY_TYPE_FEATURE_COUNT = PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IntPropertyTypeImpl <em>Int Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IntPropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIntPropertyType()
	 * @generated
	 */
	int INT_PROPERTY_TYPE = 121;

	/**
	 * The number of structural features of the '<em>Int Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_PROPERTY_TYPE_FEATURE_COUNT = PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StringPropertyTypeImpl <em>String Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StringPropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStringPropertyType()
	 * @generated
	 */
	int STRING_PROPERTY_TYPE = 122;

	/**
	 * The number of structural features of the '<em>String Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_PROPERTY_TYPE_FEATURE_COUNT = PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.BooleanPropertyTypeImpl <em>Boolean Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.BooleanPropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getBooleanPropertyType()
	 * @generated
	 */
	int BOOLEAN_PROPERTY_TYPE = 123;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PROPERTY_TYPE__TERMINAL = PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PROPERTY_TYPE_FEATURE_COUNT = PROPERTY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StructuredPropertyTypeImpl <em>Structured Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StructuredPropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStructuredPropertyType()
	 * @generated
	 */
	int STRUCTURED_PROPERTY_TYPE = 124;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY_TYPE__TYPE = PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structured Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_PROPERTY_TYPE_FEATURE_COUNT = PROPERTY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.CompositePropertyTypeImpl <em>Composite Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.CompositePropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getCompositePropertyType()
	 * @generated
	 */
	int COMPOSITE_PROPERTY_TYPE = 125;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROPERTY_TYPE__TYPE = STRUCTURED_PROPERTY_TYPE__TYPE;

	/**
	 * The feature id for the '<em><b>List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROPERTY_TYPE__LIST = STRUCTURED_PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROPERTY_TYPE_FEATURE_COUNT = STRUCTURED_PROPERTY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ReferencePropertyTypeImpl <em>Reference Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ReferencePropertyTypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getReferencePropertyType()
	 * @generated
	 */
	int REFERENCE_PROPERTY_TYPE = 126;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY_TYPE__TYPE = STRUCTURED_PROPERTY_TYPE__TYPE;

	/**
	 * The feature id for the '<em><b>Raw Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY_TYPE__RAW_REFERENCE = STRUCTURED_PROPERTY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY_TYPE_FEATURE_COUNT = STRUCTURED_PROPERTY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MappingImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 127;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = LOCAL_SCOPE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__EXPAND_EXPR = LOCAL_SCOPE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONCRETE_SYNTAX = LOCAL_SCOPE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__INSTANCE_OF_EXTENSION_DEFINITION = LOCAL_SCOPE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__STATEMENTS = LOCAL_SCOPE_STATEMENT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__PARTS = LOCAL_SCOPE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Meta Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__META_OBJECT = LOCAL_SCOPE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = LOCAL_SCOPE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MappingPartImpl <em>Mapping Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MappingPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMappingPart()
	 * @generated
	 */
	int MAPPING_PART = 128;

	/**
	 * The number of structural features of the '<em>Mapping Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PART_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MetaExprImpl <em>Meta Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MetaExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaExpr()
	 * @generated
	 */
	int META_EXPR = 129;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR__EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TargetStatementImpl <em>Target Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TargetStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTargetStatement()
	 * @generated
	 */
	int TARGET_STATEMENT = 130;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MappingStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMappingStatement()
	 * @generated
	 */
	int MAPPING_STATEMENT = 131;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__PARTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__EXPRS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SetGenContextStatementImpl <em>Set Gen Context Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SetGenContextStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSetGenContextStatement()
	 * @generated
	 */
	int SET_GEN_CONTEXT_STATEMENT = 132;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT__CONTEXT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Add After Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Gen Context Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_GEN_CONTEXT_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ResetGenContextStatementImpl <em>Reset Gen Context Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ResetGenContextStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getResetGenContextStatement()
	 * @generated
	 */
	int RESET_GEN_CONTEXT_STATEMENT = 133;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_GEN_CONTEXT_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_GEN_CONTEXT_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_GEN_CONTEXT_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_GEN_CONTEXT_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Reset Gen Context Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_GEN_CONTEXT_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SaveGenStatementImpl <em>Save Gen Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SaveGenStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSaveGenStatement()
	 * @generated
	 */
	int SAVE_GEN_STATEMENT = 134;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_GEN_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_GEN_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_GEN_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_GEN_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_GEN_STATEMENT__VARIABLE = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Save Gen Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_GEN_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ResumeGenStatementImpl <em>Resume Gen Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ResumeGenStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getResumeGenStatement()
	 * @generated
	 */
	int RESUME_GEN_STATEMENT = 135;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_GEN_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_GEN_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_GEN_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_GEN_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_GEN_STATEMENT__VARIABLE = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resume Gen Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_GEN_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.FixedMappingPartImpl <em>Fixed Mapping Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.FixedMappingPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getFixedMappingPart()
	 * @generated
	 */
	int FIXED_MAPPING_PART = 136;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_MAPPING_PART__CODE = MAPPING_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed Mapping Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_MAPPING_PART_FEATURE_COUNT = MAPPING_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.DynamicMappingPartImpl <em>Dynamic Mapping Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.DynamicMappingPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getDynamicMappingPart()
	 * @generated
	 */
	int DYNAMIC_MAPPING_PART = 137;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_MAPPING_PART__EXPR = MAPPING_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dynamic Mapping Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_MAPPING_PART_FEATURE_COUNT = MAPPING_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpandExpressionImpl <em>Expand Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpandExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandExpression()
	 * @generated
	 */
	int EXPAND_EXPRESSION = 138;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Meta Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION__META_OBJECT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expand Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpandStatementImpl <em>Expand Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpandStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandStatement()
	 * @generated
	 */
	int EXPAND_STATEMENT = 139;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Meta Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__META_OBJECT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__LOCATION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expand Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.CodeQuoteExpressionImpl <em>Code Quote Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.CodeQuoteExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getCodeQuoteExpression()
	 * @generated
	 */
	int CODE_QUOTE_EXPRESSION = 140;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__PRIMITIVE_TYPE = EXPRESSION__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__TYPE_ARRAY_DIMENSIONS = EXPRESSION__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__CLASSIFIER_TYPE = EXPRESSION__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__EXPAND_EXPR = EXPRESSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__CONCRETE_SYNTAX = EXPRESSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION = EXPRESSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Quoted Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION__QUOTED_CODE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Code Quote Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_QUOTE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.QuotedCodeImpl <em>Quoted Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.QuotedCodeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedCode()
	 * @generated
	 */
	int QUOTED_CODE = 141;

	/**
	 * The number of structural features of the '<em>Quoted Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.QuotedExpressionImpl <em>Quoted Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.QuotedExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedExpression()
	 * @generated
	 */
	int QUOTED_EXPRESSION = 142;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_EXPRESSION__EXPRESSION = QUOTED_CODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quoted Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_EXPRESSION_FEATURE_COUNT = QUOTED_CODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.QuotedStatementsImpl <em>Quoted Statements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.QuotedStatementsImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedStatements()
	 * @generated
	 */
	int QUOTED_STATEMENTS = 143;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_STATEMENTS__STATEMENTS = QUOTED_CODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quoted Statements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_STATEMENTS_FEATURE_COUNT = QUOTED_CODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.QuotedClassContentImpl <em>Quoted Class Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.QuotedClassContentImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedClassContent()
	 * @generated
	 */
	int QUOTED_CLASS_CONTENT = 144;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__EXTENSIONS = QUOTED_CODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__MODIFIER_EXTENSIONS = QUOTED_CODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ATTRIBUTES = QUOTED_CODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__METHODS = QUOTED_CODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__SUPER_CLASSES = QUOTED_CODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__INITIAL_BLOCK = QUOTED_CODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Final Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__FINAL_BLOCK = QUOTED_CODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ACTIONS_BLOCK = QUOTED_CODE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Report Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__REPORT_BLOCK = QUOTED_CODE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Clear Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__CLEAR_BLOCK = QUOTED_CODE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Quoted Class Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT_FEATURE_COUNT = QUOTED_CODE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.QuotedModuleContentImpl <em>Quoted Module Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.QuotedModuleContentImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedModuleContent()
	 * @generated
	 */
	int QUOTED_MODULE_CONTENT = 145;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__NAME = QUOTED_CODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__EXTENSIONS = QUOTED_CODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__EXPAND_EXPR = QUOTED_CODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__CLASSIFIERS = QUOTED_CODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Class Augments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__CLASS_AUGMENTS = QUOTED_CODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extension Defs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__EXTENSION_DEFS = QUOTED_CODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Procedures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__PROCEDURES = QUOTED_CODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__VARIABLES = QUOTED_CODE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Quoted Module Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT_FEATURE_COUNT = QUOTED_CODE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PatternImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 146;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__TOP = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__CONTEXT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__BODY = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TestStatementImpl <em>Test Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TestStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getTestStatement()
	 * @generated
	 */
	int TEST_STATEMENT = 147;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT__EXPAND_EXPR = STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT__CONCRETE_SYNTAX = STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT__VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Construct <em>Construct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Construct</em>'.
	 * @see hub.sam.dbl.Construct
	 * @generated
	 */
	EClass getConstruct();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Construct#getExpandExpr <em>Expand Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expand Expr</em>'.
	 * @see hub.sam.dbl.Construct#getExpandExpr()
	 * @see #getConstruct()
	 * @generated
	 */
	EReference getConstruct_ExpandExpr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extensible Element</em>'.
	 * @see hub.sam.dbl.ExtensibleElement
	 * @generated
	 */
	EClass getExtensibleElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ExtensibleElement#getConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concrete Syntax</em>'.
	 * @see hub.sam.dbl.ExtensibleElement#getConcreteSyntax()
	 * @see #getExtensibleElement()
	 * @generated
	 */
	EAttribute getExtensibleElement_ConcreteSyntax();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ExtensibleElement#isInstanceOfExtensionDefinition <em>Instance Of Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Of Extension Definition</em>'.
	 * @see hub.sam.dbl.ExtensibleElement#isInstanceOfExtensionDefinition()
	 * @see #getExtensibleElement()
	 * @generated
	 */
	EAttribute getExtensibleElement_InstanceOfExtensionDefinition();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see hub.sam.dbl.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Model#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see hub.sam.dbl.Model#getImports()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Model#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see hub.sam.dbl.Model#getModules()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Modules();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see hub.sam.dbl.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Import#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see hub.sam.dbl.Import#getFile()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_File();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.Import#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see hub.sam.dbl.Import#getModel()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_Model();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see hub.sam.dbl.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getClassifiers <em>Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifiers</em>'.
	 * @see hub.sam.dbl.Module#getClassifiers()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Classifiers();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getClassAugments <em>Class Augments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Augments</em>'.
	 * @see hub.sam.dbl.Module#getClassAugments()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ClassAugments();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getExtensionDefs <em>Extension Defs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension Defs</em>'.
	 * @see hub.sam.dbl.Module#getExtensionDefs()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ExtensionDefs();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getProcedures <em>Procedures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procedures</em>'.
	 * @see hub.sam.dbl.Module#getProcedures()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Procedures();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see hub.sam.dbl.Module#getVariables()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Variables();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.EmbeddableExtensionsContainer <em>Embeddable Extensions Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embeddable Extensions Container</em>'.
	 * @see hub.sam.dbl.EmbeddableExtensionsContainer
	 * @generated
	 */
	EClass getEmbeddableExtensionsContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.EmbeddableExtensionsContainer#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see hub.sam.dbl.EmbeddableExtensionsContainer#getExtensions()
	 * @see #getEmbeddableExtensionsContainer()
	 * @generated
	 */
	EReference getEmbeddableExtensionsContainer_Extensions();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ModifierExtensionsContainer <em>Modifier Extensions Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifier Extensions Container</em>'.
	 * @see hub.sam.dbl.ModifierExtensionsContainer
	 * @generated
	 */
	EClass getModifierExtensionsContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ModifierExtensionsContainer#getModifierExtensions <em>Modifier Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modifier Extensions</em>'.
	 * @see hub.sam.dbl.ModifierExtensionsContainer#getModifierExtensions()
	 * @see #getModifierExtensionsContainer()
	 * @generated
	 */
	EReference getModifierExtensionsContainer_ModifierExtensions();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see hub.sam.dbl.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Type#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Dimensions</em>'.
	 * @see hub.sam.dbl.Type#getArrayDimensions()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_ArrayDimensions();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see hub.sam.dbl.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.TypedElement#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primitive Type</em>'.
	 * @see hub.sam.dbl.TypedElement#getPrimitiveType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_PrimitiveType();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.TypedElement#getTypeArrayDimensions <em>Type Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Array Dimensions</em>'.
	 * @see hub.sam.dbl.TypedElement#getTypeArrayDimensions()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_TypeArrayDimensions();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.TypedElement#getClassifierType <em>Classifier Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Classifier Type</em>'.
	 * @see hub.sam.dbl.TypedElement#getClassifierType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_ClassifierType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ArrayDimension <em>Array Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Dimension</em>'.
	 * @see hub.sam.dbl.ArrayDimension
	 * @generated
	 */
	EClass getArrayDimension();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ArrayDimension#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see hub.sam.dbl.ArrayDimension#getSize()
	 * @see #getArrayDimension()
	 * @generated
	 */
	EReference getArrayDimension_Size();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see hub.sam.dbl.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see hub.sam.dbl.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IntType <em>Int Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Type</em>'.
	 * @see hub.sam.dbl.IntType
	 * @generated
	 */
	EClass getIntType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.BoolType <em>Bool Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Type</em>'.
	 * @see hub.sam.dbl.BoolType
	 * @generated
	 */
	EClass getBoolType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Type</em>'.
	 * @see hub.sam.dbl.DoubleType
	 * @generated
	 */
	EClass getDoubleType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see hub.sam.dbl.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see hub.sam.dbl.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Procedure#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see hub.sam.dbl.Procedure#getParameters()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Procedure#isClazz <em>Clazz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clazz</em>'.
	 * @see hub.sam.dbl.Procedure#isClazz()
	 * @see #getProcedure()
	 * @generated
	 */
	EAttribute getProcedure_Clazz();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Procedure#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see hub.sam.dbl.Procedure#isAbstract()
	 * @see #getProcedure()
	 * @generated
	 */
	EAttribute getProcedure_Abstract();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see hub.sam.dbl.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.NativeBinding <em>Native Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Binding</em>'.
	 * @see hub.sam.dbl.NativeBinding
	 * @generated
	 */
	EClass getNativeBinding();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.NativeBinding#getTargetLanguage <em>Target Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Language</em>'.
	 * @see hub.sam.dbl.NativeBinding#getTargetLanguage()
	 * @see #getNativeBinding()
	 * @generated
	 */
	EAttribute getNativeBinding_TargetLanguage();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.NativeBinding#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Type</em>'.
	 * @see hub.sam.dbl.NativeBinding#getTargetType()
	 * @see #getNativeBinding()
	 * @generated
	 */
	EAttribute getNativeBinding_TargetType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ClassSimilar <em>Class Similar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Similar</em>'.
	 * @see hub.sam.dbl.ClassSimilar
	 * @generated
	 */
	EClass getClassSimilar();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ClassSimilar#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getAttributes()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ClassSimilar#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getMethods()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ClassSimilar#getSuperClasses <em>Super Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Classes</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getSuperClasses()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_SuperClasses();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ClassSimilar#getInitialBlock <em>Initial Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Block</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getInitialBlock()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_InitialBlock();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ClassSimilar#getFinalBlock <em>Final Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Final Block</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getFinalBlock()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_FinalBlock();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ClassSimilar#getActionsBlock <em>Actions Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actions Block</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getActionsBlock()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_ActionsBlock();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ClassSimilar#getReportBlock <em>Report Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Report Block</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getReportBlock()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_ReportBlock();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ClassSimilar#getClearBlock <em>Clear Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Clear Block</em>'.
	 * @see hub.sam.dbl.ClassSimilar#getClearBlock()
	 * @see #getClassSimilar()
	 * @generated
	 */
	EReference getClassSimilar_ClearBlock();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ClassPart <em>Class Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Part</em>'.
	 * @see hub.sam.dbl.ClassPart
	 * @generated
	 */
	EClass getClassPart();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SuperClassSpecification <em>Super Class Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Class Specification</em>'.
	 * @see hub.sam.dbl.SuperClassSpecification
	 * @generated
	 */
	EClass getSuperClassSpecification();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.SuperClassSpecification#getClazz <em>Clazz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clazz</em>'.
	 * @see hub.sam.dbl.SuperClassSpecification#getClazz()
	 * @see #getSuperClassSpecification()
	 * @generated
	 */
	EReference getSuperClassSpecification_Clazz();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.SuperClassSpecification#getConstructorArguments <em>Constructor Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constructor Arguments</em>'.
	 * @see hub.sam.dbl.SuperClassSpecification#getConstructorArguments()
	 * @see #getSuperClassSpecification()
	 * @generated
	 */
	EReference getSuperClassSpecification_ConstructorArguments();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Clazz <em>Clazz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clazz</em>'.
	 * @see hub.sam.dbl.Clazz
	 * @generated
	 */
	EClass getClazz();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Clazz#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see hub.sam.dbl.Clazz#isActive()
	 * @see #getClazz()
	 * @generated
	 */
	EAttribute getClazz_Active();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Clazz#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constructor</em>'.
	 * @see hub.sam.dbl.Clazz#getConstructor()
	 * @see #getClazz()
	 * @generated
	 */
	EReference getClazz_Constructor();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Clazz#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see hub.sam.dbl.Clazz#getBindings()
	 * @see #getClazz()
	 * @generated
	 */
	EReference getClazz_Bindings();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Constructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor</em>'.
	 * @see hub.sam.dbl.Constructor
	 * @generated
	 */
	EClass getConstructor();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Constructor#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see hub.sam.dbl.Constructor#getParameters()
	 * @see #getConstructor()
	 * @generated
	 */
	EReference getConstructor_Parameters();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ClassAugment <em>Class Augment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Augment</em>'.
	 * @see hub.sam.dbl.ClassAugment
	 * @generated
	 */
	EClass getClassAugment();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.ClassAugment#getAugmentedClass <em>Augmented Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Augmented Class</em>'.
	 * @see hub.sam.dbl.ClassAugment#getAugmentedClass()
	 * @see #getClassAugment()
	 * @generated
	 */
	EReference getClassAugment_AugmentedClass();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable</em>'.
	 * @see hub.sam.dbl.AbstractVariable
	 * @generated
	 */
	EClass getAbstractVariable();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see hub.sam.dbl.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Variable#isControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control</em>'.
	 * @see hub.sam.dbl.Variable#isControl()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Control();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Variable#isClazz <em>Clazz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clazz</em>'.
	 * @see hub.sam.dbl.Variable#isClazz()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Clazz();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Variable#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see hub.sam.dbl.Variable#getInitialValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_InitialValue();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see hub.sam.dbl.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see hub.sam.dbl.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see hub.sam.dbl.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see hub.sam.dbl.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.LoopStatement <em>Loop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Statement</em>'.
	 * @see hub.sam.dbl.LoopStatement
	 * @generated
	 */
	EClass getLoopStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SimpleStatement <em>Simple Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Statement</em>'.
	 * @see hub.sam.dbl.SimpleStatement
	 * @generated
	 */
	EClass getSimpleStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see hub.sam.dbl.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Assignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see hub.sam.dbl.Assignment#getVariable()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see hub.sam.dbl.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ProcedureCall <em>Procedure Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure Call</em>'.
	 * @see hub.sam.dbl.ProcedureCall
	 * @generated
	 */
	EClass getProcedureCall();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ProcedureCall#getCallIdExpr <em>Call Id Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Id Expr</em>'.
	 * @see hub.sam.dbl.ProcedureCall#getCallIdExpr()
	 * @see #getProcedureCall()
	 * @generated
	 */
	EReference getProcedureCall_CallIdExpr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return</em>'.
	 * @see hub.sam.dbl.Return
	 * @generated
	 */
	EClass getReturn();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Return#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see hub.sam.dbl.Return#getValue()
	 * @see #getReturn()
	 * @generated
	 */
	EReference getReturn_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.WaitUntil <em>Wait Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Until</em>'.
	 * @see hub.sam.dbl.WaitUntil
	 * @generated
	 */
	EClass getWaitUntil();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.WaitUntil#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see hub.sam.dbl.WaitUntil#getCondition()
	 * @see #getWaitUntil()
	 * @generated
	 */
	EReference getWaitUntil_Condition();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Terminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate</em>'.
	 * @see hub.sam.dbl.Terminate
	 * @generated
	 */
	EClass getTerminate();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Yield <em>Yield</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Yield</em>'.
	 * @see hub.sam.dbl.Yield
	 * @generated
	 */
	EClass getYield();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Wait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait</em>'.
	 * @see hub.sam.dbl.Wait
	 * @generated
	 */
	EClass getWait();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Reactivate <em>Reactivate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reactivate</em>'.
	 * @see hub.sam.dbl.Reactivate
	 * @generated
	 */
	EClass getReactivate();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Reactivate#getObjectAccess <em>Object Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object Access</em>'.
	 * @see hub.sam.dbl.Reactivate#getObjectAccess()
	 * @see #getReactivate()
	 * @generated
	 */
	EReference getReactivate_ObjectAccess();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ActivateObject <em>Activate Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activate Object</em>'.
	 * @see hub.sam.dbl.ActivateObject
	 * @generated
	 */
	EClass getActivateObject();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ActivateObject#getObjectAccess <em>Object Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object Access</em>'.
	 * @see hub.sam.dbl.ActivateObject#getObjectAccess()
	 * @see #getActivateObject()
	 * @generated
	 */
	EReference getActivateObject_ObjectAccess();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ActivateObject#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see hub.sam.dbl.ActivateObject#getPriority()
	 * @see #getActivateObject()
	 * @generated
	 */
	EAttribute getActivateObject_Priority();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Advance <em>Advance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advance</em>'.
	 * @see hub.sam.dbl.Advance
	 * @generated
	 */
	EClass getAdvance();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Advance#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time</em>'.
	 * @see hub.sam.dbl.Advance#getTime()
	 * @see #getAdvance()
	 * @generated
	 */
	EReference getAdvance_Time();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print</em>'.
	 * @see hub.sam.dbl.Print
	 * @generated
	 */
	EClass getPrint();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Print#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see hub.sam.dbl.Print#getOutputs()
	 * @see #getPrint()
	 * @generated
	 */
	EReference getPrint_Outputs();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see hub.sam.dbl.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.IfStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see hub.sam.dbl.IfStatement#getCondition()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.IfStatement#getTrueCase <em>True Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Case</em>'.
	 * @see hub.sam.dbl.IfStatement#getTrueCase()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_TrueCase();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.IfStatement#getFalseCase <em>False Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Case</em>'.
	 * @see hub.sam.dbl.IfStatement#getFalseCase()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_FalseCase();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.LocalScope <em>Local Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Scope</em>'.
	 * @see hub.sam.dbl.LocalScope
	 * @generated
	 */
	EClass getLocalScope();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.LocalScope#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see hub.sam.dbl.LocalScope#getStatements()
	 * @see #getLocalScope()
	 * @generated
	 */
	EReference getLocalScope_Statements();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.LocalScopeStatement <em>Local Scope Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Scope Statement</em>'.
	 * @see hub.sam.dbl.LocalScopeStatement
	 * @generated
	 */
	EClass getLocalScopeStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see hub.sam.dbl.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ForStatement#getTermination <em>Termination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Termination</em>'.
	 * @see hub.sam.dbl.ForStatement#getTermination()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Termination();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ForStatement#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Increment</em>'.
	 * @see hub.sam.dbl.ForStatement#getIncrement()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Increment();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ForStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see hub.sam.dbl.ForStatement#getBody()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Body();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Statement</em>'.
	 * @see hub.sam.dbl.WhileStatement
	 * @generated
	 */
	EClass getWhileStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.WhileStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see hub.sam.dbl.WhileStatement#getCondition()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.WhileStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see hub.sam.dbl.WhileStatement#getBody()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Body();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Statement</em>'.
	 * @see hub.sam.dbl.SwitchStatement
	 * @generated
	 */
	EClass getSwitchStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.SwitchStatement#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see hub.sam.dbl.SwitchStatement#getVariable()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.SwitchStatement#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see hub.sam.dbl.SwitchStatement#getCases()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.SwitchStatement#getDefaultCase <em>Default Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Case</em>'.
	 * @see hub.sam.dbl.SwitchStatement#getDefaultCase()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_DefaultCase();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SwitchCase <em>Switch Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Case</em>'.
	 * @see hub.sam.dbl.SwitchCase
	 * @generated
	 */
	EClass getSwitchCase();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.SwitchCase#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see hub.sam.dbl.SwitchCase#getValue()
	 * @see #getSwitchCase()
	 * @generated
	 */
	EReference getSwitchCase_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.SwitchCase#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see hub.sam.dbl.SwitchCase#getBody()
	 * @see #getSwitchCase()
	 * @generated
	 */
	EReference getSwitchCase_Body();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Statement</em>'.
	 * @see hub.sam.dbl.BreakStatement
	 * @generated
	 */
	EClass getBreakStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Statement</em>'.
	 * @see hub.sam.dbl.ContinueStatement
	 * @generated
	 */
	EClass getContinueStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see hub.sam.dbl.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L1Expr <em>L1 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L1 Expr</em>'.
	 * @see hub.sam.dbl.L1Expr
	 * @generated
	 */
	EClass getL1Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L2Expr <em>L2 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2 Expr</em>'.
	 * @see hub.sam.dbl.L2Expr
	 * @generated
	 */
	EClass getL2Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L3Expr <em>L3 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L3 Expr</em>'.
	 * @see hub.sam.dbl.L3Expr
	 * @generated
	 */
	EClass getL3Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L4Expr <em>L4 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L4 Expr</em>'.
	 * @see hub.sam.dbl.L4Expr
	 * @generated
	 */
	EClass getL4Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L5Expr <em>L5 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L5 Expr</em>'.
	 * @see hub.sam.dbl.L5Expr
	 * @generated
	 */
	EClass getL5Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L6Expr <em>L6 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L6 Expr</em>'.
	 * @see hub.sam.dbl.L6Expr
	 * @generated
	 */
	EClass getL6Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L7Expr <em>L7 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L7 Expr</em>'.
	 * @see hub.sam.dbl.L7Expr
	 * @generated
	 */
	EClass getL7Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L8Expr <em>L8 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L8 Expr</em>'.
	 * @see hub.sam.dbl.L8Expr
	 * @generated
	 */
	EClass getL8Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L9Expr <em>L9 Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L9 Expr</em>'.
	 * @see hub.sam.dbl.L9Expr
	 * @generated
	 */
	EClass getL9Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operator</em>'.
	 * @see hub.sam.dbl.BinaryOperator
	 * @generated
	 */
	EClass getBinaryOperator();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.BinaryOperator#getOp1 <em>Op1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Op1</em>'.
	 * @see hub.sam.dbl.BinaryOperator#getOp1()
	 * @see #getBinaryOperator()
	 * @generated
	 */
	EReference getBinaryOperator_Op1();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.BinaryOperator#getOp2 <em>Op2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Op2</em>'.
	 * @see hub.sam.dbl.BinaryOperator#getOp2()
	 * @see #getBinaryOperator()
	 * @generated
	 */
	EReference getBinaryOperator_Op2();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Operator</em>'.
	 * @see hub.sam.dbl.UnaryOperator
	 * @generated
	 */
	EClass getUnaryOperator();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.UnaryOperator#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Op</em>'.
	 * @see hub.sam.dbl.UnaryOperator#getOp()
	 * @see #getUnaryOperator()
	 * @generated
	 */
	EReference getUnaryOperator_Op();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see hub.sam.dbl.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see hub.sam.dbl.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Greater <em>Greater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater</em>'.
	 * @see hub.sam.dbl.Greater
	 * @generated
	 */
	EClass getGreater();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.GreaterEqual <em>Greater Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Equal</em>'.
	 * @see hub.sam.dbl.GreaterEqual
	 * @generated
	 */
	EClass getGreaterEqual();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Less <em>Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less</em>'.
	 * @see hub.sam.dbl.Less
	 * @generated
	 */
	EClass getLess();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.LessEqual <em>Less Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Equal</em>'.
	 * @see hub.sam.dbl.LessEqual
	 * @generated
	 */
	EClass getLessEqual();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.NotEqual <em>Not Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Equal</em>'.
	 * @see hub.sam.dbl.NotEqual
	 * @generated
	 */
	EClass getNotEqual();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal</em>'.
	 * @see hub.sam.dbl.Equal
	 * @generated
	 */
	EClass getEqual();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.InstanceOf <em>Instance Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Of</em>'.
	 * @see hub.sam.dbl.InstanceOf
	 * @generated
	 */
	EClass getInstanceOf();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see hub.sam.dbl.Plus
	 * @generated
	 */
	EClass getPlus();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus</em>'.
	 * @see hub.sam.dbl.Minus
	 * @generated
	 */
	EClass getMinus();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Mul <em>Mul</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mul</em>'.
	 * @see hub.sam.dbl.Mul
	 * @generated
	 */
	EClass getMul();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Mod <em>Mod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mod</em>'.
	 * @see hub.sam.dbl.Mod
	 * @generated
	 */
	EClass getMod();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Div <em>Div</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Div</em>'.
	 * @see hub.sam.dbl.Div
	 * @generated
	 */
	EClass getDiv();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Neg <em>Neg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Neg</em>'.
	 * @see hub.sam.dbl.Neg
	 * @generated
	 */
	EClass getNeg();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see hub.sam.dbl.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Cast <em>Cast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cast</em>'.
	 * @see hub.sam.dbl.Cast
	 * @generated
	 */
	EClass getCast();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.CreateObject <em>Create Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Object</em>'.
	 * @see hub.sam.dbl.CreateObject
	 * @generated
	 */
	EClass getCreateObject();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal</em>'.
	 * @see hub.sam.dbl.NullLiteral
	 * @generated
	 */
	EClass getNullLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TimeLiteral <em>Time Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Literal</em>'.
	 * @see hub.sam.dbl.TimeLiteral
	 * @generated
	 */
	EClass getTimeLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ActiveLiteral <em>Active Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Literal</em>'.
	 * @see hub.sam.dbl.ActiveLiteral
	 * @generated
	 */
	EClass getActiveLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see hub.sam.dbl.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.dbl.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Literal</em>'.
	 * @see hub.sam.dbl.IntLiteral
	 * @generated
	 */
	EClass getIntLiteral();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.IntLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.dbl.IntLiteral#getValue()
	 * @see #getIntLiteral()
	 * @generated
	 */
	EAttribute getIntLiteral_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TrueLiteral <em>True Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Literal</em>'.
	 * @see hub.sam.dbl.TrueLiteral
	 * @generated
	 */
	EClass getTrueLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.FalseLiteral <em>False Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Literal</em>'.
	 * @see hub.sam.dbl.FalseLiteral
	 * @generated
	 */
	EClass getFalseLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see hub.sam.dbl.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.dbl.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpandExpr <em>Expand Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Expr</em>'.
	 * @see hub.sam.dbl.ExpandExpr
	 * @generated
	 */
	EClass getExpandExpr();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExpandExpr#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see hub.sam.dbl.ExpandExpr#getExpr()
	 * @see #getExpandExpr()
	 * @generated
	 */
	EReference getExpandExpr_Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ParseExpr <em>Parse Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parse Expr</em>'.
	 * @see hub.sam.dbl.ParseExpr
	 * @generated
	 */
	EClass getParseExpr();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ParseExpr#getAstPart <em>Ast Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ast Part</em>'.
	 * @see hub.sam.dbl.ParseExpr#getAstPart()
	 * @see #getParseExpr()
	 * @generated
	 */
	EReference getParseExpr_AstPart();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.PredefinedId <em>Predefined Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predefined Id</em>'.
	 * @see hub.sam.dbl.PredefinedId
	 * @generated
	 */
	EClass getPredefinedId();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MeLiteral <em>Me Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Me Literal</em>'.
	 * @see hub.sam.dbl.MeLiteral
	 * @generated
	 */
	EClass getMeLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SuperLiteral <em>Super Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Literal</em>'.
	 * @see hub.sam.dbl.SuperLiteral
	 * @generated
	 */
	EClass getSuperLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MetaLiteral <em>Meta Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Literal</em>'.
	 * @see hub.sam.dbl.MetaLiteral
	 * @generated
	 */
	EClass getMetaLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal</em>'.
	 * @see hub.sam.dbl.TypeLiteral
	 * @generated
	 */
	EClass getTypeLiteral();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SizeOfArray <em>Size Of Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Size Of Array</em>'.
	 * @see hub.sam.dbl.SizeOfArray
	 * @generated
	 */
	EClass getSizeOfArray();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IdExpr <em>Id Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Expr</em>'.
	 * @see hub.sam.dbl.IdExpr
	 * @generated
	 */
	EClass getIdExpr();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.IdExpr#getParentIdExpr <em>Parent Id Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent Id Expr</em>'.
	 * @see hub.sam.dbl.IdExpr#getParentIdExpr()
	 * @see #getIdExpr()
	 * @generated
	 */
	EReference getIdExpr_ParentIdExpr();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.IdExpr#getReferencedElement <em>Referenced Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Element</em>'.
	 * @see hub.sam.dbl.IdExpr#getReferencedElement()
	 * @see #getIdExpr()
	 * @generated
	 */
	EReference getIdExpr_ReferencedElement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.IdExpr#getPredefinedId <em>Predefined Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predefined Id</em>'.
	 * @see hub.sam.dbl.IdExpr#getPredefinedId()
	 * @see #getIdExpr()
	 * @generated
	 */
	EReference getIdExpr_PredefinedId();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.IdExpr#getArrayIndex <em>Array Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Index</em>'.
	 * @see hub.sam.dbl.IdExpr#getArrayIndex()
	 * @see #getIdExpr()
	 * @generated
	 */
	EReference getIdExpr_ArrayIndex();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.IdExpr#getCallPart <em>Call Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Part</em>'.
	 * @see hub.sam.dbl.IdExpr#getCallPart()
	 * @see #getIdExpr()
	 * @generated
	 */
	EReference getIdExpr_CallPart();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.CallPart <em>Call Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Part</em>'.
	 * @see hub.sam.dbl.CallPart
	 * @generated
	 */
	EClass getCallPart();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.CallPart#getCallArguments <em>Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Call Arguments</em>'.
	 * @see hub.sam.dbl.CallPart#getCallArguments()
	 * @see #getCallPart()
	 * @generated
	 */
	EReference getCallPart_CallArguments();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ElementAccess <em>Element Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Access</em>'.
	 * @see hub.sam.dbl.ElementAccess
	 * @generated
	 */
	EClass getElementAccess();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ElementAccess#getIdExpr <em>Id Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id Expr</em>'.
	 * @see hub.sam.dbl.ElementAccess#getIdExpr()
	 * @see #getElementAccess()
	 * @generated
	 */
	EReference getElementAccess_IdExpr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Access</em>'.
	 * @see hub.sam.dbl.VariableAccess
	 * @generated
	 */
	EClass getVariableAccess();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MetaAccess <em>Meta Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Access</em>'.
	 * @see hub.sam.dbl.MetaAccess
	 * @generated
	 */
	EClass getMetaAccess();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TypeAccess <em>Type Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Access</em>'.
	 * @see hub.sam.dbl.TypeAccess
	 * @generated
	 */
	EClass getTypeAccess();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ClassContentExtension <em>Class Content Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Content Extension</em>'.
	 * @see hub.sam.dbl.ClassContentExtension
	 * @generated
	 */
	EClass getClassContentExtension();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ModuleContentExtension <em>Module Content Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Content Extension</em>'.
	 * @see hub.sam.dbl.ModuleContentExtension
	 * @generated
	 */
	EClass getModuleContentExtension();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExtensionDefinition <em>Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Definition</em>'.
	 * @see hub.sam.dbl.ExtensionDefinition
	 * @generated
	 */
	EClass getExtensionDefinition();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.ExtensionDefinition#getExtendedConcept <em>Extended Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Concept</em>'.
	 * @see hub.sam.dbl.ExtensionDefinition#getExtendedConcept()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_ExtendedConcept();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ExtensionDefinition#getAbstractSyntaxDef <em>Abstract Syntax Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract Syntax Def</em>'.
	 * @see hub.sam.dbl.ExtensionDefinition#getAbstractSyntaxDef()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_AbstractSyntaxDef();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExtensionDefinition#getTextualSyntaxDef <em>Textual Syntax Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Textual Syntax Def</em>'.
	 * @see hub.sam.dbl.ExtensionDefinition#getTextualSyntaxDef()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_TextualSyntaxDef();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExtensionDefinition#getMappingDef <em>Mapping Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Def</em>'.
	 * @see hub.sam.dbl.ExtensionDefinition#getMappingDef()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_MappingDef();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TextualSyntaxDef <em>Textual Syntax Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Textual Syntax Def</em>'.
	 * @see hub.sam.dbl.TextualSyntaxDef
	 * @generated
	 */
	EClass getTextualSyntaxDef();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.TextualSyntaxDef#getStartRule <em>Start Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Rule</em>'.
	 * @see hub.sam.dbl.TextualSyntaxDef#getStartRule()
	 * @see #getTextualSyntaxDef()
	 * @generated
	 */
	EReference getTextualSyntaxDef_StartRule();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.TextualSyntaxDef#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see hub.sam.dbl.TextualSyntaxDef#getRules()
	 * @see #getTextualSyntaxDef()
	 * @generated
	 */
	EReference getTextualSyntaxDef_Rules();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.LanguageConstructClassifier <em>Language Construct Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Construct Classifier</em>'.
	 * @see hub.sam.dbl.LanguageConstructClassifier
	 * @generated
	 */
	EClass getLanguageConstructClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.LanguageConceptClassifier <em>Language Concept Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Concept Classifier</em>'.
	 * @see hub.sam.dbl.LanguageConceptClassifier
	 * @generated
	 */
	EClass getLanguageConceptClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TsRule <em>Ts Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ts Rule</em>'.
	 * @see hub.sam.dbl.TsRule
	 * @generated
	 */
	EClass getTsRule();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.TsRule#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see hub.sam.dbl.TsRule#getRhs()
	 * @see #getTsRule()
	 * @generated
	 */
	EReference getTsRule_Rhs();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.RhsExpression <em>Rhs Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhs Expression</em>'.
	 * @see hub.sam.dbl.RhsExpression
	 * @generated
	 */
	EClass getRhsExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L3RhsExpr <em>L3 Rhs Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L3 Rhs Expr</em>'.
	 * @see hub.sam.dbl.L3RhsExpr
	 * @generated
	 */
	EClass getL3RhsExpr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L2RhsExpr <em>L2 Rhs Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2 Rhs Expr</em>'.
	 * @see hub.sam.dbl.L2RhsExpr
	 * @generated
	 */
	EClass getL2RhsExpr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SequenceExpr <em>Sequence Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Expr</em>'.
	 * @see hub.sam.dbl.SequenceExpr
	 * @generated
	 */
	EClass getSequenceExpr();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.SequenceExpr#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequence</em>'.
	 * @see hub.sam.dbl.SequenceExpr#getSequence()
	 * @see #getSequenceExpr()
	 * @generated
	 */
	EReference getSequenceExpr_Sequence();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L1RhsExpr <em>L1 Rhs Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L1 Rhs Expr</em>'.
	 * @see hub.sam.dbl.L1RhsExpr
	 * @generated
	 */
	EClass getL1RhsExpr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TerminalExpr <em>Terminal Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal Expr</em>'.
	 * @see hub.sam.dbl.TerminalExpr
	 * @generated
	 */
	EClass getTerminalExpr();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.TerminalExpr#getTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal</em>'.
	 * @see hub.sam.dbl.TerminalExpr#getTerminal()
	 * @see #getTerminalExpr()
	 * @generated
	 */
	EAttribute getTerminalExpr_Terminal();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.PropertyBindingExpr <em>Property Binding Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Binding Expr</em>'.
	 * @see hub.sam.dbl.PropertyBindingExpr
	 * @generated
	 */
	EClass getPropertyBindingExpr();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.PropertyBindingExpr#getPropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property Type</em>'.
	 * @see hub.sam.dbl.PropertyBindingExpr#getPropertyType()
	 * @see #getPropertyBindingExpr()
	 * @generated
	 */
	EReference getPropertyBindingExpr_PropertyType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.RhsClassifierExpr <em>Rhs Classifier Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rhs Classifier Expr</em>'.
	 * @see hub.sam.dbl.RhsClassifierExpr
	 * @generated
	 */
	EClass getRhsClassifierExpr();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.RhsClassifierExpr#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see hub.sam.dbl.RhsClassifierExpr#getClassifier()
	 * @see #getRhsClassifierExpr()
	 * @generated
	 */
	EReference getRhsClassifierExpr_Classifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Type</em>'.
	 * @see hub.sam.dbl.PropertyType
	 * @generated
	 */
	EClass getPropertyType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IdPropertyType <em>Id Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Property Type</em>'.
	 * @see hub.sam.dbl.IdPropertyType
	 * @generated
	 */
	EClass getIdPropertyType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IntPropertyType <em>Int Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Property Type</em>'.
	 * @see hub.sam.dbl.IntPropertyType
	 * @generated
	 */
	EClass getIntPropertyType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.StringPropertyType <em>String Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Property Type</em>'.
	 * @see hub.sam.dbl.StringPropertyType
	 * @generated
	 */
	EClass getStringPropertyType();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.BooleanPropertyType <em>Boolean Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Property Type</em>'.
	 * @see hub.sam.dbl.BooleanPropertyType
	 * @generated
	 */
	EClass getBooleanPropertyType();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.BooleanPropertyType#getTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal</em>'.
	 * @see hub.sam.dbl.BooleanPropertyType#getTerminal()
	 * @see #getBooleanPropertyType()
	 * @generated
	 */
	EAttribute getBooleanPropertyType_Terminal();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.StructuredPropertyType <em>Structured Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Property Type</em>'.
	 * @see hub.sam.dbl.StructuredPropertyType
	 * @generated
	 */
	EClass getStructuredPropertyType();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.StructuredPropertyType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see hub.sam.dbl.StructuredPropertyType#getType()
	 * @see #getStructuredPropertyType()
	 * @generated
	 */
	EReference getStructuredPropertyType_Type();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.CompositePropertyType <em>Composite Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Property Type</em>'.
	 * @see hub.sam.dbl.CompositePropertyType
	 * @generated
	 */
	EClass getCompositePropertyType();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.CompositePropertyType#isList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List</em>'.
	 * @see hub.sam.dbl.CompositePropertyType#isList()
	 * @see #getCompositePropertyType()
	 * @generated
	 */
	EAttribute getCompositePropertyType_List();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ReferencePropertyType <em>Reference Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Property Type</em>'.
	 * @see hub.sam.dbl.ReferencePropertyType
	 * @generated
	 */
	EClass getReferencePropertyType();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ReferencePropertyType#isRawReference <em>Raw Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Reference</em>'.
	 * @see hub.sam.dbl.ReferencePropertyType#isRawReference()
	 * @see #getReferencePropertyType()
	 * @generated
	 */
	EAttribute getReferencePropertyType_RawReference();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see hub.sam.dbl.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Mapping#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see hub.sam.dbl.Mapping#getParts()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Parts();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Mapping#getMetaObject <em>Meta Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta Object</em>'.
	 * @see hub.sam.dbl.Mapping#getMetaObject()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_MetaObject();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MappingPart <em>Mapping Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Part</em>'.
	 * @see hub.sam.dbl.MappingPart
	 * @generated
	 */
	EClass getMappingPart();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MetaExpr <em>Meta Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Expr</em>'.
	 * @see hub.sam.dbl.MetaExpr
	 * @generated
	 */
	EClass getMetaExpr();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.MetaExpr#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see hub.sam.dbl.MetaExpr#getExpr()
	 * @see #getMetaExpr()
	 * @generated
	 */
	EReference getMetaExpr_Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TargetStatement <em>Target Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Statement</em>'.
	 * @see hub.sam.dbl.TargetStatement
	 * @generated
	 */
	EClass getTargetStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.TargetStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see hub.sam.dbl.TargetStatement#getBody()
	 * @see #getTargetStatement()
	 * @generated
	 */
	EReference getTargetStatement_Body();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MappingStatement <em>Mapping Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Statement</em>'.
	 * @see hub.sam.dbl.MappingStatement
	 * @generated
	 */
	EClass getMappingStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.MappingStatement#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see hub.sam.dbl.MappingStatement#getParts()
	 * @see #getMappingStatement()
	 * @generated
	 */
	EReference getMappingStatement_Parts();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.MappingStatement#getExprs <em>Exprs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exprs</em>'.
	 * @see hub.sam.dbl.MappingStatement#getExprs()
	 * @see #getMappingStatement()
	 * @generated
	 */
	EReference getMappingStatement_Exprs();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SetGenContextStatement <em>Set Gen Context Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Gen Context Statement</em>'.
	 * @see hub.sam.dbl.SetGenContextStatement
	 * @generated
	 */
	EClass getSetGenContextStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.SetGenContextStatement#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see hub.sam.dbl.SetGenContextStatement#getContext()
	 * @see #getSetGenContextStatement()
	 * @generated
	 */
	EReference getSetGenContextStatement_Context();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.SetGenContextStatement#isAddAfterContext <em>Add After Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add After Context</em>'.
	 * @see hub.sam.dbl.SetGenContextStatement#isAddAfterContext()
	 * @see #getSetGenContextStatement()
	 * @generated
	 */
	EAttribute getSetGenContextStatement_AddAfterContext();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ResetGenContextStatement <em>Reset Gen Context Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reset Gen Context Statement</em>'.
	 * @see hub.sam.dbl.ResetGenContextStatement
	 * @generated
	 */
	EClass getResetGenContextStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SaveGenStatement <em>Save Gen Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Save Gen Statement</em>'.
	 * @see hub.sam.dbl.SaveGenStatement
	 * @generated
	 */
	EClass getSaveGenStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.SaveGenStatement#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see hub.sam.dbl.SaveGenStatement#getVariable()
	 * @see #getSaveGenStatement()
	 * @generated
	 */
	EReference getSaveGenStatement_Variable();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ResumeGenStatement <em>Resume Gen Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resume Gen Statement</em>'.
	 * @see hub.sam.dbl.ResumeGenStatement
	 * @generated
	 */
	EClass getResumeGenStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ResumeGenStatement#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see hub.sam.dbl.ResumeGenStatement#getVariable()
	 * @see #getResumeGenStatement()
	 * @generated
	 */
	EReference getResumeGenStatement_Variable();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.FixedMappingPart <em>Fixed Mapping Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Mapping Part</em>'.
	 * @see hub.sam.dbl.FixedMappingPart
	 * @generated
	 */
	EClass getFixedMappingPart();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.FixedMappingPart#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see hub.sam.dbl.FixedMappingPart#getCode()
	 * @see #getFixedMappingPart()
	 * @generated
	 */
	EAttribute getFixedMappingPart_Code();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.DynamicMappingPart <em>Dynamic Mapping Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Mapping Part</em>'.
	 * @see hub.sam.dbl.DynamicMappingPart
	 * @generated
	 */
	EClass getDynamicMappingPart();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.DynamicMappingPart#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see hub.sam.dbl.DynamicMappingPart#getExpr()
	 * @see #getDynamicMappingPart()
	 * @generated
	 */
	EReference getDynamicMappingPart_Expr();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpandExpression <em>Expand Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Expression</em>'.
	 * @see hub.sam.dbl.ExpandExpression
	 * @generated
	 */
	EClass getExpandExpression();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExpandExpression#getMetaObject <em>Meta Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta Object</em>'.
	 * @see hub.sam.dbl.ExpandExpression#getMetaObject()
	 * @see #getExpandExpression()
	 * @generated
	 */
	EReference getExpandExpression_MetaObject();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpandStatement <em>Expand Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Statement</em>'.
	 * @see hub.sam.dbl.ExpandStatement
	 * @generated
	 */
	EClass getExpandStatement();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExpandStatement#getMetaObject <em>Meta Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta Object</em>'.
	 * @see hub.sam.dbl.ExpandStatement#getMetaObject()
	 * @see #getExpandStatement()
	 * @generated
	 */
	EReference getExpandStatement_MetaObject();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExpandStatement#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see hub.sam.dbl.ExpandStatement#getLocation()
	 * @see #getExpandStatement()
	 * @generated
	 */
	EReference getExpandStatement_Location();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.CodeQuoteExpression <em>Code Quote Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Quote Expression</em>'.
	 * @see hub.sam.dbl.CodeQuoteExpression
	 * @generated
	 */
	EClass getCodeQuoteExpression();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.CodeQuoteExpression#getQuotedCode <em>Quoted Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Quoted Code</em>'.
	 * @see hub.sam.dbl.CodeQuoteExpression#getQuotedCode()
	 * @see #getCodeQuoteExpression()
	 * @generated
	 */
	EReference getCodeQuoteExpression_QuotedCode();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.QuotedCode <em>Quoted Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Code</em>'.
	 * @see hub.sam.dbl.QuotedCode
	 * @generated
	 */
	EClass getQuotedCode();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.QuotedExpression <em>Quoted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Expression</em>'.
	 * @see hub.sam.dbl.QuotedExpression
	 * @generated
	 */
	EClass getQuotedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.QuotedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see hub.sam.dbl.QuotedExpression#getExpression()
	 * @see #getQuotedExpression()
	 * @generated
	 */
	EReference getQuotedExpression_Expression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.QuotedStatements <em>Quoted Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Statements</em>'.
	 * @see hub.sam.dbl.QuotedStatements
	 * @generated
	 */
	EClass getQuotedStatements();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.QuotedStatements#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see hub.sam.dbl.QuotedStatements#getStatements()
	 * @see #getQuotedStatements()
	 * @generated
	 */
	EReference getQuotedStatements_Statements();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.QuotedClassContent <em>Quoted Class Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Class Content</em>'.
	 * @see hub.sam.dbl.QuotedClassContent
	 * @generated
	 */
	EClass getQuotedClassContent();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.QuotedModuleContent <em>Quoted Module Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Module Content</em>'.
	 * @see hub.sam.dbl.QuotedModuleContent
	 * @generated
	 */
	EClass getQuotedModuleContent();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see hub.sam.dbl.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Pattern#isTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see hub.sam.dbl.Pattern#isTop()
	 * @see #getPattern()
	 * @generated
	 */
	EAttribute getPattern_Top();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Pattern#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see hub.sam.dbl.Pattern#getContext()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Context();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Pattern#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see hub.sam.dbl.Pattern#getBody()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Body();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.TestStatement <em>Test Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Statement</em>'.
	 * @see hub.sam.dbl.TestStatement
	 * @generated
	 */
	EClass getTestStatement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.TestStatement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.dbl.TestStatement#getValue()
	 * @see #getTestStatement()
	 * @generated
	 */
	EAttribute getTestStatement_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DblFactory getDblFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ConstructImpl <em>Construct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ConstructImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getConstruct()
		 * @generated
		 */
		EClass CONSTRUCT = eINSTANCE.getConstruct();

		/**
		 * The meta object literal for the '<em><b>Expand Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCT__EXPAND_EXPR = eINSTANCE.getConstruct_ExpandExpr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExtensibleElementImpl <em>Extensible Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExtensibleElementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExtensibleElement()
		 * @generated
		 */
		EClass EXTENSIBLE_ELEMENT = eINSTANCE.getExtensibleElement();

		/**
		 * The meta object literal for the '<em><b>Concrete Syntax</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX = eINSTANCE.getExtensibleElement_ConcreteSyntax();

		/**
		 * The meta object literal for the '<em><b>Instance Of Extension Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION = eINSTANCE.getExtensibleElement_InstanceOfExtensionDefinition();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ModelImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__MODULES = eINSTANCE.getModel_Modules();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ImportImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__FILE = eINSTANCE.getImport_File();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__MODEL = eINSTANCE.getImport_Model();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ModuleImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Classifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CLASSIFIERS = eINSTANCE.getModule_Classifiers();

		/**
		 * The meta object literal for the '<em><b>Class Augments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CLASS_AUGMENTS = eINSTANCE.getModule_ClassAugments();

		/**
		 * The meta object literal for the '<em><b>Extension Defs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__EXTENSION_DEFS = eINSTANCE.getModule_ExtensionDefs();

		/**
		 * The meta object literal for the '<em><b>Procedures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__PROCEDURES = eINSTANCE.getModule_Procedures();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__VARIABLES = eINSTANCE.getModule_Variables();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.EmbeddableExtensionsContainerImpl <em>Embeddable Extensions Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.EmbeddableExtensionsContainerImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getEmbeddableExtensionsContainer()
		 * @generated
		 */
		EClass EMBEDDABLE_EXTENSIONS_CONTAINER = eINSTANCE.getEmbeddableExtensionsContainer();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMBEDDABLE_EXTENSIONS_CONTAINER__EXTENSIONS = eINSTANCE.getEmbeddableExtensionsContainer_Extensions();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ModifierExtensionsContainerImpl <em>Modifier Extensions Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ModifierExtensionsContainerImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getModifierExtensionsContainer()
		 * @generated
		 */
		EClass MODIFIER_EXTENSIONS_CONTAINER = eINSTANCE.getModifierExtensionsContainer();

		/**
		 * The meta object literal for the '<em><b>Modifier Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFIER_EXTENSIONS_CONTAINER__MODIFIER_EXTENSIONS = eINSTANCE.getModifierExtensionsContainer_ModifierExtensions();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Array Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__ARRAY_DIMENSIONS = eINSTANCE.getType_ArrayDimensions();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TypedElementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Primitive Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__PRIMITIVE_TYPE = eINSTANCE.getTypedElement_PrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Type Array Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE_ARRAY_DIMENSIONS = eINSTANCE.getTypedElement_TypeArrayDimensions();

		/**
		 * The meta object literal for the '<em><b>Classifier Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__CLASSIFIER_TYPE = eINSTANCE.getTypedElement_ClassifierType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ArrayDimensionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getArrayDimension()
		 * @generated
		 */
		EClass ARRAY_DIMENSION = eINSTANCE.getArrayDimension();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_DIMENSION__SIZE = eINSTANCE.getArrayDimension_Size();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PrimitiveTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.VoidTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IntTypeImpl <em>Int Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IntTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIntType()
		 * @generated
		 */
		EClass INT_TYPE = eINSTANCE.getIntType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.BoolTypeImpl <em>Bool Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.BoolTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getBoolType()
		 * @generated
		 */
		EClass BOOL_TYPE = eINSTANCE.getBoolType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.DoubleTypeImpl <em>Double Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.DoubleTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getDoubleType()
		 * @generated
		 */
		EClass DOUBLE_TYPE = eINSTANCE.getDoubleType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StringTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ProcedureImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__PARAMETERS = eINSTANCE.getProcedure_Parameters();

		/**
		 * The meta object literal for the '<em><b>Clazz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE__CLAZZ = eINSTANCE.getProcedure_Clazz();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE__ABSTRACT = eINSTANCE.getProcedure_Abstract();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassifierImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.NativeBindingImpl <em>Native Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.NativeBindingImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getNativeBinding()
		 * @generated
		 */
		EClass NATIVE_BINDING = eINSTANCE.getNativeBinding();

		/**
		 * The meta object literal for the '<em><b>Target Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NATIVE_BINDING__TARGET_LANGUAGE = eINSTANCE.getNativeBinding_TargetLanguage();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NATIVE_BINDING__TARGET_TYPE = eINSTANCE.getNativeBinding_TargetType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassSimilarImpl <em>Class Similar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassSimilarImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClassSimilar()
		 * @generated
		 */
		EClass CLASS_SIMILAR = eINSTANCE.getClassSimilar();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__ATTRIBUTES = eINSTANCE.getClassSimilar_Attributes();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__METHODS = eINSTANCE.getClassSimilar_Methods();

		/**
		 * The meta object literal for the '<em><b>Super Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__SUPER_CLASSES = eINSTANCE.getClassSimilar_SuperClasses();

		/**
		 * The meta object literal for the '<em><b>Initial Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__INITIAL_BLOCK = eINSTANCE.getClassSimilar_InitialBlock();

		/**
		 * The meta object literal for the '<em><b>Final Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__FINAL_BLOCK = eINSTANCE.getClassSimilar_FinalBlock();

		/**
		 * The meta object literal for the '<em><b>Actions Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__ACTIONS_BLOCK = eINSTANCE.getClassSimilar_ActionsBlock();

		/**
		 * The meta object literal for the '<em><b>Report Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__REPORT_BLOCK = eINSTANCE.getClassSimilar_ReportBlock();

		/**
		 * The meta object literal for the '<em><b>Clear Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SIMILAR__CLEAR_BLOCK = eINSTANCE.getClassSimilar_ClearBlock();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassPartImpl <em>Class Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClassPart()
		 * @generated
		 */
		EClass CLASS_PART = eINSTANCE.getClassPart();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SuperClassSpecificationImpl <em>Super Class Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SuperClassSpecificationImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSuperClassSpecification()
		 * @generated
		 */
		EClass SUPER_CLASS_SPECIFICATION = eINSTANCE.getSuperClassSpecification();

		/**
		 * The meta object literal for the '<em><b>Clazz</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPER_CLASS_SPECIFICATION__CLAZZ = eINSTANCE.getSuperClassSpecification_Clazz();

		/**
		 * The meta object literal for the '<em><b>Constructor Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS = eINSTANCE.getSuperClassSpecification_ConstructorArguments();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClazzImpl <em>Clazz</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClazzImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClazz()
		 * @generated
		 */
		EClass CLAZZ = eINSTANCE.getClazz();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLAZZ__ACTIVE = eINSTANCE.getClazz_Active();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAZZ__CONSTRUCTOR = eINSTANCE.getClazz_Constructor();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAZZ__BINDINGS = eINSTANCE.getClazz_Bindings();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ConstructorImpl <em>Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ConstructorImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructor()
		 * @generated
		 */
		EClass CONSTRUCTOR = eINSTANCE.getConstructor();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR__PARAMETERS = eINSTANCE.getConstructor_Parameters();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassAugmentImpl <em>Class Augment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassAugmentImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClassAugment()
		 * @generated
		 */
		EClass CLASS_AUGMENT = eINSTANCE.getClassAugment();

		/**
		 * The meta object literal for the '<em><b>Augmented Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_AUGMENT__AUGMENTED_CLASS = eINSTANCE.getClassAugment_AugmentedClass();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AbstractVariableImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAbstractVariable()
		 * @generated
		 */
		EClass ABSTRACT_VARIABLE = eINSTANCE.getAbstractVariable();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.VariableImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__CONTROL = eINSTANCE.getVariable_Control();

		/**
		 * The meta object literal for the '<em><b>Clazz</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__CLAZZ = eINSTANCE.getVariable_Clazz();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__INITIAL_VALUE = eINSTANCE.getVariable_InitialValue();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ParameterImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.NamedElementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LoopStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLoopStatement()
		 * @generated
		 */
		EClass LOOP_STATEMENT = eINSTANCE.getLoopStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SimpleStatementImpl <em>Simple Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SimpleStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSimpleStatement()
		 * @generated
		 */
		EClass SIMPLE_STATEMENT = eINSTANCE.getSimpleStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AssignmentImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VARIABLE = eINSTANCE.getAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ProcedureCallImpl <em>Procedure Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ProcedureCallImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getProcedureCall()
		 * @generated
		 */
		EClass PROCEDURE_CALL = eINSTANCE.getProcedureCall();

		/**
		 * The meta object literal for the '<em><b>Call Id Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE_CALL__CALL_ID_EXPR = eINSTANCE.getProcedureCall_CallIdExpr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ReturnImpl <em>Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ReturnImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getReturn()
		 * @generated
		 */
		EClass RETURN = eINSTANCE.getReturn();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN__VALUE = eINSTANCE.getReturn_Value();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.WaitUntilImpl <em>Wait Until</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.WaitUntilImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getWaitUntil()
		 * @generated
		 */
		EClass WAIT_UNTIL = eINSTANCE.getWaitUntil();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAIT_UNTIL__CONDITION = eINSTANCE.getWaitUntil_Condition();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TerminateImpl <em>Terminate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TerminateImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTerminate()
		 * @generated
		 */
		EClass TERMINATE = eINSTANCE.getTerminate();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.YieldImpl <em>Yield</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.YieldImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getYield()
		 * @generated
		 */
		EClass YIELD = eINSTANCE.getYield();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.WaitImpl <em>Wait</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.WaitImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getWait()
		 * @generated
		 */
		EClass WAIT = eINSTANCE.getWait();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ReactivateImpl <em>Reactivate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ReactivateImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getReactivate()
		 * @generated
		 */
		EClass REACTIVATE = eINSTANCE.getReactivate();

		/**
		 * The meta object literal for the '<em><b>Object Access</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REACTIVATE__OBJECT_ACCESS = eINSTANCE.getReactivate_ObjectAccess();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ActivateObjectImpl <em>Activate Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ActivateObjectImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getActivateObject()
		 * @generated
		 */
		EClass ACTIVATE_OBJECT = eINSTANCE.getActivateObject();

		/**
		 * The meta object literal for the '<em><b>Object Access</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVATE_OBJECT__OBJECT_ACCESS = eINSTANCE.getActivateObject_ObjectAccess();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_OBJECT__PRIORITY = eINSTANCE.getActivateObject_Priority();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AdvanceImpl <em>Advance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AdvanceImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAdvance()
		 * @generated
		 */
		EClass ADVANCE = eINSTANCE.getAdvance();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCE__TIME = eINSTANCE.getAdvance_Time();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PrintImpl <em>Print</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PrintImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPrint()
		 * @generated
		 */
		EClass PRINT = eINSTANCE.getPrint();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINT__OUTPUTS = eINSTANCE.getPrint_Outputs();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IfStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>True Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__TRUE_CASE = eINSTANCE.getIfStatement_TrueCase();

		/**
		 * The meta object literal for the '<em><b>False Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__FALSE_CASE = eINSTANCE.getIfStatement_FalseCase();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LocalScopeImpl <em>Local Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LocalScopeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLocalScope()
		 * @generated
		 */
		EClass LOCAL_SCOPE = eINSTANCE.getLocalScope();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_SCOPE__STATEMENTS = eINSTANCE.getLocalScope_Statements();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LocalScopeStatementImpl <em>Local Scope Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LocalScopeStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLocalScopeStatement()
		 * @generated
		 */
		EClass LOCAL_SCOPE_STATEMENT = eINSTANCE.getLocalScopeStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ForStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Termination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__TERMINATION = eINSTANCE.getForStatement_Termination();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__INCREMENT = eINSTANCE.getForStatement_Increment();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__BODY = eINSTANCE.getForStatement_Body();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.WhileStatementImpl <em>While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.WhileStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getWhileStatement()
		 * @generated
		 */
		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__BODY = eINSTANCE.getWhileStatement_Body();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SwitchStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSwitchStatement()
		 * @generated
		 */
		EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__VARIABLE = eINSTANCE.getSwitchStatement_Variable();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__CASES = eINSTANCE.getSwitchStatement_Cases();

		/**
		 * The meta object literal for the '<em><b>Default Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__DEFAULT_CASE = eINSTANCE.getSwitchStatement_DefaultCase();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SwitchCaseImpl <em>Switch Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SwitchCaseImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSwitchCase()
		 * @generated
		 */
		EClass SWITCH_CASE = eINSTANCE.getSwitchCase();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_CASE__VALUE = eINSTANCE.getSwitchCase_Value();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_CASE__BODY = eINSTANCE.getSwitchCase_Body();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.BreakStatementImpl <em>Break Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.BreakStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getBreakStatement()
		 * @generated
		 */
		EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ContinueStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getContinueStatement()
		 * @generated
		 */
		EClass CONTINUE_STATEMENT = eINSTANCE.getContinueStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L1ExprImpl <em>L1 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L1ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL1Expr()
		 * @generated
		 */
		EClass L1_EXPR = eINSTANCE.getL1Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L2ExprImpl <em>L2 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L2ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL2Expr()
		 * @generated
		 */
		EClass L2_EXPR = eINSTANCE.getL2Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L3ExprImpl <em>L3 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L3ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL3Expr()
		 * @generated
		 */
		EClass L3_EXPR = eINSTANCE.getL3Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L4ExprImpl <em>L4 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L4ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL4Expr()
		 * @generated
		 */
		EClass L4_EXPR = eINSTANCE.getL4Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L5ExprImpl <em>L5 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L5ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL5Expr()
		 * @generated
		 */
		EClass L5_EXPR = eINSTANCE.getL5Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L6ExprImpl <em>L6 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L6ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL6Expr()
		 * @generated
		 */
		EClass L6_EXPR = eINSTANCE.getL6Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L7ExprImpl <em>L7 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L7ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL7Expr()
		 * @generated
		 */
		EClass L7_EXPR = eINSTANCE.getL7Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L8ExprImpl <em>L8 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L8ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL8Expr()
		 * @generated
		 */
		EClass L8_EXPR = eINSTANCE.getL8Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L9ExprImpl <em>L9 Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L9ExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL9Expr()
		 * @generated
		 */
		EClass L9_EXPR = eINSTANCE.getL9Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.BinaryOperatorImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getBinaryOperator()
		 * @generated
		 */
		EClass BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

		/**
		 * The meta object literal for the '<em><b>Op1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR__OP1 = eINSTANCE.getBinaryOperator_Op1();

		/**
		 * The meta object literal for the '<em><b>Op2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR__OP2 = eINSTANCE.getBinaryOperator_Op2();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.UnaryOperatorImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_OPERATOR__OP = eINSTANCE.getUnaryOperator_Op();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AndImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.OrImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.GreaterImpl <em>Greater</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.GreaterImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getGreater()
		 * @generated
		 */
		EClass GREATER = eINSTANCE.getGreater();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.GreaterEqualImpl <em>Greater Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.GreaterEqualImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getGreaterEqual()
		 * @generated
		 */
		EClass GREATER_EQUAL = eINSTANCE.getGreaterEqual();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LessImpl <em>Less</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LessImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLess()
		 * @generated
		 */
		EClass LESS = eINSTANCE.getLess();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LessEqualImpl <em>Less Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LessEqualImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLessEqual()
		 * @generated
		 */
		EClass LESS_EQUAL = eINSTANCE.getLessEqual();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.NotEqualImpl <em>Not Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.NotEqualImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getNotEqual()
		 * @generated
		 */
		EClass NOT_EQUAL = eINSTANCE.getNotEqual();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.EqualImpl <em>Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.EqualImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getEqual()
		 * @generated
		 */
		EClass EQUAL = eINSTANCE.getEqual();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.InstanceOfImpl <em>Instance Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.InstanceOfImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getInstanceOf()
		 * @generated
		 */
		EClass INSTANCE_OF = eINSTANCE.getInstanceOf();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PlusImpl <em>Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PlusImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPlus()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MinusImpl <em>Minus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MinusImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMinus()
		 * @generated
		 */
		EClass MINUS = eINSTANCE.getMinus();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MulImpl <em>Mul</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MulImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMul()
		 * @generated
		 */
		EClass MUL = eINSTANCE.getMul();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ModImpl <em>Mod</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ModImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMod()
		 * @generated
		 */
		EClass MOD = eINSTANCE.getMod();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.DivImpl <em>Div</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.DivImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getDiv()
		 * @generated
		 */
		EClass DIV = eINSTANCE.getDiv();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.NegImpl <em>Neg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.NegImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getNeg()
		 * @generated
		 */
		EClass NEG = eINSTANCE.getNeg();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.NotImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.CastImpl <em>Cast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.CastImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getCast()
		 * @generated
		 */
		EClass CAST = eINSTANCE.getCast();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.CreateObjectImpl <em>Create Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.CreateObjectImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getCreateObject()
		 * @generated
		 */
		EClass CREATE_OBJECT = eINSTANCE.getCreateObject();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.NullLiteralImpl <em>Null Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.NullLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getNullLiteral()
		 * @generated
		 */
		EClass NULL_LITERAL = eINSTANCE.getNullLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TimeLiteralImpl <em>Time Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TimeLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTimeLiteral()
		 * @generated
		 */
		EClass TIME_LITERAL = eINSTANCE.getTimeLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ActiveLiteralImpl <em>Active Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ActiveLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getActiveLiteral()
		 * @generated
		 */
		EClass ACTIVE_LITERAL = eINSTANCE.getActiveLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StringLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IntLiteralImpl <em>Int Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IntLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIntLiteral()
		 * @generated
		 */
		EClass INT_LITERAL = eINSTANCE.getIntLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TrueLiteralImpl <em>True Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TrueLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTrueLiteral()
		 * @generated
		 */
		EClass TRUE_LITERAL = eINSTANCE.getTrueLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.FalseLiteralImpl <em>False Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.FalseLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getFalseLiteral()
		 * @generated
		 */
		EClass FALSE_LITERAL = eINSTANCE.getFalseLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.DoubleLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpandExprImpl <em>Expand Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpandExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandExpr()
		 * @generated
		 */
		EClass EXPAND_EXPR = eINSTANCE.getExpandExpr();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPAND_EXPR__EXPR = eINSTANCE.getExpandExpr_Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ParseExprImpl <em>Parse Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ParseExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getParseExpr()
		 * @generated
		 */
		EClass PARSE_EXPR = eINSTANCE.getParseExpr();

		/**
		 * The meta object literal for the '<em><b>Ast Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARSE_EXPR__AST_PART = eINSTANCE.getParseExpr_AstPart();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PredefinedIdImpl <em>Predefined Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PredefinedIdImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPredefinedId()
		 * @generated
		 */
		EClass PREDEFINED_ID = eINSTANCE.getPredefinedId();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MeLiteralImpl <em>Me Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MeLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMeLiteral()
		 * @generated
		 */
		EClass ME_LITERAL = eINSTANCE.getMeLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SuperLiteralImpl <em>Super Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SuperLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSuperLiteral()
		 * @generated
		 */
		EClass SUPER_LITERAL = eINSTANCE.getSuperLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MetaLiteralImpl <em>Meta Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MetaLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaLiteral()
		 * @generated
		 */
		EClass META_LITERAL = eINSTANCE.getMetaLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TypeLiteralImpl <em>Type Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TypeLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTypeLiteral()
		 * @generated
		 */
		EClass TYPE_LITERAL = eINSTANCE.getTypeLiteral();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SizeOfArrayImpl <em>Size Of Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SizeOfArrayImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSizeOfArray()
		 * @generated
		 */
		EClass SIZE_OF_ARRAY = eINSTANCE.getSizeOfArray();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IdExprImpl <em>Id Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IdExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIdExpr()
		 * @generated
		 */
		EClass ID_EXPR = eINSTANCE.getIdExpr();

		/**
		 * The meta object literal for the '<em><b>Parent Id Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_EXPR__PARENT_ID_EXPR = eINSTANCE.getIdExpr_ParentIdExpr();

		/**
		 * The meta object literal for the '<em><b>Referenced Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_EXPR__REFERENCED_ELEMENT = eINSTANCE.getIdExpr_ReferencedElement();

		/**
		 * The meta object literal for the '<em><b>Predefined Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_EXPR__PREDEFINED_ID = eINSTANCE.getIdExpr_PredefinedId();

		/**
		 * The meta object literal for the '<em><b>Array Index</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_EXPR__ARRAY_INDEX = eINSTANCE.getIdExpr_ArrayIndex();

		/**
		 * The meta object literal for the '<em><b>Call Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ID_EXPR__CALL_PART = eINSTANCE.getIdExpr_CallPart();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.CallPartImpl <em>Call Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.CallPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getCallPart()
		 * @generated
		 */
		EClass CALL_PART = eINSTANCE.getCallPart();

		/**
		 * The meta object literal for the '<em><b>Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_PART__CALL_ARGUMENTS = eINSTANCE.getCallPart_CallArguments();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ElementAccessImpl <em>Element Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ElementAccessImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getElementAccess()
		 * @generated
		 */
		EClass ELEMENT_ACCESS = eINSTANCE.getElementAccess();

		/**
		 * The meta object literal for the '<em><b>Id Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_ACCESS__ID_EXPR = eINSTANCE.getElementAccess_IdExpr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.VariableAccessImpl <em>Variable Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.VariableAccessImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getVariableAccess()
		 * @generated
		 */
		EClass VARIABLE_ACCESS = eINSTANCE.getVariableAccess();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MetaAccessImpl <em>Meta Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MetaAccessImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaAccess()
		 * @generated
		 */
		EClass META_ACCESS = eINSTANCE.getMetaAccess();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TypeAccessImpl <em>Type Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TypeAccessImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTypeAccess()
		 * @generated
		 */
		EClass TYPE_ACCESS = eINSTANCE.getTypeAccess();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassContentExtensionImpl <em>Class Content Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassContentExtensionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClassContentExtension()
		 * @generated
		 */
		EClass CLASS_CONTENT_EXTENSION = eINSTANCE.getClassContentExtension();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ModuleContentExtensionImpl <em>Module Content Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ModuleContentExtensionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getModuleContentExtension()
		 * @generated
		 */
		EClass MODULE_CONTENT_EXTENSION = eINSTANCE.getModuleContentExtension();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExtensionDefinitionImpl <em>Extension Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExtensionDefinitionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExtensionDefinition()
		 * @generated
		 */
		EClass EXTENSION_DEFINITION = eINSTANCE.getExtensionDefinition();

		/**
		 * The meta object literal for the '<em><b>Extended Concept</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__EXTENDED_CONCEPT = eINSTANCE.getExtensionDefinition_ExtendedConcept();

		/**
		 * The meta object literal for the '<em><b>Abstract Syntax Def</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__ABSTRACT_SYNTAX_DEF = eINSTANCE.getExtensionDefinition_AbstractSyntaxDef();

		/**
		 * The meta object literal for the '<em><b>Textual Syntax Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__TEXTUAL_SYNTAX_DEF = eINSTANCE.getExtensionDefinition_TextualSyntaxDef();

		/**
		 * The meta object literal for the '<em><b>Mapping Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__MAPPING_DEF = eINSTANCE.getExtensionDefinition_MappingDef();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TextualSyntaxDefImpl <em>Textual Syntax Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TextualSyntaxDefImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTextualSyntaxDef()
		 * @generated
		 */
		EClass TEXTUAL_SYNTAX_DEF = eINSTANCE.getTextualSyntaxDef();

		/**
		 * The meta object literal for the '<em><b>Start Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTUAL_SYNTAX_DEF__START_RULE = eINSTANCE.getTextualSyntaxDef_StartRule();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTUAL_SYNTAX_DEF__RULES = eINSTANCE.getTextualSyntaxDef_Rules();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LanguageConstructClassifierImpl <em>Language Construct Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LanguageConstructClassifierImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLanguageConstructClassifier()
		 * @generated
		 */
		EClass LANGUAGE_CONSTRUCT_CLASSIFIER = eINSTANCE.getLanguageConstructClassifier();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.LanguageConceptClassifierImpl <em>Language Concept Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.LanguageConceptClassifierImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getLanguageConceptClassifier()
		 * @generated
		 */
		EClass LANGUAGE_CONCEPT_CLASSIFIER = eINSTANCE.getLanguageConceptClassifier();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TsRuleImpl <em>Ts Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TsRuleImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTsRule()
		 * @generated
		 */
		EClass TS_RULE = eINSTANCE.getTsRule();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TS_RULE__RHS = eINSTANCE.getTsRule_Rhs();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.RhsExpressionImpl <em>Rhs Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.RhsExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getRhsExpression()
		 * @generated
		 */
		EClass RHS_EXPRESSION = eINSTANCE.getRhsExpression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L3RhsExprImpl <em>L3 Rhs Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L3RhsExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL3RhsExpr()
		 * @generated
		 */
		EClass L3_RHS_EXPR = eINSTANCE.getL3RhsExpr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L2RhsExprImpl <em>L2 Rhs Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L2RhsExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL2RhsExpr()
		 * @generated
		 */
		EClass L2_RHS_EXPR = eINSTANCE.getL2RhsExpr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SequenceExprImpl <em>Sequence Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SequenceExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSequenceExpr()
		 * @generated
		 */
		EClass SEQUENCE_EXPR = eINSTANCE.getSequenceExpr();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_EXPR__SEQUENCE = eINSTANCE.getSequenceExpr_Sequence();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L1RhsExprImpl <em>L1 Rhs Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L1RhsExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL1RhsExpr()
		 * @generated
		 */
		EClass L1_RHS_EXPR = eINSTANCE.getL1RhsExpr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TerminalExprImpl <em>Terminal Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TerminalExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTerminalExpr()
		 * @generated
		 */
		EClass TERMINAL_EXPR = eINSTANCE.getTerminalExpr();

		/**
		 * The meta object literal for the '<em><b>Terminal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL_EXPR__TERMINAL = eINSTANCE.getTerminalExpr_Terminal();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PropertyBindingExprImpl <em>Property Binding Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PropertyBindingExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPropertyBindingExpr()
		 * @generated
		 */
		EClass PROPERTY_BINDING_EXPR = eINSTANCE.getPropertyBindingExpr();

		/**
		 * The meta object literal for the '<em><b>Property Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_BINDING_EXPR__PROPERTY_TYPE = eINSTANCE.getPropertyBindingExpr_PropertyType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.RhsClassifierExprImpl <em>Rhs Classifier Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.RhsClassifierExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getRhsClassifierExpr()
		 * @generated
		 */
		EClass RHS_CLASSIFIER_EXPR = eINSTANCE.getRhsClassifierExpr();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RHS_CLASSIFIER_EXPR__CLASSIFIER = eINSTANCE.getRhsClassifierExpr_Classifier();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PropertyTypeImpl <em>Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPropertyType()
		 * @generated
		 */
		EClass PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IdPropertyTypeImpl <em>Id Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IdPropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIdPropertyType()
		 * @generated
		 */
		EClass ID_PROPERTY_TYPE = eINSTANCE.getIdPropertyType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IntPropertyTypeImpl <em>Int Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IntPropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIntPropertyType()
		 * @generated
		 */
		EClass INT_PROPERTY_TYPE = eINSTANCE.getIntPropertyType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StringPropertyTypeImpl <em>String Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StringPropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStringPropertyType()
		 * @generated
		 */
		EClass STRING_PROPERTY_TYPE = eINSTANCE.getStringPropertyType();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.BooleanPropertyTypeImpl <em>Boolean Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.BooleanPropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getBooleanPropertyType()
		 * @generated
		 */
		EClass BOOLEAN_PROPERTY_TYPE = eINSTANCE.getBooleanPropertyType();

		/**
		 * The meta object literal for the '<em><b>Terminal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_PROPERTY_TYPE__TERMINAL = eINSTANCE.getBooleanPropertyType_Terminal();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StructuredPropertyTypeImpl <em>Structured Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StructuredPropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStructuredPropertyType()
		 * @generated
		 */
		EClass STRUCTURED_PROPERTY_TYPE = eINSTANCE.getStructuredPropertyType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_PROPERTY_TYPE__TYPE = eINSTANCE.getStructuredPropertyType_Type();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.CompositePropertyTypeImpl <em>Composite Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.CompositePropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getCompositePropertyType()
		 * @generated
		 */
		EClass COMPOSITE_PROPERTY_TYPE = eINSTANCE.getCompositePropertyType();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_PROPERTY_TYPE__LIST = eINSTANCE.getCompositePropertyType_List();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ReferencePropertyTypeImpl <em>Reference Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ReferencePropertyTypeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getReferencePropertyType()
		 * @generated
		 */
		EClass REFERENCE_PROPERTY_TYPE = eINSTANCE.getReferencePropertyType();

		/**
		 * The meta object literal for the '<em><b>Raw Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_PROPERTY_TYPE__RAW_REFERENCE = eINSTANCE.getReferencePropertyType_RawReference();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MappingImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__PARTS = eINSTANCE.getMapping_Parts();

		/**
		 * The meta object literal for the '<em><b>Meta Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__META_OBJECT = eINSTANCE.getMapping_MetaObject();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MappingPartImpl <em>Mapping Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MappingPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMappingPart()
		 * @generated
		 */
		EClass MAPPING_PART = eINSTANCE.getMappingPart();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MetaExprImpl <em>Meta Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MetaExprImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaExpr()
		 * @generated
		 */
		EClass META_EXPR = eINSTANCE.getMetaExpr();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_EXPR__EXPR = eINSTANCE.getMetaExpr_Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TargetStatementImpl <em>Target Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TargetStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTargetStatement()
		 * @generated
		 */
		EClass TARGET_STATEMENT = eINSTANCE.getTargetStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_STATEMENT__BODY = eINSTANCE.getTargetStatement_Body();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MappingStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMappingStatement()
		 * @generated
		 */
		EClass MAPPING_STATEMENT = eINSTANCE.getMappingStatement();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATEMENT__PARTS = eINSTANCE.getMappingStatement_Parts();

		/**
		 * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATEMENT__EXPRS = eINSTANCE.getMappingStatement_Exprs();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SetGenContextStatementImpl <em>Set Gen Context Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SetGenContextStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSetGenContextStatement()
		 * @generated
		 */
		EClass SET_GEN_CONTEXT_STATEMENT = eINSTANCE.getSetGenContextStatement();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_GEN_CONTEXT_STATEMENT__CONTEXT = eINSTANCE.getSetGenContextStatement_Context();

		/**
		 * The meta object literal for the '<em><b>Add After Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_GEN_CONTEXT_STATEMENT__ADD_AFTER_CONTEXT = eINSTANCE.getSetGenContextStatement_AddAfterContext();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ResetGenContextStatementImpl <em>Reset Gen Context Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ResetGenContextStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getResetGenContextStatement()
		 * @generated
		 */
		EClass RESET_GEN_CONTEXT_STATEMENT = eINSTANCE.getResetGenContextStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SaveGenStatementImpl <em>Save Gen Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SaveGenStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSaveGenStatement()
		 * @generated
		 */
		EClass SAVE_GEN_STATEMENT = eINSTANCE.getSaveGenStatement();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAVE_GEN_STATEMENT__VARIABLE = eINSTANCE.getSaveGenStatement_Variable();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ResumeGenStatementImpl <em>Resume Gen Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ResumeGenStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getResumeGenStatement()
		 * @generated
		 */
		EClass RESUME_GEN_STATEMENT = eINSTANCE.getResumeGenStatement();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESUME_GEN_STATEMENT__VARIABLE = eINSTANCE.getResumeGenStatement_Variable();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.FixedMappingPartImpl <em>Fixed Mapping Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.FixedMappingPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getFixedMappingPart()
		 * @generated
		 */
		EClass FIXED_MAPPING_PART = eINSTANCE.getFixedMappingPart();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_MAPPING_PART__CODE = eINSTANCE.getFixedMappingPart_Code();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.DynamicMappingPartImpl <em>Dynamic Mapping Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.DynamicMappingPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getDynamicMappingPart()
		 * @generated
		 */
		EClass DYNAMIC_MAPPING_PART = eINSTANCE.getDynamicMappingPart();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_MAPPING_PART__EXPR = eINSTANCE.getDynamicMappingPart_Expr();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpandExpressionImpl <em>Expand Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpandExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandExpression()
		 * @generated
		 */
		EClass EXPAND_EXPRESSION = eINSTANCE.getExpandExpression();

		/**
		 * The meta object literal for the '<em><b>Meta Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPAND_EXPRESSION__META_OBJECT = eINSTANCE.getExpandExpression_MetaObject();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpandStatementImpl <em>Expand Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpandStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandStatement()
		 * @generated
		 */
		EClass EXPAND_STATEMENT = eINSTANCE.getExpandStatement();

		/**
		 * The meta object literal for the '<em><b>Meta Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPAND_STATEMENT__META_OBJECT = eINSTANCE.getExpandStatement_MetaObject();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPAND_STATEMENT__LOCATION = eINSTANCE.getExpandStatement_Location();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.CodeQuoteExpressionImpl <em>Code Quote Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.CodeQuoteExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getCodeQuoteExpression()
		 * @generated
		 */
		EClass CODE_QUOTE_EXPRESSION = eINSTANCE.getCodeQuoteExpression();

		/**
		 * The meta object literal for the '<em><b>Quoted Code</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_QUOTE_EXPRESSION__QUOTED_CODE = eINSTANCE.getCodeQuoteExpression_QuotedCode();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.QuotedCodeImpl <em>Quoted Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.QuotedCodeImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedCode()
		 * @generated
		 */
		EClass QUOTED_CODE = eINSTANCE.getQuotedCode();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.QuotedExpressionImpl <em>Quoted Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.QuotedExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedExpression()
		 * @generated
		 */
		EClass QUOTED_EXPRESSION = eINSTANCE.getQuotedExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUOTED_EXPRESSION__EXPRESSION = eINSTANCE.getQuotedExpression_Expression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.QuotedStatementsImpl <em>Quoted Statements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.QuotedStatementsImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedStatements()
		 * @generated
		 */
		EClass QUOTED_STATEMENTS = eINSTANCE.getQuotedStatements();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUOTED_STATEMENTS__STATEMENTS = eINSTANCE.getQuotedStatements_Statements();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.QuotedClassContentImpl <em>Quoted Class Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.QuotedClassContentImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedClassContent()
		 * @generated
		 */
		EClass QUOTED_CLASS_CONTENT = eINSTANCE.getQuotedClassContent();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.QuotedModuleContentImpl <em>Quoted Module Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.QuotedModuleContentImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedModuleContent()
		 * @generated
		 */
		EClass QUOTED_MODULE_CONTENT = eINSTANCE.getQuotedModuleContent();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PatternImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN__TOP = eINSTANCE.getPattern_Top();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__CONTEXT = eINSTANCE.getPattern_Context();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__BODY = eINSTANCE.getPattern_Body();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.TestStatementImpl <em>Test Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.TestStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getTestStatement()
		 * @generated
		 */
		EClass TEST_STATEMENT = eINSTANCE.getTestStatement();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STATEMENT__VALUE = eINSTANCE.getTestStatement_Value();

	}

} //DblPackage
