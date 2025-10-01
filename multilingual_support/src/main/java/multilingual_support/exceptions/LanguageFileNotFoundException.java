package multilingual_support.exceptions;

/**
 * EN - Exception thrown when a language file cannot be found.
 * 
 * ES - Excepción lanzada cuando no se puede encontrar un fichero de idioma.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class LanguageFileNotFoundException extends Exception {

	private static final long serialVersionUID = -3725324899288696042L;

	public LanguageFileNotFoundException(String errorPath) {
		super("File not found: " + errorPath
				+ ". Please check if the file exists in the resources folder and verify that AvailableLanguages and FileType are correctly configured.");
	}
}
