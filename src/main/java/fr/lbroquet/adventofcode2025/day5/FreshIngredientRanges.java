package fr.lbroquet.adventofcode2025.day5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class FreshIngredientRanges {
    private final Collection<Range> ranges = new ArrayList<>();

    public void addRange(long start, long end) {
        Range range = new Range(start, end);
        for (Iterator<Range> iterator = ranges.iterator(); iterator.hasNext(); ) {
            Range other = iterator.next();
            if (range.overlaps(other)) {
                range = range.merge(other);
                iterator.remove();
            }
        }
        ranges.add(range);
    }

    public boolean contains(long ingredientId) {
        return ranges.stream().anyMatch(range -> range.contains(ingredientId));
    }

    public long size() {
        return ranges.stream().mapToLong(Range::size).sum();
    }
}
