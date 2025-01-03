package fr.lbroquet.adventofcode2024.day6;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class SituationMap {
    private final char[][] map;
    private final Set<Position> obstructions = new HashSet<>();
    private final List<Guard> visited = new ArrayList<>();
    private final Set<Position> visitedPositions = new HashSet<>();
    private final Set<Position> possibleObstructions = new HashSet<>();

    public SituationMap(char[][] map) {
        this.map = map;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                char tile = map[row][column];
                if (tile == '#') {
                    Position position = new Position(row, column);
                    obstructions.add(position);
                }
                if (tile == '^') {
                    Position position = new Position(row, column);
                    visited.add(new Guard(position, Facing.NORTH));
                    visitedPositions.add(position);
                }
            }
        }
        walk(visited.getFirst());
    }

    public String print() {
        Map<Position, List<Guard>> guardsAtPositions = visited.stream().collect(groupingBy(Guard::position));
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                Position position = new Position(row, column);
                if (possibleObstructions.contains(position)) {
                    output.append("\u001b[93mO\u001b[0m");
                } else if (guardsAtPositions.containsKey(position)) {
                    Guard lastGuard = guardsAtPositions.get(position).getLast();
                    output.append("\u001b[31m").append(icon(lastGuard.facing())).append("\u001b[0m");
                } else {
                    output.append(map[row][column]);
                }
            }
            output.append('\n');
        }
        return output.toString();
    }

    private static char icon(Facing facing) {
        return switch (facing) {
            case NORTH -> '↑';
            case EAST -> '→';
            case SOUTH -> '↓';
            case WEST -> '←';
        };
    }

    public long visitedPositions() {
        return visitedPositions.size();
    }

    public int possibleObstructions() {
        return possibleObstructions.size();
    }

    private void walk(Guard guard) {
        for (
                Position forwardPosition = guard.forwardPosition();
                insideMap(forwardPosition);
                forwardPosition = guard.forwardPosition()
        ) {
            if (obstructions.contains(forwardPosition)) {
                guard = guard.turnRight();
            } else {
                if (!visitedPositions.contains(forwardPosition) && sendGhostWalkInLoop(guard.turnRight(), forwardPosition)) {
                    possibleObstructions.add(forwardPosition);
                }
                guard = guard.stepForward();
            }
            visited.add(guard);
            visitedPositions.add(guard.position());
        }
    }

    private boolean sendGhostWalkInLoop(Guard guard, Position possibleObstruction) {
        Set<Position> ghostObstructions = new HashSet<>(obstructions);
        ghostObstructions.add(possibleObstruction);
        Set<Guard> ghostVisited = new HashSet<>(visited);
        ghostVisited.add(guard);
        for (
                Position forwardPosition = guard.forwardPosition();
                insideMap(forwardPosition);
                forwardPosition = guard.forwardPosition()
        ) {
            if (ghostObstructions.contains(forwardPosition)) {
                guard = guard.turnRight();
            } else {
                guard = guard.stepForward();
            }
            boolean caughtInLoop = !ghostVisited.add(guard);
            if (caughtInLoop) {
                return true;
            }
        }
        return false;
    }

    private boolean insideMap(Position position) {
        int row = position.row();
        int column = position.column();
        return 0 <= row && row < map.length && 0 <= column && column < map[row].length;
    }
}
