package exercise;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
}

