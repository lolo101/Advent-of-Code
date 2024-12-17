package fr.lbroquet.adventofcode2024.day15;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            char[][] map = warehouse(reader);
            char[] movements = movements(reader);

            Warehouse warehouse = new Warehouse(map);
            warehouse.moveRobot(movements);
            System.out.println("Sum of boxes GPS: " + warehouse.sumOfBoxesGPS());

            WideWarehouse wideWarehouse = new WideWarehouse(map);
            wideWarehouse.show();
            wideWarehouse.moveRobot(movements);
            System.out.println("Sum of wide boxes GPS: " + wideWarehouse.sumOfBoxesGPS());
        }
    }

    private static char[] movements(BufferedReader reader) {
        return reader.lines().reduce("", String::concat).toCharArray();
    }

    private static char[][] warehouse(BufferedReader reader) throws IOException {
        List<char[]> mapRows = new ArrayList<>();
        for (String line; !(line = reader.readLine()).isEmpty(); ) {
            mapRows.add(line.toCharArray());
        }
        return mapRows.toArray(char[][]::new);
    }
}
