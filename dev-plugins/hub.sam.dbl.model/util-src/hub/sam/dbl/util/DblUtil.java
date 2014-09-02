package hub.sam.dbl.util;

import java.util.logging.Logger;

import hub.sam.dbl.DblFactory;
import hub.sam.dbl.ExtensibleElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public class DblUtil {
	
	private static final Logger logger = Logger.getLogger(DblUtil.class.getName());

	public static EObject createObjectOfParentClass(EClass metaClass) {
		EObjectImpl instance = null;
		try {
			EClass parentClass = metaClass.getESuperTypes().get(0);

			instance = (EObjectImpl) DblFactory.eINSTANCE.create(parentClass);
			instance.eSetClass(metaClass);
			
			if (instance instanceof ExtensibleElement) {
				ExtensibleElement extensibleInstance = (ExtensibleElement) instance;
				extensibleInstance.setInstanceOfExtensionDefinition(true);
			}
			
			logger.info("instantiated meta-class " + metaClass.getName() + " via first parent meta-class " + parentClass.getName() + ".");
		}
		finally {
			if (instance == null) {
				logger.severe("instantiating meta-class " + metaClass.getName() + " failed.");
			}
		}
		
		return instance;
	}
	
}
