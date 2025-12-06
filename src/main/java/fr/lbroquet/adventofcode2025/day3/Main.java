package fr.lbroquet.adventofcode2025.day3;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            long totalOutputJoltage = reader.lines()
                    .map(Main::toBank)
                    .mapToLong(bank -> bank.outputJoltage(12))
                    .sum();
            System.out.println("Total output joltage: " + totalOutputJoltage);
        }
    }

    private static Bank toBank(String line) {
        return new Bank(line);
    }
}
