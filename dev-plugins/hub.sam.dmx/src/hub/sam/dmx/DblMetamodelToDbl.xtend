package hub.sam.dmx

import hub.sam.dbl.DblPackage
import org.eclipse.core.runtime.IPath

class DblMetamodelToDbl extends EcoreToDblGenerator {
	
	new(IPath outputFolder) {
		super(outputFolder)
	}
	
	override startGenerator() {
		makeFolder("resources-gen")
		startGenerator("resources-gen/dbl.dbl", DblPackage.eINSTANCE, "hub.sam.dbl")			
	}
	
	def static void main(String[] args) {
		(new DblMetamodelToDbl(null)).startGenerator
	}
	
}