package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import hub.sam.dbl.Class;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.NamedElement;
import hub.sam.dmx.editor.IPreProcessedDocument;
import hub.sam.dmx.editor.semantics.DblIdentificationScheme;
import hub.sam.tef.semantics.DefaultIdentificationScheme;

public class IdentifierResolver extends DefaultIdentificationScheme {
	
	private static final Logger LOGGER = Logger.getLogger(IdentifierResolver.class.getName());
	
	private final VariableResolver variableResolver = new VariableResolver();
	private final MethodResolver methodResolver = new MethodResolver();
	private final ClassResolver<EObject> classInAnyContextResolver = new ClassResolver<>();

	private final IPreProcessedDocument preProcessedDocument;
	
	private final DblIdentificationScheme dblIdentificationSchemeFallback;
	
	public IdentifierResolver(IPreProcessedDocument preProcessedDocument) {
		this.preProcessedDocument = preProcessedDocument;
		this.dblIdentificationSchemeFallback = new DblIdentificationScheme(preProcessedDocument);
	}

	// returns all the objects that the given identifier identifies in the given context
	@Override
	public Object[] getGlobalIdentities(Object identifier, EObject context, EClassifier type) {
		Collection<IdentifiedElement> identifiedElements = new HashSet<>();
		
		if (identifier instanceof NamedElement) {
			NamedElement namedElementIdentifier = (NamedElement) identifier;
			identifiedElements = identifyPossibleNamedElements(namedElementIdentifier.getName(), context);
			warnWhenMultipleElementsAreIdentified(namedElementIdentifier.getName(), identifiedElements);
		} else {
			LOGGER.warning(String.format("cannot resolve identifier %s of type %s", identifier, identifier.getClass()));
		}
		
		Object[] identities = identifiedElements.stream()
				.map(identifiedElement -> identifiedElement.getIdentitiy(preProcessedDocument.getModel()))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet())
				.toArray();
		
		if (identities.length != 0) {
			return identities;
		} else {
			LOGGER.warning(String.format("falling back to old ID resolution for identifier %s of type %s", identifier, identifier.getClass()));
			return dblIdentificationSchemeFallback.getGlobalIdentities(identifier, context, type);
		}
	}

	private Collection<IdentifiedElement> identifyPossibleNamedElements(String identifier, EObject context) {
		if (context instanceof IdExpr) {
			return identifyPossibleElementsReferedToInIdExpr(identifier, (IdExpr) context);
		} else if (context instanceof hub.sam.dbl.Class) {
			return classInAnyContextResolver.resolve(identifier, (hub.sam.dbl.Class) context);
		} else {
			return new HashSet<>();
		}
	}
	
	private Collection<IdentifiedElement> identifyPossibleElementsReferedToInIdExpr(String identifier, IdExpr idExprContext) {
		Collection<IdentifiedElement> identifiedElements = new HashSet<>();
		identifiedElements.addAll(variableResolver.resolve(identifier, idExprContext));
		identifiedElements.addAll(methodResolver.resolve(identifier, idExprContext));
		identifiedElements.addAll(classInAnyContextResolver.resolve(identifier, idExprContext));
		return identifiedElements;
	}
	
	private void warnWhenMultipleElementsAreIdentified(String identifier,
			Collection<IdentifiedElement> identifiedElements) {
		
		if (identifiedElements.size() > 1) {
			LOGGER.warning(String.format("identifier %s identifies multiple elements:\n%s", identifier, 
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
