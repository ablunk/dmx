package hub.sam.edu.modsoft.bf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
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
		
		// model
		EObjectImpl box = (EObjectImpl) EcoreFactory.eINSTANCE.createEObject();
		box.eSetClass(boxClass);
		box.eSet(boxName, "A");
		
		System.out.println(box.eGet(boxName));
	}

}
