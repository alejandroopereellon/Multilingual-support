package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import multilingual_support.language_selection.DefaultLanguage;

class DefaultLanguageTest {

	@Test
	void testDefaultLanguage() {
		assertEquals("de", DefaultLanguage.getDefaultLanguage());
	}

}
