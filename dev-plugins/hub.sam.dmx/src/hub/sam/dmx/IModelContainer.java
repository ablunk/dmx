package hub.sam.dmx;

import org.eclipse.emf.ecore.resource.Resource;

import hub.sam.dbl.Model;

public interface IModelContainer {
	Model getModel();
	Resource getResource();
}
