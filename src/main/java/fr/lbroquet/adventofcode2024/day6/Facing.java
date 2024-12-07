package fr.lbroquet.adventofcode2024.day6;

public enum Facing {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    public Facing turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
}
