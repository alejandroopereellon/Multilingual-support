package multilingual_support.language_selection;

/**
 * EN - Enum that contains the available languages for the application. The
 * default language is configured in {@link DefaultLanguage}
 * 
 * ES - Enum que contiene los idiomas disponibles para la aplicación. El idioma
 * por defecto se configura en {@link DefaultLanguage}.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public enum AvailableLanguages {
	SPANISH("es"), ENGLISH("en"), FRENCH("fr"), GERMAN("de"), PORTUGUESE("pt");

	private final String code;

	private AvailableLanguages(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
