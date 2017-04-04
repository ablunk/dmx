package hub.sam.dmx.launcher;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;

public interface JavaClassLauncher {
	void launch(IJavaProject project, IPath workingDirectory, String className, String[] args, ProgramOutputPrinter programOutputPrinter);
}
