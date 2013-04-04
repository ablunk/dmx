package hub.sam.dmx;

import hub.sam.dbl.DblPackage;
//import hub.sam.dbl.Unless2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

// this class gets generated from the semantics part
public class Unless2SemanticsStatic {

	private static FileWriter fstream;
	private static BufferedWriter out;

	public static void main(String[] args) {
		try {
			FileWriter errStreamFile = new FileWriter("debug.txt");
			BufferedWriter err = new BufferedWriter(errStreamFile);
			err.write("starting ...\n");
			
			try {

				String xmiFile = args[0];
				String extensionInstanceUri = args[1];
		
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		    	resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, DblPackage.eINSTANCE);
		        
				//URI fileURI = URI.createFileURI(new File("resources/test.bf").getAbsolutePath());
				URI fileURI = URI.createFileURI(new File(xmiFile).getAbsolutePath());
				Resource res = resourceSet.getResource(fileURI, true);

				//Unless2 extensionInstance = (Unless2) res.getEObject(extensionInstanceUri);
		    
				fstream = new FileWriter("out.txt");
				out = new BufferedWriter(fstream);

				// TODO generate code below by executing a transformation
			    //gen("if (!(" + extensionInstance.getCondition().getConcreteSyntax() + "))" + extensionInstance.getCodeBlock().getConcreteSyntax());
				
			    out.close();
			}
			catch (Exception e) {// Catch exception if any
				err.write("Error: " + e.getMessage() + "\n");
			}
			finally {
				err.close();
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void gen(String str) throws IOException {
		out.write(str);
	}

}
