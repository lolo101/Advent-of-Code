package fr.lbroquet.adventofcode2024.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReportTest {
    @Test
    void long_plateau_in_the_middle_of_safely_incresing_is_unsafe() {
        assertFalse(new Report(List.of(1, 2, 3, 3, 3, 4)).isSafe());
    }

    @Test
    void one_plateau_in_the_middle_of_safely_incresing_is_safe() {
        assertTrue(new Report(List.of(1, 2, 3, 3, 4)).isSafe());
    }

    @Test
    void first_plateau_is_safe() {
        assertTrue(new Report(List.of(1, 1, 2, 3, 4)).isSafe());
    }

    @Test
    void last_plateau_is_safe() {
        assertTrue(new Report(List.of(1, 2, 3, 4, 4)).isSafe());
    }

    @Test
    void one_invalid_high_point_in_the_middle_of_safely_incresing_is_safe() {
        assertTrue(new Report(List.of(1, 2, 7, 3, 4)).isSafe());
    }

    @Test
    void one_invalid_high_point_in_the_middle_of_safely_decresing_is_safe() {
        assertTrue(new Report(List.of(4, 3, 7, 2, 1)).isSafe());
    }

    @Test
    void one_invalid_low_point_in_the_middle_of_safely_incresing_is_safe() {
        assertTrue(new Report(List.of(1, 2, 0, 3, 4)).isSafe());
    }

    @Test
    void one_invalid_low_point_in_the_middle_of_safely_decresing_is_safe() {
        assertTrue(new Report(List.of(4, 3, 0, 2, 1)).isSafe());
    }

    @Test
    void a_cliff_is_unsafe() {
        assertFalse(new Report(List.of(1, 2, 7, 8, 9)).isSafe());
    }

    @Test
    void first_invalid_high_point_is_safe() {
        assertTrue(new Report(List.of(7, 2, 3, 4)).isSafe());
    }

    @Test
    void last_invalid_high_point_is_safe() {
        assertTrue(new Report(List.of(1, 2, 3, 7)).isSafe());
    }

    @Test
    void last_invalid_low_point_is_safe() {
        assertTrue(new Report(List.of(1, 2, 3, -2)).isSafe());
    }

    @Test
    void first_cliff_is_safe() {
        assertTrue(new Report(List.of(1, 5, 6, 7)).isSafe());
    }

    @Test
    void last_cliff_is_safe() {
        assertTrue(new Report(List.of(1, 2, 3, 7)).isSafe());
    }

    @Test
    void second_invalid_low_point_is_safe() {
        assertTrue(new Report(List.of(1, 0, 3, 4)).isSafe());
    }

    @Test
    void two_distinct_increasing_is_unsafe() {
        assertFalse(new Report(List.of(3, 4, 1, 2)).isSafe());
    }
}