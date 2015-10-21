package hub.sam.dmx.editor;

import hub.sam.dmx.editor.InsideOutDocumentProvider.InsideOutSubstitutedDocument;

import java.util.logging.Logger;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.part.FileEditorInput;

public class InsideOutTextEditor extends DblTextEditor {
	
	private final static Logger logger = Logger.getLogger(DblPreProcessor.class.getName());
	
	private class InsideOutPreProcessor extends DblPreProcessor {

		public InsideOutPreProcessor(String filename, DblTextEditor editor) {
			super(filename, editor);
		}
		
	}
	
	public InsideOutTextEditor() {
		super();
		initialiseDocumentProvider();
	}
	
	@Override
	protected void initPreProcessor() {
		if (_preProcessor == null) {
			_preProcessor = new InsideOutPreProcessor(getEditorInput().getName(), this);
		}
	}
	
	@Override
	public void preProcessDocument() {
		initPreProcessor();
		super.preProcessDocument();
		IPath inputFile = ((FileEditorInput) getEditorInput()).getFile().getLocation();
		getPreProcessor().preProcess(getCurrentText(), inputFile.removeLastSegments(1));
		
		// TODO translate inside out extensions including semantics with a special pre-processor
		
		// extend the model a bit
		String text = getCurrentText();
		text = text.substring(0, text.length()-2) + " class X { string info = \"hello from shadowed X!\"; } }";
		logger.info("substituted inside out extensions.");
		
		IDocument doc = getDocumentProvider().getDocument((FileEditorInput) getEditorInput());
		if (doc instanceof InsideOutSubstitutedDocument) {
			InsideOutSubstitutedDocument subDoc = (InsideOutSubstitutedDocument) doc;
			subDoc.textWithSubstitutions = text;
		}		
	}

	protected void initialiseDocumentProvider() {
		setDocumentProvider(new InsideOutDocumentProvider());
	}
	
//	protected void postUpdateCurrentModel(final IModelCreatingContext context) {
//		String origininalInputText = getSourceViewer().getDocument().get();
//		//updateCurrentText(origininalInputText);
//		//updateCurrentText(context.getText() + "$$");
//	}

}
