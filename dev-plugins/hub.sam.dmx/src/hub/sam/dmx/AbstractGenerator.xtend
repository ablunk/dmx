package hub.sam.dmx

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.Writer
import org.eclipse.core.runtime.IPath

abstract class AbstractGenerator {
	
	protected val IPath outputFolder
	
	new(IPath outputFolder) {
		this.outputFolder = outputFolder;
	}
	
	def abstract void startGenerator();
	
	protected def void makeFolder(IPath folder) {
		val folder_fileObject = new File(folder.toString);
		if (!folder_fileObject.exists && !folder_fileObject.mkdirs) {
			throw new RuntimeException("could not create java package folder structure.");
		}
	}
	
	protected def void makeFolder(String folder) {
		val folder_fileObject = new File(folder);
		if (!folder_fileObject.exists && !folder_fileObject.mkdirs) {
			throw new RuntimeException("could not create java package folder structure.");
		}
	}

	protected def Writer beginTargetFile(String fileName) {
		val File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
 
		val FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
		val BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		return bufferedWriter;
	}

	protected def Writer beginTargetFile(IPath folder, String fileName) {
		val File file = new File(folder.append(fileName).toString);
		if (!file.exists()) {
			file.createNewFile();
		}
 
		val FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
		val BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		return bufferedWriter;
	}
	
	protected def void endTargetFile(Writer targerWriter) {
		targerWriter.close;
	}
	
}