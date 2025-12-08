package fr.lbroquet.adventofcode2024.day6;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] map = Input.loadMap(Main.class);
        SituationMap situationMap = new SituationMap(map);
        IO.println("visited positions: " + situationMap.visitedPositions());
        IO.println("possible obstructions: " + situationMap.possibleObstructions());
        IO.println(situationMap.print());
    }
}
