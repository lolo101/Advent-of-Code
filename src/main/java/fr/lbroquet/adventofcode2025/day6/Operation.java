package fr.lbroquet.adventofcode2025.day6;

import java.util.Arrays;

record Operation(char operator, long... operands) {
    public long compute() {
        return switch (operator) {
            case '+' -> Arrays.stream(operands).sum();
            case '*' -> Arrays.stream(operands).reduce(Math::multiplyExact).orElse(0);
            default -> 0;
        };
    }
}
