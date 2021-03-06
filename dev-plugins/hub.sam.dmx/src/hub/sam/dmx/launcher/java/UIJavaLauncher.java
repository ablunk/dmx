package hub.sam.dmx.launcher.java;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.swt.widgets.Display;

import hub.sam.dmx.launcher.programoutput.ProgramOutputPrinter;

public class UIJavaLauncher implements JavaClassLauncher {

	private Display associatedDisplay;
	private boolean sync;

	private NonUIJavaClassLauncher nonUILauncher = new NonUIJavaClassLauncher();

	public UIJavaLauncher(Display associatedDisplay, boolean sync) {
		super();
		this.associatedDisplay = associatedDisplay;
		this.sync = sync;
	}

	@Override
	public void launch(IJavaProject project, IPath workingDirectory, String className, String[] args,
			ProgramOutputPrinter programOutputPrinter) {
		if (associatedDisplay != null) {
			if (sync) {
				associatedDisplay.syncExec(new Runnable() {
					public void run() {
						nonUILauncher.launch(project, workingDirectory, className, args, programOutputPrinter);
					}
				});
			} else {
				associatedDisplay.asyncExec(new Runnable() {
					public void run() {
						nonUILauncher.launch(project, workingDirectory, className, args, programOutputPrinter);
					}
				});
			}
		} else {
			nonUILauncher.launch(project, workingDirectory, className, args, programOutputPrinter);
		}
	}

}
