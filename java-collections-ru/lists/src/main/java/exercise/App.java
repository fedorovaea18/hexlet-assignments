package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        letters = letters.toLowerCase();
        word = word.toLowerCase();

        char[] letterArray = letters.toCharArray();

        if (letters.length() < word.length()) {
            return false;
        }

        char[] wordArray = word.toCharArray();

        for (char c : wordArray) {
            if (letters.indexOf(c) == -1) {
                return false;
            }

            letters = letters.replaceFirst(String.valueOf(c), "");
        }

        return true;
    }
}
//END

