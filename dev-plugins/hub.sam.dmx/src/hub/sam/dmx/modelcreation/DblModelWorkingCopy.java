package hub.sam.dmx.modelcreation;

import hub.sam.dbl.Model;
import hub.sam.dmx.semantics.PositionWithNegative;
import hub.sam.tef.modelcreating.IModelCreatingContext;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Position;

// Eine DblModelWorkingCopy ist eine Arbeitskopie eines DBL-Modells auf dem alle
// Erweiterungsinstanzen schrittweise aufgelöst werden.
public class DblModelWorkingCopy {
	private final Resource resource;
	private final String text;
	private final ObjectPositionsContainer objectPositions;

	/**
	 * Replaces a formerWorkingModel by a new one, which is contained in newResource.
	 * 
	 * @param formerWorkingModel
	 * @param newResource
	 * @param newResourceCreationContext
	 */
	public DblModelWorkingCopy(DblModelWorkingCopy formerWorkingModel, Resource newResource, 
			IModelCreatingContext newResourceCreationContext) {
		resource = formerWorkingModel.getResource();
		resource.getContents().clear();
		resource.getContents().addAll(newResource.getContents());
		
		text = newResourceCreationContext.getText();
		
		try {
			resource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.objectPositions = new ModelCreatingContextObjectPositionsContainer(newResourceCreationContext);
	}
	
	private class ObjectPositionCopier extends EcoreUtil.Copier {
		
		private static final long serialVersionUID = 2392567829651068424L;
		
		private final ObjectPositionsContainer originalObjectPositions;
		private final ObjectPositionsContainer copyObjectPositions = new ObjectPositionsContainer();
		
		public ObjectPositionCopier(ObjectPositionsContainer originalObjectPositions) {
			this.originalObjectPositions = originalObjectPositions;
		}

		@Override
		protected EObject createCopy(EObject original) {
			EObject copy = super.createCopy(original);
			Position originalPosition = originalObjectPositions.getPosition(original);
			if (originalPosition != null) {
				copyObjectPositions.setPosition(copy, new PositionWithNegative(originalPosition));
			}
			return copy;
		}
		
		public ObjectPositionsContainer getCopyObjectPositions() {
			return copyObjectPositions;
		}
		
	}
	
	private class ObjectPositionsContainer implements IObjectPositionsContainer {
		
		private Map<EObject, Position> positions = new HashMap<EObject, Position>();
		
		public Position getPosition(EObject eObject) {
			return positions.get(eObject);
		}
		
		public void setPosition(EObject eObject, Position position) {
			positions.put(eObject, position);
		}
	}
	
	private class ModelCreatingContextObjectPositionsContainer extends ObjectPositionsContainer {
		private final IModelCreatingContext resourceCreationContext;
		
		public ModelCreatingContextObjectPositionsContainer(IModelCreatingContext resourceCreationContext) {
			this.resourceCreationContext = resourceCreationContext;
		}

		@Override
		public Position getPosition(EObject eObject) {
			return resourceCreationContext.getTreeNodeForObject(eObject).getPosition();
		}
	}
	
	/**
	 * Creates a new working copy from the model contained in originalResource.
	 * 
	 * @param originalUri
	 * @param originalResource
	 * @param copy
	 * @param workingCopiesResourceSet
	 * @param originalResourceCreationContext
	 */
	public DblModelWorkingCopy(URI originalUri, Resource originalResource, boolean copy, 
			IModelCreatingContext originalResourceCreationContext,
			ResourceSet workingCopiesResourceSet) {
		String workingCopyXmiName = originalUri.trimFileExtension() + "_base.xmi";
		URI workingCopyXmiUri = URI.createURI(workingCopyXmiName);
		
		resource = workingCopiesResourceSet.createResource(workingCopyXmiUri);
		resource.getContents().clear();
		
		if (copy) {
			ObjectPositionCopier copier = new ObjectPositionCopier(new ModelCreatingContextObjectPositionsContainer(originalResourceCreationContext));
			Collection<EObject> contentCopy = copier.copyAll(originalResource.getContents());
			copier.copyReferences();
			resource.getContents().addAll(contentCopy);
			objectPositions = copier.getCopyObjectPositions();
		}
		else {
			resource.getContents().addAll(originalResource.getContents());
			objectPositions = new ModelCreatingContextObjectPositionsContainer(originalResourceCreationContext);
		}
		
		text = originalResourceCreationContext.getText();
		
		try {
			resource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}			
	}

	public Position getObjectPosition(EObject eObject) {
		return objectPositions.getPosition(eObject);
	}
	
	public ObjectPositionsContainer getAllObjectPositions() {
		return objectPositions;
	}
	
	public void setObjectPosition(EObject eObject, Position position) {
		objectPositions.setPosition(eObject, position);
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public String getText() {
		return text;
	}
	
	public Model getModel() {
		return (Model) resource.getContents().get(0);
	}
	
	public void save() {
		try {
			resource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
