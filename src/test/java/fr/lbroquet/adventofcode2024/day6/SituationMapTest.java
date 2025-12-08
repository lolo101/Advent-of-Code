package fr.lbroquet.adventofcode2024.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SituationMapTest {
    @Test
    void should_find_visited_positions() {
        String input = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        assertEquals(41, situationMap.visitedPositions());
    }

    @Test
    void should_find_all_possible_obstructions() {
        String input = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        IO.println(situationMap.print());
        assertEquals(6, situationMap.possibleObstructions());
    }

    @Test
    void should_find_single_obstructions() {
        String input = """
                .##..
                ....#
                ..^..
                #....
                .....
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        IO.println(situationMap.print());
        assertEquals(1, situationMap.possibleObstructions());
    }

    @Test
    void should_find_loop_outside_path() {
        String input = """
                ..#...
                ......
                .#^...
                #....#
                ....#.
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        IO.println(situationMap.print());
        assertEquals(1, situationMap.possibleObstructions());
    }

    @Test
    void should_meet_possible_obstructions_multiple_times() {
        String input = """
                .##.
                ....
                ..^.
                #...
                ..#.
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        IO.println(situationMap.print());
        assertEquals(1, situationMap.possibleObstructions());
    }

    @Test
    void should_not_be_possible_to_obstructions_an_already_visited_position() {
        String input = """
                #...
                ...#
                ...#
                ^...
                #...
                ..#.
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        IO.println(situationMap.print());
        assertEquals(1, situationMap.possibleObstructions());
    }

    @Test
    void should_bounce_on_possible_obstruction_under_multiple_directions() {
        String input = """
                ..#.#..
                ...#..#
                .#.....
                .^.....
                #..#...
                ..#.#..
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        SituationMap situationMap = new SituationMap(array);
        IO.println(situationMap.print());
        assertEquals(2, situationMap.possibleObstructions());
    }
}