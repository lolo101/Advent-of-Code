package fr.lbroquet.adventofcode2024.day15;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            Warehouse warehouse = warehouse(reader);
            char[] movements = movements(reader);
            warehouse.moveRobot(movements);
            System.out.println("Sum of boxes GPS: " + warehouse.sumOfBoxesGPS());
        }
    }

    private static char[] movements(BufferedReader reader) {
        return reader.lines().reduce("", String::concat).toCharArray();
    }

    private static Warehouse warehouse(BufferedReader reader) throws IOException {
        List<char[]> mapRows = new ArrayList<>();
        for (String line; !(line = reader.readLine()).isEmpty(); ) {
            mapRows.add(line.toCharArray());
        }
        return new Warehouse(mapRows.toArray(char[][]::new));
    }
}
