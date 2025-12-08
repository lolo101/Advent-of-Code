package fr.lbroquet.adventofcode2025.day6;

import fr.lbroquet.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    static void main() throws IOException {
        char[][] mathSheet = transpose(Input.loadMap(Main.class));

        Collection<Operation> operations = new ArrayList<>();
        Collection<Long> operands = new ArrayList<>();
        char operator = '\0';
        for (char[] lineChars : mathSheet) {
            char maybeOperator = lineChars[lineChars.length - 1];
            if (maybeOperator == '+' || maybeOperator == '*') {
                operator = maybeOperator;
            }
            String lineString = new String(lineChars, 0, lineChars.length - 1).trim();
            if(lineString.isBlank()) {
                operations.add(new Operation(operator, operands.toArray(new Long[0])));
                operands.clear();
            } else {
                operands.add(Long.parseLong(lineString));
            }
        }
        // add last pending operation
        operations.add(new Operation(operator, operands.toArray(new Long[0])));

        long total = operations.stream().reduce(0L, (sum, op) -> sum + op.compute(), Long::sum);
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
}
