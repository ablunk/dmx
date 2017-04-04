package hub.sam.dmx.launcher.programoutput;

public interface SimplePrinterStream {
	void println(String message);
	void print(String message);
	void close();
}
