package fr.lbroquet.adventofcode2024.day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ClawMachineTest {
    @Test
    void example() {
        ClawMachine clawMachine = new ClawMachine("Button A: X+94, Y+34", "Button B: X+22, Y+67", "Prize: X=8400, Y=5400");
        assertEquals(280, clawMachine.fewestToken());
    }

    @Test
    void impossible_example() {
        ClawMachine clawMachine = new ClawMachine("Button A: X+26, Y+66", "Button B: X+67, Y+21", "Prize: X=12748, Y=12176");
        assertFalse(clawMachine.winnable());
    }
}