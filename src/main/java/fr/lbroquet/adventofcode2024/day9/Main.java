package fr.lbroquet.adventofcode2024.day9;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        String diskMap = loadDiskMap();
        BlockwiseChecksum blockwiseChecksum = new BlockwiseChecksum(diskMap);
        IO.println("Disk Blockwise Checksum: " + blockwiseChecksum.defragmentedValue());

        WholeFileChecksum wholeFileChecksum = new WholeFileChecksum(diskMap);
        IO.println("Disk Whole File Checksum: " + wholeFileChecksum.defragmentedValue());
    }

    private static String loadDiskMap() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            return reader.readLine();
        }
    }
}
