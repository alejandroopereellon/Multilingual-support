package multilingual_support.language_selection;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		AvailableLanguages selection = (AvailableLanguages) JOptionPane.showInputDialog(null, "Select a Language",
				"Language Selection", JOptionPane.QUESTION_MESSAGE, null, AvailableLanguages.values(),
				AvailableLanguages.ENGLISH);

		logger.debug("The value of selection from the JOptionPane is: {}", selection);

		/**
		 * EN - If the selection is null, the default language is used. Otherwise, the
		 * language chosen in the JOptionPane is returned.
		 * 
		 * ES - Si la selección es nula se escogerá el idioma por defecto, en caso
		 * contrario se introduce el idioma seleccionado en el JOptionPane
		 */
		if (selection != null) {
			logger.info("User selected a valid language: {}", selection.getCode());
			return selection.getCode();
		} else {
			JOptionPane.showMessageDialog(null,
					"The default language will be selected (" + DefaultLanguage.getDefaultLanguage() + ")",
					"Language selection canceled", JOptionPane.INFORMATION_MESSAGE);
		}

		logger.warn("No language was selected in the JOptionPane. Returning default language.");
		return DefaultLanguage.getDefaultLanguage();
	}

}
