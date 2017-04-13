package hub.sam.dmx.executionsemantics;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.text.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import hub.sam.dmx.modelcreation.IObjectPositionsContainer;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsFactory;
import hub.sam.dmx.modifications.ModificationsRecord;
import hub.sam.dmx.modifications.Substitution;
import hub.sam.dmx.semantics.IncrementalModificationApplier;

public class IncrementalModificationApplierTest {
	
	private IncrementalModificationApplier modificationsApplier;
	private IObjectPositionsContainer objectPositionsMock;
	private Resource resource;
	private final String originalText = "0123456789";
	private EClass boxClass;
	private EReference box_containedBoxes;

	@Before
	public void setup() {
		objectPositionsMock = Mockito.mock(IObjectPositionsContainer.class);
		resource = new ResourceImpl();
		modificationsApplier = new IncrementalModificationApplier(
				new StringBuffer(originalText), objectPositionsMock, resource);
		
		initBoxClass();
	}
	
	@Test
	public void additionAfterStart() {
		EObject b0 = boxObject();
		resource.getContents().add(b0);
		String b0Uri = resource.getURIFragment(b0);
		
		// >0<123456789
		Mockito.when(objectPositionsMock.getPosition(b0))
			.thenReturn(new Position(0,1));
		
		modificationsApplier.applyAll(modificationsRecord(
				additionAfter(b0Uri, "++")).getModifications());
		
		assertEquals("0++123456789", modificationsApplier.getWorkingText());
	}

	@Test
	public void additionAfterEnd() {
		EObject b9 = boxObject();
		resource.getContents().add(b9);
		String b9Uri = resource.getURIFragment(b9);
		
		// 012345678>9<
		Mockito.when(objectPositionsMock.getPosition(b9))
			.thenReturn(new Position(9,1));
		
		modificationsApplier.applyAll(modificationsRecord(
				additionAfter(b9Uri, "++")).getModifications());
		
		assertEquals("0123456789++", modificationsApplier.getWorkingText());
	}

	@Test
	public void additionsMultiple() {
		EObject b0 = boxObject();
		resource.getContents().add(b0);
		String b0Uri = resource.getURIFragment(b0);
		
		// >0<123456789
		Mockito.when(objectPositionsMock.getPosition(b0))
			.thenReturn(new Position(0,1));
		
		// >0+<123456789
		// >0+*<123456789
		modificationsApplier.applyAll(modificationsRecord(
				additionAfter(b0Uri, "+"), additionAfter(b0Uri, "*")).getModifications());
		
		assertEquals("0+*123456789", modificationsApplier.getWorkingText());
	}

	@Test
	public void substitution() {
		EObject b0 = boxObject();
		resource.getContents().add(b0);
		String b0Uri = resource.getURIFragment(b0);
		
		// >0<123456789
		Mockito.when(objectPositionsMock.getPosition(b0))
			.thenReturn(new Position(0,1));
		
		modificationsApplier.applyAll(modificationsRecord(
				substitution(b0Uri, "--")).getModifications());
		
		assertEquals("--123456789", modificationsApplier.getWorkingText());
	}

	@Test
	public void additionAfterWithSubstitution() {
		EObject b1 = boxObject();
		EObject b012 = boxObject(b1);
		resource.getContents().add(b012);

		String b012Uri = resource.getURIFragment(b012);
		String b1Uri = resource.getURIFragment(b1);
		
		// 0>1<23456789
		Mockito.when(objectPositionsMock.getPosition(b1))
			.thenReturn(new Position(1,1));
		
		// >012<3456789
		Mockito.when(objectPositionsMock.getPosition(b012))
			.thenReturn(new Position(0,3));
		
		// 0>----<23456789
		modificationsApplier.applyAll(modificationsRecord(
				substitution(b1Uri, "----")).getModifications());

		// >0----2<++3456789
		modificationsApplier.applyAll(modificationsRecord(
				additionAfter(b012Uri, "++")).getModifications());
		
		assertEquals("0----2++3456789", modificationsApplier.getWorkingText());
	}
	
	private EObject boxObject(EObject... containedBoxes) {
		EObjectImpl box = (EObjectImpl) EcoreFactory.eINSTANCE.createEObject();
		box.eSetClass(boxClass);
		EList<EObject> boxList = new BasicEList<EObject>();
		boxList.addAll(Arrays.asList(containedBoxes));
		box.eSet(box_containedBoxes, boxList);
		return box;
	}
	
	private void initBoxClass() {
		EPackage bf = EcoreFactory.eINSTANCE.createEPackage();
		bf.setName("bf");
		bf.setNsPrefix("bf");
		bf.setNsURI("http://www.informatik.hu-berlin.de/sam/lang/bf");

		boxClass = EcoreFactory.eINSTANCE.createEClass();
		boxClass.setName("Box");
		bf.getEClassifiers().add(boxClass);
		
		box_containedBoxes = EcoreFactory.eINSTANCE.createEReference();
		box_containedBoxes.setName("boxes");
		box_containedBoxes.setEType(boxClass);
		box_containedBoxes.setLowerBound(0);
		box_containedBoxes.setUpperBound(-1);
		box_containedBoxes.setOrdered(true);
		box_containedBoxes.setContainment(true);
		boxClass.getEStructuralFeatures().add(box_containedBoxes);		
	}

	private ModificationsRecord modificationsRecord(Modification... modifications) {
		ModificationsRecord modificationsRecord = ModificationsFactory.eINSTANCE.createModificationsRecord();
		modificationsRecord.getModifications().addAll(Arrays.asList(modifications));
		return modificationsRecord;
	}
	
	private Addition additionAfter(String sourceEObjectUri, String replacementText) {
		return addition(sourceEObjectUri, replacementText, true);
	}
	
	private Addition additionBefore(String sourceEObjectUri, String replacementText) {
		return addition(sourceEObjectUri, replacementText, false);
	}
	
	private Addition addition(String sourceEObjectUri, String replacementText, boolean after) {
		Addition addition = ModificationsFactory.eINSTANCE.createAddition();
		addition.setSourceEObjectUri(sourceEObjectUri);
		addition.setReplacementText(replacementText);
		addition.setAddAfterPosition(after);
		return addition;
	}
	
	private Substitution substitution(String sourceEObjectUri, String replacementText) {
		Substitution substitution = ModificationsFactory.eINSTANCE.createSubstitution();		
		substitution.setSourceEObjectUri(sourceEObjectUri);
		substitution.setReplacementText(replacementText);
		return substitution;
	}

}
