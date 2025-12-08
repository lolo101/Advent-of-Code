package fr.lbroquet.adventofcode2024.day16;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        Maze maze = new Maze(Input.loadMap(Main.class));
        IO.println("Lowest score: " + maze.lowestScore());
    }
}
