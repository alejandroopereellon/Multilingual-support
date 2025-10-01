package multilingual_support;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import multilingual_support.exceptions.MessageNotFoundException;
import multilingual_support.getMessages.MessageProvider;

class MessageProviderTest {

    @Test
    void testMessageFound() throws MessageNotFoundException {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello world");

        MessageProvider provider = new MessageProvider(map);

        String result = provider.findMessage("Test");
        assertEquals("hello world", result);
    }

    @Test
    void testMessageNotFound() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello world");

        MessageProvider provider = new MessageProvider(map);

        assertThrows(MessageNotFoundException.class,
                () -> provider.findMessage("NotFound"));
    }

    @Test
    void testMessageEmpty() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Test", "hello world");

        MessageProvider provider = new MessageProvider(map);

        assertThrows(MessageNotFoundException.class,
                () -> provider.findMessage(""));
    }
}
