package multilingual_support.getMessages;

import java.text.MessageFormat;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * EN – Class responsible for returning messages from a {@link HashMap}.
 * 
 * ES – Clase encargada de retornar los mensajes desde un {@link HashMap}.
 * 
 * @author Alejandro Perellón López
 * @version 1.0
 */
public class MessageProvider {

	private final HashMap<String, String> map;

	private static final Logger logger = LogManager.getLogger(MessageProvider.class);

	public MessageProvider(HashMap<String, String> map) {
		this.map = map;
	}

	public String findMessage(String key) {
		String message = map.get(key);
		logger.debug("The value of message is: {}", message);

		if (message == null || message.isBlank()) {
			logger.error("Message with key '{}' not found.", key);
			return "[Missing message: " + key + "]";
		}

		return message;
	}

	public String findMessage(String key, Object... args) {
		String message = findMessage(key);
		return MessageFormat.format(message, args);
	}
}
