package fr.lbroquet.adventofcode2024.day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Trailhead {
    private final char[][] map;
    private final Position start;

    public Trailhead(char[][] map, int row, int column) {
        this.map = map;
        this.start = new Position(new Coordinates(row, column), '0');
    }

    public long score() {
        List<Position> toVisit = new ArrayList<>();
        Collection<Position> score = new HashSet<>();
        toVisit.add(start);
        while (!toVisit.isEmpty()) {
            Position position = toVisit.removeFirst();
            if (position.height() == '9')
                score.add(position);
            else
                toVisit.addAll(neighbors(position));
        }
        return score.size();
    }

    private Collection<Position> neighbors(Position position) {
        Coordinates current = position.coordinates();
        return Stream.of(
                        new Coordinates(current.row() - 1, current.column()),
                        new Coordinates(current.row(), current.column() - 1),
                        new Coordinates(current.row(), current.column() + 1),
                        new Coordinates(current.row() + 1, current.column())
                )
                .filter(this::withinMap)
                .map(this::toPosition)
                .filter(nextPosition -> nextPosition.oneHigherThan(position))
                .toList();
    }

    private boolean withinMap(Coordinates coordinates) {
        int row = coordinates.row();
        int column = coordinates.column();
        return 0 <= row && row < this.map.length
                && 0 <= column && column < this.map[row].length;
    }

    private Position toPosition(Coordinates coordinates) {
        return new Position(coordinates, map[coordinates.row()][coordinates.column()]);
    }
}
