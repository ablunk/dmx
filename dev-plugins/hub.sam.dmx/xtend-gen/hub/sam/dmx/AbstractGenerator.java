package hub.sam.dmx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class AbstractGenerator {
  protected final IPath outputFolder;
  
  public AbstractGenerator(final IPath outputFolder) {
    this.outputFolder = outputFolder;
  }
  
  protected void makeFolder(final IPath folder) {
    String _string = folder.toString();
    final File folder_fileObject = new File(_string);
    boolean _and = false;
    boolean _exists = folder_fileObject.exists();
    boolean _not = (!_exists);
    if (!_not) {
      _and = false;
    } else {
      boolean _mkdirs = folder_fileObject.mkdirs();
      boolean _not_1 = (!_mkdirs);
      _and = _not_1;
    }
    if (_and) {
      throw new RuntimeException("could not create java package folder structure.");
    }
  }
  
  protected void makeFolder(final String folder) {
    final File folder_fileObject = new File(folder);
    boolean _and = false;
    boolean _exists = folder_fileObject.exists();
    boolean _not = (!_exists);
    if (!_not) {
      _and = false;
    } else {
      boolean _mkdirs = folder_fileObject.mkdirs();
      boolean _not_1 = (!_mkdirs);
      _and = _not_1;
    }
    if (_and) {
      throw new RuntimeException("could not create java package folder structure.");
    }
  }
  
  protected Writer beginTargetFile(final String fileName) {
    try {
      final File file = new File(fileName);
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      File _absoluteFile = file.getAbsoluteFile();
      final FileWriter fileWriter = new FileWriter(_absoluteFile);
      final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      return bufferedWriter;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Writer beginTargetFile(final IPath folder, final String fileName) {
    try {
      IPath _append = folder.append(fileName);
      String _string = _append.toString();
      final File file = new File(_string);
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      File _absoluteFile = file.getAbsoluteFile();
      final FileWriter fileWriter = new FileWriter(_absoluteFile);
      final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      return bufferedWriter;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void endTargetFile(final Writer targerWriter) {
    try {
      targerWriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
