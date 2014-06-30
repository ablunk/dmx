package hub.sam.tef.editor.text;

public interface ITefEditorStatusListener {
	void errorStatusChanged(TextEditor editor);
	void rccSyntaxChanged(TextEditor editor);
	void modelChanged(TextEditor editor);
	void referencedModelChanged(TextEditor editor);
}
