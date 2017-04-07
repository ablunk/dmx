package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dmx.editor.IPreProcessedDocument;
import hub.sam.tef.semantics.DefaultIdentificationScheme;

public class IdentifierResolver extends DefaultIdentificationScheme {
	
	private static final Logger LOGGER = Logger.getLogger(IdentifierResolver.class.getName());

	private IPreProcessedDocument preProcessedDocument;
	
	public IdentifierResolver(IPreProcessedDocument preProcessedDocument) {
		this.preProcessedDocument = preProcessedDocument;
	}

	// returns all the objects that the given identifier identifies in the given context
	@Override
	public Object[] getGlobalIdentities(Object identifier, EObject context, EClassifier type) {
		if (identifier instanceof NamedElement && context instanceof IdExpr) {
			return identifyPossibleElements((NamedElement) identifier, (IdExpr) context).stream()
					.map(identifiedElement -> identifiedElement.getIdentitiy(preProcessedDocument.getModel()))
					.collect(Collectors.toSet())
					.toArray();
		} else {
			LOGGER.info(String.format("resolving identifier %s in context %s with type %s", identifier, context, type));
			return new Object[] {};
		}
	}

	public Collection<IdentifiedElement> identifyPossibleElements(NamedElement identifier, IdExpr idExprContext) {
		LOGGER.info(String.format("resolving identifier %s in context within container type %s", identifier.getName(), 
				idExprContext.eContainer().eClass().getName()));
		
		Collection<IdentifiedElement> identifiedElements = new HashSet<>();
		ElementResolver variableResolver = new VariableResolver();		
		identifiedElements.addAll(variableResolver.resolvePossibleElements(identifier, idExprContext));
		
		warnWhenMultipleElementsAreIdentified(identifier, identifiedElements);
		
		return identifiedElements;
	}

	private void warnWhenMultipleElementsAreIdentified(NamedElement identifier,
			Collection<IdentifiedElement> identifiedElements) {
		
		if (identifiedElements.size() > 1) {
			LOGGER.warning(String.format("identifier %s identifies multiple elements:\n%s", identifier.getName(), 
					identifiedElements.stream()
						.map(element -> {
							if (element.getIdentifiedElement().eResource() != null) {
								return element.getIdentifiedElement().eResource().getURIFragment(element.getIdentifiedElement());
							} else {
								return element.getIdentifiedElement().toString();
							}
						})
						.collect(Collectors.joining("\n"))));
		}
	}

	@Override
	public Object getIdentitiy(EObject object) {
		if (object instanceof NamedElement) {
			return new IdentifiedElement((NamedElement) object).getIdentitiy(preProcessedDocument.getModel());
		} else {
			LOGGER.severe("no identity available for object");
			return null;
		}
	}	
	
}
