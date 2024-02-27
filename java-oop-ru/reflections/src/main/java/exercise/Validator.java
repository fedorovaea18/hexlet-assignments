package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.junit.Test;

public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();
        
        Field[] fields = Address.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    notValidFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
        return notValidFields;
    }
    
    @Test
    public void testAdvancedValidate() {
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("country", Collections.singletonList("length less than 4"));
        expected.put("street", Collections.singletonList("can not be null"));

        assertEquals(expected, notValidFields);
    }
}

