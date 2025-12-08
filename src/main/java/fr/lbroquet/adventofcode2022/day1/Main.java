package fr.lbroquet.adventofcode2022.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader input = Input.load(Main.class)) {
            Elves elves = input.lines().collect(
                    Elves::new,
                    Elves::addCalories,
                    (_, _) -> {}
            );
            IO.println(elves);
        }
    }
}
