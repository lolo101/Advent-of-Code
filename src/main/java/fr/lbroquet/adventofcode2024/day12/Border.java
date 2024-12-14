package fr.lbroquet.adventofcode2024.day12;

import java.util.*;
import java.util.stream.Stream;

class Border {
    private final SortedSet<Location> locations = new TreeSet<>();

    public Border(Collection<Location> locations) {
        this.locations.addAll(locations);
    }

    public long turns() {
        long turns = 0;
        for (Location location : locations) {
            turns += numberOfTurnsAtUpperLeftCornerOf(location);
            Location south = location.south();
            Location east = location.east();
            Location northEast = location.north().east();
            Location southEast = south.east();
            if (!locations.contains(south)) {
                turns += numberOfTurnsAtUpperLeftCornerOf(south);
            }
            if (!locations.contains(east) && !locations.contains(northEast)) {
                turns += numberOfTurnsAtUpperLeftCornerOf(east);
            }
            if (!locations.contains(south) && !locations.contains(east) && !locations.contains(southEast)) {
                turns += numberOfTurnsAtUpperLeftCornerOf(southEast);
            }
        }
        return turns;
    }

    private int numberOfTurnsAtUpperLeftCornerOf(Location location) {
        List<Location> locationsInRegion = Stream.of(
                        location,
                        location.north(),
                        location.west(),
                        location.north().west()
                ).filter(locations::contains)
                .toList();
        int count = locationsInRegion.size();
        if (count == 1 || count == 3) {
            return 1;
        }
        if (count == 2) {
            Location first = locationsInRegion.getFirst();
            Location last = locationsInRegion.getLast();
            if (first.row() != last.row() && first.column() != last.column()) {
                return 2;
            }
        }
        return 0;
    }
}
