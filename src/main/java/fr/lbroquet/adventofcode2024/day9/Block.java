package fr.lbroquet.adventofcode2024.day9;

import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;

public class Block {
    private long index;

    public long rawChecksumAndIncrement(long size) {
        long checksum = addExact(multiplyExact(size, index), multiplyExact(size, size - 1) / 2);
        index += size;
        return checksum;
    }
}
