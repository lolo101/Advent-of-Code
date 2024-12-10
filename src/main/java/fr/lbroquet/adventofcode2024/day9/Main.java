package fr.lbroquet.adventofcode2024.day9;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String diskMap = loadDiskMap();
        Checksum checksum = new Checksum(diskMap);
        System.out.println("Disk checksum: " + checksum.defragmentedValue());
    }

    private static String loadDiskMap() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            return reader.readLine();
        }
    }
}
