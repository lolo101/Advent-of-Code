package fr.lbroquet.adventofcode2016.day9;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            String compressed = reader.readLine();
            IO.println("Compressed length = " + compressed.length());

            IO.println("Decompressed length = " + Decompressor.decompress(compressed));

            IO.println("Decompressed v2 length = " + Decompressor.decompress_v2(compressed));
        }
    }
}
