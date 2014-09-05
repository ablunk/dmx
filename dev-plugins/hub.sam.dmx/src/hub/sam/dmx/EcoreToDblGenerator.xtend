package hub.sam.dmx

import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcorePackage
import java.io.Writer
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EPackage

class EcoreToDblGenerator extends AbstractGenerator {
	
	new(IPath outputFolder) {
		super(outputFolder)
	}
	
	def startGenerator(String outputFile, EPackage metamodel, String javaPackagePrefix, String[] imports) {
		val Writer writer = beginTargetFile(outputFile);

		writer.write(
		'''
		«IF imports != null»
			«FOR i : imports»
				#import "«i»"
			«ENDFOR»
		«ENDIF»
		
		module «metamodel.name» {
		
		'''
		)
		metamodel.EClassifiers.filter(EClass).forEach[writer.write(genEClass(javaPackagePrefix))]
		writer.write('''
		
		}
		''')

		endTargetFile(writer)				
	}
	
	def void startGenerator() {
		makeFolder("resources-gen")
		startGenerator("resources-gen/ecore.dbl", EcorePackage.eINSTANCE, "org.eclipse.emf.ecore", null)
	}
	
	def static void main(String[] args) {
		(new EcoreToDblGenerator(null)).startGenerator
	}
	
	def String genFeature(EStructuralFeature feature) {
		val it = feature
		'''
		«genAttribute»
		«IF changeable»
			«genSetter»
		«ENDIF»
		'''
	}

	def String genAttribute(EStructuralFeature feature) {
		val it = feature
		genType + ' ' + name + ';'
	}

	def String genGetter(EStructuralFeature feature) {
		val it = feature
		genType + ' '
		+ (if (EType.name.equals("EBoolean")) 'is' else 'get')
		+ name.toFirstUpper + '() abstract;'
	}

	def String genSetter(EStructuralFeature feature) {
		val it = feature
		if (!feature.many) 'void set' + name.toFirstUpper + '(' + genType + ' value) abstract;'
	}
	
	def String genEClass(EClass eClass, String javaPackagePrefix) {
		val it = eClass
		if (!name.equals("EObject")) {
			'''
			class «name»
			«IF ESuperTypes.empty»
				extends EObject
			«ELSE»
				extends 
				«FOR superClass : ESuperTypes SEPARATOR ','»
					«superClass.name»
				«ENDFOR»
			«ENDIF»
			{
				bindings {
					"java" -> "«javaPackagePrefix».«name»"
				}
				
				«FOR feature : EStructuralFeatures»
					«feature.genFeature»
				«ENDFOR»
			}
			'''
		}
		else {
			'''
			class Object {
				bindings {
					"java" -> "java.lang.Object"
				}
			}
			
			class Class {
				bindings {
					"java" -> "java.lang.Class"
				}
			}
			
			class Enumerator {
				bindings {
					"java" -> "org.eclipse.emf.common.util.Enumerator"
				}
			}
			
			class ListIterator {
				bindings {
					"java" -> "java.util.Iterator"
				}

				boolean hasNext() abstract;
				Object next() abstract;
				void remove() abstract;
			}

			class List {
				bindings {
					"java" -> "java.util.List"
				}

			boolean add(Object e) abstract;
			boolean add(int index, Object e) abstract;
			void clear() abstract;
			boolean contains(Object e) abstract;
			int size() abstract;
			Object get(int index) abstract;
			int indexOf(Object e) abstract;
			boolean isEmpty() abstract;
			Object remove(int index) abstract;
			boolean remove(Object e) abstract;
			Object set(int index, Object e) abstract;
			Object array[] toArray() abstract;
			ListIterator iterator() abstract;
			}

			class EObject {
				bindings {
					"java" -> "org.eclipse.emf.ecore.EObject"
				}
				EClass eClass() abstract;
				//Resource eResource() abstract;
				EObject eContainer() abstract;
				EStructuralFeature eContainingFeature() abstract;
				EReference eContainmentFeature() abstract;
				List eContents() abstract;
				List eAllContents() abstract;
				//boolean eIsProxy() abstract;
				//EList eCrossReferences() abstract;
				Object eGet(EStructuralFeature feature) abstract;
				Object eGet(EStructuralFeature feature, boolean resolve) abstract;
				void eSet(EStructuralFeature feature, Object newValue) abstract;
				boolean eIsSet(EStructuralFeature feature) abstract;
				void eUnset(EStructuralFeature feature) abstract;
				//Object eInvoke(EOperation operation, Object array[] arguments) abstract;
			}
			'''
		}
	}
	
	def String genType(ETypedElement typedElement) {
		val it = typedElement
		if (EType != null) {
			if (many) {
				//'''«EType.name» array[]'''
				'List'
			}
			else {
				switch (EType.name) {
					case 'EInt': 'int'
					case 'EBigInteger': 'int'
					case 'EDouble': 'double'
					case 'EBoolean': 'boolean'
					case 'EString': 'string'
					case 'EJavaObject': 'Object'
					case 'EJavaClass': 'Class'
					case 'EEnumerator': 'Enumerator'
					default: EType.name
				}
			}
		}
		else {
			'void'
		}
	}
	
}