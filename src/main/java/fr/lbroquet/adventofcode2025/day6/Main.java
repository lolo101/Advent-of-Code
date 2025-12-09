package fr.lbroquet.adventofcode2025.day6;

import fr.lbroquet.Input;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Gatherer;

public class Main {
    static void main() throws IOException {
        char[][] mathSheet = transpose(Input.loadMap(Main.class));

        long total = Arrays.stream(mathSheet)
                .<Operation>gather(Gatherer.ofSequential(
                        Memo::new,
                        (memo, lineChars, downstream) -> {
                            integrateOperator(memo, lineChars);
                            return integrateOperand(memo, lineChars, downstream);
                        },
                        (memo, downstream) -> downstream.push(new Operation(memo))
                ))
                .reduce(0L, (sum, op) -> sum + op.compute(), Long::sum);

        IO.println("Grand total=" + total);
    }

    private static char[][] transpose(char[][] array) {
        char[][] result = new char[array[0].length][];
        for (int column = 0; column < result.length; column++) {
            result[column] = new char[array.length];
        }

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                char c = array[row][column];
                result[column][row] = c == '_' ? ' ' : c;
            }
        }
        return result;
    }

    private static void integrateOperator(Memo memo, char[] lineChars) {
        char maybeOperator = lineChars[lineChars.length - 1];
        if (maybeOperator == '+' || maybeOperator == '*') {
            memo.operator = maybeOperator;
        }
    }

    private static boolean integrateOperand(Memo memo, char[] lineChars, Gatherer.Downstream<? super Operation> downstream) {
        String lineString = new String(lineChars, 0, lineChars.length - 1).trim();
        if (lineString.isBlank()) {
            return downstream.push(new Operation(memo));
        } else {
            memo.addOperand(lineString);
            return true;
        }
    }
}
