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
    this.startGenerator("resources-gen/dbl.dbl", DblPackage.eINSTANCE, "hub.sam.dbl", new String[] { "ecore" });
  }
  
  public static void main(final String[] args) {
    DblMetamodelToDbl _dblMetamodelToDbl = new DblMetamodelToDbl(null);
    _dblMetamodelToDbl.startGenerator();
  }
  
  public String escapeName(final String name) {
    String _xifexpression = null;
    boolean _or = false;
    boolean _equals = name.equals("priority");
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = name.equals("type");
      _or = _equals_1;
    }
    if (_or) {
      _xifexpression = (name + "_");
    }
    return _xifexpression;
  }
}
