package hub.sam.dmx.editor.modelcreation;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class DblModelCreationContext extends ModelCreatingContext {

	public static EcoreModelManager ecoreModelManager;
	
	public DblModelCreationContext(EPackage[] packages,
			ISemanticsProvider semanticsProvider, Resource resource, ResourceSet resourceSet, String text) {
		super(packages, semanticsProvider, resource, resourceSet, text);
		//this.metamodel = metamodel;
		//ecoreModelManager = new EcoreModelManager(null, project);
		//ecoreModelManager.resourceSet.getResources().add(resource);
	}
	
	private class ModelContentsIterator implements java.util.Iterator<Object> {
		
		private java.util.Iterator<EObject> iterator;
		private Collection<Import> importsLeft = new HashSet<Import>();
		
		public ModelContentsIterator(Model model) {
			this.iterator = model.eAllContents();
			//importsLeft.addAll(model.getImports());
			addImportsRecursively(model, importsLeft);
		}
		
		private void addImportsRecursively(Model model, Collection<Import> imports) {
			if (model != null) {
				for (Import imprt: model.getImports()) {
					imports.add(imprt);
				}
				for (Import imprt: model.getImports()) {
					addImportsRecursively(imprt.getModel(), imports);
				}
			}
		}

		@Override
		public boolean hasNext() {
			if (iterator.hasNext()) {
				return true;
			}
			else {
				while (!importsLeft.isEmpty()) {
					Import imprt = importsLeft.iterator().next();
					importsLeft.remove(imprt);
					Model modelToImport = imprt.getModel();
					if (modelToImport == null)
						continue;
					else {
						iterator = imprt.getModel().eAllContents();
						return iterator.hasNext();
					}
				}
			}
			return false;
		}

		@Override
		public Object next() {
			return iterator.next();
		}

		@Override
		public void remove() {
			iterator.remove();
		}
		
	}
	
	private class ModelContentsIterator2 implements java.util.Iterator<Object> {

		private java.util.Iterator<EObject> iterator;
		private Collection<Import> importsLeft = new HashSet<Import>();
		
		public ModelContentsIterator2(Model model) {
			this.iterator = new EContentIterator(model);
			addImportsRecursively(model, importsLeft);
		}
		
		private void addImportsRecursively(Model model, Collection<Import> imports) {
			if (model != null) {
				for (Import imprt: model.getImports()) {
					imports.add(imprt);
				}
				for (Import imprt: model.getImports()) {
					addImportsRecursively(imprt.getModel(), imports);
				}
			}
		}

		@Override
		public boolean hasNext() {
			if (iterator.hasNext()) {
				return true;
			}
			else {
				while (!importsLeft.isEmpty()) {
					Import imprt = importsLeft.iterator().next();
					importsLeft.remove(imprt);
					Model modelToImport = imprt.getModel();
					if (modelToImport == null)
						continue;
					else {
						iterator = new EContentIterator(imprt.getModel());
						return iterator.hasNext();
					}
				}
			}
			return false;
		}

		@Override
		public Object next() {
			return iterator.next();
		}

		@Override
		public void remove() {
			iterator.remove();
		}
		
	}
	
	private class EContentIterator implements java.util.Iterator<EObject> {
		
		private EObject container;
		private Iterator<EObject> iterator;
		
		public EContentIterator(EObject container) {
			this.container = container;
			iterator = container.eContents().iterator();
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public EObject next() {
			return iterator.next();
		}
		
	}

	@Override
	public Iterable<Object> getAllContents() {
		if (getResource() != null) {
			final EObject root = getResource().getContents().iterator().next();
			if (root instanceof Model) {
				Iterable<Object> iterable = new Iterable<Object>() {
					@Override
					public java.util.Iterator<Object> iterator() {
						return new ModelContentsIterator((Model) root);
					}
				};
				return iterable;
			}
		}
		return null;
	}

}
