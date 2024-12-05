package fr.lbroquet.adventofcode2024.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrossMasTest {
    @Test
    void should_find_all_occurences() {
        String input = """
                MMMSXXMASM
                MSAMXMSMSA
                AMXSXMAAMM
                MSAMASMSMX
                XMASAMXAMM
                XXAMMXXAMA
                SMSMSASXSS
                SAXAMASAAA
                MAMMMXMMMM
                MXMXAXMASX
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(9, new CrossMas(array).count());
    }
}