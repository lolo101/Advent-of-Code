package fr.lbroquet.adventofcode2024.day2;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            long safeReports = reader
                    .lines()
                    .map(report -> report.split(" "))
                    .map(levels -> Stream.of(levels).map(Integer::parseInt).toList())
                    .map(Main::toReport)
                    .filter(Report::isSafe)
                    .count();
            IO.println("Safe reports: " + safeReports);
        }
    }

    private static Report toReport(List<Integer> levels) {
        return new Report(levels);
    }
}
