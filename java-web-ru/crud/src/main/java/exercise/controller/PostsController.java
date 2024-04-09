package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    private static final int POSTS_PER_PAGE = 5;
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var startIndex = (page - 1) * POSTS_PER_PAGE;

        var listOfPosts = posts.stream()
                    .skip(startIndex)
                    .limit(POSTS_PER_PAGE)
                    .collect(Collectors.toList());

        var postsPerPage = new PostsPage(listOfPosts, page);

        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPerPage));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(()-> new NotFoundResponse("Post not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
