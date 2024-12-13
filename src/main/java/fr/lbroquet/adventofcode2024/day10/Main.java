package fr.lbroquet.adventofcode2024.day10;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        char[][] map = Input.loadMap(Main.class);
        TopographicMap topographicMap = new TopographicMap(map);
        System.out.println("Trailheads score sum: " + topographicMap.trailheadsScoreSum());
        System.out.println("Trailheads rating sum: " + topographicMap.trailheadsRatingSum());
    }
}
