package hub.sam.dmx.semantics;

import hub.sam.dmx.Activator;
import hub.sam.dmx.modelcreation.IObjectPositionsContainer;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.Substitution;

import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.Position;

public class IncrementalModificationApplier {

	protected static final Logger logger = Logger.getLogger(IncrementalModificationApplier.class.getName());

	private final Resource workingModelResource;
	private final IObjectPositionsContainer objectPositions;
	private final StringBuffer workingText;
	
	public IncrementalModificationApplier(StringBuffer originalText, 
			IObjectPositionsContainer objectPositions, Resource workingModelResource) {
		this.workingText = originalText;
		this.objectPositions = objectPositions;
		this.workingModelResource = workingModelResource;
	}
	
	public String getWorkingText() {
		return workingText.toString();
	}
	
	private EObject setStartLength(Modification mod) {
		EObject positionObject = workingModelResource.getEObject(mod.getSourceEObjectUri());
		
		Position position = objectPositions.getPosition(positionObject);
		
		if (mod instanceof Substitution) {
			Substitution sub = (Substitution) mod;
			sub.setSourceStart(position.getOffset());
			sub.setSourceLength(position.getLength());
		}
		else if (mod instanceof Addition) {
			Addition addition = (Addition) mod;
			if (addition.isAddAfterPosition()) {
				addition.setSourceStart(position.getOffset() + position.getLength());
			}
			else {
				addition.setSourceStart(position.getOffset());
			}
		}
		
		return positionObject;
	}
	
	private void shiftObjects(EObject referenceObject, boolean after, int v, boolean includeRefObjectChilds) {
		// all contents of dbl.Model
		TreeIterator<EObject> rootContentsTree = referenceObject.eResource().getContents().get(0).eAllContents();
		
		EObject current = null;
		Position referenceObjectPosition = objectPositions.getPosition(referenceObject);

		// shift all objects before referenceObject
		while (rootContentsTree.hasNext()) {
			current = rootContentsTree.next();
			Position currentPosition = objectPositions.getPosition(current);

			if (current == referenceObject) {
				if (!includeRefObjectChilds) rootContentsTree.prune();
				
				if (!after) {
					logger.info("shifting object " + current.eResource().getURIFragment(current) + " by " + v + " characters");
					currentPosition.setOffset(currentPosition.getOffset() + v);
					// TODO the length of all objects that the referenceObject is contained in has to be adapted
				}
			}
			else if (currentPosition.getOffset() > referenceObjectPosition.getOffset()) {
				logger.info("shifting object " + current.eResource().getURIFragment(current) + " by " + v + " characters");
				currentPosition.setOffset(currentPosition.getOffset() + v);
			}
		}
	}
	
	public void applyAll(EList<Modification> unsortedModifications) {
		boolean substitutionApplied = false;

		// apply modifications, adjust positions for other constructs						
		for (Modification mod: unsortedModifications) {
			
			EObject positionObject = setStartLength(mod);
			int startPos = mod.getSourceStart();
			
			if (mod instanceof Addition) {
				Addition addition = (Addition) mod;
				
				logger.info("inserting at text position: " + startPos + ", just after ... " + Activator.lineSep
						+ workingText.substring((startPos - 20 < 0 ? 0 : startPos - 20), startPos) + Activator.lineSep);
				
				workingText.insert(startPos, addition.getReplacementText());

				// adjust positions for other constructs
				shiftObjects(positionObject, addition.isAddAfterPosition(), addition.getReplacementText().length(), false);
			}
			else if (mod instanceof Substitution) {
				if (substitutionApplied) {
					logger.severe("there are at least 2 substitution modifications. an extension can only be substituted once.");
					throw new RuntimeException();
				}
				substitutionApplied = true;
				
				Substitution sub = (Substitution) mod;
				
				int endPos = startPos + sub.getSourceLength();
				
				String sourceFragment = workingText.substring(startPos, endPos);					
				logger.info("substituting source fragement: " + Activator.lineSep +
						sourceFragment + Activator.lineSep
						+ "by: " + Activator.lineSep +
						mod.getReplacementText() + Activator.lineSep);
				
				workingText.replace(startPos, endPos, mod.getReplacementText());

				shiftObjects(positionObject, true, mod.getReplacementText().length() - sub.getSourceLength(), false);
			}				

			logger.info("new working text: " + Activator.lineSep
					+ workingText + Activator.lineSep);
		}
	}
	
}
