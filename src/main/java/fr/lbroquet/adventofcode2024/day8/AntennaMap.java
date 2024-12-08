package fr.lbroquet.adventofcode2024.day8;

import java.util.*;

import static java.lang.Math.min;

public class AntennaMap {
    private final char[][] map;
    private final Map<Character, List<Location>> antennas = new HashMap<>();

    public AntennaMap(char[][] map) {
        this.map = map;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                char tile = map[row][column];
                if (tile != '.') {
                    antennas.computeIfAbsent(tile, _ -> new ArrayList<>()).add(new Location(row, column));
                }
            }
        }
    }

    public long countAntinodes() {
        return antennas.keySet()
                .stream()
                .map(this::toFrequencyAntinodes)
                .flatMap(Collection::stream)
                .distinct()
                .count();
    }

    private Collection<Location> toFrequencyAntinodes(char frequency) {
        Collection<Location> antinodes = new ArrayList<>();
        List<Location> frequencyAntennas = antennas.get(frequency);
        for (int firstIndex = 0; firstIndex < frequencyAntennas.size(); firstIndex++) {
            Location firstAntenna = frequencyAntennas.get(firstIndex);
            for (int secondIndex = firstIndex + 1; secondIndex < frequencyAntennas.size(); secondIndex++) {
                Location secondAntenna = frequencyAntennas.get(secondIndex);
                antinodes.addAll(antinodesForCouple(firstAntenna, secondAntenna));
            }
        }
        return antinodes;
    }

    private Collection<Location> antinodesForCouple(Location firstAntenna, Location secondAntenna) {
        int deltaRow = secondAntenna.row() - firstAntenna.row();
        int deltaColumn = secondAntenna.column() - firstAntenna.column();
        int numberOfDeltaFromFirstAntennaToEdge = min(
                numberOfDeltaFromRowToEdge(firstAntenna.row(), deltaRow),
                numberOfDeltaFromColumnToEdge(firstAntenna.column(), deltaColumn)
        );
        int minRow = firstAntenna.row() - numberOfDeltaFromFirstAntennaToEdge * deltaRow;
        int minColumn = firstAntenna.column() - numberOfDeltaFromFirstAntennaToEdge * deltaColumn;
        Collection<Location> antinodes = new ArrayList<>();
        for (
                int row = minRow, column = minColumn;
                withinBounds(row, column);
                row += deltaRow, column += deltaColumn) {
            antinodes.add(new Location(row, column));
        }
        return antinodes;
    }

    private int numberOfDeltaFromRowToEdge(int row, int deltaRow) {
        if (deltaRow < 0) {
            return (row - map.length + 1) / deltaRow;
        }
        if (deltaRow > 0) {
            return row / deltaRow;
        }
        return Integer.MAX_VALUE;
    }

    private int numberOfDeltaFromColumnToEdge(int column, int deltaColumn) {
        if (deltaColumn < 0) {
            return (column - map[0].length + 1) / deltaColumn;
        }
        if (deltaColumn > 0) {
            return column / deltaColumn;
        }
        return Integer.MAX_VALUE;
    }

    private boolean withinBounds(int row, int column) {
        return 0 <= row && row < map.length && 0 <= column && column < map[row].length;
    }
}
