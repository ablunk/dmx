package hub.sam.edu.modsoft.bf;

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

public class Bf3 {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bf", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(BfPackage.eNS_URI, BfPackage.eINSTANCE);
        
		Box box = BfFactory.eINSTANCE.createBox();
		box.setName("A");
		
		URI fileURI = URI.createFileURI(new File("resources/test.bf").getAbsolutePath());
		Resource res = resourceSet.createResource(fileURI);
		
		res.getContents().add(box);
		
		try {
			res.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (EObject obj: res.getContents()) {
			if (obj instanceof Box) {
				Box b = (Box) obj;
				System.out.println("Box " + b.getName() + ".");
			}
		}
	}

}
