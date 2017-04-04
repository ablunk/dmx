package hub.sam.dmx.launcher;

public interface ProgramOutputPrinter {
	void clear();
	SimplePrinterStream getDefaultPrinterStream();
	SimplePrinterStream getErrorPrinterStream();
}
