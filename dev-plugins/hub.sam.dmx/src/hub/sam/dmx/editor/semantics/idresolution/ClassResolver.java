package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;

public class ClassResolver<C extends EObject> extends HierarchicalResolver implements ElementResolver<C> {

	@Override
	public Collection<IdentifiedElement> resolve(String identifier, C context) {
		Collection<IdentifiedElement> classes = resolveInContainer(identifier, context, Module.class, DblPackage.Literals.MODULE__CLASSES);
		
		if (classes.isEmpty()) {
			classes.addAll(resolveInContainer(identifier, context, Model.class, 
					(id, modelContainer) -> resolveInImportedModelsRecursively(identifier, modelContainer)));
		}
		
		return classes;
	}
	
	private Collection<IdentifiedElement> resolveInImportedModelsRecursively(String identifier, Model modelContainer) {
		Collection<IdentifiedElement> elements = new HashSet<>();
		
		Collection<Model> importedModels = modelContainer.getImports().stream()
				.map(imprt -> imprt.getModel())
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		for (Model importedModel: importedModels) {
			elements.addAll(importedModel.getModules().stream()
				.map(module -> resolveInElements(identifier, module.getClasses()))
				.flatMap(identifiedElements -> identifiedElements.stream())
				.collect(Collectors.toSet()));	
		}
		
		if (elements.isEmpty()) {
			for (Model importedModel: importedModels) {
				elements.addAll(resolveInImportedModelsRecursively(identifier, importedModel));
			}
		}
		
		return elements;
	}
	
}
