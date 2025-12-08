package fr.lbroquet.adventofcode2016.day3;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            IO.println("Nb of possible triangles: " + reader.lines().map(Triangle::new).filter(Triangle::isPossible).count());
        }
        try (BufferedReader reader = Input.load(Main.class)) {
            int possible = 0;
            for (String line1, line2, line3; (line1 = reader.readLine()) != null;) {
                line2 = reader.readLine();
                line3 = reader.readLine();
                TriTriangle triTriangle = new TriTriangle(line1 + line2 + line3);
                possible += triTriangle.countPossibles();
            }
            IO.println("Nb of possile triangles with vertical coords: " + possible);
        }
    }
}
