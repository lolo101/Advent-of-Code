package fr.lbroquet.adventofcode2024.day16;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Maze maze = new Maze(Input.loadMap(Main.class));
        System.out.println("Lowest score: " + maze.lowestScore());
    }
}
