package fr.lbroquet.adventofcode2024.day11;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            Collection<String> stones = Arrays.asList(reader.readLine().split(" "));
            for (int i = 0; i < 25; i++) {
                stones = blink(stones);
            }
            System.out.println("Stones after 25 blinks: " + stones.size());
        }
    }

    public static Collection<String> blink(Iterable<String> before) {
        Collection<String> after = new ArrayList<>();
        for (String stone : before) {
            if (stone.equals("0")) {
                after.add("1");
            } else if ((stone.length() % 2) == 0) {
                after.add(engraveNumber(stone.substring(0, stone.length() / 2)));
                after.add(engraveNumber(stone.substring(stone.length() / 2)));
            } else {
                after.add(String.valueOf(Long.parseLong(stone) * 2024));
            }
        }
        return after;
    }

    private static String engraveNumber(String number) {
        return Long.valueOf(number).toString();
    }
}
