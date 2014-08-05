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
	
	private static EStructuralFeature concreteSyntaxProperty = DblPackage.Literals.EXTENSIBLE_ELEMENT__CONCRETE_SYNTAX;
	
	protected abstract void doGenerate(EObject extensionInstance);
	
	public void doGenerate(String[] args) {
		doGenerate(args, true);
	}
	
	public void doGenerate(String[] args, boolean useDynamicEObjects) {
		try {
			FileWriter errStreamFile = new FileWriter(XtendRunAction.TEMP_FOLDER_NAME + File.separator + "debug.txt");
			BufferedWriter err = new BufferedWriter(errStreamFile);
			err.write("starting ...\n");

			try {
				String modelXmiFile = args[0];
				extensionInstanceUri = args[1];

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
				
				String modificationsXmiFile = XtendRunAction.TEMP_FOLDER_NAME + File.separator + "modifications.xmi";
				URI modificationsFileUri = URI.createFileURI(new File(modificationsXmiFile).getAbsolutePath());
				Resource modificationsResource = resourceSet.getResource(modificationsFileUri, true);
				if (modificationsResource.getContents().size() == 0) {
					record = ModificationsFactory.eINSTANCE.createModificationsRecord();
					modificationsResource.getContents().add(record);
				}
				else {
					record = (ModificationsRecord) modificationsResource.getContents().get(0);
				}
				
				extensionInstance = eblProgramResource.getEObject(extensionInstanceUri);
				resetGenContext();
				doGenerate(extensionInstance);
				addCurrentModification();
				
				modificationsResource.save(Collections.EMPTY_MAP);
			}
			catch (Exception e) {
				err.write("Error: " + e.getMessage() + "\n" + e.getStackTrace() + "\n");
			}
			finally {
				err.close();
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	protected String getConcreteSyntax(EObject extensionInstance, String propertyName) {
		EStructuralFeature property = extensionInstance.eClass().getEStructuralFeature(propertyName);
		Object propertyValue = extensionInstance.eGet(property);
		
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
		else {
			return "";
		}
	}
	
	protected Object getPropertyValue(EObject eObject, String propertyName) {
		EStructuralFeature property = eObject.eClass().getEStructuralFeature(propertyName);
		return eObject.eGet(property);
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
	
	protected void setGenContext(EObject positionObject, boolean addAfterEObject) {
		addCurrentModification();
		Addition addition = ModificationsFactory.eINSTANCE.createAddition();
		currentModification = addition;
		addition.setSourceEObjectUri(getEmfUriFragment(positionObject));
		addition.setReplacementText("");
		addition.setAddAfterPosition(addAfterEObject);
	}
	
	private void addCurrentModification() {
		if (currentModification != null && currentModification.getReplacementText() != null && !currentModification.getReplacementText().equals("")) {
			record.getModifications().add(currentModification);
		}
	}
	
	protected void resetGenContext() {
		addCurrentModification();
		currentModification = ModificationsFactory.eINSTANCE.createSubstitution();
		currentModification.setSourceEObjectUri(extensionInstanceUri);
		currentModification.setReplacementText("");
	}

	protected void gen(String str) {
		currentModification.setReplacementText(currentModification.getReplacementText() + str);
	}
	
}
