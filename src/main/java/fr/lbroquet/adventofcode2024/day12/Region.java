package fr.lbroquet.adventofcode2024.day12;

import java.util.ArrayList;
import java.util.Collection;

public class Region {
    final char type;
    private final Collection<Plot> plots = new ArrayList<>();

    public Region(char type) {
        this.type = type;
    }

    public void addPlot(Plot plot) {
        plots.add(plot);
    }

    public void absorb(Region other) {
        other.plots.forEach(plot -> plot.region = this);
        plots.addAll(other.plots);

    }

    public long priceOfFencing() {
        return area() * perimeter();
    }

    public long discountedPriceOfFencing() {
        return area() * sides();
    }

    private long area() {
        return plots.size();
    }

    private long perimeter() {
        return plots.stream().mapToLong(plot -> plot.perimeter).sum();
    }

    private long sides() {
        Border border = new Border(plots.stream().map(plot -> plot.location).toList());
        return border.turns();
    }
}
