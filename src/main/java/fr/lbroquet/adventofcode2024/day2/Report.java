package fr.lbroquet.adventofcode2024.day2;

import java.util.ArrayList;
import java.util.List;

public record Report(List<Integer> levels) {
    public boolean isSafe() {
        List<Integer> derivativeLevels = derivate(levels);
        return new ProblemDampener(derivativeLevels).isSafe();
    }

    private static List<Integer> derivate(List<Integer> levels) {
        List<Integer> derivativeLevels = new ArrayList<>();
        for (int i = 1; i < levels.size(); i++) {
            Integer current = levels.get(i - 1);
            Integer next = levels.get(i);
            derivativeLevels.add(next - current);
        }
        return derivativeLevels;
    }
}
