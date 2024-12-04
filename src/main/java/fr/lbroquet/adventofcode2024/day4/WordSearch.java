package fr.lbroquet.adventofcode2024.day4;

import java.util.regex.Pattern;

import static java.lang.Math.max;
import static java.lang.Math.min;

public record WordSearch(char[][] array) {
    private static final Pattern WORD = Pattern.compile("XMAS");

    public long count() {
        return
                rowsBothDirections(array) +
                        rowsBothDirections(rotate()) +
                        rowsBothDirections(semiRotate(array)) +
                        rowsBothDirections(semiRotate(symetric()));
    }

    private char[][] rotate() {
        char[][] rotated = new char[array.length][array.length];
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array.length; column++) {
                rotated[column][row] = array[row][column];
            }
        }
        return rotated;
    }

    private char[][] symetric() {
        char[][] symetric = new char[array.length][array.length];
        for (int row = 0; row < array.length; row++) {
            symetric[row] = array[array.length - row - 1];
        }
        return symetric;
    }

    /*
    diagonals are numbered from up to bottom
    +---+---+---+
    | 2 | 1 | 0 |
    +---+---+---+
    | 3 | 2 | 1 |
    +---+---+---+
    | 4 | 3 | 2 |
    +---+---+---+
     */
    private static char[][] semiRotate(char[][] array) {
        char[][] semiRotated = new char[array.length * 2 - 1][];
        for (int diagonal = 0; diagonal < semiRotated.length; diagonal++) {
            int diagonalLength = min(diagonal + 1, 2 * array.length - diagonal - 1);
            semiRotated[diagonal] = new char[diagonalLength];
            for (int x = 0; x < diagonalLength; x++) {
                int rowOffset = max(0, diagonal - array.length + 1);
                int columnOffset = max(0, array.length - 1 - diagonal);
                semiRotated[diagonal][x] = array[rowOffset + x][columnOffset + x];
            }
        }
        return semiRotated;
    }

    private static long rowsBothDirections(char[][] array) {
        long count = 0;
        for (char[] arrayRow : array) {
            // row left -> right
            count += search(arrayRow);
            // row right -> left
            count += search(reverse(arrayRow));
        }
        return count;
    }

    private static char[] reverse(char[] array) {
        char[] reversed = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    private static long search(char[] arrayRow) {
        String row = new String(arrayRow);
        return WORD.matcher(row).results().count();
    }
}
