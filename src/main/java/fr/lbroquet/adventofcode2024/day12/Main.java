package fr.lbroquet.adventofcode2024.day12;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] map = Input.loadMap(Main.class);
        Garden garden = new Garden(map);
        System.out.println("Price of fencing all regions: " + garden.priceOfFencing());
    }
}
