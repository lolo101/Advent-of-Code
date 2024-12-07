package fr.lbroquet.adventofcode2024.day6;

public record Tile(Position position, char c) {
    public boolean startingPosition() {
        return c == '^';
    }

    public boolean isBlocked() {
        return c == '#';
    }
}
