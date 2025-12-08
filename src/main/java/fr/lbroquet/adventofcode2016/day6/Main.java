package fr.lbroquet.adventofcode2016.day6;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        Dedup dedup = new Dedup();
        try (BufferedReader reader = Input.load(Main.class)) {
            reader.lines().forEach(dedup::repeat);
        }
        IO.println(dedup.decode());
        IO.println(dedup.decodeReversed());
    }
}
