package hub.sam.dmx.editor.modelcreation;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

public class EcoreModelManager {
	
	public ResourceSet resourceSet = new ResourceSetImpl();
	
	public EcoreModelManager(Bundle bundle, IProject project) {
		fBundle = bundle;
		fProject = project;
	}
	
	public interface IEcoreModel {
		public void loadModel(String uri);
		public Iterator<Notifier> getAllContents();
	}
	
	public IEcoreModel ecoreModel = new IEcoreModel() {
		private ResourceSet metaModel = null;
		private String metaModelPath = null;
		
		@SuppressWarnings("unchecked")
		public Iterator<Notifier> getAllContents() {
			if (metaModel == null) {
				return Collections.EMPTY_LIST.iterator();
			} else {
				return (Iterator<Notifier>) metaModel.getAllContents();
			}
		}
		
		private void loadReference(EList<EObject> listOfObjects, Collection<EObject> loaded) {
			for(EObject object: listOfObjects) {
				if (!loaded.contains(object)) {
					if (object instanceof ETypedElement) {
						((ETypedElement)object).getEType();						
					}
					if (object instanceof EClass) {
						((EClass)object).getESuperTypes();
					}
					loadReference(object.eContents(), loaded);
				}
			}
		}

		public void loadModel(String uri) {
			if (uri.equals(metaModelPath)) {
				return;
			} else {
				metaModelPath = uri;
			}
			try {				
				URI metaModelURI = null;
				if (fBundle != null) {
					URL url = FileLocator.find(fBundle, new Path(uri), null);
					metaModelURI = URI.createURI(url.toExternalForm());
				} else {					
					metaModelURI = URI.createFileURI(fProject.getLocation() + "/" + uri);
				}
				EPackage metaMetaModel = EcorePackage.eINSTANCE;
				resourceSet.getPackageRegistry().put(metaMetaModel.getNsURI(),
						metaMetaModel);
				// TODO there must be a better way to load all referenced elements. At least
				// you can optimise it.
				loadReference(
						resourceSet.getResource(metaModelURI, true).getContents(),
						new HashSet<EObject>());				
				metaModel = resourceSet;
			} catch (RuntimeException ex) {
				metaModel = null;
				metaModelPath = null;
				throw ex;
			}
		}
	};
	
	private final Bundle fBundle;
	private final IProject fProject;
	
}
