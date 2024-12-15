package fr.lbroquet.adventofcode2024.day13;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws IOException {
        Collection<ClawMachine> clawMachines = new ArrayList<>();
        try (BufferedReader reader = Input.load(Main.class)) {
            do {
                String buttonA = reader.readLine();
                String buttonB = reader.readLine();
                String prize = reader.readLine();
                clawMachines.add(new ClawMachine(buttonA, buttonB, prize));
            } while (reader.readLine() != null);
        }
        System.out.println("Fewest tokens to spend: " + clawMachines.stream().filter(ClawMachine::winnable).mapToLong(ClawMachine::fewestToken).sum());
    }
}
