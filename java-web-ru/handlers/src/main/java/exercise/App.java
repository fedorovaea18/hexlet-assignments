package exercise;

import io.javalin.Javalin;
import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
           config.bundledPlugins.enableDevLogging();
        });
        
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();
  
        app.get("GET /phones", ctx -> ctx.json(phones));
        app.get("GET /domains", ctx -> ctx.json(domains));
  
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

