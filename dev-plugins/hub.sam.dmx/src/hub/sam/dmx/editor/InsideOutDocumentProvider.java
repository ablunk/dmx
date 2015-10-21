package hub.sam.dmx.editor;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class InsideOutDocumentProvider extends FileDocumentProvider {

	public static class InsideOutSubstitutedDocument extends Document {
		public String textWithSubstitutions;
	}

	@Override
	protected IDocument createEmptyDocument() {
		return new InsideOutSubstitutedDocument();
	}
	
}
