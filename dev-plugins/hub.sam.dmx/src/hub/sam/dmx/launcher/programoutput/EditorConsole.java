package hub.sam.dmx.launcher.programoutput;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class EditorConsole implements ProgramOutputPrinter {
	
	private final String consoleLabel;
	private final Display associatedDisplay;
	
	// param: editorPartName + " execution"
	public EditorConsole(String consoleLabel, Display associatedDisplay) {
		this.consoleLabel = consoleLabel;
		this.associatedDisplay = associatedDisplay;
	}

	public void resetConsole() {
		MessageConsole console = getConsoleForCurrentEditor();
		console.clearConsole();
		console.activate();
	}
	
	public MessageConsoleStream getOutputStream() {
		return getConsoleForCurrentEditor().newMessageStream();
	}
	
	public MessageConsole getConsoleForCurrentEditor() {
		return getConsole();
	}
	
	private MessageConsole getConsole() {
		IConsoleManager conMgr = ConsolePlugin.getDefault().getConsoleManager();
		for (IConsole console: conMgr.getConsoles()) {
			if (console instanceof MessageConsole) {
				MessageConsole msgConsole = (MessageConsole) console;
				if (msgConsole.getName().equals(consoleLabel)) {
					return msgConsole;
				}
			}
		}
		MessageConsole msgConsole = new MessageConsole(consoleLabel, null);
		conMgr.addConsoles(new IConsole[] { msgConsole });
		return msgConsole;
	}
	
	public void redirectInputToConsole(String editorPartName, Process process) {
		try {
			MessageConsole console = getConsole();
			int b = process.getInputStream().read();
			while (b != -1) {
				console.newMessageStream().write(b);
				b = process.getInputStream().read();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private MessageConsoleStream newStream() {
		return getConsoleForCurrentEditor().newMessageStream();
	}

	private MessageConsoleStream newErrorStream() {
		MessageConsoleStream errorStream = getConsoleForCurrentEditor().newMessageStream();
		final Color errorColor = associatedDisplay.getSystemColor(SWT.COLOR_RED);
		errorStream.setColor(errorColor);
		return errorStream;
	}

	@Override
	public void clear() {
		resetConsole();
	}

	@Override
	public SimplePrinterStream newDefaultPrinterStream() {
		return new MessageConsoleSimplePrinterStream(newStream());
	}

	@Override
	public SimplePrinterStream newErrorPrinterStream() {
		return new MessageConsoleSimplePrinterStream(newErrorStream());
	}
	
}
