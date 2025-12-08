package fr.lbroquet.adventofcode2024.day4;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] array = Input.loadMap(Main.class);
        WordSearch wordSearch = new WordSearch(array);
        IO.println("XMAS count: " + wordSearch.count());

        CrossMas crossMas = new CrossMas(array);
        IO.println("X-MAS count: " + crossMas.count());
    }
}
