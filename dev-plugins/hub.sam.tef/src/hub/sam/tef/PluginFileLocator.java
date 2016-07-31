package hub.sam.tef;

import java.net.URL;
import java.util.logging.Logger;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.Bundle;

public class PluginFileLocator {
	
	private static final Logger LOGGER = Logger.getLogger(PluginFileLocator.class.getName());
	
	private final Bundle bundle;
	
	
	public PluginFileLocator(Bundle bundle) {
		this.bundle = bundle;
	}
	
	
	public PluginFileLocator(Plugin plugin) {
		if (plugin != null && plugin.getBundle() != null) {
			this.bundle = plugin.getBundle();
		} else {
			this.bundle = null;
		}
	}
	
	
	public boolean hasBundle() {
		return bundle != null;
	}
	

	public URL findFile(String fileWithPluginRelativePath) {
		LOGGER.info("trying to find file: " + fileWithPluginRelativePath);
		return FileLocator.find(bundle, new Path(fileWithPluginRelativePath), null);
	}

}
