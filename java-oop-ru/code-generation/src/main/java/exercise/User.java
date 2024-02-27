package exercise;

import lombok.Value;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
