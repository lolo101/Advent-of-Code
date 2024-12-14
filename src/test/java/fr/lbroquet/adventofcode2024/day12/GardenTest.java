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

    @Test
    void sides_tiny_region() {
        String input = "X";
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(4, new Garden(map).discountedPriceOfFencing());
    }

    @Test
    void sides_single_region() {
        String input = """
                XX
                XX
                """;
        // L : 4 * 4 = 16
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(16, new Garden(map).discountedPriceOfFencing());
    }

    @Test
    void sides_L_region() {
        String input = """
                XXL
                XXL
                LLL
                """;
        // L : 5 * 6 = 30
        // X : 4 * 4 = 16
        // total     = 46
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(46, new Garden(map).discountedPriceOfFencing());
    }

    @Test
    void sides_T_region() {
        String input = """
                TTT
                XTX
                XTX
                """;
        // T : 5x8       = 40
        // X : 2x4 + 2x4 = 16
        // total         = 56
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(56, new Garden(map).discountedPriceOfFencing());
    }

    @Test
    void sides_plus_region() {
        String input = """
                X+X
                +++
                X+X
                """;
        // T : 5x12  = 60
        // X : 4x1x4 = 16
        // total     = 76
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(76, new Garden(map).discountedPriceOfFencing());
    }

    @Test
    void sides_example() {
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
        assertEquals(1206, new Garden(map).discountedPriceOfFencing());
    }

    @Test
    void sides_with_hole() {
        String input = """
                XXX
                XHX
                XXX
                """;
        // X : 8x8 = 64
        // H : 1x4 =  4
        // total   = 68
        char[][] map = input.lines().map(String::toCharArray).toArray(char[][]::new);
        assertEquals(68, new Garden(map).discountedPriceOfFencing());
    }
}
