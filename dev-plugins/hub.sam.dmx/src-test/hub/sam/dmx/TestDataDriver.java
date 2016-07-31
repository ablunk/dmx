package hub.sam.dmx;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.management.RuntimeErrorException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mockito.Mockito;

import hub.sam.dbl.DblPackage;
import hub.sam.dmx.editor.modelcreation.DblParser;
import hub.sam.dmx.editor.semantics.DblIdentificationSchemeTest;
import hub.sam.tef.PluginFileLocator;
import hub.sam.tef.TEFPlugin;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.primitivetypes.EtslActionParameter;
import hub.sam.tef.primitivetypes.FloatDescriptor;
import hub.sam.tef.primitivetypes.IdentifierDescriptor;
import hub.sam.tef.primitivetypes.IntegerDescriptor;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.primitivetypes.StringDefDescriptor;
import hub.sam.tef.tokens.CStyleComment;
import hub.sam.tef.tokens.TokenDescriptor;
import hub.sam.tef.tsl.TslPackage;

public class TestDataDriver {

	private static final String TEF_PLUGIN_NAME = TEFPlugin.PLUGIN_ID;
	private static final String DMX_PLUGIN_NAME = Activator.PLUGIN_ID;
	
	
	public void setupEnvironment() {
		try {
			setupEmf();
			mockTefPluginFileLocator();
			mockTefDescriptors();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public PluginFileLocator getMockedDblPluginFileLocator() throws MalformedURLException {
		String pathToDmxPlugin = getDmxPluginLocation();
		PluginFileLocator pluginFileLocator = Mockito.mock(PluginFileLocator.class);
		URL url = new URL(pathToDmxPlugin + DblParser.SYNTAX_DEFINITION_FILE);
		Mockito.when(pluginFileLocator.findFile(DblParser.SYNTAX_DEFINITION_FILE)).thenReturn(url);
		
		String dblEcoreFile = "resources/dbl.ecore";
		URL dblEcoreUrl = new URL(pathToDmxPlugin + "/" + dblEcoreFile);
		Mockito.when(pluginFileLocator.findFile(dblEcoreFile)).thenReturn(dblEcoreUrl);
	
		return pluginFileLocator;
	}
	
	
	private void mockTefPluginFileLocator() throws MalformedURLException {
		PluginFileLocator pluginFileLocator = Mockito.mock(PluginFileLocator.class);
		final String tefPluginLocation = getTefPluginLocation();
		
		String extendedTslSyntaxDefinitionFile = "resources/models/etsl.tslt";
		URL extendedTslSyntaxDefinitionUrl = new URL(tefPluginLocation + "/" + extendedTslSyntaxDefinitionFile);
		Mockito.when(pluginFileLocator.findFile(extendedTslSyntaxDefinitionFile)).thenReturn(extendedTslSyntaxDefinitionUrl);

		String tslSyntaxDefinitionFile = "resources/models/tsl.tsl";
		URL tslSyntaxDefinitionUrl = new URL(tefPluginLocation + "/" + tslSyntaxDefinitionFile);
		Mockito.when(pluginFileLocator.findFile(tslSyntaxDefinitionFile)).thenReturn(tslSyntaxDefinitionUrl);
		
		String etslEcoreFile = "resources/models/etsl.ecore";
		URL etslEcoreUrl = new URL(tefPluginLocation + "/" + etslEcoreFile);
		Mockito.when(pluginFileLocator.findFile(etslEcoreFile)).thenReturn(etslEcoreUrl);

		String pathToDmxPlugin = getDmxPluginLocation();
		String dblEcoreFile = "resources/dbl.ecore";
		URL dblEcoreUrl = new URL(pathToDmxPlugin + "/" + dblEcoreFile);
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

		final String tefPluginLocation = getTefPluginLocation();
		URI tefPluginUri = URI.createURI(tefPluginLocation).appendSegment(".");
		EcorePlugin.getPlatformResourceMap().put(TEF_PLUGIN_NAME, tefPluginUri);
	}
	
	
	public String getDmxPluginLocation() {
		String testClassLocation = this.getClass().getResource(TestDataDriver.class.getSimpleName() + ".class").toExternalForm();
		int pluginNamePosition= testClassLocation.indexOf(DMX_PLUGIN_NAME);
		String pluginLocation = testClassLocation.substring(0, pluginNamePosition + DMX_PLUGIN_NAME.length());
		return pluginLocation;
	}

	private String getTefPluginLocation() {
		String tefPluginClassWithDirectory = TEFPlugin.class.getCanonicalName().replaceAll("\\.", "/");
		String testClassLocation = this.getClass().getClassLoader().getResource(tefPluginClassWithDirectory + ".class").toExternalForm();
		int pluginNamePosition= testClassLocation.indexOf(TEF_PLUGIN_NAME);
		String pluginLocation = testClassLocation.substring(0, pluginNamePosition + TEF_PLUGIN_NAME.length());
		return pluginLocation;
	}
	
}
