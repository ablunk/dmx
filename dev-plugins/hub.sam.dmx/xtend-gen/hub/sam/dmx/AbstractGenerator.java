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
  
  public abstract void startGenerator();
  
  protected void makeFolder(final IPath folder) {
    String _string = folder.toString();
    File _file = new File(_string);
    final File folder_fileObject = _file;
    boolean _and = false;
    boolean _exists = folder_fileObject.exists();
    boolean _not = (!_exists);
    if (!_not) {
      _and = false;
    } else {
      boolean _mkdirs = folder_fileObject.mkdirs();
      boolean _not_1 = (!_mkdirs);
      _and = (_not && _not_1);
    }
    if (_and) {
      RuntimeException _runtimeException = new RuntimeException("could not create java package folder structure.");
      throw _runtimeException;
    }
  }
  
  protected void makeFolder(final String folder) {
    File _file = new File(folder);
    final File folder_fileObject = _file;
    boolean _and = false;
    boolean _exists = folder_fileObject.exists();
    boolean _not = (!_exists);
    if (!_not) {
      _and = false;
    } else {
      boolean _mkdirs = folder_fileObject.mkdirs();
      boolean _not_1 = (!_mkdirs);
      _and = (_not && _not_1);
    }
    if (_and) {
      RuntimeException _runtimeException = new RuntimeException("could not create java package folder structure.");
      throw _runtimeException;
    }
  }
  
  protected Writer beginTargetFile(final String fileName) {
    try {
      File _file = new File(fileName);
      final File file = _file;
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      File _absoluteFile = file.getAbsoluteFile();
      FileWriter _fileWriter = new FileWriter(_absoluteFile);
      final FileWriter fileWriter = _fileWriter;
      BufferedWriter _bufferedWriter = new BufferedWriter(fileWriter);
      final BufferedWriter bufferedWriter = _bufferedWriter;
      return bufferedWriter;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Writer beginTargetFile(final IPath folder, final String fileName) {
    try {
      IPath _append = folder.append(fileName);
      String _string = _append.toString();
      File _file = new File(_string);
      final File file = _file;
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      File _absoluteFile = file.getAbsoluteFile();
      FileWriter _fileWriter = new FileWriter(_absoluteFile);
      final FileWriter fileWriter = _fileWriter;
      BufferedWriter _bufferedWriter = new BufferedWriter(fileWriter);
      final BufferedWriter bufferedWriter = _bufferedWriter;
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
