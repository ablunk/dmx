package hub.sam.dmx.examples;

import hub.sam.dbl.DblPackage;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class Test {

	public static void main(String[] args) {
		String xmiFile = "/Users/blunk/Projekte/Entwicklungen/dmx/runtime-plugins/Examples/src-dmx/unless/test-unless.xmi";

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
    	
		URI metamodelUri = URI.createFileURI(new File("/Users/blunk/Projekte/Entwicklungen/dmx/runtime-plugins/Examples/temp/dbl.ecore").getAbsolutePath());
		Resource metamodelResource = resourceSet.getResource(metamodelUri, true);
		EObject rootObject = metamodelResource.getContents().get(0);
		if (rootObject instanceof EPackage) {
			EPackage metamodelPackage = (EPackage) rootObject;
			resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, metamodelPackage);
		}
		
		//resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, DblPackage.eINSTANCE);
    	
    	// TODO load temp/dbl.ecore and add all missing meta-classes
    	
		URI eblProgramFileUri = URI.createFileURI(new File(xmiFile).getAbsolutePath());		
		Resource eblProgramResource = resourceSet.getResource(eblProgramFileUri, true);
		
		System.out.println(eblProgramResource.getContents().get(0));
	}

}
