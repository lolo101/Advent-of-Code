package fr.lbroquet.adventofcode2018.day2;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main() throws IOException {
        long twoRepeatedLetters, threeRepeatedLetters;

        try (BufferedReader reader = Input.load(Main.class)) {
            twoRepeatedLetters = reader.lines()
                    .filter(line -> hasRepeatedLetters(line, 2))
                    .count();
        }
        try (BufferedReader reader = Input.load(Main.class)) {
            threeRepeatedLetters = reader.lines()
                    .filter(line -> hasRepeatedLetters(line, 3))
                    .count();
        }
        IO.println("Checksum: " + Math.multiplyExact(twoRepeatedLetters, threeRepeatedLetters));
    }

    private static boolean hasRepeatedLetters(String line, long repetition) {
        Map<Integer, Long> frequencies = line.chars().boxed().collect(groupingBy(identity(), counting()));
        return frequencies.values().stream().anyMatch(f -> f == repetition);
    }
}
