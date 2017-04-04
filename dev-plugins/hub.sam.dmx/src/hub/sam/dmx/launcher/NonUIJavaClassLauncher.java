package hub.sam.dmx.launcher;

import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMRunnerConfiguration;

public class NonUIJavaClassLauncher implements JavaClassLauncher {
	
	protected static final Logger logger = Logger.getLogger(NonUIJavaClassLauncher.class.getName());
	
	@Override
	public void launch(IJavaProject project, IPath workingDirectory, String className, String[] args, ProgramOutputPrinter programOutputPrinter) {
		IVMInstall vmInstall = null;
		try {
			vmInstall = JavaRuntime.getVMInstall(project);
		} catch (CoreException e1) {
			throw new RuntimeException(e1);
		}
		if (vmInstall == null) {
			vmInstall = JavaRuntime.getDefaultVMInstall();
		}
		if (vmInstall != null) {
			IVMRunner vmRunner = vmInstall.getVMRunner(ILaunchManager.RUN_MODE);
			if (vmRunner != null) {
				String[] classPath = null;
				try {
					classPath = JavaRuntime.computeDefaultRuntimeClassPath(project);
				}
				catch (CoreException e) {
				}
				if (classPath != null) {
					VMRunnerConfiguration vmConfig = new VMRunnerConfiguration(className, classPath);
					if (args != null) {
						vmConfig.setProgramArguments(args);
					}
					vmConfig.setWorkingDirectory(workingDirectory.toString());
					final ILaunch launch = new Launch(null, ILaunchManager.RUN_MODE, null);
					logger.info("Launching Java program " + className + " ... ");
					try {
						vmRunner.run(vmConfig, launch, null);
					} catch (CoreException e) {
						throw new RuntimeException(e);
					}
			        final IProcess[] processes = launch.getProcesses();

			        if (launch.getProcesses().length == 0) {
			        	logger.severe("Program could not be launched.");
					}
					else {
						final SimplePrinterStream stream = programOutputPrinter.getDefaultPrinterStream();
						
						IStreamListener outputStreamListener = new IStreamListener() {
							@Override
							public void streamAppended(String text, IStreamMonitor monitor) {
								stream.print(text);
							}
						};
						processes[0].getStreamsProxy().getOutputStreamMonitor().addListener(outputStreamListener);
						
						final SimplePrinterStream errorStream = programOutputPrinter.getErrorPrinterStream();
						
						IStreamListener errorStreamListener = new IStreamListener() {
							@Override
							public void streamAppended(String text, IStreamMonitor monitor) {
								errorStream.print(text);
							}
						};
						processes[0].getStreamsProxy().getErrorStreamMonitor().addListener(errorStreamListener);
						
        				while (!launch.isTerminated()) {
        					try {
        						Thread.sleep(100);
        					}
				            catch (InterruptedException ie) {
				                ie.printStackTrace();
				            }
        					if (processes[0].getStreamsProxy().getErrorStreamMonitor().getContents().length() > 0) {
        						logger.severe("Error encountered.");
        						break;
        					}
        				}
        				
        				processes[0].getStreamsProxy().getOutputStreamMonitor().removeListener(outputStreamListener);
        				processes[0].getStreamsProxy().getErrorStreamMonitor().removeListener(errorStreamListener);
        				
						stream.close();
						errorStream.close();
        				
        				logger.info("Program terminated.");
					}
				}
			}
		}
	}

}
