package fr.lbroquet.adventofcode2024.day3;

import fr.lbroquet.Input;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    private static final Pattern MUL = Pattern.compile("mul\\((?<firstOperand>\\d{1,3}),(?<secondOperand>\\d{1,3})\\)");

    public static void main(String[] args) {
        long sum = Input.load(Main.class).lines().flatMap(Main::toExpression).mapToLong(Main::multiply).sum();
        System.out.println("sum of multiplications = " + sum);
    }

    private static Stream<MatchResult> toExpression(String memory) {
        return MUL.matcher(memory).results();
    }

    private static long multiply(MatchResult matchResult) {
        String firstOperand = matchResult.group("firstOperand");
        String secondOperand = matchResult.group("secondOperand");
        return Long.parseLong(firstOperand) * Long.parseLong(secondOperand);
    }
}
