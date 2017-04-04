package hub.sam.dmx.launcher.programoutput;

public interface ProgramOutputPrinter {
	void clear();
	SimplePrinterStream newDefaultPrinterStream();
	SimplePrinterStream newErrorPrinterStream();
}
