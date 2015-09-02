package hub.sam.dmx.editor.modelcreation;

import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.util.DblUtil;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.semantics.ISemanticsProvider;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class DbxModelCreationContext extends DblModelCreationContext {

	public DbxModelCreationContext(EPackage[] packages,
			ISemanticsProvider semanticsProvider, Resource resource, ResourceSet resourceSet, String text) {
		super(packages, semanticsProvider, resource, resourceSet, text);
	}
	
	public EObject instantiate(EClass metaClass, ParseTreeRuleNode node) throws ModelCreatingException {
		try {
			loop: for (EPackage ePackage: getMetaModelPackages()) {
				EClassifier classifier = null;
				if ((classifier = ePackage.getEClassifier(metaClass.getName())) != null) {
					if (!(classifier instanceof EClass) || ((EClass)classifier).isAbstract()) {
						continue loop;
					}
					EObject result = ePackage.getEFactoryInstance().create(metaClass);
					fNodesForObjects.put(result, node);

//					if (result instanceof DynamicEObjectImpl) {
//						DynamicEObjectImpl dynamicEObject = (DynamicEObjectImpl) result;
//					}
					
					if (result instanceof ExtensibleElement) {
						ExtensibleElement element = (ExtensibleElement) result;
						element.setConcreteSyntax(node.getNodeText());
					}
					
//					if (result instanceof Extension) {
//						Extension extensionInstance = (Extension) result;
//						//extensionInstance.setExtensionInstanceUri(result.eResource().getURIFragment(result));
//						// TODO not in resource here
//					}
					
					return result;
				}
			}
			
			// meta-class does not exist in ecore-model
			throw new ModelCreatingException("Cannot instantiate " + metaClass.getName() + ".");
		}
		catch (IllegalArgumentException e) {
			// meta-class exists in ecore-model, but a corresponding java-class is missing

			// TODO create instance of the real meta-class
			
			// try to instantiate the super type

			return DblUtil.createObjectOfParentClass(metaClass);
			
			//EObjectImpl instance = (EObjectImpl) DblFactory.eINSTANCE.createStatementExtension();
			//instance.eSetClass(metaClass);
		}
	}

}
