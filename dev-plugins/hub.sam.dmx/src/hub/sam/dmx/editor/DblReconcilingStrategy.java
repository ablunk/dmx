package hub.sam.dmx.editor;

import java.util.logging.Logger;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;

import hub.sam.dmx.editor.InsideOutDocumentProvider.InsideOutSubstitutedDocument;
import hub.sam.tef.editor.ReconcilingStrategy;
import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;

public class DblReconcilingStrategy extends ReconcilingStrategy {
	
	private final static Logger logger = Logger.getLogger(DblReconcilingStrategy.class.getName());
	
	final DblTextEditor editor;

	@Override
	protected String getInputText() {
		IDocument doc = getDocument();
		if (doc instanceof InsideOutSubstitutedDocument) {
			InsideOutSubstitutedDocument subDoc = (InsideOutSubstitutedDocument) doc;
			if (subDoc.textWithSubstitutions != null) {
				return subDoc.textWithSubstitutions;
			}
			else {
				return subDoc.get();
			}
		}
		else {
			return super.getInputText();
		}
	}

	public DblReconcilingStrategy(DblTextEditor editor, final ISourceViewer sourceViewer) {
		super(editor, sourceViewer);
		this.editor = editor;
		
		editor.addEditorStatusListener(new ITefEditorStatusListener() {
			
			@Override
			public void referencedModelChanged(TextEditor editor) {
				logger.info("referenced model changed for editor '" + editor.getEditorInput().getName() + "'");
				if (sourceViewer.getDocument() != null) {
					logger.info(" -> initiate reconcile");
					reconcile(null);
				}
				else {
					logger.info(" -> no reconcile (editor was closed)");
				}
			}
			
			@Override
			public void rccSyntaxChanged(TextEditor editor) {
				// empty
			}
			
			@Override
			public void modelChanged(TextEditor editor) {
				// empty
			}
			
			@Override
			public void errorStatusChanged(TextEditor editor) {
				// empty
			}
		});
	}

}
