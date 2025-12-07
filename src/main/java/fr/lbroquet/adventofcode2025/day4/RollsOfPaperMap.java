package fr.lbroquet.adventofcode2025.day4;

import java.util.ArrayList;
import java.util.Collection;

class RollsOfPaperMap {
    private final char[][] map;

    public RollsOfPaperMap(char[][] map) {
        this.map = map;
    }

    /**
     * To be accessible, a roll must have fewer than 4 rolls on its 8 adjacent tiles.
     * @return quantity of accessible rolls on the map.
     */
    public long countAccessibleRollsOfPaper() {
        return accessiblePositions().size();
    }

    public long countRemovedRollsOfPaper() {
        long removedRollsOfPaper = 0;
        for (
                Collection<Position> accessiblePositions = accessiblePositions();
                !accessiblePositions.isEmpty();
                accessiblePositions = accessiblePositions()
        ) {
            for (Position position : accessiblePositions) {
                map[position.row()][position.column()] = 'x';
            }
            removedRollsOfPaper += accessiblePositions.size();
        }
        return removedRollsOfPaper;
    }

    private Collection<Position> accessiblePositions() {
        Collection<Position> accessiblePositions = new ArrayList<>();
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                if (map[row][column] == '@' && accessible(row, column))
                    accessiblePositions.add(new Position(row, column));
            }
        }
        return accessiblePositions;
    }

    private boolean accessible(int row, int column) {
        int adjacentRolls = 0;
        if (row > 0                && column > 0                     && map[row-1][column-1] == '@') ++adjacentRolls;
        if (row > 0                                                  && map[row-1][column]   == '@') ++adjacentRolls;
        if (row > 0                && (column + 1) < map[row].length && map[row-1][column+1] == '@') ++adjacentRolls;

        if (                          column > 0                     && map[row][column-1]   == '@') ++adjacentRolls;
        if (                          (column + 1) < map[row].length && map[row][column+1]   == '@') ++adjacentRolls;

        if ((row + 1) < map.length && column > 0                     && map[row+1][column-1] == '@') ++adjacentRolls;
        if ((row + 1) < map.length                                   && map[row+1][column]   == '@') ++adjacentRolls;
        if ((row + 1) < map.length && (column + 1) < map[row].length && map[row+1][column+1] == '@') ++adjacentRolls;
        return adjacentRolls < 4;
    }
}
