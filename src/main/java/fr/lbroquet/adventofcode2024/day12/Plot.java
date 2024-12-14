package fr.lbroquet.adventofcode2024.day12;

public class Plot {
    Region region;
    int perimeter = 4;

    public Plot(Region region) {
        this.region = region;
        region.addPlot(this);
    }

    public void mergeWithIfSameRegion(Plot other) {
        if (region.type == other.region.type) {
            perimeter -= 1;
            other.perimeter -= 1;
            if (region != other.region) {
                other.region.absorb(region);
            }
        }
    }
}
