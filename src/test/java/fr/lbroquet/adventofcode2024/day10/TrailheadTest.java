package fr.lbroquet.adventofcode2024.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrailheadTest {
    @Test
    void larger_score_example() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732
                """;
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(36, new TopographicMap(map).trailheadsScoreSum());
    }

    @Test
    void larger_rating_example() {
        String input = """
                89010123
                78121874
                87430965
                96549874
                45678903
                32019012
                01329801
                10456732
                """;
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(81, new TopographicMap(map).trailheadsRatingSum());
    }
}