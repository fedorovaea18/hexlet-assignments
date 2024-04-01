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
    	    var page = ctx.queryParamAsClass("page", Integer.class, 1);
            var perPage = ctx.queryParamAsClass("per", Integer.class, 5);

            var startIndex = (page - 1) * perPage;
            var endIndex = Math.min(startIndex + perPage, USERS.size());

                List<Map<String, String>> usersSubset = USERS.subList(startIndex, endIndex);

    ctx.json(usersSubset);
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
