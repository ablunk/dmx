package hub.sam.edu.modsoft.bf;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public class Bf {

	public static void main(String[] args) {
		// metamodel
		EPackage bf = EcoreFactory.eINSTANCE.createEPackage();
		bf.setName("bf");
		bf.setNsPrefix("bf");
		bf.setNsURI("http://www.informatik.hu-berlin.de/sam/lang/bf");
		
		EClass boxClass = EcoreFactory.eINSTANCE.createEClass();
		boxClass.setName("Box");
		bf.getEClassifiers().add(boxClass);
		
		EAttribute boxName = EcoreFactory.eINSTANCE.createEAttribute();
		boxName.setName("name");
		boxName.setEType(EcorePackage.Literals.ESTRING);
		boxClass.getEStructuralFeatures().add(boxName);
		
		EAttribute id = EcoreFactory.eINSTANCE.createEAttribute();
		id.setName("id");
		id.setEType(EcorePackage.Literals.EINT);
		boxClass.getEStructuralFeatures().add(id);

		EReference listRef = EcoreFactory.eINSTANCE.createEReference();
		listRef.setName("boxes");
		listRef.setEType(boxClass);
		listRef.setLowerBound(0);
		listRef.setUpperBound(-1);
		listRef.setOrdered(true);
		listRef.setContainment(true);
		boxClass.getEStructuralFeatures().add(listRef);

		// model
		EObjectImpl box = (EObjectImpl) EcoreFactory.eINSTANCE.createEObject();
		box.eSetClass(boxClass);
		box.eSet(boxName, "A");
		box.eSet(id, 2);

		EList<EObject> listValue = new BasicEList<EObject>();
		listValue.add(box);
		box.eSet(listRef, listValue);
		
		String nameValue = getPropertyValue(box, "name", String.class);
		Integer idValue = getPropertyValue(box, "id", Integer.class);
		EList<EObject> boxesValue = getListPropertyValue(box, "boxes", EObject.class);
		
		System.out.println( getPropertyValue( boxesValue.get(0), "name", String.class ) );
	}
	
	public static <T> T getPropertyValue(EObject eObject, String propertyName, Class<T> propertyType) {
		EStructuralFeature property = eObject.eClass().getEStructuralFeature(propertyName);
		return (T) eObject.eGet(property);
	}
	
	public static <T> EList<T> getListPropertyValue(EObject eObject, String propertyName, Class<T> listItemType) {
		EStructuralFeature property = eObject.eClass().getEStructuralFeature(propertyName);
		return (EList<T>) eObject.eGet(property);
	}


}
