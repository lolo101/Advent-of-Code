package fr.lbroquet.adventofcode2024.day12;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toSet;

class Garden {
    private final Plot[][] plots;

    public Garden(char[][] map) {
        plots = new Plot[map.length][];
        for (int row = 0; row < map.length; row++) {
            plots[row] = new Plot[map[row].length];
            for (int column = 0; column < map[row].length; column++) {
                char type = map[row][column];
                plots[row][column] = mergePlotSameRegion(row, column, type);
            }
        }
    }

    private Plot mergePlotSameRegion(int row, int column, char type) {
        Region region = new Region(type);
        Plot plot = new Plot(row, column, region);
        if (row > 0) {
            Plot plotAbove = plots[row - 1][column];
            plotAbove.mergeWithIfSameRegion(plot);
        }
        if (column > 0) {
            Plot plotLeft = plots[row][column - 1];
            plotLeft.mergeWithIfSameRegion(plot);
        }
        return plot;
    }

    public long priceOfFencing() {
        Collection<Region> regions = Arrays.stream(plots)
                .flatMap(Arrays::stream)
                .map(value -> value.region)
                .collect(toSet());
        return regions.stream().mapToLong(Region::priceOfFencing).sum();
    }

    public long discountedPriceOfFencing() {
        Collection<Region> regions = Arrays.stream(plots)
                .flatMap(Arrays::stream)
                .map(value -> value.region)
                .collect(toSet());
        return regions.stream().mapToLong(Region::discountedPriceOfFencing).sum();
    }
}
