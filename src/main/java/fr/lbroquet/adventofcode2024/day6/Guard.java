package fr.lbroquet.adventofcode2024.day6;

public record Guard(Position position, Facing facing) {
    public Position forwardPosition() {
        return facing.forward(position);
    }

    public Guard stepForward() {
        return new Guard(forwardPosition(), facing);
    }

    public Guard turnRight() {
        return new Guard(position, facing.turnRight());
    }
}
