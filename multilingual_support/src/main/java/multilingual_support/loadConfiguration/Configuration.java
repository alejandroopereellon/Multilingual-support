package multilingual_support.loadConfiguration;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EN - Class responsible for loading the multilingual system configuration.
 * 
 * ES - Clase responsable de cargar la configuración del sistema multilingüe.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class Configuration {

	private static final Logger logger = LogManager.getLogger(Configuration.class);

	private static String defaultLanguage;
	private static String[] languages;
	private static String[] foldersAvailable;

	static {
		load();
	}

	/**
	 * EN - Loads the configuration from the properties file located in the
	 * resources directory.
	 * 
	 * ES - Carga la configuración desde el archivo .properties ubicado en la
	 * carpeta de recursos.
	 */
	public static void load() {
		Properties config = new Properties();
		logger.debug("Configuration properties object created.");

		try {
			config.load(Configuration.class.getResourceAsStream("/multilanguage_config.properties"));
			logger.debug("Configuration file successfully loaded from resources.");

			// Load all configuration values
			defaultLanguage = config.getProperty("default_language");
			logger.debug("Default language loaded: {}", defaultLanguage);

			languages = config.getProperty("languages_supported").trim().split(",");
			logger.debug("Supported languages loaded: {}", Arrays.toString(languages));

			foldersAvailable = config.getProperty("folders").trim().split(",");
			logger.debug("Available folders loaded: {}", Arrays.toString(foldersAvailable));

		} catch (IOException e) {
			logger.error("An error occurred while loading the configuration file from resources.", e);
		}
	}

	// Getters
	public static String getDefaultLanguage() {
		return defaultLanguage;
	}

	public static String[] getLanguages() {
		return languages;
	}

	public static String[] getFoldersAvailable() {
		return foldersAvailable;
	}

	
}
