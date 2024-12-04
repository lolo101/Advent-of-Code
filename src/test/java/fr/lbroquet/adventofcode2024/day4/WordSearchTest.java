package fr.lbroquet.adventofcode2024.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchTest {
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
        assertEquals(18, new WordSearch(array).count());
    }

    @Test
    void should_search_forward() {
        String input = """
                XMAS
                ....
                ....
                ....
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_backward() {
        String input = """
                SAMX
                ....
                ....
                ....
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_downward() {
        String input = """
                X...
                M...
                A...
                S...
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_upward() {
        String input = """
                S...
                A...
                M...
                X...
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_NW_to_SE() {
        String input = """
                X...
                .M..
                ..A.
                ...S
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_SW_to_NE() {
        String input = """
                ...S
                ..A.
                .M..
                X...
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_SE_to_NW() {
        String input = """
                S...
                .A..
                ..M.
                ...X
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }

    @Test
    void should_search_NE_to_SW() {
        String input = """
                ...X
                ..M.
                .A..
                S...
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1, new WordSearch(array).count());
    }
}