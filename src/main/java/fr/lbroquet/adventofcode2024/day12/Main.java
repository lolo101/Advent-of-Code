package fr.lbroquet.adventofcode2024.day12;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] map = Input.loadMap(Main.class);
        Garden garden = new Garden(map);
        IO.println("Price of fencing all regions: " + garden.priceOfFencing());
        IO.println("Discounted price of fencing all regions: " + garden.discountedPriceOfFencing());
    }
}
