package fr.lbroquet.adventofcode2025.day6;

import java.util.ArrayList;
import java.util.Collection;

class Memo {
    public char operator;
    private final Collection<Long> operands = new ArrayList<>();

    public Long[] dumpOperands() {
        Long[] array = operands.toArray(Long[]::new);
        operands.clear();
        return array;
    }

    public void addOperand(String operand) {
        operands.add(Long.parseLong(operand));
    }
}
