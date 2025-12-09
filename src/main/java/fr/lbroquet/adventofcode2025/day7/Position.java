package fr.lbroquet.adventofcode2025.day7;

import java.util.Comparator;

public record Position(int row, int column) implements Comparable<Position> {
    public Position left() {
        return new Position(row, column - 1);
    }

    public Position right() {
        return new Position(row, column + 1);
    }

    @Override
    public int compareTo(Position o) {
        return Comparator
                .comparingInt(Position::row)
                .thenComparingInt(Position::column)
                .compare(this, o);
    }
}
