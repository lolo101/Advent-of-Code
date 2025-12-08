package fr.lbroquet.adventofcode2025.day5;

import static java.lang.Math.max;
import static java.lang.Math.min;

public record Range(long start, long end) {
    public boolean contains(long ingredientId) {
        return start <= ingredientId && ingredientId <= end;
    }
    public long size() {
        return end - start + 1;
    }

    public boolean overlaps(Range other) {
        return start <= other.end && end >= other.start;
    }

    public Range merge(Range other) {
        return new Range(min(start, other.start), max(end, other.end));
    }
}
