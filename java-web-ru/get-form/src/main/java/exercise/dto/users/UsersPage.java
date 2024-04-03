package exercise.dto.users;

import exercise.model.User;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@AllArgsConstructor
public class UsersPage {
    private List<User> users;
    private String term;

}

