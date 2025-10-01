package multilingual_support.language_selection;

/**
 * EN - Enum representing the available types of message files in the
 * application.
 * 
 * ES - Enum que representa los tipos de ficheros de mensajes disponibles en la
 * aplicación.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public enum FileType {
	GENERIC("generic"), PERSONALIZED("personalized");

	private final String code;

	FileType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
