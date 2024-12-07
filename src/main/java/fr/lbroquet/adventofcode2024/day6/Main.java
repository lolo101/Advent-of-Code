package fr.lbroquet.adventofcode2024.day6;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SituationMap situationMap = load();
        System.out.println("visited positions: " + situationMap.visitedPositions());
    }

    private static SituationMap load() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            char[][] map = reader.lines().map(String::toCharArray).toArray(char[][]::new);
            return new SituationMap(map);
        }
    }
}
