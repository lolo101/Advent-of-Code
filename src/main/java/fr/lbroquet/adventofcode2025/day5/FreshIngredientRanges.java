package fr.lbroquet.adventofcode2025.day5;

import java.util.ArrayList;
import java.util.Collection;

class FreshIngredientRanges {
    private final Collection<Range> ranges = new ArrayList<>();

    public void addRange(long start, long end) {
        ranges.add(new Range(start, end));
    }

    public boolean contains(long ingredientId) {
        return ranges.stream().anyMatch(range -> range.contains(ingredientId));
    }
}
