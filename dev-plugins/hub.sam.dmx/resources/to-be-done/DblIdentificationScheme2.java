package hub.sam.dmx.editor.semantics;

import hub.sam.dbl.DblEObject;
import hub.sam.dbl.NamedElement;
import hub.sam.dmx.editor.IPreProcessedDocument;
import hub.sam.tef.semantics.DefaultIdentificationScheme;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class DblIdentificationScheme2 extends DefaultIdentificationScheme {
	
	private IPreProcessedDocument preProcessedDocument;
	
	public DblIdentificationScheme2(IPreProcessedDocument preProcessedDocument) {
		this.preProcessedDocument = preProcessedDocument;
	}

	// returns all the objects that the given identifier identifies in the given context
	@Override
	public Object[] getGlobalIdentities(Object identifier, EObject context, EClassifier type) {
		try {
			String identifierString = null;
			
			if (identifier instanceof NamedElement) {
				NamedElement namedElementId = (NamedElement) identifier;
				identifierString = namedElementId.getName();
			}
			
			if (identifierString != null && context instanceof DblEObject) {
				DblEObject dblContext = (DblEObject) context;
				
				CollectIdentitiesVisitor visitor = new CollectIdentitiesVisitor(this, identifierString);
				dblContext.accept(visitor);
				
				Object[] identities = visitor.getIdentities();
				if (identities.length > 0) {
					return identities;
				}
			}

			return super.getGlobalIdentities(identifier, context, type);
		}
		catch (RuntimeException e) {
			System.out.println(e);
			return null;
		}
	}

	// computes the globally unique identity of an object
	// e.g. Module_Test.Class_X.Procedure_m.LocalVariable_n
	// e.g. Module_Test.Class_X.Procedure_m.Parameter_n
	@Override
	public Object getIdentitiy(EObject object) {
		return getIdentityBasedOnURIFragment(object);
	}
	
	private String getIdentityBasedOnURIFragment(EObject object) {
		Resource modelResource = null;
		if (preProcessedDocument.getModel() != null) {
			modelResource = preProcessedDocument.getModel().eResource();
		}

		if (object.eResource() != null) {
			String result = "";
			if (object.eResource().getURI() != null && object.eResource() != modelResource) {
				result += object.eResource().getURI();
			}
			result += object.eResource().getURIFragment(object);
			return result;
		}
		else {
			return null;
		}
	}

	@Override
	public String getLocalIdentity(EObject object, EObject context) {
		return super.getLocalIdentity(object, context);
	}
	
}
