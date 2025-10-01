package multilingual_support.language_selection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EN – Class responsible for providing the default language.
 * 
 * ES – Clase encargada de proporcionar el idioma por defecto.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class DefaultLanguage {

	private static final Logger logger = LogManager.getLogger(DefaultLanguage.class);

	private static final String DEFAULT_LANGUAGE = AvailableLanguages.GERMAN.getCode();

	public static String getDefaultLanguage() {
		logger.info("the default language ({}) has been requested", DEFAULT_LANGUAGE);
		return DEFAULT_LANGUAGE;
	}
}
