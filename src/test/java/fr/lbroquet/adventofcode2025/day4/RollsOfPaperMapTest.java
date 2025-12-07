package fr.lbroquet.adventofcode2025.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollsOfPaperMapTest {
    @Test
    void count_accessible_rolls_of_paper() {
        String input = """
                ..@@.@@@@.
                @@@.@.@.@@
                @@@@@.@.@@
                @.@@@@..@.
                @@.@@@@.@@
                .@@@@@@@.@
                .@.@.@.@@@
                @.@@@.@@@@
                .@@@@@@@@.
                @.@.@@@.@.
                """;
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        RollsOfPaperMap rollsOfPaperMap = new RollsOfPaperMap(map);
        assertEquals(13L, rollsOfPaperMap.countAccessibleRollsOfPaper());
    }
}