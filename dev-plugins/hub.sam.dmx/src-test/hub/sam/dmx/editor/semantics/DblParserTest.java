package hub.sam.dmx.editor.semantics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import org.apache.bsf.util.IOUtils;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import hub.sam.dmx.TestDataDriver;
import hub.sam.dmx.editor.modelcreation.DblParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParserError;

@RunWith(Parameterized.class)
public class DblParserTest {
	
	private static TestDataDriver testDataDriver;

	@Parameters
	public static Object[] testFiles() {
	    return new Object[] { "hello.dbl", "yieldto.dbl" };
	}
	
	@Parameter
	public String fileName;
	
	@BeforeClass
	public static void setup() {
		testDataDriver = new TestDataDriver();
		testDataDriver.setupEnvironment();		
	}
    
	@Test
	public void parseEachTestFile() throws ModelCreatingException, IOException {
		IPath inputPath = new Path(testDataDriver.getDmxPluginLocation());		
		DblParser dblParser = new DblParser(inputPath, fileName);
		dblParser.setPluginFileLocator(testDataDriver.getMockedDblPluginFileLocator());
		
		java.nio.file.Path blFile = Paths.get(URI.create(testDataDriver.getDmxPluginLocation() + "/resources/test/" + fileName));
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
