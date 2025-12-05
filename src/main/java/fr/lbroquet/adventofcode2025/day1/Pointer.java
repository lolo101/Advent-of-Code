package fr.lbroquet.adventofcode2025.day1;

public class Pointer {
    public int number;
    private final int quantityOfNumbers;

    public Pointer(int number, int quantityOfNumbers) {
        this.number = number;
        this.quantityOfNumbers = quantityOfNumbers;
    }

    int add(int distance) {
        int unwrappedNewNumber = number + distance;
        int clicks = unwrappedNewNumber / quantityOfNumbers;
        number = unwrappedNewNumber % quantityOfNumbers;
        return clicks;
    }

    int sub(int distance) {
        int unwrappedNewNumber = number - distance;
        int clicks = Math.abs(unwrappedNewNumber / quantityOfNumbers);
        if (unwrappedNewNumber <= 0 && number > 0) ++clicks;
        number = unwrappedNewNumber % quantityOfNumbers;
        if (number < 0) number += quantityOfNumbers;
        return clicks;
    }
}
