package fr.lbroquet.adventofcode2023.day18;

import java.util.*;
import java.util.Map.Entry;

public class DigPlan {
    private final List<DigStep> digSteps;
    private final Turtle turtle = new Turtle();
    private final SortedMap<Integer, SortedSet<Integer>> crossings = new TreeMap<>();

    public DigPlan(List<DigStep> digSteps) {
        this.digSteps = digSteps;
    }

    public long surface() {
        for (DigStep step : digSteps) {
            drawVerticalLine(step);
            turtle.move(step);
        }

        long surface = 0;
        for (Entry<Integer, SortedSet<Integer>> rowCrossings : crossings.entrySet()) {
            SortedSet<Integer> crossingPoints = rowCrossings.getValue();
            while (!crossingPoints.isEmpty()) {
                Integer left = crossingPoints.removeFirst();
                Integer right = crossingPoints.removeFirst();
                surface += right - left + 1;
            }
        }
        return surface;
    }

    private void drawVerticalLine(DigStep step) {
        switch (step.direction()) {
            case Up -> {
                for (int row = 1; row < step.length(); row++) {
                    crossings.computeIfAbsent(turtle.row + row, k -> new TreeSet<>()).add(turtle.column);
                }
            }
            case Right -> {
                SortedSet<Integer> rowCrossings = crossings.computeIfAbsent(turtle.row, k -> new TreeSet<>());
                int leftRowCrossings = rowCrossings.subSet(Integer.MIN_VALUE, turtle.column).size();
                int rightRowCrossings = rowCrossings.subSet(turtle.column, Integer.MAX_VALUE).size();
                if (leftRowCrossings % 2 == 0)
                    rowCrossings.add(turtle.column);
                if (rightRowCrossings % 2 == 0)
                    rowCrossings.add(turtle.column + step.length());
            }
            case Down -> {
                for (int row = 1; row < step.length(); row++) {
                    crossings.computeIfAbsent(turtle.row - row, k -> new TreeSet<>()).add(turtle.column);
                }
            }
            case Left -> {
                SortedSet<Integer> rowCrossings = crossings.computeIfAbsent(turtle.row, k -> new TreeSet<>());
                int leftRowCrossings = rowCrossings.subSet(Integer.MIN_VALUE, turtle.column).size();
                int rightRowCrossings = rowCrossings.subSet(turtle.column, Integer.MAX_VALUE).size();
                if (leftRowCrossings % 2 == 0)
                    rowCrossings.add(turtle.column - step.length());
                if (rightRowCrossings % 2 == 0)
                    rowCrossings.add(turtle.column);
            }
        }
    }
}
