# Multilingual Support

This project is for manage messages and translations in different languages.  
It use files with key-value text for load messages in runtime.

## Features
- Support for multiple languages.
- Read messages from properties files.
- Get translation with a simple key.
- Show error if message not found.

## Example
		String language = new LanguageSelectionJOptionPane().selectLanguage();
		TranslationLoader loader = new TranslationLoader(language);
		loader.loadTranslations();

		MessageProvider provider = new MessageProvider(loader.getTranslations());
		String text = provider.findMessage("APP_BACK");
		System.out.println(text);

## Technologies
Java 17
JUnit 5
Maven

## License
This project is under MIT License.
