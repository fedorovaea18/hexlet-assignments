package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;
    
 public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

public static Car unserialize(String json) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(json, Car.class);
}
}

