package hub.sam.dmx;

import hub.sam.dbl.DblPackage;
import hub.sam.dmx.modifications.Addition;
import hub.sam.dmx.modifications.Modification;
import hub.sam.dmx.modifications.ModificationsFactory;
import hub.sam.dmx.modifications.ModificationsPackage;
import hub.sam.dmx.modifications.ModificationsRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class AbstractExtensionSemantics {

	protected ModificationsRecord record;
	protected Modification currentModification;
	protected EObject extensionInstance;
	protected String extensionInstanceUri;
	protected String inputPath;
	
	private static EStructuralFeature concreteSyntaxProperty = DblPackage.Literals.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
	
	protected abstract void doGenerate(EObject extensionInstance);
	
	public void doGenerate(String[] args) {
		doGenerate(args, true);
	}
	
	public void doGenerate(String[] args, boolean useDynamicEObjects) {
		try {
			FileWriter errStreamFile = new FileWriter(XtendRunAction.TEMP_FOLDER_NAME + File.separator + "debug.txt");
			BufferedWriter debugWriter = new BufferedWriter(errStreamFile);
			debugWriter.write("starting ...\n");

			try {
				String modelXmiFile = args[0];
				extensionInstanceUri = args[1];
				if (args.length > 2) inputPath = args[2];

				debugWriter.write("modelXmiFile = " + modelXmiFile + "\n");
				debugWriter.write("extensionInstanceUri = " + extensionInstanceUri + "\n");

				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
				resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		    	resourceSet.getPackageRegistry().put(ModificationsPackage.eNS_URI, ModificationsPackage.eINSTANCE);
        
		    	if (useDynamicEObjects) {
			    	String metamodelFile = XtendRunAction.TEMP_FOLDER_NAME + File.separator + "dbl.ecore";
					URI metamodelUri = URI.createFileURI(new File(metamodelFile).getAbsolutePath());
					Resource metamodelResource = resourceSet.getResource(metamodelUri, true);
					EObject rootObject = metamodelResource.getContents().get(0);
					if (rootObject instanceof EPackage) {
						EPackage metamodelPackage = (EPackage) rootObject;

						resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, metamodelPackage);
						
						concreteSyntaxProperty = ((EClass) metamodelPackage.getEClassifier("ExtensibleElement")).getEStructuralFeature("concreteSyntax");
					}
		    	}
		    	else {
		    		resourceSet.getPackageRegistry().put(DblPackage.eNS_URI, DblPackage.eINSTANCE);
		    	}

				URI eblProgramFileUri = URI.createFileURI(new File(modelXmiFile).getAbsolutePath());
				Resource eblProgramResource = resourceSet.getResource(eblProgramFileUri, true);
				
				String modificationsXmi = XtendRunAction.TEMP_FOLDER_NAME + File.separator + "modifications.xmi";
				File modificationsXmiFile = new File(modificationsXmi);
				URI modificationsXmiUri = URI.createFileURI(modificationsXmiFile.getAbsolutePath());
				
				Resource modificationsResource = null;
				if (!modificationsXmiFile.exists()) {
					modificationsResource = resourceSet.createResource(modificationsXmiUri);
				}
				else {
					modificationsResource = resourceSet.getResource(modificationsXmiUri, true);
				}
				
				if (modificationsResource.getContents().size() == 0) {
					record = ModificationsFactory.eINSTANCE.createModificationsRecord();
					modificationsResource.getContents().add(record);
				}
				else {
					record = (ModificationsRecord) modificationsResource.getContents().get(0);
					record.getModifications().clear();
				}
				
				extensionInstance = eblProgramResource.getEObject(extensionInstanceUri);
				setExpand(extensionInstance);
				doGenerate(extensionInstance);
				addCurrentModification();
				
				modificationsResource.save(Collections.EMPTY_MAP);
			}
			catch (Exception e) {
				debugWriter.write("Error: " + e.getMessage() + "\n" + e.getStackTrace() + "\n");
			}
			finally {
				debugWriter.close();
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	protected String getConcreteSyntax(EObject extensionInstance, String propertyName) {
		EStructuralFeature property = extensionInstance.eClass().getEStructuralFeature(propertyName);
		Object propertyValue = extensionInstance.eGet(property);
		return getConcreteSyntax(propertyValue);
	}
	
	protected String getConcreteSyntax(Object propertyValue) {
		if (propertyValue instanceof EList) {
			@SuppressWarnings("unchecked")
			EList<EObject> listPropertyValue = (EList<EObject>) propertyValue;
			String concreteSyntax = "";
			for (EObject listItem: listPropertyValue) {
				concreteSyntax += listItem.eGet(concreteSyntaxProperty);
			}
			return concreteSyntax;
		}
		else if (propertyValue instanceof EObject) {
			EObject singlePropertyValue = (EObject) propertyValue;
			return (String) singlePropertyValue.eGet(concreteSyntaxProperty);
		}
		else if (propertyValue instanceof String) {
			return (String) propertyValue;
		}
		else {
			return "";
		}
	}
	
	protected Object getPropertyValue(EObject eObject, String propertyName) {
		EStructuralFeature property = eObject.eClass().getEStructuralFeature(propertyName);
		if (property == null) {
			throw new RuntimeException(eObject.eClass().getName() + " has no structural feature " + propertyName + ".");
		}
		else {
			return eObject.eGet(property, true);
		}
	}
	
	static String getEmfUriFragment(EObject eObject) {
		return eObject.eResource().getURIFragment(eObject);
	}
	
	protected static boolean isInstanceOfDynamic(EObject eObject, String eClassName) {
		if (eObject.eClass().getName().equals(eClassName)) {
			return true;
		}
		for (EClass superType: eObject.eClass().getEAllSuperTypes()) {
			if (superType.getName().equals(eClassName)) {
				return true;
			}
		}
		return false;
	}
	
	protected void setExpand(Object positionObject) {
		setExpand(positionObject, true);
	}
	
	protected void setExpand(Object positionObject, boolean addAfterEObject) {
		if (positionObject == extensionInstance) {
			addCurrentModification();

			currentModification = ModificationsFactory.eINSTANCE.createSubstitution();
			currentModification.setSourceEObjectUri(extensionInstanceUri);
			currentModification.setReplacementText("");
		}
		else if (positionObject instanceof EObject) {
			EObject positionEObject = (EObject) positionObject;
			
			addCurrentModification();
			
			Addition addition = ModificationsFactory.eINSTANCE.createAddition();
			addition.setSourceEObjectUri(getEmfUriFragment(positionEObject));
			addition.setReplacementText("");
			addition.setAddAfterPosition(addAfterEObject);

			currentModification = addition;
		}
	}
	
	private void addCurrentModification() {
		if (currentModification != null && currentModification.getReplacementText() != null && !currentModification.getReplacementText().equals("")) {
			record.getModifications().add(currentModification);
		}
	}

	protected void expand(String str) {
		currentModification.setReplacementText(currentModification.getReplacementText() + str);
	}
	
}
