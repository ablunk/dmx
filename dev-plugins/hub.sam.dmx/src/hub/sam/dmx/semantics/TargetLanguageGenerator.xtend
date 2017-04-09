package hub.sam.dmx.semantics

import hub.sam.dbl.Model
import org.eclipse.core.runtime.IPath

interface TargetLanguageGenerator {
	def void genModel(Model model, boolean mainModel, IPath outputFolder)
}