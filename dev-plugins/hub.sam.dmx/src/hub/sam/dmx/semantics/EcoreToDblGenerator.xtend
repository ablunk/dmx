package hub.sam.dmx.semantics

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcorePackage
import java.io.Writer
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EPackage

class EcoreToDblGenerator extends AbstractGenerator {
	
	def startGenerator(String outputFile, EPackage metamodel, String javaPackagePrefix, String[] imports) {
		val Writer writer = beginTargetFile(outputFile);

		writer.write(
		'''
		#import "stdlib"
		«IF imports != null»
			«FOR i : imports»
				#import "«i»"
			«ENDFOR»
		«ENDIF»
		
		module «metamodel.name»;
		
		'''
		)
		metamodel.EClassifiers.filter(EClass).forEach[writer.write(genEClass(javaPackagePrefix))]

		endTargetFile(writer)				
	}
	
	def void startGenerator() {
		makeFolder("resources-gen")
		startGenerator("resources-gen/ecore.dbl", EcorePackage.eINSTANCE, "org.eclipse.emf.ecore", null)
	}
	
	def static void main(String[] args) {
		(new EcoreToDblGenerator()).startGenerator
	}
	
	def String genFeature(EStructuralFeature feature) {
		val it = feature
		'''
		«genGetter»
		«IF changeable»
			«genSetter»
		«ENDIF»
		'''
	}
	
	def String escapeName(String name) {
		name
	}

	def String genAttribute(EStructuralFeature feature) {
		val it = feature
		genType + ' ' + name.escapeName + ';'
	}

	def String genGetter(EStructuralFeature feature) {
		val it = feature
		genType + ' '
		+ (if (EType.name.equals("EBoolean")) 'is' else 'get')
		+ name.escapeName.toFirstUpper + '();'
	}

	def String genSetter(EStructuralFeature feature) {
		val it = feature
		if (!feature.many) 'void set' + name.escapeName.toFirstUpper + '(' + genType + ' value);'
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
			class Enumerator {
				bindings {
					"java" -> "org.eclipse.emf.common.util.Enumerator"
				}
			}
			
			class Resource {
				bindings {
					"java" -> "org.eclipse.emf.ecore.resource.Resource"
				}
				string getURIFragment(EObject eObject);
			}
			
			string getURI(EObject eObject) {
				return eObject.eResource().getURIFragment(eObject);
			}
			
			class EList extends List {
				bindings {
					"java" -> "org.eclipse.emf.common.util.EList"
				}
				void move(int newPos, Object object);
				void move(int newPos, int oldPos);
			}

			class EObject {
				bindings {
					"java" -> "org.eclipse.emf.ecore.EObject"
				}
				Resource eResource();
				EClass eClass();
				EObject eContainer();
				EStructuralFeature eContainingFeature();
				EReference eContainmentFeature();
				EList eContents();
				EList eAllContents();
				EList eCrossReferences();
				Object eGet(EStructuralFeature feature);
				Object eGet(EStructuralFeature feature, boolean resolve);
				void eSet(EStructuralFeature feature, Object newValue);
				boolean eIsSet(EStructuralFeature feature);
				void eUnset(EStructuralFeature feature);
				//boolean eIsProxy();
				//Object eInvoke(EOperation operation, Object array[] arguments);
			}
			'''
		}
	}
	
	def String genType(ETypedElement typedElement) {
		val it = typedElement
		if (EType != null) {
			if (many) {
				'EList'
			}
			else {
				switch (EType.name) {
					case 'EInt': 'int'
					case 'EBigInteger': 'int'
					case 'EDouble': 'double'
					case 'EBoolean': 'boolean'
					case 'EString': 'string'
					case 'EJavaObject': 'Object'
					case 'EJavaClass': 'JavaClass'
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