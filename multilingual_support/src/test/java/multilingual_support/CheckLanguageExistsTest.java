package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import multilingual_support.language_selection.CheckLanguageExists;
import multilingual_support.language_selection.DefaultLanguage;

class CheckLanguageExistsTest {
	private final CheckLanguageExists checker = new CheckLanguageExists();

	@Test
	void languageExistsLowerCase() {
		assertEquals("es", checker.validateLanguage("es"));
	}

	@Test
	void languageExistsUpperCase() {
		assertEquals("es", checker.validateLanguage("ES"));
	}

	@Test
	void languageNotExists() {
		assertEquals(DefaultLanguage.getDefaultLanguage(), checker.validateLanguage("TESTERROR"));
	}

	@Test
	void languageNull() {
		assertEquals(DefaultLanguage.getDefaultLanguage(), checker.validateLanguage(null));
	}

}
