package fr.lbroquet.adventofcode2024.day11;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void example() {
        Collection<String> stones = List.of("125", "17");
        for (int i = 0; i < 6; i++) {
            stones = Main.blink(stones);
        }
        assertEquals(22, stones.size());
    }
}
