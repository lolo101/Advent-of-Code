package fr.lbroquet.adventofcode2024.day8;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] map = Input.loadMap(Main.class);
        AntennaMap antennaMap = new AntennaMap(map);
        System.out.println("Number of antinodes: " + antennaMap.countAntinodes());
    }
}
