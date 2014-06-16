package hub.sam.edu.modsoft.bf

import hub.sam.edu.modsoft.bfmodel.bf.BfFactory;
import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import hub.sam.edu.modsoft.bfmodel.bf.Flow
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.impl.EObjectImpl
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EcorePackage

class GenerateTargetCode {
	
	def public static void main(String[] args) {
		val ResourceSet resourceSet = new ResourceSetImpl();
		
		// meta-model
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bf", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(BfPackage::eNS_URI, BfPackage::eINSTANCE);
		
		// model resource
		val URI fileURI = URI::createFileURI(new File("resources/test.bf").getAbsolutePath());
		val Resource res = resourceSet.createResource(fileURI);

		// use meta-class for which Java class exists
		val Box box = BfFactory::eINSTANCE.createBox();
		box.setName("A");
		res.getContents().add(box);
		
		val Flow flow = BfFactory::eINSTANCE.createFlow();
		box.flows.add(flow);
		flow.setSourceBox(box);
		flow.setTargetBox(box);
		
		// use dynamically created meta-class with no existing Java class
		val EClass itemClass = EcoreFactory::eINSTANCE.createEClass();
		itemClass.setName("Item");

		BfPackage::eINSTANCE.getEClassifiers().add(itemClass);

		val EAttribute nameAttribute = EcoreFactory::eINSTANCE.createEAttribute();
		val it = nameAttribute
		setName("itemName");
		setEType(EcorePackage::eINSTANCE.EString);
		itemClass.getEStructuralFeatures().add(nameAttribute);
		
		// use dynamically created meta-class, which in addition extends an existing meta-class
		// NOTE the key to success seems to be to add the super-class after all structural features have been added
		itemClass.ESuperTypes.add(BfPackage::eINSTANCE.box)

		val EObjectImpl item = EcoreFactory::eINSTANCE.createEObject() as EObjectImpl;
		item.eSetClass(itemClass);
		res.getContents().add(item);

		item.eSet(nameAttribute, "blub");
		item.eSet(itemClass.EAllStructuralFeatures.findFirst[ sf | sf.name.equals("name") ], "boing")
		
		println(BfPackage::eINSTANCE.box.isSuperTypeOf(itemClass))
		
		try {
			res.save(Collections::EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		(new GenerateTargetCode).generate(res);
	}
	
	def public void generate(Resource res) {
		res.contents.forEach[ eObject | println(compile(eObject)) ]
	}
	
	def public dispatch compile(EObject eObject) {
		switch eObject {
			case eObject.eClass.name.equals("Item"):
				'''
				Item
					«eObject.eGet(eObject.eClass.EAllStructuralFeatures.findFirst[ sf | sf.name.equals("itemName") ])»
					«eObject.eGet(eObject.eClass.EAllStructuralFeatures.findFirst[ sf | sf.name.equals("name") ])»
				.
				'''
			default: "<unknown eobject>"
		}
	}
	
	def public dispatch compile(Box box) {
		'''
		Box «box.name» ''' + '''
			«IF !box.flows.empty»with
				«FOR flow : box.flows SEPARATOR ', '»
				flow from «flow.sourceBox.name» to «flow.targetBox.name»
				«ENDFOR»
			«ENDIF».
		'''.toString.trim
	}
	
}