package hub.sam.dmx.editor.semantics;

import java.net.MalformedURLException;

import org.assertj.core.api.Assertions;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import hub.sam.dmx.TestDataDriver;
import hub.sam.dmx.editor.modelcreation.DblParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;

public class DblParserTest {
	
	private TestDataDriver testDataDriver = new TestDataDriver();

	@Test
	public void helloWorld() throws ModelCreatingException, MalformedURLException {
		testDataDriver.setupEnvironment();
		
		IPath inputPath = new Path(testDataDriver.getDmxPluginLocation());		
		DblParser dblParser = new DblParser(inputPath, "hello-world.dbl");
		dblParser.setPluginFileLocator(testDataDriver.getMockedDblPluginFileLocator());
		IModelCreatingContext context = dblParser.parse("module test { void main() { print \"hello\"; } }");
		
		Assertions.assertThat(context.getErrors()).isEmpty();
	}
	
}
