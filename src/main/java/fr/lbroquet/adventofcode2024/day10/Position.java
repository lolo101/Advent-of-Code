package fr.lbroquet.adventofcode2024.day10;

public record Position(Coordinates coordinates, char height) {
    public boolean oneHigherThan(Position position) {
        return height == position.height + 1;
    }
}
