package fr.lbroquet.adventofcode2025.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreshIngredientRangesTest {
    @Test
    void part_one_example() {
        FreshIngredientRanges ranges = new FreshIngredientRanges();

        ranges.addRange(3,5);
        ranges.addRange(10,14);
        ranges.addRange(16,20);
        ranges.addRange(12,18);

        assertFalse(ranges.contains(1));
        assertTrue(ranges.contains(5));
        assertFalse(ranges.contains(8));
        assertTrue(ranges.contains(11));
        assertTrue(ranges.contains(17));
        assertFalse(ranges.contains(32));
    }

    @Test
    void should_merge_ranges() {
        FreshIngredientRanges ranges = new FreshIngredientRanges();

        ranges.addRange(10,14);
        ranges.addRange(16,20);
        ranges.addRange(12,18);

        // merge to 10-20
        assertEquals(11, ranges.size());
    }
}