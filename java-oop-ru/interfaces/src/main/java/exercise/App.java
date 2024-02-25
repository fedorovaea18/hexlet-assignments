package exercise;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, Integer n) {
        List<String> sortedApartments = homes.stream()
                .sorted((h1, h2) -> Double.compare(h1.getArea(), h2.getArea()))
                .limit(n)
                .map(Home::toString)
                .collect(Collectors.toList());

        return sortedApartments;
    }
}

