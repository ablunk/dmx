package hub.sam.dmx;

import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.Substitution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.EList;

@Deprecated
public class IncrementalModificationApplier {
	
	private static final Logger logger = Logger.getLogger(IncrementalModificationApplier.class.getName());

	private final List<Modification> sortedModifications = new ArrayList<Modification>();
	private final String originalText;
	private StringBuffer workingText;
	
	public IncrementalModificationApplier(EList<Modification> unsortedModifications, String originalText) {
		this.originalText = originalText;
		
		sortedModifications.addAll(unsortedModifications);
		Collections.sort(sortedModifications, new Comparator<Modification>() {
			@Override
			public int compare(Modification m1, Modification m2) {
				if (m1.getSourceStart() < m2.getSourceStart()) return -1;
				else if (m1.getSourceStart() > m2.getSourceStart()) return 1;
				else return 0;
			}
		});
	}
	
	public String applyAll() {
		if (workingText == null) {
			workingText = new StringBuffer(originalText);

			// apply modifications in order, adjust positions for remaining modifications
			
			int delta = 0;
			
			for (Modification mod: sortedModifications) {
				int start = mod.getSourceStart() + delta;
				if (start < 0) {
					start = 0;
				}
				
				if (mod instanceof Substitution) {
					Substitution sub = (Substitution) mod;
					
					int end = start + sub.getSourceLength();
					if (end > workingText.length()) {
						end = workingText.length();
					}
					
					String sourceFragment = workingText.substring(start, end);
					logger.info("substituting source fragement: " + sourceFragment + Activator.lineSep
							+ "by: " + mod.getReplacementText() + Activator.lineSep);
					
					workingText.replace(start, end, mod.getReplacementText());

					delta += mod.getReplacementText().length() - sub.getSourceLength();
				}
				else if (mod instanceof Addition) {
					Addition addition = (Addition) mod;
					
					if (addition.isAddAfterPosition()) {
						start += 1;
					}
					logger.info("inserting at text position: " + start);
					
					workingText.insert(start, addition.getReplacementText());

					delta += mod.getReplacementText().length();
				}
				
				logger.info("new working text: " + workingText + Activator.lineSep
						+ "new delta: " + delta + Activator.lineSep);
			}
		}
		return workingText.toString();
	}
	
}
