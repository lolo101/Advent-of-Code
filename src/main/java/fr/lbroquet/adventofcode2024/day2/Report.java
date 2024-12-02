package fr.lbroquet.adventofcode2024.day2;

import java.util.List;

public record Report(List<Integer> levels) {
    public boolean isSafe() {
        int sign = 0;
        for (int i = 1; i < levels.size(); i++) {
            Integer current = levels.get(i - 1);
            Integer next = levels.get(i);
            int diff = next - current;
            if (1 > Math.abs(diff) || Math.abs(diff) > 3) return false;
            int signum = Integer.signum(diff);
            if (sign != 0 && sign != signum) return false;
            sign = signum;
        }
        return true;
    }
}
