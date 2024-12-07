package fr.lbroquet.adventofcode2024.day6;

public final class Guard {
    private Position position;
    private Facing facing;

    public Guard(Position position, Facing facing) {
        this.position = position;
        this.facing = facing;
    }

    public Position forwardPosition() {
        return switch (facing) {
            case NORTH -> new Position(position.row() - 1, position.column());
            case EAST -> new Position(position.row(), position.column() + 1);
            case SOUTH -> new Position(position.row() + 1, position.column());
            case WEST -> new Position(position.row(), position.column() - 1);
        };
    }

    public void stepForward() {
        position = forwardPosition();
    }

    public void turnRight() {
        facing = facing.turnRight();
    }
}
