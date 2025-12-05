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
                    .gather(Gatherer.<Rotation, Pointer, Integer>ofSequential(
                            () -> new Pointer(50, 100),
                            (pointer, rotation, downstream) -> {
                                int clicks = rotation.move(pointer);
                                return downstream.push(clicks);
                            }
                    ))
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println("Number of clicks @ zero: " + sum);
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
