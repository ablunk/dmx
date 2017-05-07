package hub.sam.dmx.editor.semantics.idresolution;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import hub.sam.dbl.Class;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.Function;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Interface;

public class MethodResolver extends MemberResolver implements ElementResolver<IdExpr> {
	
	@Override
	public Collection<IdentifiedElement> resolve(String identifier, IdExpr idExprContext) {
		if (idExprContext.getCallPart() != null) {
			if (idExprContext.getParentIdExpr() == null) {
				return resolveInContainer(identifier, idExprContext, Classifier.class,
						(id, containerClassifier) -> resolvePlainMethods(identifier, idExprContext, containerClassifier));
			} else {
				return resolveFeaturesInNavigation(identifier, idExprContext);
			}
		} else {
			return new HashSet<>();
		}
	}
	
	@Override
	protected Collection<IdentifiedElement> resolvePlainMembers(String identifier, IdExpr idExprContext, Classifier containerClassifier) {
		return resolvePlainMethods(identifier, idExprContext, containerClassifier);
	}
	
	private Collection<IdentifiedElement> resolvePlainMethods(String identifier, IdExpr idExprContext, Classifier containerClassifier) {
		Collection<IdentifiedElement> methods = resolveInElements(identifier, filterPossibleMethods(idExprContext, containerClassifier.getMethods()));
		
		if (methods.isEmpty()) {
			methods.addAll(resolveInheritedMethodsRecursive(identifier, idExprContext, containerClassifier));
		}
		
		return methods;
	}
	
	private List<Function> filterPossibleMethods(IdExpr idExprContext, List<Function> methods) {
		return methods.stream()
				.filter(method -> method.getParameters().size() == idExprContext.getCallPart().getCallArguments().size())
				.collect(Collectors.toList());
	}
	
	private Collection<IdentifiedElement> resolveInheritedMethodsRecursive(String identifier, IdExpr idExprContext, Classifier classifier) {
		Collection<IdentifiedElement> methods = new HashSet<>();
		
		if (classifier instanceof Class) {
			Class dblClass = (Class) classifier;
			Class superClass = dblClass.getSuperClass();
			if (superClass != null && methods.isEmpty()) {
				methods.addAll(resolveInElements(identifier, filterPossibleMethods(idExprContext, superClass.getMethods())));
			}
		}

		for (Interface superInterface: classifier.getSuperInterfaces()) {
			if (methods.isEmpty()) {
				methods.addAll(resolveInElements(identifier, filterPossibleMethods(idExprContext, superInterface.getMethods())));
			}
		}
		
		if (classifier instanceof Class) {
			Class dblClass = (Class) classifier;
			Class superClass = dblClass.getSuperClass();
			if (superClass != null && methods.isEmpty()) {
				methods.addAll(resolveInheritedMethodsRecursive(identifier, idExprContext, superClass));
			}
		}

		for (Interface superInterface: classifier.getSuperInterfaces()) {
			if (methods.isEmpty()) {
				methods.addAll(resolveInheritedMethodsRecursive(identifier, idExprContext, superInterface));
			}
		}

		return methods;
	}

}
