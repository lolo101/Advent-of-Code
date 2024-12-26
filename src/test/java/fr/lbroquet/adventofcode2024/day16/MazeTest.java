package fr.lbroquet.adventofcode2024.day16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {
    @Test
    void straight_line() {
        String input = """
                ###############
                #S...........E#
                ###############
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(array);
        assertEquals(12, maze.lowestScore());
    }

    @Test
    void loop() {
        String input = """
                ###############
                #...........E.#
                #.###########.#
                #S............#
                ###############
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(array);
        assertEquals(2013, maze.lowestScore());
    }

    @Test
    void example1() {
        String input = """
                ###############
                #.......#....E#
                #.#.###.#.###.#
                #.....#.#...#.#
                #.###.#####.#.#
                #.#.#.......#.#
                #.#.#####.###.#
                #...........#.#
                ###.#.#####.#.#
                #...#.....#.#.#
                #.#.#.###.#.#.#
                #.....#...#.#.#
                #.###.#.#.#.#.#
                #S..#.....#...#
                ###############
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(array);
        assertEquals(7036, maze.lowestScore());
    }

    @Test
    void example2() {
        String input = """
                #################
                #...#...#...#..E#
                #.#.#.#.#.#.#.#.#
                #.#.#.#...#...#.#
                #.#.#.#.###.#.#.#
                #...#.#.#.....#.#
                #.#.#.#.#.#####.#
                #.#...#.#.#.....#
                #.#.#####.#.###.#
                #.#.#.......#...#
                #.#.###.#####.###
                #.#.#...#.....#.#
                #.#.#.#####.###.#
                #.#.#.........#.#
                #.#.#.#########.#
                #S#.............#
                #################
                """;
        char[][] array = input.lines().map(String::toCharArray).toArray(char[][]::new);
        Maze maze = new Maze(array);
        assertEquals(11048, maze.lowestScore());

    }
}