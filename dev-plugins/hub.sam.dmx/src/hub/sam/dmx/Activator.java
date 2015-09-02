package hub.sam.dmx;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ResourceBundle;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "hub.sam.dmx"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}
	
	public static ResourceBundle getMessagesBundle() {
		return ResourceBundle.getBundle("resources/messages");
	}

	public static final String lineSep = System.getProperty("line.separator");

	public static class VerySimpleFormatter extends Formatter {
		
		public String format(LogRecord record) {
			StringBuffer buf = new StringBuffer(180);
			buf.append(record.getLevel() + ": ");
			buf.append(formatMessage(record));
			buf.append(" [ in ");
			buf.append(record.getSourceClassName());
			buf.append(".");
			buf.append(record.getSourceMethodName());
			buf.append("() ]");
			buf.append(lineSep);
			
			Throwable throwable = record.getThrown();
			if (throwable != null) {
				StringWriter sink = new StringWriter();
				throwable.printStackTrace(new PrintWriter(sink, true));
				buf.append(sink.toString());
			}
 
			return buf.toString();
		}
		
	}
	
	public static class SystemOutConsoleHandler extends StreamHandler {
		
		public SystemOutConsoleHandler(Formatter formatter) {
			super(System.out, formatter);
		}
		
		public void publish(LogRecord record) {
			super.publish(record);
			flush();
		}
		
		public void close() {
			flush();
		}
	}

	public static final Logger dmxLogger = Logger.getLogger("hub.sam.dmx");
	public static final Logger dblLogger = Logger.getLogger("hub.sam.dbl");
	
	private final Handler loggerHandler = new SystemOutConsoleHandler(new VerySimpleFormatter());//new StreamHandler(System.out, new VerySimpleFormatter());
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		configureLogger(dmxLogger);
		configureLogger(dblLogger);
	}
	
	private void configureLogger(Logger logger) {
		logger.setLevel(Level.FINE); 
		for (Handler h: logger.getHandlers()) {
			logger.removeHandler(h);
		}
		logger.setUseParentHandlers(false);
		logger.addHandler(loggerHandler);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
