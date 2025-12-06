package fr.lbroquet.adventofcode2023.day11;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] universeArray = Input.loadMap(Main.class);
        Universe universe = new Universe(universeArray);
        System.out.printf("Sum of distances between pairs of galaxies: %d%n", universe.sumOfDistances());
    }
}
