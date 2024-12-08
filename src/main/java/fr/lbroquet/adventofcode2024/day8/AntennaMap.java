package fr.lbroquet.adventofcode2024.day8;

import java.util.*;

public class AntennaMap {
    private final char[][] map;
    private final Map<Character, List<Location>> antennas = new HashMap<>();

    public AntennaMap(char[][] map) {
        this.map = map;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                char tile = map[x][y];
                if (tile != '.') {
                    antennas.computeIfAbsent(tile, _ -> new ArrayList<>()).add(new Location(x, y));
                }
            }
        }
    }

    public long countAntinodes() {
        return antennas.keySet()
                .stream()
                .map(this::toFrequencyAntinodes)
                .flatMap(Collection::stream)
                .filter(this::withinBounds)
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

    private static Collection<Location> antinodesForCouple(Location firstAntenna, Location secondAntenna) {
        int deltaX = secondAntenna.x() - firstAntenna.x();
        int deltaY = secondAntenna.y() - firstAntenna.y();
        return List.of(
                new Location(firstAntenna.x() - deltaX, firstAntenna.y() - deltaY),
                new Location(firstAntenna.x() + 2 * deltaX, firstAntenna.y() + 2 * deltaY)
        );
    }

    private boolean withinBounds(Location location) {
        int x = location.x();
        int y = location.y();
        return 0 <= x && x < map.length && 0 <= y && y < map[x].length;
    }
}
