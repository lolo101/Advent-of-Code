package fr.lbroquet.adventofcode2025.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Gatherer;

public class Main {
    static void main() throws IOException {
        try (BufferedReader rotations = Input.load(Main.class)) {
            long sum = rotations.lines()
                    .map(Main::toRotation)
                    .gather(Gatherer.<Rotation, Dial, Integer>ofSequential(
                            () -> new Dial(100, 50),
                            (dial, rotation, downstream) -> {
                                int clicks = rotation.move(dial);
                                return downstream.push(clicks);
                            }
                    ))
                    .mapToInt(Integer::intValue)
                    .sum();
            IO.println("Number of clicks @ zero: " + sum);
        }
    }

    private static Rotation toRotation(String line) {
        char direction = line.charAt(0);
        return switch (direction) {
            case 'R' -> new Rotation.Add(Integer.parseInt(line.substring(1)));
            case 'L' -> new Rotation.Sub(Integer.parseInt(line.substring(1)));
            default -> throw new IllegalArgumentException("Unexpected direction: " + direction);
        };
    }
}
