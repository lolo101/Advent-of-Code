package fr.lbroquet.adventofcode2023.day2;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    private static final Pattern GAME_PATTERN = Pattern.compile("^Game (?<id>\\d+):(?<subsets>.+)$");
    private static final Pattern COLOR_COUNT_PATTERN = Pattern.compile("^ (?<count>\\d+) (?<color>red|green|blue)$");

    private static final Map<String, Integer> constraints = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );

    public static void main(String[] args) {
        BufferedReader input = Input.load(Main.class);
        long sum = input.lines().map(Main::toGame).filter(game -> game.isPossible(constraints)).mapToLong(Game::id).sum();
        System.out.printf("Sum id IDs of possible games: %d%n", sum);
    }

    private static Game toGame(String line) {
        Matcher matcher = GAME_PATTERN.matcher(line);
        if (matcher.matches()) {
            String id = matcher.group("id");
            String subsets = matcher.group("subsets");
            Collection<CubesSubset> cubesSubsets = toCubesSubsets(subsets);
            return new Game(Long.parseLong(id), cubesSubsets);
        }
        throw new IllegalArgumentException(line);
    }

    private static Collection<CubesSubset> toCubesSubsets(String cubesSubsets) {
        return Stream.of(cubesSubsets.split(";")).map(Main::toCubesSubset).toList();
    }

    private static CubesSubset toCubesSubset(String subset) {
        List<ColorCount> colorCounts = Stream.of(subset.split(",")).map(Main::toColorCount).toList();
        Map<String, Integer> countsByColor = colorCounts.stream().collect(toMap(ColorCount::color, ColorCount::count));
        return new CubesSubset(
                countsByColor.getOrDefault("red", 0),
                countsByColor.getOrDefault("green", 0),
                countsByColor.getOrDefault("blue", 0)
        );
    }

    private static ColorCount toColorCount(String colorCount) {
        Matcher matcher = COLOR_COUNT_PATTERN.matcher(colorCount);
        if (matcher.matches()) {
            String count = matcher.group("count");
            String color = matcher.group("color");
            return new ColorCount(Integer.parseInt(count), color);
        }
        throw new IllegalArgumentException(colorCount);
    }
}