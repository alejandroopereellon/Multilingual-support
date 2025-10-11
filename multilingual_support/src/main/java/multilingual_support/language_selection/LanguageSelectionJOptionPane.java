package multilingual_support.language_selection;

import java.util.Arrays;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import multilingual_support.loadConfiguration.Configuration;

/**
 * EN - Class that implements the LanguageProvider interface to allow the user
 * to select the application language using a JOptionPane.
 * 
 * ES - Clase que implementa la interfaz LanguageProvider para permitir al
 * usuario seleccionar el idioma mediante un JOptionPane.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class LanguageSelectionJOptionPane implements LanguageProvider {

	private static final Logger logger = LogManager.getLogger(LanguageSelectionJOptionPane.class);

	/**
	 * EN - Method that allows the user to select the application language.
	 * 
	 * ES - Método que permite al usuario seleccionar el idioma de la aplicación.
	 * 
	 * @return The selected language as a String. - El idioma seleccionado como un
	 *         String.
	 * 
	 * @author Alejandro Perellón López
	 * @version 1.0
	 */
	@Override
	public String selectLanguage() {
		logger.debug("The language selection from JOptionPane has been requested");
		/**
		 * EN - Display a JOptionPane dialog to let the user select a language
		 * 
		 * ES - Mostramos un JOptionPane para que el usuario seleccione el idioma
		 */
		String selection = (String) JOptionPane.showInputDialog(null, "Select a Language", "Language Selection",
				JOptionPane.QUESTION_MESSAGE, null, getArrayLanguageName(),
				getLanguageName(Configuration.getDefaultLanguage()));

		logger.debug("The value of selection from the JOptionPane is: {}", selection);

		/**
		 * EN - If the selection is null, the default language is used. Otherwise, the
		 * language chosen in the JOptionPane is returned.
		 * 
		 * ES - Si la selección es nula se escogerá el idioma por defecto, en caso
		 * contrario se introduce el idioma seleccionado en el JOptionPane
		 */
		if (selection != null) {
			logger.info("User selected a valid language: {}", selection);
			return selection;
		} else {
			JOptionPane.showMessageDialog(null,
					"The default language will be selected (" + Configuration.getDefaultLanguage() + ")",
					"Language selection canceled", JOptionPane.INFORMATION_MESSAGE);
		}

		logger.warn("No language was selected in the JOptionPane. Returning default language.");
		return Configuration.getDefaultLanguage();
	}

	/**
	 * EN - Returns the full language name in English.
	 * 
	 * ES - Devuelve el nombre completo del idioma en inglés.
	 * 
	 * @param languageCode The language code ("es", "en", "fr", "de", "pt").
	 * @return The full language name in English, e.g. "Spanish", or "Unknown" if
	 *         invalid.
	 */
	private String getLanguageName(String languageCode) {
		if (languageCode == null || languageCode.isBlank()) {
			return "Unknown";
		}

		try {
			Locale locale = Locale.of(languageCode.toLowerCase());

			String languageName = locale.getDisplayLanguage(Locale.ENGLISH);

			return languageName;
		} catch (Exception e) {
			logger.error("There was an error getting the language name.", e);
			return "Unknown";
		}

	}

	/**
	 * EN - Returns an array containing the full names of the available languages.
	 * 
	 * ES - Devuelve un array que contiene los nombres completos de los idiomas
	 * disponibles.
	 * 
	 * @return {@link Arrays} with the name
	 */
	private String[] getArrayLanguageName() {
		// Create array with the same size of the languages list in configuration
		String[] languageNameList = new String[Configuration.getLanguages().length];

		for (int i = 0; i < languageNameList.length; i++) {
			languageNameList[i] = getLanguageName(Configuration.getLanguages()[i]);

		}

		return languageNameList;
	}
}
