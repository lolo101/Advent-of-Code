package fr.lbroquet.adventofcode2024.day2;

import fr.lbroquet.Input;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        long safeReports = Input.load(Main.class)
                .lines()
                .map(report -> report.split(" "))
                .map(levels -> Stream.of(levels).map(Integer::parseInt).toList())
                .map(Main::toReport)
                .filter(Report::isSafe)
                .count();
        System.out.println("Safe reports: " + safeReports);
    }

    private static Report toReport(List<Integer> levels) {
        return new Report(levels);
    }
}
