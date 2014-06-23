package hub.sam.dmx;

import hub.sam.dmx.BasicDblToJavaGenerator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class ExtensionsToJavaGenerator extends BasicDblToJavaGenerator {
  public ExtensionsToJavaGenerator(final Resource modelResource, final IPath outputFolder) {
    super(modelResource, outputFolder);
  }
  
  public String genIdExpr_for_PredefinedId_meLiteral() {
    return "self";
  }
}
