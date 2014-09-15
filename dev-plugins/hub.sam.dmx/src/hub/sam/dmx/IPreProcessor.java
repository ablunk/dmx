package hub.sam.dmx;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;

public interface IPreProcessor {
	public void preProcess(String inputText, IPath inputPath);
	public IModelContainer getImportedModel(String fileOfImport);
	public Collection<IModelContainer> getImportedModels();
}
