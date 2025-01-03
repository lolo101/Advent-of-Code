package fr.lbroquet.adventofcode2024.day11;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Map<Integer, Long>> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            Collection<String> stones = Arrays.asList(reader.readLine().split(" "));
            long count = stones.stream().mapToLong(stone -> blink(stone, 25)).sum();
            System.out.println("Stones after 25 blinks: " + count);
            long longCount = stones.stream().mapToLong(stone -> blink(stone, 75)).sum();
            System.out.println("Stones after 75 blinks: " + longCount);
        }
    }

    private static long blink(String stone, int time) {
        Map<Integer, Long> secondLevelCache = cache.computeIfAbsent(stone, _ -> new HashMap<>());
        if (secondLevelCache.containsKey(time)) {
            return secondLevelCache.get(time);
        }
        long value = doBlink(stone, time);
        secondLevelCache.put(time, value);
        return value;
    }

    private static long doBlink(String stone, int time) {
        if (time == 0) return 1;
        if (stone.equals("0")) return blink("1", time - 1);
        if ((stone.length() % 2) == 0)
            return blink(engraveNumber(stone.substring(0, stone.length() / 2)), time - 1)
                    + blink(engraveNumber(stone.substring(stone.length() / 2)), time - 1);
        return blink(String.valueOf(Long.parseLong(stone) * 2024), time - 1);
    }

    private static String engraveNumber(String number) {
        return Long.valueOf(number).toString();
    }
}
