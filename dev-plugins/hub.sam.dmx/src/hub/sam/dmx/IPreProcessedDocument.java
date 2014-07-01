package hub.sam.dmx;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;

public interface IPreProcessedDocument {
	IPath getLocation();
	Collection<Resource> getImportedResources();
	Resource getCurrentModel();
}
