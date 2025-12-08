package fr.lbroquet.adventofcode2024.day10;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] map = Input.loadMap(Main.class);
        TopographicMap topographicMap = new TopographicMap(map);
        IO.println("Trailheads score sum: " + topographicMap.trailheadsScoreSum());
        IO.println("Trailheads rating sum: " + topographicMap.trailheadsRatingSum());
    }
}
