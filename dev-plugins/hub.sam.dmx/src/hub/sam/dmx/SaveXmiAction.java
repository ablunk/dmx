package hub.sam.dmx;

import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ResourceAction;

public class SaveXmiAction extends ResourceAction implements ITefEditorStatusListener {

	public final static String MESSAGE_KEYS_PREFIX = "SaveXmiAction.";

	public final static String ACTION_DEFINITION_ID = "hub.sam.dmx.SaveXmi";
	
	private final TextEditor fEditor;

	public SaveXmiAction(TextEditor editor) {
		super(Activator.getMessagesBundle(), MESSAGE_KEYS_PREFIX);
		fEditor = editor;
		fEditor.addEditorStatusListener(this);
		setActionDefinitionId(ACTION_DEFINITION_ID);
	}
	
	@Override
	public void run() {
		run(fEditor);
	}
	
	@Override
	public boolean isEnabled() {
		return isEnabled(fEditor);
	}
	
	private static boolean isEnabled(TextEditor editor) {
		return !editor.hasError() && editor.getCurrentModel() != null && editor.getCurrentModel().getContents().size() > 0;
	}

	public static void run(TextEditor editor) {
		if (isEnabled(editor)) {
			URI xmiUri = URI.createURI(editor.getCurrentModel().getURI().trimFileExtension() + ".xmi");
			IPath xmiLocation = new Path(xmiUri.toPlatformString(true));
			IPath xmiRawLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(xmiLocation).getRawLocation();
			
			try {
				Map<String, Object> options = new HashMap<String, Object>();
				options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
				
				FileOutputStream originalAsXmiStream = new FileOutputStream(xmiRawLocation.toString());
				try {
					editor.getCurrentModel().save(originalAsXmiStream, options);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("saved as XMI: " + xmiRawLocation);
				
				// refreshing the folder that contains the XMI file, so the change is recognized by the editor
				((FileEditorInput) editor.getEditorInput()).getFile().getParent().refreshLocal(IResource.DEPTH_ONE, null);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
			catch (IOException e) {
				e.printStackTrace();
				return;
			} catch (CoreException e) {
				e.printStackTrace();
				return;
			}
		}
	}	
	
	public void errorStatusChanged(TextEditor editor) {
		setEnabled(!editor.hasError());
	}
	
	public void dispose() {
		fEditor.removeEditorStatusListener(this);
	}

	@Override
	public void rccSyntaxChanged(TextEditor editor) {
		// TODO Auto-generated method stub
		
	}
	
}
