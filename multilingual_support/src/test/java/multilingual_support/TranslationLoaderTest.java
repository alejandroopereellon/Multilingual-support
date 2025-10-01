package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import multilingual_support.exceptions.MessageNotFoundException;
import multilingual_support.getMessages.MessageProvider;
import multilingual_support.loader.TranslationLoader;

class TranslationLoaderTest {

	@Test
	void testValidFile() throws MessageNotFoundException {
		TranslationLoader translation = new TranslationLoader("es");

		translation.loadTranslations();

		assertEquals("Actualizar", new MessageProvider(translation.getTranslations()).findMessage("GENERAL_REFRESH"));
	}

	@Test
	void testValidFileLanguageNotExists() throws MessageNotFoundException {
		TranslationLoader translation = new TranslationLoader("fakeLanguage");

		translation.loadTranslations();

		assertEquals("Aktualisieren",
				new MessageProvider(translation.getTranslations()).findMessage("GENERAL_REFRESH"));
	}

}
