package hub.sam.dmx;

public class TransformationProperties {

	public static final String defaultSimulationLibrary = "desmoj";
	public static final String defaultTargetLanguage = "java";
	
	private static String currentTargetLanguage = defaultTargetLanguage;
	private static String currentSimulationLibrary = defaultSimulationLibrary;

	public static void resetToDefaults() {
		currentSimulationLibrary = defaultSimulationLibrary;
		currentTargetLanguage = defaultTargetLanguage;
	}
	
	public static String getSimLib() {
		return currentSimulationLibrary;
	}
	
	public static void setSimLib(String simLib) {
		currentSimulationLibrary = simLib;
	}
	
	public static String getTargetLanguage() {
		return currentTargetLanguage;
	}
	
}
