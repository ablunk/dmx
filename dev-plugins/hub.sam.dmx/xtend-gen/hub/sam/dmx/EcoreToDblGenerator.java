package hub.sam.dmx;

import hub.sam.dmx.AbstractGenerator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EcoreToDblGenerator extends AbstractGenerator {
  public EcoreToDblGenerator(final Resource modelResource, final IPath outputFolder) {
    super(modelResource, outputFolder);
  }
  
  public void startGenerator() {
    EList<EObject> _contents = this.modelResource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final EPackage pkg = ((EPackage) _head);
  }
}
