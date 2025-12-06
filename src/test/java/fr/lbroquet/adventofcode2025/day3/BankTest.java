package fr.lbroquet.adventofcode2025.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {
    @ParameterizedTest
    @CsvSource({
            "987654321111111, 987654321111",
            "811111111111119, 811111111119",
            "234234234234278, 434234234278",
            "818181911112111, 888911112111"
    })
    void test(String batteries, long expected) {
        Bank bank = new Bank(batteries);
        assertEquals(expected, bank.outputJoltage(12));
    }
}