package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        KeyValueStorage storage = new FileKV(filePath, Map.of("key", "value"));

        assertEquals("value", storage.get("key", "default"));

        storage.set("key2", "value2");
        assertEquals("value2", storage.get("key2", "default"));

        storage.unset("key2");
        assertEquals("default", storage.get("key2", "default"));

        Map<String, String> data = storage.toMap();
        assertEquals(data, Map.of("key", "value"));
    }
}

