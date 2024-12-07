package fr.lbroquet.adventofcode2024.day6;

import java.util.HashSet;
import java.util.Set;

public class SituationMap {
    private final char[][] map;
    private final Set<Position> visited = new HashSet<>();
    private final Set<Guard> visitedObstacles = new HashSet<>();
    private final Set<Position> possibleObstructions = new HashSet<>();

    public SituationMap(char[][] map) {
        this.map = map;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                Position position = new Position(row, column);
                if (map[row][column] == '^') {
                    visited.add(position);
                }
            }
        }
        Guard guard = new Guard(visited.stream().findFirst().orElseThrow(), Facing.NORTH);
        walk(guard);
    }

    public String print() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                if (possibleObstructions.contains(new Position(row, column))) {
                    output.append("\u001b[93mO\u001b[0m");
                } else if (visited.contains(new Position(row, column))) {
                    output.append("\u001b[31mx\u001b[0m");
                } else {
                    output.append(map[row][column]);
                }
            }
            output.append('\n');
        }
        return output.toString();
    }

    public int visitedPositions() {
        return visited.size();
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
            if (blocked(forwardPosition)) {
                visitedObstacles.add(guard);
                guard = guard.turnRight();
            } else {
                visited.add(forwardPosition);
                if (sendGhostWalkInLoop(guard.turnRight())) {
                    possibleObstructions.add(forwardPosition);
                }
                guard = guard.stepForward();
            }
        }
    }

    private boolean sendGhostWalkInLoop(Guard guard) {
        Set<Guard> ghostVisitedObstacle = new HashSet<>(visitedObstacles);
        for (
                Position forwardPosition = guard.forwardPosition();
                insideMap(forwardPosition);
                forwardPosition = guard.forwardPosition()
        ) {
            if (blocked(forwardPosition)) {
                boolean alreadyVisited = !ghostVisitedObstacle.add(guard);
                if (alreadyVisited) {
                    return true;
                }
                guard = guard.turnRight();
            } else {
                guard = guard.stepForward();
            }
        }
        return false;
    }

    private boolean insideMap(Position position) {
        int row = position.row();
        int column = position.column();
        return 0 <= row && row < map.length && 0 <= column && column < map[row].length;
    }

    private boolean blocked(Position position) {
        return map[position.row()][position.column()] == '#';
    }
}
