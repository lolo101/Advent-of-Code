package fr.lbroquet.adventofcode2023.day17;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        char[][] mapArray = Input.loadMap(Main.class);
        HeatMap heatMap = new HeatMap(mapArray);
        System.out.printf("Least heat loss: %d%n", heatMap.leastHeatLoss(new Position(140, 140)));
        System.out.println(heatMap.drawMap());
    }
}
