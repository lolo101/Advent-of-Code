package fr.lbroquet.adventofcode2024.day9;

import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;

public class Gap {

    private long block;
    private int length;

    public Gap(long block, int length) {
        this.block = block;
        this.length = length;
    }

    public int remainingSpace() {
        return length;
    }

    public long fill(int sizeInBlocks) {
        long checksum = addExact(multiplyExact(sizeInBlocks, block), multiplyExact(sizeInBlocks, sizeInBlocks - 1) / 2);
        block += sizeInBlocks;
        length -= sizeInBlocks;
        return checksum;
    }
}
