package fr.lbroquet.adventofcode2024.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AntennaMapTest {

    @Test
    void should_find_simple_antinodes() {
        String input = """
                .....
                .a...
                ..a..
                .....
                .....
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        AntennaMap antennaMap = new AntennaMap(array);
        assertEquals(2, antennaMap.countAntinodes());
    }

    @Test
    void should_find_more_antinodes() {
        String input = """
                .....
                .aa..
                ..a..
                .....
                .....
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        AntennaMap antennaMap = new AntennaMap(array);
        assertEquals(6, antennaMap.countAntinodes());
    }

    @Test
    void should_count_only_distinct_antinodes() {
        String input = """
                .....
                ..a..
                ..a..
                .....
                ..b..
                ..b..
                .....
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        AntennaMap antennaMap = new AntennaMap(array);
        assertEquals(3, antennaMap.countAntinodes());
    }

    @Test
    void should_count_only_distinct_and_within_bounds_antinodes() {
        String input = """
                ..a..
                ..a..
                .....
                ..b..
                ..b..
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        AntennaMap antennaMap = new AntennaMap(array);
        assertEquals(1, antennaMap.countAntinodes());
    }
}