package fr.lbroquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input {
    public static char[][] loadMap(Class<?> mainClass) throws IOException {
        try (BufferedReader reader = Input.load(mainClass)) {
            return reader.lines().map(String::toCharArray).toArray(char[][]::new);
        }
    }
    public static BufferedReader load(Class<?> mainClass) {
        InputStream inputStream = mainClass.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
