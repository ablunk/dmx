package hub.sam.dmx;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IPropertyListener;

public interface IPreProcessedDocument {
	IPath getLocation();
	Collection<Resource> getImportedResources();
	Resource getCurrentModel();

	public final int RESOURCE_CHANGED_ID = 1;	
	void addPropertyChangedListener(IPropertyListener listener);
}
