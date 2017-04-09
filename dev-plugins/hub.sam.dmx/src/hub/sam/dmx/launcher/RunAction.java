package hub.sam.dmx.launcher;

import hub.sam.dmx.editor.DblTextEditor;
import hub.sam.dmx.launcher.java.UIJavaLauncher;
import hub.sam.dmx.launcher.programoutput.EditorConsole;
import hub.sam.dmx.semantics.TargetLanguageGenerator;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.FileEditorInput;

public class RunAction extends Action {

	private final DblTextEditor editor;
	
	private final TargetLanguageGenerator targetLanguageGenerator;

	private String targetSimLib;
	private String targetLanguage;
	
	public static final String JAVA_GEN_FOLDER_NAME = "gen-src";
	public static final String TEMP_FOLDER_NAME = "temp";
	
	public RunAction(DblTextEditor editor, TargetLanguageGenerator targetLanguageGenerator) {
		this.editor = editor;
		this.targetLanguageGenerator = targetLanguageGenerator;
	}
	
	public String getTargetSimLib() {
		return targetSimLib;
	}

	public void setTargetSimLib(String targetSimLib) {
		this.targetSimLib = targetSimLib;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public boolean isEnabled() {
		return !editor.hasError() && editor.getCurrentModel() != null && editor.getCurrentModel().getContents().size() > 0;
	}
	
	private Display currentDisplay;
	
	private IProject getCurrentProject() {
		IFile file = ((FileEditorInput) editor.getEditorInput()).getFile();
		return file.getProject();
	}
	
	public void run() {
		currentDisplay = Display.getCurrent();

		final IRunnableWithProgress runnable = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				IFile inputFile = ((FileEditorInput) editor.getEditorInput()).getFile();
				Resource metamodelResource = editor.getDblMetaModel().eResource();
				EditorConsole editorConsole = new EditorConsole(inputFile.getName() + " execution", currentDisplay);

				ModelLauncher launcher;
				if (getTargetLanguage() == "c++") {
					launcher = new ModelLauncherC(monitor, inputFile, metamodelResource, 
							editor.getLastModelCreatingContext(), targetSimLib, null, editorConsole);
				}
				else {
					launcher = new ModelLauncher(monitor, inputFile, metamodelResource, 
							editor.getLastModelCreatingContext(), targetLanguageGenerator, new UIJavaLauncher(currentDisplay, true),
							editorConsole);
				}
				//getCurrentProject().getRawLocation();
				//IPath xmiRawLocation = ResourcesPlugin.getWorkspace().getRoot().getFile(xmiPath).getRawLocation();
				//GroovyTest.main(null);
				launcher.compileAndRun(editor.getCurrentModel());
				monitor.done();
			}
		};
		
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(currentDisplay.getActiveShell());
        try {
			dialog.run(true, false, runnable);
		}
        catch (InvocationTargetException e) {
			e.printStackTrace();
		}
        catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}
