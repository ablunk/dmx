package hub.sam.dmx.editor.semantics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;
import org.mockito.Mockito;

import hub.sam.dbl.DblPackage;
import hub.sam.dmx.editor.modelcreation.DblParser;
import hub.sam.tef.PluginFileLocator;
import hub.sam.tef.TEFPlugin;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.primitivetypes.EtslActionParameter;
import hub.sam.tef.primitivetypes.FloatDescriptor;
import hub.sam.tef.primitivetypes.IdentifierDescriptor;
import hub.sam.tef.primitivetypes.IntegerDescriptor;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.primitivetypes.StringDefDescriptor;
import hub.sam.tef.tokens.CStyleComment;
import hub.sam.tef.tokens.TokenDescriptor;
import hub.sam.tef.tsl.TslPackage;

public class DblIdentificationSchemeTest {
	
	private static final String PATH_TO_DMX_ROOT = "/Users/andreasb/Privat/Projects/dmx";
	private static final String PATH_TO_DMX_DEV = PATH_TO_DMX_ROOT + "/dev-plugins";
	private static final String PATH_TO_DMX_PLUGIN = PATH_TO_DMX_DEV + "/hub.sam.dmx";
	private static final String PATH_TO_TEF_PLUGIN = PATH_TO_DMX_DEV + "/hub.sam.tef";
	
	
	private PluginFileLocator getMockedDblPluginFileLocator() throws MalformedURLException {
		PluginFileLocator pluginFileLocator = Mockito.mock(PluginFileLocator.class);
		URL url = new URL("file://" + PATH_TO_DMX_PLUGIN + DblParser.SYNTAX_DEFINITION_FILE);
		Mockito.when(pluginFileLocator.findFile(DblParser.SYNTAX_DEFINITION_FILE)).thenReturn(url);
		
		String dblEcoreFile = "resources/dbl.ecore";
		URL dblEcoreUrl = new URL("file://" + PATH_TO_DMX_PLUGIN + "/" + dblEcoreFile);
		Mockito.when(pluginFileLocator.findFile(dblEcoreFile)).thenReturn(dblEcoreUrl);
	
		return pluginFileLocator;
	}
	
	
	private void mockTefPluginFileLocator() throws MalformedURLException {
		PluginFileLocator pluginFileLocator = Mockito.mock(PluginFileLocator.class);
		
		String extendedTslSyntaxDefinitionFile = "resources/models/etsl.tslt";
		URL extendedTslSyntaxDefinitionUrl = new URL("file://" + PATH_TO_TEF_PLUGIN + "/" + extendedTslSyntaxDefinitionFile);
		Mockito.when(pluginFileLocator.findFile(extendedTslSyntaxDefinitionFile)).thenReturn(extendedTslSyntaxDefinitionUrl);

		String tslSyntaxDefinitionFile = "resources/models/tsl.tsl";
		URL tslSyntaxDefinitionUrl = new URL("file://" + PATH_TO_TEF_PLUGIN + "/" + tslSyntaxDefinitionFile);
		Mockito.when(pluginFileLocator.findFile(tslSyntaxDefinitionFile)).thenReturn(tslSyntaxDefinitionUrl);
		
		String etslEcoreFile = "resources/models/etsl.ecore";
		URL etslEcoreUrl = new URL("file://" + PATH_TO_TEF_PLUGIN + "/" + etslEcoreFile);
		Mockito.when(pluginFileLocator.findFile(etslEcoreFile)).thenReturn(etslEcoreUrl);

		String dblEcoreFile = "resources/dbl.ecore";
		URL dblEcoreUrl = new URL("file://" + PATH_TO_DMX_PLUGIN + "/" + dblEcoreFile);
		Mockito.when(pluginFileLocator.findFile(dblEcoreFile)).thenReturn(dblEcoreUrl);

		TEFPlugin.setPluginFileLocator(pluginFileLocator);
	}
	
	
	private void mockTefDescriptors() {
		Collection<PrimitiveTypeDescriptor> primitiveTypeDescriptors = new ArrayList<>();
		primitiveTypeDescriptors.add(new IdentifierDescriptor());
		primitiveTypeDescriptors.add(new StringDefDescriptor());
		primitiveTypeDescriptors.add(new IntegerDescriptor());
		primitiveTypeDescriptors.add(new FloatDescriptor());
		primitiveTypeDescriptors.add(new EtslActionParameter());
		PrimitiveTypeDescriptor.setRegisteredTypeDescriptors(primitiveTypeDescriptors);
		
		Collection<TokenDescriptor> tokenDescriptors = new ArrayList<>();
		tokenDescriptors.add(new CStyleComment());
		TokenDescriptor.setRegisteredTokenDescriptors(tokenDescriptors);
	}
	
	
	private void setupEmf() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		EcorePackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("tsl", new XMIResourceFactoryImpl());
		TslPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("etslt", new XMIResourceFactoryImpl());
		EtslPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("dbl", new XMIResourceFactoryImpl());
		DblPackage.eINSTANCE.eClass();

		EcorePlugin.getPlatformResourceMap().put("hub.sam.tef", 
				URI.createFileURI(new File(PATH_TO_TEF_PLUGIN + "/.").getAbsolutePath()));

	}


	@Test
	public void basicDblParse() throws ModelCreatingException, MalformedURLException {
		setupEmf();
		mockTefPluginFileLocator();
		mockTefDescriptors();
		
		IPath inputPath = new Path(PATH_TO_DMX_PLUGIN);
		System.out.println(inputPath.toString());
		
		DblParser dblParser = new DblParser(inputPath, "hello-world.dbl");
		dblParser.setPluginFileLocator(getMockedDblPluginFileLocator());
		IModelCreatingContext context = dblParser.parse("module test { void main() { print \"hello\"; } }");
		
		System.out.println("errors:" + context.getErrors().size());
		System.out.println(context.getText().toString());
		
		System.out.println("test finished!");
	}
	
}
