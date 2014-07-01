package hub.sam.dmx

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EPackage

class EcoreToDblGenerator extends AbstractGenerator {
	
	new(Resource modelResource, IPath outputFolder) {
		super(modelResource, outputFolder)
	}
	
	override startGenerator() {
		val pkg = modelResource.contents.head as EPackage
		
				
	}
	
}