package fr.lbroquet.adventofcode2025.day1;

public class Pointer {
    public int number;
    private final int quantityOfNumbers;

    public Pointer(int number, int quantityOfNumbers) {
        this.number = number;
        this.quantityOfNumbers = quantityOfNumbers;
    }

    void add(int distance) {
        number = (number + distance) % quantityOfNumbers;
    }

    void sub(int distance) {
        number = (number - distance) % quantityOfNumbers;
    }
}
