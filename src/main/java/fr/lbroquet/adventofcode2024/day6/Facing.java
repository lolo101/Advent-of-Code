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

    Position forward(Position position) {
        return switch (this) {
            case NORTH -> new Position(position.row() - 1, position.column());
            case EAST -> new Position(position.row(), position.column() + 1);
            case SOUTH -> new Position(position.row() + 1, position.column());
            case WEST -> new Position(position.row(), position.column() - 1);
        };
    }
}
