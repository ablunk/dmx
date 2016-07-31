package hub.sam.edu.modsoft.bf;

import hub.sam.edu.modsoft.bfmodel.bf.BfFactory;
import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;
import hub.sam.edu.modsoft.bfmodel.bf.Flow;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class SaveCrossResourceReferences {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bf", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(BfPackage.eNS_URI, BfPackage.eINSTANCE);
        
		URI test1FileURI = URI.createFileURI(new File("resources/test1.bf").getAbsolutePath());
		Resource resource1 = resourceSet.createResource(test1FileURI);

		URI test2FileURI = URI.createFileURI(new File("resources/test2.bf").getAbsolutePath());
		Resource resource2 = resourceSet.createResource(test2FileURI);

		URI metamodelFileURI = URI.createFileURI(new File("resources/bf.ecore").getAbsolutePath());
		Resource metamodelResource = resourceSet.getResource(metamodelFileURI, true);

		Box boxA = BfFactory.eINSTANCE.createBox();
		boxA.setName("A");
		resource1.getContents().add(boxA);
		
		Box boxB = BfFactory.eINSTANCE.createBox();
		boxB.setName("B");
		resource1.getContents().add(boxB);
		
		Flow flow = BfFactory.eINSTANCE.createFlow();
		flow.setSourceBox(boxA);
		flow.setTargetBox(boxB);
		resource2.getContents().add(flow);
		
		TreeIterator<EObject> iterator = metamodelResource.getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (eClass.getName().equals("Box")) {
					boxA.setMetaClass(eClass);
					boxB.setMetaClass(eClass);
				}
			}
		}
		
		try {
			resource1.save(Collections.EMPTY_MAP);
			resource2.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void printBoxContents(EObject eObject) {
		for (EObject content: eObject.eContents()) {
			if (content instanceof Box) {
				Box b = (Box) content;
				System.out.println("Box " + b.getName() + ".");
				printBoxContents(b);
			}
		}
	}

}
