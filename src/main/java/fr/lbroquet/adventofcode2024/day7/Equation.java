package fr.lbroquet.adventofcode2024.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;

import static java.lang.Math.addExact;
import static java.lang.Math.multiplyExact;

public record Equation(long test, long[] operands) {
    public boolean possible() {
        List<Long> remainingOperands = LongStream.of(operands).collect(ArrayList::new, List::add, List::addAll);
        List<Long> intermediateResults = new ArrayList<>();
        Collection<Long> results = new ArrayList<>();
        results.add(remainingOperands.removeFirst());
        while (!remainingOperands.isEmpty()) {
            intermediateResults.addAll(results);
            results.clear();
            Long nextOperand = remainingOperands.removeFirst();
            while (!intermediateResults.isEmpty()) {
                Long secondOperand = intermediateResults.removeFirst();
                results.add(addExact(secondOperand, nextOperand));
                results.add(multiplyExact(secondOperand, nextOperand));
            }
        }
        return results.contains(test);
    }
}
