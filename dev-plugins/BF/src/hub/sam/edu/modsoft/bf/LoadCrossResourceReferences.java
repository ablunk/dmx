package hub.sam.edu.modsoft.bf;

import hub.sam.edu.modsoft.bfmodel.bf.BfFactory;
import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;
import hub.sam.edu.modsoft.bfmodel.bf.Flow;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class LoadCrossResourceReferences {

	public static void main(String[] args) throws URISyntaxException {
		ResourceSet resourceSet = new ResourceSetImpl();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		EcorePackage.eINSTANCE.eClass();

		//resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		//resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bf", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(BfPackage.eNS_URI, BfPackage.eINSTANCE);
        
		EcorePlugin.getPlatformResourceMap().put("BF",
				URI.createFileURI(new File("./").getAbsolutePath()));
		//resourceSet.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("BF/resources", true).appendSegment(""), 
		//		URI.createFileURI(new File("resources").getAbsolutePath()).appendSegment(""));
		
		URI ecoreJarURI = URI.createURI(EcorePlugin.INSTANCE.getBaseURL().toURI().toString());
		System.out.println(ecoreJarURI);
		resourceSet.getURIConverter().getURIMap().put(URI.createURI("platform:/plugin/org.eclipse.emf.ecore/"), ecoreJarURI);
		
		URI test2FileURI = URI.createFileURI(new File("resources/test2.bf").getAbsolutePath());
		Resource resource = resourceSet.getResource(test2FileURI, true);
		
		for (EObject eObject: resource.getContents()) {
			if (eObject instanceof Flow) {
				Flow flow = (Flow) eObject;
				System.out.println("source: " + flow.getSourceBox().getName());
				System.out.println("target: " + flow.getTargetBox().getName());
				
				System.out.println(flow.getSourceBox().getMetaClass());
				System.out.println(flow.getSourceBox().getMetaClass().getName());
			}
		}
	}

}
