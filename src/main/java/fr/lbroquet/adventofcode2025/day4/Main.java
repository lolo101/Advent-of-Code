package fr.lbroquet.adventofcode2025.day4;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        RollsOfPaperMap map = new RollsOfPaperMap(Input.loadMap(Main.class));
        long accessibleRollsOfPaper = map.countAccessibleRollsOfPaper();
        System.out.println("Accessible rolls of paper: " + accessibleRollsOfPaper);
    }
}
