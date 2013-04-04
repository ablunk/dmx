package hub.sam.dmx.tests;

import static org.junit.Assert.assertEquals;
import hub.sam.dmx.IncrementalModificationApplier;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.ModificationsFactory;
import hub.sam.dmx.modifications.ModificationsRecord;
import hub.sam.dmx.modifications.Substitution;

import org.junit.Before;
import org.junit.Test;

public class TestIncrementalModificationApplier {
	
	private ModificationsRecord record;
	private String originalText;

	@Before
	public void runBeforeEveryTest() {
		record = ModificationsFactory.eINSTANCE.createModificationsRecord();
		originalText = "0123456789";
	}
	
	@Test
	public void singleAddAfterAtStart() {
		addAfter(0, "AB");
		assertEquals(apply(),"0AB123456789");
	}
	
	@Test
	public void singleAddAfterAtEnd() {
		addAfter(9, "AB");
		assertEquals(apply(),"0123456789AB");
	}
	
	@Test
	public void singleAddBeforeAtStart() {
		addBefore(0, "AB");
		assertEquals(apply(),"AB0123456789");
	}
	
	@Test
	public void singleAddBeforeAtEnd() {
		addBefore(9, "AB");
		assertEquals(apply(),"012345678AB9");
	}
	
	@Test
	public void multiAdd1() {
		addAfter(0, "AB");
		addAfter(0, "C");
		assertEquals(apply(),"0ABC123456789");
	}
	
	@Test
	public void multiAdd2() {
		addAfter(0, "AB");
		addAfter(1, "C");
		assertEquals(apply(),"0AB1C23456789");
	}
	
	@Test
	public void multiAdd3() {
		addAfter(0, "AB");
		addBefore(1, "C");
		assertEquals(apply(),"0ABC123456789");
	}
	
	@Test
	public void singleSubstituteAtStart() {
		substitute(0, 3, "AB");
		assertEquals(apply(),"AB3456789");
	}
	
	@Test
	public void singleSubstituteAtEnd() {
		substitute(9, 3, "AB");
		assertEquals(apply(),"012345678AB");
	}
	
	@Test
	public void multiSubstitute() {
		substitute(0, 3, "AB");
		substitute(5, 3, "AB");
		assertEquals(apply(),"AB34AB89");
	}

	@Test
	public void multi1() {
		addAfter(1, "AB");
		substitute(2, 2, "C");
		assertEquals(apply(),"01ABC456789");
	}

	@Test
	public void multi2() {
		addAfter(2, "B");
		substitute(0, 3, "A");
		assertEquals(apply(),"AB3456789");
	}

	private String apply() {
		IncrementalModificationApplier modApplier = new IncrementalModificationApplier(record.getModifications(), originalText);
		return modApplier.applyAll();
	}
	
	private void addAfter(int offset, String text) {
		add(true, offset, text);
	}
	
	private void addBefore(int offset, String text) {
		add(false, offset, text);
	}
	
	private void add(boolean after, int start, String text) {
		Addition mod = ModificationsFactory.eINSTANCE.createAddition();
		mod.setAddAfterPosition(after);
		mod.setSourceStart(start);
		mod.setReplacementText(text);
		record.getModifications().add(mod);
	}
	
	private void substitute(int sourceStart, int sourceLength, String replacementText) {
		Substitution mod = ModificationsFactory.eINSTANCE.createSubstitution();		
		mod.setSourceStart(sourceStart);
		mod.setSourceLength(sourceLength);
		mod.setReplacementText(replacementText);
		record.getModifications().add(mod);
	}

}
