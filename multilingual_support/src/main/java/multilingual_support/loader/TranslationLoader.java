package multilingual_support.loader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import multilingual_support.exceptions.LanguageFileNotFoundException;
import multilingual_support.language_selection.DefaultLanguage;
import multilingual_support.language_selection.FileType;

/**
 * EN – Class responsible for loading and storing translation key–value pairs
 * for the selected language.
 * 
 * ES – Clase responsable de cargar y almacenar pares clave–valor de traducción
 * para el idioma seleccionado.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class TranslationLoader {
	private static final Logger logger = LogManager.getLogger(TranslationLoader.class);

	// Create the values
	private final HashMap<String, String> translations = new HashMap<>();

	private final String languageCode;

	// Create constructor
	public TranslationLoader(String language) {
		this.languageCode = language;
	}

	/**
	 * EN - Loads translations into the HashMap step by step.
	 * 
	 * ES - Este método carga las traducciones en el HashMap paso a paso.
	 * 
	 * @throws LanguageFileNotFoundException
	 */

	public void loadTranslations() {
		logger.info("The translations will be loaded");

		for (FileType type : FileType.values()) {
			logger.info("They are going to load the file: {}", type.getCode());
			try {
				/**
				 * EN - Create the inputStream
				 * 
				 * ES - Creamos el inputStream
				 */
				InputStream input = openResource(type);

				/**
				 * EN - Insert generic data into the HashMap.
				 * 
				 * ES - Insertamos los datos genericos en el hashMap
				 */
				loadFromProperties(input);

			} catch (Exception e) {
				logger.error("Error loading translations for file {}", type.getCode(), e);
				e.printStackTrace();
			}

		}
	}

	/**
	 * EN - Creates the {@link InputStream} using the selected language, If the file
	 * does not exist, the default language is used
	 * 
	 * ES - Crea el {@link InputStream} con el lenguaje seleccionado, en caso de no
	 * existir el fichero se usara el lenguaje predeterminado
	 * 
	 * @param type (generic / personalized / ...)
	 * @return {@link InputStream}
	 * @throws LanguageFileNotFoundException
	 */
	private InputStream openResource(FileType type) throws LanguageFileNotFoundException {
		String filePath = "/messages/" + type.getCode() + "/messages_" + languageCode.toLowerCase() + ".properties";
		logger.debug("The file path is {}" + filePath);

		/**
		 * EN - We create the generic inputStream
		 * 
		 * ES - Creamos el inputStream generico
		 */
		InputStream languageFile = getClass().getResourceAsStream(filePath);
		logger.debug("The value of the inputStream languageFile is: {}", languageFile);

		// Check if null
		if (languageFile == null) {
			/**
			 * EN - If the file not found we use the default language
			 * 
			 * ES - En caso de no existir el fichero se utiliza el lenguaje predeterminado
			 */
			logger.warn("Language file not found, trying default language");
			languageFile = getClass().getResourceAsStream("/messages/" + type.getCode() + "/messages_"
					+ DefaultLanguage.getDefaultLanguage() + ".properties");

			/**
			 * EN - If the default file does not exist either, an exception will be created.
			 * 
			 * ES - Si el fichero predeterminado tampoco existe se va a crear una excepcion.
			 */
			if (languageFile == null) {
				logger.error("The selected {} and default {} language is not found for the file: {}", languageCode,
						DefaultLanguage.getDefaultLanguage(), filePath);
				throw new LanguageFileNotFoundException(filePath);
			}
		}

		logger.info("The language file was found. Returning InputStream.");
		return languageFile;
	}

	/**
	 * EN - Method thats create the {@link HashMap} with the properties file
	 * 
	 * ES - Metodo encargado de crear el {@link HashMap} con los datos del fichero
	 * properties
	 * 
	 * @param hashMap
	 * @param input
	 * @throws LanguageFileNotFoundException
	 */
	private void loadFromProperties(InputStream input) throws LanguageFileNotFoundException {
		if (input == null) {
			logger.error("The language file is null {}", input);
			throw new LanguageFileNotFoundException("Input stream is null");
		}

		Properties props = new Properties();

		/**
		 * EN - Load the data from the file into memory.
		 * 
		 * ES - Almacenamos en memoria los datos del fichero
		 */
		try (InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {
			props.load(reader);
			logger.debug("Properties successfully loaded from InputStream");
		} catch (Exception e) {
			throw new RuntimeException("Error reading the file", e);
		}

		/**
		 * EN - Loads translations from a properties file
		 * 
		 * ES - Cargar las traducciones desde el fichero de propiedades.
		 */
		for (String key : props.stringPropertyNames()) {
			translations.put(key, props.getProperty(key));
		}
		logger.info("Loaded {} keys into the HashMap", props.size());
	}

	// Getters && setters

	public String getLanguageCode() {
		return languageCode;
	}

	public HashMap<String, String> getTranslations() {
		return translations;
	}
}
