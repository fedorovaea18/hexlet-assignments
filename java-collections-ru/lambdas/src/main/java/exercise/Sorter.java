package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        List<Map<String, String>> maleUsers = users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted((user1, user2) -> LocalDate.parse(user1.get("birthday")).compareTo(LocalDate.parse(user2.get("birthday"))))
                .toList();

        return maleUsers.stream()
                .map(user -> user.get("name"))
                .toList();
    }
}

// END
