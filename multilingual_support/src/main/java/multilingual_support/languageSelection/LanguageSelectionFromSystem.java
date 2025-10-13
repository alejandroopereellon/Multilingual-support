package multilingual_support.languageSelection;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EN - Class that implements {@link LanguageProvider} and selects the language
 * based on the OS locale.
 * 
 * ES - Clase que implementa {@link LanguageProvider} y selecciona el idioma en
 * base al locale del sistema operativo.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class LanguageSelectionFromSystem implements LanguageProvider {

	private static final Logger logger = LogManager.getLogger(LanguageSelectionFromSystem.class);

	@Override
	public String selectLanguage() {
		String osLanguage = Locale.getDefault().getLanguage().toLowerCase();

		logger.info("Detected system locale language: {}", osLanguage);

		return new CheckLanguageExists().validateLanguage(osLanguage);
	}
}
