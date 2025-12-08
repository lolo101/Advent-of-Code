package fr.lbroquet.adventofcode2024.day7;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern SEPARATOR = Pattern.compile(": ");

    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            long total = reader.lines().map(Main::toEquation).filter(Equation::possible).mapToLong(Equation::test).sum();
            IO.println("Total calibration result = " + total);
        }
    }

    private static Equation toEquation(String s) {
        String[] testAndOperands = SEPARATOR.split(s);
        String test = testAndOperands[0];
        String[] operands = testAndOperands[1].split(" ");
        return new Equation(Long.parseLong(test), Arrays.stream(operands).mapToLong(Long::parseLong).toArray());
    }
}
