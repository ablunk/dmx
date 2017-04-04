package hub.sam.dmx.launcher.java;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;

import hub.sam.dmx.launcher.programoutput.ProgramOutputPrinter;

public interface JavaClassLauncher {
	void launch(IJavaProject project, IPath workingDirectory, String className, String[] args, ProgramOutputPrinter programOutputPrinter);
}
