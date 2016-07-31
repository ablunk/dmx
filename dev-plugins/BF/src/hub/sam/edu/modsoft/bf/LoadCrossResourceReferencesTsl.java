package hub.sam.edu.modsoft.bf;

import hub.sam.edu.modsoft.bfmodel.bf.BfFactory;
import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;
import hub.sam.edu.modsoft.bfmodel.bf.Flow;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.TslPackage;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class LoadCrossResourceReferencesTsl {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tsl", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(TslPackage.eNS_URI, TslPackage.eINSTANCE);
        
		resourceSet.getURIConverter().getURIMap().put(URI.createPlatformResourceURI("hub.sam.tef/resources", true).appendSegment(""), 
				URI.createFileURI(new File("/Users/andreasb/Privat/Projects/dmx/dev-plugins/hub.sam.tef/resources").getAbsolutePath()).appendSegment(""));

		URI tslFileURI = URI.createFileURI(new File("/Users/andreasb/Privat/Projects/dmx/dev-plugins/hub.sam.tef/resources/models/tsl.tsl").getAbsolutePath());
		Resource resource = resourceSet.getResource(tslFileURI, true);
		
		TreeIterator<EObject> iterator = resource.getAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof PropertyBinding) {
				PropertyBinding propertyBinding = (PropertyBinding) eObject;
				System.out.println(propertyBinding.getProperty());
				System.out.println(propertyBinding.getProperty().getName());
				System.out.println(propertyBinding.getProperty().getEContainingClass().getName());
			}
		}
	}

}
