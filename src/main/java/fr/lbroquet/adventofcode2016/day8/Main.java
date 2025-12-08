package fr.lbroquet.adventofcode2016.day8;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            Screen screen = new Screen();
            reader.lines().forEach(screen::addInstr);
            IO.println(screen.countPixelsOn());
            IO.println(screen.display());
        }
    }
}
