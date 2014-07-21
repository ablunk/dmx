package hub.sam.dmx;

import hub.sam.dbl.Model;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;

public interface IPreProcessedDocument {
	IPath getPath();
//	Collection<Resource> getImportedResources();
//	Resource getCurrentModel();
	Collection<IModelContainer> getImportsModels();
	Model getModel();
}
