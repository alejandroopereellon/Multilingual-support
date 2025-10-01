package multilingual_support.language_selection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EN – Class responsible for checking whether a language exists in
 * {@link AvailableLanguages}. If it does not exist or is null, the default
 * language is returned.
 * 
 * ES – Clase encargada de comprobar si el idioma existe en
 * {@link AvailableLanguages}. En caso de no existir o ser nulo, se devuelve el
 * idioma predeterminado.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class CheckLanguageExists {
	private static final Logger logger = LogManager.getLogger(CheckLanguageExists.class);

	public String validateLanguage(String language) {
		logger.debug("The selected language is: {}", language);

		if (language != null && !language.isBlank()) {
			logger.debug("The provided language '{}' is not null/blank", language);

			for (AvailableLanguages lang : AvailableLanguages.values()) {
				if (lang.getCode().equalsIgnoreCase(language)) {
					logger.info("The language {} was found and return it", lang);
					return lang.getCode();
				}
			}
			logger.info("The language {} does not exist in AvailableLanguages", language);
		}
		/**
		 * EN - if it does not exist or is null, the default language is returned.
		 */
		logger.warn("The selected value is null, blank or doesnt exists, return the default language");
		return DefaultLanguage.getDefaultLanguage();

	}
}
