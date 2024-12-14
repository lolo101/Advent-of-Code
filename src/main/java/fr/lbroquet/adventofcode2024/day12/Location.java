package fr.lbroquet.adventofcode2024.day12;

import java.util.Comparator;

record Location(int row, int column) implements Comparable<Location> {
    private static final Comparator<Location> COMPARATOR = Comparator.comparing(Location::row).thenComparing(Location::column);

    @Override
    public int compareTo(Location o) {
        return COMPARATOR.compare(this, o);
    }

    public Location north() {
        return new Location(row - 1, column);
    }

    Location east() {
        return new Location(row, column + 1);
    }

    public Location south() {
        return new Location(row + 1, column);
    }

    public Location west() {
        return new Location(row, column - 1);
    }
}
