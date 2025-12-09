package fr.lbroquet.adventofcode2025.day7;

public record Position(int row, int column) {
    public Position left() {
        return new Position(row, column - 1);
    }

    public Position right() {
        return new Position(row, column + 1);
    }
}
