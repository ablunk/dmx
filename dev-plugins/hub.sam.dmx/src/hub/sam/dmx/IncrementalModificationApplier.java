package hub.sam.dmx;

import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.Substitution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

public class IncrementalModificationApplier {

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
					System.out.println("substituting source fragement: " + sourceFragment + "\nby: " + mod.getReplacementText());
					
					workingText.replace(start, end, mod.getReplacementText());

					delta += mod.getReplacementText().length() - sub.getSourceLength();
				}
				else if (mod instanceof Addition) {
					Addition addition = (Addition) mod;
					
					if (addition.isAddAfterPosition()) {
						start += 1;
					}
					System.out.println("inserting at text position: " + start);
					
					workingText.insert(start, addition.getReplacementText());

					delta += mod.getReplacementText().length();
				}
				
				System.out.println("new working text: " + workingText);
				System.out.println("new delta: " + delta);
				System.out.println("-----------------------------");
			}
		}
		return workingText.toString();
	}
	
}
