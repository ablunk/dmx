package hub.sam.dmx.editor;

import hub.sam.tef.editor.Reconciler;
import hub.sam.tef.editor.SourceViewerConfiguration;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.ISourceViewer;

public class DblSourceViewerConfiguration extends SourceViewerConfiguration {
	
	final DblTextEditor editor;

	public DblSourceViewerConfiguration(DblTextEditor editor) {
		super(editor);
		this.editor = editor;
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {	
		IReconcilingStrategy strategy = new ModelReferenceAwareReconcilingStrategy(editor, sourceViewer); 
		MonoReconciler reconciler= new Reconciler(editor, strategy, false);		
		reconciler.setIsIncrementalReconciler(false);
		reconciler.setProgressMonitor(new NullProgressMonitor());
		reconciler.setDelay(500);
		return reconciler;				
	}
	
}
