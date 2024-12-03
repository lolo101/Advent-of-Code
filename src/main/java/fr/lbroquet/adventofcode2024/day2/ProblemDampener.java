package fr.lbroquet.adventofcode2024.day2;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record ProblemDampener(List<Integer> derivativeLevels) {
    public boolean isSafe() {
        List<Integer> incresingIndexes = new ArrayList<>();
        List<Integer> decresingIndexes = new ArrayList<>();
        List<Integer> excessiveIndexes = new ArrayList<>();
        for (int i = 0; i < derivativeLevels.size(); i++) {
            Integer derivative = derivativeLevels.get(i);
            if (derivative >= 0) {
                incresingIndexes.add(i);
            }
            if (derivative <= 0) {
                decresingIndexes.add(i);
            }
            if (derivative == 0 || Math.abs(derivative) > 3) {
                excessiveIndexes.add(i);
            }
        }

        if (decresingIndexes.size() > incresingIndexes.size()) {
            return safelyIncreasing(new ArrayList<>(derivativeLevels.stream().map(i -> -i).toList()), incresingIndexes, excessiveIndexes);
        }
        return safelyIncreasing(new ArrayList<>(derivativeLevels), decresingIndexes, excessiveIndexes);
    }

    private static boolean safelyIncreasing(List<Integer> derivatives, List<Integer> decresingIndexes, List<Integer> excessiveIndexes) {
        if (decresingIndexes.size() == 1) {
            int erroneousIndex = decresingIndexes.getFirst();
            int previousValue = previousValue(erroneousIndex, derivatives);
            int erroneousValue = derivatives.get(erroneousIndex);
            int nextValue = nextValue(erroneousIndex, derivatives);
            int previousDiff = previousValue + erroneousValue;
            int nextDiff = erroneousValue + nextValue;
            int maxDiff = max(previousDiff, nextDiff);
            if (safeDerivative(maxDiff)) {
                derivatives.set(erroneousIndex + (previousDiff > nextDiff ? -1 : 1), maxDiff);
                derivatives.remove(erroneousIndex);
            } else if (isOnEdge(erroneousIndex, derivatives)) {
                derivatives.remove(erroneousIndex);
            }
        } else if (excessiveIndexes.size() == 1) {
            int excessiveIndex = excessiveIndexes.getFirst();
            if (isFirst(excessiveIndex)) {
                derivatives.removeFirst();
            } else if (isLast(excessiveIndex, derivatives)) {
                derivatives.removeLast();
            }
        }
        return safe(derivatives);
    }

    private static int previousValue(int index, List<Integer> list) {
        return isFirst(index) ? 0 : list.get(index - 1);
    }

    private static int nextValue(int index, List<Integer> list) {
        return isLast(index, list) ? 0 : list.get(index + 1);
    }

    private static boolean isOnEdge(int index, Collection<Integer> list) {
        return isFirst(index) || isLast(index, list);
    }

    private static boolean isFirst(int index) {
        return index == 0;
    }

    private static boolean isLast(int index, Collection<Integer> list) {
        return index == list.size() - 1;
    }

    private static boolean safe(Collection<Integer> derivatives) {
        return derivatives.stream().allMatch(ProblemDampener::safeDerivative);
    }

    private static boolean safeDerivative(int derivative) {
        return 0 < derivative && derivative < 4;
    }
}
