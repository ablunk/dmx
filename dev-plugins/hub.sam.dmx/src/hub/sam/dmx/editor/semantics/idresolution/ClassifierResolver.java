package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;

public class ClassifierResolver<C extends EObject> extends HierarchicalResolver implements ElementResolver<C> {

	@Override
	public Collection<IdentifiedElement> resolve(String identifier, C context) {
		Collection<IdentifiedElement> classifiers = resolveInContainer(identifier, context, Module.class, DblPackage.Literals.MODULE__CLASSIFIERS);
		
		if (classifiers.isEmpty()) {
			classifiers.addAll(resolveInContainer(identifier, context, Model.class, 
					(id, modelContainer) -> resolveInImportedModelsRecursively(identifier, modelContainer)));
		}
		
		return classifiers;
	}
	
	private Collection<IdentifiedElement> resolveInImportedModelsRecursively(String identifier, Model modelContainer) {
		Collection<IdentifiedElement> elements = new HashSet<>();
		
		Collection<Model> importedModels = modelContainer.getImports().stream()
				.map(imprt -> imprt.getModel())
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		for (Model importedModel: importedModels) {
			elements.addAll(resolveInElements(identifier, importedModel.getModule().getClassifiers()));
		}
		
		if (elements.isEmpty()) {
			for (Model importedModel: importedModels) {
				elements.addAll(resolveInImportedModelsRecursively(identifier, importedModel));
			}
		}
		
		return elements;
	}
	
}
