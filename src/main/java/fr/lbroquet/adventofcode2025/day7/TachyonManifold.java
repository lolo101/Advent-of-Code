package fr.lbroquet.adventofcode2025.day7;

import java.util.*;

import static java.util.Comparator.comparing;

class TachyonManifold {
    private Position start;
    private final Map<Integer, SortedSet<Position>> splittersByColumn = new HashMap<>();

    public TachyonManifold(char[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                char tile = map[row][column];
                if (tile == 'S') {
                    this.start = new Position(row, column);
                }
                if (tile == '^') {
                    splittersByColumn.computeIfAbsent(column, _ -> newSetOfPositions()).add(new Position(row, column));
                }
            }
        }
    }

    public long countSplits() {
        Deque<Position> beams = new ArrayDeque<>();
        Set<Position> activatedSplitter = new HashSet<>();
        beams.push(start);
        for (
                Position currentBeamPosition;
                (currentBeamPosition = beams.poll()) != null;
        ) {
            SortedSet<Position> columnSplitters = splittersByColumn.getOrDefault(currentBeamPosition.column(), newSetOfPositions());
            SortedSet<Position> reachableSplitters = columnSplitters.tailSet(currentBeamPosition);
            if (!reachableSplitters.isEmpty()) {
                Position nextSplitter = reachableSplitters.first();
                if (activatedSplitter.add(nextSplitter)) {
                    beams.push(nextSplitter.left());
                    beams.push(nextSplitter.right());
                }
            }
        }
        return activatedSplitter.size();
    }

    private static TreeSet<Position> newSetOfPositions() {
        return new TreeSet<>(comparing(Position::row));
    }
}
