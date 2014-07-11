package hub.sam.dmx;

import org.eclipse.jface.text.source.ISourceViewer;

import hub.sam.tef.editor.ReconcilingStrategy;
import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;

public class ModelReferenceAwareReconcilingStrategy extends ReconcilingStrategy {
	
	final DblTextEditor editor;

	public ModelReferenceAwareReconcilingStrategy(DblTextEditor editor, final ISourceViewer sourceViewer) {
		super(editor, sourceViewer);
		this.editor = editor;
		
		editor.addEditorStatusListener(new ITefEditorStatusListener() {
			
			@Override
			public void referencedModelChanged(TextEditor editor) {
				System.out.println("referenced model changed for editor '" + editor.getEditorInput().getName() + "'");
				if (sourceViewer.getDocument() != null) {
					System.out.println(" -> initiate reconcile");
					reconcile(null);
				}
				else {
					System.out.println(" -> no reconcile (editor is closed)");
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
