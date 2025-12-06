package fr.lbroquet.adventofcode2025.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @Test
    void range_is_inclusive() {
        Range range = new Range("11", "22");
        assertThat(range.invalidIds()).containsExactlyInAnyOrder(
                11L, 22L
        );
    }

    @Test
    void only_3_repeats() {
        Range range = new Range("100", "999");
        assertThat(range.invalidIds()).containsExactlyInAnyOrder(
                111L, 222L, 333L, 444L, 555L, 666L, 777L, 888L, 999L
        );
    }

    @Test
    void mix_of_repeats() {
        Range range = new Range("90", "2000");
        assertThat(range.invalidIds()).containsExactlyInAnyOrder(
                99L,
                111L, 222L, 333L, 444L, 555L, 666L, 777L, 888L, 999L,
                1010L, 1111L, 1212L, 1313L, 1414L, 1515L, 1616L, 1717L, 1818L, 1919L
        );
    }
}