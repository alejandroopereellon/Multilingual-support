package multilingual_support;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import multilingual_support.getMessages.MessageProvider;

class MessageProviderTest {

    @Test
    void testMessageFound() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello world");

        MessageProvider provider = new MessageProvider(map);

        String result = provider.findMessage("Test");
        assertEquals("hello world", result);
    }
    
    @Test
    void testMessageTemplateFound() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello {0} world");

        MessageProvider provider = new MessageProvider(map);

        String result = provider.findMessage("Test", "beautiful");
        assertEquals("hello beautiful world", result);
    }

    @Test
    void testMessageNotFound() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello world");

        MessageProvider provider = new MessageProvider(map);

        assertTrue(provider.findMessage("TestNotExists").startsWith("[Missing message: "));
    }

    @Test
    void testMessageEmpty() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello world");

        MessageProvider provider = new MessageProvider(map);

        assertTrue(provider.findMessage("").startsWith("[Missing message: "));
    }
}
