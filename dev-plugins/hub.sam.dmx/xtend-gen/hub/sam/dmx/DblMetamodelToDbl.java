package hub.sam.dmx;

import hub.sam.dbl.DblPackage;
import hub.sam.dmx.EcoreToDblGenerator;
import org.eclipse.core.runtime.IPath;

@SuppressWarnings("all")
public class DblMetamodelToDbl extends EcoreToDblGenerator {
  public DblMetamodelToDbl(final IPath outputFolder) {
    super(outputFolder);
  }
  
  public void startGenerator() {
    this.makeFolder("resources-gen");
    this.startGenerator("resources-gen/dbl.dbl", DblPackage.eINSTANCE, "hub.sam.dbl");
  }
  
  public static void main(final String[] args) {
    DblMetamodelToDbl _dblMetamodelToDbl = new DblMetamodelToDbl(null);
    _dblMetamodelToDbl.startGenerator();
  }
}
