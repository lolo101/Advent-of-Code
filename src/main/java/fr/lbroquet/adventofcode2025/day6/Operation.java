package fr.lbroquet.adventofcode2025.day6;

import java.util.Arrays;

record Operation(char operator, Long... operands) {
    public Operation(Memo memo) {
        this(memo.operator, memo.dumpOperands());
    }

    public long compute() {
        return switch (operator) {
            case '+' -> Arrays.stream(operands).reduce(Math::addExact).orElse(0L);
            case '*' -> Arrays.stream(operands).reduce(Math::multiplyExact).orElse(0L);
            default -> 0;
        };
    }
}
