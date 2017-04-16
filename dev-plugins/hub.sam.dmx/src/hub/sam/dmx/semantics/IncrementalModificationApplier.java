package hub.sam.dmx.semantics;

import hub.sam.dmx.Activator;
import hub.sam.dmx.modelcreation.IObjectPositionsContainer;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.Substitution;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
	
	public void applyAll(EList<Modification> modifications) {
		boolean substitutionApplied = false;
		
		for (int i=0; i<modifications.size(); i++) {
			Modification modification = modifications.get(i);
			
			EObject referenceObject = getReferenceObject(modification);
			Position referencePosition = objectPositions.getPosition(referenceObject);

			int referenceOffset = referencePosition.getOffset();
			int referenceOffsetDelta = 0;

			if (modification instanceof Addition) {
				Addition addition = (Addition) modification;
				
				logger.info("inserting at text position: " + referenceOffset + ", just after ... " + Activator.lineSep
						+ workingText.substring((referenceOffset - 20 < 0 ? 0 : referenceOffset - 20), referenceOffset) + Activator.lineSep);
				
				if (addition.isAddAfterPosition()) {
					referenceOffset += referencePosition.getLength();
				}
				workingText.insert(referenceOffset, addition.getReplacementText());

				referenceOffsetDelta = addition.getReplacementText().length();
				TreeIterator<EObject> rootObjectIterator = workingModelResource.getContents().get(0).eAllContents();
				shiftObjectsAffectedByAdditionAfter(rootObjectIterator, referencePosition, referenceOffsetDelta);
				
			}
			else if (modification instanceof Substitution) {
				if (substitutionApplied) {
					logger.severe("there are at least 2 substitution modifications. an extension can only be substituted once.");
					throw new RuntimeException();
				}
				substitutionApplied = true;
				
				Substitution sub = (Substitution) modification;
				
				int endOffset = referenceOffset + referencePosition.getLength();
				
				String sourceFragment = workingText.substring(referenceOffset, endOffset);					
				logger.info("substituting source fragement: " + Activator.lineSep +
						sourceFragment + Activator.lineSep
						+ "by: " + Activator.lineSep +
						modification.getReplacementText() + Activator.lineSep);
				
				workingText.replace(referenceOffset, endOffset, modification.getReplacementText());
				referenceOffsetDelta = sub.getReplacementText().length() - referencePosition.getLength();
				
				TreeIterator<EObject> rootObjectIterator = workingModelResource.getAllContents();
				shiftObjectsAffectedBySubstitution(rootObjectIterator, referencePosition, referenceOffsetDelta);

				// update position
				referencePosition.setLength(sub.getReplacementText().length());
			}				

			logger.info("new working text: " + Activator.lineSep
					+ workingText + Activator.lineSep);
		}
	}
	
	public String getWorkingText() {
		return workingText.toString();
	}
	
	private EObject getReferenceObject(Modification modification) {
		return workingModelResource.getEObject(modification.getSourceEObjectUri());
	}
	
	private void shiftObjectsAffectedBySubstitution(Iterator<? extends EObject> objectIterator, Position replacedObjectPosition, 
			int referenceOffsetDelta) {		
		EObject currentObject = null;

		int replacedObjectStart = replacedObjectPosition.getOffset();
		int replacedObjectEnd = replacedObjectPosition.getOffset() + replacedObjectPosition.getLength();

		while (objectIterator.hasNext()) {
			currentObject = objectIterator.next();
			Position currentPosition = objectPositions.getPosition(currentObject);
			if (currentPosition != null) {
				int currentStart = currentPosition.getOffset();
				int currentEnd = currentPosition.getOffset() + currentPosition.getLength();
				
				// replaced:     C{ }
				// text:      A{BC{D}E}F
				// positions: 0123456
				// length:    10
				//              1
				//               4 1 1 1
				
				if (currentStartsWithinReference(replacedObjectStart, replacedObjectEnd, currentStart, currentEnd)
						|| currentStartsAfterReference(replacedObjectStart, replacedObjectEnd, currentStart, currentEnd)) {
					logShifting(currentObject, referenceOffsetDelta);
					addOffset(currentPosition, referenceOffsetDelta);
				}
				
				if (currentIsContainedInReference(replacedObjectStart, replacedObjectEnd, currentStart, currentEnd)
						|| currentContainsReference(replacedObjectStart, replacedObjectEnd, currentStart, currentEnd)) {
					logShifting(currentObject, referenceOffsetDelta);
					addLength(currentPosition, referenceOffsetDelta);
				}
			}
		}
	}
	
	private void shiftObjectsAffectedByAdditionAfter(Iterator<? extends EObject> objectIterator, Position referencePosition, 
			int referenceOffsetDelta) {
		EObject currentObject = null;

		int referenceStart = referencePosition.getOffset();
		int referenceEnd = referencePosition.getOffset() + referencePosition.getLength();

		while (objectIterator.hasNext()) {
			currentObject = objectIterator.next();
			Position currentPosition = objectPositions.getPosition(currentObject);
			if (currentPosition != null) {
				int currentStart = currentPosition.getOffset();
				int currentEnd = currentPosition.getOffset() + currentPosition.getLength();
				
				// reference:    C{ }
				// text:      A{BC{D}E}F
				// positions: 0123456
				// length:    10
				//              1
				//               4 1 1 1
				
				if (currentStartsAfterReference(referenceStart, referenceEnd, currentStart, currentEnd)) {
					logShifting(currentObject, referenceOffsetDelta);
					addOffset(currentPosition, referenceOffsetDelta);
				}
				
				if (currentContainsReference(referenceStart, referenceEnd, currentStart, currentEnd)) {
					logShifting(currentObject, referenceOffsetDelta);
					addLength(currentPosition, referenceOffsetDelta);
				}
			}
		}
	}
	
	private void addOffset(Position position, int delta) {
		position.setOffset(position.getOffset() + delta);
	}

	private void addLength(Position position, int delta) {
		position.setLength(position.getLength() + delta);
	}
	
	private boolean currentStartsWithinReference(int referenceStart, int referenceEnd, int currentStart, int currentEnd) {
		return currentStart > referenceStart;
	}
	
	private boolean currentStartsAfterReference(int referenceStart, int referenceEnd, int currentStart, int currentEnd) {
		return currentStart > referenceEnd;
	}

	private boolean currentIsContainedInReference(int referenceStart, int referenceEnd, int currentStart, int currentEnd) {
		return referenceStart < currentStart && currentEnd <= referenceEnd;
	}
	
	private boolean currentContainsReference(int referenceStart, int referenceEnd, int currentStart, int currentEnd) {
		return currentStart < referenceStart && referenceEnd <= currentEnd;
	}

	private void logShifting(EObject shiftedObject, int offsetDelta) {
		logger.info("shifting object " + shiftedObject.eResource().getURIFragment(shiftedObject) + " by " + offsetDelta + " characters");
	}
	
}
