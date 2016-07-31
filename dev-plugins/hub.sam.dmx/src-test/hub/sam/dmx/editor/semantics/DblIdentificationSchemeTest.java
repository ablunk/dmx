package hub.sam.dmx.editor.semantics;

import java.net.MalformedURLException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import hub.sam.dmx.TestDataDriver;
import hub.sam.dmx.editor.modelcreation.DblParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;

public class DblIdentificationSchemeTest {
	
	private TestDataDriver testDataDriver = new TestDataDriver();

	@Test
	public void basicDblParse() throws ModelCreatingException, MalformedURLException {
		testDataDriver.setupEnvironment();
		
		IPath inputPath = new Path(testDataDriver.getDmxPluginLocation());
		System.out.println(inputPath.toString());
		
		DblParser dblParser = new DblParser(inputPath, "hello-world.dbl");
		dblParser.setPluginFileLocator(testDataDriver.getMockedDblPluginFileLocator());
		IModelCreatingContext context = dblParser.parse("module test { void main() { print \"hello\"; } }");
		
		System.out.println("errors:" + context.getErrors().size());
		System.out.println(context.getText().toString());
		
		System.out.println("test finished!");
	}
	
}
