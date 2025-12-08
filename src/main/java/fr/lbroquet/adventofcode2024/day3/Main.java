package fr.lbroquet.adventofcode2024.day3;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    private static final Pattern MUL = Pattern.compile("mul\\((?<firstOperand>\\d{1,3}),(?<secondOperand>\\d{1,3})\\)|(?<do>do\\(\\))|(?<dont>don't\\(\\))");
    private static boolean enabled = true;

    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            long sum = reader.lines().flatMap(Main::toExpression).mapToLong(Main::multiply).sum();
            IO.println("sum of multiplications = " + sum);
        }
    }

    private static Stream<MatchResult> toExpression(String memory) {
        return MUL.matcher(memory).results();
    }

    private static long multiply(MatchResult matchResult) {
        String enable = matchResult.group("do");
        String disable = matchResult.group("dont");
        if (enable != null) {
            enabled = true;
            return 0;
        }
        if (disable != null) {
            enabled = false;
            return 0;
        }
        if (enabled) {
            String firstOperand = matchResult.group("firstOperand");
            String secondOperand = matchResult.group("secondOperand");
            return Long.parseLong(firstOperand) * Long.parseLong(secondOperand);
        }
        return 0;
    }
}
