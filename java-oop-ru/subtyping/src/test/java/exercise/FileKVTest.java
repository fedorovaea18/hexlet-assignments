package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }
    
    @Test
    public void testFileKV() {
        String filePath = "src/test/resources/file";
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key", "value");

        KeyValueStorage storage = new FileKV(filePath, initialData);

        assertEquals("value", storage.get("key", "default"));

        storage.set("key2", "value2");
        assertEquals("value2", storage.get("key2", "default"));

        storage.unset("key2");
        assertEquals("default", storage.get("key2", "default"));

        Map<String, String> data = storage.toMap();
        assertEquals(data, Map.of("key", "value"));
    }
}

