package fr.lbroquet.adventofcode2022.day10;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            CPU cpu = reader
                    .lines()
                    .map(Instruction::of)
                    .reduce(
                            new CPU(),
                            CPU::execute,
                            ((cpu1, _) -> cpu1)
                    );
            IO.println(cpu.signalStrengths().stream().reduce(0, Integer::sum));
            CRT crt = new CRT(cpu);
            IO.println(crt.print());
        }
    }
}
