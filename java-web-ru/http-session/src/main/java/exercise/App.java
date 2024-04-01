package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            int page = ctx.queryParamAsClass("page", Integer.class, 1);
            int perPage = ctx.queryParamAsClass("per", Integer.class, 5);

            int startIndex = (page - 1) * perPage;
            int endIndex = Math.min(startIndex + perPage, USERS.size());

            List<Map<String, String>> usersSubset = USERS.subList(startIndex, endIndex);

            ctx.json(usersSubset);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
