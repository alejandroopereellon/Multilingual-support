# Multilingual Support

This project is for manage messages and translations in different languages.  
It use files with key-value text for load messages in runtime.

## Features
- Support for multiple languages (Spanish, English, German, French, Portuguese).
- Read messages from properties files.
- Get translation with a simple key.
- Show error if message not found.

## Example
MessageProvider provider = new MessageProvider("messages");
System.out.println(provider.getMessage("hello.world", "en"));
// Output: "Hello World"


Technologies
Java 17
JUnit 5
Maven

License
This project is under MIT License.
