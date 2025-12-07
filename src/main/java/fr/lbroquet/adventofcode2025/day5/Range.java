package fr.lbroquet.adventofcode2025.day5;

public record Range(long start, long end) {
    public boolean contains(long ingredientId) {
        return start <= ingredientId && ingredientId <= end;
    }
}
