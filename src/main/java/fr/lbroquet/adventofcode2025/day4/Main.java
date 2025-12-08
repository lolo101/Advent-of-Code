package fr.lbroquet.adventofcode2025.day4;

import fr.lbroquet.Input;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        RollsOfPaperMap map = new RollsOfPaperMap(Input.loadMap(Main.class));
        long accessibleRollsOfPaper = map.countAccessibleRollsOfPaper();
        long removedRollsOfPaper = map.countRemovedRollsOfPaper();
        IO.println("Accessible rolls of paper: " + accessibleRollsOfPaper);
        IO.println("Total removed rolls of paper: " + removedRollsOfPaper);
    }
}
