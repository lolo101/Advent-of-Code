package fr.lbroquet.adventofcode2025.day1;

public class Dial {
    private int pointer;
    private final int quantityOfNumbers;

    public Dial(int quantityOfNumbers, int pointer) {
        this.pointer = pointer;
        this.quantityOfNumbers = quantityOfNumbers;
    }

    int add(int distance) {
        int unwrappedNewNumber = pointer + distance;
        int clicks = unwrappedNewNumber / quantityOfNumbers;
        pointer = unwrappedNewNumber % quantityOfNumbers;
        return clicks;
    }

    int sub(int distance) {
        pointer = (quantityOfNumbers - pointer) % quantityOfNumbers;
        int clicks = add(distance);
        pointer = (quantityOfNumbers - pointer) % quantityOfNumbers;
        return clicks;
    }
}
