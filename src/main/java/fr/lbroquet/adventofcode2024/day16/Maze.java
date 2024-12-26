package fr.lbroquet.adventofcode2024.day16;

import java.util.*;

class Maze {
    private final char[][] maze;
    private final Position end;
    private final Reindeer reindeerStart;

    public Maze(char[][] maze) {
        this.maze = maze;
        Position start = find('S');
        end = find('E');
        reindeerStart = new Reindeer(start, Facing.EAST);
    }

    private Position find(char mark) {
        for (int row = 0; row < maze.length; row++) {
            for (int column = 0; column < maze[0].length; column++) {
                if (maze[row][column] == mark) {
                    return new Position(row, column);
                }
            }
        }
        throw new IllegalArgumentException("Mark %c not found".formatted(mark));
    }

    public long lowestScore() {
        Map<Position, Long> visited = new HashMap<>();
        SequencedMap<Reindeer, Long> nextVisit = new LinkedHashMap<>();
        nextVisit.put(reindeerStart, 0L);
        for (Map.Entry<Reindeer, Long> reindeerScore = nextVisit.pollFirstEntry(); reindeerScore != null; reindeerScore = nextVisit.pollFirstEntry()) {
            Reindeer current = reindeerScore.getKey();
            long currentScore = reindeerScore.getValue();
            Position position = current.position();
            if (visited.containsKey(position) && visited.get(position) <= currentScore) {
                continue;
            }
            Facing facing = current.facing();
            Position forwardPosition = facing.forward(position);
            Reindeer forward = new Reindeer(forwardPosition, facing);
            Position rightPosition = facing.right(position);
            Reindeer right = new Reindeer(rightPosition, facing.turnRight());
            Position leftPosition = facing.left(position);
            Reindeer left = new Reindeer(leftPosition, facing.turnLeft());
            if (isPassable(forwardPosition)) {
                nextVisit.put(forward, currentScore + 1);
            }
            if (isPassable(rightPosition)) {
                nextVisit.put(right, currentScore + 1001);
            }
            if (isPassable(leftPosition)) {
                nextVisit.put(left, currentScore + 1001);
            }
            visited.put(position, currentScore);
        }
        return visited.get(end);
    }

    private boolean isPassable(Position position) {
        return maze[position.row()][position.column()] != '#';
    }
}
