package fr.lbroquet.adventofcode2024.day10;

import java.util.ArrayList;
import java.util.Collection;

public class TopographicMap {
    private final Collection<Trailhead> trailheads = new ArrayList<>();

    public TopographicMap(char[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                if (map[row][column] == '0') {
                    trailheads.add(new Trailhead(map, row, column));
                }
            }
        }
    }

    public long trailheadsScoreSum() {
        return trailheads.stream().mapToLong(Trailhead::score).sum();
    }

    public long trailheadsRatingSum() {
        return trailheads.stream().mapToLong(Trailhead::rating).sum();
    }
}
