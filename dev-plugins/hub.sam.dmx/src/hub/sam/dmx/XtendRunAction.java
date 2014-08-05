package hub.sam.dmx;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

public class XtendRunAction extends Action {

	private final DblTextEditor editor;

	private String targetSimLib;
	private String targetLanguage;
	
	public static final String JAVA_GEN_FOLDER_NAME = "gen-src";
	public static final String TEMP_FOLDER_NAME = "temp";
	
	public XtendRunAction(DblTextEditor editor) {
		this.editor = editor;
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
	
	public void run() {
		currentDisplay = Display.getCurrent();

		final IRunnableWithProgress runnable = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				ModelLauncher launcher = new ModelLauncher(monitor, currentDisplay, editor, targetSimLib, targetLanguage);
				launcher.compileAndRun();
				monitor.done();
			}
		};
		
//		final Job job = new Job("Compile & Run") {
//			@Override
//			protected IStatus run(IProgressMonitor monitor) {
//				runnable.run(monitor);
//				return Status.OK_STATUS;
//			}
//		};
//		job.schedule();
		
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
