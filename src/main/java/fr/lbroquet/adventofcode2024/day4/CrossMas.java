package fr.lbroquet.adventofcode2024.day4;

public record CrossMas(char[][] array) {
    public long count() {
        char[][] window = new char[3][3];
        long count = 0;
        for (int row = 0; row < array.length - 2; row++) {
            for (int column = 0; column < array[row].length - 2; column++) {
                copy(window, row, column);
                if (containsCrossMas(window)) count++;
            }
        }
        return count;
    }

    private void copy(char[][] window, int rowOffset, int columnOffset) {
        for (int row = 0; row < 3; row++) {
            System.arraycopy(array[rowOffset + row], columnOffset, window[row], 0, 3);
        }
    }

    private static boolean containsCrossMas(char[][] window) {
        return (window[1][1] == 'A')
                && containsMasNWtoSE(window)
                && containsMasNEtoSW(window);
    }

    private static boolean containsMasNWtoSE(char[][] window) {
        return window[0][0] == 'M' && window[2][2] == 'S' || window[0][0] == 'S' && window[2][2] == 'M';
    }

    private static boolean containsMasNEtoSW(char[][] window) {
        return window[0][2] == 'M' && window[2][0] == 'S' || window[0][2] == 'S' && window[2][0] == 'M';
    }
}
