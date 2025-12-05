package fr.lbroquet.adventofcode2025.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @Test
    void range_is_inclusive() {
        Range range = new Range("11", "22");
        assertThat(range.invalidIds()).containsExactly(
                11L, 22L
        );
    }

    @Test
    void odd_number_of_digits_is_valid() {
        Range range = new Range("100", "999");
        assertThat(range.invalidIds()).isEmpty();
    }
}