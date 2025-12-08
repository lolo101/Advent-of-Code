package fr.lbroquet.adventofcode2022.day9;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        Rope rope = new Rope();
        try (BufferedReader reader = Input.load(Main.class)) {
            reader.lines()
                .map(Movement::of)
                .forEach(rope::move);
        }

        IO.println(rope.tailPositions().size());
        IO.println(rope.printTailPositions());
    }
}
