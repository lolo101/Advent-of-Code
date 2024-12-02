package fr.lbroquet.adventofcode2023.day18;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern DIG_STEP = Pattern.compile("(?<direction>[URDL]) (?<length>\\d+) \\(#\\p{XDigit}{6}\\)");

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            List<DigStep> digSteps = input.lines().map(Main::toDigStep).toList();
            DigPlan digPlan = new DigPlan(digSteps);
            System.out.printf("Dig plan surface: %d%n", digPlan.surface());
        }
    }

    private static DigStep toDigStep(String line) {
        Matcher matcher = DIG_STEP.matcher(line);
        if (matcher.matches()) {
            Direction direction = Direction.from(matcher.group("direction"));
            int length = Integer.parseInt(matcher.group("length"));
            return new DigStep(direction, length);
        }
        throw new IllegalArgumentException(line);
    }
}
