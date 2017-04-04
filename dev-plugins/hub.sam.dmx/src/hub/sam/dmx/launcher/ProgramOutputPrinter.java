package hub.sam.dmx.launcher;

public interface ProgramOutputPrinter {
	void clear();
	SimplePrinterStream newDefaultPrinterStream();
	SimplePrinterStream newErrorPrinterStream();
}
