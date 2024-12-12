package fr.lbroquet.adventofcode2024.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WholeFileChecksumTest {
    @Test
    void should_return_zero_when_there_is_only_one_file() {
        assertEquals(0, new WholeFileChecksum("9").defragmentedValue());
    }

    @Test
    void should_return_zero_when_there_is_only_one_file_and_free_space() {
        assertEquals(0, new WholeFileChecksum("99").defragmentedValue());
    }

    @Test
    void should_return_second_fileId_times_its_defragmented_position() {
        assertEquals(9, new WholeFileChecksum("991").defragmentedValue());
    }

    @Test
    void files_fit_in_gaps() {
        // 0.1.2
        // 021.. => 0x0+1x2+2x1=4
        assertEquals(4, new WholeFileChecksum("11111").defragmentedValue());
    }

    @Test
    void files_must_move_only_when_it_fits() {
        // 0.1.22
        // 01..22.. => 0x0 + 1x1 + 4x2 + 5x2 = 19
        assertEquals(19, new WholeFileChecksum("11112").defragmentedValue());
    }

    @Test
    void files_must_share_same_space() {
        // 0..123
        // 0321.. => 0x0 + 1x3 + 2x2 + 3x1 = 10
        assertEquals(10, new WholeFileChecksum("1210101").defragmentedValue());
    }
}