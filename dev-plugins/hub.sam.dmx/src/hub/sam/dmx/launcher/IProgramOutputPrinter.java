package hub.sam.dmx.launcher;

public interface IProgramOutputPrinter {
	void clear();
	SimplePrinterStream getDefaultPrinterStream();
	SimplePrinterStream getErrorPrinterStream();
}
