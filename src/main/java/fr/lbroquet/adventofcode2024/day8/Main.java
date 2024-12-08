package fr.lbroquet.adventofcode2024.day8;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AntennaMap antennaMap = load();
        System.out.println("Number of antinodes: " + antennaMap.countAntinodes());
    }

    private static AntennaMap load() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            char[][] map = reader.lines().map(String::toCharArray).toArray(char[][]::new);
            return new AntennaMap(map);
        }
    }
}
