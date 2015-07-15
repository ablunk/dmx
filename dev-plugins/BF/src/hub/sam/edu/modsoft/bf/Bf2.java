package hub.sam.edu.modsoft.bf;

import hub.sam.edu.modsoft.bfmodel.bf.BfFactory;
import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Bf2 {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bf", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(BfPackage.eNS_URI, BfPackage.eINSTANCE);
        
		URI fileURI = URI.createFileURI(new File("resources/test.bf").getAbsolutePath());
		Resource res = resourceSet.createResource(fileURI);

		Box boxA = BfFactory.eINSTANCE.createBox();
		boxA.setName("A");
		res.getContents().add(boxA);
		
		Box boxB = BfFactory.eINSTANCE.createBox();
		boxB.setName("A.B");
		boxA.getOwnedBoxes().add(boxB);

		Box boxC = BfFactory.eINSTANCE.createBox();
		boxC.setName("A.C");
		boxA.getOwnedBoxes().add(boxC);

		Box boxD = BfFactory.eINSTANCE.createBox();
		boxD.setName("A.B.D");
		boxB.getOwnedBoxes().add(boxD);
		
		TreeIterator<EObject> contentIterator = boxA.eAllContents();
		while (contentIterator.hasNext()) {
			EObject current = contentIterator.next();
			if (current instanceof Box) {
				Box b = (Box) current;
				System.out.println("Box " + b.getName() + ".");
			}
		}
		
		try {
			res.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
