package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import multilingual_support.loadConfiguration.Configuration;

class DefaultLanguageTest {

	@Test
	void testDefaultLanguage() {
		System.out.println(Configuration.getDefaultLanguage());
		assertEquals("de", Configuration.getDefaultLanguage());
	}

}
