package fr.lbroquet.adventofcode2018.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            int sum = reader.lines()
                    .mapToInt(Integer::parseInt)
                    .sum();
            IO.println("Final frequency : " + sum);
        }

        try (BufferedReader reader = Input.load(Main.class)) {
            Iterable<Integer> changes = reader.lines()
                    .map(Integer::valueOf)
                    .collect(toList());
            Accumulator accu = new Accumulator(changes);
            IO.println("First repeated frequency : " + accu.firstDuplicate());
        }
    }
}
