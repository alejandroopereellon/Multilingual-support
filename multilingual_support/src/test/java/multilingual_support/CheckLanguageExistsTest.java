package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import multilingual_support.languageSelection.CheckLanguageExists;
import multilingual_support.loadConfiguration.Configuration;

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
		assertEquals(Configuration.getDefaultLanguage(), checker.validateLanguage("TESTERROR"));
	}

	@Test
	void languageNull() {
		assertEquals(Configuration.getDefaultLanguage(), checker.validateLanguage(null));
	}

}
