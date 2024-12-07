package fr.lbroquet.adventofcode2024.day6;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SituationMap {
    private final SortedMap<Position, Tile> tiles = new TreeMap<>();
    private final Set<Position> visited = new HashSet<>();

    public SituationMap(char[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                Position position = new Position(row, column);
                Tile tile = new Tile(position, map[row][column]);
                tiles.put(position, tile);
                if (tile.startingPosition()) {
                    visited.add(position);
                }
            }
        }
    }

    public long visitedPositions() {
        walk();
        return visited.size();
    }

    private void walk() {
        Position currentPosition = visited.stream().findFirst().orElseThrow();
        Guard guard = new Guard(currentPosition, Facing.NORTH);
        for (
                Position forwardPosition = guard.forwardPosition();
                tiles.containsKey(forwardPosition);
                forwardPosition = guard.forwardPosition()
        ) {
            Tile forwardTile = tiles.get(forwardPosition);
            if (forwardTile.isBlocked()) {
                guard.turnRight();
            } else {
                visited.add(forwardPosition);
                guard.stepForward();
            }
        }
    }
}
