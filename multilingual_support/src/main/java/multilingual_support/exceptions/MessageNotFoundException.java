package multilingual_support.exceptions;

/**
 * EN – Exception thrown when a translation message is not found.
 * 
 * ES – Excepción lanzada cuando no se encuentra un mensaje de traducción.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class MessageNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8072940838224073917L;

	public MessageNotFoundException(String messageKey) {
		super("Message not found for key: " + messageKey
				+ ". Please check if the key exists in the loaded translations.");
	}
}
