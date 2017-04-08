package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import hub.sam.dbl.NamedElement;

abstract class NamedElementResolver {
	
	protected <T extends EObject> Collection<IdentifiedElement> resolveInContainer(
			String identifier,
			EObject context,
			Class<T> containerType,
			ElementResolver<T> resolver) {
		
		return Containment.getContainerObject(context, containerType)
			.map(container -> {
				return resolver.resolvePossibleElements(identifier, container);
			}).orElse(Collections.emptySet());
	}
	
	protected <T extends EObject> Collection<IdentifiedElement> resolveInContainer(
			String identifier,
			EObject context,
			Class<T> containerType,
			EStructuralFeature containerAttributeWithPossibleElements) {
		
		return Containment.getContainerObject(context, containerType)
			.map(container -> {
				Object possibleElementsObject = container.eGet(containerAttributeWithPossibleElements);
				Collection<IdentifiedElement> identifiedElements = new HashSet<>();
				if (possibleElementsObject instanceof Collection) {
					identifiedElements.addAll(resolve(identifier, (Collection) possibleElementsObject));
				} else if (possibleElementsObject instanceof NamedElement) {
					IdentifiedElement identifiedElement = identify(identifier, (NamedElement) possibleElementsObject);
					if (identifiedElement != null) {
						identifiedElements.add(identifiedElement);
					}
				}
				return identifiedElements;
			}).orElse(Collections.emptySet());
	}

	protected Collection<IdentifiedElement> resolve(String identifier, Collection<? extends NamedElement> possibleElements) {
		return possibleElements.stream()
			.map(possibleElement -> identify(identifier, possibleElement))
			.filter(Objects::nonNull)
			.collect(Collectors.toSet());
	}

	protected IdentifiedElement identify(String identifier, NamedElement possibleElement) {
		final String possibleName = possibleElement.getName();
		if (possibleName != null && possibleName.equals(identifier)) {
			return new IdentifiedElement(possibleElement);
		} else {
			return null;
		}
	}

}
