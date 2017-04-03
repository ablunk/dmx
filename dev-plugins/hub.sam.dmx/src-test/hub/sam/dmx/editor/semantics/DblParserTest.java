package hub.sam.dmx.editor.semantics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Paths;

import org.apache.bsf.util.IOUtils;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import hub.sam.dmx.TestDataDriver;
import hub.sam.dmx.editor.modelcreation.DblParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParserError;

public class DblParserTest {
	
	private TestDataDriver testDataDriver = new TestDataDriver();

	@Test
	public void helloWorld() throws ModelCreatingException, IOException {
		testDataDriver.setupEnvironment();
		
		IPath inputPath = new Path(testDataDriver.getDmxPluginLocation());		
		DblParser dblParser = new DblParser(inputPath, "hello.dbl");
		dblParser.setPluginFileLocator(testDataDriver.getMockedDblPluginFileLocator());
		
		// TODO test all files with parametric test
		java.nio.file.Path blFile = Paths.get(URI.create(testDataDriver.getDmxPluginLocation() + "/resources/test/hello.dbl"));
		String fileContent = FileUtils.readFileToString(blFile.toFile(), Charset.forName("utf-8"));
		IModelCreatingContext modelContext = dblParser.parse(fileContent);
		
		// TODO compile DBL to target language and execute
		
		if (!modelContext.getErrors().isEmpty()) {
			modelContext.getErrors().stream().forEach(error -> {
				String message = error.getMessage();
				if (error instanceof ParserError) {
					ParserError parserError = (ParserError) error;
					message += " at position: " + parserError.getPosition(null);
				}
				System.out.println(message);
			});
			Assertions.fail("found parse errors.");
		}
	}	

}
