package fr.lbroquet.adventofcode2023.day18;

public enum Direction {
    Up, Right, Down, Left;

    public static Direction from(String direction) {
        return switch (direction) {
            case "U" -> Up;
            case "R" -> Right;
            case "D" -> Down;
            case "L" -> Left;
            default -> throw new IllegalArgumentException(direction);
        };
    }
}
