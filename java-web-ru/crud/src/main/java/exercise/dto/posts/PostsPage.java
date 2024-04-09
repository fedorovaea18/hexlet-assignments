package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// BEGIN
public class PostsPage {
    List<Post> posts;
    int page;
}
// END
