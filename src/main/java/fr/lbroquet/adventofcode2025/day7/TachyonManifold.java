package fr.lbroquet.adventofcode2025.day7;

import java.util.*;

import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;
import static java.util.Collections.*;

class TachyonManifold {
    private Position start;
    private final Map<Integer, SortedSet<Position>> splittersByColumn = new HashMap<>();

    public TachyonManifold(char[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                char tile = map[row][column];
                if (tile == 'S') {
                    this.start = new Position(row, column);
                }
                if (tile == '^') {
                    splittersByColumn.computeIfAbsent(column, _ -> new TreeSet<>()).add(new Position(row, column));
                }
            }
        }
    }

    public long countSplits() {
        Set<Position> activatedSplitter = new HashSet<>();

        Deque<Position> beams = new ArrayDeque<>();
        beams.push(start);
        for (
                Position currentBeamPosition;
                (currentBeamPosition = beams.poll()) != null;
        ) {
            SortedSet<Position> columnSplitters = splittersByColumn.getOrDefault(currentBeamPosition.column(), emptySortedSet());
            SortedSet<Position> reachableSplitters = columnSplitters.tailSet(currentBeamPosition);
            if (!reachableSplitters.isEmpty()) {
                Position nextSplitter = reachableSplitters.first();
                if (activatedSplitter.add(nextSplitter)) {
                    beams.push(nextSplitter.left());
                    beams.push(nextSplitter.right());
                }
            }
        }
        return activatedSplitter.size();
    }

    public long countTimelines() {
        Set<Beam> finishedBeams = new HashSet<>();

        SortedMap<Position, Long> splitterWeight = new TreeMap<>();
        SortedSet<Position> activatedSplitter = new TreeSet<>();
        Deque<Beam> beams = new ArrayDeque<>();
        beams.push(new Beam(start, emptyList()));
        for (
                Beam currentBeam;
                (currentBeam = beams.poll()) != null;
        ) {
            SortedSet<Position> columnSplitters = splittersByColumn.getOrDefault(currentBeam.start().column(), emptySortedSet());
            SortedSet<Position> reachableSplitters = columnSplitters.tailSet(currentBeam.start());
            if (reachableSplitters.isEmpty()) {
                finishedBeams.add(currentBeam);
            } else {
                Position nextSplitter = reachableSplitters.first();
                if(activatedSplitter.add(nextSplitter)) {
                    List<Position> newSplitterChain = new ArrayList<>(currentBeam.splitterChain());
                    newSplitterChain.add(nextSplitter);
                    beams.push(new Beam(nextSplitter.left(), newSplitterChain));
                    beams.push(new Beam(nextSplitter.right(), newSplitterChain));
                } else {
                    Long previousWeight = splitterWeight.computeIfAbsent(nextSplitter, _ -> 1L);
                    splitterWeight.put(nextSplitter, previousWeight + 1L);
                }
            }
        }
        return finishedBeams.stream().reduce(0L, (sum, beam) ->
                addExact(sum, beam.splitterChain().stream().reduce(1L, (mul, splitter) -> multiplyExact(mul, splitterWeight.getOrDefault(splitter, 1L)), Math::multiplyExact)),
                Math::addExact
        );
    }
}
