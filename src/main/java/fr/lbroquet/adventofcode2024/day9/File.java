package fr.lbroquet.adventofcode2024.day9;

import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;

public record File(long block, int length) {
    public boolean fitIn(Gap gap) {
        return gap.remainingSpace() >= length;
    }

    public long ownRawChecksum() {
        return addExact(multiplyExact(length, block), multiplyExact(length, length - 1) / 2);
    }
}
