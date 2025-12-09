package fr.lbroquet.adventofcode2025.day7;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        char[][] map = Input.loadMap(Main.class);
        TachyonManifold manifold = new TachyonManifold(map);
        IO.println("Tachyon beam split times: " + manifold.countSplits());
    }
}
