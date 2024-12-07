package fr.lbroquet.adventofcode2024.day6;

import java.util.Comparator;

public record Position(int row, int column) implements Comparable<Position> {

    private static final Comparator<Position> COMPARATOR = Comparator.comparing(Position::row).thenComparing(Position::column);

    @Override
    public int compareTo(Position o) {
        return COMPARATOR.compare(this, o);
    }
}
