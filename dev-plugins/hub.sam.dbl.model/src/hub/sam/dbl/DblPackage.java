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
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
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
	int NAMED_ELEMENT = 29;

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
	 * The feature id for the '<em><b>Content Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CONTENT_EXTENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXTENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extension Semantics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__EXTENSION_SEMANTICS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__FUNCTIONS = NAMED_ELEMENT_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AnnotationImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ITEMS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AnnotationItemImpl <em>Annotation Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AnnotationItemImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotationItem()
	 * @generated
	 */
	int ANNOTATION_ITEM = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ITEM__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ITEM__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Annotation Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AnnotateableElementImpl <em>Annotateable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AnnotateableElementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotateableElement()
	 * @generated
	 */
	int ANNOTATEABLE_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATEABLE_ELEMENT__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Annotateable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATEABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ConstructiveExtensionImpl <em>Constructive Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ConstructiveExtensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructiveExtension()
	 * @generated
	 */
	int CONSTRUCTIVE_EXTENSION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Constructive Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ConstructiveExtensionAtContentExtensionPointImpl <em>Constructive Extension At Content Extension Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ConstructiveExtensionAtContentExtensionPointImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructiveExtensionAtContentExtensionPoint()
	 * @generated
	 */
	int CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT = 9;

	/**
	 * The feature id for the '<em><b>Content Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Constructive Extension At Content Extension Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ModuleContentExtensionImpl <em>Module Content Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ModuleContentExtensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getModuleContentExtension()
	 * @generated
	 */
	int MODULE_CONTENT_EXTENSION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__NAME = CONSTRUCTIVE_EXTENSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__EXPAND_EXPR = CONSTRUCTIVE_EXTENSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__CONCRETE_SYNTAX = CONSTRUCTIVE_EXTENSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION = CONSTRUCTIVE_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Module Content Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_CONTENT_EXTENSION_FEATURE_COUNT = CONSTRUCTIVE_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassContentExtensionImpl <em>Class Content Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassContentExtensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClassContentExtension()
	 * @generated
	 */
	int CLASS_CONTENT_EXTENSION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__NAME = CONSTRUCTIVE_EXTENSION__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__EXPAND_EXPR = CONSTRUCTIVE_EXTENSION__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__CONCRETE_SYNTAX = CONSTRUCTIVE_EXTENSION__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION = CONSTRUCTIVE_EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Class Content Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTENT_EXTENSION_FEATURE_COUNT = CONSTRUCTIVE_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.TypeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 12;

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
	int TYPED_ELEMENT = 13;

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
	int ARRAY_DIMENSION = 14;

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
	int PRIMITIVE_TYPE = 15;

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
	int VOID_TYPE = 16;

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
	int INT_TYPE = 17;

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
	int BOOL_TYPE = 18;

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
	int DOUBLE_TYPE = 19;

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
	int STRING_TYPE = 20;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.FunctionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PRIMITIVE_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__TYPE_ARRAY_DIMENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CLASSIFIER_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__STATEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CLASS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ABSTRACT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NativeBindingImpl <em>Native Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NativeBindingImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNativeBinding()
	 * @generated
	 */
	int NATIVE_BINDING = 22;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.LocalScopeImpl <em>Local Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LocalScopeImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLocalScope()
	 * @generated
	 */
	int LOCAL_SCOPE = 45;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SuperClassSpecificationImpl <em>Super Class Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SuperClassSpecificationImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSuperClassSpecification()
	 * @generated
	 */
	int SUPER_CLASS_SPECIFICATION = 23;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CLASS_SPECIFICATION__CLASS = 0;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ClassImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ARRAY_DIMENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONTENT_EXTENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONCRETE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INSTANCE_OF_EXTENSION_DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ANNOTATIONS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ACTIVE = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__BINDINGS = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPER_CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Constructors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONSTRUCTORS = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__METHODS = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ACTIONS_BLOCK = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 13;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.ConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ConstructorImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructor()
	 * @generated
	 */
	int CONSTRUCTOR = 25;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__STATEMENTS = LOCAL_SCOPE__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__PARAMETERS = LOCAL_SCOPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__OWNING_CLASS = LOCAL_SCOPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_FEATURE_COUNT = LOCAL_SCOPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AbstractVariableImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 26;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__ANNOTATIONS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.VariableImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 27;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ANNOTATIONS = ABSTRACT_VARIABLE__ANNOTATIONS;

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
	 * The feature id for the '<em><b>Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CONTROL = ABSTRACT_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CLASS = ABSTRACT_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__INITIAL_VALUE = ABSTRACT_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ParameterImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 28;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ANNOTATIONS = ABSTRACT_VARIABLE__ANNOTATIONS;

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
	int STATEMENT = 30;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__ANNOTATIONS = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LoopStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLoopStatement()
	 * @generated
	 */
	int LOOP_STATEMENT = 31;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_STATEMENT__ANNOTATIONS = STATEMENT__ANNOTATIONS;

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
	int SIMPLE_STATEMENT = 32;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_STATEMENT__ANNOTATIONS = STATEMENT__ANNOTATIONS;

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
	int ASSIGNMENT = 33;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.FunctionCallImpl <em>Function Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.FunctionCallImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getFunctionCall()
	 * @generated
	 */
	int FUNCTION_CALL = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Call Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__CALL_ID_EXPR = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ReturnImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 35;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int WAIT_UNTIL = 36;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_UNTIL__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int TERMINATE = 37;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int YIELD = 38;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YIELD__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int WAIT = 39;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int REACTIVATE = 40;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTIVATE__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int ACTIVATE_OBJECT = 41;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_OBJECT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int ADVANCE = 42;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCE__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int PRINT = 43;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int IF_STATEMENT = 44;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ANNOTATIONS = STATEMENT__ANNOTATIONS;

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
	int LOCAL_SCOPE_STATEMENT = 46;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SCOPE_STATEMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int FOR_STATEMENT = 47;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ANNOTATIONS = LOOP_STATEMENT__ANNOTATIONS;

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
	int WHILE_STATEMENT = 48;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__ANNOTATIONS = LOOP_STATEMENT__ANNOTATIONS;

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
	int SWITCH_STATEMENT = 49;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int SWITCH_CASE = 50;

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
	int BREAK_STATEMENT = 51;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int CONTINUE_STATEMENT = 52;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

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
	int EXPRESSION = 53;

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
	int L1_EXPR = 54;

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
	int L2_EXPR = 55;

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
	int L3_EXPR = 56;

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
	int L4_EXPR = 57;

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
	int L5_EXPR = 58;

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
	int L6_EXPR = 59;

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
	int L7_EXPR = 60;

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
	int L8_EXPR = 61;

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
	int L9_EXPR = 62;

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
	int BINARY_OPERATOR = 63;

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
	int UNARY_OPERATOR = 64;

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
	int AND = 66;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.OrImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getOr()
	 * @generated
	 */
	int OR = 65;

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
	int GREATER = 69;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.GreaterEqualImpl <em>Greater Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.GreaterEqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getGreaterEqual()
	 * @generated
	 */
	int GREATER_EQUAL = 70;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LessImpl <em>Less</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LessImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLess()
	 * @generated
	 */
	int LESS = 71;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.LessEqualImpl <em>Less Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.LessEqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getLessEqual()
	 * @generated
	 */
	int LESS_EQUAL = 72;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.NotEqualImpl <em>Not Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.NotEqualImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getNotEqual()
	 * @generated
	 */
	int NOT_EQUAL = 67;

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
	int EQUAL = 68;

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
	int INSTANCE_OF = 73;

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
	int PLUS = 74;

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
	int MINUS = 75;

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
	int MUL = 76;

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
	int MOD = 77;

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
	int DIV = 78;

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
	int NEG = 79;

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
	int NOT = 80;

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
	int CAST = 81;

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
	int CREATE_OBJECT = 82;

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
	int NULL_LITERAL = 83;

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
	int TIME_LITERAL = 84;

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
	int ACTIVE_LITERAL = 85;

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
	int STRING_LITERAL = 86;

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
	int INT_LITERAL = 87;

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
	int TRUE_LITERAL = 88;

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
	int FALSE_LITERAL = 89;

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
	int DOUBLE_LITERAL = 90;

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
	int EXPAND_EXPR = 91;

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
	int PARSE_EXPR = 92;

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
	int PREDEFINED_ID = 93;

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
	int ME_LITERAL = 94;

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
	int SUPER_LITERAL = 95;

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
	int META_LITERAL = 96;

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
	int TYPE_LITERAL = 97;

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
	int SIZE_OF_ARRAY = 98;

	/**
	 * The number of structural features of the '<em>Size Of Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_OF_ARRAY_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.AnnotationLiteralImpl <em>Annotation Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.AnnotationLiteralImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotationLiteral()
	 * @generated
	 */
	int ANNOTATION_LITERAL = 99;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_LITERAL__NAME = PREDEFINED_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_LITERAL__ITEMS = PREDEFINED_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_LITERAL_FEATURE_COUNT = PREDEFINED_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IdExprImpl <em>Id Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IdExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIdExpr()
	 * @generated
	 */
	int ID_EXPR = 100;

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
	int CALL_PART = 101;

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
	int ELEMENT_ACCESS = 102;

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
	int VARIABLE_ACCESS = 103;

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
	int META_ACCESS = 104;

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
	int TYPE_ACCESS = 105;

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
	 * The meta object id for the '{@link hub.sam.dbl.impl.SyntaxSymbolClassifierImpl <em>Syntax Symbol Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SyntaxSymbolClassifierImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSyntaxSymbolClassifier()
	 * @generated
	 */
	int SYNTAX_SYMBOL_CLASSIFIER = 109;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_SYMBOL_CLASSIFIER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_SYMBOL_CLASSIFIER__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_SYMBOL_CLASSIFIER__CONCRETE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_SYMBOL_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Syntax Symbol Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_SYMBOL_CLASSIFIER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ComplexSymbolImpl <em>Complex Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ComplexSymbolImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getComplexSymbol()
	 * @generated
	 */
	int COMPLEX_SYMBOL = 110;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_SYMBOL__NAME = SYNTAX_SYMBOL_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_SYMBOL__EXPAND_EXPR = SYNTAX_SYMBOL_CLASSIFIER__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_SYMBOL__CONCRETE_SYNTAX = SYNTAX_SYMBOL_CLASSIFIER__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION = SYNTAX_SYMBOL_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Complex Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_SYMBOL_FEATURE_COUNT = SYNTAX_SYMBOL_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ConceptImpl <em>Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ConceptImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getConcept()
	 * @generated
	 */
	int CONCEPT = 111;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__NAME = COMPLEX_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__EXPAND_EXPR = COMPLEX_SYMBOL__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__CONCRETE_SYNTAX = COMPLEX_SYMBOL__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT__INSTANCE_OF_EXTENSION_DEFINITION = COMPLEX_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_FEATURE_COUNT = COMPLEX_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExtensionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 106;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__NAME = CONCEPT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXPAND_EXPR = CONCEPT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__CONCRETE_SYNTAX = CONCEPT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__INSTANCE_OF_EXTENSION_DEFINITION = CONCEPT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Extension Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENSION_POINT = CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Syntax Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__SYNTAX_DEFINITION = CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExtensionSemanticsImpl <em>Extension Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExtensionSemanticsImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExtensionSemantics()
	 * @generated
	 */
	int EXTENSION_SEMANTICS = 107;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS__STATEMENTS = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Syntax Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS__SYNTAX_DEFINITION = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extension Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_SEMANTICS_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SyntaxDefinitionImpl <em>Syntax Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SyntaxDefinitionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSyntaxDefinition()
	 * @generated
	 */
	int SYNTAX_DEFINITION = 108;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION__NAME = EXTENSIBLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION__EXPAND_EXPR = EXTENSIBLE_ELEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION__CONCRETE_SYNTAX = EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION__INSTANCE_OF_EXTENSION_DEFINITION = EXTENSIBLE_ELEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Start Symbol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION__START_SYMBOL = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Symbols</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION__SYMBOLS = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Syntax Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_DEFINITION_FEATURE_COUNT = EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MetaSymbolImpl <em>Meta Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MetaSymbolImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaSymbol()
	 * @generated
	 */
	int META_SYMBOL = 112;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_SYMBOL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_SYMBOL__EXPAND_EXPR = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_SYMBOL__CONCRETE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Possible Syntax</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_SYMBOL__POSSIBLE_SYNTAX = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Meta Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_SYMBOL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SyntaxExpressionImpl <em>Syntax Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SyntaxExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSyntaxExpression()
	 * @generated
	 */
	int SYNTAX_EXPRESSION = 113;

	/**
	 * The number of structural features of the '<em>Syntax Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L3SyntaxExpressionImpl <em>L3 Syntax Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L3SyntaxExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL3SyntaxExpression()
	 * @generated
	 */
	int L3_SYNTAX_EXPRESSION = 114;

	/**
	 * The number of structural features of the '<em>L3 Syntax Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_SYNTAX_EXPRESSION_FEATURE_COUNT = SYNTAX_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L2SyntaxExpressionImpl <em>L2 Syntax Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L2SyntaxExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL2SyntaxExpression()
	 * @generated
	 */
	int L2_SYNTAX_EXPRESSION = 115;

	/**
	 * The number of structural features of the '<em>L2 Syntax Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_SYNTAX_EXPRESSION_FEATURE_COUNT = SYNTAX_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.SymbolSequenceImpl <em>Symbol Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.SymbolSequenceImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getSymbolSequence()
	 * @generated
	 */
	int SYMBOL_SEQUENCE = 116;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_SEQUENCE__SEQUENCE = L2_SYNTAX_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Symbol Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOL_SEQUENCE_FEATURE_COUNT = L2_SYNTAX_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.L1SyntaxExpressionImpl <em>L1 Syntax Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.L1SyntaxExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getL1SyntaxExpression()
	 * @generated
	 */
	int L1_SYNTAX_EXPRESSION = 117;

	/**
	 * The number of structural features of the '<em>L1 Syntax Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_SYNTAX_EXPRESSION_FEATURE_COUNT = SYNTAX_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl <em>Structural Symbol Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StructuralSymbolReferenceImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStructuralSymbolReference()
	 * @generated
	 */
	int STRUCTURAL_SYMBOL_REFERENCE = 118;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__CLASSIFIER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Classifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__OWNED_CLASSIFIER = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__LIST = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Local Scoped Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Global Scoped Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Structural Symbol Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_SYMBOL_REFERENCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.PlainSymbolReferenceImpl <em>Plain Symbol Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.PlainSymbolReferenceImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getPlainSymbolReference()
	 * @generated
	 */
	int PLAIN_SYMBOL_REFERENCE = 119;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_SYMBOL_REFERENCE__CLASSIFIER = L1_SYNTAX_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Classifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER = L1_SYNTAX_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER = L1_SYNTAX_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Plain Symbol Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_SYMBOL_REFERENCE_FEATURE_COUNT = L1_SYNTAX_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ElementarySymbolImpl <em>Elementary Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ElementarySymbolImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getElementarySymbol()
	 * @generated
	 */
	int ELEMENTARY_SYMBOL = 120;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_SYMBOL__NAME = SYNTAX_SYMBOL_CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_SYMBOL__EXPAND_EXPR = SYNTAX_SYMBOL_CLASSIFIER__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_SYMBOL__CONCRETE_SYNTAX = SYNTAX_SYMBOL_CLASSIFIER__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION = SYNTAX_SYMBOL_CLASSIFIER__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Elementary Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_SYMBOL_FEATURE_COUNT = SYNTAX_SYMBOL_CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IdSymbolImpl <em>Id Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IdSymbolImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIdSymbol()
	 * @generated
	 */
	int ID_SYMBOL = 121;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_SYMBOL__NAME = ELEMENTARY_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_SYMBOL__EXPAND_EXPR = ELEMENTARY_SYMBOL__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_SYMBOL__CONCRETE_SYNTAX = ELEMENTARY_SYMBOL__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION = ELEMENTARY_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Id Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_SYMBOL_FEATURE_COUNT = ELEMENTARY_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.IntSymbolImpl <em>Int Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.IntSymbolImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getIntSymbol()
	 * @generated
	 */
	int INT_SYMBOL = 122;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SYMBOL__NAME = ELEMENTARY_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SYMBOL__EXPAND_EXPR = ELEMENTARY_SYMBOL__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SYMBOL__CONCRETE_SYNTAX = ELEMENTARY_SYMBOL__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION = ELEMENTARY_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>Int Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SYMBOL_FEATURE_COUNT = ELEMENTARY_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.StringSymbolImpl <em>String Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.StringSymbolImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getStringSymbol()
	 * @generated
	 */
	int STRING_SYMBOL = 123;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SYMBOL__NAME = ELEMENTARY_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SYMBOL__EXPAND_EXPR = ELEMENTARY_SYMBOL__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SYMBOL__CONCRETE_SYNTAX = ELEMENTARY_SYMBOL__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION = ELEMENTARY_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The number of structural features of the '<em>String Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SYMBOL_FEATURE_COUNT = ELEMENTARY_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.KeywordImpl <em>Keyword</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.KeywordImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getKeyword()
	 * @generated
	 */
	int KEYWORD = 124;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD__NAME = ELEMENTARY_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD__EXPAND_EXPR = ELEMENTARY_SYMBOL__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD__CONCRETE_SYNTAX = ELEMENTARY_SYMBOL__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD__INSTANCE_OF_EXTENSION_DEFINITION = ELEMENTARY_SYMBOL__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Keyword</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD__KEYWORD = ELEMENTARY_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Keyword</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYWORD_FEATURE_COUNT = ELEMENTARY_SYMBOL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.MetaExprImpl <em>Meta Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.MetaExprImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaExpr()
	 * @generated
	 */
	int META_EXPR = 125;

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
	int TARGET_STATEMENT = 126;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT__BODY = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.CreateIdStatementImpl <em>Create Id Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.CreateIdStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getCreateIdStatement()
	 * @generated
	 */
	int CREATE_ID_STATEMENT = 127;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__PRIMITIVE_TYPE = VARIABLE__PRIMITIVE_TYPE;

	/**
	 * The feature id for the '<em><b>Type Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__TYPE_ARRAY_DIMENSIONS = VARIABLE__TYPE_ARRAY_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Classifier Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__CLASSIFIER_TYPE = VARIABLE__CLASSIFIER_TYPE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__ANNOTATIONS = VARIABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__EXPAND_EXPR = VARIABLE__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__CONCRETE_SYNTAX = VARIABLE__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = VARIABLE__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__CONTROL = VARIABLE__CONTROL;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__CLASS = VARIABLE__CLASS;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT__INITIAL_VALUE = VARIABLE__INITIAL_VALUE;

	/**
	 * The number of structural features of the '<em>Create Id Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ID_STATEMENT_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpansionStatementImpl <em>Expansion Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpansionStatementImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpansionStatement()
	 * @generated
	 */
	int EXPANSION_STATEMENT = 128;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__NAME = SIMPLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__EXPAND_EXPR = SIMPLE_STATEMENT__EXPAND_EXPR;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__CONCRETE_SYNTAX = SIMPLE_STATEMENT__CONCRETE_SYNTAX;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION = SIMPLE_STATEMENT__INSTANCE_OF_EXTENSION_DEFINITION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__ANNOTATIONS = SIMPLE_STATEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Class Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__CLASS_CONTEXT = SIMPLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__FUNCTION_CONTEXT = SIMPLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__VARIABLE_CONTEXT = SIMPLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Differing Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__DIFFERING_CONTEXT = SIMPLE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__PARTS = SIMPLE_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT__EXPRS = SIMPLE_STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Expansion Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_STATEMENT_FEATURE_COUNT = SIMPLE_STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpansionPartImpl <em>Expansion Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpansionPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpansionPart()
	 * @generated
	 */
	int EXPANSION_PART = 129;

	/**
	 * The number of structural features of the '<em>Expansion Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANSION_PART_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpandTextPartImpl <em>Expand Text Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpandTextPartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandTextPart()
	 * @generated
	 */
	int EXPAND_TEXT_PART = 130;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_TEXT_PART__TEXT = EXPANSION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expand Text Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_TEXT_PART_FEATURE_COUNT = EXPANSION_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpandVariablePartImpl <em>Expand Variable Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpandVariablePartImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandVariablePart()
	 * @generated
	 */
	int EXPAND_VARIABLE_PART = 131;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_VARIABLE_PART__EXPR = EXPANSION_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expand Variable Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_VARIABLE_PART_FEATURE_COUNT = EXPANSION_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.ExpandExpressionImpl <em>Expand Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.ExpandExpressionImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandExpression()
	 * @generated
	 */
	int EXPAND_EXPRESSION = 132;

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
	int EXPAND_STATEMENT = 133;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_STATEMENT__ANNOTATIONS = STATEMENT__ANNOTATIONS;

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
	int CODE_QUOTE_EXPRESSION = 134;

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
	int QUOTED_CODE = 135;

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
	int QUOTED_EXPRESSION = 136;

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
	int QUOTED_STATEMENTS = 137;

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
	int QUOTED_CLASS_CONTENT = 138;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__NAME = QUOTED_CODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ARRAY_DIMENSIONS = QUOTED_CODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Content Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__CONTENT_EXTENSIONS = QUOTED_CODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__EXPAND_EXPR = QUOTED_CODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__CONCRETE_SYNTAX = QUOTED_CODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Instance Of Extension Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__INSTANCE_OF_EXTENSION_DEFINITION = QUOTED_CODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ANNOTATIONS = QUOTED_CODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ACTIVE = QUOTED_CODE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__BINDINGS = QUOTED_CODE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__SUPER_CLASSES = QUOTED_CODE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Constructors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__CONSTRUCTORS = QUOTED_CODE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ATTRIBUTES = QUOTED_CODE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__METHODS = QUOTED_CODE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT__ACTIONS_BLOCK = QUOTED_CODE_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Quoted Class Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_CLASS_CONTENT_FEATURE_COUNT = QUOTED_CODE_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link hub.sam.dbl.impl.QuotedModuleContentImpl <em>Quoted Module Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see hub.sam.dbl.impl.QuotedModuleContentImpl
	 * @see hub.sam.dbl.impl.DblPackageImpl#getQuotedModuleContent()
	 * @generated
	 */
	int QUOTED_MODULE_CONTENT = 139;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__NAME = QUOTED_CODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__CONTENT_EXTENSIONS = QUOTED_CODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expand Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__EXPAND_EXPR = QUOTED_CODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__CLASSES = QUOTED_CODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__EXTENSIONS = QUOTED_CODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extension Semantics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__EXTENSION_SEMANTICS = QUOTED_CODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_MODULE_CONTENT__FUNCTIONS = QUOTED_CODE_FEATURE_COUNT + 6;

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
	int PATTERN = 140;

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
	int TEST_STATEMENT = 141;

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
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STATEMENT__ANNOTATIONS = STATEMENT__ANNOTATIONS;

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
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see hub.sam.dbl.Module#getClasses()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see hub.sam.dbl.Module#getExtensions()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Extensions();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getExtensionSemantics <em>Extension Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension Semantics</em>'.
	 * @see hub.sam.dbl.Module#getExtensionSemantics()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ExtensionSemantics();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Module#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see hub.sam.dbl.Module#getFunctions()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Functions();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see hub.sam.dbl.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Annotation#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see hub.sam.dbl.Annotation#getItems()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Items();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.AnnotationItem <em>Annotation Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Item</em>'.
	 * @see hub.sam.dbl.AnnotationItem
	 * @generated
	 */
	EClass getAnnotationItem();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.AnnotationItem#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see hub.sam.dbl.AnnotationItem#getKey()
	 * @see #getAnnotationItem()
	 * @generated
	 */
	EAttribute getAnnotationItem_Key();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.AnnotationItem#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see hub.sam.dbl.AnnotationItem#getValue()
	 * @see #getAnnotationItem()
	 * @generated
	 */
	EAttribute getAnnotationItem_Value();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.AnnotateableElement <em>Annotateable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotateable Element</em>'.
	 * @see hub.sam.dbl.AnnotateableElement
	 * @generated
	 */
	EClass getAnnotateableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.AnnotateableElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see hub.sam.dbl.AnnotateableElement#getAnnotations()
	 * @see #getAnnotateableElement()
	 * @generated
	 */
	EReference getAnnotateableElement_Annotations();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ConstructiveExtension <em>Constructive Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructive Extension</em>'.
	 * @see hub.sam.dbl.ConstructiveExtension
	 * @generated
	 */
	EClass getConstructiveExtension();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint <em>Constructive Extension At Content Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructive Extension At Content Extension Point</em>'.
	 * @see hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint
	 * @generated
	 */
	EClass getConstructiveExtensionAtContentExtensionPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint#getContentExtensions <em>Content Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Content Extensions</em>'.
	 * @see hub.sam.dbl.ConstructiveExtensionAtContentExtensionPoint#getContentExtensions()
	 * @see #getConstructiveExtensionAtContentExtensionPoint()
	 * @generated
	 */
	EReference getConstructiveExtensionAtContentExtensionPoint_ContentExtensions();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.ClassContentExtension <em>Class Content Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Content Extension</em>'.
	 * @see hub.sam.dbl.ClassContentExtension
	 * @generated
	 */
	EClass getClassContentExtension();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see hub.sam.dbl.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Function#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see hub.sam.dbl.Function#getParameters()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Function#isClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see hub.sam.dbl.Function#isClass()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Class();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Function#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see hub.sam.dbl.Function#isAbstract()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Abstract();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.SuperClassSpecification <em>Super Class Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Class Specification</em>'.
	 * @see hub.sam.dbl.SuperClassSpecification
	 * @generated
	 */
	EClass getSuperClassSpecification();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.SuperClassSpecification#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see hub.sam.dbl.SuperClassSpecification#getClass_()
	 * @see #getSuperClassSpecification()
	 * @generated
	 */
	EReference getSuperClassSpecification_Class();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see hub.sam.dbl.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Class#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see hub.sam.dbl.Class#isActive()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Active();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Class#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see hub.sam.dbl.Class#getBindings()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Bindings();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Class#getSuperClasses <em>Super Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Classes</em>'.
	 * @see hub.sam.dbl.Class#getSuperClasses()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SuperClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Class#getConstructors <em>Constructors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constructors</em>'.
	 * @see hub.sam.dbl.Class#getConstructors()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Constructors();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see hub.sam.dbl.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.Class#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see hub.sam.dbl.Class#getMethods()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Methods();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Class#getActionsBlock <em>Actions Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actions Block</em>'.
	 * @see hub.sam.dbl.Class#getActionsBlock()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_ActionsBlock();

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
	 * Returns the meta object for the container reference '{@link hub.sam.dbl.Constructor#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see hub.sam.dbl.Constructor#getOwningClass()
	 * @see #getConstructor()
	 * @generated
	 */
	EReference getConstructor_OwningClass();

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
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Variable#isClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see hub.sam.dbl.Variable#isClass()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Class();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call</em>'.
	 * @see hub.sam.dbl.FunctionCall
	 * @generated
	 */
	EClass getFunctionCall();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.FunctionCall#getCallIdExpr <em>Call Id Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Id Expr</em>'.
	 * @see hub.sam.dbl.FunctionCall#getCallIdExpr()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_CallIdExpr();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.AnnotationLiteral <em>Annotation Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Literal</em>'.
	 * @see hub.sam.dbl.AnnotationLiteral
	 * @generated
	 */
	EClass getAnnotationLiteral();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see hub.sam.dbl.Extension
	 * @generated
	 */
	EClass getExtension();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.Extension#getExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extension Point</em>'.
	 * @see hub.sam.dbl.Extension#getExtensionPoint()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_ExtensionPoint();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.Extension#getSyntaxDefinition <em>Syntax Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Syntax Definition</em>'.
	 * @see hub.sam.dbl.Extension#getSyntaxDefinition()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_SyntaxDefinition();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExtensionSemantics <em>Extension Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Semantics</em>'.
	 * @see hub.sam.dbl.ExtensionSemantics
	 * @generated
	 */
	EClass getExtensionSemantics();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.ExtensionSemantics#getSyntaxDefinition <em>Syntax Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Syntax Definition</em>'.
	 * @see hub.sam.dbl.ExtensionSemantics#getSyntaxDefinition()
	 * @see #getExtensionSemantics()
	 * @generated
	 */
	EReference getExtensionSemantics_SyntaxDefinition();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SyntaxDefinition <em>Syntax Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax Definition</em>'.
	 * @see hub.sam.dbl.SyntaxDefinition
	 * @generated
	 */
	EClass getSyntaxDefinition();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.SyntaxDefinition#getStartSymbol <em>Start Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Symbol</em>'.
	 * @see hub.sam.dbl.SyntaxDefinition#getStartSymbol()
	 * @see #getSyntaxDefinition()
	 * @generated
	 */
	EReference getSyntaxDefinition_StartSymbol();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.SyntaxDefinition#getSymbols <em>Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Symbols</em>'.
	 * @see hub.sam.dbl.SyntaxDefinition#getSymbols()
	 * @see #getSyntaxDefinition()
	 * @generated
	 */
	EReference getSyntaxDefinition_Symbols();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SyntaxSymbolClassifier <em>Syntax Symbol Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax Symbol Classifier</em>'.
	 * @see hub.sam.dbl.SyntaxSymbolClassifier
	 * @generated
	 */
	EClass getSyntaxSymbolClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ComplexSymbol <em>Complex Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Symbol</em>'.
	 * @see hub.sam.dbl.ComplexSymbol
	 * @generated
	 */
	EClass getComplexSymbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept</em>'.
	 * @see hub.sam.dbl.Concept
	 * @generated
	 */
	EClass getConcept();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.MetaSymbol <em>Meta Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Symbol</em>'.
	 * @see hub.sam.dbl.MetaSymbol
	 * @generated
	 */
	EClass getMetaSymbol();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.MetaSymbol#getPossibleSyntax <em>Possible Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Possible Syntax</em>'.
	 * @see hub.sam.dbl.MetaSymbol#getPossibleSyntax()
	 * @see #getMetaSymbol()
	 * @generated
	 */
	EReference getMetaSymbol_PossibleSyntax();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SyntaxExpression <em>Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax Expression</em>'.
	 * @see hub.sam.dbl.SyntaxExpression
	 * @generated
	 */
	EClass getSyntaxExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L3SyntaxExpression <em>L3 Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L3 Syntax Expression</em>'.
	 * @see hub.sam.dbl.L3SyntaxExpression
	 * @generated
	 */
	EClass getL3SyntaxExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L2SyntaxExpression <em>L2 Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2 Syntax Expression</em>'.
	 * @see hub.sam.dbl.L2SyntaxExpression
	 * @generated
	 */
	EClass getL2SyntaxExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.SymbolSequence <em>Symbol Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol Sequence</em>'.
	 * @see hub.sam.dbl.SymbolSequence
	 * @generated
	 */
	EClass getSymbolSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.SymbolSequence#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequence</em>'.
	 * @see hub.sam.dbl.SymbolSequence#getSequence()
	 * @see #getSymbolSequence()
	 * @generated
	 */
	EReference getSymbolSequence_Sequence();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.L1SyntaxExpression <em>L1 Syntax Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L1 Syntax Expression</em>'.
	 * @see hub.sam.dbl.L1SyntaxExpression
	 * @generated
	 */
	EClass getL1SyntaxExpression();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.StructuralSymbolReference <em>Structural Symbol Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Symbol Reference</em>'.
	 * @see hub.sam.dbl.StructuralSymbolReference
	 * @generated
	 */
	EClass getStructuralSymbolReference();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.StructuralSymbolReference#isList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List</em>'.
	 * @see hub.sam.dbl.StructuralSymbolReference#isList()
	 * @see #getStructuralSymbolReference()
	 * @generated
	 */
	EAttribute getStructuralSymbolReference_List();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.StructuralSymbolReference#isComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composite</em>'.
	 * @see hub.sam.dbl.StructuralSymbolReference#isComposite()
	 * @see #getStructuralSymbolReference()
	 * @generated
	 */
	EAttribute getStructuralSymbolReference_Composite();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.StructuralSymbolReference#isLocalScopedReference <em>Local Scoped Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Scoped Reference</em>'.
	 * @see hub.sam.dbl.StructuralSymbolReference#isLocalScopedReference()
	 * @see #getStructuralSymbolReference()
	 * @generated
	 */
	EAttribute getStructuralSymbolReference_LocalScopedReference();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.StructuralSymbolReference#isGlobalScopedReference <em>Global Scoped Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global Scoped Reference</em>'.
	 * @see hub.sam.dbl.StructuralSymbolReference#isGlobalScopedReference()
	 * @see #getStructuralSymbolReference()
	 * @generated
	 */
	EAttribute getStructuralSymbolReference_GlobalScopedReference();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.PlainSymbolReference <em>Plain Symbol Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plain Symbol Reference</em>'.
	 * @see hub.sam.dbl.PlainSymbolReference
	 * @generated
	 */
	EClass getPlainSymbolReference();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.PlainSymbolReference#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see hub.sam.dbl.PlainSymbolReference#getClassifier()
	 * @see #getPlainSymbolReference()
	 * @generated
	 */
	EReference getPlainSymbolReference_Classifier();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.PlainSymbolReference#getOwnedClassifier <em>Owned Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Classifier</em>'.
	 * @see hub.sam.dbl.PlainSymbolReference#getOwnedClassifier()
	 * @see #getPlainSymbolReference()
	 * @generated
	 */
	EReference getPlainSymbolReference_OwnedClassifier();

	/**
	 * Returns the meta object for the reference '{@link hub.sam.dbl.PlainSymbolReference#getReferencedClassifier <em>Referenced Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Classifier</em>'.
	 * @see hub.sam.dbl.PlainSymbolReference#getReferencedClassifier()
	 * @see #getPlainSymbolReference()
	 * @generated
	 */
	EReference getPlainSymbolReference_ReferencedClassifier();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ElementarySymbol <em>Elementary Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Elementary Symbol</em>'.
	 * @see hub.sam.dbl.ElementarySymbol
	 * @generated
	 */
	EClass getElementarySymbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IdSymbol <em>Id Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Symbol</em>'.
	 * @see hub.sam.dbl.IdSymbol
	 * @generated
	 */
	EClass getIdSymbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.IntSymbol <em>Int Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Symbol</em>'.
	 * @see hub.sam.dbl.IntSymbol
	 * @generated
	 */
	EClass getIntSymbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.StringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Symbol</em>'.
	 * @see hub.sam.dbl.StringSymbol
	 * @generated
	 */
	EClass getStringSymbol();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyword</em>'.
	 * @see hub.sam.dbl.Keyword
	 * @generated
	 */
	EClass getKeyword();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.Keyword#getKeyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyword</em>'.
	 * @see hub.sam.dbl.Keyword#getKeyword()
	 * @see #getKeyword()
	 * @generated
	 */
	EAttribute getKeyword_Keyword();

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
	 * Returns the meta object for class '{@link hub.sam.dbl.CreateIdStatement <em>Create Id Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Id Statement</em>'.
	 * @see hub.sam.dbl.CreateIdStatement
	 * @generated
	 */
	EClass getCreateIdStatement();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpansionStatement <em>Expansion Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expansion Statement</em>'.
	 * @see hub.sam.dbl.ExpansionStatement
	 * @generated
	 */
	EClass getExpansionStatement();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ExpansionStatement#isClassContext <em>Class Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Context</em>'.
	 * @see hub.sam.dbl.ExpansionStatement#isClassContext()
	 * @see #getExpansionStatement()
	 * @generated
	 */
	EAttribute getExpansionStatement_ClassContext();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ExpansionStatement#isFunctionContext <em>Function Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Context</em>'.
	 * @see hub.sam.dbl.ExpansionStatement#isFunctionContext()
	 * @see #getExpansionStatement()
	 * @generated
	 */
	EAttribute getExpansionStatement_FunctionContext();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ExpansionStatement#isVariableContext <em>Variable Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Context</em>'.
	 * @see hub.sam.dbl.ExpansionStatement#isVariableContext()
	 * @see #getExpansionStatement()
	 * @generated
	 */
	EAttribute getExpansionStatement_VariableContext();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExpansionStatement#getDifferingContext <em>Differing Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Differing Context</em>'.
	 * @see hub.sam.dbl.ExpansionStatement#getDifferingContext()
	 * @see #getExpansionStatement()
	 * @generated
	 */
	EReference getExpansionStatement_DifferingContext();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ExpansionStatement#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see hub.sam.dbl.ExpansionStatement#getParts()
	 * @see #getExpansionStatement()
	 * @generated
	 */
	EReference getExpansionStatement_Parts();

	/**
	 * Returns the meta object for the containment reference list '{@link hub.sam.dbl.ExpansionStatement#getExprs <em>Exprs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exprs</em>'.
	 * @see hub.sam.dbl.ExpansionStatement#getExprs()
	 * @see #getExpansionStatement()
	 * @generated
	 */
	EReference getExpansionStatement_Exprs();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpansionPart <em>Expansion Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expansion Part</em>'.
	 * @see hub.sam.dbl.ExpansionPart
	 * @generated
	 */
	EClass getExpansionPart();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpandTextPart <em>Expand Text Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Text Part</em>'.
	 * @see hub.sam.dbl.ExpandTextPart
	 * @generated
	 */
	EClass getExpandTextPart();

	/**
	 * Returns the meta object for the attribute '{@link hub.sam.dbl.ExpandTextPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see hub.sam.dbl.ExpandTextPart#getText()
	 * @see #getExpandTextPart()
	 * @generated
	 */
	EAttribute getExpandTextPart_Text();

	/**
	 * Returns the meta object for class '{@link hub.sam.dbl.ExpandVariablePart <em>Expand Variable Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Variable Part</em>'.
	 * @see hub.sam.dbl.ExpandVariablePart
	 * @generated
	 */
	EClass getExpandVariablePart();

	/**
	 * Returns the meta object for the containment reference '{@link hub.sam.dbl.ExpandVariablePart#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see hub.sam.dbl.ExpandVariablePart#getExpr()
	 * @see #getExpandVariablePart()
	 * @generated
	 */
	EReference getExpandVariablePart_Expr();

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
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__CLASSES = eINSTANCE.getModule_Classes();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__EXTENSIONS = eINSTANCE.getModule_Extensions();

		/**
		 * The meta object literal for the '<em><b>Extension Semantics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__EXTENSION_SEMANTICS = eINSTANCE.getModule_ExtensionSemantics();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__FUNCTIONS = eINSTANCE.getModule_Functions();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__VARIABLES = eINSTANCE.getModule_Variables();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AnnotationImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__ITEMS = eINSTANCE.getAnnotation_Items();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AnnotationItemImpl <em>Annotation Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AnnotationItemImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotationItem()
		 * @generated
		 */
		EClass ANNOTATION_ITEM = eINSTANCE.getAnnotationItem();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_ITEM__KEY = eINSTANCE.getAnnotationItem_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_ITEM__VALUE = eINSTANCE.getAnnotationItem_Value();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AnnotateableElementImpl <em>Annotateable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AnnotateableElementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotateableElement()
		 * @generated
		 */
		EClass ANNOTATEABLE_ELEMENT = eINSTANCE.getAnnotateableElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATEABLE_ELEMENT__ANNOTATIONS = eINSTANCE.getAnnotateableElement_Annotations();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ConstructiveExtensionImpl <em>Constructive Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ConstructiveExtensionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructiveExtension()
		 * @generated
		 */
		EClass CONSTRUCTIVE_EXTENSION = eINSTANCE.getConstructiveExtension();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ConstructiveExtensionAtContentExtensionPointImpl <em>Constructive Extension At Content Extension Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ConstructiveExtensionAtContentExtensionPointImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getConstructiveExtensionAtContentExtensionPoint()
		 * @generated
		 */
		EClass CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT = eINSTANCE.getConstructiveExtensionAtContentExtensionPoint();

		/**
		 * The meta object literal for the '<em><b>Content Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTIVE_EXTENSION_AT_CONTENT_EXTENSION_POINT__CONTENT_EXTENSIONS = eINSTANCE.getConstructiveExtensionAtContentExtensionPoint_ContentExtensions();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassContentExtensionImpl <em>Class Content Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassContentExtensionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClassContentExtension()
		 * @generated
		 */
		EClass CLASS_CONTENT_EXTENSION = eINSTANCE.getClassContentExtension();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.FunctionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETERS = eINSTANCE.getFunction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__CLASS = eINSTANCE.getFunction_Class();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__ABSTRACT = eINSTANCE.getFunction_Abstract();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SuperClassSpecificationImpl <em>Super Class Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SuperClassSpecificationImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSuperClassSpecification()
		 * @generated
		 */
		EClass SUPER_CLASS_SPECIFICATION = eINSTANCE.getSuperClassSpecification();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPER_CLASS_SPECIFICATION__CLASS = eINSTANCE.getSuperClassSpecification_Class();

		/**
		 * The meta object literal for the '<em><b>Constructor Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPER_CLASS_SPECIFICATION__CONSTRUCTOR_ARGUMENTS = eINSTANCE.getSuperClassSpecification_ConstructorArguments();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ClassImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__ACTIVE = eINSTANCE.getClass_Active();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__BINDINGS = eINSTANCE.getClass_Bindings();

		/**
		 * The meta object literal for the '<em><b>Super Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPER_CLASSES = eINSTANCE.getClass_SuperClasses();

		/**
		 * The meta object literal for the '<em><b>Constructors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CONSTRUCTORS = eINSTANCE.getClass_Constructors();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__METHODS = eINSTANCE.getClass_Methods();

		/**
		 * The meta object literal for the '<em><b>Actions Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ACTIONS_BLOCK = eINSTANCE.getClass_ActionsBlock();

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
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR__OWNING_CLASS = eINSTANCE.getConstructor_OwningClass();

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
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__CLASS = eINSTANCE.getVariable_Class();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.FunctionCallImpl <em>Function Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.FunctionCallImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getFunctionCall()
		 * @generated
		 */
		EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

		/**
		 * The meta object literal for the '<em><b>Call Id Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL__CALL_ID_EXPR = eINSTANCE.getFunctionCall_CallIdExpr();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.AnnotationLiteralImpl <em>Annotation Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.AnnotationLiteralImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getAnnotationLiteral()
		 * @generated
		 */
		EClass ANNOTATION_LITERAL = eINSTANCE.getAnnotationLiteral();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExtensionImpl <em>Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExtensionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExtension()
		 * @generated
		 */
		EClass EXTENSION = eINSTANCE.getExtension();

		/**
		 * The meta object literal for the '<em><b>Extension Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION__EXTENSION_POINT = eINSTANCE.getExtension_ExtensionPoint();

		/**
		 * The meta object literal for the '<em><b>Syntax Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION__SYNTAX_DEFINITION = eINSTANCE.getExtension_SyntaxDefinition();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExtensionSemanticsImpl <em>Extension Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExtensionSemanticsImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExtensionSemantics()
		 * @generated
		 */
		EClass EXTENSION_SEMANTICS = eINSTANCE.getExtensionSemantics();

		/**
		 * The meta object literal for the '<em><b>Syntax Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_SEMANTICS__SYNTAX_DEFINITION = eINSTANCE.getExtensionSemantics_SyntaxDefinition();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SyntaxDefinitionImpl <em>Syntax Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SyntaxDefinitionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSyntaxDefinition()
		 * @generated
		 */
		EClass SYNTAX_DEFINITION = eINSTANCE.getSyntaxDefinition();

		/**
		 * The meta object literal for the '<em><b>Start Symbol</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX_DEFINITION__START_SYMBOL = eINSTANCE.getSyntaxDefinition_StartSymbol();

		/**
		 * The meta object literal for the '<em><b>Symbols</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX_DEFINITION__SYMBOLS = eINSTANCE.getSyntaxDefinition_Symbols();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SyntaxSymbolClassifierImpl <em>Syntax Symbol Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SyntaxSymbolClassifierImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSyntaxSymbolClassifier()
		 * @generated
		 */
		EClass SYNTAX_SYMBOL_CLASSIFIER = eINSTANCE.getSyntaxSymbolClassifier();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ComplexSymbolImpl <em>Complex Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ComplexSymbolImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getComplexSymbol()
		 * @generated
		 */
		EClass COMPLEX_SYMBOL = eINSTANCE.getComplexSymbol();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ConceptImpl <em>Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ConceptImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getConcept()
		 * @generated
		 */
		EClass CONCEPT = eINSTANCE.getConcept();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.MetaSymbolImpl <em>Meta Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.MetaSymbolImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getMetaSymbol()
		 * @generated
		 */
		EClass META_SYMBOL = eINSTANCE.getMetaSymbol();

		/**
		 * The meta object literal for the '<em><b>Possible Syntax</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_SYMBOL__POSSIBLE_SYNTAX = eINSTANCE.getMetaSymbol_PossibleSyntax();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SyntaxExpressionImpl <em>Syntax Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SyntaxExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSyntaxExpression()
		 * @generated
		 */
		EClass SYNTAX_EXPRESSION = eINSTANCE.getSyntaxExpression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L3SyntaxExpressionImpl <em>L3 Syntax Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L3SyntaxExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL3SyntaxExpression()
		 * @generated
		 */
		EClass L3_SYNTAX_EXPRESSION = eINSTANCE.getL3SyntaxExpression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L2SyntaxExpressionImpl <em>L2 Syntax Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L2SyntaxExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL2SyntaxExpression()
		 * @generated
		 */
		EClass L2_SYNTAX_EXPRESSION = eINSTANCE.getL2SyntaxExpression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.SymbolSequenceImpl <em>Symbol Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.SymbolSequenceImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getSymbolSequence()
		 * @generated
		 */
		EClass SYMBOL_SEQUENCE = eINSTANCE.getSymbolSequence();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYMBOL_SEQUENCE__SEQUENCE = eINSTANCE.getSymbolSequence_Sequence();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.L1SyntaxExpressionImpl <em>L1 Syntax Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.L1SyntaxExpressionImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getL1SyntaxExpression()
		 * @generated
		 */
		EClass L1_SYNTAX_EXPRESSION = eINSTANCE.getL1SyntaxExpression();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StructuralSymbolReferenceImpl <em>Structural Symbol Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StructuralSymbolReferenceImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStructuralSymbolReference()
		 * @generated
		 */
		EClass STRUCTURAL_SYMBOL_REFERENCE = eINSTANCE.getStructuralSymbolReference();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_SYMBOL_REFERENCE__LIST = eINSTANCE.getStructuralSymbolReference_List();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_SYMBOL_REFERENCE__COMPOSITE = eINSTANCE.getStructuralSymbolReference_Composite();

		/**
		 * The meta object literal for the '<em><b>Local Scoped Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_SYMBOL_REFERENCE__LOCAL_SCOPED_REFERENCE = eINSTANCE.getStructuralSymbolReference_LocalScopedReference();

		/**
		 * The meta object literal for the '<em><b>Global Scoped Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCTURAL_SYMBOL_REFERENCE__GLOBAL_SCOPED_REFERENCE = eINSTANCE.getStructuralSymbolReference_GlobalScopedReference();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.PlainSymbolReferenceImpl <em>Plain Symbol Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.PlainSymbolReferenceImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getPlainSymbolReference()
		 * @generated
		 */
		EClass PLAIN_SYMBOL_REFERENCE = eINSTANCE.getPlainSymbolReference();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAIN_SYMBOL_REFERENCE__CLASSIFIER = eINSTANCE.getPlainSymbolReference_Classifier();

		/**
		 * The meta object literal for the '<em><b>Owned Classifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAIN_SYMBOL_REFERENCE__OWNED_CLASSIFIER = eINSTANCE.getPlainSymbolReference_OwnedClassifier();

		/**
		 * The meta object literal for the '<em><b>Referenced Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAIN_SYMBOL_REFERENCE__REFERENCED_CLASSIFIER = eINSTANCE.getPlainSymbolReference_ReferencedClassifier();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ElementarySymbolImpl <em>Elementary Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ElementarySymbolImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getElementarySymbol()
		 * @generated
		 */
		EClass ELEMENTARY_SYMBOL = eINSTANCE.getElementarySymbol();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IdSymbolImpl <em>Id Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IdSymbolImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIdSymbol()
		 * @generated
		 */
		EClass ID_SYMBOL = eINSTANCE.getIdSymbol();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.IntSymbolImpl <em>Int Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.IntSymbolImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getIntSymbol()
		 * @generated
		 */
		EClass INT_SYMBOL = eINSTANCE.getIntSymbol();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.StringSymbolImpl <em>String Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.StringSymbolImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getStringSymbol()
		 * @generated
		 */
		EClass STRING_SYMBOL = eINSTANCE.getStringSymbol();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.KeywordImpl <em>Keyword</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.KeywordImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getKeyword()
		 * @generated
		 */
		EClass KEYWORD = eINSTANCE.getKeyword();

		/**
		 * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEYWORD__KEYWORD = eINSTANCE.getKeyword_Keyword();

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
		 * The meta object literal for the '{@link hub.sam.dbl.impl.CreateIdStatementImpl <em>Create Id Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.CreateIdStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getCreateIdStatement()
		 * @generated
		 */
		EClass CREATE_ID_STATEMENT = eINSTANCE.getCreateIdStatement();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpansionStatementImpl <em>Expansion Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpansionStatementImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpansionStatement()
		 * @generated
		 */
		EClass EXPANSION_STATEMENT = eINSTANCE.getExpansionStatement();

		/**
		 * The meta object literal for the '<em><b>Class Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPANSION_STATEMENT__CLASS_CONTEXT = eINSTANCE.getExpansionStatement_ClassContext();

		/**
		 * The meta object literal for the '<em><b>Function Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPANSION_STATEMENT__FUNCTION_CONTEXT = eINSTANCE.getExpansionStatement_FunctionContext();

		/**
		 * The meta object literal for the '<em><b>Variable Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPANSION_STATEMENT__VARIABLE_CONTEXT = eINSTANCE.getExpansionStatement_VariableContext();

		/**
		 * The meta object literal for the '<em><b>Differing Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANSION_STATEMENT__DIFFERING_CONTEXT = eINSTANCE.getExpansionStatement_DifferingContext();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANSION_STATEMENT__PARTS = eINSTANCE.getExpansionStatement_Parts();

		/**
		 * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPANSION_STATEMENT__EXPRS = eINSTANCE.getExpansionStatement_Exprs();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpansionPartImpl <em>Expansion Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpansionPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpansionPart()
		 * @generated
		 */
		EClass EXPANSION_PART = eINSTANCE.getExpansionPart();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpandTextPartImpl <em>Expand Text Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpandTextPartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandTextPart()
		 * @generated
		 */
		EClass EXPAND_TEXT_PART = eINSTANCE.getExpandTextPart();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPAND_TEXT_PART__TEXT = eINSTANCE.getExpandTextPart_Text();

		/**
		 * The meta object literal for the '{@link hub.sam.dbl.impl.ExpandVariablePartImpl <em>Expand Variable Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see hub.sam.dbl.impl.ExpandVariablePartImpl
		 * @see hub.sam.dbl.impl.DblPackageImpl#getExpandVariablePart()
		 * @generated
		 */
		EClass EXPAND_VARIABLE_PART = eINSTANCE.getExpandVariablePart();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPAND_VARIABLE_PART__EXPR = eINSTANCE.getExpandVariablePart_Expr();

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
