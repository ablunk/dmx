package hub.sam.dbl.util;

import hub.sam.dbl.DblFactory;
import hub.sam.dbl.ExtensibleElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public class DblUtil {

	public static EObject createObjectOfParentClass(EClass metaClass) {
		System.out.print("trying to create instance of dynamically added meta-class " + metaClass.getName() + " ...");

		EObjectImpl instance = null;
		try {
			EClass parentClass = metaClass.getESuperTypes().get(0);
			System.out.println();
			System.out.print("instantiating " + parentClass.getName() + " ");
			if (metaClass.getESuperTypes().size() > 1) {
				System.out.print(" -- warning: multiple parent meta-classes exist, instantiating the first one");
			}
			instance = (EObjectImpl) DblFactory.eINSTANCE.create(parentClass);
			instance.eSetClass(metaClass);
			
			if (instance instanceof ExtensibleElement) {
				ExtensibleElement extensibleInstance = (ExtensibleElement) instance;
				extensibleInstance.setInstanceOfExtensionDefinition(true);
				System.out.print(" as extension instance");
			}
			
			System.out.println(" -- ok");
		}
		finally {
			if (instance == null) {
				System.out.println(" -- failed");
			}
		}
		
		return instance;
	}
	
}
