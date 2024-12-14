package fr.lbroquet.adventofcode2024.day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GardenTest {
    @Test
    void single_region() {
        String input = """
                XX
                XX
                """;
        // L : 4 * 8 = 32
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(32, new Garden(map).priceOfFencing());
    }

    @Test
    void L_region() {
        String input = """
                XXL
                XXL
                LLL
                """;
        // L : 5 * 12 = 60
        // X : 4 * 8  = 32
        // total      = 92
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(92, new Garden(map).priceOfFencing());
    }

    @Test
    void u_region() {
        String input = """
                UXU
                UXU
                UUU
                """;
        // U : 7 * 16 = 112
        // X : 2 * 6  =  12
        // total      = 124
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(124, new Garden(map).priceOfFencing());
    }

    @Test
    void example() {
        String input = """
                RRRRIICCFF
                RRRRIICCCF
                VVRRRCCFFF
                VVRCCCJFFF
                VVVVCJJCFE
                VVIVCCJJEE
                VVIIICJJEE
                MIIIIIJJEE
                MIIISIJEEE
                MMMISSJEEE
                """;
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(1930, new Garden(map).priceOfFencing());
    }
}