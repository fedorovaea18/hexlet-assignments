package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String configFile) {
        return Arrays.stream(configFile.split("\n"))
                .filter(line -> line.contains("environment="))
                .flatMap(line -> {
                    String[] variables = line.split("\"")[1].split(",");
                    return Arrays.stream(variables)
                            .filter(variable -> variable.startsWith("X_FORWARDED_"))
                            .map(variable -> variable.replace("X_FORWARDED_", ""))
                            .map(variable -> variable.split("=")[0] + "=" + variable.split("=")[1]);
                })
                .collect(Collectors.joining(","));
    }
}
//END
