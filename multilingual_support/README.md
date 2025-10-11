# Multilingual Support

## Overview
This system provides **multi-language support** for Java applications.  
All translations are stored in `.properties` files located in the project’s **resources** folder.  
Language configuration is defined in a small file called `multilanguage-config.properties`.

---

## Configuration file
Example:  
`src/main/resources/multilanguage-config.properties`

```properties
# Supported languages
languages_supported=es,en,fr,pt,de

# Default language
default_language=es

# Translation folders (order = priority)
folders=general,personalized
```

- `languages_supported` → list of available languages  
- `default_language` → default language used if the selected one is missing  
- `folders` → translation groups (e.g. general, personalized, cajas, etc.)

---

## How it works
1. **Configuration.java** loads `multilanguage-config.properties`.  
2. **TranslationLoader.java** reads the translation files defined in the configuration.  
3. **MessageProvider.java** retrieves the correct text by key.  
4. If a translation file or key is missing, a clear exception is thrown.

---

## File structure
```
src/main/resources/
 ├─ multilanguage-config.properties
 ├─ general/
 │   ├─ messages_es.properties
 │   ├─ messages_en.properties
 │   └─ ...
 └─ personalized/
     ├─ messages_es.properties
     ├─ messages_en.properties
     └─ ...
```

Each `messages_xx.properties` contains key–value pairs, for example:
```properties
APP_EXIT=Exit
APP_BACK=Back to main screen
```

---

## Basic usage
```java
Configuration config = new Configuration();
String language = new LanguageSelectionFromSystem().selectLanguage();
TranslationLoader loader = new TranslationLoader(language, config);
loader.loadTranslations();

MessageProvider provider = new MessageProvider(loader.getTranslations());
String text = provider.findMessage("APP_BACK");
System.out.println(text);
```

---

## Add a new language
1. Add the code to `languages_supported` in `multilanguage-config.properties`.  
2. Create new files:  
   ```
   general/messages_it.properties
   personalized/messages_it.properties
   ```
3. Copy all keys from `messages_es.properties` and translate the values.

---

## Notes
- Files must be **UTF-8 encoded**.  
- Basic HTML (like `<html><br>`) is supported for Swing components.  
- The system can detect the **system locale** automatically.