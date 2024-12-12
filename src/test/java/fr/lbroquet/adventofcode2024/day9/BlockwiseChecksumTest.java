package fr.lbroquet.adventofcode2024.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockwiseChecksumTest {
    @Test
    void should_return_zero_when_there_is_only_one_file() {
        assertEquals(0, new BlockwiseChecksum("9").defragmentedValue());
    }

    @Test
    void should_return_zero_when_there_is_only_one_file_and_free_space() {
        assertEquals(0, new BlockwiseChecksum("99").defragmentedValue());
    }

    @Test
    void should_return_second_fileId_times_its_defragmented_position() {
        assertEquals(9, new BlockwiseChecksum("991").defragmentedValue());
    }

    @Test
    void files_fit_in_gaps() {
        // 0.1.2
        // 021.. => 0x0+1x2+2x1=4
        assertEquals(4, new BlockwiseChecksum("11111").defragmentedValue());
    }

    @Test
    void files_must_be_split() {
        // 0.1.22
        // 0212.. => 0x0 + 1x2 + 2x1 + 3x2 = 10
        assertEquals(10, new BlockwiseChecksum("11112").defragmentedValue());
    }

    @Test
    void files_must_be_split_with_zero_space_somewhere() {
        // 0.122
        // 0212. => 0x0 + 1x2 + 2x1 + 3x2 = 10
        assertEquals(10, new BlockwiseChecksum("11102").defragmentedValue());
    }

    @Test
    void files_must_share_same_space() {
        // 0..123
        // 0321.. => 0x0 + 1x3 + 2x2 + 3x1 = 10
        assertEquals(10, new BlockwiseChecksum("1210101").defragmentedValue());
    }
}