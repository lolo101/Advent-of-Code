package fr.lbroquet.adventofcode2023.day16;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] contraptionArray = Input.loadMap(Main.class);
        Contraption contraption = new Contraption(contraptionArray);
        System.out.printf("Energized tiles: %d%n", contraption.energizedTiles(new Beam(new Position(0, 0), Direction.Rightward)));
        System.out.printf("Max energized tiles: %d%n", contraption.energizedTiles());
    }
}
