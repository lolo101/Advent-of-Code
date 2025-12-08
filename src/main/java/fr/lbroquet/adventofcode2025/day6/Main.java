package fr.lbroquet.adventofcode2025.day6;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            List<String[]> lines = new ArrayList<>();
            for (
                    String line;
                    (line = reader.readLine()) != null;
                ) {
                lines.add(line.trim().split("\\s+"));
            }

            String[] operators = lines.removeLast();
            long[][] operands = transpose(lines.toArray(new String[0][0]));

            Collection<Operation> operations = new ArrayList<>();
            for (int i = 0; i < operators.length; i++) {
                operations.add(new Operation(
                        operators[i].charAt(0),
                        operands[i]
                ));
            }
            long total = operations.stream().reduce(0L, (sum, op) -> sum + op.compute(), Long::sum);
            IO.println("Grand total=" + total);
        }
    }

    private static long[][] transpose(String[][] array) {
        long[][] result = new long[array[0].length][];
        for (int column = 0; column < result.length; column++) {
            result[column] = new long[array.length];
        }

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                result[column][row] = Long.parseLong(array[row][column]);
            }
        }
        return result;
    }
}
