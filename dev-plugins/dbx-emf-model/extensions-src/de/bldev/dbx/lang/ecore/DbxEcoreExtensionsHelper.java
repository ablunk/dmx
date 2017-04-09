package de.bldev.dbx.lang.ecore;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.bldev.dbx.lang.ecore.dbx.DbxFactory;
import de.bldev.dbx.lang.ecore.dbx.ExtensibleElement;

public class DbxEcoreExtensionsHelper {
	
	private static final Logger logger = Logger.getLogger(DbxEcoreExtensionsHelper.class.getName());

	public static EObject createObjectOfParentClass(EClass metaClass) {
		EObjectImpl instance = null;
		try {
			EClass parentClass = metaClass.getESuperTypes().get(0);

			instance = (EObjectImpl) DbxFactory.eINSTANCE.create(parentClass);
			instance.eSetClass(metaClass);
			
			if (instance instanceof ExtensibleElement && !parentClass.getName().equals("ExtensibleElement")) {
				ExtensibleElement extensibleInstance = (ExtensibleElement) instance;
				extensibleInstance.setInstanceOfExtensionDefinition(true);
				logger.info("set extension instance for instance of meta-class " + metaClass.getName() + ".");
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
