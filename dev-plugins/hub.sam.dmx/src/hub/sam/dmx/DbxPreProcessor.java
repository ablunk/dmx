package hub.sam.dmx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;

import hub.sam.dbl.Model;

public class DbxPreProcessor extends DblPreProcessor {

	private IExtensionDefinitionApplier extensionDefinitionApplier;
	
	public DbxPreProcessor(IExtensionDefinitionApplier extensionDefinitionApplier, String filename, DbxTextEditor openedEditor) {
		super(filename, openedEditor);
		this.extensionDefinitionApplier = extensionDefinitionApplier;
	}
	
	private Collection<String> processedFileImports = new HashSet<String>();
	
	private boolean processExtensionDefinitionsOutsideToInside(String inputText, IPath inputPath) {
		Pattern importRegex = Pattern.compile("#import \"(.+)\"");
		Matcher matcher = importRegex.matcher(inputText);
		boolean added = false;
		
		while (matcher.find()) {
			final String fileToImport = matcher.group(1);

			if (!processedFileImports.contains(fileToImport)) {
				processedFileImports.add(fileToImport);
				Resource resourceForImport = null;
				
				DblTextEditor openedEditor = getOpenedEditorForImport(fileToImport, false);
				if (openedEditor != null) {
					processExtensionDefinitionsOutsideToInside(openedEditor.getCurrentText(), inputPath);
					resourceForImport = openedEditor.getCurrentModel();
				}
				else {
					// load text from file
					IPath dblImport = inputPath.append(fileToImport).addFileExtension("dbl");
					IPath dbxImport = inputPath.append(fileToImport).addFileExtension("dbx");
					
					File file = new File(dblImport.toOSString());
					if (!file.exists()) {
						file = new File(dbxImport.toOSString());
					}
					
					if (file.exists()) {
						processExtensionDefinitionsOutsideToInside(getImportLinesInContent(file), inputPath);
						resourceForImport = loadXmi(fileToImport, inputPath);
					}
				}
				
				// add extension definitions contained in import -> requires ecore model
				if (resourceForImport != null) {
					added |= extensionDefinitionApplier.addExtensionDefinitions((Model) resourceForImport.getContents().get(0));
				}
			}
		}
		
		return added;
	}
	
	private String getImportLinesInContent(File importFile) {
		FileReader fileReader;
		try {
			fileReader = new FileReader(importFile);
			BufferedReader br = new BufferedReader(fileReader);
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null && (!line.isEmpty() || line.startsWith("#import") )) {
		            sb.append(line);
		            sb.append(System.getProperty("line.separator"));
		            line = br.readLine();
		        }
		        return sb.toString();
		    }
		    catch (IOException e) {
				e.printStackTrace();
			}
		    finally {
		        try {
					br.close();
				}
		        catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void preProcess(String inputText, IPath inputPath) {
		// 1. build a pre-model of the full import tree (without importing)
		//    and add extension definitions from outside to inside (i.e. beginning at the leaves of the import tree)
		processedFileImports.clear();
		boolean extensionDefinitionsAdded = processExtensionDefinitionsOutsideToInside(inputText, inputPath);
		if (extensionDefinitionsAdded) {
			extensionDefinitionApplier.syntaxChanged();
		}
		
		// 2. process direct imports, i.e. call importFile(..) and listen for model changes
		// TODO can be optimized
		super.preProcess(inputText, inputPath);
	}

	@Override
	protected void importedModelChanged(Model model) {
		extensionDefinitionApplier.unwindExtensionDefinitionEffects(model);
		extensionDefinitionApplier.syntaxChanged();
		
		super.importedModelChanged(model);
	}

}
