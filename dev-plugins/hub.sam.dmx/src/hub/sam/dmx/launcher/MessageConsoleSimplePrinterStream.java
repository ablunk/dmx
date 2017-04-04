package hub.sam.dmx.launcher;

import java.io.IOException;

import org.eclipse.ui.console.MessageConsoleStream;

public class MessageConsoleSimplePrinterStream implements SimplePrinterStream {
	
	private MessageConsoleStream messageConsoleStream;

	public MessageConsoleSimplePrinterStream(MessageConsoleStream messageConsoleStream) {
		this.messageConsoleStream = messageConsoleStream;
	}

	@Override
	public void println(String message) {
		messageConsoleStream.println(message);
	}

	@Override
	public void print(String message) {
		messageConsoleStream.print(message);
	}

	@Override
	public void close() {
		try {
			messageConsoleStream.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
