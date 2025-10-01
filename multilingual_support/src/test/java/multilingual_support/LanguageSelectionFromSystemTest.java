package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import multilingual_support.language_selection.LanguageSelectionFromSystem;

class LanguageSelectionFromSystemTest {

	Locale original = Locale.getDefault();

	@Test
	void currentOSLanguage() {
		assertEquals("es", new LanguageSelectionFromSystem().selectLanguage());
	}

	@Test
	void currentOSLanguageNotExists() {
		Locale fake = Locale.of("FakeLocation");
		Locale.setDefault(fake);
		assertEquals("de", new LanguageSelectionFromSystem().selectLanguage());
		Locale.setDefault(original);
	}

}
