# Multilingual Support System

## Overview
The **Multilingual Support System** is a Java-based solution for managing translations using `.properties` files.  
It provides an easy way to load, manage, and retrieve localized messages for applications, supporting both **generic messages** and **application-specific personalized messages**.  

The system supports multiple languages out of the box:
- German (`de`)
- English (`en`)
- French (`fr`)
- Spanish (`es`)
- Portuguese (`pt`)

Fallback to a **default language** (currently `es`) is automatically handled when a language file does not exist.

---

## Features
- Load translations from resource files automatically.
- Priority-based message resolution:
  1. **Personalized messages** (application-specific)
  2. **Generic messages** (system default)
- Support for fallback language if the requested language does not exist.
- Message retrieval through a dedicated provider class.
- Configurable language selection:
  - Based on the operating system locale.
  - Manual selection via a `JOptionPane` dialog.
  - Manual injection by the developer.
- Clear exception handling when files or messages cannot be found.
- Logging with **Log4j2** for debugging and monitoring.

---

## File Structure

Resources must follow this convention inside the project:

src/main/resources/
 └── messages/
     ├── generic/
     │   ├── messages_de.properties
     │   ├── messages_en.properties
     │   ├── messages_fr.properties
     │   ├── messages_es.properties
     │   └── messages_pt.properties
     └── personalized/
         ├── messages_de.properties
         ├── messages_en.properties
         ├── messages_fr.properties
         ├── messages_es.properties
         └── messages_pt.properties

---

### Rules
1. **File naming convention**:  
   messages_<languageCode>.properties  
   Example: messages_es.properties  

2. **Priority of resolution**:  
   - First, the system checks the `personalized` folder.  
   - If the key is not found, it checks the `generic` folder.  
   - If still not found, the system throws a `MessageNotFoundException`.  

3. **Encoding**:  
   All files must be saved in **UTF-8** to support accented characters.  

---

## Usage Example

1. Load Translations
TranslationLoader loader = new TranslationLoader("es");
loader.loadTranslations();

2. Retrieve Messages
MessageProvider provider = new MessageProvider(loader.getTranslations());
String msg = provider.findMessage("GENERAL_REFRESH");
System.out.println(msg); // "Actualizar"

3. Language Selection from OS
String lang = new LanguageSelectionFromSystem().selectLanguage();
System.out.println("System language: " + lang);

4. Language Selection via Dialog
String lang = new LanguageSelectionJOptionPane().selectLanguage();
System.out.println("Selected language: " + lang);

---

## Class Overview

- TranslationLoader  
  Loads `.properties` files into a HashMap<String, String>.  
  Handles fallback to default language if the selected language is missing.  

- MessageProvider  
  Retrieves messages from the loaded HashMap.  
  Throws MessageNotFoundException if a key is not found.  

- AvailableLanguages  
  Enum containing supported languages and their codes.  

- CheckLanguageExists  
  Validates whether a given language code exists in the system.  
  Returns the default language if not valid.  

- DefaultLanguage  
  Defines and returns the default system language (`es`).  

- LanguageSelectionFromSystem  
  Implements LanguageProvider.  
  Selects language based on the OS locale.  

- LanguageSelectionJOptionPane  
  Implements LanguageProvider.  
  Displays a JOptionPane dialog for the user to select a language.  

---

## Exceptions

### LanguageFileNotFoundException
**Thrown when:**  
- Both the requested language file and the default language file are missing.  

**Solution:**  
- Verify that the `.properties` file exists in the correct folder.  
- Check that file names follow the required format (messages_<code>.properties).  

### MessageNotFoundException
**Thrown when:**  
- A key does not exist in the loaded translation map.  

**Solution:**  
- Ensure the key is defined in the personalized or generic `.properties` file.  
- Check for typos in the key.  

---

## Adding New Languages
1. Add the new language to the `AvailableLanguages` enum.  
2. Create the corresponding files:  
   /messages/generic/messages_xx.properties  
   /messages/personalized/messages_xx.properties  
   Replace `xx` with the ISO language code (e.g., `it` for Italian).  
3. Fill in the key–value pairs in both files.  

---

## Tests
Unit tests are written with **JUnit 5**.  

Examples include:  
- MessageProviderTest → validates message retrieval and exception throwing.  
- TranslationLoaderTest → checks correct file loading and fallback to default.  
- CheckLanguageExistsTest → verifies language validation.  
- LanguageSelectionFromSystemTest → tests OS locale selection.  

Run tests with:  
mvn test  

---

## Logging
The system uses **Log4j2** for logging.  
You can configure logging via log4j2.xml or log4j2.properties.  

If no configuration file is present, the system will still run, but logging output will be limited.  

---

## License
This project is distributed under the MIT License.
